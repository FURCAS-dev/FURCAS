package com.sap.tc.moin.xm.kernel.impl.serializer.sax;


import java.io.OutputStream;
import java.util.Iterator;
import java.util.Stack;

import com.sap.tc.moin.repository.exception.MoinIllegalStateException;
import com.sap.tc.moin.repository.exception.MoinNullPointerException;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.xm.serializer.XmlOutputHandler;
import com.sap.tc.moin.xm.kernel.impl.XmExceptionMessages;



/**
 * Handler for creating a XML document. The depth of the hierarchy level of the
 * elements is restricted to {@link #MAX_DEPTH}.
 */
public final class XmlOutputHandlerImpl implements XmlOutputHandler {

    private static final MoinLogger LOGGER = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_XM, MoinLocationEnum.MOIN_XM_RT, XmlOutputHandlerImpl.class );

    private static final int MAX_DEPTH = 200;

    private final PWriter out;

    private String lastClosed = ""; //$NON-NLS-1$

    private boolean closed = true;

    private int depth = 0;

    private final int[] ndepth = new int[MAX_DEPTH];

    private final Stack<String> tagStack = new Stack<String>( );

    /**
     * Constructor.
     * 
     * @param ous output stream
     * @throws NullPointerException if <tt>ous</tt> is <code>null</code>
     */
    public XmlOutputHandlerImpl( final OutputStream ous ) {

        this.out = new PWriter( ous );
    }

    public void addAttribute( final String name, final Object value ) {

        if ( name == null ) {
            throw new MoinNullPointerException( "name" ); //$NON-NLS-1$
        }
        out.print( " " + name + "=\"" + this.escapeXMLChars( value.toString( ) ) + "\"" ); //$NON-NLS-1$ //$NON-NLS-2$//$NON-NLS-3$
    }

    public void addElement( final String tagName, final Object value ) {

        this.startTag( tagName );
        this.putValue( value );
        this.closeTag( );
    }

    public void addRawAttribute( final CharSequence _value ) {

        out.print( _value.toString( ) );
    }

    public void closeTag( ) {

        if ( tagStack.empty( ) ) {
            LOGGER.trace( MoinSeverity.ERROR, XmExceptionMessages.OUTPUTSTRUCTURENOTWELLFORMED );
            throw new MoinIllegalStateException( XmExceptionMessages.OUTPUTSTRUCTURENOTWELLFORMED );
        }
        lastClosed = tagStack.pop( );
        closeTag( lastClosed );
    }

    private void closeTag( final String tagName ) {

        if ( !closed ) {
            out.print( ">" ); //$NON-NLS-1$
            closed = true;
        }
        out.print( "</" + tagName + ">" ); //$NON-NLS-1$ //$NON-NLS-2$
        depth--;
    }

    public void documentEnd( ) {

        out.flush( );
        out.close( );
    }

    public void documentStart( ) {

        out.println( "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" ); //$NON-NLS-1$
    }

    public String getCurPath( ) {

        final StringBuilder buf = new StringBuilder( "/" ); //$NON-NLS-1$
        final Iterator<String> iter = tagStack.iterator( );
        int dpth = 0;
        while ( iter.hasNext( ) ) {
            final Object item = iter.next( );
            buf.append( item );
            if ( dpth < MAX_DEPTH && ndepth[dpth] > 0 ) {
                buf.append( '[' ).append( ndepth[dpth] + 1 ).append( ']' );
            }
            buf.append( '/' );
            dpth++;
        }
        return buf.toString( );
    }

    public String getCurTag( ) {

        if ( tagStack.empty( ) ) {
            LOGGER.trace( MoinSeverity.ERROR, XmExceptionMessages.NOOPENXMLTAG );
            throw new MoinIllegalStateException( XmExceptionMessages.NOOPENXMLTAG );
        }
        return tagStack.peek( );
    }

    public Exception getException( ) {

        return out.getException( );
    }

    public int getLastIndex( ) {

        return ndepth[depth];
    }


