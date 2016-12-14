
    package de.mayflower.lib.io;

    import  android.content.Context;
    import  android.graphics.Typeface;

    /*********************************************************************************
    *   Manages input and output streams.
    *
    *   @author     Christopher Stock
    *   @version    1.0
    *********************************************************************************/
    public abstract class LibIO
    {
        /************************************************************************
         *   Returns the Typeface with the specified resource name from the 'asset'-folder.
         *
         *   @param  context     The current system context.
         *   @param  assetName   The resource name of the font-file in the 'asset'-folder.
         *   @return             The read Typeface.
         ************************************************************************/
        public static final Typeface createTypefaceFromAsset( Context context, String assetName )
        {
            return Typeface.createFromAsset( context.getAssets(), assetName );
        }
    }
