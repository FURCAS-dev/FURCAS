package com.sap.tc.moin.repository.test.ocl.integration;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.reflect.ConstraintViolationException;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;

import org.junit.Test;
import org.omg.ocl.attaching.OclConstraint;

import com.sap.company.Department;
import com.sap.company.Division;
import com.sap.company.Employee;
import com.sap.company.Freelance;
import com.sap.company.Student;
import com.sap.serviceinteractions.Message;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.events.VetoException;
import com.sap.tc.moin.repository.core.ocl.service.impl.DeferredConstraintViolationStatusItemImpl;
import com.sap.tc.moin.repository.events.type.ElementChangeEvent;
import com.sap.tc.moin.repository.events.type.LinkChangeEvent;
import com.sap.tc.moin.repository.events.type.ModelChangeEvent;
import com.sap.tc.moin.repository.ocl.OclRegistryService;
import com.sap.tc.moin.repository.ocl.debugger.OclDebuggerNode;
import com.sap.tc.moin.repository.ocl.debugger.OclDebuggerNode.NodeValueTypes;
import com.sap.tc.moin.repository.ocl.metamodel.OclMetaModelConstraintRegistration;
import com.sap.tc.moin.repository.ocl.metamodel.OclMetamodelConstraintRegistry;
import com.sap.tc.moin.repository.ocl.notification.DeferredConstraintViolationListener;
import com.sap.tc.moin.repository.ocl.notification.DeferredConstraintViolationStatus;
import com.sap.tc.moin.repository.ocl.notification.DeferredConstraintViolationStatusItem;
import com.sap.tc.moin.repository.ocl.notification.EventBasedConstraintViolationStatus;
import com.sap.tc.moin.repository.ocl.notification.EventBasedConstraintViolationStatusItem;
import com.sap.tc.moin.repository.ocl.notification.ImmediateConstraintViolationListener;
import com.sap.tc.moin.repository.ocl.notification.OclManagerException;
import com.sap.tc.moin.repository.ocl.registry.OclRegistrationCategory;
import com.sap.tc.moin.repository.shared.util.QualifiedName;
import com.sap.tc.moin.repository.spi.core.Wrapper;
import com.sap.tc.moin.repository.test.ocl.base.BaseOclIntegrationTest;
import com.sap.tc.moin.test.fw.TestMetaModels;

/**
 * Test OCL registration
 * 
 * @author d022737
 */
@SuppressWarnings( "nls" )
public class MetamodelConstraintRegistryTest extends BaseOclIntegrationTest {

    private static final String CAT_CIRCCHECK = "CircularityCheck";

    private static final String CAT_SAVE = "Save";

    private static final String VALIDASSIGNMENT = "[Company, Freelance, ValidAssignment]";

    private static final String VALIDASSIGNMENTWARNING = "[Company, Freelance, ValidAssignmentWarning]";

    private static final String BOSS10YEARSOLDEREMPLOYEE = "[Company, Employee, Boss10YearsOlderThanEmployee]";

    private static final String EXPENSESRESTRICTION = "[Company, Department, ExpensesRestriction]";

    private static final String OLDEMPLOYEE = "[Company, Department, OldEmployee]";

    private static final String SECRETARY10YEARSOLDERBOOS = "[Company, Employee, Secretary10YearsOlderThanBoss]";

    private static final String BOSSHIGHESTSALARY = "[Company, Department, BossHighestSalary]";

    private static final String MAXJUNIORS = "[Company, Department, MaxJuniors]";

    private final class ExpectedException extends VetoException {

        private static final long serialVersionUID = 1L;

        /**
         * Just internally
         */
        public ExpectedException( ) {

            super( "This was an expected one" );
        }
    }

