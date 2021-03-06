
    package de.mayflower.soundboard;

    /*******************************************************************************************************************
    *   Logs all versions of this app.
    *
    *   @author     Christopher Stock
    *   @version    1.0.0
    *******************************************************************************************************************/
    public enum SoundBoardVersion
    {
        /** */  VERSION_1_0_0( "1.0.0",       2, "none", "13.01.2017 17:37:46", "1ST RELEASE",      "" ),
        /** */  VERSION_0_0_1( "0.0.1 alpha", 1, "none", "14.12.2016 12:38:17", "PROOF_OF_CONCEPT", "" ),

        ;

        /** The version string of the client version. */
        private         String              clientVersionNumber         = null;
        /** The integer version code for the Android Manifest. */
        private         int                 versionCode                 = 0;
        /** The version string of the backend version. */
        private         String              backendVersionNumber        = null;
        /** The completion time of this version. */
        private         String              releaseDate                 = null;
        /** The internal codename of this version. */
        private         String              codeName                    = null;
        /** The log for this version contains latest changes. */
        private         String              log                         = null;

        /***************************************************************************************************************
        *   Creates one app version enum constant.
        *
        *   @param  clientVersionNumber  The version string for this client.
        *   @param  versionCode          The integer version code for the Android Manifest.
        *   @param  backendVersionNumber The version string of the according backend.
        *   @param  releaseDate          The last compilation time of this version.
        *   @param  codename             The internal codename for this version.
        *   @param  log                  A log-text with latest changes for this version.
        ***************************************************************************************************************/
        private SoundBoardVersion
        (
            String clientVersionNumber,
            int    versionCode,
            String backendVersionNumber,
            String releaseDate,
            String codename,
            String log
        )
        {
            this.clientVersionNumber  = clientVersionNumber;
            this.versionCode          = versionCode;
            this.backendVersionNumber = backendVersionNumber;
            this.releaseDate          = releaseDate;
            this.codeName             = codename;
            this.log                  = log;
        }

        /***************************************************************************************************************
        *   Returns the release date.
        *
        *   @return     The last release date for this version.
        ***************************************************************************************************************/
        public final String getReleaseDate()
        {
            return this.releaseDate;
        }

        /***************************************************************************************************************
        *   Returns the version string for the client version.
        *
        *   @return     The version string for the client.
        ***************************************************************************************************************/
        public final String getClientVersionNumber()
        {
            return this.clientVersionNumber;
        }

        /***************************************************************************************************************
        *   Returns the version string for the backend version.
        *
        *   @return     The version string for the backend.
        ***************************************************************************************************************/
        public final String getBackendVersionNumber()
        {
            return this.backendVersionNumber;
        }

        /***************************************************************************************************************
         *   Shows the current version number.
         *
         *   @return     The version-number of the latest version.
         **************************************************************************************************************/
        public static final String getCurrentVersionId()
        {
            return SoundBoardVersion.values()[ 0 ].clientVersionNumber;
        }

        /***************************************************************************************************************
        *   Shows the current version number.
        *
        *   @return     The version-number of the latest version.
        ***************************************************************************************************************/
        public static final String getVersion()
        {
            return
            (
                    "["
                +   SoundBoardVersion.values()[ 0 ].clientVersionNumber
                +   "] codename ["
                +   SoundBoardVersion.values()[ 0 ].codeName
                +   "] released on ["
                +   SoundBoardVersion.values()[ 0 ].releaseDate
                +   "]"
            );
        }

        /***************************************************************************************************************
        *   Returns a list of the project history.
        *
        *   @return     Returns a list of all versions with all version-numbers, codenames,
        *               release-dates and the according log.
        ***************************************************************************************************************/
        public static final String getVersionLog()
        {
            StringBuffer ret = new StringBuffer();
            for ( int i = 0; i < SoundBoardVersion.values().length; ++i )
            {
                ret.append
                (
                        SoundBoardVersion.values()[ i ].clientVersionNumber
                    +   " "
                    +   SoundBoardVersion.values()[ i ].codeName
                    +   " "
                    +   SoundBoardVersion.values()[ i ].releaseDate
                    +   " "
                    +   SoundBoardVersion.values()[ i ].log
                    +   "\n"
                );
            }
            ret.append( "\n" );

            return ret.toString();
        }
    }
