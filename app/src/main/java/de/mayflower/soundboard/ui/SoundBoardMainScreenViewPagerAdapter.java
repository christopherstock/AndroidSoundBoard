
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
            fragments = new SoundBoardMainScreenViewPagerFragment[5];

            for ( int i = 0; i < fragments.length; i++ )
            {
                fragments[i] = new SoundBoardMainScreenViewPagerFragment();
/*
                fragments[i].init( SoundBoardHydrator.categories[i].getId(), SoundBoardHydrator.categories[i].getName());
*/
                fragments[i].init( i, "muuh name " + i);
            }
        }

        @Override
        public Fragment getItem( int position )
        {
            return fragments[ position ];
        }

        @Override
        public int getCount()
        {
            return fragments.length;
        }

        @Override
        public CharSequence getPageTitle( int position )
        {
            return fragments[ position ].getTitle();
        }
    }
