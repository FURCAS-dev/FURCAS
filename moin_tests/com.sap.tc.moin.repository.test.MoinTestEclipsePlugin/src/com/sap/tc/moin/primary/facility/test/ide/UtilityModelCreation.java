/*
 * Created on 01.03.2005
 */
package com.sap.tc.moin.primary.facility.test.ide;

import java.util.ArrayList;
import java.util.Collection;
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
import com.sap.tc.moin.repository.mmi.model.GeneralizableElement;
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
import com.sap.tc.moin.repository.mmi.model.VisibilityKindEnum;
import com.sap.tc.moin.repository.mmi.primitivetypes.PrimitiveTypesPackage;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.serviceinteractions.EndPointReference;
import com.sap.serviceinteractions.Message;
import com.sap.serviceinteractions.MessageTriggersReply;
import com.sap.serviceinteractions.ServiceInteractionsPackage;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.spi.core.Wrapper;
import com.sap.tc.moin.test.fw.TestMetaModels;

/**
 * @author d044711, d021091
 */

public class UtilityModelCreation {

    /**
     * Create model of meta-model MOF and assign it to the given partition. The
     * caller is responsible for saving the partition.
     */
    public static List<MRI> fillPartitionWithMofModel( Connection connection, ModelPartition mmPartition ) throws Exception {

        ModelPackage modelPkg = (ModelPackage) connection.getPackage( null, "Model" );

        MofPackage p1 = (MofPackage) modelPkg.getMofPackage( ).refCreateInstance( );
        p1.setName( "p1" );
        setDefaultAttributes( p1 );

        MofClass c1 = (MofClass) modelPkg.getMofClass( ).refCreateInstance( );
        c1.setName( "c1" );
        setDefaultAttributes( c1 );

        p1.getContents( ).add( c1 );

//        for ( Partitionable p : connection.getNullPartition( ).getElements( ) ) {
//            p.assign___Partition( mmPartition );
//        }

        List<RefObject> modelElements = new ArrayList<RefObject>( );

        modelElements.add( p1 );
        modelElements.add( c1 );

        List<MRI> mris = new ArrayList<MRI>( modelElements.size( ) );
        for ( RefObject refObject : modelElements ) {
            mmPartition.assignElement( refObject );
            mris.add( ( (Partitionable) refObject ).get___Mri( ) );
        }

        return mris;
    }

    private static void setDefaultAttributes( GeneralizableElement element ) {

        // These attributes are required to avoid underflow constraint check errors in mof editor
        element.setAnnotation( "" );
        element.setVisibility( VisibilityKindEnum.PUBLIC_VIS );
    }

    public static void changePartitionWithMofModel( Connection connection, ModelPartition mmPartition ) throws Exception {

        ModelPackage modelPkg = (ModelPackage) connection.getPackage( null, "Model" );

        MofPackage p1 = (MofPackage) modelPkg.getMofPackage( ).refCreateInstanceInPartition( mmPartition );
        p1.setName( "p2" );
    }

