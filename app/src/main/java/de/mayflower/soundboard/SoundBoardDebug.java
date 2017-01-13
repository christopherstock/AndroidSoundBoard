
    package de.mayflower.soundboard;

    import  android.util.Log;
    import  de.mayflower.lib.LibDebug;

    /*******************************************************************************************************************
    *   Represents the debug system consisting of switchable debug groups
    *   formed by the enum constants. Grouped debug outs can be toggled.
    *
    *   @author     Christopher Stock
    *   @version    1.0.0
    *******************************************************************************************************************/
    public enum SoundBoardDebug implements LibDebug
    {
        /** A paramount debug group with lowest priority. */
        bugfix(                     true                        ),
        /** A paramount debug group with moderate priority. */
        major(                      true                        ),
        /** A paramount debug group with highest priority. */
        error(                      true                        ),

        /** Shows speech results. */
        speechResults(              true                        ),
        /** Logs external  */
        externalAudioRecorder(      true                        ),
        /** Logs background listener service. */
        bgListener(                 true                        ),

        ;

        /** The stacktrace-String to send via email. */
        public      static  final   boolean             DEBUG_MODE              = SoundBoardSettings.Debug.DEBUG_MODE;

        /** The debug flag for this debug group. */
        private                     boolean             debug                   = false;

        /***************************************************************************************************************
        *   Creates a new debug group with the specified debug flag.
        *
        *   @param  debugOut    The debug flag indicates if debug-tasks for this group
        *                       shall be performed.
        ***************************************************************************************************************/
        SoundBoardDebug( boolean debugOut )
        {
            this.debug = debugOut;
        }

        @Override
        public final void out( Object msg )
        {
            if ( this.debug )
            {
                DEBUG_OUT( this.toString(), msg );
            }
        }

        @Override
        public final void err( Object msg )
        {
            DEBUG_ERR( this.toString(), msg );
        }

        @Override
        public final void trace( Throwable t )
        {
            if ( this.debug )
            {
                DEBUG_THROWABLE( t );
            }
        }

        /***************************************************************************************************************
        *   Delegates a message and a output-tag to the system's log system
        *   with a severity of 'info'.
        *
        *   @param      tag     The tag that represents the according debug group.
        *   @param      msg     The message to log for this output group.
        *   @see        Log#i(String, String)
        ***************************************************************************************************************/
        private static final void DEBUG_OUT( String tag, Object msg )
        {
            if ( DEBUG_MODE )
            {
                Log.i( tag, String.valueOf( msg ) );
            }
        }

        /***************************************************************************************************************
        *   Delegates a message to the system's log system with a severity of 'error'.
        *
        *   @param      tag     The tag that represents the according debug group.
        *   @param      msg     The message to log for this output group.
        *   @see        Log#e(String, String)
        ***************************************************************************************************************/
        private static final void DEBUG_ERR( String tag, Object msg )
        {
            if ( DEBUG_MODE )
            {
                Log.e( tag, String.valueOf( msg ) );
            }
        }

        /***************************************************************************************************************
        *   Writes the stack-trace for the specified Throwable to the system's log system.
        *
        *   @param  t   The Throwable to print the stack-trace for.
        ***************************************************************************************************************/
        public static final void DEBUG_THROWABLE( Throwable t )
        {
            if ( DEBUG_MODE )
            {
                DEBUG_OUT( "[throwable]", Log.getStackTraceString( t ) );
            }
        }
    }
