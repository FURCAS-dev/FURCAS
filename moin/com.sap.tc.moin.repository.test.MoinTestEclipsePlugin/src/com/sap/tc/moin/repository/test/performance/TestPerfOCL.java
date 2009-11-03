package com.sap.tc.moin.repository.test.performance;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.model.ModelPackage;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.VisibilityKindEnum;

import org.eclipse.test.performance.PerformanceMeter;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.company.Department;
import com.sap.company.Employee;
import com.sap.serviceinteractions.Message;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.ocl.OclRegistryService;
import com.sap.tc.moin.repository.ocl.metamodel.OclMetamodelConstraintRegistry;
import com.sap.tc.moin.repository.ocl.mof.OclMofConstraintRegistry;
import com.sap.tc.moin.repository.ocl.notification.DeferredConstraintViolationListener;
import com.sap.tc.moin.repository.ocl.notification.DeferredConstraintViolationStatus;
import com.sap.tc.moin.repository.ocl.notification.DeferredConstraintViolationStatusItem;
import com.sap.tc.moin.repository.ocl.notification.OclManagerException;
import com.sap.tc.moin.repository.ocl.registry.OclRegistrationCategory;
import com.sap.tc.moin.test.fw.TestMetaModels;

/**
 * OCL Performance
 */
@SuppressWarnings( "nls" )
public class TestPerfOCL extends TestPerfBase {

    private static final String CAT_CIRCCHECK = "CircularityCheck";

    private static final String CAT_SAVE = "Save";

    /**
     * Nothing particularly interesting
     */
    public TestPerfOCL( ) {

        super( );
    }

    /**
     * @throws Exception some
     */
    @BeforeClass
    public static void beforePerformanceTest( ) throws Exception {

        setUp( );
    }

    /**
     * @throws Exception some
     */
    @AfterClass
    public static void afterPerformanceTest( ) throws Exception {

        tearDown( );
    }

    /**
     * @throws Exception some
     */
    @Test
    public void testGetMofConstraintRegistryFromNewConnection( ) throws Exception {

        int count = 100;
        String descriptiveId = "OCL MofConstraintRegistryNewConn";
        String comment = "Getting OCL MofConstraintRegistry based on a newly created connection which is closed again at the end (" + count + " times)";
        PerformanceMeter testPerfMeter = createPerformanceMeter( descriptiveId, false, comment );

        // Warm-up call to minimize startup/JIT optimization impact
        doGetMofConstraintRegistryFromNewConnection( 10 );

        try {
            for ( int i = 0; i < 100; i++ ) {
                testPerfMeter.start( );
                doGetMofConstraintRegistryFromNewConnection( count );
                testPerfMeter.stop( );
            }
            endPerformanceMeasurement( testPerfMeter, true );
        } finally {
            testPerfMeter.dispose( );
        }
    }

    private void doGetMofConstraintRegistryFromNewConnection( int count ) throws Exception, OclManagerException {

        for ( int i = 0; i < count; i++ ) {
            Connection conn = createConnection( );
            conn.getOclRegistryService( ).getMofConstraintRegistry( );
            conn.close( );
        }
    }

    /**
     * @throws Exception some
     */
    @Test
    public void testGetMofConstraintRegistryFromSameConnection( ) throws Exception {

        int count = 10000;
        String descriptiveId = "OCL MofConstraintRegistrySameConn";
        String comment = "Getting OCL MofConstraintRegistry based on an existing connection (" + count + " times)";
        PerformanceMeter testPerfMeter = createPerformanceMeter( descriptiveId, false, comment );

        Connection conn = createConnection( );

        // Warm-up call to minimize startup/JIT optimization impact
        doGetMofConstraintRegistryFromSameConnection( 10, conn );
        try {
            for ( int i = 0; i < 100; i++ ) {
                testPerfMeter.start( );
                doGetMofConstraintRegistryFromSameConnection( count, conn );
                testPerfMeter.stop( );
            }
            endPerformanceMeasurement( testPerfMeter, true );
        } finally {
            testPerfMeter.dispose( );
            conn.close( );
        }
    }

    private void doGetMofConstraintRegistryFromSameConnection( int count, Connection connection ) throws Exception, OclManagerException {

        for ( int i = 0; i < count; i++ ) {
            connection.getOclRegistryService( ).getMofConstraintRegistry( );
        }
    }

