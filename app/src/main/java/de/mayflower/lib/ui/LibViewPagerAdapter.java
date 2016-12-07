
    package de.mayflower.lib.ui;

    import  android.support.v4.app.Fragment;
    import  android.support.v4.app.FragmentManager;
    import  android.support.v4.app.FragmentPagerAdapter;

    /************************************************************************
    *   The adapter for a ViewPager.
    *
    *   @author     Christopher Stock
    *   @version    1.0
    ************************************************************************/
    public class LibViewPagerAdapter extends FragmentPagerAdapter
    {
        private         LibViewPagerFragment[]         fragments           = null;

        public LibViewPagerAdapter( FragmentManager fm )
        {
            super( fm );
        }

        public final void init()
        {
            this.fragments = new LibViewPagerFragment[5];

            for ( int i = 0; i < this.fragments.length; i++ )
            {
                this.fragments[i] = new LibViewPagerFragment();
                this.fragments[i].init( i, "Fragment # " + i);
            }
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
