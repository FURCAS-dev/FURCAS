package com.sap.tc.moin.repository.test.performance;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.AggregationKindEnum;
import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.Constant;
import com.sap.tc.moin.repository.mmi.model.DirectionKindEnum;
import com.sap.tc.moin.repository.mmi.model.EnumerationType;
import com.sap.tc.moin.repository.mmi.model.Import;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.ModelPackage;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.Operation;
import com.sap.tc.moin.repository.mmi.model.Parameter;
import com.sap.tc.moin.repository.mmi.model.PrimitiveType;
import com.sap.tc.moin.repository.mmi.model.Reference;
import com.sap.tc.moin.repository.mmi.model.ScopeKindEnum;
import com.sap.tc.moin.repository.mmi.model.StructureField;
import com.sap.tc.moin.repository.mmi.model.StructureType;
import com.sap.tc.moin.repository.mmi.primitivetypes.PrimitiveTypesPackage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.events.framework.SessionEventManager;
import com.sap.tc.moin.repository.core.ocl.service.impl.OclRegistryServiceImpl;
import com.sap.tc.moin.repository.events.ChangeListener;
import com.sap.tc.moin.repository.events.EventRegistry;
import com.sap.tc.moin.repository.events.PreChangeListener;
import com.sap.tc.moin.repository.events.filter.CompositionHierarchyFilter;
import com.sap.tc.moin.repository.events.filter.EventFilter;
import com.sap.tc.moin.repository.events.filter.EventTypeFilter;
import com.sap.tc.moin.repository.events.filter.OrFilter;
import com.sap.tc.moin.repository.events.type.AttributeValueAddEvent;
import com.sap.tc.moin.repository.events.type.AttributeValueChangeEvent;
import com.sap.tc.moin.repository.events.type.AttributeValueRemoveEvent;
import com.sap.tc.moin.repository.events.type.ChangeEvent;
import com.sap.tc.moin.repository.events.type.ElementChangeEvent;
import com.sap.tc.moin.repository.events.type.ElementCreateEvent;
import com.sap.tc.moin.repository.events.type.ElementDeleteEvent;
import com.sap.tc.moin.repository.events.type.LinkAddEvent;
import com.sap.tc.moin.repository.events.type.LinkChangeEvent;
import com.sap.tc.moin.repository.events.type.LinkRemoveEvent;
import com.sap.tc.moin.repository.ocl.notification.OclManagerException;
import com.sap.tc.moin.repository.spi.core.Wrapper;
import com.sap.tc.moin.repository.test.core.CoreMoinTest;
import com.sap.tc.moin.test.fw.TestMetaModels;

/**
 * Class to test the MOF ROM with activated event framework
 * 
 * @author d024032
 */
public class TestEventFrameworkPerformance extends CoreMoinTest {

