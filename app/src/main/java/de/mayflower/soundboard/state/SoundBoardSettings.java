
    package de.mayflower.soundboard.state;

    import  android.os.Bundle;
    import  de.mayflower.soundboard.R;
    import  de.mayflower.soundboard.SoundBoardAction;
    import de.mayflower.soundboard.state.activity.SoundBoardActivity;

    /**********************************************************************************************
    *   The settings activity.
    *
    *   @author     Christopher Stock
    *   @version    1.0
    ***********************************************************************************************/
    public class SoundBoardSettings extends SoundBoardActivity
    {
        /*******************************************************************************************
        *   Creates a new Activity specifying the backKey event.
        *******************************************************************************************/
        public SoundBoardSettings()
        {
            super
            (
                SoundBoardAction.Event.RETURN_TO_ACTIVITY_WELCOME,
                SoundBoardActivity.ShowBackButton.YES,
                SoundBoardActivity.ShowMenuButton.YES
            );
        }

        /*****************************************************************************
        *   Being invoked when this activity is being created.
        *****************************************************************************/
        @Override
        protected void onCreate( Bundle savedInstanceState )
        {
            super.onCreate( savedInstanceState );

            this.setContentView( R.layout.activity_settings );
        }
    }
