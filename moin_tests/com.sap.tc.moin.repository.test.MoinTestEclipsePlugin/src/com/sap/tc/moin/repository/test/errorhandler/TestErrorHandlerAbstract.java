package com.sap.tc.moin.repository.test.errorhandler;

import java.io.IOException;
import java.io.InputStream;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.core.cps.parser.CoreParserCallbackImpl;
import com.sap.tc.moin.repository.core.cps.parser.PartitionParserImpl;
import com.sap.tc.moin.repository.runtimehost.deployment.PartitionSerializationManagerImpl;
import com.sap.tc.moin.repository.spi.facility.SpiFacility;
import com.sap.tc.moin.repository.spi.ps.parser.SpiParserCallback;
import com.sap.tc.moin.repository.test.core.CoreMoinTest;

@SuppressWarnings( "nls" )
public class TestErrorHandlerAbstract extends CoreMoinTest {

    protected CoreConnection coreConnection = null;

    protected PartitionSerializationManagerImpl serializationManager = null;

    @Override
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );
        coreConnection = getTestHelper( ).getCoreConnection( getMOINConnection( ) );
        SpiFacility facility = (SpiFacility) coreConnection.getSession( ).getMoin( ).getFacilityById( "PF" );
        serializationManager = (PartitionSerializationManagerImpl) facility.getPartitionSerializationManager( );
    }

    @Override
    public void afterTestMethod( ) throws Exception {

        coreConnection = null;
        serializationManager = null;
        super.afterTestMethod( );
    }

    protected void parse( InputStream sourceStream, CoreModelPartition targetPartition ) throws IOException {

        SpiParserCallback callback = new CoreParserCallbackImpl( serializationManager, coreConnection.getSession( ), targetPartition );
        new PartitionParserImpl( ).parse( sourceStream, callback, -1 );
    }
}