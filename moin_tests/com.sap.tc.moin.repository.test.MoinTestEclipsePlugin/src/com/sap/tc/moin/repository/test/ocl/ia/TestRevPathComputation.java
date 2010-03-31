package com.sap.tc.moin.repository.test.ocl.ia;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.reflect.RefFeatured;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sap.company.Department;
import com.sap.company.Division;
import com.sap.company.Employee;
import com.sap.company.Freelance;
import com.sap.company.__impl.DepartmentImpl;
import com.sap.company.__impl.DivisionImpl;
import com.sap.company.__impl.EmployeeImpl;
import com.sap.company.__impl.FreelanceImpl;
import com.sap.tc.moin.ocl.ia.ImpactAnalyzer;
import com.sap.tc.moin.ocl.ia.result.EvaluationUnit;
import com.sap.tc.moin.ocl.ia.result.InstanceSet;
import com.sap.tc.moin.ocl.utils.OclStatement;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.core.JmiList;
import com.sap.tc.moin.repository.core.ocl.service.impl.EvaluationHelper;
import com.sap.tc.moin.repository.events.type.LinkAddEvent;
import com.sap.tc.moin.repository.events.type.LinkRemoveEvent;
import com.sap.tc.moin.repository.events.type.ModelChangeEvent;
import com.sap.tc.moin.repository.test.ocl.ia.helper.BaseDepartmentTest;
import com.sap.tc.moin.repository.test.ocl.ia.mockobjects.AttributeValueChangeEventImpl;
import com.sap.tc.moin.repository.test.ocl.ia.mockobjects.LinkAddEventImpl;
import com.sap.tc.moin.repository.test.ocl.ia.mockobjects.LinkRemoveEventImpl;
import com.sap.tc.moin.repository.test.ocl.ia.mockobjects.MRIImpl;

/**
 * Tests whether the right context instances are computed. This is done as
 * follows: A simple instance of the company model is created. Each test tests
 * only one statement. The statement is analyzed and a set of relevant events is
 * generated and reported to IA. The resulting EvaluationUnits are then put into
 * the evaluator to compute the affected context instances. This set is then
 * compared to a set of expected context instances.
 * 
 * @author d039141
 */
public class TestRevPathComputation extends BaseDepartmentTest {

    private DivisionImpl div;

    private DepartmentImpl dep1;

    private DepartmentImpl dep2;

    private EmployeeImpl e1;

    private FreelanceImpl e2;

    private EmployeeImpl e3;

    private FreelanceImpl e4;

    private EmployeeImpl boss1;

    private EmployeeImpl boss2;

    private EmployeeImpl director;

    private EmployeeImpl secretary;

    private Map<RefObject, MRI> linkEnds = new HashMap<RefObject, MRI>( );

