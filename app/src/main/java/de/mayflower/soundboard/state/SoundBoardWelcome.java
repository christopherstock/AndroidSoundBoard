
    package de.mayflower.soundboard.state;

    import  android.os.Bundle;
    import  android.view.View;
    import  android.widget.ImageView;
    import  de.mayflower.lib.Lib;
    import  de.mayflower.lib.ui.LibUI;
    import  de.mayflower.soundboard.R;
    import  de.mayflower.soundboard.SoundBoardAction;
    import  de.mayflower.soundboard.service.SoundBoardBgListener;
    import  de.mayflower.soundboard.state.activity.SoundBoardActivity;
    import  de.mayflower.soundboard.ui.SoundBoardFont;

    /*******************************************************************************************************************
    *   The main activity of the SoundBoardWelcome application.
    *
    *   @author     Christopher Stock
    *   @version    0.0.1
    *******************************************************************************************************************/
    public class SoundBoardWelcome extends SoundBoardActivity
    {
        /***************************************************************************************************************
        *   Creates a new Activity specifying the backKey event.
        ***************************************************************************************************************/
        public SoundBoardWelcome()
        {
            super
            (
                SoundBoardAction.Event.SHOW_HOMESCREEN,
                SoundBoardActivity.ShowBackButton.NO,
                SoundBoardActivity.ShowMenuButton.YES
            );
        }

        /***************************************************************************************************************
        *   Being invoked when the application starts and resumes.
        *
        *   @param savedInstanceState The data bundle being passed if any.
        ***************************************************************************************************************/
        @Override
        protected void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);

            this.setContentView( R.layout.activity_welcome );

            LibUI.setupButton
            (
                this,
                R.id.button_start_listener_service,
                R.string.button_start_bg_listener_service,
                new SoundBoardAction( SoundBoardAction.Event.TEST_START_BG_SERVICE, this ),
                SoundBoardFont.TYPEFACE_MYRIAD_PRO_REGULAR.getTypeface( this )
            );

            LibUI.setupButton
            (
                this,
                R.id.button_stop_listener_service,
                R.string.button_stop_bg_listener_service,
                new SoundBoardAction( SoundBoardAction.Event.TEST_STOP_BG_SERVICE, this ),
                SoundBoardFont.TYPEFACE_MYRIAD_PRO_REGULAR.getTypeface( this )
            );

            LibUI.setupButton
            (
                this,
                R.id.button_show_viewpager,
                R.string.button_show_viewpager,
                new SoundBoardAction( SoundBoardAction.Event.ENTER_ACTIVITY_VIEWPAGER, this ),
                SoundBoardFont.TYPEFACE_MYRIAD_PRO_REGULAR.getTypeface( this )
            );

            LibUI.setupButton
            (
                this,
                R.id.button_show_tabbedpane,
                R.string.button_show_tabbedpane,
                new SoundBoardAction( SoundBoardAction.Event.ENTER_ACTIVITY_TABBEDPANE, this ),
                SoundBoardFont.TYPEFACE_MYRIAD_PRO_REGULAR.getTypeface( this )
            );

            if ( Lib.isServiceRunning( this, SoundBoardBgListener.class ) )
            {
                this.startRecorder();
            }
            else
            {
                this.stopRecorder();
            }
        }

        /***************************************************************************************************************
        *   Alters UI components when the recorder is started.
        ***************************************************************************************************************/
        public void startRecorder()
        {
            this.findViewById( R.id.button_start_listener_service ).setVisibility( View.GONE    );
            this.findViewById( R.id.button_stop_listener_service  ).setVisibility( View.VISIBLE );
            this.findViewById( R.id.button_start_listener_service ).setSelected( false );

            ( (ImageView)this.findViewById( R.id.image_title_splash ) ).setImageResource( R.drawable.title_splash_recording );
        }

        /***************************************************************************************************************
        *   Alters UI components when the recorder is stopped.
        ***************************************************************************************************************/
        public void stopRecorder()
        {
            this.findViewById( R.id.button_start_listener_service ).setVisibility( View.VISIBLE );
            this.findViewById( R.id.button_stop_listener_service  ).setVisibility( View.GONE    );
            this.findViewById( R.id.button_stop_listener_service  ).setSelected( false );

            ( (ImageView)this.findViewById( R.id.image_title_splash ) ).setImageResource( R.drawable.title_splash_default);
        }
    }
