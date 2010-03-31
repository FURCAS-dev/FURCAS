package com.sap.tc.moin.repository.test.inconsistency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sap.tc.moin.MoinPackage;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.NullPartitionNotEmptyException;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.PartitionsNotSavedException;
import com.sap.tc.moin.repository.ReferencedTransientElementsException;
import com.sap.tc.moin.repository.consistency.ConsistencyCorrectionHandle;
import com.sap.tc.moin.repository.consistency.ConsistencyViolation;
import com.sap.tc.moin.repository.consistency.DuplicateElementConsistencyViolation;
import com.sap.tc.moin.repository.consistency.DuplicateParentConsistencyViolation;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.core.EndStorageLink;
import com.sap.tc.moin.repository.core.consistency.ConsistencyViolationRegistry;
import com.sap.tc.moin.repository.core.consistency.impl.AllOtherElementsDeleteCorrectionImpl;
import com.sap.tc.moin.repository.core.consistency.impl.LinkDeleteCorrectionImpl;
import com.sap.tc.moin.repository.ocl.notification.DeferredConstraintViolationStatus;
import com.sap.tc.moin.repository.ocl.notification.OclManagerException;
import com.sap.tc.moin.repository.spi.core.SpiLink;
import com.sap.tc.moin.test.fw.TestClient;
import com.sap.tc.moin.test.testcase.MoinTestCase;
import com.sap.tc.moin.testcases.TestcasesPackage;
import com.sap.tc.moin.testcases.case002.A2;
import com.sap.tc.moin.testcases.case002.AreferencesB;
import com.sap.tc.moin.testcases.case002.B2;
import com.sap.tc.moin.testcases.case002.C2;
import com.sap.tc.moin.testcases.case005.p1.A5;
import com.sap.tc.moin.testcases.case005.p1.p2.B5;
import com.sap.tc.moin.testcases.case006.C6;
import com.sap.tc.moin.testcases.case006.D6;
import com.sap.tc.moin.testcases.case016.A16;
import com.sap.tc.moin.testcases.case016.B16;
import com.sap.tc.moin.testcases.case016.Case016Package;
import com.sap.tc.moin.testcases.case017.A17;

/**
 * <h1>Consistency correction with standard means</h1>
 * <p>
 * These test check the correction of inconsistencies using the standard API.
 * </p>
 * 
 * @author d026715
 */
public class TestInconsistencyFixing extends TestInconsistencyBase {

