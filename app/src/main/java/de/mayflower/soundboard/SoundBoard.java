
    package de.mayflower.soundboard;

    import  android.app.Application;

    /*******************************************************************************************************************
    *   The global application context. Long-living variables should be
    *
    *   TODO ASAP Release via FastLane.
    *   TODO ASAP Create Wiki page.
    *   TODO ASAP Complete 'Apps' wiki page.
    *   TODO ASAP Perform code inspection and remove all warnings etc.
    *
    *   @author     Christopher Stock
    *   @version    1.0.0
    *******************************************************************************************************************/
    public class SoundBoard extends Application
    {
        /***************************************************************************************************************
        *   Being invoked on application startup and resume.
        ***************************************************************************************************************/
        @Override
        public void onCreate()
        {
            super.onCreate( );

            SoundBoardDebug.major.out( "onCreate() in Application class being invoked." );
        }
    }
