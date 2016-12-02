
    package de.mayflower.soundboard.state;

    import  android.os.Bundle;
    import  android.support.v7.app.AppCompatActivity;
    import  android.view.KeyEvent;
    import  de.mayflower.lib.ui.LibUI;
    import  de.mayflower.soundboard.R;
    import  de.mayflower.soundboard.SoundBoardAction;

    /*******************************************************************************************
    *   The main activity of the SoundBoardWelcomeScreen application.
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
        /*******************************************************************************************
        *   Being invoked when the application starts and resumes.
        *
        *   @param savedInstanceState The data bundle being passed if any.
        *******************************************************************************************/
        @Override
        protected void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);

            this.setContentView( R.layout.activity_sound_board_welcome_screen );

            LibUI.setupButton
            (
                this,
                R.id.button_welcome,
                R.string.button_welcome,
                new SoundBoardAction( SoundBoardAction.Event.SHOW_TEST_ACTIVITY, this )
            );

            LibUI.setupButton
            (
                this,
                R.id.button_show_main_screen,
                R.string.button_show_main_screen,
                new SoundBoardAction( SoundBoardAction.Event.SHOW_MAIN_SCREEN_ACTIVITY, this )
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
