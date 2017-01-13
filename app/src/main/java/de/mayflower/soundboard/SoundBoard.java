
    package de.mayflower.soundboard;

    import  android.app.Application;

    /*******************************************************************************************************************
    *   The global application context. Long-living variables should be
    *
    *   TODO ASAP Remove old solution via speech dialog.
    *
    *   TODO ASAP Actually play sounds if speech is recognized.
    *
    *   TODO ASAP Alter two button into one toggle button.
    *   TODO ASAP Remove activity 'recorder'.
    *   TODO ASAP Alter blue hover color on pressing system buttons (menu key etc.).
    *   TODO ASAP Release via FastLane.
    *   TODO ASAP Create Wiki page.
    *   TODO ASAP Complete 'Apps' wiki page.
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
