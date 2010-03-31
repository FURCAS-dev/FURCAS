package com.sap.tc.moin.repository.test.inconsistency;

import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sap.tc.moin.MoinPackage;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.LockedException;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.NullPartitionNotEmptyException;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.PartitionEditingNotPossibleException;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.PartitionsNotSavedException;
import com.sap.tc.moin.repository.ReferencedTransientElementsException;
import com.sap.tc.moin.repository.commands.PartitionOperation;
import com.sap.tc.moin.repository.consistency.ConsistencyCorrectionHandle;
import com.sap.tc.moin.repository.consistency.ConsistencyViolation;
import com.sap.tc.moin.repository.consistency.ConsistencyViolationListenerRegistry;
import com.sap.tc.moin.repository.consistency.DanglingLinkConsistencyViolation;
import com.sap.tc.moin.repository.consistency.DuplicateElementConsistencyViolation;
import com.sap.tc.moin.repository.consistency.DuplicateParentConsistencyViolation;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.core.EndStorageLink;
import com.sap.tc.moin.repository.core.consistency.impl.AllOtherElementsDeleteCorrectionImpl;
import com.sap.tc.moin.repository.core.consistency.impl.LinkDeleteCorrectionImpl;
import com.sap.tc.moin.test.fw.TestClient;
import com.sap.tc.moin.test.testcase.MoinTestCase;
import com.sap.tc.moin.testcases.TestcasesPackage;
import com.sap.tc.moin.testcases.case001.A1;
import com.sap.tc.moin.testcases.case001.B1;
import com.sap.tc.moin.testcases.case002.AreferencesB;
import com.sap.tc.moin.testcases.case002.B2;
import com.sap.tc.moin.testcases.case002.C2;
import com.sap.tc.moin.testcases.case006.C6;
import com.sap.tc.moin.testcases.case006.D6;
import com.sap.tc.moin.testcases.case016.A16;
import com.sap.tc.moin.testcases.case016.B16;
import com.sap.tc.moin.testcases.case016.Case016Package;
import com.sap.tc.moin.testcases.case017.A17;

/**
 * <h1>Consistency correction tests with two connections</h1>
 * <p>
 * These tests apply the consistency correction handles using a second
 * connection. It is checked if the corrections are visible by the first
 * connection.
 * <p>
 * 
 * @author d026715
 */
public class TestInconsistencyCorrectionHandles extends TestInconsistencyBase {

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
     * Correction of a duplicate element inconsistency by deleting the
     * duplicates. Scenario: double storage, elements are duplicated on both
     * sides.
     * 
     * @throws PartitionsNotSavedException
     * @throws ReferencedTransientElementsException
     * @throws NullPartitionNotEmptyException
     */
    @Test
    public void testDeletionDoubleStorageTwoDuplicateElement( ) throws NullPartitionNotEmptyException, ReferencedTransientElementsException, PartitionsNotSavedException {

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

        this.processNotificationQueue( );
        ConsistencyCorrectionHandle correction = null;
        // get inconsistency violation for partition A
        for ( ConsistencyViolation violation : listener.getViolations( ) ) {
            if ( ( (DuplicateElementConsistencyViolation) violation ).getMri( ).getPri( ).equals( mpA.getPri( ) ) ) {
                correction = violation.getCorrectionHandles( this.getMOINConnection( ) )[0];
                // test description
                correction.getDescription( );
                break;
            }
        }

        // delete element in partition A to correct inconsistencies
        // Due to composition, one of the inconsistent Bs will also be deleted
        // apply correction handle using a second connection to test cross
        // session updates
        Connection secondConnection = this.getSecondMOINConnection( );
        if ( correction != null ) {
            ConsistencyViolationListenerRegistry consistencyViolationRegistry = secondConnection.getConsistencyViolationListenerRegistry( );
            Collection<PartitionOperation> affectedPartitions = consistencyViolationRegistry.getAffectedPartitions( correction.getId( ) );
            verify( affectedPartitions.contains( new PartitionOperation( PartitionOperation.Operation.EDIT, mpA.getPri( ) ) ), "Returned affected partition are incorrect" );

            consistencyViolationRegistry.applyCorrection( correction.getId( ) );
        }
        secondConnection.save( );
        this.processNotificationQueue( );

        verify( !mpBCopy.getElements( ).isEmpty( ), "Partition is empty" );

        verify( !mpB.getElements( ).isEmpty( ), "Partition is empty" );

        // there must be inconsistencies left
        this.processNotificationQueue( );
        verify( !listener.getViolations( ).isEmpty( ), "No inconsistencies found." );

        // partition ACopy and BCopy must still contain links
        CoreModelPartition cmpACopy = MoinTestCase.getTestHelper( ).getCoreModelPartition( mpACopy );
        verify( !cmpACopy.getLinks( ).isEmpty( ), "Partition A copy contains no links" );

        // cleanup
        mpB.delete( );
        mpA.delete( );
        mpBCopy.delete( );
        mpACopy.delete( );
        saveConnectionOne( );
    }

