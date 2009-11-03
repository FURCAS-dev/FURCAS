package com.sap.tc.moin.repository.spi.ps;

import com.sap.tc.moin.repository.spi.ps.parser.SpiCustomParser;
import com.sap.tc.moin.repository.spi.ps.serializer.SpiCustomSerializer;

/**
 * Factory for custom parsers/serializers. This has to be implemented by custom
 * parser/serializer providers.
 * 
 * @author d026715
 */
public interface SpiCustomParserSerializerFactory {

    /**
     * Id of the MOIN built-in serialization factory.
     */
    public final String DEFAULT_SERIALIZATION = "com.sap.tc.moin.repository.DefaultParserSerializer"; //$NON-NLS-1$

    /**
     * Returns an instance of a custom parser.
     * 
     * @return
     */
    public SpiCustomParser getParser( );

    /**
     * Returns an instance of a custom serializer.
     * 
     * @return
     */
    public SpiCustomSerializer getSerializer( );
}
