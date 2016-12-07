
    package de.mayflower.soundboard.state;

    import  android.os.Bundle;
    import  de.mayflower.lib.ui.LibUI;
    import  de.mayflower.soundboard.R;
    import  de.mayflower.soundboard.SoundBoardAction;
    import  de.mayflower.soundboard.state.activities.SoundBoardActivity;

    /*******************************************************************************************
    *   The main activity of the SoundBoardWelcome application.
    *
    *   TODO ASAP   Show back button in header?
    *   TODO ASAP   Show menu button in header?
    *   TODO HIGH   Create tabbed view pager.
    *   TODO HIGH   Pimp the ViewPager! Icon items and new style!
    *   TODO HIGH   Prune ALL unused drawables, layouts, values and other resources!!
    *   TODO INIT   Welcome ViewPager like in PicFood?
    *   TODO INIT   Button in main view for returning?
    *   TODO INIT   Hold and pass all data in instance fields? Eliminate all static fields?
    *   TODO HIGH   Fix DE recognition for speech.
    *   TODO LOW    SoundBoardMainScreenViewPagerAdapter to lib?
    *   TODO WEAK   Remove ALL inspection issues AND/OR warnings and confectionate Inspection profile!
    *
    *   @author     Christopher Stock
    *   @version    1.0
    *******************************************************************************************/
    public class SoundBoardWelcome extends SoundBoardActivity
    {
        /*******************************************************************************************
        *   Creates a new Activity.
        *******************************************************************************************/
        public SoundBoardWelcome()
        {
            super( SoundBoardAction.Event.SHOW_HOMESCREEN );
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
            this.setContentView( R.layout.activity_welcome);

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
        }
    }
