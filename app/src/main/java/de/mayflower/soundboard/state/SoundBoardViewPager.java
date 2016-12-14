
    package de.mayflower.soundboard.state;

    import  android.os.Bundle;
    import  java.util.Arrays;
    import  de.mayflower.lib.ui.LibUI;
    import  de.mayflower.lib.ui.LibViewPagerFragment;
    import  de.mayflower.soundboard.R;
    import  de.mayflower.soundboard.SoundBoardAction;
    import  de.mayflower.soundboard.state.activity.SoundBoardActivity;
    import  de.mayflower.soundboard.state.activity.SoundBoardFragmentLibrary;

    /**********************************************************************************************
    *   The viewPager activity.
    *
    *   @author     Christopher Stock
    *   @version    1.0
    ***********************************************************************************************/
    public class SoundBoardViewPager extends SoundBoardActivity
    {
        /*******************************************************************************************
        *   Creates a new Activity specifying the backKey event.
        *******************************************************************************************/
        public SoundBoardViewPager()
        {
            super
            (
                SoundBoardAction.Event.RETURN_TO_ACTIVITY_WELCOME,
                SoundBoardActivity.ShowBackButton.YES,
                SoundBoardActivity.ShowMenuButton.YES
            );
        }

        /*****************************************************************************
        *   Being invoked when this activity is being created.
        *****************************************************************************/
        @Override
        protected void onCreate( Bundle savedInstanceState )
        {
            super.onCreate( savedInstanceState );

            this.setContentView( R.layout.activity_viewpager );

            LibUI.setupViewPagerAdapter
            (
                this,
                R.id.viewpager_pager,
                Arrays.asList
                (
                    new LibViewPagerFragment[]
                    {
                        new SoundBoardFragmentLibrary( "Default" ),
                        new SoundBoardFragmentLibrary( "Funny" ),
                        new SoundBoardFragmentLibrary( "Thrilling" ),
                        new SoundBoardFragmentLibrary( "Weird" ),
                    }
                )
            );
        }
    }
