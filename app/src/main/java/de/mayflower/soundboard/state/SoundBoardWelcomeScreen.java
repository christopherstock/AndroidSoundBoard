
    package de.mayflower.soundboard.state;

    import  android.os.Bundle;
    import  android.support.v7.app.AppCompatActivity;

    import de.mayflower.soundboard.R;

    /*******************************************************************************************
    *   The main activity of the SoundBoardWelcomeScreen application.
    *
    *   @author  Christopher Stock
    *   @version 1.0
    *******************************************************************************************/
    public class SoundBoardWelcomeScreen extends AppCompatActivity
    {
        /*******************************************************************************************
        *   Being invoked when the application starts and resumes.
        *
        *   @param savedInstanceState The data bundle being passed if any.
        *******************************************************************************************/
        @Override
        protected void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);

            this.setContentView(R.layout.activity_sound_board);
        }
    }
