package com.sap.tc.moin.repository.test.transactions.microtransactionables;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.reflect.CompositionViolationException;
import com.sap.tc.moin.repository.mmi.reflect.DuplicateException;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;

import org.junit.Test;

import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CorePartitionable;
import com.sap.tc.moin.repository.core.events.AttributeValueChangeEventImpl;
import com.sap.tc.moin.repository.core.events.ElementCreateEventImpl;
import com.sap.tc.moin.repository.events.filter.CompositionHierarchyFilter;
import com.sap.tc.moin.repository.events.filter.EventFilter;
import com.sap.tc.moin.repository.events.type.ChangeEvent;
import com.sap.tc.moin.repository.exception.ExecutionCancelledException;
import com.sap.tc.moin.repository.exception.ExecutionRollbackFailedException;
import com.sap.tc.moin.repository.exception.UnrecoverableExecutionException;
import com.sap.tc.moin.repository.spi.core.Wrapper;
import com.sap.tc.moin.repository.transactions.Transactionable;
import com.sap.tc.moin.testcases.case004.A4;
import com.sap.tc.moin.testcases.case004.B4;
import com.sap.tc.moin.testcases.case004.C4;
import com.sap.tc.moin.testcases.case004.F4;
import com.sap.tc.moin.testcases.case004.__impl.B4Impl;
import com.sap.tc.moin.testcases.case017.A17;
import com.sap.tc.moin.testcases.case017.Case017Package;
import com.sap.tc.moin.testcases.case017.Composition;

@SuppressWarnings( "nls" )
public class TestMicroTransactionablesComposedTransactions extends BaseMicroTransactionablesTest {

    @Test
    public void testComponentChild( ) throws Exception {

        Transactionable transactionable = new Transactionable( ) {

            public void runInTransaction( ) throws UnrecoverableExecutionException, ExecutionRollbackFailedException, ExecutionCancelledException, JmiException, NullPointerException {

                // create an element, assign it to a partition and then
                // associate a component element to it
                Case017Package case017Package = testcasesPackage.getCase017( );
                A17 composite = (A17) case017Package.getA17( ).refCreateInstance( );
                getPartitionOne( ).assignElement( composite );
                A17 component = (A17) case017Package.getA17( ).refCreateInstance( );
                Composition composition = case017Package.getComposition( );
                composition.add( composite, component );
            }

            public CoreConnection getConnection( ) {

                return coreConnection;
            }
        };
        runDoUndoRedoTest( getMOINConnection( ), transactionable, new EmptyAsserter( ) {

            @Override
            public void assertAfterDo( ) {

            }

            @Override
            public void assertAfterUndo( ) {

            }
        } );
    }

    @Test
    public void testUndoEventsForCompositionHierarchyFilter( ) throws Exception {

        // check undo events for an element deletion when a composition
        // hierarchy filter was set for parent events
        // create an element with a composite child
        final B4 b4 = getMOINConnection( ).createElementInPartition( B4.class, null );
        final C4 c4 = getMOINConnection( ).createElementInPartition( C4.class, null );
        c4.setPrimitive( "primitive" );
        c4.setComplex( b4 );
        Transactionable transactionable = new Transactionable( ) {

            public void runInTransaction( ) throws UnrecoverableExecutionException, ExecutionRollbackFailedException, ExecutionCancelledException, JmiException, NullPointerException {

                // remove the composite child
                b4.refDelete( );
            }

            public CoreConnection getConnection( ) {

                return coreConnection;
            }
        };
        DoUndoRedoTestAsserter asserter = new EmptyAsserter( ) {

            @Override
            public void assertExpectedPreEventsAfterUndo( List<? extends ChangeEvent> receivedEvents ) {

                B4Impl b4Unwrapped = (B4Impl) ( (Wrapper) b4 ).unwrap( );
                MRI instanceDeletedMri = ( (CorePartitionable) b4Unwrapped ).get___Mri( );
                MRI instanceDeletedMetaObjectMri = ( (CorePartitionable) b4Unwrapped.refMetaObject( ) ).get___Mri( );
                MRI instanceDeletedImmediatePackageMri = ( (CorePartitionable) b4Unwrapped.refImmediatePackage( ) ).get___Mri( );
                List<ChangeEvent> expectedEvents = new ArrayList<ChangeEvent>( 2 );
                expectedEvents.add( new ElementCreateEventImpl( coreConnection, instanceDeletedMri, instanceDeletedMetaObjectMri, instanceDeletedImmediatePackageMri ) );
                expectedEvents.add( new AttributeValueChangeEventImpl( coreConnection, c4, (Attribute) getFeatureByName( (MofClass) c4.refMetaObject( ), "complex" ), null, ( (Partitionable) b4 ).get___Mri( ).getLri( ) ) );
                checkEvents( expectedEvents, receivedEvents );
            }

            @Override
            public EventFilter getEventFilter( ) {

                return new CompositionHierarchyFilter( c4 );
            }

            @Override
            public void assertAfterDo( ) {

            }

            @Override
            public void assertAfterUndo( ) {

            }
        };
        runDoUndoRedoTest( getMOINConnection( ), transactionable, asserter );
    }

