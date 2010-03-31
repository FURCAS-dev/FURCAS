package com.sap.tc.moin.repository.test.inconsistency;

import java.io.ByteArrayInputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sap.junit.Staged;
import com.sap.tc.moin.MoinPackage;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.InconsistentModelException;
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
import com.sap.tc.moin.repository.consistency.DanglingLinkConsistencyViolation;
import com.sap.tc.moin.repository.consistency.DuplicateElementConsistencyViolation;
import com.sap.tc.moin.repository.consistency.DuplicateParentConsistencyViolation;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.core.CoreMoin;
import com.sap.tc.moin.repository.core.CorePartitionable;
import com.sap.tc.moin.repository.core.EndStorageLink;
import com.sap.tc.moin.repository.core.MetamodelWorkspace;
import com.sap.tc.moin.repository.core.consistency.ConsistencyViolationRegistry;
import com.sap.tc.moin.repository.core.serialization.PartitionReaderImpl;
import com.sap.tc.moin.repository.spi.core.SpiPartitionable;
import com.sap.tc.moin.test.fw.NwdiTestClientImpl;
import com.sap.tc.moin.test.testcase.MoinTestCase;
import com.sap.tc.moin.testcases.TestcasesPackage;
import com.sap.tc.moin.testcases.case001.A1;
import com.sap.tc.moin.testcases.case001.B1;
import com.sap.tc.moin.testcases.case002.AreferencesB;
import com.sap.tc.moin.testcases.case002.B2;
import com.sap.tc.moin.testcases.case002.C2;
import com.sap.tc.moin.testcases.case005.p1.A5;
import com.sap.tc.moin.testcases.case005.p1.p2.B5;
import com.sap.tc.moin.testcases.case006.B6;
import com.sap.tc.moin.testcases.case006.C6;
import com.sap.tc.moin.testcases.case006.D6;
import com.sap.tc.moin.testcases.case016.A16;
import com.sap.tc.moin.testcases.case016.B16;
import com.sap.tc.moin.testcases.case017.A17;
import com.sap.tc.moin.testcases.case017.Case017Package;

/**
 * <h1>Test of the inconsistency handling</h1>
 * <p>
 * These tests check the behaviour of MOIN in case of inconsistencies.
 * <p>
 * 
 * @author d026715
 */
public class TestInconsistencyBehavior extends TestInconsistencyBase {

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

    private B1 createB1( ) {

        return getMOINConnection( ).createElementInPartition( B1.class, null );
    }

    private A1 createA1( Connection connection ) {

        return connection.createElementInPartition( A1.class, null );
    }

    private A1 createA1( ) {

        return this.createA1( getMOINConnection( ) );
    }

