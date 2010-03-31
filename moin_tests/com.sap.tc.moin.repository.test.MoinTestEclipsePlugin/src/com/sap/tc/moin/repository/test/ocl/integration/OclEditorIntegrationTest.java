package com.sap.tc.moin.repository.test.ocl.integration;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.model.AggregationKindEnum;
import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.EvaluationKindEnum;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.ModelPackage;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.Tag;
import com.sap.tc.moin.repository.mmi.model.VisibilityKindEnum;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import org.junit.Test;
import org.omg.ocl.OclPackage;
import org.omg.ocl.attaching.OclConstraint;
import org.omg.ocl.expressions.OclExpression;
import org.omg.ocl.expressions.StringLiteralExp;

import com.sap.tc.moin.friends.factory.UtilitiesFactory;
import com.sap.tc.moin.ocl.utils.impl.OclSerializer;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.ProcessReport;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.ocl.notification.DeferredConstraintViolationStatus;
import com.sap.tc.moin.repository.ocl.notification.DeferredConstraintViolationStatusItem;
import com.sap.tc.moin.repository.ocl.registry.OclRegistrationCategory;
import com.sap.tc.moin.repository.test.ocl.base.BaseOclIntegrationTest;
import com.sap.tc.moin.test.fw.TestMetaModels;

public class OclEditorIntegrationTest extends BaseOclIntegrationTest {

