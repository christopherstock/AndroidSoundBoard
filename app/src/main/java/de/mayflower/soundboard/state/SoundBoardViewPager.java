
    package de.mayflower.soundboard.state;

    import  android.os.Bundle;
    import  android.support.v4.view.ViewPager;
    import  de.mayflower.soundboard.R;
    import  de.mayflower.soundboard.SoundBoardAction;
    import  de.mayflower.soundboard.state.activities.SoundBoardActivity;
    import  de.mayflower.soundboard.ui.SoundBoardMainScreenViewPagerAdapter;

    /**********************************************************************************************
    *   The viewPager activity.
    *
    *   @author     Christopher Stock
    *   @version    1.0
    ***********************************************************************************************/
    public class SoundBoardViewPager extends SoundBoardActivity
    {
        /*******************************************************************************************
        *   Creates a new Activity.
        *******************************************************************************************/
        public SoundBoardViewPager()
        {
            super(SoundBoardAction.Event.RETURN_TO_ACTIVITY_WELCOME);
        }

        /*****************************************************************************
        *   Being invoked when this activity is being created.
        *****************************************************************************/
        @Override
        protected void onCreate( Bundle savedInstanceState )
        {
            super.onCreate( savedInstanceState );
            this.setContentView( R.layout.activity_viewpager);

            this.setupPagerAdapter();
        }
/*
        @Override
        public boolean onOptionsItemSelected(MenuItem item)
        {
            SoundBoardDebug.major.out( SoundBoardViewPager.class + "::onOptionsItemSelected()" );

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
    }