    @Test
    public void testUndo1( ) throws Exception {

        // do several complex operations and check whether everything is as it
        // was before
        initRepositoryForComplexTransactionable1( );
        Transactionable transactionable = new ComplexTransactionable1( );
        DoUndoRedoTestAsserter asserter = new ComplexTransactionable1Asserter( );
        runDoUndoRedoTest( getMOINConnection( ), transactionable, asserter );
    }

    @Test
    public void testRollbackViaPreConstraintViolation( ) throws Exception {

        // add an element to a multiple unique attribute, which is already in it
        initRepositoryForComplexTransactionable1( );
        Transactionable transactionable = new ComplexTransactionable1( ) {

            @Override
            public void runInTransaction( ) throws UnrecoverableExecutionException, ExecutionRollbackFailedException, ExecutionCancelledException, JmiException, NullPointerException {

                super.runInTransaction( );
                A4 a4_1 = getMOINConnection( ).createElementInPartition( A4.class, null );
                B4 b4_1 = getMOINConnection( ).createElementInPartition( B4.class, null );
                a4_1.getManyBsUnique( ).add( b4_1 );
                // this is not allowed because the attribute is unique
                a4_1.getManyBsUnique( ).add( b4_1 );
            }
        };
        DoUndoRedoTestAsserter asserter = new ComplexTransactionable1Asserter( );
        synchronized ( clientSpecificWorkspace.getWorkspaceSet( ).getSynchronizationManager( ).getProhibitWriteSyncObject( ) ) {
            try {
                runDoUndoRedoTest( getMOINConnection( ), transactionable, asserter );
                errorAndStop( "Tried to add an element that is already present in a unique attribute, should have thrown a DuplicateException" );
            } catch ( DuplicateException duplicateEx ) {
                // duplicate
            }
        }
    }

    @Test
    public void testRollbackViaPostConstraintViolation( ) throws Exception {

        // change to a value that is already set as attribute of another parent
        // instance
        initRepositoryForComplexTransactionable1( );
        Transactionable transactionable = new ComplexTransactionable1( ) {

            @Override
            public void runInTransaction( ) throws UnrecoverableExecutionException, ExecutionRollbackFailedException, ExecutionCancelledException, JmiException, NullPointerException {

                super.runInTransaction( );
                A4 a4_1 = getMOINConnection( ).createElementInPartition( A4.class, null );
                B4 b4_1 = getMOINConnection( ).createElementInPartition( B4.class, null );
                a4_1.setOneBchangeable( b4_1 );
                A4 a4_2 = getMOINConnection( ).createElementInPartition( A4.class, null );
                // this is not allowed because the value is already set as an
                // attribute of another instance
                a4_2.setOneBchangeable( b4_1 );
            }
        };
        DoUndoRedoTestAsserter asserter = new ComplexTransactionable1Asserter( );
        synchronized ( clientSpecificWorkspace.getWorkspaceSet( ).getSynchronizationManager( ).getProhibitWriteSyncObject( ) ) {
            try {
                runDoUndoRedoTest( getMOINConnection( ), transactionable, asserter );
                errorAndStop( "Tried to set a second parent to an attribute, should have thrown a CompositionViolationException" );
            } catch ( CompositionViolationException compositionViolationEx ) {
                // composition violation
            }
        }
    }

    @Test
    public void testRollbackViaRaisingExceptions( ) throws Exception {

        // throw an exception in between two MOIN API calls inside of a
        // transaction
        initRepositoryForComplexTransactionable1( );
        Transactionable transactionable = new ComplexTransactionable1( ) {

            @Override
            public void runInTransaction( ) throws UnrecoverableExecutionException, ExecutionRollbackFailedException, ExecutionCancelledException, JmiException, NullPointerException {

                super.runInTransaction( );
                A4 a4_1 = getMOINConnection( ).createElementInPartition( A4.class, null );
                B4 b4_1 = getMOINConnection( ).createElementInPartition( B4.class, null );
                a4_1.setOneBchangeable( b4_1 );
                getMOINConnection( ).createElementInPartition( A4.class, null );
                // throw an exception that causes a rollback
                throw new RuntimeException( );
            }
        };
        DoUndoRedoTestAsserter asserter = new ComplexTransactionable1Asserter( );
        synchronized ( clientSpecificWorkspace.getWorkspaceSet( ).getSynchronizationManager( ).getProhibitWriteSyncObject( ) ) {
            try {
                runDoUndoRedoTest( getMOINConnection( ), transactionable, asserter );
                errorAndStop( "should have thrown a RuntimeException" );
            } catch ( RuntimeException runtimeEx ) {
                // runtime exception
            }
        }
    }

