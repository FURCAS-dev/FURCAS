package com.sap.tc.moin.primary.facility.test.ide;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sap.tc.moin.facility.primary.ide.persistence.lfs.ecl.EclFsFactoryImpl;
import com.sap.tc.moin.facility.primary.ipi.fs.IpiFsResourceManagement;
import com.sap.tc.moin.facility.primary.ipi.fs.IpiFsResourceManagement.PartitionIsCreatableResultRecord;
import com.sap.tc.moin.facility.primary.ipi.fs.IpiFsResourceManagement.PartitionIsCreatableResultRecord.CreatableCheckResult;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.ResourceIdentifierFactory;
import com.sap.tc.moin.repository.exception.MoinBaseException;
import com.sap.tc.moin.test.testcase.MoinTestCase;

/**
 * @author D048997
 * @author d047015
 */
public class TestResourceManagement extends FacilityIdeMoinTest {

    IpiFsResourceManagement rm;

    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );
        this.rm = getResourceManagement( );
    }

    @Override
    @After
    public void afterTestMethod( ) throws Exception {

        super.afterTestMethod( );
    }

    @Test
    public void testPartitionExists( ) {

        ModelPartition mp = this._testClient1.getOrCreatePartition( "RM_existsTest" );
        this.saveConnectionOne( );
        PRI pri = mp.getPri( );
        assertTrue( "expected partition to exist: " + pri.toString( ), this.rm.partitionExists( pri ) );
        mp.delete( );
        saveConnectionOne( );
        assertFalse( "expected partition to inexistent: " + pri.toString( ), this.rm.partitionExists( pri ) );
    }

    @Test
    public void testPartitionIsReadOnly( ) {

        ModelPartition mp = this._testClient1.getOrCreatePartition( "RM_readonlyTest" );
        this.saveConnectionOne( );
        PRI pri = mp.getPri( );
        assertFalse( "expected partition to be writable " + pri.toString( ), this.rm.partitionIsReadOnly( pri ) );
        mp.delete( );
        this.saveConnectionOne( );
        try {
            this.rm.partitionIsReadOnly( pri );
            fail( "expected deleted partition to be not readonly...:" + pri.toString( ) );
        } catch ( Exception e ) {
            assertTrue( true );
        }
        // negative test: requires archive or something should be covered in Ulis tests
    }

    @Test
    public void testPartitionIsCreatable( ) throws MoinBaseException {

        /*
         * Calculate and set-up test data
         */

        // set the base partitions name
        String basePath = "src/a";
        String basePartitionName = basePath + "/RM_isCreatableTest.mointest"; // existing base partition

        // set the test partitions names
        String pathPartitionName1 = "src/a/RM_isCreatableTest123.mointest"; // new file name, path case different
        String pathConflictPartitionName1 = "src/A/RM_isCreatableTest.mointest"; // same file name, path case different
        String pathConflictPartitionName2 = "src/A/RM_isCreatableTest123.mointest"; // new file name, path case different
        String fileConflictPartitionName1 = "src/a/RM_ISCreatableTest.mointest"; // different case in file name, same path
        String fileConflictPartitionName2 = "src/\\//a\\RM_ISCreatableTest.mointest"; // same file name, same path, mixed path seperators
        String directoryConflictPartitionName = "src/a/RM_isCreatableTest.dir.mointest"; // same file name, same path, mixed path seperators

        // make sure the base partition does not exist (get/create and delete it)
        ModelPartition baseModelPartition = this._testClient1.getOrCreatePartition( basePartitionName );
        PRI basePri = baseModelPartition.getPri( );
        baseModelPartition.delete( );

        // calculate the path of the base partition file
        String partitionPriSourcePath = this.rm.getStorageResponsibleForPRI( basePri ).getSourcePath( );
        String canonicalPriSourcePath = new EclFsFactoryImpl( ).getResource( partitionPriSourcePath ).getCanonicalPath( );

        // paranoia clean-up (for previously crashed test runs)
        new File( canonicalPriSourcePath + "/" + directoryConflictPartitionName ).delete( );
        new File( canonicalPriSourcePath + "/" + basePartitionName ).delete( );
        new File( canonicalPriSourcePath + "/" + basePath ).delete( );

        // create a directory with the name of partition directoryConflictPartitionName
        File directoryConflictDirectory = new File( canonicalPriSourcePath + "/" + directoryConflictPartitionName );
        directoryConflictDirectory.mkdirs( );
        // check if creation was successful
        if ( !directoryConflictDirectory.exists( ) && !directoryConflictDirectory.isDirectory( ) ) {
            throw new RuntimeException( "Test set-up failed! Could not created directory: " + directoryConflictDirectory.getAbsolutePath( ) );
        }

        // create base partition to check against
        ResourceIdentifierFactory riFactory = MoinTestCase.getFacility( ).getRIFactory( );
        basePri = riFactory.createPri( basePri.getDataAreaDescriptor( ).getDataAreaName( ), basePri.getContainerName( ), basePartitionName );
        baseModelPartition = this.getConnectionOne( ).createPartition( basePri );
        saveConnectionOne( );

        // calculate test pris
        PRI pathPri1 = riFactory.createPri( basePri.getDataAreaDescriptor( ).getDataAreaName( ), basePri.getContainerName( ), pathPartitionName1 );
        PRI pathConflictPri1 = riFactory.createPri( basePri.getDataAreaDescriptor( ).getDataAreaName( ), basePri.getContainerName( ), pathConflictPartitionName1 );
        PRI pathConflictPri2 = riFactory.createPri( basePri.getDataAreaDescriptor( ).getDataAreaName( ), basePri.getContainerName( ), pathConflictPartitionName2 );
        PRI fileConflictPri1 = riFactory.createPri( basePri.getDataAreaDescriptor( ).getDataAreaName( ), basePri.getContainerName( ), fileConflictPartitionName1 );
        PRI fileConflictPri2 = riFactory.createPri( basePri.getDataAreaDescriptor( ).getDataAreaName( ), basePri.getContainerName( ), fileConflictPartitionName2 );
        PRI directoryConflictPri = riFactory.createPri( basePri.getDataAreaDescriptor( ).getDataAreaName( ), basePri.getContainerName( ), directoryConflictPartitionName );


        /*
         * Actually perform the test
         */

        // existing partition
        PartitionIsCreatableResultRecord resultRecord = this.rm.partitionIsCreatable( basePri );
        assertTrue( "Partition should not be creatable: " + basePri.toString( ), resultRecord.result == CreatableCheckResult.NOT_CREATABLE_ALREADY_EXISTS );
        assertNull( "Existing path should be null since the partition does already exist.", resultRecord.existingPath );


        // partition without conflicts
        resultRecord = this.rm.partitionIsCreatable( pathPri1 );
        assertTrue( "Partition should not be creatable: " + pathPri1.toString( ), resultRecord.result == CreatableCheckResult.CREATABLE );
        assertNull( "Existing path should be null since the partition can be created.", resultRecord.existingPath );


        // partition exists in a different case
        resultRecord = this.rm.partitionIsCreatable( pathConflictPri1 );
        assertTrue( "Partition should not be creatable since a part of its path is already there in an other case: " + pathConflictPri1.toString( ), resultRecord.result == CreatableCheckResult.NOT_CREATABLE_CASE_CONFLICT );
        assertNotNull( "Existing path should be null since a path conflict occurred.", resultRecord.existingPath );
        String existingConflictingPath;
        try {
            // existing path should be "/src/a/RM_isCreatableTest.mointest"
            existingConflictingPath = new File( canonicalPriSourcePath + "/" + basePartitionName ).getCanonicalPath( );
        } catch ( IOException e ) {
            throw new RuntimeException( "Test was not set up correctly", e );
        }
        assertEquals( "Existing path was expected to be " + existingConflictingPath, existingConflictingPath, resultRecord.existingPath );


        // partition does not exist but a part of the path exists in a different case
        resultRecord = this.rm.partitionIsCreatable( pathConflictPri2 );
        assertTrue( "Partition should not be creatable since a part of its path is already there in an other case: " + pathConflictPri2.toString( ), resultRecord.result == CreatableCheckResult.NOT_CREATABLE_CASE_CONFLICT );
        assertNotNull( "Existing path should be null since a path conflict occurred.", resultRecord.existingPath );
        try {
            // existing path should be "/src/a"
            existingConflictingPath = new File( canonicalPriSourcePath + "/" + basePath ).getCanonicalPath( );
        } catch ( IOException e ) {
            throw new RuntimeException( "Test was not set up correctly", e );
        }
        assertEquals( "Existing path was expected to be " + existingConflictingPath, existingConflictingPath, resultRecord.existingPath );


        // partition with same path but different file name case already exists
        resultRecord = this.rm.partitionIsCreatable( fileConflictPri1 );
        assertTrue( "Partition should not be creatable since a partition file in other case already there: " + fileConflictPri1.toString( ), resultRecord.result == CreatableCheckResult.NOT_CREATABLE_CASE_CONFLICT );
        assertNotNull( "Existing path should be null since a case conflict occurred.", resultRecord.existingPath );
        try {
            existingConflictingPath = new File( canonicalPriSourcePath + "/" + basePartitionName ).getCanonicalPath( );
        } catch ( IOException e ) {
            throw new RuntimeException( "Test was not set up correctly", e );
        }
        assertEquals( "Existing path was expected to be " + existingConflictingPath, existingConflictingPath, resultRecord.existingPath );


        // partition with same path but different file name case already exists
        resultRecord = this.rm.partitionIsCreatable( fileConflictPri2 );
        assertTrue( "Partition should not be creatable since it already exists: " + fileConflictPri2.toString( ), resultRecord.result == CreatableCheckResult.NOT_CREATABLE_CASE_CONFLICT );
        assertNotNull( "Existing path should be null since a case conflict occurred.", resultRecord.existingPath );
        try {
            existingConflictingPath = new File( canonicalPriSourcePath + "/" + basePartitionName ).getCanonicalPath( );
        } catch ( IOException e ) {
            throw new RuntimeException( "Test was not set up correctly", e );
        }
        assertEquals( "Existing path was expected to be " + existingConflictingPath, existingConflictingPath, resultRecord.existingPath );


        // partition with same path but different file name case already exists
        resultRecord = this.rm.partitionIsCreatable( directoryConflictPri );
        assertTrue( "Partition should not be creatable since a directory with the partiton name already exists: " + directoryConflictPri.toString( ), resultRecord.result == CreatableCheckResult.NOT_CREATABLE_ALREADY_EXISTS );
        assertNull( "Existing path should be null since a directory already exists.", resultRecord.existingPath );


        /*
         * Do some clean-up
         */

        // delete base partition
        baseModelPartition.delete( );
        this.saveConnectionOne( );

        // partition creatable
        resultRecord = this.rm.partitionIsCreatable( basePri );
        assertTrue( "Partition should be creatable: " + basePri.toString( ), resultRecord.result == CreatableCheckResult.CREATABLE );
        assertNull( "Existing path should be null since the partition can be created.", resultRecord.existingPath );

        // cleanup directory
        new File( canonicalPriSourcePath + "/" + directoryConflictPartitionName ).delete( );
        new File( canonicalPriSourcePath + "/" + basePath ).delete( );

        // test for archives is done in Uli's tests
    }
}
