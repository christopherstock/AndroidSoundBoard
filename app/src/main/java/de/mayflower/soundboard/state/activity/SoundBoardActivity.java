
    package de.mayflower.soundboard.state.activity;

    import  android.os.Bundle;
    import  android.support.v7.app.ActionBar;
    import  android.support.v7.app.AppCompatActivity;
    import  android.support.v7.view.menu.ActionMenuItemView;
    import  android.view.*;
    import  de.mayflower.soundboard.R;
    import  de.mayflower.soundboard.SoundBoardAction;

    /*******************************************************************************************************************
    *   The parent class for all activities. Has a mechanism to directly assign the backKey event.
    *
    *   @author     Christopher Stock
    *   @version    0.0.1
    *******************************************************************************************************************/
    public abstract class SoundBoardActivity extends AppCompatActivity
    {
        /***************************************************************************************************************
        *   Specifies if the 'back softkey' shall be displayed in the title bar.
        ***************************************************************************************************************/
        public static enum ShowBackButton
        {
            /** Do show the back button. */
            YES,

            /** Do not show the back button. */
            NO,

            ;
        }

        /***************************************************************************************************************
        *   Specifies if the 'menu' key shall be supported in this activity.
        ***************************************************************************************************************/
        public static enum ShowMenuButton
        {
            /** Do show the menu button. */
            YES,

            /** Do not show the menu button. */
            NO,

            ;
        }

        /** The event to launch when the backKey is pressed. */
        private             SoundBoardAction.Event              backKeyEvent                = null;

        /** Specifies if the back button should be shown in the title bar. */
        private             SoundBoardActivity.ShowBackButton   showBackButtonInActionBar   = null;

        /** Specifies if the menu button should be shown in the title bar. */
        private             SoundBoardActivity.ShowMenuButton   showMenuButtonInActionBar   = null;

        /***************************************************************************************************************
        *   Creates a new Activity with an assignable backKey.
        *
        *   @param  backKeyEvent                The event to invoke when the back key is pressed.
        *   @param  showBackButtonInActionBar   Determines if the 'back' button should be displayed
        *                                       in this activitie's title bar.
        *   @param  showMenuButtonInActionBar   Determines if this activity supports the menu button.
        ***************************************************************************************************************/
        protected SoundBoardActivity
        (
            SoundBoardAction.Event            backKeyEvent,
            SoundBoardActivity.ShowBackButton showBackButtonInActionBar,
            SoundBoardActivity.ShowMenuButton showMenuButtonInActionBar
        )
        {
            this.backKeyEvent              = backKeyEvent;
            this.showBackButtonInActionBar = showBackButtonInActionBar;
            this.showMenuButtonInActionBar = showMenuButtonInActionBar;
        }

        /***************************************************************************************************************
        *   Being invoked when the application starts and resumes.
        *
        *   @param savedInstanceState The data bundle being passed if any.
        ***************************************************************************************************************/
        @Override
        protected void onCreate(Bundle savedInstanceState)
        {
            super.onCreate( savedInstanceState );

            this.initActionBar();
        }

        /***************************************************************************************************************
         *   Initializes the buttons for the action bar.
         **************************************************************************************************************/
        private void initActionBar()
        {
            ActionBar ab = this.getSupportActionBar();

            if
            (
                    ( this.showBackButtonInActionBar == SoundBoardActivity.ShowBackButton.YES )
                &&  ( ab != null )
            )
            {
                ab.setDisplayShowHomeEnabled( true );
                ab.setDisplayHomeAsUpEnabled( true );
            }
        }

        @Override
        public boolean onKeyUp( int keyCode, KeyEvent event )
        {
            switch ( keyCode )
            {
                case KeyEvent.KEYCODE_BACK:
                {
                    new SoundBoardAction( this.backKeyEvent, this ).run();

                    //prevent system from handling this event
                    return true;
                }

                case KeyEvent.KEYCODE_MENU:
                {
                    if ( this.showMenuButtonInActionBar == SoundBoardActivity.ShowMenuButton.YES )
                    {
                        //reference the menu button and propagate a click on it
                        ActionMenuItemView menuButton = (ActionMenuItemView)this.findViewById( R.id.menu_button );
                        menuButton.performClick();

                        //prevent system from handling this event
                        return true;
                    }
                }
            }

            return super.onKeyDown( keyCode, event );
        }

        @Override
        public boolean onCreateOptionsMenu( Menu menu )
        {
            if ( this.showMenuButtonInActionBar == SoundBoardActivity.ShowMenuButton.YES )
            {
                MenuInflater inflater = this.getMenuInflater();
                inflater.inflate( R.menu.menu_default, menu );

                return true;
            }

            return false;
        }

        @Override
        public boolean onOptionsItemSelected( MenuItem item )
        {
            int id = item.getItemId();

            switch ( id )
            {
                case android.R.id.home:
                {
                    new SoundBoardAction( this.backKeyEvent, this ).run();

                    //prevent system from handling this event
                    return true;
                }

                case R.id.menu_settings:
                {
                    new SoundBoardAction( SoundBoardAction.Event.ENTER_ACTIVITY_SETTINGS, this ).run();

                    //prevent system from handling this event
                    return true;
                }

                case R.id.menu_about:
                {
                    new SoundBoardAction( SoundBoardAction.Event.SHOW_DIALOG_ABOUT, this ).run();

                    //prevent system from handling this event
                    return true;
                }

                case R.id.menu_help:
                {
                    new SoundBoardAction( SoundBoardAction.Event.ENTER_ACTIVITY_HELP, this ).run();

                    //prevent system from handling this event
                    return true;
                }
            }

            return super.onOptionsItemSelected(item);
        }
    }