    private void initRepositoryForComplexTransactionable1( ) throws Exception {

        nullPartition.deleteElements( );
        getPartitionOne( ).deleteElements( );
        getPartitionTwo( ).deleteElements( );
        F4 f4_1 = (F4) f4Class.refCreateInstance( );
        getPartitionTwo( ).assignElement( f4_1 );
        getMOINConnection( ).save( );
    }

    private class ComplexTransactionable1 implements Transactionable {

        public void runInTransaction( ) throws UnrecoverableExecutionException, ExecutionRollbackFailedException, ExecutionCancelledException, JmiException, NullPointerException {

            // delete elements
            F4 f4_1 = (F4) getPartitionTwo( ).getElements( ).iterator( ).next( );
            f4_1.refDelete( );
            // create elements and assign them to partitions, some remain in the
            // null partition
            getMOINConnection( ).createElementInPartition( A4.class, null );
            A4 a4_2 = getMOINConnection( ).createElementInPartition( A4.class, null );
            getPartitionOne( ).assignElement( a4_2 );
            B4 b4_1 = getMOINConnection( ).createElementInPartition( B4.class, null );
            getPartitionOne( ).assignElement( b4_1 );
            F4 f4_2 = (F4) f4Class.refCreateInstance( );
            getPartitionTwo( ).assignElement( f4_2 );
            F4 f4_3 = (F4) f4Class.refCreateInstance( );
            getPartitionTwo( ).assignElement( f4_3 );
            F4 f4_4 = (F4) f4Class.refCreateInstance( );
            B4 b4_2 = getMOINConnection( ).createElementInPartition( B4.class, null );
            B4 b4_3 = getMOINConnection( ).createElementInPartition( B4.class, null );
            B4 b4_4 = getMOINConnection( ).createElementInPartition( B4.class, null );
            // connect the elements together
            case004Package.getComposesB( ).add( b4_1, f4_2 );
            case004Package.getComposesB( ).add( b4_4, f4_4 );
            a4_2.getManyBsUnique( ).addAll( Arrays.asList( b4_2, b4_3 ) );
        }

        public CoreConnection getConnection( ) {

            return coreConnection;
        }
    }

    private class ComplexTransactionable1Asserter extends EmptyAsserter {

        @Override
        public void assertBeforeDo( ) {

            assertTrue( "Null partition should be empty, but has " + nullPartition.getElements( ).size( ) + " elements in it", 0 == nullPartition.getElements( ).size( ) );
            assertTrue( "Partition One should be empty, but has " + getPartitionOne( ).getElements( ).size( ) + " elements in it", 0 == getPartitionOne( ).getElements( ).size( ) );
            assertTrue( "Partition Two should have 1 element, but has " + getPartitionTwo( ).getElements( ).size( ) + " elements in it", 1 == getPartitionTwo( ).getElements( ).size( ) );
            assertNotLocked( lockManager, getPartitionOne( ).getPri( ) );
            assertNotLocked( lockManager, getPartitionTwo( ).getPri( ) );
            assertNotDirty( getPartitionOne( ) );
            assertNotDirty( getPartitionTwo( ) );
        }

        @Override
        public void assertAfterDo( ) {

            assertTrue( "Null partition should have 3 element, but has " + nullPartition.getElements( ).size( ), 3 == nullPartition.getElements( ).size( ) );
            assertTrue( "Partition One should have 4 elements, but has " + getPartitionOne( ).getElements( ).size( ), 4 == getPartitionOne( ).getElements( ).size( ) );
            assertTrue( "Partition Two should have 2 elements, but has " + getPartitionTwo( ).getElements( ).size( ), 2 == getPartitionTwo( ).getElements( ).size( ) );
            assertLocked( lockManager, getPartitionOne( ).getPri( ), getMOINConnection( ) );
            assertLocked( lockManager, getPartitionTwo( ).getPri( ), getMOINConnection( ) );
            assertDirty( getPartitionOne( ) );
            assertDirty( getPartitionTwo( ) );
        }

        @Override
        public void assertAfterUndo( ) {

            assertTrue( "Null partition should be empty, but has " + nullPartition.getElements( ).size( ) + " elements in it", 0 == nullPartition.getElements( ).size( ) );
            assertTrue( "Partition One should be empty, but has " + getPartitionOne( ).getElements( ).size( ) + " elements in it", 0 == getPartitionOne( ).getElements( ).size( ) );
            assertTrue( "Partition Two should have 1 element, but has " + getPartitionTwo( ).getElements( ).size( ) + " elements in it", 1 == getPartitionTwo( ).getElements( ).size( ) );
            assertNotLocked( lockManager, getPartitionOne( ).getPri( ) );
            assertNotLocked( lockManager, getPartitionTwo( ).getPri( ) );
            assertNotDirty( getPartitionOne( ) );
            assertNotDirty( getPartitionTwo( ) );
        }
    }
}
