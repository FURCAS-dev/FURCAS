package com.sap.tc.moin.repository.test.ocl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.junit.Test;

import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.DataArea;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.ocl.OclRegistryService;
import com.sap.tc.moin.repository.ocl.notification.DeferredConstraintViolationStatus;
import com.sap.tc.moin.repository.ocl.notification.DeferredConstraintViolationStatusItem;
import com.sap.tc.moin.repository.spi.core.Wrapper;
import com.sap.tc.moin.test.fw.TestMetaModels;
import com.sap.tc.moin.test.testcase.MoinTestCase;

public class RefVerifyConstraintCompare extends MoinTestCase {

    private Connection connection;

    private static String[] TEST_METAMODELS = { TestMetaModels.TESTCASES };

    @Override
    public void afterTestMethod( ) throws Exception {

        super.afterTestMethod( );
    }

    @Override
    public void beforeTestMethod( ) throws Exception {

        // TODO Auto-generated method stub
        super.beforeTestMethod( );

        getTestHelper( ).setTestConfigurationFile( "nwdiTestConfiguration.properties" );
        super.beforeTestMethod( );

        connection = createConnection( );
        CoreConnection coreConnection = getTestHelper( ).getCoreConnection( connection );
        coreConnection.getOrCreateTransientPartitionNonTransactional( "OclTestTransientPartition" );

    }

    @Test
    public void compareNumViolations( ) throws Exception {

        Collection<DataArea> das = connection.getSession( ).getCompoundClientSpec( ).getCompoundDataArea( ).getDataAreas( );
        Set<PRI> pris = new HashSet<PRI>( );
        for ( DataArea da : das ) {
            CRI cri = connection.getSession( ).getMoin( ).createCri( da.getDescriptor( ).getFacilityId( ), da.getDescriptor( ).getDataAreaName( ), TestMetaModels.TESTCASES_CN );
            pris.addAll( connection.getSession( ).getInnerPartitions( cri ) );
        }

        OclRegistryService srv = connection.getOclRegistryService( );
        ModelPartition part = connection.getPartition( pris.iterator( ).next( ) );
        Collection<Partitionable> elements = part.getElements( );
        // do one check so that mof constraint registry is initialized
        for ( Partitionable element : elements ) {
            if ( element instanceof RefClass ) {
                RefObject ro = ( (RefClass) element ).refMetaObject( );
                ro.refVerifyConstraints( false );
                srv.verifyConstraints( ro );
                break;
            }
        }

        long totalTimeHard = 0;
        long totalTimeOcl = 0;

        int numModelElements = 0;

        int totalViolationsHard = 0;
        int totalViolationsOcl = 0;

        for ( PRI pri : pris ) {
            System.out.println( "Partition: " + pri.getPartitionName( ) );
            elements = connection.getPartition( pri ).getElements( );

            for ( Partitionable element : elements ) {
                if ( element instanceof ModelElement ) {

                    ModelElement me = (ModelElement) element;

                    if ( me instanceof Wrapper ) {
                        me = ( (Wrapper<ModelElement>) me ).unwrap( );
                    }
                    int codedViolations = 0;
                    Collection<JmiException> exceptions = new ArrayList<JmiException>( );
                    long start = System.nanoTime( );
                    try {
                        exceptions = me.refVerifyConstraints( false );
                    } catch ( RuntimeException e ) {
                        System.err.println( "Exception MoinAndMofConstraints" );
                    }
                    long durHard = System.nanoTime( ) - start;
                    totalTimeHard += durHard;

                    if ( exceptions != null ) {
                        codedViolations += exceptions.size( );
                        for ( JmiException ex : exceptions ) {
                            String message = "Exception: " + ex.getMessage( );
                            if ( ex.getElementInError( ) != null ) {
                                message = message + " MofID: " + ex.getElementInError( ).refMofId( );
                            }
                            System.out.println( message );
                        }
                    }

                    start = System.nanoTime( );
                    DeferredConstraintViolationStatus stat = null;
                    try {
                        stat = srv.verifyConstraints( me );
                    } catch ( RuntimeException e ) {
                        System.err.println( "Exception OclService" );
                    }

                    long durOcl = System.nanoTime( ) - start;
                    totalTimeOcl += durOcl;

                    int oclViolations = 0;
                    if ( stat != null ) {

                        List<DeferredConstraintViolationStatusItem> items = stat.getAll( );
                        oclViolations += items.size( );
                        for ( DeferredConstraintViolationStatusItem item : items ) {
                            System.out.println( "Violation: " + item.getConstraintRegistration( ).getName( ) + " MofID: " + item.getOffendingMRI( ).getMofId( ) );
                        }
                    }

                    totalViolationsHard += codedViolations;
                    totalViolationsOcl += oclViolations;
                    if ( codedViolations + oclViolations > 0 ) {
                        if ( codedViolations != oclViolations ) {
                            System.err.println( "MofId: " + me.refMofId( ) + " Coded: " + codedViolations + " Exceptions in " + durHard / 1000000d + "ms, OCL: " + oclViolations + " Violations in " + durOcl / 1000000d + " ms" );
                        } else {
                            System.out.println( "MofId: " + me.refMofId( ) + " Coded: " + codedViolations + " Exceptions in " + durHard / 1000000d + "ms, OCL: " + oclViolations + " Violations in " + durOcl / 1000000d + " ms" );
                        }
                    }
                    numModelElements++;

                }
            }
        }
        System.out.println( "Sum for " + numModelElements + " ModelElements: Coded: " + totalTimeHard / 1000000d + " (" + totalViolationsHard + " violations) OCL: " + totalTimeOcl / 1000000d + " (" + totalViolationsOcl + " violations)" );

    }

}
