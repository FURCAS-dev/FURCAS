package com.sap.tc.moin.repository.core.serialization;

import java.io.OutputStream;

import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.Session;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.core.CoreSession;
import com.sap.tc.moin.repository.core.cps.serializer.CoreSerializerCallbackImpl;
import com.sap.tc.moin.repository.core.cps.serializer.PartitionSerializerImpl;
import com.sap.tc.moin.repository.spi.core.serialization.SpiPartitionWriter;

/**
 * This class only exists for compatibility reasons. As soon as all test cases
 * are adapted to use the new {@link PartitionSerializerImpl}, this class can be
 * deleted.
 */
@Deprecated
public class PartitionWriterImpl implements SpiPartitionWriter {

    private PartitionSerializerImpl serializer;

    /**
     * Use the new {@link PartitionSerializerImpl} instead.
     */
    @Deprecated
    public PartitionWriterImpl( ) {

        serializer = new PartitionSerializerImpl( );
    }

    /**
     * Use the new {@link PartitionSerializerImpl} instead.
     */
    @Deprecated
    public void write( Session session, OutputStream os, ModelPartition partition ) throws java.io.IOException {

        CoreSerializerCallbackImpl callback = new CoreSerializerCallbackImpl( (CoreSession) session, (CoreModelPartition) partition );
        serializer.serialize( os, callback );
    }
}