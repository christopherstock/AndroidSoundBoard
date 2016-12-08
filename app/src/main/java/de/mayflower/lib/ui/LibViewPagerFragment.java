
    package de.mayflower.lib.ui;

    import android.support.v4.app.*;

    /************************************************************************
    *   The fragment for the ViewPager.
    *
    *   @author     Christopher Stock
    *   @version    1.0
    ************************************************************************/
    public class LibViewPagerFragment extends Fragment
    {
        protected               String                  title                   = null;

        public void setTitle( String title )
        {
            this.title = title;
        }

        public String getTitle()
        {
            return this.title;
        }
    }
