package com.sap.tc.moin.repository.core.cps.parser;

import java.io.IOException;
import java.io.InputStream;

import com.sap.tc.moin.repository.spi.ps.parser.SpiCustomParser;
import com.sap.tc.moin.repository.spi.ps.parser.SpiParserCallback;
import com.sap.tc.moin.repository.spi.ps.parser.SpiPartitionParseException;

public final class PartitionParserImpl implements SpiCustomParser {

    private SaxReader saxParser = new SaxReader( );

    public void parse( InputStream stream, SpiParserCallback callback, long fileSize ) throws IOException {

        if ( stream == null ) {
            // TODO: Think about MoinIOException ... and localize texts then
            throw new IOException( "The stream parameter must not be 'null'." ); //$NON-NLS-1$
        }
        if ( callback == null ) {
            // TODO: Think about MoinIOException ... and localize texts then
            throw new IOException( "The callback parameter must not be 'null'." ); //$NON-NLS-1$
        }
        try {
            saxParser.parse( stream, callback, fileSize );
        } catch ( SpiPartitionParseException ex ) {
            throw new IOException( ex );
        } finally {
            saxParser.reset( );
        }
    }
}