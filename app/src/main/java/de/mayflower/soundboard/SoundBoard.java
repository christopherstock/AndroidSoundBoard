
    package de.mayflower.soundboard;

    import  android.support.v7.app.AppCompatActivity;
    import  android.os.Bundle;

    /*******************************************************************************************
    *   The main activity of the SoundBoard application.
    *
    *   @author  Christopher Stock
    *   @version 1.0
    *******************************************************************************************/
    public class SoundBoard extends AppCompatActivity
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

            setContentView(R.layout.activity_sound_board);
        }
    }