    /**
     * Just see if the constraints are there
     * 
     * @throws Exception
     */
    private void checkServiceInteractionConstraintsFound( Connection conn ) {

        try {
            if ( this.getConstraints( conn ).isEmpty( ) ) {
                errorAndStop( "No OCL Constraints found in the metamodel, please import the ServiceInteractions metamodel with the constraints" );
            }
        } catch ( Exception e ) {
            errorAndStop( "Exception getting the OCL Constraints found from the metamodel" );
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

    private Division createDivision( Connection conn, java.lang.String name, int budget ) {

        Division division = conn.createElementInPartition( Division.class, null );
        division.setName( name );
        division.setBudget( budget );
        return division;
    }

    private Student createStudent( Connection conn, java.lang.String name, int age, int salary, com.sap.company.Employee secretary ) {

        Student student = conn.createElementInPartition( Student.class, null );
        student.setName( name );
        student.setAge( age );
        student.setSalary( salary );
        student.setSecretary( secretary );
        return student;
    }

    /**
     * Writes the content of the constraint registry
     * 
     * @throws Exception ex
     */
    @Test
    public void testShowMetamodelRegistry( ) throws Exception {

        Connection conn = null;
        try {
            conn = createConnection( );
            checkServiceInteractionConstraintsFound( conn );
            // now this is the actual test: create and delete messages and links

            OclMetamodelConstraintRegistry reg = conn.getOclRegistryService( ).getMetamodelConstraintRegistry( );

            Set<OclMetaModelConstraintRegistration> constraints = reg.getAvailableMetamodelConstraints( );

            if ( constraints.isEmpty( ) ) {
                errorAndStop( "No constraints found in the registry" );
            }

            StringBuilder out = new StringBuilder( );

            out.append( "***************************************************\n" );

            for ( OclMetaModelConstraintRegistration constraintInfo : constraints ) {
                out.append( "Name: " + constraintInfo.getName( ) + "\n" );
                out.append( "Severity: " + constraintInfo.getSeverity( ).name( ) + "\n" );
                out.append( "Expression: " + constraintInfo.getOclExpression( ) + "\n" );
                out.append( "Constrained Elements: \n" );
                for ( String el : constraintInfo.getConstrainedElements( ) ) {
                    out.append( "     " + el + "\n" );
                }
                out.append( "Qualified name: \n" );
                out.append( QualifiedName.toDotSeparatedString( constraintInfo.getQualifiedName( ) ) + "\n" );
                out.append( "Categories: \n" );
                for ( String categoriy : constraintInfo.getCategories( ) ) {
                    out.append( "      " + categoriy + "\n" );
                }
                out.append( "***************************************************\n" );
            }

            info( "\n" + out.toString( ) );

            out.setLength( 0 );

            out.append( "***************************************************\n" );

            Map<String, Set<OclMetaModelConstraintRegistration>> registry = reg.getRegistry( );

            for ( String category : registry.keySet( ) ) {
                out.append( "Category: " + category + "\n" );
                for ( OclMetaModelConstraintRegistration constraint : registry.get( category ) ) {
                    out.append( "     Constraint: " + constraint.getName( ) + "\n" );
                    out.append( "     Severity: " + constraint.getSeverity( ) + "\n" );
                }
            }
            info( "\n" + out.toString( ) );

        } finally {
            if ( conn != null ) {
                conn.close( );
            }
        }
    }

    /**
     * @throws Exception ex
     */
    @Test
    public void testMultipleRegistrations( ) throws Exception {

        Connection conn = null;
        DeferredConstraintViolationListener redListener = null;
        DeferredConstraintViolationListener yellowListener = null;
        DeferredConstraintViolationListener greenListener = null;
        DeferredConstraintViolationListener blackListener = null;
        DeferredConstraintViolationListener deferredListener = null;

        OclMetamodelConstraintRegistry reg = null;
        OclRegistryService srv = null;
        try {
            conn = this.createConnection( );
            srv = conn.getOclRegistryService( );
            reg = srv.getMetamodelConstraintRegistry( );

            redListener = createDeferredListener( new String[] { VALIDASSIGNMENT }, new String[] { VALIDASSIGNMENTWARNING } );
            yellowListener = createDeferredListener( new String[] {}, new String[] { BOSS10YEARSOLDEREMPLOYEE, VALIDASSIGNMENTWARNING } );
            greenListener = createDeferredListener( new String[] {}, new String[] {} );
            blackListener = createDeferredListener( new String[] { VALIDASSIGNMENT }, new String[] {} );
            deferredListener = createDeferredListener( new String[] { VALIDASSIGNMENT }, new String[] { BOSS10YEARSOLDEREMPLOYEE, VALIDASSIGNMENTWARNING } );

            reg.registerPartitionBasedConstraintViolationListener( "red", redListener );
            reg.registerPartitionBasedConstraintViolationListener( "green", greenListener );
            reg.registerPartitionBasedConstraintViolationListener( "yellow", yellowListener );
            reg.registerPartitionBasedConstraintViolationListener( "black", blackListener );
            reg.registerPartitionBasedConstraintViolationListener( "deferred", deferredListener );

            //CompanyPackage companyPackage = (CompanyPackage) conn.getPackage( TestMetaModels.COMPANY_CN, TestMetaModels.COMPANY_TPE );
            Division div1 = createDivision( conn, "FirstDivision", 1000000 );
            Department dep1 = createDepartment( conn, "Department1", 3, 50000 );
            Employee secretary1 = createEmployee( conn, "Moneypenny", 64, 3000, null );
            Employee boss1 = createEmployee( conn, "Bond", 52, 6000, null );
            Employee expensiveEmployee = createEmployee( conn, "Expensive", 25, 8000, null );
            Employee oldEmployee = createEmployee( conn, "Older", 48, 2800, null );

            Freelance freelance1 = createFreelance( conn, "Freelance", 18, 150, null, 55 );

            div1.getDepartment( ).add( dep1 );
            dep1.getEmployee( ).add( freelance1 );
            dep1.getEmployee( ).add( oldEmployee );
            dep1.getEmployee( ).add( expensiveEmployee );
            dep1.setBoss( boss1 );

            Set<PRI> partitions = new HashSet<PRI>( );
            partitions.add( conn.getNullPartition( ).getPri( ) );
            this.checkCategory( srv, partitions, "red" );
            this.checkCategory( srv, partitions, "green" );
            this.checkCategory( srv, partitions, "yellow" );
            this.checkCategory( srv, partitions, "black" );
            this.checkCategory( srv, partitions, "deferred" );

        } finally {
            if ( conn != null ) {
                if ( reg != null ) {
                    reg.unregisterDeferredListener( redListener );
                    reg.unregisterDeferredListener( yellowListener );
                    reg.unregisterDeferredListener( greenListener );
                    reg.unregisterDeferredListener( blackListener );
                    reg.unregisterDeferredListener( deferredListener );
                }
                conn.close( );
            }
        }

    }

    /**
     * @throws Exception ex
     */
    @Test
    public void testRefVerifyConstraintsShallow( ) throws Exception {

        this.testRefVerifyConstraints( false );
    }

    /**
     * @throws Exception ex
     */
    @Test
    public void testRefVerifyConstraintRefPackage( ) throws Exception {

        info( "Checking package 'OCL.StdLibrary'" );
        Collection<JmiException> exceptions = this.createConnection( ).getPackage( null, new String[] { "OCL", "StdLibrary" } ).refVerifyConstraints( true );
        if ( exceptions != null ) {
            for ( JmiException exception : exceptions ) {
                info( "Exception: " + exception.getMessage( ) + "MofId: " + exception.getElementInError( ).refMofId( ) );
            }
        }
    }

    /**
     * @throws Exception ex
     */
    @Test
    public void testRefVerifyConstraintsModelPackage( ) throws Exception {

        info( "Checking package 'Company'" );
        Collection<JmiException> exceptions = this.createConnection( ).getPackage( null, new String[] { "Company" } ).refVerifyConstraints( true );
        if ( exceptions != null ) {
            for ( Exception exception : exceptions ) {
                info( "Exception: " + exception.getMessage( ) );
            }
        }
        info( "Checking package 'ServiceInteractions'" );
        exceptions = this.createConnection( ).getPackage( null, new String[] { "ServiceInteractions" } ).refVerifyConstraints( true );
        if ( exceptions != null ) {
            for ( Exception exception : exceptions ) {
                info( "Exception: " + exception.getMessage( ) );
            }
        }
    }

    /**
     * @throws Exception ex
     */
    @Test
    public void testRefVerifyConstraintsDeep( ) throws Exception {

        this.testRefVerifyConstraints( true );
    }

    private void testRefVerifyConstraints( boolean deepVerify ) throws Exception {

        Connection conn = null;

        try {
            conn = this.createConnection( );

            //CompanyPackage companyPackage = (CompanyPackage) conn.getPackage( TestMetaModels.COMPANY_CN, TestMetaModels.COMPANY_TPE );
            Division div1 = createDivision( conn, "FirstDivision", 1000000 );
            Department dep1 = createDepartment( conn, "Department1", 3, 50000 );
            Employee secretary1 = createEmployee( conn, "Moneypenny", 50, 3000, null );
            Employee boss1 = createEmployee( conn, "Bond", 52, 6000, null );
            Employee director1 = createEmployee( conn, "Q", 58, 20000, secretary1 );
            Employee expensiveEmployee = createEmployee( conn, "Expensive", 25, 8000, null );
            Employee oldEmployee = createEmployee( conn, "Older", 48, 2800, null );

            Freelance freelance1 = createFreelance( conn, "Freelance", 18, 150, null, 15 );

            div1.getDepartment( ).add( dep1 );
            div1.setDirector( director1 );
            dep1.getEmployee( ).add( freelance1 );
            dep1.getEmployee( ).add( oldEmployee );
            dep1.getEmployee( ).add( secretary1 );
            dep1.getEmployee( ).add( expensiveEmployee );
            dep1.getEmployee( ).add( boss1 );
            dep1.setBoss( boss1 );

            long start = 0;
            long duration = 0;

            Collection<JmiException> exceptions;
            start = System.nanoTime( );
            exceptions = director1.refVerifyConstraints( deepVerify );
            duration = ( System.nanoTime( ) - start ) / 1000000;
            System.out.println( "Verifying Director: " + duration + " milliseconds" );
            if ( exceptions != null ) {
                for ( Exception exception : exceptions ) {
                    System.out.println( "Exception: " + exception.getMessage( ) );
                }
            }

            start = System.nanoTime( );
            exceptions = freelance1.refVerifyConstraints( deepVerify );
            duration = ( System.nanoTime( ) - start ) / 1000000;
            System.out.println( "Verifying Freelance: " + duration + " milliseconds" );
            if ( exceptions != null ) {
                for ( Exception exception : exceptions ) {
                    System.out.println( "Exception: " + exception.getMessage( ) );
                }
            }

            start = System.nanoTime( );
            exceptions = boss1.refVerifyConstraints( deepVerify );
            duration = ( System.nanoTime( ) - start ) / 1000000;
            System.out.println( "Verifying Boss: " + duration + " milliseconds" );
            if ( exceptions != null ) {
                for ( Exception exception : exceptions ) {
                    System.out.println( "Exception: " + exception.getMessage( ) );
                }
            }

            start = System.nanoTime( );
            exceptions = secretary1.refVerifyConstraints( deepVerify );
            duration = ( System.nanoTime( ) - start ) / 1000000;
            System.out.println( "Verifying Secretary: " + duration + " milliseconds" );
            if ( exceptions != null ) {
                for ( Exception exception : exceptions ) {
                    System.out.println( "Exception: " + exception.getMessage( ) );
                }
            }

            start = System.nanoTime( );
            exceptions = dep1.refVerifyConstraints( deepVerify );
            duration = ( System.nanoTime( ) - start ) / 1000000;
            System.out.println( "Verifying Department: " + duration + " milliseconds" );
            if ( exceptions != null ) {
                for ( Exception exception : exceptions ) {
                    System.out.println( "Exception: " + exception.getMessage( ) );
                }
            }

            start = System.nanoTime( );
            exceptions = div1.refVerifyConstraints( deepVerify );
            duration = ( System.nanoTime( ) - start ) / 1000000;
            System.out.println( "Verifying Division: " + duration + " milliseconds" );
            if ( exceptions != null ) {
                for ( Exception exception : exceptions ) {
                    System.out.println( "Exception: " + exception.getMessage( ) );
                }
            }

        } finally {
            if ( conn != null ) {
                conn.close( );
            }
        }
    }

    /**
     * @throws Exception ex
     */
    @Test
    public void testMultipleConstrainedElements( ) throws Exception {

        Connection conn = null;

        try {
            conn = this.createConnection( );

            //CompanyPackage companyPackage = (CompanyPackage) conn.getPackage( TestMetaModels.COMPANY_CN, TestMetaModels.COMPANY_TPE );
            Freelance free = createFreelance( conn, "testFreelance", 50, 100, null, 30 );
            Employee empl = createEmployee( conn, "testEmp", 50, 200, null );
            Student stud = createStudent( conn, "testStud", 50, 200, null );

            Set<String> messages = new HashSet<String>( );

            Collection<JmiException> exceptions = free.refVerifyConstraints( false );
            for ( JmiException ex : exceptions ) {
                messages.add( ex.getMessage( ) );
            }
            assertTrue( "Expected Freelance violation not found", messages.contains( "[Company, StudentAndFreelancesAge]" ) );

            messages.clear( );
            exceptions = stud.refVerifyConstraints( false );
            for ( JmiException ex : exceptions ) {
                messages.add( ex.getMessage( ) );
            }
            assertTrue( "Expected Student violation not found", messages.contains( "[Company, StudentAndFreelancesAge]" ) );

            messages.clear( );
            exceptions = empl.refVerifyConstraints( false );
            for ( JmiException ex : exceptions ) {
                messages.add( ex.getMessage( ) );
            }
            assertTrue( "Unexpected Employee violation found", !messages.contains( "[Company, StudentAndFreelancesAge]" ) );

        } finally {
            if ( conn != null ) {
                conn.close( );
            }
        }
    }

    /**
     * @throws Exception ex
     */
    @Test
    public void testInfoSeverity( ) throws Exception {

        Connection conn = null;

        try {
            conn = this.createConnection( );

            Department dep = createDepartment( conn, "InfoTest", 3, 500 );
            Employee free = createFreelance( conn, "Free", 18, 100, null, 1 );
            dep.getEmployee( ).add( free );

            DeferredConstraintViolationStatus stat = conn.getOclRegistryService( ).verifyConstraints( dep );
            List<DeferredConstraintViolationStatusItem> infos = stat.getInfos( );

            assertTrue( infos.size( ) == 1 );

        } finally {
            if ( conn != null ) {
                conn.close( );
            }
        }
    }


    /**
     * @throws Exception ex
     */
    @Test
    public void testVerifyConstraintsInternal( ) throws Exception {

        Connection connection = null;
        OclRegistryService srv = null;
        try {
            connection = this.createConnection( );
            srv = connection.getOclRegistryService( );

            Object sync = ( ( (Wrapper<CoreConnection>) connection ).unwrap( ) ).getSession( ).getWorkspaceSet( ).getSynchronizationManager( ).getProhibitWriteSyncObject( );
            synchronized ( sync ) {

                //CompanyPackage companyPackage = (CompanyPackage) connection.getPackage( TestMetaModels.COMPANY_CN, TestMetaModels.COMPANY_TPE );
                Division div1 = createDivision( connection, "FirstDivision", 1000000 );
                Department dep1 = createDepartment( connection, "Department1", 3, 50000 );
                Employee secretary1 = createEmployee( connection, "Moneypenny", 50, 3000, null );
                Employee boss1 = createEmployee( connection, "Bond", 52, 6000, null );
                Employee director1 = createEmployee( connection, "Q", 58, 20000, secretary1 );
                Employee expensiveEmployee = createEmployee( connection, "Expensive", 25, 8000, null );
                Employee oldEmployee = createEmployee( connection, "Older", 48, 2800, null );

                Freelance freelance1 = createFreelance( connection, "Freelance", 18, 150, null, 15 );

                div1.getDepartment( ).add( dep1 );
                div1.setDirector( director1 );
                dep1.getEmployee( ).add( freelance1 );
                dep1.getEmployee( ).add( oldEmployee );
                dep1.getEmployee( ).add( secretary1 );
                dep1.getEmployee( ).add( expensiveEmployee );
                dep1.getEmployee( ).add( boss1 );
                dep1.setBoss( boss1 );

                long start = 0;
                long duration = 0;
                DeferredConstraintViolationStatus exceptions = null;

                start = System.nanoTime( );
                exceptions = srv.verifyConstraints( director1 );
                duration = ( System.nanoTime( ) - start ) / 1000000;
                System.out.println( "Verifying Director: " + duration + " milliseconds" );
                for ( DeferredConstraintViolationStatusItem item : exceptions.getAll( ) ) {
                    System.out.println( "Exception: " + item.toString( ) + " Offending MofID: " + item.getOffendingMRI( ).getMofId( ) );
                }

                start = System.nanoTime( );
                exceptions = srv.verifyConstraints( freelance1 );
                duration = ( System.nanoTime( ) - start ) / 1000000;
                System.out.println( "Verifying Freelance: " + duration + " milliseconds" );
                for ( DeferredConstraintViolationStatusItem item : exceptions.getAll( ) ) {
                    System.out.println( "Exception: " + item.toString( ) + " Offending MofID: " + item.getOffendingMRI( ).getMofId( ) );
                }
                start = System.nanoTime( );
                exceptions = srv.verifyConstraints( boss1 );
                duration = ( System.nanoTime( ) - start ) / 1000000;
                System.out.println( "Verifying Boss: " + duration + " milliseconds" );
                for ( DeferredConstraintViolationStatusItem item : exceptions.getAll( ) ) {
                    System.out.println( "Exception: " + item.toString( ) + " Offending MofID: " + item.getOffendingMRI( ).getMofId( ) );
                }

                start = System.nanoTime( );
                exceptions = srv.verifyConstraints( secretary1 );
                duration = ( System.nanoTime( ) - start ) / 1000000;
                System.out.println( "Verifying Secretary: " + duration + " milliseconds" );
                for ( DeferredConstraintViolationStatusItem item : exceptions.getAll( ) ) {
                    System.out.println( "Exception: " + item.toString( ) + " Offending MofID: " + item.getOffendingMRI( ).getMofId( ) );
                }
            }
        } finally {
            if ( connection != null ) {
                connection.close( );
            }
        }
    }

    /**
     * @throws Exception ex
     */
    @Test
    public void testVerifyMetamodelUnderflowCheck( ) throws Exception {

        Connection conn = null;

        try {
            conn = this.createConnection( );

            //CompanyPackage cp = conn.getPackage( CompanyPackage.PACKAGE_DESCRIPTOR );
            Employee empl = conn.createElementInPartition( Employee.class, null );
            Collection<JmiException> exceptions = empl.refVerifyConstraints( false );
            if ( exceptions.isEmpty( ) ) {
                errorAndContinue( "No Exceptions thrown" );
            }

            // multiplicity should be checked
            for ( JmiException e : exceptions ) {
                if ( e.getMessage( ).equals( "No value was found for the mandatory feature \"name\"" ) ) {
                    return;
                }
            }
            errorAndStop( "Underflow should have been checked" );


            Set<PRI> partitions = new HashSet<PRI>( );
            partitions.add( conn.getNullPartition( ).getPri( ) );
            DeferredConstraintViolationListener listener = new DeferredConstraintViolationListener( ) {

                public void notify( DeferredConstraintViolationStatus violationStatus ) {

                    for ( DeferredConstraintViolationStatusItem item : violationStatus.getAll( ) ) {
                        System.out.println( "Error: " + item.getConstraintViolationMessage( ) );
                    }
                }

            };
            conn.getOclRegistryService( ).getMetamodelConstraintRegistry( ).registerPartitionBasedConstraintViolationListener( OclRegistrationCategory.deferred.name( ), listener );
            conn.getOclRegistryService( ).analyzeModelPartitions( OclRegistrationCategory.deferred.name( ), partitions );

        } finally {
            if ( conn != null ) {
                conn.close( );
            }
        }
    }

    /**
     * @throws Exception ex
     */
    @Test
    public void testMetamodelConstraintLocalization( ) throws Exception {

        Connection conn = null;

        try {
            conn = this.createConnection( );

            //CompanyPackage cp = (CompanyPackage) conn.getPackage( CompanyPackage.PACKAGE_DESCRIPTOR );
            Employee empl = conn.createElementInPartition( Employee.class, null );
            empl.setSalary( 5325 );
            Employee boss = conn.createElementInPartition( Employee.class, null );
            boss.setSalary( 7523 );
            Department dep = conn.createElementInPartition( Department.class, null );
            dep.setBudget( 300 );
            dep.getEmployee( ).add( empl );
            dep.setBoss( boss );

            dep.refVerifyConstraints( false );

            Collection<JmiException> exceptions = dep.refVerifyConstraints( false );

            for ( JmiException e : exceptions ) {
                ConstraintViolationException ce = (ConstraintViolationException) e;
                String id = ce.getViolationId( );
                if ( id.equals( EXPENSESRESTRICTION ) ) {
                    Locale previous = Locale.getDefault( );
                    Locale.setDefault( Locale.ENGLISH );
                    String message = e.getMessage( );
                    String localizedMessage = e.getLocalizedMessage( );
                    assertEquals( "The English Localized Message should be equal to the non-localized message", message, localizedMessage );
                    Locale.setDefault( Locale.GERMAN );
                    message = e.getMessage( );
                    localizedMessage = e.getLocalizedMessage( );
                    verify( !( message.equals( localizedMessage ) ), "The German Localized Message should be different from the non-localized message" );
                    Locale.setDefault( previous );
                }
            }

        } finally {
            if ( conn != null ) {
                conn.close( );
            }
        }
    }

    private void checkCategory( OclRegistryService srv, Set<PRI> partitions, String category ) throws OclManagerException {

        srv.analyzeModelPartitions( category, partitions );
    }

    /**
     * We take the "ModelEditorPrecheck" and "Save" category and register for
     * immediate event checking
     * <p>
     * Both refer to the "not circle" constraint, but ModelEditorPrecheck is a
     * warning, whereas "Save is an Error
     * 
     * @throws Exception ex
     */
    @Test
    public void testDeferredConstraintChecking( ) throws Exception {

        Connection conn = null;
        DeferredConstraintViolationListener warningListener = null;
        DeferredConstraintViolationListener warningListener2 = null;
        OclMetamodelConstraintRegistry reg = null;
        OclRegistryService srv = null;
        try {
            conn = this.createConnection( );
            srv = conn.getOclRegistryService( );
            reg = srv.getMetamodelConstraintRegistry( );

            warningListener = createDeferredListener( false, CAT_CIRCCHECK );

            warningListener2 = createDeferredListener( false, CAT_SAVE );

            reg.registerPartitionBasedConstraintViolationListener( CAT_CIRCCHECK, warningListener );
            reg.registerPartitionBasedConstraintViolationListener( CAT_SAVE, warningListener2 );

            //RefPackage targetPackage = conn.getPackage( TestMetaModels.SERVICE_INTERACTIONS_CN, TestMetaModels.SERVICE_INTERACTIONS_TPE );

            info( "************** Creating message1: " );
            Message message1 = conn.createElement( Message.class );

            info( "************** Creating message2: " );
            Message message2 = conn.createElement( Message.class );

            info( "************** Setting message1 to reply to message2: " );
            message1.setReplyTo( message2 );

            ModelPartition myPartition = conn.getNullPartition( );
            Set<PRI> partitions = new HashSet<PRI>( );
            partitions.add( myPartition.getPri( ) );

            try {
                srv.analyzeModelPartitions( CAT_CIRCCHECK, partitions );
                srv.analyzeModelPartitions( CAT_SAVE, partitions );
            } catch ( ExpectedException e ) {
                errorAndContinue( "Unexpected Exception in consistent model" );
            }

            info( "************** Setting message2 to reply to message1: " );
            message2.setReplyTo( message1 );

            try {
                srv.analyzeModelPartitions( CAT_CIRCCHECK, partitions );
                errorAndContinue( "Expected Exception not thrown" );
            } catch ( ExpectedException e ) {
                // $JL-EXC$ expected
            }
            try {
                srv.analyzeModelPartitions( CAT_SAVE, partitions );
                errorAndContinue( "Expected Exception not thrown" );
            } catch ( ExpectedException e ) {
                // $JL-EXC$ expected
            }

            info( "************** Setting message2 to reply to null: " );
            message2.setReplyTo( null );

            try {
                srv.analyzeModelPartitions( CAT_CIRCCHECK, partitions );
                srv.analyzeModelPartitions( CAT_SAVE, partitions );
            } catch ( ExpectedException e ) {
                errorAndContinue( "Unexpected Exception in consistent model" );
            }

            info( "************** Setting message2 to reply to message1: " );
            message2.setReplyTo( message1 );

            reg.unregisterDeferredListener( warningListener );

            try {
                srv.analyzeModelPartitions( CAT_CIRCCHECK, partitions );
            } catch ( ExpectedException e ) {
                errorAndContinue( "Unexpected Exception after unregistration" );
            }

            try {
                srv.analyzeModelPartitions( CAT_SAVE, partitions );
                errorAndContinue( "Expected Exception not thrown" );
            } catch ( ExpectedException e ) {
                // $JL-EXC$ ok
            }

            reg.unregisterDeferredListener( warningListener2 );

            try {
                srv.analyzeModelPartitions( CAT_CIRCCHECK, partitions );
                srv.analyzeModelPartitions( CAT_SAVE, partitions );
            } catch ( ExpectedException e ) {
                errorAndContinue( "Unexpected Exception after unregistration" );
            }

            info( "************** Deleting message1: " );
            message1.refDelete( );
            info( "************** Deleting message2: " );
            message2.refDelete( );
            info( "************** Saving connection: " );
            conn.save( );
        } finally {
            if ( conn != null ) {
                if ( reg != null ) {
                    reg.unregisterDeferredListener( warningListener );
                    reg.unregisterDeferredListener( warningListener2 );
                }
                conn.close( );
            }
        }

    }

    /**
     * @throws Exception exception
     */
    @Test
    public void testFilteredPartitionBasedConstraintChecking( ) throws Exception {

        Connection conn = null;
        OclRegistryService srv = null;
        OclMetamodelConstraintRegistry reg = null;
        try {
            conn = this.createConnection( );
            srv = conn.getOclRegistryService( );
            reg = srv.getMetamodelConstraintRegistry( );

            //RefPackage targetPackage = conn.getPackage( TestMetaModels.SERVICE_INTERACTIONS_CN, TestMetaModels.SERVICE_INTERACTIONS_TPE );

            //RefClass messageClass = targetPackage.refClass( "Message" );

            info( "************** Creating message1: " );
            Message message1 = conn.createElement( Message.class );

            info( "************** Creating message2: " );
            Message message2 = conn.createElement( Message.class );

            info( "************** Setting message1 to reply to message2: " );
            message1.setReplyTo( message2 );

            ModelPartition myPartition = conn.getNullPartition( );
            Set<PRI> partitions = new HashSet<PRI>( );
            partitions.add( myPartition.getPri( ) );

            Set<String> both = new HashSet<String>( );
            both.add( CAT_SAVE );
            both.add( CAT_CIRCCHECK );

            Set<String> save = new HashSet<String>( );
            save.add( CAT_SAVE );

            Set<String> circcheck = new HashSet<String>( );
            save.add( CAT_CIRCCHECK );


            if ( reg.verifyConstraints( partitions, both ).hasItems( ) ) {

                errorAndContinue( "Unexpected Exception in consistent model" );
            }

            message2.setReplyTo( message1 );

            if ( !reg.verifyConstraints( partitions, circcheck ).hasItems( ) ) {
                errorAndContinue( "Expected Violation not found" );
            }

            if ( !reg.verifyConstraints( partitions, save ).hasItems( ) ) {
                errorAndContinue( "Expected Violation not found" );
            }

            Set<String> categories = new HashSet<String>( );
            long durationAll = 0l;
            for ( int i = 0; i < 10; i++ ) {

                long start = System.nanoTime( );
                reg.verifyConstraints( partitions, categories );
                durationAll += ( System.nanoTime( ) - start );
            }

            info( "All checks took " + durationAll );

            categories.add( "red" );
            durationAll = 0l;
            for ( int i = 0; i < 10; i++ ) {

                long start = System.nanoTime( );
                reg.verifyConstraints( partitions, categories );
                durationAll += ( System.nanoTime( ) - start );
            }

            info( "Red checks took " + durationAll );

            message2.setReplyTo( null );

            if ( reg.verifyConstraints( partitions, both ).hasItems( ) ) {

                errorAndContinue( "Unexpected Exception in consistent model" );
            }

            message1.refDelete( );
            message2.refDelete( );
            conn.save( );
        } finally {
            if ( conn != null ) {
                conn.close( );
            }
        }

    }

    /**
     * @throws Exception ex
     */
    @Test
    public void testDeferredConstraintCheckingNoListeners( ) throws Exception {

        Connection conn = null;
        OclMetamodelConstraintRegistry reg = null;
        OclRegistryService srv = null;
        Set<String> both = new HashSet<String>( );

        both.add( CAT_CIRCCHECK );
        both.add( CAT_SAVE );

        Set<String> save = new HashSet<String>( );

        save.add( CAT_SAVE );

        Set<String> circ = new HashSet<String>( );

        circ.add( CAT_CIRCCHECK );

        try {
            conn = this.createConnection( );
            srv = conn.getOclRegistryService( );
            reg = srv.getMetamodelConstraintRegistry( );

            Message message1 = conn.createElement( Message.class );

            Message message2 = conn.createElement( Message.class );

            message1.setReplyTo( message2 );

            ModelPartition myPartition = conn.getNullPartition( );
            Set<PRI> partitions = new HashSet<PRI>( );
            partitions.add( myPartition.getPri( ) );

            if ( hasOclItems( reg.verifyConstraints( partitions, both ) ) ) {
                errorAndContinue( "Unexpected violation in consistent model" );
            }

            message2.setReplyTo( message1 );

            if ( !hasOclItems( reg.verifyConstraints( partitions, circ ) ) ) {
                errorAndContinue( "Expected violation not found" );
            }

            if ( !hasOclItems( reg.verifyConstraints( partitions, save ) ) ) {
                errorAndContinue( "Expected violation not found" );
            }

            if ( !hasOclItems( reg.verifyConstraints( partitions, new HashSet<String>( ) ) ) ) {
                errorAndContinue( "Expected violation not found" );
            }

            message2.setReplyTo( null );

            if ( hasOclItems( reg.verifyConstraints( partitions, both ) ) ) {
                errorAndContinue( "Unexpected violation in consistent model" );
            }

            message2.setReplyTo( message1 );

            message1.refDelete( );
            message2.refDelete( );

            conn.save( );
        } finally {
            if ( conn != null ) {
                conn.close( );
            }
        }

    }

    private boolean hasOclItems( DeferredConstraintViolationStatus status ) {

        for ( DeferredConstraintViolationStatusItem item : status.getAll( ) ) {
            if ( item instanceof DeferredConstraintViolationStatusItemImpl ) {
                return true;
            }
        }
        return false;
    }

    /**
     * @throws Exception ex
     */
    @Test
    public void testOclDebugger( ) throws Exception {

        Connection conn = null;
        DeferredConstraintViolationListener warningListener = null;
        OclMetamodelConstraintRegistry reg = null;
        OclRegistryService srv = null;
        try {
            conn = this.createConnection( );
            srv = conn.getOclRegistryService( );
            reg = srv.getMetamodelConstraintRegistry( );

            warningListener = new DeferredConstraintViolationListener( ) {

                public void notify( DeferredConstraintViolationStatus violationStatus ) {

                    for ( DeferredConstraintViolationStatusItem item : violationStatus.getAll( ) ) {
                        try {
                            OclDebuggerNode node = item.getDebuggerTree( );
                            assertTrue( "The Debugger Node value type is not Boolean", node.getNodeValueType( ).equals( NodeValueTypes.Boolean ) );
                        } catch ( OclManagerException e ) {
                            errorAndStop( e.getMessage( ) );
                        }
                    }

                }

            };


            reg.registerPartitionBasedConstraintViolationListener( CAT_CIRCCHECK, warningListener );
            reg.registerPartitionBasedConstraintViolationListener( CAT_SAVE, warningListener );

            //RefPackage targetPackage = conn.getPackage( TestMetaModels.SERVICE_INTERACTIONS_CN, TestMetaModels.SERVICE_INTERACTIONS_TPE );

            //RefClass messageClass = targetPackage.refClass( "Message" );

            info( "************** Creating message1: " );
            Message message1 = conn.createElement( Message.class );

            info( "************** Creating message2: " );
            Message message2 = conn.createElement( Message.class );

            info( "************** Setting message1 to reply to message2: " );
            message1.setReplyTo( message2 );

            ModelPartition myPartition = conn.getNullPartition( );
            Set<PRI> partitions = new HashSet<PRI>( );
            partitions.add( myPartition.getPri( ) );

            info( "************** Setting message2 to reply to message1: " );
            message2.setReplyTo( message1 );

            srv.analyzeModelPartitions( CAT_CIRCCHECK, partitions );
            srv.analyzeModelPartitions( CAT_SAVE, partitions );


            info( "************** Deleting message1: " );
            message1.refDelete( );
            info( "************** Deleting message2: " );
            message2.refDelete( );
            info( "************** Saving connection: " );
            conn.save( );
        } finally {
            if ( conn != null ) {
                if ( reg != null ) {
                    reg.unregisterDeferredListener( warningListener );
                }
                conn.close( );
            }
        }

    }

    private DeferredConstraintViolationListener createDeferredListener( boolean error, final String name ) {

        DeferredConstraintViolationListener listener;
        if ( error ) {
            // error listener, log warning instead of error
            listener = new DeferredConstraintViolationListener( ) {

                public void notify( DeferredConstraintViolationStatus event ) {

                    if ( !event.hasErrors( ) ) {
                        errorAndContinue( name + ": Got Deferred Warning instead of Errors" );
                        outDeferred( event.getWarnings( ) );
                    } else {
                        info( name + ": Deferred Errors detected" );
                        outDeferred( event.getErrors( ) );
                        throw new ExpectedException( );
                    }
                }

            };
        } else {
            // warning listener
            listener = new DeferredConstraintViolationListener( ) {

                public void notify( DeferredConstraintViolationStatus event ) {

                    if ( event.hasErrors( ) ) {
                        errorAndContinue( name + ": Got Deferred Errors instead of Warnings" );
                        outDeferred( event.getErrors( ) );
                    } else {
                        info( name + ": Deferred Warnings detected" );
                        outDeferred( event.getWarnings( ) );
                        throw new ExpectedException( );
                    }
                }
            };
        }
        return listener;
    }

    private DeferredConstraintViolationListener createDeferredListener( final String[] errorConstraints, final String[] warningConstraints ) {

        DeferredConstraintViolationListener listener = new DeferredConstraintViolationListener( ) {

            public void notify( DeferredConstraintViolationStatus status ) {

                this.check( status, true );
                this.check( status, false );
            }

            private void check( DeferredConstraintViolationStatus status, boolean error ) {

                String severity;
                if ( error ) {
                    severity = "Error";
                } else {
                    severity = "Warning";
                }
                Set<String> expectedConstraints = new HashSet<String>( );
                if ( error ) {
                    for ( String expectedConstraint : errorConstraints ) {
                        expectedConstraints.add( expectedConstraint );
                    }
                } else {
                    for ( String expectedConstraint : warningConstraints ) {
                        expectedConstraints.add( expectedConstraint );
                    }
                }

                Set<String> foundConstraints = new HashSet<String>( );
                List<DeferredConstraintViolationStatusItem> items;
                if ( error ) {
                    items = status.getErrors( );
                } else {
                    items = status.getWarnings( );
                }
                for ( DeferredConstraintViolationStatusItem item : items ) {
                    if ( item.oclExceptionOccurred( ) ) {
                        continue;
                    }
                    String name = item.getConstraintRegistration( ).getName( );
                    foundConstraints.add( name );
                    info( "Constraint found" );
                    if ( !expectedConstraints.contains( name ) ) {
                        errorAndContinue( "Found unexpected " + severity + ": " + name + " MRI: " + item.getOffendingMRI( ) );
                    }
                }
                for ( String expectedConstraint : expectedConstraints ) {
                    if ( !foundConstraints.contains( expectedConstraint ) ) {
                        errorAndContinue( "Expected " + severity + " not found: " + expectedConstraint );
                    }
                }
            }
        };

        return listener;
    }

    private OclMetamodelConstraintRegistry getConstraintRegistration( Connection conn ) {

        checkServiceInteractionConstraintsFound( conn );
        OclMetamodelConstraintRegistry reg;
        try {
            reg = conn.getOclRegistryService( ).getMetamodelConstraintRegistry( );
            if ( reg.getAvailableMetamodelConstraints( ).isEmpty( ) ) {
                errorAndStop( "No constraints in the registry" );
            }
            return reg;
        } catch ( OclManagerException e ) {
            errorAndStop( "Could not get the constraint registry" );
        }
        return null;
    }

    /**
     * We use the "ModelEditorPrecheck" and "Save" category and register for
     * immediate event checking
     * <p>
     * Both refer to the "not circle" constraint, but ModelEditorPrecheck is a
     * warning, whereas "Save is an Error
     * 
     * @throws Exception ex
     */
    @Test
    public void testExplicitImmediateConstraintChecking( ) throws Exception {

        Connection conn = null;

        ImmediateConstraintViolationListener warningListener = null;
        OclMetamodelConstraintRegistry reg = null;
        try {
            conn = createConnection( );
            // now this is the actual test: create and delete messages and links

            reg = getConstraintRegistration( conn );

            warningListener = createImmediateListener( false, CAT_CIRCCHECK );

            // RefPackage targetPackage = conn.getPackage( TestMetaModels.SERVICE_INTERACTIONS_CN, TestMetaModels.SERVICE_INTERACTIONS_TPE );
            // RefClass messageClass = targetPackage.refClass( "Message" );

            info( "************** Creating message1: " );
            Message message1 = conn.createElement( Message.class );

            info( "************** Creating message2: " );
            Message message2 = conn.createElement( Message.class );

            info( "************** Setting message1 to reply to message2: " );
            message1.setReplyTo( message2 );
            // no registration, should not throw the Exception
            try {
                message2.setReplyTo( message1 );
            } catch ( ExpectedException e ) {
                errorAndContinue( "Unexpected Exception received before explicitly registering listener" );
            }
            message2.setReplyTo( null );

            reg.registerImmediateConstraintViolationListener( CAT_CIRCCHECK, warningListener );
            try {
                info( "************** Setting message2 to reply to message1: " );
                message2.setReplyTo( message1 );
                errorAndContinue( "Expected Exception not thrown after registering Error listener" );
            } catch ( ExpectedException e ) {
                info( "Expected Exception thrown" );
            }
            try {
                message2.setReplyTo( null );
            } catch ( ExpectedException e ) {
                info( "Expected Exception thrown" );
            }

            reg.unregisterImmediateListener( warningListener );
            // no registration, should not throw the Exception
            try {
                info( "************** Setting message2 to reply to message1: " );
                message2.setReplyTo( message1 );
            } catch ( ExpectedException e ) {
                errorAndContinue( "Unexpected Exception received after unregistering Error listener" );
            }
            message2.setReplyTo( null );

            reg.registerImmediateConstraintViolationListener( CAT_CIRCCHECK, warningListener );

            try {
                info( "************** Setting message2 to reply to message1: " );
                message2.setReplyTo( message1 );
                errorAndContinue( "Expected Exception not thrown after registering Warning listener" );
            } catch ( ExpectedException e ) {
                info( "Expected Exception thrown" );
            }

            try {
                message2.setReplyTo( null );
            } catch ( ExpectedException e ) {
                info( "Expected Exception thrown" );
            }

            reg.unregisterImmediateListener( warningListener );
            // no registration, should not throw the Exception
            try {
                info( "************** Setting message2 to reply to message1: " );
                message2.setReplyTo( message1 );
            } catch ( ExpectedException e ) {
                errorAndContinue( "Unexpected Exception received after unregistering Warning listener" );
            }
            message2.setReplyTo( null );

            info( "************** Deleting message1: " );
            message1.refDelete( );
            info( "************** Deleting message2: " );
            message2.refDelete( );
            System.out.println( "************** Saving connection: " );
            conn.save( );
        } finally {
            if ( conn != null ) {
                if ( reg != null ) {
                    reg.unregisterImmediateListener( warningListener );
                }
                conn.close( );
            }
        }

    }

    private ImmediateConstraintViolationListener createImmediateListener( boolean error, final String name ) {

        ImmediateConstraintViolationListener listener;
        if ( error ) {
            listener = new ImmediateConstraintViolationListener( ) {

                public void notify( EventBasedConstraintViolationStatus event ) {

                    if ( !event.hasErrors( ) ) {
                        errorAndContinue( name + ": Got Immediate Warnings instead of Errors" );
                        outImmediate( event.getWarnings( ) );
                    } else {
                        info( name + ": Deferred Errors detected" );
                        outImmediate( event.getWarnings( ) );
                        throw new ExpectedException( );
                    }
                }

            };
        } else {
            listener = new ImmediateConstraintViolationListener( ) {

                public void notify( EventBasedConstraintViolationStatus event ) {

                    if ( event.hasErrors( ) ) {
                        errorAndContinue( name + ": Got Immediate Errors instead of Warnings" );
                        outImmediate( event.getErrors( ) );
                    } else {
                        info( name + ": Deferred Warnings detected" );
                        outImmediate( event.getWarnings( ) );
                        throw new ExpectedException( );
                    }
                }
            };
        }

        return listener;
    }

    /**
     * This tests the implicit, immediate constraint checking
     * <p>
     * The immediate constraint is that a message can not reply to itself. When
     * trying to set a message to reply to itself, a VetoException is thrown.
     * Later on, this must be handled in a different way (by reverting the
     * change, for example)
     * 
     * @throws Exception
     */
    // TODO implicit immediate constraints not supported
    // @Test public void testImplicitImmediateConstraintChecking() throws Exception {
    // Connection conn = null;
    // try {
    // conn = createConnection();
    //
    // RefPackage targetPackage = conn.getPackage(null, new String[] { "ServiceInteractions" });
    // RefClass messageClass = targetPackage.refClass("Message");
    //
    // info("************** Creating message1: ");
    // Message message1 = (Message) messageClass.refCreateInstance(Collections.EMPTY_LIST);
    //
    // info("************** Creating message2: ");
    // Message message2 = (Message) messageClass.refCreateInstance(Collections.EMPTY_LIST);
    //
    // info("************** Setting message1 to reply to itself: ");
    // try {
    // message1.setReplyTo(message1);
    // flop("This should have been vetoed");
    // } catch (VetoException e) {
    // info("Veto received properly");
    // }
    //
    // info("************** Setting message1 to reply to message2: ");
    // try {
    // message1.setReplyTo(message2);
    // } catch (VetoException e1) {
    // flop("Unexpected VetoException");
    // }
    // info("************** Resetting message1 to reply to itself: ");
    // try {
    // message1.setReplyTo(message1);
    // flop("This should have been vetoed");
    // } catch (VetoException e) {
    // info("Veto received properly");
    // }
    //
    // info("************** Resetting message2 to reply to itself: ");
    // try {
    // message2.setReplyTo(message2);
    // flop("This should have been vetoed");
    // } catch (VetoException e) {
    // info("Veto received properly");
    // }
    //
    // info("************** Deleting message1: ");
    // message1.refDelete();
    // info("************** Deleting message2: ");
    // message2.refDelete();
    // info("************** Saving connection: ");
    // conn.save();
    // } finally {
    // if (conn != null) {
    // conn.close();
    // }
    // }
    //
    // }
    /**
     * @throws Exception ex
     */
    @Test
    public void testDeferredEventBasedConstraintChecking( ) throws Exception {

        Connection conn = null;
        OclRegistryService srv = null;
        OclMetamodelConstraintRegistry reg = null;
        try {
            conn = createConnection( );
            srv = conn.getOclRegistryService( );
            reg = srv.getMetamodelConstraintRegistry( );
            // now this is the actual test: create and delete messages and links

            DeferredConstraintViolationListener circcheck = createDeferredListener( false, "Circularity" );
            DeferredConstraintViolationListener save = createDeferredListener( false, "Save" );

            reg.registerDeferredConstraintViolationListenerForEvents( CAT_CIRCCHECK, circcheck );
            reg.registerDeferredConstraintViolationListenerForEvents( CAT_SAVE, save );

            //RefPackage targetPackage = conn.getPackage( TestMetaModels.SERVICE_INTERACTIONS_CN, TestMetaModels.SERVICE_INTERACTIONS_TPE );

            //RefClass messageClass = targetPackage.refClass( "Message" );

            info( "************** Creating message1: " );
            Message message1 = conn.createElement( Message.class );

            info( "************** Creating message2: " );
            Message message2 = conn.createElement( Message.class );

            info( "************** Setting message1 to reply to message2: " );
            message1.setReplyTo( message2 );

            srv.analyzeCollectedEvents( CAT_CIRCCHECK );
            srv.analyzeCollectedEvents( CAT_SAVE );

            info( "************** Setting message2 to reply to message1: " );
            message2.setReplyTo( message1 );

            try {
                srv.analyzeCollectedEvents( CAT_CIRCCHECK );
                errorAndContinue( "First circularity check should have been vetoed" );
            } catch ( VetoException e ) {
                info( "Expected veto received" );
            }
            try {
                srv.analyzeCollectedEvents( CAT_SAVE );
                errorAndContinue( "First save check should have been vetoed" );
            } catch ( VetoException e ) {
                info( "Expected veto received" );
            }

            srv.resetEvents( CAT_CIRCCHECK );

            try {
                srv.analyzeCollectedEvents( CAT_CIRCCHECK );
            } catch ( VetoException e ) {
                errorAndContinue( "Unexpected veto after resetting circularity check" );
            }

            try {
                srv.analyzeCollectedEvents( CAT_SAVE );
                errorAndContinue( "Second save check should have been vetoed" );
            } catch ( VetoException e ) {
                info( "Expected veto received" );
            }

            srv.resetEvents( CAT_SAVE );

            try {
                srv.analyzeCollectedEvents( CAT_CIRCCHECK );
            } catch ( VetoException e ) {
                errorAndContinue( "Unexpected cirularity veto after resetting save" );
            }
            try {
                srv.analyzeCollectedEvents( CAT_SAVE );
            } catch ( VetoException e ) {
                errorAndContinue( "Unexpected save veto after resetting save" );
            }

            reg.unregisterDeferredListener( circcheck );
            reg.unregisterDeferredListener( save );

            info( "************** Deleting message1: " );
            message1.refDelete( );
            info( "************** Deleting message2: " );
            message2.refDelete( );
            System.out.println( "************** Saving connection: " );
            // TODO we still create unwanted objects in the transient partition, so save doesn't work
            conn.save( );
        } finally {
            if ( conn != null ) {
                conn.close( );
            }
        }

    }

    @SuppressWarnings( "unchecked" )
    private Set<OclConstraint> getConstraints( Connection connection ) throws Exception {

        Collection<OclConstraint> result = (Collection) connection.getPackage( TestMetaModels.MOIN_MOF_CN, new String[] { "OCL", "Attaching" } ).refClass( "OclConstraint" ).refAllOfClass( );
        // RefPackage pkg = result.get(0).refImmediatePackage();
        // pkg.refAllAssociations();
        Set<OclConstraint> resultset = new HashSet<OclConstraint>( );
        resultset.addAll( result );
        return resultset;
    }

    void outImmediate( List<EventBasedConstraintViolationStatusItem> itemList ) {

        for ( EventBasedConstraintViolationStatusItem item : itemList ) {
            info( "Constraint: " + item.getConstraintRegistration( ).getName( ) + " Offending MRI: " + item.getOffendingMRI( ) );
            ModelChangeEvent mce = item.getOffendingChangeEvent( );
            if ( mce instanceof ElementChangeEvent ) {
                info( " Element change event, MRI of changed elements: " + ( (ElementChangeEvent) mce ).getAffectedElementMri( ) );
            } else if ( mce instanceof LinkChangeEvent ) {
                info( " Link change event, IDs of changed elements: " + ( (LinkChangeEvent) mce ).getStoredLinkEndMri( ) + "<->" + ( (LinkChangeEvent) mce ).getNonStoredLinkEndLri( ) );
            } else {
                info( "Other event: " + item.toString( ) );
            }
        }
    }

    void outDeferred( List<DeferredConstraintViolationStatusItem> itemList ) {

        for ( DeferredConstraintViolationStatusItem item : itemList ) {
            info( "Constraint: " + item.getConstraintRegistration( ).getName( ) + " Offending MRI: " + item.getOffendingMRI( ) );
        }
    }
}
