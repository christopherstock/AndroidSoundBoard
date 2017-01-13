
    package de.mayflower.soundboard.service;

    import  android.app.Service;
    import  android.content.Intent;
    import  android.os.IBinder;
    import  de.mayflower.lib.LibLauncher;
    import  de.mayflower.soundboard.SoundBoardDebug;

    /*******************************************************************************************************************
    *   The background service that listens for speech input.
    *
    *   @author     Christopher Stock.
    *   @version    0.0.1
    *******************************************************************************************************************/
    public class SoundBoardBgListener extends Service
    {
        @Override
        public void onCreate()
        {
            super.onCreate();

            SoundBoardDebug.bgListener.out( "Background-Listener Service invoked." );

            // TODO check if the service should be invoked repeatedly??



            //final long SERVICE_TICK_DELAY = 5000;
            //LibLauncher.launchService( this, this.getClass(), SERVICE_TICK_DELAY );
        }

        @Override
        public IBinder onBind(Intent intent )
        {
            return null;
        }
    }
