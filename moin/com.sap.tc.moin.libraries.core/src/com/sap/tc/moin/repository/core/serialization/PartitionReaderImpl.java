package com.sap.tc.moin.repository.core.serialization;

import java.io.IOException;
import java.io.InputStream;

import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.core.CoreSession;
import com.sap.tc.moin.repository.core.cps.parser.CoreParserCallbackImpl;
import com.sap.tc.moin.repository.core.cps.parser.PartitionParserImpl;
import com.sap.tc.moin.repository.spi.core.SpiSession;
import com.sap.tc.moin.repository.spi.core.serialization.SpiPartitionReader;
import com.sap.tc.moin.repository.spi.core.serialization.SpiPartitionReaderCallback;

/**
 * This class only exists for compatibility reasons. As soon as all test cases
 * are adapted to use the new {@link PartitionParserImpl}, this class can be
 * deleted.
 */
@Deprecated
public final class PartitionReaderImpl implements SpiPartitionReader {

    private PartitionParserImpl parser;

    public PartitionReaderImpl( ) {

        parser = new PartitionParserImpl( );
    }

    public void read( SpiSession session, InputStream stream, ModelPartition partition ) throws java.io.IOException {

        CoreSession coreSession = (CoreSession) session;
        CoreParserCallbackImpl callback = new CoreParserCallbackImpl( ( coreSession.getMoin( ) ).getPartitionSerializationManager( ), coreSession, (CoreModelPartition) partition );
        parser.parse( stream, callback, -1 );
    }

    public void read( InputStream stream, PRI partitionBehindStream, SpiPartitionReaderCallback callback ) throws IOException {

        throw new UnsupportedOperationException( );
    }
}