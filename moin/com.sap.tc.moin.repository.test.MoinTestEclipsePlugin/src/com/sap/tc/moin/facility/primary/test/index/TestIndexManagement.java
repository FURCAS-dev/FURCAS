package com.sap.tc.moin.facility.primary.test.index;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sap.junit.IndexOnly;
import com.sap.tc.moin.facility.primary.ipi.IpiIndexManagement;
import com.sap.tc.moin.facility.primary.ipi.IpiIndexManagement.IndexingAction;
import com.sap.tc.moin.repository.DataAreaDescriptor;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.spi.core.SpiLink;
import com.sap.tc.moin.repository.spi.facility.SpiMofRomInjectionService.SpiMofRomPartitionContent;
import com.sap.tc.moin.testcases.case002.B2;
import com.sap.tc.moin.testcases.case002.C2;

public class TestIndexManagement extends IndexTestCase {

    protected DataAreaDescriptor daDesc = null;

    private IpiIndexManagement index = null;

    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );

        ModelPartition mp = this._testClient1.getOrCreatePartition( "InconsistencyTestSetup" );
        daDesc = mp.getPri( ).getDataAreaDescriptor( );

        for ( Partitionable element : this.getConnectionOne( ).getNullPartition( ).getElements( ) ) {
            mp.assignElement( element );
        }

        this.index = super.index;
    }

    @Override
    @After
    public void afterTestMethod( ) throws Exception {

//        ( (ResourceManagementImpl) ( (AbstractFsPrimaryFacility) getFacility( ) ).getResourceManagement( ) ).synchronizeIndexForDataArea( this.daDesc, true );

        super.afterTestMethod( );

    }

    @Test
    @IndexOnly
    public void testGetPartitionTimestamp( ) {

        ModelPartition mp = this._testClient1.getOrCreatePartition( makePartitionName( "getTimestamp" ) );
        mp.deleteElements( );

        assertTrue( "Unexpected timestamp returned", this.index.getPartitionTimestamp( mp.getPri( ) ) == -1 );

        long timestamp = System.currentTimeMillis( );
        saveConnectionOne( );

        long ts = this.index.getPartitionTimestamp( mp.getPri( ) );
        assertTrue( "Timestamp expected", ts != -1 );
        assertTrue( "Mal timestamp: " + ts, timestamp <= ts );
    }

    @Test
    @IndexOnly
    public void testIsPartitionIndexed( ) {

        ModelPartition mp = this._testClient1.getOrCreatePartition( "QueryTest.ipe.Partition" );
        mp.deleteElements( );
        this.saveConnectionOne( );

        PRI pri = mp.getPri( );

        assertTrue( "Expected true", this.index.isPartitionIndexed( pri ) );

        mp.delete( );
        this.saveConnectionOne( );

        assertFalse( "Expected false", this.index.isPartitionIndexed( pri ) );

    }

    @Test
    @IndexOnly
    public void testIndexingRenamedPartition( ) {

        ModelPartition oldName = this._testClient1.getOrCreatePartition( "renametest.oldName" );
        PRI oldPri = oldName.getPri( );
        oldName.deleteElements( );

        B2 b2 = this.createB2( );
        C2 c2 = this.createC2( );
        oldName.assignElement( b2 );
        oldName.assignElement( c2 );
        c2.setB( b2 );

        this.saveConnectionOne( );

        ModelPartition newName = this._testClient1.createPartition( "renametest.newName" );

        Collection<Partitionable> elements = oldName.getElements( );
        for ( Partitionable elem : elements ) {
            newName.assignElement( elem );
        }

        oldName.delete( );

        this.saveConnectionOne( );

        assertTrue( "newPartition not indexed", this.index.isPartitionIndexed( newName.getPri( ) ) );
        assertFalse( "oldPartition still indexed", this.index.isPartitionIndexed( oldPri ) );

        newName.delete( );
    }

