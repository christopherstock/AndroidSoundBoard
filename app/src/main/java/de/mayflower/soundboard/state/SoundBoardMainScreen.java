
    package de.mayflower.soundboard.state;

    import  android.os.Bundle;
    import  android.support.v4.app.FragmentActivity;
    import  android.support.v4.view.ViewPager;
    import  android.view.Menu;
    import  android.view.MenuInflater;
    import  android.view.MenuItem;
    import  de.mayflower.soundboard.R;
    import de.mayflower.soundboard.R.id;
    import de.mayflower.soundboard.R.layout;
    import de.mayflower.soundboard.R.menu;
    import  de.mayflower.soundboard.SoundBoardDebug;
    import de.mayflower.soundboard.SoundBoardVersion;
    import  de.mayflower.soundboard.ui.SoundBoardMainScreenViewPagerAdapter;

    /**********************************************************************************************
    *   The startup activity class.
    *
    *   TODO ASAP   Rename remove 'SoundBoard' from all classes.
    *   TODO ASAP   Move classes to appropriate subpackages.
    *   TODO ASAP   Button in detailed view for returning.
    *   TODO WEAK   Hold and pass all data in instance fields!
    *   TODO WEAK   Support latest API Level.
    *   TODO WEAK   Remove all old classes and references.
    *   TODO WEAK   Remove ALL inspection issues AND/OR warnings and confectionate Inspection profile!
    *
    *   @author     Christopher Stock
    *   @version    1.0
    ***********************************************************************************************/
    public class SoundBoardMainScreen extends FragmentActivity
    {
        /*****************************************************************************
        *   Being invoked when this activity is being created.
        *****************************************************************************/
        @Override
        protected void onCreate( Bundle savedInstanceState )
        {
            //invoke super method
            super.onCreate(savedInstanceState);

            SoundBoardDebug.major.out("Welcome to [" + SoundBoardVersion.getVersion() + "]");
/*
            SoundBoardPatternCountService countService = new SoundBoardPatternCountService();
            countService.init(this);

            SoundBoardHydrator.hydrate(this, countService);
*/
            this.setContentView(layout.soundboard_main_screen);

            this.setupPagerAdapter();
        }

        /*****************************************************************************
        *   Being invoked when the menu key is pressed.
        *****************************************************************************/
        @Override
        public boolean onCreateOptionsMenu( Menu menu )
        {
            SoundBoardDebug.major.out( SoundBoardMainScreen.class + "::onCreateOptionsMenu()" );

            MenuInflater inflater = this.getMenuInflater();
            inflater.inflate( menu.menu_main, menu );

            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item)
        {
            SoundBoardDebug.major.out( SoundBoardMainScreen.class + "::onOptionsItemSelected()" );

            return super.onOptionsItemSelected(item);
        }

        /*****************************************************************************
        *   Sets up the pager-adapter for the pager view.
        *****************************************************************************/
        private void setupPagerAdapter()
        {
            SoundBoardMainScreenViewPagerAdapter pagerAdapter = new SoundBoardMainScreenViewPagerAdapter
            (
                this.getSupportFragmentManager()
            );

            pagerAdapter.init();

            ViewPager viewPager = (ViewPager)this.findViewById( id.main_screen_pager );
            viewPager.setAdapter( pagerAdapter );
        }
    }
