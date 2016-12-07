
    package de.mayflower.soundboard.state;

    import  android.os.Bundle;
    import  de.mayflower.lib.ui.LibUI;
    import de.mayflower.lib.ui.LibViewPagerFragment;
    import  de.mayflower.soundboard.R;
    import  de.mayflower.soundboard.SoundBoardAction;
    import  de.mayflower.soundboard.state.activities.SoundBoardActivity;

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
            super( SoundBoardAction.Event.RETURN_TO_ACTIVITY_WELCOME, true );
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
                new LibViewPagerFragment[]
                {
                        new LibViewPagerFragment( "Fragment A" ),
                        new LibViewPagerFragment( "Fragment B" ),
                        new LibViewPagerFragment( "Fragment C" ),
                        new LibViewPagerFragment( "Fragment D" ),
                }
            );
        }
    }
