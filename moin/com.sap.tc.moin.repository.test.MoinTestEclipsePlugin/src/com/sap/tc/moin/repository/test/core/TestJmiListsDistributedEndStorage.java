package com.sap.tc.moin.repository.test.core;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.AttachesTo;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.ModelPackage;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.Tag;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.omg.ocl.OclPackage;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.NullPartitionNotEmptyException;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.PartitionEditingNotPossibleException;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.PartitionsNotSavedException;
import com.sap.tc.moin.repository.core.CompoundClientSpecWorkspace;
import com.sap.tc.moin.repository.core.CoreSession;
import com.sap.tc.moin.repository.core.EndStorageLink;
import com.sap.tc.moin.repository.core.JmiListWrapper;
import com.sap.tc.moin.repository.core.MriReference;
import com.sap.tc.moin.repository.core.SessionWorkspace;
import com.sap.tc.moin.repository.core.SynchronizationManager;
import com.sap.tc.moin.repository.core.links.JmiListForDistributedEndStorage;
import com.sap.tc.moin.test.fw.TestClient;
import com.sap.tc.moin.test.fw.TestMetaModels;
import com.sap.tc.moin.testcases.TestcasesPackage;
import com.sap.tc.moin.testcases.case016.A16;
import com.sap.tc.moin.testcases.case016.B16;
import com.sap.tc.moin.testcases.case016.Case016Package;

/**
 * tests the implementation of the JmiList and the
 * JmiListForDistributedEndStorage using the ServiceInteractions package as well
 * as UML.
 * 
 * @author d045397
 */
public class TestJmiListsDistributedEndStorage extends CoreMoinTest {

    ModelPartition partition = null;

    ModelPartition partition2 = null;

    TestcasesPackage tcp = null;

