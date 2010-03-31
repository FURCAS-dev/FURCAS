package com.sap.tc.moin.repository.test.inconsistency;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefFeatured;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sap.junit.Staged;
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
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.PartitionOperation;
import com.sap.tc.moin.repository.consistency.ConsistencyCorrectionHandle;
import com.sap.tc.moin.repository.consistency.ConsistencyViolation;
import com.sap.tc.moin.repository.consistency.DanglingLinkConsistencyViolation;
import com.sap.tc.moin.repository.consistency.DuplicateElementConsistencyViolation;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.core.consistency.impl.ElementDeleteCorrectionImpl;
import com.sap.tc.moin.repository.core.consistency.impl.LinkDeleteCorrectionImpl;
import com.sap.tc.moin.repository.exception.ExecutionCancelledException;
import com.sap.tc.moin.repository.exception.ExecutionRollbackFailedException;
import com.sap.tc.moin.repository.exception.UnrecoverableExecutionException;
import com.sap.tc.moin.repository.mmi.reflect.RefClassCalculatedMofId;
import com.sap.tc.moin.repository.transactions.Transactionable;
import com.sap.tc.moin.test.fw.TestClient;
import com.sap.tc.moin.test.testcase.MoinTestCase;
import com.sap.tc.moin.testcases.TestcasesPackage;
import com.sap.tc.moin.testcases.case002.AreferencesB;
import com.sap.tc.moin.testcases.case002.B2;
import com.sap.tc.moin.testcases.case002.C2;
import com.sap.tc.moin.testcases.case017.A17;
import com.sap.tc.moin.testcases.case017.Case017Package;

/**
 * <h1>Consistency correction tests with undo</h1>
 * <p>
 * These tests apply the consistency correction handles with undo/redo.
 * <p>
 * 
 * @author d026715
 */
