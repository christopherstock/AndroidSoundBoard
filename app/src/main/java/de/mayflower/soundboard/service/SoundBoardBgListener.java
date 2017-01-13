
    package de.mayflower.soundboard.service;

    import  android.app.Service;
    import  android.content.Intent;
    import  android.os.Bundle;
    import  android.os.IBinder;
    import  android.speech.RecognitionListener;
    import  android.speech.RecognizerIntent;
    import  android.speech.SpeechRecognizer;
    import  android.support.annotation.Nullable;
    import  java.util.ArrayList;
    import  de.mayflower.lib.ui.LibNotification;
    import  de.mayflower.soundboard.R;
    import  de.mayflower.soundboard.SoundBoardDebug;
    import  de.mayflower.soundboard.SoundBoardSettings;
    import  de.mayflower.soundboard.state.SoundBoardWelcome;

    /*******************************************************************************************************************
    *   The background service that listens for speech input.
    *
    *   @author     Christopher Stock.
    *   @version    0.0.1
    *******************************************************************************************************************/
    public class SoundBoardBgListener extends Service implements RecognitionListener
    {
        /** The speech recognizer instance. */
        private                         SpeechRecognizer        speechRecognizer                    = null;

        /** Specifies if this service is destroyed. */
        private                         boolean                 serviceIsDestroyed                  = false;

        @Override
        public void onCreate()
        {
            super.onCreate();
            SoundBoardDebug.bgListener.out( "> Service onCreate" );

            this.serviceIsDestroyed = false;

            SoundBoardDebug.bgListener.out( "> Show notification" );
            LibNotification.show
            (
                this,
                R.drawable.notification_icon,
                "SoundBoard listening",
                "SoundBoard is listening in background.",
                SoundBoardSettings.Notification.NOTIFICATION_ID_BG_SERVICE_RUNNING_INFO,
                new Intent( this, SoundBoardWelcome.class )
            );

            this.createAndStartSpeechRecognizer();
        }

        @Override
        public void onDestroy()
        {
            super.onDestroy();
            SoundBoardDebug.bgListener.out( "> Service onDestroy" );

            this.serviceIsDestroyed = true;

            SoundBoardDebug.bgListener.out( "> Show notification" );
            LibNotification.hide( this, SoundBoardSettings.Notification.NOTIFICATION_ID_BG_SERVICE_RUNNING_INFO );

            this.speechRecognizer.stopListening();
        }

        @Nullable
        @Override
        public IBinder onBind(Intent intent)
        {
            return null;
        }

        @Override
        public void onReadyForSpeech( Bundle params )
        {
            SoundBoardDebug.bgListener.out( "> Listener onReadyForSpeech" );
        }

        @Override
        public void onBeginningOfSpeech()
        {
            SoundBoardDebug.bgListener.out( "> Listener onBeginningOfSpeech" );
        }

        @Override
        public void onRmsChanged( float rmsdB )
        {
            //SoundBoardDebug.bgListener.out( "> Listener onRmsChanged" );
        }

        @Override
        public void onBufferReceived( byte[] buffer )
        {
            //SoundBoardDebug.bgListener.out( "> Listener onBufferReceived" );

            // no readable output!
            //SoundBoardDebug.bgListener.out( " > " + new String(buffer) );
        }

        @Override
        public void onEndOfSpeech()
        {
            SoundBoardDebug.bgListener.out( "> Listener onEndOfSpeech" );
        }

        @Override
        public void onError( int error )
        {
            SoundBoardDebug.bgListener.out( "> Listener onError [" + error + "]" );

            this.createAndStartSpeechRecognizer();
        }

        @Override
        public void onResults( Bundle results )
        {
            SoundBoardDebug.bgListener.out( "> Listener onResults" );

            this.handleResults( results );

            this.createAndStartSpeechRecognizer();
        }

        @Override
        public void onPartialResults( Bundle partialResults )
        {
            SoundBoardDebug.bgListener.out( "> Listener onPartialResults" );

            this.handleResults( partialResults );
        }

        @Override
        public void onEvent( int eventType, Bundle params )
        {
            SoundBoardDebug.bgListener.out( "> Listener onEvent" );
        }

        /***************************************************************************************************************
        *   Shows received speech results.
        *
        *   @param results The bundled data.
        ***************************************************************************************************************/
        private void handleResults( Bundle results )
        {
            ArrayList<String> matchesList = results.getStringArrayList( SpeechRecognizer.RESULTS_RECOGNITION );

            if ( matchesList != null )
            {
                String[] matches = matchesList.toArray(new String[]{});

                //SoundBoardSpeechRecognizer service = new SoundBoardSpeechRecognizer();
                //service.handleReceivedSpeechStrings( this, matches.toArray( new String[ matches.size() ] ) );

                for ( String match : matches )
                {
                    SoundBoardDebug.bgListener.out( " > [" + match + "]" );
                }
            }
        }

        /***************************************************************************************************************
        *   Created and starts or restarts the speech recognizer.
        ***************************************************************************************************************/
        private void createAndStartSpeechRecognizer()
        {
            if ( !this.serviceIsDestroyed )
            {
                Intent recognizerIntent = new Intent( RecognizerIntent.ACTION_RECOGNIZE_SPEECH );

                recognizerIntent.putExtra( RecognizerIntent.EXTRA_MAX_RESULTS, 10 );
                recognizerIntent.putExtra( RecognizerIntent.EXTRA_CALLING_PACKAGE, this.getPackageName() );

                recognizerIntent.putExtra( RecognizerIntent.EXTRA_SPEECH_INPUT_COMPLETE_SILENCE_LENGTH_MILLIS, 100 );

                recognizerIntent.putExtra( RecognizerIntent.EXTRA_LANGUAGE,       "de-DE" );
                recognizerIntent.putExtra( RecognizerIntent.EXTRA_LANGUAGE_MODEL, "de-DE" );
/*
                recognizerIntent.putExtra( RecognizerIntent.EXTRA_SPEECH_INPUT_MINIMUM_LENGTH_MILLIS, 100 );
                recognizerIntent.putExtra( RecognizerIntent.EXTRA_SPEECH_INPUT_POSSIBLY_COMPLETE_SILENCE_LENGTH_MILLIS, 1000 );
                recognizerIntent.putExtra( "android.speech.extra.DICTATION_MODE", true );
*/

                if ( this.speechRecognizer == null )
                {
                    this.speechRecognizer = SpeechRecognizer.createSpeechRecognizer( this.getApplicationContext() );
                    this.speechRecognizer.setRecognitionListener(this);
                }

                this.speechRecognizer.startListening( recognizerIntent );
            }
        }
    }
