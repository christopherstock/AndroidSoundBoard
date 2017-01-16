
    package de.mayflower.soundboard;

    import  android.app.Activity;
    import  de.mayflower.lib.Lib;
    import  de.mayflower.lib.LibLauncher;
    import  de.mayflower.lib.LibResource;
    import  de.mayflower.lib.io.LibSound;
    import  de.mayflower.soundboard.service.SoundBoardBgListener;
    import  de.mayflower.soundboard.state.SoundBoardHelp;
    import  de.mayflower.soundboard.ui.SoundBoardDialogAbout;
    import  de.mayflower.soundboard.state.SoundBoardSettings;
    import  de.mayflower.soundboard.state.SoundBoardTabbedPane;
    import  de.mayflower.soundboard.state.SoundBoardViewPager;
    import  de.mayflower.soundboard.state.SoundBoardWelcome;

    /*******************************************************************************************************************
    *   The action system.
    *
    *   @author     Christopher Stock
    *   @version    1.0.0
    *******************************************************************************************************************/
    public class SoundBoardAction implements Runnable
    {
        /***************************************************************************************************************
        *   All actions being performed accross the app.
        *
        *   @author     Christopher Stock
        *   @version    1.0.0
        ***************************************************************************************************************/
        public enum Event
        {
            /** A no op event that does nothing for everybody. */
            NOTHING,

            /** Shows the 'viewpager' activity. */
            ENTER_ACTIVITY_VIEWPAGER,

            /** Shows the 'tabbedpane' activity. */
            ENTER_ACTIVITY_TABBEDPANE,

            /** Shows the 'settings' activity. */
            ENTER_ACTIVITY_SETTINGS,

            /** Shows the 'help' activity. */
            ENTER_ACTIVITY_HELP,

            /** Changes back to the 'welcome' activity. */
            RETURN_TO_ACTIVITY_WELCOME,

            /** Eclipses the app and shows the android homescreen. */
            SHOW_HOMESCREEN,

            /** Shows the 'about' dialog. */
            SHOW_DIALOG_ABOUT,

            /** Starts the background speech listener service. */
            TEST_START_BG_SERVICE,

            /** Stopd the background speech listener service. */
            TEST_STOP_BG_SERVICE,

            /** Plays 1st sound fx. */
            PLAY_SOUND_1,

            /** Plays 2nd sound fx. */
            PLAY_SOUND_2,

            /** Plays 3rd sound fx. */
            PLAY_SOUND_3,

            ;
        }

        /** The event for this action to perform. */
        private         SoundBoardAction.Event      event               = null;

        /** The activity that invoked this action. */
        private         Activity                    activity            = null;

        /***************************************************************************************************************
        *   Launched a new action.
        *
        *   @param  event    The ID of the event to launch.
        *   @param  activity The activity that launched this action.
        ***************************************************************************************************************/
        public SoundBoardAction( SoundBoardAction.Event event, Activity activity )
        {
            this.event    = event;
            this.activity = activity;
        }

        @SuppressWarnings( { "OverlyLongMethod", "OverlyComplexMethod" } )
        @Override
        public void run()
        {
            switch( this.event  )
            {
                case NOTHING:
                {
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

                case ENTER_ACTIVITY_HELP:
                {
                    LibLauncher.launchActivity
                    (
                        this.activity,
                        SoundBoardHelp.class,
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

                case SHOW_DIALOG_ABOUT:
                {
                    Runnable actionOnClose = new SoundBoardAction( SoundBoardAction.Event.NOTHING, this.activity );

                    String body =
                    (
                            LibResource.getResourceString( this.activity, R.string.app_name )
                        +   ", v."
                        +   SoundBoardVersion.getCurrentVersionId()
                        +   "<br>"
                        +   LibResource.getResourceString( this.activity, R.string.copyright )
                    );

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

                case TEST_START_BG_SERVICE:
                {
                    SoundBoardDebug.major.out( "START the bg 'Speech Listener' service .." );

                    //noinspection CastToConcreteClass
                    ((SoundBoardWelcome)this.activity ).startRecorder();

                    LibLauncher.startService( this.activity, SoundBoardBgListener.class );

                    break;
                }

                case TEST_STOP_BG_SERVICE:
                {
                    SoundBoardDebug.major.out( "STOP the bg 'Speech Listener' service .." );

                    //noinspection CastToConcreteClass
                    ((SoundBoardWelcome)this.activity ).stopRecorder();

                    LibLauncher.stopService( this.activity, SoundBoardBgListener.class );

                    break;
                }

                case PLAY_SOUND_1:
                {
                    LibSound.playSound( this.activity, R.raw.sound_attack );
                    break;
                }

                case PLAY_SOUND_2:
                {
                    LibSound.playSound( this.activity, R.raw.sound_retreat );
                    break;
                }

                case PLAY_SOUND_3:
                {
                    LibSound.playSound( this.activity, R.raw.sound_resign );
                    break;
                }
            }
        }
    }