public class TestInconsistencyCorrectionWithUndo extends TestInconsistencyBase {

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
     * @throws Exception
     */
    @Staged
    @Test
    public void testDeletionTwoDuplicateElement( ) throws Exception {


        String mpAPri = null;
        String mpBPri = null;
        String mpACopyPri = null;
        String mpBCopyPri = null;
        String a17Mri = null;
        String a17_2Mri = null;
        {
            // Create inconsistencies in the persistence, followed by a MOIN reset, to simulate real-world conditions
            // regarding on-load inconsistencies like DuplicateElement. This is done in separate code block to prevent 
            // accidental re-use of wrappers, PRIs, MRIs etc.

            // clear PartitionA
            ModelPartition mpA = this._testClient1.getOrCreatePartitionStable( "IconsistencyTest.ds1i.PartitionA" );
            mpA.delete( );

            // clear PartitionB
            ModelPartition mpB = this._testClient1.getOrCreatePartitionStable( "IconsistencyTest.ds1i.PartitionB" );
            mpB.delete( );
            saveConnectionOne( );

            mpA = this._testClient1.getOrCreatePartitionStable( "IconsistencyTest.ds1i.PartitionA" );
            mpAPri = mpA.getPri( ).toString( );
            mpB = this._testClient1.getOrCreatePartitionStable( "IconsistencyTest.ds1i.PartitionB" );
            mpBPri = mpB.getPri( ).toString( );

            // change single-valued attributes
            Case017Package case017Package = testcasesPackage.getCase017( );

            RefClass a17class = case017Package.getA17( );
            A17 a17 = (A17) ( (RefClassCalculatedMofId) a17class ).refCreateInstanceInPartition( mpA, null, new String[] { "A" } );
            a17Mri = ( (Partitionable) a17 ).get___Mri( ).toString( );
            A17 a17_2 = (A17) ( (RefClassCalculatedMofId) a17class ).refCreateInstanceInPartition( mpB, null, new String[] { "B" } );
            a17_2Mri = ( (Partitionable) a17_2 ).get___Mri( ).toString( );
            a17.getToEnd( ).add( a17_2 );
            a17_2.setFromEnd( a17 );

            saveConnectionOne( );

            // create inconsistencies
            byte[] mpBXmi = this.getPartitionByteArray( mpB );
            byte[] mpAXmi = this.getPartitionByteArray( mpA );

            TestClient client = this._testClient1;
            ModelPartition mpBCopy = this.createDuplicatePartition( "IconsistencyTest.ds2i.PartitionBCopy", mpBXmi, client );
            mpBCopyPri = mpBCopy.getPri( ).toString( );
            ModelPartition mpACopy = this.createDuplicatePartition( "IconsistencyTest.ds2i.PartitionACopy", mpAXmi, client );
            mpACopyPri = mpACopy.getPri( ).toString( );

            getTestHelper( ).reset( );
        }
        Collection<ConsistencyViolation> allConsistencyViolations = getTestHelper( ).getCoreConnection( getMOINConnection( ) ).getSession( ).getConsistencyViolationRegistry( ).getAllConsistencyViolations( );
        assertEquals( 0, allConsistencyViolations.size( ) );

        final MyConsistencyListener listener = createInconsistencyListener( this.getMOINConnection( ) );

        ModelPartition mpA = getMOINConnection( ).getPartition( getTestHelper( ).getMoin( ).createPri( mpAPri ) );
        makeDirty( mpA );
        ModelPartition mpB = getMOINConnection( ).getPartition( getTestHelper( ).getMoin( ).createPri( mpBPri ) );
        makeDirty( mpB );
        ModelPartition mpACopy = getMOINConnection( ).getPartition( getTestHelper( ).getMoin( ).createPri( mpACopyPri ) );
        makeDirty( mpACopy );
        ModelPartition mpBCopy = getMOINConnection( ).getPartition( getTestHelper( ).getMoin( ).createPri( mpBCopyPri ) );
        makeDirty( mpBCopy );

        allConsistencyViolations = getTestHelper( ).getCoreConnection( getMOINConnection( ) ).getSession( ).getConsistencyViolationRegistry( ).getAllConsistencyViolations( );
        assertEquals( 4, allConsistencyViolations.size( ) );

        final A17 a17 = (A17) getMOINConnection( ).getElement( getTestHelper( ).getMoin( ).createMri( a17Mri ) );
        final A17 a17_2 = (A17) getMOINConnection( ).getElement( getTestHelper( ).getMoin( ).createMri( a17_2Mri ) );
        final A17 a17_2copy = (A17) mpBCopy.getElements( ).iterator( ).next( );
        final A17 a17copy = (A17) mpACopy.getElements( ).iterator( ).next( );

        final RefFeatured ic_a17 = a17.refImmediateComposite( );
        final RefFeatured ic_a17_2 = a17_2.refImmediateComposite( );
        final RefFeatured ic_a17copy = a17copy.refImmediateComposite( );
        final RefFeatured ic_a17_2copy = a17_2copy.refImmediateComposite( );

        // it can not be made sure that the used element is coming form mpA. If the builder runs, it might come from another partition
        assertNull( ic_a17 );
        //verify( mpA.getPri( ).equals( ( (Partitionable) ic_a17_2 ).get___Mri( ).getPri( ) ), "Should be " + mpA.getPri( ) + " but was " + ( (Partitionable) ic_a17_2 ).get___Mri( ).getPri( ) );
        //assertEquals( mpA.getPri( ), ( (Partitionable) ic_a17_2 ).get___Mri( ).getPri( ) );
        assertNull( ic_a17copy );
        //assertEquals( mpA.getPri( ), ( (Partitionable) ic_a17_2copy ).get___Mri( ).getPri( ) );

        final PRI usedElementsPri = ( (Partitionable) a17.getToEnd( ).iterator( ).next( ) ).get___Mri( ).getPri( );

        final List<ConsistencyCorrectionHandle> corrections = new ArrayList<ConsistencyCorrectionHandle>( );

        this.processNotificationQueue( );

        allConsistencyViolations = getTestHelper( ).getCoreConnection( getMOINConnection( ) ).getSession( ).getConsistencyViolationRegistry( ).getAllConsistencyViolations( );
        assertEquals( 4, allConsistencyViolations.size( ) );

        final int expectedNumberOfViolations = 4;
        assertEquals( expectedNumberOfViolations, listener.getViolations( ).size( ) );

        // get inconsistency violations for partition A
        for ( ConsistencyViolation violation : listener.getViolations( ) ) {
            if ( ( (DuplicateElementConsistencyViolation) violation ).getMri( ).getPri( ).equals( mpA.getPri( ) ) || ( (DuplicateElementConsistencyViolation) violation ).getMri( ).getPri( ).equals( mpB.getPri( ) ) ) {
                // TODO a little bit unstable - assumes that the first correction handle is the element deletion
                ConsistencyCorrectionHandle correctionHandle = violation.getCorrectionHandles( this.getMOINConnection( ) )[0];
                assert correctionHandle instanceof ElementDeleteCorrectionImpl;
                corrections.add( correctionHandle );
            }
        }

        Transactionable transactionable = new Transactionable( ) {

            public void runInTransaction( ) throws UnrecoverableExecutionException, ExecutionRollbackFailedException, ExecutionCancelledException, JmiException, NullPointerException {

                Connection connection = getMOINConnection( );
                for ( int i = corrections.size( ) - 1; i >= 0; i-- ) {
                    ConsistencyCorrectionHandle correction = corrections.get( i );
                    connection.getConsistencyViolationListenerRegistry( ).applyCorrection( correction.getId( ) );
                }
            }

            public CoreConnection getConnection( ) {

                return getTestHelper( ).getCoreConnection( getMOINConnection( ) );
            }
        };

        final ModelPartition finalMpB = mpB;
        final ModelPartition finalMpBCopy = mpBCopy;
        final ModelPartition finalMpACopy = mpACopy;

        runDoUndoRedoTest( getMOINConnection( ), transactionable, new EmptyAsserter( ) {

            @Override
            public void assertAfterDo( ) {

                // second partition must not be empty

                if ( finalMpB.getPri( ).equals( usedElementsPri ) ) {
                    assertFalse( "Partition is empty", finalMpBCopy.getElements( ).isEmpty( ) );

                } else {
                    assertFalse( "Partition is empty", finalMpB.getElements( ).isEmpty( ) );
                }

                // there must be no inconsistency left
                TestInconsistencyCorrectionWithUndo.this.processNotificationQueue( );
                String message = "Inconsistencies left: ";
                for ( ConsistencyViolation violation : listener.getViolations( ) ) {
                    message += violation.getClass( ).getName( ) + ",";
                }
                assertEquals( message, 0, listener.getViolations( ).size( ) );

                // partition ACopy must still contain links
                CoreModelPartition cmpACopy = MoinTestCase.getTestHelper( ).getCoreModelPartition( finalMpACopy );
                assertFalse( "Partition ACopy contains no links", cmpACopy.getLinks( ).isEmpty( ) );
            }

            @Override
            public void assertAfterUndo( ) {

                TestInconsistencyCorrectionWithUndo.this.processNotificationQueue( );
                assertEquals( "Wrong number of inconsistencies.", 4 /* expectedNumberOfViolations */, listener.getViolations( ).size( ) );

                final RefFeatured undo_ic_a17 = a17.refImmediateComposite( );
                final RefFeatured undo_ic_a17_2 = a17_2.refImmediateComposite( );
                final RefFeatured undo_ic_a17copy = a17copy.refImmediateComposite( );
                final RefFeatured undo_ic_a17_2copy = a17_2copy.refImmediateComposite( );

                assertEquals( "B*", ( (Partitionable) ic_a17_2copy ).get___Mri( ), ( (Partitionable) undo_ic_a17_2copy ).get___Mri( ) );
                assertEquals( "B", ( (Partitionable) ic_a17_2 ).get___Mri( ), ( (Partitionable) undo_ic_a17_2 ).get___Mri( ) );
            }
        } );

        saveConnectionOne( );

        mpB.delete( );
        mpA.delete( );
        mpBCopy.delete( );
        mpACopy.delete( );
        saveConnectionOne( );

    }

