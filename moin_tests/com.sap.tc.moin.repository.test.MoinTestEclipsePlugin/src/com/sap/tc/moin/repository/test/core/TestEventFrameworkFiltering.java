package com.sap.tc.moin.repository.test.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.ModelPackage;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.core.events.ModelChangeEventImpl;
import com.sap.tc.moin.repository.events.ChangeListener;
import com.sap.tc.moin.repository.events.CommitListener;
import com.sap.tc.moin.repository.events.EventChain;
import com.sap.tc.moin.repository.events.EventRegistry;
import com.sap.tc.moin.repository.events.PreChangeListener;
import com.sap.tc.moin.repository.events.filter.AndFilter;
import com.sap.tc.moin.repository.events.filter.AssociationFilter;
import com.sap.tc.moin.repository.events.filter.AttributeFilter;
import com.sap.tc.moin.repository.events.filter.ClassFilter;
import com.sap.tc.moin.repository.events.filter.CompositionHierarchyFilter;
import com.sap.tc.moin.repository.events.filter.ConnectionFilter;
import com.sap.tc.moin.repository.events.filter.ContainerFilter;
import com.sap.tc.moin.repository.events.filter.EventFilter;
import com.sap.tc.moin.repository.events.filter.EventTypeFilter;
import com.sap.tc.moin.repository.events.filter.InstanceFilter;
import com.sap.tc.moin.repository.events.filter.NotFilter;
import com.sap.tc.moin.repository.events.filter.OrFilter;
import com.sap.tc.moin.repository.events.filter.PackageFilter;
import com.sap.tc.moin.repository.events.filter.PartitionFilter;
import com.sap.tc.moin.repository.events.filter.SessionFilter;
import com.sap.tc.moin.repository.events.type.AttributeValueChangeEvent;
import com.sap.tc.moin.repository.events.type.ChangeEvent;
import com.sap.tc.moin.repository.events.type.ElementChangeEvent;
import com.sap.tc.moin.repository.events.type.ElementCreateEvent;
import com.sap.tc.moin.repository.events.type.LinkAddEvent;
import com.sap.tc.moin.repository.events.type.LinkRemoveEvent;
import com.sap.tc.moin.repository.events.type.ModelChangeEvent;
import com.sap.tc.moin.repository.events.type.PartitionChangeEvent;
import com.sap.tc.moin.repository.events.type.PartitionMembershipChangeEvent;
import com.sap.tc.moin.test.fw.TestMetaModels;
import com.sap.tc.moin.testcasesfoundation.TestcasesfoundationPackage;

public class TestEventFrameworkFiltering extends EventFrameworkTest {

    protected ModelPackage mofModelPackage;

    protected Connection connection;

    protected EventRegistry eventRegistry;

    private ModelPartition part;

    private MofPackage pkA, pkB;

    private MofClass clA, clB;

    private Attribute atA, atB;

    private MRI pkA_Mri, pkB_Mri;

    private MRI clA_Mri, clB_Mri;

