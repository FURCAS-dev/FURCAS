package com.sap.tc.moin.xm.test.xml;



import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;


/**
 * This class contains static Utility-Functions for IO (Streams etc.). Some its
 * methods were copied from deleted StreamUtil.
 */
public class IOUtil {

    //private static final Logger log = Logger.getLogger(IOUtil.class.getName());

    private IOUtil( ) {

    } // no instances for this class

    /**
     * Constant for the local line separator (EndOfLine). The value is read from
     * to the System-property "line.separator".
     */
    public static final String EOL = System.getProperty( "line.separator", "\n" );

    /**
     * Constant for the local path separator. The value is read from to the
     * System-property "path.separator".
     */
    public static final String PATH_SEP = System.getProperty( "path.separator", ";" );

    /**
     * Constant for the local file separator. The value is read from to the
     * System-property "file.separator".
     */
    public static final String FILE_SEP = System.getProperty( "file.separator", "/" );

    /**
     * This constant provides an <code>OutputStream</code> which ignores all
     * data sent to it. This is e.g. helpfull for testing the performance of
     * applications writing to an arbitrary <code>OutputStream</code>.
     */
    public static final OutputStream NIRWANA = new OutputStream( ) {

        @Override
        public void write( int b ) {

        }
    };

    static final int BUFFER_SIZE = 1024;

    /**
     * Copy all bytes from an InputStream to an OutputStream.
     * 
     * @return number of transferred bytes
     */
    public static int copyStream( InputStream in, OutputStream out ) throws IOException {

        byte[] buffer = new byte[BUFFER_SIZE];
        int count = 0;

        int n = in.read( buffer );
        while ( n > -1 ) {
            out.write( buffer, 0, n );
            count += n;

            n = in.read( buffer );
        }

        return count;
    }

    /*
     * Copy all bytes from an InputStream to an OutputStream asynchronously.
     * This method starts a {@link CopyStreamThread}and returns immediately.
     * The Thread copies bytes from the InputStream until an EndOfFile occurs
     * (or {@link CopyStreamThread#stopCopy}) is called. @param doClose if
     * <code> true </code> , both Streams are closed after the copying is
     * finished. @return a reference to the used CopyStreamThread.
     */
    /*
     * public static CopyStreamThread copyStreamASync(InputStream in,
     * OutputStream out, boolean doClose) { CopyStreamThread thread = new
     * CopyStreamThread(in, out, doClose); thread.start(); return thread; }
     */

    /**
     * Copy all characters from a Reader to a Writer.
     * 
     * @return number of transferred characters
     */
    public static int copyCharStream( Reader in, Writer out ) throws IOException {

        char[] buffer = new char[BUFFER_SIZE];
        int count = 0;

        int n = in.read( buffer );
        while ( n > -1 ) {
            out.write( buffer, 0, n );
            count += n;

            n = in.read( buffer );
        }

        return count;
    }

    /**
     * Returns the byte array of an input stream. The stream is closed after the
     * reading.
     * 
     * @param aInputStream, can be <code>null</code>
     * @return byte array, <code>null</code> if <code>aInputStream</code> is
     * <code>null</code>.
     * @throws IOException
     */
    public static byte[] getInputStreamAsByteArray( InputStream aInputStream ) throws IOException {

        if ( aInputStream == null ) {
            return null;
        }
        return read( aInputStream );
    }

    /**
     * Reads an InputStream into a String. The stream is closed after reading.
     * 
     * @param aInputStream the InputStream (may be <code>null</code>)
     * @param aEncoding the encoding used to decode the input to characters (if
     * <code>aEncoding</code> is <code>null</code> UTF-8 is used as default
     * encoding)
     * @return String (returns <code>null</code>, if
     * <code>aInputStream</code> is <code>null</code>)
     * @throws IOException
     */
    public static String getInputStreamAsString( InputStream aInputStream, String aEncoding ) throws IOException {

        if ( aInputStream == null ) {
            return null;
        }
        InputStreamReader lIsr = null;
        BufferedReader lReader = null;
        try {
            StringBuffer lText = new StringBuffer( );
            lIsr = new InputStreamReader( aInputStream, ( aEncoding == null ) ? "UTF-8" : aEncoding );
            lReader = new BufferedReader( lIsr );
            String lLine;
            while ( ( lLine = lReader.readLine( ) ) != null ) {
                lText.append( lLine ).append( '\n' );
            }
            return lText.toString( );
        } finally {
            if ( lReader != null ) {
                lReader.close( );
            }
            if ( lIsr != null ) {
                lIsr.close( );
            }
            aInputStream.close( );
        }
    }

