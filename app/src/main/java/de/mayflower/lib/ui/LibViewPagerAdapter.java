
    package de.mayflower.lib.ui;

    import  android.support.v4.app.*;

    /************************************************************************
    *   The adapter for a ViewPager.
    *
    *   @author     Christopher Stock
    *   @version    1.0
    ************************************************************************/
    public class LibViewPagerAdapter extends FragmentPagerAdapter
    {
        private         LibViewPagerFragment[]         fragments           = null;

        public LibViewPagerAdapter( FragmentManager fm, LibViewPagerFragment[] fragments )
        {
            super( fm );

            this.fragments = fragments;
        }

        @Override
        public Fragment getItem( int position )
        {
            return this.fragments[ position ];
        }

        @Override
        public int getCount()
        {
            return this.fragments.length;
        }

        @Override
        public CharSequence getPageTitle( int position )
        {
            return this.fragments[ position ].getTitle();
        }
    }