    /**
     * Test of double storage links with an inconsistency on one side. Instance
     * a17 is assigned to PartitionA and saved. Instance a17_2, which is at the
     * other end of a double storage link of a17 is assigned to pertition B and
     * saved. Partition B is cloned. The element a17_2 exists in two partitions
     * then.
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
        ModelPartition mpA = this._testClient1.getOrCreatePartitionStable( "IconsistencyTest.ds1i.PartitionA" );
        mpA.deleteElements( );

        // clear PartitionB
        ModelPartition mpB = this._testClient1.getOrCreatePartitionStable( "IconsistencyTest.ds1i.PartitionB" );
        mpB.deleteElements( );
        save( );

        // change single-valued attributes
        A17 a17 = createA17( );

        mpA.assignElement( a17 );

        mpB.assignElement( a17.getToEnd( ).iterator( ).next( ) );

        MRI mriA17 = ( (Partitionable) a17 ).get___Mri( );

        save( );

        byte[] mpBXmi = this.getPartitionByteArray( mpB );

        ModelPartition mpBCopy = this.createDuplicatePartition( "IconsistencyTest.ds1i.PartitionBCopy", mpBXmi, this._testClient1 );

        boolean correctionSuccessful = false;

        // use second connection
        a17 = (A17) this.getSecondMOINConnection( ).getElement( mriA17 );
        a17.getToEnd( ).iterator( ).next( );

        this.processNotificationQueue( );
        ConsistencyViolation event = secondListener.getEvents( ).get( 0 );

        this.verify( event instanceof DuplicateElementConsistencyViolation, "DuplicateElement inconsistency detected." );

        CoreConnection coreConnection = getTestHelper( ).getCoreConnection( getSecondMOINConnection( ) );
        Collection<CorePartitionable> instances = coreConnection.getSession( ).getWorkspace( ).getInstanceManager( ).getInstances( );
        for ( SpiPartitionable spiPartitionable : instances ) {
            assertNotNull( spiPartitionable );
        }

        // explicit inconsistency check
        this.getMOINConnection( ).getConsistencyViolationListenerRegistry( ).performConsistencyCheck( mpA.getPri( ) );

        this.processNotificationQueue( );
        ConsistencyViolation explicitCheckEvent = listener.getEvents( ).get( 0 );

        if ( explicitCheckEvent instanceof DuplicateElementConsistencyViolation ) {
            MRI mri = ( (DuplicateElementConsistencyViolation) explicitCheckEvent ).getMri( );
            A17 a17_2 = (A17) this.getMOINConnection( ).getElement( mri );

            ConsistencyCorrectionHandle[] correctionHandles = ( (DuplicateElementConsistencyViolation) explicitCheckEvent ).getCorrectionHandles( this.getMOINConnection( ) );

            for ( int i = 0; i < 1; i++ ) {
                this.getMOINConnection( ).getConsistencyViolationListenerRegistry( ).applyCorrection( correctionHandles[0].getId( ) );
            }

            a17.getToEnd( ).iterator( ).next( );
            save( );

            this.processNotificationQueue( );
            if ( listener.getEvents( ).isEmpty( ) ) {
                correctionSuccessful = true;
            }
        }

        this.verify( correctionSuccessful, "Correction" );

        // cleanup
        mpA.delete( );
        mpB.delete( );
        mpBCopy.delete( );
        save( );
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
    public void testTwoDuplicateElementInconsistencies( ) throws NullPartitionNotEmptyException, ReferencedTransientElementsException, PartitionsNotSavedException {

        MyConsistencyListener listener = createInconsistencyListener( this.getMOINConnection( ) );
        MyConsistencyListener secondListener = createInconsistencyListener( this.getSecondMOINConnection( ) );

        // clear PartitionA
        ModelPartition mpA = this._testClient1.getOrCreatePartition( "IconsistencyTest.ds2i.PartitionA" );
        mpA.deleteElements( );

        // clear PartitionB
        ModelPartition mpB = this._testClient1.getOrCreatePartition( "IconsistencyTest.ds2i.PartitionB" );
        mpB.deleteElements( );
        save( );

        // change single-valued attributes
        A17 a17 = createA17( );

        mpA.assignElement( a17 );

        mpB.assignElement( a17.getToEnd( ).iterator( ).next( ) );

        MRI mriA17 = ( (Partitionable) a17 ).get___Mri( );

        save( );

        byte[] mpBXmi = this.getPartitionByteArray( mpB );
        byte[] mpAXmi = this.getPartitionByteArray( mpA );

        ModelPartition mpBCopy = this.createDuplicatePartition( "IconsistencyTest.ds2i.PartitionBCopy", mpBXmi, this._testClient1 );

        ModelPartition mpACopy = this.createDuplicatePartition( "IconsistencyTest.ds2i.PartitionACopy", mpAXmi, this._testClient1 );

        boolean correctionSuccessful = false;

        a17 = (A17) this.getSecondMOINConnection( ).getElement( mriA17 );
        a17.getToEnd( ).iterator( ).next( );

        this.processNotificationQueue( );
        ConsistencyViolation event = secondListener.getEvents( ).get( 0 );

        this.verify( event instanceof DuplicateElementConsistencyViolation, "DuplicateElement inconsistency detected." );

        // explicit inconsitency check
        this.getMOINConnection( ).getConsistencyViolationListenerRegistry( ).performConsistencyCheck( mpA.getPri( ) );
        this.getMOINConnection( ).getConsistencyViolationListenerRegistry( ).performConsistencyCheck( mpB.getPri( ) );

        List<ConsistencyViolation> events = listener.getEvents( );

        // cleanup
        mpA.delete( );
        mpB.delete( );
        mpBCopy.delete( );
        mpACopy.delete( );
        save( );
    }

    /**
     * Test for duplicate link ends. A5 has a composite link to B5. Instance a5
     * is assigned to partition "All" and saved. Instance b5 is assigned to
     * partition "B" and saved. Then B is exported as XMI and imported as
     * "NewB". The element b5 exists in both partitions then and can no longer
     * be resolved.
     */
    @Test
    public void testSingleStorageOneDuplicateElementInconsistency( ) throws Exception {

        MyConsistencyListener listener = createInconsistencyListener( this.getMOINConnection( ) );

        ModelPartition mpForB = this._testClient1.getOrCreatePartition( "SingleStorageOneDuplicateElementB" );
        mpForB.deleteElements( );

        ModelPartition mpForAll = this._testClient1.getOrCreatePartition( "SingleStorageOneDuplicateElementAll" );
        mpForAll.deleteElements( );

        save( );

        // change single-valued attributes
        A5 a5 = createA5( );

        B5 b5 = a5.getX( );

        mpForB.assignElement( b5 );
        mpForAll.assignElement( a5 );

        MRI mri = ( (Partitionable) a5 ).get___Mri( );

        save( );


        byte[] mpForBByteArray = getPartitionByteArray( mpForB );

        // create second partition
        ModelPartition newMpForB = createNewPartitionFromByteArray( "SingleStorageOneDuplicateElementNewB", mpForBByteArray, this._testClient1 );

        boolean correctionSuccessful = false;

        a5 = (A5) this.getMOINConnection( ).getElement( mri );
        b5 = a5.getX( );

        // explicit inconsistency check
        this.getMOINConnection( ).getConsistencyViolationListenerRegistry( ).performConsistencyCheck( mpForAll.getPri( ) );

        this.processNotificationQueue( );
        ConsistencyViolation event = null;
        if ( listener.getEvents( ).size( ) > 0 ) {
            event = listener.getEvents( ).get( 0 );
        }

        this.verify( event instanceof DuplicateElementConsistencyViolation, "No DuplicateElement inconsistency detected." );

        ConsistencyCorrectionHandle[] correctionHandles = ( (DuplicateElementConsistencyViolation) event ).getCorrectionHandles( this.getMOINConnection( ) );

        MRI mriToDelete = ( (Partitionable) b5 ).get___Mri( );

        for ( int i = 0; i < 1; i++ ) {
            this.getMOINConnection( ).getConsistencyViolationListenerRegistry( ).applyCorrection( correctionHandles[0].getId( ) );
        }

        save( );

        b5 = a5.getX( );

        this.processNotificationQueue( );
        if ( listener.getEvents( ).isEmpty( ) ) {
            correctionSuccessful = true;
        }

        this.verify( correctionSuccessful, "Correction" );

        // cleanup
        mpForAll.delete( );
        mpForB.delete( );
        save( );
    }

