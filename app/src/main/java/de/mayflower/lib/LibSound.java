
    package de.mayflower.lib;

    import  android.content.Context;
    import  android.media.MediaPlayer;

    /*********************************************************************************
    *   Manages sound playback.
    *
    *   TODO to package io !
    *
    *   @author     Christopher Stock
    *   @version    1.0
    *********************************************************************************/
    public abstract class LibSound
    {
        /*********************************************************************************
        *   Plays the given sound resource.
        *
        *   @param  context     The current system context.
        *   @param  id          The resource-id of the Sound to play.
        *********************************************************************************/
        public static final void playSound( Context context, int id )
        {
            try
            {
                MediaPlayer.create( context, id ).start ();
            }
            catch ( Exception e )
            {
                e.printStackTrace();
            }
        }
    }
