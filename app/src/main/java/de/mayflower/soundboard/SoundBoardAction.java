
    package de.mayflower.soundboard;

    import  android.app.Activity;
    import  android.content.Intent;
    import  android.speech.RecognizerIntent;
    import  de.mayflower.lib.Lib;
    import  de.mayflower.lib.LibLauncher;
    import  de.mayflower.soundboard.state.*;
    import  de.mayflower.soundboard.state.SoundBoardSettings;

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
            /** Shows the test activity. */
            ENTER_ACTIVITY_RECORDER,

            /** Shows the main-screen activity. */
            ENTER_ACTIVITY_VIEWPAGER,

            /** Shows the settings activity */
            ENTER_ACTIVITY_SETTINGS,

            /** Shows the welcome activity from the test state. */
            RETURN_TO_ACTIVITY_WELCOME,

            /** Eclipses the app and shows the android homescreen. */
            SHOW_HOMESCREEN,

            /** Show the 'voice input' dialog. */
            SHOW_VOICE_INPUT_DIALOG,

            ;
        }

        /** The event for this action to perform. */
        private         SoundBoardAction.Event      event               = null;

        /** The activity that invoked this action. */
        private         Activity                    activity            = null;

        /*****************************************************************************
        *   Launched a new action.
        *
        *   @param  event    The ID of the event to launch.
        *   @param  activity The activity that launched this action.
        *****************************************************************************/
        public SoundBoardAction( SoundBoardAction.Event event, Activity activity )
        {
            this.event    = event;
            this.activity = activity;
        }

        @Override
        public void run()
        {
            switch( this.event  )
            {
                case ENTER_ACTIVITY_RECORDER:
                {
                    LibLauncher.launchActivity
                    (
                        this.activity,
                        SoundBoardRecorder.class,
                        R.anim.push_left_in,
                        R.anim.push_left_out
                    );
                    break;
                }

                case ENTER_ACTIVITY_VIEWPAGER:
                {
                    LibLauncher.launchActivity
                    (
                        this.activity,
                        SoundBoardViewPager.class,
                        R.anim.push_left_in,
                        R.anim.push_left_out
                    );
                    break;
                }

                case ENTER_ACTIVITY_SETTINGS:
                {
                    LibLauncher.launchActivity
                    (
                        this.activity,
                        SoundBoardSettings.class,
                        R.anim.push_left_in,
                        R.anim.push_left_out
                    );
                    break;
                }

                case RETURN_TO_ACTIVITY_WELCOME:
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

                    intent.putExtra( RecognizerIntent.EXTRA_LANGUAGE,       "de-DE" );
                    intent.putExtra( RecognizerIntent.EXTRA_LANGUAGE_MODEL, "de-DE" );

                    this.activity.startActivityForResult(
                        intent,
                        SoundBoardRecorder.REQUEST_CODE_RECORD_AUDIO
                    );
                    break;
                }
            }
        }
    }
