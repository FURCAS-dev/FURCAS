/*
 * Created on 01.03.2005
 */
package com.sap.tc.moin.repository.test.core;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AttachesTo;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.Contains;
import com.sap.tc.moin.repository.mmi.model.EnumerationType;
import com.sap.tc.moin.repository.mmi.model.ModelPackage;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.Tag;
import com.sap.tc.moin.repository.mmi.reflect.CompositionCycleException;
import com.sap.tc.moin.repository.mmi.reflect.InvalidObjectException;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;
import com.sap.tc.moin.repository.mmi.reflect.RefAssociation;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefException;
import com.sap.tc.moin.repository.mmi.reflect.RefFeatured;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;
import com.sap.tc.moin.repository.mmi.reflect.WrongSizeException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sap.company.CompanyPackage;
import com.sap.company.Division;
import com.sap.tc.moin.facility.primary.PrimaryFacility;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.Facility;
import com.sap.tc.moin.repository.InvalidConnectionException;
import com.sap.tc.moin.repository.InvalidModelPartitionException;
import com.sap.tc.moin.repository.InvalidResourceIdentifierException;
import com.sap.tc.moin.repository.InvalidSessionException;
import com.sap.tc.moin.repository.JmiHelper;
import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.NullPartitionNotEmptyException;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.ResourceIdentifierFactory;
import com.sap.tc.moin.repository.Session;
import com.sap.tc.moin.repository.cdam.CompoundClientSpec;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.CommandStack;
import com.sap.tc.moin.repository.commands.PartitionOperation;
import com.sap.tc.moin.repository.commands.PartitionOperation.Operation;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.core.CoreMoin;
import com.sap.tc.moin.repository.core.CorePartitionManager;
import com.sap.tc.moin.repository.core.CorePartitionable;
import com.sap.tc.moin.repository.core.EndStorageLink;
import com.sap.tc.moin.repository.core.LogicalLinkManager;
import com.sap.tc.moin.repository.core.SynchronizationManager;
import com.sap.tc.moin.repository.core.UnresolvableException;
import com.sap.tc.moin.repository.core.Workspace;
import com.sap.tc.moin.repository.core.impl.PartitionManagerImpl;
import com.sap.tc.moin.repository.events.ChangeListener;
import com.sap.tc.moin.repository.events.CommitListener;
import com.sap.tc.moin.repository.events.EventChain;
import com.sap.tc.moin.repository.events.EventRegistry;
import com.sap.tc.moin.repository.events.PreChangeListener;
import com.sap.tc.moin.repository.events.PreCommitListener;
import com.sap.tc.moin.repository.events.UpdateListener;
import com.sap.tc.moin.repository.events.filter.EventTypeFilter;
import com.sap.tc.moin.repository.events.type.ChangeEvent;
import com.sap.tc.moin.repository.events.type.ElementCreateEvent;
import com.sap.tc.moin.repository.events.type.LinkAddEvent;
import com.sap.tc.moin.repository.events.type.PartitionSaveEvent;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObjectAdapter;
import com.sap.tc.moin.repository.metamodels.DeploymentExtension;
import com.sap.tc.moin.repository.metamodels.MetaModelCatalog;
import com.sap.tc.moin.repository.metamodels.MetaModelInfo;
import com.sap.tc.moin.repository.metamodels.MetaModelVersion;
import com.sap.tc.moin.repository.mql.MQLProcessor;
import com.sap.tc.moin.repository.mql.MQLQuery;
import com.sap.tc.moin.repository.ocl.OclRegistryService;
import com.sap.tc.moin.repository.ocl.freestyle.OclExpressionRegistration;
import com.sap.tc.moin.repository.ocl.freestyle.OclFreestyleRegistry;
import com.sap.tc.moin.repository.ocl.freestyle.OclInvariantRegistration;
import com.sap.tc.moin.repository.ocl.metamodel.OclMetaModelConstraintRegistration;
import com.sap.tc.moin.repository.ocl.metamodel.OclMetamodelConstraintRegistry;
import com.sap.tc.moin.repository.ocl.registry.OclRegistrationSeverity;
import com.sap.tc.moin.repository.spi.core.SpiModelPartition;
import com.sap.tc.moin.repository.spi.runtimehost.mm.SpiMetamodelRegistry;
import com.sap.tc.moin.repository.xmi.XmiReader;
import com.sap.tc.moin.repository.xmi.XmiWriter;
import com.sap.tc.moin.test.fw.TestMetaModels;
import com.sap.tc.moin.test.testcase.MoinTestCase;
import com.sap.tc.moin.testcases.case004.A4;
import com.sap.tc.moin.testcases.case004.B4;
import com.sap.tc.moin.testcases.case006.C6;
import com.sap.tc.moin.testcases.case006.D6;
import com.sap.tc.moin.testcases.case006.ReferenceAtComposite;


/**
 * Performs a number of tests on the functionality of the workspace, including
 * model element relocation and partition eviction.
 * 
 * @author D043530
 */
public class TestWorkspaceOperations extends CoreMoinTest {



    /**
     * The first model partition
     */
    private ModelPartition mp1;

