
    package de.mayflower.soundboard;

    import  android.app.Application;

    /*******************************************************************************************************************
    *   The global application context. Long-living variables should be
    *
    *   TODO ASAP Alter two button into one toggle button.
    *   TODO ASAP Alter blue hover color on pressing system buttons (menu key etc.).
    *   TODO ASAP Release via FastLane.
    *   TODO ASAP Create Wiki page.
    *   TODO ASAP Complete 'Apps' wiki page.
    *   TODO ASAP Perform code inspection and remove all warnings etc.
    *
    *   @author     Christopher Stock
    *   @version    0.0.1
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