    Case016Package case016Package = null;

    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );
        partition = getPartitionOne( );
        partition2 = getPartitionTwo( );

        tcp = (TestcasesPackage) this.getMOINConnection( ).getPackage( TestMetaModels.TESTCASES_CN, TestMetaModels.TESTCASES_TPE );
        case016Package = tcp.getCase016( );

    }

    @Test
    public void testDistributedEndStorageForNewElement( ) throws Exception {

        A16 a16_1 = getMOINConnection( ).createElementInPartition( A16.class, null );
        B16 b16_1 = getMOINConnection( ).createElementInPartition( B16.class, null );

        assertTrue( "Expected element to be new", getTestHelper( ).getCoreConnection( getMOINConnection( ) ).isNewElement( getTestHelper( ).getCorePartitionable( (Partitionable) a16_1 ) ) );
        Collection<B16> distributedBs = a16_1.getB( );
        distributedBs.add( b16_1 );
        assertTrue( "Expected element to be contained", distributedBs.contains( b16_1 ) );
    }

    @Test
    public void testUpdateCrossSession( ) throws Exception {

        A16 a16_1 = getMOINConnection( ).createElementInPartition( A16.class, null );
        B16 b16_1 = getMOINConnection( ).createElementInPartition( B16.class, null );
        B16 b16_2 = getMOINConnection( ).createElementInPartition( B16.class, null );
        B16 b16_3 = getMOINConnection( ).createElementInPartition( B16.class, null );

        // assign to real partitions so it can be saved
        ( (Partitionable) a16_1 ).assign___Partition( partition );
        ( (Partitionable) b16_1 ).assign___Partition( partition );
        ( (Partitionable) b16_2 ).assign___Partition( partition );
        ( (Partitionable) b16_3 ).assign___Partition( partition2 );

        Collection distributedBs = a16_1.getB( );
        assertTrue( distributedBs.isEmpty( ) );
        distributedBs.add( b16_1 );
        distributedBs.add( b16_2 );
        distributedBs.add( b16_3 );

        assertTrue( "Not all elements are contained", distributedBs.contains( b16_1 ) && distributedBs.contains( b16_2 ) && distributedBs.contains( b16_3 ) );

        int expectedSize = 3;
        assertSame( expectedSize, distributedBs.size( ) );
        Connection connection = getMOINConnection( );

        // save partition
        connection.save( );

        assertSame( "Size changed after save!", expectedSize, distributedBs.size( ) );

        // start the other thread which adds an element to the triggers and
        // saves
        LinkAddClient secondClientThread = new LinkAddClient( this._testClient2, ( (Partitionable) a16_1 ).get___Mri( ) );
        secondClientThread.start( );
        secondClientThread.join( );

        // now (as the other thread has finished) there must be an additional
        // element
        expectedSize++;
        assertSame( "Seems like the list wasn't invalidated across session borders after adding a link", expectedSize, distributedBs.size( ) );
        assertTrue( "Added element from other session is not contained", distributedBs.contains( secondClientThread.getAddedElement( ) ) );

        PartitionDeleteClient deletePartitionThread = new PartitionDeleteClient( this._testClient2, getPartitionThree( ).getPri( ) );
        deletePartitionThread.start( );
        deletePartitionThread.join( );
        if ( deletePartitionThread.getOccuredException( ) != null ) {
            throw deletePartitionThread.getOccuredException( );
        }

        // now (as the delete thread for partition3 is finished) there must be
        // one element less
        expectedSize--;
        assertSame( "Seems like the list wasn't invalidated across session borders after deletion of a partition", expectedSize, distributedBs.size( ) );
        assertTrue( "Missing element in distributed list", distributedBs.contains( b16_1 ) );
        assertTrue( "Missing element in distributed list", distributedBs.contains( b16_2 ) );
        assertTrue( "Missing element in distributed list", distributedBs.contains( b16_3 ) );

        // delete the link to the third element to see if update also works on
        // link deletion (not the whole partition is
        // deleted)
        ElementDeleteClient elementDeleteClient = new ElementDeleteClient( this._testClient2, ( (Partitionable) b16_3 ).get___Mri( ) );
        elementDeleteClient.start( );
        elementDeleteClient.join( );
        if ( elementDeleteClient.getOccuredException( ) != null ) {
            throw elementDeleteClient.getOccuredException( );
        }

        expectedSize--;
        assertSame( "Seems like the list wasn't invalidated across session borders after deletion of a link", expectedSize, distributedBs.size( ) );
        assertTrue( "Missing element in distributed list", distributedBs.contains( b16_1 ) );
        assertTrue( "Missing element in distributed list", distributedBs.contains( b16_2 ) );
    }

    @Test
    public void testUpdateCrossSessionForRepartionedValueElement( ) throws Exception {

        A16 a16_1 = getMOINConnection( ).createElementInPartition( A16.class, null );
        B16 b16_1 = getMOINConnection( ).createElementInPartition( B16.class, null );
        B16 b16_2 = getMOINConnection( ).createElementInPartition( B16.class, null );
        B16 b16_3 = getMOINConnection( ).createElementInPartition( B16.class, null );

        // assign to real partitions so it can be saved
        ( (Partitionable) a16_1 ).assign___Partition( partition );
        ( (Partitionable) b16_1 ).assign___Partition( partition );
        ( (Partitionable) b16_2 ).assign___Partition( partition );
        ( (Partitionable) b16_3 ).assign___Partition( partition2 );

        Collection<B16> distributedBs = a16_1.getB( );
        assertTrue( distributedBs.isEmpty( ) );
        distributedBs.add( b16_1 );
        distributedBs.add( b16_2 );
        distributedBs.add( b16_3 );

        assertTrue( "Not all elements are contained", distributedBs.contains( b16_1 ) && distributedBs.contains( b16_2 ) && distributedBs.contains( b16_3 ) );

        int expectedSize = 3;
        assertSame( expectedSize, distributedBs.size( ) );
        Connection connection = getMOINConnection( );

        // save partition
        connection.save( );

        //move the element in partition2 to partition3 in a second session
        //the first session's distributed JmiList must be informed so it can update itself
        Connection connectionOfOtherSession = getSecondMOINConnection( );
        A16 a16InOtherSession = (A16) connectionOfOtherSession.getElement( ( (Partitionable) a16_1 ).get___Mri( ) );
        Collection<B16> distributedBsInOtherSession = a16InOtherSession.getB( );
        assertEquals( expectedSize, distributedBsInOtherSession.size( ) );
        Partitionable b16_3InOtherSession = (Partitionable) connectionOfOtherSession.getElement( ( (Partitionable) b16_3 ).get___Mri( ) );
        assertTrue( distributedBsInOtherSession.contains( b16_3InOtherSession ) );
        assertEquals( partition2.getPri( ), b16_3InOtherSession.get___Mri( ).getPri( ) );
        getPartitionThree( ).assignElement( b16_3InOtherSession );
        connectionOfOtherSession.save( );

        LRI lriOfB16_3 = b16_3InOtherSession.get___Mri( ).getLri( );
        for ( B16 b16 : distributedBs ) {
            Partitionable element = ( (Partitionable) b16 );
            if ( element.get___Mri( ).getLri( ).equals( lriOfB16_3 ) ) {
                assertEquals( getPartitionThree( ).getPri( ), element.get___Mri( ).getPri( ) );
                return;
            }
        }
        fail( "The repartitioning of b16_3 wasn't propagated across session borders" );
    }

    private class LinkAddClient extends Thread {

        private MRI fromElementMri = null;

        private TestClient testClient = null;

        private Partitionable newElement = null;

        public LinkAddClient( TestClient client, MRI fromElement ) {

            this.fromElementMri = fromElement;
            this.testClient = client;
        }

        @Override
        public void run( ) {

            Connection connection = testClient.getConnection( );
            ModelPartition partition = connection.getPartition( getPartitionThree( ).getPri( ) );
            if ( partition == null ) {
                partition = connection.createPartition( getPartitionThree( ).getPri( ) );
            }

            A16 fromElement = (A16) connection.getElement( fromElementMri );

            Collection distributedBs = fromElement.getB( );
            B16 newB = connection.createElementInPartition( B16.class, null );
            partition.assignElement( newB );
            distributedBs.add( newB );
            this.newElement = (Partitionable) newB;

            try {
                connection.save( );
            } catch ( PartitionsNotSavedException e ) {
                throw new RuntimeException( e );
            }
        }

        public Partitionable getAddedElement( ) {

            return this.newElement;
        }
    }

    private static class PartitionDeleteClient extends Thread {

        private PRI partitionToDelete = null;

        private Exception occuredException = null;

        private TestClient testClient = null;

        public PartitionDeleteClient( TestClient client, PRI priToDelete ) {

            this.partitionToDelete = priToDelete;
            this.testClient = client;
        }

        @Override
        public void run( ) {

            Connection connection = testClient.getConnection( );
            ModelPartition partition = connection.getPartition( this.partitionToDelete );
            if ( partition == null ) {
                this.occuredException = new RuntimeException( "Partition " + this.partitionToDelete + " doesn't exist for connection " + connection );
                return;
            }

            partition.delete( );

            try {
                connection.save( );
            } catch ( Exception e ) {
                this.occuredException = e;
                throw new RuntimeException( e );
            }
        }

        public Exception getOccuredException( ) {

            return this.occuredException;
        }
    }

    private static class ElementDeleteClient extends Thread {

        private MRI elementToDelete = null;

        private Exception occuredException = null;

        private TestClient testClient = null;

        public ElementDeleteClient( TestClient client, MRI mriToDelete ) {

            this.elementToDelete = mriToDelete;
            this.testClient = client;
        }

        @Override
        public void run( ) {

            Connection connection = testClient.getConnection( );
            RefObject element = (RefObject) connection.getElement( this.elementToDelete );
            if ( element == null ) {
                this.occuredException = new RuntimeException( "Element " + this.elementToDelete + " doesn't exist for connection " + connection );
                return;
            }

            element.refDelete( );

            try {
                connection.save( );
            } catch ( Exception e ) {
                this.occuredException = e;
                throw new RuntimeException( e );
            }
        }

        public Exception getOccuredException( ) {

            return this.occuredException;
        }
    }

    /**
     * tests links between messages and endpointreferences which have been saved
     * and loaded again
     * 
     * @throws PartitionsNotSavedException
     */
    @Test
    public void testSaveAndLoadAgainDe( ) throws NullPartitionNotEmptyException, PartitionsNotSavedException {

        A16 a16_1 = getMOINConnection( ).createElementInPartition( A16.class, null );
        B16 b16_1 = getMOINConnection( ).createElementInPartition( B16.class, null );
        B16 b16_2 = getMOINConnection( ).createElementInPartition( B16.class, null );
        B16 b16_3 = getMOINConnection( ).createElementInPartition( B16.class, null );

        // assign to real partitions so it can be saved
        ( (Partitionable) a16_1 ).assign___Partition( partition );
        ( (Partitionable) b16_1 ).assign___Partition( partition );
        ( (Partitionable) b16_2 ).assign___Partition( partition );
        ( (Partitionable) b16_3 ).assign___Partition( partition2 );

        Collection distributedBs = a16_1.getB( );
        assertTrue( distributedBs.isEmpty( ) );
        distributedBs.add( b16_1 );
        distributedBs.add( b16_2 );
        distributedBs.add( b16_3 );

        assertTrue( "Not all elements are contained", distributedBs.contains( b16_1 ) && distributedBs.contains( b16_2 ) && distributedBs.contains( b16_3 ) );

        Connection connection = getMOINConnection( );

        // save partition
        connection.save( );

        // we want to make sure that the partition is not loaded, therefore we
        // add another element (to make the
        // partition dirty) and then revert (as all dirty partitions will be
        // evicted during revert())
        partition.createElement( A16.class );
        partition2.createElement( A16.class );
        connection.revert( );

        // get partition again
        ModelPartition partitionLoaded = connection.getPartition( partition.getPri( ) );

        Collection modelElements = partitionLoaded.getElements( );
        A16 a3Reloaded = null;
        for ( Object modelElement : modelElements ) {

            if ( a16_1.equals( modelElement ) ) {
                a3Reloaded = (A16) modelElement;
                break;
            }

        }
        assertNotNull( a3Reloaded );

        // make sure that all former triggers are still contained after saving
        // and loading
        assertTrue( "Not all elements are contained after saving and loading ", distributedBs.contains( b16_1 ) && distributedBs.contains( b16_2 ) && distributedBs.contains( b16_3 ) );

        // add another element
        B16 b3_new = connection.createElementInPartition( B16.class, null );
        distributedBs.add( b3_new );
        assertTrue( "Not all elements are contained", distributedBs.contains( b16_1 ) && distributedBs.contains( b16_2 ) && distributedBs.contains( b16_3 ) && distributedBs.contains( b3_new ) );
    }

    /**
     * Test tag retrieval and creation via AttachesTo Association on MofClass
     * "MofPackage"
     * 
     * @throws Exception
     */
    @Test
    public void testAttachesTo( ) throws Exception {

        ModelPackage mofModelPackage = (ModelPackage) getMOINConnection( ).getPackage( TestMetaModels.MOIN_MOF_CN, TestMetaModels.MOIN_MOF_TPE_MODEL );
        OclPackage mofOclPackage = (OclPackage) getMOINConnection( ).getPackage( TestMetaModels.MOIN_MOF_CN, TestMetaModels.MOIN_MOF_TPE_OCL );
        AttachesTo at = mofModelPackage.getAttachesTo( );
        MofClass mofPackage = (MofClass) mofModelPackage.refMetaObject( ).refMetaObject( );
        Collection<Tag> tags = at.getTag( mofPackage );
        RefClass tagClass = mofModelPackage.getTag( );
        for ( Tag tag : tags ) {
            System.out.println( "Tag: " + tag.getName( ) );
            System.out.println( "- Annotation: " + tag.getAnnotation( ) );
            System.out.println( "- TagId: " + tag.getTagId( ) );
            System.out.println( "- Container: " + tag.getContainer( ) );
            for ( Object tagValue : tag.getValues( ) ) {
                System.out.println( "-- Value: " + tagValue.toString( ) );
            }
        }
        assertEquals( 2, tags.size( ) );

        Tag artificialTag = (Tag) tagClass.refCreateInstance( );
        this.getPartitionOne( ).assignElement( (Partitionable) artificialTag );
        artificialTag.setTagId( "ArtificialTag" );
        try {
            artificialTag.setContainer( (com.sap.tc.moin.repository.mmi.model.Namespace) mofModelPackage.refMetaObject( ) );
        } catch ( PartitionEditingNotPossibleException e ) {
            // fine, as we cannot change the MofRom
        }
        assertEquals( null, artificialTag.getContainer( ) );
        try {
            artificialTag.setContainer( (com.sap.tc.moin.repository.mmi.model.Namespace) mofModelPackage.refMetaObject( ) );
        } catch ( PartitionEditingNotPossibleException e ) {
            // fine, as we cannot change the MofRom
        }
        assertEquals( null, artificialTag.getContainer( ) );
        try {
            artificialTag.setContainer( (com.sap.tc.moin.repository.mmi.model.Namespace) mofOclPackage.refMetaObject( ) );
        } catch ( PartitionEditingNotPossibleException e ) {
            // fine, as we cannot change the MofRom
        }
        assertEquals( null, artificialTag.getContainer( ) );

        List<String> valueList = artificialTag.getValues( );
        valueList.add( "ArtificalTagValue01" );
        valueList.add( "ArtificalTagValue02" );
        int size = tags.size( );

        assertEquals( 2, artificialTag.getValues( ).size( ) );

        Tag someModelElement = (Tag) tagClass.refCreateInstance( );
        Collection listOfTagsForSomeModelElement = at.getTag( someModelElement );
        assertEquals( 0, listOfTagsForSomeModelElement.size( ) );
        at.add( someModelElement, artificialTag );
        assertEquals( 1, listOfTagsForSomeModelElement.size( ) );
        assertEquals( artificialTag, listOfTagsForSomeModelElement.iterator( ).next( ) );

        com.sap.tc.moin.repository.mmi.model.Namespace ns = (com.sap.tc.moin.repository.mmi.model.Namespace) mofModelPackage.refMetaObject( );
        for ( Iterator iter = ns.getContents( ).iterator( ); iter.hasNext( ); ) {
            Object o = iter.next( );
            ModelElement element = (ModelElement) o;
            System.out.println( element.toString( ) );
            tags = at.getTag( element );
            for ( Tag tag : tags ) {
                System.out.println( "- Tag: " + tag.getName( ) );
                for ( Object tagValue : tag.getValues( ) ) {
                    System.out.println( "-- Value: " + tagValue.toString( ) );
                }
            }
        }
    }

    @Test
    public void testRevertCrossSession( ) throws Exception {

        A16 a16_1 = getMOINConnection( ).createElementInPartition( A16.class, null );
        B16 b16_1 = getMOINConnection( ).createElementInPartition( B16.class, null );
        B16 b16_2 = getMOINConnection( ).createElementInPartition( B16.class, null );

        // assign to real partitions so it can be saved
        ( (Partitionable) a16_1 ).assign___Partition( partition );
        ( (Partitionable) b16_1 ).assign___Partition( partition );
        ( (Partitionable) b16_2 ).assign___Partition( partition );

        Collection<B16> distributedBs = a16_1.getB( );
        assertTrue( distributedBs.isEmpty( ) );
        distributedBs.add( b16_1 );
        distributedBs.add( b16_2 );

        assertTrue( "Not all elements are contained", distributedBs.contains( b16_1 ) && distributedBs.contains( b16_2 ) );

        int expectedSize = 2;
        assertSame( expectedSize, distributedBs.size( ) );
        Connection connection = getMOINConnection( );

        // save partition
        connection.save( );

        Connection connection2 = getSecondMOINConnection( );

        A16 a16_1_conn2 = (A16) connection2.getElement( ( (Partitionable) a16_1 ).get___Mri( ) );
        RefClass b16Class_conn2 = (RefClass) connection2.getElement( ( (Partitionable) this.case016Package.getB16( ) ).get___Mri( ) );
        B16 b16_conn2 = (B16) b16Class_conn2.refCreateInstance( );
        Collection<B16> distributedBs_conn2 = a16_1_conn2.getB( );

        assertSame( expectedSize, distributedBs_conn2.size( ) );

        distributedBs_conn2.add( b16_conn2 );
        Iterator iterator = distributedBs_conn2.iterator( );
        iterator.hasNext( );

        connection2.revert( );

        //        for (B16 b16 : distributedBs) {
        //            assertTrue(((Partitionable) b16).is___Alive());
        //        }

        for ( B16 b16 : distributedBs_conn2 ) {
            assertTrue( ( (Partitionable) b16 ).is___Alive( ) );
        }
    }

    @Test
    public void testCopyOnWrite( ) throws Exception {

        A16 a16_1 = getPartitionOne( ).createElement( A16.class );
        B16 b16_1 = getPartitionTwo( ).createElement( B16.class );
        B16 b16_2 = getPartitionTwo( ).createElement( B16.class );
        Collection<B16> distributedBs = a16_1.getB( );
        distributedBs.add( b16_1 );
        distributedBs.add( b16_2 );
        getMOINConnection( ).save( );
        getPartitionOne( ).createElement( MofClass.class ); // trigger creation of private copy of partitionOne
        for ( B16 b16 : distributedBs ) { // dummy loop to trigger resolving of the links' MriReferences
        }

        CoreSession session = getTestHelper( ).getCoreConnection( getMOINConnection( ) ).getSession( );
        assertTrue( getTestHelper( ).getCoreModelPartition( getPartitionOne( ) ).getWorkspace( ) instanceof SessionWorkspace );
        assertTrue( getTestHelper( ).getCoreModelPartition( getPartitionTwo( ) ).getWorkspace( ) instanceof CompoundClientSpecWorkspace );

        JmiListForDistributedEndStorage jmiList = (JmiListForDistributedEndStorage) ( (JmiListWrapper) distributedBs ).unwrap( );
        Collection<EndStorageLink> linkCollection = jmiList.getLinkCollection( );
        for ( EndStorageLink link : linkCollection ) {
            MriReference storageEnd = link.getStorageEnd( );
            assertFalse( storageEnd.isCached( ) );
            assertTrue( storageEnd.get( session /* session */).get___Workspace( ) instanceof CompoundClientSpecWorkspace );
        }
        getPartitionTwo( ).createElement( MofClass.class ); // trigger creation of private copy of partitionTwo
        jmiList = (JmiListForDistributedEndStorage) ( (JmiListWrapper) distributedBs ).unwrap( );
        linkCollection = jmiList.getLinkCollection( );
        for ( EndStorageLink link : linkCollection ) {
            MriReference storageEnd = link.getStorageEnd( );
            assertFalse( storageEnd.isCached( ) );
            assertTrue( storageEnd.get( session /* session */).get___Workspace( ) instanceof SessionWorkspace );
        }

        getMOINConnection( ).save( );

        jmiList = (JmiListForDistributedEndStorage) ( (JmiListWrapper) distributedBs ).unwrap( );
        linkCollection = jmiList.getLinkCollection( );
        SynchronizationManager synchronizationManager = jmiList.getWorkspace( ).getWorkspaceSet( ).getSynchronizationManager( );
        synchronizationManager.acquireReadLock( );
        try {
            for ( EndStorageLink link : linkCollection ) {
                MriReference storageEnd = link.getStorageEnd( );
                assertFalse( storageEnd.isCached( ) );
                assertTrue( storageEnd.get( session /* session */).get___Workspace( ) instanceof CompoundClientSpecWorkspace );
            }
        } finally {
            synchronizationManager.releaseReadLock( );
        }
    }

    @Test
    public void testRepartitioning( ) throws Exception {

        Connection connection = getMOINConnection( );
        A16 a16 = connection.createElementInPartition( A16.CLASS_DESCRIPTOR, null );
        B16 b16 = connection.createElementInPartition( B16.CLASS_DESCRIPTOR, null );
        Collection<B16> distributedBs = a16.getB( );
        distributedBs.add( b16 );
        getPartitionOne( ).assignElement( a16 );
        assertEquals( b16, distributedBs.iterator( ).next( ) );
    }

    @Override
    @After
    public void afterTestMethod( ) throws Exception {

        tcp = null;
        partition = null;
        partition2 = null;
        case016Package = null;
        super.afterTestMethod( );
    }
}