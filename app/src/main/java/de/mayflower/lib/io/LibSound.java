
    package de.mayflower.lib.io;

    import  android.content.Context;
    import  android.media.MediaPlayer;

    /*******************************************************************************************************************
    *   Manages sound playback.
    *
    *   @author     Christopher Stock
    *   @version    0.0.1
    *******************************************************************************************************************/
    public abstract class LibSound
    {
        /***************************************************************************************************************
        *   Plays the given sound resource.
        *
        *   @param  context     The current system context.
        *   @param  id          The resource-id of the Sound to play.
        ***************************************************************************************************************/
        public static final void playSound( Context context, int id )
        {
            try
            {
                MediaPlayer.create( context, id ).start();
            }
            catch ( Exception e )
            {
                e.printStackTrace();
            }
        }
    }