    /**
     * Correction of a dangling link inconsistency by removing the link. The
     * other connections are informed about the correction by the partition
     * change event.
     * 
     * @throws NullPartitionNotEmptyException
     * @throws ReferencedTransientElementsException
     * @throws PartitionsNotSavedException
     */
    @Test
    public void testDanglingLinkDuplicateElementInconsistencyLinkDelete( ) throws NullPartitionNotEmptyException, ReferencedTransientElementsException, PartitionsNotSavedException {

        MyConsistencyListener listener = createInconsistencyListener( this.getMOINConnection( ) );

        ModelPartition mpA = recreatePartition( "IconsistencyTest.dlde.PartitionA" );

        ModelPartition mpB = recreatePartition( "IconsistencyTest.dlde.PartitionB" );

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

        PRI mpBPri = mpB.getPri( );

        mpA.delete( );
        mpB.delete( );
        saveConnectionOne( );

        mpA = this.createNewPartitionFromByteArray( "IconsistencyTest.dlde.PartitionA", mpAXmi, this._testClient1 );
        ModelPartition mpACopy = this.createNewPartitionFromByteArray( "IconsistencyTest.dlde.PartitionACopy", mpAXmi, this._testClient1 );

        c2 = (C2) this.getMOINConnection( ).getElement( lriOfC );
        // trigger inconsistency event
        c2.getB( );

        this.processNotificationQueue( );
        verify( listener.getViolations( ).size( ) > 1, "No Inconsistencies found." );

        // remove one of the duplicate elements
        mpA.delete( );

        Connection firstConnection = this.getMOINConnection( );

        c2 = (C2) firstConnection.getElement( lriOfC );
        // trigger inconsistency event
        c2.getB( );

        this.processNotificationQueue( );
        verify( listener.getViolations( ).size( ) > 0, "No Inconsistencies found." );

        // remove link
        Connection secondConnection = this.getSecondMOINConnection( );
        if ( listener.getViolations( ).size( ) > 0 ) {
            DanglingLinkConsistencyViolation violation = (DanglingLinkConsistencyViolation) listener.getViolations( ).get( 0 );
            ConsistencyCorrectionHandle[] correctionHandles = violation.getCorrectionHandles( secondConnection );
            // test description
            for ( ConsistencyCorrectionHandle consistencyCorrectionHandle : correctionHandles ) {
                consistencyCorrectionHandle.getDescription( );
            }
            ConsistencyCorrectionHandle consistencyCorrectionHandle = correctionHandles[0];
            Collection<PartitionOperation> affectedPartitions = secondConnection.getConsistencyViolationListenerRegistry( ).getAffectedPartitions( consistencyCorrectionHandle.getId( ) );
            verify( affectedPartitions.contains( new PartitionOperation( PartitionOperation.Operation.EDIT, mpACopy.getPri( ) ) ), "Returned affected partition are incorrect" );
            secondConnection.getConsistencyViolationListenerRegistry( ).applyCorrection( consistencyCorrectionHandle.getId( ) );
        }
        secondConnection.save( );

        this.processNotificationQueue( );
        verify( listener.getViolations( ).size( ) == 0, "Inconsistencies left." );

        mpACopy.delete( );
        saveConnectionOne( );
    }

