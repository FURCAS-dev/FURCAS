package com.sap.tc.moin.repository.errorhandler.test;

import java.io.ByteArrayInputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sap.tc.moin.facility.primary.ide.IdePrimaryFacility;
import com.sap.tc.moin.facility.primary.ipi.IpiIndexManagement;
import com.sap.tc.moin.primary.facility.test.ide.FacilityIdeMoinTest;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.mql.MQLProcessor;
import com.sap.tc.moin.repository.mql.MQLResultSet;
import com.sap.tc.moin.repository.runtimehost.deployment.PartitionSerializationManagerImpl;
import com.sap.tc.moin.repository.spi.facility.SpiFacility;
import com.sap.tc.moin.repository.spi.ps.SpiType;
import com.sap.tc.moin.repository.spi.ps.errorhandler.SpiDefaultParserErrorHandler;
import com.sap.tc.moin.repository.spi.ps.errorhandler.SpiParserErrorHandler;
import com.sap.tc.moin.repository.spi.ps.parser.SpiElement;
import com.sap.tc.moin.repository.spi.ps.parser.SpiParserCallback;
import com.sap.tc.moin.test.fw.TestMetaModels;
import com.sap.tc.moin.testcases.case004.B4;


public class TestErrorhandlerMQL extends FacilityIdeMoinTest {

    private SpiParserErrorHandler parserErrorHandler;

    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );
        PartitionSerializationManagerImpl serializationManager = (PartitionSerializationManagerImpl) ( (SpiFacility) getFacility( ) ).getPartitionSerializationManager( );
        parserErrorHandler = serializationManager.getParserErrorHandler( TestMetaModels.TESTCASES_CN, null );
        serializationManager.setParserErrorHandler( TestMetaModels.TESTCASES_CN, new TestMqlErrorHandler( ) );
    }

    @Override
    @After
    public void afterTestMethod( ) throws Exception {

        PartitionSerializationManagerImpl serializationManager = (PartitionSerializationManagerImpl) ( (SpiFacility) getFacility( ) ).getPartitionSerializationManager( );
        serializationManager.setParserErrorHandler( TestMetaModels.TESTCASES_CN, this.parserErrorHandler );
        super.afterTestMethod( );
    }

    @Test( timeout = 30000 )
    public void testErrorHandledPartitionIndexedAndInMqlResult( ) throws Exception {

        CoreConnection coreConn = getTestHelper( ).getCoreConnection( this._testClient1.getConnection( ) );

        CoreModelPartition mp = getTestHelper( ).getCoreModelPartition( this._testClient1.createPartition( "mqlErrorhandlerTest1" ) );
        this._testClient1.getConnection( ).save( );

        long beforeTs = mp.getPersistedTimestamp( );
        PRI pri = mp.getPri( );
        mp = null;
        IFile mpFile = ( (IdePrimaryFacility) getFacility( ) ).getFile( pri );

        while ( System.currentTimeMillis( ) - beforeTs < 100 ) {
            try {
                this.wait( 100 );
            } catch ( Exception e ) {

            }
        }

        mpFile.setContents( this.getContentOfTestPartition1( ), IResource.FORCE, null );

        IpiIndexManagement index = ( (IpiIndexManagement) ( (SpiFacility) getFacility( ) ).getCoreQueryService( ) );

        // wait until the resource change event has evicted mp (hopefully)
        while ( coreConn.getSession( ).getWorkspace( ).getPartitionManager( ).getPartition( coreConn.getSession( ), pri, false ) != null || //
                index.getPartitionTimestamp( pri ) == beforeTs ) {
            try {
                this.wait( 50 );
            } catch ( Exception e ) {

            }
        }

        MQLProcessor mql = coreConn.getMQLProcessor( );
        String query = "select b4 from testcases::case004::B4 as b4";
        MQLResultSet rs = mql.execute( query ); //$NON-NLS-1$
        assertFalse( rs.isEmpty( ) );

        String mofId = "45ED2E29050B855406AE42C81E9EA97E02EFA276";
        this.checkIncludesElement( rs, pri, mofId );

        // create a new element in the partially loaded partition, delete it and save the partition
        ModelPartition m = this._testClient1.getConnection( ).getPartition( pri );
        mp = getTestHelper( ).getCoreModelPartition( m );
        m.createElement( B4.class ).refDelete( );
        // wait before save
        while ( System.currentTimeMillis( ) - mp.getPersistedTimestamp( ) < 100 ) {
            try {
                this.wait( 100 );
            } catch ( Exception e ) {

            }
        }
        this._testClient1.getConnection( ).save( );

        // evict partition
        coreConn.getSession( ).getWorkspace( ).getPartitionManager( ).evictPartitionForced( mp );

        // query for instances of B4
        MQLResultSet rs2 = mql.execute( query );
        assertFalse( rs2.isEmpty( ) );

        // check index 1
        this.checkIncludesElement( rs2, pri, mofId );

        // check partition content
        mp = getTestHelper( ).getCoreModelPartition( this._testClient1.getConnection( ).getPartition( pri ) );
        assertFalse( mp.isMemoryStateDifferentFromPersistentStateAfterLoad( ) );

        // check index 2
        assertEquals( mp.getPersistedTimestamp( ), index.getPartitionTimestamp( pri ) );

        this._testClient1.getConnection( ).getPartition( pri ).delete( );
        this._testClient1.getConnection( ).save( );
    }

    /*
     * private
     */
    private void checkIncludesElement( MQLResultSet rs, PRI pri, String mofId ) {

        boolean found = false;
        for ( MRI mri : rs.getMris( "b4" ) ) {
            if ( mri.getPri( ) == pri && mri.getMofId( ).equals( mofId ) ) {
                found = true;
                break;
            }
        }
        assertTrue( "result: " + rs.getMris( "b4" ), found );
    }

    private final class TestMqlErrorHandler extends SpiDefaultParserErrorHandler {

        @Override
        public SpiType handleUnknownType( SpiParserCallback callback, String typeMofId, String metamodelContainer, String dotSeparatedQualifiedName ) {

            if ( dotSeparatedQualifiedName.equals( "testcases.case004.B4old" ) ) {
                return callback.getType( "45F120A5CE8778345E6E45142026DF2289212782", TestMetaModels.TESTCASES_CN, "testcases.case004.B4" );
            } else {
                throw new IllegalStateException( "unexpected qualified name " + dotSeparatedQualifiedName );
            }
        }

        @Override
        public boolean handleIllegalAttributeValue( SpiParserCallback callback, SpiElement element, String attributeName, Object attributeValue ) {

            throw new UnsupportedOperationException( "unexpected call" );
        }
    }

    private ByteArrayInputStream getContentOfTestPartition1( ) throws Exception {

        StringBuilder buf = new StringBuilder( );
        buf.append( "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" );
        buf.append( "<Partition xmlns:m='http://xml.sap.com/moin'>" );
        buf.append( "<C n='test.sap.com/tc/moin/metamodel/testcases' i='1' v=''/>" );
        buf.append( "<M c='1' q='testcases.case004.B4old' i='45F120A5CE8778345E6E45142026DF2289212783'/>" ); // was 45F120A5CE8778345E6E45142026DF2289212782
        buf.append( "<testcases.case004.B4old m:c='1' m:i='45ED2E29050B855406AE42C81E9EA97E02EFA276'/>" );
        buf.append( "</Partition>" );
        return new ByteArrayInputStream( buf.toString( ).getBytes( ) );
    }
}
