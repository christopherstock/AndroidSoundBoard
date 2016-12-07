
    package de.mayflower.soundboard.state;

    import  android.os.Bundle;
    import  android.support.v7.app.AppCompatActivity;
    import  android.view.KeyEvent;
    import  de.mayflower.lib.ui.LibUI;
    import  de.mayflower.soundboard.R;
    import  de.mayflower.soundboard.SoundBoardAction;

    /*******************************************************************************************
    *   The main activity of the SoundBoardWelcome application.
    *
    *   TODO HIGH   New parent class for all activity classes that handle a back key?
    *
    *   TODO HIGH   Show back button in header?
    *   TODO HIGH   Show menu button in header?
    *   TODO HIGH   Fix DE recognition for speech.
    *   TODO ASAP   Create tabbed view pager.
    *   TODO ASAP   Pimp the ViewPager! Icon items and new style!
    *   TODO ASAP   Prune ALL unused drawables, layouts, values and other resources!!
    *   TODO ASAP   Welcome ViewPager like in PicFood?
    *   TODO HIGH   Button in main view for returning?
    *   TODO INIT   Hold and pass all data in instance fields? Eliminate all static fields?
    *   TODO LOW    SoundBoardMainScreenViewPagerAdapter to lib?
    *   TODO WEAK   Remove ALL inspection issues AND/OR warnings and confectionate Inspection profile!
    *   TODO WEAK   Clarify 9-patch drawable size problem.
    *
    *   @author     Christopher Stock
    *   @version    1.0
    *******************************************************************************************/
    public class SoundBoardWelcome extends AppCompatActivity
    {
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
                new SoundBoardAction( SoundBoardAction.Event.ENTER_TEST_ACTIVITY, this )
            );

            LibUI.setupButton
            (
                this,
                R.id.button_show_main_screen,
                R.string.button_show_main_screen,
                new SoundBoardAction( SoundBoardAction.Event.ENTER_MAIN_SCREEN_ACTIVITY, this )
            );
        }

        @Override
        public boolean onKeyDown( int keyCode, KeyEvent event )
        {
            switch ( keyCode )
            {
                case KeyEvent.KEYCODE_BACK:
                {
                    new SoundBoardAction( SoundBoardAction.Event.SHOW_HOMESCREEN, this ).run();

                    //prevent this event from being propagated further
                    return true;
                }
            }

            //let the system handle this event
            return false;
        }
    }