//    public void putBytes( final byte[] array ) {
//
//        if ( !closed ) {
//            out.print( ">" ); //$NON-NLS-1$
//            closed = true;
//        }
//        out.write( array );
//    }

    public void putValue( final Object value ) {

        //escaping
        putValueUnescaped( this.escapeXMLChars( value.toString( ) ) );
    }

    public void putValueUnescaped( final Object _value ) {

        if ( !closed ) {
            out.print( ">" ); //$NON-NLS-1$
            closed = true;
        }
        out.print( _value.toString( ) );
        closed = true;
    }

    public void startTag( final String tagName ) {

        if ( tagName == null ) {
            throw new MoinNullPointerException( "tagName" ); //$NON-NLS-1$
        }
        if ( !closed ) {
            out.print( ">" ); //$NON-NLS-1$
        }
        out.print( "<" + tagName ); //$NON-NLS-1$
        tagStack.push( tagName );
        if ( ( depth < MAX_DEPTH ) ) {
            if ( tagName.equals( lastClosed ) ) {
                ndepth[depth]++;
            } else if ( depth != 0 ) {
                ndepth[depth] = 0;
            }
        }
        depth++;
        closed = false;
        lastClosed = null;
    }

    /**
     * This method returns a String where the reserved XML mark-up characters
     * are escaped. (Example: <code>&lt;</code> to <code>&amp;lt;</code>)
     * Illegal XML characters are replaced by "#".
     * <p>
     * Note: This method is not intended for HTML. HTML requires more escaping
     * (Umlaute, etc.).
     * 
     * @see #writeEscapedXMLChars(Writer, String), #unescapeXMLChars(String)
     */
    private String escapeXMLChars( final String aString ) {

        if ( aString == null ) {
            return aString;
        }
        // StringBuffer -- only allocated if there are characters that must be escaped
        StringBuilder lBuffer = null;
        // index from where to copy if required
        int lSourceCopyStartPos = 0;
        // scan
        for ( int i = 0; i < aString.length( ); ++i ) {
            final char lCurrentChar = aString.charAt( i );
            String lReplacementForCurrentChar = null;
            // check whether replacement is required
            switch ( lCurrentChar ) {
                case '&':
                    lReplacementForCurrentChar = "&amp;"; //$NON-NLS-1$
                    break;
                case '\"':
                    lReplacementForCurrentChar = "&quot;"; //$NON-NLS-1$
                    break;
                case '<':
                    lReplacementForCurrentChar = "&lt;"; //$NON-NLS-1$
                    break;
                case '>':
                    lReplacementForCurrentChar = "&gt;"; //$NON-NLS-1$
                    break;
                case '\'':
                    lReplacementForCurrentChar = "&apos;"; //$NON-NLS-1$
                    break;
                default:
                    if ( !isValidXMLChar( lCurrentChar ) ) {
                        lReplacementForCurrentChar = "#"; //$NON-NLS-1$
                    }
                    break;
            }
            // perform replacement if required
            if ( lReplacementForCurrentChar != null ) {
                // check buffer allocation
                if ( lBuffer == null ) {
                    // replacement required -- provide enough space
                    lBuffer = new StringBuilder( 2 * aString.length( ) );
                }
                // append "backlog"
                final String lBacklog = aString.substring( lSourceCopyStartPos, i );
                lBuffer.append( lBacklog );
                // append replacement
                lBuffer.append( lReplacementForCurrentChar );
                // update start position for next copy
                lSourceCopyStartPos = i + 1;
            }
        }
        // append final backlog
        if ( lBuffer != null && lSourceCopyStartPos < aString.length( ) ) {
            final String lBacklog = aString.substring( lSourceCopyStartPos, aString.length( ) );
            lBuffer.append( lBacklog );
        }
        // return source or result
        return lBuffer == null ? aString : lBuffer.toString( );
    }

    /**
     * Returns <code>true</code> if <code>c</code> is a valid XML character.
     * (see http://www.w3.org/TR/REC-xml/#charsets)
     */
    private boolean isValidXMLChar( final char c ) {

        final int n = c;

        if ( 0x20 <= n && n <= 0xD7FF ) {
            return true;
        }

        if ( n == 0x09 || n == 0x0A || n == 0x0D ) {
            return true;
        }

        if ( 0xE000 <= n && n <= 0xFFFD ) {
            return true;
        }
        if ( 0x10000 <= n && n <= 0x10FFFF ) {
            return true;
        }

        return false;
    }

}
