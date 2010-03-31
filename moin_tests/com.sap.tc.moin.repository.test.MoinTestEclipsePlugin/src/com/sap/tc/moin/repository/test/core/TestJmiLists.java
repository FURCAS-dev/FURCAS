/**
 * 
 */
package com.sap.tc.moin.repository.test.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.DependsOn;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.ModelPackage;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.Namespace;
import com.sap.tc.moin.repository.mmi.model.Tag;
import com.sap.tc.moin.repository.mmi.reflect.InvalidObjectException;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sap.serviceinteractions.EndPointReference;
import com.sap.serviceinteractions.Message;
import com.sap.serviceinteractions.MessageTriggersReply;
import com.sap.serviceinteractions.ServiceInteractionsPackage;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.NullPartitionNotEmptyException;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.PartitionsNotSavedException;
import com.sap.tc.moin.repository.mmi.descriptors.StructureFieldContainer;
import com.sap.tc.moin.test.fw.TestClient;
import com.sap.tc.moin.test.fw.TestMetaModels;
import com.sap.tc.moin.testcases.TestcasesPackage;
import com.sap.tc.moin.testcases.case004.A4;
import com.sap.tc.moin.testcases.case004.B4;
import com.sap.tc.moin.testcases.case008.A8;
import com.sap.tc.moin.testcases.case008.E8;
import com.sap.tc.moin.testcases.case008.E8Enum;
import com.sap.tc.moin.testcases.case008.S8;
import com.sap.tc.moin.testcases.case008.T8;

/**
 * tests the implementation of the JmiList, MultiValuedAttributesList and the
 * JmiListForDistributedEndStorage using the testcases, ServiceInteractions
 * package as well as UML.
 * 
 * @author d045397
 */
public class TestJmiLists extends CoreMoinTest {

    private ServiceInteractionsPackage sip;

    private Message message1;

    private Message message2;

    private Message message3;

    private Message message4;

    private Message message5;

    private EndPointReference epr1;

    private EndPointReference epr2;

    private EndPointReference epr3;

    private EndPointReference epr4;

    private MessageTriggersReply messageTriggersReply;

    /**
     * The testcases package
     */
    private TestcasesPackage tp;

    private ModelPartition partition;

