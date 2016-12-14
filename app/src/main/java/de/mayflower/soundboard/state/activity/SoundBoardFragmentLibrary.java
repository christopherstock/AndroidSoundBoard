
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

            View     rootView = inflater.inflate( R.layout.activity_viewpager_fragment_tabbedpane, container, false );


            TextView tv       = (TextView)rootView.findViewById( R.id.text_viewpager );

            LibUI.setupTextView
            (
                tv,
                "ViewPager<br>Example content<br>Page " + ( this.index + 1 ),
                SoundBoardFont.TYPEFACE_MYRIAD_PRO_REGULAR.getTypeface( this.getContext() )
            );



            //ViewGroup sv       = (ViewGroup)rootView.findViewById( R.id.view_pager_scrollview_content );
/*
            LibUI.setupTextView
            (
                this.getActivity(),
                R.id.text_viewpager,
                R.string.text_viewpager
            );

            ViewGroup sv       = (ViewGroup)rootView.findViewById( R.id.view_pager_scrollview_content );
*/
/*
            SoundBoardPatternCountService countService = new SoundBoardPatternCountService();
            countService.init(this.getActivity());

            Integer[] patternIds;

            if ( Integer.valueOf(index).compareTo(SoundBoardPatternCountService.TOP_10_CATEGORY_ID) == 0) {
                patternIds = countService.getSortedTopPatternIdList(10, SoundBoardHydrator.patterns);
            } else {
                patternIds = SoundBoardHydrator.categories[index].getPatterns();
            }

            for ( int i = 0; i < patternIds.length; ++i )
            {
                LinearLayout item     = (LinearLayout)inflater.inflate(R.layout.SoundBoard_list_item, container, false);
                TextView     textView = (TextView)item.findViewById(R.id.text_item_title);

                String patternLabel = SoundBoardHydrator.patterns[i].getName();

                if ( Integer.valueOf(index).compareTo(SoundBoardPatternCountService.TOP_10_CATEGORY_ID) == 0) {
                    patternLabel = SoundBoardHydrator.patterns[i].getNameWithCounter();
                }

                textView.setText( patternLabel );

                SoundBoardItemClickListener clickListener = new SoundBoardItemClickListener(
                    i,
                    this.getActivity()
                );

                item.setOnClickListener( clickListener );

                sv.addView( item );
            }
*/
            return rootView;
        }
    }
