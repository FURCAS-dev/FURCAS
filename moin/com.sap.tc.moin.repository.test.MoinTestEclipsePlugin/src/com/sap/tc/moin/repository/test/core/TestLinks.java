/*
 * Created on 01.03.2005
 */
package com.sap.tc.moin.repository.test.core;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.AttachesTo;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.Contains;
import com.sap.tc.moin.repository.mmi.model.IsOfType;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.ModelPackage;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.Namespace;
import com.sap.tc.moin.repository.mmi.model.Operation;
import com.sap.tc.moin.repository.mmi.model.Parameter;
import com.sap.tc.moin.repository.mmi.model.Reference;
import com.sap.tc.moin.repository.mmi.model.RefersTo;
import com.sap.tc.moin.repository.mmi.model.Tag;
import com.sap.tc.moin.repository.mmi.model.__impl.AssociationEndInternal;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.TypeMismatchException;
import com.sap.tc.moin.repository.mmi.reflect.WrongSizeException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.omg.ocl.OclPackage;
import org.omg.ocl.attaching.OclConstraint;
import org.omg.ocl.expressions.OclExpression;

import com.sap.serviceinteractions.Message;
import com.sap.serviceinteractions.MessageTriggersReply;
import com.sap.serviceinteractions.ServiceInteractionsPackage;
import com.sap.tc.moin.friends.AssociationLink;
import com.sap.tc.moin.friends.RefObjectUtil;
import com.sap.tc.moin.friends.factory.UtilitiesFactory;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.DataAreaDescriptor;
import com.sap.tc.moin.repository.IllegalLinkException;
import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.consistency.DanglingLinkConsistencyViolation;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.core.CorePartitionManager;
import com.sap.tc.moin.repository.core.CorePartitionable;
import com.sap.tc.moin.repository.core.EndStorageLink;
import com.sap.tc.moin.repository.core.JmiList;
import com.sap.tc.moin.repository.core.MemoryLinkManager;
import com.sap.tc.moin.repository.core.consistency.impl.ConsistencyViolationRegistryImpl;
import com.sap.tc.moin.repository.core.jmi.reflect.RefObjectImpl;
import com.sap.tc.moin.repository.core.serialization.PartitionReaderImpl;
import com.sap.tc.moin.repository.core.serialization.PartitionWriterImpl;
import com.sap.tc.moin.repository.events.EventChain;
import com.sap.tc.moin.repository.events.UpdateListener;
import com.sap.tc.moin.repository.events.filter.EventTypeFilter;
import com.sap.tc.moin.repository.events.type.ChangeEvent;
import com.sap.tc.moin.repository.events.type.LinkAddEvent;
import com.sap.tc.moin.repository.events.type.LinkChangeEvent;
import com.sap.tc.moin.repository.events.type.LinkRemoveEvent;
import com.sap.tc.moin.repository.mmi.reflect.RefClassCalculatedMofId;
import com.sap.tc.moin.repository.spi.core.Wrapper;
import com.sap.tc.moin.test.fw.TestMetaModels;
import com.sap.tc.moin.testcases.TestcasesPackage;
import com.sap.tc.moin.testcases.case001.A1;
import com.sap.tc.moin.testcases.case001.B1;
import com.sap.tc.moin.testcases.case003.A3;
import com.sap.tc.moin.testcases.case003.B3;
import com.sap.tc.moin.testcases.case004.A4;
import com.sap.tc.moin.testcases.case004.B4;
import com.sap.tc.moin.testcases.case004.C4;
import com.sap.tc.moin.testcases.case004.Case004Package;
import com.sap.tc.moin.testcases.case004.ComposesB;
import com.sap.tc.moin.testcases.case004.ComposesCs;
import com.sap.tc.moin.testcases.case004.ComposesCsOrdered;
import com.sap.tc.moin.testcases.case004.F4;
import com.sap.tc.moin.testcases.case004.HasCs;
import com.sap.tc.moin.testcases.case005.p1.A5;
import com.sap.tc.moin.testcases.case005.p1.p2.B5;
import com.sap.tc.moin.testcases.case006.B6;
import com.sap.tc.moin.testcases.case006.C6;
import com.sap.tc.moin.testcases.case006.D6;
import com.sap.tc.moin.testcases.case006.ReferenceAtComponent;
import com.sap.tc.moin.testcases.case006.ReferenceAtComposite;
import com.sap.tc.moin.testcases.case010.A10;
import com.sap.tc.moin.testcases.case010.B10;
import com.sap.tc.moin.testcases.case010.C10;
import com.sap.tc.moin.testcases.case016.A16;
import com.sap.tc.moin.testcases.case016.B16;
import com.sap.tc.moin.testcases.case026.A26;

@SuppressWarnings( "nls" )
public class TestLinks extends CoreMoinTest {

    private TestcasesPackage testcasesPackage;

    private ServiceInteractionsPackage sip;

    private Message message1;

    private Message message2;

    private Message message3;

    private Message message4;

    private Message message5;

