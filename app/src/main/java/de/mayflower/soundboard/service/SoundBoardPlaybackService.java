
    package de.mayflower.soundboard.service;

    import  android.app.Activity;
    import  de.mayflower.lib.io.LibSound;
    import  de.mayflower.soundboard.R;
    import  de.mayflower.soundboard.SoundBoardDebug;

    /**********************************************************************************************
     *   This class handles recognized speech strings.
     *
     *   @author     Christopher Stock.
     *   @version    1.0
     ***********************************************************************************************/
    public class SoundBoardPlaybackService
    {
        public void handleReceivedSpeechStrings( Activity activity, String[] matches )
        {
            for ( String match : matches )
            {
                SoundBoardDebug.major.out("[" + match + "]");

                if ( match.equalsIgnoreCase( "ich greife an" ) )
                {
                    SoundBoardDebug.major.out("Play sound 'attack'");
                    LibSound.playSound( activity, R.raw.sound_attack );
                    break;
                }
                else if ( match.equalsIgnoreCase( "ich ziehe mich zurück" ) )
                {
                    SoundBoardDebug.major.out("Play sound 'retreat'");
                    LibSound.playSound( activity, R.raw.sound_retreat );
                    break;
                }
                else if ( match.equalsIgnoreCase( "ich gebe auf" ) )
                {
                    SoundBoardDebug.major.out("Play sound 'resign'");
                    LibSound.playSound( activity, R.raw.sound_resign );
                    break;
                }
            }
        }
    }
