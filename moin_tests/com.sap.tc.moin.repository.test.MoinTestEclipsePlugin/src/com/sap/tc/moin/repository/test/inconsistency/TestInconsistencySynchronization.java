package com.sap.tc.moin.repository.test.inconsistency;

import org.junit.Before;
import org.junit.Test;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.consistency.ConsistencyListener;
import com.sap.tc.moin.repository.consistency.ConsistencyViolation;
import com.sap.tc.moin.repository.consistency.ConsistencyViolationListenerRegistry;
import com.sap.tc.moin.test.fw.TestClient;
import com.sap.tc.moin.test.fw.TestMetaModels;
import com.sap.tc.moin.testcases.TestcasesPackage;
import com.sap.tc.moin.testcases.case017.A17;

/**
 * <h1>Consistency handling with read/write locking and potential "evil"
 * listeners</h1>
 * 
 * @author d026715, d044711
 */
public class TestInconsistencySynchronization extends TestInconsistencyBase {

    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );
        testcasesPackage = (TestcasesPackage) getMOINConnection( ).getPackage( TestMetaModels.TESTCASES_CN, TestMetaModels.TESTCASES_TPE );

    }

    @Test( timeout = 30000 )
    public void testNoDeadlockWithEvilInconsistencyListener( ) throws Exception {

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

        Partitionable firstElementAtToEnd = (Partitionable) a17.getToEnd( ).iterator( ).next( );
        mpB.assignElement( firstElementAtToEnd );

        saveConnectionOne( );

        byte[] mpBXmi = this.getPartitionByteArray( mpB );

        TestClient client = this._testClient1;

        ModelPartition mpBCopy = this.createDuplicatePartition( "IconsistencyTest.ds1i.PartitionBCopy", mpBXmi, client );

        ConsistencyViolationListenerRegistry consistencyViolationRegistry = getSecondMOINConnection( ).getConsistencyViolationListenerRegistry( );
        ConsistencyListener evilWritingListener = new EvilConsistencyListener( getSecondMOINConnection( ) );
        consistencyViolationRegistry.addListener( evilWritingListener );

        // do something which requires a read lock
        getSecondMOINConnection( ).getElement( firstElementAtToEnd.get___Mri( ).getLri( ) );

    }

    private static final class EvilConsistencyListener implements ConsistencyListener {

        Connection connection;

        public EvilConsistencyListener( Connection connection ) {

            this.connection = connection;
        }

        public void onConsistencyResolution( ConsistencyViolation[] consistencyViolation, Connection connection ) {

        }

        public void onConsistencyViolation( ConsistencyViolation[] consistencyViolation, Connection connection ) {

            A17 element = (A17) this.connection.getElement( consistencyViolation[0].getAffectedElement( ) );
            // do something which requires a write lock -> evil as this is a
            // lock upgrade -> deadlock!!!
            element.setFromEnd( null );
        }

    }

}
