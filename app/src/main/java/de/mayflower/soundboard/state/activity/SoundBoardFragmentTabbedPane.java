
    package de.mayflower.soundboard.state.activity;

    import  android.os.Bundle;
    import  android.view.LayoutInflater;
    import  android.view.View;
    import  android.view.ViewGroup;
    import  android.widget.TextView;
    import  de.mayflower.lib.ui.LibViewPagerFragment;
    import  de.mayflower.soundboard.R;
    import  de.mayflower.soundboard.SoundBoardDebug;

    /***********************************************************************************************
    *   The concrete class for a fragment.
    *
    *   @author     Christopher Stock
    *   @version    1.0
    **********************************************************************************************/
    public class SoundBoardFragmentTabbedPane extends LibViewPagerFragment
    {
        public SoundBoardFragmentTabbedPane()
        {
        }

        public SoundBoardFragmentTabbedPane(String title )
        {
            this.setTitle( title );
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState )
        {
            super.onCreateView( inflater, container, savedInstanceState );

            SoundBoardDebug.major.out("onCreateView for fragment with [" + this.getTitle() + "]");

            View     rootView = inflater.inflate( R.layout.activity_viewpager_fragment_tabbedpane, container, false );
            TextView tv       = (TextView)rootView.findViewById( R.id.text_viewpager );
            tv.setText( R.string.text_fragment_tabbedpane);

            return rootView;
        }
    }
