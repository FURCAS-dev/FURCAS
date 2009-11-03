package com.sap.tc.moin.test.fw.ide;


public class UtilImpl {

    protected void threadSleep( long millis, String testedMethod ) {

        try {
            Thread.sleep( millis );
        } catch ( InterruptedException exception ) {
            logExceptionMessage( testedMethod, exception );
            try {
                Thread.sleep( millis );
            } catch ( InterruptedException ex ) {
                logExceptionMessage( testedMethod, ex );
            }
        }
    }

    protected void logExceptionMessage( final String testedMethod, Exception exception ) {

        String message = null;
        if ( exception != null ) {
            message = "[Exception orrured] Method '" + testedMethod + "' has thrown exception '" + exception.getClass( ).getCanonicalName( ) + "': " + exception.getMessage( ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
            java.lang.System.out.println( message );
            java.lang.System.out.flush( );
            exception.printStackTrace( System.out );
        }
    }
}