    /**
     * @throws Exception some
     */
    @Test
    public void testRegisterDeferredMofConstraintRegistryListener( ) throws Exception {

        int count = 40;
        String descriptiveId = "OCL DeferredListenerMofConstraints";
        String comment = "Register Listener for deferred MOF constraint violations (" + count + " times)";
        PerformanceMeter testPerfMeter = createPerformanceMeter( descriptiveId, false, comment );

        // Warm-up call to minimize startup/JIT optimization impact
        doRegisterDeferredMofConstraintRegistryListener( count );

        try {
            for ( int i = 0; i < 100; i++ ) {
                testPerfMeter.start( );
                doRegisterDeferredMofConstraintRegistryListener( count );
                testPerfMeter.stop( );
            }
            endPerformanceMeasurement( testPerfMeter, true );
        } finally {
            testPerfMeter.dispose( );
        }
    }

    private void doRegisterDeferredMofConstraintRegistryListener( int count ) throws Exception {

        for ( int i = 0; i < count; i++ ) {

            Connection conn = createConnection( );
            OclMofConstraintRegistry registry = conn.getOclRegistryService( ).getMofConstraintRegistry( );

            DeferredConstraintViolationListener firstListener = new DeferredConstraintViolationListener( ) {

                public void notify( DeferredConstraintViolationStatus violationStatus ) {

                    // does nothing, just listens
                }
            };

            registry.registerDeferredConstraintViolationListenerForEvents( firstListener, OclRegistrationCategory.deferred );

            conn.close( );
        }
    }

    /**
     * @throws Exception some
     */
    @Test
    public void testEvaluatePartitionsMofConstraintRegistry( ) throws Exception {

        int count = 5;
        String descriptiveId = "OCL EvalPartitionsMofConstraints";
        String comment = "Evaluate MOF constraints on partitions (" + count + " times)";
        PerformanceMeter testPerfMeter = createPerformanceMeter( descriptiveId, false, comment );

        // Preparation work
        Connection conn = createConnection( );
        OclMofConstraintRegistry registry = conn.getOclRegistryService( ).getMofConstraintRegistry( );

        Set<PRI> partitionPris = new HashSet<PRI>( );

        ModelPartition partitions = ( (Partitionable) ( conn.getPackage( TestMetaModels.COMPANY_CN, "Company" ).refMetaObject( ) ) ).get___Partition( );
        partitionPris.add( partitions.getPri( ) );

        // Warm-up call to minimize startup/JIT optimization impact
        doEvaluatePartitionsMofConstraintRegistry( count, registry, partitionPris );

        try {
            for ( int i = 0; i < 100; i++ ) {

                testPerfMeter.start( );
                doEvaluatePartitionsMofConstraintRegistry( count, registry, partitionPris );
                testPerfMeter.stop( );

            }
            endPerformanceMeasurement( testPerfMeter, true );
        } finally {
            conn.close( );
            testPerfMeter.dispose( );
        }
    }

    private void doEvaluatePartitionsMofConstraintRegistry( int count, OclMofConstraintRegistry registry, Set<PRI> partitionPris ) throws Exception {

        for ( int i = 0; i < count; i++ ) {
            DeferredConstraintViolationStatus stat = registry.analyzeMetamodelPartitions( partitionPris, OclRegistrationCategory.immediate, OclRegistrationCategory.deferred );
            for ( DeferredConstraintViolationStatusItem item : stat.getAll( ) ) {
                item.getConstraintViolationMessage( );
            }
        }
    }

