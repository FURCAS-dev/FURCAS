package com.sap.tc.moin.repository.test.ocl.integration;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import org.junit.Test;

import com.sap.company.Department;
import com.sap.company.Employee;
import com.sap.company.Freelance;
import com.sap.serviceinteractions.Message;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.core.events.VetoException;
import com.sap.tc.moin.repository.ocl.OclRegistryService;
import com.sap.tc.moin.repository.ocl.debugger.OclDebuggerNode;
import com.sap.tc.moin.repository.ocl.freestyle.ExpressionInvalidationListener;
import com.sap.tc.moin.repository.ocl.freestyle.OclExpressionRegistration;
import com.sap.tc.moin.repository.ocl.freestyle.OclFreestyleRegistry;
import com.sap.tc.moin.repository.ocl.freestyle.OclInvariantRegistration;
import com.sap.tc.moin.repository.ocl.freestyle.OclRegistrationType;
import com.sap.tc.moin.repository.ocl.notification.DeferredConstraintViolationListener;
import com.sap.tc.moin.repository.ocl.notification.DeferredConstraintViolationStatus;
import com.sap.tc.moin.repository.ocl.notification.EventBasedConstraintViolationStatus;
import com.sap.tc.moin.repository.ocl.notification.EventBasedConstraintViolationStatusItem;
import com.sap.tc.moin.repository.ocl.notification.ImmediateConstraintViolationListener;
import com.sap.tc.moin.repository.ocl.notification.OclManagerException;
import com.sap.tc.moin.repository.ocl.registry.OclRegistrationSeverity;
import com.sap.tc.moin.repository.spi.core.Wrapper;
import com.sap.tc.moin.repository.test.ocl.base.BaseOclIntegrationTest;
import com.sap.tc.moin.test.fw.TestMetaModels;

/**
 * @author d022737
 */
@SuppressWarnings( "nls" )
public class FreestyleRegistryTestCompany extends BaseOclIntegrationTest {

    private class ExpectedException extends VetoException {

        private static final long serialVersionUID = 1L;

        // just so that it passes the event framework
        /**
         * 
         */
        public ExpectedException( ) {

            super( "This is expected" );
        }
    }

