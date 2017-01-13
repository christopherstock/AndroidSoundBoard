
    package de.mayflower.soundboard.ui;

    import  android.app.Activity;
    import  android.app.AlertDialog;
    import  android.content.DialogInterface;
    import  android.view.ViewGroup;
    import  android.widget.ImageView;
    import  android.widget.TextView;
    import  de.mayflower.lib.ui.LibUI;
    import  de.mayflower.soundboard.R;

    /*******************************************************************************************************************
    *   Builds a custom about dialog.
    *
    *   @author     Christopher Stock
    *   @version    1.0.0
    *******************************************************************************************************************/
    public abstract class SoundBoardDialogAbout
    {
        /***************************************************************************************************************
        *   Shows a custom dialog.
        *
        *   @param  activity                The current system context.
        *   @param  dialogLayoutID          The layout-resource-ID of the layout to use for this dialog.
        *   @param  titleID                 The string-resource-ID for this dialog's title.
        *   @param  body                    The Strings for the labels above the input-fields.
        *                                   This array's length doesn't have to equal the length of the inputFieldIDs.
        *   @param  buttonCaption1ID        The string-resource-ID for the 1st button's caption.
        *   @param  buttonAction1           The action to perform if the 1st button is pressed.
        *   @param  cancelable              Specifies if this dialog can be canceled via the back button.
        *   @param  cancelAction            The action to perform if this dialog is canceled.
        ***************************************************************************************************************/
        public static final void show
        (
                  Activity     activity,
                  int          dialogLayoutID,
                  int          titleID,
                  String       body,
                  int          buttonCaption1ID,
            final Runnable     buttonAction1,
                  boolean      cancelable,
            final Runnable     cancelAction
        )
        {
            //reference layout
            ViewGroup layout    = (ViewGroup)LibUI.getInflatedLayoutById( activity, dialogLayoutID );

            LibUI.setupTextView
            (
                (TextView)layout.findViewById( R.id.text_dialog_about ),
                body,
                SoundBoardFont.TYPEFACE_MYRIAD_PRO_REGULAR.getTypeface( activity )
            );

            LibUI.setupAnimatedImageView
            (
                (ImageView)layout.findViewById( R.id.image_title_logo ),
                R.drawable.title_logo
            );

            //create dialog builder
            AlertDialog.Builder iBuilder = new AlertDialog.Builder( activity );
            iBuilder.setCancelable( cancelable );
            iBuilder.setTitle( titleID );

            //assign inflated layout view
            iBuilder.setView( layout );

            //set positive button if available
            if ( buttonAction1 != null )
            {
                iBuilder.setPositiveButton
                (
                    buttonCaption1ID,
                    new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick( DialogInterface dialog, int which )
                        {
                            //perform action on close
                            buttonAction1.run();

                            //dismiss dialog
                            dialog.dismiss();
                        }
                    }
                );
            }

            //set cancel-action if available
            if ( cancelable )
            {
                iBuilder.setOnCancelListener
                (
                    new DialogInterface.OnCancelListener()
                    {
                        @Override
                        public void onCancel( DialogInterface dialog )
                        {
                            //perform cancel-action
                            cancelAction.run();
                        }
                    }
                );
            }

            //create and show
            AlertDialog dialog = iBuilder.create();
            dialog.show();
        }
    }
