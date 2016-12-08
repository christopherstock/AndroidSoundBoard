
    package de.mayflower.soundboard.state.activity;

    import  android.os.Bundle;
    import  android.support.v7.app.ActionBar;
    import  android.support.v7.app.AppCompatActivity;
    import  android.view.*;
    import  de.mayflower.soundboard.R;
    import  de.mayflower.soundboard.SoundBoardAction;

    /***********************************************************************************************
    *   The parent class for all activities. Has a mechanism to directly assign the backKey event.
    *
    *   @author     Christopher Stock
    *   @version    1.0
     **********************************************************************************************/
    public abstract class SoundBoardActivity extends AppCompatActivity
    {
        /** The event to launch when the backKey is pressed. */
        private             SoundBoardAction.Event      backKeyEvent                    = null;

        /** Specifies if the back button should be shown in the title bar. */
        private             boolean                     showBackButtonInActionBar       = false;

        /** Specifies if the menu button should be shown in the title bar. */
        private             boolean                     showMenuButtonInActionBar       = false;

        /*******************************************************************************************
        *   Creates a new Activity with an assignable backKey.
        *******************************************************************************************/
        protected SoundBoardActivity
        (
            SoundBoardAction.Event backKeyEvent,
            boolean                showBackButtonInActionBar,
            boolean                showMenuButtonInActionBar
        )
        {
            this.backKeyEvent              = backKeyEvent;
            this.showBackButtonInActionBar = showBackButtonInActionBar;
            this.showMenuButtonInActionBar = showMenuButtonInActionBar;
        }

        /*******************************************************************************************
        *   Being invoked when the application starts and resumes.
        *
        *   @param savedInstanceState The data bundle being passed if any.
        *******************************************************************************************/
        @Override
        protected void onCreate(Bundle savedInstanceState)
        {
            super.onCreate( savedInstanceState );

            this.initActionBar();
        }

        /*******************************************************************************************
         *   Initializes the buttons for the action bar.
         *******************************************************************************************/
        private void initActionBar()
        {
            ActionBar ab = this.getSupportActionBar();

            if ( this.showBackButtonInActionBar && ( ab != null ) )
            {
                ab.setDisplayShowHomeEnabled( true );
                ab.setDisplayHomeAsUpEnabled( true );
            }
        }

        @Override
        public boolean onKeyDown( int keyCode, KeyEvent event )
        {
            switch ( keyCode )
            {
                case KeyEvent.KEYCODE_BACK:
                {
                    new SoundBoardAction( this.backKeyEvent, this ).run();

                    //prevent system from handling this event
                    return true;
                }
            }

            return super.onKeyDown( keyCode, event );
        }

        @Override
        public boolean onCreateOptionsMenu( Menu menu )
        {
            if ( this.showMenuButtonInActionBar )
            {
                MenuInflater inflater = this.getMenuInflater();
                inflater.inflate( R.menu.menu_default, menu );

                return true;
            }

            return false;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item)
        {
            int id = item.getItemId();

            switch ( id )
            {
                case android.R.id.home:
                {
                    new SoundBoardAction(this.backKeyEvent, this).run();

                    //prevent system from handling this event
                    return true;
                }

                case R.id.menu_settings:
                {
                    new SoundBoardAction(SoundBoardAction.Event.ENTER_ACTIVITY_SETTINGS, this).run();

                    //prevent system from handling this event
                    return true;
                }

                case R.id.menu_about:
                {
                    new SoundBoardAction(SoundBoardAction.Event.SHOW_DIALOG_ABOUT, this).run();

                    //prevent system from handling this event
                    return true;
                }
            }

            return super.onOptionsItemSelected(item);
        }
    }
