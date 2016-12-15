
    package de.mayflower.lib;

    import  android.app.Activity;
    import  android.content.Intent;

    /*******************************************************************************************************************
    *   Launches internal or external system activities.
    *
    *   @author     Christopher Stock
    *   @version    0.0.1
    *******************************************************************************************************************/
    public abstract class LibLauncher
    {
        /***************************************************************************************************************
        *   Launches another Activity of the current application package.
        *
        *   @param  from    The according activity context.
        *   @param  to      The Activity class of the Activity to start.
        *   @param  animIn  The resource-ID of the animation for the new Activity to appear.
        *   @param  animOut The resource-ID of the animation for the old Activity to disappear.
        ***************************************************************************************************************/
        public static final void launchActivity( Activity from, Class<?> to, int animIn, int animOut )
        {
            //only launch if activity classes differ
            if ( !from.getClass().equals( to ) )
            {
                //create activity launch intent and start it
                Intent launchActivity = new Intent( from, to );
                from.startActivity(launchActivity);

                //set animation if desired
                if ((animIn != -1) && (animOut != -1)) {
                    Lib.overridePendingTransition(from, animIn, animOut);
                }
            }
        }
    }
