
    package de.mayflower.soundboard.ui;

    import  android.app.Activity;
    import  android.view.View;
    import android.view.View.OnClickListener;

    import  de.mayflower.soundboard.SoundBoardDebug;

    /**********************************************************************************************
    *   This class represents the item click listener for an item lists.
    *
    *   @author     Christian Heldt.
    *   @version    1.0
    ***********************************************************************************************/
    public class SoundBoardItemClickListener implements OnClickListener
    {
        private                 int                 index                       = 0;
        private                 Activity            context                     = null;

        public SoundBoardItemClickListener(int index, Activity context )
        {
            this.index   = index;
            this.context = context;
        }

        @Override
        public void onClick( View view )
        {
            SoundBoardDebug.major.out("Item [" + this.index + "] in page [" + this.index + "] touched!");
/*
            SoundBoardHydrator.setCurrent(this.index); // register pattern to show

            LibLauncher.launchActivity(
                    this.context,
                    SoundBoardDetailScreen.class,
                    R.anim.push_left_in,
                    R.anim.push_left_out
            );
*/
        }
    }
