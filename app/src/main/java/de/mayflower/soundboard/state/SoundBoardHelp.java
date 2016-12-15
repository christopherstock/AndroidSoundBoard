
    package de.mayflower.soundboard.state;

    import  android.os.Bundle;
    import  de.mayflower.lib.ui.LibUI;
    import  de.mayflower.soundboard.R;
    import  de.mayflower.soundboard.SoundBoardAction;
    import  de.mayflower.soundboard.state.activity.SoundBoardActivity;
    import  de.mayflower.soundboard.ui.SoundBoardFont;

    /*******************************************************************************************************************
    *   The 'help' activity.
    *
    *   @author     Christopher Stock
    *   @version    0.0.1
    *******************************************************************************************************************/
    public class SoundBoardHelp extends SoundBoardActivity
    {
        /***************************************************************************************************************
        *   Creates a new Activity specifying the backKey event.
        ***************************************************************************************************************/
        public SoundBoardHelp()
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
            super.onCreate(savedInstanceState);

            this.setContentView( R.layout.activity_help );

            LibUI.setupTextView
            (
                this,
                R.id.text_help,
                R.string.text_help,
                SoundBoardFont.TYPEFACE_MYRIAD_PRO_REGULAR.getTypeface( this )
            );
        }
    }
