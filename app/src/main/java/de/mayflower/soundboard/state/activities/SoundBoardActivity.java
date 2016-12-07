
    package de.mayflower.soundboard.state.activities;

    import  android.os.Bundle;
    import  android.support.v7.app.ActionBar;
    import  android.support.v7.app.AppCompatActivity;
    import  android.view.KeyEvent;
    import  android.view.MenuItem;
    import  de.mayflower.soundboard.SoundBoardAction;

    /***********************************************************************************************
    *   The parent class for all activities. Has a mechanism to directly assign the backKey event.
    *
    *   @author     Christopher Stock
    *   @version    1.0
     **********************************************************************************************/
    public abstract class SoundBoardActivity extends AppCompatActivity
    {
        /*******************************************************************************************
        *   The event to launch when the backKey is pressed.
        *******************************************************************************************/
        private             SoundBoardAction.Event      backKeyEvent                    = null;

        /*******************************************************************************************
        *   Specifies if the back button should be shown in the action bar.
        *******************************************************************************************/
        private             boolean                     showBackButtonInActionBar       = false;

        /*******************************************************************************************
        *   Creates a new Activity with an assignable backKey.
        *******************************************************************************************/
        protected SoundBoardActivity
        (
            SoundBoardAction.Event backKeyEvent,
            boolean                showBackButtonInActionBar
        )
        {
            this.backKeyEvent              = backKeyEvent;
            this.showBackButtonInActionBar = showBackButtonInActionBar;
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
        public boolean onOptionsItemSelected(MenuItem item)
        {
            int id = item.getItemId();

            if ( id == android.R.id.home )
            {
                new SoundBoardAction( this.backKeyEvent, this ).run();

                //prevent system from handling this event
                return true;
            }

            return super.onOptionsItemSelected(item);
        }
    }
