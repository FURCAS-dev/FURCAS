/**
 * 
 */
package com.sap.tc.moin.repository.spi.facility;

import java.io.IOException;
import java.io.InputStream;


/**
 * Basic interface for binary content provided as input stream and the total
 * content length.
 * 
 * @author d032434
 */
public interface SpiContentRecord {

    /**
     * @return The length of the content provided as stream.
     */
    public long getContentLength( );

    /**
     * A new data stream will be opened when this method is invoked. The caller
     * is responsible for closing the stream. It depends on the implementation
     * if it is allowed to open a content stream several times.
     * 
     * @return the data stream for the content of the partition
     */
    public InputStream getContentInputStream( ) throws IOException;

}
