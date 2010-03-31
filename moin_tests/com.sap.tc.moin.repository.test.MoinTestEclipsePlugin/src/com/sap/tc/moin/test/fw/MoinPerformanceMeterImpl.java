package com.sap.tc.moin.test.fw;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import com.sap.tc.moin.test.util.printer.MoinTestLogger;

@SuppressWarnings( "nls" )
public class MoinPerformanceMeterImpl implements MoinPerformanceMeter {

    private String applicationId;

    static private String absPath;

    static private Calendar cal;

    static private SimpleDateFormat sdf;

    private final static String PERFORMANCE_LOG_PATH = "moin_performance_logs_path";

    private static final String CSV_EXT = ".csv";

    private String CSV_FILE_NAME;

    private final static String CSV_HEADER = "Date , Time , Test, ";

    private final static String CSV_TRAILER = "Execution Time";

    private long startTime;

    public MoinPerformanceMeterImpl( String testApplicationId ) {

        this.applicationId = testApplicationId;
        this.CSV_FILE_NAME = applicationId.substring( 0, applicationId.indexOf( '#' ) ) + CSV_EXT;

        initializeLogFile( CSV_FILE_NAME, new String[] { "Types (mmSize)", "Instances (instSize)", "Attributes (attrSize)", "ModelElements total", "Partitions total" } );
    }

    public void commit( ) {

        // TODO implement me!

    }

    public void dispose( ) {

        // TODO implement me!

    }

    public void start( ) {

        this.startTime = System.nanoTime( );
    }

    public void stop( ) {

        long elapsedTime = System.nanoTime( ) - startTime;
        addToCsvFile( elapsedTime );
        this.startTime = 0;
    }

    public void stop( Object[] entries ) {

        long elapsedTime = System.nanoTime( ) - startTime;
        addToCsvFile( elapsedTime, entries );
        this.startTime = 0;
    }

    public void assertPerformance( ) {

        // TODO implement me!

    }

    public void tagAsGlobalSummaryForCPUTime( String header ) {

        // unsupported
    }

    public void tagAsGlobalSummaryForElapsedTime( String header ) {

        // unsupported
    }

    public void tagAsGlobalSummaryForMemoryConsumption( String header ) {

        // unsupported
    }

    /*
     * Methods for performance logging
     */

    /**
     * Initialize a performance CSV log file by providing a fileName and
     * additional headers. By default the header includes DATE, TIME, TESTNAME,
     * and EXECUTION TIME. The additional headers will appear in between the
     * TESTNAME and EXECUTION TIME. The log file will be created if it does not
     * exist, otherwise an empty line will added. If fileName==null, no log file
     * will be written or extended. Also, if the system property
     * moin_performance_logs_path is not set, no log file will be written or
     * extended.
     */
    static private void initializeLogFile( String fileName, String[] headers ) {

        absPath = System.getProperties( ).getProperty( PERFORMANCE_LOG_PATH );

        if ( absPath != null ) {
            MoinTestLogger.printInfo( "Property \"" + PERFORMANCE_LOG_PATH + "\" is \"" + absPath + "\"" );
            absPath = absPath + "\\";
        }

        cal = Calendar.getInstance( TimeZone.getDefault( ) );
        String DATE_FORMAT = "yyyy-MM-dd, HH:mm:ss";
        sdf = new SimpleDateFormat( DATE_FORMAT );
        sdf.setTimeZone( TimeZone.getDefault( ) );

        if ( absPath != null && fileName != null ) {
            try {
                // create directory if necessary
                File dir = new File( absPath );
                boolean dirExists = dir.exists( );
                if ( !dirExists ) {
                    dirExists = dir.mkdir( );
                }

                // create file if necessary
                File file = new File( absPath + fileName );
                boolean makeHeader = false;
                if ( dirExists && !( file.exists( ) ) ) {
                    makeHeader = true;
                    file.createNewFile( );
                }

                BufferedWriter out = null;

                if ( dirExists && file.canWrite( ) ) {
                    try {
                        out = new BufferedWriter( new FileWriter( file, true ) );

                        if ( makeHeader ) {
                            String header = CSV_HEADER;
                            for ( String headerEntry : headers ) {
                                header = header + headerEntry + ",";
                            }
                            header = header + CSV_TRAILER + "\n";

                            out.write( header );
                        }

                        out.write( "\n" );

                    } finally {
                        out.close( );
                    }
                }
            } catch ( Exception e ) {
                e.printStackTrace( );
            }
        }
    }

    /**
     * (static: name has to be provided) Appends a line to the performance log
     * file indicated by fileName. If fileName==null, the line will not be
     * added. The time should be given as milliseconds (long). Additional
     * entries should implement toString() and ought to correspond to the custom
     * header as constructed with {@link #initializeLogFile(String, String[])}.
     */
    private void addToCsvFile( String name, long time, Object[] entries ) {

        if ( absPath != null && CSV_FILE_NAME != null ) {
            try {
                String inbetween = ",";
                for ( Object entry : entries ) {
                    inbetween = inbetween + entry.toString( ) + ",";
                }

                String line = sdf.format( cal.getTime( ) ) + "," + name + inbetween + String.valueOf( time );

                File file = new File( absPath + CSV_FILE_NAME );
                if ( file.canWrite( ) ) {
                    BufferedWriter out = null;
                    try {
                        out = new BufferedWriter( new FileWriter( file, true ) );
                        out.write( line + "\n" );
                    } finally {
                        out.close( );
                    }
                }
            } catch ( Exception e ) {
                e.printStackTrace( );
            }
        }
    }

    /**
     * * (non-static: name is that of test) Appends a line to the performance
     * log file indicated by fileName. If fileName==null, the line will not be
     * added. The time should be given as milliseconds (long). Additional
     * entries should implement toString() and ought to correspond to the custom
     * header as constructed with {@link #initializeLogFile(String, String[])}.
     */
    private void addToCsvFile( long time, Object[] entries ) {

        addToCsvFile( applicationId, time, entries );
    }

    /**
     * Appends a standard line to the performance log file indicated by
     * fileName. If fileName==null, the line will not be added. The time should
     * be given as milliseconds (long).
     */
    private void addToCsvFile( long time ) {

        addToCsvFile( time, new Object[0] );
    }

    // /**
    // * Appends a new line to the performance log file indicated by fileName. If
    // * fileName==null, the line will not be added.
    // */
    // private void addNewLineToCsvFile()
    // {
    // if (absPath != null && CSV_FILE_NAME != null)
    // {
    // try
    // {
    // File file = new File(absPath + CSV_FILE_NAME);
    // if (file.canWrite())
    // {
    // BufferedWriter out = null;
    // try
    // {
    // out = new BufferedWriter(new FileWriter(file, true));
    // out.write("\n");
    // } finally
    // {
    // out.close();
    // }
    // }
    //
    // } catch (Exception e)
    // {
    // e.printStackTrace();
    // }
    // }
    // }
}
