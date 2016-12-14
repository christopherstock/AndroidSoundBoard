
    package de.mayflower.soundboard.state.activity;

    import  android.os.Bundle;
    import  android.view.LayoutInflater;
    import  android.view.View;
    import  android.view.ViewGroup;
    import  android.widget.TextView;
    import  de.mayflower.lib.ui.LibUI;
    import  de.mayflower.lib.ui.LibViewPagerFragment;
    import  de.mayflower.soundboard.R;
    import  de.mayflower.soundboard.SoundBoardDebug;
    import  de.mayflower.soundboard.ui.SoundBoardFont;

    /***********************************************************************************************
    *   The concrete class for a fragment.
    *
    *   @author     Christopher Stock
    *   @version    1.0
    **********************************************************************************************/
    public class SoundBoardFragmentLibrary extends LibViewPagerFragment
    {
        private                     int             index               = 0;

        public SoundBoardFragmentLibrary()
        {
        }

        public SoundBoardFragmentLibrary( int index, String title )
        {
            this.index = index;
            this.setTitle( title );
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState )
        {
            super.onCreateView( inflater, container, savedInstanceState );

            SoundBoardDebug.major.out("onCreateView for fragment with [" + this.getTitle() + "]");

            View      rootView          = inflater.inflate( R.layout.activity_viewpager_fragment_tabbedpane, container, false );
            ViewGroup fragmentContainer = (ViewGroup)rootView.findViewById( R.id.viewpager_fragment_container );


            // show temporary items
            if ( this.index == 0 )
            {

            }
            else
            {
                TextView tv = (TextView)rootView.findViewById( R.id.text_viewpager );

                LibUI.setupTextView
                (
                    tv,
                    "ViewPager<br>Example content<br>Page " + ( this.index + 1 ),
                    SoundBoardFont.TYPEFACE_MYRIAD_PRO_REGULAR.getTypeface( this.getContext() )
                );
            }

            return rootView;
        }
    }