    private void makeDirty( ModelPartition partition ) {

        partition.createElement( MofClass.class );
    }

    /**
     * Correction of a duplicate element inconsistency by deleting the
     * duplicates.
     * 
     * @throws Exception
     */
    @Test
    public void testDeleteDuplicateElementWithUndo( ) throws Exception {

        final MyConsistencyListener listener = createInconsistencyListener( this.getMOINConnection( ) );

        // clear PartitionA
        ModelPartition mpA = this._testClient1.getOrCreatePartitionStable( "IconsistencyTest.ds1i.PartitionA" );
        mpA.delete( );

        mpA = this._testClient1.getOrCreatePartitionStable( "IconsistencyTest.ds1i.PartitionA" );

        // change single-valued attributes
        A17 a17 = createSingleA17( );

        mpA.assignElement( a17 );

        saveConnectionOne( );

        // create inconsistencies        
        byte[] mpAXmi = this.getPartitionByteArray( mpA );

        TestClient client = this._testClient1;

        ensurePartitionLoadedInCCSW( mpA );
        ModelPartition mpACopy = this.createDuplicatePartition( "IconsistencyTest.ds2i.PartitionACopy", mpAXmi, client );

        final MRI usedElementsMri = ( (Partitionable) a17 ).get___Mri( );

        this.processNotificationQueue( );

        Transactionable transactionable = new Transactionable( ) {

            public void runInTransaction( ) throws UnrecoverableExecutionException, ExecutionRollbackFailedException, ExecutionCancelledException, JmiException, NullPointerException {

                Connection connection = getMOINConnection( );
                RefObject element = (RefObject) connection.getElement( usedElementsMri );
                element.refDelete( );
            }

            public CoreConnection getConnection( ) {

                return getTestHelper( ).getCoreConnection( getMOINConnection( ) );
            }
        };

        runDoUndoRedoTest( getMOINConnection( ), transactionable, new EmptyAsserter( ) {

            @Override
            public void assertAfterDo( ) {

                // there must be no inconsistency left
                TestInconsistencyCorrectionWithUndo.this.processNotificationQueue( );
                verify( listener.getViolations( ).isEmpty( ), "Inconsistencies left." );
            }

            @Override
            public void assertAfterUndo( ) {

                Partitionable element = getMOINConnection( ).getElement( usedElementsMri.getLri( ) );
                verify( usedElementsMri.equals( element.get___Mri( ) ), "Wrong used duplicate element after undo." );

                TestInconsistencyCorrectionWithUndo.this.processNotificationQueue( );
                verify( !listener.getViolations( ).isEmpty( ), "No inconsistencies found." );
            }
        } );

        saveConnectionOne( );

        // cleanup

        mpA.delete( );
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
    public void testDanglingLinkLinkDeleteWithCommand( ) throws NullPartitionNotEmptyException, ReferencedTransientElementsException, PartitionsNotSavedException {

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

        mpA.delete( );
        mpB.delete( );
        saveConnectionOne( );

        mpA = this.createNewPartitionFromByteArray( "IconsistencyTest.dsdl.PartitionA", mpAXmi, this._testClient1 );

        a17 = (A17) this.getMOINConnection( ).getElement( mriA17 );

        Collection list = a17.getToEnd( );

        for ( Object object : list ) {
            A17 component = (A17) object;
        }

        ConsistencyCorrectionHandle correction = null;

        this.processNotificationQueue( );
        List<ConsistencyViolation> violations = listener.getViolations( );
        for ( ConsistencyViolation consistencyViolation : violations ) {
            if ( consistencyViolation instanceof DanglingLinkConsistencyViolation ) {
                ConsistencyCorrectionHandle[] correctionHandles = consistencyViolation.getCorrectionHandles( this.getMOINConnection( ) );
                for ( ConsistencyCorrectionHandle consistencyCorrectionHandle : correctionHandles ) {
                    if ( consistencyCorrectionHandle instanceof LinkDeleteCorrectionImpl ) {
                        correction = consistencyCorrectionHandle;
                        break;
                    }
                }
            }
        }

        final ConsistencyCorrectionHandle finalCorr = correction;

        final PRI affectedPRI = mpA.getPri( );

        // do the correction in a command
        Command command = new Command( this.getMOINConnection( ) ) {

            @Override
            public Collection<PartitionOperation> getAffectedPartitions( ) {

                ArrayList<PartitionOperation> arrayList = new ArrayList<PartitionOperation>( );
                arrayList.add( new PartitionOperation( PartitionOperation.Operation.EDIT, affectedPRI ) );

                return arrayList;
            }

            @Override
            public void doExecute( ) {

                this.getConnection( ).getConsistencyViolationListenerRegistry( ).applyCorrection( finalCorr.getId( ) );

            }

            @Override
            public boolean canExecute( ) {

                return true;
            }

        };

        command.execute( );

        this.processNotificationQueue( );
        verify( listener.getViolations( ).isEmpty( ), "Inconsistencies left." );

        this.getMOINConnection( ).getCommandStack( ).undo( );

        list = a17.getToEnd( );

        for ( Object object : list ) {
            A17 component = (A17) object;
        }

        this.processNotificationQueue( );
        verify( !listener.getViolations( ).isEmpty( ), "No inconsistencies found." );

        // cleanup
        mpA.delete( );

        saveConnectionOne( );
    }

    /**
     * Correction of a dangling link inconsistency by removing the link.
     * 
     * @throws Exception
     */
    @Test
    @Staged
    public void testDanglingLinkDuplicateElementInconsistencyLinkDelete( ) throws Exception {

        final MyConsistencyListener listener = createInconsistencyListener( this.getMOINConnection( ) );

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

        final LRI lriOfC = ( (Partitionable) c2 ).get___Mri( ).getLri( );

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

        final Connection firstConnection = this.getMOINConnection( );

        c2 = (C2) firstConnection.getElement( lriOfC );
        // trigger inconsistency event
        c2.getB( );

        TestInconsistencyCorrectionWithUndo.this.processNotificationQueue( );
        verify( listener.getViolations( ).size( ) > 0, "No Inconsistencies found." );

        DanglingLinkConsistencyViolation violation = null;
        for ( ConsistencyViolation viol : listener.getViolations( ) ) {
            if ( viol instanceof DanglingLinkConsistencyViolation ) {
                violation = (DanglingLinkConsistencyViolation) viol;
                break;
            }
        }
        assertNotNull( violation );

        final ConsistencyCorrectionHandle consistencyCorrectionHandle = violation.getCorrectionHandles( firstConnection )[0];

        Transactionable transactionable = new Transactionable( ) {

            public void runInTransaction( ) throws UnrecoverableExecutionException, ExecutionRollbackFailedException, ExecutionCancelledException, JmiException, NullPointerException {

                TestInconsistencyCorrectionWithUndo.this.processNotificationQueue( );
                // remove link
                if ( listener.getViolations( ).size( ) > 0 ) {

                    firstConnection.getConsistencyViolationListenerRegistry( ).applyCorrection( consistencyCorrectionHandle.getId( ) );
                }
            }

            public CoreConnection getConnection( ) {

                return getTestHelper( ).getCoreConnection( getMOINConnection( ) );
            }
        };

        runDoUndoRedoTest( firstConnection, transactionable, new EmptyAsserter( ) {

            @Override
            public void assertAfterDo( ) {

                TestInconsistencyCorrectionWithUndo.this.processNotificationQueue( );
                verify( listener.getViolations( ).size( ) == 0, "Inconsistencies left." );
            }

            @Override
            public void assertAfterUndo( ) {

                C2 c2 = (C2) firstConnection.getElement( lriOfC );
                // trigger inconsistency event
                c2.getB( );
                TestInconsistencyCorrectionWithUndo.this.processNotificationQueue( );
                verify( !listener.getViolations( ).isEmpty( ), "No inconsistencies found." );
            }
        } );

        firstConnection.save( );

        mpACopy.delete( );
        saveConnectionOne( );
    }
}
