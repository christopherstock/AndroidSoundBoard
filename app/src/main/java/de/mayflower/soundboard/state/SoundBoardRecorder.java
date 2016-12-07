
    package de.mayflower.soundboard.state;

    import  android.app.Activity;
    import  android.content.Intent;
    import  android.os.Bundle;
    import  android.speech.RecognizerIntent;
    import  java.util.ArrayList;
    import  de.mayflower.lib.ui.LibUI;
    import  de.mayflower.soundboard.R;
    import  de.mayflower.soundboard.SoundBoardAction;
    import  de.mayflower.soundboard.SoundBoardDebug;
    import  de.mayflower.soundboard.service.SoundBoardPlaybackService;
    import  de.mayflower.soundboard.state.activities.SoundBoardActivity;

    /*******************************************************************************************
    *   The recorder activity.
    *
    *   @author     Christopher Stock
    *   @version    1.0
    *******************************************************************************************/
    public class SoundBoardRecorder extends SoundBoardActivity
    {
        /** The request id for the external activity 'speech recognizer'. */
        public      static  final   int             REQUEST_CODE_RECORD_AUDIO       = 1;

        /*******************************************************************************************
        *   Creates a new Activity specifying the backKey event.
        *******************************************************************************************/
        public SoundBoardRecorder()
        {
            super( SoundBoardAction.Event.RETURN_TO_ACTIVITY_WELCOME, true, true );
        }

        /*******************************************************************************************
        *   Being invoked when the application starts and resumes.
        *
        *   @param savedInstanceState The data bundle being passed if any.
        *******************************************************************************************/
        @Override
        protected void onCreate(Bundle savedInstanceState)
        {
            super.onCreate( savedInstanceState );

            this.setContentView( R.layout.activity_recorder );

            LibUI.setupButton
            (
                this,
                R.id.button_test,
                R.string.button_back,
                new SoundBoardAction( SoundBoardAction.Event.RETURN_TO_ACTIVITY_WELCOME, this )
            );

            LibUI.setupButton
            (
                this,
                R.id.button_voice_input,
                R.string.button_show_voice_input,
                new SoundBoardAction( SoundBoardAction.Event.SHOW_VOICE_INPUT_DIALOG, this )
            );

            LibUI.setupTextView
            (
                this,
                R.id.text_recorder,
                R.string.text_recorder
            );
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

                        SoundBoardPlaybackService service = new SoundBoardPlaybackService();
                        service.handleReceivedSpeechStrings( this, matches.toArray( new String[] {} ) );
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
