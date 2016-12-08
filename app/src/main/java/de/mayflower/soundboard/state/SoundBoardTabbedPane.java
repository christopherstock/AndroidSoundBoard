
    package de.mayflower.soundboard.state;

    import  android.os.Bundle;
    import  android.support.v4.app.FragmentActivity;
    import  android.support.v4.view.ViewPager;
    import  android.view.View;
    import  android.widget.ImageView;
    import  android.widget.TabHost;
    import  android.widget.TabWidget;
    import  java.util.Arrays;
    import  de.mayflower.lib.ui.LibUI;
    import  de.mayflower.lib.ui.LibViewPagerAdapter;
    import  de.mayflower.lib.ui.LibViewPagerFragment;
    import  de.mayflower.soundboard.R;
    import  de.mayflower.soundboard.SoundBoardAction;
    import  de.mayflower.soundboard.state.activity.SoundBoardActivity;
    import  de.mayflower.soundboard.state.activity.SoundBoardFragment;

    /**********************************************************************************************
    *   Represents the tabbed pane.
    *
    *   @author     Christopher Stock
    *   @version    1.0
    **********************************************************************************************/
    public class SoundBoardTabbedPane extends SoundBoardActivity implements TabHost.OnTabChangeListener, ViewPager.OnPageChangeListener
    {
        /** The tag for the tab 'wall'. */
        public      static  final   String                              TAB_TAG_WALL                    = "tab_wall";
        /** The tag for the tab 'explore'. */
        public      static  final   String                              TAB_TAG_EXPLORE                 = "tab_explore";
        /** The tag for the tab 'uplpoad'. */
        public      static  final   String                              TAB_TAG_UPLOAD                  = "tab_upload";
        /** The tag for the tab 'profile'. */
        public      static  final   String                              TAB_TAG_PROFILE                 = "tab_profile";

        /** The TabHost that hold the tab buttons. */
        private                     TabHost                             tabHost                         = null;
        /** The ViewPager that is bound to the TabHost in this {@link FragmentActivity}. */
        private                     ViewPager                           viewPager                       = null;
        /** The adapter that serves the ViewPager with Fragments. */
        public                      LibViewPagerAdapter                 pagerAdapter                    = null;

        /*******************************************************************************************
         *   Creates a new Activity specifying the backKey event.
         *******************************************************************************************/
        public SoundBoardTabbedPane()
        {
            super( SoundBoardAction.Event.RETURN_TO_ACTIVITY_WELCOME, true, true );
        }

        @Override
        protected void onCreate( Bundle savedInstanceState )
        {
            super.onCreate( savedInstanceState );

            this.setContentView( R.layout.activity_tabbedpane );

            //init pivotal state
            this.initPivotal();
        }

        /**********************************************************************************************
        *   Inits the pivotal state.
        **********************************************************************************************/
        private void initPivotal()
        {
            //init TabHost
            this.initialiseTabHost();

            //intialise ViewPager
            this.intialiseViewPager();

            //init TabWidget-bgs
            this.initTabWidgetBgs();
        }

        @Override
        public void onTabChanged( String tabId )
        {
            int pos = this.tabHost.getCurrentTab();
            this.viewPager.setCurrentItem( pos );
        }

        @Override
        public void onPageScrolled( int position, float positionOffset, int positionOffsetPixels )
        {
        }

        @Override
        public void onPageScrollStateChanged( int state )
        {
        }

        @Override
        public void onPageSelected( int position )
        {
            this.tabHost.setCurrentTab( position );
        }

        /**********************************************************************************************
        *   Initialise the Tab Host
        **********************************************************************************************/
        private void initialiseTabHost()
        {
            this.tabHost = (TabHost)this.findViewById( R.id.tabbedpane_tabhost );
            this.tabHost.setup();

            this.addTab( this.tabHost, this.tabHost.newTabSpec( TAB_TAG_WALL    ).setIndicator( LibUI.createImageView( this, R.drawable.tabbed_pane_tab_item, ImageView.ScaleType.CENTER_INSIDE ) ) );
            this.addTab( this.tabHost, this.tabHost.newTabSpec( TAB_TAG_EXPLORE ).setIndicator( LibUI.createImageView( this, R.drawable.tabbed_pane_tab_item, ImageView.ScaleType.CENTER_INSIDE ) ) );
            this.addTab( this.tabHost, this.tabHost.newTabSpec( TAB_TAG_UPLOAD  ).setIndicator( LibUI.createImageView( this, R.drawable.tabbed_pane_tab_item, ImageView.ScaleType.CENTER_INSIDE ) ) );
            this.addTab( this.tabHost, this.tabHost.newTabSpec( TAB_TAG_PROFILE ).setIndicator( LibUI.createImageView( this, R.drawable.tabbed_pane_tab_item, ImageView.ScaleType.CENTER_INSIDE ) ) );

            this.tabHost.setOnTabChangedListener( this );
        }

        /**********************************************************************************************
        *   Initialise ViewPager
        **********************************************************************************************/
        private void intialiseViewPager()
        {
            //setup PagerAdapter
            this.pagerAdapter = new LibViewPagerAdapter
            (
                super.getSupportFragmentManager(),
                Arrays.asList
                (
                    new LibViewPagerFragment[]
                    {
                        new SoundBoardFragment( "Fragment A" ),
                        new SoundBoardFragment( "Fragment B" ),
                        new SoundBoardFragment( "Fragment C" ),
                        new SoundBoardFragment( "Fragment D" ),
                    }
                )
            );

            //init ViewPager
            this.viewPager = (ViewPager)super.findViewById( R.id.viewpager );
            this.viewPager.setAdapter( this.pagerAdapter );
            this.viewPager.addOnPageChangeListener( this );
        }

        /**********************************************************************************************
        *   Init the backgrounds for all tabs
        **********************************************************************************************/
        private void initTabWidgetBgs()
        {
            TabWidget tabWidget = this.tabHost.getTabWidget();
            for ( int i = 0; i < tabWidget.getChildCount(); ++i )
            {
                //tabWidget.getChildAt( i ).setBackgroundResource( R.drawable. );
                tabWidget.getChildAt( i ).setBackgroundColor( 0xffffff00 );
            }
        }

        /**********************************************************************************************
        *   Adds a tab to the Tabhost
        *
        *   @param  tabHost     The TabHost to add a tab to.
        *   @param  tabSpec     The specification of the new tab to add.
        **********************************************************************************************/
        private void addTab( TabHost tabHost, TabHost.TabSpec tabSpec )
        {
            //create anonymous content-factory class
            tabSpec.setContent
            (
                new TabHost.TabContentFactory()
                {
                    @Override
                    public View createTabContent( String tag )
                    {
                        //return empty view
                        View v = new View( SoundBoardTabbedPane.this );
                        //v.setMinimumWidth(  0 );
                        //v.setMinimumHeight( 0 );
                        return v;
                    }
                }
            );

            //add tabSpec to host
            tabHost.addTab( tabSpec );
        }
    }