    /**
     * Test for dangling link ends. A5 has a composite link to B5. Instance a5
     * is assigned to partition "All". Instance b5 is assigned to partition "B".
     * Then B is exported as XMI. After deleting all partitions, "All" is
     * imported again from the XMI.
     */
    @Test
    public void testDanglingCompositeLinkEnds( ) throws Exception {

        MyConsistencyListener listener = createInconsistencyListener( this.getMOINConnection( ) );

        ModelPartition mpForAll = ( (NwdiTestClientImpl) this._testClient1 ).getOrCreatePartition( "DanglingLinkEnds.All", false );
        mpForAll.deleteElements( );
        save( );

        // change single-valued attributes
        A5 a5 = createA5( );

        B5 b5 = a5.getX( );

        // assign the rest to "All"
        for ( Partitionable element : this.getMOINConnection( ).getNullPartition( ).getElements( ) ) {
            mpForAll.assignElement( element );
        }

        // assign b5 to "B"
        ModelPartition mpForB = ( (NwdiTestClientImpl) this._testClient1 ).getOrCreatePartition( "DanglingLinkEnds.B", false );
        mpForB.deleteElements( );
        mpForB.assignElement( b5 );

        MRI mri = ( (Partitionable) a5 ).get___Mri( );

        save( );

        byte[] mpForAllByteArray = getPartitionByteArray( mpForAll );


        // delete everything
        mpForAll.delete( );
        mpForB.delete( );
        save( );


        mpForAll = createNewPartitionFromByteArray( "DanglingLinkEnds.All", mpForAllByteArray, this._testClient1 );

        this.processNotificationQueue( );

        try {

            a5 = (A5) this.getMOINConnection( ).getElement( mri );
            b5 = a5.getX( );

            this.processNotificationQueue( );
            ConsistencyViolation event = listener.getEvents( ).get( 0 );

            this.verify( event instanceof DanglingLinkConsistencyViolation, "DanglingLink inconsistency detected." );

            // test description
            String description = event.getDescription( this.getMOINConnection( ), Locale.getDefault( ) );

            this.verify( description != null, "No description found." );

            // test description without locale
            String descriptionDefault = event.getDescription( this.getMOINConnection( ) );

            this.verify( descriptionDefault != null, "No description found (using default locale)." );

        } finally {
            // cleanup
            mpForAll.delete( );
            save( );
        }
    }

    /**
     * 
     */
    private void save( ) {

        try {
            this.getMOINConnection( ).save( );
        } catch ( Exception e ) {
            errorAndStop( "Partition could not be saved.", e );
        }
    }

