package com.sap.tc.moin.repository.spi.core.serialization;

import java.io.IOException;
import java.io.InputStream;

import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.spi.core.SpiSession;

/**
 * Use the new PartitionParserImpl instead.
 */
@Deprecated
public interface SpiPartitionReader {

    /**
     * Use the new PartitionParserImpl instead.
     */
    @Deprecated
    public void read( SpiSession session, InputStream stream, ModelPartition partition ) throws IOException;

    /**
     * Use the new PartitionParserImpl instead.
     */
    @Deprecated
    public void read( InputStream stream, PRI partitionBehindStream, SpiPartitionReaderCallback callback ) throws IOException;
}