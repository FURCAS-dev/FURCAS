package com.sap.tc.moin.repository.cps.test;

import com.sap.tc.moin.repository.spi.ps.SpiCustomParserSerializerFactory;
import com.sap.tc.moin.repository.spi.ps.parser.SpiCustomParser;
import com.sap.tc.moin.repository.spi.ps.serializer.SpiCustomSerializer;

/**
 * Test custom parser factory.
 * 
 * @author d026715
 */
public class ReadOnlyTestCustomParserFactory implements SpiCustomParserSerializerFactory {

    public static final String[] SUFFIXES = { ".cpstestreadonly" };

    public SpiCustomParser getParser( ) {

        return new SimpleTestCustomParser( );
    }

    public SpiCustomSerializer getSerializer( ) {

        // no serializer, readonly
        return null;
    }

}