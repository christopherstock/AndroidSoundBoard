
    package de.mayflower.soundboard.ui;

    import  android.content.Context;
    import  android.graphics.Typeface;
    import  de.mayflower.lib.io.LibIO;

    /*****************************************************************************
    *   Lazy loads all required custom typefaces.
    *
    *   @author     Christopher Stock.
    *   @version    1.0
    *****************************************************************************/
    public enum SoundBoardFont {
        /**
         * A default typeface.
         */
        TYPEFACE_MYRIAD_PRO_REGULAR( "font_myriad_pro_regular.ttf" ),

        /**
         * A bold typeface.
         */
        TYPEFACE_MYRIAD_PRO_BOLD( "font_myriad_pro_bold.ttf" ),;

        /** Holds the loaded typeface. */
        private             Typeface            typeface                    = null;

        /** The asset name for this custom typeface to load. */
        private             String              assetName                   = null;

        private SoundBoardFont( String assetName )
        {
            this.assetName = assetName;
        }

        /*****************************************************************************
        *   Gets the typeface of this enum constant.
        *   A default typeface can be created using
        *   e.g.: Typeface.create( "Droid Sans", Typeface.NORMAL );
        *
        *   @param  context     The current application context.
        *****************************************************************************/
        public Typeface getTypeface( Context context )
        {
            if ( this.typeface == null )
            {
                this.typeface = LibIO.createTypefaceFromAsset( context, this.assetName );
            }

            return this.typeface;
        }
    }
