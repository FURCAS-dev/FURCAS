package com.sap.tc.moin.repository.test.ocl.ia;

import java.util.HashSet;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import org.junit.Test;

import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.ocl.freestyle.OclExpressionRegistration;
import com.sap.tc.moin.repository.ocl.notification.DeferredConstraintViolationListener;
import com.sap.tc.moin.repository.ocl.notification.DeferredConstraintViolationStatus;
import com.sap.tc.moin.repository.ocl.notification.DeferredConstraintViolationStatusItem;
import com.sap.tc.moin.repository.ocl.registry.OclRegistrationCategory;
import com.sap.tc.moin.repository.ocl.registry.OclRegistrationSeverity;
import com.sap.tc.moin.repository.test.ocl.base.BaseOclTest;
import com.sap.tc.moin.testcases.case023.A23;
import com.sap.tc.moin.testcases.case023.B23;
import com.sap.tc.moin.testcases.case023.C23;
import com.sap.tc.moin.testcases.case023.Case023Package;


public class TestOperationCall extends BaseOclTest {

    @Test
    public void testRecursiveOpCallImpactAnalysis( ) throws Exception {

        Case023Package pkg = this.connection.getPackage( Case023Package.PACKAGE_DESCRIPTOR );
        ModelPartition testPartition = this.connection.getOrCreateTransientPartition( "IAOpCallRecursiveTest" );
        A23 a23 = this.connection.createElementInPartition( A23.class, testPartition );
        B23 b23 = this.connection.createElementInPartition( B23.class, testPartition );
        C23 c23 = this.connection.createElementInPartition( C23.class, testPartition );

        Set<PRI> partitions = new HashSet<PRI>( );
        partitions.add( testPartition.getPri( ) );
        DeferredConstraintViolationListener listener = new DeferredConstraintViolationListener( ) {

            public void notify( DeferredConstraintViolationStatus violationStatus ) {

                for ( DeferredConstraintViolationStatusItem item : violationStatus.getAll( ) ) {
                    System.out.println( item.getConstraintViolationMessage( ) );
                }
            }

        };

        this.connection.getOclRegistryService( ).getMetamodelConstraintRegistry( ).registerPartitionBasedConstraintViolationListener( OclRegistrationCategory.deferred.name( ), listener );
        //this.connection.getOclRegistryService( ).getMetamodelConstraintRegistry( ).registerPartitionBasedConstraintViolationListener( OclRegistrationCategory.immediate.name( ), listener );

        this.connection.getOclRegistryService( ).analyzeModelPartitions( OclRegistrationCategory.deferred.name( ), partitions );
        //this.connection.getOclRegistryService( ).analyzeModelPartitions( OclRegistrationCategory.immediate.name( ), partitions );

    }

    @Test
    public void testJavaOpCallWithCollectionParamters( ) throws Exception {

        Case023Package pkg = this.connection.getPackage( Case023Package.PACKAGE_DESCRIPTOR );
        ModelPartition testPartition = this.connection.getOrCreateTransientPartition( "IAOpCallRecursiveTest" );
        B23 b23 = this.connection.createElementInPartition( B23.class, testPartition );
        A23 a23 = this.connection.createElementInPartition( A23.class, testPartition );

        pkg.getAb( ).add( b23, a23 );

        String expression = "let myA:Set(A23) = self.bToA in " + "let empty:Set(A23) = Set{} in " + "self.collectA(empty,myA)";

        OclExpressionRegistration reg = this.connection.getOclRegistryService( ).getFreestyleRegistry( ).createExpressionRegistration( "TestExpressionOpCollectionParam", expression, OclRegistrationSeverity.Error, new String[] { "Test" }, pkg.getB23( ), new RefPackage[] { pkg } );
        reg.evaluateExpression( b23 );

    }
}
