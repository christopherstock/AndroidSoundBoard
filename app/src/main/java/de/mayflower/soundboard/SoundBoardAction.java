
    package de.mayflower.soundboard;

    import  android.util.Log;
    import  de.mayflower.lib.LibLauncher;
    import  de.mayflower.soundboard.state.SoundBoardTestScreen;
    import  de.mayflower.soundboard.state.SoundBoardWelcomeScreen;

    /*****************************************************************************
    *   All actions being performed accross the app.
    *
    *   @author     Christopher Stock
    *   @version    1.0
    *****************************************************************************/
    public enum SoundBoardAction implements Runnable
    {
        /** Shows the test activity. */
        SHOW_TEST_ACTIVITY,

        /** Shows the welcome activity. */
        SHOW_WELCOME_ACTIVITY,

        ;

        @Override
        public void run()
        {
            switch( this  )
            {
                case SHOW_TEST_ACTIVITY:
                {
                    Log.i("Test", "Button Welcome pressed!");

                    LibLauncher.launchActivity
                    (
                        SoundBoardWelcomeScreen.singleton,
                        SoundBoardTestScreen.class,
                        R.anim.push_left_in,
                        R.anim.push_left_out
                    );
                    break;
                }

                case SHOW_WELCOME_ACTIVITY:
                {
                    Log.i("Test", "Button Test pressed!");

                    LibLauncher.launchActivity
                    (
                        SoundBoardTestScreen.singleton,
                        SoundBoardWelcomeScreen.class,
                        R.anim.push_right_in,
                        R.anim.push_right_out
                    );
                    break;
                }



            }
        }
    }
