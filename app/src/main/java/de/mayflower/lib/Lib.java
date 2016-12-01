
    package de.mayflower.lib;

    import  android.app.Activity;

    /*********************************************************************************
    *   Determines device api.
    *
    *   @author     Christopher Stock
    *   @version    1.0
    *********************************************************************************/
    public abstract class Lib
    {
        /*********************************************************************************
        *   Sets up a transition animation from the current to a different activity.
        *   This method must be invoked AFTER the different activity has been started!
        *
        *   @param  activity    The according activity context.
        *   @param  animIn      The resource-ID of the animation for the new activity to appear.
        *   @param  animOut     The resource-ID of the animation for the old activity to disappear.
        *********************************************************************************/
        public static final void overridePendingTransition(Activity activity, int animIn, int animOut )
        {
            activity.overridePendingTransition( animIn, animOut );
        }

        /*********************************************************************************
        *   Checks if this device's API-Level is lower than given API-Level.
        *   The field {@link android.os.Build.VERSION#SDK_INT} is read to determine this.
        *
        *   @param apiLevel The API level to check.
        *   @return         true if this device uses an API-Level lower than specified.
        *                   Otherwise false.
        *********************************************************************************/
        public static final boolean isSdkLevelLowerThan( int apiLevel )
        {
            return ( android.os.Build.VERSION.SDK_INT < apiLevel );
        }
    }
