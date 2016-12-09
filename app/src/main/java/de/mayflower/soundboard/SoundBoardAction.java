
    package de.mayflower.soundboard;

    import  android.app.Activity;
    import  android.content.Intent;
    import  android.speech.RecognizerIntent;
    import  de.mayflower.lib.Lib;
    import  de.mayflower.lib.LibLauncher;
    import  de.mayflower.lib.LibResource;
    import de.mayflower.soundboard.ui.SoundBoardDialogAbout;
    import  de.mayflower.soundboard.state.SoundBoardRecorder;
    import  de.mayflower.soundboard.state.SoundBoardSettings;
    import  de.mayflower.soundboard.state.SoundBoardTabbedPane;
    import  de.mayflower.soundboard.state.SoundBoardViewPager;
    import  de.mayflower.soundboard.state.SoundBoardWelcome;

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
            /** A no op event that does nothing for everybody. */
            NOTHING,

            /** Shows the 'recorder' activity. */
            ENTER_ACTIVITY_RECORDER,

            /** Shows the 'viewpager' activity. */
            ENTER_ACTIVITY_VIEWPAGER,

            /** Shows the 'tabbedpane' activity. */
            ENTER_ACTIVITY_TABBEDPANE,

            /** Shows the 'settings' activity. */
            ENTER_ACTIVITY_SETTINGS,

            /** Changes back to the 'welcome' activity. */
            RETURN_TO_ACTIVITY_WELCOME,

            /** Eclipses the app and shows the android homescreen. */
            SHOW_HOMESCREEN,

            /** Shows the 'voice input' dialog. */
            SHOW_DIALOG_VOICE_INPUT,

            /** Shows the 'about' dialog. */
            SHOW_DIALOG_ABOUT,

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

        @SuppressWarnings("OverlyLongMethod")
        @Override
        public void run()
        {
            switch( this.event  )
            {
                case NOTHING:
                {
                    break;
                }

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

                case ENTER_ACTIVITY_TABBEDPANE:
                {
                    LibLauncher.launchActivity
                    (
                        this.activity,
                        SoundBoardTabbedPane.class,
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

                case SHOW_DIALOG_VOICE_INPUT:
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

                case SHOW_DIALOG_ABOUT:
                {
                    SoundBoardDebug.major.out( "Show the about dialog.." );

                    Runnable actionOnClose = new SoundBoardAction
                    (
                        SoundBoardAction.Event.NOTHING,
                        this.activity
                    );

                    String body =
                    (
                            LibResource.getResourceString( this.activity, R.string.app_name )
                        +   ", v."
                        +   SoundBoardVersion.getCurrentVersionId()
                        +   "<br>"
                        +   LibResource.getResourceString( this.activity, R.string.copyright )
                    );
/*
                    LibDialogDefault.show
                    (
                        this.activity,
                        R.string.dialog_about_title,
                        body,
                        R.string.dialog_about_button_ok,
                        actionOnClose,
                        0,
                        null,
                        true,
                        actionOnClose
                    );
*/
                    SoundBoardDialogAbout.show
                    (
                        this.activity,
                        R.layout.dialog_about,
                        R.string.dialog_about_title,
                        body,
                        R.string.dialog_about_button_ok,
                        actionOnClose,
                        true,
                        actionOnClose
                    );
                    break;
                }
            }
        }
    }
