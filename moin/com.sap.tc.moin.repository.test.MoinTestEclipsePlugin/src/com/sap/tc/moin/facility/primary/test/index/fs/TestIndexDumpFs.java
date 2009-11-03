package com.sap.tc.moin.facility.primary.test.index.fs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sap.junit.IndexOnly;
import com.sap.tc.moin.facility.primary.PrimaryFacility;
import com.sap.tc.moin.facility.primary.ipi.IpiIndexManagement.IndexingAction;
import com.sap.tc.moin.facility.primary.ipi.IpiIndexManagement.SyncReport;
import com.sap.tc.moin.facility.primary.ipi.fs.IpiFsFacilityForTest;
import com.sap.tc.moin.facility.primary.persistence.fs.ResourceManagementImpl;
import com.sap.tc.moin.facility.primary.query.index.memory.IndexConstants;
import com.sap.tc.moin.facility.primary.query.index.memory.IndexFsDumpedImpl;
import com.sap.tc.moin.facility.primary.query.index.memory.IndexImpl;
import com.sap.tc.moin.facility.primary.query.index.memory.IndexPri;
import com.sap.tc.moin.facility.primary.riservice.CheckedResourceIdentifierFactoryImpl;
import com.sap.tc.moin.facility.primary.test.index.IndexTestCase;
import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.DataAreaDescriptor;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.spi.facility.SpiPartitionStreamProvider;
import com.sap.tc.moin.repository.spi.util.SpiDelegator;
import com.sap.tc.moin.testcases.case002.B2;
import com.sap.tc.moin.testcases.case002.C2;
import com.sap.tc.moin.testcasesfoundation.case001f.A1f;

public class TestIndexDumpFs extends IndexTestCase {

    protected DataAreaDescriptor daDesc = null;