    /**
     * @throws Exception some
     */
    @Test
    public void testEvaluateEventsMofConstraintRegistry( ) throws Exception {

        int count = 10;
        String descriptiveId = "OCL EvalEventsMofConstraints";
        String comment = "Register Listener for deferred MOF constraint violations (" + count + " times)";
        PerformanceMeter testPerfMeter = createPerformanceMeter( descriptiveId, false, comment );

        Connection conn = createConnection( );
        OclMofConstraintRegistry registry = conn.getOclRegistryService( ).getMofConstraintRegistry( );

        registry.registerDeferredConstraintViolationListenerForEvents( new DeferredConstraintViolationListener( ) {

            public void notify( DeferredConstraintViolationStatus violationStatus ) {

                // just listening    
                //                for (DeferredConstraintViolationStatusItem item : violationStatus.getAll()) {
                //                    System.out.println(item.getConstraintViolationMessage());
                //                }
            }

        }, OclRegistrationCategory.immediate, OclRegistrationCategory.deferred );

        ModelPackage mp = (ModelPackage) conn.getPackage( TestMetaModels.MOIN_MOF_CN, "Model" );
        MofClass mc = (MofClass) mp.getMofClass( ).refCreateInstance( );
        mc.setName( "SomeName" );
        mc.setAnnotation( "" );
        mc.setRoot( false );
        mc.setLeaf( false );
        mc.setAbstract( false );
        mc.setVisibility( VisibilityKindEnum.PUBLIC_VIS );
        mc.setSingleton( true );

        MofClass mc2 = (MofClass) mp.getMofClass( ).refCreateInstance( );
        mc2.setName( "SomeName" );
        mc2.setAnnotation( "" );
        mc2.setRoot( false );
        mc2.setLeaf( false );
        mc2.setAbstract( true );
        mc2.setVisibility( VisibilityKindEnum.PUBLIC_VIS );
        mc2.setSingleton( true );

        // Warm-up call to minimize startup/JIT optimization impact
        doEvaluateEventsMofConstraintRegistry( count, registry );

        try {
            for ( int i = 0; i < 100; i++ ) {
                testPerfMeter.start( );
                doEvaluateEventsMofConstraintRegistry( count, registry );
                testPerfMeter.stop( );
            }
            endPerformanceMeasurement( testPerfMeter, true );
        } finally {
            testPerfMeter.dispose( );
            conn.close( );
        }
    }

    private void doEvaluateEventsMofConstraintRegistry( int count, OclMofConstraintRegistry registry ) throws Exception {

        for ( int i = 0; i < count; i++ ) {
            registry.analyzeCollectedEvents( OclRegistrationCategory.immediate, OclRegistrationCategory.deferred );
        }
    }

    /**
     * @throws Exception some
     */
    @Test
    public void testGetMMConstraintRegistryFromNewConnection( ) throws Exception {

        int count = 100;
        String descriptiveId = "OCL MMConstraintRegistryNewConn";
        String comment = "Getting OCL Metamodel ConstraintRegistry based on a newly created connection which is closed again at the end (" + count + " times)";
        PerformanceMeter testPerfMeter = createPerformanceMeter( descriptiveId, false, comment );

        // Warm-up call to minimize startup/JIT optimization impact
        doGetMMConstraintRegistryFromNewConnection( count );

        try {
            for ( int i = 0; i < 100; i++ ) {
                testPerfMeter.start( );
                doGetMMConstraintRegistryFromNewConnection( count );
                testPerfMeter.stop( );
            }
            endPerformanceMeasurement( testPerfMeter, true );
        } finally {
            testPerfMeter.dispose( );
        }
    }

    private void doGetMMConstraintRegistryFromNewConnection( int count ) throws Exception, OclManagerException {

        for ( int i = 0; i < count; i++ ) {
            Connection conn = createConnection( );
            conn.getOclRegistryService( ).getMetamodelConstraintRegistry( );
            conn.close( );
        }
    }

    /**
     * @throws Exception some
     */
    @Test
    public void testRegisterDeferredMMConstraintRegistryListener( ) throws Exception {

        int count = 100;
        String descriptiveId = "OCL DeferredListenerMMConstraints";
        String comment = "Register Listener for deferred metamodel constraint violations (" + count + " times)";
        PerformanceMeter testPerfMeter = createPerformanceMeter( descriptiveId, false, comment );

        try {

            for ( int i = 0; i < count; i++ ) {

                Connection conn = createConnection( );
                OclMetamodelConstraintRegistry registry = conn.getOclRegistryService( ).getMetamodelConstraintRegistry( );

                DeferredConstraintViolationListener listener = new DeferredConstraintViolationListener( ) {

                    public void notify( DeferredConstraintViolationStatus violationStatus ) {

                        // does nothing, just listens
                    }
                };

                final String customCategory = "red";

                // Warm-up to minimize lazy loading / JIT
                registry.registerDeferredConstraintViolationListenerForEvents( OclRegistrationCategory.deferred.toString( ), listener );
                registry.unregisterDeferredListener( listener );
                registry.registerDeferredConstraintViolationListenerForEvents( customCategory, listener );
                registry.unregisterDeferredListener( listener );

                // Start Measuring
                testPerfMeter.start( );
                registry.registerDeferredConstraintViolationListenerForEvents( OclRegistrationCategory.deferred.toString( ), listener );
                registry.registerDeferredConstraintViolationListenerForEvents( customCategory, listener );
                testPerfMeter.stop( );
                registry.unregisterDeferredListener( listener );
                conn.close( );
            }
            endPerformanceMeasurement( testPerfMeter, true );
        } finally {
            testPerfMeter.dispose( );
        }

    }