    /**
     * Correction of dangling link inconsistency by recreating the missing
     * element. The partition containing the element is imported using another
     * connection. Since the persistence is not checked by the consistency
     * handling, the resolution of the dangling link is only visible after
     * trying to resolve the link again with the first connection.
     * 
     * @throws NullPartitionNotEmptyException
     * @throws ReferencedTransientElementsException
     * @throws PartitionsNotSavedException
     */
    @Test
    public void testDanglingLinkInconsistencyRecreateElement( ) throws NullPartitionNotEmptyException, ReferencedTransientElementsException, PartitionsNotSavedException {

        MyConsistencyListener secondListener = createInconsistencyListener( this.getSecondMOINConnection( ) );

        ModelPartition mpA = recreatePartition( "IconsistencyTest.dlde.PartitionA" );

        ModelPartition mpB = recreatePartition( "IconsistencyTest.dlde.PartitionB" );

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

        mpA = this.createNewPartitionFromByteArray( "IconsistencyTest.dlde.PartitionA", mpAXmi, this._testClient1 );

        c2 = (C2) this.getSecondMOINConnection( ).getElement( lriOfC );
        // trigger inconsistency event - violation only known to second
        // connection
        c2.getB( );

        this.processNotificationQueue( );
        verify( secondListener.getViolations( ).size( ) > 0, "No Inconsistencies found." );

        // recreate element with first connection
        mpB = this.createNewPartitionFromByteArray( "IconsistencyTest.dlde.PartitionB", mpBXmi, this._testClient1 );

        saveConnectionOne( );

        // check if violation is removed
        c2.getB( );

        this.processNotificationQueue( );
        verify( secondListener.getViolations( ).size( ) == 0, "Inconsistencies left." );

        mpA.delete( );
        mpB.delete( );
        saveConnectionOne( );
    }

    /**
     * Correction of a dangling link inconsistency by removing the link. The
     * other connections are informed about the correction by the partition
     * change event.
     * 
     * @throws NullPartitionNotEmptyException
     * @throws ReferencedTransientElementsException
     * @throws PartitionsNotSavedException
     */
    @Test
    public void testLinkDeleteCorrectionLocking( ) throws NullPartitionNotEmptyException, ReferencedTransientElementsException, PartitionsNotSavedException {

        MyConsistencyListener listener = createInconsistencyListener( this.getMOINConnection( ) );

        ModelPartition mpA = recreatePartition( "IconsistencyTest.dlde.PartitionA" );

        ModelPartition mpB = recreatePartition( "IconsistencyTest.dlde.PartitionB" );

        // change single-valued attributes
        C2 c2 = this.createC2( );
        B2 b2 = this.createB2( );
        C2 cx = this.createC2( );

        mpA.assignElement( c2 );
        mpA.assignElement( cx );
        mpB.assignElement( b2 );

        saveConnectionOne( );

        AreferencesB ref = this.case002Package.getAreferencesB( );
        ref.add( b2, c2 );

        LRI lriOfC = ( (Partitionable) c2 ).get___Mri( ).getLri( );

        saveConnectionOne( );

        byte[] mpAXmi = this.getPartitionByteArray( mpA );

        mpA.delete( );
        mpB.delete( );
        saveConnectionOne( );

        mpA = this.createNewPartitionFromByteArray( "IconsistencyTest.dlde.PartitionA", mpAXmi, this._testClient1 );
        ModelPartition mpACopy = this.createNewPartitionFromByteArray( "IconsistencyTest.dlde.PartitionACopy", mpAXmi, this._testClient1 );

        c2 = (C2) this.getMOINConnection( ).getElement( lriOfC );
        // trigger inconsistency event
        c2.getB( );

        this.processNotificationQueue( );
        verify( listener.getViolations( ).size( ) > 1, "No Inconsistencies found." );

        // remove one of the duplicate elements
        mpA.delete( );

        Connection firstConnection = this.getMOINConnection( );

        c2 = (C2) firstConnection.getElement( lriOfC );
        // trigger inconsistency event
        c2.getB( );

        this.processNotificationQueue( );
        verify( listener.getViolations( ).size( ) > 0, "No Inconsistencies found." );

        // make A copy dirty - since partition A is deleted, cx is now coming
        // from partition A copy
        cx.refDelete( );

        boolean exceptionThrown = false;

        // remove link

        this.processNotificationQueue( );
        Connection secondConnection = this.getSecondMOINConnection( );
        if ( listener.getViolations( ).size( ) > 0 ) {
            DanglingLinkConsistencyViolation violation = (DanglingLinkConsistencyViolation) listener.getViolations( ).get( 0 );
            ConsistencyCorrectionHandle consistencyCorrectionHandle = violation.getCorrectionHandles( secondConnection )[0];
            try {
                secondConnection.getConsistencyViolationListenerRegistry( ).applyCorrection( consistencyCorrectionHandle.getId( ) );
            } catch ( PartitionEditingNotPossibleException ex ) {
                if ( ex.getCause( ) instanceof LockedException ) {
                    exceptionThrown = true;
                    firstConnection.save( );
                    secondConnection.getConsistencyViolationListenerRegistry( ).applyCorrection( consistencyCorrectionHandle.getId( ) );
                }
            }
        }

        verify( exceptionThrown, "Lock exception not thrown." );

        secondConnection.save( );

        this.processNotificationQueue( );
        verify( listener.getViolations( ).size( ) == 0, "Inconsistencies left." );

        mpACopy.delete( );
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

        a17.getToEnd( ).add( a17_2 );

        mpA.assignElement( a17 );

        mpB.assignElement( a17_2 );

        saveConnectionOne( );

        byte[] mpAXmi = this.getPartitionByteArray( mpA );

        ModelPartition mpACopy = this.createNewPartitionFromByteArray( "IconsistencyTest.dsdl.PartitionACopy", mpAXmi, this._testClient1 );

        this.processNotificationQueue( );

        ConsistencyCorrectionHandle correction = null;
        for ( ConsistencyViolation violation : listener.getViolations( ) ) {
            if ( violation.getAffectedElement( ).getPri( ).equals( mpA.getPri( ) ) ) {
                correction = violation.getCorrectionHandles( this.getMOINConnection( ) )[0];
                // test description
                correction.getDescription( );

            }
        }

        Connection secondConnection = this.getSecondMOINConnection( );

        Collection<PartitionOperation> affectedPartitions = secondConnection.getConsistencyViolationListenerRegistry( ).getAffectedPartitions( correction.getId( ) );
        verify( affectedPartitions.contains( new PartitionOperation( PartitionOperation.Operation.EDIT, mpA.getPri( ) ) ), "Returned affected partition are incorrect" );


        secondConnection.getConsistencyViolationListenerRegistry( ).applyCorrection( correction.getId( ) );

        secondConnection.save( );

        this.processNotificationQueue( );
        this.verify( !MoinTestCase.getTestHelper( ).getCoreModelPartition( mpB ).getElements( ).isEmpty( ), "Component element was deleted." );

        this.verify( !MoinTestCase.getTestHelper( ).getCoreModelPartition( mpACopy ).getLinks( ).isEmpty( ), "Too many links deleted." );

        this.verifyNoConsistencyViolations( listener );

        // cleanup
        mpA.delete( );
        mpB.delete( );
        mpACopy.delete( );

        saveConnectionOne( );
    }

