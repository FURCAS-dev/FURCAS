package com.sap.tc.moin.xm.kernel.impl.serializer.sax;



import java.io.IOException;
import java.io.OutputStream;

import com.sap.tc.moin.repository.exception.MoinNullPointerException;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;


/**
 * Buffering writer collects strings in a string buffer and writes the result to
 * an output stream.
 */
final class PWriter {

    private static final MoinLogger LOGGER = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_XM, MoinLocationEnum.MOIN_XM_RT, PWriter.class );

    private final OutputStream stream;

    private boolean trouble = false;

    private Exception exc;

    private final StringBuilder sb;


    /**
     * Constructor.
     * 
     * @param stream output stream
     * @throws NullPointerException if the parameter is <code>null</code>
     */
    PWriter( final OutputStream ous ) {

        if ( ous == null ) {
            throw new MoinNullPointerException( "ous" ); //$NON-NLS-1$
        }
        stream = ous;
        sb = new StringBuilder( );
    }

    void println( final String s ) {

        print( s + '\n' );
    }

    void print( final String s ) {

        sb.append( s );
    }

    void flush( ) {

        try {
            if ( sb.length( ) > 0 ) {
                final byte[] ar = sb.toString( ).getBytes( "UTF-8" ); //$NON-NLS-1$
                sb.setLength( 0 );
                stream.write( ar, 0, ar.length );
            }
        } catch ( final Exception ex ) {//$JL-EXC$
            trouble = true;
            exc = ex;
        }
    }

//    boolean isError( ) {
//
//        return trouble;
//    }

    Exception getException( ) {

        return exc;
    }


//    void write( final byte[] array ) {
//
//        try {
//            flush( );
//            stream.write( array );
//        } catch ( final IOException e ) {//$JL-EXC$
//            LOGGER.trace( e, MoinSeverity.ERROR, "IOException occured during writing to the output stream" ); //$NON-NLS-1$
//            trouble = true;
//            exc = e;
//        }
//    }


    void close( ) {

        try {
            stream.close( );
        } catch ( final IOException e ) {//$JL-EXC$
            trouble = true;
            exc = e;
        }
    }
}
