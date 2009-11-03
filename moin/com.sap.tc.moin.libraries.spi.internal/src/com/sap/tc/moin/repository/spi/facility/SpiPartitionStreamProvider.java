package com.sap.tc.moin.repository.spi.facility;

import java.io.InputStream;

import com.sap.tc.moin.repository.PRI;

/**
 * Provider for partition input streams.
 * <p>
 * This interface enables to abstract from a concrete persistent storage as well
 * as to temporally decouple the creation of a stream.
 * 
 * @author d026715
 */
public interface SpiPartitionStreamProvider {

    /**
     * Returns an input stream for the given partition descriptor.
     * 
     * @param pri The {@link PRI}.
     * @return InputStream An {@link InputStream} to the partition content for
     * the given {@link PRI}.
     */
    public InputStream getPartitionStream( PRI pri );
}