    private MessageTriggersReply messageTriggersReply;

    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );
        testcasesPackage = (TestcasesPackage) getMOINConnection( ).getPackage( TestMetaModels.TESTCASES_CN, TestMetaModels.TESTCASES_TPE );
        sip = (ServiceInteractionsPackage) ( getMOINConnection( ).getPackage( TestMetaModels.SERVICE_INTERACTIONS_CN, TestMetaModels.SERVICE_INTERACTIONS_TPE ) );

        // create multiple messages
        message1 = getMOINConnection( ).createElementInPartition( Message.class, null );
        message2 = getMOINConnection( ).createElementInPartition( Message.class, null );
        message3 = getMOINConnection( ).createElementInPartition( Message.class, null );
        message4 = getMOINConnection( ).createElementInPartition( Message.class, null );
        message5 = getMOINConnection( ).createElementInPartition( Message.class, null );
        // create association
        messageTriggersReply = sip.getMessageTriggersReply( );
    }

    @Test
    public void testComponentChildrenRetrievalWithStorageOnChild( ) throws Exception {

        B6 parent = createB6( );
        C6 childOne = createC6( );
        childOne.setX( parent );
        assertEquals( parent, childOne.getX( ) );
        ReferenceAtComponent referenceAtComponent = testcasesPackage.getCase006( ).getReferenceAtComponent( );
        C6 currentChild = referenceAtComponent.getY( parent );
        assertEquals( childOne, currentChild );

        Collection<CorePartitionable> componentChildren = getLinkActionManager( getMOINConnection( ) ).getComponentChildren( getTestHelper( ).getCoreConnection( getMOINConnection( ) ).getSession( ), getTestHelper( ).getCorePartitionable( parent ) );
        assertEquals( 1, componentChildren.size( ) );
        assertEquals( getTestHelper( ).getCorePartitionable( childOne ), componentChildren.iterator( ).next( ) );
    }

    @Test
    public void testGetCompositeChildrenStable( ) throws Exception {

        ModelPackage mp = (ModelPackage) getMOINConnection( ).getPackage( null, TestMetaModels.MOIN_MOF_TPE_MODEL );
        MofPackage pkg = (MofPackage) mp.getMofPackage( ).refCreateInstance( );
        MofClass child1 = (MofClass) mp.getMofClass( ).refCreateInstance( );
        child1.setName( "class1" );
        MofClass child2 = (MofClass) mp.getMofClass( ).refCreateInstance( );
        child2.setName( "class1" );

        Attribute attribute1 = (Attribute) mp.getAttribute( ).refCreateInstance( );
        attribute1.setName( "attribute1" );
        Attribute attribute2 = (Attribute) mp.getAttribute( ).refCreateInstance( );
        attribute2.setName( "attribute2" );
        Attribute attribute3 = (Attribute) mp.getAttribute( ).refCreateInstance( );
        attribute3.setName( "attribute3" );
        Attribute attribute4 = (Attribute) mp.getAttribute( ).refCreateInstance( );
        attribute4.setName( "attribute4" );

        Attribute attribute5 = (Attribute) mp.getAttribute( ).refCreateInstance( );
        attribute5.setName( "attribute5" );
        Attribute attribute6 = (Attribute) mp.getAttribute( ).refCreateInstance( );
        attribute6.setName( "attribute6" );
        Attribute attribute7 = (Attribute) mp.getAttribute( ).refCreateInstance( );
        attribute7.setName( "attribute7" );

        com.sap.tc.moin.repository.mmi.model.Operation operation = (Operation) mp.getOperation( ).refCreateInstance( );
        com.sap.tc.moin.repository.mmi.model.Parameter parameter1 = (Parameter) mp.getParameter( ).refCreateInstance( );
        parameter1.setName( "parameter1" );
        com.sap.tc.moin.repository.mmi.model.Parameter parameter2 = (Parameter) mp.getParameter( ).refCreateInstance( );
        parameter2.setName( "parameter2" );

        operation.getContents( ).add( parameter1 );
        operation.getContents( ).add( parameter2 );

        pkg.getContents( ).add( child1 );
        pkg.getContents( ).add( child2 );

        child1.getContents( ).add( attribute1 );
        child1.getContents( ).add( attribute2 );
        child1.getContents( ).add( attribute3 );
        child1.getContents( ).add( attribute4 );

        child2.getContents( ).add( attribute5 );
        child2.getContents( ).add( attribute6 );
        child2.getContents( ).add( attribute7 );
        child2.getContents( ).add( operation );

        //recursive
        ArrayList<String> expectedMofIdsInCorrectOrder = new ArrayList<String>( );
        expectedMofIdsInCorrectOrder.add( child1.refMofId( ) );
        expectedMofIdsInCorrectOrder.add( child2.refMofId( ) );
        expectedMofIdsInCorrectOrder.add( attribute1.refMofId( ) );
        expectedMofIdsInCorrectOrder.add( attribute2.refMofId( ) );
        expectedMofIdsInCorrectOrder.add( attribute3.refMofId( ) );
        expectedMofIdsInCorrectOrder.add( attribute4.refMofId( ) );
        expectedMofIdsInCorrectOrder.add( attribute5.refMofId( ) );
        expectedMofIdsInCorrectOrder.add( attribute6.refMofId( ) );
        expectedMofIdsInCorrectOrder.add( attribute7.refMofId( ) );
        expectedMofIdsInCorrectOrder.add( operation.refMofId( ) );
        expectedMofIdsInCorrectOrder.add( parameter1.refMofId( ) );
        expectedMofIdsInCorrectOrder.add( parameter2.refMofId( ) );

        int numberOfChildren = expectedMofIdsInCorrectOrder.size( );

        com.sap.tc.moin.repository.JmiHelper jmiHelper = getMOINConnection( ).getJmiHelper( );
        RefObject rootElement = pkg;

        Collection<RefObject> compositeChildren = jmiHelper.getCompositeChildrenStable( rootElement, true );

        assertSame( numberOfChildren, compositeChildren.size( ) );

        Iterator<RefObject> iterator = compositeChildren.iterator( );
        for ( int i = 0; i < compositeChildren.size( ); i++ ) {
            RefObject refObject = iterator.next( );
            assertEquals( expectedMofIdsInCorrectOrder.get( i ), refObject.refMofId( ) );
            assertTrue( "Returned object is not wrapped!", refObject instanceof Wrapper );
        }

        //non-recursive
        expectedMofIdsInCorrectOrder.clear( );
        expectedMofIdsInCorrectOrder.add( child1.refMofId( ) );
        expectedMofIdsInCorrectOrder.add( child2.refMofId( ) );
        numberOfChildren = expectedMofIdsInCorrectOrder.size( );

        compositeChildren = jmiHelper.getCompositeChildrenStable( rootElement, false );

        assertSame( numberOfChildren, compositeChildren.size( ) );

        iterator = compositeChildren.iterator( );
        for ( int i = 0; i < compositeChildren.size( ); i++ ) {
            assertEquals( expectedMofIdsInCorrectOrder.get( i ), iterator.next( ).refMofId( ) );
        }

        TestcasesPackage testcasesPackage = (TestcasesPackage) getMOINConnection( ).getPackage( TestMetaModels.TESTCASES_CN, TestMetaModels.TESTCASES_TPE );

        F4 f4 = getMOINConnection( ).createElementInPartition( F4.class, null );

        C4 c4_1 = getMOINConnection( ).createElementInPartition( C4.class, null );
        C4 c4_2 = getMOINConnection( ).createElementInPartition( C4.class, null );
        C4 c4_3 = getMOINConnection( ).createElementInPartition( C4.class, null );
        C4 c4_4 = getMOINConnection( ).createElementInPartition( C4.class, null );
        C4 c4_5 = getMOINConnection( ).createElementInPartition( C4.class, null );
        C4 c4_6 = getMOINConnection( ).createElementInPartition( C4.class, null );

        Collection<C4> manyCs = f4.getManyCs( );
        manyCs.add( c4_1 );
        manyCs.add( c4_2 );
        manyCs.add( c4_3 );

        List<C4> manyCsOrdered = f4.getManyCsOrdered( );
        manyCsOrdered.add( c4_4 );
        manyCsOrdered.add( c4_5 );
        manyCsOrdered.add( c4_6 );

        expectedMofIdsInCorrectOrder.clear( );
        rootElement = f4;

        //as the associations will be sorted by mofId, the comparison collection must be built up accordingly
        Case004Package case004 = testcasesPackage.getCase004( );
        if ( case004.getComposesCs( ).refMofId( ).compareTo( case004.getComposesCsOrdered( ).refMofId( ) ) < 0 ) {

            for ( RefObject refObject : manyCs ) {
                expectedMofIdsInCorrectOrder.add( refObject.refMofId( ) );
            }
            for ( RefObject refObject : manyCsOrdered ) {
                expectedMofIdsInCorrectOrder.add( refObject.refMofId( ) );
            }

        } else {
            for ( RefObject refObject : manyCsOrdered ) {
                expectedMofIdsInCorrectOrder.add( refObject.refMofId( ) );
            }
            for ( RefObject refObject : manyCs ) {
                expectedMofIdsInCorrectOrder.add( refObject.refMofId( ) );
            }

        }

        numberOfChildren = expectedMofIdsInCorrectOrder.size( );
        compositeChildren = jmiHelper.getCompositeChildrenStable( rootElement, false );

        assertSame( numberOfChildren, compositeChildren.size( ) );

        iterator = compositeChildren.iterator( );
        for ( int i = 0; i < compositeChildren.size( ); i++ ) {
            assertEquals( expectedMofIdsInCorrectOrder.get( i ), iterator.next( ).refMofId( ) );
        }

        //do the same again with "recursive = true" -> must be same result
        compositeChildren = jmiHelper.getCompositeChildrenStable( rootElement, true );

        assertSame( numberOfChildren, compositeChildren.size( ) );

        iterator = compositeChildren.iterator( );
        for ( int i = 0; i < compositeChildren.size( ); i++ ) {
            assertEquals( expectedMofIdsInCorrectOrder.get( i ), iterator.next( ).refMofId( ) );
        }

    }

    @Test
    public void testRefImmediateCompositeWithStorageOnlyOnParent( ) throws Exception {

        B5 child = getMOINConnection( ).createElementInPartition( B5.class, null );
        A5 parent = getMOINConnection( ).createElementInPartition( A5.class, null );
        parent.setX( child );

        assertEquals( parent, child.refImmediateComposite( ) );

    }

    @Test
    public void testComponentChildrenRetrievalWithStorageOnParent( ) throws Exception {

        D6 child = createD6( );
        C6 parent = createC6( );

        parent.setW( child );
        assertEquals( child, parent.getW( ) );
        ReferenceAtComposite referenceAtComposite = testcasesPackage.getCase006( ).getReferenceAtComposite( );

        C6 currentParent = referenceAtComposite.getV( child );
        assertEquals( parent, currentParent );

        Collection<CorePartitionable> componentChildren = getLinkActionManager( getMOINConnection( ) ).getComponentChildren( getTestHelper( ).getCoreConnection( getMOINConnection( ) ).getSession( ), getTestHelper( ).getCorePartitionable( parent ) );
        assertEquals( 1, componentChildren.size( ) );
        assertEquals( getTestHelper( ).getCorePartitionable( child ), componentChildren.iterator( ).next( ) );

    }

    @Test
    public void testCompositeParentRetrievalWithStorageOnChild( ) throws Exception {

        B6 parent = createB6( );
        C6 child = createC6( );
        child.setX( parent );
        assertEquals( parent, child.getX( ) );
        ReferenceAtComponent referenceAtComponent = testcasesPackage.getCase006( ).getReferenceAtComponent( );
        C6 currentChild = referenceAtComponent.getY( parent );
        assertEquals( child, currentChild );

        EndStorageLink compositeParentLink = getLinkActionManager( getMOINConnection( ) ).getCompositeParentLink( getTestHelper( ).getCoreConnection( getMOINConnection( ) ).getSession( ), getTestHelper( ).getCorePartitionable( child ) );

        assertEquals( getTestHelper( ).getCorePartitionable( parent ), compositeParentLink.getEnd( compositeParentLink.getCompositeEnd( ) ).get( getTestHelper( ).getCoreConnection( getMOINConnection( ) ).getSession( ) ) );
        assertEquals( getTestHelper( ).getCorePartitionable( child ), compositeParentLink.getEnd( compositeParentLink.getComponentEnd( ) ).get( getTestHelper( ).getCoreConnection( getMOINConnection( ) ).getSession( ) ) );

        assertEquals( parent, child.refImmediateComposite( ) );
        assertEquals( parent, child.getX( ) );

    }

    @Test
    public void testCompositeParentRetrievalWithStorageOnParent( ) throws Exception {

        D6 child = createD6( );
        C6 parent = createC6( );

        parent.setW( child );
        assertEquals( child, parent.getW( ) );
        ReferenceAtComposite referenceAtComposite = testcasesPackage.getCase006( ).getReferenceAtComposite( );

        C6 currentParent = referenceAtComposite.getV( child );
        assertEquals( parent, currentParent );

        EndStorageLink compositeParentLink = getLinkActionManager( getMOINConnection( ) ).getCompositeParentLink( getTestHelper( ).getCoreConnection( getMOINConnection( ) ).getSession( ), getTestHelper( ).getCorePartitionable( child ) );

        assertEquals( getTestHelper( ).getCorePartitionable( parent ), compositeParentLink.getEnd( compositeParentLink.getCompositeEnd( ) ).get( getTestHelper( ).getCoreConnection( getMOINConnection( ) ).getSession( ) ) );
        assertEquals( getTestHelper( ).getCorePartitionable( child ), compositeParentLink.getEnd( compositeParentLink.getComponentEnd( ) ).get( getTestHelper( ).getCoreConnection( getMOINConnection( ) ).getSession( ) ) );

        assertEquals( parent, child.refImmediateComposite( ) );
        assertEquals( child, parent.getW( ) );

    }

    @Test
    public void testStableEndStorageLinkOrderDistributed( ) throws Exception {

        ModelPartition partition = getPartitionOne( );
        ModelPartition partition2 = getPartitionTwo( );

        A16 a16_1 = getMOINConnection( ).createElementInPartition( A16.class, null );
        B16 b16_1 = getMOINConnection( ).createElementInPartition( B16.class, null );
        B16 b16_2 = getMOINConnection( ).createElementInPartition( B16.class, null );
        B16 b16_3 = getMOINConnection( ).createElementInPartition( B16.class, null );
        B16 b16_4 = getMOINConnection( ).createElementInPartition( B16.class, null );
        B16 b16_5 = getMOINConnection( ).createElementInPartition( B16.class, null );
        B16 b16_6 = getMOINConnection( ).createElementInPartition( B16.class, null );
        B16 b16_7 = getMOINConnection( ).createElementInPartition( B16.class, null );
        B16 b16_8 = getMOINConnection( ).createElementInPartition( B16.class, null );

        // assign to real partitions so it can be saved
        ( (Partitionable) a16_1 ).assign___Partition( partition );
        ( (Partitionable) b16_1 ).assign___Partition( partition );
        ( (Partitionable) b16_2 ).assign___Partition( partition );
        ( (Partitionable) b16_3 ).assign___Partition( partition );
        ( (Partitionable) b16_4 ).assign___Partition( partition2 );
        ( (Partitionable) b16_5 ).assign___Partition( partition2 );
        ( (Partitionable) b16_6 ).assign___Partition( partition2 );
        ( (Partitionable) b16_7 ).assign___Partition( partition );
        ( (Partitionable) b16_8 ).assign___Partition( partition );

        Collection<B16> distributedBs = a16_1.getB( );
        assertTrue( distributedBs.isEmpty( ) );
        distributedBs.add( b16_1 );
        distributedBs.add( b16_2 );
        distributedBs.add( b16_3 );
        distributedBs.add( b16_4 );
        distributedBs.add( b16_5 );
        distributedBs.add( b16_6 );
        distributedBs.add( b16_7 );
        distributedBs.add( b16_8 );

        Collection<B16> expectedB16s = new ArrayList<B16>( );
        expectedB16s.add( b16_1 );
        expectedB16s.add( b16_2 );
        expectedB16s.add( b16_3 );
        expectedB16s.add( b16_4 );
        expectedB16s.add( b16_5 );
        expectedB16s.add( b16_6 );
        expectedB16s.add( b16_7 );
        expectedB16s.add( b16_8 );

        assertEqualsCollection( expectedB16s, distributedBs );

        List<B16> currentOrder = new ArrayList<B16>( );
        for ( B16 message : distributedBs ) {
            currentOrder.add( message );
        }

        Connection connection = getMOINConnection( );

        // empty null partition so connection can be saved
        connection.getNullPartition( ).deleteElements( );

        // save partition
        connection.save( );

        // order must be the same after save
        assertEqualsCollectionOrder( currentOrder, distributedBs );

        // we want to make sure that the partitions are not loaded, therefore we
        // add another element (to make the
        // partition dirty) and then revert (as all dirty partitions will be
        // evicted during revert())
        getMOINConnection( ).createElementInPartition( A16.class, partition );
        getMOINConnection( ).createElementInPartition( A16.class, partition2 );
        connection.revert( );

        // order must be the same after reload
        assertEqualsCollectionOrder( currentOrder, distributedBs );

    }

    @Test
    public void testDistributedLinkRemovalOnElementDeletion( ) throws Exception {

        Connection connection = getMOINConnection( );
        ModelPartition partition = getPartitionOne( );
        ModelPartition partition2 = getPartitionTwo( );
        assertTrue( "Expected partition to be empty", partition2.getElements( ).isEmpty( ) );

        // make sure there are no other elements which are not needed in this
        // test
        connection.getNullPartition( ).deleteElements( );

        A16 a16_1 = getMOINConnection( ).createElementInPartition( A16.class, null );
        B16 b16_1 = getMOINConnection( ).createElementInPartition( B16.class, null );
        B16 b16_2 = getMOINConnection( ).createElementInPartition( B16.class, null );

        // assign to real partitions so it can be saved
        ( (Partitionable) a16_1 ).assign___Partition( partition );
        ( (Partitionable) b16_1 ).assign___Partition( partition );
        ( (Partitionable) b16_2 ).assign___Partition( partition2 );

        // establish the links
        Collection<B16> distributedBs = a16_1.getB( );
        assertTrue( distributedBs.isEmpty( ) );
        distributedBs.add( b16_1 );
        distributedBs.add( b16_2 );

        // save it so that nothing is dirty anymore
        connection.save( );
        assertFalse( "Expected partition to be NOT dirty", partition2.isDirty( ) );

        // delete the element which has links that are stored distributed
        a16_1.refDelete( );

        // the links must have vanished
        assertTrue( "Expected no more elements to be linked to deleted object", distributedBs.isEmpty( ) );

        // partition2 must be dirty now as there a link to the deleted element
        // was stored.
        assertTrue( "Expected partition2 to be dirty", partition2.isDirty( ) );

    }

    @Test
    public void testStableEndStorageLinkNonDistributed( ) throws Exception {

        Collection<Message> triggers = messageTriggersReply.getTriggers( message1 );

        triggers.add( message2 );
        triggers.add( message3 );
        triggers.add( message4 );
        triggers.add( message5 );

        Collection<Message> expectedTriggers = new ArrayList<Message>( );
        expectedTriggers.add( message2 );
        expectedTriggers.add( message3 );
        expectedTriggers.add( message4 );
        expectedTriggers.add( message5 );

        assertEqualsCollection( expectedTriggers, triggers );

        List<Message> currentOrder = new ArrayList<Message>( );
        for ( Message message : triggers ) {
            currentOrder.add( message );
        }

        ModelPartition partition = getPartitionOne( );

        partition.assignElement( message1 );
        partition.assignElement( message2 );
        partition.assignElement( message3 );
        partition.assignElement( message4 );
        partition.assignElement( message5 );

        Connection connection = ( message1 ).get___Connection( );
        connection.save( );
        assertEqualsCollectionOrder( currentOrder, triggers );

        evictPartition( partition );

        assertEqualsCollectionOrder( currentOrder, triggers );
    }

    private void evictPartition( ModelPartition partition ) {

        CoreModelPartition cmp = getTestHelper( ).getCoreModelPartition( partition );
        CoreConnection coreConnection = getTestHelper( ).getCoreConnection( getMOINConnection( ) );
        CorePartitionManager ccswPartitionManager = coreConnection.getSession( ).getCompoundClientSpecWorkspace( ).getPartitionManager( );
        if ( ccswPartitionManager.isPartitionLoaded( partition.getPri( ) ) ) {
            ccswPartitionManager.evictPartitionForced( cmp );
        }
        CorePartitionManager swPartitionManager = coreConnection.getSession( ).getWorkspace( ).getPartitionManager( );
        if ( swPartitionManager.isPartitionLoaded( partition.getPri( ) ) ) {
            swPartitionManager.evictPartitionForced( cmp );
        }
    }

    private void assertEqualsCollectionOrder( Collection<?> expected, Collection<?> actual ) {

        assertSame( "Size differs", expected.size( ), actual.size( ) );
        Iterator<?> expectedIterator = expected.iterator( );
        Iterator<?> actualIterator = actual.iterator( );
        while ( expectedIterator.hasNext( ) ) {
            assertEquals( expectedIterator.next( ), actualIterator.next( ) );
        }

    }

    private void assertEqualsCollection( Collection<?> expected, Collection<?> actual ) {

        assertSame( "Size differs", expected.size( ), actual.size( ) );
        assertTrue( "Not all elements are contained", expected.containsAll( actual ) );
        for ( Object object : expected ) {
            int frequencyExpected = Collections.frequency( expected, object );
            int frequencyActual = Collections.frequency( actual, object );
            assertSame( "Frequency for element " + object + " differs", frequencyExpected, frequencyActual );
        }
    }

    @Test
    @SuppressWarnings( { "unchecked" } )
    public void testStableLinkOrderAfterInsertionAtIndex0AndReload( ) throws Exception {

        String nameOfParameter1 = "parameter1";
        String nameOfParameter2 = "parameter2";
        String nameOfParameter3 = "parameter3";
        String nameOfParameter4 = "parameter4";
        String nameOfParameter5 = "parameter5";
        MofPackage somePackage = getMOINConnection( ).getNullPartition( ).createElement( MofPackage.class );
        List parameters = somePackage.getContents( );
        MofClass parameter1 = getMOINConnection( ).getNullPartition( ).createElement( MofClass.class );
        parameter1.setName( nameOfParameter1 );
        MofClass parameter2 = getMOINConnection( ).getNullPartition( ).createElement( MofClass.class );
        parameter2.setName( nameOfParameter2 );
        MofClass parameter3 = getMOINConnection( ).getNullPartition( ).createElement( MofClass.class );
        parameter3.setName( nameOfParameter3 );
        MofClass parameter4 = getMOINConnection( ).getNullPartition( ).createElement( MofClass.class );
        parameter4.setName( nameOfParameter4 );
        MofClass parameter5 = getMOINConnection( ).getNullPartition( ).createElement( MofClass.class );
        parameter5.setName( nameOfParameter5 );
        parameters.add( parameter1 );
        parameters.add( parameter2 );
        parameters.add( parameter3 );
        parameters.add( 0, parameter4 );
        parameters.add( 0, parameter5 );

        ModelPartition partition = getMOINConnection( ).getOrCreateTransientPartition( "linkOrderingPartitionTest" );
        partition.assignElement( somePackage );
        partition.assignElement( parameter1 );
        partition.assignElement( parameter2 );
        partition.assignElement( parameter3 );
        partition.assignElement( parameter4 );
        partition.assignElement( parameter5 );

        assertTrue( "Not all parameter are contained", parameters.containsAll( Arrays.asList( new Object[] { parameter1, parameter2, parameter3, parameter4, parameter5 } ) ) );

        int index = 0;
        for ( Object object : parameters ) {

            switch ( index ) {
                case 0:
                    assertEquals( parameter5, object );
                    break;
                case 1:
                    assertEquals( parameter4, object );
                    break;
                case 2:
                    assertEquals( parameter1, object );
                    break;
                case 3:
                    assertEquals( parameter2, object );
                    break;
                case 4:
                    assertEquals( parameter3, object );
                    break;

                default:
                    fail( "unexpected index" );
            }

            index++;
        }

        assertSame( 5, index );
        assertSame( 5, parameters.size( ) );

        MRI mriOfMofPackage = ( (Partitionable) somePackage ).get___Mri( );

        ByteArrayOutputStream bos = new ByteArrayOutputStream( );
        new PartitionWriterImpl( ).write( getTestHelper( ).getCoreConnection( getMOINConnection( ) ).getSession( ), bos, getTestHelper( ).getCoreModelPartition( partition ) );
        byte[] xmi = bos.toByteArray( );
        String asString = new String( xmi );

        // in order to make sure that the changes are undone before reading in
        // from xmi
        this.getMOINConnection( ).revert( );

        partition.deleteElements( );
        assertTrue( partition.getElements( ).isEmpty( ) );

        ByteArrayInputStream stream = new ByteArrayInputStream( asString.getBytes( ) );
        new PartitionReaderImpl( ).read( getTestHelper( ).getCoreConnection( getMOINConnection( ) ).getSession( ), stream, getTestHelper( ).getCoreModelPartition( partition ) );

        assertSame( 6, partition.getElements( ).size( ) );
        Collection<Partitionable> elements = partition.getElements( );

        MofPackage newlyReadMofPackage = null;
        // find the operation
        for ( Partitionable element : elements ) {
            if ( mriOfMofPackage.equals( element.get___Mri( ) ) ) {
                // found it
                newlyReadMofPackage = (MofPackage) element;
            }
        }

        assertNotNull( "Expected to find MofPackge again after reading partition xmi", newlyReadMofPackage );
        List<ModelElement> newlyReadParameters = newlyReadMofPackage.getContents( );
        assertSame( 5, newlyReadParameters.size( ) );
        assertEquals( nameOfParameter5, newlyReadParameters.get( 0 ).getName( ) );
        assertEquals( nameOfParameter4, newlyReadParameters.get( 1 ).getName( ) );
        assertEquals( nameOfParameter1, newlyReadParameters.get( 2 ).getName( ) );
        assertEquals( nameOfParameter2, newlyReadParameters.get( 3 ).getName( ) );
        assertEquals( nameOfParameter3, newlyReadParameters.get( 4 ).getName( ) );
    }

    @Test
    public void testOrderingAfterSave( ) throws Exception {

        String nameOfParameter1 = "parameter1";
        String nameOfParameter2 = "parameter2";
        String nameOfParameter3 = "parameter3";
        String nameOfParameter4 = "parameter4";
        String nameOfParameter5 = "parameter5";
        String nameOfParameter6 = "parameter6";
        MofPackage someMofPackage = getMOINConnection( ).getNullPartition( ).createElement( MofPackage.class );
        List<ModelElement> parameters = someMofPackage.getContents( );
        MofClass parameter1 = getMOINConnection( ).getNullPartition( ).createElement( MofClass.class );
        parameter1.setName( nameOfParameter1 );
        MofClass parameter2 = getMOINConnection( ).getNullPartition( ).createElement( MofClass.class );
        parameter2.setName( nameOfParameter2 );
        MofClass parameter3 = getMOINConnection( ).getNullPartition( ).createElement( MofClass.class );
        parameter3.setName( nameOfParameter3 );
        MofClass parameter4 = getMOINConnection( ).getNullPartition( ).createElement( MofClass.class );
        parameter4.setName( nameOfParameter4 );
        MofClass parameter5 = getMOINConnection( ).getNullPartition( ).createElement( MofClass.class );
        parameter5.setName( nameOfParameter5 );
        MofClass parameter6 = getMOINConnection( ).getNullPartition( ).createElement( MofClass.class );
        parameter6.setName( nameOfParameter6 );

        parameters.add( parameter1 );
        parameters.add( parameter2 );
        parameters.add( parameter3 );
        parameters.add( parameter4 );
        parameters.add( parameter5 );
        parameters.add( parameter6 );

        List<String> mofIds = new ArrayList<String>( );
        mofIds.add( parameter1.refMofId( ) );
        mofIds.add( parameter2.refMofId( ) );
        mofIds.add( parameter3.refMofId( ) );
        mofIds.add( parameter4.refMofId( ) );
        mofIds.add( parameter5.refMofId( ) );
        mofIds.add( parameter6.refMofId( ) );

        Connection connection = getMOINConnection( );

        ModelPartition partition = getPartitionOne( );

        assertTrue( "Partition already contains elements", partition.getElements( ).isEmpty( ) );

        partition.assignElement( someMofPackage );
        partition.assignElement( parameter1 );
        partition.assignElement( parameter2 );
        partition.assignElement( parameter3 );
        partition.assignElement( parameter4 );
        partition.assignElement( parameter5 );
        partition.assignElement( parameter6 );

        connection.getNullPartition( ).deleteElements( );

        connection.save( );

        evictPartition( partition );

        // 
        parameters = someMofPackage.getContents( );
        List<String> mofIdsAfterSaveAndReload = new ArrayList<String>( );
        for ( Object object : parameters ) {
            RefObject refObject = (RefObject) object;
            mofIdsAfterSaveAndReload.add( refObject.refMofId( ) );
        }

        assertEquals( "Expected same elements after save and reload", mofIds, mofIdsAfterSaveAndReload );
    }

    @Test
    public void testMofOrderingAfterSave( ) throws Exception {

        Connection connection = getMOINConnection( );
        connection.getNullPartition( ).deleteElements( );
        OclPackage ocl = (OclPackage) connection.getPackage( null, "OCL" );
        OclConstraint oc = (OclConstraint) ocl.getAttaching( ).getOclConstraint( ).refCreateInstance( );
        OclExpression exp1 = (OclExpression) ocl.getExpressions( ).getStringLiteralExp( ).refCreateInstance( Arrays.asList( "name1", "TheString1" ) );
        OclExpression exp2 = (OclExpression) ocl.getExpressions( ).getStringLiteralExp( ).refCreateInstance( Arrays.asList( "name2", "TheString2" ) );
        List<String> mofIds = new ArrayList<String>( );
        oc.getViolationMessageExpression( ).add( exp1 );
        mofIds.add( exp1.refMofId( ) );
        oc.getViolationMessageExpression( ).add( exp2 );
        mofIds.add( exp2.refMofId( ) );

        ModelPartition partition = getPartitionOne( );

        assertTrue( "Partition already contains elements", partition.getElements( ).isEmpty( ) );

        partition.assignElement( oc );
        partition.assignElement( exp1 );
        partition.assignElement( exp2 );

        connection.save( );

        evictPartition( partition );

        // 
        List<OclExpression> expr = oc.getViolationMessageExpression( );
        List<String> mofIdsAfterSaveAndReload = new ArrayList<String>( );
        for ( Object object : expr ) {
            RefObject refObject = (RefObject) object;
            mofIdsAfterSaveAndReload.add( refObject.refMofId( ) );
        }

        assertEquals( "Expected same elements after save and reload", mofIds, mofIdsAfterSaveAndReload );
    }

    @Test
    public void testMofNamespaceOrderingAfterSave( ) throws Exception {

        ModelPackage mp = (ModelPackage) getMOINConnection( ).getPackage( null, TestMetaModels.MOIN_MOF_TPE_MODEL );
        MofPackage pkg = (MofPackage) mp.getMofPackage( ).refCreateInstance( );
        MofClass child1 = (MofClass) mp.getMofClass( ).refCreateInstance( );
        child1.setName( "class1" );
        MofClass child2 = (MofClass) mp.getMofClass( ).refCreateInstance( );
        child2.setName( "class2" );

        List<String> mofIds = new ArrayList<String>( );
        pkg.getContents( ).add( child1 );
        mofIds.add( child1.refMofId( ) );
        pkg.getContents( ).add( child2 );
        mofIds.add( child2.refMofId( ) );

        Connection connection = getMOINConnection( );

        ModelPartition partition = getPartitionOne( );

        assertTrue( "Partition already contains elements", partition.getElements( ).isEmpty( ) );

        partition.assignElementIncludingChildren( pkg );

        connection.getNullPartition( ).deleteElements( );

        connection.save( );

        evictPartition( partition );

        // 
        List<ModelElement> expr = pkg.getContents( );
        List<String> mofIdsAfterSaveAndReload = new ArrayList<String>( );
        for ( Object object : expr ) {
            RefObject refObject = (RefObject) object;
            mofIdsAfterSaveAndReload.add( refObject.refMofId( ) );
        }

        assertEquals( "Expected same elements after save and reload", mofIds, mofIdsAfterSaveAndReload );
    }

    @Test
    public void testLinkExists( ) throws Exception {

        Collection<Message> distributedTriggers = messageTriggersReply.getTriggers( message1 );
        assertTrue( distributedTriggers.isEmpty( ) );

        assertFalse( messageTriggersReply.exists( message1, message2 ) );
        assertFalse( messageTriggersReply.exists( message1, message3 ) );
        assertFalse( messageTriggersReply.exists( message1, message4 ) );
        assertFalse( messageTriggersReply.exists( message1, message5 ) );

        assertFalse( messageTriggersReply.refLinkExists( message1, message2 ) );
        assertFalse( messageTriggersReply.refLinkExists( message1, message3 ) );
        assertFalse( messageTriggersReply.refLinkExists( message1, message4 ) );
        assertFalse( messageTriggersReply.refLinkExists( message1, message5 ) );

        // must return false, not throwing an exception
        boolean result = messageTriggersReply.exists( null, null );
        assertFalse( result );

        // must return false, not throwing an exception
        result = messageTriggersReply.refLinkExists( null, null );
        assertFalse( result );

        distributedTriggers.add( message2 );
        distributedTriggers.add( message3 );
        distributedTriggers.add( message4 );
        distributedTriggers.add( message5 );

        Collection<Message> expectedTriggers = new ArrayList<Message>( );
        expectedTriggers.add( message2 );
        expectedTriggers.add( message3 );
        expectedTriggers.add( message4 );
        expectedTriggers.add( message5 );

        assertTrue( "Expected all messages to be contained", distributedTriggers.containsAll( expectedTriggers ) );

        assertTrue( messageTriggersReply.exists( message1, message2 ) );
        assertTrue( messageTriggersReply.exists( message1, message3 ) );
        assertTrue( messageTriggersReply.exists( message1, message4 ) );
        assertTrue( messageTriggersReply.exists( message1, message5 ) );

        assertTrue( messageTriggersReply.refLinkExists( message1, message2 ) );
        assertTrue( messageTriggersReply.refLinkExists( message1, message3 ) );
        assertTrue( messageTriggersReply.refLinkExists( message1, message4 ) );
        assertTrue( messageTriggersReply.refLinkExists( message1, message5 ) );

        assertFalse( messageTriggersReply.exists( message2, message1 ) );
        assertFalse( messageTriggersReply.exists( message3, message1 ) );
        assertFalse( messageTriggersReply.exists( message4, message1 ) );
        assertFalse( messageTriggersReply.exists( message5, message1 ) );

        assertFalse( messageTriggersReply.refLinkExists( message2, message1 ) );
        assertFalse( messageTriggersReply.refLinkExists( message3, message1 ) );
        assertFalse( messageTriggersReply.refLinkExists( message4, message1 ) );
        assertFalse( messageTriggersReply.refLinkExists( message5, message1 ) );
    }

    @Test
    public void testLinkDeletion( ) throws Exception {

        Collection<Message> distributedTriggers = messageTriggersReply.getTriggers( message1 );
        distributedTriggers.add( message2 );
        distributedTriggers.add( message3 );
        distributedTriggers.add( message4 );

        Collection<Message> expectedTriggers = new ArrayList<Message>( );
        expectedTriggers.add( message2 );
        expectedTriggers.add( message3 );
        expectedTriggers.add( message4 );

        assertTrue( "Expected all messages to be contained", distributedTriggers.containsAll( expectedTriggers ) );
        assertTrue( messageTriggersReply.exists( message1, message2 ) );
        assertTrue( messageTriggersReply.exists( message1, message3 ) );
        assertTrue( messageTriggersReply.exists( message1, message4 ) );
        assertFalse( messageTriggersReply.exists( message1, message5 ) );

        // Remove an existing association link
        boolean result = messageTriggersReply.refRemoveLink( message1, message3 );
        assertTrue( "Expected refRemoveLink to return other value", result );
        expectedTriggers.remove( message3 );

        assertTrue( "Expected all messages to be contained", distributedTriggers.containsAll( expectedTriggers ) );
        assertTrue( messageTriggersReply.exists( message1, message2 ) );
        assertFalse( messageTriggersReply.exists( message1, message3 ) );
        assertTrue( messageTriggersReply.exists( message1, message4 ) );
        assertFalse( messageTriggersReply.exists( message1, message5 ) );

        // Remove a non-existing association link which has never existed before
        result = messageTriggersReply.refRemoveLink( message1, message5 );
        assertFalse( "Expected refRemoveLink to return other value", result );
        assertTrue( "Expected all messages to be contained", distributedTriggers.containsAll( expectedTriggers ) );
        assertTrue( messageTriggersReply.exists( message1, message2 ) );
        assertFalse( messageTriggersReply.exists( message1, message3 ) );
        assertTrue( messageTriggersReply.exists( message1, message4 ) );
        assertFalse( messageTriggersReply.exists( message1, message5 ) );

        // Remove a non-existing association link which existed before
        result = messageTriggersReply.refRemoveLink( message1, message3 );
        assertFalse( "Expected refRemoveLink to return other value", result );
        assertTrue( "Expected all messages to be contained", distributedTriggers.containsAll( expectedTriggers ) );
        assertTrue( messageTriggersReply.exists( message1, message2 ) );
        assertFalse( messageTriggersReply.exists( message1, message3 ) );
        assertTrue( messageTriggersReply.exists( message1, message4 ) );
        assertFalse( messageTriggersReply.exists( message1, message5 ) );

        A1 a1 = getMOINConnection( ).createElementInPartition( A1.class, null );
        B1 b1_1 = getMOINConnection( ).createElementInPartition( B1.class, null );
        B1 b1_2 = getMOINConnection( ).createElementInPartition( B1.class, null );
        B1 b1_3 = getMOINConnection( ).createElementInPartition( B1.class, null );

        List<B1> jmiListOfBs = a1.getBs( );

        jmiListOfBs.add( b1_1 );
        jmiListOfBs.add( b1_2 );

        assertTrue( jmiListOfBs.contains( b1_1 ) );
        assertTrue( jmiListOfBs.contains( b1_2 ) );
        assertSame( 2, jmiListOfBs.size( ) );
        assertFalse( jmiListOfBs.contains( b1_3 ) );

        // Remove attribute link which exists
        jmiListOfBs.remove( b1_1 );

        assertFalse( jmiListOfBs.contains( b1_1 ) );
        assertTrue( jmiListOfBs.contains( b1_2 ) );
        assertSame( 1, jmiListOfBs.size( ) );
        assertFalse( jmiListOfBs.contains( b1_3 ) );

        // Remove a non-existing attribute link which has never existed before
        jmiListOfBs.remove( b1_3 );

        assertFalse( jmiListOfBs.contains( b1_1 ) );
        assertTrue( jmiListOfBs.contains( b1_2 ) );
        assertSame( 1, jmiListOfBs.size( ) );
        assertFalse( jmiListOfBs.contains( b1_3 ) );

        // Remove a non-existing attribute link which existed before
        jmiListOfBs.remove( b1_1 );

        assertFalse( jmiListOfBs.contains( b1_1 ) );
        assertTrue( jmiListOfBs.contains( b1_2 ) );
        assertSame( 1, jmiListOfBs.size( ) );
        assertFalse( jmiListOfBs.contains( b1_3 ) );

    }

    @Test
    public void testRemovalOfNonUniqueMultivaluedAttribute( ) throws Exception {

        A4 a4 = getMOINConnection( ).createElementInPartition( A4.class, null );
        B4 add = getMOINConnection( ).createElementInPartition( B4.class, null );

        Collection<B4> manyBs = a4.getManyBs( );
        manyBs.add( add );
        manyBs.add( add );

        // the same object must be included twice as it is non-unique
        assertSame( 2, manyBs.size( ) );
        Iterator<B4> manyBsIterator = manyBs.iterator( );
        assertEquals( add, manyBsIterator.next( ) );
        assertEquals( add, manyBsIterator.next( ) );
        assertFalse( manyBsIterator.hasNext( ) );

        // remove the object -> currently we only remove the first occurrence
        manyBs.remove( add );
        assertSame( 1, manyBs.size( ) );
        manyBsIterator = manyBs.iterator( );
        assertEquals( add, manyBsIterator.next( ) );
        assertFalse( manyBsIterator.hasNext( ) );

        // add it again, so that it is again contained two times
        manyBs.add( add );
        assertSame( 2, manyBs.size( ) );
        manyBsIterator = manyBs.iterator( );
        assertEquals( add, manyBsIterator.next( ) );
        assertEquals( add, manyBsIterator.next( ) );
        assertFalse( manyBsIterator.hasNext( ) );

        // now removeAll(), after that all elements must be removed
        manyBs.removeAll( Collections.singletonList( add ) );

        assertTrue( manyBs.isEmpty( ) );
        manyBsIterator = manyBs.iterator( );
        assertFalse( manyBsIterator.hasNext( ) );
    }

    @Test
    public void testDistributedToOneAssociation( ) throws Exception {

        B6 parent = createB6( );
        C6 child = createC6( );
        child.setX( parent );
        assertEquals( parent, child.getX( ) );
        ReferenceAtComponent referenceAtComponent = testcasesPackage.getCase006( ).getReferenceAtComponent( );
        C6 currentChild = referenceAtComponent.getY( parent );
        assertEquals( child, currentChild );

        for ( int i = 0; i < 1000; i++ ) {
            currentChild = referenceAtComponent.getY( parent );
            assertEquals( child, currentChild );
        }
    }

    @Test
    public void testMergingOfIntraAndCrossPartitionLinks( ) throws Exception {

        Connection connection = getMOINConnection( );
        ModelPartition partition = getPartitionOne( );
        ModelPartition partition2 = getPartitionTwo( );
        ModelPartition partition3 = getPartitionThree( );
        assertFalse( "Expected partition to be NOT dirty", partition2.isDirty( ) );
        assertFalse( "Expected partition to be NOT dirty", partition3.isDirty( ) );

        // make sure there are no other elements which are not needed in this
        // test
        connection.getNullPartition( ).deleteElements( );

        A16 a16_1 = getMOINConnection( ).createElementInPartition( A16.class, null );
        B16 b16_1 = getMOINConnection( ).createElementInPartition( B16.class, null );
        B16 b16_2 = getMOINConnection( ).createElementInPartition( B16.class, null );
        B16 b16_3 = getMOINConnection( ).createElementInPartition( B16.class, null );
        B16 b16_4 = getMOINConnection( ).createElementInPartition( B16.class, null );
        B16 b16_5 = getMOINConnection( ).createElementInPartition( B16.class, null );
        B16 b16_6 = getMOINConnection( ).createElementInPartition( B16.class, null );
        B16 b16_7 = getMOINConnection( ).createElementInPartition( B16.class, null );
        B16 b16_8 = getMOINConnection( ).createElementInPartition( B16.class, null );
        B16 b16_9 = getMOINConnection( ).createElementInPartition( B16.class, null );

        // assign to real partitions so it can be saved
        a16_1.assign___Partition( partition );
        b16_1.assign___Partition( partition );
        b16_2.assign___Partition( partition2 );
        b16_3.assign___Partition( partition3 );
        b16_4.assign___Partition( partition );
        b16_5.assign___Partition( partition2 );
        b16_6.assign___Partition( partition3 );
        b16_7.assign___Partition( partition );
        b16_8.assign___Partition( partition2 );
        b16_9.assign___Partition( partition3 );

        // establish the links
        Collection<B16> distributedBs = a16_1.getB( );
        assertTrue( distributedBs.isEmpty( ) );
        distributedBs.add( b16_1 );
        distributedBs.add( b16_2 );
        distributedBs.add( b16_3 );
        distributedBs.add( b16_4 );
        distributedBs.add( b16_5 );
        distributedBs.add( b16_6 );
        distributedBs.add( b16_7 );
        distributedBs.add( b16_8 );
        distributedBs.add( b16_9 );

        // remember the MRIs in order to compare later
        List<MRI> distributedBMrisBeforeSave = new ArrayList<MRI>( );
        for ( B16 b16 : distributedBs ) {
            distributedBMrisBeforeSave.add( ( (Partitionable) b16 ).get___Mri( ) );
        }

        // save it so that nothing is dirty anymore
        connection.save( );
        assertFalse( "Expected partition to be NOT dirty", partition.isDirty( ) );
        assertFalse( "Expected partition to be NOT dirty", partition2.isDirty( ) );
        assertFalse( "Expected partition to be NOT dirty", partition3.isDirty( ) );

        evictPartition( partition );
        evictPartition( partition2 );
        evictPartition( partition3 );

        // collect the MRIs after save
        List<MRI> distributedBMrisAfterSave = new ArrayList<MRI>( );
        for ( B16 b16 : distributedBs ) {
            distributedBMrisAfterSave.add( ( (Partitionable) b16 ).get___Mri( ) );
        }

        assertEquals( distributedBMrisBeforeSave, distributedBMrisAfterSave );

    }

    @Test
    public void testGetCompositeChildren( ) throws Exception {

        ModelPackage mofModelPackage = (ModelPackage) getMOINConnection( ).getPackage( TestMetaModels.MOIN_MOF_CN, TestMetaModels.MOIN_MOF_TPE_MODEL );

        // Create 3 packages
        MofPackage mofPackageTop = (MofPackage) mofModelPackage.getMofPackage( ).refCreateInstance( );
        MofPackage mofPackageMiddle = (MofPackage) mofModelPackage.getMofPackage( ).refCreateInstance( );
        MofPackage mofPackageBottom = (MofPackage) mofModelPackage.getMofPackage( ).refCreateInstance( );

        // Nest 3 packages in composition hierarchy
        mofPackageMiddle.setContainer( mofPackageTop );
        mofPackageBottom.setContainer( mofPackageMiddle );

        // Now retrieve composition via JmiHelper
        Collection<RefObject> children = getMOINConnection( ).getJmiHelper( ).getCompositeChildren( mofPackageTop, false );
        assertEquals( children.size( ), 1 );
        assertTrue( children.contains( mofPackageMiddle ) );

        // Now retrieve composition via JmiHelper
        children = getMOINConnection( ).getJmiHelper( ).getCompositeChildren( mofPackageTop, true );
        assertEquals( children.size( ), 2 );
        assertTrue( children.contains( mofPackageMiddle ) );
        assertTrue( children.contains( mofPackageBottom ) );

    }

    @Test
    public void testDistributedAutomaticLinkReplacement( ) throws Exception {

        A3 a3_1 = getPartitionOne( ).createElement( A3.class );
        B3 b3_1 = getPartitionOne( ).createElement( B3.class );
        B3 b3_2 = getPartitionOne( ).createElement( B3.class );

        b3_1.setZ( a3_1 );

        try {
            b3_2.setZ( a3_1 );
            fail( "Expected exception" );
        } catch ( WrongSizeException e ) {
            //must fail because link between b3_1 and a3_1 must not be automatically removed by creating a link starting at b3_2    
        }

        A10 a10_1 = getPartitionTwo( ).createElement( A10.class );
        A10 a10_2 = getPartitionTwo( ).createElement( A10.class );

        B10 b10_1 = getPartitionTwo( ).createElement( B10.class );
        B10 b10_2 = getPartitionTwo( ).createElement( B10.class );

        b10_1.setOneAchangeable( a10_1 );
        b10_2.setOneAchangeable( a10_1 );

        b10_2.setOneAchangeable( a10_2 );

        assertEquals( a10_2, b10_2.getOneAchangeable( ) );
        assertEquals( a10_1, b10_1.getOneAchangeable( ) );
        assertSame( 1, a10_1.getManyBsChangeable( ).size( ) );
        assertEquals( b10_1, a10_1.getManyBsChangeable( ).iterator( ).next( ) );
        assertSame( 1, a10_2.getManyBsChangeable( ).size( ) );
        assertEquals( b10_2, a10_2.getManyBsChangeable( ).iterator( ).next( ) );
    }

    @Test
    public void testLoadingObjectValuedAttributeLinksCrossPartition( ) throws Exception {

        A1 a1 = getMOINConnection( ).createElementInPartition( A1.class, null );
        B1 b1_1 = getMOINConnection( ).createElementInPartition( B1.class, null );
        B1 b1_2 = getMOINConnection( ).createElementInPartition( B1.class, null );
        B1 b1_3 = getMOINConnection( ).createElementInPartition( B1.class, null );

        List<B1> jmiListOfBs = a1.getBs( );

        jmiListOfBs.add( b1_1 );
        jmiListOfBs.add( b1_2 );
        jmiListOfBs.add( b1_3 );

        assertTrue( jmiListOfBs.contains( b1_1 ) );
        assertTrue( jmiListOfBs.contains( b1_2 ) );
        assertTrue( jmiListOfBs.contains( b1_3 ) );
        assertSame( 3, jmiListOfBs.size( ) );

        // assign the values to different partitions
        getPartitionOne( ).assignElement( a1 );
        getPartitionOne( ).assignElement( b1_1 );
        getPartitionTwo( ).assignElement( b1_2 );
        getPartitionThree( ).assignElement( b1_3 );

        byte[] partitionOneByteArray = getPartitionByteArray( getTestHelper( ).getCoreModelPartition( getPartitionOne( ) ) );

        _testClient2.setAsCurrentClient( );
        CoreModelPartition tempPartition = getTestHelper( ).getCoreModelPartition( _testClient2.getOrCreatePartition( "temporaryForTest" ) );
        readPartitionFromByteArray( partitionOneByteArray, tempPartition );
    }

    private byte[] getPartitionByteArray( CoreModelPartition cmp ) throws Exception {

        PartitionWriterImpl writer = new PartitionWriterImpl( );
        ByteArrayOutputStream os = new ByteArrayOutputStream( );

        writer.write( getTestHelper( ).getCoreConnection( getMOINConnection( ) ).getSession( ), os, cmp );

        byte[] byteArray = os.toByteArray( );
        return byteArray;
    }

    private void readPartitionFromByteArray( byte[] byteArray, CoreModelPartition partition ) throws Exception {

        PartitionReaderImpl reader = new PartitionReaderImpl( );
        reader.read( getTestHelper( ).getCoreConnection( getMOINConnection( ) ).getSession( ), new ByteArrayInputStream( byteArray ), partition );
    }

    @Test
    public void testGetAffectedPartitionsOfCompositeDeletion( ) throws Exception {

        ModelPackage mofModelPackage = (ModelPackage) getMOINConnection( ).getPackage( TestMetaModels.MOIN_MOF_CN, TestMetaModels.MOIN_MOF_TPE_MODEL );

        // Create 4 packages
        MofPackage mofPackageTop = (MofPackage) mofModelPackage.getMofPackage( ).refCreateInstance( );
        MofPackage mofPackageUpper = (MofPackage) mofModelPackage.getMofPackage( ).refCreateInstance( );
        MofPackage mofPackageLower = (MofPackage) mofModelPackage.getMofPackage( ).refCreateInstance( );
        MofPackage mofPackageBottom = (MofPackage) mofModelPackage.getMofPackage( ).refCreateInstance( );

        // Nest 4 packages in composition hierarchy
        mofPackageUpper.setContainer( mofPackageTop );
        mofPackageLower.setContainer( mofPackageUpper );
        mofPackageBottom.setContainer( mofPackageLower );

        // Create tag and attach to one package
        Tag tag = (Tag) mofModelPackage.getTag( ).refCreateInstance( );
        tag.getElements( ).add( mofPackageUpper );

        // put 4 packages in 3 partitions
        getPartitionOne( ).assignElement( mofPackageTop );
        getPartitionTwo( ).assignElement( mofPackageUpper );
        getPartitionTwo( ).assignElement( mofPackageLower );
        getPartitionThree( ).assignElement( mofPackageBottom );

        // Put tag in other partition
        ModelPartition partition4 = this._testClient1.getOrCreatePartition( "Partition4" );
        partition4.assignElement( tag );

        // Now check the affected partitions
        // Although the top element has not been deleted, its partition should
        // also be dirty,
        // because the link has double storage.
        Collection<PRI> pris = getMOINConnection( ).getJmiHelper( ).getAffectedPartitionsForRefDelete( mofPackageUpper );
        assertSame( 4, pris.size( ) );
        assertTrue( pris.contains( ( (Partitionable) mofPackageTop ).get___Mri( ).getPri( ) ) );
        assertTrue( pris.contains( ( (Partitionable) mofPackageUpper ).get___Mri( ).getPri( ) ) );
        assertTrue( pris.contains( ( (Partitionable) mofPackageLower ).get___Mri( ).getPri( ) ) );
        assertTrue( pris.contains( ( (Partitionable) mofPackageBottom ).get___Mri( ).getPri( ) ) );
        assertTrue( pris.contains( ( (Partitionable) tag ).get___Mri( ).getPri( ) ) );

        // Now retrieve composition via JmiHelper
        Collection<RefObject> children = getMOINConnection( ).getJmiHelper( ).getCompositeChildren( mofPackageTop, true );
        assertEquals( 3, children.size( ) );
    }

    @Test
    public void testLinkToMetamodelElement( ) throws Exception {

        ModelPackage mofModelPackage = (ModelPackage) getMOINConnection( ).getPackage( TestMetaModels.MOIN_MOF_CN, TestMetaModels.MOIN_MOF_TPE_MODEL );
        AttachesTo at = mofModelPackage.getAttachesTo( );
        RefClass tagClass = mofModelPackage.getTag( );
        Tag artificialTag = (Tag) tagClass.refCreateInstance( );
        this.getPartitionOne( ).assignElement( artificialTag );
        artificialTag.setTagId( "ArtificialTag" );
        Namespace ns = mofModelPackage.refMetaObject( );
        assertTrue( ( (Partitionable) ns ).get___Partition( ).getPri( ).isMetaModelPartition( ) );
        at.add( ns, artificialTag );
        Collection<Tag> tags = at.getTag( ns );
        assertTrue( tags.contains( artificialTag ) );
    }

    @Test
    public void testGetAffectedPartitionsOfCompositeDeletionWithCompositeParent( ) throws Exception {

        ModelPackage mofModelPackage = (ModelPackage) getMOINConnection( ).getPackage( TestMetaModels.MOIN_MOF_CN, TestMetaModels.MOIN_MOF_TPE_MODEL );

        // Create 4 packages
        MofPackage mofPackageTop = (MofPackage) mofModelPackage.getMofPackage( ).refCreateInstance( );
        MofPackage mofPackageUpper = (MofPackage) mofModelPackage.getMofPackage( ).refCreateInstance( );
        MofPackage mofPackageLower = (MofPackage) mofModelPackage.getMofPackage( ).refCreateInstance( );
        MofPackage mofPackageBottom = (MofPackage) mofModelPackage.getMofPackage( ).refCreateInstance( );

        // Nest 4 packages in composition hierarchy
        mofPackageUpper.setContainer( mofPackageTop );
        mofPackageLower.setContainer( mofPackageUpper );
        mofPackageBottom.setContainer( mofPackageLower );

        // Create tag and attach to one package
        Tag tag = (Tag) mofModelPackage.getTag( ).refCreateInstance( );
        tag.getElements( ).add( mofPackageUpper );

        // put 4 packages in 3 partitions
        getPartitionOne( ).assignElement( mofPackageTop );
        getPartitionTwo( ).assignElement( mofPackageUpper );
        getPartitionTwo( ).assignElement( mofPackageLower );
        getPartitionThree( ).assignElement( mofPackageBottom );

        // Put tag in other partition
        ModelPartition partition4 = this._testClient1.getOrCreatePartition( "Partition4" );
        partition4.assignElement( tag );

        // Now check the affected partitions
        Collection<PRI> pris = getMOINConnection( ).getJmiHelper( ).getAffectedPartitionsForRefDelete( mofPackageTop );
        assertEquals( pris.size( ), 4 );
        assertTrue( pris.contains( ( (Partitionable) mofPackageTop ).get___Mri( ).getPri( ) ) );
        assertTrue( pris.contains( ( (Partitionable) mofPackageUpper ).get___Mri( ).getPri( ) ) );
        assertTrue( pris.contains( ( (Partitionable) mofPackageLower ).get___Mri( ).getPri( ) ) );
        assertTrue( pris.contains( ( (Partitionable) mofPackageBottom ).get___Mri( ).getPri( ) ) );
        assertTrue( pris.contains( ( (Partitionable) tag ).get___Mri( ).getPri( ) ) );

        // Now retrieve composition via JmiHelper
        Collection<RefObject> children = getMOINConnection( ).getJmiHelper( ).getCompositeChildren( mofPackageTop, true );
        assertEquals( children.size( ), 3 );
    }

    @Test
    public void testGetAffectedPartitionsOfCompositeDeletionWithRootObjectsOnly( ) throws Exception {

        ModelPackage mofModelPackage = (ModelPackage) getMOINConnection( ).getPackage( TestMetaModels.MOIN_MOF_CN, TestMetaModels.MOIN_MOF_TPE_MODEL );

        // Create 1 package
        MofPackage mofPackageTop = (MofPackage) mofModelPackage.getMofPackage( ).refCreateInstance( );

        // put 1 packages in 1 partitions
        getPartitionOne( ).assignElement( mofPackageTop );

        // Now check the affected partitions
        Collection<PRI> pris = getMOINConnection( ).getJmiHelper( ).getAffectedPartitionsForRefDelete( mofPackageTop );
        assertEquals( pris.size( ), 1 );

        // Now retrieve composition via JmiHelper
        Collection<RefObject> children = getMOINConnection( ).getJmiHelper( ).getCompositeChildren( mofPackageTop, true );
        assertEquals( children.size( ), 0 );
    }

    @Test
    public void testGetAffectedPartitionsForLinksWithStorageAtOtherEnd( ) throws Exception {

        MofPackage mofPackage = getPartitionOne( ).createElement( MofPackage.class );
        Collection<PRI> affectedPartitionsForRefDelete = getMOINConnection( ).getJmiHelper( ).getAffectedPartitionsForRefDelete( mofPackage );
        assertEquals( 1, affectedPartitionsForRefDelete.size( ) );
        assertTrue( affectedPartitionsForRefDelete.contains( getPartitionOne( ).getPri( ) ) );

        // Create tag in other partition and attach to one package
        Tag tag = getPartitionTwo( ).createElement( Tag.class );
        tag.getElements( ).add( mofPackage );

        affectedPartitionsForRefDelete = getMOINConnection( ).getJmiHelper( ).getAffectedPartitionsForRefDelete( mofPackage );
        assertEquals( 2, affectedPartitionsForRefDelete.size( ) );
        assertTrue( affectedPartitionsForRefDelete.contains( getPartitionOne( ).getPri( ) ) );
        assertTrue( affectedPartitionsForRefDelete.contains( getPartitionTwo( ).getPri( ) ) );

    }

    @Test
    public void testCreateDangLink( ) throws Exception {

        final Connection conn = getMOINConnection( );
        final CoreConnection coreConn = getTestHelper( ).getCoreConnection( getMOINConnection( ) );

        // Create "host" element (which stores the link)
        final MofClass mc = conn.createElementInPartition( MofClass.class, getPartitionOne( ) );

        // Create calculated LRI for contained Attribute
        RefClass attributeClass = conn.getClass( Attribute.CLASS_DESCRIPTOR );
        RefClassCalculatedMofId attributeClassCalc = (RefClassCalculatedMofId) attributeClass;
        String[] logicalKey = new String[] { "Zum Core", "No way out" };
        String calculatedMofId = attributeClassCalc.calculateMofId( logicalKey );
        String calculatedMofId2 = attributeClassCalc.calculateMofId( new String[] { "Zum Core2", "No way out2" } );
        String calculatedMofId3 = attributeClassCalc.calculateMofId( new String[] { "Zum Core3", "No way out3" } );
        DataAreaDescriptor dataAreaDescriptor = ( (Partitionable) mc ).get___Mri( ).getDataAreaDescriptor( );
        String facilityId = dataAreaDescriptor.getFacilityId( );
        final LRI lri = conn.getSession( ).getMoin( ).createLri( facilityId, dataAreaDescriptor.getDataAreaName( ), calculatedMofId );
        final LRI lri2 = conn.getSession( ).getMoin( ).createLri( facilityId, dataAreaDescriptor.getDataAreaName( ), calculatedMofId2 );
        final LRI lri3 = conn.getSession( ).getMoin( ).createLri( facilityId, dataAreaDescriptor.getDataAreaName( ), calculatedMofId3 );
        // Check if inconsistency stuff reports no dangling links
        List<DanglingLinkConsistencyViolation> danglingLinksOfPartition = coreConn.getConsistencyViolationRegistry( ).checkDanglingLinksOfPartition( getPartitionOne( ).getPri( ) );
        assertTrue( danglingLinksOfPartition.size( ) == 0 );

        // Create danglink with LRI
        Association containsAssoc = conn.getAssociation( Contains.ASSOCIATION_DESCRIPTOR ).refMetaObject( );
        final AssociationEnd containedEnd = conn.getJmiHelper( ).getAssociationEnds( containsAssoc ).get( 1 );

        final RefObjectUtil refObjectUtil = UtilitiesFactory.getRefObjectUtil( );

        try {
            refObjectUtil.addLinkTarget( mc, containedEnd, lri, 4711 );
            fail( "Expected exception" );
        } catch ( IndexOutOfBoundsException e ) {
            //expected
        }

        try {
            refObjectUtil.addLinkTarget( mc, containedEnd, lri, 1 );
            fail( "Expected exception" );
        } catch ( IndexOutOfBoundsException e ) {
            //expected
        }

        try {
            refObjectUtil.addLinkTarget( mc, containedEnd, lri, -2 );
            fail( "Expected exception" );
        } catch ( IndexOutOfBoundsException e ) {
            //expected
        }

        Command command = new TestCommand( this.getMOINConnection( ) ) {

            @Override
            public void doExecute( ) {

                refObjectUtil.addLinkTarget( mc, containedEnd, lri, -1 );
            }

        };

        DoUndoRedoTestAsserter asserter = new EmptyAsserter( ) {

            @Override
            public void assertExpectedPreEventsAfterDo( List<? extends ChangeEvent> receivedEvents ) {

                assertEquals( 1, receivedEvents.size( ) );
                assertTrue( receivedEvents.get( 0 ) instanceof LinkAddEvent );
                LinkAddEvent event = (LinkAddEvent) receivedEvents.get( 0 );
                // First link end must be the host element
                assertEquals( ( (Partitionable) mc ).get___Mri( ), event.getFirstLinkEndMri( ) );
                // Second link end must be null, because we have a dangling link
                assertNull( event.getSecondLinkEndMri( ) );
                // The dangling link end must be available via its LRI
                assertEquals( lri, event.getNonStoredLinkEndLri( ) );

            }

            @Override
            public void assertExpectedPreEventsAfterUndo( List<? extends ChangeEvent> receivedEvents ) {

                assertEquals( 1, receivedEvents.size( ) );
                assertTrue( receivedEvents.get( 0 ) instanceof LinkRemoveEvent );
                LinkRemoveEvent event = (LinkRemoveEvent) receivedEvents.get( 0 );
                // First link end must be the host element
                assertEquals( ( (Partitionable) mc ).get___Mri( ), event.getFirstLinkEndMri( ) );
                // Second link end must be null, because we have a dangling link
                assertNull( event.getSecondLinkEndMri( ) );
                // The dangling link end must be available via its LRI
                assertEquals( lri, event.getNonStoredLinkEndLri( ) );
            }

            @Override
            public void assertAfterDo( ) {

                // Check if inconsistency stuff reports a dangling link
                List<DanglingLinkConsistencyViolation> danglingLinksOfPartition = coreConn.getConsistencyViolationRegistry( ).checkDanglingLinksOfPartition( getPartitionOne( ).getPri( ) );
                assertEquals( 1, danglingLinksOfPartition.size( ) );
                assertEquals( 1, mc.getContents( ).size( ) );
                assertNull( mc.getContents( ).iterator( ).next( ) );
            }

            @Override
            public void assertAfterUndo( ) {

                // Check if inconsistency stuff reports a dangling link
                List<DanglingLinkConsistencyViolation> danglingLinksOfPartition = coreConn.getConsistencyViolationRegistry( ).checkDanglingLinksOfPartition( getPartitionOne( ).getPri( ) );
                assertEquals( 0, danglingLinksOfPartition.size( ) );
                assertEquals( 0, mc.getContents( ).size( ) );
            }

        };

        this.runDoUndoRedoTest( this.getMOINConnection( ), command, asserter );

        command = new TestCommand( this.getMOINConnection( ) ) {

            @Override
            public void doExecute( ) {

                refObjectUtil.addLinkTarget( mc, containedEnd, lri2, 1 );
            }

        };

        asserter = new EmptyAsserter( ) {

            @Override
            public void assertAfterDo( ) {

                // Check if inconsistency stuff reports a dangling link
                List<DanglingLinkConsistencyViolation> danglingLinksOfPartition = coreConn.getConsistencyViolationRegistry( ).checkDanglingLinksOfPartition( getPartitionOne( ).getPri( ) );
                assertEquals( 2, danglingLinksOfPartition.size( ) );
                assertEquals( 2, mc.getContents( ).size( ) );
                Iterator<ModelElement> iterator = mc.getContents( ).iterator( );
                assertNull( iterator.next( ) );
                assertNull( iterator.next( ) );

            }

            @Override
            public void assertAfterUndo( ) {

                // Check if inconsistency stuff reports a dangling link
                List<DanglingLinkConsistencyViolation> danglingLinksOfPartition = coreConn.getConsistencyViolationRegistry( ).checkDanglingLinksOfPartition( getPartitionOne( ).getPri( ) );
                assertEquals( 1, danglingLinksOfPartition.size( ) );
                assertEquals( 1, mc.getContents( ).size( ) );
                assertNull( mc.getContents( ).iterator( ).next( ) );
            }

        };

        this.runDoUndoRedoTest( this.getMOINConnection( ), command, asserter );

        command = new TestCommand( this.getMOINConnection( ) ) {

            @Override
            public void doExecute( ) {

                refObjectUtil.addLinkTarget( mc, containedEnd, lri3, 0 );
            }
        };

        asserter = new EmptyAsserter( ) {

            @Override
            public void assertAfterDo( ) {

                // Check if inconsistency stuff reports a dangling link
                List<DanglingLinkConsistencyViolation> danglingLinksOfPartition = coreConn.getConsistencyViolationRegistry( ).checkDanglingLinksOfPartition( getPartitionOne( ).getPri( ) );
                assertEquals( 3, danglingLinksOfPartition.size( ) );
                assertEquals( 3, mc.getContents( ).size( ) );
                Iterator<ModelElement> iterator = mc.getContents( ).iterator( );
                assertNull( iterator.next( ) );
                assertNull( iterator.next( ) );
                assertNull( iterator.next( ) );

                byte fromEnd = coreConn.getSession( ).getWorkspaceSet( ).getMoin( ).getJmiHelper( ).getAssociationEndNumber( coreConn.getSession( ), ( (AssociationEndInternal) getTestHelper( ).getCoreRefObject( containedEnd ) ).otherEnd( coreConn ) );
                Association association = (Association) ( (RefObjectImpl) getTestHelper( ).getCoreRefObject( containedEnd ) ).refImmediateComposite( coreConn.getSession( ) );
                CorePartitionable hostPartitionable = getTestHelper( ).getCorePartitionable( mc );
                MemoryLinkManager linkManager = hostPartitionable.get___Workspace( ).getMemoryLinkManager( );
                Collection<EndStorageLink> linksForEndAndMetaObject = linkManager.getLinksForEndAndMetaObject( coreConn.getSession( ), coreConn.getSession( ).getWorkspaceSet( ).getEndAndMetaObjectPool( ).getEndAndMetaObject( fromEnd, association ), hostPartitionable );
                assertEquals( 3, linksForEndAndMetaObject.size( ) );
                Iterator<EndStorageLink> linkIterator = linksForEndAndMetaObject.iterator( );
                for ( int i = 0; i < 3; i++ ) {
                    EndStorageLink link = linkIterator.next( );
                    LRI otherEndLri = link.getOtherEnd( ).getLri( );
                    LRI expectedLri = null;
                    if ( i == 0 ) {
                        expectedLri = lri3;
                    }
                    if ( i == 1 ) {
                        expectedLri = lri;
                    }

                    if ( i == 2 ) {
                        expectedLri = lri2;
                    }

                    assertEquals( expectedLri, otherEndLri );

                }
            }

            @Override
            public void assertAfterUndo( ) {

                // Check if inconsistency stuff reports a dangling link
                List<DanglingLinkConsistencyViolation> danglingLinksOfPartition = coreConn.getConsistencyViolationRegistry( ).checkDanglingLinksOfPartition( getPartitionOne( ).getPri( ) );
                assertEquals( 2, danglingLinksOfPartition.size( ) );
                assertEquals( 2, mc.getContents( ).size( ) );
                Iterator<ModelElement> iterator = mc.getContents( ).iterator( );
                assertNull( iterator.next( ) );
                assertNull( iterator.next( ) );

                byte fromEnd = coreConn.getSession( ).getWorkspaceSet( ).getMoin( ).getJmiHelper( ).getAssociationEndNumber( coreConn.getSession( ), ( (AssociationEndInternal) getTestHelper( ).getCoreRefObject( containedEnd ) ).otherEnd( coreConn ) );
                Association association = (Association) ( (RefObjectImpl) getTestHelper( ).getCoreRefObject( containedEnd ) ).refImmediateComposite( coreConn.getSession( ) );
                CorePartitionable hostPartitionable = getTestHelper( ).getCorePartitionable( mc );
                MemoryLinkManager linkManager = hostPartitionable.get___Workspace( ).getMemoryLinkManager( );
                Collection<EndStorageLink> linksForEndAndMetaObject = linkManager.getLinksForEndAndMetaObject( coreConn.getSession( ), coreConn.getSession( ).getWorkspaceSet( ).getEndAndMetaObjectPool( ).getEndAndMetaObject( fromEnd, association ), hostPartitionable );
                assertEquals( 2, linksForEndAndMetaObject.size( ) );
                Iterator<EndStorageLink> linkIterator = linksForEndAndMetaObject.iterator( );
                for ( int i = 0; i < 2; i++ ) {
                    EndStorageLink link = linkIterator.next( );
                    LRI otherEndLri = link.getOtherEnd( ).getLri( );
                    LRI expectedLri = null;
                    if ( i == 0 ) {
                        expectedLri = lri;
                    }
                    if ( i == 1 ) {
                        expectedLri = lri2;
                    }

                    assertEquals( expectedLri, otherEndLri );
                }
            }

        };

        this.runDoUndoRedoTest( this.getMOINConnection( ), command, asserter );

        EmptyAsserter noChangeAsserter = new EmptyAsserter( ) {

            @Override
            public void assertAfterDo( ) {

                // Check if inconsistency stuff reports a dangling link
                List<DanglingLinkConsistencyViolation> danglingLinksOfPartition = coreConn.getConsistencyViolationRegistry( ).checkDanglingLinksOfPartition( getPartitionOne( ).getPri( ) );
                assertEquals( 3, danglingLinksOfPartition.size( ) );
                assertEquals( 3, mc.getContents( ).size( ) );
                Iterator<ModelElement> iterator = mc.getContents( ).iterator( );
                assertNull( iterator.next( ) );
                assertNull( iterator.next( ) );
                assertNull( iterator.next( ) );

            }

            @Override
            public void assertAfterUndo( ) {

                //nothing should have been changed by do, therefore same assertions as after do
                assertAfterDo( );
            }

        };

        //repeated doing must work without any noticeable effects
        this.runDoUndoRedoTest( this.getMOINConnection( ), command, noChangeAsserter );
        this.runDoUndoRedoTest( this.getMOINConnection( ), command, noChangeAsserter );
        this.runDoUndoRedoTest( this.getMOINConnection( ), command, noChangeAsserter );

        try {
            refObjectUtil.addLinkTarget( null, containedEnd, lri, -1 );
            fail( "Expected exception" );
        } catch ( IllegalArgumentException e ) {
            //expected
        }
        try {
            refObjectUtil.addLinkTarget( mc, null, lri, -1 );
            fail( "Expected exception" );
        } catch ( IllegalArgumentException e ) {
            //expected
        }

        try {
            refObjectUtil.addLinkTarget( mc, containedEnd, null, -1 );
            fail( "Expected exception" );
        } catch ( IllegalArgumentException e ) {
            //expected
        }

        Association isOfTypeAssoc = conn.getAssociation( IsOfType.ASSOCIATION_DESCRIPTOR ).refMetaObject( );
        AssociationEnd typedElements = conn.getJmiHelper( ).getAssociationEnds( isOfTypeAssoc ).get( 1 );
        try {
            refObjectUtil.addLinkTarget( mc, typedElements, lri, -1 );
            fail( "Expected exception because storage is on wrong side" );
        } catch ( IllegalArgumentException e ) {
            //expected
        }

        final Association refersToAssoc = conn.getAssociation( RefersTo.ASSOCIATION_DESCRIPTOR ).refMetaObject( );
        final AssociationEnd referencedEnd = conn.getJmiHelper( ).getAssociationEnds( refersToAssoc ).get( 1 );

        try {
            refObjectUtil.addLinkTarget( mc, referencedEnd, lri );
            fail( "Expected exception" );
        } catch ( TypeMismatchException e ) {
            //expected
        }

        Association attachesTo = conn.getAssociation( AttachesTo.ASSOCIATION_DESCRIPTOR ).refMetaObject( );
        final AssociationEnd modelElementAssocEnd = conn.getJmiHelper( ).getAssociationEnds( attachesTo ).get( 0 );
        final Tag myTag = getPartitionTwo( ).createElement( Tag.class );
        List<DanglingLinkConsistencyViolation> danglingLinksOfPartition2 = coreConn.getConsistencyViolationRegistry( ).checkDanglingLinksOfPartition( getPartitionTwo( ).getPri( ) );
        assertTrue( danglingLinksOfPartition2.size( ) == 0 );

        try {
            refObjectUtil.addLinkTarget( myTag, modelElementAssocEnd, lri, -2 );
            fail( "Expected exception" );
        } catch ( IllegalArgumentException e ) {
            //expected
        }

        try {
            refObjectUtil.addLinkTarget( myTag, modelElementAssocEnd, lri, 0 );
            fail( "Expected exception" );
        } catch ( IllegalArgumentException e ) {
            //expected
        }

        command = new TestCommand( this.getMOINConnection( ) ) {

            @Override
            public void doExecute( ) {

                refObjectUtil.addLinkTarget( myTag, modelElementAssocEnd, lri, -1 );
            }

        };

        asserter = new EmptyAsserter( ) {

            @Override
            public void assertAfterDo( ) {

                // Check if inconsistency stuff reports a dangling link
                List<DanglingLinkConsistencyViolation> danglingLinksOfPartition = coreConn.getConsistencyViolationRegistry( ).checkDanglingLinksOfPartition( getPartitionTwo( ).getPri( ) );
                assertEquals( 1, danglingLinksOfPartition.size( ) );
                assertEquals( 1, myTag.getElements( ).size( ) );
                assertNull( myTag.getElements( ).iterator( ).next( ) );
            }

            @Override
            public void assertAfterUndo( ) {

                // Check if inconsistency stuff reports a dangling link
                List<DanglingLinkConsistencyViolation> danglingLinksOfPartition = coreConn.getConsistencyViolationRegistry( ).checkDanglingLinksOfPartition( getPartitionTwo( ).getPri( ) );
                assertEquals( 0, danglingLinksOfPartition.size( ) );
                assertEquals( 0, myTag.getElements( ).size( ) );
            }

        };

        this.runDoUndoRedoTest( this.getMOINConnection( ), command, asserter );

        //create an element a danglink points to -> consistency registry must no longer report dangling link
        ConsistencyViolationRegistryImpl consistencyViolationRegistry = (ConsistencyViolationRegistryImpl) coreConn.getConsistencyViolationRegistry( );
        assertEquals( 3, consistencyViolationRegistry.checkDanglingLinksOfPartition( getPartitionOne( ).getPri( ) ).size( ) );
        attributeClassCalc.refCreateInstanceInPartition( getPartitionOne( ), logicalKey );
        assertEquals( 2, consistencyViolationRegistry.checkDanglingLinksOfPartition( getPartitionOne( ).getPri( ) ).size( ) );

        // add "dangling" link which is not really dangling -> must not be reported as dangling 
        final Reference myReference = getPartitionThree( ).createElement( Reference.class );
        final AssociationEnd myReferencedEnd = getPartitionThree( ).createElement( AssociationEnd.class );
        final LRI myReferencedEndLri = ( (Partitionable) myReferencedEnd ).get___Mri( ).getLri( );
        assertNull( myReference.getReferencedEnd( ) );
        List<DanglingLinkConsistencyViolation> danglingLinksOfPartition3 = coreConn.getConsistencyViolationRegistry( ).checkDanglingLinksOfPartition( getPartitionThree( ).getPri( ) );
        assertTrue( danglingLinksOfPartition3.size( ) == 0 );
        command = new TestCommand( this.getMOINConnection( ) ) {

            @Override
            public void doExecute( ) {

                refObjectUtil.addLinkTarget( myReference, referencedEnd, myReferencedEndLri );
            }

        };

        asserter = new EmptyAsserter( ) {

            @Override
            public void assertAfterDo( ) {

                //no inconsistency must be reported as the link is not really dangling
                List<DanglingLinkConsistencyViolation> danglingLinksOfPartition = coreConn.getConsistencyViolationRegistry( ).checkDanglingLinksOfPartition( getPartitionThree( ).getPri( ) );
                assertEquals( 0, danglingLinksOfPartition.size( ) );
                assertEquals( myReferencedEnd, myReference.getReferencedEnd( ) );

            }

            @Override
            public void assertAfterUndo( ) {

                List<DanglingLinkConsistencyViolation> danglingLinksOfPartition = coreConn.getConsistencyViolationRegistry( ).checkDanglingLinksOfPartition( getPartitionThree( ).getPri( ) );
                assertEquals( 0, danglingLinksOfPartition.size( ) );
                assertNull( myReference.getReferencedEnd( ) );
            }

        };

        this.runDoUndoRedoTest( this.getMOINConnection( ), command, asserter );

        //use to-1 association (RefersTo) -> try to add a dangling link to an already existing dangling link -> exception, no replacement logic 
        myReference.setReferencedEnd( myReferencedEnd );
        assertEquals( myReferencedEnd, myReference.getReferencedEnd( ) );
        danglingLinksOfPartition3 = coreConn.getConsistencyViolationRegistry( ).checkDanglingLinksOfPartition( getPartitionThree( ).getPri( ) );
        assertTrue( danglingLinksOfPartition3.size( ) == 0 );

        try {
            refObjectUtil.addLinkTarget( myReference, referencedEnd, lri2, -1 );
            fail( "Expected exception" );
        } catch ( WrongSizeException e ) {
            //expected
        }
        assertEquals( myReferencedEnd, myReference.getReferencedEnd( ) );
        danglingLinksOfPartition3 = coreConn.getConsistencyViolationRegistry( ).checkDanglingLinksOfPartition( getPartitionThree( ).getPri( ) );
        assertTrue( danglingLinksOfPartition3.size( ) == 0 );

        //try wrong type of target element that is existing and loaded)
        myReference.setReferencedEnd( null );
        assertNull( myReference.getReferencedEnd( ) );
        assertTrue( ( (Partitionable) mc ).is___Alive( ) );
        try {
            refObjectUtil.addLinkTarget( myReference, referencedEnd, ( (Partitionable) mc ).get___Mri( ).getLri( ), -1 );
            fail( "Expected exception" );
        } catch ( TypeMismatchException e ) {
            //expected
        }

        assertNull( myReference.getReferencedEnd( ) );

    }

    @Test
    public void testNoCompositeLinksToMetamodel( ) {

        Connection connection = getMOINConnection( );
        ModelPartition partition = getPartitionOne( );

        //get element from metamodel data area
        ModelPackage modelPackage = connection.getPackage( ModelPackage.PACKAGE_DESCRIPTOR );
        MofPackage elementFromMetamodelDataArea = modelPackage.refMetaObject( );
        assertTrue( "Expected metamodel data area", elementFromMetamodelDataArea.get___Mri( ).getDataAreaDescriptor( ).isMetamodelDataArea( ) );
        assertNull( elementFromMetamodelDataArea.refImmediateComposite( ) ); //must not have a composite parent because otherwise we can't link it with the Contains association

        //CASE 1: add attribute/association link on instance creation (InstanceCreateMT)
        try {

            A26 a26InitializedWithLinksOnCreation = connection.createElementInPartition( A26.class, partition );
            a26InitializedWithLinksOnCreation.setReflectToOne( elementFromMetamodelDataArea );
            fail( "Expected Exception" );
        } catch ( IllegalLinkException e ) {
            //expected Exception
        }

        try {
            List<RefObject> list = new ArrayList<RefObject>( );
            list.add( elementFromMetamodelDataArea );
            A26 a26InitializedWithLinksOnCreation = connection.createElementInPartition( A26.class, partition );
            a26InitializedWithLinksOnCreation.getReflectToMany( ).addAll( list );
            fail( "Expected Exception" );
        } catch ( IllegalLinkException e ) {
            //expected Exception
        }

        //CASE 2: add association link (LinkAddElementMT)
        //create element in non-metamodel data area
        MofPackage myCreatedMofPackage = partition.createElement( MofPackage.class );
        assertFalse( "Expected non-metamodel data area", ( (Partitionable) myCreatedMofPackage ).get___Mri( ).getDataAreaDescriptor( ).isMetamodelDataArea( ) );
        assertEquals( 0, myCreatedMofPackage.getContents( ).size( ) );
        //try to establish the composite link to deployed metamodel element
        try {
            myCreatedMofPackage.getContents( ).add( elementFromMetamodelDataArea );
            fail( "Expected Exception" );
        } catch ( IllegalLinkException e ) {
            //expected exception
            //make sure the link was really not established
            assertEquals( 0, myCreatedMofPackage.getContents( ).size( ) );
        }

        //CASE 3: add attribute link (ObjectAttributeAddElementMT)
        //create element in non-metamodel data area
        A26 a26_1 = partition.createElement( A26.class );
        //try to establish the composite link to deployed metamodel element
        try {
            a26_1.getReflectToMany( ).add( elementFromMetamodelDataArea );
            fail( "Expected Exception" );
        } catch ( IllegalLinkException e ) {
            //expected exception
            //make sure the link was really not established
            assertEquals( 0, a26_1.getReflectToMany( ).size( ) );
        }

        //CASE 4: set association link (LinkSetElementMT)
        MofPackage myContainedPackage = partition.createElement( MofPackage.class );
        assertEquals( 0, myCreatedMofPackage.getContents( ).size( ) );
        myCreatedMofPackage.getContents( ).add( myContainedPackage );
        assertEquals( 1, myCreatedMofPackage.getContents( ).size( ) );
        assertEquals( myContainedPackage, myCreatedMofPackage.getContents( ).get( 0 ) );
        try {
            myCreatedMofPackage.getContents( ).set( 0, elementFromMetamodelDataArea );
            fail( "Expected exception" );
        } catch ( IllegalLinkException e ) {
            //expected exception
            //make sure link was really not set
            assertEquals( 1, myCreatedMofPackage.getContents( ).size( ) );
            assertEquals( myContainedPackage, myCreatedMofPackage.getContents( ).get( 0 ) );
        }

        //CASE 5: set attribute link (ObjectAttributeSetElementMT)
        A26 a26_2 = partition.createElement( A26.class );
        MofPackage someContainedMofPackage = partition.createElement( MofPackage.class );
        assertEquals( 0, a26_2.getReflectToMany( ).size( ) );
        a26_2.getReflectToMany( ).add( someContainedMofPackage );
        assertEquals( 1, a26_2.getReflectToMany( ).size( ) );
        assertEquals( someContainedMofPackage, a26_2.getReflectToMany( ).get( 0 ) );
        //try to establish the composite link to deployed metamodel element
        try {
            a26_2.getReflectToMany( ).set( 0, elementFromMetamodelDataArea );
            fail( "Expected Exception" );
        } catch ( IllegalLinkException e ) {
            //expected exception
            //make sure the link was really not established
            assertEquals( 1, a26_2.getReflectToMany( ).size( ) );
            assertEquals( someContainedMofPackage, a26_2.getReflectToMany( ).get( 0 ) );
        }

        //CASE 6: change association link via reference (ReferenceChangeMT)
        MofPackage createdParentMofPackage = partition.createElement( MofPackage.class );
        //must not have container as we want to set it now
        assertNull( elementFromMetamodelDataArea.getContainer( ) );
        try {
            elementFromMetamodelDataArea.setContainer( createdParentMofPackage );
            fail( "Expected exception" );
        } catch ( IllegalLinkException e ) {
            //expected exception
            //make sure the link was really not established
            assertNull( elementFromMetamodelDataArea.getContainer( ) );
        }

        //CASE 7: change attribute link (ObjectAttributeChangeMT)
        A26 a26_3 = partition.createElement( A26.class );
        try {
            a26_3.setReflectToOne( elementFromMetamodelDataArea );
            fail( "Expected Exception" );
        } catch ( IllegalLinkException e ) {
            //expected exception
            //make sure the link was really not established
            assertNull( a26_3.getReflectToOne( ) );
        }

    }

    @Test
    public void testRetrievalOfAssociationLinks( ) {

        MofClass element = getPartitionOne( ).createElement( MofClass.class );
        Attribute linkedAttribute1 = getPartitionOne( ).createElement( Attribute.class );
        Attribute linkedAttribute2 = getPartitionOne( ).createElement( Attribute.class );
        Attribute linkedAttribute3 = getPartitionOne( ).createElement( Attribute.class );
        Contains containsAssoc = getMOINConnection( ).getAssociation( Contains.ASSOCIATION_DESCRIPTOR );
        MRI containsAssocMri = ( (Partitionable) containsAssoc.refMetaObject( ) ).get___Mri( );
        element.getContents( ).add( linkedAttribute1 );
        element.getContents( ).add( linkedAttribute2 );
        element.getContents( ).add( linkedAttribute3 );

        //another link to element, but not stored at element
        Tag tag = getPartitionOne( ).createElement( Tag.class );
        tag.getElements( ).add( element );
        assertEquals( 1, tag.getElements( ).size( ) );
        assertEquals( element, tag.getElements( ).iterator( ).next( ) );
        Partitionable[] storedLinkedElements = new Partitionable[] { linkedAttribute1, linkedAttribute2, linkedAttribute3 };

        RefObjectUtil refObjectUtil = UtilitiesFactory.getRefObjectUtil( );
        Collection<AssociationLink> links = refObjectUtil.getAssociationLinks( element );
        assertEquals( storedLinkedElements.length, links.size( ) );

        Iterator<AssociationLink> linkIterator = links.iterator( );
        for ( int i = 0; i < links.size( ); i++ ) {
            AssociationLink link = linkIterator.next( );
            assertEquals( ( (Partitionable) element ).get___Mri( ), link.getStoredEnd( ) );
            assertEquals( storedLinkedElements[i].get___Mri( ).getLri( ), link.getOtherEnd( ) );
            assertEquals( containsAssocMri, link.getAssociation( ) );
            assertEquals( i, link.getPosition( ) );
        }

        //delete the element in order to see if the link to the tag was existing
        element.refDelete( );
        assertTrue( tag.getElements( ).isEmpty( ) );

        try {
            refObjectUtil.getAssociationLinks( null );
            fail( "Expected exception" );
        } catch ( IllegalArgumentException e ) {
            //expected
        }

        MofClass elementWithNoLinks = getPartitionOne( ).createElement( MofClass.class );
        assertTrue( refObjectUtil.getAssociationLinks( elementWithNoLinks ).isEmpty( ) );

        final ComposesCs composesCs = getMOINConnection( ).getAssociation( ComposesCs.ASSOCIATION_DESCRIPTOR );
        final HasCs hasCs = getMOINConnection( ).getAssociation( HasCs.ASSOCIATION_DESCRIPTOR );
        final ComposesCsOrdered composesCsOrdered = getMOINConnection( ).getAssociation( ComposesCsOrdered.ASSOCIATION_DESCRIPTOR );
        final ComposesB composesB = getMOINConnection( ).getAssociation( ComposesB.ASSOCIATION_DESCRIPTOR );

        final F4 elementToGetLinksFrom = getPartitionOne( ).createElement( F4.class );

        final C4 oneCValue = getPartitionOne( ).createElement( C4.class );

        final C4 manyCs1 = getPartitionOne( ).createElement( C4.class );
        final C4 manyCs2 = getPartitionOne( ).createElement( C4.class );
        final C4 manyCs3 = getPartitionOne( ).createElement( C4.class );

        final C4 manyCsOrdered1 = getPartitionOne( ).createElement( C4.class );
        final C4 manyCsOrdered2 = getPartitionOne( ).createElement( C4.class );
        final C4 manyCsOrdered3 = getPartitionOne( ).createElement( C4.class );

        final C4 composesCsOrdered1 = getPartitionOne( ).createElement( C4.class );
        final C4 composesCsOrdered2 = getPartitionOne( ).createElement( C4.class );
        final C4 composesCsOrdered3 = getPartitionOne( ).createElement( C4.class );

        final C4 hasCs1 = getPartitionOne( ).createElement( C4.class );
        final C4 hasCs2 = getPartitionOne( ).createElement( C4.class );
        final C4 hasCs3 = getPartitionOne( ).createElement( C4.class );

        final C4 composesCs1 = getPartitionOne( ).createElement( C4.class );
        final C4 composesCs2 = getPartitionOne( ).createElement( C4.class );
        final C4 composesCs3 = getPartitionOne( ).createElement( C4.class );

        final B4 composesBValue = getPartitionOne( ).createElement( B4.class );

        elementToGetLinksFrom.setOneC( oneCValue );
        elementToGetLinksFrom.getManyCs( ).add( manyCs1 );
        elementToGetLinksFrom.getManyCs( ).add( manyCs2 );
        elementToGetLinksFrom.getManyCs( ).add( manyCs3 );
        elementToGetLinksFrom.getManyCsOrdered( ).add( manyCsOrdered1 );
        elementToGetLinksFrom.getManyCsOrdered( ).add( manyCsOrdered2 );
        elementToGetLinksFrom.getManyCsOrdered( ).add( manyCsOrdered3 );

        Collection<C4> myCs = composesCs.getMyCs( elementToGetLinksFrom );
        myCs.add( composesCs1 );
        myCs.add( composesCs2 );
        myCs.add( composesCs3 );

        List<C4> myCsOrdered = composesCsOrdered.getMyCsOrdered( elementToGetLinksFrom );
        myCsOrdered.add( composesCsOrdered1 );
        myCsOrdered.add( composesCsOrdered2 );
        myCsOrdered.add( composesCsOrdered3 );

        Collection<C4> myHasCs = hasCs.getC( elementToGetLinksFrom );
        myHasCs.add( hasCs1 );
        myHasCs.add( hasCs2 );
        myHasCs.add( hasCs3 );

        composesB.add( composesBValue, elementToGetLinksFrom );

        Collection<AssociationLink> associationLinks = refObjectUtil.getAssociationLinks( elementToGetLinksFrom );
        assertEquals( 10, associationLinks.size( ) );
    }

    @Test
    public void testNoRepartitioningOfCrossPartitionObjectValuedAttributeOnLinkRemoval1( ) throws Exception {

        getMOINConnection( ).revert( );

        A1 a1 = getPartitionOne( ).createElement( A1.class );
        B1 b1 = getPartitionTwo( ).createElement( B1.class );
        a1.getBs( ).add( b1 );
        getMOINConnection( ).save( );

        a1.getBs( ).clear( );

        assertEquals( getPartitionTwo( ), ( (Partitionable) b1 ).get___Partition( ) );
    }

    @Test
    public void testNoRepartitioningOfCrossPartitionObjectValuedAttributeOnLinkRemoval2( ) throws Exception {

        getMOINConnection( ).revert( );

        A4 a4 = getPartitionOne( ).createElement( A4.class );
        B4 b4 = getPartitionTwo( ).createElement( B4.class );
        a4.setOneBchangeable( b4 );
        getMOINConnection( ).save( );

        a4.setOneBchangeable( null );

        assertEquals( getPartitionTwo( ), ( (Partitionable) b4 ).get___Partition( ) );
    }

    @Test
    public void testCrossPartitionAttributeLinkMultiplicityN( ) throws Exception {

        getMOINConnection( ).revert( );
        A4 a4 = getPartitionOne( ).createElement( A4.class );
        B4 b4_1 = getPartitionOne( ).createElement( B4.class );
        B4 b4_2 = getPartitionTwo( ).createElement( B4.class );
        B4 b4_3 = getPartitionThree( ).createElement( B4.class );

        a4.getManyBs( ).add( b4_1 );
        a4.getManyBs( ).add( b4_2 );
        a4.getManyBs( ).add( b4_3 );

        getMOINConnection( ).save( );

        A4 a4FromSecondConnection = (A4) getSecondMOINConnection( ).getElement( ( (Partitionable) a4 ).get___Mri( ) );
        assertEquals( ( (Partitionable) a4 ).get___Mri( ), ( (Partitionable) a4FromSecondConnection ).get___Mri( ) );

        Collection<B4> manyBsFromConnection2 = a4.getManyBs( );
        assertEquals( 3, manyBsFromConnection2.size( ) );
        HashSet<MRI> mris = new HashSet<MRI>( );
        for ( B4 b4 : manyBsFromConnection2 ) {
            mris.add( ( (Partitionable) b4 ).get___Mri( ) );
        }

        assertTrue( mris.contains( ( (Partitionable) b4_1 ).get___Mri( ) ) );
        assertTrue( mris.contains( ( (Partitionable) b4_2 ).get___Mri( ) ) );
        assertTrue( mris.contains( ( (Partitionable) b4_3 ).get___Mri( ) ) );

    }

    @Test
    public void testCrossPartitionAttributeLinkMultiplicityOne( ) throws Exception {

        getMOINConnection( ).revert( );
        A4 a4 = getPartitionOne( ).createElement( A4.class );
        B4 b4 = getPartitionTwo( ).createElement( B4.class );

        a4.setOneBchangeable( b4 );

        getMOINConnection( ).save( );

        A4 a4FromSecondConnection = (A4) getSecondMOINConnection( ).getElement( ( (Partitionable) a4 ).get___Mri( ) );
        assertEquals( ( (Partitionable) a4 ).get___Mri( ), ( (Partitionable) a4FromSecondConnection ).get___Mri( ) );

        B4 b4FromSecondConnection = a4FromSecondConnection.getOneBchangeable( );
        assertEquals( ( (Partitionable) b4 ).get___Mri( ), ( (Partitionable) b4FromSecondConnection ).get___Mri( ) );

    }

    @Test
    public void testEqualsAndLogicalEquals( ) throws Exception {

        final Connection connection1 = getMOINConnection( );

        final ModelPartition partitionFromConnection1 = getPartitionOne( );
        A26 a26_1 = partitionFromConnection1.createElement( A26.class );
        MofClass value1 = connection1.createElement( MofClass.class );
        value1.setName( "value1" );

        List<RefObject> reflectToManyList = a26_1.getReflectToMany( );
        reflectToManyList.add( value1 );
        assertEquals( 1, reflectToManyList.size( ) );
        reflectToManyList.add( value1 );
        assertEquals( 2, reflectToManyList.size( ) );
        JmiList jmiList = ( (Wrapper<JmiList>) reflectToManyList ).unwrap( );
        Collection<EndStorageLink> linkCollection = jmiList.getLinkCollection( );
        assertEquals( 2, linkCollection.size( ) );
        Iterator<EndStorageLink> linkCollectionIterator = linkCollection.iterator( );
        EndStorageLink link1 = linkCollectionIterator.next( );
        EndStorageLink link2 = linkCollectionIterator.next( );

        assertTrue( link1.logicalEquals( link2 ) );
        assertFalse( link1.equals( link2 ) );
    }

    /**
     * Test refAddLink & refRemoveLink also in conjunction with a reference
     * access for an association with equal (!) end types.
     */
    @Test
    public void testAddAndRemoveLinkWithEqualEndTypes( ) {

        boolean result = true;
        com.sap.tc.moin.testcases.case010.HasCs hasCs = getMOINConnection( ).getAssociation( com.sap.tc.moin.testcases.case010.HasCs.ASSOCIATION_DESCRIPTOR );
        C10 firstEnd = getMOINConnection( ).createElement( C10.CLASS_DESCRIPTOR );
        C10 secondEnd = getMOINConnection( ).createElement( C10.CLASS_DESCRIPTOR );

        // add the link via refAddLink
        result = hasCs.refAddLink( firstEnd, secondEnd );
        assertTrue( result );
        // remove the link via refRemoveLink
        result = hasCs.refRemoveLink( firstEnd, secondEnd );
        assertTrue( result );

        // add the link via refAddLink
        result = hasCs.refAddLink( firstEnd, secondEnd );
        assertTrue( result );
        // remove the link via refRemoveLink, but with interchanged ends, the result has to be "false"
        result = hasCs.refRemoveLink( secondEnd, firstEnd );
        assertFalse( result );
        // reset
        hasCs.refRemoveLink( firstEnd, secondEnd );

        // add the link via refAddLink
        result = hasCs.refAddLink( firstEnd, secondEnd );
        assertTrue( result );
        // remove the link via the reference "first"
        result = secondEnd.getFirst( ).remove( firstEnd );
        assertTrue( result );

        // add the link via refAddLink
        result = hasCs.refAddLink( firstEnd, secondEnd );
        assertTrue( result );
        // remove the link via the reference "second"
        result = firstEnd.getSecond( ).remove( secondEnd );
        assertTrue( result );

        // add the link via the reference "first"
        result = secondEnd.getFirst( ).add( firstEnd );
        assertTrue( result );
        // remove the link via the reference "first"
        result = secondEnd.getFirst( ).remove( firstEnd );
        assertTrue( result );

        // add the link via the reference "first"
        result = secondEnd.getFirst( ).add( firstEnd );
        assertTrue( result );
        // remove the link via refRemoveLink
        result = hasCs.refRemoveLink( firstEnd, secondEnd );
        assertTrue( result );

        // add the link via the reference "first"
        result = secondEnd.getFirst( ).add( firstEnd );
        assertTrue( result );
        // remove the link via refRemoveLink, but with interchanged ends, the result has to be "false"
        result = hasCs.refRemoveLink( secondEnd, firstEnd );
        assertFalse( result );
        // reset
        hasCs.refRemoveLink( firstEnd, secondEnd );

        // add the link via the reference "first"
        result = secondEnd.getFirst( ).add( firstEnd );
        assertTrue( result );
        // remove the link via the reference "second"
        result = firstEnd.getSecond( ).remove( secondEnd );
        assertTrue( result );
    }

    @Test
    public void testReplaceOrderedLinkViaReferenceAndCheckEventIndex( ) {

        MofPackage mofPackageA = getMOINConnection( ).createElement( MofPackage.class );
        MofClass class1 = getMOINConnection( ).createElement( MofClass.class );
        MofClass class2 = getMOINConnection( ).createElement( MofClass.class );
        MofClass class3 = getMOINConnection( ).createElement( MofClass.class );
        MofClass class4 = getMOINConnection( ).createElement( MofClass.class );
        mofPackageA.getContents( ).add( class1 );
        mofPackageA.getContents( ).add( class2 );
        mofPackageA.getContents( ).add( class3 );
        mofPackageA.getContents( ).add( class4 );

        MofPackage mofPackageB = getMOINConnection( ).createElement( MofPackage.class );

        UpdateListener listenerForDo = new UpdateListener( ) {

            @Override
            public void notifyUpdate( EventChain eventChain ) {

                List<ChangeEvent> events = eventChain.getEvents( );
                assertEquals( 2, events.size( ) );

                // First event should be link remove at third position (index 2)
                LinkRemoveEvent linkRemoveEvent = (LinkRemoveEvent) events.get( 0 );
                assertEquals( 2, linkRemoveEvent.getPosition( ) );

                // Second event should be link add at first position (index 0)
                LinkAddEvent linkAddEvent = (LinkAddEvent) events.get( 1 );
                assertEquals( 0, linkAddEvent.getPosition( ) );
            }
        };

        getMOINConnection( ).getSession( ).getEventRegistry( ).registerUpdateListener( listenerForDo, new EventTypeFilter( LinkChangeEvent.class ) );

        class3.setContainer( mofPackageB );

        getMOINConnection( ).getSession( ).getEventRegistry( ).deregister( listenerForDo );

        UpdateListener listenerForUndo = new UpdateListener( ) {

            @Override
            public void notifyUpdate( EventChain eventChain ) {

                List<ChangeEvent> events = eventChain.getEvents( );
                assertEquals( 2, events.size( ) );

                // First event should be link remove at first position (index 0)
                LinkRemoveEvent linkRemoveEvent = (LinkRemoveEvent) events.get( 0 );
                assertEquals( 0, linkRemoveEvent.getPosition( ) );

                // Second event should be link add at third position (index 2)
                LinkAddEvent linkAddEvent = (LinkAddEvent) events.get( 1 );
                assertEquals( 2, linkAddEvent.getPosition( ) );
            }
        };

        getMOINConnection( ).getSession( ).getEventRegistry( ).registerUpdateListener( listenerForUndo, new EventTypeFilter( LinkChangeEvent.class ) );

        getMOINConnection( ).getCommandStack( ).undo( );

        // Check if "class3" is back at position 2 after undo
        List<ModelElement> contents = mofPackageA.getContents( );
        assertEquals( 2, contents.indexOf( class3 ) );
    }

    @Override
    @After
    public void afterTestMethod( ) throws Exception {

        this.testcasesPackage = null;
        this.sip = null;
        this.message1 = null;
        this.message2 = null;
        this.message3 = null;
        this.message4 = null;
        this.message5 = null;
        this.messageTriggersReply = null;
        super.afterTestMethod( );
    }

    private B6 createB6( ) {

        return getMOINConnection( ).createElementInPartition( B6.class, null );

    }

    private C6 createC6( ) {

        return getMOINConnection( ).createElementInPartition( C6.class, null );
    }

    private D6 createD6( ) {

        return getMOINConnection( ).createElementInPartition( D6.class, null );
    }
}
