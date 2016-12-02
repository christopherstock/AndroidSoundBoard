
    package de.mayflower.soundboard.state;

    import  android.app.Activity;
    import  android.os.Bundle;
    import  android.view.MotionEvent;
    import  de.mayflower.lib.Lib;
    import  de.mayflower.soundboard.R;
    import  de.mayflower.soundboard.SoundBoardDebug;

    /**********************************************************************************************
    *   The details screen that contains the detailed anti pattern description.
    *
    *   @author     Christopher Stock
    *   @version    1.0
    ***********************************************************************************************/
    public class SoundBoardDetailScreen extends Activity
    {
        static final int MIN_SWIPE_DISTANCE = 150;

        private float touchStartX           = 0;
        private float touchEndX             = 0;
        private static final String ARG_ITEM_ID = "pattern_id";

        /*****************************************************************************
         * Being invoked when this activity is being created.
         *****************************************************************************/
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            //invoke super method
            super.onCreate(savedInstanceState);

            SoundBoardDebug.major.out(SoundBoardDetailScreen.class + "::onCreate()");

            //setContentView( R.layout.SoundBoard_detail_screen );
/*
            LayoutInflater inflater = this.getLayoutInflater();
            View rootView = inflater.inflate(R.layout.SoundBoard_detail_screen, null, false);
            TextView titleview = (TextView)rootView.findViewById(R.id.detail_view_title);
            TextView symptomview = (TextView)rootView.findViewById(R.id.detail_view_symptoms);
            TextView remedyview = (TextView)rootView.findViewById(R.id.detail_view_remedies);

            Pattern pattern = SoundBoardHydrator.getCurrentPattern();
            titleview.setText(pattern.getName());
            String[] symptoms = pattern.getSymptomps();
            String symptomtext = "";
            for ( int i=0; i < symptoms.length; i++ ) {
                symptomtext = symptomtext + "• " + symptoms[i] + "\n";
            }
            symptomview.setText(symptomtext);
            String[] remedies = pattern.getRemedies();
            String remedytext = "";
            for ( int i=0; i < remedies.length; i++ ) {
                remedytext = remedytext + "• " + remedies[i] + "\n";
            }
            remedyview.setText(remedytext);

            this.setContentView(rootView);
*/
        }

        /*****************************************************************************
         * Being invoked after this activity has been created and on returning.
         *****************************************************************************/
        @Override
        public void onStart()
        {
            //invoke super method
            super.onStart();

            SoundBoardDebug.major.out( SoundBoardDetailScreen.class + "::onStart()" );
        }

        @Override
        public void onBackPressed()
        {
            super.onBackPressed();
            this.animateTransition();
        }

        @Override
        public boolean onTouchEvent(MotionEvent event)
        {
            switch(event.getAction())
            {
                case MotionEvent.ACTION_DOWN:
                    this.touchStartX = event.getX();
                    break;
                case MotionEvent.ACTION_UP:
                    this.touchEndX = event.getX();

                    float deltaX = this.touchEndX - this.touchStartX;

                    if (deltaX > SoundBoardDetailScreen.MIN_SWIPE_DISTANCE) {
                        super.onBackPressed();
                        this.animateTransition();
                    }

                    break;
                default:
                    break;
            }
            return super.onTouchEvent(event);
        }


        private void animateTransition()
        {
            Lib.overridePendingTransition
            (
                                this,
                                R.anim.push_right_in,
                                R.anim.push_right_out
            );
        }
    }