    private Freelance createFreelance( Connection conn, java.lang.String name, int age, int salary, com.sap.company.Employee secretary, int assignment ) {

        Freelance freelance = conn.createElementInPartition( Freelance.class, null );
        freelance.setName( name );
        freelance.setAge( age );
        freelance.setSalary( salary );
        freelance.setSecretary( secretary );
        freelance.setAssignment( assignment );
        return freelance;
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

    private Message createMessage( Connection conn, boolean isFault, java.lang.String type ) {

        Message message = conn.createElementInPartition( Message.class, null );
        message.setFault( isFault );
        message.setType( type );
        return message;
    }

    /**
     * @throws Exception cover all
     */
    @Test
    public void testDeferredInvariantRegistration( ) throws Exception {

        Connection c = this.createConnection( );

        OclRegistryService regsrv = c.getOclRegistryService( );
        OclFreestyleRegistry registry = regsrv.getFreestyleRegistry( );

        RefPackage targetPackage = c.getPackage( TestMetaModels.COMPANY_CN, TestMetaModels.COMPANY_TPE );
        RefClass freelanceClass = targetPackage.refClass( "Freelance" );
        RefClass departmentClass = targetPackage.refClass( "Department" );
        RefClass employeeClass = targetPackage.refClass( "Employee" );


        RefPackage[] types = new RefPackage[] { targetPackage };

        OclInvariantRegistration errorRegistration = registry.createInvariantRegistration( "FreelanceInvariantError", "inv: self.assignment >= 0 and self.assignment <= 30", OclRegistrationSeverity.Error, new String[] { "MyCategory", "MyErrorCategory" }, freelanceClass, types );

        OclInvariantRegistration warningRegistration = registry.createInvariantRegistration( "FreelanceInvariantWarning", "inv: self.assignment >= 5 and self.assignment <= 15", OclRegistrationSeverity.Warning, new String[] { "MyCategory", "MyWarningCategory" }, freelanceClass, types );

        DeferredConstraintViolationListener warninglistener = new DeferredConstraintViolationListener( ) {

            public void notify( DeferredConstraintViolationStatus event ) {

                if ( event.hasErrors( ) ) {
                    errorAndContinue( "Error instead of warning received" );
                } else if ( event.hasWarnings( ) ) {
                    throw new ExpectedException( );
                }
            }
        };

        DeferredConstraintViolationListener errorlistener = new DeferredConstraintViolationListener( ) {

            public void notify( DeferredConstraintViolationStatus event ) {

                if ( event.hasWarnings( ) ) {
                    errorAndContinue( "Warning instead of error received" );
                } else if ( event.hasErrors( ) ) {
                    throw new ExpectedException( );
                }
            }

        };


        //createFreelance(java.lang.String name, int age, int salary, com.sap.company.Employee secretary, int assignment)         
        Freelance f1 = createFreelance( c, "Free1", 22, 500, null, 5 );

        Freelance f2 = createFreelance( c, "Free2", 21, 500, null, 35 );

        Freelance f3 = createFreelance( c, "Free3", 21, 500, null, 77 );

        Employee e1 = createEmployee( c, "Emp1", 25, 2500, null );

        Employee e2 = createEmployee( c, "Emp2", 35, 2800, null );

        registry.registerDeferredConstraintViolationListenerForPartitions( "MyWarningCategory", warninglistener );

        registry.registerDeferredConstraintViolationListenerForPartitions( "MyErrorCategory", errorlistener );

        Set<PRI> partitions = new HashSet<PRI>( );
        partitions.add( c.getNullPartition( ).getPri( ) );

        try {
            regsrv.analyzeModelPartitions( "MyErrorCategory", partitions );
            errorAndContinue( "Expected Exception not thrown" );
        } catch ( ExpectedException e ) {
            info( "Expected Exception thrown" );
        }
        try {
            regsrv.analyzeModelPartitions( "MyWarningCategory", partitions );
            errorAndContinue( "Expected Exception not thrown" );
        } catch ( ExpectedException e ) {
            info( "Expected Exception thrown" );
        }
        registry.unregisterDeferredConstraintViolationListener( warninglistener );
        registry.unregisterDeferredConstraintViolationListener( errorlistener );

        try {
            regsrv.analyzeModelPartitions( "MyCategory", partitions );
            regsrv.analyzeModelPartitions( "MyOtherCategory", partitions );
        } catch ( RuntimeException e ) {
            errorAndContinue( "Unexpected Exception" );
        }

    }

    /**
     * @throws Exception cover all
     */
    @Test
    public void testSimpleEvaluationAndWrap( ) throws Exception {

        Connection c = this.createConnection( );

        OclRegistryService regsrv = c.getOclRegistryService( );
        OclFreestyleRegistry registry = regsrv.getFreestyleRegistry( );

        RefPackage targetPackage = c.getPackage( TestMetaModels.COMPANY_CN, TestMetaModels.COMPANY_TPE );
        RefClass freelanceClass = targetPackage.refClass( "Freelance" );
        RefClass departmentClass = targetPackage.refClass( "Department" );
        RefClass employeeClass = targetPackage.refClass( "Employee" );


        RefPackage[] types = new RefPackage[] { targetPackage };

        OclExpressionRegistration assign = registry.createExpressionRegistration( "FreelanceAssignment", "self.assignment", OclRegistrationSeverity.Warning, new String[] { "Expression" }, freelanceClass, types );
        OclExpressionRegistration empls = registry.createExpressionRegistration( "DepartmentEmployees", "self.employee", OclRegistrationSeverity.Warning, new String[] { "Expression" }, departmentClass, types );
        OclExpressionRegistration dep = registry.createExpressionRegistration( "EmployeeDepartment", "self.employer", OclRegistrationSeverity.Warning, new String[] { "Expression" }, employeeClass, types );
        OclExpressionRegistration allinstances = registry.createExpressionRegistration( "EmployeeAllInstances", "Employee.allInstances()", OclRegistrationSeverity.Warning, new String[] { "Expression" }, employeeClass, types );



        Freelance f1 = createFreelance( c, "Free1", 22, 500, null, 5 );

        Freelance f2 = createFreelance( c, "Free2", 21, 500, null, 35 );

        Freelance f3 = createFreelance( c, "Free3", 21, 500, null, 77 );

        Employee e1 = createEmployee( c, "Emp1", 25, 2500, null );

        Employee e2 = createEmployee( c, "Emp2", 35, 2800, null );

        Department dep1 = createDepartment( c, "Dep1", 1, 2000 );

        Employee e3 = createEmployee( c, "Emp3", 25, 2500, null );
        dep1.getEmployee( ).add( e3 );

        Employee e4 = createEmployee( c, "Emp4", 35, 2800, null );
        dep1.getEmployee( ).add( e4 );

        Set<PRI> partitions = new HashSet<PRI>( );
        partitions.add( c.getNullPartition( ).getPri( ) );


        int result = ( (Integer) assign.evaluateExpression( f3 ) ).intValue( );
        verify( result == 77, "Expected result not returned" );

        // check the other API method
        result = ( (Integer) assign.evaluateExpression( f3.get___Mri( ) ) ).intValue( );
        verify( result == 77, "Expected result not returned" );

        Collection employees = (Collection) empls.evaluateExpression( dep1 );
        verify( employees.size( ) == 2, "Expected size of connection wrong" );
        for ( Object empl : employees ) {
            verify( empl instanceof Wrapper, "Instance is not a wrapper" );
        }
        Department department = (Department) dep.evaluateExpression( e3 );
        verify( department instanceof Wrapper, "Department not wrapped" );
        verify( department.getEmployee( ).size( ) == 2, "No the right number of employees" );

        int numberOfIntances = ( (Collection) allinstances.evaluateExpression( (RefObject) null ) ).size( );
        // 7 because freelances are employees, too
        verify( numberOfIntances == 7, "Wrong number of instances" );

    }

    /**
     * @throws Exception cover all
     */
    @Test
    public void testOclDebugger( ) throws Exception {

        Connection c = this.createConnection( );

        OclRegistryService regsrv = c.getOclRegistryService( );
        OclFreestyleRegistry registry = regsrv.getFreestyleRegistry( );

        RefPackage targetPackage = c.getPackage( TestMetaModels.COMPANY_CN, TestMetaModels.COMPANY_TPE );
        RefClass freelanceClass = targetPackage.refClass( "Freelance" );
        RefClass departmentClass = targetPackage.refClass( "Department" );
        RefClass employeeClass = targetPackage.refClass( "Employee" );


        RefPackage[] types = new RefPackage[] { targetPackage };

        OclExpressionRegistration assign = registry.createExpressionRegistration( "FreelanceAssignment", "self.assignment", OclRegistrationSeverity.Warning, new String[] { "Expression" }, freelanceClass, types );
        OclExpressionRegistration empls = registry.createExpressionRegistration( "DepartmentEmployees", "self.employee", OclRegistrationSeverity.Warning, new String[] { "Expression" }, departmentClass, types );
        OclExpressionRegistration dep = registry.createExpressionRegistration( "EmployeeDepartment", "self.employer", OclRegistrationSeverity.Warning, new String[] { "Expression" }, employeeClass, types );
        OclExpressionRegistration allinstances = registry.createExpressionRegistration( "EmployeeAllInstances", "Employee.allInstances()", OclRegistrationSeverity.Warning, new String[] { "Expression" }, employeeClass, types );

        Freelance f1 = createFreelance( c, "Free1", 22, 500, null, 5 );

        Freelance f2 = createFreelance( c, "Free2", 21, 500, null, 35 );

        Freelance f3 = createFreelance( c, "Free3", 21, 500, null, 77 );

        Employee e1 = createEmployee( c, "Emp1", 25, 2500, null );

        Employee e2 = createEmployee( c, "Emp2", 35, 2800, null );

        Department dep1 = createDepartment( c, "Dep1", 1, 2000 );

        Employee e3 = createEmployee( c, "Emp3", 25, 2500, null );
        dep1.getEmployee( ).add( e3 );

        Employee e4 = createEmployee( c, "Emp4", 35, 2800, null );
        dep1.getEmployee( ).add( e4 );

        Set<PRI> partitions = new HashSet<PRI>( );
        partitions.add( c.getNullPartition( ).getPri( ) );


        OclDebuggerNode node = empls.debugExpression( dep1 );
        Set nodeResult = (Set) node.getResultValue( );
        assertEquals( "Wrong result size", nodeResult.size( ), 2 );
        assertTrue( "Employee e3 not contained", nodeResult.contains( ( (Partitionable) e3 ).get___Mri( ) ) );
        assertTrue( "Employee e4 not contained", nodeResult.contains( ( (Partitionable) e4 ).get___Mri( ) ) );
        assertFalse( "Employee e1 contained", nodeResult.contains( ( (Partitionable) e1 ).get___Mri( ) ) );
        // the other API method
        node = empls.debugExpression( dep1.get___Mri( ) );
        nodeResult = (Set) node.getResultValue( );
        assertEquals( "Wrong result size", nodeResult.size( ), 2 );
        assertTrue( "Employee e3 not contained", nodeResult.contains( ( (Partitionable) e3 ).get___Mri( ) ) );
        assertTrue( "Employee e4 not contained", nodeResult.contains( ( (Partitionable) e4 ).get___Mri( ) ) );
        assertFalse( "Employee e1 contained", nodeResult.contains( ( (Partitionable) e1 ).get___Mri( ) ) );

        node = allinstances.debugExpression( (RefObject) null );
        nodeResult = (Set) node.getResultValue( );
        assertTrue( "Wrong result size", nodeResult.size( ) == 7 );
        assertTrue( "Employee e1 not contained", nodeResult.contains( ( (Partitionable) e1 ).get___Mri( ) ) );
        assertTrue( "Employee e2 not contained", nodeResult.contains( ( (Partitionable) e2 ).get___Mri( ) ) );
        assertTrue( "Freelance f1 not contained", nodeResult.contains( ( (Partitionable) f1 ).get___Mri( ) ) );
        assertTrue( "Freelance f2 not contained", nodeResult.contains( ( (Partitionable) f2 ).get___Mri( ) ) );

    }

    /**
     * @throws Exception cover all
     */
    @Test
    public void testDeferredEventBasedInvariantRegistration( ) throws Exception {

        Connection conn = this.createConnection( );

        OclRegistryService srv = conn.getOclRegistryService( );
        OclFreestyleRegistry registry = srv.getFreestyleRegistry( );

        RefPackage targetPackage = conn.getPackage( TestMetaModels.SERVICE_INTERACTIONS_CN, TestMetaModels.SERVICE_INTERACTIONS_TPE );
        RefClass messageClass = targetPackage.refClass( "Message" );
        RefPackage[] types = new RefPackage[] { targetPackage };

        OclInvariantRegistration registration = registry.createInvariantRegistration( "SomeName", "inv: self.reply_to.reply_to->excludes(self)", OclRegistrationSeverity.Warning, new String[] { "OtherCategory" }, messageClass, types );

        DeferredConstraintViolationListener warninglistener = new DeferredConstraintViolationListener( ) {

            public void notify( DeferredConstraintViolationStatus event ) {

                if ( event.hasErrors( ) ) {
                    errorAndContinue( "Error instead of warning received" );
                } else if ( event.hasWarnings( ) ) {
                    throw new ExpectedException( );
                }
            }
        };

        Message msg1 = createMessage( conn, false, "response" );
        Message msg2 = createMessage( conn, false, "response" );

        msg1.setReplyTo( msg2 );

        registry.registerDeferredConstraintViolationListenerForEvents( "OtherCategory", warninglistener );

        msg2.setReplyTo( msg1 );

        try {
            srv.analyzeCollectedEvents( "OtherCategory" );
            errorAndContinue( "Expected Exception not thrown" );
        } catch ( ExpectedException e ) {
            info( "Expected Exception thrown" );
        }

        srv.resetEvents( "OtherCategory" );

        try {
            srv.analyzeCollectedEvents( "OtherCategory" );
        } catch ( ExpectedException e ) {
            errorAndContinue( "Unexpected Exception" );
        }
        verify( registry.unregisterDeferredConstraintViolationListener( warninglistener ), "Unregistration should return true" );

        try {
            srv.analyzeCollectedEvents( "OtherCategory" );
            srv.analyzeCollectedEvents( "OtherCategory" );
        } catch ( RuntimeException e ) {
            errorAndContinue( "Unexpected Exception" );
        }
    }

    /**
     * @throws Exception cover all
     */
    @Test
    public void testImmediateInvariantRegistration( ) throws Exception {


        Connection conn = this.createConnection( );

        OclFreestyleRegistry registry = conn.getOclRegistryService( ).getFreestyleRegistry( );

        RefPackage targetPackage = conn.getPackage( TestMetaModels.SERVICE_INTERACTIONS_CN, TestMetaModels.SERVICE_INTERACTIONS_TPE );
        RefClass messageClass = targetPackage.refClass( "Message" );
        RefPackage[] types = new RefPackage[] { targetPackage };

        OclInvariantRegistration registration = registry.createInvariantRegistration( "SomeName", "inv: self.reply_to.reply_to->excludes(self)", OclRegistrationSeverity.Error, new String[] { "someImmediate" }, messageClass, types );

        ImmediateConstraintViolationListener listener = new ImmediateConstraintViolationListener( ) {

            public void notify( EventBasedConstraintViolationStatusItem event ) {

                System.out.println( "Violation found, MRI: " + event.getOffendingMRI( ) );
                throw new ExpectedException( );
            }

            public void notify( EventBasedConstraintViolationStatus event ) {

                if ( event.hasErrors( ) ) {
                    System.out.println( "Violation found" );
                    throw new ExpectedException( );
                }
                System.out.println( "Warning found" );
                List<EventBasedConstraintViolationStatusItem> warnings = event.getWarnings( );
                for ( EventBasedConstraintViolationStatusItem warning : warnings ) {
                    System.out.println( "MRI: " + warning.getOffendingMRI( ) );
                }
                errorAndContinue( "Warnint instead of Error received" );
            }

        };

        Message msg1 = createMessage( conn, false, "response" );
        Message msg2 = createMessage( conn, false, "response" );
        msg1.setReplyTo( msg2 );

        registry.registerImmediateConstraintViolationListener( "someImmediate", listener );

        try {
            msg2.setReplyTo( msg1 );
            errorAndContinue( "Expected Exception not thrown" );
        } catch ( ExpectedException e ) {
            info( "Expected Exception thrown" );
        }

        verify( registry.unregisterImmediateConstraintViolationListener( listener ), "Unregister should return true" );

    }

    /**
     * @throws Exception cover all
     */
    @Test
    public void testDeferredExpressionRegistration( ) throws Exception {


        Connection c = this.createConnection( );

        OclRegistryService srv = c.getOclRegistryService( );
        OclFreestyleRegistry registry = srv.getFreestyleRegistry( );

        RefPackage targetPackage = c.getPackage( TestMetaModels.SERVICE_INTERACTIONS_CN, TestMetaModels.SERVICE_INTERACTIONS_TPE );
        RefClass messageClass = targetPackage.refClass( "Message" );
        RefPackage[] types = new RefPackage[] { targetPackage };

        final OclExpressionRegistration registration = registry.createExpressionRegistration( "SomeName", "self.type", OclRegistrationSeverity.Warning, new String[] { "TheCategory" }, messageClass, types );

        ExpressionInvalidationListener listener = new ExpressionInvalidationListener( ) {

            public void notify( Collection<MRI> objectsToReEvaluate, OclExpressionRegistration registration,
        	    Connection conn) {

                System.out.println( registration.getSeverity( ) + ": Invalidated Objects: " );
                for ( MRI element : objectsToReEvaluate ) {
                    try {
                        System.out.println( "MofId: " + element.getMofId( ) + " new Value: " + registration.evaluateExpression( element ) );
                    } catch ( OclManagerException e ) {
                        e.printStackTrace( );
                    }
                }
                throw new ExpectedException( );
            }

        };

        registration.registerPartitionBasedInvalidationListener( "TheCategory", listener );

        Message msg1 = createMessage( c, false, "response" );
        Message msg2 = createMessage( c, false, "request" );

        Set<PRI> partitions = new HashSet<PRI>( );
        partitions.add( c.getNullPartition( ).getPri( ) );

        try {
            srv.analyzeModelPartitions( "TheCategory", partitions );
            errorAndContinue( "ExpectedException not thrown" );
        } catch ( ExpectedException e ) {
            info( "ExpectedException thrown" );
        }

        msg2.setType( "test" );
        try {
            srv.analyzeModelPartitions( "TheCategory", partitions );
            errorAndContinue( "ExpectedException not thrown" );
        } catch ( ExpectedException e ) {
            info( "ExpectedException thrown" );
        }

        try {
            srv.analyzeModelPartitions( "TheCategory", partitions );
        } catch ( ExpectedException e1 ) {
            errorAndContinue( "Unexpected Exception thrown: " + e1.getMessage( ) );
        }

        msg1.setType( "request" );

        try {
            srv.analyzeModelPartitions( "TheCategory", partitions );
        } catch ( ExpectedException e ) {
            info( "ExpectedException thrown" );
        }

        String result = (String) registration.evaluateExpression( msg1 );
        assertEquals( result, "request" );

        registration.unregisterInvalidationListener( listener );

    }

    /**
     * @throws Exception cover all
     */
    @Test
    public void testDeferredExpressionRegistrationWithFilter( ) throws Exception {


        Connection c = this.createConnection( );

        OclRegistryService srv = c.getOclRegistryService( );
        OclFreestyleRegistry registry = srv.getFreestyleRegistry( );

        RefPackage targetPackage = c.getPackage( TestMetaModels.SERVICE_INTERACTIONS_CN, TestMetaModels.SERVICE_INTERACTIONS_TPE );
        RefClass messageClass = targetPackage.refClass( "Message" );
        RefPackage[] types = new RefPackage[] { targetPackage };

        final OclExpressionRegistration registration = registry.createExpressionRegistration( "SomeName", "self.type", OclRegistrationSeverity.Warning, new String[] { "TheCategory" }, messageClass, types );

        ExpressionInvalidationListener listener = new ExpressionInvalidationListener( ) {

            public void notify( Collection<MRI> objectsToReEvaluate, OclExpressionRegistration registration,
        	    Connection conn ) {

                System.out.println( registration.getSeverity( ) + ": Invalidated Objects: " );
                for ( MRI element : objectsToReEvaluate ) {
                    try {
                        System.out.println( "MofId: " + element.getMofId( ) + " new Value: " + registration.evaluateExpression( element ) );
                    } catch ( OclManagerException e ) {
                        e.printStackTrace( );
                    }
                }
                throw new ExpectedException( );
            }

        };

        Set<MRI> filter = new HashSet<MRI>( );

        Message msg1 = createMessage( c, false, "response" );
        filter.add( msg1.get___Mri( ) );
        Message msg2 = createMessage( c, false, "request" );

        registration.registerPartitionBasedInvalidationListener( "TheCategory", listener, filter );


        Set<PRI> partitions = new HashSet<PRI>( );
        partitions.add( c.getNullPartition( ).getPri( ) );

        try {
            srv.analyzeModelPartitions( "TheCategory", partitions );
            errorAndContinue( "ExpectedException not thrown" );
        } catch ( ExpectedException e ) {
            info( "ExpectedException thrown" );
        }

        msg2.setType( "test" );
        // msg2 is not in the filter

        try {
            srv.analyzeModelPartitions( "TheCategory", partitions );
        } catch ( ExpectedException e1 ) {
            errorAndContinue( "Unexpected Exception thrown: " + e1.getMessage( ) );
        }

        msg1.setType( "request" );

        try {
            srv.analyzeModelPartitions( "TheCategory", partitions );
        } catch ( ExpectedException e ) {
            info( "ExpectedException thrown" );
        }

        String result = (String) registration.evaluateExpression( msg1 );
        assertEquals( result, "request" );

        registration.unregisterInvalidationListener( listener );

    }

    /**
     * @throws Exception cover all
     */
    @Test
    public void testImmediateExpressionRegistration( ) throws Exception {

        Connection conn = this.createConnection( );
        OclFreestyleRegistry registry = conn.getOclRegistryService( ).getFreestyleRegistry( );

        RefPackage targetPackage = conn.getPackage( TestMetaModels.SERVICE_INTERACTIONS_CN, TestMetaModels.SERVICE_INTERACTIONS_TPE );
        RefClass messageClass = targetPackage.refClass( "Message" );
        RefPackage[] types = new RefPackage[] { targetPackage };

        final OclExpressionRegistration registration = registry.createExpressionRegistration( "SomeName", "self.type", OclRegistrationSeverity.Error, new String[] { "SomeImmediate" }, messageClass, types );

        ExpressionInvalidationListener listener = new ExpressionInvalidationListener( ) {

            public void notify( Collection<MRI> objectsToReEvaluate, OclExpressionRegistration registration,
        	    Connection conn ) {

                System.out.println( registration.getSeverity( ).name( ) + " Invalidated Objects: " );
                for ( MRI element : objectsToReEvaluate ) {
                    try {
                        System.out.println( "MofId: " + element.getMofId( ) + " new Value: " + registration.evaluateExpression( element ) );
                    } catch ( OclManagerException e ) {
                        e.printStackTrace( );
                    }
                }
                throw new ExpectedException( );
            }
        };
        Message msg = createMessage( conn, false, "response" );

        registration.registerEventBasedInvalidationListener( listener, true );

        try {
            msg.setType( "response" );
            errorAndContinue( "ExpectedException not thrown" );
        } catch ( ExpectedException e ) {
            info( "Expected Exception thrown" );
        }

        try {
            msg.setType( "request" );
            errorAndContinue( "ExpectedException not thrown" );
        } catch ( ExpectedException e ) {
            info( "Expected Exception thrown" );
        }

    }

    /**
     * @throws Exception cover all
     */
    @Test
    public void testImmediateExpressionRegistrationWithFilter( ) throws Exception {

        Connection conn = this.createConnection( );
        OclFreestyleRegistry registry = conn.getOclRegistryService( ).getFreestyleRegistry( );

        RefPackage targetPackage = conn.getPackage( TestMetaModels.SERVICE_INTERACTIONS_CN, TestMetaModels.SERVICE_INTERACTIONS_TPE );
        RefClass messageClass = targetPackage.refClass( "Message" );
        RefPackage[] types = new RefPackage[] { targetPackage };

        final OclExpressionRegistration registration = registry.createExpressionRegistration( "SomeName", "self.type", OclRegistrationSeverity.Error, new String[] { "SomeImmediate" }, messageClass, types );

        ExpressionInvalidationListener listener = new ExpressionInvalidationListener( ) {

            public void notify( Collection<MRI> objectsToReEvaluate, OclExpressionRegistration registration,
        	    Connection conn ) {

                System.out.println( registration.getSeverity( ).name( ) + " Invalidated Objects: " );
                for ( MRI element : objectsToReEvaluate ) {
                    try {
                        System.out.println( "MofId: " + element.getMofId( ) + " new Value: " + registration.evaluateExpression( element ) );
                    } catch ( OclManagerException e ) {
                        e.printStackTrace( );
                    }
                }
                throw new ExpectedException( );
            }
        };
        Message msg = createMessage( conn, false, "response" );

        Set<MRI> filter = new HashSet<MRI>( );
        filter.add( msg.get___Mri( ) );
        registration.registerEventBasedInvalidationListener( listener, filter, true );

        try {
            msg.setType( "response" );
            errorAndContinue( "ExpectedException not thrown" );
        } catch ( ExpectedException e ) {
            info( "Expected Exception thrown" );
        }

        try {
            msg.setType( "request" );
            errorAndContinue( "ExpectedException not thrown" );
        } catch ( ExpectedException e ) {
            info( "Expected Exception thrown" );
        }

        registration.unregisterInvalidationListener( listener );

        // reset the events
        conn.getOclRegistryService( ).resetEvents( "SomeImmediate" );

        filter.clear( );
        Message msg2 = createMessage( conn, false, "response" );
        filter.add( msg2.get___Mri( ) );

        registration.registerEventBasedInvalidationListener( listener, filter, true );

        try {
            msg.setType( "response" );
        } catch ( ExpectedException e ) {
            errorAndContinue( "UnexpectedException after resetting the filter" );
        }
    }

    /**
     * @throws Exception cover all
     */
    @Test
    public void testDeferredEventBasedExpressionRegistration( ) throws Exception {


        Connection conn = this.createConnection( );
        OclRegistryService srv = conn.getOclRegistryService( );
        OclFreestyleRegistry registry = srv.getFreestyleRegistry( );

        RefPackage targetPackage = conn.getPackage( TestMetaModels.SERVICE_INTERACTIONS_CN, TestMetaModels.SERVICE_INTERACTIONS_TPE );
        RefClass messageClass = targetPackage.refClass( "Message" );
        RefPackage[] types = new RefPackage[] { targetPackage };

        final OclExpressionRegistration registration = registry.createExpressionRegistration( "SomeName", "self.type", OclRegistrationSeverity.Error, new String[] { "SomeDeferred" }, messageClass, types );

        ExpressionInvalidationListener listener = new ExpressionInvalidationListener( ) {

            public void notify( Collection<MRI> objectsToReEvaluate, OclExpressionRegistration registration,
        	    Connection conn ) {

                System.out.println( registration.getSeverity( ).name( ) + " Invalidated Objects: " );
                for ( MRI element : objectsToReEvaluate ) {
                    try {
                        System.out.println( "MofId: " + element.getMofId( ) + " new Value: " + registration.evaluateExpression( element ) );
                    } catch ( OclManagerException e ) {
                        e.printStackTrace( );
                    }
                }
                throw new ExpectedException( );
            }
        };
        Message msg = createMessage( conn, false, "response" );

        registration.registerEventBasedInvalidationListener( listener, false );

        msg.setType( "response" );
        msg.setType( "request" );

        try {
            srv.analyzeCollectedEvents( "SomeDeferred" );
            errorAndContinue( "ExpectedException not thrown" );
        } catch ( ExpectedException e ) {
            info( "ExpectedException thrown" );
        }

        srv.resetEvents( "SomeDeferred" );

        try {
            srv.analyzeCollectedEvents( "SomeDeferred" );
        } catch ( RuntimeException e ) {
            errorAndContinue( "Unexcpected Exception" );
        }

    }

    /**
     * @throws Exception cover all
     */
    @Test
    public void testRegistration( ) throws Exception {

        String regname = "MySpecialNameCheckerName";

        Connection conn = this.createConnection( );
        OclRegistryService srv = conn.getOclRegistryService( );
        OclFreestyleRegistry registry = srv.getFreestyleRegistry( );

        verify( !registry.getRegistrationNames( ).contains( regname ), "Registration name should not be found" );

        verify( registry.getRegistration( regname ) == null, "Registration should be null" );

        RefPackage targetPackage = conn.getPackage( TestMetaModels.SERVICE_INTERACTIONS_CN, TestMetaModels.SERVICE_INTERACTIONS_TPE );
        RefClass messageClass = targetPackage.refClass( "Message" );
        RefPackage[] types = new RefPackage[] { targetPackage };

        OclExpressionRegistration registration = registry.createExpressionRegistration( regname, "self.type", OclRegistrationSeverity.Error, new String[] { "SomeDeferred" }, messageClass, types );

        verify( registry.getRegistration( regname ) != null, "Registration should not be null" );

        verify( registry.getRegistrationNames( ).contains( regname ), "Registration name should be found" );

        verify( registration.getName( ).equals( regname ), "Name not correct" );
        verify( registration.getOclExpression( ).equals( "self.type" ), "Expression not correct" );
        verify( registration.getSeverity( ).equals( OclRegistrationSeverity.Error ), "Severity not correct" );
        verify( registration.getType( ).equals( OclRegistrationType.Expression ), "Type not correct" );
        verify( registration.getCategories( ).contains( "SomeDeferred" ), "Category not found" );

        boolean deleted = registry.deleteRegistration( regname );

        verify( registry.getRegistration( regname ) == null, "Registration should be null" );

        verify( deleted, "Deletion should have returned true" );

        deleted = registry.deleteRegistration( regname );

        verify( !deleted, "Deletion should have returned false" );

        verify( !registry.getRegistrationNames( ).contains( regname ), "Registration name should not be found" );

    }
}
