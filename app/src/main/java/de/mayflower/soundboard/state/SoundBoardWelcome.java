
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
    *   TODO ASAP   Add custom dialog (for about, with logo etc.).
    *   TODO ASAP   Check remaining features in the template project.
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

            LibUI.setupTextView
            (
                this,
                R.id.text_welcome,
                R.string.text_welcome,
                SoundBoardFont.TYPEFACE_MYRIAD_PRO_REGULAR.getTypeface( this )
            );

            LibUI.setupTextView
            (
                this,
                R.id.text_credits,
                R.string.text_credits,
                SoundBoardFont.TYPEFACE_MYRIAD_PRO_REGULAR.getTypeface( this )
            );

            LibUI.setupAnimatedImageView
            (
                this,
                R.id.image_title_logo,
                R.drawable.title_logo
            );



            LibUI.setupButton
            (
                this,
                R.id.button_unlinked_1,
                R.string.button_back,
                new SoundBoardAction( SoundBoardAction.Event.NOTHING, this ),
                SoundBoardFont.TYPEFACE_MYRIAD_PRO_REGULAR.getTypeface( this )
            );
        }
    }
