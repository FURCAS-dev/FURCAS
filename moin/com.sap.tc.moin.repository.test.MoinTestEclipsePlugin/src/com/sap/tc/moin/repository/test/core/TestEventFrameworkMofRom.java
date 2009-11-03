/*
 * Created on 16.12.2005
 */
package com.sap.tc.moin.repository.test.core;

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

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.events.ChangeListener;
import com.sap.tc.moin.repository.events.CommitListener;
import com.sap.tc.moin.repository.events.EventChain;
import com.sap.tc.moin.repository.events.PreChangeListener;
import com.sap.tc.moin.repository.events.PreCommitListener;
import com.sap.tc.moin.repository.events.filter.AndFilter;
import com.sap.tc.moin.repository.events.filter.ClassFilter;
import com.sap.tc.moin.repository.events.filter.EventFilter;
import com.sap.tc.moin.repository.events.filter.EventTypeFilter;
import com.sap.tc.moin.repository.events.filter.InstanceFilter;
import com.sap.tc.moin.repository.events.filter.OrFilter;
import com.sap.tc.moin.repository.events.filter.PackageFilter;
import com.sap.tc.moin.repository.events.filter.PartitionFilter;
import com.sap.tc.moin.repository.events.type.ChangeEvent;
import com.sap.tc.moin.repository.events.type.ElementChangeEvent;
import com.sap.tc.moin.repository.events.type.ElementCreateEvent;
import com.sap.tc.moin.repository.events.type.LinkChangeEvent;
import com.sap.tc.moin.repository.events.type.PartitionChangeEvent;
import com.sap.tc.moin.test.fw.TestMetaModels;

/**
 * Class to test the MOF ROM with activated event framework
 * 
 * @author d024032
 */
public class TestEventFrameworkMofRom extends EventFrameworkTest {

    private ModelPackage mofModelPackage;