    // hot_todo: MM of Christian is no longer valid, there seems to be a violation of an OCL constraint, because DcBuild throws exception:
//    [MOINGenerateMM] java.lang.IllegalArgumentException: underlyingObject must not be null
//    [MOINGenerateMM]    at com.sap.tc.moin.ocl.evaluator.stdlib.impl.OclFactoryImpl.create(OclFactoryImpl.java:46)
//    [MOINGenerateMM]    at com.sap.tc.moin.repository.core.ocl.service.impl.OclMofConstraintRegistryImpl.analyzeMetamodelPartitions(OclMofConstraintRegistryImpl.java:336)
//    [MOINGenerateMM]    at com.sap.tc.moin.repository.core.OclMofConstraintRegistryWrapper.analyzeMetamodelPartitions(OclMofConstraintRegistryWrapper.java:48)
//    [MOINGenerateMM]    at com.sap.tc.moin.repository.jmigenerator.controller.MetaModelOclConstraintCheckerImpl.doCheck(MetaModelOclConstraintCheckerImpl.java:55)
//    [MOINGenerateMM]    at com.sap.tc.moin.repository.jmigenerator.controller.CompositeMetaModelChecker.doCheck(CompositeMetaModelChecker.java:22)
//    [MOINGenerateMM]    at com.sap.tc.moin.repository.jmigenerator.controller.MoinMMGeneration.execute(MoinMMGeneration.java:146)
//    [MOINGenerateMM]    at com.sap.tc.moin.repository.jmigenerator.controller.MoinMMGeneration.execute(MoinMMGeneration.java:119)
//    [MOINGenerateMM]    at com.sap.tc.moin.ant.task.MoinMMGenerationTask.executeSafe(MoinMMGenerationTask.java:33)
//    [MOINGenerateMM]    at com.sap.tc.moin.ant.task.MoinAntTask.execute(MoinAntTask.java:151)
//    ...
    public static List<MRI> fillPartitionWithMofModel_noLongerValid( Connection connection, ModelPartition mmPartition ) throws Exception {

        CoreConnection coreConnection = connection instanceof Wrapper ? ( (Wrapper<CoreConnection>) connection ).unwrap( ) : (CoreConnection) connection;
        ModelPackage mofModelPackage = (ModelPackage) connection.getPackage( TestMetaModels.MOIN_MOF_CN, TestMetaModels.MOIN_MOF_TPE_MODEL );

        HashMap<String, PrimitiveType> mofPrimitives = new HashMap<String, PrimitiveType>( 6 );
        PrimitiveTypesPackage ptp = (PrimitiveTypesPackage) connection.getPackage( TestMetaModels.MOIN_MOF_CN, TestMetaModels.MOIN_MOF_TPE_PT );
        List<ModelElement> prims = ptp.refMetaObject( ).getContents( );
        for ( Iterator<ModelElement> i = prims.iterator( ); i.hasNext( ); ) {
            ModelElement me = i.next( );
            if ( me instanceof PrimitiveType ) {
                PrimitiveType pt = (PrimitiveType) me;
                mofPrimitives.put( pt.getName( ), pt );
            }
        }

        // Elements in the test MOF Model
        MofPackage mofPackage = null;
        MofPackage mofPackageB = null;
        Import packageImport = null;
        MofClass classA = null;
        MofClass classB = null;
        MofClass classC = null;
        MofClass classD = null;
        Constant constA = null;
        com.sap.tc.moin.repository.mmi.model.Operation operA = null;
        com.sap.tc.moin.repository.mmi.model.Parameter param0 = null;
        com.sap.tc.moin.repository.mmi.model.Parameter param1 = null;
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
        fieldF.setType( mofPrimitives.get( "Integer" ) );
        fieldF.setContainer( structE );
        fieldG = (StructureField) mofModelPackage.getStructureField( ).refCreateInstance( );
        fieldG.setName( "FieldG" );
        fieldG.setType( mofPrimitives.get( "String" ) );
        fieldG.setContainer( structE );

        // Create Attribute attrA in class ClassA of type ClassB
        // ClassA.attrA:ClassB
        attrA = (Attribute) mofModelPackage.getAttribute( ).refCreateInstance( );
        attrA.setName( "attrA" );
        attrA.setType( classB );
        attrA.setDerived( true );
        attrA.setContainer( classA );
        attrA.setMultiplicity( coreConnection.getCoreJmiHelper( ).createMultiplicityType( coreConnection, 1, 1, false, false ) );
        attrA.setChangeable( true );

        // Create Attribute attrB in class ClassA of type ClassB
        // ClassA.attrB:PrimitiveC
        attrB = (Attribute) mofModelPackage.getAttribute( ).refCreateInstance( );
        attrB.setName( "attrB" );
        attrB.setType( primitiveC );
        attrB.setScope( ScopeKindEnum.CLASSIFIER_LEVEL );
        attrB.setContainer( classA );
        attrB.setMultiplicity( coreConnection.getCoreJmiHelper( ).createMultiplicityType( coreConnection, 1, 1, false, false ) );
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
        param1.setMultiplicity( coreConnection.getCoreJmiHelper( ).createMultiplicityType( coreConnection, 1, -1, true, false ) );

        // create asociation including ends
        assocAB = (Association) mofModelPackage.getAssociation( ).refCreateInstance( );
        assocAB.setName( "AssocAB" );
        assocAB.setContainer( mofPackage );

        aEndA = (AssociationEnd) mofModelPackage.getAssociationEnd( ).refCreateInstance( );
        aEndA.setName( "theA" );
        aEndA.setType( classA );
        aEndA.setAggregation( AggregationKindEnum.COMPOSITE );
        aEndA.setMultiplicity( coreConnection.getCoreJmiHelper( ).createMultiplicityType( coreConnection, 0, 1, false, true ) );
        aEndA.setContainer( assocAB );
        aEndA.setChangeable( true );

        aEndB = (AssociationEnd) mofModelPackage.getAssociationEnd( ).refCreateInstance( );
        aEndB.setName( "theB" );
        aEndB.setType( classB );
        aEndB.setAggregation( AggregationKindEnum.NONE );
        aEndB.setMultiplicity( coreConnection.getCoreJmiHelper( ).createMultiplicityType( coreConnection, 0, -1, false, true ) );
        aEndB.setContainer( assocAB );
        aEndB.setChangeable( true );
        aEndB.setNavigable( true );

        // create reference
        refAB = (Reference) mofModelPackage.getReference( ).refCreateInstance( );
        refAB.setReferencedEnd( aEndB );
        refAB.setName( aEndB.getName( ) );
        refAB.setType( aEndB.getType( ) );
        refAB.setMultiplicity( aEndB.getMultiplicity( ) );
        refAB.setContainer( aEndA.getType( ) );
        refAB.setChangeable( true );

        List<RefObject> modelElements = new ArrayList<RefObject>( );

        modelElements.add( mofPackage );
        modelElements.add( mofPackageB );
        modelElements.add( packageImport );
        modelElements.add( classA );
        modelElements.add( classB );
        modelElements.add( classC );
        modelElements.add( classD );
        modelElements.add( constA );
        modelElements.add( operA );
        modelElements.add( param0 );
        modelElements.add( param1 );
        modelElements.add( primitiveC );
        modelElements.add( enumD );
        modelElements.add( structE );
        modelElements.add( fieldF );
        modelElements.add( fieldG );
        modelElements.add( attrA );
        modelElements.add( attrB );
        modelElements.add( assocAB );
        modelElements.add( aEndA );
        modelElements.add( aEndB );
        modelElements.add( refAB );

        List<MRI> mris = new ArrayList<MRI>( modelElements.size( ) );
        for ( RefObject refObject : modelElements ) {
            mmPartition.assignElement( refObject );
            mris.add( ( (Partitionable) refObject ).get___Mri( ) );
        }

        return mris;

    }

