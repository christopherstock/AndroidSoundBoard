
    package de.mayflower.soundboard.state.activities;

    import  android.support.v7.app.AppCompatActivity;
    import  android.view.KeyEvent;
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
        private             SoundBoardAction.Event              backKeyEvent                = null;

        /*******************************************************************************************
        *   Creates a new Activity with an assignable backKey.
        *******************************************************************************************/
        protected SoundBoardActivity( SoundBoardAction.Event backKeyEvent )
        {
            this.backKeyEvent = backKeyEvent;
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

            //let system handle this event
            return false;
        }
    }
