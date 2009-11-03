package com.sap.tc.moin.repository.core.cps;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

import com.sap.tc.moin.repository.core.serialization.PartitionWriterImpl;

/**
 * This is a helper class used by instances of {@link PartitionWriterImpl}.
 * Instances of it hold the OutputStream used during serialization, and offer
 * methods to write XML elements, XML attributes and Strings to the stream.
 */
public final class XmlHelper {

    static final String LINE_SEPARATOR = System.getProperty( "line.separator" ); //$NON-NLS-1$

    static final int LINE_SEPARATOR_LENGTH = LINE_SEPARATOR.length( );

    /**
     * Quote character used for enclosing attribute values.
     */
    private static final char QUOTE = '\'';

    private final StringBuilder sb = new StringBuilder( 256 );

    private static final int MIN_CHAR_BUFFER_SIZE = 1024; // 1K

    private static final int MAX_CHAR_BUFFER_SIZE = 65536; // 64K

    /**
     * The UnsynchronizedBufferedPrintWriter used during serialization.
     */
    private UnsynchronizedBufferedPrintWriter writer;

    /**
     * <code>true</code>, if there is currently an open XML element.
     */
    private boolean elementOpen;

    /**
     * Package private constructor. This class is only instantiated by instances
     * of {@link PartitionWriterImpl}.
     */
    public XmlHelper( ) {

    }

    /**
     * Initializes the XmlHelper for a new run.
     */
    public void init( OutputStream os, String encoding, int maxBufferSize ) throws IOException {

        writer = new UnsynchronizedBufferedPrintWriter( os, encoding, maxBufferSize );
        elementOpen = false;
    }

    /**
     * Flushes the writer.
     */
    public void flushStream( ) throws IOException {

        if ( writer != null ) {
            writer.flush( );
        }
    }

    /**
     * Writes a String to the stream.
     */
    public void write( String text ) {

        try {
            writer.print( text );
        } catch ( IOException e ) {
            throw new RuntimeException( e );
        }
    }

    /**
     * Writes a StringBuilder to the stream.
     */
    public void write( StringBuilder stringBuilder ) {

        try {
            writer.write( stringBuilder );
        } catch ( IOException e ) {
            throw new RuntimeException( e );
        }
    }

    /**
     * Writes a character to the stream.
     */
    public void write( int character ) {

        try {
            writer.write( character );
        } catch ( IOException e ) {
            throw new RuntimeException( e );
        }
    }

    /**
     * Writes end-of-line to the stream.
     */
    public void writeln( ) {

        try {
            writer.println( );
        } catch ( IOException e ) {
            throw new RuntimeException( e );
        }
    }

    /**
     * Writes the opening tag of an XML element to the stream. The previous XML
     * element is closed first.
     */
    public void startElement( String name ) {

        if ( elementOpen ) {
            write( '>' );
            writeln( );
        }
        write( '<' );
        write( name );
        elementOpen = true;
    }

    /**
     * Writes the closing tag of an XML element to the stream.
     */
    public void endElement( String name ) {

        if ( !elementOpen ) {
            sb.delete( 0, sb.length( ) );
            sb.append( "</" ).append( name ).append( ">" ); //$NON-NLS-1$ //$NON-NLS-2$
            write( sb );
        } else {
            write( '/' );
            write( '>' );
            elementOpen = false;
        }
        writeln( );
    }

    /**
     * Writes an attribute of the currenly written XML element to the stream.
     */
    public void addAttribute( String name, String value, boolean replaceSpecialChars ) {

        sb.delete( 0, sb.length( ) );
        sb.append( ' ' ).append( name ).append( '=' ).append( QUOTE );
        if ( replaceSpecialChars ) {
            appendEscapedChars( sb, value );
        } else {
            sb.append( value );
        }
        sb.append( QUOTE );
        write( sb );
    }

