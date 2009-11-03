/*
 * Created on 20.02.2006
 */
package com.sap.tc.moin.repository.test.core;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PartitionCreatingNotPossibleException;
import com.sap.tc.moin.repository.PartitionEditingNotPossibleException;

/**
 * Tests different editing scenarios of partitions. Main focus is on locking.
 * 
 * @author d044711
 */
public class TestDuplicatePartitionCreation extends CoreMoinTest {

    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );
        _testClient2.getConnection( );
        deleteAllCreatedPartitions( );
    }

    @Override
    @After
    public void afterTestMethod( ) throws Exception {

        deleteAllCreatedPartitions( );
        super.afterTestMethod( );
    }

    /**
     * 
     */
    @Test
    public void testCreateDuplicatePartitionTransient( ) throws Exception {

        _testClient1.createPartition( "P1" );

        // This second creation should cause a "PartitionEditingNotPossibleException" because "_testClient1" already created "P1"
        try {
            _testClient2.createPartition( "P1" );
            fail( "Expected PartitionEditingNotPossibleException" );
        } catch ( PartitionEditingNotPossibleException e ) {

        }
    }

    /**
     * 
     */
    @Test
    public void testCreateDuplicatePartitionPersistent( ) throws Exception {

        _testClient1.createPartition( "P1" );
        getMOINConnection( ).save( );

        // This second creation should cause a "PartitionCreatingNotPossibleException"
        try {
            _testClient1.createPartition( "P1" );
            fail( "Expected PartitionCreatingNotPossibleException" );
        } catch ( PartitionCreatingNotPossibleException e ) {

        }
    }

    /**
     * 
     */
    @Test
    public void testCreateDuplicatePartitionPersistentWith2Connections( ) throws Exception {

        _testClient1.createPartition( "P1" );
        getMOINConnection( ).save( );

        // This second creation should cause a "PartitionCreatingNotPossibleException"
        try {
            _testClient2.createPartition( "P1" );
            fail( "Expected PartitionCreatingNotPossibleException" );
        } catch ( PartitionCreatingNotPossibleException e ) {

        }
    }

    /**
     * 
     */
    @Test
    public void testRecreatePartitionAfterDelete( ) throws Exception {

        ModelPartition p1 = _testClient1.createPartition( "P1" );
        getMOINConnection( ).save( );
        p1.delete( );

        // This creation must work, because "P1" was deleted before
        _testClient1.createPartition( "P1" );
    }

    /**
     * 
     */
    @Test
    public void testRecreatePartitionAfterDeleteAndSave( ) throws Exception {

        ModelPartition p1 = _testClient1.createPartition( "P1" );
        getMOINConnection( ).save( );
        p1.delete( );
        getMOINConnection( ).save( );

        // This creation must work, because "P1" was deleted before
        _testClient1.createPartition( "P1" );
    }

    /**
     * 
     */
    @Test
    public void testRecreatePartitionAfterDeleteWith2Connections( ) throws Exception {

        ModelPartition p1 = _testClient1.createPartition( "P1" );
        getMOINConnection( ).save( );
        p1.delete( );

        // This creation will fail, because the deletion from "_testClient1" is not saved yet. Therefore from
        // "testClient2"'s view the partition does alredy exist.
        try {
            _testClient2.createPartition( "P1" );
            fail( "Expected PartitionCreatingNotPossibleException" );
        } catch ( PartitionCreatingNotPossibleException e ) {

        }
    }

    /**
     * 
     */
    @Test
    public void testRecreatePartitionAfterDeleteAndSaveWith2Connections( ) throws Exception {

        ModelPartition p1 = _testClient1.createPartition( "P1" );
        getMOINConnection( ).save( );
        p1.delete( );
        getMOINConnection( ).save( );

        // This creation must work, because "P1" was deleted before
        _testClient2.createPartition( "P1" );
        getSecondMOINConnection( ).save( );
    }

    private void deleteAllCreatedPartitions( ) {

        try {
            _testClient1.getOrCreatePartitionStable( "P1" ).delete( );
            getMOINConnection( ).save( );
        } catch ( Exception e ) {
            // OK
        }

        try {
            _testClient2.getOrCreatePartitionStable( "P1" ).delete( );
            getSecondMOINConnection( ).save( );
        } catch ( Exception e ) {
            // OK
        }
    }
}