    /**
     * Gets the lines of a text file as List of Strings.
     * 
     * @param aFile
     * @param aEncoding the encoding used to decode the input to characters (if
     * <code>aEncoding</code> is <code>null</code> UTF-8 is used as default
     * encoding)
     * @return a List of Strings
     * @throws IOException
     */
    public static List<String> getLinesOfTextFile( File aFile, String aEncoding ) throws IOException {

        // check existence
        if ( !aFile.exists( ) ) {
            return null;
        }
        // OK, file exists
        FileInputStream lFis = null;
        InputStreamReader lIsr = null;
        BufferedReader lReader = null;
        try {
            List<String> lLines = new ArrayList<String>( );
            lFis = new FileInputStream( aFile );
            lIsr = new InputStreamReader( lFis, ( aEncoding == null ) ? "UTF-8" : aEncoding );
            lReader = new BufferedReader( lIsr );
            String lLine;
            while ( ( lLine = lReader.readLine( ) ) != null ) {
                lLines.add( lLine );
            }
            return lLines;
        } finally {
            if ( lReader != null ) {
                lReader.close( );
            }
            if ( lIsr != null ) {
                lIsr.close( );
            }
            if ( lFis != null ) {
                lFis.close( );
            }
        }
    }

    /* This Thread copies all input from an InputStream to an OutputStream. */
    /*
     * private static class CopyStreamThread extends Thread { private
     * InputStream in; private OutputStream out; private int count; private
     * boolean doClose; private boolean stopCopy = false; private boolean
     * finished = false; private IOException exception = null; public
     * CopyStreamThread(InputStream in, OutputStream out, boolean doClose) {
     * this.in = in; this.out = out; this.doClose = doClose; count = 0; } public
     * void run() { byte[] buffer = new byte[IOUtil.BUFFER_SIZE]; try { int n =
     * in.read(buffer); while( (!stopCopy) && (n > -1) ) { out.write(buffer, 0,
     * n); count += n; n = in.read(buffer); } } catch(IOException e) { //
     * $JL-EXC$ exception is stored exception = e; } if(doClose) { close(out);
     * close(in); } finished = true; } public void stopCopy() { this.stopCopy =
     * true; } public int getCount() { return count; } public IOException
     * getException() { return exception; } public boolean isFinished() { return
     * finished; } }
     */

    /**
     * Get an InputStream reading from a String.
     * 
     * @throws UnsupportedEncodingException
     */
    public static InputStream toInputStream( String s, String encoding ) throws UnsupportedEncodingException {

        return new ByteArrayInputStream( s.getBytes( encoding ) );
    }

    /**
     * Copies the input from a Reader to a String.
     * 
     * @throws IOException
     */
    public static String copyToString( Reader in ) throws IOException {

        StringWriter sw = new StringWriter( );
        IOUtil.copyCharStream( in, sw );
        sw.close( );
        return sw.toString( );
    }

    /**
     * Copies the input from an InputStream to a String.
     * 
     * @throws UnsupportedEncodingException
     * @throws IOException
     */
    public static String copyToString( InputStream in, String encoding ) throws IOException {

        return copyToString( new InputStreamReader( in, encoding ) );
    }



    /**
     * Check if a file can be read. This method is guaranteed to throw no
     * Exceptions (Useful when running as unsigned Webstart client - no
     * SecurityExceptions). If Exceptions occur while accessing the file, the
     * method returns <code>false</code>.
     */
    public static boolean isFileReadable( File file ) {

        try {
            return file.canRead( );
        } catch ( Exception e ) { // $JL-EXC$ (see javadoc)
            return false;
        }
    }

    /**
     * Returns the full canonical name of a file (including path). This method
     * is guaranteed to throw no Exceptions (Useful when running as unsigned
     * Webstart client - no SecurityExceptions). If Exceptions occur while
     * accessing the file name, the "default" name (File.getPath()) is returned.
     */
    public static String getFileName( File file ) {

        try {
            return file.getCanonicalPath( );
        } catch ( Exception e ) { // $JL-EXC$ (see javadoc)
            return file.getPath( );
        }
    }

    /**
     * Returns the full canonical name of a file (including path). This method
     * is guaranteed to throw no Exceptions (Useful when running as unsigned
     * Webstart client - no SecurityExceptions). If Exceptions occur while
     * accessing the file name, the "original" name is returned.
     */
    public static String getCanonicalFileName( String name ) {

        try {
            return new File( name ).getCanonicalPath( );
        } catch ( Exception e ) { // $JL-EXC$ (see javadoc)
            return name;
        }
    }

    /**
     * Reads byte array from an Input Stream. The stream is closed after the
     * reading.
     * 
     * @param in input stream
     * @return byte array
     * @throws NullPointerException if <code>in</code> is <code>null</code>.
     */
    public static byte[] read( InputStream in ) throws IOException {

        return read( in, true );
    }

    /**
     * Reads byte array from an Inuput Stream.
     * 
     * @param in input stream
     * @param closeStream, if <code>true</code> the stream is closed after the
     * reading.
     * @throws NullPointerException if <code>in</code> is <code>null</code>.
     */
    public static byte[] read( InputStream in, boolean closeStream ) throws IOException {

        if ( in == null ) {
            throw new NullPointerException( "Parameter in is null." );
        }
        ByteArrayOutputStream lBaos = null;
        try {
            lBaos = new ByteArrayOutputStream( );
            byte[] lBuffer = new byte[BUFFER_SIZE];
            for ( int readNumber = in.read( lBuffer ); readNumber > -1; ) {
                lBaos.write( lBuffer, 0, readNumber );
                readNumber = in.read( lBuffer );
            }
            return lBaos.toByteArray( );
        } finally {
            if ( lBaos != null ) {
                lBaos.close( );
            }
            if ( closeStream ) {
                in.close( );
            }
        }
    }

}