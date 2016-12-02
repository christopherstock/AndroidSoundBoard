
    package de.mayflower.soundboard.state;

    import  android.os.*;
    import  android.support.v4.app.FragmentActivity;
    import  android.support.v4.view.ViewPager;
    import  android.view.*;
    import  de.mayflower.soundboard.*;
    import  de.mayflower.soundboard.ui.*;

    /**********************************************************************************************
    *   The startup activity class.
    *
    *   @author     Christopher Stock
    *   @version    1.0
    ***********************************************************************************************/
    public class SoundBoardMainScreen extends FragmentActivity
    {
        /** The singleton instance. */
        public      static      FragmentActivity            singleton           = null;

        /*****************************************************************************
        *   Being invoked when this activity is being created.
        *****************************************************************************/
        @Override
        protected void onCreate( Bundle savedInstanceState )
        {
            super.onCreate(savedInstanceState);

            singleton = this;

            SoundBoardDebug.major.out("Welcome to [" + SoundBoardVersion.getVersion() + "]");

            this.setContentView(R.layout.soundboard_main_screen);

            this.setupPagerAdapter();
        }

        /*****************************************************************************
        *   Being invoked when the menu key is pressed.
        *****************************************************************************/
        @Override
        public boolean onCreateOptionsMenu( Menu menu )
        {
            SoundBoardDebug.major.out( SoundBoardMainScreen.class + "::onCreateOptionsMenu()" );

            MenuInflater inflater = this.getMenuInflater();
            inflater.inflate( R.menu.menu_main, menu );

            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item)
        {
            SoundBoardDebug.major.out( SoundBoardMainScreen.class + "::onOptionsItemSelected()" );

            return super.onOptionsItemSelected(item);
        }

        /*****************************************************************************
        *   Sets up the pager-adapter for the pager view.
        *****************************************************************************/
        private void setupPagerAdapter()
        {
            SoundBoardMainScreenViewPagerAdapter pagerAdapter = new SoundBoardMainScreenViewPagerAdapter
            (
                this.getSupportFragmentManager()
            );

            pagerAdapter.init();

            ViewPager viewPager = (ViewPager)this.findViewById( R.id.main_screen_pager );
            viewPager.setAdapter( pagerAdapter );
        }

        @Override
        public boolean onKeyDown( int keyCode, KeyEvent event )
        {
            switch ( keyCode )
            {
                case KeyEvent.KEYCODE_BACK:
                {
                    SoundBoardAction.SHOW_WELCOME_ACTIVITY_FROM_MAIN_ACTIVITY.run();

                    //prevent this event from being propagated further
                    return true;
                }
            }

            //let the system handle this event
            return false;
        }
    }