    /**
     * Creates a model of meta-model ServiceInteractions and assigns it to the
     * given partition. The caller is responsible for saving the partition.
     */
    public static List<MRI> fillPartitionWithServiceInteractionsModelElements( ServiceInteractionsPackage serviceInteractionsPackageExtend, ModelPartition partition ) {

        // Create model elements for ServiceInteractions MetaModel:

        // - create multiple messages
        Message message1 = (Message) serviceInteractionsPackageExtend.getMessage( ).refCreateInstance( );
        Message message2 = (Message) serviceInteractionsPackageExtend.getMessage( ).refCreateInstance( );
        Message message3 = (Message) serviceInteractionsPackageExtend.getMessage( ).refCreateInstance( );
        Message message4 = (Message) serviceInteractionsPackageExtend.getMessage( ).refCreateInstance( );

        // - create associations
        MessageTriggersReply messageTriggersReply = serviceInteractionsPackageExtend.getMessageTriggersReply( );
        Collection<Message> messageTriggers = messageTriggersReply.getTriggers( message1 );
        // - add triggers for message1
        messageTriggers.add( message2 );
        messageTriggers.add( message3 );
        messageTriggers.add( message4 );
        // - create multiple endpointreferences
        EndPointReference epr1 = (EndPointReference) serviceInteractionsPackageExtend.getEndPointReference( ).refCreateInstance( );
        EndPointReference epr2 = (EndPointReference) serviceInteractionsPackageExtend.getEndPointReference( ).refCreateInstance( );
        EndPointReference epr3 = (EndPointReference) serviceInteractionsPackageExtend.getEndPointReference( ).refCreateInstance( );
        // - add endpointreferences for message1
        Collection<EndPointReference> messageSendReplies = message1.getSendRepliesTo( );
        messageSendReplies.add( epr1 );
        messageSendReplies.add( epr2 );
        messageSendReplies.add( epr3 );

        // Assign the created model elements to the given partition
        partition.assignElement( message1 );
        partition.assignElement( message2 );
        partition.assignElement( message3 );
        partition.assignElement( message4 );
        partition.assignElement( epr1 );
        partition.assignElement( epr2 );
        partition.assignElement( epr3 );

        // Determine and return the MRIs of the created model elements:
        List<MRI> createdElementMris = new ArrayList<MRI>( );

        createdElementMris.add( message1.get___Mri( ) );
        createdElementMris.add( message2.get___Mri( ) );
        createdElementMris.add( message3.get___Mri( ) );
        createdElementMris.add( message4.get___Mri( ) );

        createdElementMris.add( epr1.get___Mri( ) );
        createdElementMris.add( epr2.get___Mri( ) );
        createdElementMris.add( epr3.get___Mri( ) );

        return createdElementMris;
    }

