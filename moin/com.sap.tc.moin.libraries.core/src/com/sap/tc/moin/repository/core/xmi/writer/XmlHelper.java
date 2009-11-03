package com.sap.tc.moin.repository.core.xmi.writer;

import static com.sap.tc.moin.repository.shared.util.SunSystemPropertyKeys.LINE_SEPARATOR;

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
 * This is a helper class used by instances of {@link XmiWriter12Impl} and
 * {@link PartitionWriterImpl} . Instances of it hold the OutputStream used
 * during serialization, and offer methods to write XML elements, XML attributes
 * and Strings to the stream.
 */
public class XmlHelper {

    static final String LINE_SEPARATOR_VALUE = System.getProperty( LINE_SEPARATOR );

    static final int LINE_SEPARATOR_LENGTH = LINE_SEPARATOR_VALUE.length( );

    /**
     * Quote character used for enclosing attribute values.
     */
    private static final char QUOTE = '\'';

    /**
     * The indentation used during {@link #startElement(String)}.
     */
    private static final String INDENT = "\t"; //$NON-NLS-1$

    /**
     * The indentation length.
     */
    private static final int INDENT_LENGTH = INDENT.length( );

    private final StringBuilder sb = new StringBuilder( 256 );

    private static final int CHAR_BUFFER_SIZE = 16384;

    /**
     * The UnsynchronizedBufferedPrintWriter used during serialization.
     */
    private UnsynchronizedBufferedPrintWriter writer;

    /**
     * <code>true</code>, if the currently written XML element has at least one
     * sub-element
     */
    private boolean hasContent;

    /**
     * <code>true</code>, if the currently written XML element has some
     * characters in its content
     */
    private boolean hasCharacters;

    /**
     * <code>true</code>, if the XML elements should be indented
     */
    private boolean useIndentation;

    /**
     * currently used indentation String
     */
    private String indentation;

    /**
     * Package private constructor. This class is only instantiated by instances
     * of {@link XmiWriterImpl}.
     */
    public XmlHelper( ) {

    }

    /**
     * Creates a stream and wraps it around the given OutputStream. Initializes
     * the other variables.
     */
    public void createStream( OutputStream os, String encoding, boolean indent ) throws IOException {

        writer = new UnsynchronizedBufferedPrintWriter( os, encoding );
        hasContent = true;
        hasCharacters = true;
        useIndentation = indent;
        indentation = ""; //$NON-NLS-1$
    }

    /**
     * Flushes the stream (but does not close it).
     */
    public void flushStream( ) throws IOException {

        if ( writer != null ) {
            writer.flush( );
        }
    }

    /**
     * Offers the possibility to set the {@link #hasCharacters} flag from
     * outside.
     */
    public void setHasCharacters( boolean hasCharacters ) {

        this.hasCharacters = hasCharacters;
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
     * Determines whether the given attribute value contains special characters
     * that make it necessary to serialize the String in a CDATA section.
     */
    public boolean requiresCData( String attributeValue ) {

        boolean useCDATA = false;
        int n = attributeValue.length( );
        for ( int i = 0; i < n && useCDATA == false; i++ ) {
            switch ( attributeValue.charAt( i ) ) {
                case '&':
                case '\'':
                case '\"':
                case '<':
                case '>':
                case '\r':
                case '\n':
                case '\t':
                    useCDATA = true;
                    break;
            }
        }
        return useCDATA;
    }

    /**
     * Writes the opening tag of an XML element to the stream. The previous XMI
     * element is closed first.
     */
    public void startElement( String name ) {

        if ( !hasContent && !hasCharacters ) {
            write( ">" ); //$NON-NLS-1$
            writeln( );
        }
        hasContent = false;
        hasCharacters = false;
        if ( useIndentation ) {
            write( indentation );
            indentation += INDENT;
        }
        write( "<" + name ); //$NON-NLS-1$
    }

    /**
     * Writes the closing tag of an XML element to the stream.
     */
    public void endElement( String name ) {

        if ( useIndentation ) {
            indentation = indentation.substring( 0, indentation.length( ) - INDENT_LENGTH );
        }
        if ( hasContent ) {
            if ( useIndentation ) {
                write( indentation );
            }
            sb.delete( 0, sb.length( ) );
            sb.append( "</" ).append( name ).append( ">" ); //$NON-NLS-1$ //$NON-NLS-2$
            write( sb.toString( ) );
        } else if ( hasCharacters ) {
            sb.delete( 0, sb.length( ) );
            sb.append( "</" ).append( name ).append( ">" ); //$NON-NLS-1$ //$NON-NLS-2$
            write( sb.toString( ) );
        } else {
            write( "/>" ); //$NON-NLS-1$
        }
        writeln( );
        hasContent = true;
    }

    /**
     * Writes an attribute of the currenly written XML element to the stream.
     */
    public void addAttribute( String name, String value, boolean replaceSpecialChars ) {

        if ( name == null || value == null ) {
            return;
        }
        StringBuilder text = new StringBuilder( " " ); //$NON-NLS-1$
        text.append( name );
        text.append( "=" ); //$NON-NLS-1$
        text.append( QUOTE );
        if ( replaceSpecialChars ) {
            text.append( replaceSpecialChars( value ) );
        } else {
            text.append( value );
        }
        text.append( QUOTE );
        write( text.toString( ) );
    }

    /**
     * Writes characters into the body of the currenly written XML element.
     * Before the String is written, {@link #replaceSpecialChars(String)} is
     * called on it to replace special XML characters.
     */
    public void characters( String text ) {

        if ( !hasContent ) {
            write( ">" ); //$NON-NLS-1$
        }
        write( replaceSpecialChars( text ) );
        hasCharacters = true;
    }

/**
     * Locates occurences of special XML charecters (like ' <', '&', etc.) in a String and replaces them by sequences of
     * the form &X..X;
     */
    private String replaceSpecialChars( String s ) {

        int length = s.length( );
        char[] chars = new char[6 * length];
        int n = 0;
        for ( int i = 0; i < length; i++ ) {
            char c = s.charAt( i );
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
                default:
                    chars[n++] = c;
            }
        }
        return new String( chars, 0, n );
    }

