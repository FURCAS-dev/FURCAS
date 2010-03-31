/**
 * 
 */
package com.sap.tc.moin.repository.test.core;

import java.util.ArrayList;
import java.util.List;

import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sap.serviceinteractions.EndPointReference;
import com.sap.serviceinteractions.Message;
import com.sap.serviceinteractions.MessageTriggersReply;
import com.sap.serviceinteractions.ServiceInteractionsPackage;
import com.sap.tc.moin.facility.primary.ipi.IpiPrimaryFacility;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.Facility;
import com.sap.tc.moin.repository.InvalidModelPartitionException;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.NullPartitionNotEmptyException;
import com.sap.tc.moin.repository.PartitionDeletingNotPossibleException;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.test.fw.TestMetaModels;

/**
 * This test does nothing more than using the standard partitions from the
 * testframework to create a little M1 model of ServiceInteractions MM, saves it
 * and loads it again verifying that the elements and links are still there.
 * 
 * @author d046074
 */
public class TestSimpleModelAndPartitionHandling extends CoreMoinTest {

    private ServiceInteractionsPackage sip;

    private List<String> elementMrisPartition1 = new ArrayList( );

    private List<String> elementMrisPartition2 = new ArrayList( );

    private String partitionOneElement;

    private String partitionTwoElement;

