
    package de.mayflower.soundboard.ui;

    import  android.content.Context;
    import  android.graphics.Typeface;
    import  de.mayflower.lib.io.LibIO;

    /*******************************************************************************************************************
    *   Lazy loads all required custom typefaces.
    *
    *   @author     Christopher Stock.
    *   @version    1.0.0
    *******************************************************************************************************************/
    public enum SoundBoardFont
    {
        /** The regular default typeface. */
        TYPEFACE_MYRIAD_PRO_REGULAR( "font_myriad_pro_regular.ttf" ),

        /** The bold default typeface. */
        TYPEFACE_MYRIAD_PRO_BOLD( "font_myriad_pro_bold.ttf" ),

        ;

        /** Holds the loaded typeface. */
        private             Typeface            typeface                    = null;

        /** The asset name for this custom typeface to load. */
        private             String              assetName                   = null;

        /***************************************************************************************************************
        *   Creates a new predefined custom font.
        *
        *   @param  assetName   The name of the resource in the 'assets' folder.
        ***************************************************************************************************************/
        private SoundBoardFont( String assetName )
        {
            this.assetName = assetName;
        }

        /***************************************************************************************************************
        *   Gets the typeface of this enum constant. The typeface is initialized lazy.
        *   Default typefaces can be created using Typeface.create( "Droid Sans", Typeface.NORMAL )
        *
        *   @param  context     The current application context.
        *   @return             The generated custom typeface.
        ***************************************************************************************************************/
        public Typeface getTypeface( Context context )
        {
            if ( this.typeface == null )
            {
                this.typeface = LibIO.createTypefaceFromAsset( context, this.assetName );
            }

            return this.typeface;
        }
    }