    private static final class UnsynchronizedBufferedPrintWriter extends Writer {

        private Writer out;

        private char cb[];

        private int nChars, nextChar;

        private UnsynchronizedBufferedPrintWriter( Writer out ) {

            super( out );
            this.out = out;
            cb = new char[CHAR_BUFFER_SIZE];
            nChars = CHAR_BUFFER_SIZE;
            nextChar = 0;
        }

        public UnsynchronizedBufferedPrintWriter( OutputStream out, String encoding ) throws UnsupportedEncodingException {

            this( new OutputStreamWriter( out, encoding ) ); //$JL-I18N$
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

        public void print( String s ) throws IOException {

            write( s );
        }

        public void println( ) throws IOException {

            write( LINE_SEPARATOR_VALUE, 0, LINE_SEPARATOR_LENGTH );
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

    public static Reader getUnsynchronizedBufferedReader( InputStream is, String encoding ) throws UnsupportedEncodingException {

        return new UnsynchronizedBufferedReader( is, encoding );
    }

    private static final class UnsynchronizedBufferedReader extends Reader {

        private Reader in;

        private char cb[];

        private int nChars, nextChar;

        private static final int INVALIDATED = -2;

        private static final int UNMARKED = -1;

        private int markedChar = UNMARKED;

        private int readAheadLimit = 0;

        private boolean skipLF = false;

        public UnsynchronizedBufferedReader( InputStream out, String encoding ) throws UnsupportedEncodingException {

            this( new InputStreamReader( out, encoding ) ); //$JL-I18N$
        }

        private UnsynchronizedBufferedReader( Reader in ) {

            super( in );
            this.in = in;
            cb = new char[CHAR_BUFFER_SIZE];
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
                if ( skipLF ) {
                    skipLF = false;
                    if ( cb[nextChar] == '\n' ) {
                        nextChar++;
                        continue;
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

            if ( skipLF ) {
                if ( nextChar >= nChars && in.ready( ) ) {
                    fill( );
                }
                if ( nextChar < nChars ) {
                    if ( cb[nextChar] == '\n' ) {
                        nextChar++;
                    }
                    skipLF = false;
                }
            }
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

            int dst;
            if ( markedChar <= UNMARKED ) {
                dst = 0;
            } else {
                int delta = nextChar - markedChar;
                if ( delta >= readAheadLimit ) {
                    markedChar = INVALIDATED;
                    readAheadLimit = 0;
                    dst = 0;
                } else {
                    if ( readAheadLimit <= cb.length ) {
                        System.arraycopy( cb, markedChar, cb, 0, delta );
                        markedChar = 0;
                        dst = delta;
                    } else {
                        char ncb[] = new char[readAheadLimit];
                        System.arraycopy( cb, markedChar, ncb, 0, delta );
                        cb = ncb;
                        markedChar = 0;
                        dst = delta;
                    }
                    nextChar = nChars = delta;
                }
            }
            int n;
            do {
                n = in.read( cb, dst, cb.length - dst );
            } while ( n == 0 );
            if ( n > 0 ) {
                nChars = dst + n;
                nextChar = dst;
            }
        }

        private int read1( char[] cbuf, int off, int len ) throws IOException {

            if ( nextChar >= nChars ) {
                if ( len >= cb.length && markedChar <= UNMARKED && !skipLF ) {
                    return in.read( cbuf, off, len );
                }
                fill( );
            }
            if ( nextChar >= nChars ) {
                return -1;
            }
            if ( skipLF ) {
                skipLF = false;
                if ( cb[nextChar] == '\n' ) {
                    nextChar++;
                    if ( nextChar >= nChars ) {
                        fill( );
                    }
                    if ( nextChar >= nChars ) {
                        return -1;
                    }
                }
            }
            int n = Math.min( len, nChars - nextChar );
            System.arraycopy( cb, nextChar, cbuf, off, n );
            nextChar += n;
            return n;
        }
    }
}