    /**
     * Test for one duplicate link end. Checks how the inconsistency handling
     * behaves if an inconsistency is unknown.
     * 
     * @throws PartitionsNotSavedException
     * @throws ReferencedTransientElementsException
     * @throws NullPartitionNotEmptyException
     */
    @Test
    public void testOneDuplicateElementUnknownInconsistency( ) throws NullPartitionNotEmptyException, ReferencedTransientElementsException, PartitionsNotSavedException {

        MyConsistencyListener listener = createInconsistencyListener( this.getMOINConnection( ) );

        ModelPartition mpA = this.recreatePartition( "A16Partition.ssde" );
        ModelPartition mpB = this.recreatePartition( "B16Partition.ssde" );

        Case016Package case016 = this.testcasesPackage.getCase016( );
        A16 a16 = getMOINConnection( ).createElementInPartition( A16.class, null );
        B16 b16 = getMOINConnection( ).createElementInPartition( B16.class, null );

        a16.getB( ).add( b16 );

        mpA.assignElement( a16 );
        mpB.assignElement( b16 );

        saveConnectionOne( );
        ensurePartitionLoadedInCCSW( mpA );

        byte[] partitionByteArray = this.getPartitionByteArray( mpA );

        ModelPartition mpACopy = this.createNewPartitionFromByteArray( "A16Partition.ssde.copy", partitionByteArray, this._testClient1 );

        this.processNotificationQueue( );
        ConsistencyCorrectionHandle correction = listener.getViolations( ).get( 0 ).getCorrectionHandles( this.getMOINConnection( ) )[0];

        Connection secondConnection = this.getSecondMOINConnection( );

        secondConnection.getConsistencyViolationListenerRegistry( ).applyCorrection( correction.getId( ) );

        secondConnection.save( );

        this.processNotificationQueue( );
        CoreModelPartition cmpB = MoinTestCase.getTestHelper( ).getCoreModelPartition( mpB );
        this.verify( !cmpB.getLinks( ).isEmpty( ), "Too many links deleted." );

        mpA.delete( );
        mpB.delete( );
        mpACopy.delete( );
        saveConnectionOne( );
    }

