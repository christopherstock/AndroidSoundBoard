
    package de.mayflower.soundboard.state;

    import  android.os.Bundle;
    import  de.mayflower.lib.ui.LibUI;
    import  de.mayflower.soundboard.R;
    import  de.mayflower.soundboard.SoundBoardAction;
    import  de.mayflower.soundboard.state.activity.SoundBoardActivity;
    import  de.mayflower.soundboard.ui.SoundBoardFont;

    /*******************************************************************************************************************
    *   The recorder activity.
    *
    *   @author     Christopher Stock
    *   @version    0.0.1
    *******************************************************************************************************************/
    public class SoundBoardRecorder extends SoundBoardActivity
    {
        /** The request id for the external activity 'speech recognizer'. */
        public      static  final   int             REQUEST_CODE_RECORD_AUDIO       = 1;

        /***************************************************************************************************************
        *   Creates a new Activity specifying the backKey event.
        ***************************************************************************************************************/
        public SoundBoardRecorder()
        {
            super
            (
                SoundBoardAction.Event.RETURN_TO_ACTIVITY_WELCOME,
                SoundBoardActivity.ShowBackButton.YES,
                SoundBoardActivity.ShowMenuButton.YES
            );
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

            this.setContentView( R.layout.activity_recorder );

            LibUI.setupTextView
            (
                this,
                R.id.text_recorder,
                R.string.text_recorder,
                SoundBoardFont.TYPEFACE_MYRIAD_PRO_REGULAR.getTypeface( this )
            );

            LibUI.setupButton
            (
                this,
                R.id.button_start_listener_service,
                R.string.button_start_bg_listener_service,
                new SoundBoardAction( SoundBoardAction.Event.TEST_START_BG_SERVICE, this ),
                SoundBoardFont.TYPEFACE_MYRIAD_PRO_REGULAR.getTypeface( this )
            );

            LibUI.setupButton
            (
                this,
                R.id.button_stop_listener_service,
                R.string.button_stop_bg_listener_service,
                new SoundBoardAction( SoundBoardAction.Event.TEST_STOP_BG_SERVICE, this ),
                SoundBoardFont.TYPEFACE_MYRIAD_PRO_REGULAR.getTypeface( this )
            );
        }
    }
