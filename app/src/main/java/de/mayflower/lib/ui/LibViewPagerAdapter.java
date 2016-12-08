
    package de.mayflower.lib.ui;

    import  android.support.v4.app.Fragment;
    import  android.support.v4.app.FragmentManager;
    import  android.support.v4.app.FragmentPagerAdapter;
    import  java.util.List;

    /************************************************************************
    *   The adapter for a ViewPager.
    *
    *   @author     Christopher Stock
    *   @version    1.0
    ************************************************************************/
    public class LibViewPagerAdapter extends FragmentPagerAdapter
    {
        private             List<LibViewPagerFragment>      fragments           = null;

        public LibViewPagerAdapter(FragmentManager fm, List<LibViewPagerFragment> fragments )
        {
            super( fm );

            this.fragments = fragments;
        }

        @Override
        public Fragment getItem( int position )
        {
            return this.fragments.get( position );
        }

        @Override
        public int getCount()
        {
            return this.fragments.size();
        }

        @Override
        public CharSequence getPageTitle( int position )
        {
            return this.fragments.get( position ).getTitle();
        }
    }
