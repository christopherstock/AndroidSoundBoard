
    package de.mayflower.soundboard.state;

    import  android.os.Bundle;
    import  de.mayflower.lib.ui.LibUI;
    import  de.mayflower.soundboard.R;
    import  de.mayflower.soundboard.SoundBoardAction;
    import  de.mayflower.soundboard.state.activities.SoundBoardActivity;

    /*******************************************************************************************
    *   The main activity of the SoundBoardWelcome application.
    *
    *   TODO WEAK   Create tabbed view pager with TabHost.
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
            super( SoundBoardAction.Event.SHOW_HOMESCREEN, false, true );
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
                new SoundBoardAction( SoundBoardAction.Event.ENTER_ACTIVITY_RECORDER, this )
            );

            LibUI.setupButton
            (
                this,
                R.id.button_show_viewpager,
                R.string.button_show_viewpager,
                new SoundBoardAction( SoundBoardAction.Event.ENTER_ACTIVITY_VIEWPAGER, this )
            );

            LibUI.setupButton
            (
                this,
                R.id.button_show_tabbedpane,
                R.string.button_show_tabbedpane,
                new SoundBoardAction( SoundBoardAction.Event.ENTER_ACTIVITY_TABBEDPANE, this )
            );

            LibUI.setupTextView
            (
                this,
                R.id.text_welcome,
                R.string.text_welcome
            );

            LibUI.setupTextView
            (
                this,
                R.id.text_credits,
                R.string.text_credits
            );

            LibUI.setupAnimatedImageView
            (
                this,
                R.id.image_title_logo,
                R.drawable.title_logo
            );
        }
    }