    private static int firstOccurenceOfSpecialChar( String s ) {

        for ( int i = 0, n = s.length( ); i < n; i++ ) {
            switch ( s.charAt( i ) ) {
                case '&':
                case '\'':
                case '\"':
                case '<':
                case '>':
                case '\t':
                case '\r':
                case '\n':
                    return i;
            }
        }
        return -1;
    }

/**
     * Locates occurences of special XML characters (like ' <', '&', etc.) in
     * the given String and replaces them by sequences of the form &X..X;
     * <p>
     * The resulting characters are appended to the given StringBuilder.
     */
    private static void appendEscapedChars( StringBuilder sb, String s ) {

        int start = firstOccurenceOfSpecialChar( s );
        if ( start == -1 ) {
            sb.append( s );
            return;
        }
        int length = s.length( );
        char[] chars = new char[6 * length];
        s.getChars( 0, length, chars, 5 * length );
        int n = 0;
        for ( int i = 5 * length, j = 6 * length; i < j; i++ ) {
            char c = chars[i];
            switch ( c ) {
                case '&':
                    chars[n++] = '&';
                    chars[n++] = 'a';
                    chars[n++] = 'm';
                    chars[n++] = 'p';
                    chars[n++] = ';';
                    break;
                case '\'':
                    chars[n++] = '&';
                    chars[n++] = 'a';
                    chars[n++] = 'p';
                    chars[n++] = 'o';
                    chars[n++] = 's';
                    chars[n++] = ';';
                    break;
                case '\"':
                    chars[n++] = '&';
                    chars[n++] = 'q';
                    chars[n++] = 'u';
                    chars[n++] = 'o';
                    chars[n++] = 't';
                    chars[n++] = ';';
                    break;
                case '<':
                    chars[n++] = '&';
                    chars[n++] = 'l';
                    chars[n++] = 't';
                    chars[n++] = ';';
                    break;
                case '>':
                    chars[n++] = '&';
                    chars[n++] = 'g';
                    chars[n++] = 't';
                    chars[n++] = ';';
                    break;
                case '\t':
                    chars[n++] = '&';
                    chars[n++] = '#';
                    chars[n++] = '9';
                    chars[n++] = ';';
                    break;
                case '\r':
                    chars[n++] = '&';
                    chars[n++] = '#';
                    chars[n++] = '1';
                    chars[n++] = '3';
                    chars[n++] = ';';
                    break;
                case '\n':
                    chars[n++] = '&';
                    chars[n++] = '#';
                    chars[n++] = '1';
                    chars[n++] = '0';
                    chars[n++] = ';';
                    break;
                default:
                    chars[n++] = c;
            }
        }
        sb.append( chars, 0, n );
    }

    private static final class UnsynchronizedBufferedPrintWriter extends Writer {

        private Writer out;

        private char cb[];

        private int nChars, nextChar;

        private UnsynchronizedBufferedPrintWriter( Writer out, int maxBufferSize ) {

            super( out );
            this.out = out;
            // Make sure that the buffer size is between MIN_CHAR_BUFFER_SIZE and MAX_CHAR_BUFFER_SIZE.
            nChars = ( maxBufferSize < MIN_CHAR_BUFFER_SIZE ? MIN_CHAR_BUFFER_SIZE : maxBufferSize );
            nChars = ( maxBufferSize > MAX_CHAR_BUFFER_SIZE ? MAX_CHAR_BUFFER_SIZE : maxBufferSize );
            cb = new char[nChars];
            nextChar = 0;
        }

        public UnsynchronizedBufferedPrintWriter( OutputStream out, String encoding, int maxBufferSize ) throws UnsupportedEncodingException {

            this( new OutputStreamWriter( out, encoding ), maxBufferSize ); //$JL-I18N$
        }

        @Override
        public void flush( ) throws IOException {

            flushBuffer( );
            out.flush( );
        }

        @Override
        public void close( ) throws IOException {

            if ( out == null ) {
                return;
            }
            flushBuffer( );
            out.close( );
            out = null;
            cb = null;
        }

        @Override
        public void write( char cbuf[], int off, int len ) throws IOException {

            if ( ( off < 0 ) || ( off > cbuf.length ) || ( len < 0 ) || ( ( off + len ) > cbuf.length ) || ( ( off + len ) < 0 ) ) {
                throw new IndexOutOfBoundsException( );
            } else if ( len == 0 ) {
                return;
            }
            if ( len >= nChars ) {
                flushBuffer( );
                out.write( cbuf, off, len );
                return;
            }
            int b = off, t = off + len;
            while ( b < t ) {
                int d = min( nChars - nextChar, t - b );
                System.arraycopy( cbuf, b, cb, nextChar, d );
                b += d;
                nextChar += d;
                if ( nextChar >= nChars ) {
                    flushBuffer( );
                }
            }
        }

