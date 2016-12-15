
    package de.mayflower.soundboard.state.activity;

    import  android.graphics.Typeface;
    import  android.os.Bundle;
    import  android.view.LayoutInflater;
    import  android.view.View;
    import  android.view.ViewGroup;
    import  android.widget.TextView;
    import  de.mayflower.lib.ui.LibUI;
    import  de.mayflower.lib.ui.LibViewPagerFragment;
    import  de.mayflower.soundboard.R;
    import  de.mayflower.soundboard.SoundBoardAction;
    import  de.mayflower.soundboard.SoundBoardDebug;
    import  de.mayflower.soundboard.ui.SoundBoardFont;

    /*******************************************************************************************************************
    *   One fragment for the 'library' ViewPager.
    *
    *   @author     Christopher Stock
    *   @version    0.0.1
    *******************************************************************************************************************/
    public class SoundBoardFragmentLibrary extends LibViewPagerFragment
    {
        /** This fragment's index in the ViewPager. */
        private                     int             index               = 0;

        /***************************************************************************************************************
        *   Creates a new fragment for the 'library' ViewPager.
        *
        *   @param  index   This fragment's index in the ViewPager.
        *   @param  title   This fragment's title.
        ***************************************************************************************************************/
        public SoundBoardFragmentLibrary( int index, String title )
        {
            this.index = index;
            this.setTitle( title );
        }

        @Override
        public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState )
        {
            super.onCreateView( inflater, container, savedInstanceState );

            SoundBoardDebug.major.out("onCreateView for fragment with [" + this.getTitle() + "]");

            View      rootView      = inflater.inflate( R.layout.activity_viewpager_fragment, container, false );
            ViewGroup fragContainer = (ViewGroup)rootView.findViewById( R.id.viewpager_fragment_container );
            Typeface  typeface      = SoundBoardFont.TYPEFACE_MYRIAD_PRO_REGULAR.getTypeface( this.getContext() );
            TextView  tv            = (TextView)rootView.findViewById( R.id.text_viewpager );

            // show temporary items
            if ( this.index == 0 )
            {
                tv.setVisibility( View.GONE );

                View     item1      = LibUI.getInflatedLayoutById( this.getContext(), R.layout.item_settings );
                View     item2      = LibUI.getInflatedLayoutById( this.getContext(), R.layout.item_settings );
                View     item3      = LibUI.getInflatedLayoutById( this.getContext(), R.layout.item_settings );

                View     separator1 = LibUI.getInflatedLayoutById( this.getContext(), R.layout.item_separator );
                View     separator2 = LibUI.getInflatedLayoutById( this.getContext(), R.layout.item_separator );

                TextView textView1  = (TextView)item1.findViewById( R.id.text_item );
                TextView textView2  = (TextView)item2.findViewById( R.id.text_item );
                TextView textView3  = (TextView)item3.findViewById( R.id.text_item );

                LibUI.setupTextView( textView1, "Ich greife an!",         typeface );
                LibUI.setupTextView( textView2, "Ich ziehe mich zurück!", typeface );
                LibUI.setupTextView( textView3, "Ich gebe auf!",          typeface );

                LibUI.setOnClickAction
                (
                    textView1,
                    new SoundBoardAction( SoundBoardAction.Event.PLAY_SOUND_1, this.getActivity() ),
                    false
                );
                LibUI.setOnClickAction
                (
                    textView2,
                    new SoundBoardAction( SoundBoardAction.Event.PLAY_SOUND_2, this.getActivity() ),
                    false
                );
                LibUI.setOnClickAction
                (
                    textView3,
                    new SoundBoardAction( SoundBoardAction.Event.PLAY_SOUND_3, this.getActivity() ),
                    false
                );

                fragContainer.addView( item1 );
                fragContainer.addView( separator1 );
                fragContainer.addView( item2 );
                fragContainer.addView( separator2 );
                fragContainer.addView( item3 );
            }
            else
            {
                LibUI.setupTextView
                (
                    tv,
                    "ViewPager<br>Example content<br>Page " + ( this.index + 1 ),
                    typeface
                );
            }

            return rootView;
        }
    }