    /**
     * The second model partition
     */
    private ModelPartition mp2;



    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );

        this.mp1 = getPartitionOne( );
        this.mp2 = getPartitionTwo( );

    }

    @Override
    @After
    public void afterTestMethod( ) throws Exception {

        this.mp1 = null;
        this.mp2 = null;

        super.afterTestMethod( );
    }

    /**
     * Creates a composition hierarchy. After assigning the objects to the
     * workspace, they are expected to be explicitly assigned to the
     * no-partition automatically. After assigning them to a real partition, the
     * composition links are established, therefore some explicit assignments
     * now are redundant and are expected to be removed.
     */
    @Test
    public void testRedundantPartitionAssignmentRemoval( ) throws Exception {

        MofPackage pkg1 = getMOINConnection( ).getNullPartition( ).createElement( MofPackage.class );
        pkg1.setName( "p1" );

        ModelPartition nullPartition = getMOINConnection( ).getNullPartition( );
        assertEquals( "Expected pkg1 to be explicitly assigned to current connection's null-partition", nullPartition, ( (Partitionable) pkg1 ).get___Partition( ) );

        this.mp1.assignElement( pkg1 );

        assertEquals( "Expected pkg1 to be explicitly assigned to mp1", this.mp1, ( (Partitionable) pkg1 ).get___Partition( ) );

        MofPackage pkg2 = getMOINConnection( ).getNullPartition( ).createElement( MofPackage.class );
        pkg2.setName( "p2" );
        this.mp1.assignElement( pkg2 );

        MofPackage pkg3 = getMOINConnection( ).getNullPartition( ).createElement( MofPackage.class );
        pkg3.setName( "p3" );
        this.mp1.assignElement( pkg3 );

        assertEquals( "Expected pkg2 to be explicitly assigned to mp1", this.mp1, ( (Partitionable) pkg2 ).get___Partition( ) );
        assertEquals( "Expected pkg3 to be explicitly assigned to mp1", this.mp1, ( (Partitionable) pkg3 ).get___Partition( ) );

        // now add composition links
        // into redundant assignments that must be removed automatically.
        pkg2.setContainer( pkg1 );
        pkg3.setContainer( pkg2 );

        assertEquals( "Expected pkg1 to be explicitly assigned to mp1", this.mp1, ( (Partitionable) pkg1 ).get___Partition( ) );
        assertEquals( "Expected pkg2 to be implicitly assigned to mp1", this.mp1, ( (Partitionable) pkg2 ).get___Partition( ) );
        assertEquals( "Expected pkg3 to be implicitly assigned to mp1", this.mp1, ( (Partitionable) pkg3 ).get___Partition( ) );
    }

    /**
     * Creates a number of compositions and checks if cleaning existing links
     * upon addition of new ones happens correctly, and if the recompositioning
     * that has to take place due to the addition/removal of composite links is
     * handled correctly.
     */
    @Test
    public void testRecomposition( ) throws Exception {

        D6 child1 = getMOINConnection( ).getNullPartition( ).createElement( D6.class );
        C6 parent1 = getMOINConnection( ).getNullPartition( ).createElement( C6.class );

        D6 child2 = getMOINConnection( ).getNullPartition( ).createElement( D6.class );
        C6 parent2 = getMOINConnection( ).getNullPartition( ).createElement( C6.class );

        parent1.setW( child1 );
        assertEquals( child1, parent1.getW( ) );
        assertEquals( parent1, child1.refImmediateComposite( ) );
        assertNull( parent1.refImmediateComposite( ) );

        parent2.setW( child2 );
        assertEquals( child2, parent2.getW( ) );
        assertEquals( parent2, child2.refImmediateComposite( ) );
        assertNull( parent2.refImmediateComposite( ) );

        try {
            // Now recompose child1 in parent2. As child1 already has a parent, that's not allowed
            parent2.setW( child1 );
            fail( "Expected WrongSizeException to be thrown as container end multiplicity is 1" );
        } catch ( WrongSizeException e ) {
            // expected exception
            // make sure nothing changed
            parent1.setW( child1 );
            assertEquals( child1, parent1.getW( ) );
            assertEquals( parent1, child1.refImmediateComposite( ) );
            assertNull( parent1.refImmediateComposite( ) );
            parent2.setW( child2 );
            assertEquals( child2, parent2.getW( ) );
            assertEquals( parent2, child2.refImmediateComposite( ) );
            assertNull( parent2.refImmediateComposite( ) );
        }

        // Now try the recomposition again by first removing child1 from parent1,
        // then composing it with parent2:
        parent1.setW( null );
        parent2.setW( child1 );
        assertEquals( child1, parent2.getW( ) );

        LogicalLinkManager lam = getLinkActionManager( getMOINConnection( ) );
        EndStorageLink child1ParentLink = lam.getCompositeParentLink( getTestHelper( ).getCoreConnection( getMOINConnection( ) ).getSession( ), getTestHelper( ).getCorePartitionable( child1 ) );
        assertEquals( "Expected child1 to be composed by parent2 now", getTestHelper( ).getCorePartitionable( parent2 ), child1ParentLink.getEnd( child1ParentLink.getCompositeEnd( ) ).get( getTestHelper( ).getCoreConnection( getMOINConnection( ) ).getSession( ) ) );
        assertTrue( "Expected parent1 to have no more children after recomposing a1", lam.getComponentChildrenLinks( getTestHelper( ).getCoreConnection( getMOINConnection( ) ).getSession( ), this.getTestHelper( ).getCorePartitionable( parent1 ) ).size( ) == 0 );
        assertNull( "Expected child2 to be decomposed", lam.getCompositeParentLink( getTestHelper( ).getCoreConnection( getMOINConnection( ) ).getSession( ), this.getTestHelper( ).getCorePartitionable( child2 ) ) );

    }

    /**
     * Creates a number of 1:1 links and then checks that adding another link
     * violates the proper multiplicity constraints and replaces the proper
     * links as required.
     */
    @Test
    public void testAutomaticLinkRemoval( ) throws Exception {


        D6 child1 = getMOINConnection( ).getNullPartition( ).createElement( D6.class );
        C6 parent1 = getMOINConnection( ).getNullPartition( ).createElement( C6.class );

        D6 child2 = getMOINConnection( ).getNullPartition( ).createElement( D6.class );
        C6 parent2 = getMOINConnection( ).getNullPartition( ).createElement( C6.class );

        parent1.setW( child1 );
        assertEquals( child1, parent1.getW( ) );
        assertEquals( parent1, child1.refImmediateComposite( ) );
        assertNull( parent1.refImmediateComposite( ) );

        parent2.setW( child2 );
        assertEquals( child2, parent2.getW( ) );
        assertEquals( parent2, child2.refImmediateComposite( ) );
        assertNull( parent2.refImmediateComposite( ) );

        D6 child3 = getMOINConnection( ).getNullPartition( ).createElement( D6.class );

        ReferenceAtComposite association = getMOINConnection( ).getAssociation( ReferenceAtComposite.ASSOCIATION_DESCRIPTOR );

        this.mp2.assignElement( child1 );
        this.mp2.assignElement( child2 );
        this.mp2.assignElement( child3 );

        parent1.setW( child1 );
        parent2.setW( child2 );

        Workspace w = getClientSpecificWorkspace( this.getMOINConnection( ) );
        try {
            parent2.setW( child1 );
            flop( "Expected WrongSizeException to be thrown, but wasn't" );
        } catch ( WrongSizeException wse ) {
            // expected because the link a2/tp2 must not be removed
            // automatically; rollback
        }
        try {
            // don't use reference to add link; should cause WrongSizeException
            association.add( child3, parent1 );

            flop( "Expected WrongSizeException to be thrown, but wasn't" );
        } catch ( WrongSizeException wse ) {
            // expected because the link a1/tp1 must not be removed
            // automatically
            // when not modifying via reference
            Collection linksForC1 = w.getMemoryLinkManager( ).getLinksForEndAndMetaObject( getTestHelper( ).getCoreConnection( getMOINConnection( ) ).getSession( ),
                                                                                           w.getWorkspaceSet( ).getEndAndMetaObjectPool( ).getEndAndMetaObject( 1, (RefObject) getTestHelper( ).getCorePartitionable( association.refMetaObject( ) ) ), ( (Partitionable) parent1 ).get___Mri( ) );
            assertSame( "Expected still the single old link on c1 but found " + linksForC1.size( ), 1, linksForC1.size( ) );
            EndStorageLink link = (EndStorageLink) linksForC1.iterator( ).next( );
            assertEquals( "Expected to still find the link from op1 to c1 but found link to " + link.getEnd( 0 ).get( getTestHelper( ).getCoreConnection( getMOINConnection( ) ).getSession( ) ), getTestHelper( ).getCorePartitionable( child1 ), link.getEnd( 0 )
                .get( getTestHelper( ).getCoreConnection( getMOINConnection( ) ).getSession( ) ) );
        }
        parent1.setW( child3 );
        Collection<EndStorageLink> linksForEndAndMetaObject = w.getMemoryLinkManager( ).getLinksForEndAndMetaObject( getTestHelper( ).getCoreConnection( getMOINConnection( ) ).getSession( ),
                                                                                                                     w.getWorkspaceSet( ).getEndAndMetaObjectPool( ).getEndAndMetaObject( 0, (RefObject) getTestHelper( ).getCorePartitionable( association.refMetaObject( ) ) ),
                                                                                                                     ( (Partitionable) child1 ).get___Mri( ) );
        assertTrue( "Expected c1 to have been removed implicitly from op1 but wasn't", linksForEndAndMetaObject.isEmpty( ) );
    }

    @Test
    public void testResolvingOfNullMri( ) throws Exception {

        try {
            this.getMOINConnection( ).getElement( (MRI) null );
            fail( "Expected exception" );
        } catch ( IllegalArgumentException e ) {
            // expected
        }
    }

    @Test
    public void testResolvingOfNullLri( ) throws Exception {

        try {
            this.getMOINConnection( ).getElement( (LRI) null );
            fail( "Expected exception" );
        } catch ( IllegalArgumentException e ) {
            // expected
        }
    }

    /**
     * Creates a number of 1:1 links and then checks that adding another link
     * violates the proper multiplicity constraints and replaces the proper
     * links as required.
     */
    @Test
    public void testCompositionCycleDetection( ) throws Exception {

        MofPackage pkg1 = mp1.createElement( MofPackage.class );
        pkg1.setName( "p1" );
        MofPackage pkg2 = mp1.createElement( MofPackage.class );
        pkg2.setName( "p2" );
        MofPackage pkg3 = mp1.createElement( MofPackage.class );
        pkg3.setName( "p3" );
        this.mp1.assignElement( pkg3 );

        pkg2.setContainer( pkg1 );
        pkg3.setContainer( pkg2 );

        try {
            // try to create a composition cycle
            pkg1.setContainer( pkg3 );
            flop( "Expected CompositionCycleException to be thrown but wasn't" );
        } catch ( CompositionCycleException cce ) {
            assertEquals( "Expected error to be caused by pkg1 but was " + cce.getObjectInError( ), pkg1, cce.getObjectInError( ) );
            assertEquals( "Expected element in error to be contains association but was " + cce.getElementInError( ), getMOINConnection( ).getAssociation( Contains.ASSOCIATION_DESCRIPTOR ).refMetaObject( ), cce.getElementInError( ) );
        }
    }

    /**
     * Populates a number of instances and links that are owned by two different
     * partitions into a workspace with its associations container and then
     * tries the effects of evicting one of the two partitions from the
     * workspace.
     */
    @Test
    public void testPartitionEviction( ) throws Exception {

        Connection connection = getMOINConnection( );
        MofPackage mofPackage = mp1.createElement( MofPackage.class );
        mofPackage.setName( "myPackage" );
        MofPackage child = getMOINConnection( ).getNullPartition( ).createElement( MofPackage.class );
        child.setName( "MyContainedPackage" );
        child.setContainer( mofPackage );
        assertTrue( "Expected p to contain c", mofPackage.getContents( ).contains( child ) );
        MofClass child2 = mp2.createElement( MofClass.class );
        child.getContents( ).add( child2 );
        child2.getContents( ).add( mp2.createElement( Attribute.class ) );
        connection.save( );

        CoreModelPartition coreMp1 = getTestHelper( ).getCoreModelPartition( this.mp1 );
        // that's the actual method to test
        Workspace w = coreMp1.getWorkspace( );
        w.getPartitionManager( ).evictPartitionForced( coreMp1 );

        try {
            coreMp1.getWorkspace( );
            fail( "Workspace should have been unloaded by eviction" );
        } catch ( IllegalStateException e ) {
            //expected
        }
        Collection workspaceInstances = w.getInstanceManager( ).getInstances( );
        for ( Iterator i = workspaceInstances.iterator( ); i.hasNext( ); ) {
            Partitionable p = (Partitionable) i.next( );
            ModelPartition partition = p.get___Partition( );

            verify( partition == null || !partition.equals( coreMp1 ), "Found instance that should have been evicted" );

        }
        LogicalLinkManager lam = w.getWorkspaceSet( ).getLogicalLinkManager( );
        SynchronizationManager synchronizationManager = w.getWorkspaceSet( ).getSynchronizationManager( );
        synchronizationManager.acquireReadLock( );
        try {
            Collection linksForTp = lam.getLinksForElement( getTestHelper( ).getCoreConnection( getMOINConnection( ) ).getSession( ), getTestHelper( ).getCorePartitionable( getMOINConnection( ).getElement( child2.get___Mri( ) ) ) );
            verify( linksForTp != null && linksForTp.size( ) == 2, "Expected to find exactly two links referencing " + child2 );
        } finally {
            synchronizationManager.releaseReadLock( );
        }
    }

    /**
     * Tests the <tt>getComposition...</tt> operations.
     * 
     * @throws URISyntaxException
     * @throws InvalidResourceIdentifierException
     */
    @Test
    public void testCompositionLinkRetrieval( ) throws URISyntaxException, InvalidResourceIdentifierException {

        MofPackage mofPackage = mp1.createElement( MofPackage.class );
        mofPackage.setName( "myPackage" );
        MofPackage child = getMOINConnection( ).getNullPartition( ).createElement( MofPackage.class );
        child.setName( "MyContainedPackage" );
        child.setContainer( mofPackage );
        assertTrue( "Expected p to contain c", mofPackage.getContents( ).contains( child ) );
        MofPackage child2 = mp2.createElement( MofPackage.class );
        child.getContents( ).add( child2 );

        Workspace w = getClientSpecificWorkspace( this.getMOINConnection( ) );
        LogicalLinkManager lam = w.getWorkspaceSet( ).getLogicalLinkManager( );
        Collection<EndStorageLink> linksToChildrenOfPackage = lam.getComponentChildrenLinks( getTestHelper( ).getCoreConnection( getMOINConnection( ) ).getSession( ), getTestHelper( ).getCorePartitionable( mofPackage ) );
        MofPackage myClass = null;
        for ( Iterator<EndStorageLink> i = linksToChildrenOfPackage.iterator( ); i.hasNext( ); ) {
            EndStorageLink l = i.next( );
            myClass = (MofPackage) l.getEnd( 1 - l.getCompositeEnd( ) ).get( getTestHelper( ).getCoreConnection( getMOINConnection( ) ).getSession( ) );
        }
        assertEquals( child.refMofId( ), myClass.refMofId( ) );
        EndStorageLink parentLink = lam.getCompositeParentLink( getTestHelper( ).getCoreConnection( getMOINConnection( ) ).getSession( ), getTestHelper( ).getCorePartitionable( myClass ) );
        Partitionable parent = parentLink.getEnd( parentLink.getCompositeEnd( ) ).get( getTestHelper( ).getCoreConnection( getMOINConnection( ) ).getSession( ) );
        assertEquals( "Expected to find myPackage as parent of MyContainedPackage", getTestHelper( ).getCorePartitionable( mofPackage ), parent );
    }

    @Test
    public void testConnectionRevertSimple( ) throws Exception {

        Connection conn = getMOINConnection( );
        ModelPartition partition = getPartitionThree( );



        // create elements in real partition
        MofPackage package01 = partition.createElement( MofPackage.class );
        MofClass class01 = partition.createElement( MofClass.class );
        package01.getContents( ).add( class01 );

        // save / revert
        conn.save( );
        conn.revert( );

        // check elements
        assertEquals( 2, partition.getElements( ).size( ) );
        assertEquals( 0, conn.getNullPartition( ).getElements( ).size( ) );
        assertTrue( partition.getElements( ).contains( package01 ) );
        assertTrue( partition.getElements( ).contains( class01 ) );

        // create more elements in real partition
        MofPackage package02 = partition.createElement( MofPackage.class );
        MofClass class02 = partition.createElement( MofClass.class );

        assertEquals( 4, partition.getElements( ).size( ) );
        assertTrue( partition.getElements( ).contains( package01 ) );
        assertTrue( partition.getElements( ).contains( class01 ) );
        assertTrue( partition.getElements( ).contains( package02 ) );
        assertTrue( partition.getElements( ).contains( class02 ) );

        // create model element in transient partition
        MofPackage package03 = getMOINConnection( ).getNullPartition( ).createElement( MofPackage.class );
        assertEquals( 1, conn.getNullPartition( ).getElements( ).size( ) );
        assertTrue( conn.getNullPartition( ).getElements( ).contains( package03 ) );

        // revert connection
        conn.revert( );

        // check elements
        assertEquals( 2, partition.getElements( ).size( ) );
        assertEquals( 0, getTestHelper( ).getCoreConnection( conn ).getNullPartition( ).getElements( ).size( ) );
        assertTrue( partition.getElements( ).contains( package01 ) );
        assertTrue( partition.getElements( ).contains( class01 ) );
    }

    @Test
    public void testStateOfElementAfterRefDelete( ) throws Exception {

        Connection conn = getMOINConnection( );


        // create element
        MofPackage package01 = conn.getNullPartition( ).createElement( MofPackage.class );
        assertEquals( conn.getNullPartition( ), ( (Partitionable) package01 ).get___Partition( ) );

        // delete element
        package01.refDelete( );

        // isAlive() must be callable without an exception thrown
        assertFalse( "Expected the model element to be dead", ( (Partitionable) package01 ).is___Alive( ) );

        // get___Mri() and get___Connection() must also be callable without an
        // exception thrown.
        ( (Partitionable) package01 ).get___Mri( );
        ( (Partitionable) package01 ).get___Connection( );

        try {
            package01.refDelete( );// this call (or any other call on moin
            // methods except methods above) must result
            // in
            // exception
            fail( "Expected exception" );
        } catch ( InvalidObjectException e ) {
            // expected
        }



    }

    @Test
    public void testStateOfMultiValuedAttributesListAfterRefDelete( ) throws Exception {

        Connection conn = getMOINConnection( );
        // create element

        ModelPackage modelPackage = conn.getPackage( ModelPackage.PACKAGE_DESCRIPTOR );
        EnumerationType enumerationType = (EnumerationType) modelPackage.getEnumerationType( ).refCreateInstance( );
        enumerationType.getLabels( ).add( "label1" );
        enumerationType.getLabels( ).add( "label2" );

        List<String> labels = enumerationType.getLabels( );
        assertEquals( 2, labels.size( ) );
        Iterator<String> iterator = labels.iterator( );
        ListIterator<String> listIterator = labels.listIterator( );
        ListIterator<String> listIteratorWithIndex = labels.listIterator( 0 );
        List<String> subList = labels.subList( 0, 2 );

        enumerationType.refDelete( );

        Collection<String> c = Collections.emptyList( );
        int index = 0;
        Object o = new Object( );
        String element = "dummy";


        //these calls are expected to work, even after refDelete()
        iterator.equals( o );
        iterator.hashCode( );
        iterator.toString( );
        listIterator.equals( o );
        listIterator.hashCode( );
        listIterator.toString( );
        listIteratorWithIndex.equals( o );
        listIteratorWithIndex.hashCode( );
        listIteratorWithIndex.toString( );

        try {
            labels.hashCode( );
            fail( "Expected Exception" );
        } catch ( InvalidObjectException e ) {
            //expected
        }

        try {
            labels.equals( o );
            fail( "Expected Exception" );
        } catch ( InvalidObjectException e ) {
            //expected
        }

        try {
            labels.toString( );
            fail( "Expected Exception" );
        } catch ( InvalidObjectException e ) {
            //expected
        }


        try {
            labels.add( element );
            fail( "Expected Exception" );
        } catch ( InvalidObjectException e ) {
            //expected
        }

        try {
            labels.add( index, element );
            fail( "Expected Exception" );
        } catch ( InvalidObjectException e ) {
            //expected
        }

        try {
            labels.addAll( c );
            fail( "Expected Exception" );
        } catch ( InvalidObjectException e ) {
            //expected
        }

        try {
            labels.subList( 0, 2 );
            fail( "Expected Exception" );
        } catch ( InvalidObjectException e ) {
            //expected
        }

        try {
            labels.listIterator( 0 );
            fail( "Expected Exception" );
        } catch ( InvalidObjectException e ) {
            //expected
        }

        try {
            labels.listIterator( );
            fail( "Expected Exception" );
        } catch ( InvalidObjectException e ) {
            //expected
        }

        try {
            labels.toArray( new String[] {} );
            fail( "Expected Exception" );
        } catch ( InvalidObjectException e ) {
            //expected
        }

        try {
            labels.toArray( );
            fail( "Expected Exception" );
        } catch ( InvalidObjectException e ) {
            //expected
        }
        try {
            labels.size( );
            fail( "Expected Exception" );
        } catch ( InvalidObjectException e ) {
            //expected
        }
        try {
            labels.set( index, element );
            fail( "Expected Exception" );
        } catch ( InvalidObjectException e ) {
            //expected
        }
        try {
            labels.retainAll( c );
            fail( "Expected Exception" );
        } catch ( InvalidObjectException e ) {
            //expected
        }
        try {
            labels.removeAll( c );
            fail( "Expected Exception" );
        } catch ( InvalidObjectException e ) {
            //expected
        }
        try {
            labels.remove( o );
            fail( "Expected Exception" );
        } catch ( InvalidObjectException e ) {
            //expected
        }
        try {
            labels.remove( index );
            fail( "Expected Exception" );
        } catch ( InvalidObjectException e ) {
            //expected
        }
        try {
            labels.lastIndexOf( o );
            fail( "Expected Exception" );
        } catch ( InvalidObjectException e ) {
            //expected
        }
        try {
            labels.iterator( );
            fail( "Expected Exception" );
        } catch ( InvalidObjectException e ) {
            //expected
        }
        try {
            labels.isEmpty( );
            fail( "Expected Exception" );
        } catch ( InvalidObjectException e ) {
            //expected
        }
        try {
            labels.get( index );
            fail( "Expected Exception" );
        } catch ( InvalidObjectException e ) {
            //expected
        }
        try {
            labels.indexOf( o );
            fail( "Expected Exception" );
        } catch ( InvalidObjectException e ) {
            //expected
        }
        try {
            labels.containsAll( c );
            fail( "Expected Exception" );
        } catch ( InvalidObjectException e ) {
            //expected
        }
        try {
            labels.contains( o );
            fail( "Expected Exception" );
        } catch ( InvalidObjectException e ) {
            //expected
        }
        try {
            labels.clear( );
            fail( "Expected Exception" );
        } catch ( InvalidObjectException e ) {
            //expected
        }

        try {
            subList.add( element );
            fail( "Expected Exception" );
        } catch ( InvalidObjectException e ) {
            //expected
        }

        try {
            listIteratorWithIndex.set( element );
            fail( "Expected Exception" );
        } catch ( InvalidObjectException e ) {
            //expected
        }

        try {
            listIteratorWithIndex.remove( );
            fail( "Expected Exception" );
        } catch ( InvalidObjectException e ) {
            //expected
        }

        try {
            listIteratorWithIndex.previousIndex( );
            fail( "Expected Exception" );
        } catch ( InvalidObjectException e ) {
            //expected
        }

        try {
            listIteratorWithIndex.previous( );
            fail( "Expected Exception" );
        } catch ( InvalidObjectException e ) {
            //expected
        }

        try {
            listIteratorWithIndex.nextIndex( );
            fail( "Expected Exception" );
        } catch ( InvalidObjectException e ) {
            //expected
        }

        try {
            listIteratorWithIndex.next( );
            fail( "Expected Exception" );
        } catch ( InvalidObjectException e ) {
            //expected
        }

        try {
            listIteratorWithIndex.hasPrevious( );
            fail( "Expected Exception" );
        } catch ( InvalidObjectException e ) {
            //expected
        }

        try {
            listIteratorWithIndex.hasNext( );
            fail( "Expected Exception" );
        } catch ( InvalidObjectException e ) {
            //expected
        }

        try {
            listIteratorWithIndex.add( element );
            fail( "Expected Exception" );
        } catch ( InvalidObjectException e ) {
            //expected
        }

        try {
            listIterator.set( element );
            fail( "Expected Exception" );
        } catch ( InvalidObjectException e ) {
            //expected
        }

        try {
            listIterator.remove( );
            fail( "Expected Exception" );
        } catch ( InvalidObjectException e ) {
            //expected
        }

        try {
            listIterator.previousIndex( );
            fail( "Expected Exception" );
        } catch ( InvalidObjectException e ) {
            //expected
        }

        try {
            listIterator.previous( );
            fail( "Expected Exception" );
        } catch ( InvalidObjectException e ) {
            //expected
        }

        try {
            listIterator.nextIndex( );
            fail( "Expected Exception" );
        } catch ( InvalidObjectException e ) {
            //expected
        }

        try {
            listIterator.next( );
            fail( "Expected Exception" );
        } catch ( InvalidObjectException e ) {
            //expected
        }

        try {
            listIterator.hasPrevious( );
            fail( "Expected Exception" );
        } catch ( InvalidObjectException e ) {
            //expected
        }

        try {
            listIterator.hasNext( );
            fail( "Expected Exception" );
        } catch ( InvalidObjectException e ) {
            //expected
        }

        try {
            listIterator.add( element );
            fail( "Expected Exception" );
        } catch ( InvalidObjectException e ) {
            //expected
        }

        try {
            iterator.remove( );
            fail( "Expected Exception" );
        } catch ( InvalidObjectException e ) {
            //expected
        }

        try {
            iterator.next( );
            fail( "Expected Exception" );
        } catch ( InvalidObjectException e ) {
            //expected
        }

        try {
            iterator.hasNext( );
            fail( "Expected Exception" );
        } catch ( InvalidObjectException e ) {
            //expected
        }



    }

    @Test
    public void testStateOfMultiValuedAttributesListAfterConnectionClose( ) throws Exception {

        Connection conn = getMOINConnection( );
        // create element
        ModelPackage modelPackage = conn.getPackage( ModelPackage.PACKAGE_DESCRIPTOR );
        EnumerationType enumerationType = (EnumerationType) modelPackage.getEnumerationType( ).refCreateInstance( );
        enumerationType.getLabels( ).add( "label1" );
        enumerationType.getLabels( ).add( "label2" );

        List<String> labels = enumerationType.getLabels( );
        assertEquals( 2, labels.size( ) );
        Iterator<String> iterator = labels.iterator( );
        ListIterator<String> listIterator = labels.listIterator( );
        ListIterator<String> listIteratorWithIndex = labels.listIterator( 0 );
        List<String> subList = labels.subList( 0, 2 );

        conn.close( );

        Collection<String> c = Collections.emptyList( );
        int index = 0;
        Object o = new Object( );
        String element = "dummy";

        //these calls are still expected to work even after connection close
        iterator.equals( o );
        iterator.hashCode( );
        iterator.toString( );
        listIterator.equals( o );
        listIterator.hashCode( );
        listIterator.toString( );
        listIteratorWithIndex.equals( o );
        listIteratorWithIndex.hashCode( );
        listIteratorWithIndex.toString( );


        try {
            labels.hashCode( );
            fail( "Expected Exception" );
        } catch ( InvalidConnectionException e ) {
            //expected
        }

        try {
            labels.equals( o );
            fail( "Expected Exception" );
        } catch ( InvalidConnectionException e ) {
            //expected
        }

        try {
            labels.toString( );
            fail( "Expected Exception" );
        } catch ( InvalidConnectionException e ) {
            //expected
        }

        try {
            labels.add( element );
            fail( "Expected Exception" );
        } catch ( InvalidConnectionException e ) {
            //expected
        }

        try {
            labels.add( index, element );
            fail( "Expected Exception" );
        } catch ( InvalidConnectionException e ) {
            //expected
        }

        try {
            labels.addAll( c );
            fail( "Expected Exception" );
        } catch ( InvalidConnectionException e ) {
            //expected
        }

        try {
            labels.subList( 0, 2 );
            fail( "Expected Exception" );
        } catch ( InvalidConnectionException e ) {
            //expected
        }

        try {
            labels.listIterator( 0 );
            fail( "Expected Exception" );
        } catch ( InvalidConnectionException e ) {
            //expected
        }

        try {
            labels.listIterator( );
            fail( "Expected Exception" );
        } catch ( InvalidConnectionException e ) {
            //expected
        }

        try {
            labels.toArray( new String[] {} );
            fail( "Expected Exception" );
        } catch ( InvalidConnectionException e ) {
            //expected
        }

        try {
            labels.toArray( );
            fail( "Expected Exception" );
        } catch ( InvalidConnectionException e ) {
            //expected
        }
        try {
            labels.size( );
            fail( "Expected Exception" );
        } catch ( InvalidConnectionException e ) {
            //expected
        }
        try {
            labels.set( index, element );
            fail( "Expected Exception" );
        } catch ( InvalidConnectionException e ) {
            //expected
        }
        try {
            labels.retainAll( c );
            fail( "Expected Exception" );
        } catch ( InvalidConnectionException e ) {
            //expected
        }
        try {
            labels.removeAll( c );
            fail( "Expected Exception" );
        } catch ( InvalidConnectionException e ) {
            //expected
        }
        try {
            labels.remove( o );
            fail( "Expected Exception" );
        } catch ( InvalidConnectionException e ) {
            //expected
        }
        try {
            labels.remove( index );
            fail( "Expected Exception" );
        } catch ( InvalidConnectionException e ) {
            //expected
        }
        try {
            labels.lastIndexOf( o );
            fail( "Expected Exception" );
        } catch ( InvalidConnectionException e ) {
            //expected
        }
        try {
            labels.iterator( );
            fail( "Expected Exception" );
        } catch ( InvalidConnectionException e ) {
            //expected
        }
        try {
            labels.isEmpty( );
            fail( "Expected Exception" );
        } catch ( InvalidConnectionException e ) {
            //expected
        }
        try {
            labels.get( index );
            fail( "Expected Exception" );
        } catch ( InvalidConnectionException e ) {
            //expected
        }
        try {
            labels.indexOf( o );
            fail( "Expected Exception" );
        } catch ( InvalidConnectionException e ) {
            //expected
        }
        try {
            labels.containsAll( c );
            fail( "Expected Exception" );
        } catch ( InvalidConnectionException e ) {
            //expected
        }
        try {
            labels.contains( o );
            fail( "Expected Exception" );
        } catch ( InvalidConnectionException e ) {
            //expected
        }
        try {
            labels.clear( );
            fail( "Expected Exception" );
        } catch ( InvalidConnectionException e ) {
            //expected
        }

        try {
            subList.add( element );
            fail( "Expected Exception" );
        } catch ( InvalidConnectionException e ) {
            //expected
        }

        try {
            listIteratorWithIndex.set( element );
            fail( "Expected Exception" );
        } catch ( InvalidConnectionException e ) {
            //expected
        }

        try {
            listIteratorWithIndex.remove( );
            fail( "Expected Exception" );
        } catch ( InvalidConnectionException e ) {
            //expected
        }

        try {
            listIteratorWithIndex.previousIndex( );
            fail( "Expected Exception" );
        } catch ( InvalidConnectionException e ) {
            //expected
        }

        try {
            listIteratorWithIndex.previous( );
            fail( "Expected Exception" );
        } catch ( InvalidConnectionException e ) {
            //expected
        }

        try {
            listIteratorWithIndex.nextIndex( );
            fail( "Expected Exception" );
        } catch ( InvalidConnectionException e ) {
            //expected
        }

        try {
            listIteratorWithIndex.next( );
            fail( "Expected Exception" );
        } catch ( InvalidConnectionException e ) {
            //expected
        }

        try {
            listIteratorWithIndex.hasPrevious( );
            fail( "Expected Exception" );
        } catch ( InvalidConnectionException e ) {
            //expected
        }

        try {
            listIteratorWithIndex.hasNext( );
            fail( "Expected Exception" );
        } catch ( InvalidConnectionException e ) {
            //expected
        }

        try {
            listIteratorWithIndex.add( element );
            fail( "Expected Exception" );
        } catch ( InvalidConnectionException e ) {
            //expected
        }

        try {
            listIterator.set( element );
            fail( "Expected Exception" );
        } catch ( InvalidConnectionException e ) {
            //expected
        }

        try {
            listIterator.remove( );
            fail( "Expected Exception" );
        } catch ( InvalidConnectionException e ) {
            //expected
        }

        try {
            listIterator.previousIndex( );
            fail( "Expected Exception" );
        } catch ( InvalidConnectionException e ) {
            //expected
        }

        try {
            listIterator.previous( );
            fail( "Expected Exception" );
        } catch ( InvalidConnectionException e ) {
            //expected
        }

        try {
            listIterator.nextIndex( );
            fail( "Expected Exception" );
        } catch ( InvalidConnectionException e ) {
            //expected
        }

        try {
            listIterator.next( );
            fail( "Expected Exception" );
        } catch ( InvalidConnectionException e ) {
            //expected
        }

        try {
            listIterator.hasPrevious( );
            fail( "Expected Exception" );
        } catch ( InvalidConnectionException e ) {
            //expected
        }

        try {
            listIterator.hasNext( );
            fail( "Expected Exception" );
        } catch ( InvalidConnectionException e ) {
            //expected
        }

        try {
            listIterator.add( element );
            fail( "Expected Exception" );
        } catch ( InvalidConnectionException e ) {
            //expected
        }

        try {
            iterator.remove( );
            fail( "Expected Exception" );
        } catch ( InvalidConnectionException e ) {
            //expected
        }

        try {
            iterator.next( );
            fail( "Expected Exception" );
        } catch ( InvalidConnectionException e ) {
            //expected
        }

        try {
            iterator.hasNext( );
            fail( "Expected Exception" );
        } catch ( InvalidConnectionException e ) {
            //expected
        }



    }



    @Test
    public void testStateOfElementAfterConnectionClose( ) throws Exception {

        Connection conn = getMOINConnection( );
        MofPackage someMofPackage = conn.createElementInPartition( MofPackage.class, null );
        ModelPackage modelPackage = conn.getPackage( ModelPackage.PACKAGE_DESCRIPTOR );
        MRI mri = ( (Partitionable) modelPackage ).get___Mri( );
        conn.close( );
        // get___Mri() and get___Connection() must still be callable without an
        // exception thrown.
        assertEquals( mri, ( (Partitionable) modelPackage ).get___Mri( ) );
        assertEquals( conn, ( (Partitionable) modelPackage ).get___Connection( ) );
        try {
            ( (Partitionable) modelPackage ).refMofId( );
            fail( "Expected InvalidConnectionException" );
        } catch ( InvalidConnectionException ex ) {
            // expected exception
        }

        // isAlive must always work without exception
        assertFalse( "Connection was closed but element claims to be alive", ( (Partitionable) modelPackage ).is___Alive( ) );

        //modeled operations must also throw the same exception
        try {
            someMofPackage.isFrozen( );
            fail( "Expected InvalidConnectionException" );
        } catch ( InvalidConnectionException e ) {
            //expected exception
        }

    }

    @Test
    public void testStateOfPartitionAfterDelete( ) throws Exception {

        ModelPartition partition = getPartitionOne( );
        assertTrue( "Expected the partition to be alive", partition.isAlive( ) );
        PRI pri = partition.getPri( );

        // delete the partition
        partition.delete( );

        // must be callable without an exception thrown
        assertEquals( pri, partition.getPri( ) );

        // must be callable without an exception thrown
        assertFalse( "Expected the partiton to be dead", partition.isAlive( ) );

        // getPri() must be callable without an exception thrown
        assertEquals( pri, partition.getPri( ) );

        try {
            partition.delete( ); // this call (or any other call on moin methods
            // except the above tested) must result in
            // exception
            fail( "Expected exception" );
        } catch ( InvalidModelPartitionException e ) {
            // expected
        }
    }

    @Test
    public void testStateOfPartitionAfterConnectionClose( ) throws Exception {

        Connection connection = getMOINConnection( );
        ModelPartition partitionOne = this.getPartitionOne( );
        connection.close( );

        // isAlive() must be functional even after connection was closed
        assertFalse( "Expected model partition to be dead after closing connection", partitionOne.isAlive( ) );

        try {
            partitionOne.getElements( ); // this and any other moin calls (except
            // the methods above) must result in an
            // exception.
            fail( "Expected exception" );
        } catch ( InvalidModelPartitionException e ) {
            // expected
        }

        // isAlive must always work without exception
        assertFalse( "Connection was closed, but partition claims to be alive", partitionOne.isAlive( ) );
    }

    @Test
    public void testStateOfConnectionWrapperAfterMoinShutdown( ) throws Exception {

        CompoundClientSpec compoundClientSpec = _testClient1.getConnection( ).getSession( ).getCompoundClientSpec( );
        Connection connection = getTestHelper( ).getMoin( ).createSession( compoundClientSpec ).createConnection( );
        getTestHelper( ).reset( );
        try {
            connection.getCommandStack( );
            fail( "Expected Exception" );
        } catch ( InvalidConnectionException e ) {
            //expected
        }
    }

    @Test
    public void testStateOfConnectionAndSessionAndRelatedEntitiesAfterClose( ) throws Exception {

        Connection connection = getMOINConnection( );
        Session session = connection.getSession( );
        EventRegistry eventRegistry = session.getEventRegistry( );
        EventRegistry eventRegistry2 = connection.getEventRegistry( );
        JmiHelper jmiHelper = connection.getJmiHelper( );
        MQLProcessor processor = connection.getMQLProcessor( );
        CommandStack commandStack = connection.getCommandStack( );
        XmiReader xmiReader = connection.getXmiReader( );
        XmiWriter xmiWriter = connection.getXmiWriter( );
        OclRegistryService oclRegistryService = connection.getOclRegistryService( );
        OclFreestyleRegistry freestyleRegistry = oclRegistryService.getFreestyleRegistry( );
        OclMetamodelConstraintRegistry metamodelConstraintRegistry = oclRegistryService.getMetamodelConstraintRegistry( );

        OclMetaModelConstraintRegistration oclMetaModelConstraintRegistration = metamodelConstraintRegistry.getAvailableMetamodelConstraints( ).iterator( ).next( );

        RefPackage targetPackage = connection.getPackage( TestMetaModels.SERVICE_INTERACTIONS_CN, TestMetaModels.SERVICE_INTERACTIONS_TPE );
        RefClass messageClass = targetPackage.refClass( "Message" );
        RefPackage[] types = new RefPackage[] { targetPackage };

        OclExpressionRegistration oclExpressionRegistration = freestyleRegistry.createExpressionRegistration( "SomeName", "self.type", OclRegistrationSeverity.Error, new String[] { "SomeImmediate" }, messageClass, types );

        OclInvariantRegistration oclInvariantRegistration = freestyleRegistry.createInvariantRegistration( "OtherName", "inv: self.reply_to.reply_to->excludes(self)", OclRegistrationSeverity.Warning, new String[] { "OtherCategory" }, messageClass, types );

        connection.close( );
        assertFalse( "Expected connection to be dead", connection.isAlive( ) );
        connection.close( ); // Must work (no-op).

        // session was closed implicitly as there is only one connection per
        // session
        assertFalse( "Expected session to be dead", session.isAlive( ) );
        try {
            connection.getPartitionsToBeSaved( ); // this call (or any other
            // call on moin methods
            // except isAlive() and
            // close()) must result in
            // exception
            fail( "Expected exception" );
        } catch ( InvalidConnectionException e ) {
            // expected
        }

        try {
            session.getMoin( ); // this call (or any other call on moin methods
            // except isAlive()) must result in
            // exception
            fail( "Expected exception" );
        } catch ( InvalidSessionException e ) {
            // expected
        }

        try {
            jmiHelper.getAssociationEnds( (Association) targetPackage.refAllAssociations( ).iterator( ).next( ) );
            fail( "Expected exception" );
        } catch ( InvalidConnectionException e ) {
            // expected
        }

        try {
            xmiReader.getImportService( );
            fail( "Expected exception" );
        } catch ( InvalidConnectionException e ) {
            // expected
        }

        try {
            xmiWriter.write( null, (Collection) null, null );
            fail( "Expected exception" );
        } catch ( InvalidConnectionException e ) {
            // expected
        }

        try {
            commandStack.execute( null );
            fail( "Expected exception" );
        } catch ( InvalidConnectionException e ) {
            // expected
        }

        try {
            processor.execute( (MQLQuery) null );
            fail( "Expected exception" );
        } catch ( InvalidConnectionException e ) {
            // expected
        }

        try {
            oclRegistryService.analyzeCollectedEvents( null );
            fail( "Expected exception" );
        } catch ( InvalidConnectionException e ) {
            // expected
        }

        try {
            freestyleRegistry.getRegistration( null );
            fail( "Expected exception" );
        } catch ( InvalidConnectionException e ) {
            // expected
        }

        try {
            metamodelConstraintRegistry.getAvailableMetamodelConstraints( );
            fail( "Expected exception" );
        } catch ( InvalidConnectionException e ) {
            // expected
        }

        try {
            oclMetaModelConstraintRegistration.getCategories( );
            fail( "Expected exception" );
        } catch ( InvalidConnectionException e ) {
            // expected
        }

        try {
            oclExpressionRegistration.getCategories( );
            fail( "Expected exception" );
        } catch ( InvalidConnectionException e ) {
            // expected
        }

        try {
            oclInvariantRegistration.getCategories( );
            fail( "Expected exception" );
        } catch ( InvalidConnectionException e ) {
            // expected
        }

        UpdateListener listener = new UpdateListener( ) {

            public void notifyUpdate( EventChain events ) {

                //doNothing

            }
        };


        EventTypeFilter eventTypeFilter = new EventTypeFilter( );

        try {
            eventRegistry2.registerUpdateListener( listener, eventTypeFilter );
            fail( "Expected exception" );
        } catch ( InvalidConnectionException e ) {
            // expected
        }

        try {
            eventRegistry.registerUpdateListener( listener, eventTypeFilter );
            fail( "Expected exception" );
        } catch ( InvalidSessionException e ) {
            // expected
        }

    }

    @Test
    public void testResolveInvalidMri( ) throws Exception {

        MofPackage mofPackage = mp1.createElement( MofPackage.class );
        Connection connection = getMOINConnection( );

        Facility facility = getTestHelper( ).getMoin( ).getFacilityById( PrimaryFacility.FACILITY_ID );
        ResourceIdentifierFactory resourceIdentifierFactory = facility.getRIFactory( );
        String nonExistingPri = getPartitionOne( ).getPri( ).toString( ) + makePartitionName( "doesNotExist" );
        PRI pri = resourceIdentifierFactory.createPri( nonExistingPri );
        MRI mri = pri.createMri( mofPackage.refMofId( ) );
        assertNull( connection.getElement( mri ) );

    }

    @Test
    public void testConnectionRevertAdvanced( ) throws Exception {

        // get connection and umltypes package
        Connection connection = getMOINConnection( );
        connection.save( ); // do that to make sure that partitionOne is saved
        // before the first revert() is called
        // because otherwise the partition will be invalid

        ModelPartition newPartition = this._testClient1.getOrCreatePartition( "MyPartition_" + System.currentTimeMillis( ) );

        assertTrue( newPartition.isAlive( ) );
        connection.revert( );
        assertFalse( newPartition.isAlive( ) );


        // create element in null-Partition
        MofPackage package01 = getMOINConnection( ).getNullPartition( ).createElement( MofPackage.class );
        assertEquals( connection.getNullPartition( ), ( (Partitionable) package01 ).get___Partition( ) );
        assertTrue( ( (Partitionable) package01 ).is___Alive( ) );
        connection.revert( );
        assertFalse( ( (Partitionable) package01 ).is___Alive( ) );

        // change of primitive Attribute
        MofClass mofClass = getMOINConnection( ).getNullPartition( ).createElement( MofClass.class );
        ModelPartition partition = getPartitionOne( );
        partition.assignElement( mofClass );
        assertEquals( partition, ( (Partitionable) mofClass ).get___Partition( ) );
        String originalName = "MyClass";
        String newName = "MyChangedClass";
        mofClass.setName( originalName );
        connection.save( );
        assertEquals( originalName, mofClass.getName( ) );
        mofClass.setName( newName );
        assertEquals( newName, mofClass.getName( ) );
        connection.revert( );
        assertEquals( originalName, mofClass.getName( ) );

        //adding of link

        MofPackage mofPackage = getMOINConnection( ).getNullPartition( ).createElement( MofPackage.class );
        assertNull( mofClass.getContainer( ) );
        assertNull( mofClass.refImmediateComposite( ) );
        mofClass.setContainer( mofPackage );
        assertEquals( mofPackage, mofClass.getContainer( ) );
        assertEquals( mofPackage, mofClass.refImmediateComposite( ) );
        connection.revert( );
        assertNull( mofClass.getContainer( ) );
        assertNull( mofClass.refImmediateComposite( ) );

        // removal of link
        mofPackage = getMOINConnection( ).getNullPartition( ).createElement( MofPackage.class );
        partition.assignElement( mofPackage );
        mofClass.setContainer( mofPackage );
        assertEquals( mofPackage, mofClass.getContainer( ) );
        assertEquals( mofPackage, mofClass.refImmediateComposite( ) );
        connection.save( );
        assertEquals( mofPackage, mofClass.getContainer( ) );
        assertEquals( mofPackage, mofClass.refImmediateComposite( ) );

        mofClass.setContainer( null );
        assertNull( mofClass.getContainer( ) );
        assertNull( mofClass.refImmediateComposite( ) );

        connection.revert( );
        assertEquals( mofPackage, mofClass.getContainer( ) );
        assertEquals( mofPackage, mofClass.refImmediateComposite( ) );

        // do it again in order to see if nothing remains cached etc.
        mofClass.setContainer( null );
        assertNull( mofClass.getContainer( ) );
        assertNull( mofClass.refImmediateComposite( ) );

        connection.revert( );
        assertEquals( mofPackage, mofClass.getContainer( ) );
        assertEquals( mofPackage, mofClass.refImmediateComposite( ) );

        // deletion of model partition
        assertTrue( partition.isAlive( ) );
        Collection elementsInPartition = partition.getElements( );
        partition.delete( );
        assertFalse( partition.isAlive( ) );

        connection.revert( );

        assertTrue( partition.isAlive( ) );
        assertEquals( elementsInPartition, partition.getElements( ) );

        // deletion of element

        mofPackage.refDelete( );// must also delete component child 
        // due to composition delete propagation
        assertFalse( ( (Partitionable) mofPackage ).is___Alive( ) );
        assertFalse( ( (Partitionable) mofClass ).is___Alive( ) );

        connection.revert( );
        assertTrue( ( (Partitionable) mofPackage ).is___Alive( ) );
        assertTrue( ( (Partitionable) mofClass ).is___Alive( ) );
        assertEquals( mofPackage, mofClass.getContainer( ) );
        assertEquals( mofPackage, mofClass.refImmediateComposite( ) );

        // explicit repartitioning

        ModelPartition otherPartition = getPartitionTwo( );
        assertEquals( partition, ( (Partitionable) mofClass ).get___Partition( ) );
        assertFalse( partition.equals( otherPartition ) );

        otherPartition.assignElement( mofClass );
        assertEquals( otherPartition, ( (Partitionable) mofClass ).get___Partition( ) );

        connection.revert( );
        assertEquals( partition, ( (Partitionable) mofClass ).get___Partition( ) );

        // implicit repartitioning

        assertEquals( mofPackage, mofClass.getContainer( ) );
        assertEquals( mofPackage, mofClass.refImmediateComposite( ) );
        assertEquals( partition, ( (Partitionable) mofClass ).get___Partition( ) );
        assertFalse( connection.getNullPartition( ).equals( partition ) );

        mofClass.setContainer( null ); // mofClass must go to the nullPartition
        // now as it loses its parent
        assertNull( mofClass.getContainer( ) );
        assertNull( mofClass.refImmediateComposite( ) );
        assertEquals( connection.getNullPartition( ), ( (Partitionable) mofClass ).get___Partition( ) );

        connection.revert( );

        assertEquals( mofPackage, mofClass.getContainer( ) );
        assertEquals( mofPackage, mofClass.refImmediateComposite( ) );
        assertEquals( partition, ( (Partitionable) mofClass ).get___Partition( ) );
        assertFalse( connection.getNullPartition( ).equals( partition ) );

        // do it again to see if the revert was correct
        mofClass.setContainer( null ); // mofClass must go to the nullPartition
        // now as it loses its parent
        assertNull( mofClass.getContainer( ) );
        assertNull( mofClass.refImmediateComposite( ) );
        assertEquals( connection.getNullPartition( ), ( (Partitionable) mofClass ).get___Partition( ) );

    }

    @Test
    public void testStateOfNewlyCreatedElementsAfterRevert( ) throws Exception {

        // get connection and uml package
        Connection conn = getMOINConnection( );

        // create element in null-Partition
        MofPackage package01 = conn.getNullPartition( ).createElement( MofPackage.class );

        assertTrue( ( (Partitionable) package01 ).is___Alive( ) );

        // revert the connection
        conn.revert( );

        assertFalse( ( (Partitionable) package01 ).is___Alive( ) );
        try {

            package01.refMofId( );// calling a moin method on this object must
            // result in an exception
            fail( "Expected exception" );
        } catch ( InvalidObjectException e ) {
            // expected
        }

        // Creation of a model partition

        ModelPartition newlyCreatedPartition = this._testClient1.getOrCreatePartition( "MyPartition_" + System.currentTimeMillis( ) );
        assertTrue( newlyCreatedPartition.isAlive( ) );

        conn.revert( );

        assertFalse( ( newlyCreatedPartition.isAlive( ) ) );

        try {

            newlyCreatedPartition.isDirty( );
            fail( "Expected exception" );
        } catch ( InvalidModelPartitionException e ) {
            // expected
        }

    }

    public void testGetJmiInterface( ) throws Exception {

        ModelPackage up = getMOINConnection( ).getPackage( ModelPackage.PACKAGE_DESCRIPTOR );

        // package
        Class jmiInterfaceModelPackage = ( (Partitionable) up ).get___JmiInterface( );
        assertEquals( ModelPackage.class, jmiInterfaceModelPackage );

        // class
        MofClass mofClass = getMOINConnection( ).getNullPartition( ).createElement( MofClass.class );
        Class jmiInterfaceMofClass = ( (Partitionable) mofClass ).get___JmiInterface( );
        assertEquals( MofClass.class, jmiInterfaceMofClass );

        // class proxy
        Class jmiInterfaceMofClassClass = ( (Partitionable) mofClass.refClass( ) ).get___JmiInterface( );
        assertEquals( RefClass.class, jmiInterfaceMofClassClass );

        // association
        Contains associationContains = getMOINConnection( ).getAssociation( Contains.ASSOCIATION_DESCRIPTOR );
        Class jmiInterfaceContains = ( (Partitionable) associationContains ).get___JmiInterface( );
        assertEquals( Contains.class, jmiInterfaceContains );
    }

    @Test
    public void testMarkPartitionsDirty( ) throws Exception {

        MofPackage p = mp1.createElement( MofPackage.class );
        p.setName( "myPackage" );
        MofPackage child = getMOINConnection( ).getNullPartition( ).createElement( MofPackage.class );
        child.setName( "MyContainedPackage" );
        child.setContainer( p );
        assertTrue( "Expected p to contain c", p.getContents( ).contains( child ) );
        MofClass child2 = mp2.createElement( MofClass.class );
        child.getContents( ).add( child2 );
        getMOINConnection( ).save( );
        ModelPartition partition = getPartitionThree( );
        assertFalse( partition.isDirty( ) );

        // Repartitioning must make a partition dirty
        Partitionable tp_Partitionable = child2;
        assertTrue( "Expected other partition assignment", !tp_Partitionable.get___Partition( ).equals( partition ) );
        partition.assignElement( tp_Partitionable );
        assertDirty( partition );
        getMOINConnection( ).save( );
        assertFalse( partition.isDirty( ) );

        // Adding a link must make a partition dirty

        child2.setContainer( p );
        assertDirty( mp1 );
        getMOINConnection( ).save( );
        assertFalse( mp1.isDirty( ) );

        assertFalse( getTestHelper( ).getCoreSession( getMOINConnection( ).getSession( ) ).getWorkspace( ).hasPrivateCopies( ) );

        // Removing a link must make a partition dirty
        child2.setContainer( null );
        assertDirty( mp1 );
        getPartitionThree( ).assignElement( child2 );
        getMOINConnection( ).save( );
        assertFalse( mp1.isDirty( ) );

        // Creation of a model partition must make it dirty
        ModelPartition newPartition = this._testClient1.getOrCreatePartition( String.valueOf( System.currentTimeMillis( ) ) );
        assertDirty( newPartition );
        getMOINConnection( ).save( );

        // Changing a primitive value must make a partition dirty
        partition = ( (Partitionable) p ).get___Partition( );
        assertFalse( partition.isDirty( ) );
        p.setAbstract( !p.isAbstract( ) );
        assertDirty( partition );
        getMOINConnection( ).save( );

        // Deleting a model element must make a partition dirty
        MofPackage myPackage = getMOINConnection( ).getNullPartition( ).createElement( MofPackage.class );
        ( (Partitionable) myPackage ).assign___Partition( newPartition );
        verify( ( (Partitionable) myPackage ).get___Partition( ).equals( newPartition ), "Expected other partition assignment" );
        getMOINConnection( ).save( );
        myPackage.refDelete( );
        assertDirty( newPartition );
    }

    private void assertDirty( ModelPartition partition ) {

        assertTrue( "Expected partition to be dirty", partition.isDirty( ) );
    }

    @Test
    public void testNewElementBehaviour( ) throws Exception {


        Partitionable newPackage = getMOINConnection( ).getNullPartition( ).createElement( MofPackage.class );
        CorePartitionable coreNewPackage = getTestHelper( ).getCorePartitionable( newPackage );
        assertTrue( "Expected element to be new", getTestHelper( ).getCoreConnection( getMOINConnection( ) ).isNewElement( coreNewPackage ) );

        getMOINConnection( ).revert( ); // to make sure there are no new
        // elements

        CoreConnection connection = getTestHelper( ).getCoreConnection( getMOINConnection( ) );
        assertTrue( "Epxected no new elements at all", connection.getNewElements( ).isEmpty( ) );

        newPackage = getMOINConnection( ).getNullPartition( ).createElement( MofPackage.class );
        coreNewPackage = getTestHelper( ).getCorePartitionable( newPackage );
        assertTrue( "Expected element to be new", getTestHelper( ).getCoreConnection( getMOINConnection( ) ).isNewElement( coreNewPackage ) );
        assertTrue( "Expected element to be contained", connection.getNewElements( ).contains( coreNewPackage ) );
        assertTrue( "Expected other number of elements", connection.getNewElements( ).size( ) == 1 );

    }

    @Test
    public void testPartitionsToBeSaved( ) throws Exception {

        MofPackage p = mp1.createElement( MofPackage.class );
        p.setName( "myPackage" );
        MofClass child2 = mp2.createElement( MofClass.class );

        ModelPartition partitionOne = this.getPartitionOne( );
        ModelPartition partitionTwo = this.getPartitionTwo( );
        ModelPartition partitionThree = this.getPartitionThree( );

        partitionOne.assignElement( child2 );
        partitionTwo.assignElement( child2 );
        partitionThree.assignElement( child2 );
        this.getMOINConnection( ).getNullPartition( ).assignElement( child2 );

        Collection<ModelPartition> dirtyPartitions = this.getMOINConnection( ).getPartitionsToBeSaved( );
        assertSame( 3, dirtyPartitions.size( ) );
        assertTrue( dirtyPartitions.contains( partitionOne ) );
        assertTrue( dirtyPartitions.contains( partitionTwo ) );
        assertTrue( dirtyPartitions.contains( partitionThree ) );
        assertFalse( dirtyPartitions.contains( this.getMOINConnection( ).getNullPartition( ) ) );
        assertTrue( getMOINConnection( ).isDirty( ) );

        this.getMOINConnection( ).getNullPartition( ).deleteElements( );// so it
        // can
        // be
        // saved
        this.getMOINConnection( ).save( );

        // directly after save, nothing must be returned
        dirtyPartitions = this.getMOINConnection( ).getPartitionsToBeSaved( );
        assertTrue( "Expected dirty partitions to be empty", dirtyPartitions.isEmpty( ) );
        assertTrue( !getMOINConnection( ).isDirty( ) );

        // even if the null partition is not empty, it must not be included. A
        // newly created element is in the null
        // partition.

        MofPackage myPackage = getMOINConnection( ).getNullPartition( ).createElement( MofPackage.class );
        assertEquals( this.getMOINConnection( ).getNullPartition( ), ( (Partitionable) myPackage ).get___Partition( ) );

        dirtyPartitions = this.getMOINConnection( ).getPartitionsToBeSaved( );
        assertSame( 0, dirtyPartitions.size( ) );
        assertFalse( dirtyPartitions.contains( this.getMOINConnection( ).getNullPartition( ) ) );
        assertTrue( getMOINConnection( ).isDirty( ) );

        // an only in memory deleted partition is also considered "dirty" and
        // must therefore be part of the dirty
        // partitions ("dirty delete" semantics)
        ModelPartition partitionToBeDeleted = this.getPartitionOne( );
        assertFalse( partitionToBeDeleted.isDirty( ) );
        partitionToBeDeleted.delete( );
        dirtyPartitions = this.getMOINConnection( ).getPartitionsToBeSaved( );

        assertSame( 1, dirtyPartitions.size( ) );
        assertFalse( dirtyPartitions.contains( this.getMOINConnection( ).getNullPartition( ) ) );
        assertTrue( dirtyPartitions.contains( partitionToBeDeleted ) );

    }

    @Test
    public void testConcurrentIsAlive( ) throws Exception {

        MofPackage p = mp1.createElement( MofPackage.class );
        p.setName( "myPackage" );
        MofPackage child = getMOINConnection( ).getNullPartition( ).createElement( MofPackage.class );
        child.setName( "MyContainedPackage" );
        child.setContainer( p );
        assertTrue( "Expected p to contain c", p.getContents( ).contains( child ) );
        MofClass child2 = mp2.createElement( MofClass.class );
        child.getContents( ).add( child2 );
        getMOINConnection( ).revert( );// in order to make sure that p is
        // unresolved
        SecondClient newClient = new SecondClient( p );
        newClient.start( );
        newClient.join( );
        Exception exception = newClient.getException( );
        if ( exception != null ) {
            throw exception;
        }
    }

    @Test
    public void testSaveWithoutDirtyPartitions( ) throws Exception {

        // First save the dirty stuff created in the "Before" method
        getMOINConnection( ).save( );

        // NOW, we can test the save without dirty partitions
        getMOINConnection( ).save( );
    }



    @Test
    public void testResolvingOfOnlyInMemoryExistingPartitionOfOtherConnection( ) throws Exception {

        ModelPartition newPartitionConnection1 = this._testClient1.getOrCreatePartition( "temporaryNew_" + System.currentTimeMillis( ) );
        assertNull( getSecondMOINConnection( ).getPartition( newPartitionConnection1.getPri( ) ) );
    }

    @Test
    public void testSynchronization( ) throws Exception {

        Connection connection = getMOINConnection( );
        final ModelPackage modelPackage = connection.getPackage( ModelPackage.PACKAGE_DESCRIPTOR );

        final ModelPartition partition = getPartitionOne( );
        partition.deleteElements( );// to make sure there is nothing unexpected
        // in this partition
        final CoreModelPartition corePartition = getTestHelper( ).getCoreModelPartition( partition );
        final Workspace workspace = corePartition.getWorkspace( );

        ModelPartition nullPartition = getMOINConnection( ).getNullPartition( );
        for ( int i = 0; i < 1000; i++ ) {
            MofPackage package1 = nullPartition.createElement( MofPackage.class );
            partition.assignElement( package1 );
        }
        connection.getNullPartition( ).deleteElements( );
        connection.save( );

        Thread evilEvictThread = new Thread( "EvilEvictThread" ) {

            @Override
            public void run( ) {

                // pseudo call in order to attach connection to thread
                modelPackage.getAttachesTo( );

                // do the evil eviction
                ( (PartitionManagerImpl) workspace.getPartitionManager( ) ).evictPartitionForced( corePartition );

            }

        };

        evilEvictThread.start( );
        Collection<Partitionable> elements = partition.getElements( );

        int i = 0;
        for ( Partitionable element : elements ) {

            // try several methods which are handled differently in the Wrapper
            MofPackage package1 = (MofPackage) element;
            package1.setName( "myPackage" + i );
            package1.toString( );
            element.hashCode( );
            element.equals( null );
            element.is___Alive( );
            element.get___Connection( );
            element.get___Mri( );

            i++;
        }

        // very unlikely, but make sure that the other thread doesn't still run
        // when this main thread is done
        evilEvictThread.join( );

    }

    @Test
    public void testNullPartitionNotEmptyException( ) throws Exception {

        MofPackage p = getMOINConnection( ).getNullPartition( ).createElement( MofPackage.class );
        this.getMOINConnection( ).getNullPartition( ).assignElement( p );
        assertEquals( this.getMOINConnection( ).getNullPartition( ), ( (Partitionable) p ).get___Partition( ) );
        try {
            getMOINConnection( ).save( );
            fail( "Expected exception" );
        } catch ( NullPartitionNotEmptyException e ) {
            // expected
            e.getMessage( );// just to check if the call doesn't produce an
            // exception
            assertEquals( getMOINConnection( ).getNullPartition( ).getPri( ), e.getPri( ) );
        }
    }

    @Test( timeout = 30000 )
    public void testNoDeadlockWithHalfSynchronousEventListening( ) throws Exception {

        Connection connection = getMOINConnection( );
        ChangeListener listener = new HalfSynchronousListener( );
        connection.getSession( ).getEventRegistry( ).registerListener( listener, new EventTypeFilter( ElementCreateEvent.class ) );

        // write lock needed for creating an object
        getMOINConnection( ).getNullPartition( ).createElement( MofClass.class );
    }

    @Test
    public void testNoDeadlockInSave( ) throws Exception {

        Connection connection = getMOINConnection( );
        ChangeListener listener = new HalfSynchronousListener( );
        connection.getSession( ).getEventRegistry( ).registerListener( listener, new EventTypeFilter( PartitionSaveEvent.class ) );


        // write lock needed for creating an object
        MofClass mofClass = getMOINConnection( ).getNullPartition( ).createElement( MofClass.class );
        getPartitionOne( ).assignElement( mofClass );

        connection.save( );
    }

    private class HalfSynchronousListener implements ChangeListener {

        public void notify( ChangeEvent event ) {

            HalfSynchronousThread halfSynchronousThread = new HalfSynchronousThread( event );
            // start the new thread and then join it -> if the write lock isn't
            // released before the events are fired,
            // the new thread tries to get a read lock but will not get it until
            // the write lock is released, but as we
            // are joining the new thread, this will never happen if not already
            // done
            halfSynchronousThread.start( );
            try {
                halfSynchronousThread.join( );
            } catch ( InterruptedException e ) {
                throw new RuntimeException( e );
            }

        }

    }

    private class HalfSynchronousThread extends Thread {

        private ChangeEvent event;

        public HalfSynchronousThread( ChangeEvent event ) {

            this.event = event;
        }

        @Override
        public void run( ) {

            this.event.getEventTriggerConnection( ).getNullPartition( );
        }

    }

    private class SecondClient extends Thread {

        private Partitionable element;

        private volatile Exception exception;

        public SecondClient( Partitionable element ) {

            this.element = element;
        }

        @Override
        public void run( ) {

            try {
                this.element.is___Alive( );
            } catch ( Exception e ) {
                this.exception = e;
            }
        }

        public Exception getException( ) {

            return this.exception;
        }

    }

    private class ConnectionReader extends Thread {

        private final Connection connection;

        private final int max;

        public ConnectionReader( Connection connection, int max ) {

            this.connection = connection;
            this.max = max;
            setName( "ConnectionReader" );
        }

        @Override
        public void run( ) {

            synchronized ( this.connection ) {
                try {
                    this.connection.wait( );
                } catch ( InterruptedException e ) {
                }
            }
            for ( int i = 0; i < this.max; i++ ) {
                this.connection.getNullPartition( );
            }
        }
    }

    @Test( timeout = 30000 )
    public void testConcurrentReadWriteOnSameConnection( ) throws Exception {

        ModelPackage up = getMOINConnection( ).getPackage( ModelPackage.PACKAGE_DESCRIPTOR );
        MofPackage p = mp1.createElement( MofPackage.class );
        p.setName( "myPackage" );
        MofPackage child = getMOINConnection( ).getNullPartition( ).createElement( MofPackage.class );
        child.setName( "MyContainedPackage" );
        child.setContainer( p );

        int max = 10;

        List<MofClass> parameters = new ArrayList( );
        for ( int i = 0; i < max; i++ ) {
            parameters.add( getMOINConnection( ).getNullPartition( ).createElement( MofClass.class ) );
        }

        Connection connection = getMOINConnection( );
        ChangeListener listener = new DeadLockListener( );
        connection.getSession( ).getEventRegistry( ).registerListener( listener, new EventTypeFilter( LinkAddEvent.class ) );
        new ConnectionReader( connection, max ).start( );
        Thread.sleep( 100 );
        synchronized ( connection ) {
            connection.notify( );
        }
        for ( int i = 0; i < max; i++ ) {
            child.getContents( ).add( parameters.get( i ) );
        }
    }

    private class DeadLockListener implements ChangeListener {

        public void notify( ChangeEvent event ) {

            ( (LinkAddEvent) event ).getFirstLinkEnd( getMOINConnection( ) );
        }

    }

    private class ExceptionListener implements UpdateListener, PreCommitListener, CommitListener, PreChangeListener, ChangeListener {

        public boolean wasCalled = false;

        public void notifyUpdate( EventChain events ) {

            wasCalled = true;
            throw new RuntimeException( "I'm an update listener which always throws an exception :-)" );

        }

        public void prepareCommit( EventChain events ) {

            wasCalled = true;
            throw new RuntimeException( "I'm an update listener which always throws an exception :-)" );

        }

        public void notifyCommit( EventChain events ) {

            wasCalled = true;
            throw new RuntimeException( "I'm an update listener which always throws an exception :-)" );

        }

        public void prepare( ChangeEvent event ) {

            wasCalled = true;
            throw new RuntimeException( "I'm an update listener which always throws an exception :-)" );

        }

        public void notify( ChangeEvent event ) {

            wasCalled = true;
            throw new RuntimeException( "I'm an update listener which always throws an exception :-)" );

        }

    }

    @Test
    public void testUnresolvableWrapperParameter( ) throws Exception {

        Connection conn1 = getMOINConnection( );
        ModelPackage mpkg1 = (ModelPackage) conn1.getPackage( TestMetaModels.MOIN_MOF_CN, TestMetaModels.MOIN_MOF_TPE_MODEL );
        MofClass mofClass = (MofClass) mpkg1.getMofClass( ).refCreateInstance( );
        Connection conn2 = getSecondMOINConnection( );
        ModelPackage mpkg2 = (ModelPackage) conn2.getPackage( TestMetaModels.MOIN_MOF_CN, TestMetaModels.MOIN_MOF_TPE_MODEL );
        Tag tag = (Tag) mpkg2.getTag( ).refCreateInstance( );
        AttachesTo attachesTo = mpkg2.getAttachesTo( );
        try {
            attachesTo.add( mofClass, tag );
            fail( "Expected exception" );
        } catch ( UnresolvableException ex ) {
        }
    }



    @Test
    public void testModelElementToExtent( ) throws Exception {

        CompanyPackage companyPackage = getMOINConnection( ).getPackage( CompanyPackage.PACKAGE_DESCRIPTOR );
        JmiHelper jmiHelper = getMOINConnection( ).getJmiHelper( );
        MofPackage mofPackage = companyPackage.refMetaObject( );
        RefPackage refPackage = jmiHelper.getRefPackageForMofPackage( mofPackage );
        assertTrue( refPackage instanceof CompanyPackage );

        Division div = (Division) companyPackage.getDivision( ).refCreateInstance( );
        MofClass mofClass = (MofClass) div.refMetaObject( );
        RefClass refClass = jmiHelper.getRefClassForMofClass( mofClass );
        assertEquals( refClass.refMetaObject( ), mofClass );

        ModelPackage modelPackage = getMOINConnection( ).getPackage( ModelPackage.PACKAGE_DESCRIPTOR );
        Association association = modelPackage.getContains( ).refMetaObject( );
        RefAssociation refAssociation = jmiHelper.getRefAssociationForAssociation( association );
        assertTrue( refAssociation instanceof Contains );
    }

    @Test
    public void testHashCodeAfterRepartitioning( ) throws Exception {

        MofPackage pkg1 = getMOINConnection( ).getNullPartition( ).createElement( MofPackage.class );
        int hashCodeBefore = pkg1.hashCode( );
        assertFalse( ( (Partitionable) pkg1 ).get___Partition( ).equals( getPartitionOne( ) ) );
        getPartitionOne( ).assignElement( pkg1 );
        int hashCodeAfter = pkg1.hashCode( );
        assertTrue( hashCodeAfter == hashCodeBefore );
    }

    @Test
    public void testMixingElementsFromDifferentSessions( ) throws Exception {

        MofPackage p = mp1.createElement( MofPackage.class );
        p.setName( "myPackage" );
        MofPackage child = mp1.createElement( MofPackage.class );
        child.setName( "MyContainedPackage" );
        getPartitionOne( ).assignElement( p );
        getMOINConnection( ).save( );//necessary so that other session can see it


        MofPackage childFromSecondSession = getSecondMOINConnection( ).getNullPartition( ).createElement( MofPackage.class );
        ModelPartition partitionOneFromSecondSession = getSecondMOINConnection( ).getPartition( getPartitionOne( ).getPri( ) );
        partitionOneFromSecondSession.assignElement( childFromSecondSession );

        assertTrue( p.getContents( ).isEmpty( ) );

        //establish the link with elements from different sessions
        childFromSecondSession.setContainer( p );

        //parent is from first session, therefore it must not see the change (adding of child) done in memory by second session
        assertTrue( "Change done only in memory is visible across session borders!", p.getContents( ).isEmpty( ) );

    }

    @Test
    public void testElementExists( ) throws Exception {

        // Step one: Test null MRI/LRI
        assertFalse( getMOINConnection( ).elementExists( (LRI) null ) );
        assertFalse( getMOINConnection( ).elementExists( (MRI) null ) );

        // Step two: Test non-existing MRI/LRI
        Facility facility = getTestHelper( ).getMoin( ).getFacilityById( PrimaryFacility.FACILITY_ID );
        ResourceIdentifierFactory resourceIdentifierFactory = facility.getRIFactory( );
        String nonExistingPri = getPartitionOne( ).getPri( ).toString( ) + makePartitionName( "doesNotExist" );
        PRI pri = resourceIdentifierFactory.createPri( nonExistingPri );
        MRI mri = pri.createMri( "0123456789012345678901234567890123456789" );
        LRI lri = mri.getLri( );
        assertFalse( getMOINConnection( ).elementExists( lri ) );
        assertFalse( getMOINConnection( ).elementExists( mri ) );

        // Step three: Test MRI/LRI that exist only in memory (dirty created)
        ModelPartition newPartition = this._testClient1.getOrCreatePartition( "temporaryNew_" + System.currentTimeMillis( ) );
        pri = newPartition.getPri( );

        Partitionable newPackage = getMOINConnection( ).getNullPartition( ).createElement( MofPackage.class );
        newPartition.assignElement( newPackage );
        assertTrue( getMOINConnection( ).elementExists( newPackage.get___Mri( ) ) );
        assertTrue( getMOINConnection( ).elementExists( newPackage.get___Mri( ).getLri( ) ) );

        // Step four: Test MRI/LRI that exist on the file system
        getMOINConnection( ).save( );
        mri = newPackage.get___Mri( );
        lri = mri.getLri( );
        assertTrue( getMOINConnection( ).elementExists( mri ) );
        assertTrue( getMOINConnection( ).elementExists( lri ) );

        // Step five: Test MRI/PRI that exist on the file system, but has been deleted in memory (dirty delete)
        newPartition.delete( );
        assertFalse( getMOINConnection( ).elementExists( mri ) );
        assertFalse( getMOINConnection( ).elementExists( lri ) );

        // Step six: Test MRI/PRI that exist on the file system, but are not loaded.
        getMOINConnection( ).revert( );
        CoreConnection coreConnection = MoinTestCase.getTestHelper( ).getCoreConnection( getMOINConnection( ) );
        Collection<? extends SpiModelPartition> loadedPartitions = coreConnection.getSession( ).getWorkspace( ).getPartitionManager( ).getLoadedPartitionsLive( );
        // Check that partition is not loaded
        for ( SpiModelPartition spiModelPartition : loadedPartitions ) {
            assertFalse( spiModelPartition.getPri( ).equals( pri ) );
        }
        assertTrue( getMOINConnection( ).elementExists( mri ) );
        assertTrue( getMOINConnection( ).elementExists( lri ) );
        // Check that "partitionExists" did not trigger loading
        for ( SpiModelPartition spiModelPartition : loadedPartitions ) {
            assertFalse( spiModelPartition.getPri( ).equals( pri ) );
        }
    }

    @Test
    public void testPartitionExists( ) throws Exception {

        // Step One: Test null PRI
        assertFalse( getMOINConnection( ).partitionExists( null ) );

        // Step two: Test non-existing PRI
        Facility facility = getTestHelper( ).getMoin( ).getFacilityById( PrimaryFacility.FACILITY_ID );
        ResourceIdentifierFactory resourceIdentifierFactory = facility.getRIFactory( );
        String nonExistingPri = getPartitionOne( ).getPri( ).toString( ) + makePartitionName( "doesNotExist" );
        PRI pri = resourceIdentifierFactory.createPri( nonExistingPri );
        assertFalse( getMOINConnection( ).partitionExists( pri ) );

        // Step three: Test PRI that exists only in memory (dirty created)
        ModelPartition newPartition = this._testClient1.getOrCreatePartition( "temporaryNew_" + System.currentTimeMillis( ) );
        pri = newPartition.getPri( );
        assertTrue( getMOINConnection( ).partitionExists( pri ) );

        // Step four: Test PRI that exists on the file system
        getMOINConnection( ).save( );
        assertTrue( getMOINConnection( ).partitionExists( pri ) );

        // Step five: Test PRI that exists on the file system, but has been deleted in memory (dirty delete)
        newPartition.delete( );
        assertFalse( getMOINConnection( ).partitionExists( pri ) );

        // Step six: Test PRI that exists on the file system, but is not loaded.
        getMOINConnection( ).revert( );
        CoreConnection coreConnection = getTestHelper( ).getCoreConnection( getMOINConnection( ) );
        Collection<? extends SpiModelPartition> loadedPartitions = coreConnection.getSession( ).getWorkspace( ).getPartitionManager( ).getLoadedPartitionsLive( );
        // Check that partition is not loaded
        for ( SpiModelPartition spiModelPartition : loadedPartitions ) {
            assertFalse( spiModelPartition.getPri( ).equals( pri ) );
        }
        assertTrue( getMOINConnection( ).partitionExists( pri ) );
        // Check that "partitionExists" did not trigger loading
        for ( SpiModelPartition spiModelPartition : loadedPartitions ) {
            assertFalse( spiModelPartition.getPri( ).equals( pri ) );
        }


    }

    @Test
    public void testMofRomMetamodelInfo( ) throws Exception {

        CoreMoin coreMoin = getTestHelper( ).getCoreMoin( );

        // check correct entry of MofRom in (internal) meta-model registry
        SpiMetamodelRegistry metaModelRegistry = coreMoin.getMetaModelRegistry( );
        DeploymentExtension deploymentExtension = metaModelRegistry.getDeploymentExtension( coreMoin.getMofRomCri( ) );
        assertNotNull( "MOF deployment extension is not set in metamodel registry", deploymentExtension );

        MetaModelVersion metaModelVersion = metaModelRegistry.getMetaModelVersion( coreMoin.getMofRomCri( ) );
        assertNotNull( "MOF meta-model version is not set in metamodel registry", metaModelVersion );

        // check correct entry of MofRom in (external) meta-model catalog
        MetaModelCatalog metamodelCatalog = coreMoin.getMetamodelCatalog( );
        Collection<MetaModelInfo> metaModelList = metamodelCatalog.getMetaModelList( );
        MetaModelInfo mofRomMetaModelInfo = null;
        String mofRomContainerName = coreMoin.getMofRomCri( ).getContainerName( );

        for ( MetaModelInfo metaModelInfo : metaModelList ) {
            if ( mofRomContainerName.equals( metaModelInfo.getContainerName( ) ) ) {
                mofRomMetaModelInfo = metaModelInfo;
                break;
            }
        }

        assertNotNull( "MOF meta-model info is not set in metamodel catalog", mofRomMetaModelInfo );
        assertNotNull( "Version is null", mofRomMetaModelInfo.getDeployedMetaModelVersion( ) );
        assertNotNull( "Vendor is null", mofRomMetaModelInfo.getVendor( ) );
        assertNotNull( "Name is null", mofRomMetaModelInfo.getName( ) );
    }

    @Test
    public void testExceptionInListener( ) throws Exception {

        EventTypeFilter eventFilterTree = new EventTypeFilter( ChangeEvent.class );

        ExceptionListener updateListener1 = new ExceptionListener( );
        ExceptionListener updateListener2 = new ExceptionListener( );
        //register the listener which always throws an Exception
        EventRegistry eventRegistryForSecondMOINConnection = getSecondMOINConnection( ).getSession( ).getEventRegistry( );

        eventRegistryForSecondMOINConnection.registerUpdateListener( updateListener1, eventFilterTree );
        eventRegistryForSecondMOINConnection.registerUpdateListener( updateListener2, eventFilterTree );

        getPartitionOne( ).createElement( MofClass.class );
        assertTrue( "Expected partition to be dirty", getPartitionOne( ).isDirty( ) );

        getMOINConnection( ).save( );

        assertFalse( "Expected partition to be non-dirty", getPartitionOne( ).isDirty( ) );

        assertTrue( "Expected updateListener1 to be called", updateListener1.wasCalled );
        assertTrue( "Expected updateListener2 to be called", updateListener2.wasCalled );


        //register all listeners
        ExceptionListener preeventListener = new ExceptionListener( );
        ExceptionListener posteventListener = new ExceptionListener( );
        ExceptionListener precommitListener = new ExceptionListener( );
        ExceptionListener postcommitListener = new ExceptionListener( );
        ExceptionListener preeventListener2 = new ExceptionListener( );
        ExceptionListener posteventListener2 = new ExceptionListener( );
        ExceptionListener precommitListener2 = new ExceptionListener( );
        ExceptionListener postcommitListener2 = new ExceptionListener( );

        EventRegistry eventRegistryForMOINConnection = getMOINConnection( ).getSession( ).getEventRegistry( );
        eventRegistryForMOINConnection.registerListener( posteventListener, eventFilterTree );
        eventRegistryForMOINConnection.registerListener( posteventListener2, eventFilterTree );
        eventRegistryForMOINConnection.registerPreChangeListener( preeventListener, eventFilterTree );
        eventRegistryForMOINConnection.registerPreChangeListener( preeventListener2, eventFilterTree );
        eventRegistryForMOINConnection.registerPreCommitListener( precommitListener, eventFilterTree );
        eventRegistryForMOINConnection.registerPreCommitListener( precommitListener2, eventFilterTree );
        eventRegistryForMOINConnection.registerCommitListener( postcommitListener, eventFilterTree );
        eventRegistryForMOINConnection.registerCommitListener( postcommitListener2, eventFilterTree );

        Command command = new Command( getMOINConnection( ) ) {

            @Override
            public boolean canExecute( ) {


                return true;
            }

            @Override
            public void doExecute( ) {

                getPartitionOne( ).createElement( MofClass.class );

            }

            @Override
            public Collection<PartitionOperation> getAffectedPartitions( ) {

                return Collections.singletonList( new PartitionOperation( Operation.EDIT, getPartitionOne( ).getPri( ) ) );
            }

        };
        command.execute( );

        assertTrue( "Expected partition to be dirty", getPartitionOne( ).isDirty( ) );

        assertTrue( "Expected posteventListener1 to be called", posteventListener.wasCalled );
        assertTrue( "Expected posteventListener2 to be called", posteventListener2.wasCalled );

        assertTrue( "Expected preeventListener1 to be called", preeventListener.wasCalled );
        assertTrue( "Expected preeventListener2 to be called", preeventListener2.wasCalled );

        assertTrue( "Expected precommitListener1 to be called", precommitListener.wasCalled );
        assertTrue( "Expected precommitListener2 to be called", precommitListener2.wasCalled );

        assertTrue( "Expected postcommitListener1 to be called", postcommitListener.wasCalled );
        assertTrue( "Expected postcommitListener2 to be called", postcommitListener2.wasCalled );

    }

    @Test
    public void testDanglingLink( ) throws Exception {

        Connection connection1 = getMOINConnection( );
        Connection connection2 = getSecondMOINConnection( );

        //create first element in connection1 and save it so it can be seen from connection2
        MofClass mofClass = getPartitionOne( ).createElement( MofClass.class );
        connection1.save( );

        //create second element in connection2 (do NOT save, so it is not seen from connection1)
        assertNotNull( "Expected to see MofClass from connection1 also in connection2", connection2.getElement( ( (Partitionable) mofClass ).get___Mri( ) ) );
        ModelPartition partitionFromConnection2 = _testClient2.getOrCreatePartitionStable( "partition2" );
        MofPackage packageFromConnection2 = partitionFromConnection2.createElement( MofPackage.class );
        assertNull( "Expected MofPackage from connection2 NOT to be seen in connection1", connection1.getElement( ( (Partitionable) packageFromConnection2 ).get___Mri( ) ) );

        //link the two elements in connection2
        packageFromConnection2.getContents( ).add( mofClass );
        assertEquals( 1, packageFromConnection2.getContents( ).size( ) );
        assertNull( "In connection1, mofClass must not have a container", mofClass.getContainer( ) );
        assertTrue( "Expected no inconsistencies", connection2.getConsistencyViolationListenerRegistry( ).getAllConsistencyViolations( ).isEmpty( ) );

        //delete first element in connection1 -> as in connection1 the second element is not seen, the link cannot be removed automatically
        mofClass.refDelete( );
        connection1.save( ); //now the link should be dangling in connection2

        assertNull( "Expected dangling link", packageFromConnection2.getContents( ).iterator( ).next( ) );
        assertEquals( "Expected inconsistency", 1, connection2.getConsistencyViolationListenerRegistry( ).getAllConsistencyViolations( ).size( ) );

        //undo the "linking" of the two elements
        connection2.getCommandStack( ).undo( );
        assertEquals( 0, packageFromConnection2.getContents( ).size( ) );
        assertTrue( "Expected no inconsistencies", connection2.getConsistencyViolationListenerRegistry( ).getAllConsistencyViolations( ).isEmpty( ) );

        //redo must reestablish the dangling link
        connection2.getCommandStack( ).redo( );
        assertNull( "Expected dangling link", packageFromConnection2.getContents( ).iterator( ).next( ) );
        assertEquals( "Expected inconsistency", 1, connection2.getConsistencyViolationListenerRegistry( ).getAllConsistencyViolations( ).size( ) );

        //"undo" the linking by explicitly deleting the element
        packageFromConnection2.refDelete( );
        assertTrue( "Expected no inconsistencies", connection2.getConsistencyViolationListenerRegistry( ).getAllConsistencyViolations( ).isEmpty( ) );
        assertFalse( "Expected element to be no longer alive", ( (Partitionable) packageFromConnection2 ).is___Alive( ) );

        //undo the deletion
        connection2.getCommandStack( ).undo( );
        assertTrue( "Expected element to be alive", ( (Partitionable) packageFromConnection2 ).is___Alive( ) );
        assertNull( "Expected dangling link", packageFromConnection2.getContents( ).iterator( ).next( ) );
        assertEquals( "Expected inconsistency", 1, connection2.getConsistencyViolationListenerRegistry( ).getAllConsistencyViolations( ).size( ) );

    }

    @Test
    public void testGetPartitionOfNonExistingPri( ) throws Exception {

        Facility facility = getTestHelper( ).getMoin( ).getFacilityById( PrimaryFacility.FACILITY_ID );
        ResourceIdentifierFactory resourceIdentifierFactory = facility.getRIFactory( );
        String nonExistingPri = getPartitionOne( ).getPri( ).toString( ) + makePartitionName( "doesNotExist" );
        PRI pri = resourceIdentifierFactory.createPri( nonExistingPri );
        assertNull( getMOINConnection( ).getPartition( pri ) );
    }

    @Test
    public void testRemovalOfDirtyCreatedDeletedPartitionFromCoreStructures( ) throws Exception {

        ModelPartition dirtyCreatedPartition = _testClient1.getOrCreatePartitionStable( "DirtyCreated_" + System.currentTimeMillis( ) );
        PRI pri = dirtyCreatedPartition.getPri( );

        CoreConnection connection = getTestHelper( ).getCoreConnection( getMOINConnection( ) );
        CorePartitionManager partitionManager = connection.getSession( ).getWorkspace( ).getPartitionManager( );
        CoreModelPartition partition = partitionManager.getPartition( connection.getSession( ), pri, false );
        assertNotNull( partition );
        assertFalse( partition.isPersisted( ) );

        //delete
        dirtyCreatedPartition.delete( );

        //must still be in core structures but marked as deleted
        CoreModelPartition deletedCorePartition = partitionManager.getPartition( connection.getSession( ), pri, false );
        assertNotNull( deletedCorePartition );
        assertFalse( deletedCorePartition.isAlive( ) );

        getMOINConnection( ).save( );

        //must still not be in persistence
        assertNull( getMOINConnection( ).getPartition( pri ) );

        //must be removed from core structures
        deletedCorePartition = partitionManager.getPartition( connection.getSession( ), pri, false );
        assertNull( deletedCorePartition );
    }

    /**
     * This class only exists in order to simulate the client situation (e.g.
     * DummyRuleParameter in Galaxy) where a client class directly implements a
     * generated interface but extends our RefBaseObjectAdapter. Once we evolve
     * our non-generated base interfaces (e.g. RefObject, RefBaseObject...) we
     * have to adapt the RefBaseObjectAdapter as well. This class will help not
     * to forget this.
     * <p>
     * Don't adjust this class manually, only RefBaseObjectAdapter is allowed to
     * be changed!
     */
    private static final class JustToMakeSureRefBaseObjectAdapterWorks extends RefBaseObjectAdapter implements A4 {

        public Collection<B4> getManyBs( ) throws JmiException {

            return null;
        }

        public Collection<B4> getManyBsNotChangeable( ) throws JmiException {

            return null;
        }

        public Collection<B4> getManyBsNotOrdered( ) throws JmiException {

            return null;
        }

        public Collection<B4> getManyBsNotUnique( ) throws JmiException {

            return null;
        }

        public List<B4> getManyBsOrdered( ) throws JmiException {

            return null;
        }

        public List<B4> getManyBsOrderedUnique( ) throws JmiException {

            return null;
        }

        public Collection<B4> getManyBsUnique( ) throws JmiException {

            return null;
        }

        public Collection<String> getManyPrimitive( ) throws JmiException {

            return null;
        }

        public Collection<String> getManyPrimitiveNotChangeable( ) throws JmiException {

            return null;
        }

        public Collection<String> getManyPrimitiveOptional( ) throws JmiException {

            return null;
        }

        public List<String> getManyPrimitiveOrdered( ) throws JmiException {

            return null;
        }

        public List<String> getManyPrimitiveOrderedNotChangeable( ) throws JmiException {

            return null;
        }

        public List<String> getManyPrimitiveOrderedUnique( ) throws JmiException {

            return null;
        }

        public Collection<String> getManyPrimitiveUnique( ) throws JmiException {

            return null;
        }

        public B4 getOneBchangeable( ) throws JmiException {

            return null;
        }

        public B4 getOneBnotChangeable( ) throws JmiException {

            return null;
        }

        public B4 getOneBoptional( ) throws JmiException {

            return null;
        }

        public String getOnePrimitive( ) throws JmiException {

            return null;
        }

        public String getOnePrimitiveNotChangeable( ) throws JmiException {

            return null;
        }

        public String getOnePrimitiveOptional( ) throws JmiException {

            return null;
        }

        public void setOneBchangeable( B4 newValue ) throws JmiException {

        }

        public void setOneBnotChangeable( B4 newValue ) throws JmiException {

        }

        public void setOneBoptional( B4 newValue ) throws JmiException {

        }

        public void setOnePrimitive( String newValue ) throws JmiException {

        }

        public void setOnePrimitiveNotChangeable( String newValue ) throws JmiException {

        }

        public void setOnePrimitiveOptional( String newValue ) throws JmiException {

        }

        public RefClass refClass( ) {

            return null;
        }

        public void refDelete( ) {

        }

        public RefFeatured refImmediateComposite( ) {

            return null;
        }

        public boolean refIsInstanceOf( RefObject objType, boolean considerSubtypes ) {

            return false;
        }

        public RefFeatured refOutermostComposite( ) {

            return null;
        }

        public Object refGetValue( RefObject feature ) {

            return null;
        }

        public Object refGetValue( String featureName ) {

            return null;
        }

        public Object refInvokeOperation( RefObject requestedOperation, List<? extends Object> args ) throws RefException {

            return null;
        }

        public Object refInvokeOperation( String requestedOperation, List<? extends Object> args ) throws RefException {

            return null;
        }

        public void refSetValue( RefObject feature, Object value ) {

        }

        public void refSetValue( String featureName, Object value ) {

        }

        public Collection<Double> getManyPrimitiveDouble( ) throws JmiException {

            return null;
        }
    }
}