    private Employee createEmployee( Connection conn, java.lang.String name, int age, int salary, com.sap.company.Employee secretary ) {

        Employee employee = conn.createElementInPartition( Employee.class, null );
        employee.setName( name );
        employee.setAge( age );
        employee.setSalary( salary );
        employee.setSecretary( secretary );
        return employee;
    }

    private Department createDepartment( Connection conn, java.lang.String name, int maxJuniors, int budget ) {

        Department department = conn.createElementInPartition( Department.class, null );
        department.setName( name );
        department.setMaxJuniors( maxJuniors );
        department.setBudget( budget );
        return department;
    }

    /**
     * @throws Exception some
     */
    @Test
    public void testEvaluatePartitionsMMConstraintRegistry( ) throws Exception {

        int count = 10;
        String descriptiveId = "OCL EvalPartitionsMMConstraints";
        String comment = "Evaluate metamodel constraints on partitions (" + count + " times)";
        PerformanceMeter testPerfMeter = createPerformanceMeter( descriptiveId, false, comment );

        Connection conn = createConnection( );

        OclRegistryService srv = conn.getOclRegistryService( );
        OclMetamodelConstraintRegistry reg = srv.getMetamodelConstraintRegistry( );

        DeferredConstraintViolationListener listener = new DeferredConstraintViolationListener( ) {

            public void notify( DeferredConstraintViolationStatus violationStatus ) {

                // just listening
                //                for (DeferredConstraintViolationStatusItem item : violationStatus.getAll()) {
                //                    System.out.println(item.getConstraintViolationMessage());
                //                }
            }

        };

        reg.registerPartitionBasedConstraintViolationListener( OclRegistrationCategory.immediate.toString( ), listener );
        reg.registerPartitionBasedConstraintViolationListener( OclRegistrationCategory.deferred.toString( ), listener );

        //CompanyPackage company = (CompanyPackage) conn.getPackage( TestMetaModels.COMPANY_CN, "Company" );
        Department dep = createDepartment( conn, "SomeDep", 1, 50000 );
        Employee firstJunior = createEmployee( conn, "FirstJunior", 18, 1000, null );
        Employee secondJunior = createEmployee( conn, "FirstJunior", 18, 1000, null );
        dep.getEmployee( ).add( firstJunior );
        dep.getEmployee( ).add( secondJunior );

        Set<PRI> partitionPris = new HashSet<PRI>( );
        partitionPris.add( conn.getNullPartition( ).getPri( ) );

        // Warm-up call to minimize startup/JIT optimization impact
        for ( int j = 0; j < 10; j++ ) {
            srv.analyzeModelPartitions( OclRegistrationCategory.deferred.toString( ), partitionPris );
        }

        try {
            for ( int i = 0; i < 100; i++ ) {
                testPerfMeter.start( );
                for ( int j = 0; j < count; j++ ) {
                    srv.analyzeModelPartitions( OclRegistrationCategory.deferred.toString( ), partitionPris );
                }
                testPerfMeter.stop( );
            }
            endPerformanceMeasurement( testPerfMeter, true );
        } finally {
            testPerfMeter.dispose( );
            conn.close( );
        }
    }

    /**
     * @throws Exception some
     */
    @Test
    public void testEvaluateEventsMMConstraintRegistry( ) throws Exception {

        int count = 100;
        String descriptiveId = "OCL EvalEventsMMConstraints";
        String comment = "Evaluate metamodel constraint (" + count + " times)";
        PerformanceMeter testPerfMeter = createPerformanceMeter( descriptiveId, false, comment );

        Connection conn = createConnection( );

        OclRegistryService srv = conn.getOclRegistryService( );
        OclMetamodelConstraintRegistry reg = srv.getMetamodelConstraintRegistry( );

        DeferredConstraintViolationListener listener = new DeferredConstraintViolationListener( ) {

            public void notify( DeferredConstraintViolationStatus violationStatus ) {

                // just listening
                //                for (DeferredConstraintViolationStatusItem item : violationStatus.getAll()) {
                //                    System.out.println(item.getConstraintViolationMessage());
                //                }
            }

        };

        reg.registerDeferredConstraintViolationListenerForEvents( OclRegistrationCategory.immediate.toString( ), listener );
        reg.registerDeferredConstraintViolationListenerForEvents( OclRegistrationCategory.deferred.toString( ), listener );

        //CompanyPackage company = (CompanyPackage) conn.getPackage( TestMetaModels.COMPANY_CN, "Company" );
        Department dep = createDepartment( conn, "SomeDep", 1, 50000 );
        Employee firstJunior = createEmployee( conn, "FirstJunior", 18, 1000, null );
        Employee secondJunior = createEmployee( conn, "FirstJunior", 18, 1000, null );
        dep.getEmployee( ).add( firstJunior );
        dep.getEmployee( ).add( secondJunior );

        Set<PRI> partitionPris = new HashSet<PRI>( );
        partitionPris.add( conn.getNullPartition( ).getPri( ) );

        // Warm-up call to minimize startup/JIT optimization impact
        for ( int j = 0; j < 100; j++ ) {
            srv.analyzeCollectedEvents( OclRegistrationCategory.deferred.toString( ) );
            srv.analyzeCollectedEvents( OclRegistrationCategory.immediate.toString( ) );
        }

        try {
            for ( int i = 0; i < 100; i++ ) {
                testPerfMeter.start( );
                for ( int j = 0; j < count; j++ ) {
                    srv.analyzeCollectedEvents( OclRegistrationCategory.deferred.toString( ) );
                    srv.analyzeCollectedEvents( OclRegistrationCategory.immediate.toString( ) );
                }
                testPerfMeter.stop( );
            }
            endPerformanceMeasurement( testPerfMeter, true );
        } finally {
            testPerfMeter.dispose( );
            conn.close( );
        }
    }