    /**
     * Creates a model of meta-model ServiceInteractions and assigns it to the
     * given partitions. The created model elements are filled into 2 partitions
     * the way that they include references between those partitions. The caller
     * is responsible for saving the partition.
     */
    public static void fillPartitionsWithServiceInteractionsModelElements( ServiceInteractionsPackage serviceInteractionsPackageExtend, ModelPartition partition_1, ModelPartition partition_2, List<MRI> partitionMris_1, List<MRI> partitionMris_2 ) {

        // Create model elements for ServiceInteractions MetaModel:

        // - create multiple messages
        Message message1 = (Message) serviceInteractionsPackageExtend.getMessage( ).refCreateInstance( );
        Message message2 = (Message) serviceInteractionsPackageExtend.getMessage( ).refCreateInstance( );
        Message message3 = (Message) serviceInteractionsPackageExtend.getMessage( ).refCreateInstance( );
        Message message4 = (Message) serviceInteractionsPackageExtend.getMessage( ).refCreateInstance( );

        // - create associations
        MessageTriggersReply messageTriggersReply = serviceInteractionsPackageExtend.getMessageTriggersReply( );
        Collection<Message> messageTriggers = messageTriggersReply.getTriggers( message1 );
        // - add triggers for message1
        messageTriggers.add( message2 );
        messageTriggers.add( message3 );
        messageTriggers.add( message4 );
        // - create multiple endpointreferences
        EndPointReference epr1 = (EndPointReference) serviceInteractionsPackageExtend.getEndPointReference( ).refCreateInstance( );
        EndPointReference epr2 = (EndPointReference) serviceInteractionsPackageExtend.getEndPointReference( ).refCreateInstance( );
        EndPointReference epr3 = (EndPointReference) serviceInteractionsPackageExtend.getEndPointReference( ).refCreateInstance( );
        // - add endpointreferences for message1
        Collection<EndPointReference> messageSendReplies = message1.getSendRepliesTo( );
        messageSendReplies.add( epr1 );
        messageSendReplies.add( epr2 );
        messageSendReplies.add( epr3 );

        // Assign the created model elements to the given partitions, so that there is a reference from partition_1 to
        // partition_2:

        partition_1.assignElement( message1 );
        partition_1.assignElement( message2 );

        partition_2.assignElement( message3 );
        partition_2.assignElement( message4 );

        partition_1.assignElement( epr1 );

        partition_2.assignElement( epr2 );
        partition_2.assignElement( epr3 );

        // Determine and return the MRIs of the created model elements:

        partitionMris_1.clear( );
        partitionMris_2.clear( );

        partitionMris_1.add( ( (Partitionable) message1 ).get___Mri( ) );
        partitionMris_1.add( ( (Partitionable) message2 ).get___Mri( ) );

        partitionMris_2.add( ( (Partitionable) message3 ).get___Mri( ) );
        partitionMris_2.add( ( (Partitionable) message4 ).get___Mri( ) );

        partitionMris_1.add( ( (Partitionable) epr1 ).get___Mri( ) );

        partitionMris_2.add( ( (Partitionable) epr2 ).get___Mri( ) );
        partitionMris_2.add( ( (Partitionable) epr3 ).get___Mri( ) );

    }

}
