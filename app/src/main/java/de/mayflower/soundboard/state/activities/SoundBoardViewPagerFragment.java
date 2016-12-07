
    package de.mayflower.soundboard.state.activities;

    import  android.os.Bundle;
    import  android.view.LayoutInflater;
    import  android.view.View;
    import  android.view.ViewGroup;
    import  android.widget.TextView;
    import  de.mayflower.lib.ui.LibViewPagerFragment;
    import  de.mayflower.soundboard.R;
    import  de.mayflower.soundboard.SoundBoardDebug;

    /***********************************************************************************************
    *   The concrete class for a viewpager fragment.
    *
    *   @author     Christopher Stock
    *   @version    1.0
    **********************************************************************************************/
    public class SoundBoardViewPagerFragment extends LibViewPagerFragment
    {
        public SoundBoardViewPagerFragment( String title )
        {
            super( title );
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState )
        {
            super.onCreateView( inflater, container, savedInstanceState );



            SoundBoardDebug.major.out("onCreateView for fragment with [" + this.title + "]");

            View     rootView = inflater.inflate( R.layout.activity_viewpager_fragment, container, false );
            TextView tv       = (TextView)rootView.findViewById( R.id.text_viewpager );
            tv.setText( R.string.text_viewpager );

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
