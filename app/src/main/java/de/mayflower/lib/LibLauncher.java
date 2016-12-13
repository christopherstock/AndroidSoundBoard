
    package de.mayflower.lib;

    import  android.app.Activity;
    import  android.content.Intent;

    /*********************************************************************************
    *   Launches internal or external system activities.
    *
    *   @author     Christopher Stock
    *   @version    1.0
    *********************************************************************************/
    public abstract class LibLauncher
    {
        /*********************************************************************************
        *   Launches another Activity of the current application package.
        *
        *   @param  activity                The according activity context.
        *   @param  activityClassToLaunch   The Activity class of the Activity to start.
        *   @param  animIn                  The resource-ID of the animation for the new Activity to appear.
        *   @param  animOut                 The resource-ID of the animation for the old Activity to disappear.
        *********************************************************************************/
        public static final void launchActivity( Activity activity, Class<?> activityClassToLaunch, int animIn, int animOut )
        {
            //only launch if activity classes differ
            if ( !activity.getClass().equals( activityClassToLaunch ) )
            {
                //create activity launch intent and start it
                Intent launchActivity = new Intent(activity, activityClassToLaunch);
                activity.startActivity(launchActivity);

                //set animation if desired
                if ((animIn != -1) && (animOut != -1)) {
                    Lib.overridePendingTransition(activity, animIn, animOut);
                }
            }
        }
    }