    /**
     * initializes the test; i.e. imports the metal model, selects the
     * ServiceInteractions package and creates messages and an association
     */
    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );
        // try to get ServiceInteractions package
        sip = (ServiceInteractionsPackage) ( (RefPackage) getMOINConnection( ).getPackage( TestMetaModels.SERVICE_INTERACTIONS_CN, TestMetaModels.SERVICE_INTERACTIONS_TPE ) );
        if ( sip == null ) {
            throw new RuntimeException( "ServiceInteractions package is null" );
        }
    }

    @Test
    public void testCreateModelAndFindModelElements( ) throws Exception {

        // create multiple messages
        Message message1 = getMOINConnection( ).createElementInPartition( Message.class, null );

        Message message2 = getMOINConnection( ).createElementInPartition( Message.class, null );

        Message message3 = getMOINConnection( ).createElementInPartition( Message.class, null );

        Message message4 = getMOINConnection( ).createElementInPartition( Message.class, null );

        // create association
        MessageTriggersReply messageTriggersReply = sip.getMessageTriggersReply( );
        // add triggers for message1
        messageTriggersReply.getTriggers( message1 ).add( message2 );
        messageTriggersReply.getTriggers( message1 ).add( message3 );
        messageTriggersReply.getTriggers( message1 ).add( message4 );
        // create multiple endpointreferences
        EndPointReference epr1 = getMOINConnection( ).createElementInPartition( EndPointReference.class, null );
        EndPointReference epr2 = getMOINConnection( ).createElementInPartition( EndPointReference.class, null );
        EndPointReference epr3 = getMOINConnection( ).createElementInPartition( EndPointReference.class, null );
        // add endpointreferences for message1
        message1.getSendRepliesTo( ).add( epr1 );
        message1.getSendRepliesTo( ).add( epr2 );
        message1.getSendRepliesTo( ).add( epr3 );

        // assign partition
        ( (Partitionable) message1 ).assign___Partition( getPartitionOne( ) );
        elementMrisPartition1.add( ( (Partitionable) message1 ).get___Mri( ).toString( ) );
        partitionOneElement = ( (Partitionable) message1 ).get___Mri( ).toString( );

        ( (Partitionable) message2 ).assign___Partition( getPartitionOne( ) );
        elementMrisPartition1.add( ( (Partitionable) message2 ).get___Mri( ).toString( ) );

        ( (Partitionable) message3 ).assign___Partition( getPartitionTwo( ) );
        elementMrisPartition2.add( ( (Partitionable) message3 ).get___Mri( ).toString( ) );
        partitionTwoElement = ( (Partitionable) message3 ).get___Mri( ).toString( );

        ( (Partitionable) message4 ).assign___Partition( getPartitionTwo( ) );
        elementMrisPartition2.add( ( (Partitionable) message4 ).get___Mri( ).toString( ) );

        ( (Partitionable) epr1 ).assign___Partition( getPartitionOne( ) );
        elementMrisPartition1.add( ( (Partitionable) epr1 ).get___Mri( ).toString( ) );
        ( (Partitionable) epr2 ).assign___Partition( getPartitionOne( ) );
        elementMrisPartition2.add( ( (Partitionable) epr1 ).get___Mri( ).toString( ) );
        ( (Partitionable) epr3 ).assign___Partition( getPartitionTwo( ) );
        elementMrisPartition2.add( ( (Partitionable) epr1 ).get___Mri( ).toString( ) );

        getMOINConnection( ).save( );

        Facility nwdiFacility = getTestHelper( ).getFacility( IpiPrimaryFacility.FACILITY_ID );
        MRI partitionOneElementMri = nwdiFacility.getRIFactory( ).createMri( partitionOneElement );

        ModelPartition p1 = ( (Partitionable) getMOINConnection( ).getElement( partitionOneElementMri ) ).get___Partition( );

        assertTrue( "No elements found in Partition 1", elementMrisPartition1.size( ) != 0 );

        for ( Partitionable element : p1.getElements( ) ) {
            String elementMri = element.get___Mri( ).toString( );
            if ( elementMrisPartition1.contains( elementMri ) ) {
                elementMrisPartition1.remove( elementMri );
            }
        }

        assertTrue( "Expected no MRI to be found in list", elementMrisPartition1.size( ) == 0 );

        MRI partitionTwoElementMri = nwdiFacility.getRIFactory( ).createMri( partitionTwoElement );
        ModelPartition p2 = ( (Partitionable) getMOINConnection( ).getElement( partitionTwoElementMri ) ).get___Partition( );

        assertTrue( "No elements found in Partition 2", elementMrisPartition2.size( ) != 0 );

        for ( Partitionable element : p2.getElements( ) ) {
            String elementMri = element.get___Mri( ).toString( );
            if ( elementMrisPartition2.contains( elementMri ) ) {
                elementMrisPartition2.remove( elementMri );
            }
        }
        assertTrue( "Expected no MRI to be found in list", elementMrisPartition1.size( ) == 0 );

        p1.delete( );
        p2.delete( );
        getMOINConnection( ).save( );
    }

    @Test
    public void testTransientPartitionSupport( ) throws Exception {

        // create custom transient partition
        Connection connection = this.getMOINConnection( );
        ModelPartition tp1Null = this.getMOINConnection( ).getNullPartition( );
        ModelPartition tp2 = connection.getOrCreateTransientPartition( "transientA" );

        ModelPartition tp3 = connection.getOrCreateTransientPartition( "transientB" );

        // currently a HACK in order to get wrappers for the transient
        // partitions (as they cannot be created via client
        // API at the moment)
        tp2 = this.getMOINConnection( ).getPartition( tp2.getPri( ) );
        tp3 = this.getMOINConnection( ).getPartition( tp3.getPri( ) );

        // Create element in NullPartition (transient partition 1)
        Message message1 = getMOINConnection( ).createElementInPartition( Message.class, null );

        // Create element in transient partition 2
        Message message2 = getMOINConnection( ).createElementInPartition( Message.class, null );
        tp2.assignElement( (Partitionable) message2 );

        // Create element in transient partition 3
        Message message3 = getMOINConnection( ).createElementInPartition( Message.class, null );
        tp3.assignElement( (Partitionable) message3 );

        assertEquals( tp1Null, ( (Partitionable) message1 ).get___Partition( ) );
        assertEquals( tp2, ( (Partitionable) message2 ).get___Partition( ) );
        assertEquals( tp3, ( (Partitionable) message3 ).get___Partition( ) );

        try {
            connection.save( );
            fail( "NullPartitionNotEmptyException expected to be thrown" );
        } catch ( NullPartitionNotEmptyException e ) {
            // expected exception, continue
        }

        // Assign all element to transient partition 2
        tp3.assignElement( (Partitionable) message1 );
        tp3.assignElement( (Partitionable) message2 );
        tp3.assignElement( (Partitionable) message3 );

        assertEquals( tp3, ( (Partitionable) message1 ).get___Partition( ) );
        assertEquals( tp3, ( (Partitionable) message2 ).get___Partition( ) );
        assertEquals( tp3, ( (Partitionable) message3 ).get___Partition( ) );

        getMOINConnection( ).save( );

        // Try to delete NullPartition
        try {
            tp1Null.delete( );
            fail( "Deletion of NullPartition must not succeed" );
        } catch ( PartitionDeletingNotPossibleException e ) {
            // expected exception, continue
        }

        // Try assigning an element to a deleted partition
        tp2.delete( );
        // Recreate message2
        message2 = getMOINConnection( ).createElementInPartition( Message.class, null );

        try {
            tp2.assignElement( getTestHelper( ).getCorePartitionable( (Partitionable) message2 ) );
            fail( "Transient Partition has been delete and can not be used to assign elements to" );
        } catch ( InvalidModelPartitionException e ) {
            // expected exception, continue
        }

        // Try to create a transient partition which has existed but was
        // deleted.
        getMOINConnection( ).getOrCreateTransientPartition( "transientA" );
        ModelPartition wrappedTp3 = (ModelPartition) ( getTestHelper( ).getCoreSession( connection.getSession( ) ).getWorkspaceSet( ).getWrapperManager( ).wrapObject( getTestHelper( ).getCoreConnection( connection ), tp3 ) );
        wrappedTp3.assignElement( message2 );
        assertEquals( wrappedTp3, ( (Partitionable) message2 ).get___Partition( ) );

    }

    @Override
    @After
    public void afterTestMethod( ) throws Exception {

        this.sip = null;
        super.afterTestMethod( );
    }

}
