
    package de.mayflower.soundboard.ui;

    import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
    import android.widget.TextView;

    import de.mayflower.soundboard.R;
import de.mayflower.soundboard.SoundBoardDebug;

    /************************************************************************
    *   The fragment for the ViewPager.
    *
    *   @author     Christopher Stock
    *   @version    1.0
    ************************************************************************/
    public class SoundBoardMainScreenViewPagerFragment extends Fragment
    {
        private                             int         index                   = 0;
        private                             String      title                   = null;

        public void init( int index, String title )
        {
            this.index = index;
            this.title = title;
        }

        @Override
        public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState )
        {
            super.onCreateView( inflater, container, savedInstanceState );



            SoundBoardDebug.major.out("onCreateView for fragment [" + this.index + "]");

            View      rootView = inflater.inflate( R.layout.activity_viewpager_fragment, container, false );
/*
            ViewGroup sv       = (ViewGroup)rootView.findViewById( R.id.view_pager_scrollview_content );
*/

            TextView tv = (TextView)rootView.findViewById( R.id.text_viewpager );
            tv.setText( R.string.text_viewpager );
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

        public String getTitle()
        {
            return this.title;
        }
    }