    @Test
    public void createModelPartitionAndParse( ) throws Exception {

        Connection conn = this.createConnection( );
        CoreConnection coreConn = getTestHelper( ).getCoreConnection( conn );

        ModelPartition testPartition = conn.getOrCreateTransientPartition( "TestOclEditorIntegration" );
        try {

            ModelPackage mp = (ModelPackage) conn.getPackage( TestMetaModels.MOIN_MOF_CN, "Model" );

            MofClass car = (MofClass) mp.getMofClass( ).refCreateInstance( );
            car.setName( "Car" );
            car.setAnnotation( "Test class" );
            car.setRoot( true );
            car.setLeaf( true );
            car.setAbstract( false );
            car.setVisibility( VisibilityKindEnum.PUBLIC_VIS );
            car.setSingleton( false );
            testPartition.assignElement( car );

            MofClass wheel = (MofClass) mp.getMofClass( ).refCreateInstance( );
            wheel.setName( "Wheel" );
            wheel.setAnnotation( "Test class" );
            wheel.setRoot( true );
            wheel.setLeaf( true );
            wheel.setAbstract( false );
            wheel.setVisibility( VisibilityKindEnum.PUBLIC_VIS );
            wheel.setSingleton( false );
            testPartition.assignElement( wheel );

            Association assoc = (Association) mp.getAssociation( ).refCreateInstance( );
            assoc.setName( "WheelsOfCar" );
            assoc.setAnnotation( "Test Association" );
            assoc.setRoot( true );
            assoc.setLeaf( true );
            assoc.setAbstract( false );
            assoc.setVisibility( VisibilityKindEnum.PUBLIC_VIS );
            assoc.setDerived( false );

            testPartition.assignElement( assoc );

            AssociationEnd end0 = (AssociationEnd) mp.getAssociationEnd( ).refCreateInstance( );
            end0.setName( "wheels" );
            end0.setAnnotation( "Test AssociationEnd" );
            end0.setNavigable( true );
            end0.setAggregation( AggregationKindEnum.NONE );
            end0.setMultiplicity( coreConn.getCoreJmiHelper( ).createMultiplicityType( coreConn, 0, 4, false, false ) );
            end0.setChangeable( true );
            end0.setType( wheel );

            AssociationEnd end1 = (AssociationEnd) mp.getAssociationEnd( ).refCreateInstance( );
            end1.setName( "car" );
            end1.setAnnotation( "Test AssociationEnd" );
            end1.setNavigable( true );
            end1.setAggregation( AggregationKindEnum.NONE );
            end1.setMultiplicity( coreConn.getCoreJmiHelper( ).createMultiplicityType( coreConn, 0, 1, false, false ) );
            end1.setChangeable( true );
            end1.setType( car );

            assoc.getContents( ).add( end0 );
            assoc.getContents( ).add( end1 );

            OclPackage op = (OclPackage) conn.getPackage( TestMetaModels.MOIN_MOF_CN, "OCL" );
            OclConstraint oc = (OclConstraint) op.getAttaching( ).getOclConstraint( ).refCreateInstance( Arrays.asList( "TestConstraint", "Test", "context Car inv: self.wheels->size() = 4", "OCL", EvaluationKindEnum.DEFERRED ) );

            testPartition.assignElement( oc );
            oc.getConstrainedElements( ).add( car );

            Set<ModelPartition> partitions = new HashSet<ModelPartition>( );
            partitions.add( testPartition );
            UtilitiesFactory.getConnectionUtil( ).getOclActivator( conn ).parseOclConstraintsInPartitions( partitions );

            OclSerializer ser = OclSerializer.getInstance( getTestHelper( ).getCoreConnection( conn ) );
            String result = ser.serialize( (OclExpression) getTestHelper( ).getCorePartitionable( oc.getOclExpression( ) ), new RefPackage[0] );
            verify( result.equals( "self.wheels->size().equalsStdLib(4)" ), "Wrong Expression returned" );

            oc.setExpression( "context Car inv: self.wheels->size() = 23" );

            UtilitiesFactory.getConnectionUtil( ).getOclActivator( conn ).parseOclConstraintsInPartitions( partitions );
            result = ser.serialize( (OclExpression) getTestHelper( ).getCorePartitionable( oc.getOclExpression( ) ), new RefPackage[0] );
            verify( result.equals( "self.wheels->size().equalsStdLib(23)" ), "Wrong Expression returned" );

            oc.getConstrainedElements( ).clear( );
            oc.getConstrainedElements( ).add( wheel );
            oc.setExpression( "context Wheel inv: self.car->size() = 1" );

            UtilitiesFactory.getConnectionUtil( ).getOclActivator( conn ).parseOclConstraintsInPartitions( partitions );
            result = ser.serialize( (OclExpression) getTestHelper( ).getCorePartitionable( oc.getOclExpression( ) ), new RefPackage[0] );
            verify( result.equals( "self.car->size().equalsStdLib(1)" ), "Wrong Expression returned" );

            // constraint checks
            Set<PRI> pris = new HashSet<PRI>( );
            pris.add( testPartition.getPri( ) );

            oc.setExpression( "context Wheel inv: self.cahr->size() = 1" );
            Map<ProcessReport, MRI> reports = UtilitiesFactory.getConnectionUtil( ).getOclActivator( conn ).parseOclConstraintsInPartitions( partitions );

            OclConstraint ocUnparsed = (OclConstraint) op.getAttaching( ).getOclConstraint( ).refCreateInstance( Arrays.asList( "TestConstraintUnparsed", "Test", "context Car inv: self.wheels->size() = 4", "OCL", EvaluationKindEnum.DEFERRED ) );
            ocUnparsed.getConstrainedElements( ).add( car );
            testPartition.assignElement( ocUnparsed );

            DeferredConstraintViolationStatus status = conn.getOclRegistryService( ).getMofConstraintRegistry( ).analyzeMetamodelPartitions( pris, OclRegistrationCategory.immediate, OclRegistrationCategory.deferred );
            for ( DeferredConstraintViolationStatusItem item : status.getAll( ) ) {
                String message = "MOIN/MOF Constraint violated: " + item.getConstraintViolationMessage( ) + "->";
                MRI mri = item.getOffendingMRI( );
                RefBaseObject o = conn.getElement( mri );
                if ( o instanceof ModelElement ) {
                    message += ( (ModelElement) o ).getQualifiedName( );
                } else {
                    message += o.refMofId( );
                }
                System.err.println( message );
            }

            verify( !reports.isEmpty( ), "Expected Parsing error report not found" );

            Map<ProcessReport, MRI> reportMap = UtilitiesFactory.getConnectionUtil( ).getOclActivator( conn ).parseOclConstraintsInPartitions( partitions );
            verify( !reportMap.isEmpty( ), "Expected Parsing error report not found" );
            MRI errorMri = reportMap.values( ).iterator( ).next( );
            verify( errorMri.equals( ( (Partitionable) oc ).get___Mri( ) ), "MRI is not correct" );

        } finally {
            if ( testPartition != null ) {
                testPartition.deleteElements( );
            }
        }

    }

