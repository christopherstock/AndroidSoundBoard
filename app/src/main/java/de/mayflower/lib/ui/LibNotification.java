
    package de.mayflower.lib.ui;

    import  android.app.NotificationManager;
    import  android.app.PendingIntent;
    import  android.content.Context;
    import  android.content.Intent;
    import  android.support.v4.app.NotificationCompat;

    /*******************************************************************************************************************
    *   Offers system notifications.
    *
    *   @author     Christopher Stock
    *   @version    0.0.1
    *******************************************************************************************************************/
    public abstract class LibNotification
    {
        /***************************************************************************************************************
        *   Creates and shows a notification.
        *
        *   @param context       The current system context.
        *   @param iconId        Id of the icon to show in this notification.
        *   @param title         The notification's title text.
        *   @param body          The notification's body text.
        *   @param messageId     The ID of this notification.
        *   @param intentOnClick The intent to perform if this notification is clicked.
        ***************************************************************************************************************/
        public static final void show( Context context, int iconId, String title, String body, int messageId, Intent intentOnClick )
        {
            NotificationCompat.Builder notificationBuiler = new NotificationCompat.Builder( context );
            notificationBuiler.setSmallIcon( iconId );
            notificationBuiler.setContentTitle( title );
            notificationBuiler.setContentText( body );

            PendingIntent pendingIntent = PendingIntent.getActivity(
                context,
                0,
                intentOnClick,
                PendingIntent.FLAG_UPDATE_CURRENT
            );

            notificationBuiler.setContentIntent( pendingIntent );

            NotificationManager notificationManager = (NotificationManager) context.getSystemService( Context.NOTIFICATION_SERVICE );

            notificationManager.notify( messageId, notificationBuiler.build() );
        }

        /***************************************************************************************************************
        *   Hides the notification with the specified id.
        *
        *   @param context       The current system context.
        *   @param messageId     The ID of the notification to hide.
        ***************************************************************************************************************/
        public static final void hide( Context context, int messageId )
        {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService( Context.NOTIFICATION_SERVICE );

            notificationManager.cancel( messageId );
        }
    }
