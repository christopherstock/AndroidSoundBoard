
    package de.mayflower.soundboard.state;

    import  android.os.Bundle;
    import  de.mayflower.lib.ui.LibUI;
    import  de.mayflower.soundboard.R;
    import  de.mayflower.soundboard.SoundBoardAction;
    import  de.mayflower.soundboard.state.activities.SoundBoardActivity;

    /*******************************************************************************************
    *   The main activity of the SoundBoardWelcome application.
    *
    *   TODO ASAP   Show menu button in header?
    *   TODO HIGH   Pimp the ViewPager! Icon items and new style!
    *   TODO INIT   Create tabbed view pager.
    *   TODO WEAK   Welcome ViewPager (with circle view-pager-indicator) like in PicFood?
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
            super( SoundBoardAction.Event.SHOW_HOMESCREEN, false );
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
                R.string.button_welcome,
                new SoundBoardAction( SoundBoardAction.Event.ENTER_ACTIVITY_RECORDER, this )
            );

            LibUI.setupButton
            (
                this,
                R.id.button_show_main_screen,
                R.string.button_show_main_screen,
                new SoundBoardAction( SoundBoardAction.Event.ENTER_ACTIVITY_VIEWPAGER, this )
            );

            LibUI.setupTextView
            (
                this,
                R.id.text_welcome,
                R.string.text_welcome
            );
        }
    }
