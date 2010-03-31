package com.sap.tc.moin.repository.test.inconsistency;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sap.tc.moin.MoinPackage;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.NullPartitionNotEmptyException;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.PartitionsNotSavedException;
import com.sap.tc.moin.repository.ReferencedTransientElementsException;
import com.sap.tc.moin.repository.consistency.ConsistencyListener;
import com.sap.tc.moin.repository.consistency.ConsistencyViolationListenerRegistry;
import com.sap.tc.moin.repository.core.ConsistencyViolationRegistryWrapperImpl;
import com.sap.tc.moin.repository.core.consistency.impl.ConsistencyViolationRegistryImpl;
import com.sap.tc.moin.testcases.TestcasesPackage;
import com.sap.tc.moin.testcases.case017.A17;

/**
 * <h1>Consistency correction with standard means</h1>
 * <p>
 * These test check the correction of inconsistencies using the standard API.
 * </p>
 * 
 * @author d026715
 */
public class TestInconsistencyListeners extends TestInconsistencyBase {

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

    private void clearAllListeners( ) {

        ConsistencyViolationRegistryImpl registry = (ConsistencyViolationRegistryImpl) ( (ConsistencyViolationRegistryWrapperImpl) this.getMOINConnection( ).getConsistencyViolationListenerRegistry( ) ).unwrap( );

        for ( ConsistencyListener listener : registry.getAllConsistencyListeners( ) ) {
            registry.removeListener( listener );
        }
    }

    /**
     * Tests if default listener is called correctly.
     * 
     * @throws NullPartitionNotEmptyException
     * @throws ReferencedTransientElementsException
     * @throws PartitionsNotSavedException
     */
    @Test
    public void testDefaultListener( ) throws NullPartitionNotEmptyException, ReferencedTransientElementsException, PartitionsNotSavedException {

        this.clearAllListeners( );
        ConsistencyViolationListenerRegistry consistencyViolationRegistry = this.getMOINConnection( ).getConsistencyViolationListenerRegistry( );
        Connection connection = getMOINConnection( );
        MyConsistencyListener defaultListener = new MyConsistencyListener( getTestHelper( ).getCoreConnection( connection ).getConsistencyViolationRegistry( ) );
        MyConsistencyListener additionalListener = new MyConsistencyListener( getTestHelper( ).getCoreConnection( connection ).getConsistencyViolationRegistry( ) );
        consistencyViolationRegistry.setDefaultListener( defaultListener );

        this.testDoubleStorageDanglingLinkElementDelete( defaultListener, additionalListener );
    }

    /**
     * Tests if additional listeners are called correctly.
     * 
     * @throws NullPartitionNotEmptyException
     * @throws ReferencedTransientElementsException
     * @throws PartitionsNotSavedException
     */
    @Test
    public void testAdditionalListeners( ) throws NullPartitionNotEmptyException, ReferencedTransientElementsException, PartitionsNotSavedException {

        this.clearAllListeners( );
        ConsistencyViolationListenerRegistry consistencyViolationRegistry = this.getMOINConnection( ).getConsistencyViolationListenerRegistry( );
        Connection connection = getMOINConnection( );
        MyConsistencyListener defaultListener = new MyConsistencyListener( getTestHelper( ).getCoreConnection( connection ).getConsistencyViolationRegistry( ) );
        MyConsistencyListener additionalListener = new MyConsistencyListener( getTestHelper( ).getCoreConnection( connection ).getConsistencyViolationRegistry( ) );
        consistencyViolationRegistry.setDefaultListener( null );
        consistencyViolationRegistry.addListener( additionalListener );

        this.testDoubleStorageDanglingLinkElementDelete( additionalListener, defaultListener );
    }

    /**
     * Test for inconsistency listeners.
     * 
     * @throws PartitionsNotSavedException
     * @throws ReferencedTransientElementsException
     * @throws NullPartitionNotEmptyException
     */
    public void testDoubleStorageDanglingLinkElementDelete( MyConsistencyListener usedListener, MyConsistencyListener unusedListener ) throws NullPartitionNotEmptyException, ReferencedTransientElementsException, PartitionsNotSavedException {

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

        verify( usedListener.getRegistry( ).getAllConsistencyViolations( ).size( ) > 0, "Registry incorrect" );
        verify( usedListener.getViolations( ).size( ) > 0, "Listener not notified." );
        verify( unusedListener.getViolations( ).isEmpty( ), "Unused listener was notified." );

        // cleanup
        mpA.delete( );
        mpA2.delete( );
        mpA3.delete( );

        saveConnectionOne( );
    }

}