    /**
     * TODO partition writer cannot handle jmi lists with null elements ->
     * ignore test Tests dangling link inconsistencies with attribute links.
     * 
     * @throws PartitionsNotSavedException
     * @throws ReferencedTransientElementsException
     * @throws NullPartitionNotEmptyException
     */
    @Test
    public void testAttributeDanglingLinkInconsistency( ) throws NullPartitionNotEmptyException, ReferencedTransientElementsException, PartitionsNotSavedException {

        MyConsistencyListener listener = createInconsistencyListener( this.getMOINConnection( ) );

        ModelPartition mpA = this.recreatePartition( "AttributeLinkDanglingA" );

        ModelPartition mpB = this.recreatePartition( "AttributeLinkDanglingB" );

        A1 a1 = this.createA1( );

        B1 b1 = this.createB1( );

        mpA.assignElement( a1 );
        mpB.assignElement( b1 );

        a1.getBs( ).add( b1 );

        saveConnectionOne( );

        byte[] mpAXmi = this.getPartitionByteArray( mpA );

        mpA.delete( );
        mpB.delete( );
        saveConnectionOne( );

        // recreate partition A
        mpA = this.createNewPartitionFromByteArray( "AttributeLinkDanglingA", mpAXmi, this._testClient1 );

        a1.getBs( ).iterator( ).next( ); // Trigger detection of dangling link inconsistency.

        this.processNotificationQueue( );
        verify( !listener.getEvents( ).isEmpty( ), "No inconsistencies found." );

        ConsistencyViolation consistencyViolation = listener.getViolations( ).get( 0 );

        this.getMOINConnection( ).getConsistencyViolationListenerRegistry( ).applyCorrection( consistencyViolation.getCorrectionHandles( this.getMOINConnection( ) )[0].getId( ) );

        this.processNotificationQueue( );
        verify( listener.getEvents( ).isEmpty( ), "Inconsistencies left." );

        saveConnectionOne( );

        // cleanup
        mpA.delete( );
        saveConnectionOne( );
    }

    /**
     * Tests duplicate element inconsistencies with attribute links.
     * 
     * @throws PartitionsNotSavedException
     * @throws ReferencedTransientElementsException
     * @throws NullPartitionNotEmptyException
     */
    @Test
    public void testAttributeOneDuplicateElementInconsistency( ) throws NullPartitionNotEmptyException, ReferencedTransientElementsException, PartitionsNotSavedException {

        MyConsistencyListener listener = createInconsistencyListener( this.getMOINConnection( ) );

        ModelPartition mpA = this.recreatePartition( "AttributeLinkDuplicateElementA" );

        ModelPartition mpB = this.recreatePartition( "AttributeLinkDuplicateElementB" );

        A1 a1 = this.createA1( );

        B1 b1 = this.createB1( );

        mpA.assignElement( a1 );
        mpB.assignElement( b1 );

        a1.getBs( ).add( b1 );

        saveConnectionOne( );

        byte[] mpBXmi = this.getPartitionByteArray( mpB );

        ModelPartition mpBCopy = this.createNewPartitionFromByteArray( "AttributeLinkDuplicateElementBCopy", mpBXmi, this._testClient1 );

        this.processNotificationQueue( );
        verify( !listener.getEvents( ).isEmpty( ), "No inconsistencies found." );

        ConsistencyViolation consistencyViolation = listener.getViolations( ).get( 0 );

        this.getMOINConnection( ).getConsistencyViolationListenerRegistry( ).applyCorrection( consistencyViolation.getCorrectionHandles( this.getMOINConnection( ) )[0].getId( ) );

        this.processNotificationQueue( );
        verify( listener.getEvents( ).isEmpty( ), "Inconsistencies left." );

        saveConnectionOne( );

        // cleanup
        mpBCopy.delete( );
        mpA.delete( );
        mpB.delete( );
        saveConnectionOne( );
    }

    private A1 createA1( ) {

        return getMOINConnection( ).createElementInPartition( A1.class, null );
    }