    @Test
    public void checkViolationMessageParsing( ) throws Exception {

        Connection conn = this.createConnection( );
        CoreConnection coreConn = getTestHelper( ).getCoreConnection( conn );

        ModelPartition testPartition = conn.getOrCreateTransientPartition( "TestOclEditorIntegration" );
        try {

            ModelPackage mp = (ModelPackage) conn.getPackage( TestMetaModels.MOIN_MOF_CN, "Model" );

            MofClass car = (MofClass) mp.getMofClass( ).refCreateInstance( );
            car.setName( "Car" );
            car.setAnnotation( "Test class" );
            car.setRoot( true );
            car.setLeaf( true );
            car.setAbstract( false );
            car.setVisibility( VisibilityKindEnum.PUBLIC_VIS );
            car.setSingleton( false );
            testPartition.assignElement( car );

            MofClass wheel = (MofClass) mp.getMofClass( ).refCreateInstance( );
            wheel.setName( "Wheel" );
            wheel.setAnnotation( "Test class" );
            wheel.setRoot( true );
            wheel.setLeaf( true );
            wheel.setAbstract( false );
            wheel.setVisibility( VisibilityKindEnum.PUBLIC_VIS );
            wheel.setSingleton( false );
            testPartition.assignElement( wheel );

            Association assoc = (Association) mp.getAssociation( ).refCreateInstance( );
            assoc.setName( "WheelsOfCar" );
            assoc.setAnnotation( "Test Association" );
            assoc.setRoot( true );
            assoc.setLeaf( true );
            assoc.setAbstract( false );
            assoc.setVisibility( VisibilityKindEnum.PUBLIC_VIS );
            assoc.setDerived( false );
            testPartition.assignElement( assoc );

            AssociationEnd end0 = (AssociationEnd) mp.getAssociationEnd( ).refCreateInstance( );
            end0.setName( "wheels" );
            end0.setAnnotation( "Test AssociationEnd" );
            end0.setNavigable( true );
            end0.setAggregation( AggregationKindEnum.NONE );
            end0.setMultiplicity( coreConn.getCoreJmiHelper( ).createMultiplicityType( coreConn, 0, 4, false, false ) );
            end0.setChangeable( true );
            end0.setType( wheel );

            AssociationEnd end1 = (AssociationEnd) mp.getAssociationEnd( ).refCreateInstance( );
            end1.setName( "car" );
            end1.setAnnotation( "Test AssociationEnd" );
            end1.setNavigable( true );
            end1.setAggregation( AggregationKindEnum.NONE );
            end1.setMultiplicity( coreConn.getCoreJmiHelper( ).createMultiplicityType( coreConn, 0, 1, false, false ) );
            end1.setChangeable( true );
            end1.setType( car );

            assoc.getContents( ).add( end0 );
            assoc.getContents( ).add( end1 );

            OclPackage op = (OclPackage) conn.getPackage( TestMetaModels.MOIN_MOF_CN, "OCL" );
            OclConstraint oc = (OclConstraint) op.getAttaching( ).getOclConstraint( ).refCreateInstance( Arrays.asList( "TestConstraint", "Test", "context Car inv: self.wheels->size() = 4", "OCL", EvaluationKindEnum.DEFERRED ) );

            Tag expressionTag = (Tag) mp.getTag( ).refCreateInstance( );
            expressionTag.setName( "TestTag" );
            expressionTag.setAnnotation( "" );
            expressionTag.setTagId( "sap2mof.violationMessageExpression" );
            expressionTag.getValues( ).add( "'This is just a test'" );
            expressionTag.getElements( ).add( oc );

            testPartition.assignElement( oc );
            oc.getConstrainedElements( ).add( car );

            Set<ModelPartition> partitions = new HashSet<ModelPartition>( );
            partitions.add( testPartition );
            UtilitiesFactory.getConnectionUtil( ).getOclActivator( conn ).parseOclConstraintsInPartitions( partitions );
            List<OclExpression> expressions = oc.getViolationMessageExpression( );
            verify( !expressions.isEmpty( ), "ViolationExpression not parsed" );
            verify( expressions.get( 0 ) instanceof StringLiteralExp, "Expression is not a String Literal" );

        } finally {
            if ( testPartition != null ) {
                testPartition.deleteElements( );
            }
        }

    }
}
