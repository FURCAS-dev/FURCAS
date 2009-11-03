package com.sap.tc.moin.repository.spi.core.serialization;

import java.io.OutputStream;

import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.Session;

/**
 * Use the new {@link PartitionSerializerImpl} instead.
 */
@Deprecated
public interface SpiPartitionWriter {

    /**
     * Use the new {@link PartitionSerializerImpl} instead.
     */
    @Deprecated
    public void write( Session session, OutputStream os, ModelPartition partition ) throws java.io.IOException;
}