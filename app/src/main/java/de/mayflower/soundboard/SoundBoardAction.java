
    package de.mayflower.soundboard;

    import  android.app.Activity;
    import  android.content.Intent;
    import  android.speech.RecognizerIntent;
    import  de.mayflower.lib.Lib;
    import  de.mayflower.lib.LibLauncher;
    import  de.mayflower.soundboard.state.SoundBoardMainScreen;
    import  de.mayflower.soundboard.state.SoundBoardTestScreen;
    import  de.mayflower.soundboard.state.SoundBoardWelcomeScreen;

    /*****************************************************************************
    *   The action system.
    *
    *   @author     Christopher Stock
    *   @version    1.0
    *****************************************************************************/
    public class SoundBoardAction implements Runnable
    {
        /*****************************************************************************
        *   All actions being performed accross the app.
        *
        *   @author     Christopher Stock
        *   @version    1.0
        *****************************************************************************/
        public enum Event
        {
            /**
             * Shows the test activity.
             */
            SHOW_TEST_ACTIVITY,

            /**
             * Shows the welcome activity from the test state.
             */
            SHOW_WELCOME_ACTIVITY_FROM_TEST_ACTIVITY,

            /**
             * Shows the welcome activity from the main state.
             */
            SHOW_WELCOME_ACTIVITY_FROM_MAIN_ACTIVITY,

            /**
             * Shows the main-screen activity.
             */
            SHOW_MAIN_SCREEN_ACTIVITY,

            /**
             * Eclipses the app and shows the android homescreen.
             */
            SHOW_HOMESCREEN,

            /**
             * Show the 'voice input' dialog.
             */
            SHOW_VOICE_INPUT_DIALOG,;
        }

        /** The event for this action to perform. */
        private         Event           event               = null;

        /** The activity that invoked this action. */
        private         Activity        activity            = null;

        /*****************************************************************************
        *   Launched a new action.
        *
        *   @param  event
        *****************************************************************************/
        public SoundBoardAction( Event event, Activity activity )
        {
            this.event    = event;
            this.activity = activity;
        }

        @Override
        public void run()
        {
            switch( this.event  )
            {
                case SHOW_TEST_ACTIVITY:
                {
                    LibLauncher.launchActivity
                    (
                        this.activity,
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
                        this.activity,
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
                        this.activity,
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
                        this.activity,
                        SoundBoardMainScreen.class,
                        R.anim.push_left_in,
                        R.anim.push_left_out
                    );
                    break;
                }

                case SHOW_HOMESCREEN:
                {
                    Lib.showHomescreenActivity( this.activity );
                    break;
                }

                case SHOW_VOICE_INPUT_DIALOG:
                {
                    SoundBoardDebug.major.out( "Show the voice input dialog.." );

                    Intent intent = new Intent( RecognizerIntent.ACTION_RECOGNIZE_SPEECH );
                    intent.putExtra( RecognizerIntent.EXTRA_LANGUAGE_MODEL, "de-DE" );
                    this.activity.startActivityForResult(
                        intent,
                        SoundBoardTestScreen.REQUEST_CODE_RECORD_AUDIO
                    );
                    break;
                }
            }
        }
    }