    /**
     * Test for one duplicate link end. Checks how the inconsistency handling
     * behaves if an inconsistency is unknown.
     * 
     * @throws PartitionsNotSavedException
     * @throws ReferencedTransientElementsException
     * @throws NullPartitionNotEmptyException
     */
    // @Test
    public void testSingleStorageOneDuplicateElementUnknownInconsistency( ) throws NullPartitionNotEmptyException, ReferencedTransientElementsException, PartitionsNotSavedException {

        MyConsistencyListener listener = createInconsistencyListener( this.getMOINConnection( ) );

        ModelPartition mpA = this.recreatePartition( "A16Partition.ssde" );
        ModelPartition mpB = this.recreatePartition( "B16Partition.ssde" );

        A16 a16 = getMOINConnection( ).createElementInPartition( A16.class, null );
        B16 b16 = getMOINConnection( ).createElementInPartition( B16.class, null );

        a16.getB( ).add( b16 );

        mpA.assignElement( a16 );
        mpB.assignElement( b16 );

        byte[] partitionByteArray = this.getPartitionByteArray( mpA );

        ModelPartition mpACopy = this.createDuplicatePartition( "A16Partition.ssde.copy", partitionByteArray, this._testClient1 );

        Connection secondConnection = this.getSecondMOINConnection( );
        A16 a16x = (A16) secondConnection.getElement( ( (Partitionable) a16 ).get___Mri( ) );

        a16x.refDelete( );
        secondConnection.save( );

        CoreModelPartition cmpA = this.getTestHelper( ).getCoreModelPartition( mpB );
        this.verify( !cmpA.getLinks( ).isEmpty( ), "Too many links deleted." );

        mpA.delete( );
        mpB.delete( );
        mpACopy.delete( );
        save( );
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
    // @Test
    public void testDoubleStorageDuplicateElementCompositeDeletion( ) throws NullPartitionNotEmptyException, ReferencedTransientElementsException, PartitionsNotSavedException {

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

        Connection secondConnection = this.getSecondMOINConnection( );
        A17 a17x = (A17) secondConnection.getElement( ( (Partitionable) a17 ).get___Mri( ) );

        a17x.refDelete( );
        secondConnection.save( );

        //        a17 = (A17) this.getMOINConnection().getElement(((Partitionable) a17).get___Mri().getLri());

        this.verify( !a17.getToEnd( ).isEmpty( ), "Component element was deleted." );

        this.verify( !this.getTestHelper( ).getCoreModelPartition( mpB ).getElements( ).isEmpty( ), "Too many elements deleted." );

        this.verify( !this.getTestHelper( ).getCoreModelPartition( mpACopy ).getLinks( ).isEmpty( ), "Too many links deleted." );

        this.verifyNoConsistencyViolations( listener );

        // cleanup
        mpA.delete( );
        mpB.delete( );
        mpACopy.delete( );

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

        save( );

        byte[] mpBXmi = this.getPartitionByteArray( mpB );

        ModelPartition mpBCopy = this.createNewPartitionFromByteArray( "AttributeLinkDuplicateElementBCopy", mpBXmi, this._testClient1 );

        this.processNotificationQueue( );
        verify( !listener.getEvents( ).isEmpty( ), "No inconsistencies found." );

        ConsistencyViolation consistencyViolation = listener.getViolations( ).get( 0 );

        this.getMOINConnection( ).getConsistencyViolationListenerRegistry( ).applyCorrection( consistencyViolation.getCorrectionHandles( this.getMOINConnection( ) )[0].getId( ) );

        this.processNotificationQueue( );
        verify( listener.getEvents( ).isEmpty( ), "Inconsistencies left." );

        save( );

        // cleanup
        mpBCopy.delete( );
        mpA.delete( );
        mpB.delete( );
        save( );
    }

    /**
     * Test of double storage links with an inconsistency on one side. Instance
     * a17 is assigned to PartitionA and saved. Instance a17_2, which is at the
     * other end of a double storage link of a17 is assigned to pertition B and
     * saved. Partition B is cloned. The element a17_2 exists in two partitions
     * then.
     * 
     * @throws PartitionsNotSavedException
     * @throws ReferencedTransientElementsException
     * @throws NullPartitionNotEmptyException
     */
    //@Test
    public void testHugeNumberOfDuplicateInconsistencies( ) throws NullPartitionNotEmptyException, ReferencedTransientElementsException, PartitionsNotSavedException {

        MyConsistencyListener listener = createInconsistencyListener( this.getMOINConnection( ) );

        // clear PartitionA
        ModelPartition mpA = this.recreatePartition( "IconsistencyTest.ds1i.PartitionA" );

        // clear PartitionB
        ModelPartition mpB = this.recreatePartition( "IconsistencyTest.ds1i.PartitionB" );

        save( );

        // change single-valued attributes
        A17 a17 = createA17( );

        mpA.assignElement( a17 );

        Partitionable component = a17.getToEnd( ).iterator( ).next( );

        mpB.assignElement( component );

        save( );

        byte[] mpBXmi = this.getPartitionByteArray( mpB );

        ModelPartition[] partitionClones = new ModelPartition[200];

        for ( int i = 0; i < partitionClones.length; i++ ) {
            partitionClones[i] = this.createDuplicatePartition( "IconsistencyTest.ds1i.PartitionB_" + i, mpBXmi, this._testClient1 );
        }

        // get with other connection
        A17 secondA17 = (A17) this.getSecondMOINConnection( ).getElement( component.get___Mri( ).getLri( ) );

        // cleanup
        mpA.delete( );
        mpB.delete( );
        for ( int i = 0; i < partitionClones.length; i++ ) {
            partitionClones[i].delete( );
        }
        save( );
    }

    /**
     * Test of double storage links with an inconsistency on one side. Instance
     * a17 is assigned to PartitionA and saved. Instance a17_2, which is at the
     * other end of a double storage link of a17 is assigned to pertition B and
     * saved. Partition B is cloned. The element a17_2 exists in two partitions
     * then.
     * 
     * @throws PartitionsNotSavedException
     * @throws ReferencedTransientElementsException
     * @throws NullPartitionNotEmptyException
     */
    // Staged: functionality is tested elsewhere, takes very long
    @Test
    @Staged
    public void testHugeNumberOfDanglingLinkInconsistencies( ) throws NullPartitionNotEmptyException, ReferencedTransientElementsException, PartitionsNotSavedException {

        MyConsistencyListener listener = createInconsistencyListener( this.getMOINConnection( ) );

        // clear PartitionA
        ModelPartition mpA = this.recreatePartition( "IconsistencyTest.ds1i.PartitionA" );

        // clear PartitionB
        ModelPartition mpB = this.recreatePartition( "IconsistencyTest.ds1i.PartitionB" );

        save( );

        // change single-valued attributes
        A17 a17 = createA17( );

        LRI lri = ( (Partitionable) a17 ).get___Mri( ).getLri( );

        mpA.assignElement( a17 );

        Partitionable component = a17.getToEnd( ).iterator( ).next( );

        mpB.assignElement( component );

        save( );

        byte[] mpAXmi = this.getPartitionByteArray( mpA );

        mpA.delete( );
        mpB.delete( );
        save( );

        ModelPartition[] partitionClones = new ModelPartition[100];

        for ( int i = 0; i < partitionClones.length; i++ ) {
            partitionClones[i] = this.createDuplicatePartition( "IconsistencyTest.ds1i.PartitionB_" + i, mpAXmi, this._testClient1 );
        }

        for ( int i = 0; i < partitionClones.length; i++ ) {
            MRI elementMri = partitionClones[i].getPri( ).createMri( lri.getMofId( ) );
            A17 element = (A17) this.getMOINConnection( ).getElement( elementMri );
            element.getToEnd( ).iterator( ).next( );
        }

        this.processNotificationQueue( );
        // get with other connection
        //A17 secondA17 = (A17) this.getSecondMOINConnection().getElement(component.get___Mri().getLri());
        listener.getViolations( ).size( );

        System.out.println( "# of notifications: " + listener.getNumberOfNotifications( ) );

        // cleanup

        for ( int i = 0; i < partitionClones.length; i++ ) {
            partitionClones[i].delete( );
        }
        save( );
    }

    /**
     * Test of double storage links with an inconsistency on one side. Instance
     * a17 is assigned to PartitionA and saved. Instance a17_2, which is at the
     * other end of a double storage link of a17 is assigned to pertition B and
     * saved. Partition B is cloned. The element a17_2 exists in two partitions
     * then.
     * 
     * @throws PartitionsNotSavedException
     * @throws ReferencedTransientElementsException
     * @throws NullPartitionNotEmptyException
     */
    //@Test
    public void testDuplicateParentLink( ) throws NullPartitionNotEmptyException, ReferencedTransientElementsException, PartitionsNotSavedException {

        MyConsistencyListener listener = createInconsistencyListener( this.getMOINConnection( ) );

        // clear PartitionA
        ModelPartition mpA = this.recreatePartition( "IconsistencyTest.dpl.PartitionA" );

        save( );

        // change single-valued attributes
        A17 a17 = createA17( );

        mpA.assignElement( a17 );
        mpA.assignElement( a17.getToEnd( ).iterator( ).next( ) );

        save( );

        byte[] mpAXmi = this.getPartitionByteArray( mpA );

        // remove component from parent
        Iterator<A17> iter = a17.getToEnd( ).iterator( );
        A17 component = iter.next( );
        iter.remove( );

        a17.refDelete( );

        mpA.assignElement( component );

        save( );

        // add new component
        A17 newParent = getMOINConnection( ).createElementInPartition( A17.class, null );

        newParent.getToEnd( ).add( component );

        mpA.assignElement( newParent );
        mpA.assignElement( component );

        save( );

        // reload old A
        ModelPartition mpACopy = this.createDuplicatePartition( "IconsistencyTest.dpl.PartitionACopy", mpAXmi, this._testClient1 );

        newParent.getToEnd( );
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
    public void testExplicitCheck( ) throws NullPartitionNotEmptyException, ReferencedTransientElementsException, PartitionsNotSavedException {

        MyConsistencyListener listener = createInconsistencyListener( this.getSecondMOINConnection( ) );

        ModelPartition mpA = this.recreatePartition( "A16Partition.ssde" );

        A16 a16 = getMOINConnection( ).createElementInPartition( A16.class, null );

        mpA.assignElement( a16 );

        MRI mri = ( (Partitionable) a16 ).get___Mri( );

        byte[] partitionByteArray = this.getPartitionByteArray( mpA );

        ModelPartition mpACopy = this.createDuplicatePartition( "A16Partition.ssde.copy", partitionByteArray, this._testClient1 );

        Connection secondConnection = this.getSecondMOINConnection( );

        // explicitly load the partition
        secondConnection.getPartition( mri.getPri( ) );
        //secondConnection.getPartition(mpACopy.getPri());

        // resolve the element
        A16 a16x = (A16) secondConnection.getElement( mri.getLri( ) );

        //this.verify(!listener.getViolations().isEmpty(), "Inconsistency not found.");

        this.getSecondMOINConnection( ).getConsistencyViolationListenerRegistry( ).performConsistencyCheck( mri.getPri( ) );

        this.processNotificationQueue( );
        this.verify( !listener.getViolations( ).isEmpty( ), "Inconsistency not found." );

        listener.reset( );

        this.getSecondMOINConnection( ).getConsistencyViolationListenerRegistry( ).performConsistencyCheck( mri.getPri( ) );

        this.processNotificationQueue( );
        this.verify( !listener.getViolations( ).isEmpty( ), "Inconsistency not found." );

        mpA.delete( );
        mpACopy.delete( );
        save( );
    }

    @Test
    public void testCompositeParentRetrieval( ) throws Exception {

        MyConsistencyListener listener = createInconsistencyListener( this.getMOINConnection( ) );

        ModelPartition mpA = this.recreatePartition( "DuplicateParentConsistencyTestA" );
        ModelPartition mpB = this.recreatePartition( "DuplicateParentConsistencyTestB" );

        D6 child = createD6( );
        LRI childLri = ( (Partitionable) child ).get___Mri( ).getLri( );
        C6 parent = createC6( );

        parent.setW( child );

        mpA.assignElement( parent );
        mpB.assignElement( child );
        save( );

        byte[] oldAXml = this.getPartitionByteArray( mpA );
        byte[] oldBXml = this.getPartitionByteArray( mpB );

        mpA.delete( );
        mpB.delete( );
        save( );

        ModelPartition newB = this.createNewPartitionFromByteArray( "DuplicateParentConsistencyTestB", oldBXml, this._testClient1 );

        D6 oldChild = (D6) this.getMOINConnection( ).getElement( childLri );

        ModelPartition newA = this.recreatePartition( "DuplicateParentConsistencyTestANew" );

        C6 newParent = createC6( );
        newParent.setW( oldChild );

        newA.assignElement( newParent );

        save( );

        ModelPartition oldA = this.createNewPartitionFromByteArray( "DuplicateParentConsistencyTestA", oldAXml, this._testClient1 );

        EndStorageLink compositeParentLink = getLinkActionManager( getMOINConnection( ) ).getCompositeParentLink( getTestHelper( ).getCoreConnection( getMOINConnection( ) ).getSession( ), getTestHelper( ).getCorePartitionable( oldChild ) );

        ConsistencyViolation foundViolation = null;
        this.processNotificationQueue( );

        for ( ConsistencyViolation consistencyViolation : listener.getViolations( ) ) {
            if ( ( (DuplicateParentConsistencyViolation) consistencyViolation ).getChildLri( ).equals( childLri ) ) {
                foundViolation = consistencyViolation;
                break;
            }
        }

        foundViolation.getDescription( this.getMOINConnection( ) );

        verify( foundViolation.validate( this.getMOINConnection( ) ), "Validation failed." );

        B6 b6 = this.createB6( );

        newA.assignElement( b6 );
        parent.setX( b6 );

        save( );

        byte[] test = this.getPartitionByteArray( newB );

        mpA.delete( );
        mpB.delete( );
        save( );

    }

    /**
     * One duplicate parent element and one duplicate parent link.
     * 
     * @throws PartitionsNotSavedException
     * @throws ReferencedTransientElementsException
     * @throws NullPartitionNotEmptyException
     */
    @Test
    public void testDuplicateElementDuplicateParentInconsistency( ) throws NullPartitionNotEmptyException, ReferencedTransientElementsException, PartitionsNotSavedException {

        MyConsistencyListener listener = createInconsistencyListener( this.getMOINConnection( ) );
        MyConsistencyListener secondListener = createInconsistencyListener( this.getSecondMOINConnection( ) );

        // clear PartitionA
        ModelPartition mpA = this._testClient1.getOrCreatePartitionStable( "IconsistencyTest.ds1i.PartitionA" );
        mpA.deleteElements( );

        // clear PartitionB
        ModelPartition mpB = this._testClient1.getOrCreatePartitionStable( "IconsistencyTest.ds1i.PartitionB" );
        mpB.deleteElements( );
        save( );

        // change single-valued attributes
        A17 a17 = createA17( );

        mpA.assignElement( a17 );

        A17 a17b = a17.getToEnd( ).iterator( ).next( );
        mpB.assignElement( a17b );

        save( );

        byte[] mpAXmi = this.getPartitionByteArray( mpA );


        // delete old A        
        a17.getToEnd( ).clear( );
        a17.refDelete( );
        mpB.assignElement( a17b );
        save( );

        // create new A
        Case017Package case017Package = testcasesPackage.getCase017( );
        A17 a17new = getMOINConnection( ).createElementInPartition( A17.class, null );
        mpA.assignElement( a17new );
        a17new.getToEnd( ).add( a17b );
        save( );

        MRI mriA17 = ( (Partitionable) a17new ).get___Mri( );

        // duplicate old version of partition A
        ModelPartition mpACopy = this.createDuplicatePartition( "IconsistencyTest.ds1i.PartitionACopy", mpAXmi, this._testClient1 );
        ModelPartition mpACopy2 = this.createDuplicatePartition( "IconsistencyTest.ds1i.PartitionACopy2", mpAXmi, this._testClient1 );

        boolean violationFound = false;

        // start test
        a17 = (A17) this.getMOINConnection( ).getElement( mriA17 );
        a17.getToEnd( ).iterator( ).next( );

        EndStorageLink compositeParentLink = getLinkActionManager( getMOINConnection( ) ).getCompositeParentLink( getTestHelper( ).getCoreConnection( getMOINConnection( ) ).getSession( ), getTestHelper( ).getCorePartitionable( a17b ) );

        this.processNotificationQueue( );
        ConsistencyViolation event = listener.getEvents( ).get( 0 );

        for ( ConsistencyViolation violation : listener.getEvents( ) ) {
            if ( violation instanceof DuplicateParentConsistencyViolation ) {
                violationFound = true;
            }
        }

        this.verify( violationFound, "No duplicate parent inconsistency detected." );

        violationFound = false;

        for ( ConsistencyViolation violation : listener.getEvents( ) ) {
            if ( violation instanceof DuplicateElementConsistencyViolation ) {
                violationFound = true;
            }
        }

        this.verify( violationFound, "No duplicate element inconsistency detected." );

        // cleanup
        mpA.delete( );
        mpB.delete( );
        mpACopy.delete( );
        mpACopy2.delete( );
        save( );
    }

    /**
     * Test of double storage links with an inconsistency on one side. Instance
     * a17 is assigned to PartitionA and saved. Instance a17_2, which is at the
     * other end of a double storage link of a17 is assigned to pertition B and
     * saved. Partition B is cloned. The element a17_2 exists in two partitions
     * then.
     * 
     * @throws PartitionsNotSavedException
     * @throws ReferencedTransientElementsException
     * @throws NullPartitionNotEmptyException
     */
    // test for planned changes - not active yet
    public void testOneDuplicateElementInconsistencyInMetamodel( ) throws NullPartitionNotEmptyException, ReferencedTransientElementsException, PartitionsNotSavedException {

        MyConsistencyListener listener = createInconsistencyListener( this.getMOINConnection( ) );

        // clear PartitionB
        ModelPartition source = this._testClient1.getOrCreatePartitionStable( "IconsistencyTest.mmtest.Partition" );
        source.deleteElements( );
        save( );

        A17 a17 = createA17( );

        A17 a17b = a17.getToEnd( ).iterator( ).next( );
        source.assignElement( a17b );

        source.assignElement( a17 );
        save( );

        byte[] sourceXmi = this.getPartitionByteArray( source );

        PRI mmPri = ( (Partitionable) ( (RefObject) a17 ).refMetaObject( ) ).get___Mri( ).getPri( );

        // get metamodel workspace
        CoreConnection connection = this.getTestHelper( ).getCoreConnection( this.getMOINConnection( ) );

        MetamodelWorkspace metamodelWorkspace = connection.getSession( ).getWorkspaceSet( ).getMoin( ).getMetamodelWorkspace( );

        CoreMoin moin = connection.getSession( ).getMoin( );

        PRI newMmPri = moin.createPri( mmPri.getDataAreaDescriptor( ).getFacilityId( ), mmPri.getDataAreaDescriptor( ).getDataAreaName( ), mmPri.getContainerName( ), "dummyMMPartition.moinmm" );
        PRI newMmPriCopy = moin.createPri( mmPri.getDataAreaDescriptor( ).getFacilityId( ), mmPri.getDataAreaDescriptor( ).getDataAreaName( ), mmPri.getContainerName( ), "dummyMMPartitionCopy.moinmm" );

        CoreModelPartition mmPartition = metamodelWorkspace.getPartitionFactory( ).___createModelPartition( connection, newMmPri, metamodelWorkspace.getStage( ), metamodelWorkspace );

        CoreModelPartition mmPartitionCopy = metamodelWorkspace.getPartitionFactory( ).___createModelPartition( connection, newMmPriCopy, metamodelWorkspace.getStage( ), metamodelWorkspace );

        PartitionReaderImpl reader = new PartitionReaderImpl( );

        try {
            reader.read( getTestHelper( ).getCoreConnection( getMOINConnection( ) ).getSession( ), new ByteArrayInputStream( sourceXmi ), mmPartition );
        } catch ( Exception e ) {
            errorAndStop( "Partition could not be restored from xmi.", e );
        }

        try {
            reader.read( getTestHelper( ).getCoreConnection( getMOINConnection( ) ).getSession( ), new ByteArrayInputStream( sourceXmi ), mmPartitionCopy );
        } catch ( Exception e ) {
            errorAndStop( "Partition could not be restored from xmi.", e );
        }
    }

    @Test
    public void testOneDuplicateElementRepartitioning( ) throws NullPartitionNotEmptyException, ReferencedTransientElementsException, PartitionsNotSavedException {

        MyConsistencyListener listener = createInconsistencyListener( this.getMOINConnection( ) );

        // clear PartitionA
        ModelPartition mpA = this._testClient1.getOrCreatePartitionStable( "IconsistencyTest.ds1i.PartitionA" );
        mpA.deleteElements( );

        // clear PartitionB
        ModelPartition mpB = this._testClient1.getOrCreatePartitionStable( "IconsistencyTest.ds1i.PartitionB" );
        mpB.deleteElements( );
        save( );

        // create pair of elements
        A17 a17 = createA17( );

        mpA.assignElement( a17 );

        // assign component to partition B
        mpB.assignElement( a17.getToEnd( ).iterator( ).next( ) );

        String mofId = ( (Partitionable) a17.getToEnd( ).iterator( ).next( ) ).refMofId( );

        save( );

        // create duplicate element
        byte[] mpBXmi = this.getPartitionByteArray( mpB );

        ModelPartition mpBCopy = this.createDuplicatePartition( "IconsistencyTest.ds1i.PartitionBCopy", mpBXmi, this._testClient1 );

        // repartition duplicate element
        A17 a17OfBCopy = (A17) getMOINConnection( ).getElement( mpBCopy.getPri( ).createMri( mofId ) );

        try {
            //try to repartition the element to the partition where a duplicate of the element already lives
            mpB.assignElement( a17OfBCopy );
            fail( "Expected exception" );
        } catch ( InconsistentModelException e ) {
            //expected
        }

        //repartitioning to some "harmless" partition
        getPartitionThree( ).assignElement( a17OfBCopy );

        // check if inconsistencies is still there
        this.processNotificationQueue( );
        assertEquals( "Wrong number of inconsistencies", 2, listener.getViolations( ).size( ) );

        a17OfBCopy.refDelete( );

        this.processNotificationQueue( );
        assertEquals( "Wrong number of inconsistencies", 0, listener.getViolations( ).size( ) );

        // cleanup
        mpA.delete( );
        mpB.delete( );
        mpBCopy.delete( );
        save( );
    }

    /**
     * Tests if the choice of the used element is stable.
     * 
     * @throws PartitionsNotSavedException
     * @throws ReferencedTransientElementsException
     * @throws NullPartitionNotEmptyException
     */
    @Test
    public void testUsedElementChoice( ) throws NullPartitionNotEmptyException, ReferencedTransientElementsException, PartitionsNotSavedException {

        MyConsistencyListener listener = createInconsistencyListener( this.getMOINConnection( ) );

        // create setup using first connection
        ModelPartition mpA = this.recreatePartition( "UsedElementChoicePartitionA" );

        ModelPartition mpB = this.recreatePartition( "UsedElementChoicePartitionB" );

        A1 a1 = this.createA1( );

        B1 b1 = this.createB1( );

        mpA.assignElement( a1 );
        mpB.assignElement( b1 );

        a1.getBs( ).add( b1 );

        save( );

        byte[] mpBXmi = this.getPartitionByteArray( mpB );

        ModelPartition mpBCopy = this.createNewPartitionFromByteArray( "UsedElementChoicePartitionBCopy", mpBXmi, this._testClient1 );

        this.processNotificationQueue( );
        verify( !listener.getEvents( ).isEmpty( ), "No inconsistencies found." );

        // eviction via save
        // add some stuff and save
        A1 anotherA = createA1( );
        B1 anotherB = createB1( );
        mpB.assignElement( anotherA );
        mpBCopy.assignElement( anotherB );

        save( );

        // ** test setup created

        Connection connection = this.getMOINConnection( );

        A1 moreA1 = createA1( connection );
        A1 moreA2 = createA1( connection );

        ModelPartition freshPartitionBCopy = connection.getPartition( mpBCopy.getPri( ) );
        // modify partition to get it in to an own workspace
        freshPartitionBCopy.assignElement( moreA1 );

        ModelPartition freshPartitionB = connection.getPartition( mpB.getPri( ) );
        freshPartitionB.assignElement( moreA2 );

        A1 a = (A1) connection.getElement( a1.get___Mri( ) );

        B1 foundB = a.getBs( ).iterator( ).next( );

        verify( foundB.get___Mri( ).getPri( ).equals( mpB.getPri( ) ), "Unexpected element returned" );

        // modify one partition and save - should cause an eviction
        connection.save( );

        //B1 foundB_x = a.getBs( ).iterator( ).next( );

        mpB.delete( );

        B1 foundB_2 = a.getBs( ).iterator( ).next( );

        verify( foundB_2.get___Mri( ).getPri( ).equals( mpBCopy.getPri( ) ), "Unexpected element returned" );

        save( );

        B1 foundB_3 = a.getBs( ).iterator( ).next( );

        verify( foundB_3.get___Mri( ).getPri( ).equals( mpBCopy.getPri( ) ), "Unexpected element returned" );

        // cleanup
        mpBCopy.delete( );
        mpA.delete( );

        save( );
    }

    @Test
    public void testCheckForPartitionInconsistencies( ) throws Exception {

        // create scenario
        MyConsistencyListener listener = createInconsistencyListener( this.getMOINConnection( ) );

        ModelPartition mpA = recreatePartition( "IconsistencyTest.PartitionCheckA" );

        ModelPartition mpB = recreatePartition( "IconsistencyTest.PartitionCheckB" );

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

        mpA = this.createNewPartitionFromByteArray( "IconsistencyTest.PartitionCheckA", mpAXmi, this._testClient1 );

        // create duplicates
        ModelPartition mpC = this.createNewPartitionFromByteArray( "IconsistencyTest.PartitionCheckC", mpAXmi, this._testClient1 );

        c2 = (C2) this.getMOINConnection( ).getElement( lriOfC );
        // trigger inconsistency event
        c2.getB( );

        this.processNotificationQueue( );
        verify( listener.getViolations( ).size( ) > 0, "No Inconsistencies found." );

        // check partition for inconsistencies
        CoreConnection coreConnection = MoinTestCase.getTestHelper( ).getCoreConnection( this.getMOINConnection( ) );
        ConsistencyViolationRegistry registry = coreConnection.getConsistencyViolationRegistry( );

        verify( registry.isPartitionInconsistent( mpA.getPri( ), DanglingLinkConsistencyViolation.class ), "Inconsistency not found for partition." );

        mpB = this.createNewPartitionFromByteArray( "IconsistencyTest.PartitionCheckB", mpBXmi, this._testClient1 );

        saveConnectionOne( );

        this.processNotificationQueue( );
        verify( listener.getViolations( ).size( ) > 0, "No Inconsistencies found." );

        verify( !registry.isPartitionInconsistent( mpA.getPri( ), DanglingLinkConsistencyViolation.class ), "Still dangling links found." );
        verify( registry.isPartitionInconsistent( mpA.getPri( ), DuplicateElementConsistencyViolation.class ), "Duplicate element violations not found for partition." );

        mpA.delete( );
        mpB.delete( );
        mpC.delete( );
        saveConnectionOne( );
    }
}
