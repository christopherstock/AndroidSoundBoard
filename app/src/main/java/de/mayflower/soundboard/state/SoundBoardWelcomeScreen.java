
    package de.mayflower.soundboard.state;

    import  android.app.Activity;
    import  android.os.Bundle;
    import  android.support.v7.app.AppCompatActivity;
    import  android.view.KeyEvent;
    import  de.mayflower.lib.ui.LibUI;
    import  de.mayflower.soundboard.R;
    import  de.mayflower.soundboard.SoundBoardAction;
    import  de.mayflower.soundboard.SoundBoardDebug;

    /*******************************************************************************************
    *   The main activity of the SoundBoardWelcomeScreen application.
    *
    *   TODO ASAP   Remove all static Context classes.
    *
    *   TODO ASAP   Prune ALL unused drawables, layouts, values and other resources!!
    *   TODO ASAP   Welcome ViewPager like in PicFood?
    *   TODO WEAK   Remove all old classes and references.
    *   TODO LOW    SoundBoardMainScreenViewPagerAdapter to lib?
    *   TODO ASAP   Button in detailed view for returning.
    *   TODO WEAK   Hold and pass all data in instance fields!
    *   TODO WEAK   Remove ALL inspection issues AND/OR warnings and confectionate Inspection profile!
    *
    *   @author     Christopher Stock
    *   @version    1.0
    *******************************************************************************************/
    public class SoundBoardWelcomeScreen extends AppCompatActivity
    {
        /** The singleton instance. */
        public      static      Activity            singleton           = null;

        /*******************************************************************************************
        *   Being invoked when the application starts and resumes.
        *
        *   @param savedInstanceState The data bundle being passed if any.
        *******************************************************************************************/
        @Override
        protected void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);

            SoundBoardDebug.major.out( "onCreate() in Welcome Screen" );

            singleton = this;

            this.setContentView(R.layout.activity_sound_board_welcome_screen);

            LibUI.setupButton
            (
                this,
                R.id.button_welcome,
                R.string.button_welcome,
                SoundBoardAction.SHOW_TEST_ACTIVITY
            );

            LibUI.setupButton
            (
                this,
                R.id.button_show_main_screen,
                R.string.button_show_main_screen,
                SoundBoardAction.SHOW_MAIN_SCREEN_ACTIVITY
            );
        }

        @Override
        public boolean onKeyDown( int keyCode, KeyEvent event )
        {
            switch ( keyCode )
            {
                case KeyEvent.KEYCODE_BACK:
                {
                    SoundBoardAction.SHOW_HOMESCREEN.run();

                    //prevent this event from being propagated further
                    return true;
                }
            }

            //let the system handle this event
            return false;
        }
    }
