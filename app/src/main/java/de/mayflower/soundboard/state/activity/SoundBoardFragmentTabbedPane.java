
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

    /*******************************************************************************************************************
    *   One fragment for the TabbedPane.
    *
    *   @author     Christopher Stock
    *   @version    1.0.0
    *******************************************************************************************************************/
    public class SoundBoardFragmentTabbedPane extends LibViewPagerFragment
    {
        /***************************************************************************************************************
        *   Creates a new fragment for the TabbedPane.
        *
        *   @param  title   This fragment's title.
        ***************************************************************************************************************/
        public SoundBoardFragmentTabbedPane(String title )
        {
            this.setTitle( title );
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState )
        {
            super.onCreateView( inflater, container, savedInstanceState );

            SoundBoardDebug.major.out("onCreateView for fragment with [" + this.getTitle() + "]");

            View     rootView = inflater.inflate( R.layout.activity_viewpager_fragment, container, false );
            TextView tv       = (TextView)rootView.findViewById( R.id.text_viewpager );

            LibUI.setupTextView
            (
                tv,
                this.getTitle(),
                SoundBoardFont.TYPEFACE_MYRIAD_PRO_REGULAR.getTypeface( this.getContext() )
            );

            return rootView;
        }
    }