    /*
     * (non-Javadoc)
     * @see com.sap.tc.jtools.jver.framework.Test#prepare()
     */
    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );
        createInstances( );
    }

    /**
     * Creates an instance of the company model ie 2 instances of Department
     * with e employees and one boss each.
     */
    private void createInstances( ) {

        synchronized ( this.syncObjectForWrite ) {
            Division wrappedDivision = coreConnection.getWrapper( ).createElementInPartition( Division.class, null );
            this.div = (DivisionImpl) getTestHelper( ).getCorePartitionable( wrappedDivision );
            this.div.setBudget( coreConnection, 1234567 );
            this.div.setName( coreConnection, "Div1" );

            Employee wrappedDirector = coreConnection.getWrapper( ).createElementInPartition( Employee.class, null );
            this.director = (EmployeeImpl) getTestHelper( ).getCorePartitionable( wrappedDirector );
            this.director.setAge( coreConnection, 42 );
            this.director.setName( coreConnection, "Director" );
            this.director.setDirected( coreConnection, this.div );
            this.director.setSalary( coreConnection, 1234 );
            this.div.setDirector( coreConnection, this.director );

            Employee wrappedSecretary = coreConnection.getWrapper( ).createElementInPartition( Employee.class, null );
            this.secretary = (EmployeeImpl) getTestHelper( ).getCorePartitionable( wrappedSecretary );
            this.secretary.setAge( coreConnection, 55 );
            this.secretary.setName( coreConnection, "Secretary" );
            this.secretary.setSalary( coreConnection, 1234 );
            this.director.setSecretary( coreConnection, this.secretary );

            Department wrappedDep1 = coreConnection.getWrapper( ).createElementInPartition( Department.class, null );
            this.dep1 = (DepartmentImpl) getTestHelper( ).getCorePartitionable( wrappedDep1 );
            this.dep1.setName( coreConnection, "Dep1" );
            this.dep1.setBudget( coreConnection, 12345567 );
            this.dep1.setMaxJuniors( coreConnection, 5 );
            Employee wrappedE1 = coreConnection.getWrapper( ).createElementInPartition( Employee.class, null );
            this.e1 = (EmployeeImpl) getTestHelper( ).getCorePartitionable( wrappedE1 );
            this.e1.setAge( coreConnection, 42 );
            this.e1.setName( coreConnection, "e1" );
            this.e1.setEmployer( coreConnection, this.dep1 );
            this.e1.setSalary( coreConnection, 1234 );
            Freelance wrappedE2 = coreConnection.getWrapper( ).createElementInPartition( Freelance.class, null );
            this.e2 = (FreelanceImpl) getTestHelper( ).getCorePartitionable( wrappedE2 );
            this.e2.setAge( coreConnection, 42 );
            this.e2.setName( coreConnection, "e2" );
            this.e2.setAssignment( coreConnection, 9 );
            this.e2.setEmployer( coreConnection, this.dep1 );
            this.e2.setSalary( coreConnection, 1234 );
            Employee wrappedBoss1 = coreConnection.getWrapper( ).createElementInPartition( Employee.class, null );
            this.boss1 = (EmployeeImpl) getTestHelper( ).getCorePartitionable( wrappedBoss1 );
            this.boss1.setAge( coreConnection, 43 );
            this.boss1.setName( coreConnection, "boss1" );
            this.boss1.setEmployer( coreConnection, this.dep1 );
            this.boss1.setManaged( coreConnection, this.dep1 );
            this.boss1.setSalary( coreConnection, 1234 );

            this.e1.setEmployer( coreConnection, dep1 );
            this.e2.setEmployer( coreConnection, dep1 );
            this.boss1.setEmployer( coreConnection, dep1 );
            this.dep1.setBoss( coreConnection, this.boss1 );

            Department wrappedDep2 = coreConnection.getWrapper( ).createElementInPartition( Department.class, null );
            this.dep2 = (DepartmentImpl) getTestHelper( ).getCorePartitionable( wrappedDep2 );
            this.dep2.setName( coreConnection, "Dep2" );
            this.dep2.setBudget( coreConnection, 12345567 );
            this.dep2.setMaxJuniors( coreConnection, 5 );

            Employee wrappedE3 = coreConnection.getWrapper( ).createElementInPartition( Employee.class, null );
            this.e3 = (EmployeeImpl) getTestHelper( ).getCorePartitionable( wrappedE3 );
            this.e3.setAge( coreConnection, 42 );
            this.e3.setName( coreConnection, "e3" );
            this.e3.setEmployer( coreConnection, this.dep2 );
            this.e3.setSalary( coreConnection, 1234 );
            Freelance wrappedE4 = coreConnection.getWrapper( ).createElementInPartition( Freelance.class, null );
            this.e4 = (FreelanceImpl) getTestHelper( ).getCorePartitionable( wrappedE4 );
            this.e4.setAge( coreConnection, 42 );
            this.e4.setName( coreConnection, "e4" );
            this.e2.setAssignment( coreConnection, 9 );
            this.e4.setEmployer( coreConnection, this.dep2 );
            this.e4.setSalary( coreConnection, 1234 );
            Employee wrappedBoss2 = coreConnection.getWrapper( ).createElementInPartition( Employee.class, null );
            this.boss2 = (EmployeeImpl) getTestHelper( ).getCorePartitionable( wrappedBoss2 );
            this.boss2.setAge( coreConnection, 43 );
            this.boss2.setName( coreConnection, "boss2" );
            this.boss2.setEmployer( coreConnection, this.dep2 );
            this.boss2.setManaged( coreConnection, this.dep2 );
            this.boss2.setSalary( coreConnection, 1234 );

            this.e3.setEmployer( coreConnection, dep2 );
            this.e4.setEmployer( coreConnection, dep2 );
            this.boss2.setEmployer( coreConnection, dep2 );

            this.dep2.setBoss( coreConnection, this.boss2 );

            ( (JmiList) this.div.getDepartment( coreConnection ) ).add( coreConnection, this.dep1 );
            ( (JmiList) this.div.getDepartment( coreConnection ) ).add( coreConnection, this.dep2 );
        }
    }

    /**
     * @throws Exception
     */
    @Test
    public void testBossHighestSalary( ) throws Exception {

        // context Department inv BossHighestSalary:
        // self.employee->select(
        // e|e.salary >= self.boss.salary)->size() <= 1
        this.info( "\n--------------------------------------------------\n" );
        this.info( "Testing BossHighestSalary\n" );
        this.info( "--------------------------------------------------\n" );
        Set<OclStatement> stmts = new HashSet<OclStatement>( );
        ModelChangeEvent evt;
        Set<RefObject> expectedInstances = new HashSet<RefObject>( );
        expectedInstances.add( this.dep1 );

        stmts.add( this.bossHighestSalaryAST );
        ImpactAnalyzer ia = new ImpactAnalyzer( false );

        synchronized ( this.syncObjectForWrite ) {
            ia.analyze( stmts, this.myJmiCreator );
        }

        // change salary of an employee
        evt = new AttributeValueChangeEventImpl( coreConnection, this.e1, this.employeeSalary, new Integer( this.e1.getSalary( ) ), new Integer( this.e1.getSalary( ) ) );
        Collection<RefObject> instances = compAffectedInstances( ia, evt );
        compareInstances( instances, new RefObject[] { this.dep1 } );

        // change salary of the boss
        evt = new AttributeValueChangeEventImpl( coreConnection, this.boss1, this.employeeSalary, new Integer( this.boss1.getSalary( ) ), new Integer( this.boss1.getSalary( ) ) );
        instances = compAffectedInstances( ia, evt );
        compareInstances( instances, new RefObject[] { this.dep1 } );

        // add new employee
        evt = this.createLinkAddEvent( this.dep1, this.e1, this.employeeRef.getReferencedEnd( coreConnection ) );
        instances = compAffectedInstances( ia, evt );
        compareInstances( instances, new RefObject[] { this.dep1 } );

        // add new boss
        evt = this.createLinkAddEvent( this.dep1, this.boss1, this.bossRef.getReferencedEnd( coreConnection ) );
        instances = compAffectedInstances( ia, evt );
        compareInstances( instances, new RefObject[] { this.dep1 } );
        this.info( "Done\n" );
        this.info( "--------------------------------------------------\n" );
    }

    /**
     * @throws Exception
     */
    @Test
    public void testBossIsOldest( ) throws Exception {

        // context Employee inv BossIsOldest:
        // self.age <= self.employer.boss.age
        this.info( "\n--------------------------------------------------\n" );
        this.info( "Testing BossIsOldest\n" );
        this.info( "--------------------------------------------------\n" );
        Set<OclStatement> stmts = new HashSet<OclStatement>( );

        Set<RefObject> expectedInstances = new HashSet<RefObject>( );
        expectedInstances.add( this.e2 );

        stmts.add( this.bossIsOldestAST );
        ImpactAnalyzer ia = new ImpactAnalyzer( false );
        synchronized ( this.syncObjectForWrite ) {
            ia.analyze( stmts, this.myJmiCreator );
        }

        // change age of an employee
        ModelChangeEvent evt = new AttributeValueChangeEventImpl( coreConnection, this.e2, this.employeeAge, new Integer( this.e2.getAge( ) ), new Integer( this.e2.getAge( ) ) );
        Collection<RefObject> instances = compAffectedInstances( ia, evt );
        compareInstances( instances, new RefObject[] { this.e2 } );

        // change age of the boss
        expectedInstances = new HashSet<RefObject>( );
        expectedInstances.add( this.e1 );
        expectedInstances.add( this.e2 );
        expectedInstances.add( this.boss1 );
        evt = new AttributeValueChangeEventImpl( coreConnection, this.boss1, this.employeeAge, new Integer( this.boss1.getAge( ) ), new Integer( this.boss1.getAge( ) ) );
        instances = compAffectedInstances( ia, evt );
        compareInstances( instances, new RefObject[] { this.e1, this.e2, this.boss1 } );

        // add new employee
        evt = this.createLinkAddEvent( this.e1, this.dep1, this.employerRef.getReferencedEnd( coreConnection ) );
        instances = compAffectedInstances( ia, evt );
        compareInstances( instances, new RefObject[] { this.e1 } );

        // add new boss
        evt = this.createLinkAddEvent( this.dep1, this.boss1, this.bossRef.getReferencedEnd( coreConnection ) );
        instances = compAffectedInstances( ia, evt );
        compareInstances( instances, new RefObject[] { this.e1, this.e2, this.boss1 } );
        this.info( "Done\n" );
        this.info( "--------------------------------------------------\n" );
    }

    /**
     * @throws Exception
     */
    @Test
    public void testNotBossFreelance( ) throws Exception {

        // context Department
        // inv NotBossFreelance:
        // not self.boss.oclIsTypeOf(Freelance)
        this.info( "\n--------------------------------------------------\n" );
        this.info( "Testing NotBossFreelance\n" );
        this.info( "--------------------------------------------------\n" );
        Set<OclStatement> stmts = new HashSet<OclStatement>( );
        ModelChangeEvent evt = null;

        stmts.add( this.notBossFreelanceAST );
        ImpactAnalyzer ia = new ImpactAnalyzer( false );
        synchronized ( this.syncObjectForWrite ) {
            ia.analyze( stmts, this.myJmiCreator );
        }
        // add new boss
        evt = this.createLinkAddEvent( this.dep2, this.boss2, this.bossRef.getReferencedEnd( coreConnection ) );
        Collection<RefObject> instances = compAffectedInstances( ia, evt );
        compareInstances( instances, new RefObject[] { this.dep2 } );
        this.info( "Done\n" );
        this.info( "--------------------------------------------------\n" );
    }

    /**
     * @throws Exception
     */
    @Test
    public void testOldEmployee( ) throws Exception {

        // context Department
        // inv OldEmployee:
        // self.employee->exists(e | e.age > 45)
        this.info( "\n--------------------------------------------------\n" );
        this.info( "Testing OldEmployee\n" );
        this.info( "--------------------------------------------------\n" );
        Set<OclStatement> stmts = new HashSet<OclStatement>( );

        stmts.add( this.oldEmployeeAST );
        ImpactAnalyzer ia = new ImpactAnalyzer( false );
        synchronized ( this.syncObjectForWrite ) {
            ia.analyze( stmts, this.myJmiCreator );
        }
        // change age of an employee
        ModelChangeEvent evt = new AttributeValueChangeEventImpl( coreConnection, this.e2, this.employeeAge, new Integer( this.e2.getAge( ) ), new Integer( this.e2.getAge( ) ) );
        Collection<RefObject> instances = compAffectedInstances( ia, evt );
        compareInstances( instances, new RefObject[] { this.dep1 } );

        // change age of the boss
        evt = new AttributeValueChangeEventImpl( coreConnection, this.boss1, this.employeeAge, new Integer( this.boss1.getAge( ) ), new Integer( this.boss1.getAge( ) ) );
        instances = compAffectedInstances( ia, evt );
        compareInstances( instances, new RefObject[] { this.dep1 } );

        // add new employee
        evt = this.createLinkAddEvent( this.dep1, this.e1, this.employeeRef.getReferencedEnd( coreConnection ) );
        instances = compAffectedInstances( ia, evt );
        compareInstances( instances, new RefObject[] { this.dep1 } );
        this.info( "Done\n" );
        this.info( "--------------------------------------------------\n" );
    }

    /**
     * @throws Exception
     */
    @Test
    public void testUniqueNames( ) throws Exception {

        // context Employee
        // inv UniqueNames:
        // Employee.allInstances()->forAll(e |
        // e <> self implies e.name <> self.name)
        this.info( "\n--------------------------------------------------\n" );
        this.info( "Testing UniqueNames\n" );
        this.info( "--------------------------------------------------\n" );
        Set<OclStatement> stmts = new HashSet<OclStatement>( );

        stmts.add( this.uniqueNamesAST );
        ImpactAnalyzer ia = new ImpactAnalyzer( false );
        synchronized ( this.syncObjectForWrite ) {
            ia.analyze( stmts, this.myJmiCreator );
        }

        // change name of an employee
        ModelChangeEvent evt = new AttributeValueChangeEventImpl( coreConnection, this.e2, this.employeeName, this.e2.getName( ), this.e2.getName( ) );
        Collection<RefObject> instances = compAffectedInstances( ia, evt );
        compareInstances( instances, new RefObject[] { this.e1, this.e2, this.e3, this.e4, this.boss1, this.boss2, this.director, this.secretary } );
        this.info( "Done\n" );
        this.info( "--------------------------------------------------\n" );
    }

    /**
     * @throws Exception
     */
    @Test
    public void testValidAssignment( ) throws Exception {

        // context Freelance
        // inv ValidAssignment:
        // self.assignment >= 5 and self.assignment <= 30
        this.info( "\n--------------------------------------------------\n" );
        this.info( "Testing ValidAssignment\n" );
        this.info( "--------------------------------------------------\n" );
        Set<OclStatement> stmts = new HashSet<OclStatement>( );
        stmts.add( this.validAssignmentAST );

        ImpactAnalyzer ia = new ImpactAnalyzer( false );
        synchronized ( this.syncObjectForWrite ) {
            ia.analyze( stmts, this.myJmiCreator );
        }

        // change age of an employee
        ModelChangeEvent evt = new AttributeValueChangeEventImpl( coreConnection, this.e4, this.freelanceAssignment, new Integer( this.e4.getAssignment( ) ), new Integer( this.e4.getAssignment( ) ) );
        Collection<RefObject> instances = compAffectedInstances( ia, evt );
        compareInstances( instances, new RefObject[] { this.e4 } );
        this.info( "Done\n" );
        this.info( "--------------------------------------------------\n" );

    }

    /**
     * @throws Exception
     */
    @Test
    public void testMaxJuniors( ) throws Exception {

        // context Department inv MaxJuniors:
        // self.employee->select(e|e.age < 25)->size() < self.maxJuniors
        this.info( "\n--------------------------------------------------\n" );
        this.info( "Testing MaxJuniors\n" );
        this.info( "--------------------------------------------------\n" );
        Set<OclStatement> stmts = new HashSet<OclStatement>( );
        stmts.add( this.maxJuniorsAST );

        ImpactAnalyzer ia = new ImpactAnalyzer( false );
        synchronized ( this.syncObjectForWrite ) {
            ia.analyze( stmts, this.myJmiCreator );
        }

        // change age of an employee
        ModelChangeEvent evt = new AttributeValueChangeEventImpl( coreConnection, this.e2, this.employeeAge, new Integer( this.e2.getAge( ) ), new Integer( this.e2.getAge( ) ) );
        Collection<RefObject> instances = compAffectedInstances( ia, evt );
        compareInstances( instances, new RefObject[] { this.dep1 } );

        // change maxJuniors of a Department
        evt = new AttributeValueChangeEventImpl( coreConnection, this.dep1, this.departmentMaxJuniors, new Integer( this.dep1.getMaxJuniors( ) ), new Integer( this.dep1.getMaxJuniors( ) ) );
        instances = compAffectedInstances( ia, evt );
        compareInstances( instances, new RefObject[] { this.dep1 } );

        // add new employee
        evt = this.createLinkAddEvent( this.dep1, this.e1, this.employeeRef.getReferencedEnd( coreConnection ) );
        instances = compAffectedInstances( ia, evt );
        compareInstances( instances, new RefObject[] { this.dep1 } );

        this.info( "Done\n" );
        this.info( "--------------------------------------------------\n" );

    }

    /**
     * @param instances
     * @param expectedInstances
     */
    private void compareInstances( Collection<RefObject> instances, RefObject[] expectedInstances ) {

        Set<RefObject> expected = new HashSet<RefObject>( );
        for ( int i = 0; i < expectedInstances.length; i++ ) {
            expected.add( expectedInstances[i] );
        }

        if ( instances.containsAll( expected ) && instances.size( ) == expected.size( ) ) {
            this.info( ">> SUCCESS exact match\n" );
        } else if ( instances.containsAll( expected ) && instances.size( ) != expected.size( ) ) {
            this.info( ">> SUCCESS \n" );
            this.info( "excess context instances:\n" );
            instances.removeAll( expected );
            for ( Iterator<RefObject> i = instances.iterator( ); i.hasNext( ); ) {
                this.info( i.next( ) + "\n" );
            }
        } else {
            this.info( ">> FAILURE\n" );
            flop( "Returned instances does not match expected instances!" );
        }
    }

    /**
     * @throws Exception
     */
    @Test
    public void testNastyConstraint( ) throws Exception {

        // context Division
        // inv nasty:
        // self.department->collect(d|
        // d.employee->including(d.boss)).salary->sum() < budget";
        this.info( "\n--------------------------------------------------\n" );
        this.info( "Testing nasty\n" );
        this.info( "--------------------------------------------------\n" );
        Set<OclStatement> stmts = new HashSet<OclStatement>( );

        stmts.add( this.nastyConstraintAST );
        ImpactAnalyzer ia = new ImpactAnalyzer( false );
        synchronized ( this.syncObjectForWrite ) {
            ia.analyze( stmts, this.myJmiCreator );
        }

        // add new department
        ModelChangeEvent evt = this.createLinkAddEvent( this.div, this.dep1, this.departmentRef.getReferencedEnd( coreConnection ) );
        Collection<RefObject> instances = compAffectedInstances( ia, evt );
        compareInstances( instances, new RefObject[] { this.div } );

        // add new employee
        evt = this.createLinkAddEvent( this.dep1, this.e1, this.employeeRef.getReferencedEnd( coreConnection ) );
        instances = compAffectedInstances( ia, evt );
        compareInstances( instances, new RefObject[] { this.div } );

        // add new boss
        evt = this.createLinkAddEvent( this.dep1, this.boss2, this.bossRef.getReferencedEnd( coreConnection ) );
        instances = compAffectedInstances( ia, evt );
        compareInstances( instances, new RefObject[] { this.div } );

        // change salary of an employee
        evt = new AttributeValueChangeEventImpl( coreConnection, this.e1, this.employeeSalary, new Integer( this.e1.getSalary( ) ), new Integer( this.e1.getSalary( ) ) );
        instances = compAffectedInstances( ia, evt );
        compareInstances( instances, new RefObject[] { this.div } );

        // change salary of the boss
        evt = new AttributeValueChangeEventImpl( coreConnection, this.boss1, this.employeeSalary, new Integer( this.boss1.getSalary( ) ), new Integer( this.boss1.getSalary( ) ) );
        instances = compAffectedInstances( ia, evt );
        compareInstances( instances, new RefObject[] { this.div } );

        // change budget of the division
        evt = new AttributeValueChangeEventImpl( coreConnection, this.div, this.divisionBudget, new Integer( this.div.getBudget( ) ), new Integer( this.div.getBudget( ) ) );
        instances = compAffectedInstances( ia, evt );
        compareInstances( instances, new RefObject[] { this.div } );

        this.info( "Done\n" );
        this.info( "--------------------------------------------------\n" );
    }

    /**
     * @throws Exception
     */
    @Test
    public void testSecretaryOlderThanBoss( ) throws Exception {

        // context Employee \n"
        // inv secretaryOlderThanBoss: \n"
        // if self.directed->notEmpty() and \n"
        // not self.secretary.oclIsUndefined() then \n"
        // self.age < self.secretary.age \n"
        // else true \n"
        // endif";
        this.info( "\n--------------------------------------------------\n" );
        this.info( "Testing secretaryOlderThanBoss\n" );
        this.info( "--------------------------------------------------\n" );
        Set<OclStatement> stmts = new HashSet<OclStatement>( );
        stmts.add( this.secretaryOlderThanBossAST );
        ImpactAnalyzer ia = new ImpactAnalyzer( false );
        synchronized ( this.syncObjectForWrite ) {
            ia.analyze( stmts, this.myJmiCreator );
        }

        // add new director
        ModelChangeEvent evt = this.createLinkAddEvent( this.director, this.div, this.directedRef.getReferencedEnd( coreConnection ) );
        Collection<RefObject> instances = compAffectedInstances( ia, evt );
        compareInstances( instances, new RefObject[] { this.director } );

        // remove director
        evt = this.createLinkRemoveEvent( this.director, this.div, this.directedRef.getReferencedEnd( coreConnection ) );
        instances = compAffectedInstances( ia, evt );
        compareInstances( instances, new RefObject[] { this.director } );

        // change secretary of the director
        evt = new AttributeValueChangeEventImpl( coreConnection, this.director, this.employeeSecretary, this.director.getSecretary( this.coreConnection ), this.director.getSecretary( this.coreConnection ) );
        instances = compAffectedInstances( ia, evt );
        compareInstances( instances, new RefObject[] { this.director } );

        // change age of secretary
        evt = new AttributeValueChangeEventImpl( coreConnection, this.secretary, this.employeeAge, new Integer( this.secretary.getAge( ) ), new Integer( this.secretary.getAge( ) ) );
        instances = compAffectedInstances( ia, evt );
        compareInstances( instances, new RefObject[] { this.director, this.secretary } );

        // change age of director
        evt = new AttributeValueChangeEventImpl( coreConnection, this.director, this.employeeAge, new Integer( this.director.getAge( ) ), new Integer( this.director.getAge( ) ) );
        instances = compAffectedInstances( ia, evt );
        compareInstances( instances, new RefObject[] { this.director } );

        this.info( "Done\n" );
        this.info( "--------------------------------------------------\n" );
    }

    /**
     * Computes the set of affected context instances for event <tt>evt</tt>.
     * 
     * @param ia the instance of ImpactAnalyzer used to filter <tt>evt</tt>.
     * @param evt the event.
     * @return a Collection of RefObjects ie the affected context instances.
     */
    private Collection<RefObject> compAffectedInstances( ImpactAnalyzer ia, ModelChangeEvent evt ) throws Exception {

        Set<EvaluationUnit> es = ia.filter( coreConnection, evt );
        EvaluationHelper eval = new EvaluationHelper( );
        Set<RefObject> result = new HashSet<RefObject>( );

        for ( Iterator<EvaluationUnit> i = es.iterator( ); i.hasNext( ); ) {
            EvaluationUnit eu = i.next( );
            for ( Iterator<InstanceSet> i2 = eu.getInstanceSets( ).iterator( ); i2.hasNext( ); ) {
                InstanceSet is = i2.next( );
                this.info( "Starting points:\n" );
                for ( Iterator<RefObject> i3 = is.getStartingPoints( ).iterator( ); i3.hasNext( ); ) {
                    RefObject o = i3.next( );
                    this.info( " " + o.toString( ) + "\n" );
                }
                this.info( "Reverse path:\n" );
                this.info( this.serializerNoPackageNames.serialize( is.getNavigationStatement( ) ) + "\n\n" );
            }
            result.addAll( eval.getAffectedRefObjects( coreConnection, eu ) );

        }
        return result;
    }

    private LinkAddEvent createLinkAddEvent( RefObject end1, RefObject end2, RefFeatured metaObject ) {

        return new LinkAddEventImpl( coreConnection, this.getEnds( end1, end2 ), metaObject );

    }

    private LinkRemoveEvent createLinkRemoveEvent( RefObject end1, RefObject end2, RefFeatured metaObject ) {

        return new LinkRemoveEventImpl( coreConnection, this.getEnds( end1, end2 ), metaObject );

    }

    private List<MRI> getEnds( RefObject end1, RefObject end2 ) {

        List<MRI> result = new ArrayList<MRI>( );
        MRI first = this.linkEnds.get( end1 );
        if ( first == null ) {
            first = new MRIImpl( end1 );
            this.linkEnds.put( end1, first );
        }
        MRI second = this.linkEnds.get( end2 );
        if ( second == null ) {
            second = new MRIImpl( end2 );
            this.linkEnds.put( end2, second );
        }
        result.add( first );
        result.add( second );
        return result;
    }

    /**
     * Unfortunately not all features can be tested with the department model
     */
    private void extendModel( ) {

        // for some tests we need some additional classes
        // MofClass a = this.mofPackage.getModel().getMofClass().createMofClass();
        // a.setName("A");
        // MofClass b = this.mofPackage.getModel().getMofClass().createMofClass();
        // a.setName("B");
        // MofClass c = this.mofPackage.getModel().getMofClass().createMofClass();
        // a.setName("C");
        // MofClass d = this.mofPackage.getModel().getMofClass().createMofClass();
        // a.setName("D");
        // // B is a subtype of A
        // b.getSupertypes().add(a);
        // // D-B-Association
        // Association db = this.mofPackage.getModel().getAssociation().createAssociation();
        // db.setName("DB-Assocation");
        // AssociationEnd toB = this.mofPackage.getModel().getAssociationEnd().createAssociationEnd();
        // toB.setName("toB");
        // toB.setType(b);
        // toB.setMultiplicity(this.mofPackage.getModel().createMultiplicityType(0,-1,true,true));
        // db.getContents().add(toB);
        // AssociationEnd toD = this.mofPackage.getModel().getAssociationEnd().createAssociationEnd();
        // toB.setName("toD");
        // toB.setType(d);
        // toB.setMultiplicity(this.mofPackage.getModel().createMultiplicityType(0,-1,true,true));
        // db.getContents().add(toD);
        // // A-C-Association
        // Association ac = this.mofPackage.getModel().getAssociation().createAssociation();
        // ac.setName("DB-Assocation");
        // AssociationEnd toC = this.mofPackage.getModel().getAssociationEnd().createAssociationEnd();
        // toC.setName("toC");
        // toC.setType(c);
        // toC.setMultiplicity(this.mofPackage.getModel().createMultiplicityType(0,-1,true,true));
        // ac.getContents().add(toC);
        // AssociationEnd toA = this.mofPackage.getModel().getAssociationEnd().createAssociationEnd();
        // toA.setName("toA");
        // toA.setType(a);
        // toA.setMultiplicity(this.mofPackage.getModel().createMultiplicityType(0,-1,true,true));
        // ac.getContents().add(toA);
        // this.companyPackage.getContents().add(a);
        // this.companyPackage.getContents().add(b);
        // this.companyPackage.getContents().add(c);
        // this.companyPackage.getContents().add(d);
        // this.companyPackage.getContents().add(ac);
        // this.companyPackage.getContents().add(db);
    }

    @Override
    @After
    public void afterTestMethod( ) throws Exception {

        this.div = null;
        this.dep1 = null;
        this.dep2 = null;
        this.e1 = null;
        this.e2 = null;
        this.e3 = null;
        this.e4 = null;
        this.boss1 = null;
        this.boss2 = null;
        this.director = null;
        this.secretary = null;
        this.linkEnds = null;

        super.afterTestMethod( );
    }
}