//    @Test
//    public void testSynchronizeOfAllDataAreas( ) throws Exception {
//
//        this.deleteAllNonMetamodelsFromIndex( );
//
//        SyncReport syncReport = this.index.synchronize( SyncKind.MODEL_CONTENT, new PRI[0], new long[0], new SpiPartitionStreamProvider( ) {
//
//            public InputStream getPartitionStream( PRI pri ) {
//
//                fail( "getPartitionStream should not be called from index in this test" );
//                return null;
//            }
//        }, false );
//
//        assertTrue( syncReport.ADDED.isEmpty( ) );
//        assertTrue( syncReport.UPDATED.isEmpty( ) );
//        assertTrue( syncReport.DELETED.isEmpty( ) );
//        assertTrue( syncReport.NOP.isEmpty( ) );
//        assertTrue( syncReport.EXCEPTION.isEmpty( ) );
//        boolean failed = ( (IndexImpl) this.index ).getDaToDcToIndexPris( ).getUnderlyingForRead( IndexConstants.MM_DA_NAME ) == null;
//
//        if ( failed ) {
//            getTestHelper( ).reset( );
//            fail( "Metamodels have been deleted" );
//        }
//    }

    @Test
    public void testMofRomInjection( ) throws Exception {

        ModelPartition wrappedNewMofRom = this._testClient1.createPartition( "newMofRom" );

        final CoreModelPartition newMofRom = getTestHelper( ).getCoreModelPartition( wrappedNewMofRom );
        ModelPartition other = this._testClient1.createPartition( "otherNotMofromPartition" );

        wrappedNewMofRom.createElement( C2.class ).setB( other.createElement( B2.class ) );

        PRI pri = newMofRom.getPri( );
        long timestamp = 1234;
        SpiMofRomPartitionContent mofRomContent = new SpiMofRomPartitionContent( ) {

            public List<Partitionable> getElements( ) {

                return new ArrayList<Partitionable>( newMofRom.getElements( ) );
            }

            public List<SpiLink> getLinks( ) {

                return new ArrayList<SpiLink>( newMofRom.getLinks( ) );
            }

            public PRI getPri( ) {

                return newMofRom.getPri( );
            }
        };
        try {
            this.index.indexMofRomPartition( mofRomContent, timestamp );
            this.index.indexMofRomPartition( mofRomContent, timestamp );
            this.index.indexMofRomPartition( mofRomContent, timestamp );
        } catch ( Exception e ) {
            e.printStackTrace( );
            fail( "Exception during mofrom injection (see console output): " + e.getMessage( ) );
        }
        assertTrue( "Partition not indexed: " + pri, index.isPartitionIndexed( pri ) );
        assertTrue( this.index.removePartition( pri ) == IndexingAction.DELETED );
        assertFalse( "Partition still in index: " + pri, index.isPartitionIndexed( pri ) );

        other.delete( );
        wrappedNewMofRom.delete( );
    }

    @Test
    public void testErrorInMofRomInjection( ) throws Exception {

        ModelPartition wrappedNewMofRom = this._testClient1.createPartition( "newMofRom2" );

        final CoreModelPartition newMofRom = getTestHelper( ).getCoreModelPartition( wrappedNewMofRom );
        ModelPartition other = this._testClient1.createPartition( "otherNotMofromPartition2" );

        wrappedNewMofRom.createElement( C2.class ).setB( other.createElement( B2.class ) );

        PRI pri = newMofRom.getPri( );
        long timestamp = 1234;
        SpiMofRomPartitionContent mofRomContent = new SpiMofRomPartitionContent( ) {

            public List<Partitionable> getElements( ) {

                return new ArrayList<Partitionable>( newMofRom.getElements( ) );
            }

            public List<SpiLink> getLinks( ) {

                throw new RuntimeException( "Exception thrown in test" );
            }

            public PRI getPri( ) {

                return newMofRom.getPri( );
            }
        };
        try {
            this.index.indexMofRomPartition( mofRomContent, timestamp );
            fail( "expected exception during mof rom indexing" );
        } catch ( Exception e ) {
            // expected
        }
        assertFalse( "Partition indexed anyway: " + pri, index.isPartitionIndexed( pri ) );
        assertTrue( this.index.removePartition( pri ) == IndexingAction.NOP );

        other.delete( );
        wrappedNewMofRom.delete( );
    }
}
