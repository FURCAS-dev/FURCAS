/*
 * Created on 21.01.2005
 */
package com.sap.tc.moin.repository.test.core;

import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.DataAreaDescriptor;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.core.MetamodelWorkspace;
import com.sap.tc.moin.repository.core.mofrom.MoinMofRomServicesImpl;
import com.sap.tc.moin.repository.spi.core.SpiModelPartition;

/**
 * Tests the assignment to model containers.
 * 
 * @author d024032
 */
public class TestContainerAssignment extends CoreMoinTest {

    private ModelPartition partitionA;

    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );

        // Delete partition from previous tests
        partitionA = getPartitionOne( );
        getMOINConnection( ).save( );

    }

    @Override
    @After
    public void afterTestMethod( ) throws Exception {

        this.partitionA = null;

        super.afterTestMethod( );
    }

    @Test
    public void testGetInnerPartitions( ) throws Exception {

        DataAreaDescriptor dataAreaDescriptor = partitionA.getPri( ).getDataAreaDescriptor( );
        String containerName = partitionA.getPri( ).getContainerName( );

        CRI cri = getMOINConnection( ).getSession( ).getMoin( ).createCri( dataAreaDescriptor.getFacilityId( ), dataAreaDescriptor.getDataAreaName( ), containerName );

        // first get the current number of partitions in the container (may depend on previous test cases)
        Collection<PRI> partitionsInContainer = getMOINConnection( ).getSession( ).getInnerPartitions( cri );
        int initialCount = partitionsInContainer.size( );

        // Partition is deleted, but not yet saved -> 2 partitions expected (3 stored, but one deleted in memory)
        partitionA.delete( );
        partitionsInContainer = getMOINConnection( ).getSession( ).getInnerPartitions( cri );
        assertEquals( partitionsInContainer.size( ), initialCount - 1 );

        // After a save, there still should be two (now two stored)
        getMOINConnection( ).save( );
        partitionsInContainer = getMOINConnection( ).getSession( ).getInnerPartitions( cri );
        assertEquals( partitionsInContainer.size( ), initialCount - 1 );

        // a new partition is created, now we should have 3 again (2 stored, one in memory)
        String newPartitionName = "partition_new" + System.currentTimeMillis( );
        _testClient1.getOrCreatePartitionStable( newPartitionName );
        partitionsInContainer = getMOINConnection( ).getSession( ).getInnerPartitions( cri );
        assertEquals( partitionsInContainer.size( ), initialCount );

        // After a save, there still should be three (3 stored, 0 in memory)
        getMOINConnection( ).save( );
        partitionsInContainer = getMOINConnection( ).getSession( ).getInnerPartitions( cri );
        assertEquals( partitionsInContainer.size( ), initialCount );

        // Now create a partition in a different container. Models in the container should still be three
        _testClient1.getOrCreatePartitionStable( newPartitionName, _testClient1.getContainer2Name( ) );
        partitionsInContainer = getMOINConnection( ).getSession( ).getInnerPartitions( cri );
        assertEquals( partitionsInContainer.size( ), initialCount );

        //now check if also partitions for deployed metamodels (or MOF itself) are found
        MetamodelWorkspace metamodelWorkspace = getTestHelper( ).getCoreConnection( getMOINConnection( ) ).getSession( ).getWorkspaceSet( ).getMoin( ).getMetamodelWorkspace( );
        SpiModelPartition partition = metamodelWorkspace.getPartitionManager( ).getLoadedPartitions( ).iterator( ).next( );
        DataAreaDescriptor metamodelDataAreaDescriptor = partition.getPri( ).getDataAreaDescriptor( );
        assertTrue( "Expected to find data area descriptor in mm workspace that answers true for isMetamodelDataArea()", metamodelDataAreaDescriptor.isMetamodelDataArea( ) );

        CRI metaModelCri = getMOINConnection( ).getSession( ).getMoin( ).createCri( metamodelDataAreaDescriptor.getFacilityId( ), metamodelDataAreaDescriptor.getDataAreaName( ), MoinMofRomServicesImpl.MOFROM_MODELPARTITION_CONTAINER_NAME );
        partitionsInContainer = getMOINConnection( ).getSession( ).getInnerPartitions( metaModelCri );
        assertFalse( "Expected to find partitions in container for MOF", partitionsInContainer.isEmpty( ) );

    }

    @Test( expected = UnsupportedOperationException.class )
    public void testGetInnerPartitionsUnmodifiable( ) throws Exception {

        DataAreaDescriptor dataAreaDescriptor = partitionA.getPri( ).getDataAreaDescriptor( );
        String containerName = partitionA.getPri( ).getContainerName( );

        // first get the current number of partitions in the container (may depend on previous test cases)
        CRI cri = getMOINConnection( ).getSession( ).getMoin( ).createCri( dataAreaDescriptor.getFacilityId( ), dataAreaDescriptor.getDataAreaName( ), containerName );
        Collection<PRI> partitionsInContainer = getMOINConnection( ).getSession( ).getInnerPartitions( cri );

        // the list must be unmodifiable -> This call must throw an UnsupportedOperationException
        partitionsInContainer.add( null );
    }

    @Test
    public void testGetInnerPartitionsNullPartitionCri( ) throws Exception {

        PRI pri = getMOINConnection( ).getNullPartition( ).getPri( );
        CRI cri = pri.getCri( );
        Collection<PRI> partitionsInContainer = getMOINConnection( ).getSession( ).getInnerPartitions( cri );

        // First check if at least the "original" Partition is contained
        assertTrue( partitionsInContainer.contains( pri ) );

        // Then check if all contained partitions have the same CRI as the original one
        for ( PRI priInContainer : partitionsInContainer ) {
            assertEquals( priInContainer.getCri( ), cri );
        }
    }

    @Test
    public void testGetInnerPartitionsTransientPartitionCri( ) throws Exception {

        PRI pri = getMOINConnection( ).getOrCreateTransientPartition( "TP1" ).getPri( );
        CRI cri = pri.getCri( );
        Collection<PRI> partitionsInContainer = getMOINConnection( ).getSession( ).getInnerPartitions( cri );

        // First check if at least the "original" Partition is contained
        assertTrue( partitionsInContainer.contains( pri ) );

        // Then check if all contained partitions have the same CRI as the original one
        for ( PRI priInContainer : partitionsInContainer ) {
            assertEquals( priInContainer.getCri( ), cri );
        }
    }
}
