
    package de.mayflower.soundboard.state.activities;

    import  android.support.v7.app.AppCompatActivity;

    import de.mayflower.soundboard.SoundBoardAction;

    /**********************************************************************************************
    *   The startup activity class.
    *
    *   @author     Christopher Stock
    *   @version    1.0
     ***********************************************************************************************/
    public abstract class SoundBoardActivity extends AppCompatActivity
    {
        private             SoundBoardAction.Event              backKeyEvent                = null;

        protected SoundBoardActivity( SoundBoardAction.Event backKeyEvent )
        {
            this.backKeyEvent = backKeyEvent;
        }
    }
