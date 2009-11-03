package com.sap.tc.moin.repository.spi.ps;

import com.sap.tc.moin.repository.xm.parser.XmParserConfiguration;
import com.sap.tc.moin.repository.xm.serializer.XmSerializerConfiguration;

/**
 * This class represents the configuration for an XM Parser/Serializer which
 * runs as Custom Parser/Serializer.
 */
public interface SpiXmParserSerializerConfiguration {


    /**
     * Returns the parser configuration.
     * 
     * @return parser configuration, must not be <code>null</code>
     */
    XmParserConfiguration getParserConfiguration( );

    /**
     * Returns the serializer configuration. If <tt>null</tt> is returned then a
     * serialization is not possible.
     * 
     * @return serializer configuration, can be <code>null</code>
     */
    XmSerializerConfiguration getSerializerConfiguration( );

}