    // overload index variable in super class with IndexDumpedImpl variant
    protected IndexFsDumpedImpl index = null;

    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );

        this.index = (IndexFsDumpedImpl) super.index;

        ModelPartition mp = this._testClient1.getOrCreatePartition( "InconsistencyTestSetup" );
        daDesc = mp.getPri( ).getDataAreaDescriptor( );

        for ( Partitionable element : this.getConnectionOne( ).getNullPartition( ).getElements( ) ) {
            mp.assignElement( element );
        }
    }

    @Override
    @After
    public void afterTestMethod( ) throws Exception {

        ( (ResourceManagementImpl) ( (IpiFsFacilityForTest) super.getFacility( ) ).getResourceManagement( ) ).synchronizeIndexForDataArea( this.daDesc, true );
        super.afterTestMethod( );
    }

    @Test
    @IndexOnly
    public void testMissingDumpSignFile( ) throws FileNotFoundException, IOException {

        assertTrue( "Error in dump", this.index.dumpIndex( ) );

        String filePath = this.index.getIndexDumpFilePath( );
        File signFile = new File( filePath + IndexConstants.DUMP_FILE_SIGN_EXT );
        File bkupFile = new File( filePath + IndexConstants.DUMP_FILE_SIGN_EXT + ".bkup" );

        File backup = new File( filePath + ".backup" );
        File f = new File( filePath );

        this.copyFile( f, backup );

        if ( bkupFile.exists( ) ) {
            assertTrue( "could not delete backup file", bkupFile.delete( ) );
        }
        assertTrue( "signFile not existent", signFile.exists( ) );
        assertTrue( "could not rename signfile", signFile.renameTo( bkupFile ) );
        assertFalse( this.index.loadIndex( ) );
        assertTrue( "could not rename backup file", bkupFile.renameTo( signFile ) );

        assertTrue( "Could not rename corrupt to index file", backup.renameTo( f ) );

        assertTrue( this.index.loadIndex( ) );

        this.index.doSanityCheck( IndexConstants.SANITY_FORCE_CHECK_ALL );
    }

    @Test
    @IndexOnly
    // TODO refactor to abstract index dump test
    public void testDumpVersion( ) throws FileNotFoundException, IOException {

        assertTrue( "Error in dump", this.index.dumpIndex( ) );

        String filePath = this.index.getIndexDumpFilePath( );
        String signPath = filePath + IndexConstants.DUMP_FILE_SIGN_EXT;

        File backup = new File( filePath + ".backup" );
        File f = new File( filePath );
        File old = new File( filePath + ".old_version" );
        File signBackup = new File( signPath + ".backup" );
        File signF = new File( signPath );


        this.copyFile( f, backup );
        this.copyFile( signF, signBackup );

        FileInputStream fis = new FileInputStream( f );
        byte[] oldVersionBytes = new byte[fis.available( )];
        // set version number to zero
        oldVersionBytes[0] = 0;
        oldVersionBytes[1] = 0;
        oldVersionBytes[2] = 0;
        oldVersionBytes[3] = 0;
        fis.read( oldVersionBytes, 4, oldVersionBytes.length - 4 );
        FileOutputStream fos = new FileOutputStream( old );
        fos.write( oldVersionBytes );
        fos.flush( );
        fos.close( );
        fis.close( );
        assertTrue( "Could not delete index file", f.delete( ) );
        assertTrue( "Could not rename corrupt to index file", old.renameTo( f ) );

        assertFalse( "Expected false. See log for stacktrace", this.index.loadIndex( ) );

        this.index.doSanityCheck( IndexConstants.SANITY_FORCE_CHECK_ALL );

        assertFalse( "Could delete old-versioned index file", f.delete( ) );
        assertTrue( "Could not rename backup file to index file", backup.renameTo( f ) );
        assertFalse( "Could delete old-versioned index sign file", signF.delete( ) );
        assertTrue( "Could not rename backup file to index sign file", signBackup.renameTo( signF ) );

        assertTrue( "Could not restore index", this.index.loadIndex( ) );
    }


    @Test
    @IndexOnly
    // TODO move to abstract index dump tests
    public void testIsIndexChangedInDump( ) {

        // be sure that index is changed
        ModelPartition mp = this._testClient1.getOrCreatePartition( "fake" );
        saveConnectionOne( );
        mp.delete( );
        saveConnectionOne( );

        // isIndexChanged == true
        this.index.dumpIndex( );
        long timestamp1 = ( new File( this.index.getIndexDumpFilePath( ) ) ).lastModified( );

        try {
            Thread.sleep( 50 );
        } catch ( Exception e ) {
        }

        // isIndexChanged == false
        this.index.dumpIndex( );
        long timestamp2 = ( new File( this.index.getIndexDumpFilePath( ) ) ).lastModified( );

        assertTrue( "Unexpected dump of index. timestamps of dump are not equal", timestamp1 == timestamp2 );

        mp = this._testClient1.getOrCreatePartition( "fake" );
        saveConnectionOne( );
        mp.delete( );
        saveConnectionOne( );

        // isIndexChanged == true
        this.index.dumpIndex( );
        long timestamp3 = ( new File( this.index.getIndexDumpFilePath( ) ) ).lastModified( );

        assertTrue( "Index not dumped. timestamps are equal", timestamp2 != timestamp3 );
    }

    /**
     * Tests the return if the index tries to dump to an existing, read-only
     * file. Expects an exception in console.
     */
    @Test
    @IndexOnly
    public void testSaveToReadOnlyIndexDumpFile( ) {

        this.index.dumpIndex( );

        ModelPartition mp = this._testClient1.getOrCreatePartition( "fake" );
        saveConnectionOne( );
        mp.delete( );
        saveConnectionOne( );

        String filePath = this.index.getIndexDumpFilePath( );
        File f = new File( filePath );
        assertTrue( "Could not make dump file read only", f.setReadOnly( ) );

        assertFalse( "Expected false. See console for stacktrace", this.index.dumpIndex( ) );

        f.delete( );
    }

    /**
     * Tests the return if the index tries to load a corrupt index dump file.
     * Expects an exception in console.
     * 
     * @throws FileNotFoundException
     * @throws IOException
     */
    @Test
    @IndexOnly
    // TODO make abstract testable
    public void testLoadCorruptIndexDumpFile( ) throws FileNotFoundException, IOException {

        for ( int i = 0; i < 5; i++ ) {
            this.createPartitions( i );
        }
        this.index.dumpIndex( );

        String filePath = this.index.getIndexDumpFilePath( );
        String signPath = filePath + IndexConstants.DUMP_FILE_SIGN_EXT;

        File backup = new File( filePath + ".old" );
        File f = new File( filePath );
        File corrupt = new File( filePath + ".corrupt" );
        File signBackup = new File( signPath + ".old" );
        File signF = new File( signPath );

        this.copyFile( f, backup );
        this.copyFile( signF, signBackup );

        FileInputStream fis = new FileInputStream( f );
        byte[] corruptBytes = new byte[fis.available( ) / 2];
        fis.read( corruptBytes, 0, corruptBytes.length );
        FileOutputStream fos = new FileOutputStream( corrupt );
        fos.write( corruptBytes );
        fos.flush( );
        fos.close( );
        fis.close( );
        assertTrue( "Could not delete index file", f.delete( ) );
        assertTrue( "Could not rename corrupt to index file", corrupt.renameTo( f ) );

        assertFalse( "Expected false. See console for stacktrace", this.index.loadIndex( ) );

        this.index.doSanityCheck( IndexConstants.SANITY_FORCE_CHECK_ALL );

        assertFalse( "Could delete corrupt index file", f.delete( ) );
        assertTrue( "Could not rename backup file to index file", backup.renameTo( f ) );
        assertFalse( "Could delete corrupt index sign file", signF.delete( ) );
        assertTrue( "Could not rename backup file to index sign file", signBackup.renameTo( signF ) );

        assertTrue( "Could not restore index", this.index.loadIndex( ) );

        this.index.doSanityCheck( IndexConstants.SANITY_FORCE_CHECK_ALL );
    }

    @Test
    // TODO make abstract testable
    public void testLifeCycleDataAreaRemove( ) throws Exception {

        // THIS SETUP IS MADE BECAUSE OF THE FREAKING AUTOBUILDER. ENJOY FIGURING OUT HOW IT WORKS :P

        String daName = this.getPartitionOne( ).getPri( ).getDataAreaDescriptor( ).getDataAreaName( );
        this.getPartitionOne( ).assignElement( this.createB2( ) );
        this.saveConnectionOne( );
        assertTrue( "Could not dump index to file system", this.index.dumpIndex( ) );

        CheckedResourceIdentifierFactoryImpl riFac = ( (CheckedResourceIdentifierFactoryImpl) SpiDelegator.dismantle( super.getFacility( ) ).getRIFactory( ) );
        Field indexChangedField = IndexImpl.class.getDeclaredField( "isIndexChanged" );
        indexChangedField.setAccessible( true );

        String indexDumpFile = this.index.getIndexDumpFilePath( );

        File f = new File( indexDumpFile );
        File[] files = f.getParentFile( ).listFiles( );
        File[] renFiles = new File[files.length];
        for ( int i = 0; i < files.length; i++ ) {
            File ren = new File( files[i].getParent( ) + "\\cp_" + files[i].getName( ) );
            renFiles[i] = ren;
            assertTrue( files[i].renameTo( ren ) );
        }
        File dumpFile = new File( f.getParent( ) + "\\cp_" + f.getName( ) );
        assertTrue( "Dumpfile does not exist after test setup: " + dumpFile.toString( ), dumpFile.exists( ) );
        indexDumpFile = dumpFile.getAbsolutePath( );
        long firstDumpTime = dumpFile.lastModified( );

        IndexFsDumpedImpl testIndex1 = new IndexFsDumpedImpl( PrimaryFacility.FACILITY_ID, "mySuperTestMOIN1", getTestHelper( ).getHousekeepingReferenceQueue( ), indexDumpFile );
        testIndex1.bind( riFac );
        testIndex1.initialize( );
        testIndex1.finalizeStartup( );

        assertNotNull( testIndex1.getDaToDcToIndexPris( ).getUnderlyingForRead( daName ) );

        try {
            Thread.sleep( 100 );
        } catch ( Exception e ) {
            // nothing
        }

        testIndex1.tearDown( );
        assertNull( testIndex1.getDaToDcToIndexPris( ).getUnderlyingForRead( daName ) );
        testIndex1 = null;
        assertTrue( "Dumpfile does not exist after first restart&teardown: " + dumpFile.toString( ), dumpFile.exists( ) );
        long sndDumpTime = dumpFile.lastModified( );
        assertTrue( "First: " + firstDumpTime + ", Current: " + sndDumpTime, firstDumpTime < sndDumpTime );

        IndexFsDumpedImpl testIndex2 = new IndexFsDumpedImpl( PrimaryFacility.FACILITY_ID, "mySuperTestMOIN2", getTestHelper( ).getHousekeepingReferenceQueue( ), indexDumpFile );
        testIndex2.bind( riFac );
        testIndex2.initialize( );
        testIndex2.finalizeStartup( );

        Object[][] indexPris = testIndex2.getDaToDcToIndexPris( ).getUnderlyingForRead( daName );
        assertNull( "Data area was not empty: " + indexPris, indexPris );

        testIndex2.tearDown( );
        testIndex2 = null;

        for ( File renFile : renFiles ) {
            renFile.delete( );
            assertFalse( renFile.exists( ) );
        }
        System.out.print( "." );
    }

    @Test
    // TODO make abstract test
    public void testRemoveModelsForRemovedMetamodel( ) throws Exception {

        String daName = this.getPartitionOne( ).getPri( ).getDataAreaDescriptor( ).getDataAreaName( );
        String dcName = this.getPartitionOne( ).getPri( ).getContainerName( );

        this.deleteAllNonMetamodelsFromIndex( );

        this.index.dumpIndex( );

        String filePath = this.index.getIndexDumpFilePath( );

        File backup = new File( filePath + ".old" );
        File f = new File( filePath );

        this.copyFile( f, backup );
        // end preparation

        super.loadMetamodelInLocalDataArea( this.getMetamodelContainer( "testcases" ), this.getMetamodelContainer( "testcasesfoundation" ), this.getMetamodelContainer( "textverticalization" ) );

        ModelPartition stayPart = this._testClient1.getOrCreatePartition( "AnyWildPartition" );
        B2 b2 = this.createB2( );
        C2 c2 = this.createC2( );
        stayPart.assignElement( b2 );
        stayPart.assignElement( c2 );
        c2.setB( b2 );
        ModelPartition delPart = this._testClient1.getOrCreatePartition( "delPartition" );
        delPart.createElement( A1f.class );

        saveConnectionOne( );

        String tfDcName = this.getMetamodelContainer( "testcasesfoundation" );
        Object[] tcPris = this.index.getDaToDcToIndexPris( ).getUnderlyingForRead( IndexConstants.MM_DA_NAME, tfDcName );

        List<IndexPri> tcIPs = new ArrayList<IndexPri>( );
        for ( Object tcPri : tcPris ) {
            tcIPs.add( (IndexPri) tcPri );
        }
        for ( IndexPri idxPri : tcIPs ) {
            this.index.removePartition( idxPri.getCachedPri( ) );
        }
        assertNull( this.index.getDaToDcToIndexPris( ).getUnderlyingForRead( IndexConstants.MM_DA_NAME, tfDcName ) );

        Map<String, Object> metamodelList = new HashMap<String, Object>( );
        metamodelList.put( tfDcName, null );

        this.index.removePartitionsUsingMetamodelsInternal( metamodelList );

        Object[] pris = this.index.getDaToDcToIndexPris( ).getUnderlyingForRead( daName, dcName );
        boolean found = false;
        for ( Object priO : pris ) {
            IndexPri idxPri = (IndexPri) priO;
            if ( idxPri.getCachedPri( ) == stayPart.getPri( ) ) {
                found = true;
            }
        }
        assertTrue( "test partition with testcases elements deleted!", found );

        // recover
        assertTrue( "Could not delete index file", f.delete( ) );
        assertTrue( "Could not rename backup file to index file", backup.renameTo( f ) );

        assertTrue( "Could not restore index", this.index.loadIndex( ) );

        this.index.doSanityCheck( IndexConstants.SANITY_FORCE_CHECK_ALL );
    }


    @Test
    public void testRemoveModelsForRemovedMetamodelsInSynchronize( ) throws Exception {

        ModelPartition mp = this._testClient1.getOrCreatePartition( "somepartition" );
        this.fillWithSomeContent( mp );

        mp.assignElement( this.createB2( ) );
        this.saveConnectionOne( );

        assertTrue( "Could not save index to filesystem", this.index.dumpIndex( ) );

        String container = this.getMetamodelContainer( "testcases" );
        String daName = IndexConstants.MM_DA_NAME;

        CRI testcasesCri = this.getFacility( ).getRIFactory( ).createCri( daName, container );
        Object[] result = this.index.getDaToDcToIndexPris( ).getUnderlyingForRead( daName, container );
        final Object[] pris = result.clone( );
        assertTrue( pris.length == 5 ); // 5 partitions in testcases metamodel

        PRI[] prisToIndex = new PRI[] { ( (IndexPri) pris[0] ).getCachedPri( ), ( (IndexPri) pris[1] ).getCachedPri( ) };
        long[] timestamps = new long[] { 123, this.index.getPartitionTimestamp( prisToIndex[1] ) };
        SpiPartitionStreamProvider provider = new SpiPartitionStreamProvider( ) {

            public InputStream getPartitionStream( PRI pri ) {

                if ( pri == ( (IndexPri) pris[0] ).getCachedPri( ) ) {
                    throw new RuntimeException( "TestException!! Expected to be caught in test!" );
                }
                return null;

            }

        };

        SyncReport syncReport = null;
        synchronized ( this.index ) {
            syncReport = this.index.synchronize( prisToIndex, timestamps, provider, false, testcasesCri );
            assertTrue( syncReport.ADDED.isEmpty( ) );
            assertTrue( syncReport.DELETED.size( ) == 3 ); // expect 3 metamodels to be deleted
            assertTrue( syncReport.EXCEPTION.size( ) == 1 && syncReport.EXCEPTION.get( 0 ) == prisToIndex[0] );
            assertTrue( syncReport.NOP.size( ) == 1 && syncReport.NOP.get( 0 ) == prisToIndex[1] );
            assertTrue( syncReport.UPDATED.isEmpty( ) );
            assertFalse( this.index.isPartitionIndexed( prisToIndex[0] ) );
            assertFalse( this.index.isPartitionIndexed( mp.getPri( ) ) );
            this.index.doSanityCheck( IndexConstants.SANITY_FORCE_CHECK_ALL );
        }

        assertTrue( "could not restore index from file system", this.index.loadIndex( ) );

        final SyncReport sr = syncReport;
        // re-index deleted metamodel partitions (required for DB scenario)
        provider = new SpiPartitionStreamProvider( ) {

            public InputStream getPartitionStream( PRI pri ) {

                if ( sr.DELETED.contains( pri ) || sr.EXCEPTION.contains( pri ) ) {
                    return getTestHelper( ).getPartitionStream( pri );
                } else {
                    throw new IllegalArgumentException( pri + " not in " + sr.DELETED );
                }
            }

        };
        IndexingAction action;
        for ( PRI deletedPri : syncReport.DELETED ) {
            action = this.index.indexPartition( deletedPri, provider, System.currentTimeMillis( ), true );
            assertTrue( "did not expect " + action + " for PRI " + deletedPri, action != IndexingAction.EXCEPTION && action != IndexingAction.NOP );
        }
        for ( PRI exceptedPri : syncReport.EXCEPTION ) {
            action = this.index.indexPartition( exceptedPri, provider, System.currentTimeMillis( ), true );
            assertTrue( "did not expect " + action + " for PRI " + exceptedPri, action != IndexingAction.EXCEPTION && action != IndexingAction.NOP );
        }

        this.index.doSanityCheck( IndexConstants.SANITY_FORCE_CHECK_ALL );
    }

    protected void copyFile( File src, File dst ) throws FileNotFoundException, IOException {

        InputStream in = new FileInputStream( src );
        OutputStream out = new FileOutputStream( dst );

        // Transfer bytes from srcFile into destFile
        byte[] buf = new byte[1024];
        int len;
        while ( ( len = in.read( buf ) ) > 0 ) {
            out.write( buf, 0, len ); // if destFile does not exist then it is
            // created
        }
        in.close( );
        out.close( );
    }
}
