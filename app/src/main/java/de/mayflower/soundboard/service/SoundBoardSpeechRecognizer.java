
    package de.mayflower.soundboard.service;

    import  android.content.Context;
    import  de.mayflower.lib.io.LibSound;
    import  de.mayflower.soundboard.R;
    import  de.mayflower.soundboard.SoundBoardDebug;

    /*******************************************************************************************************************
    *   This class handles recognized speech strings.
    *
    *   @author     Christopher Stock.
    *   @version    1.0.0
    *******************************************************************************************************************/
    public class SoundBoardSpeechRecognizer
    {
        /***************************************************************************************************************
        *   Handles the recognized speech strings and plays a sound, if a phrase has been recognized.
        *
        *   @param  context     The current activity context.
        *   @param  matches     All possible recognized phrases recognized from speech input.
        ***************************************************************************************************************/
        public void handleReceivedSpeechStrings( Context context, String[] matches )
        {
            for ( String match : matches )
            {
                SoundBoardDebug.speechResults.out("[" + match + "]");

                if ( match.equalsIgnoreCase( "ich greife an" ) )
                {
                    SoundBoardDebug.speechResults.out("Play sound 'attack'");
                    LibSound.playSound( context, R.raw.sound_attack );
                    break;
                }
                else if ( match.equalsIgnoreCase( "ich ziehe mich zurück" ) )
                {
                    SoundBoardDebug.speechResults.out("Play sound 'retreat'");
                    LibSound.playSound( context, R.raw.sound_retreat );
                    break;
                }
                else if ( match.equalsIgnoreCase( "ich gebe auf" ) )
                {
                    SoundBoardDebug.speechResults.out("Play sound 'resign'");
                    LibSound.playSound( context, R.raw.sound_resign );
                    break;
                }
            }
        }
    }
