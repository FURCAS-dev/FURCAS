/*
 * Created on 20.02.2006
 */
package com.sap.tc.moin.repository.test.core;

import com.sap.tc.moin.repository.mmi.model.ModelPackage;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.Operation;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sap.moin.mm.gfw.graphics.GraphicsPackage;
import com.sap.moin.mm.gfw.pictograms.ContainerShape;
import com.sap.tc.moin.repository.InvalidModelPartitionException;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.exception.MoinBaseRuntimeException;
import com.sap.tc.moin.test.fw.TestMetaModels;

/**
 * Tests different editing scenarios of partitions. Main focus is on locking.
 * 
 * @author d044711
 */
public class TestPartitionDeleting extends CoreMoinTest {

    private GraphicsPackage graphicsPackage = null;

    private ModelPackage mofModelPackage;

    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );
        mofModelPackage = (ModelPackage) getMOINConnection( ).getPackage( TestMetaModels.MOIN_MOF_CN, TestMetaModels.MOIN_MOF_TPE_MODEL );
        graphicsPackage = (GraphicsPackage) getMOINConnection( ).getPackage( TestMetaModels.GFW_CN, TestMetaModels.GFW_TPE );

        verify( graphicsPackage != null, "The graphics package is null, probably not imported yet" );
    }

    @Override
    @After
    public void afterTestMethod( ) throws Exception {

        mofModelPackage = null;
        graphicsPackage = null;
        super.afterTestMethod( );
    }

    @Test
    public void testDeleteElements( ) throws Exception {

        ModelPartition firstPartition = getPartitionOne( );
        ModelPartition secondPartition = getPartitionTwo( );
        MofPackage mofPackage = (MofPackage) this.mofModelPackage.getMofPackage( ).refCreateInstance( );
        MofClass mofClass = (MofClass) this.mofModelPackage.getMofClass( ).refCreateInstance( );
        Operation operation = (Operation) mofModelPackage.getOperation( ).refCreateInstance( );
        ( (Partitionable) mofPackage ).assign___Partition( firstPartition );
        ( (Partitionable) mofClass ).assign___Partition( secondPartition );
        ( (Partitionable) operation ).assign___Partition( firstPartition );

        mofClass.setContainer( mofPackage );
        operation.setContainer( mofClass );

        assertNull( mofPackage.refImmediateComposite( ) );
        assertEquals( mofPackage, mofClass.refImmediateComposite( ) );
        assertEquals( mofClass, operation.refImmediateComposite( ) );

        assertEquals( firstPartition, ( (Partitionable) mofPackage ).get___Partition( ) );
        assertEquals( secondPartition, ( (Partitionable) mofClass ).get___Partition( ) );
        assertEquals( firstPartition, ( (Partitionable) operation ).get___Partition( ) );

        firstPartition.deleteElements( );

        assertSame( 0, firstPartition.getElements( ).size( ) );
        assertSame( 0, secondPartition.getElements( ).size( ) );

        assertFalse( ( (Partitionable) mofPackage ).is___Alive( ) );
        assertFalse( ( (Partitionable) mofClass ).is___Alive( ) );
        assertFalse( ( (Partitionable) operation ).is___Alive( ) );
    }

    @Test
    public void testDeletePartition( ) throws Exception {

        ContainerShape containerShape = getMOINConnection( ).createElementInPartition( ContainerShape.class, null );

        ModelPartition partition = super.getPartitionOne( );

        // assign to a real partition
        ( (Partitionable) containerShape ).assign___Partition( partition );

        // make sure that containerShape is assigned to a real partition
        verify( getTestHelper( ).getCoreModelPartition( ( (Partitionable) containerShape ).get___Partition( ) ).getPri( ).isVolatilePartition( ) == false, "Expected shape to be in a real Partition" );

        ModelPartition loaded0 = null;
        try {
            loaded0 = this.getMOINConnection( ).getPartition( partition.getPri( ) );
        } catch ( MoinBaseRuntimeException e ) {
            // loaded1 remains null
        }

        // is partition deleted
        verify( loaded0 != null, "Expected partition to be loaded." );

        this.getMOINConnection( ).save( );

        PRI pri = partition.getPri( );

        // delete model
        partition.delete( );
        assertFalse( partition.isAlive( ) );
        assertEquals( pri, partition.getPri( ) );// this call must still be
        // possible despite not being
        // alive anymore

        ModelPartition loaded1 = null;
        try {
            loaded1 = this.getMOINConnection( ).getPartition( partition.getPri( ) );
        } catch ( MoinBaseRuntimeException e ) {
            // loaded1 remains null
        }

        // is partition deleted
        verify( loaded1 == null, "Expected deleted partition." );

        this.getMOINConnection( ).save( );

        ModelPartition loaded2 = null;
        try {
            loaded2 = this.getMOINConnection( ).getPartition( partition.getPri( ) );
        } catch ( MoinBaseRuntimeException e ) {
            // loaded1 remains null
        }

        // is partition deleted
        verify( loaded2 == null, "Expected deleted partition." );
        // TODO: substitute stuff below with M1 scenario
        // // -- delete metamodel
        // // first clean up rest of the metamodel partitions to make repository
        // consistent
        // ((CorePartitionable)
        // this.graphicsPackage.getDatatypes().refMetaObject()).get___Partition().delete();
        // ((CorePartitionable)
        // this.graphicsPackage.getLinks().refMetaObject()).get___Partition().delete();
        // ((CorePartitionable)
        // this.graphicsPackage.getPictograms().refMetaObject()).get___Partition().delete();
        // // now do test with graphics package
        // ModelPartition metamodelPartition = ((CorePartitionable)
        // this.graphicsPackage.refMetaObject()).get___Partition();
        // PRI metamodelPri = metamodelPartition.getPri();
        // metamodelPartition.delete();
        //        
        // ModelPartition metamodelLoaded = null;
        // try {
        // metamodelLoaded =
        // this.getMOINConnection().getPartition(metamodelPri);
        // } catch (MoinBaseRuntimeException e) {
        // //loaded1 remains null
        // }
        //        
        // // is partition deleted
        // verify(metamodelLoaded == null, "Expected deleted partition.");
        //        
        // this.getMOINConnection().save();
        //                    
        // try {
        // metamodelLoaded =
        // this.getMOINConnection().getPartition(partition.getPri());
        // } catch (MoinBaseRuntimeException e) {
        // //loaded1 remains null
        // }
        //        
        // // is partition deleted
        // verify(metamodelLoaded == null, "Expected deleted partition.");
    }

    @Test
    public void testDeletionOfNewlyCreatedPartition( ) throws Exception {

        ModelPartition partition = super._testClient1.getOrCreatePartition( "NewPartition_" + System.currentTimeMillis( ) );
        partition.delete( );
        try {
            partition.getElements( );
            fail( "Expected exception" );
        } catch ( InvalidModelPartitionException e ) {
            // expected
        }

        // the getPri() method must be callable without an exception (even if
        // the element is deleted)
        assertNull( _testClient1.getConnection( ).getPartition( partition.getPri( ) ) );
    }

    @Test
    public void testCreationOfDeletedPartition( ) throws Exception {

        ModelPartition partition = super._testClient1.getOrCreatePartition( "NewPartition_" + System.currentTimeMillis( ) );
        PRI pri = partition.getPri( );
        partition.delete( );
        ModelPartition recreatedPartition = getMOINConnection( ).createPartition( pri );

        assertNotNull( recreatedPartition );
        assertEquals( partition, recreatedPartition );
    }

    @Test
    public void testCreationOfDeletedPartitionAfterSave( ) throws Exception {

        ModelPartition partition = super._testClient1.getOrCreatePartition( "NewPartition_" + System.currentTimeMillis( ) );
        PRI pri = partition.getPri( );
        partition.delete( );
        getMOINConnection( ).save( );
        ModelPartition recreatedPartition = getMOINConnection( ).createPartition( pri );

        assertNotNull( recreatedPartition );
        assertEquals( partition, recreatedPartition );
    }

    @Test
    public void testUndoOfPartitionDeletion( ) throws Exception {

        ModelPartition partition = super._testClient1.getOrCreatePartition( "NewPartition_" + System.currentTimeMillis( ) );
        partition.delete( );
        assertFalse( partition.isAlive( ) );
        getMOINConnection( ).getCommandStack( ).undo( );
        assertTrue( partition.isAlive( ) );
    }

    @Test
    public void testDeletionOfEmptyPartition( ) throws Exception {

        ModelPartition partition = getPartitionOne( );
        partition.deleteElements( );
        assertTrue( partition.getElements( ).isEmpty( ) );
        getMOINConnection( ).save( );
        assertEquals( null, getMOINConnection( ).getSession( ).getLockManager( ).getLockOwner( partition.getPri( ) ) );
        partition.delete( );
        assertFalse( partition.isAlive( ) );
        //partition must be locked
        assertEquals( getMOINConnection( ), getMOINConnection( ).getSession( ).getLockManager( ).getLockOwner( partition.getPri( ) ) );
        getMOINConnection( ).getCommandStack( ).undo( );

        //partition must be there again
        assertTrue( partition.isAlive( ) );
        //lock must have been released on undo
        assertEquals( null, getMOINConnection( ).getSession( ).getLockManager( ).getLockOwner( partition.getPri( ) ) );

    }


    @Test
    public void testDeletionAndRecreationOfPersistedPartition( ) throws Exception {

        ModelPartition partition = super._testClient1.getOrCreatePartition( "NewPartition_" + System.currentTimeMillis( ) );
        PRI pri = partition.getPri( );
        getMOINConnection( ).save( );
        partition.delete( );
        assertFalse( partition.isAlive( ) );
        ModelPartition recreatedPartition = getMOINConnection( ).createPartition( pri );
        assertTrue( "Expected recreated partition to be marked as persisted", getTestHelper( ).getCoreModelPartition( recreatedPartition ).isPersisted( ) );
        assertNotNull( recreatedPartition );
        assertTrue( partition.isAlive( ) );
        assertEquals( partition, recreatedPartition );
    }

}