
    package de.mayflower.soundboard.state;

    import  android.os.Bundle;
    import  de.mayflower.lib.ui.LibUI;
    import  de.mayflower.soundboard.R;
    import  de.mayflower.soundboard.SoundBoardAction;
    import  de.mayflower.soundboard.state.activity.SoundBoardActivity;
    import  de.mayflower.soundboard.ui.SoundBoardFont;

    /*******************************************************************************************
    *   The main activity of the SoundBoardWelcome application.
    *
    *   TODO WEAK Generate Javadoc.
    *
    *   @author     Christopher Stock
    *   @version    1.0
    *******************************************************************************************/
    public class SoundBoardWelcome extends SoundBoardActivity
    {
        /*******************************************************************************************
        *   Creates a new Activity specifying the backKey event.
        *******************************************************************************************/
        public SoundBoardWelcome()
        {
            super
            (
                SoundBoardAction.Event.SHOW_HOMESCREEN,
                SoundBoardActivity.ShowBackButton.NO,
                SoundBoardActivity.ShowMenuButton.YES
            );
        }

        /*******************************************************************************************
        *   Being invoked when the application starts and resumes.
        *
        *   @param savedInstanceState The data bundle being passed if any.
        *******************************************************************************************/
        @Override
        protected void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);

            this.setContentView( R.layout.activity_welcome );

            LibUI.setupButton
            (
                this,
                R.id.button_welcome,
                R.string.button_show_recorder,
                new SoundBoardAction( SoundBoardAction.Event.ENTER_ACTIVITY_RECORDER, this ),
                SoundBoardFont.TYPEFACE_MYRIAD_PRO_REGULAR.getTypeface( this )
            );

            LibUI.setupButton
            (
                this,
                R.id.button_show_viewpager,
                R.string.button_show_viewpager,
                new SoundBoardAction( SoundBoardAction.Event.ENTER_ACTIVITY_VIEWPAGER, this ),
                SoundBoardFont.TYPEFACE_MYRIAD_PRO_REGULAR.getTypeface( this )
            );

            LibUI.setupButton
            (
                this,
                R.id.button_show_tabbedpane,
                R.string.button_show_tabbedpane,
                new SoundBoardAction( SoundBoardAction.Event.ENTER_ACTIVITY_TABBEDPANE, this ),
                SoundBoardFont.TYPEFACE_MYRIAD_PRO_REGULAR.getTypeface( this )
            );
        }
    }