        @Override
        public void write( String s, int off, int len ) throws IOException {

            int b = off, t = off + len;
            while ( b < t ) {
                int d = min( nChars - nextChar, t - b );
                s.getChars( b, b + d, cb, nextChar );
                b += d;
                nextChar += d;
                if ( nextChar >= nChars ) {
                    flushBuffer( );
                }
            }
        }

        @Override
        public void write( String s ) throws IOException {

            write( s, 0, s.length( ) );
        }

        public void write( StringBuilder sb ) throws IOException {

            int length = sb.length( );
            char[] chars = new char[length];
            sb.getChars( 0, length, chars, 0 );
            write( chars, 0, length );
        }

        public void print( String s ) throws IOException {

            write( s );
        }

        public void println( ) throws IOException {

            write( LINE_SEPARATOR, 0, LINE_SEPARATOR_LENGTH );
        }

        private void flushBuffer( ) throws IOException {

            if ( nextChar == 0 ) {
                return;
            }
            out.write( cb, 0, nextChar );
            nextChar = 0;
        }

        private int min( int a, int b ) {

            if ( a < b ) {
                return a;
            }
            return b;
        }
    }

    public static Reader getUnsynchronizedBufferedReader( InputStream is, String encoding, long fileSize ) throws UnsupportedEncodingException {

        return new UnsynchronizedBufferedReader( is, encoding, fileSize );
    }

    private static final class UnsynchronizedBufferedReader extends Reader {

        private Reader in;

        private char cb[];

        private int nChars, nextChar;

        public UnsynchronizedBufferedReader( InputStream out, String encoding, long fileSize ) throws UnsupportedEncodingException {

            this( new InputStreamReader( out, encoding ), fileSize ); //$JL-I18N$
        }

        private UnsynchronizedBufferedReader( Reader in, long fileSize ) {

            super( in );
            this.in = in;
            int bufSize = MAX_CHAR_BUFFER_SIZE;
            if ( fileSize > 0 ) { // fileSize was provided by the caller
                bufSize = ( fileSize > MAX_CHAR_BUFFER_SIZE ? MAX_CHAR_BUFFER_SIZE : (int) fileSize );
            }
            cb = new char[bufSize];
            nextChar = nChars = 0;
        }

        @Override
        public int read( ) throws IOException {

            for ( ;; ) {
                if ( nextChar >= nChars ) {
                    fill( );
                    if ( nextChar >= nChars ) {
                        return -1;
                    }
                }
                return cb[nextChar++];
            }
        }

        @Override
        public int read( char cbuf[], int off, int len ) throws IOException {

            if ( ( off < 0 ) || ( off > cbuf.length ) || ( len < 0 ) || ( ( off + len ) > cbuf.length ) || ( ( off + len ) < 0 ) ) {
                throw new IndexOutOfBoundsException( );
            } else if ( len == 0 ) {
                return 0;
            }
            int n = read1( cbuf, off, len );
            if ( n <= 0 ) {
                return n;
            }
            while ( ( n < len ) && in.ready( ) ) {
                int n1 = read1( cbuf, off + n, len - n );
                if ( n1 <= 0 ) {
                    break;
                }
                n += n1;
            }
            return n;
        }

        @Override
        public boolean ready( ) throws IOException {

            return ( nextChar < nChars ) || in.ready( );
        }

        @Override
        public void close( ) throws IOException {

            if ( in == null ) {
                return;
            }
            in.close( );
            in = null;
            cb = null;
        }

        private void fill( ) throws IOException {

            int n;
            do {
                n = in.read( cb, 0, cb.length );
            } while ( n == 0 );
            if ( n > 0 ) {
                nChars = n;
                nextChar = 0;
            }
        }

        private int read1( char[] cbuf, int off, int len ) throws IOException {

            if ( nextChar >= nChars ) {
                if ( len >= cb.length ) {
                    return in.read( cbuf, off, len );
                }
                fill( );
            }
            if ( nextChar >= nChars ) {
                return -1;
            }
            int n = Math.min( len, nChars - nextChar );
            System.arraycopy( cb, nextChar, cbuf, off, n );
            nextChar += n;
            return n;
        }
    }
}
