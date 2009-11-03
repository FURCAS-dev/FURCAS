package com.sap.tc.moin.repository.spi.ps.parser;

import java.io.IOException;
import java.io.InputStream;

/**
 * An instance of {@link SpiCustomParser} represents a component that is able to
 * parse data from an {@link InputStream} in a specific format and make the data
 * (namely model elements, their attributes and links between model elements)
 * available for MOIN. Custom parsers have to be registered first to be known by
 * MOIN, and they report their findings to an instance of
 * {@link SpiParserCallback}, which is passed to the <code>parse</code> method.
 */
public interface SpiCustomParser {

    /**
     * Parses the data in the given {@link InputStream} and reports the parsed
     * information by calling the various methods of {@link SpiParserCallback}.
     * 
     * @param stream The {@link InputStream} containing the data to be parsed.
     * The stream is expected to remain open after parsing.
     * @param callback the {@link SpiParserCallback} to which the parsed
     * information needs to be reported
     * @param fileSize The size in bytes of the data behind the stream, or -1 if
     * the information is not available. This information could for example be
     * used for optimizing the size of a read buffer.
     * @throws IOException
     */
    public void parse( InputStream stream, SpiParserCallback callback, long fileSize ) throws IOException;
}
