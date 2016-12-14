
    package de.mayflower.lib.ui;

    import  android.support.v4.app.*;

    /************************************************************************
    *   The fragment for a ViewPager.
    *
    *   @author     Christopher Stock
    *   @version    1.0
    ************************************************************************/
    public class LibViewPagerFragment extends Fragment
    {
        /** The title for this fragment. */
        private                 String                  title                   = null;

        /************************************************************************
        *   Sets this fragment's title.
        *
        *   @param  title   The title to set for this fragment.
        ************************************************************************/
        public void setTitle( String title )
        {
            this.title = title;
        }

        /************************************************************************
        *   Returns this fragment's title.
        *
        *   @return The title of this fragment.
        ************************************************************************/
        public String getTitle()
        {
            return this.title;
        }
    }