    private B1 createB1( ) {

        return getMOINConnection( ).createElementInPartition( B1.class, null );
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

        ConsistencyCorrectionHandle[] correctionHandles = foundViolation.getCorrectionHandles( this.getMOINConnection( ) );
        for ( ConsistencyCorrectionHandle consistencyCorrectionHandle : correctionHandles ) {
            // test description
            consistencyCorrectionHandle.getDescription( );
        }

        LinkDeleteCorrectionImpl correction = (LinkDeleteCorrectionImpl) correctionHandles[0];

        this.getMOINConnection( ).getConsistencyViolationListenerRegistry( ).applyCorrection( correction.getId( ) );

        verify( !foundViolation.validate( this.getMOINConnection( ) ), "Validation failed." );

        this.processNotificationQueue( );
        verify( listener.getViolations( ).isEmpty( ), "Inconsistencies left." );

        mpA.delete( );
        mpB.delete( );
        saveConnectionOne( );

    }

    /**
     * Correction of a duplicate element inconsistency by deleting the
     * duplicates. Scenario: double storage, elements are duplicated on both
     * sides.
     * 
     * @throws PartitionsNotSavedException
     * @throws ReferencedTransientElementsException
     * @throws NullPartitionNotEmptyException
     */
    @Test
    public void testDuplicateElementDeleteAllOthersCorrection( ) throws NullPartitionNotEmptyException, ReferencedTransientElementsException, PartitionsNotSavedException {

        MyConsistencyListener listener = createInconsistencyListener( this.getMOINConnection( ) );

        // clear PartitionA
        ModelPartition mpA = this._testClient1.getOrCreatePartitionStable( "IconsistencyTestDeleteAllOthers.PartitionA1" );
        mpA.delete( );

        saveConnectionOne( );

        mpA = this._testClient1.getOrCreatePartitionStable( "IconsistencyTest.ds1i.PartitionA" );

        // change single-valued attributes
        A17 a17 = getMOINConnection( ).createElementInPartition( A17.class, null );

        mpA.assignElement( a17 );

        saveConnectionOne( );

        // create inconsistencies       
        byte[] mpAXmi = this.getPartitionByteArray( mpA );

        TestClient client = this._testClient1;
        ModelPartition mpA2 = this.createDuplicatePartition( "IconsistencyTestDeleteAllOthers.PartitionA2", mpAXmi, client );

        ModelPartition mpA3 = this.createDuplicatePartition( "IconsistencyTestDeleteAllOthers.PartitionA3", mpAXmi, client );

        this.processNotificationQueue( );
        ConsistencyCorrectionHandle correction = null;
        // get inconsistency violation for partition A
        for ( ConsistencyViolation violation : listener.getViolations( ) ) {
            if ( ( (DuplicateElementConsistencyViolation) violation ).getMri( ).getPri( ).equals( mpA.getPri( ) ) ) {
                ConsistencyCorrectionHandle[] corrections = violation.getCorrectionHandles( this.getMOINConnection( ) );
                // test description
                for ( ConsistencyCorrectionHandle consistencyCorrectionHandle : corrections ) {
                    consistencyCorrectionHandle.getDescription( );
                    if ( consistencyCorrectionHandle instanceof AllOtherElementsDeleteCorrectionImpl ) {
                        correction = consistencyCorrectionHandle;
                    }
                }

                break;
            }
        }

        // delete all inconsistent elements except the one in partition A
        boolean correctAffectedPartitionsFound = false;
        int foundViolations = listener.getViolations( ).size( );
        Connection secondConnection = this.getSecondMOINConnection( );
        if ( correction != null ) {
            ConsistencyViolationListenerRegistry consistencyViolationRegistry = secondConnection.getConsistencyViolationListenerRegistry( );
            Collection<PartitionOperation> affectedPartitions = consistencyViolationRegistry.getAffectedPartitions( correction.getId( ) );
            if ( affectedPartitions.size( ) == ( foundViolations - 1 ) ) {
                correctAffectedPartitionsFound = !affectedPartitions.contains( new PartitionOperation( PartitionOperation.Operation.EDIT, mpA.getPri( ) ) );
            }

            consistencyViolationRegistry.applyCorrection( correction.getId( ) );
        }
        secondConnection.save( );
        this.processNotificationQueue( );

        verify( correctAffectedPartitionsFound, "Affected partitions are incorrect" );

        try {
            verify( listener.getViolations( ).isEmpty( ), "Inconsistencies left." );
        } catch ( AssertionError e ) {
            throw e;
        } finally {

            // cleanup
            mpA.delete( );
            mpA2.delete( );
            mpA3.delete( );

            saveConnectionOne( );
        }
    }
}
