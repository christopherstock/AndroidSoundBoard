
    package de.mayflower.soundboard;

    import  android.app.Activity;
    import  android.content.Intent;
    import  android.speech.RecognizerIntent;
    import  de.mayflower.lib.Lib;
    import  de.mayflower.lib.LibLauncher;
    import de.mayflower.soundboard.state.SoundBoardMain;
    import de.mayflower.soundboard.state.SoundBoardTest;
    import de.mayflower.soundboard.state.SoundBoardWelcome;

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
            ENTER_TEST_ACTIVITY,


            /**
             * Shows the main-screen activity.
             */
            ENTER_MAIN_SCREEN_ACTIVITY,

            /**
             * Shows the welcome activity from the test state.
             */
            RETURN_TO_WELCOME_ACTIVITY,

            /**
             * Eclipses the app and shows the android homescreen.
             */
            SHOW_HOMESCREEN,

            /**
             * Show the 'voice input' dialog.
             */
            SHOW_VOICE_INPUT_DIALOG,

            ;
        }

        /** The event for this action to perform. */
        private         Event           event               = null;

        /** The activity that invoked this action. */
        private         Activity        activity            = null;

        /*****************************************************************************
        *   Launched a new action.
        *
        *   @param  event    The ID of the event to launch.
        *   @param  activity The activity that launched this action.
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
                case ENTER_TEST_ACTIVITY:
                {
                    LibLauncher.launchActivity
                    (
                        this.activity,
                        SoundBoardTest.class,
                        R.anim.push_left_in,
                        R.anim.push_left_out
                    );
                    break;
                }

                case ENTER_MAIN_SCREEN_ACTIVITY:
                {
                    LibLauncher.launchActivity
                    (
                        this.activity,
                        SoundBoardMain.class,
                        R.anim.push_left_in,
                        R.anim.push_left_out
                    );
                    break;
                }

                case RETURN_TO_WELCOME_ACTIVITY:
                {
                    LibLauncher.launchActivity
                    (
                            this.activity,
                            SoundBoardWelcome.class,
                            R.anim.push_right_in,
                            R.anim.push_right_out
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
                        SoundBoardTest.REQUEST_CODE_RECORD_AUDIO
                    );
                    break;
                }
            }
        }
    }
