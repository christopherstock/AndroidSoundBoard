
    package de.mayflower.soundboard.ui;

    import  android.support.v4.app.Fragment;
    import  android.support.v4.app.FragmentManager;
    import  android.support.v4.app.FragmentPagerAdapter;

    /************************************************************************
    *   The adapter for the main screen view pager.
    *
    *   TODO To Lib! :D
    *
    *   @author     Christopher Stock
    *   @version    1.0
    ************************************************************************/
    public class SoundBoardMainScreenViewPagerAdapter extends FragmentPagerAdapter
    {
        private         SoundBoardMainScreenViewPagerFragment[]       fragments       = null;

        public SoundBoardMainScreenViewPagerAdapter(FragmentManager fm )
        {
            super( fm );
        }

        public final void init()
        {
/*
            Category[] cats = SoundBoardHydrator.categories;
*/
            this.fragments = new SoundBoardMainScreenViewPagerFragment[5];

            for (int i = 0; i < this.fragments.length; i++ )
            {
                this.fragments[i] = new SoundBoardMainScreenViewPagerFragment();
/*
                fragments[i].init( SoundBoardHydrator.categories[i].getId(), SoundBoardHydrator.categories[i].getName());
*/
                this.fragments[i].init( i, "muuh name " + i);
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
