
    package de.mayflower.soundboard.state;

    import  android.graphics.Typeface;
    import  android.os.Bundle;
    import  android.view.View;
    import  android.view.ViewGroup;
    import  android.widget.TextView;
    import  de.mayflower.lib.ui.LibUI;
    import  de.mayflower.soundboard.R;
    import  de.mayflower.soundboard.SoundBoardAction;
    import  de.mayflower.soundboard.state.activity.SoundBoardActivity;
    import  de.mayflower.soundboard.ui.SoundBoardFont;

    /**********************************************************************************************
    *   The settings activity.
    *
    *   @author     Christopher Stock
    *   @version    1.0
    ***********************************************************************************************/
    public class SoundBoardSettings extends SoundBoardActivity
    {
        /** Number of dummy items to create in the 'settings' screen. */
        public          static          final           int             NUMBER_OF_TEST_ITEMS    = 20;

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

            this.addSettingsItems();
        }

        /*****************************************************************************
        *   Dynamically adds all settings items to the settings activity.
        *
        *   In state alpha, only three constant and unclickable items so far.
        *****************************************************************************/
        private void addSettingsItems()
        {
            ViewGroup settingsContainer = (ViewGroup)this.findViewById( R.id.settings_container );
            Typeface  typeface          = SoundBoardFont.TYPEFACE_MYRIAD_PRO_REGULAR.getTypeface( this );

            for (int i = 0; i < NUMBER_OF_TEST_ITEMS; ++i )
            {
                View     item      = LibUI.getInflatedLayoutById( this, R.layout.item_settings );
                View     separator = LibUI.getInflatedLayoutById( this, R.layout.item_separator );
                TextView textView  = (TextView)item.findViewById( R.id.text_item );

                LibUI.setupTextView
                (
                    textView,
                    "Settings item " + i,
                    typeface
                );

                LibUI.setOnClickAction
                (
                    textView,
                    new SoundBoardAction( SoundBoardAction.Event.NOTHING, this ),
                    false
                );

                settingsContainer.addView( item );

                if ( i < ( NUMBER_OF_TEST_ITEMS - 1 ) )
                {
                    settingsContainer.addView( separator );
                }
            }
        }
    }
