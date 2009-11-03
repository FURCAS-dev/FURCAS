package com.sap.tc.moin.repository.test.metamodelchecker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.ModelPackage;
import com.sap.tc.moin.repository.mmi.model.MultiplicityType;

import com.sap.tc.moin.MoinPackage;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.NameViolation;
import com.sap.tc.moin.repository.consistency.ConsistencyViolation;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.jmigenerator.controller.DefaultMetaModelChecker;
import com.sap.tc.moin.repository.jmigenerator.controller.DoNothingLogCallback;
import com.sap.tc.moin.repository.jmigenerator.controller.DoNothingTimerCallback;
import com.sap.tc.moin.repository.ocl.notification.DeferredConstraintViolationStatusItem;
import com.sap.tc.moin.repository.test.core.CoreMoinTest;

/**
 * Test the MOIN default metamodel checker
 */

@SuppressWarnings( "nls" )
public class TestDefaultMetamodelChecker extends CoreMoinTest {

    ModelPackage modelPackage = null;

    Checker checker = null;

    MultiplicityType multiplicity1To1 = null;

    @Override
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );
        MoinPackage moinPackage = (MoinPackage) getMOINConnection( ).getPackage( null, new String[] { "MOIN" } );
        modelPackage = moinPackage.getModel( );
        checker = new Checker( );
        CoreConnection conn = getTestHelper( ).getCoreConnection( getMOINConnection( ) );
        multiplicity1To1 = conn.getCoreJmiHelper( ).createMultiplicityType( conn, 1, 1, false, false );
    }

    @Override
    public void afterTestMethod( ) throws Exception {

        super.afterTestMethod( );
        modelPackage = null;
        checker = null;
        multiplicity1To1 = null;
    }

    protected class Checker extends DefaultMetaModelChecker {

        private List<DeferredConstraintViolationStatusItem> constraintViolationItems = new ArrayList<DeferredConstraintViolationStatusItem>( );

        private List<ConsistencyViolation> consistencyViolationItems = new ArrayList<ConsistencyViolation>( );

        private List<NameViolation> nameViolationItems = new ArrayList<NameViolation>( );

        private Checker( ) {

            super( new DoNothingTimerCallback( ), new DoNothingLogCallback( ), false );
        }

        public void doCheck( ModelPartition... partitions ) {

            resetViolationItems( );
            super.doCheck( getMOINConnection( ), new HashSet<ModelPartition>( Arrays.<ModelPartition> asList( partitions ) ) );
        }

        private void resetViolationItems( ) {

            constraintViolationItems = new ArrayList<DeferredConstraintViolationStatusItem>( );
            consistencyViolationItems = new ArrayList<ConsistencyViolation>( );
            nameViolationItems = new ArrayList<NameViolation>( );
        }

        protected List<NameViolation> getNameViolationItems( ) {

            return nameViolationItems;
        }

        protected List<DeferredConstraintViolationStatusItem> getConstraintViolationItems( ) {

            return constraintViolationItems;
        }

        protected List<ConsistencyViolation> getConsistencyViolationItems( ) {

            return consistencyViolationItems;
        }

        @Override
        public void handleViolation( Object violationItem, String message ) {

            try {
                super.handleViolation( violationItem, message );
            } catch ( RuntimeException re ) {
                if ( violationItem instanceof DeferredConstraintViolationStatusItem ) {
                    constraintViolationItems.add( (DeferredConstraintViolationStatusItem) violationItem );
                }
                if ( violationItem instanceof ConsistencyViolation ) {
                    consistencyViolationItems.add( (ConsistencyViolation) violationItem );
                }
                if ( violationItem instanceof NameViolation ) {
                    nameViolationItems.add( (NameViolation) violationItem );
                }
            }
        }
    }
}
