
    package de.mayflower.lib;

    import  android.app.*;
    import  android.content.*;

    /*******************************************************************************************************************
    *   Determines device api.
    *
    *   @author     Christopher Stock
    *   @version    0.0.1
    *******************************************************************************************************************/
    public abstract class Lib
    {
        /***************************************************************************************************************
        *   Sets up a transition animation from the current to a different activity.
        *   This method must be invoked AFTER the different activity has been started!
        *
        *   @param  activity    The according activity context.
        *   @param  animIn      The resource-ID of the animation for the new activity to appear.
        *   @param  animOut     The resource-ID of the animation for the old activity to disappear.
        ***************************************************************************************************************/
        public static final void overridePendingTransition( Activity activity, int animIn, int animOut )
        {
            activity.overridePendingTransition( animIn, animOut );
        }

        /***************************************************************************************************************
        *   Launches the Android Homescreen Activity. This will show the user's
        *   homescreen immediately and pushes this application in the background.
        *
        *   @param  context The current application context.
        ***************************************************************************************************************/
        public static final void showHomescreenActivity( Context context )
        {
            Intent intent = new Intent();
            intent.setAction(   Intent.ACTION_MAIN      );
            intent.addCategory( Intent.CATEGORY_HOME    );

            context.startActivity( intent );
        }

        /***************************************************************************************************************
        *   Checks if the specified service class is running.
        *
        *   @param context      The current system service.
        *   @param serviceClass The service class to check running state.
        *   @return             true if the specified service is running.
        ***************************************************************************************************************/
        public static boolean isServiceRunning( Context context, Class<?> serviceClass )
        {
            ActivityManager manager = (ActivityManager)context.getSystemService( Context.ACTIVITY_SERVICE );
            for ( ActivityManager.RunningServiceInfo service : manager.getRunningServices( Integer.MAX_VALUE ) )
            {
                if ( serviceClass.getName().equalsIgnoreCase( service.service.getClassName() ) )
                {
                    return true;
                }
            }

            return false;
        }
    }
