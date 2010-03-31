package com.sap.tc.moin.repository.test.inconsistency;

import com.sap.tc.moin.repository.mmi.model.MofClass;

import org.junit.Test;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.Session;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.consistency.ConsistencyViolationRegistry;


public class TestInconsistencyBasicStuff extends TestInconsistencyBase {


    @Test
    public void testConsistencyCheckOnNonExistingPartitionsAndElements( ) throws Exception {

        Connection connection = getMOINConnection( );
        CoreConnection coreConnection = getTestHelper( ).getCoreConnection( connection );
        Session session = connection.getSession( );
        ConsistencyViolationRegistry registry = getTestHelper( ).getCoreSession( session ).getConsistencyViolationRegistry( );

        ModelPartition deletedPartition = _testClient1.getOrCreatePartition( "DeletedPartition" );
        MofClass deletedElement = deletedPartition.createElement( MofClass.class );
        PRI deletedPartitionPri = deletedPartition.getPri( );
        MRI deletedElementMri = ( (Partitionable) deletedElement ).get___Mri( );
        LRI deletedElementLri = deletedElementMri.getLri( );
        deletedPartition.delete( );
        assertNull( "Expected partition to be deleted", connection.getPartition( deletedPartitionPri ) );
        assertNull( "Expected element to be deleted", connection.getElement( deletedElementMri ) );
        assertNull( "Expected element to be deleted", connection.getElement( deletedElementLri ) );

        //all methods must work without throwing Exceptions, they have to be no-ops
        registry.checkDanglingLinksOfPartition( deletedPartitionPri );
        registry.checkRegisteredDuplicateElement( deletedElementMri );
        registry.checkRegisteredDuplicateElement( deletedElementLri );
        registry.performConsistencyCheck( deletedPartitionPri, coreConnection );
        registry.performDcDependencyCheck( deletedPartitionPri, coreConnection );
        registry.isPartitionInconsistent( deletedPartitionPri );
    }

    @Test
    public void testConsistencyCheckWithIllegalParameters( ) throws Exception {

        Connection connection = getMOINConnection( );
        CoreConnection coreConnection = getTestHelper( ).getCoreConnection( connection );
        Session session = connection.getSession( );
        ConsistencyViolationRegistry registry = getTestHelper( ).getCoreSession( session ).getConsistencyViolationRegistry( );

        //all methods must work without throwing Exceptions, they have to be no-ops
        registry.checkDanglingLinksOfPartition( null );
        registry.checkRegisteredDuplicateElement( (LRI) null );
        registry.checkRegisteredDuplicateElement( (MRI) null );
        registry.checkRegisteredDuplicateElement( coreConnection, null, false );
        registry.checkRegisteredDuplicateElement( coreConnection, null, true );
        registry.performConsistencyCheck( null, coreConnection );
        registry.performDcDependencyCheck( null, coreConnection );
        registry.isPartitionInconsistent( null );


        registry.setDefaultListener( null );
        registry.getConsistencyViolation( null );
        registry.applyCorrection( null, coreConnection );
        registry.removeListener( null );
        registry.addListener( null );

    }

}