    private MRI atA_Mri, atB_Mri;

    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );
        connection = getMOINConnection( );
        eventRegistry = connection.getEventRegistry( );
        mofModelPackage = (ModelPackage) connection.getPackage( TestMetaModels.MOIN_MOF_CN, TestMetaModels.MOIN_MOF_TPE_MODEL );
    }

    @Override
    @After
    public void afterTestMethod( ) throws Exception {

        super.afterTestMethod( );
        mofModelPackage = null;
        connection = null;
        pkA = null;
        pkB = null;
        part = null;
        clA = null;
        clB = null;
        atA = null;
        atB = null;
        eventRegistry = null;
    }

    // InstanceFilter(clA)
    // All events for clA
    @Test
    public void testInstanceFilter( ) {

        fireCreationEventsA( );

        EventFilter instanceF = new InstanceFilter( new MRI[] { clA_Mri } );
        TestChangeListener instanceCL = createAndRegisterTestChangeListener( instanceF );
        instanceCL.expectedElementCreateEvents = 0;
        instanceCL.expectedElementDeleteEvents = 1;
        instanceCL.expectedAttributeValueChangeEvents = 1;
        instanceCL.expectedLinkAddEvents = 3;
        instanceCL.expectedLinkRemoveEvents = 3;
        instanceCL.expectedPartitionMembershipChangeEvents = 1;

        fireCreationEventsB( );
        fireModificationEvents( );
        fireDeletionEvents( );

        checkReceivedEvents( );

        deregisterListener( instanceCL );

    }

    // InstanceFilter(clA) and (EventTypeFilter(ElementChangeEvent))
    // Element Change events for clA
    @Test
    public void testInstanceFilterAndElementChangeEvent( ) {

        fireCreationEventsA( );

        // combined filter Instance and elementChange Event
        Set<Class<? extends ChangeEvent>> eventTypeFilterArgs = new HashSet<Class<? extends ChangeEvent>>( );
        eventTypeFilterArgs.add( ElementChangeEvent.class );
        EventFilter instanceAndElementChangeFilter = new AndFilter( new EventTypeFilter( eventTypeFilterArgs ), new InstanceFilter( clA_Mri ) );

        // register to the listener
        TestChangeListener instanceAndElementChangeListener = createAndRegisterTestChangeListener( instanceAndElementChangeFilter );

        // set the expected events
        instanceAndElementChangeListener.expectedElementDeleteEvents = 1;
        instanceAndElementChangeListener.expectedAttributeValueChangeEvents = 1;

        fireCreationEventsB( );
        fireModificationEvents( );
        fireDeletionEvents( );

        checkReceivedEvents( );

        deregisterListener( instanceAndElementChangeListener );

    }

    // InstanceFilter(clA) and (EventTypeFilter(PartitionMembershipChangeEvent)
    // Partition events for clA
    @Test
    public void testInstanceFilterAndPartitionMembershipChangeEvent( ) {

        fireCreationEventsA( );

        Set<LRI> instanceFilterArgs = new HashSet<LRI>( );
        instanceFilterArgs.add( clA_Mri.getLri( ) );
        EventFilter instanceAndPartitionMembershipChangeFilter = new AndFilter( new EventTypeFilter( PartitionMembershipChangeEvent.class ), new InstanceFilter( instanceFilterArgs ) );

        // register to the listener
        TestChangeListener instanceAndPartitionMembershipChangeListener = createAndRegisterTestChangeListener( instanceAndPartitionMembershipChangeFilter );

        // set the expected events
        instanceAndPartitionMembershipChangeListener.expectedPartitionMembershipChangeEvents = 1;

        fireCreationEventsB( );
        fireModificationEvents( );
        fireDeletionEvents( );

        checkReceivedEvents( );

        deregisterListener( instanceAndPartitionMembershipChangeListener );

    }

    // InstanceFilter(clA,true) and (EventTypeFilter(ElementChangeEvent)
    // Element Change events for clA & atB
    @Test
    public void testInstanceFilterAndElementChangeEventWithComp( ) {

        fireCreationEventsA( );

        // combined filter Instance with composition and elementChange Event
        EventFilter instanceAndElementChangeFilterWithComp = new AndFilter( new EventTypeFilter( ElementChangeEvent.class ), new CompositionHierarchyFilter( clA_Mri ) );

        // register to the listener
        TestChangeListener instanceAndElementChangeListenerWithComp = createAndRegisterTestChangeListener( instanceAndElementChangeFilterWithComp );

        // set the expected events
        instanceAndElementChangeListenerWithComp.expectedElementDeleteEvents = 2;
        instanceAndElementChangeListenerWithComp.expectedAttributeValueChangeEvents = 2;

        fireCreationEventsB( );
        fireModificationEvents( );
        fireDeletionEvents( );

        checkReceivedEvents( );

        deregisterListener( instanceAndElementChangeListenerWithComp );

    }

    // InstanceFilter(clA,true) and
    // (EventTypeFilter(PartitionMembershipChangeEvent)
    // Partition events for clA & atB
    @Test
    public void testInstanceFilterAndPartitionMembershipChangeEventWithComp( ) {

        fireCreationEventsA( );

        EventFilter instanceAndPartitionMembershipChangeFilterWithComp = new AndFilter( new EventTypeFilter( PartitionMembershipChangeEvent.class ), new CompositionHierarchyFilter( clA_Mri ) );

        // register to the listener
        TestChangeListener instanceAndPartitionMembershipChangeListenerWithComp = createAndRegisterTestChangeListener( instanceAndPartitionMembershipChangeFilterWithComp );

        // set the expected events
        instanceAndPartitionMembershipChangeListenerWithComp.expectedPartitionMembershipChangeEvents = 2;

        fireCreationEventsB( );
        fireModificationEvents( );
        fireDeletionEvents( );

        checkReceivedEvents( );

        deregisterListener( instanceAndPartitionMembershipChangeListenerWithComp );

    }

    // ClassFilter(clA.refMetaObject())
    // all events for clA & clB
    @Test
    public void testClassFilter( ) {

        fireCreationEventsA( );

        // Class filter
        EventFilter classFilter = new ClassFilter( ( (Partitionable) clA.refMetaObject( ) ).get___Mri( ).getLri( ) );

        // register Listener
        TestChangeListener classListener = createAndRegisterTestChangeListener( classFilter );

        // set expected Values
        classListener.expectedLinkAddEvents = 6;
        classListener.expectedAttributeValueChangeEvents = 2;
        classListener.expectedPartitionMembershipChangeEvents = 2;
        classListener.expectedLinkRemoveEvents = 6;
        classListener.expectedElementCreateEvents = 1;
        classListener.expectedElementDeleteEvents = 2;

        fireCreationEventsB( );
        fireModificationEvents( );
        fireDeletionEvents( );

        checkReceivedEvents( );

        deregisterListener( classListener );

    }

    // PartitionMembershipFilter(part)
    // all events in the partition
    @Test
    public void testPartitionMembershipFilter( ) {

        fireCreationEventsA( );

        // PartitionMembership filter
        EventFilter partitionFilter = new PartitionFilter( part );

        // register Listener
        TestChangeListener partitionMembershipListener = createAndRegisterTestChangeListener( partitionFilter );

        // set expected Values
        partitionMembershipListener.expectedLinkAddEvents = 3;
        partitionMembershipListener.expectedAttributeValueChangeEvents = 1;
        partitionMembershipListener.expectedPartitionMembershipChangeEvents = 6;
        partitionMembershipListener.expectedLinkRemoveEvents = 6;
        partitionMembershipListener.expectedElementDeleteEvents = 6;
        partitionMembershipListener.expectedPartitionDeleteEvents = 1;

        fireCreationEventsB( );
        fireModificationEvents( );
        fireDeletionEvents( );

        checkReceivedEvents( );

        deregisterListener( partitionMembershipListener );

    }

    // PartitionMembershipFilter(part) and ClassFilter(clA.refMetaObject)
    // All events for claA & clB when in partition part
    @Test
    public void testPartitionMembershipAndClassFilter( ) {

        fireCreationEventsA( );

        // Combined filter : PartitionMembership and Class filter
        EventFilter partitionMembershipAndClassFilter = new AndFilter( new PartitionFilter( part.getPri( ) ), new ClassFilter( (MofClass) clA.refMetaObject( ), false ) );

        // register Listener
        TestChangeListener partitionMembershipAndClassListener = createAndRegisterTestChangeListener( partitionMembershipAndClassFilter );

        // set expected Values
        partitionMembershipAndClassListener.expectedLinkAddEvents = 3;
        // @todo:check
        partitionMembershipAndClassListener.expectedLinkRemoveEvents = 6;
        partitionMembershipAndClassListener.expectedPartitionMembershipChangeEvents = 2;
        partitionMembershipAndClassListener.expectedElementDeleteEvents = 2;

        fireCreationEventsB( );
        fireModificationEvents( );
        fireDeletionEvents( );

        checkReceivedEvents( );

        deregisterListener( partitionMembershipAndClassListener );

    }

    // ClassFilter(clA.refMetaObject) and PartitionMembershipFilter(part)
    // All events for claA & clB when in partition part
    @Test
    public void testClassAndPartitionMembership( ) {

        fireCreationEventsA( );

        EventFilter classAndpartitionMembershipFilter = new AndFilter( new ClassFilter( (MofClass) clA.refMetaObject( ), false ), new PartitionFilter( part ) );

        // register Listener
        TestChangeListener classAndPartitionMembershipListener = createAndRegisterTestChangeListener( classAndpartitionMembershipFilter );

        // set expected Values
        classAndPartitionMembershipListener.expectedLinkAddEvents = 3;
        classAndPartitionMembershipListener.expectedPartitionMembershipChangeEvents = 2;
        classAndPartitionMembershipListener.expectedLinkRemoveEvents = 6;
        classAndPartitionMembershipListener.expectedElementDeleteEvents = 2;

        fireCreationEventsB( );
        fireModificationEvents( );
        fireDeletionEvents( );

        checkReceivedEvents( );

        deregisterListener( classAndPartitionMembershipListener );

    }

    // AssociationFilter((Association)mofModelPackage.getContains().refMetaObject())
    // All link events of Contains association
    @Test
    public void testAssociationFilter( ) {

        fireCreationEventsA( );

        MRI associationMri = ( (Partitionable) mofModelPackage.getContains( ).refMetaObject( ) ).get___Mri( );
        EventFilter associationFilter = new AssociationFilter( associationMri );

        TestChangeListener associationListener = createAndRegisterTestChangeListener( associationFilter );

        associationListener.expectedLinkAddEvents = 4;
        associationListener.expectedLinkRemoveEvents = 4;

        fireCreationEventsB( );
        fireModificationEvents( );
        fireDeletionEvents( );

        checkReceivedEvents( );

        deregisterListener( associationListener );

    }

    // InstanceFilter(clA) and
    // AssociationFilter(modelPackage.getContains().refMetaObject())
    // All link events of Contains association on clA
    @Test
    public void testInstanceAndAssociationFilter( ) {

        fireCreationEventsA( );

        Set<LRI> assocFilterEntries = new HashSet<LRI>( );
        assocFilterEntries.add( ( (Partitionable) mofModelPackage.getContains( ).refMetaObject( ) ).get___Mri( ).getLri( ) );
        EventFilter instanceAndAssociationFilter = new AndFilter( new InstanceFilter( clA_Mri ), new AssociationFilter( assocFilterEntries ) );

        TestChangeListener instanceAndAssociationListener = createAndRegisterTestChangeListener( instanceAndAssociationFilter );

        instanceAndAssociationListener.expectedLinkAddEvents = 2;
        instanceAndAssociationListener.expectedLinkRemoveEvents = 2;

        fireCreationEventsB( );
        fireModificationEvents( );
        fireDeletionEvents( );

        checkReceivedEvents( );

        deregisterListener( instanceAndAssociationListener );

    }

    // EventTypeFilter(LinkAddEvent) and
    // AssociationFilter(modelPackage.getContains().refMetaObject())
    @Test
    public void testTypeAndAssociationFilter( ) {

        fireCreationEventsA( );

        EventFilter instanceAndAssociationFilterWithComp = new OrFilter( new AndFilter( new EventTypeFilter( LinkAddEvent.class ), new AssociationFilter( (Association) mofModelPackage.getContains( ).refMetaObject( ) ) ), new AndFilter( new EventTypeFilter( LinkRemoveEvent.class ),
                                                                                                                                                                                                                                            new AssociationFilter( (Association) mofModelPackage
                                                                                                                                                                                                                                                .getContains( ).refMetaObject( ) ) ),
                                                                         new AndFilter( new EventTypeFilter( ElementCreateEvent.class ) )

        );

        TestChangeListener instanceAndAssociationListenerWithComp = createAndRegisterTestChangeListener( instanceAndAssociationFilterWithComp );

        instanceAndAssociationListenerWithComp.expectedLinkAddEvents = 4;
        instanceAndAssociationListenerWithComp.expectedLinkRemoveEvents = 4;
        instanceAndAssociationListenerWithComp.expectedElementCreateEvents = 3;

        fireCreationEventsB( );
        fireModificationEvents( );
        fireDeletionEvents( );

        checkReceivedEvents( );

        deregisterListener( instanceAndAssociationListenerWithComp );

    }

    // InstanceFilter(clA) and
    // AssociationFilter((Association)mofModelPackage.getContains().refMetaObject())
    // and ClassFilter((MofClass)clA.refMetaObject(),false)
    @Test
    public void testInstanceAndAssociationAndClassFilter( ) {

        fireCreationEventsA( );

        EventFilter instanceAndAssociationAndClassFilter = new AndFilter( new InstanceFilter( clA_Mri ), new AssociationFilter( (Association) mofModelPackage.getContains( ).refMetaObject( ) ), new ClassFilter( (MofClass) clA.refMetaObject( ), false ) );

        TestChangeListener instanceAndAssociationAndClassListener = createAndRegisterTestChangeListener( instanceAndAssociationAndClassFilter );

        instanceAndAssociationAndClassListener.expectedLinkAddEvents = 2;
        instanceAndAssociationAndClassListener.expectedLinkRemoveEvents = 2;

        fireCreationEventsB( );
        fireModificationEvents( );
        fireDeletionEvents( );

        checkReceivedEvents( );

        deregisterListener( instanceAndAssociationAndClassListener );

    }

    // ClassFilter(clA.refMetaObject()) and
    // AssociationFilter(modelPackage.getContains().refMetaObject())
    // Link events of association Contains on clA & clB
    @Test
    public void testClassAndAssociationFilter( ) {

        fireCreationEventsA( );

        Set<MofClass> classFilterArgs = new HashSet<MofClass>( );
        classFilterArgs.add( (MofClass) clA.refMetaObject( ) );
        EventFilter classAndAssociationFilter = new AndFilter( new ClassFilter( classFilterArgs, false ), new AssociationFilter( (Association) mofModelPackage.getContains( ).refMetaObject( ) ) );

        TestChangeListener classAndAssociationListener = createAndRegisterTestChangeListener( classAndAssociationFilter );

        classAndAssociationListener.expectedLinkAddEvents = 4;
        classAndAssociationListener.expectedLinkRemoveEvents = 4;

        fireCreationEventsB( );
        fireModificationEvents( );
        fireDeletionEvents( );

        checkReceivedEvents( );

        deregisterListener( classAndAssociationListener );
    }

    private Attribute getAttributeByName( String attName ) {

        Iterator it = ( (MofClass) mofModelPackage.getModelElement( ).refMetaObject( ) ).getContents( ).iterator( );
        while ( it.hasNext( ) ) {
            Object me = it.next( );
            if ( me instanceof Attribute ) {
                Attribute at = (Attribute) me;
                if ( attName.equals( at.getName( ) ) ) {
                    return at;
                }
            }
        }
        return null;
    }

    // InstanceFilter(clA) and AttributeFilter("name")
    // AttributeValueChange events of clA & clB
    @Test
    public void testInstanceAndAttributeFilter( ) {

        fireCreationEventsA( );

        Set<LRI> attrFilterArgs = new HashSet<LRI>( );
        attrFilterArgs.add( ( (Partitionable) getAttributeByName( "name" ) ).get___Mri( ).getLri( ) );
        EventFilter instanceAndAttributeFilter = new AndFilter( new InstanceFilter( clA_Mri ), new AttributeFilter( attrFilterArgs ) );

        TestChangeListener instanceAndAttributeListener = createAndRegisterTestChangeListener( instanceAndAttributeFilter );

        instanceAndAttributeListener.expectedAttributeValueChangeEvents = 1;

        fireCreationEventsB( );
        fireModificationEvents( );
        fireDeletionEvents( );

        checkReceivedEvents( );

        deregisterListener( instanceAndAttributeListener );
    }

    // InstanceFilter(clA,true) and AttributeFilter("name")
    // AttributeValueChange events of clA, clB, atA & atB
    @Test
    public void testInstanceAndAttributeFilterWithComp( ) {

        fireCreationEventsA( );

        // TODO: Use attribute NAME!
        Set<LRI> compHierFilterArgs = new HashSet<LRI>( );
        compHierFilterArgs.add( clA_Mri.getLri( ) );
        EventFilter instanceAndAttributeFilterWithComp = new AndFilter( new CompositionHierarchyFilter( compHierFilterArgs ), new AttributeFilter( getAttributeByName( "name" ) ) );

        TestChangeListener instanceAndAttributeListenerWithComp = createAndRegisterTestChangeListener( instanceAndAttributeFilterWithComp );

        instanceAndAttributeListenerWithComp.expectedAttributeValueChangeEvents = 2;

        fireCreationEventsB( );
        fireModificationEvents( );
        fireDeletionEvents( );

        checkReceivedEvents( );

        deregisterListener( instanceAndAttributeListenerWithComp );
    }

    /***************************************************************************
     * Testing Model Manipulation
     */

    public void fireCreationEventsA( ) {

        // Create Model Partition
        // Evt: ParitionCreateEvent
        part = _testClient1.getOrCreatePartition( "TestEventFilteringPartition" );

        // Create elements (2 MofPackages (pkA,pkB) and 2 MofClasses (clA,clB),
        // 2 Attributes (atA,atB))
        // Evt: ElementCreateEvent

        pkA = (MofPackage) mofModelPackage.getMofPackage( ).refCreateInstance( );
        pkA_Mri = ( (Partitionable) pkA ).get___Mri( );

        clA = (MofClass) mofModelPackage.getMofClass( ).refCreateInstance( );
        clA_Mri = ( (Partitionable) clA ).get___Mri( );

        atA = (Attribute) mofModelPackage.getAttribute( ).refCreateInstance( );
        atA_Mri = ( (Partitionable) atA ).get___Mri( );

    }

    public void fireCreationEventsB( ) {

        // Create elements (2 MofPackages (pkA,pkB) and 2 MofClasses (clA,clB),
        // 2 Attributes (atA,atB))
        // Evt: ElementCreateEvent

        pkB = (MofPackage) mofModelPackage.getMofPackage( ).refCreateInstance( );
        pkB_Mri = ( (Partitionable) pkB ).get___Mri( );

        clB = (MofClass) mofModelPackage.getMofClass( ).refCreateInstance( );
        clB_Mri = ( (Partitionable) clB ).get___Mri( );

        atB = (Attribute) mofModelPackage.getAttribute( ).refCreateInstance( );
        atB_Mri = ( (Partitionable) atB ).get___Mri( );

    }

    public void fireModificationEvents( ) {

        // Compose elements 1 (clA.container=MofClasses contained into
        // MofPackages, Attributes into MofClasses )
        // Evt: LinkAddEvent
        clA.setContainer( pkA );
        atA.setContainer( clA );

        // Set element Names
        // Evt: AttributeValueChangeEvent
        pkA.setName( "Pk A" );
        clA.setName( "Cl A" );
        atA.setName( "At A" );

        // Create Association 1 (attA.Type=clB)
        // evt: LinkAddEvent
        atA.setType( clB );

        /**
         * *********************************************************************
         * *********
         */
        // Assign Elements to new Partition
        // Evt: PartitionMembershipChangeEvent
        // ((Partitionable)atA).assign___Partition(part);
        // ((Partitionable)clA).assign___PartitionIncludingChildren(part);
        // ((Partitionable)pkA).assign___Partition(part);
        ( (Partitionable) pkA ).assign___PartitionIncludingChildren( part );
        ( (Partitionable) pkB ).assign___PartitionIncludingChildren( part );
        /**
         * *********************************************************************
         * *********
         */

        // Set element Names
        // Evt: AttributeValueChangeEvent
        pkB.setName( "Pk B" );
        clB.setName( "Cl B" );
        atB.setName( "At B" );

        // Compose elements 1 (clA.container=MofClasses contained into
        // MofPackages, Attributes into MofClasses )
        // Evt: LinkAddEvent
        // Evt: PartitionMembershipChangeEvent
        clB.setContainer( pkB );
        atB.setContainer( clB );

        // Create Association 2 (attB.Type=clA)
        // evt: LinkAddEvent
        atB.setType( clA );

    }

    public void fireDeletionEvents( ) {

        // Delete MofPackages
        // Evt: LinkRemoveEvent
        // Evt: ElementDeleteEvent
        pkA.refDelete( );
        pkB.refDelete( );

        // Delete Partition
        // Evt: ParitionDeleteEvent
        part.delete( );
    }

    /***************************************************************************
     * Only for debugging purposes
     */

    /**
     * Combined ChangeListener
     */
    private class CombinedChangeListener implements ChangeListener {

        MRI mri;

        public int noc = 0;

        public CombinedChangeListener( MRI p_mri ) {

            this.mri = p_mri;
            System.out.println( "Registered for " + mri.getMofId( ) );
        }

        public void notify( ChangeEvent event ) {

            if ( ( event instanceof AttributeValueChangeEvent ) ) {
                MRI eMRI = ( (AttributeValueChangeEvent) event ).getAffectedElementMri( );
                System.out.println( "Received Event for " + eMRI.getMofId( ) );
                assertEqualsAndContinue( "Event Object MRI", mri, eMRI );
                noc++;
                return;
            }
            assertTrueAndContinue( "Received Event Type " + event.getClass( ).toString( ), false );
        }
    }

    /**
     * Instace ChangeListener
     */
    private class InstanceChangeListener implements ChangeListener, PreChangeListener {

        MRI mri;

        public int noc = 0;

        public InstanceChangeListener( MRI p_mri ) {

            this.mri = p_mri;
            System.out.println( "InstanceChangeListener Registered for " + mri.getMofId( ) );
        }

        public void notify( ChangeEvent event ) {

            String evn = event.getClass( ).getName( ).substring( 39 );
            if ( event instanceof ElementChangeEvent ) {
                MRI eMRI = ( (ElementChangeEvent) event ).getAffectedElementMri( );
                System.out.println( "IC: " + evn + " received for " + eMRI.getMofId( ) );
                // assertEqualsAndContinue("Event Object MRI", mri.getMofId(),
                // eMRI.getMofId());
            } else {
                System.out.println( "IC: " + evn + " received." );
            }
            noc++;

            return;
        }

        public void prepare( ChangeEvent event ) {

            String evn = event.getClass( ).getName( ).substring( 39 );
            if ( event instanceof ElementChangeEvent ) {
                MRI eMRI = ( (ElementChangeEvent) event ).getAffectedElementMri( );
                System.out.println( "IC: " + evn + " received for " + eMRI.getMofId( ) );
                // assertEqualsAndContinue("Event Object MRI", mri.getMofId(),
                // eMRI.getMofId());
            } else {
                System.out.println( "IC: " + evn + " received." );
            }
            noc++;

            return;
        }
    }

    /**
     * ModelChangeListener
     */
    private class ModelChangeListener implements ChangeListener, PreChangeListener {

        public int noc = 0;

        public ModelChangeListener( ) {

            System.out.println( "ModelChangeListener Registered" );
        }

        public void notify( ChangeEvent event ) {

            process( event );
        }

        public void prepare( ChangeEvent event ) {

            process( event );
        }

        public void process( ChangeEvent event ) {

            String evn = event.getClass( ).getName( ).substring( 39 );
            if ( event instanceof ModelChangeEvent ) {
                Collection<LRI> lris = ( (ModelChangeEventImpl) event ).getAffectedElementsLris( );
                String ids = "";
                for ( LRI lri : lris ) {
                    ids = ids + lri.getMofId( ) + " ";
                }

                System.out.println( "MC: " + evn + " received for " + ids );
            } else {
                System.out.println( "MC: " + evn + " received." );
            }
            noc++;

            return;
        }

    }

    @Test
    public void testCombinedFilter( ) {

        MofPackage mofPackage = (MofPackage) mofModelPackage.getMofPackage( ).refCreateInstance( );
        MofPackage anotherMofPackage = (MofPackage) mofModelPackage.getMofPackage( ).refCreateInstance( );

        mofPackage.setName( "PackageName1" );
        anotherMofPackage.setName( "anotherPackageName1" );

        MRI packageMri = ( (Partitionable) mofPackage ).get___Mri( );
        MRI anotherPackageMri = ( (Partitionable) mofPackage ).get___Mri( );

        // Instance Listener
        InstanceFilter instanceFilter = new InstanceFilter( anotherPackageMri );
        InstanceChangeListener instanceListener = new InstanceChangeListener( anotherPackageMri );
        eventRegistry.registerListener( instanceListener, instanceFilter );

        // Combined Listener
        List<EventFilter> andFilterArgs = new ArrayList<EventFilter>( );
        andFilterArgs.add( new EventTypeFilter( AttributeValueChangeEvent.class ) );
        andFilterArgs.add( new InstanceFilter( packageMri ) );
        EventFilter combinedFilter = new AndFilter( andFilterArgs );

        CombinedChangeListener combinedListener = new CombinedChangeListener( packageMri );
        eventRegistry.registerListener( combinedListener, combinedFilter );

        // Make Modifications

        // Should notify combinedListener
        mofPackage.setName( "PackageName2" );

        // Should notify instanceListener
        anotherMofPackage.setName( "anotherPackageName2" );

        // Should not notify any listener
        MofClass newClass = (MofClass) mofModelPackage.getMofClass( ).refCreateInstance( );

        // Should not notify instance listener
        mofPackage.getContents( ).add( newClass );

        assertEquals( "Combined Listener calls", 1, combinedListener.noc );
        assertEquals( "Instance Listener calls", 2, instanceListener.noc );

        // Deregister Listeners
        eventRegistry.deregister( combinedListener );
        eventRegistry.deregister( instanceListener );
    }

    @Test
    public void testMultipleRegistrations( ) {

        fireCreationEventsA( );

        EventFilter instanceF = new InstanceFilter( clA_Mri );
        TestChangeListener instanceCL = createAndRegisterTestChangeListener( instanceF );
        eventRegistry.registerListener( instanceCL, instanceF );
        eventRegistry.registerListener( instanceCL, instanceF );
        eventRegistry.registerListener( instanceCL, instanceF );

        instanceCL.expectedElementCreateEvents = 0;
        instanceCL.expectedElementDeleteEvents = 1;
        instanceCL.expectedAttributeValueChangeEvents = 1;
        instanceCL.expectedLinkAddEvents = 3;
        instanceCL.expectedLinkRemoveEvents = 3;
        instanceCL.expectedPartitionMembershipChangeEvents = 1;

        fireCreationEventsB( );
        fireModificationEvents( );
        fireDeletionEvents( );

        checkReceivedEvents( );

        deregisterListener( instanceCL );

    }

    @Test
    public void testFilterAfterRepartitioning( ) {

        fireCreationEventsA( );

        EventFilter instanceF = new InstanceFilter( clA_Mri );
        TestChangeListener instanceCL = createAndRegisterTestChangeListener( instanceF );

        instanceCL.expectedAttributeValueChangeEvents = 2;
        instanceCL.expectedPartitionMembershipChangeEvents = 2;
        clA.setAnnotation( "Anno1" );

        ModelPartition part2 = _testClient1.getOrCreatePartition( "TestEventFilteringPartition2" );

        ModelPartition mpOld = ( (Partitionable) clA ).get___Partition( );
        part2.assignElement( clA );
        // Now the "clA" has a different MRI than at the point of the filter
        // registration
        // But the InstanceFilter must still work, because the EventFramework
        // uses the LRI internally
        assertNotEqualsAndContinue( "MRIs must be different", clA_Mri, ( (Partitionable) clA ).get___Mri( ) );
        clA.setAnnotation( "Anno2" );
        mpOld.assignElement( clA );

        checkReceivedEvents( );

        // cleanup
        part2.delete( );
        deregisterListener( instanceCL );

    }

    @Test
    public void testDisjunctiveNormalFormSimple( ) {

        // this creates "clA_Mri" which is used in the InstanceFilter
        fireCreationEventsA( );
        EventTypeFilter etFilter = new EventTypeFilter( AttributeValueChangeEvent.class );
        InstanceFilter iFilter = new InstanceFilter( clA_Mri );
        AndFilter andFilter = new AndFilter( etFilter, iFilter );
        OrFilter orFilter = new OrFilter( andFilter, new EventTypeFilter( PartitionChangeEvent.class ) );

        // has thrown IllegalStateException!!!
        createAndRegisterTestChangeListener( orFilter );
    }

    protected class TestEmptyEventChainListener implements CommitListener {

        public void notifyCommit( EventChain events ) {

            if ( events.getEvents( ).isEmpty( ) ) {
                fail( "EventChain must not be empty" );
            }
        }
    }

    @Test
    public void testEmptyEventChain( ) {

        // this creates "clA_Mri" which is used in the InstanceFilter
        fireCreationEventsA( );
        EventTypeFilter etFilter = new EventTypeFilter( AttributeValueChangeEvent.class );
        InstanceFilter iFilter = new InstanceFilter( clA_Mri );
        AndFilter andFilter = new AndFilter( etFilter, iFilter );
        OrFilter orFilter = new OrFilter( andFilter, new EventTypeFilter( PartitionChangeEvent.class ) );

        TestEmptyEventChainListener listener = new TestEmptyEventChainListener( );
        eventRegistry.registerCommitListener( listener, orFilter );

        fireCreationEventsB( );

        eventRegistry.deregister( listener );
    }

    @Test
    public void testDeregisterListenerOfClosedConnection( ) {

        fireCreationEventsA( );

        EventFilter instanceF = new InstanceFilter( clA_Mri );
        TestChangeListener instanceCL = createAndRegisterTestChangeListener( instanceF );
        eventRegistry.registerListener( instanceCL, instanceF );
        eventRegistry.registerListener( instanceCL, instanceF );
        eventRegistry.registerListener( instanceCL, instanceF );

        instanceCL.expectedElementCreateEvents = 0;
        instanceCL.expectedElementDeleteEvents = 1;
        instanceCL.expectedAttributeValueChangeEvents = 1;
        instanceCL.expectedLinkAddEvents = 3;
        instanceCL.expectedLinkRemoveEvents = 3;
        instanceCL.expectedPartitionMembershipChangeEvents = 1;

        fireCreationEventsB( );
        fireModificationEvents( );
        fireDeletionEvents( );

        checkReceivedEvents( );

        deregisterListener( instanceCL );

    }

    @Test
    public void testContainerFilter( ) {

        // Prepare data
        fireCreationEventsA( );
        part.assignElementIncludingChildren( pkA );

        // Register listener that shall receive events
        EventFilter containerFilter = new ContainerFilter( part.getPri( ).getCri( ) );
        TestChangeListener listener = createAndRegisterTestChangeListener( containerFilter );
        listener.expectedAttributeValueChangeEvents = 1;

        // Register listener that shall not receive events
        EventFilter containerFilter2 = new ContainerFilter( "DoesNotExist" );
        TestChangeListener listener2 = createAndRegisterTestChangeListener( containerFilter2 );
        listener2.expectedAttributeValueChangeEvents = 0;

        // Do the modification and check the events
        pkA.setName( "New Name" );
        checkReceivedEvents( );

        // Clean-up
        deregisterListener( listener );
        deregisterListener( listener2 );
    }

    @Test
    public void testContainerFilterNullPartition( ) {

        // Prepare data
        fireCreationEventsA( );

        // Register listener that shall receive events
        EventFilter containerFilter = new ContainerFilter( ( (Partitionable) pkA ).get___Mri( ).getCri( ) );
        TestChangeListener listener = createAndRegisterTestChangeListener( containerFilter );
        listener.expectedAttributeValueChangeEvents = 1;

        // Register listener that shall not receive events
        EventFilter containerFilter2 = new ContainerFilter( "DoesNotExist" );
        TestChangeListener listener2 = createAndRegisterTestChangeListener( containerFilter2 );
        listener2.expectedAttributeValueChangeEvents = 0;

        // Do the modification and check the events
        pkA.setName( "New Name" );
        checkReceivedEvents( );

        // Clean-up
        deregisterListener( listener );
        deregisterListener( listener2 );
    }

    @Test
    public void testContainerFilterTransientPartition( ) {

        // Prepare data
        fireCreationEventsA( );

        ModelPartition transientPartition = getMOINConnection( ).getOrCreateTransientPartition( "TransTest1" );
        transientPartition.assignElementIncludingChildren( pkA );

        // Register listener that shall receive events
        EventFilter containerFilter = new ContainerFilter( ( (Partitionable) pkA ).get___Mri( ).getCri( ) );
        TestChangeListener listener = createAndRegisterTestChangeListener( containerFilter );
        listener.expectedAttributeValueChangeEvents = 1;

        // Register listener that shall not receive events
        EventFilter containerFilter2 = new ContainerFilter( "DoesNotExist" );
        TestChangeListener listener2 = createAndRegisterTestChangeListener( containerFilter2 );
        listener2.expectedAttributeValueChangeEvents = 0;

        // Do the modification and check the events
        pkA.setName( "New Name" );
        checkReceivedEvents( );

        // Clean-up
        deregisterListener( listener );
        deregisterListener( listener2 );
    }

    @Test
    public void testConnectionFilter( ) {

        // Prepare data
        fireCreationEventsA( );

        // Register listener that shall receive events
        EventFilter connectionFilter = new ConnectionFilter( getMOINConnection( ) );
        TestChangeListener listener = createAndRegisterTestChangeListener( connectionFilter );
        listener.expectedAttributeValueChangeEvents = 1;

        // Register listener that shall not receive events
        EventFilter connectionFilter2 = new ConnectionFilter( getSecondMOINConnection( ) );
        TestChangeListener listener2 = createAndRegisterTestChangeListener( connectionFilter2 );
        listener2.expectedAttributeValueChangeEvents = 0;

        // Do the modification and check the events
        pkA.setName( "New Name" );
        checkReceivedEvents( );

        // Clean-up
        deregisterListener( listener );
        deregisterListener( listener2 );
    }

    @Test
    public void testConnectionFilterWithSave( ) throws Exception {

        // Prepare data: try to delete old partition
        Connection conn1 = getMOINConnection( );
        Connection conn2 = getSecondMOINConnection( );
        _testClient1.getOrCreatePartitionStable( "P1" ).delete( );
        _testClient2.getOrCreatePartitionStable( "P2" ).delete( );
        conn1.save( );
        conn2.save( );

        // Register listener that shall receive events
        EventFilter connectionFilter = new ConnectionFilter( conn2 );
        TestChangeListener listener = createAndRegisterTestChangeListener( connectionFilter );
        listener.expectedPartitionCreateEvents = 0;

        // Do the modification and check the events
        _testClient1.getOrCreatePartitionStable( "P1" );
        _testClient2.getOrCreatePartitionStable( "P2" );
        checkReceivedEvents( );

        // Do the modification and check the events
        listener.expectedPartitionCreateEvents = 1;
        conn2.save( );
        checkReceivedEvents( );

        // Clean-up
        deregisterListener( listener );
    }

    @Test
    public void testSessionFilter( ) {

        // Prepare data
        fireCreationEventsA( );

        // Register listener that shall receive events
        EventFilter sessionFilter = new SessionFilter( getMOINConnection( ).getSession( ) );
        TestChangeListener listener = createAndRegisterTestChangeListener( sessionFilter );
        listener.expectedAttributeValueChangeEvents = 1;

        // Register listener that shall not receive events
        EventFilter sessionFilter2 = new SessionFilter( getSecondMOINConnection( ).getSession( ) );
        TestChangeListener listener2 = createAndRegisterTestChangeListener( sessionFilter2 );
        listener2.expectedAttributeValueChangeEvents = 0;

        // Do the modification and check the events
        pkA.setName( "New Name" );
        checkReceivedEvents( );

        // Clean-up
        deregisterListener( listener );
        deregisterListener( listener2 );
    }

    @Test
    public void testSessionFilterWithSave( ) throws Exception {

        // Prepare data: try to delete old partition
        Connection conn1 = getMOINConnection( );
        Connection conn2 = getSecondMOINConnection( );
        _testClient1.getOrCreatePartitionStable( "P1" ).delete( );
        _testClient2.getOrCreatePartitionStable( "P2" ).delete( );
        conn1.save( );
        conn2.save( );

        // Register listener that shall receive events
        EventFilter sessionFilter = new SessionFilter( conn2.getSession( ) );
        TestChangeListener listener = createAndRegisterTestChangeListener( sessionFilter );
        listener.expectedPartitionCreateEvents = 0;

        // Do the modification and check the events
        _testClient1.getOrCreatePartitionStable( "P1" );
        _testClient2.getOrCreatePartitionStable( "P2" );
        checkReceivedEvents( );

        // Do the modification and check the events
        listener.expectedPartitionCreateEvents = 1;
        conn2.save( );
        checkReceivedEvents( );

        // Clean-up
        deregisterListener( listener );
    }


    @Test
    public void testToStringOfEventFilters( ) {

        EventTypeFilter simpleFilter = new EventTypeFilter( AttributeValueChangeEvent.class );
        simpleFilter.toString( );

        EventTypeFilter combinedFilter = new EventTypeFilter( AttributeValueChangeEvent.class, ElementChangeEvent.class );
        combinedFilter.setNegated( true );
        combinedFilter.toString( );

        AndFilter andfilter = new AndFilter( simpleFilter, combinedFilter );
        andfilter.toString( );

        AndFilter andFilterEmptyCreated = new AndFilter( );
        andFilterEmptyCreated.getOperands( ).add( simpleFilter );

        NotFilter notFilter = new NotFilter( simpleFilter );

        OrFilter orFilterEmptyCreated = new OrFilter( );
        orFilterEmptyCreated.getOperands( ).add( simpleFilter );

        PackageFilter pf1 = new PackageFilter( getMOINConnection( ).getPackage( TestcasesfoundationPackage.PACKAGE_DESCRIPTOR ) );
        pf1.toString( );

        Set<RefPackage> packages = new HashSet<RefPackage>( );
        packages.add( getMOINConnection( ).getPackage( TestcasesfoundationPackage.PACKAGE_DESCRIPTOR ) );
        PackageFilter pf2 = new PackageFilter( packages );
        pf2.toString( );

        Set<MofClass> classes = new HashSet<MofClass>( );
        classes.add( (MofClass) getMOINConnection( ).getClass( MofClass.CLASS_DESCRIPTOR ).refMetaObject( ) );
        ClassFilter cf = new ClassFilter( classes, true );
        cf.toString( );

        classes.add( (MofClass) getMOINConnection( ).getClass( MofPackage.CLASS_DESCRIPTOR ).refMetaObject( ) );
        ClassFilter cf2 = new ClassFilter( classes, true );
        cf2.setNegated( true );
        cf2.toString( );

        PartitionFilter pf = new PartitionFilter( getMOINConnection( ).getNullPartition( ).getPri( ) );
        pf.toString( );

        PackageFilter packageFilter = new PackageFilter( ( (Partitionable) getMOINConnection( ).getPackage( TestcasesfoundationPackage.PACKAGE_DESCRIPTOR ).refMetaObject( ) ).get___Mri( ).getLri( ) );
        packageFilter.toString( );

    }

    @Test
    public void testNullFilter( ) throws Exception {

        TestUpdateUserInterfaceListener listener = createAndRegisterTestUpdateUserInterfaceListener( null );
        listener.expectedElementCreateEvents = 1;
        getPartitionOne( ).createElement( MofClass.class );
        checkReceivedEvents( );
    }
}