    static boolean EVENTS_CHECK = true;

    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );

        testcasesPackage = (TestcasesPackage) getMOINConnection( ).getPackage( null, new String[] { "testcases" } );
        moinPackage = (MoinPackage) getMOINConnection( ).getPackage( null, new String[] { "MOIN" } );
        case004Package = testcasesPackage.getCase004( );
        case008Package = testcasesPackage.getCase008( );

        case002Package = testcasesPackage.getCase002( );

        a4Class = case004Package.getA4( );
        a8Class = case008Package.getA8( );

        b4Class = case004Package.getB4( );

        ModelPartition mp = this._testClient1.getOrCreatePartition( "InconsistencyTestSetup" );

        for ( Partitionable element : this.getMOINConnection( ).getNullPartition( ).getElements( ) ) {
            mp.assignElement( element );
        }
    }

    @Override
    @After
    public void afterTestMethod( ) throws Exception {

        super.afterTestMethod( );
    }

    /**
     * Test of double storage links with an inconsistency on one side. Instance
     * a17 is assigned to PartitionA and saved. Instance a17_2, which is at the
     * other end of a double storage link of a17 is assigned to pertition B and
     * saved. Partition B is cloned. The element a17_2 exists in two partitions
     * then. The inconsistency is resolved by deleting the partition and/or the
     * duplicate element.
     * 
     * @throws PartitionsNotSavedException
     * @throws ReferencedTransientElementsException
     * @throws NullPartitionNotEmptyException
     */
    @Test
    public void testOneDuplicateElementInconsistency( ) throws NullPartitionNotEmptyException, ReferencedTransientElementsException, PartitionsNotSavedException {

        MyConsistencyListener listener = createInconsistencyListener( this.getMOINConnection( ) );
        MyConsistencyListener secondListener = createInconsistencyListener( this.getSecondMOINConnection( ) );

        // clear PartitionA
        ModelPartition mpA = this._testClient1.getOrCreatePartition( "IconsistencyTest.ds1i.PartitionA" );
        mpA.deleteElements( );

        // clear PartitionB
        ModelPartition mpB = this._testClient1.getOrCreatePartition( "IconsistencyTest.ds1i.PartitionB" );
        mpB.deleteElements( );
        saveConnectionOne( );

        // change single-valued attributes
        A17 a17 = createA17( );

        mpA.assignElement( a17 );

        mpB.assignElement( a17.getToEnd( ).iterator( ).next( ) );

        MRI mriA17 = ( (Partitionable) a17 ).get___Mri( );

        saveConnectionOne( );

        byte[] mpBXmi = this.getPartitionByteArray( mpB );

        TestClient client = this._testClient1;

        ModelPartition mpBCopy = this.createNewPartitionFromByteArray( "IconsistencyTest.ds1i.PartitionBCopy", mpBXmi, client );
        ModelPartition mpBCopy2 = this.createNewPartitionFromByteArray( "IconsistencyTest.ds1i.PartitionBCopy2", mpBXmi, client );

        boolean correctionSuccessful = false;

        // use second connection to make sure nothing is loaded
        a17 = (A17) this.getMOINConnection( ).getElement( mriA17 );
        a17.getToEnd( ).iterator( ).next( );

        this.processNotificationQueue( );
        ConsistencyViolation event = listener.getViolations( ).get( 0 );

        this.verify( event instanceof DuplicateElementConsistencyViolation, "No DuplicateElement inconsistency found. " );

        // explicit inconsitency check - necessary since elements are already
        // loaded consistently in connection
        this.getSecondMOINConnection( ).getConsistencyViolationListenerRegistry( ).performConsistencyCheck( mpA.getPri( ) );

        this.processSecondNotificationQueue( );
        ConsistencyViolation explicitCheckEvent = null;
        if ( !secondListener.getViolations( ).isEmpty( ) ) {
            for ( ConsistencyViolation nextEvent : secondListener.getViolations( ) ) {
                if ( nextEvent instanceof DuplicateElementConsistencyViolation ) {
                    explicitCheckEvent = nextEvent;
                    break;
                }
            }
        }
        this.verify( explicitCheckEvent instanceof DuplicateElementConsistencyViolation, "NO DuplicateElement inconsistency found." );

        List<ModelPartition> partitions = new ArrayList<ModelPartition>( Arrays.asList( mpA, mpB, mpBCopy, mpBCopy2 ) );

        if ( event instanceof DuplicateElementConsistencyViolation ) {
            MRI mri = ( (DuplicateElementConsistencyViolation) event ).getMri( );
            ModelPartition partition = this.getMOINConnection( ).getPartition( mri.getPri( ) );

            partition.delete( );
            saveConnectionOne( );
            partitions.remove( partition );

            this.processNotificationQueue( );
            this.verify( !listener.getViolations( ).isEmpty( ), "No more insconsistencies found." );

            if ( !listener.getViolations( ).isEmpty( ) ) {
                DuplicateElementConsistencyViolation remainingViolation = (DuplicateElementConsistencyViolation) listener.getViolations( ).get( 0 );
                MRI usedMri = remainingViolation.getUsedElementsMri( );
                RefObject duplicateElement = (RefObject) this.getMOINConnection( ).getElement( usedMri );
                duplicateElement.refDelete( );
                saveConnectionOne( );
            }

            this.processNotificationQueue( );
            this.verify( a17.getToEnd( ).iterator( ).next( ) != null, "Element cannot be resolved." );

            if ( listener.getViolations( ).isEmpty( ) ) {
                correctionSuccessful = true;
            } else {
                throw new RuntimeException( listener.toString( ) );
            }
        }

        this.verify( correctionSuccessful, "Correction failed" );

        // cleanup
        for ( ModelPartition modelPartition : partitions ) {
            modelPartition.delete( );
        }

        saveConnectionOne( );
    }

    /**
     * Test deletion of inconsistent partitions. The test also does the check if
     * component children have been deleted in all partitions.
     * 
     * @throws PartitionsNotSavedException
     * @throws ReferencedTransientElementsException
     * @throws NullPartitionNotEmptyException
     */
    @Test
    public void testDeletionOneDuplicateElement( ) throws NullPartitionNotEmptyException, ReferencedTransientElementsException, PartitionsNotSavedException {

        MyConsistencyListener listener = createInconsistencyListener( this.getMOINConnection( ) );
        MyConsistencyListener secondListener = createInconsistencyListener( this.getSecondMOINConnection( ) );

        // clear PartitionA
        ModelPartition mpA = this._testClient1.getOrCreatePartitionStable( "InconsistencyTest.ds1i.PartitionA" );
        mpA.delete( );

        // clear PartitionB
        ModelPartition mpB = this._testClient1.getOrCreatePartitionStable( "InconsistencyTest.ds1i.PartitionB" );
        mpB.delete( );
        saveConnectionOne( );

        mpA = this._testClient1.getOrCreatePartitionStable( "InconsistencyTest.ds1i.PartitionA" );
        mpB = this._testClient1.getOrCreatePartitionStable( "InconsistencyTest.ds1i.PartitionB" );

        // change single-valued attributes
        A17 a17 = createA17( );

        mpA.assignElement( a17 );

        mpB.assignElement( a17.getToEnd( ).iterator( ).next( ) );

        saveConnectionOne( );

        byte[] mpBXmi = this.getPartitionByteArray( mpB );

        TestClient client = this._testClient1;

        ModelPartition mpBCopy = this.createDuplicatePartition( "InconsistencyTest.ds1i.PartitionBCopy", mpBXmi, client );
        ModelPartition mpBCopy2 = this.createDuplicatePartition( "InconsistencyTest.ds1i.PartitionBCopy2", mpBXmi, client );

        // explicit inconsistency check
        this.getSecondMOINConnection( ).getConsistencyViolationListenerRegistry( ).performConsistencyCheck( mpA.getPri( ) );

        this.processSecondNotificationQueue( );
        ConsistencyViolation explicitCheckEvent = null;
        if ( !secondListener.getViolations( ).isEmpty( ) ) {
            for ( ConsistencyViolation nextEvent : secondListener.getViolations( ) ) {
                if ( nextEvent instanceof DuplicateElementConsistencyViolation ) {
                    explicitCheckEvent = nextEvent;
                    break;
                }
            }
        }
        this.verify( explicitCheckEvent instanceof DuplicateElementConsistencyViolation, "NO DuplicateElement inconsistency found." );

        // determine set of partitions that contain the elements that are not
        // used
        ModelPartition usedPartition = ( (Partitionable) a17.getToEnd( ).iterator( ).next( ) ).get___Partition( );
        List<ModelPartition> partitionsToCheck = Arrays.asList( mpB, mpBCopy, mpBCopy2 );
        partitionsToCheck = new ArrayList<ModelPartition>( partitionsToCheck );
        partitionsToCheck.remove( usedPartition );

        // if mpA is deleted, the component element of the used partition should
        // be deleted also
        mpA.delete( );
        saveConnectionOne( );

        // A is deleted -
        // there must be two duplicate element
        // inconsistencies left
        this.processNotificationQueue( );
        verify( !listener.getViolations( ).isEmpty( ), "No inconsistencies found." );

        // the elements must not be deleted from the partitions other than the
        // used elements partition
        for ( ModelPartition partition : partitionsToCheck ) {
            verify( !partition.getElements( ).isEmpty( ), "Partition is empty (" + partition.getPri( ) + ")" );
        }

        // remove partitions
        for ( ModelPartition partition : partitionsToCheck ) {
            partition.delete( );
        }

        // there must be no inconsistencies left
        this.processNotificationQueue( );
        verify( listener.getViolations( ).isEmpty( ), "Inconsistencies found." );

        // delete empty partition
        mpB.delete( );

        saveConnectionOne( );
    }

    /**
     * Test of double storage links with an inconsistency on both sides.
     * Instance a17 is assigned to PartitionA and saved. Instance a17_2, which
     * is at the other end of a double storage link of a17 is assigned to
     * partition B and saved. Then both partitions are cloned. The element a17
     * and a17_2 exist in both partitions then.
     * 
     * @throws PartitionsNotSavedException
     * @throws ReferencedTransientElementsException
     * @throws NullPartitionNotEmptyException
     */
    @Test
    public void testDeletionTwoDuplicateElement( ) throws NullPartitionNotEmptyException, ReferencedTransientElementsException, PartitionsNotSavedException {

        MyConsistencyListener listener = createInconsistencyListener( this.getMOINConnection( ) );
        MyConsistencyListener secondListener = createInconsistencyListener( this.getSecondMOINConnection( ) );

        // clear PartitionA
        ModelPartition mpA = this._testClient1.getOrCreatePartitionStable( "IconsistencyTest.ds1i.PartitionA" );
        mpA.delete( );

        // clear PartitionB
        ModelPartition mpB = this._testClient1.getOrCreatePartitionStable( "IconsistencyTest.ds1i.PartitionB" );
        mpB.delete( );
        saveConnectionOne( );

        mpA = this._testClient1.getOrCreatePartitionStable( "IconsistencyTest.ds1i.PartitionA" );
        mpB = this._testClient1.getOrCreatePartitionStable( "IconsistencyTest.ds1i.PartitionB" );

        // change single-valued attributes
        A17 a17 = createA17( );

        mpA.assignElement( a17 );

        mpB.assignElement( a17.getToEnd( ).iterator( ).next( ) );

        saveConnectionOne( );

        // create inconsistencies
        byte[] mpBXmi = this.getPartitionByteArray( mpB );
        byte[] mpAXmi = this.getPartitionByteArray( mpA );

        TestClient client = this._testClient1;
        ModelPartition mpBCopy = this.createDuplicatePartition( "IconsistencyTest.ds2i.PartitionBCopy", mpBXmi, client );
        ModelPartition mpACopy = this.createDuplicatePartition( "IconsistencyTest.ds2i.PartitionACopy", mpAXmi, client );

        PRI usedElementsPri = ( (Partitionable) a17.getToEnd( ).iterator( ).next( ) ).get___Mri( ).getPri( );

        // delete partition A to correct inconsistencies
        // Due to composition, one of the inconsistent Bs will also be deleted
        mpA.delete( );
        saveConnectionOne( );

        // second partition must not be empty
        if ( mpB.getPri( ).equals( usedElementsPri ) ) {
            verify( !mpBCopy.getElements( ).isEmpty( ), "Partition is empty" );

        } else {
            verify( !mpB.getElements( ).isEmpty( ), "Partition is empty" );
        }

        this.getMOINConnection( ).getConsistencyViolationListenerRegistry( ).performConsistencyCheck( mpACopy.getPri( ) );

        // there must be one inconsistency left
        this.processNotificationQueue( );
        verify( listener.getViolations( ).isEmpty( ), "No inconsistencies found." );

        // partition ACopy and BCopy must still contain links
        CoreModelPartition cmpACopy = MoinTestCase.getTestHelper( ).getCoreModelPartition( mpACopy );
        verify( !cmpACopy.getLinks( ).isEmpty( ), "Partition A copy contains no links" );

        // cleanup
        mpB.delete( );

        this.processNotificationQueue( );
        this.checkCorrectionWithSecondConnection( secondListener, mpBCopy, mpACopy );

        mpBCopy.delete( );
        mpACopy.delete( );
        saveConnectionOne( );
    }

    /**
     * Test for duplicate link ends. A5 has a composite link to B5. Instance a5
     * is assigned to partition "All" and saved. Instance b5 is assigned to
     * partition "B" and saved. Then B is exported as XMI and imported as
     * "NewB". The element b5 exists in both partitions then and can no longer
     * be resolved. <br>
     * The inconsistency is resolved by deleting the duplicate element.
     * 
     * @throws PartitionsNotSavedException
     * @throws ReferencedTransientElementsException
     * @throws NullPartitionNotEmptyException
     */
    @Test
    public void testOneDuplicateElementInconsistencyB5( ) throws NullPartitionNotEmptyException, ReferencedTransientElementsException, PartitionsNotSavedException {

        MyConsistencyListener listener = createInconsistencyListener( this.getMOINConnection( ) );

        ModelPartition mpForB = this._testClient1.getOrCreatePartition( "SingleStorageOneDuplicateElementB" );
        mpForB.deleteElements( );

        ModelPartition mpForAll = this._testClient1.getOrCreatePartition( "SingleStorageOneDuplicateElementAll" );
        mpForAll.deleteElements( );

        saveConnectionOne( );

        // change single-valued attributes
        A5 a5 = createA5( );

        B5 b5 = a5.getX( );

        mpForB.assignElement( b5 );
        mpForAll.assignElement( a5 );

        MRI mri = ( (Partitionable) a5 ).get___Mri( );

        saveConnectionOne( );

        byte[] mpBXmi = this.getPartitionByteArray( mpForB );
        ModelPartition newMpForB = this.createDuplicatePartition( "SingleStorageOneDuplicateElementBCopy", mpBXmi, this._testClient1 );

        boolean correctionSuccessful = false;

        a5 = (A5) this.getMOINConnection( ).getElement( mri );
        b5 = a5.getX( );

        this.processNotificationQueue( );
        ConsistencyViolation event = null;
        if ( listener.getViolations( ).size( ) > 0 ) {
            event = listener.getViolations( ).get( 0 );
        }

        this.verify( event instanceof DuplicateElementConsistencyViolation, "DuplicateElement inconsistency detected." );

        b5.refDelete( );

        saveConnectionOne( );

        b5 = a5.getX( );

        this.processNotificationQueue( );
        if ( listener.getViolations( ).isEmpty( ) ) {
            correctionSuccessful = true;
        }

        this.verify( correctionSuccessful, "Correction" );

        // cleanup
        mpForAll.delete( );
        mpForB.delete( );
        saveConnectionOne( );
    }

    @Test
    public void testDuplicateElementDifferentLinks( ) throws NullPartitionNotEmptyException, ReferencedTransientElementsException, PartitionsNotSavedException {

        MyConsistencyListener listener = createInconsistencyListener( this.getMOINConnection( ) );

        ModelPartition mpA = recreatePartition( "IconsistencyTest.dldl.PartitionA" );

        ModelPartition mpB = recreatePartition( "IconsistencyTest.dldl.PartitionB" );

        // change single-valued attributes
        C2 c2 = this.createC2( );
        B2 b2 = this.createB2( );
        B2 b2x = this.createB2( );

        mpA.assignElement( c2 );
        mpB.assignElement( b2 );
        mpB.assignElement( b2x );

        saveConnectionOne( );

        byte[] mpAXmi = this.getPartitionByteArray( mpA );

        AreferencesB ref = this.case002Package.getAreferencesB( );
        ref.add( b2, c2 );

        LRI lriOfC = ( (Partitionable) c2 ).get___Mri( ).getLri( );

        saveConnectionOne( );
        ensurePartitionLoadedInCCSW( mpA );

        ModelPartition mpACopy = this.createNewPartitionFromByteArray( "IconsistencyTest.dldl.PartitionACopy", mpAXmi, this._testClient1 );
        this.processNotificationQueue( );
        verify( listener.getViolations( ).size( ) > 0, "No Inconsistencies found." );

        C2 c2Copy = (C2) this.getMOINConnection( ).getElement( mpACopy.getPri( ).createMri( lriOfC.getMofId( ) ) );
        AreferencesB refCopy = this.case002Package.getAreferencesB( );
        refCopy.add( b2x, c2Copy );
        saveConnectionOne( );

        verify( ( (Partitionable) c2Copy.getB( ) ).get___Mri( ).equals( ( (Partitionable) b2x ).get___Mri( ) ), "Wrong instance returned" );

        c2Copy.refDelete( );
        saveConnectionOne( );

        // instance is not found by the wrapper. the wrapper tries to resolve
        // the lri then an finds the
        // remaining element
        this.processNotificationQueue( );
        verify( ( (Partitionable) c2Copy.getB( ) ).get___Mri( ).equals( ( (Partitionable) b2 ).get___Mri( ) ), "Wrong instance returned" );

        mpACopy.delete( );
        mpA.delete( );
        mpB.delete( );
        saveConnectionOne( );
    }

    // @Test - not tested. has to be handled by constraint check
    public void testSingleStorageMultiplicityViolation( ) throws NullPartitionNotEmptyException, ReferencedTransientElementsException, PartitionsNotSavedException {

        MyConsistencyListener listener = createInconsistencyListener( this.getMOINConnection( ) );

        ModelPartition mpA = recreatePartition( "IconsistencyTest.dlde.PartitionA" );

        ModelPartition mpB = recreatePartition( "IconsistencyTest.dlde.PartitionB" );

        ModelPartition mpC = recreatePartition( "IconsistencyTest.dlde.PartitionC" );

        // change single-valued attributes
        C2 c2 = this.createC2( );
        C2 c2x = this.createC2( );
        B2 b2 = this.createB2( );

        mpA.assignElement( c2 );
        mpB.assignElement( b2 );
        mpC.assignElement( c2x );

        saveConnectionOne( );

        AreferencesB ref = this.case002Package.getAreferencesB( );
        ref.add( b2, c2 );

        A2 a = ref.getA( b2 );

        saveConnectionOne( );

        byte[] mpAXmi = this.getPartitionByteArray( mpA );

        // temporarily delete mp A
        mpA.delete( );
        saveConnectionOne( );

        // set reference
        AreferencesB refCopy = this.case002Package.getAreferencesB( );
        refCopy.add( b2, c2x );

        saveConnectionOne( );

        // reimport another A from xmi
        mpA = this.createNewPartitionFromByteArray( "IconsistencyTest.dlde.PartitionA", mpAXmi, this._testClient1 );

        a = ref.getA( b2 );

        DeferredConstraintViolationStatus verifyConstraints = null;
        try {
            verifyConstraints = this.getMOINConnection( ).getOclRegistryService( ).verifyConstraints( b2 );
        } catch ( OclManagerException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace( );
        }
        // TODO FIX: multiplicity is never checked !!

        mpC.delete( );
        mpA.delete( );
        mpB.delete( );
        saveConnectionOne( );
    }

    /**
     * Test for duplicate link ends. One element at the link end is in the same
     * partition, the duplicate is in another partition.
     * 
     * @throws PartitionsNotSavedException
     * @throws ReferencedTransientElementsException
     * @throws NullPartitionNotEmptyException
     */
    @Test
    public void testOneDuplicateElementInconsistencyIntraPartition( ) throws NullPartitionNotEmptyException, ReferencedTransientElementsException, PartitionsNotSavedException {

        MyConsistencyListener listener = createInconsistencyListener( this.getMOINConnection( ) );

        ModelPartition mpB = this._testClient1.getOrCreatePartition( "SingleStorageOneDuplicateElementB" );
        mpB.deleteElements( );

        ModelPartition mpA = this._testClient1.getOrCreatePartition( "SingleStorageOneDuplicateElementA" );
        mpA.deleteElements( );

        saveConnectionOne( );

        // change single-valued attributes
        A5 a5 = createA5( );

        LRI lriOfA = ( (Partitionable) a5 ).get___Mri( ).getLri( );

        B5 b5 = a5.getX( );

        // first, assign both to A and export
        mpA.assignElement( b5 );
        mpA.assignElement( a5 );

        saveConnectionOne( );

        byte[] mpAXmi = this.getPartitionByteArray( mpA );

        // move B to partition B
        mpB.assignElement( b5 );
        saveConnectionOne( );

        byte[] mpBXmi = this.getPartitionByteArray( mpB );

        // delete both partitions
        mpA.delete( );
        mpB.delete( );
        saveConnectionOne( );

        // recreate both partitions from xmi
        mpB = this.createDuplicatePartition( "SingleStorageOneDuplicateElementB", mpBXmi, this._testClient1 );
        mpA = this.createDuplicatePartition( "SingleStorageOneDuplicateElementA", mpAXmi, this._testClient1 );

        this.processNotificationQueue( );
        ConsistencyViolation event = null;
        if ( listener.getViolations( ).size( ) > 0 ) {
            event = listener.getViolations( ).get( 0 );
        }

        this.verify( event instanceof DuplicateElementConsistencyViolation, "No DuplicateElement inconsistency detected." );

        for ( ConsistencyViolation violation : listener.getViolations( ) ) {
            MRI mri = violation.getAffectedElement( );
            if ( mri.getPri( ).equals( mpA.getPri( ) ) ) {
                // delete intra partition element
                RefObject element = (RefObject) this.getMOINConnection( ).getElement( mri );
                element.refDelete( );
                saveConnectionOne( );
            }
        }

        a5 = (A5) this.getMOINConnection( ).getElement( lriOfA );
        assertEquals( mpA.getPri( ), ( (Partitionable) a5 ).get___Mri( ).getPri( ) );

        b5 = a5.getX( );

        this.processNotificationQueue( );
        assertEquals( "Wrong instance picked.", mpB.getPri( ), ( (Partitionable) b5 ).get___Mri( ).getPri( ) );
        this.verifyNoConsistencyViolations( listener );

        // cleanup
        mpA.delete( );
        mpB.delete( );
        saveConnectionOne( );
    }

    /**
     * Test of dangling links in a composite association. One of the component
     * elements is missing. {@link Iterator#next()} returns null for this
     * element.
     * 
     * @throws PartitionsNotSavedException
     * @throws ReferencedTransientElementsException
     * @throws NullPartitionNotEmptyException
     */
    @Test
    public void testDanglingLinkWithJmiList( ) throws NullPartitionNotEmptyException, ReferencedTransientElementsException, PartitionsNotSavedException {

        MyConsistencyListener listener = createInconsistencyListener( this.getMOINConnection( ) );

        ModelPartition mpA = this.recreatePartition( "IconsistencyTest.dsdl.PartitionA" );

        ModelPartition mpB = this.recreatePartition( "IconsistencyTest.dsdl.PartitionB" );

        // change single-valued attributes
        A17 a17 = getMOINConnection( ).createElementInPartition( A17.class, null );
        A17 a17_2 = getMOINConnection( ).createElementInPartition( A17.class, null );
        A17 a17_3 = getMOINConnection( ).createElementInPartition( A17.class, null );

        a17.getToEnd( ).add( a17_2 );
        a17.getToEnd( ).add( a17_3 );

        mpA.assignElement( a17 );
        mpA.assignElement( a17_3 );

        mpB.assignElement( a17_2 );

        MRI mriA17 = ( (Partitionable) a17 ).get___Mri( );

        saveConnectionOne( );

        byte[] mpAXmi = this.getPartitionByteArray( mpA );
        byte[] mpBXmi = this.getPartitionByteArray( mpB );

        mpA.delete( );
        mpB.delete( );
        saveConnectionOne( );

        mpA = this.createNewPartitionFromByteArray( "IconsistencyTest.dsdl.PartitionA", mpAXmi, this._testClient1 );

        a17 = (A17) this.getMOINConnection( ).getElement( mriA17 );

        boolean nullElement = false;

        for ( Object element : a17.getToEnd( ) ) {
            nullElement = nullElement || ( element == null );
        }

        A17[] array = new A17[2];

        a17.getToEnd( ).toArray( array );

        this.verify( nullElement, "All link ends found." );
        this.verify( !this.getMOINConnection( ).getConsistencyViolationListenerRegistry( ).getAllConsistencyViolations( ).isEmpty( ), "No inconsistencies in registry found." );

        this.processNotificationQueue( );
        this.verify( !listener.getViolations( ).isEmpty( ), "No inconsistencies in listener found." );

        mpB = this.createNewPartitionFromByteArray( "IconsistencyTest.dsdl.PartitionB", mpBXmi, this._testClient1 );

        this.processNotificationQueue( );
        this.verifyNoConsistencyViolations( listener );

        // cleanup
        mpA.delete( );
        mpB.delete( );

        saveConnectionOne( );
    }

    /**
     * Test of a double storage component links with duplicates element on both
     * the composite side and the component side. When deleting the composite,
     * the components are also deleted. It has to be checked if the components
     * are deleted from the same partition if possible.
     * 
     * @throws PartitionsNotSavedException
     * @throws ReferencedTransientElementsException
     * @throws NullPartitionNotEmptyException
     */
    @Test
    public void testDuplicateElementCompositeDeletion( ) throws NullPartitionNotEmptyException, ReferencedTransientElementsException, PartitionsNotSavedException {

        MyConsistencyListener listener = createInconsistencyListener( this.getMOINConnection( ) );

        ModelPartition mpA = this.recreatePartition( "IconsistencyTest.dsdl.PartitionA" );

        ModelPartition mpB = this.recreatePartition( "IconsistencyTest.dsdl.PartitionB" );

        // change single-valued attributes
        A17 a17 = getMOINConnection( ).createElementInPartition( A17.class, null );
        A17 a17_2 = getMOINConnection( ).createElementInPartition( A17.class, null );
        A17 a17_3 = getMOINConnection( ).createElementInPartition( A17.class, null );

        a17.getToEnd( ).add( a17_2 );
        a17.getToEnd( ).add( a17_3 );

        mpA.assignElement( a17 );
        mpA.assignElement( a17_3 );

        mpB.assignElement( a17_2 );

        LRI lriParent = ( (Partitionable) a17 ).get___Mri( ).getLri( );

        saveConnectionOne( );

        byte[] mpAXmi = this.getPartitionByteArray( mpA );
        byte[] mpBXmi = this.getPartitionByteArray( mpB );

        ModelPartition mpACopy = this.createNewPartitionFromByteArray( "IconsistencyTest.dsdl.PartitionACopy", mpAXmi, this._testClient1 );
        ModelPartition mpBCopy = this.createNewPartitionFromByteArray( "IconsistencyTest.dsdl.PartitionBCopy", mpBXmi, this._testClient1 );

        MRI mriOfCopy = mpACopy.getPri( ).createMri( lriParent.getMofId( ) );
        a17 = (A17) this.getMOINConnection( ).getElement( mriOfCopy );

        // delete parent from copied partition
        a17.refDelete( );
        saveConnectionOne( );

        boolean elementFound = false;
        // check the mri of the remaining elements, get the remaining element first
        MRI mri = mpA.getPri( ).createMri( lriParent.getMofId( ) );
        a17 = (A17) this.getMOINConnection( ).getElement( mri );
        for ( Object element : a17.getToEnd( ) ) {
            elementFound = elementFound || ( (Partitionable) element ).get___Mri( ).getPri( ).equals( mpA.getPri( ) );
        }

        this.verify( elementFound, "Element was deleted from the wrong partition." );

        this.processNotificationQueue( );
        this.verifyNoConsistencyViolations( listener );

        this.checkPartitionViolationCounter( this.getMOINConnection( ), mpA.getPri( ) );
        this.checkPartitionViolationCounter( this.getMOINConnection( ), mpB.getPri( ) );
        this.checkPartitionViolationCounter( this.getMOINConnection( ), mpACopy.getPri( ) );
        this.checkPartitionViolationCounter( this.getMOINConnection( ), mpBCopy.getPri( ) );

        // cleanup
        mpA.delete( );
        mpB.delete( );
        mpACopy.delete( );
        mpBCopy.delete( );

        saveConnectionOne( );
    }

    /**
     * Test of double storage links with an inconsistency on both sides.
     * Instance a17 is assigned to PartitionA and saved. Instance a17_2, which
     * is at the other end of a double storage link of a17 is assigned to
     * pertition B and saved. Then both partitions are cloned. The element a17
     * and a17_2 exist in both partitions then.
     * 
     * @throws PartitionsNotSavedException
     * @throws ReferencedTransientElementsException
     * @throws NullPartitionNotEmptyException
     */
    @Test
    public void testDeletionTwoDuplicateElementTwoConnections( ) throws NullPartitionNotEmptyException, ReferencedTransientElementsException, PartitionsNotSavedException {

        MyConsistencyListener listener = createInconsistencyListener( this.getMOINConnection( ) );

        // clear PartitionA
        ModelPartition mpA = this._testClient1.getOrCreatePartitionStable( "IconsistencyTest.ds1i.PartitionA" );
        mpA.delete( );

        // clear PartitionB
        ModelPartition mpB = this._testClient1.getOrCreatePartitionStable( "IconsistencyTest.ds1i.PartitionB" );
        mpB.delete( );
        saveConnectionOne( );

        mpA = this._testClient1.getOrCreatePartitionStable( "IconsistencyTest.ds1i.PartitionA" );
        mpB = this._testClient1.getOrCreatePartitionStable( "IconsistencyTest.ds1i.PartitionB" );

        // change single-valued attributes
        A17 a17 = createA17( );

        mpA.assignElement( a17 );

        mpB.assignElement( a17.getToEnd( ).iterator( ).next( ) );

        saveConnectionOne( );

        // create inconsistencies
        byte[] mpBXmi = this.getPartitionByteArray( mpB );
        byte[] mpAXmi = this.getPartitionByteArray( mpA );

        TestClient client = this._testClient1;
        ModelPartition mpBCopy = this.createDuplicatePartition( "IconsistencyTest.ds2i.PartitionBCopy", mpBXmi, client );

        ModelPartition mpACopy = this.createDuplicatePartition( "IconsistencyTest.ds2i.PartitionACopy", mpAXmi, client );

        // delete a17 using a second connection
        // Due to composition, one of the inconsistent Bs will also be deleted
        Connection secondConnection = this.getSecondMOINConnection( );
        A17 a17_2 = (A17) secondConnection.getElement( ( (Partitionable) a17 ).get___Mri( ) );
        PRI usedElementsPri = ( (Partitionable) a17_2.getToEnd( ).iterator( ).next( ) ).get___Mri( ).getPri( );
        a17_2.refDelete( );
        secondConnection.save( );

        // second partition must not be empty
        if ( mpB.getPri( ).equals( usedElementsPri ) ) {
            verify( !mpBCopy.getElements( ).isEmpty( ), "Partition is empty" );
        } else {
            verify( !mpB.getElements( ).isEmpty( ), "Partition is empty" );
        }

        CoreModelPartition cmpACopy = MoinTestCase.getTestHelper( ).getCoreModelPartition( mpACopy );
        verify( !cmpACopy.getLinks( ).isEmpty( ), "Partition A copy contains no links" );

        // there must no inconsistency left
        this.processNotificationQueue( );
        verify( listener.getViolations( ).isEmpty( ), "Inconsistencies left." );

        // cleanup
        mpA.delete( );
        mpB.delete( );

        mpBCopy.delete( );
        mpACopy.delete( );
        saveConnectionOne( );
    }

    @Test
    public void testDanglingLinkInconsistencyRecreateElement( ) throws NullPartitionNotEmptyException, ReferencedTransientElementsException, PartitionsNotSavedException {

        MyConsistencyListener listener = createInconsistencyListener( this.getMOINConnection( ) );

        ModelPartition mpA = recreatePartition( "IconsistencyTest.dlre.PartitionA" );

        ModelPartition mpB = recreatePartition( "IconsistencyTest.dlre.PartitionB" );

        // change single-valued attributes
        C2 c2 = this.createC2( );
        B2 b2 = this.createB2( );

        mpA.assignElement( c2 );
        mpB.assignElement( b2 );

        saveConnectionOne( );

        AreferencesB ref = this.case002Package.getAreferencesB( );
        ref.add( b2, c2 );

        LRI lriOfC = ( (Partitionable) c2 ).get___Mri( ).getLri( );

        saveConnectionOne( );

        byte[] mpAXmi = this.getPartitionByteArray( mpA );
        byte[] mpBXmi = this.getPartitionByteArray( mpB );

        mpA.delete( );
        mpB.delete( );
        saveConnectionOne( );

        mpA = this.createNewPartitionFromByteArray( "IconsistencyTest.dlre.PartitionA", mpAXmi, this._testClient1 );

        c2 = (C2) this.getMOINConnection( ).getElement( lriOfC );
        // trigger inconsistency event
        c2.getB( );

        this.processNotificationQueue( );
        verify( listener.getViolations( ).size( ) > 0, "No Inconsistencies found." );

        mpB = this.createNewPartitionFromByteArray( "IconsistencyTest.dlre.PartitionB", mpBXmi, this._testClient1 );

        saveConnectionOne( );

        this.processNotificationQueue( );
        verify( listener.getViolations( ).size( ) == 0, "Inconsistencies left." );

        verify( !this.checkPartitionViolationCounter( this.getMOINConnection( ), mpA.getPri( ) ), "Partition still marked as inconsistent." );
        verify( !this.checkPartitionViolationCounter( this.getMOINConnection( ), mpB.getPri( ) ), "Partition still marked as inconsistent." );

        mpA.delete( );
        mpB.delete( );
        saveConnectionOne( );
    }

    @Test
    public void testDuplicateElementBulkNotification( ) throws NullPartitionNotEmptyException, ReferencedTransientElementsException, PartitionsNotSavedException {

        MyConsistencyListener listener = createInconsistencyListener( this.getSecondMOINConnection( ) );

        ModelPartition mpA = recreatePartition( "IconsistencyTest.debn.PartitionA" );

        // change single-valued attributes
        C2 c2;

        // create hundreds of c2
        for ( int i = 0; i < 100; i++ ) {

            c2 = this.createC2( );

            mpA.assignElement( c2 );
        }

        saveConnectionOne( );

        byte[] mpAXmi = this.getPartitionByteArray( mpA );

        ModelPartition mpACopy = this.createNewPartitionFromByteArray( "IconsistencyTest.debn.PartitionACopy", mpAXmi, this._testClient1 );

        // load partition in a second connection
        this.getSecondMOINConnection( ).getPartition( mpACopy.getPri( ) );
        this.getSecondMOINConnection( ).getPartition( mpA.getPri( ) );

        this.processSecondNotificationQueue( );
        verify( listener.getViolations( ).size( ) > 0, "No Inconsistencies found." );
        assertEquals( "Notified too often", 1, listener.getNumberOfNotifications( ) );

        mpA.delete( );
        saveConnectionOne( );
    }

    /**
     * Test of dangling links in a composite association. One of the component
     * elements is missing. {@link Iterator#next()} returns null for this
     * element.
     * 
     * @throws PartitionsNotSavedException
     * @throws ReferencedTransientElementsException
     * @throws NullPartitionNotEmptyException
     */
    @Test
    public void testDanglingLinkElementDelete( ) throws NullPartitionNotEmptyException, ReferencedTransientElementsException, PartitionsNotSavedException {

        MyConsistencyListener listener = createInconsistencyListener( this.getMOINConnection( ) );

        ModelPartition mpA = this.recreatePartition( "IconsistencyTest.dsdl.PartitionA" );

        ModelPartition mpB = this.recreatePartition( "IconsistencyTest.dsdl.PartitionB" );

        // change single-valued attributes
        A17 a17 = getMOINConnection( ).createElementInPartition( A17.class, null );
        A17 a17_2 = getMOINConnection( ).createElementInPartition( A17.class, null );
        A17 a17_3 = getMOINConnection( ).createElementInPartition( A17.class, null );

        a17.getToEnd( ).add( a17_2 );
        a17.getToEnd( ).add( a17_3 );

        mpA.assignElement( a17 );
        mpA.assignElement( a17_3 );

        mpB.assignElement( a17_2 );

        MRI mriA17 = ( (Partitionable) a17 ).get___Mri( );

        saveConnectionOne( );

        byte[] mpAXmi = this.getPartitionByteArray( mpA );
        byte[] mpBXmi = this.getPartitionByteArray( mpB );

        mpA.delete( );
        mpB.delete( );
        saveConnectionOne( );

        mpA = this.createNewPartitionFromByteArray( "IconsistencyTest.dsdl.PartitionA", mpAXmi, this._testClient1 );
        ModelPartition mpA2 = this.createNewPartitionFromByteArray( "IconsistencyTest.dsdl.PartitionA2", mpAXmi, this._testClient1 );
        ModelPartition mpA3 = this.createNewPartitionFromByteArray( "IconsistencyTest.dsdl.PartitionA3", mpAXmi, this._testClient1 );

        this.processNotificationQueue( );
        List<ConsistencyViolation> violations = listener.getViolations( );
        for ( ConsistencyViolation consistencyViolation : violations ) {
            if ( consistencyViolation instanceof DuplicateElementConsistencyViolation ) {
                DuplicateElementConsistencyViolation foundViolation = (DuplicateElementConsistencyViolation) consistencyViolation;
                if ( foundViolation.getMri( ).equals( mriA17 ) ) {
                    ConsistencyCorrectionHandle[] correctionHandles = foundViolation.getCorrectionHandles( this.getMOINConnection( ) );
                    for ( ConsistencyCorrectionHandle consistencyCorrectionHandle : correctionHandles ) {
                        if ( consistencyCorrectionHandle instanceof AllOtherElementsDeleteCorrectionImpl ) {
                            this.getMOINConnection( ).getConsistencyViolationListenerRegistry( ).applyCorrection( consistencyCorrectionHandle.getId( ) );
                            this.getMOINConnection( ).save( );
                        }
                    }
                }
            }
        }

        a17 = (A17) this.getMOINConnection( ).getElement( mriA17 );

        Collection toEnd = a17.getToEnd( );

        verify( toEnd.size( ) > 0, "No elements found." );

        a17.refDelete( );
        // cleanup
        mpA.delete( );
        mpA2.delete( );
        mpA3.delete( );

        saveConnectionOne( );
    }

    @Test
    public void testDuplicateCompositeParentLinkDelete( ) throws Exception {

        MyConsistencyListener listener = createInconsistencyListener( this.getMOINConnection( ) );

        ModelPartition mpA = this.recreatePartition( "DuplicateParentConsistencyTestA" );
        ModelPartition mpB = this.recreatePartition( "DuplicateParentConsistencyTestB" );

        D6 child = createD6( );
        LRI childLri = ( (Partitionable) child ).get___Mri( ).getLri( );
        C6 parent = createC6( );

        parent.setW( child );

        mpA.assignElement( parent );
        mpB.assignElement( child );
        saveConnectionOne( );

        byte[] oldAXml = this.getPartitionByteArray( mpA );
        byte[] oldBXml = this.getPartitionByteArray( mpB );

        mpA.delete( );
        mpB.delete( );
        saveConnectionOne( );

        ModelPartition newB = this.createNewPartitionFromByteArray( "DuplicateParentConsistencyTestB", oldBXml, this._testClient1 );

        D6 oldChild = (D6) this.getMOINConnection( ).getElement( childLri );

        ModelPartition newA = this.recreatePartition( "DuplicateParentConsistencyTestANew" );

        C6 newParent = createC6( );
        newParent.setW( oldChild );

        newA.assignElement( newParent );

        saveConnectionOne( );

        ModelPartition oldA = this.createNewPartitionFromByteArray( "DuplicateParentConsistencyTestA", oldAXml, this._testClient1 );

        // call triggering the inconsistency event
        EndStorageLink compositeParentLink = getLinkActionManager( getMOINConnection( ) ).getCompositeParentLink( getTestHelper( ).getCoreConnection( getMOINConnection( ) ).getSession( ), getTestHelper( ).getCorePartitionable( oldChild ) );

        ConsistencyViolation foundViolation = null;
        this.processNotificationQueue( );

        for ( ConsistencyViolation consistencyViolation : listener.getViolations( ) ) {
            if ( ( (DuplicateParentConsistencyViolation) consistencyViolation ).getChildLri( ).equals( childLri ) ) {
                foundViolation = consistencyViolation;
                break;
            }
        }

        LinkDeleteCorrectionImpl correction = (LinkDeleteCorrectionImpl) foundViolation.getCorrectionHandles( this.getMOINConnection( ) )[0];

        this.getMOINConnection( ).getConsistencyViolationListenerRegistry( ).applyCorrection( correction.getId( ) );

        this.processNotificationQueue( );
        verify( listener.getViolations( ).isEmpty( ), "Inconsistencies left." );

        mpA.delete( );
        mpB.delete( );
        saveConnectionOne( );

    }

    @Test
    public void testDuplicateCompositeParentElementDelete( ) throws Exception {

        MyConsistencyListener listener = createInconsistencyListener( this.getMOINConnection( ) );

        ModelPartition mpA = this.recreatePartition( "DuplicateParentConsistencyTestA" );
        ModelPartition mpB = this.recreatePartition( "DuplicateParentConsistencyTestB" );

        D6 child = createD6( );
        LRI childLri = ( (Partitionable) child ).get___Mri( ).getLri( );
        C6 parent = createC6( );

        parent.setW( child );

        mpA.assignElement( parent );
        mpB.assignElement( child );
        saveConnectionOne( );

        byte[] oldAXml = this.getPartitionByteArray( mpA );
        byte[] oldBXml = this.getPartitionByteArray( mpB );

        mpA.delete( );
        mpB.delete( );
        saveConnectionOne( );

        ModelPartition newB = this.createNewPartitionFromByteArray( "DuplicateParentConsistencyTestB", oldBXml, this._testClient1 );

        D6 oldChild = (D6) this.getMOINConnection( ).getElement( childLri );

        ModelPartition newA = this.recreatePartition( "DuplicateParentConsistencyTestANew" );

        C6 newParent = createC6( );
        newParent.setW( oldChild );

        newA.assignElement( newParent );

        saveConnectionOne( );

        ModelPartition oldA = this.createNewPartitionFromByteArray( "DuplicateParentConsistencyTestA", oldAXml, this._testClient1 );

        // call triggering the inconsistency event
        EndStorageLink compositeParentLink = getLinkActionManager( getMOINConnection( ) ).getCompositeParentLink( getTestHelper( ).getCoreConnection( getMOINConnection( ) ).getSession( ), getTestHelper( ).getCorePartitionable( oldChild ) );

        // delete child
        oldChild.refDelete( );
        saveConnectionOne( );

        // links must both be deleted
        this.processNotificationQueue( );
        verify( getTestHelper( ).getCoreModelPartition( oldA ).getLinks( ).isEmpty( ), "Link from partition oldA has not been deleted." );
        verify( getTestHelper( ).getCoreModelPartition( newA ).getLinks( ).isEmpty( ), "Link from partition newA has not been deleted." );

        this.processNotificationQueue( );
        verify( listener.getViolations( ).isEmpty( ), "Inconsistencies left." );

        mpA.delete( );
        mpB.delete( );
        saveConnectionOne( );

    }

    @Test
    public void testDanglingLinkInconsistencyRecreateOneElement( ) throws NullPartitionNotEmptyException, ReferencedTransientElementsException, PartitionsNotSavedException {

        Case016Package case016Package = testcasesPackage.getCase016( );

        MyConsistencyListener listener = createInconsistencyListener( this.getMOINConnection( ) );

        ModelPartition mpA = recreatePartition( "IconsistencyTest.RecreateTest2.PartitionA" );

        ModelPartition mpB = recreatePartition( "IconsistencyTest.RecreateTest2.PartitionB" );

        ModelPartition mpC = recreatePartition( "IconsistencyTest.RecreateTest2.PartitionC" );

        A16 a = getMOINConnection( ).createElementInPartition( A16.class, null );

        B16 b1 = getMOINConnection( ).createElementInPartition( B16.class, null );
        B16 b2 = getMOINConnection( ).createElementInPartition( B16.class, null );

        a.getB( ).add( b1 );
        a.getB( ).add( b2 );


        mpA.assignElement( a );
        mpB.assignElement( b1 );
        mpC.assignElement( b2 );

        saveConnectionOne( );

        LRI lriOfB1 = ( (Partitionable) b1 ).get___Mri( ).getLri( );
        LRI lriOfB2 = ( (Partitionable) b2 ).get___Mri( ).getLri( );

        byte[] mpAXmi = this.getPartitionByteArray( mpA );
        byte[] mpBXmi = this.getPartitionByteArray( mpB );
        byte[] mpCXmi = this.getPartitionByteArray( mpC );

        mpA.delete( );
        mpB.delete( );
        mpC.delete( );
        saveConnectionOne( );

        mpB = this.createNewPartitionFromByteArray( "IconsistencyTest.RecreateTest2.PartitionB", mpBXmi, this._testClient1 );
        mpC = this.createNewPartitionFromByteArray( "IconsistencyTest.RecreateTest2.PartitionC", mpCXmi, this._testClient1 );

        this.getMOINConnection( ).getConsistencyViolationListenerRegistry( ).performConsistencyCheck( mpB.getPri( ) );
        this.getMOINConnection( ).getConsistencyViolationListenerRegistry( ).performConsistencyCheck( mpC.getPri( ) );

        this.processNotificationQueue( );
        verify( listener.getViolations( ).size( ) > 0, "No Inconsistencies found." );

        //mpA = this.createNewPartitionFromByteArray( "IconsistencyTest.dlre.PartitionA", mpAXmi, this._testClient1 );

        // remove dangling link from partition C
        List<ConsistencyViolation> violations = listener.getViolations( );
        ConsistencyViolation violation = null;
        for ( ConsistencyViolation consistencyViolation : violations ) {
            if ( consistencyViolation.getAffectedElement( ).getPri( ).equals( mpC.getPri( ) ) ) {
                violation = consistencyViolation;
                break;
            }
        }

        if ( violation != null ) {
            ConsistencyCorrectionHandle[] correctionHandles = violation.getCorrectionHandles( this.getMOINConnection( ) );
            this.getMOINConnection( ).getConsistencyViolationListenerRegistry( ).applyCorrection( correctionHandles[0].getId( ) );
            saveConnectionOne( );
        }

        SpiLink lastLink = MoinTestCase.getTestHelper( ).getCoreModelPartition( mpB ).getLinks( ).iterator( ).next( );

        this.processNotificationQueue( );
        verify( !listener.getViolations( ).isEmpty( ), "No Inconsistencies found." );

        // there must be a violation left for partition B
        CoreConnection coreConnection = MoinTestCase.getTestHelper( ).getCoreConnection( this.getMOINConnection( ) );
        ConsistencyViolationRegistry consistencyViolationRegistry = coreConnection.getConsistencyViolationRegistry( );

        verify( consistencyViolationRegistry.checkRegisteredDanglingLink( (EndStorageLink) lastLink, false, coreConnection ) != null, "No inconsistencies in registry" );

        mpA = this.createNewPartitionFromByteArray( "IconsistencyTest.dlre.PartitionA", mpAXmi, this._testClient1 );

        verify( consistencyViolationRegistry.getAllConsistencyViolations( ).isEmpty( ), "Inconsistencies left" );

        mpB.delete( );
        mpC.delete( );
        saveConnectionOne( );
    }
}
