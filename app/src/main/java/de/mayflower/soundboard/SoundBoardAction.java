
    package de.mayflower.soundboard;

    import  android.content.Intent;
    import  android.speech.RecognizerIntent;
    import  de.mayflower.lib.Lib;
    import  de.mayflower.lib.LibLauncher;
    import  de.mayflower.soundboard.state.SoundBoardMainScreen;
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

        /** Shows the welcome activity from the test state. */
        SHOW_WELCOME_ACTIVITY_FROM_TEST_ACTIVITY,

        /** Shows the welcome activity from the main state. */
        SHOW_WELCOME_ACTIVITY_FROM_MAIN_ACTIVITY,

        /** Shows the main-screen activity. */
        SHOW_MAIN_SCREEN_ACTIVITY,

        /** Eclipses the app and shows the android homescreen. */
        SHOW_HOMESCREEN,

        /** Show the 'voice input' dialog. */
        SHOW_VOICE_INPUT_DIALOG,

        ;

        @Override
        public void run()
        {
            switch( this  )
            {
                case SHOW_TEST_ACTIVITY:
                {
                    LibLauncher.launchActivity
                    (
                        SoundBoardWelcomeScreen.singleton,
                        SoundBoardTestScreen.class,
                        R.anim.push_left_in,
                        R.anim.push_left_out
                    );
                    break;
                }

                case SHOW_WELCOME_ACTIVITY_FROM_TEST_ACTIVITY:
                {
                    LibLauncher.launchActivity
                    (
                        SoundBoardTestScreen.singleton,
                        SoundBoardWelcomeScreen.class,
                        R.anim.push_right_in,
                        R.anim.push_right_out
                    );
                    break;
                }

                case SHOW_WELCOME_ACTIVITY_FROM_MAIN_ACTIVITY:
                {
                    LibLauncher.launchActivity
                    (
                        SoundBoardMainScreen.singleton,
                        SoundBoardWelcomeScreen.class,
                        R.anim.push_right_in,
                        R.anim.push_right_out
                    );
                    break;
                }

                case SHOW_MAIN_SCREEN_ACTIVITY:
                {
                    LibLauncher.launchActivity
                    (
                        SoundBoardWelcomeScreen.singleton,
                        SoundBoardMainScreen.class,
                        R.anim.push_left_in,
                        R.anim.push_left_out
                    );
                    break;
                }

                case SHOW_HOMESCREEN:
                {
                    Lib.showHomescreenActivity( SoundBoardWelcomeScreen.singleton );
                    break;
                }

                case SHOW_VOICE_INPUT_DIALOG:
                {
                    SoundBoardDebug.major.out( "Show the voice input dialog.." );

                    Intent intent = new Intent( RecognizerIntent.ACTION_RECOGNIZE_SPEECH );
                    intent.putExtra( RecognizerIntent.EXTRA_LANGUAGE_MODEL, "de-DE" );
                    SoundBoardTestScreen.singleton.startActivityForResult(
                        intent,
                        SoundBoardTestScreen.REQUEST_CODE_RECORD_AUDIO
                    );
                    break;
                }
            }
        }
    }