    boolean confirm = false;

    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );
        // init client specs
        mofModelPackage = (ModelPackage) getMOINConnection( ).getPackage( TestMetaModels.MOIN_MOF_CN, TestMetaModels.MOIN_MOF_TPE_MODEL );

        mofPrimitives = new HashMap<String, PrimitiveType>( 6 );
        PrimitiveTypesPackage ptp = (PrimitiveTypesPackage) getMOINConnection( ).getPackage( TestMetaModels.MOIN_MOF_CN, TestMetaModels.MOIN_MOF_TPE_PT );

        List<ModelElement> prims = ptp.refMetaObject( ).getContents( );
        for ( Iterator<ModelElement> i = prims.iterator( ); i.hasNext( ); ) {
            ModelElement me = i.next( );
            if ( me instanceof PrimitiveType ) {
                PrimitiveType pt = (PrimitiveType) me;
                mofPrimitives.put( pt.getName( ), pt );
            }
        }

    }

    @Override
    @After
    public void afterTestMethod( ) throws Exception {

        super.afterTestMethod( );
    }

    // Counter for Pre-Events
    int expectedAttributeValueAddPreEvents = 0;

    int expectedAttributeValueChangePreEvents = 0;

    int expectedAttributeValueRemovePreEvents = 0;

    int expectedElementCreatePreEvents = 0;

    int expectedElementDeletePreEvents = 0;

    int expectedLinkAddPreEvents = 0;

    int expectedLinkRemovePreEvents = 0;

    // Counter for Post-Events
    int expectedAttributeValueAddEvents = 0;

    int expectedAttributeValueChangeEvents = 0;

    int expectedAttributeValueRemoveEvents = 0;

    int expectedElementCreateEvents = 0;

    int expectedElementDeleteEvents = 0;

    int expectedLinkAddEvents = 0;

    int expectedLinkRemoveEvents = 0;

    private void registerSimpleListeners( ) {

        EventRegistry eventRegistry = getMOINConnection( ).getSession( ).getEventRegistry( );

        // Register for ("ElementChange" OR "LinkChange")
        EventFilter filterElementChange = new EventTypeFilter( ElementChangeEvent.class );
        EventFilter filterLinkChange = new EventTypeFilter( LinkChangeEvent.class );
        OrFilter mainFilter = new OrFilter( filterElementChange, filterLinkChange );

        preChangeListener = new MyPreChangeListener( );
        changeListener = new MyChangeListener( );
        myInstanceListener = new MyChangeListener( );

        eventRegistry.registerPreChangeListener( preChangeListener, mainFilter );
        eventRegistry.registerListener( changeListener, mainFilter );
    }

    private void deregisterSimpleListeners( ) {

        // Unregister event listeners
        EventRegistry eventRegistry = getMOINConnection( ).getSession( ).getEventRegistry( );

        eventRegistry.deregister( preChangeListener );
        eventRegistry.deregister( changeListener );
        eventRegistry.deregister( myInstanceListener );

        preChangeListener = null;
        changeListener = null;
        myInstanceListener = null;
    }

    /**
     * PreChangeListener
     */
    private class MyPreChangeListener implements PreChangeListener {

        public void prepare( ChangeEvent event ) {

            if ( event instanceof AttributeValueAddEvent ) {
                expectedAttributeValueAddPreEvents--;
            } else if ( event instanceof AttributeValueChangeEvent ) {
                expectedAttributeValueChangePreEvents--;
            } else if ( event instanceof AttributeValueRemoveEvent ) {
                expectedAttributeValueRemovePreEvents--;
            } else if ( event instanceof ElementCreateEvent ) {
                expectedElementCreatePreEvents--;
            } else if ( event instanceof ElementDeleteEvent ) {
                expectedElementDeletePreEvents--;
            } else if ( event instanceof LinkAddEvent ) {
                expectedLinkAddPreEvents--;
            } else if ( event instanceof LinkRemoveEvent ) {
                expectedLinkRemovePreEvents--;
            } else {
                fail( "Unknown event received in 'prepare'" );
            }
        }
    }

    /**
     * ChangeListener
     */
    private class MyChangeListener implements ChangeListener {

        public void notify( ChangeEvent event ) {

            if ( event instanceof AttributeValueAddEvent ) {
                expectedAttributeValueAddEvents--;
            } else if ( event instanceof AttributeValueChangeEvent ) {
                expectedAttributeValueChangeEvents--;
            } else if ( event instanceof AttributeValueRemoveEvent ) {
                expectedAttributeValueRemoveEvents--;
            } else if ( event instanceof ElementCreateEvent ) {
                expectedElementCreateEvents--;
            } else if ( event instanceof ElementDeleteEvent ) {
                expectedElementDeleteEvents--;
            } else if ( event instanceof LinkAddEvent ) {
                expectedLinkAddEvents--;
            } else if ( event instanceof LinkRemoveEvent ) {
                expectedLinkRemoveEvents--;
            } else {
                fail( "Unknown event received in 'notify'" );
            }
        }
    }

    /**
     * EChangeListener
     */
    private class EmptyChangeListener implements ChangeListener, PreChangeListener {

        public void notify( ChangeEvent event ) {

        }

        public void prepare( ChangeEvent event ) {

        }
    }

    /*
     * Creates a Mof Metamodel programatically using Mof JMI
     */
    @Test
    public void testCreateMOFModelSimpleListeners( ) {

        long startTime = 0;
        long endTime = 0;
        final int repetitions = 1000;
        registerSimpleListeners( );
        SessionEventManager mgr = (SessionEventManager) getMOINConnection( ).getSession( ).getEventRegistry( );
        mgr.setFireEvents( false );
        mofPackage = (MofPackage) mofModelPackage.getMofPackage( ).refCreateInstance( );
        MofClass clazz = (MofClass) mofModelPackage.getMofClass( ).refCreateInstance( );
        mofPackage.getContents( ).add( clazz );
        clazz.setContainer( mofPackage );

        // register instance listener
        EventFilter instanceInclCompositionsFilter = new CompositionHierarchyFilter( mofPackage );
        getMOINConnection( ).getSession( ).getEventRegistry( ).registerListener( myInstanceListener, instanceInclCompositionsFilter );

        startTime = System.currentTimeMillis( );
        for ( int i = 0; i < repetitions; i++ ) {
            mofPackage.setName( "aMofPackage" );
            mofPackage.setName( "bMofPackage" );
            clazz.setName( "aMofClass" );
            clazz.setName( "bMofClass" );
        }

        long withoutEvents = System.currentTimeMillis( ) - startTime;
        System.out.println( "Time without events: " + withoutEvents );

        nextStep( "Test w/events" );
        // --- Test with events
        mgr.setFireEvents( true );
        expectedAttributeValueChangePreEvents = repetitions * 4;
        expectedAttributeValueChangeEvents = repetitions * 8;

        startTime = System.currentTimeMillis( );
        for ( int i = 0; i < repetitions; i++ ) {
            mofPackage.setName( "aMofPackage" );
            mofPackage.setName( "bMofPackage" );
            clazz.setName( "aMofClass" );
            clazz.setName( "bMofClass" );
        }
        long withEvents = System.currentTimeMillis( ) - startTime;
        System.out.println( "Time with events: " + withEvents );
        double percent = Math.round( ( (double) withEvents / (double) withoutEvents ) * 100 - 100 );
        System.out.println( "Percent of performance used in EventFramework: " + percent );

        nextStep( "Test  w/events done" );

        checkReceivedEvents( );
        mofPackage.refDelete( );
        deregisterSimpleListeners( );
    }

    private void checkReceivedEvents( ) {

        assertEquals( expectedAttributeValueAddPreEvents, 0 );
        assertEquals( expectedAttributeValueChangePreEvents, 0 );
        assertEquals( expectedAttributeValueRemovePreEvents, 0 );
        assertEquals( expectedElementCreatePreEvents, 0 );
        assertEquals( expectedElementDeletePreEvents, 0 );
        assertEquals( expectedLinkAddPreEvents, 0 );
        assertEquals( expectedLinkRemovePreEvents, 0 );

        assertEquals( expectedAttributeValueAddEvents, 0 );
        assertEquals( expectedAttributeValueChangeEvents, 0 );
        assertEquals( expectedAttributeValueRemoveEvents, 0 );
        assertEquals( expectedElementCreateEvents, 0 );
        assertEquals( expectedElementDeleteEvents, 0 );
        assertEquals( expectedLinkAddEvents, 0 );
        assertEquals( expectedLinkRemoveEvents, 0 );

        expectedAttributeValueAddPreEvents = 0;
        expectedAttributeValueChangePreEvents = 0;
        expectedAttributeValueRemovePreEvents = 0;
        expectedElementCreatePreEvents = 0;
        expectedElementDeletePreEvents = 0;
        expectedLinkAddPreEvents = 0;
        expectedLinkRemovePreEvents = 0;

        expectedAttributeValueAddEvents = 0;
        expectedAttributeValueChangeEvents = 0;
        expectedAttributeValueRemoveEvents = 0;
        expectedElementCreateEvents = 0;
        expectedElementDeleteEvents = 0;
        expectedLinkAddEvents = 0;
        expectedLinkRemoveEvents = 0;
    }

    @Test
    public void testCreateMOFModelMOFFilters( ) throws OclManagerException {

        long startTime = 0;
        long endTime = 0;
        final int repetitions = 1000;
        EventRegistry eventRegistry = getMOINConnection( ).getSession( ).getEventRegistry( );
        long time = System.currentTimeMillis( );
        EventFilter filter = getMOFConstraintsListeners( );
        long elapsedTime = System.currentTimeMillis( ) - time;
        System.out.println( "MOF Constraint Listener Time: " + elapsedTime );

        System.out.println( filter );
        mofPackage = (MofPackage) mofModelPackage.getMofPackage( ).refCreateInstance( );

        // Warm up!
        for ( int i = 0; i < repetitions; i++ ) {
            doModelManipulation( );
        }

        // Test without events
        SessionEventManager mgr = (SessionEventManager) getMOINConnection( ).getSession( ).getEventRegistry( );
        mgr.setFireEvents( false );
        nextStep( "0 - Test without events" );

        startTime = System.currentTimeMillis( );
        for ( int i = 0; i < repetitions; i++ ) {
            doModelManipulation( );
        }
        long withoutEvents = System.currentTimeMillis( ) - startTime;
        System.out.println( "Time without events: " + withoutEvents );

        mgr.setFireEvents( true );

        // Test without filters
        nextStep( "1 - Test without filter" );

        startTime = System.currentTimeMillis( );
        for ( int i = 0; i < repetitions; i++ ) {
            doModelManipulation( );
        }
        long withoutFilters = System.currentTimeMillis( ) - startTime;
        System.out.println( "Time without filters: " + withoutFilters );

        // Test with simple filters
        nextStep( "2 - Test with simple filters" );
        registerSimpleListeners( );

        startTime = System.currentTimeMillis( );
        for ( int i = 0; i < repetitions; i++ ) {
            doModelManipulation( );
        }
        long withSEvents = System.currentTimeMillis( ) - startTime;

        System.out.println( "Time with simple filters: " + withSEvents );
        double percents = Math.round( ( (double) withSEvents / (double) withoutEvents ) * 100 - 100 );
        System.out.println( "Percent of performance used in EventFramework: " + percents );
        nextStep( "Done..." );
        deregisterMOFConstraintsListeners( );

        // Test with OCL filters
        nextStep( "3 - Test with MOF Constraints filters" );
        eChangeListener = new EmptyChangeListener( );
        eventRegistry.registerListener( eChangeListener, filter );

        startTime = System.currentTimeMillis( );
        for ( int i = 0; i < repetitions; i++ ) {
            doModelManipulation( );
        }
        long withEvents = System.currentTimeMillis( ) - startTime;
        System.out.println( "Time with MOF constraints filters: " + withEvents );
        double percent = Math.round( ( (double) withEvents / (double) withoutEvents ) * 100 - 100 );
        System.out.println( "Percent of performance used in EventFramework: " + percent );
        nextStep( "Done..." );
        deregisterSimpleListeners( );

    }

    protected void doModelManipulation( ) {

        // doCreateMofModel();
        doSimpleModelChanges( );
    }

    protected void doSimpleModelChanges( ) {

        mofPackage.setName( "aMofPackage" );
        mofPackage.setName( "bMofPackage" );
    }

    protected void doCreateMofModel( ) {
        CoreConnection conn = ( (Wrapper<CoreConnection>) getMOINConnection( ) ).unwrap( );

        // Elements in the test MOF Model
        MofPackage mofPackage = null;
        MofPackage mofPackageB = null;
        Import packageImport = null;
        MofClass classA = null;
        MofClass classB = null;
        MofClass classC = null;
        MofClass classD = null;
        Constant constA = null;
        Operation operA = null;
        Parameter param0 = null;
        Parameter param1 = null;
        PrimitiveType primitiveC = null;
        EnumerationType enumD = null;
        StructureType structE = null;
        StructureField fieldF = null;
        StructureField fieldG = null;
        Attribute attrA = null;
        Attribute attrB = null;
        Association assocAB = null;
        AssociationEnd aEndA = null;
        AssociationEnd aEndB = null;
        Reference refAB = null;

        // Create a Mof Package named "aMofPackage"
        mofPackage = (MofPackage) mofModelPackage.getMofPackage( ).refCreateInstance( );

        mofPackage.setName( "aMofPackage" );

        // Create another Mof Package named "anotherMofPackage"
        mofPackageB = (MofPackage) mofModelPackage.getMofPackage( ).refCreateInstance( );
        mofPackageB.setName( "anotherMofPackage" );

        // create an import
        packageImport = (Import) mofModelPackage.getImport( ).refCreateInstance( );
        packageImport.setName( "importAnother" );
        packageImport.setContainer( mofPackage );
        packageImport.setImportedNamespace( mofPackageB );
        packageImport.setClustered( true );

        // Create an Abstract Mof Class named "ClassA"
        classA = (MofClass) mofModelPackage.getMofClass( ).refCreateInstance( );
        classA.setName( "ClassA" );
        classA.setAbstract( true );
        classA.setContainer( mofPackage );

        // Create a Mof Class named "ClassB", derived from "ClassA"
        classB = (MofClass) mofModelPackage.getMofClass( ).refCreateInstance( );
        classB.setName( "ClassB" );
        classB.setContainer( mofPackage );
        classB.getSupertypes( ).add( classA );

        classC = (MofClass) mofModelPackage.getMofClass( ).refCreateInstance( );
        classC.setName( "ClassC" );
        classC.setContainer( mofPackage );
        classC.getSupertypes( ).add( classA );

        classD = (MofClass) mofModelPackage.getMofClass( ).refCreateInstance( );
        classD.setName( "ClassD" );
        classD.setContainer( mofPackage );
        classD.getSupertypes( ).add( classB );
        classD.getSupertypes( ).add( classC );

        // Create a Mof Primitive Type named "PrimitiveC"
        primitiveC = (PrimitiveType) mofModelPackage.getPrimitiveType( ).refCreateInstance( );
        primitiveC.setName( "PrimitiveC" );
        primitiveC.setContainer( mofPackageB );

        // Create a Mof EnumerationType "EnumD"
        enumD = (EnumerationType) mofModelPackage.getEnumerationType( ).refCreateInstance( );
        enumD.setName( "EnumD" );
        enumD.getLabels( ).add( "Label1" );
        enumD.getLabels( ).add( "Label2" );
        enumD.getLabels( ).add( "LabelTmp" );
        enumD.getLabels( ).remove( "LabelTmp" );
        enumD.setContainer( mofPackageB );

        // Create a Mof StructureType "StructE"
        structE = (StructureType) mofModelPackage.getStructureType( ).refCreateInstance( );
        structE.setName( "StructE" );
        structE.setContainer( mofPackageB );
        fieldF = (StructureField) mofModelPackage.getStructureField( ).refCreateInstance( );
        fieldF.setName( "FieldF" );
        fieldF.setType( (PrimitiveType) mofPrimitives.get( "Integer" ) );
        fieldF.setContainer( structE );
        fieldG = (StructureField) mofModelPackage.getStructureField( ).refCreateInstance( );
        fieldG.setName( "FieldG" );
        fieldG.setType( (PrimitiveType) mofPrimitives.get( "String" ) );
        fieldG.setContainer( structE );

        // Create Attribute attrA in class ClassA of type ClassB
        // ClassA.attrA:ClassB
        attrA = (Attribute) mofModelPackage.getAttribute( ).refCreateInstance( );
        attrA.setName( "attrA" );
        attrA.setType( classB );
        attrA.setDerived( true );
        attrA.setContainer( classA );
        attrA.setMultiplicity( conn.getCoreJmiHelper( ).createMultiplicityType( conn, 1, 1, false, false ) );
        attrA.setChangeable( true );

        // Create Attribute attrB in class ClassA of type ClassB
        // ClassA.attrB:PrimitiveC
        attrB = (Attribute) mofModelPackage.getAttribute( ).refCreateInstance( );
        attrB.setName( "attrB" );
        attrB.setType( primitiveC );
        attrB.setScope( ScopeKindEnum.CLASSIFIER_LEVEL );
        attrB.setContainer( classA );
        attrB.setMultiplicity( conn.getCoreJmiHelper( ).createMultiplicityType( conn, 1, 1, false, false ) );
        attrB.setChangeable( true );

        constA = (Constant) mofModelPackage.getConstant( ).refCreateInstance( );
        constA.setName( "ConstA" );
        constA.setType( (PrimitiveType) mofPrimitives.get( "Integer" ) );
        constA.setContainer( classA );
        constA.setValue( "44" );

        operA = (Operation) mofModelPackage.getOperation( ).refCreateInstance( );
        operA.setName( "operA" );
        operA.setContainer( classA );
        operA.setQuery( true );

        // create paramaters
        param0 = (Parameter) mofModelPackage.getParameter( ).refCreateInstance( );
        param0.setName( "param0" );
        param0.setContainer( operA );
        param0.setDirection( DirectionKindEnum.RETURN_DIR );
        param0.setType( classB );

        param1 = (Parameter) mofModelPackage.getParameter( ).refCreateInstance( );
        param1.setName( "param1" );
        param1.setContainer( operA );
        param1.setDirection( DirectionKindEnum.IN_DIR );
        param1.setType( (PrimitiveType) mofPrimitives.get( "String" ) );
        param1.setMultiplicity( conn.getCoreJmiHelper( ).createMultiplicityType( conn, 1, -1, true, false ) );

        // create asociation including ends
        assocAB = (Association) mofModelPackage.getAssociation( ).refCreateInstance( );
        assocAB.setName( "AssocAB" );
        assocAB.setContainer( mofPackage );

        aEndA = (AssociationEnd) mofModelPackage.getAssociationEnd( ).refCreateInstance( );
        aEndA.setName( "theA" );
        aEndA.setType( classA );
        aEndA.setAggregation( AggregationKindEnum.COMPOSITE );
        aEndA.setMultiplicity( conn.getCoreJmiHelper( ).createMultiplicityType( conn, 0, 1, false, true ) );
        aEndA.setContainer( assocAB );
        aEndA.setChangeable( true );

        aEndB = (AssociationEnd) mofModelPackage.getAssociationEnd( ).refCreateInstance( );
        aEndB.setName( "theB" );
        aEndB.setType( classB );
        aEndB.setAggregation( AggregationKindEnum.NONE );
        aEndB.setMultiplicity( conn.getCoreJmiHelper( ).createMultiplicityType( conn, 0, -1, false, true ) );
        aEndB.setContainer( assocAB );
        aEndB.setChangeable( true );
        aEndB.setNavigable( true );

        // create reference
        refAB = (Reference) mofModelPackage.getReference( ).refCreateInstance( );
        refAB.setReferencedEnd( aEndB );
        refAB.setName( aEndB.getName( ) );
        refAB.setType( aEndB.getType( ) );
        refAB.setMultiplicity( aEndB.getMultiplicity( ) );
        assertEquals( refAB.getExposedEnd( ), aEndA );
        refAB.setContainer( aEndA.getType( ) );
        refAB.setChangeable( true );

        // Create of MOF class to be deleted
        MofClass classTmp = null;
        classTmp = (MofClass) mofModelPackage.getMofClass( ).refCreateInstance( );
        classTmp.setName( "ClassTmp" );
        classTmp.setContainer( mofPackage );
        classTmp.refDelete( );

        mofPackage.refDelete( );
        mofPackageB.refDelete( );
    }

    protected void nextStep( String msg ) {

        java.lang.System.out.print( msg );
        if ( confirm ) {
            java.lang.System.out.println( "... 'Enter' to continue." );
            try {
                while ( java.lang.System.in.read( ) != 13 ) {
                }
            } catch ( IOException e ) {
                // TODO Auto-generated catch block
                e.printStackTrace( );
            }
            ;
        } else {
            java.lang.System.out.println( "" );
        }
    }

    private EventFilter getMOFConstraintsListeners( ) throws OclManagerException {

        CoreConnection conn = (CoreConnection) ( (Wrapper) getMOINConnection( ) ).unwrap( );
        synchronized ( conn.getSession( ).getWorkspaceSet( ).getSynchronizationManager( ).getProhibitWriteSyncObject( ) ) {
            OclRegistryServiceImpl srv = (OclRegistryServiceImpl) conn.getOclRegistryService( );
            return srv.getMofConstraintEventFilter( conn );
        }
    }

    private void deregisterMOFConstraintsListeners( ) {

        // Unregister event listeners
        EventRegistry eventRegistry = getMOINConnection( ).getSession( ).getEventRegistry( );
        eventRegistry.deregister( eChangeListener );
        eChangeListener = null;
    }

    MofPackage mofPackage = null;

    // Housekeeping
    private ModelPackage mofModelPackage;

    private HashMap<String, PrimitiveType> mofPrimitives;

    private PreChangeListener preChangeListener;

    private ChangeListener changeListener;

    private ChangeListener myInstanceListener;

    private EmptyChangeListener eChangeListener;
}
