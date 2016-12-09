
    package de.mayflower.soundboard.ui;

    import  android.app.Activity;
    import  android.view.View;
    import  de.mayflower.soundboard.SoundBoardDebug;

    /**********************************************************************************************
    *   This class represents the item click listener for an item lists.
    *
    *   @author     Christopher Stock.
    *   @version    1.0
    ***********************************************************************************************/
    public class SoundBoardItemClickListener implements View.OnClickListener
    {
        private                 int                 index                       = 0;
        private                 Activity            context                     = null;

        /**********************************************************************************************
        *   Creates a new Item Click Listener.
        *
        *   @param  index   The index for the item to append this listener on.
        *   @param  context The current application context.
        ***********************************************************************************************/
        public SoundBoardItemClickListener(int index, Activity context )
        {
            this.index   = index;
            this.context = context;
        }

        @Override
        public void onClick( View v )
        {
            SoundBoardDebug.major.out("Item [" + this.index + "] in touched!");
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
