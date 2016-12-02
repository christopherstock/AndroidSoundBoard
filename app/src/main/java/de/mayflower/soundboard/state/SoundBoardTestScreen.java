
    package de.mayflower.soundboard.state;

    import  android.app.Activity;
    import  android.os.Bundle;
    import  android.support.v7.app.AppCompatActivity;
    import android.view.KeyEvent;

    import  de.mayflower.lib.ui.LibUI;
    import  de.mayflower.soundboard.R;
    import  de.mayflower.soundboard.SoundBoardAction;

    /*******************************************************************************************
    *   The test activity.
    *
    *   @author     Christopher Stock
    *   @version    1.0
    *******************************************************************************************/
    public class SoundBoardTestScreen extends AppCompatActivity
    {
        /** The singleton instance. */
        public      static          Activity            singleton           = null;

        /*******************************************************************************************
        *   Being invoked when the application starts and resumes.
        *
        *   @param savedInstanceState The data bundle being passed if any.
        *******************************************************************************************/
        @Override
        protected void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);

            singleton = this;

            this.setContentView(R.layout.activity_sound_board_test_screen);

            LibUI.setupButton
            (
                this,
                R.id.button_test,
                R.string.button_test,
                SoundBoardAction.SHOW_WELCOME_ACTIVITY_FROM_TEST_ACTIVITY
            );
        }

        @Override
        public boolean onKeyDown( int keyCode, KeyEvent event )
        {
            switch ( keyCode )
            {
                case KeyEvent.KEYCODE_BACK:
                {
                    SoundBoardAction.SHOW_WELCOME_ACTIVITY_FROM_TEST_ACTIVITY.run();

                    //prevent this event from being propagated further
                    return true;
                }
            }

            //let the system handle this event
            return false;
        }
    }