    /**
     * initializes the test; i.e. imports the metal model, selects the
     * ServiceInteractions package and creates messages and an association
     */
    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );
        // make sure you get a new clean partition
        partition = getPartitionOne( );
        if ( !partition.getElements( ).isEmpty( ) ) {
            partition.deleteElements( );
            getMOINConnection( ).save( );
        }

        // try to get ServiceInteractions package
        sip = (ServiceInteractionsPackage) getMOINConnection( ).getPackage( TestMetaModels.SERVICE_INTERACTIONS_CN, TestMetaModels.SERVICE_INTERACTIONS_TPE );
        if ( sip == null ) {
            throw new RuntimeException( "ServiceInteractions package is null" );
        }
        // create multiple messages
        message1 = getMOINConnection( ).createElementInPartition( Message.class, null );
        message2 = getMOINConnection( ).createElementInPartition( Message.class, null );
        message3 = getMOINConnection( ).createElementInPartition( Message.class, null );
        message4 = getMOINConnection( ).createElementInPartition( Message.class, null );
        // create association
        messageTriggersReply = sip.getMessageTriggersReply( );
        // add triggers for message1
        messageTriggersReply.getTriggers( message1 ).add( message2 );
        messageTriggersReply.getTriggers( message1 ).add( message3 );
        messageTriggersReply.getTriggers( message1 ).add( message4 );
        // create multiple endpointreferences
        epr1 = getMOINConnection( ).createElementInPartition( EndPointReference.class, null );
        epr2 = getMOINConnection( ).createElementInPartition( EndPointReference.class, null );
        epr3 = getMOINConnection( ).createElementInPartition( EndPointReference.class, null );
        // add endpointreferences for message1
        message1.getSendRepliesTo( ).add( epr1 );
        message1.getSendRepliesTo( ).add( epr2 );
        message1.getSendRepliesTo( ).add( epr3 );

        tp = (TestcasesPackage) getMOINConnection( ).getPackage( TestMetaModels.TESTCASES_CN, TestMetaModels.TESTCASES_TPE );
    }

    @Test
    public void testJmiListAfterRepartitioning( ) throws Exception {

        MofPackage parent = getMOINConnection( ).getNullPartition( ).createElement( MofPackage.class );
        MofPackage child = getMOINConnection( ).getNullPartition( ).createElement( MofPackage.class );
        List<ModelElement> children = parent.getContents( );
        children.add( child );
        assertTrue( "Expected child in contents of parent p", children.contains( child ) );
        assertTrue( "Expected parent to be container of child", child.getContainer( ).equals( parent ) );
        assertFalse( "Expected package to be assigned to other partition", ( (Partitionable) parent ).get___Partition( ).equals( partition ) );

        partition.assignElement( parent );
        assertTrue( "Expected package to be assigned to other partition", ( (Partitionable) parent ).get___Partition( ).equals( partition ) );

        MofPackage child2 = getMOINConnection( ).getNullPartition( ).createElement( MofPackage.class );
        child2.setName( "c2" );
        children.add( child2 );
        assertTrue( "Expected child2 in contents of package p", children.contains( child2 ) );
        assertTrue( "Expected parent to be container of child2", child2.getContainer( ).equals( parent ) );
        assertTrue( "Expected child in contents of package p", children.contains( child ) );
        assertTrue( "Expected parent to be container of child", child.getContainer( ).equals( parent ) );

        getMOINConnection( ).revert( );

        try {
            children.add( child );
            fail( "Expected exception to be thrown" );
        } catch ( InvalidObjectException e ) {
            // expected
        }

        MofClass dummyClass = getMOINConnection( ).getNullPartition( ).createElement( MofClass.class );
        Collection<MofClass> dummyCollection = new ArrayList<MofClass>( );
        dummyCollection.add( dummyClass );
        try {
            children.add( dummyClass );
            fail( "Expected exception to be thrown" );
        } catch ( InvalidObjectException e ) {
            // expected
        }

        try {
            children.addAll( dummyCollection );
            fail( "Expected exception to be thrown" );
        } catch ( InvalidObjectException e ) {
            // expected
        }

        try {
            children.clear( );
            fail( "Expected exception to be thrown" );
        } catch ( InvalidObjectException e ) {
            // expected
        }

        try {
            children.contains( dummyClass );
            fail( "Expected exception to be thrown" );
        } catch ( InvalidObjectException e ) {
            // expected
        }

        try {
            children.containsAll( dummyCollection );
            fail( "Expected exception to be thrown" );
        } catch ( InvalidObjectException e ) {
            // expected
        }

        try {
            children.isEmpty( );
            fail( "Expected exception to be thrown" );
        } catch ( InvalidObjectException e ) {
            // expected
        }

        try {
            children.iterator( );
            fail( "Expected exception to be thrown" );
        } catch ( InvalidObjectException e ) {
            // expected
        }

        try {
            children.remove( dummyClass );
            fail( "Expected exception to be thrown" );
        } catch ( InvalidObjectException e ) {
            // expected
        }

        try {
            children.removeAll( dummyCollection );
            fail( "Expected exception to be thrown" );
        } catch ( InvalidObjectException e ) {
            // expected
        }

        try {
            children.retainAll( dummyCollection );
            fail( "Expected exception to be thrown" );
        } catch ( InvalidObjectException e ) {
            // expected
        }

        try {
            children.size( );
            fail( "Expected exception to be thrown" );
        } catch ( InvalidObjectException e ) {
            // expected
        }

        try {
            children.toArray( );
            fail( "Expected exception to be thrown" );
        } catch ( InvalidObjectException e ) {
            // expected
        }

        try {
            children.toArray( new Object[] {} );
            fail( "Expected exception to be thrown" );
        } catch ( InvalidObjectException e ) {
            // expected
        }
    }

    @Test
    public void testUpdateOfJmiList( ) throws Exception {

        Connection connection = this.getMOINConnection( );

        // assign messages and endpointreferences to partition
        ( (Partitionable) message1 ).assign___Partition( partition );
        ( (Partitionable) message2 ).assign___Partition( partition );
        ( (Partitionable) message3 ).assign___Partition( partition );
        ( (Partitionable) message4 ).assign___Partition( partition );

        // make sure the null partition is empty
        connection.getNullPartition( ).deleteElements( );

        // save partition
        connection.save( );

        Collection<Message> distributedTriggers = this.messageTriggersReply.getTriggers( message1 );
        int expectedSize = 3; // must already contain message2, message3,
        // message4
        assertSame( expectedSize, distributedTriggers.size( ) );

        // start the other thread which adds an element to the triggers and
        // saves
        SecondClient secondClientThread = new SecondClient( this._testClient2, ( (Partitionable) message1 ).get___Mri( ) );
        secondClientThread.start( );
        secondClientThread.join( );

        // now (as the other thread has finished) there must be an additional
        // element
        expectedSize++;
        assertSame( expectedSize, distributedTriggers.size( ) );
    }

    private class SecondClient extends Thread {

        private MRI fromElementMri = null;

        private TestClient testClient = null;

        public SecondClient( TestClient client, MRI fromElement ) {

            this.fromElementMri = fromElement;
            this.testClient = client;
        }

        @Override
        public void run( ) {

            Connection connection = testClient.getConnection( );
            ModelPartition partition = connection.getPartition( getPartitionTwo( ).getPri( ) );
            if ( partition == null ) {
                partition = connection.createPartition( getPartitionTwo( ).getPri( ) );
            }
            Message fromElement = (Message) connection.getElement( fromElementMri );
            ServiceInteractionsPackage sip = (ServiceInteractionsPackage) connection.getPackage( TestMetaModels.SERVICE_INTERACTIONS_CN, TestMetaModels.SERVICE_INTERACTIONS_TPE );
            MessageTriggersReply triggersReply = sip.getMessageTriggersReply( );
            Collection<Message> distributedTriggers = triggersReply.getTriggers( fromElement );
            Message newMessage = connection.createElementInPartition( Message.class, null );
            partition.assignElement( newMessage );
            distributedTriggers.add( newMessage );

            try {
                connection.save( );
            } catch ( PartitionsNotSavedException e ) {
                throw new RuntimeException( e );
            }
        }
    }

    /**
     * tests operations on collection of endpointreferences (uses JmiList)
     */
    @Test
    public void testJmiList( ) {

        message1.getSendRepliesTo( ).clear( );
        assertTrue( "Expected send_replies_to of message message1 to be empty", message1.getSendRepliesTo( ).isEmpty( ) );

        // create a "reference" collection which contains the expected elements
        Collection<EndPointReference> expectedObjectsForMessage = new ArrayList<EndPointReference>( 9 );

        // add expected objects
        EndPointReference reference9 = null;
        for ( int i = 0; i < 9; i++ ) {
            EndPointReference reference = getMOINConnection( ).createElementInPartition( EndPointReference.class, null );
            expectedObjectsForMessage.add( reference );
            if ( i == 8 ) {
                reference9 = reference;
            }
        }

        // fill the "real" collection
        Collection<EndPointReference> sendRepliesTo = message1.getSendRepliesTo( );
        sendRepliesTo.addAll( expectedObjectsForMessage );

        // check whether all links are contained
        assertSame( "Expected other number of messages to be contained in triggers of message1", expectedObjectsForMessage.size( ), message1.getSendRepliesTo( ).size( ) );

        assertTrue( expectedObjectsForMessage.containsAll( message1.getSendRepliesTo( ) ) );
        assertTrue( message1.getSendRepliesTo( ).containsAll( expectedObjectsForMessage ) );

        // remove epr3
        message1.getSendRepliesTo( ).remove( reference9 );
        assertTrue( "Expected endpointreference9 not to be contained in send_replies_to of message1", !message1.getSendRepliesTo( ).contains( reference9 ) );

        // remove from the comparison list
        expectedObjectsForMessage.remove( reference9 );
        assertTrue( expectedObjectsForMessage.containsAll( message1.getSendRepliesTo( ) ) );
        assertTrue( message1.getSendRepliesTo( ).containsAll( expectedObjectsForMessage ) );

        // use clear() method for removing all triggers
        message1.getSendRepliesTo( ).clear( );
        assertTrue( "Expected send_replies_to of message message1 to be empty", message1.getSendRepliesTo( ).isEmpty( ) );
        // add triggers again
        message1.getSendRepliesTo( ).addAll( expectedObjectsForMessage );
        assertTrue( expectedObjectsForMessage.containsAll( message1.getSendRepliesTo( ) ) );
        assertTrue( message1.getSendRepliesTo( ).containsAll( expectedObjectsForMessage ) );

        // use removeAll() method for removing all triggers
        message1.getSendRepliesTo( ).removeAll( expectedObjectsForMessage );
        assertTrue( "Expected send_replies_to of message message1 to be empty", message1.getSendRepliesTo( ).isEmpty( ) );
    }

    /**
     * tests operations on collection of endpointreferences using an iterator
     * (uses JmiList)
     */
    @Test
    public void testJmiListWithIterator( ) {

        // check that elements contained in iterator are as much as obtained by
        // the getSendRepliesTo() method
        int count = 0;
        for ( Iterator<EndPointReference> it = message1.getSendRepliesTo( ).iterator( ); it.hasNext( ); it.next( ) ) {
            count++;
        }
        verify( message1.getSendRepliesTo( ).size( ) == count, "Expected iterator to contain the same amount of links as the reference it is derived from" );

        // create fourth endpointreference for testing the exception
        epr4 = getMOINConnection( ).createElementInPartition( EndPointReference.class, null );
        // check that proper exception is thrown when manipulating the
        // collection within
        // the use of the iterator
        try {
            for ( Iterator<EndPointReference> it = message1.getSendRepliesTo( ).iterator( ); it.hasNext( ); ) {
                message1.getSendRepliesTo( ).add( epr4 );
                it.next( );
                errorAndContinue( "Should have thrown ConcurrentModificationException" );
                break;
            }
        } catch ( ConcurrentModificationException cme ) {
        }
        verify( message1.getSendRepliesTo( ).contains( epr4 ), "Expected endpointreference4 to be contained in send_replies_to of message1" );

        // delete epr3
        for ( Iterator<EndPointReference> it = message1.getSendRepliesTo( ).iterator( ); it.hasNext( ); ) {
            EndPointReference endPointReference = it.next( );
            if ( endPointReference.equals( epr3 ) ) {
                it.remove( );
            }
        }

        // check that endpointreference3 is no longer contained in
        // send_replies_to collection
        verify( !message1.getSendRepliesTo( ).contains( epr3 ), "Expected endpointreference3 not to be contained in send_replies_to of message1" );

        // check that proper exception is thrown when using remove() without
        // having called next() before
        // (the next() in the header of the for loop is first called after the
        // first pass)
        try {
            for ( Iterator<EndPointReference> it = message1.getSendRepliesTo( ).iterator( ); it.hasNext( ); ) {
                it.remove( );
                errorAndContinue( "Should have trown IllegalStateException" );
            }
        } catch ( IllegalStateException ise ) {
        }
    }

    /**
     * tests links between messages and endpointreferences which have been saved
     * and loaded again
     * 
     * @throws PartitionsNotSavedException
     */
    @Test
    public void testSaveAndLoadAgainLinks( ) throws NullPartitionNotEmptyException, PartitionsNotSavedException {

        // assign messages and endpointreferences to partition
        ( (Partitionable) message1 ).assign___Partition( partition );
        ( (Partitionable) message2 ).assign___Partition( partition );
        ( (Partitionable) message3 ).assign___Partition( partition );
        ( (Partitionable) message4 ).assign___Partition( partition );
        ( (Partitionable) epr1 ).assign___Partition( partition );
        ( (Partitionable) epr2 ).assign___Partition( partition );
        ( (Partitionable) epr3 ).assign___Partition( partition );

        Connection connection = getMOINConnection( );

        // save partition
        connection.save( );
        // get partition again
        ModelPartition partitionLoaded = connection.getPartition( partition.getPri( ) );

        // load the message that equals message1
        Collection<Partitionable> modelElements = partitionLoaded.getElements( );
        Message messageLoaded = null;
        for ( Object modelElement : modelElements ) {
            if ( modelElement instanceof Message ) {
                messageLoaded = (Message) modelElement;
                if ( messageLoaded.equals( message1 ) ) {
                    break;
                }
            }
        }

        // make sure that all former triggers are still contained after saving
        // and loading
        verify( messageTriggersReply.getTriggers( messageLoaded ).contains( message2 ) && messageTriggersReply.getTriggers( messageLoaded ).contains( message3 ) && messageTriggersReply.getTriggers( messageLoaded ).contains( message4 ),
                "Not all triggers could be found after saving the messages and loading them again" );

        // make sure that all former send_replies_to are still contained after
        // saving and loading
        verify( messageLoaded.getSendRepliesTo( ).contains( epr1 ) && messageLoaded.getSendRepliesTo( ).contains( epr2 ) && messageLoaded.getSendRepliesTo( ).contains( epr3 ), "Not all send_replies_to could be found after saving the message and the endpointreference and loading them again" );

        // add another trigger
        message5 = connection.createElementInPartition( Message.class, null );
        messageTriggersReply.getTriggers( message1 ).add( message5 );
        verify( messageTriggersReply.getTriggers( message1 ).contains( message5 ), "Expected message5 to be contained in triggers of message1" );

        // add another send_reply_to
        epr4 = connection.createElementInPartition( EndPointReference.class, null );
        message1.getSendRepliesTo( ).add( epr4 );
        verify( message1.getSendRepliesTo( ).contains( epr4 ), "Expected endpointreference4 to be contained in send_replies_to of message1" );
    }

    /**
     * tests data typed attributes which have been saved and loaded again
     */
    @Test
    public void testSaveAndLoadAgainDataType( ) throws NullPartitionNotEmptyException, PartitionsNotSavedException {

        Connection connection = getMOINConnection( );
        emptyTransientPartitions( connection );
        StructureFieldContainer<S8> contS8 = new StructureFieldContainer<S8>( );
        StructureFieldContainer<T8> contT8 = new StructureFieldContainer<T8>( );
        // create the elements and assign them to a partition
        A4 a4 = connection.createElementInPartition( A4.class, null );
        a4.getManyPrimitive( ).add( "1" );
        a4.getManyPrimitive( ).add( "3" );
        a4.getManyPrimitive( ).add( "2" );
        a4.getManyPrimitive( ).add( "4" );
        A8 a8 = connection.createElementInPartition( A8.class, null );
        contT8.put( T8.DESCRIPTORS.FIELD1( ), 0 ).put( T8.DESCRIPTORS.FIELD2( ), "0" );
        T8 t8 = tp.getCase008( ).createT8( contT8 );
        a8.getManyEnumerationE( ).add( E8Enum.LABEL2 );
        a8.getManyEnumerationE( ).add( E8Enum.LABEL1 );
        contS8.put( S8.DESCRIPTORS.FIELD1( ), 1 ).put( S8.DESCRIPTORS.FIELD2( ), "1" ).put( S8.DESCRIPTORS.STRUCTURE1( ), t8 );
        a8.getManyStructureS( ).add( tp.getCase008( ).createS8( contS8 ) );
        contS8.put( S8.DESCRIPTORS.FIELD1( ), 3 ).put( S8.DESCRIPTORS.FIELD2( ), "3" ).put( S8.DESCRIPTORS.STRUCTURE1( ), t8 );
        a8.getManyStructureS( ).add( tp.getCase008( ).createS8( contS8 ) );
        contS8.put( S8.DESCRIPTORS.FIELD1( ), 2 ).put( S8.DESCRIPTORS.FIELD2( ), "2" ).put( S8.DESCRIPTORS.STRUCTURE1( ), t8 );
        a8.getManyStructureS( ).add( tp.getCase008( ).createS8( contS8 ) );
        contS8.put( S8.DESCRIPTORS.FIELD1( ), 4 ).put( S8.DESCRIPTORS.FIELD2( ), "4" ).put( S8.DESCRIPTORS.STRUCTURE1( ), t8 );
        a8.getManyStructureS( ).add( tp.getCase008( ).createS8( contS8 ) );
        a4.assign___PartitionIncludingChildren( partition );
        a8.assign___PartitionIncludingChildren( partition );
        // save
        connection.save( );
        // load partition and do the checks
        ModelPartition partitionLoaded = connection.getPartition( partition.getPri( ) );
        Collection<Partitionable> modelElements = partitionLoaded.getElements( );
        A4 a4Loaded = null;
        A8 a8Loaded = null;
        for ( Object modelElement : modelElements ) {
            if ( modelElement instanceof A4 ) {
                a4 = (A4) modelElement;
                continue;
            }
            if ( modelElement instanceof A8 ) {
                a8 = (A8) modelElement;
                continue;
            }
        }
        // get the values after save
        Collection<String> manyPrimitiveAfter = a4.getManyPrimitive( );
        Collection<E8> manyEnumerationAfter = a8.getManyEnumerationE( );
        List<Integer> manyStructureField1After = new ArrayList<Integer>( a8.getManyStructureS( ).size( ) );
        for ( Object structure : a8.getManyStructureS( ) ) {
            manyStructureField1After.add( ( (S8) structure ).getField1( ) );
        }
        // make sure that the order of data typed attributes remained stable
        assertEquals( Arrays.asList( new String[] { "1", "3", "2", "4" } ), manyPrimitiveAfter );
        assertEquals( Arrays.asList( new E8[] { E8Enum.LABEL2, E8Enum.LABEL1 } ), manyEnumerationAfter );
        assertEquals( Arrays.asList( new Integer[] { 1, 3, 2, 4 } ), manyStructureField1After );
    }

    @Test
    public void testSimpleJmiListCase( ) throws Exception {

        MofPackage parent = getMOINConnection( ).getNullPartition( ).createElement( MofPackage.class );
        MofPackage child = getMOINConnection( ).getNullPartition( ).createElement( MofPackage.class );
        parent.getContents( ).add( child );
        MofPackage c2 = getMOINConnection( ).getNullPartition( ).createElement( MofPackage.class );
        c2.setName( "c2" );
        parent.getContents( ).add( c2 );
        assertTrue( "Expected child in contents of parent", parent.getContents( ).contains( child ) );
        assertTrue( "Expected c2 in contents of parent", parent.getContents( ).contains( c2 ) );
        assertTrue( "Expected parent to be container of child", child.getContainer( ).equals( parent ) );
        assertTrue( "Expected parent to be container of c2", c2.getContainer( ).equals( parent ) );
        parent.getContents( ).remove( c2 );
        assertFalse( "Expected c2 to be removed from contents of parent", parent.getContents( ).contains( c2 ) );
        assertTrue( "Expected parent to be removed as container for c2", c2.getContainer( ) == null );
    }

    @Test
    public void testReorderingOfElements( ) throws Exception {

        ModelPackage modelPackage = (ModelPackage) getMOINConnection( ).getPackage( TestMetaModels.MOIN_MOF_CN, TestMetaModels.MOIN_MOF_TPE_MODEL );
        MofClass class1 = (MofClass) modelPackage.getMofClass( ).refCreateInstance( );
        MofClass class2 = (MofClass) modelPackage.getMofClass( ).refCreateInstance( );
        MofClass class3 = (MofClass) modelPackage.getMofClass( ).refCreateInstance( );
        MofClass class4 = (MofClass) modelPackage.getMofClass( ).refCreateInstance( );
        MofPackage mofPackage = (MofPackage) modelPackage.getMofPackage( ).refCreateInstance( );
        getPartitionOne( ).assignElement( mofPackage );

        class1.setContainer( mofPackage );
        class2.setContainer( mofPackage );
        class3.setContainer( mofPackage );
        class4.setContainer( mofPackage );

        List<ModelElement> contents = mofPackage.getContents( );

        ModelElement removedObject = contents.remove( 0 );
        contents.add( 3, removedObject );

        assertEquals( mofPackage, ( (MofClass) contents.get( 0 ) ).getContainer( ) );
        assertEquals( mofPackage, ( (MofClass) contents.get( 1 ) ).getContainer( ) );
        assertEquals( mofPackage, ( (MofClass) contents.get( 2 ) ).getContainer( ) );
        assertEquals( mofPackage, ( (MofClass) contents.get( 3 ) ).getContainer( ) );

    }

    @Test
    public void testSetAssociationToNull( ) throws Exception {

        MofPackage parent = getMOINConnection( ).getNullPartition( ).createElement( MofPackage.class );
        MofPackage child = getMOINConnection( ).getNullPartition( ).createElement( MofPackage.class );
        assertTrue( parent.getContents( ).size( ) == 0 );
        assertTrue( parent.getContents( ).isEmpty( ) );
        parent.getContents( ).add( child );
        Namespace namespaceOfC = child.getContainer( );
        assertEquals( parent, namespaceOfC );
        assertTrue( parent.getContents( ).contains( child ) );
        assertTrue( parent.getContents( ).size( ) == 1 );

        child.setContainer( null );
        namespaceOfC = namespaceOfC.getContainer( );
        assertNull( namespaceOfC );
        assertTrue( parent.getContents( ).isEmpty( ) );
    }

    @Test
    public void testRefDeleteOfAllElementsInList( ) {

        ModelPackage modelPackage = (ModelPackage) getMOINConnection( ).getPackage( TestMetaModels.MOIN_MOF_CN, TestMetaModels.MOIN_MOF_TPE_MODEL );
        MofClass class1 = (MofClass) modelPackage.getMofClass( ).refCreateInstance( );
        MofClass class2 = (MofClass) modelPackage.getMofClass( ).refCreateInstance( );
        MofClass class3 = (MofClass) modelPackage.getMofClass( ).refCreateInstance( );
        MofClass class4 = (MofClass) modelPackage.getMofClass( ).refCreateInstance( );

        MofPackage mofPackage = (MofPackage) modelPackage.getMofPackage( ).refCreateInstance( );
        getPartitionOne( ).assignElement( mofPackage );

        class1.setContainer( mofPackage );
        class2.setContainer( mofPackage );
        class3.setContainer( mofPackage );
        class4.setContainer( mofPackage );

        List<ModelElement> contents = mofPackage.getContents( );

        int size = 4;
        assertSame( size, contents.size( ) );

        Object[] objectsInList = contents.toArray( );
        for ( Object object : objectsInList ) {
            ( (RefObject) object ).refDelete( );
        }

        size = 0;
        assertSame( size, contents.size( ) );

        class1 = (MofClass) modelPackage.getMofClass( ).refCreateInstance( );
        class2 = (MofClass) modelPackage.getMofClass( ).refCreateInstance( );
        class3 = (MofClass) modelPackage.getMofClass( ).refCreateInstance( );
        class4 = (MofClass) modelPackage.getMofClass( ).refCreateInstance( );

        class1.setContainer( mofPackage );
        class2.setContainer( mofPackage );
        class3.setContainer( mofPackage );
        class4.setContainer( mofPackage );

        size = 4;
        assertSame( size, contents.size( ) );

        for ( Iterator<ModelElement> iterator = contents.iterator( ); iterator.hasNext( ); ) {
            RefObject refObject = iterator.next( );
            iterator.remove( ); //this call is essential, because otherwise the following refDelete would modify the underlying collection
            refObject.refDelete( );
        }

        size = 0;
        assertSame( size, contents.size( ) );

        class1 = (MofClass) modelPackage.getMofClass( ).refCreateInstance( );
        class2 = (MofClass) modelPackage.getMofClass( ).refCreateInstance( );
        class3 = (MofClass) modelPackage.getMofClass( ).refCreateInstance( );
        class4 = (MofClass) modelPackage.getMofClass( ).refCreateInstance( );

        class1.setContainer( mofPackage );
        class2.setContainer( mofPackage );
        class3.setContainer( mofPackage );
        class4.setContainer( mofPackage );

        size = 4;
        assertSame( size, contents.size( ) );

        try {
            for ( Object object : contents ) {
                //refDelete() modifies the underlying list, therefore
                //a concurrent modification must be thrown
                ( (RefObject) object ).refDelete( );
            }
            fail( "Expected concurrent modification" );
        } catch ( ConcurrentModificationException e ) {
            //expected
        }

    }

    @Test
    public void testJmiListWrapperAccessAfterElementDeletion( ) {

        Collection<EndPointReference> sendRepliesTo = message1.getSendRepliesTo( );
        message1.refDelete( );
        try {
            sendRepliesTo.add( getMOINConnection( ).createElementInPartition( EndPointReference.class, null ) );
            fail( "Expected InvalidObjectException" );
        } catch ( InvalidObjectException ex ) {
            // expected
        }
    }

    @Test
    public void testRanges( ) throws Exception {

        ModelPackage modelPackage = (ModelPackage) getMOINConnection( ).getPackage( TestMetaModels.MOIN_MOF_CN, TestMetaModels.MOIN_MOF_TPE_MODEL );
        MofClass class1 = (MofClass) modelPackage.getMofClass( ).refCreateInstance( );
        MofClass class2 = (MofClass) modelPackage.getMofClass( ).refCreateInstance( );
        MofClass class3 = (MofClass) modelPackage.getMofClass( ).refCreateInstance( );
        MofClass class4 = (MofClass) modelPackage.getMofClass( ).refCreateInstance( );
        MofClass classToBeAddedLater = (MofClass) modelPackage.getMofClass( ).refCreateInstance( );
        MofClass classToBeSetLater = (MofClass) modelPackage.getMofClass( ).refCreateInstance( );
        MofPackage mofPackage = (MofPackage) modelPackage.getMofPackage( ).refCreateInstance( );
        getPartitionOne( ).assignElement( mofPackage );

        class1.setContainer( mofPackage );
        class2.setContainer( mofPackage );
        class3.setContainer( mofPackage );
        class4.setContainer( mofPackage );

        List<MofClass> addAllMofClasses = new ArrayList<MofClass>( );
        addAllMofClasses.add( (MofClass) modelPackage.getMofClass( ).refCreateInstance( ) );
        addAllMofClasses.add( (MofClass) modelPackage.getMofClass( ).refCreateInstance( ) );

        List<ModelElement> contents = mofPackage.getContents( );

        int size = 4;
        assertSame( size, contents.size( ) );

        try {
            contents.remove( -1 );
            fail( "Expected exception" );
        } catch ( IndexOutOfBoundsException e ) {
            // expected
        }
        try {
            contents.remove( -2 );
            fail( "Expected exception" );
        } catch ( IndexOutOfBoundsException e ) {
            // expected
        }

        try {
            contents.remove( size );
            fail( "Expected exception" );
        } catch ( IndexOutOfBoundsException e ) {
            // expected
        }

        try {
            contents.remove( size + 1 );
            fail( "Expected exception" );
        } catch ( IndexOutOfBoundsException e ) {
            // expected
        }

        try {
            contents.add( -1, null );
            fail( "Expected exception" );
        } catch ( IndexOutOfBoundsException e ) {
            // expected
        }

        try {
            contents.add( -2, null );
            fail( "Expected exception" );
        } catch ( IndexOutOfBoundsException e ) {
            // expected
        }

        // must not work because index > contents.size()
        try {
            contents.add( size + 1, null );
            fail( "Expected exception" );
        } catch ( IndexOutOfBoundsException e ) {
            // expected
        }

        // must work as index == contents.size()
        contents.add( size, classToBeAddedLater );
        size++;
        assertSame( size, contents.size( ) );

        try {
            contents.addAll( -1, null );
            fail( "Expected exception" );
        } catch ( IndexOutOfBoundsException e ) {
            // expected
        }

        try {
            contents.addAll( -2, null );
            fail( "Expected exception" );
        } catch ( IndexOutOfBoundsException e ) {
            // expected
        }

        // must not work as index > contents.size()
        try {
            contents.addAll( size + 1, null );
            fail( "Expected exception" );
        } catch ( IndexOutOfBoundsException e ) {
            // expected
        }

        // must work as index == contents.size()
        contents.addAll( size, addAllMofClasses );
        size = size + addAllMofClasses.size( );
        assertSame( size, contents.size( ) );

        try {
            contents.get( -1 );
            fail( "Expected exception" );
        } catch ( IndexOutOfBoundsException e ) {
            // expected
        }

        try {
            contents.get( size );
            fail( "Expected exception" );
        } catch ( IndexOutOfBoundsException e ) {
            // expected
        }

        try {
            contents.get( -2 );
            fail( "Expected exception" );
        } catch ( IndexOutOfBoundsException e ) {
            // expected
        }

        try {
            contents.set( -1, null );
            fail( "Expected exception" );
        } catch ( IndexOutOfBoundsException e ) {
            // expected
        }

        try {
            contents.set( -2, null );
            fail( "Expected exception" );
        } catch ( IndexOutOfBoundsException e ) {
            // expected
        }

        // must work
        contents.set( size - 1, classToBeSetLater );
        assertSame( size, contents.size( ) );

        // must not work as the specified index == size of contents
        try {
            contents.set( size, classToBeSetLater );
            fail( "Expected exception" );
        } catch ( IndexOutOfBoundsException e ) {
            // expected
        }

        try {
            contents.subList( -1, -3 );
            fail( "Expected exception" );
        } catch ( IndexOutOfBoundsException e ) {
            // expected
        }

        try {
            contents.subList( -2, -3 );
            fail( "Expected exception" );
        } catch ( IndexOutOfBoundsException e ) {
            // expected
        }

        try {
            contents.listIterator( -1 );
            fail( "Expected exception" );
        } catch ( IndexOutOfBoundsException e ) {
            // expected
        }

        try {
            contents.listIterator( -2 );
            fail( "Expected exception" );
        } catch ( IndexOutOfBoundsException e ) {
            // expected
        }

    }

    @Override
    @After
    public void afterTestMethod( ) throws Exception {

        super.afterTestMethod( );
        partition = null;
        sip = null;
        message1 = null;
        message2 = null;
        message3 = null;
        message4 = null;
        message5 = null;
        epr1 = null;
        epr2 = null;
        epr3 = null;
        epr4 = null;
        messageTriggersReply = null;
    }

    private void emptyTransientPartitions( Connection connection ) {

        for ( ModelPartition transientPartition : connection.getTransientPartitions( ) ) {
            transientPartition.deleteElements( );
        }
    }

    @Test
    public void testJmiListAddAndRemoveAllWithOtherJmiList( ) throws Exception {

        ModelPartition partition = getPartitionOne( );
        Tag tag1 = partition.createElement( Tag.class );
        Tag tag2 = partition.createElement( Tag.class );
        Attribute attribute1 = partition.createElement( Attribute.class );
        Attribute attribute2 = partition.createElement( Attribute.class );
        Attribute attribute3 = partition.createElement( Attribute.class );
        Attribute attribute4 = partition.createElement( Attribute.class );

        Collection<ModelElement> jmiList1 = tag1.getElements( );
        Collection<ModelElement> jmiList2 = tag2.getElements( );

        jmiList1.add( attribute1 );
        jmiList1.add( attribute2 );

        jmiList2.add( attribute3 );
        jmiList2.add( attribute4 );

        jmiList1.addAll( jmiList2 );
        assertEquals( 4, jmiList1.size( ) );
        assertTrue( jmiList1.containsAll( jmiList2 ) );
        assertTrue( jmiList1.contains( attribute1 ) );
        assertTrue( jmiList1.contains( attribute2 ) );
        assertTrue( jmiList1.contains( attribute3 ) );
        assertTrue( jmiList1.contains( attribute4 ) );

        jmiList1.removeAll( jmiList2 );

        assertEquals( 2, jmiList1.size( ) );
        assertTrue( jmiList1.contains( attribute1 ) );
        assertTrue( jmiList1.contains( attribute2 ) );
    }

    @Test
    public void testJmiListAddAndContainsAllWithOtherJmiList( ) throws Exception {

        ModelPartition partition = getPartitionOne( );
        Tag tag1 = partition.createElement( Tag.class );
        Tag tag2 = partition.createElement( Tag.class );
        Attribute attribute1 = partition.createElement( Attribute.class );
        Attribute attribute2 = partition.createElement( Attribute.class );
        Attribute attribute3 = partition.createElement( Attribute.class );
        Attribute attribute4 = partition.createElement( Attribute.class );

        Collection<ModelElement> jmiList1 = tag1.getElements( );
        Collection<ModelElement> jmiList2 = tag2.getElements( );

        jmiList1.add( attribute1 );
        jmiList1.add( attribute2 );

        jmiList2.add( attribute3 );
        jmiList2.add( attribute4 );

        jmiList1.addAll( jmiList2 );
        assertEquals( 4, jmiList1.size( ) );
        assertEquals( 2, jmiList2.size( ) );
        assertTrue( jmiList1.containsAll( jmiList2 ) );
        assertTrue( jmiList1.contains( attribute1 ) );
        assertTrue( jmiList1.contains( attribute2 ) );
        assertTrue( jmiList1.contains( attribute3 ) );
        assertTrue( jmiList1.contains( attribute4 ) );
    }

    @Test
    public void testJmiListRetainAllWithOtherJmiList( ) throws Exception {

        ModelPartition partition = getPartitionOne( );
        Tag tag1 = partition.createElement( Tag.class );
        Tag tag2 = partition.createElement( Tag.class );
        Attribute attribute1 = partition.createElement( Attribute.class );
        Attribute attribute2 = partition.createElement( Attribute.class );
        Attribute attribute3 = partition.createElement( Attribute.class );
        Attribute attribute4 = partition.createElement( Attribute.class );
        Attribute attribute5 = partition.createElement( Attribute.class );

        Collection<ModelElement> jmiList1 = tag1.getElements( );
        Collection<ModelElement> jmiList2 = tag2.getElements( );

        jmiList1.add( attribute1 );
        jmiList1.add( attribute2 );

        jmiList2.add( attribute3 );
        jmiList2.add( attribute4 );
        jmiList2.add( attribute5 );

        jmiList1.add( attribute3 );
        jmiList1.add( attribute4 );
        assertEquals( 4, jmiList1.size( ) );
        assertTrue( jmiList1.contains( attribute1 ) );
        assertTrue( jmiList1.contains( attribute2 ) );
        assertTrue( jmiList1.contains( attribute3 ) );
        assertTrue( jmiList1.contains( attribute4 ) );

        assertEquals( 3, jmiList2.size( ) );
        assertTrue( jmiList2.contains( attribute3 ) );
        assertTrue( jmiList2.contains( attribute4 ) );
        assertTrue( jmiList2.contains( attribute5 ) );

        jmiList1.retainAll( jmiList2 );
        assertEquals( 2, jmiList1.size( ) );
        assertTrue( jmiList1.contains( attribute3 ) );
        assertTrue( jmiList1.contains( attribute4 ) );

        assertEquals( 3, jmiList2.size( ) );
        assertTrue( jmiList2.contains( attribute3 ) );
        assertTrue( jmiList2.contains( attribute4 ) );
        assertTrue( jmiList2.contains( attribute5 ) );

        assertTrue( jmiList2.containsAll( jmiList1 ) );

    }

    @Test
    public void testJmiListRemoveAllWithOtherJmiListAttribute( ) throws Exception {

        ModelPartition partition = getPartitionOne( );
        A4 a4_1 = partition.createElement( A4.class );
        B4 attribute1 = partition.createElement( B4.class );
        B4 attribute2 = partition.createElement( B4.class );
        B4 attribute3 = partition.createElement( B4.class );
        B4 attribute4 = partition.createElement( B4.class );

        List<B4> jmiList1 = a4_1.getManyBsOrdered( );

        jmiList1.add( attribute1 );
        jmiList1.add( attribute2 );
        jmiList1.add( attribute3 );
        jmiList1.add( attribute4 );

        assertEquals( 4, jmiList1.size( ) );
        assertTrue( jmiList1.contains( attribute1 ) );
        assertTrue( jmiList1.contains( attribute2 ) );
        assertTrue( jmiList1.contains( attribute3 ) );
        assertTrue( jmiList1.contains( attribute4 ) );

        List<B4> jmiList2 = jmiList1.subList( 0, 2 );
        assertEquals( 2, jmiList2.size( ) );
        assertTrue( jmiList2.contains( attribute1 ) );
        assertTrue( jmiList2.contains( attribute2 ) );

        jmiList1.removeAll( jmiList2 );

        assertEquals( 2, jmiList1.size( ) );
        assertTrue( jmiList1.contains( attribute3 ) );
        assertTrue( jmiList1.contains( attribute4 ) );

    }

    @Test
    public void testJmiListContainsAllWithOtherJmiListAttribute( ) throws Exception {

        ModelPartition partition = getPartitionOne( );
        A4 a4_1 = partition.createElement( A4.class );
        B4 attribute1 = partition.createElement( B4.class );
        B4 attribute2 = partition.createElement( B4.class );
        B4 attribute3 = partition.createElement( B4.class );
        B4 attribute4 = partition.createElement( B4.class );

        List<B4> jmiList1 = a4_1.getManyBsOrdered( );

        jmiList1.add( attribute1 );
        jmiList1.add( attribute2 );
        jmiList1.add( attribute3 );
        jmiList1.add( attribute4 );

        assertEquals( 4, jmiList1.size( ) );
        assertTrue( jmiList1.contains( attribute1 ) );
        assertTrue( jmiList1.contains( attribute2 ) );
        assertTrue( jmiList1.contains( attribute3 ) );
        assertTrue( jmiList1.contains( attribute4 ) );

        List<B4> jmiList2 = jmiList1.subList( 2, 4 );
        assertEquals( 2, jmiList2.size( ) );
        assertTrue( jmiList2.contains( attribute3 ) );
        assertTrue( jmiList2.contains( attribute4 ) );

        assertTrue( jmiList1.containsAll( jmiList2 ) );

    }

    @Test
    public void testJmiListAddAllWithOtherJmiListAttribute( ) throws Exception {

        ModelPartition partition = getPartitionOne( );

        A4 a4_1 = partition.createElement( A4.class );

        B4 attribute1 = partition.createElement( B4.class );
        B4 attribute2 = partition.createElement( B4.class );
        B4 attribute3 = partition.createElement( B4.class );
        B4 attribute4 = partition.createElement( B4.class );

        List<B4> jmiList1 = a4_1.getManyBsOrdered( );

        jmiList1.add( attribute1 );
        jmiList1.add( attribute2 );
        jmiList1.add( attribute3 );
        jmiList1.add( attribute4 );

        assertEquals( 4, jmiList1.size( ) );
        assertTrue( jmiList1.contains( attribute1 ) );
        assertTrue( jmiList1.contains( attribute2 ) );
        assertTrue( jmiList1.contains( attribute3 ) );
        assertTrue( jmiList1.contains( attribute4 ) );

        List<B4> jmiList2 = jmiList1.subList( 0, 2 );
        assertEquals( 2, jmiList2.size( ) );
        assertTrue( jmiList2.contains( attribute1 ) );
        assertTrue( jmiList2.contains( attribute2 ) );
        jmiList1.addAll( jmiList2 );
        assertEquals( 6, jmiList1.size( ) );
        assertEquals( attribute1, jmiList1.get( 0 ) );
        assertEquals( attribute2, jmiList1.get( 1 ) );
        assertEquals( attribute3, jmiList1.get( 2 ) );
        assertEquals( attribute4, jmiList1.get( 3 ) );
        assertEquals( attribute1, jmiList1.get( 4 ) );
        assertEquals( attribute2, jmiList1.get( 5 ) );

        jmiList1.addAll( 0, jmiList2 );
        assertEquals( 8, jmiList1.size( ) );
        assertEquals( attribute1, jmiList1.get( 0 ) );
        assertEquals( attribute2, jmiList1.get( 1 ) );
        assertEquals( attribute1, jmiList1.get( 2 ) );
        assertEquals( attribute2, jmiList1.get( 3 ) );
        assertEquals( attribute3, jmiList1.get( 4 ) );
        assertEquals( attribute4, jmiList1.get( 5 ) );
        assertEquals( attribute1, jmiList1.get( 6 ) );
        assertEquals( attribute2, jmiList1.get( 7 ) );

    }

    @Test
    public void testJmiListRetainAllWithOtherJmiListAttribute( ) throws Exception {

        ModelPartition partition = getPartitionOne( );

        A4 a4_1 = partition.createElement( A4.class );

        B4 attribute1 = partition.createElement( B4.class );
        B4 attribute2 = partition.createElement( B4.class );
        B4 attribute3 = partition.createElement( B4.class );
        B4 attribute4 = partition.createElement( B4.class );
        B4 attribute5 = partition.createElement( B4.class );

        List<B4> jmiList1 = a4_1.getManyBsOrdered( );

        jmiList1.add( attribute1 );
        jmiList1.add( attribute2 );
        jmiList1.add( attribute3 );
        jmiList1.add( attribute4 );
        jmiList1.add( attribute5 );

        assertEquals( 5, jmiList1.size( ) );
        assertTrue( jmiList1.contains( attribute1 ) );
        assertTrue( jmiList1.contains( attribute2 ) );
        assertTrue( jmiList1.contains( attribute3 ) );
        assertTrue( jmiList1.contains( attribute4 ) );
        assertTrue( jmiList1.contains( attribute5 ) );

        List<B4> jmiList2 = jmiList1.subList( 2, 5 );

        assertEquals( 3, jmiList2.size( ) );
        assertTrue( jmiList2.contains( attribute3 ) );
        assertTrue( jmiList2.contains( attribute4 ) );
        assertTrue( jmiList2.contains( attribute5 ) );

        jmiList1.retainAll( jmiList2 );
        assertEquals( 3, jmiList1.size( ) );
        assertTrue( jmiList1.contains( attribute3 ) );
        assertTrue( jmiList1.contains( attribute4 ) );
        assertTrue( jmiList1.contains( attribute5 ) );

    }

    @Test
    public void testOrderedJmiListEqualsWithJmiListOfOtherConnection( ) throws Exception {

        ModelPartition partition = getSecondMOINConnection( ).getPartition( getPartitionOne( ).getPri( ) );

        A4 a4 = partition.createElement( A4.class );

        B4 attribute1 = partition.createElement( B4.class );
        B4 attribute2 = partition.createElement( B4.class );
        B4 attribute3 = partition.createElement( B4.class );
        B4 attribute4 = partition.createElement( B4.class );
        B4 attribute5 = partition.createElement( B4.class );

        List<B4> jmiList1 = a4.getManyBsOrdered( );

        jmiList1.add( attribute1 );
        jmiList1.add( attribute2 );
        jmiList1.add( attribute3 );
        jmiList1.add( attribute4 );
        jmiList1.add( attribute5 );

        // Save the elements created in second connection and retrieve them via first connection
        getSecondMOINConnection( ).save( );

        Connection connection1 = getMOINConnection( );
        A4 a4_conn1 = (A4) connection1.getElement( ( (Partitionable) a4 ).get___Mri( ) );
        List<B4> jmiList_conn1 = a4_conn1.getManyBsOrdered( );

        assertEquals( jmiList1, jmiList_conn1 );
        assertEquals( jmiList_conn1, jmiList1 );

    }

    @Test
    public void testNonOrderedJmiListEqualsWithJmiListOfOtherConnection( ) throws Exception {

        ModelPartition partition = getSecondMOINConnection( ).getPartition( getPartitionOne( ).getPri( ) );

        A4 a4 = partition.createElement( A4.class );

        B4 attribute1 = partition.createElement( B4.class );
        B4 attribute2 = partition.createElement( B4.class );
        B4 attribute3 = partition.createElement( B4.class );
        B4 attribute4 = partition.createElement( B4.class );
        B4 attribute5 = partition.createElement( B4.class );

        Collection<B4> jmiList1 = a4.getManyBs( );

        jmiList1.add( attribute1 );
        jmiList1.add( attribute2 );
        jmiList1.add( attribute3 );
        jmiList1.add( attribute4 );
        jmiList1.add( attribute5 );

        // Save the elements created in second connection and retrieve them via first connection
        getSecondMOINConnection( ).save( );

        Connection connection1 = getMOINConnection( );
        A4 a4_conn1 = (A4) connection1.getElement( ( (Partitionable) a4 ).get___Mri( ) );
        Collection<B4> jmiList_conn1 = a4_conn1.getManyBs( );

        assertEquals( jmiList1, jmiList_conn1 );
        assertEquals( jmiList_conn1, jmiList1 );

    }

    @Test
    public void testDerivedAssocJmiList( ) throws Exception {

        DependsOn dependsOnAssoc = getMOINConnection( ).getAssociation( DependsOn.ASSOCIATION_DESCRIPTOR );
        MofClass mofClass = getPartitionOne( ).createElement( MofClass.class );
        Collection<RefObject> result = dependsOnAssoc.refQuery( "provider", mofClass );
        assertEquals( 1, result.size( ) );
        assertEquals( mofClass, result.iterator( ).next( ) );
        assertFalse( result.isEmpty( ) );
    }
}
