
    package de.mayflower.soundboard.service;

    import android.app.Service;
    import  android.content.Intent;
    import  android.os.Bundle;
    import android.os.IBinder;
    import  android.speech.RecognitionListener;
    import  android.speech.RecognitionService;
    import android.speech.RecognizerIntent;
    import  android.speech.SpeechRecognizer;
    import android.support.annotation.Nullable;

    import  de.mayflower.soundboard.SoundBoardDebug;

    /*******************************************************************************************************************
    *   The background service that listens for speech input.
    *
    *   @author     Christopher Stock.
    *   @version    0.0.1
    *******************************************************************************************************************/
    public class SoundBoardBgListener extends /* RecognitionService */ Service implements RecognitionListener
    {
        /** The speech recognizer instance. */
        private SpeechRecognizer speechRecognizer = null;

        @Override
        public void onCreate()
        {
            super.onCreate();

SoundBoardDebug.bgListener.out("> Service onCreate");

            this.speechRecognizer = SpeechRecognizer.createSpeechRecognizer( this.getApplicationContext() );

SoundBoardDebug.bgListener.out("> Check 1");


            Intent recognizerIntent = new Intent( RecognizerIntent.ACTION_RECOGNIZE_SPEECH );
            recognizerIntent.putExtra("android.speech.extra.DICTATION_MODE", true);
            recognizerIntent.putExtra( RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM );
            // accept partial results if they come
            recognizerIntent.putExtra( RecognizerIntent.EXTRA_PARTIAL_RESULTS, true );



     Intent recognizerIntent2 = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        recognizerIntent2.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        recognizerIntent2.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, "en-US");
        recognizerIntent2.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS,1);
        recognizerIntent2.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE,this.getPackageName());


/*
            recognizerIntent.putExtra
            (
                RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM
            );
*/
SoundBoardDebug.bgListener.out("> Check 2");

/*
            // accept partial results if they come
            recognizerIntent.putExtra( RecognizerIntent.EXTRA_PARTIAL_RESULTS, true );
*/

SoundBoardDebug.bgListener.out("> Check 3");

            this.speechRecognizer.setRecognitionListener(this);

SoundBoardDebug.bgListener.out("> Check 4");

            this.speechRecognizer.startListening( recognizerIntent2 );

SoundBoardDebug.bgListener.out("> Check 5");
        }

        @Override
        public void onDestroy()
        {
            super.onDestroy();

            SoundBoardDebug.bgListener.out("> Service onDestroy");
        }



        @Nullable
        @Override
        public IBinder onBind(Intent intent)
        {
            return null;
        }
/*
        @Override
        protected void onCancel( RecognitionService.Callback listener )
        {
            SoundBoardDebug.bgListener.out("> Service onCancel");

            this.speechRecognizer.cancel();
        }

        @Override
        protected void onStartListening( Intent recognizerIntent, RecognitionService.Callback listener )
        {
            SoundBoardDebug.bgListener.out("> Service onStartListening");

            this.speechRecognizer.setRecognitionListener(this);
            this.speechRecognizer.startListening(recognizerIntent);
        }

        @Override
        protected void onStopListening( RecognitionService.Callback listener )
        {
            SoundBoardDebug.bgListener.out("> Service onStopListening");

            this.speechRecognizer.stopListening();
        }
*/




        @Override
        public void onReadyForSpeech( Bundle params )
        {
            SoundBoardDebug.bgListener.out("> Listener onReadyForSpeech");
        }

        @Override
        public void onBeginningOfSpeech()
        {
            SoundBoardDebug.bgListener.out("> Listener onBeginningOfSpeech");
        }

        @Override
        public void onRmsChanged( float rmsdB )
        {
            SoundBoardDebug.bgListener.out("> Listener onRmsChanged");
        }

        @Override
        public void onBufferReceived( byte[] buffer )
        {
            SoundBoardDebug.bgListener.out("> Listener onBufferReceived");
        }

        @Override
        public void onEndOfSpeech()
        {
            SoundBoardDebug.bgListener.out("> Listener onEndOfSpeech");
        }

        @Override
        public void onError( int error )
        {
            SoundBoardDebug.bgListener.out("> Listener onError [" + error + "]");
        }

        @Override
        public void onResults( Bundle results )
        {
            SoundBoardDebug.bgListener.out("> Listener onResults");
        }

        @Override
        public void onPartialResults( Bundle partialResults )
        {
            SoundBoardDebug.bgListener.out("> Listener onPartialResults");
        }

        @Override
        public void onEvent( int eventType, Bundle params )
        {
            SoundBoardDebug.bgListener.out("> Listener onEvent");
        }
    }
