
    package de.mayflower.soundboard;

    /*****************************************************************************************
    *   Specifies all project settings.
    *
    *   @author     Christopher Stock
    *   @version    1.0
    *****************************************************************************************/
    public abstract class SoundBoardSettings
    {
        /*****************************************************************************************
        *   The paramount settings. Make sure to check these before each release build.
        *****************************************************************************************/
        public static final class Paramounts
        {
            /** The internal name of this project. This value is used in the exception emails. */
            public      static      final   String      PROJECT_NAME            = "SoundBoardWelcome";
        }

        /*****************************************************************************************
        *   All switches made for debug purposes.
        *****************************************************************************************/
        public static final class Debug
        {
            /** Enables or disabled the debug mode. */
            public      static      final   boolean     DEBUG_MODE              = true;
        }
    }