    private HashMap<String, PrimitiveType> mofPrimitives;

    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );
        // init client specs
        mofModelPackage = (ModelPackage) connection.getPackage( TestMetaModels.MOIN_MOF_CN, TestMetaModels.MOIN_MOF_TPE_MODEL );

        mofPrimitives = new HashMap<String, PrimitiveType>( 6 );
        PrimitiveTypesPackage ptp = (PrimitiveTypesPackage) connection.getPackage( TestMetaModels.MOIN_MOF_CN, TestMetaModels.MOIN_MOF_TPE_PT );
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

        mofModelPackage = null;
        mofPrimitives = null;
        super.afterTestMethod( );
    }

    @Test
    public void testCreateMOFModel( ) {

        // --- BEGIN SECTION
        CoreConnection conn = getTestHelper( ).getCoreConnection( getMOINConnection( ) );

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

        // Register for ("ElementChange" OR "LinkChange")
        EventFilter filterElementChange = new EventTypeFilter( ElementChangeEvent.class );
        EventFilter filterLinkChange = new EventTypeFilter( LinkChangeEvent.class );
        OrFilter mainFilter = new OrFilter( filterElementChange, filterLinkChange );

        // PCL = PreChangeListener
        TestPreChangeListener elementAndLinkChangePCL = createAndRegisterTestPreChangeListener( mainFilter );
        // CL = ChangeListener
        TestChangeListener elementAndLinkChangeCL = createAndRegisterTestChangeListener( mainFilter );

        // Register for ("EventType=ElementCreateEvent AND ClassFitler=MofPackage and subtypes")
        EventFilter filterElementCreate = new EventTypeFilter( ElementCreateEvent.class );
        EventFilter classFilterMofPackage = new ClassFilter( mofModelPackage.getMofPackage( ).refMetaObject( ), true );
        AndFilter createMofPackageFilter = new AndFilter( filterElementCreate, classFilterMofPackage );

        TestChangeListener createMofPackageCL = createAndRegisterTestChangeListener( createMofPackageFilter );
        TestPreChangeListener createMofPackagePCL = createAndRegisterTestPreChangeListener( createMofPackageFilter );

        // set the number of expected events
        elementAndLinkChangePCL.expectedElementCreateEvents = 1;
        elementAndLinkChangeCL.expectedElementCreateEvents = 1;

        createMofPackageCL.expectedElementCreateEvents = 1;
        createMofPackagePCL.expectedElementCreateEvents = 1;

        // Create a Mof Package named "aMofPackage"
        mofPackage = (MofPackage) mofModelPackage.getMofPackage( ).refCreateInstance( );

        checkReceivedEvents( );

        // Test instance filter
        TestPreChangeListener instancePCL = createAndRegisterTestPreChangeListener( new InstanceFilter( mofPackage ) );
        // Test PartitionMembership filter
        TestChangeListener partitionMembershipCL = createAndRegisterTestChangeListener( new PartitionFilter( ( (Partitionable) mofPackage ).get___Partition( ) ) );
        // Test Partition filter
        TestChangeListener partitionCL = createAndRegisterTestChangeListener( new AndFilter( new PartitionFilter( ( (Partitionable) mofPackage ).get___Partition( ) ), new EventTypeFilter( PartitionChangeEvent.class ) ) );
        // Test class filter with subtypes
        TestChangeListener classFilterInclSubTypesCL = createAndRegisterTestChangeListener( new ClassFilter( (MofClass) mofPackage.refMetaObject( ), true ) );
        // Test package filter
        TestChangeListener packageCL = createAndRegisterTestChangeListener( new PackageFilter( mofPackage.refImmediatePackage( ) ) );

        // set the number of expected events
        elementAndLinkChangePCL.expectedAttributeValueChangeEvents = 1;
        elementAndLinkChangeCL.expectedAttributeValueChangeEvents = 1;
        packageCL.expectedAttributeValueChangeEvents = 1;
        classFilterInclSubTypesCL.expectedAttributeValueChangeEvents = 1;
        partitionMembershipCL.expectedAttributeValueChangeEvents = 1;
        instancePCL.expectedAttributeValueChangeEvents = 1;

        mofPackage.setName( "aMofPackage" );

        /*
         * Listeners active: instancePCL partitionMembershipCL partitionCL
         * classFilterInclSubTypesCL packageCL elementAndLinkChangePCL
         * elementAndLinkChangeCL createMofPackageCL createMofPackagePCL
         */

        deregisterListener( partitionCL );
        deregisterListener( createMofPackageCL );
        deregisterListener( createMofPackagePCL );
        deregisterListener( instancePCL );

        // Check if expected events have been received
        checkReceivedEvents( );
        // --- END SECTION

        // --- BEGIN SECTION
        // Set the number of expected events

        partitionMembershipCL.expectedElementCreateEvents = 1;
        partitionMembershipCL.expectedAttributeValueChangeEvents = 1;
        classFilterInclSubTypesCL.expectedElementCreateEvents = 1;
        classFilterInclSubTypesCL.expectedAttributeValueChangeEvents = 1;
        packageCL.expectedElementCreateEvents = 1;
        packageCL.expectedAttributeValueChangeEvents = 1;
        elementAndLinkChangePCL.expectedElementCreateEvents = 1;
        elementAndLinkChangePCL.expectedAttributeValueChangeEvents = 1;
        elementAndLinkChangeCL.expectedElementCreateEvents = 1;
        elementAndLinkChangeCL.expectedAttributeValueChangeEvents = 1;

        // Create another Mof Package named "anotherMofPackage"
        mofPackageB = (MofPackage) mofModelPackage.getMofPackage( ).refCreateInstance( );
        mofPackageB.setName( "anotherMofPackage" );
        // Check if expected events have been received
        checkReceivedEvents( );

        deregisterListener( classFilterInclSubTypesCL );
        // --- END SECTION

        // --- BEGIN SECTION
        // Set the number of expected events

        partitionMembershipCL.expectedElementCreateEvents = 1;
        partitionMembershipCL.expectedAttributeValueChangeEvents = 2;
        partitionMembershipCL.expectedLinkAddEvents = 2;

        packageCL.expectedElementCreateEvents = 1;
        packageCL.expectedAttributeValueChangeEvents = 2;
        packageCL.expectedLinkAddEvents = 2;

        elementAndLinkChangePCL.expectedElementCreateEvents = 1;
        elementAndLinkChangePCL.expectedAttributeValueChangeEvents = 2;
        elementAndLinkChangePCL.expectedLinkAddEvents = 2;

        elementAndLinkChangeCL.expectedElementCreateEvents = 1;
        elementAndLinkChangeCL.expectedAttributeValueChangeEvents = 2;
        elementAndLinkChangeCL.expectedLinkAddEvents = 2;

        // create an import
        packageImport = (Import) mofModelPackage.getImport( ).refCreateInstance( );
        packageImport.setName( "importAnother" );
        packageImport.setContainer( mofPackage );
        packageImport.setImportedNamespace( mofPackageB );
        packageImport.setClustered( true );
        // Check if expected events have been received
        checkReceivedEvents( );
        // --- END SECTION

        // --- BEGIN SECTION
        // Set the number of expected events
        partitionMembershipCL.expectedElementCreateEvents = 1;
        partitionMembershipCL.expectedAttributeValueChangeEvents = 2;
        partitionMembershipCL.expectedLinkAddEvents = 1;

        packageCL.expectedElementCreateEvents = 1;
        packageCL.expectedAttributeValueChangeEvents = 2;
        packageCL.expectedLinkAddEvents = 1;

        elementAndLinkChangePCL.expectedElementCreateEvents = 1;
        elementAndLinkChangePCL.expectedAttributeValueChangeEvents = 2;
        elementAndLinkChangePCL.expectedLinkAddEvents = 1;

        elementAndLinkChangeCL.expectedElementCreateEvents = 1;
        elementAndLinkChangeCL.expectedAttributeValueChangeEvents = 2;
        elementAndLinkChangeCL.expectedLinkAddEvents = 1;

        // Create an Abstract Mof Class named "ClassA"
        classA = (MofClass) mofModelPackage.getMofClass( ).refCreateInstance( );
        classA.setName( "ClassA" );
        classA.setAbstract( true );
        classA.setContainer( mofPackage );
        // Check if expected events have been received
        checkReceivedEvents( );
        // --- END SECTION

        // --- BEGIN SECTION
        // Set the number of expected events

        partitionMembershipCL.expectedElementCreateEvents = 3;
        partitionMembershipCL.expectedAttributeValueChangeEvents = 3;
        partitionMembershipCL.expectedLinkAddEvents = 7;

        packageCL.expectedElementCreateEvents = 3;
        packageCL.expectedAttributeValueChangeEvents = 3;
        packageCL.expectedLinkAddEvents = 7;

        elementAndLinkChangePCL.expectedElementCreateEvents = 3;
        elementAndLinkChangePCL.expectedAttributeValueChangeEvents = 3;
        elementAndLinkChangePCL.expectedLinkAddEvents = 7;

        elementAndLinkChangeCL.expectedElementCreateEvents = 3;
        elementAndLinkChangeCL.expectedAttributeValueChangeEvents = 3;
        elementAndLinkChangeCL.expectedLinkAddEvents = 7;

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
        // Check if expected events have been received
        checkReceivedEvents( );
        // --- END SECTION

        // --- BEGIN SECTION
        // Set the number of expected events
        partitionMembershipCL.expectedElementCreateEvents = 1;
        partitionMembershipCL.expectedAttributeValueChangeEvents = 1;
        partitionMembershipCL.expectedLinkAddEvents = 1;

        packageCL.expectedElementCreateEvents = 1;
        packageCL.expectedAttributeValueChangeEvents = 1;
        packageCL.expectedLinkAddEvents = 1;

        elementAndLinkChangePCL.expectedElementCreateEvents = 1;
        elementAndLinkChangePCL.expectedAttributeValueChangeEvents = 1;
        elementAndLinkChangePCL.expectedLinkAddEvents = 1;

        elementAndLinkChangeCL.expectedElementCreateEvents = 1;
        elementAndLinkChangeCL.expectedAttributeValueChangeEvents = 1;
        elementAndLinkChangeCL.expectedLinkAddEvents = 1;

        // Create a Mof Primitive Type named "PrimitiveC"
        primitiveC = (PrimitiveType) mofModelPackage.getPrimitiveType( ).refCreateInstance( );
        primitiveC.setName( "PrimitiveC" );
        primitiveC.setContainer( mofPackageB );
        // Check if expected events have been received
        checkReceivedEvents( );
        // --- END SECTION

        // --- BEGIN SECTION
        // Set the number of expected events
        partitionMembershipCL.expectedElementCreateEvents = 1;
        partitionMembershipCL.expectedAttributeValueChangeEvents = 1;
        partitionMembershipCL.expectedLinkAddEvents = 1;
        partitionMembershipCL.expectedAttributeValueAddEvents = 3;
        partitionMembershipCL.expectedAttributeValueRemoveEvents = 1;

        packageCL.expectedElementCreateEvents = 1;
        packageCL.expectedAttributeValueChangeEvents = 1;
        packageCL.expectedLinkAddEvents = 1;
        packageCL.expectedAttributeValueAddEvents = 3;
        packageCL.expectedAttributeValueRemoveEvents = 1;

        elementAndLinkChangePCL.expectedElementCreateEvents = 1;
        elementAndLinkChangePCL.expectedAttributeValueChangeEvents = 1;
        elementAndLinkChangePCL.expectedLinkAddEvents = 1;
        elementAndLinkChangePCL.expectedAttributeValueAddEvents = 3;
        elementAndLinkChangePCL.expectedAttributeValueRemoveEvents = 1;

        elementAndLinkChangeCL.expectedElementCreateEvents = 1;
        elementAndLinkChangeCL.expectedAttributeValueChangeEvents = 1;
        elementAndLinkChangeCL.expectedLinkAddEvents = 1;
        elementAndLinkChangeCL.expectedAttributeValueAddEvents = 3;
        elementAndLinkChangeCL.expectedAttributeValueRemoveEvents = 1;

        // Create a Mof EnumerationType "EnumD"
        enumD = (EnumerationType) mofModelPackage.getEnumerationType( ).refCreateInstance( );
        enumD.setName( "EnumD" );
        enumD.getLabels( ).add( "Label1" );
        enumD.getLabels( ).add( "Label2" );
        enumD.getLabels( ).add( "LabelTmp" );
        enumD.getLabels( ).remove( "LabelTmp" );
        enumD.setContainer( mofPackageB );
        // Check if expected events have been received
        checkReceivedEvents( );
        // --- END SECTION

        // --- BEGIN SECTION
        // Set the number of expected events
        partitionMembershipCL.expectedElementCreateEvents = 3;
        partitionMembershipCL.expectedAttributeValueChangeEvents = 3;
        partitionMembershipCL.expectedLinkAddEvents = 5;

        packageCL.expectedElementCreateEvents = 3;
        packageCL.expectedAttributeValueChangeEvents = 3;
        packageCL.expectedLinkAddEvents = 5;

        elementAndLinkChangePCL.expectedElementCreateEvents = 3;
        elementAndLinkChangePCL.expectedAttributeValueChangeEvents = 3;
        elementAndLinkChangePCL.expectedLinkAddEvents = 5;

        elementAndLinkChangeCL.expectedElementCreateEvents = 3;
        elementAndLinkChangeCL.expectedAttributeValueChangeEvents = 3;
        elementAndLinkChangeCL.expectedLinkAddEvents = 5;

        // Create a Mof StructureType "StructE"
        structE = (StructureType) mofModelPackage.getStructureType( ).refCreateInstance( );
        structE.setName( "StructE" );
        structE.setContainer( mofPackageB );
        fieldF = (StructureField) mofModelPackage.getStructureField( ).refCreateInstance( );
        fieldF.setName( "FieldF" );
        fieldF.setType( mofPrimitives.get( "Integer" ) );
        fieldF.setContainer( structE );
        fieldG = (StructureField) mofModelPackage.getStructureField( ).refCreateInstance( );
        fieldG.setName( "FieldG" );
        fieldG.setType( mofPrimitives.get( "String" ) );
        fieldG.setContainer( structE );
        // Check if expected events have been received
        checkReceivedEvents( );
        // --- END SECTION

        // --- BEGIN SECTION
        // Set the number of expected events
        partitionMembershipCL.expectedElementCreateEvents = 4;
        partitionMembershipCL.expectedAttributeValueChangeEvents = 12;
        partitionMembershipCL.expectedLinkAddEvents = 7;

        packageCL.expectedElementCreateEvents = 4;
        packageCL.expectedAttributeValueChangeEvents = 12;
        packageCL.expectedLinkAddEvents = 7;

        elementAndLinkChangePCL.expectedElementCreateEvents = 4;
        elementAndLinkChangePCL.expectedAttributeValueChangeEvents = 12;
        elementAndLinkChangePCL.expectedLinkAddEvents = 7;

        elementAndLinkChangeCL.expectedElementCreateEvents = 4;
        elementAndLinkChangeCL.expectedAttributeValueChangeEvents = 12;
        elementAndLinkChangeCL.expectedLinkAddEvents = 7;

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
        constA.setType( mofPrimitives.get( "Integer" ) );
        constA.setContainer( classA );
        constA.setValue( "44" );

        operA = (Operation) mofModelPackage.getOperation( ).refCreateInstance( );
        operA.setName( "operA" );
        operA.setContainer( classA );
        operA.setQuery( true );
        // Check if expected events have been received
        checkReceivedEvents( );
        // --- END SECTION

        // --- BEGIN SECTION
        // Set the number of expected events
        partitionMembershipCL.expectedElementCreateEvents = 2;
        partitionMembershipCL.expectedAttributeValueChangeEvents = 5;
        partitionMembershipCL.expectedLinkAddEvents = 4;

        packageCL.expectedElementCreateEvents = 2;
        packageCL.expectedAttributeValueChangeEvents = 5;
        packageCL.expectedLinkAddEvents = 4;

        elementAndLinkChangePCL.expectedElementCreateEvents = 2;
        elementAndLinkChangePCL.expectedAttributeValueChangeEvents = 5;
        elementAndLinkChangePCL.expectedLinkAddEvents = 4;

        elementAndLinkChangeCL.expectedElementCreateEvents = 2;
        elementAndLinkChangeCL.expectedAttributeValueChangeEvents = 5;
        elementAndLinkChangeCL.expectedLinkAddEvents = 4;
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
        param1.setType( mofPrimitives.get( "String" ) );
        param1.setMultiplicity( conn.getCoreJmiHelper( ).createMultiplicityType( conn, 1, -1, true, false ) );
        // Check if expected events have been received
        checkReceivedEvents( );
        // --- END SECTION

        // --- BEGIN SECTION
        // Set the number of expected events
        partitionMembershipCL.expectedElementCreateEvents = 3;
        partitionMembershipCL.expectedAttributeValueChangeEvents = 10;
        partitionMembershipCL.expectedLinkAddEvents = 5;

        packageCL.expectedElementCreateEvents = 3;
        packageCL.expectedAttributeValueChangeEvents = 10;
        packageCL.expectedLinkAddEvents = 5;

        elementAndLinkChangePCL.expectedElementCreateEvents = 3;
        elementAndLinkChangePCL.expectedAttributeValueChangeEvents = 10;
        elementAndLinkChangePCL.expectedLinkAddEvents = 5;

        elementAndLinkChangeCL.expectedElementCreateEvents = 3;
        elementAndLinkChangeCL.expectedAttributeValueChangeEvents = 10;
        elementAndLinkChangeCL.expectedLinkAddEvents = 5;

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
        assertEquals( aEndB.otherEnd( ), aEndA );
        // Check if expected events have been received
        checkReceivedEvents( );
        // --- END SECTION

        // --- BEGIN SECTION
        // Set the number of expected events
        partitionMembershipCL.expectedElementCreateEvents = 1;
        partitionMembershipCL.expectedAttributeValueChangeEvents = 3;
        partitionMembershipCL.expectedLinkAddEvents = 3;

        packageCL.expectedElementCreateEvents = 1;
        packageCL.expectedAttributeValueChangeEvents = 3;
        packageCL.expectedLinkAddEvents = 3;

        elementAndLinkChangePCL.expectedElementCreateEvents = 1;
        elementAndLinkChangePCL.expectedAttributeValueChangeEvents = 3;
        elementAndLinkChangePCL.expectedLinkAddEvents = 3;

        elementAndLinkChangeCL.expectedElementCreateEvents = 1;
        elementAndLinkChangeCL.expectedAttributeValueChangeEvents = 3;
        elementAndLinkChangeCL.expectedLinkAddEvents = 3;

        // create reference
        refAB = (Reference) mofModelPackage.getReference( ).refCreateInstance( );
        refAB.setReferencedEnd( aEndB );
        refAB.setName( aEndB.getName( ) );
        refAB.setType( aEndB.getType( ) );
        refAB.setMultiplicity( aEndB.getMultiplicity( ) );
        assertEquals( refAB.getExposedEnd( ), aEndA );
        refAB.setContainer( aEndA.getType( ) );
        refAB.setChangeable( true );
        // Check if expected events have been received
        checkReceivedEvents( );
        // --- END SECTION

        // --- BEGIN SECTION
        // Set the number of expected events
        partitionMembershipCL.expectedElementCreateEvents = 1;
        partitionMembershipCL.expectedElementDeleteEvents = 1;
        partitionMembershipCL.expectedAttributeValueChangeEvents = 1;
        partitionMembershipCL.expectedLinkAddEvents = 1;
        partitionMembershipCL.expectedLinkRemoveEvents = 1;

        packageCL.expectedElementCreateEvents = 1;
        packageCL.expectedElementDeleteEvents = 1;
        packageCL.expectedAttributeValueChangeEvents = 1;
        packageCL.expectedLinkAddEvents = 1;
        packageCL.expectedLinkRemoveEvents = 1;

        elementAndLinkChangePCL.expectedElementCreateEvents = 1;
        elementAndLinkChangePCL.expectedElementDeleteEvents = 1;
        elementAndLinkChangePCL.expectedAttributeValueChangeEvents = 1;
        elementAndLinkChangePCL.expectedLinkAddEvents = 1;
        elementAndLinkChangePCL.expectedLinkRemoveEvents = 1;

        elementAndLinkChangeCL.expectedElementCreateEvents = 1;
        elementAndLinkChangeCL.expectedElementDeleteEvents = 1;
        elementAndLinkChangeCL.expectedAttributeValueChangeEvents = 1;
        elementAndLinkChangeCL.expectedLinkAddEvents = 1;
        elementAndLinkChangeCL.expectedLinkRemoveEvents = 1;

        // Create of MOF class to be deleted
        MofClass classTmp = null;
        classTmp = (MofClass) mofModelPackage.getMofClass( ).refCreateInstance( );
        classTmp.setName( "ClassTmp" );
        classTmp.setContainer( mofPackage );
        classTmp.refDelete( );
        // Check if expected events have been received
        checkReceivedEvents( );
        // --- END SECTION

        deregisterListener( partitionMembershipCL );
        deregisterListener( packageCL );
        deregisterListener( elementAndLinkChangePCL );
        deregisterListener( elementAndLinkChangeCL );
    }

    /**
     * ChangeListener
     */
    protected class AttachingChangeListener implements ChangeListener {

        public void notify( ChangeEvent event ) {

            // Do something with the second connection. This results in the second connection being attached.
            ModelPackage mofModelPackage = (ModelPackage) getSecondMOINConnection( ).getPackage( TestMetaModels.MOIN_MOF_CN, TestMetaModels.MOIN_MOF_TPE_MODEL );
        }
    }


    /**
     * Listener
     */
    protected class DeregisterListener implements ChangeListener, PreChangeListener, CommitListener, PreCommitListener {

        public void prepare( ChangeEvent event ) {

            // The de-registration caused a "ConcurrentModificationException"
            getMOINConnection( ).getSession( ).getEventRegistry( ).deregister( this );
        }

        public void notify( ChangeEvent chain ) {

            // The de-registration caused a "ConcurrentModificationException"
            getMOINConnection( ).getSession( ).getEventRegistry( ).deregister( this );
        }

        public void prepareCommit( EventChain chain ) {

            // The de-registration caused a "ConcurrentModificationException"
            getMOINConnection( ).getSession( ).getEventRegistry( ).deregister( this );
        }

        public void notifyCommit( EventChain chain ) {

            // The de-registration caused a "ConcurrentModificationException"
            getMOINConnection( ).getSession( ).getEventRegistry( ).deregister( this );
        }
    }

    @Test
    public void testDeregisterInListener( ) {

        // Tests if the current connection is properly re-attached to the current thread after an event handler has run.
        Connection conn1 = getMOINConnection( );

        // PreChangeListener
        PreChangeListener preChangeListener = new DeregisterListener( );
        PreChangeListener preChangeListener2 = new DeregisterListener( );

        conn1.getEventRegistry( ).registerPreChangeListener( preChangeListener, new EventTypeFilter( ChangeEvent.class ) );
        conn1.getEventRegistry( ).registerPreChangeListener( preChangeListener2, new EventTypeFilter( ChangeEvent.class ) );

        // ChangeListener
        ChangeListener changeListener = new DeregisterListener( );
        ChangeListener changeListener2 = new DeregisterListener( );

        conn1.getEventRegistry( ).registerListener( changeListener, new EventTypeFilter( ChangeEvent.class ) );
        conn1.getEventRegistry( ).registerListener( changeListener2, new EventTypeFilter( ChangeEvent.class ) );

        // CommitListener
        CommitListener listener = new DeregisterListener( );
        CommitListener listener2 = new DeregisterListener( );

        conn1.getEventRegistry( ).registerCommitListener( listener, new EventTypeFilter( ChangeEvent.class ) );
        conn1.getEventRegistry( ).registerCommitListener( listener2, new EventTypeFilter( ChangeEvent.class ) );

        // PreCommitListener
        PreCommitListener preListener = new DeregisterListener( );
        PreCommitListener preListener2 = new DeregisterListener( );

        conn1.getEventRegistry( ).registerPreCommitListener( preListener, new EventTypeFilter( ChangeEvent.class ) );
        conn1.getEventRegistry( ).registerPreCommitListener( preListener2, new EventTypeFilter( ChangeEvent.class ) );

        ModelPackage mofModelPackage1 = (ModelPackage) conn1.getPackage( TestMetaModels.MOIN_MOF_CN, TestMetaModels.MOIN_MOF_TPE_MODEL );
        MofPackage mofPackage = (MofPackage) mofModelPackage1.getMofPackage( ).refCreateInstance( );
        mofPackage.setName( "Test" );
    }

    /**
     * Listener
     */
    protected class MutatingListener implements CommitListener {

        MofPackage pck;

        public MutatingListener( MofPackage pck ) {

            this.pck = pck;
        }

        public void notifyCommit( EventChain chain ) {

            if ( "Test".equals( pck.getName( ) ) ) {
                pck.setName( "OtherName" );
            } else {
                assertNotNull( chain );
                assertTrue( chain.getEvents( ).size( ) > 0 );
            }
        }
    }

    @Test
    public void testEmptyEventChainsInMutatingPostCommitListeners( ) {

        // Tests if the current connection is properly re-attached to the current thread after an event handler has run.
        Connection conn1 = getMOINConnection( );
        ModelPackage mofModelPackage1 = (ModelPackage) conn1.getPackage( TestMetaModels.MOIN_MOF_CN, TestMetaModels.MOIN_MOF_TPE_MODEL );
        MofPackage mofPackage = (MofPackage) mofModelPackage1.getMofPackage( ).refCreateInstance( );

        CommitListener listener = new MutatingListener( mofPackage );
        CommitListener listener2 = new MutatingListener( mofPackage );

        conn1.getEventRegistry( ).registerCommitListener( listener, new EventTypeFilter( ChangeEvent.class ) );
        conn1.getEventRegistry( ).registerCommitListener( listener2, new EventTypeFilter( ChangeEvent.class ) );

        mofPackage.setName( "Test" );

        conn1.getEventRegistry( ).deregister( listener );
        conn1.getEventRegistry( ).deregister( listener2 );
    }

    @Test
    public void testSameInstanceForListeners( ) {

        Connection conn1 = getMOINConnection( );
        ModelPackage mofModelPackage1 = (ModelPackage) conn1.getPackage( TestMetaModels.MOIN_MOF_CN, TestMetaModels.MOIN_MOF_TPE_MODEL );
        MofPackage mofPackage = (MofPackage) mofModelPackage1.getMofPackage( ).refCreateInstance( );

        TestCombinedListener combinedListener = new TestCombinedListener( );

        EventFilter eventFilter = new EventTypeFilter( ChangeEvent.class );
        conn1.getEventRegistry( ).registerPreCommitListener( combinedListener, eventFilter );
        conn1.getEventRegistry( ).registerCommitListener( combinedListener, eventFilter );
        conn1.getEventRegistry( ).registerUpdateListener( combinedListener, eventFilter );
        combinedListener.expectedAttributeValueChangeEvents = 3;

        mofPackage.setName( "Test" );

        combinedListener.checkAllEventsReceived( );
        assertEqualsAndContinue( "prepareCommit number of calls", 1, combinedListener.prepareCommitCalls );
        assertEqualsAndContinue( "notifyCommit number of calls", 1, combinedListener.notifyCommitCalls );
        assertEqualsAndContinue( "notifyUpdate number of calls", 1, combinedListener.notifyUpdateCalls );

        conn1.getEventRegistry( ).deregister( combinedListener );
        mofPackage.refDelete( );
    }
}