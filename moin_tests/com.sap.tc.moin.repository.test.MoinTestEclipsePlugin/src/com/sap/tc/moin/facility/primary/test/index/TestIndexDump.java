package com.sap.tc.moin.facility.primary.test.index;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashSet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sap.junit.IndexOnly;
import com.sap.tc.moin.facility.primary.ipi.IpiIndexManagement;
import com.sap.tc.moin.facility.primary.ipi.IpiIndexManagement.IndexingAction;
import com.sap.tc.moin.facility.primary.query.index.memory.IndexAbstractDumpedImpl;
import com.sap.tc.moin.facility.primary.query.index.memory.IndexConstants;
import com.sap.tc.moin.facility.primary.query.index.memory.IndexWeakHashReference;
import com.sap.tc.moin.repository.DataAreaDescriptor;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.NullPartitionNotEmptyException;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.PartitionsNotSavedException;
import com.sap.tc.moin.repository.ReferencedTransientElementsException;
import com.sap.tc.moin.repository.spi.facility.SpiPartitionStreamProvider;
import com.sap.tc.moin.testcases.case002.B2;
import com.sap.tc.moin.testcases.case002.C2;

public class TestIndexDump extends IndexTestCase {

    protected DataAreaDescriptor daDesc = null;

    // overload index variable in super class with IndexDumpedImpl variant
    protected IndexAbstractDumpedImpl index = null;

    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );

        this.index = (IndexAbstractDumpedImpl) super.index;

        ModelPartition mp = this._testClient1.getOrCreatePartition( "InconsistencyTestSetup" );
        daDesc = mp.getPri( ).getDataAreaDescriptor( );

        for ( Partitionable element : this.getConnectionOne( ).getNullPartition( ).getElements( ) ) {
            mp.assignElement( element );
        }
    }

    @Override
    @After
    public void afterTestMethod( ) throws Exception {

//        ( (ResourceManagementImpl) ( (AbstractFsPrimaryFacility) getFacility( ) ).getResourceManagement( ) ).synchronizeIndexForDataArea( this.daDesc, true );
        super.afterTestMethod( );
    }

    /**
     * Tests if the index implementation removes all elements and links of a
     * partition if there raises an exception during indexPartition() from HDD.
     */
    @Test
    @IndexOnly
    public void testIndexPartitionWithErrorInStream( ) {

        saveConnectionOne( );
        super.deleteAllNonMetamodelsFromIndex( );
        ModelPartition mp1 = this._testClient1.getOrCreatePartition( "QueryTest.indexPartitionWithError.Partition" );
        ModelPartition mp2 = this._testClient1.getOrCreatePartition( "QueryTest.indexPartitionWithError.Partition" );

        C2 c2 = this.createC2( );
        B2 b2 = this.createB2( );

        mp1.assignElement( c2 );
        mp2.assignElement( b2 );

        c2.setB( b2 );

        PRI pri = mp1.getPri( );
        String elementMofId = c2.refMofId( );
        String elementTypeMofId = c2.refMetaObject( ).refMofId( );
        String extMofId = b2.refMofId( );

        // create corrupt partition in input stream
        byte[] mp1array = this.getPartitionByteArray( mp1 );
        byte[] corruptMp1array = new byte[mp1array.length - 3];
        for ( int i = 0; i < corruptMp1array.length; i++ ) {
            corruptMp1array[i] = mp1array[i];
        }
        final InputStream is = new ByteArrayInputStream( corruptMp1array );

        mp1.delete( );
        mp2.delete( );
        this.saveConnectionOne( );

        IndexingAction result = this.index.indexPartition( pri, new SpiPartitionStreamProvider( ) {

            public InputStream getPartitionStream( PRI pri ) {

                return is;
            }
        }, System.currentTimeMillis( ) + 1, true );

        assertSame( "Indexing result is wrong", result, IpiIndexManagement.IndexingAction.EXCEPTION );

        assertNull( "Index still contains the link in priToLinkRecords", this.getPriToLinkRecords( pri.toString( ) ) );
        assertNull( "Index still contains the element in typeToInstances", this.index.getTypeToInstances( ).get( elementTypeMofId ) );
//        assertNull( "Index still contains the element in priToElements", this.index.getPriToElements( ).get( pri.toString( ) ) );
        assertTrue( "Element still in MofIdToElements", this.getMofIdToElements( elementMofId ) == null || this.getMofIdToElements( elementMofId ) instanceof IndexWeakHashReference );
        assertNull( "Partition still in priToIndexPris", this.index.getPriToIndexPri( ).get( pri.toString( ) ) );
        assertNull( "Partition still in daToDcsToIndexPris", this.index.getDaToDcToIndexPris( ).getUnderlyingForRead( pri.getDataAreaDescriptor( ).getDataAreaName( ), pri.getContainerName( ) ) );
        assertNull( "Link still in localMofIdToLinkRecords", this.index.getLocalMofIdToLinkRecords( ).getUnderlyingForRead( elementMofId ) );
        assertNull( "Link still in extMofIdToLinkRecords", this.index.getExtMofIdToLinkRecords( ).getUnderlyingForRead( extMofId ) );

        this.index.doSanityCheck( IndexConstants.SANITY_FORCE_CHECK_ALL );
    }

    @Test
    @IndexOnly
    public void testDumpAndReload( ) throws NullPartitionNotEmptyException, ReferencedTransientElementsException, PartitionsNotSavedException {

        // add a deployed metamodel in editing mode.
        super.loadMetamodelInLocalDataArea( this.getMetamodelContainer( "testcases" ), this.getMetamodelContainer( "testcasesfoundation" ), this.getMetamodelContainer( "textverticalization" ) );

        Object priToIndexPri = this.index.getPriToIndexPri( );
        Object mofIdToElements = this.index.getMofIdToElements( );
        Object priToElements = this.index.getPriToElements( );
        Object typeToInstances = this.index.getTypeToInstances( );
        Object locMofIdToLinkRecords = this.index.getLocalMofIdToLinkRecords( );
        Object extMofIdToLinkRecords = this.index.getExtMofIdToLinkRecords( );
        Object priToLinkRecords = this.index.getPriToLinkRecords( );
        Object topLevelPkg = this.index.getTopLevelPackages_( );
        Object daToDcToIndexPris = this.index.getDaToDcToIndexPris( );

        assertTrue( "Error in dump", this.index.dumpIndex( ) );
        assertTrue( "Error in read", this.index.loadIndex( ) );

        if ( !this.index.getPriToIndexPri( ).equals( priToIndexPri ) ) {
            fail( "PRI tables differ" );
        }
        if ( !this.index.getMofIdToElements( ).equals( mofIdToElements ) ) {
            fail( "MofID/Elements tables differ" );
        }
        if ( !this.index.getPriToElements( ).equals( priToElements ) ) {
            fail( "PRI to Elements tables differ" );
        }
        if ( !this.index.getTypeToInstances( ).equals( typeToInstances ) ) {
            fail( "Types to Elements tables differ" );
        }
        if ( !this.index.getLocalMofIdToLinkRecords( ).equals( locMofIdToLinkRecords ) ) {
            fail( "LocMofIdsToElements tables differ" );
        }
        if ( !this.index.getExtMofIdToLinkRecords( ).equals( extMofIdToLinkRecords ) ) {
            fail( "ExtMofIdsToElements tables differ" );
        }
        if ( !this.index.getPriToLinkRecords( ).equals( priToLinkRecords ) ) {
            fail( "PRI to LinkRecords tables differ" );
        }
        if ( !this.index.getTopLevelPackages_( ).equals( topLevelPkg ) ) {
            fail( "Toplevelpkg tables differ" );
        }
        if ( !this.index.getDaToDcToIndexPris( ).equals( daToDcToIndexPris ) ) {
            fail( "DaToDcToPris tables differ" );
        }

        this.index.doSanityCheck( IndexConstants.SANITY_FORCE_CHECK_ALL );
    }

    /**
     * This test tests if the dumpHandler acts correctly, if the number of
     * elements in the typeToInstances table matches exactly the size of a
     * bucket in the fast list. This is defined in
     * {@link IndexHashSetFastLists.DEF_X_SIZE}. Default is 64.
     */
    @Test
    @IndexOnly
    public void testDumpAndReloadForFastLists( ) {

        this.deleteAllNonMetamodelsFromIndex( );
        final int elemCount = 1 << 6; // IndexHashSetFastLists.DEF_X_SIZE;

        ModelPartition mp = this._testClient1.getOrCreatePartition( "IndexManagement.darffl.Partition" );
        mp.deleteElements( );

        C2 c2 = null;
        for ( int i = 0; i < elemCount; i++ ) {
            c2 = this.createC2( );
            mp.assignElement( c2 );
        }
        this.saveConnectionOne( );

        assertTrue( "Error while dumping. See console for stackprint", this.index.dumpIndex( ) );
        assertTrue( "Error while reloading. See console for stackprint", this.index.loadIndex( ) );

        mp.delete( );
        this.saveConnectionOne( );
    }

    @Test
    @IndexOnly
    public void testDumpAndReloadAfterIndexPartitionWithError( ) {

        this.testIndexPartitionWithErrorInStream( );
        this.index.doSanityCheck( IndexConstants.SANITY_FORCE_CHECK_ALL );

        // must be done to by-pass isIndexChanged check in dump
        ModelPartition mp = this._testClient1.getOrCreatePartition( "fake" );
        saveConnectionOne( );
        mp.delete( );
        saveConnectionOne( );

        assertTrue( "Error in dump", this.index.dumpIndex( ) );
        assertTrue( "Error in read", this.index.loadIndex( ) );

        this.index.doSanityCheck( IndexConstants.SANITY_FORCE_CHECK_ALL );
    }

    @Test
    @IndexOnly
    public void testDumpReadDumpRead( ) {

        this.index.doSanityCheck( IndexConstants.SANITY_FORCE_CHECK_ALL );

        // must be done to by-pass isIndexChanged check in dump
        ModelPartition mp = this._testClient1.getOrCreatePartition( "fake" );
        saveConnectionOne( );
        mp.delete( );
        saveConnectionOne( );

        assertTrue( "Error in first dump", this.index.dumpIndex( ) );
        assertTrue( "Error in first read", this.index.loadIndex( ) );

        // must be done to by-pass isIndexChanged check in dump
        mp = this._testClient1.getOrCreatePartition( "fake" );
        saveConnectionOne( );
        mp.delete( );
        saveConnectionOne( );

        assertTrue( "Error in second dump", this.index.dumpIndex( ) );
        assertTrue( "Error in second read", this.index.loadIndex( ) );

        this.index.doSanityCheck( IndexConstants.SANITY_FORCE_CHECK_ALL );
    }

    @Test
    public void testDumpReadWithUmlaut( ) {

        Object priToIndexPri = this.index.getPriToIndexPri( );
        Object mofIdToElements = this.index.getMofIdToElements( );
        Object priToElements = this.index.getPriToElements( );
        Object typeToInstances = this.index.getTypeToInstances( );
        Object locMofIdToLinkRecords = this.index.getLocalMofIdToLinkRecords( );
        Object extMofIdToLinkRecords = this.index.getExtMofIdToLinkRecords( );
        Object priToLinkRecords = this.index.getPriToLinkRecords( );
        Object topLevelPkg = this.index.getTopLevelPackages_( );
        Object daToDcToIndexPris = this.index.getDaToDcToIndexPris( );

        ModelPartition mp = this._testClient1.getOrCreatePartition( "umlaut_öäßü" );
        saveConnectionOne( );

        this.index.doSanityCheck( IndexConstants.SANITY_FORCE_CHECK_ALL );

        assertTrue( "Error in dump", this.index.dumpIndex( ) );
        assertTrue( "Error in read", this.index.loadIndex( ) );

        if ( !this.index.getPriToIndexPri( ).equals( priToIndexPri ) ) {
            fail( "PRI tables differ" );
        }
        if ( !this.index.getMofIdToElements( ).equals( mofIdToElements ) ) {
            fail( "MofID/Elements tables differ" );
        }
        if ( !this.index.getPriToElements( ).equals( priToElements ) ) {
            fail( "PRI to Elements tables differ" );
        }
        if ( !this.index.getTypeToInstances( ).equals( typeToInstances ) ) {
            fail( "Types to Elements tables differ" );
        }
        if ( !this.index.getLocalMofIdToLinkRecords( ).equals( locMofIdToLinkRecords ) ) {
            fail( "LocMofIdsToElements tables differ" );
        }
        if ( !this.index.getExtMofIdToLinkRecords( ).equals( extMofIdToLinkRecords ) ) {
            fail( "ExtMofIdsToElements tables differ" );
        }
        if ( !this.index.getPriToLinkRecords( ).equals( priToLinkRecords ) ) {
            fail( "PRI to LinkRecords tables differ" );
        }
        if ( !this.index.getTopLevelPackages_( ).equals( topLevelPkg ) ) {
            fail( "Toplevelpkg tables differ" );
        }
        if ( !this.index.getDaToDcToIndexPris( ).equals( daToDcToIndexPris ) ) {
            fail( "DaToDcToPris tables differ" );
        }

        this.index.doSanityCheck( IndexConstants.SANITY_FORCE_CHECK_ALL );

        mp.delete( );
        saveConnectionOne( );
    }

    @Test
    @IndexOnly
    public void testAddAndRemoveElementAndDumpAndReload( ) {

        ModelPartition mp = this._testClient1.getOrCreatePartition( "IndexManagement.AddAndDumpAndReload.Partition" );
        this.fillWithSomeContent( mp );

        C2 c2_1 = this.createC2( );
        mp.assignElement( c2_1 );
        this.saveConnectionOne( );

        C2 c2_2 = this.createC2( );
        mp.assignElement( c2_2 );
        this.saveConnectionOne( );

        this.index.doSanityCheck( IndexConstants.SANITY_FORCE_CHECK_ALL );

        assertTrue( "Error while dumping", this.index.dumpIndex( ) );
        assertTrue( "Error while reloading", this.index.loadIndex( ) );

        c2_2.refDelete( );
        this.saveConnectionOne( );

        this.index.doSanityCheck( IndexConstants.SANITY_FORCE_CHECK_ALL );

        assertTrue( "Error while dumping", this.index.dumpIndex( ) );
        assertTrue( "Error while reloading", this.index.loadIndex( ) );
    }

    @Test
    @IndexOnly
    public void testDataAreaRemove( ) throws NullPartitionNotEmptyException, ReferencedTransientElementsException, PartitionsNotSavedException {

        super.deleteAllNonMetamodelsFromIndex( );
        super.loadMetamodelInLocalDataArea( this.getMetamodelContainer( "testcases" ), this.getMetamodelContainer( "testcasesfoundation" ), this.getMetamodelContainer( "textverticalization" ) );

        int overallCount = 5;


        int partitionNr = 0;
        for ( int i = 0; i < overallCount; i++ ) {
            this.createPartitions( partitionNr++ );
        }
        String daName = IndexConstants.MM_DA_NAME;

        HashSet<String> dels = new HashSet<String>( );
        dels.add( daName );
        assertTrue( this.index.dumpIndex( ) );
        this.index.removeDataAreas( dels );
        assertTrue( "Not all partitions in data area '" + daName + "' have been removed", this.index.getDaToDcToIndexPris( ).getUnderlyingForRead( daName ) == null );
        this.index.doSanityCheck( IndexConstants.SANITY_FORCE_CHECK_ALL );
        assertTrue( this.index.loadIndex( ) );
        this.index.doSanityCheck( IndexConstants.SANITY_FORCE_CHECK_ALL );

        this.deleteAllNonMetamodelsFromIndex( );
        this.saveConnectionOne( );
    }
}
