
    package de.mayflower.soundboard.state;

    import  android.os.Bundle;
    import  android.support.v4.view.ViewPager;
    import  android.view.KeyEvent;
    import  de.mayflower.soundboard.R;
    import  de.mayflower.soundboard.SoundBoardAction;
    import  de.mayflower.soundboard.state.activities.SoundBoardActivity;
    import  de.mayflower.soundboard.ui.SoundBoardMainScreenViewPagerAdapter;

    /**********************************************************************************************
    *   The startup activity class.
    *
    *   @author     Christopher Stock
    *   @version    1.0
    ***********************************************************************************************/
    public class SoundBoardMain extends SoundBoardActivity
    {
        /*****************************************************************************
        *   Being invoked when this activity is being created.
        *****************************************************************************/
        @Override
        protected void onCreate( Bundle savedInstanceState )
        {
            super.onCreate(savedInstanceState);
            this.setContentView(R.layout.activity_main);

            this.setupPagerAdapter();
        }
/*
        @Override
        public boolean onOptionsItemSelected(MenuItem item)
        {
            SoundBoardDebug.major.out( SoundBoardMain.class + "::onOptionsItemSelected()" );

            return super.onOptionsItemSelected(item);
        }
*/
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
                    new SoundBoardAction( SoundBoardAction.Event.RETURN_TO_WELCOME_ACTIVITY, this ).run();

                    //prevent this event from being propagated further
                    return true;
                }
            }

            //let the system handle this event
            return false;
        }
    }