    /**
     * @throws Exception some
     */
    @Test
    public void testFilteredPartitionBasedConstraintChecking( ) throws Exception {

        int count = 100;
        String descriptiveId = "OCL CatFilteredPartitionCheck";
        String comment = "Evaluate metamodel constraint (" + count + " times)";
        PerformanceMeter testPerfMeter = createPerformanceMeter( descriptiveId, false, comment );

        Connection conn = createConnection( );

        OclRegistryService srv = conn.getOclRegistryService( );
        OclMetamodelConstraintRegistry reg = srv.getMetamodelConstraintRegistry( );

        Message message1 = conn.createElement( Message.class );
        Message message2 = conn.createElement( Message.class );

        // circle
        message1.setReplyTo( message2 );
        message2.setReplyTo( message1 );

        Set<PRI> partitions = new HashSet<PRI>( );
        partitions.add( conn.getNullPartition( ).getPri( ) );

        Set<String> both = new HashSet<String>( );
        both.add( CAT_SAVE );
        both.add( CAT_CIRCCHECK );

        // Warm-up call to minimize startup/JIT optimization impact
        for ( int j = 0; j < 100; j++ ) {
            reg.verifyConstraints( partitions, both );
        }

        try {
            for ( int i = 0; i < 100; i++ ) {
                testPerfMeter.start( );
                for ( int j = 0; j < count; j++ ) {
                    reg.verifyConstraints( partitions, both );
                }
                testPerfMeter.stop( );
            }
            endPerformanceMeasurement( testPerfMeter, true );
        } finally {
            testPerfMeter.dispose( );
            conn.close( );
        }
    }

    /**
     * @throws Exception some
     */
    @Test
    public void testUnFilteredPartitionBasedConstraintChecking( ) throws Exception {

        int count = 100;
        String descriptiveId = "OCL CatUnFilteredPartitionCheck";
        String comment = "Evaluate metamodel constraint (" + count + " times)";
        PerformanceMeter testPerfMeter = createPerformanceMeter( descriptiveId, false, comment );

        Connection conn = createConnection( );

        OclRegistryService srv = conn.getOclRegistryService( );
        OclMetamodelConstraintRegistry reg = srv.getMetamodelConstraintRegistry( );

        Message message1 = conn.createElement( Message.class );
        Message message2 = conn.createElement( Message.class );

        // circle
        message1.setReplyTo( message2 );
        message2.setReplyTo( message1 );

        Set<PRI> partitions = new HashSet<PRI>( );
        partitions.add( conn.getNullPartition( ).getPri( ) );

        Set<String> all = Collections.emptySet( );

        // Warm-up call to minimize startup/JIT optimization impact
        for ( int j = 0; j < 100; j++ ) {
            reg.verifyConstraints( partitions, all );
        }

        try {
            for ( int i = 0; i < 100; i++ ) {
                testPerfMeter.start( );
                for ( int j = 0; j < count; j++ ) {
                    reg.verifyConstraints( partitions, all );
                }
                testPerfMeter.stop( );
            }
            endPerformanceMeasurement( testPerfMeter, true );
        } finally {
            testPerfMeter.dispose( );
            conn.close( );
        }
    }
}
