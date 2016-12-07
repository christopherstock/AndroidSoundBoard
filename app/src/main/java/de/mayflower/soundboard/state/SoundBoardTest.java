
    package de.mayflower.soundboard.state;

    import  android.app.Activity;
    import  android.content.Intent;
    import  android.os.Bundle;
    import  android.speech.RecognizerIntent;
    import  android.view.KeyEvent;
    import  java.util.ArrayList;
    import  de.mayflower.lib.io.LibSound;
    import  de.mayflower.lib.ui.LibUI;
    import  de.mayflower.soundboard.R;
    import  de.mayflower.soundboard.SoundBoardAction;
    import  de.mayflower.soundboard.SoundBoardDebug;
    import  de.mayflower.soundboard.state.activities.SoundBoardActivity;

    /*******************************************************************************************
    *   The test activity.
    *
    *   @author     Christopher Stock
    *   @version    1.0
    *******************************************************************************************/
    public class SoundBoardTest extends SoundBoardActivity
    {
        /** The request id  */
        public      static  final   int             REQUEST_CODE_RECORD_AUDIO       = 1;

        /*******************************************************************************************
        *   Creates a new Activity.
        *******************************************************************************************/
        public SoundBoardTest()
        {
            super(SoundBoardAction.Event.RETURN_TO_WELCOME_ACTIVITY );
        }

        /*******************************************************************************************
        *   Being invoked when the application starts and resumes.
        *
        *   @param savedInstanceState The data bundle being passed if any.
        *******************************************************************************************/
        @Override
        protected void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            this.setContentView(R.layout.activity_test);

            LibUI.setupButton
            (
                this,
                R.id.button_test,
                R.string.button_test,
                new SoundBoardAction( SoundBoardAction.Event.RETURN_TO_WELCOME_ACTIVITY, this )
            );

            LibUI.setupButton
            (
                this,
                R.id.button_voice_input,
                R.string.button_voice_test,
                new SoundBoardAction( SoundBoardAction.Event.SHOW_VOICE_INPUT_DIALOG, this )
            );
        }

        @Override
        public boolean onKeyDown( int keyCode, KeyEvent event )
        {
            switch ( keyCode )
            {
                case KeyEvent.KEYCODE_BACK:
                {
                    new SoundBoardAction( SoundBoardAction.Event.RETURN_TO_WELCOME_ACTIVITY, this ).run();

                    //prevent this event from being propagated further
                    return true;
                }
            }

            //let the system handle this event
            return false;
        }

        @Override
        protected void onActivityResult( int requestCode, int resultCode, Intent data )
        {
            SoundBoardDebug.major.out(
                "onActivityResult in TestScreen Activity .. [" + requestCode + "][" + resultCode + "][" + data + "]"
            );

            //blur button
            this.findViewById( R.id.button_voice_input ).setSelected( false );

            switch ( requestCode )
            {
                case REQUEST_CODE_RECORD_AUDIO:
                {
                    SoundBoardDebug.major.out("Response from audio recorder ..");

                    if (resultCode == Activity.RESULT_OK)
                    {
                        SoundBoardDebug.major.out("Received correct audio.");

                        ArrayList<String> matches = data.getStringArrayListExtra( RecognizerIntent.EXTRA_RESULTS );

                        for ( String match : matches )
                        {
                            SoundBoardDebug.major.out("[" + match + "]");

                            if ( match.equalsIgnoreCase( "ich greife an" ) )
                            {
                                SoundBoardDebug.major.out("Play sound 'attack'");
                                LibSound.playSound( this, R.raw.sound_attack );
                                break;
                            }
                            else if ( match.equalsIgnoreCase( "ich ziehe mich zurück" ) )
                            {
                                SoundBoardDebug.major.out("Play sound 'retreat'");
                                LibSound.playSound( this, R.raw.sound_retreat );
                                break;
                            }
                            else if ( match.equalsIgnoreCase( "ich gebe auf" ) )
                            {
                                SoundBoardDebug.major.out("Play sound 'resign'");
                                LibSound.playSound( this, R.raw.sound_resign );
                                break;
                            }
                        }
                    }
                    else
                    {
                        SoundBoardDebug.major.out("Received error code from audio activity.");
                    }
                    break;
                }
            }
        }
    }
