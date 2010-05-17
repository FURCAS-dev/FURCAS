package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.tests;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ocl.ecore.OCLExpression;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import company.CompanyFactory;
import company.Department;
import company.Division;
import company.Employee;
import company.Freelance;

import de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzer;
import de.hpi.sam.bp2009.solution.impactAnalyzer.impl.ImpactAnalyzerImpl;
import de.hpi.sam.bp2009.solution.impactAnalyzer.tests.helper.BaseDepartmentTest;
import de.hpi.sam.bp2009.solution.impactAnalyzer.tests.helper.NotificationHelper;

/**
 * Tests whether the right context instances are computed. This is done as
 * follows: A simple instance of the company model is created. Each test tests
 * only one statement. The statement is analyzed and a set of relevant events is
 * generated and reported to IA. The IA compute the affected context instances
 * with the help of the InstanceScopeAnalysis. This set is then
 * compared to a set of expected context instances.
 * 
 */
public class RevPathComputationTest extends BaseDepartmentTest {

    private Division div;
    private Department dep1;
    private Department dep2;
    private Employee e1;
    private Freelance e2;
    private Employee e3;
    private Freelance e4;
    private Employee boss1;
    private Employee boss2;
    private Employee director;
    private Employee secretary;

    @Override
    @Before
    public void setUp( ) {

        super.setUp( );
        createInstances( );
    }

    @Override
    @After
    public void tearDown( ) {
        EcoreUtil.remove(this.div);
        EcoreUtil.remove(this.dep1);
        EcoreUtil.remove(this.dep2);
        EcoreUtil.remove(this.e1);
        EcoreUtil.remove(this.e2);
        EcoreUtil.remove(this.e3);
        EcoreUtil.remove(this.e4);
        EcoreUtil.remove(this.boss1);
        EcoreUtil.remove(this.boss2);
        EcoreUtil.remove(this.director);
        EcoreUtil.remove(this.secretary);
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
        super.tearDown( );
    }

    @Test
    public void testBossHighestSalaryEmployeeSalaryChange( ) {

        // context Department inv BossHighestSalary:
            // self.employee->select(
        // e|e.salary >= self.boss.salary)->size() <= 1
        System.out.println( "Testing BossHighestSalaryEmployeeSalaryChange\n" );
        Set<OCLExpression> stmts = new HashSet<OCLExpression>( );
        stmts.add( this.bossHighestSalaryAST );

        ImpactAnalyzer ia = new ImpactAnalyzerImpl();

        createFilters(stmts, ia, false);             
        Notification noti;

        // change salary of an employee
        noti = NotificationHelper.createAttributeChangeNotification(this.e1, this.employeeSalary, new Long(this.e1.getSalary()), new Long( this.e1.getSalary()));
        Collection<EObject> instances = computeAffectedInstances(stmts, noti, ia, this.department);
        compareInstances( instances, new EObject[] { this.dep1 } );
    }

    @Test
    public void testBossHighestSalaryBossSalaryChange( ) {

        // context Department inv BossHighestSalary:
        // self.employee->select(
        // e|e.salary >= self.boss.salary)->size() <= 1
        System.out.println( "Testing BossHighestSalaryBossSalaryChange\n" );
        Set<OCLExpression> stmts = new HashSet<OCLExpression>( );
        stmts.add( this.bossHighestSalaryAST );

        ImpactAnalyzer ia = new ImpactAnalyzerImpl();

        createFilters(stmts, ia, false);             
        Notification noti;

        Collection<EObject> instances;

        // change salary of the boss
        noti = NotificationHelper.createAttributeChangeNotification(this.boss1, this.employeeSalary, new Long( this.boss1.getSalary( ) ), new Long( this.boss1.getSalary( ) ) );        
        instances = computeAffectedInstances(stmts, noti, ia, this.department );
        compareInstances( instances, new EObject[] { this.dep1 } );

    }

    @Test
    public void testBossHighestSalaryAddEmployee( ) {

        // context Department inv BossHighestSalary:
        // self.employee->select(
        // e|e.salary >= self.boss.salary)->size() <= 1
        System.out.println( "Testing BossHighestSalaryAddEmployee\n" );
        Set<OCLExpression> stmts = new HashSet<OCLExpression>( );
        stmts.add( this.bossHighestSalaryAST );

        ImpactAnalyzer ia = new ImpactAnalyzerImpl();

        createFilters(stmts, ia, false);             
        Notification noti;

        Collection<EObject> instances;

        // add new employee
        
        noti = NotificationHelper.createReferenceAddNotification(this.dep1, this.employeeRef, CompanyFactory.eINSTANCE.createEmployee());
        instances = computeAffectedInstances(stmts, noti, ia, this.department );
        compareInstances( instances, new EObject[] { this.dep1 } );
    }

    @Test
    public void testBossHighestSalaryAddBoss( ) {

        // context Department inv BossHighestSalary:
        // self.employee->select(
        // e|e.salary >= self.boss.salary)->size() <= 1
        System.out.println( "Testing BossHighestSalaryAddBoss\n" );
        Set<OCLExpression> stmts = new HashSet<OCLExpression>( );
        stmts.add( this.bossHighestSalaryAST );

        ImpactAnalyzer ia = new ImpactAnalyzerImpl();

        createFilters(stmts, ia, false);             
        Notification noti;

        Collection<EObject> instances;

        // add new boss
        noti = NotificationHelper.createReferenceAddNotification( this.dep1, this.bossRef, this.boss1 );
        instances = computeAffectedInstances(stmts, noti, ia, this.department );
        compareInstances( instances, new EObject[] { this.dep1 } );
        System.out.println( "--------------------------------------------------\n" );
    }

    @Test
    public void testBossIsOldestEmployeeAgeChange( ) {


        // context Employee inv BossIsOldest:
        // self.age <= self.employer.boss.age
        System.out.println( "Testing BossIsOldestEmployeeAgeChange\n" );
        Set<OCLExpression> stmts = new HashSet<OCLExpression>( );
        stmts.add( this.bossIsOldestAST );

        Set<EObject> expectedInstances = new HashSet<EObject>( );
        expectedInstances.add( this.e2 );       
        ImpactAnalyzer ia = new ImpactAnalyzerImpl( );
        createFilters(stmts, ia, false);
        Collection<EObject> instances;
        Notification noti;

        // change age of an employee
        noti = NotificationHelper.createAttributeChangeNotification( this.e2, this.employeeAge, new Long( this.e2.getAge( ) ), new Long( this.e2.getAge( ) ) );
        instances = computeAffectedInstances(stmts, noti, ia, this.employee );
        compareInstances( instances, new EObject[] { this.e2 } );
    }
    
    @Test
    public void testBossIsOldestBossAgeChange( ) {


        // context Employee inv BossIsOldest:
        // self.age <= self.employer.boss.age
        System.out.println( "Testing BossIsOldestBossAgeChange\n" );
        Set<OCLExpression> stmts = new HashSet<OCLExpression>( );
        stmts.add( this.bossIsOldestAST );

        Set<EObject> expectedInstances = new HashSet<EObject>( );
        expectedInstances.add( this.e2 );       
        ImpactAnalyzer ia = new ImpactAnalyzerImpl( );
        createFilters(stmts, ia, false);
        Collection<EObject> instances;
        Notification noti;

        // change age of the boss
        expectedInstances = new HashSet<EObject>( );
        expectedInstances.add( this.e1 );
        expectedInstances.add( this.e2 );
        expectedInstances.add( this.boss1 );
        noti = NotificationHelper.createAttributeChangeNotification(this.boss1, this.employeeAge, new Long( this.boss1.getAge( ) ), new Long( this.boss1.getAge( ) ) );
        instances = computeAffectedInstances(stmts, noti, ia, this.employee );
        compareInstances( instances, new EObject[] { this.e1, this.e2, this.boss1 } );

    }
    @Test
    public void testBossIsOldestAddEmployee( ) {


        // context Employee inv BossIsOldest:
        // self.age <= self.employer.boss.age
        System.out.println( "Testing BossIsOldestAddEmployee\n" );
        Set<OCLExpression> stmts = new HashSet<OCLExpression>( );
        stmts.add( this.bossIsOldestAST );

        Set<EObject> expectedInstances = new HashSet<EObject>( );
        expectedInstances.add( this.e2 );       
        ImpactAnalyzer ia = new ImpactAnalyzerImpl( );
        createFilters(stmts, ia, false);
        Collection<EObject> instances;
        Notification noti;

        // add new employee
        noti = NotificationHelper.createReferenceAddNotification( this.e1, this.employerRef, this.dep1 );
        instances = computeAffectedInstances(stmts, noti, ia, this.employee );
        compareInstances( instances, new EObject[] { this.e1 } );

    }
    @Test
    public void testBossIsOldestAddBoss( ) {


        // context Employee inv BossIsOldest:
        // self.age <= self.employer.boss.age
        System.out.println( "Testing BossIsOldestAddBoss\n" );
        Set<OCLExpression> stmts = new HashSet<OCLExpression>( );
        stmts.add( this.bossIsOldestAST );

        Set<EObject> expectedInstances = new HashSet<EObject>( );
        expectedInstances.add( this.e2 );       
        ImpactAnalyzer ia = new ImpactAnalyzerImpl( );
        createFilters(stmts, ia, false);
        Collection<EObject> instances;
        Notification noti;
        
        // add new boss
        noti = NotificationHelper.createReferenceAddNotification(this.dep1, this.bossRef, this.boss1 );
        instances = computeAffectedInstances(stmts, noti, ia, this.employee );
        compareInstances( instances, new EObject[] { this.e1, this.e2, this.boss1 } );

        System.out.println( "--------------------------------------------------\n" );
    }

    
    @Test
    public void testNotBossFreelance( ) {

        // context Department
        // inv NotBossFreelance:
        // not self.boss.oclIsTypeOf(Freelance)
        System.out.println( "Testing NotBossFreelance\n" );
        Set<OCLExpression> stmts = new HashSet<OCLExpression>( );
        Notification noti = null;

        stmts.add( this.notBossFreelanceAST );
        ImpactAnalyzer ia = new ImpactAnalyzerImpl( );
        createFilters(stmts, ia, false);
        // add new boss
        noti = NotificationHelper.createReferenceAddNotification( this.dep2, this.bossRef, this.boss2 );
        Collection<EObject> instances = computeAffectedInstances(stmts, noti, ia, this.department );
        compareInstances( instances, new EObject[] { this.dep2 } );
        System.out.println( "--------------------------------------------------\n" );
    }

    @Test
    public void testOldEmployeeEmployeeAgeChange( ) {

        // context Department
        // inv OldEmployee:
        // self.employee->exists(e | e.age > 45)
        System.out.println( "Testing OldEmployeeEmployeeAgeChange\n" );
        Set<OCLExpression> stmts = new HashSet<OCLExpression>( );

        stmts.add( this.oldEmployeeAST );
        ImpactAnalyzer ia = new ImpactAnalyzerImpl( );
        createFilters(stmts, ia, false);
        Notification noti;
        Collection<EObject> instances;
        // change age of an employee
        noti = NotificationHelper.createAttributeChangeNotification(this.e2, this.employeeAge, new Long( this.e2.getAge( ) ), new Long( this.e2.getAge( ) ) );
        instances = computeAffectedInstances(stmts, noti, ia, this.department );
        compareInstances( instances, new EObject[] { this.dep1 } );

    }
    @Test
    public void testOldEmployeeBossAgeChange( ) {

        // context Department
        // inv OldEmployee:
        // self.employee->exists(e | e.age > 45)
        System.out.println( "Testing OldEmployeeBossAgeChange\n" );
        Set<OCLExpression> stmts = new HashSet<OCLExpression>( );

        stmts.add( this.oldEmployeeAST );
        ImpactAnalyzer ia = new ImpactAnalyzerImpl( );
        createFilters(stmts, ia, false);
        Notification noti;
        Collection<EObject> instances;
        // change age of the boss
        noti = NotificationHelper.createAttributeChangeNotification( this.boss1, this.employeeAge, new Long( this.boss1.getAge( ) ), new Long( this.boss1.getAge( ) ) );
        instances = computeAffectedInstances(stmts, noti, ia, this.department );
        compareInstances( instances, new EObject[] { this.dep1 } );
    }
    @Test
    public void testOldEmployeeAddEmployee( ) {

        // context Department
        // inv OldEmployee:
        // self.employee->exists(e | e.age > 45)
        System.out.println( "Testing OldEmployeeAddEmployee\n" );
        Set<OCLExpression> stmts = new HashSet<OCLExpression>( );

        stmts.add( this.oldEmployeeAST );
        ImpactAnalyzer ia = new ImpactAnalyzerImpl( );
        createFilters(stmts, ia, false);
        Notification noti;
        Collection<EObject> instances;

        // add new employee
        noti = NotificationHelper.createReferenceAddNotification( this.dep1, this.employeeRef, CompanyFactory.eINSTANCE.createEmployee() );
        instances = computeAffectedInstances(stmts, noti, ia, this.department );
        compareInstances( instances, new EObject[] { this.dep1 } );
        System.out.println( "--------------------------------------------------\n" );
    }
    @Test
    public void testUniqueNames( ) {

        // context Employee
        // inv UniqueNames:
        // Employee.allInstances()->forAll(e |
        // e <> self implies e.name <> self.name)
        System.out.println( "Testing UniqueNames\n" );
        Set<OCLExpression> stmts = new HashSet<OCLExpression>( );

        stmts.add( this.uniqueNamesAST );
        ImpactAnalyzer ia = new ImpactAnalyzerImpl( );
        createFilters(stmts, ia, false);

        // change name of an employee
        // this does not trigger the allInstances change handling
        Notification noti = NotificationHelper.createAttributeChangeNotification(this.e2, this.employeeName, this.e2.getName( ), this.e2.getName( ) );

        Collection<EObject> instances = computeAffectedInstances(stmts, noti, ia, this.employee );
        compareInstances( instances, new EObject[] { this.e2 } );
        System.out.println( "--------------------------------------------------\n" );
    }

    @Test
    public void testValidAssignment( ) {

        // context Freelance
        // inv ValidAssignment:
        // self.assignment >= 5 and self.assignment <= 30
        System.out.println( "Testing ValidAssignment\n" );
        Set<OCLExpression> stmts = new HashSet<OCLExpression>( );
        stmts.add( this.validAssignmentAST );

        ImpactAnalyzer ia = new ImpactAnalyzerImpl( );
        createFilters(stmts, ia, false);

        // change age of an employee
        Notification noti = NotificationHelper.createAttributeChangeNotification( this.e4, this.freelanceAssignment, new Long( this.e4.getAssignment( ) ), new Long( this.e4.getAssignment( ) ) );
        Collection<EObject> instances = computeAffectedInstances(stmts, noti, ia, this.freelance );
        compareInstances( instances, new EObject[] { this.e4 } );
        System.out.println( "--------------------------------------------------\n" );

    }

    @Test
    public void testMaxJuniorsEmployeeAgeChange( ) {

        // context Department inv MaxJuniors:
        // self.employee->select(e|e.age < 25)->size() < self.maxJuniors
        System.out.println( "Testing MaxJuniorsEmployeeAgeChange\n" );
        Set<OCLExpression> stmts = new HashSet<OCLExpression>( );
        stmts.add( this.maxJuniorsAST );

        ImpactAnalyzer ia = new ImpactAnalyzerImpl( );
        createFilters(stmts, ia, false);

        Notification noti;
        Collection<EObject> instances;
        // change age of an employee
        noti = NotificationHelper.createAttributeChangeNotification(this.e2, this.employeeAge, new Long( this.e2.getAge( ) ), new Long( this.e2.getAge( ) ) );
        instances = computeAffectedInstances(stmts, noti, ia, this.department );
        compareInstances( instances, new EObject[] { this.dep1 } );

    }

    @Test
    public void testMaxJuniorsDepartmentMaxJuniorsChange( ) {

        // context Department inv MaxJuniors:
        // self.employee->select(e|e.age < 25)->size() < self.maxJuniors
        System.out.println( "Testing MaxJuniorsDepartmentMaxJuniorsChange\n" );
        Set<OCLExpression> stmts = new HashSet<OCLExpression>( );
        stmts.add( this.maxJuniorsAST );

        ImpactAnalyzer ia = new ImpactAnalyzerImpl( );
        createFilters(stmts, ia, false);

        Notification noti;
        Collection<EObject> instances;

        // change maxJuniors of a Department
        noti = NotificationHelper.createAttributeChangeNotification(this.dep1, this.departmentMaxJuniors, new Long( this.dep1.getMaxJuniors( ) ), new Long( this.dep1.getMaxJuniors( ) ) );
        instances = computeAffectedInstances(stmts, noti, ia, this.department );
        compareInstances( instances, new EObject[] { this.dep1 } );

    }
    @Test
    public void testMaxJuniorsAddEmployee( ) {

        // context Department inv MaxJuniors:
        // self.employee->select(e|e.age < 25)->size() < self.maxJuniors
        System.out.println( "Testing MaxJuniorsAddEmployee\n" );
        Set<OCLExpression> stmts = new HashSet<OCLExpression>( );
        stmts.add( this.maxJuniorsAST );

        ImpactAnalyzer ia = new ImpactAnalyzerImpl( );
        createFilters(stmts, ia, false);

        Notification noti;
        Collection<EObject> instances;

        // add new employee
        noti = NotificationHelper.createReferenceAddNotification(this.dep1, this.employeeRef, CompanyFactory.eINSTANCE.createEmployee());
        instances = computeAffectedInstances(stmts, noti, ia, this.department );
        compareInstances( instances, new EObject[] { this.dep1 } );

        System.out.println( "--------------------------------------------------\n" );

    }
    @Test
    public void testNastyConstraintAddDepartment( ) {

        // context Division
        // inv nasty:
        // self.department->collect(d|
        // d.employee->including(d.boss)).salary->sum() < budget";
        System.out.println( "Testing nastyAddDepartment\n" );
        Set<OCLExpression> stmts = new HashSet<OCLExpression>( );

        stmts.add( this.nastyConstraintAST );
        ImpactAnalyzer ia = new ImpactAnalyzerImpl( );
        createFilters(stmts, ia, false);

        Notification noti;
        Collection<EObject> instances;
        
        // add new department
        noti = NotificationHelper.createReferenceAddNotification(this.div, this.departmentRef, CompanyFactory.eINSTANCE.createDepartment() );
        instances = computeAffectedInstances(stmts, noti, ia, this.division );
        compareInstances( instances, new EObject[] { this.div } );

    }

    @Test
    public void testNastyConstraintAddEmployee( ) {

        // context Division
        // inv nasty:
        // self.department->collect(d|
        // d.employee->including(d.boss)).salary->sum() < budget";
        System.out.println( "Testing nastyAddEmployee\n" );
        Set<OCLExpression> stmts = new HashSet<OCLExpression>( );

        stmts.add( this.nastyConstraintAST );
        ImpactAnalyzer ia = new ImpactAnalyzerImpl( );
        createFilters(stmts, ia, false);

        Notification noti;
        Collection<EObject> instances;

        // add new employee
        noti = NotificationHelper.createReferenceAddNotification(this.dep1, this.employeeRef, CompanyFactory.eINSTANCE.createEmployee());
        instances = computeAffectedInstances(stmts, noti, ia, this.division );
        compareInstances( instances, new EObject[] { this.div } );

    }
    @Test
    public void testNastyConstraintAddBoss( ) {

        // context Division
        // inv nasty:
        // self.department->collect(d|
        // d.employee->including(d.boss)).salary->sum() < budget";
        System.out.println( "Testing nastyAddBoss\n" );
        Set<OCLExpression> stmts = new HashSet<OCLExpression>( );

        stmts.add( this.nastyConstraintAST );
        ImpactAnalyzer ia = new ImpactAnalyzerImpl( );
        createFilters(stmts, ia, false);

        Notification noti;
        Collection<EObject> instances;


        // add new boss
        noti = NotificationHelper.createReferenceAddNotification(this.dep1, this.bossRef, this.boss2 );
        instances = computeAffectedInstances(stmts, noti, ia, this.division );
        compareInstances( instances, new EObject[] { this.div } );

    }
    @Test
    public void testNastyConstraintEmployeeSalaryChange( ) {

        // context Division
        // inv nasty:
        // self.department->collect(d|
        // d.employee->including(d.boss)).salary->sum() < budget";
        System.out.println( "Testing nastyEmployeeSalaryChange\n" );
        Set<OCLExpression> stmts = new HashSet<OCLExpression>( );

        stmts.add( this.nastyConstraintAST );
        ImpactAnalyzer ia = new ImpactAnalyzerImpl( );
        createFilters(stmts, ia, false);

        Notification noti;
        Collection<EObject> instances;


        // change salary of an employee
        noti = NotificationHelper.createAttributeChangeNotification(this.e1, this.employeeSalary, new Long( this.e1.getSalary( ) ), new Long( this.e1.getSalary( ) ) );
        instances = computeAffectedInstances(stmts, noti, ia, this.division );
        compareInstances( instances, new EObject[] { this.div } );

    }
    @Test
    public void testNastyConstraintBossSalaryChange( ) {

        // context Division
        // inv nasty:
        // self.department->collect(d|
        // d.employee->including(d.boss)).salary->sum() < budget";
        System.out.println( "Testing nastyBossSalaryChange\n" );
        Set<OCLExpression> stmts = new HashSet<OCLExpression>( );

        stmts.add( this.nastyConstraintAST );
        ImpactAnalyzer ia = new ImpactAnalyzerImpl( );
        createFilters(stmts, ia, false);

        Notification noti;
        Collection<EObject> instances;
        
        // change salary of the boss
        noti = NotificationHelper.createAttributeChangeNotification(this.boss1, this.employeeSalary, new Long( this.boss1.getSalary( ) ), new Long( this.boss1.getSalary( ) ) );
        instances = computeAffectedInstances(stmts, noti, ia, this.division );
        compareInstances( instances, new EObject[] { this.div } );

    }
    @Test
    public void testNastyConstraintDivisionBudgetChange( ) {

        // context Division
        // inv nasty:
        // self.department->collect(d|
        // d.employee->including(d.boss)).salary->sum() < budget";
        System.out.println( "Testing nastyDivisionBudgetChange\n" );
        Set<OCLExpression> stmts = new HashSet<OCLExpression>( );

        stmts.add( this.nastyConstraintAST );
        ImpactAnalyzer ia = new ImpactAnalyzerImpl( );
        createFilters(stmts, ia, false);

        Notification noti;
        Collection<EObject> instances;
        
        // change budget of the division
        noti = NotificationHelper.createAttributeChangeNotification(this.div, this.divisionBudget, new Long( this.div.getBudget( ) ), new Long( this.div.getBudget( ) ) );
        instances = computeAffectedInstances(stmts, noti, ia, this.division );
        compareInstances( instances, new EObject[] { this.div } );

        System.out.println( "--------------------------------------------------\n" );
    }
    @Test
    public void testSecretaryOlderThanBossAddDirector( ) {

        // context Employee \n"
        // inv secretaryOlderThanBoss: \n"
        // if self.directed->notEmpty() and \n"
        // not self.secretary.oclIsUndefined() then \n"
        // self.age < self.secretary.age \n"
        // else true \n"
        // endif";
        System.out.println( "Testing secretaryOlderThanBossAddDirector\n" );
        Set<OCLExpression> stmts = new HashSet<OCLExpression>( );
        stmts.add( this.secretaryOlderThanBossAST );
        ImpactAnalyzer ia = new ImpactAnalyzerImpl( );
        createFilters(stmts, ia, false);

        Notification noti;
        Collection<EObject> instances;
        
        // add new director
        noti = NotificationHelper.createReferenceAddNotification(this.director, this.directedRef, this.div );
        instances = computeAffectedInstances(stmts, noti, ia, this.employee );
        compareInstances( instances, new EObject[] { this.director } );
    }

    @Test
    public void testSecretaryOlderThanBossRemoveDirector( ) {

        // context Employee \n"
        // inv secretaryOlderThanBoss: \n"
        // if self.directed->notEmpty() and \n"
        // not self.secretary.oclIsUndefined() then \n"
        // self.age < self.secretary.age \n"
        // else true \n"
        // endif";
        System.out.println( "Testing secretaryOlderThanBossRemoveDirector\n" );
        Set<OCLExpression> stmts = new HashSet<OCLExpression>( );
        stmts.add( this.secretaryOlderThanBossAST );
        ImpactAnalyzer ia = new ImpactAnalyzerImpl( );
        createFilters(stmts, ia, false);

        Notification noti;
        Collection<EObject> instances;

        // remove director
        noti = NotificationHelper.createReferenceRemoveNotification(this.director, this.directedRef, this.div );
        instances = computeAffectedInstances(stmts, noti, ia, this.employee );
        compareInstances( instances, new EObject[] { this.director } );

    }
    @Test
    public void testSecretaryOlderThanBossDirectorSecretaryChange( ) {

        // context Employee \n"
        // inv secretaryOlderThanBoss: \n"
        // if self.directed->notEmpty() and \n"
        // not self.secretary.oclIsUndefined() then \n"
        // self.age < self.secretary.age \n"
        // else true \n"
        // endif";
        System.out.println( "Testing secretaryOlderThanBossDirectorSecretaryChange\n" );
        Set<OCLExpression> stmts = new HashSet<OCLExpression>( );
        stmts.add( this.secretaryOlderThanBossAST );
        ImpactAnalyzer ia = new ImpactAnalyzerImpl( );
        createFilters(stmts, ia, false);

        Notification noti;
        Collection<EObject> instances;
        
        // change secretary of the director
        noti = NotificationHelper.createReferenceChangeNotification(this.director, this.employeeSecretary, this.director.getSecretary( ), CompanyFactory.eINSTANCE.createEmployee());
        instances = computeAffectedInstances(stmts, noti, ia, this.employee );
        compareInstances( instances, new EObject[] { this.director } );

    }
    @Test
    public void testSecretaryOlderThanBossSecretaryAgeChange( ) {

        // context Employee \n"
        // inv secretaryOlderThanBoss: \n"
        // if self.directed->notEmpty() and \n"
        // not self.secretary.oclIsUndefined() then \n"
        // self.age < self.secretary.age \n"
        // else true \n"
        // endif";
        System.out.println( "Testing secretaryOlderThanBossSecretaryAgeChange\n" );
        Set<OCLExpression> stmts = new HashSet<OCLExpression>( );
        stmts.add( this.secretaryOlderThanBossAST );
        ImpactAnalyzer ia = new ImpactAnalyzerImpl( );
        createFilters(stmts, ia, false);

        Notification noti;
        Collection<EObject> instances;

        // change age of secretary
        noti = NotificationHelper.createAttributeChangeNotification(this.secretary, this.employeeAge, new Long( this.secretary.getAge( ) ), new Long( this.secretary.getAge( ) ) );
        instances = computeAffectedInstances(stmts, noti, ia, this.employee );
        compareInstances( instances, new EObject[] { this.director, this.secretary } );
    }
    @Test
    public void testSecretaryOlderThanBossDirectorAgeChange( ) {

        // context Employee \n"
        // inv secretaryOlderThanBoss: \n"
        // if self.directed->notEmpty() and \n"
        // not self.secretary.oclIsUndefined() then \n"
        // self.age < self.secretary.age \n"
        // else true \n"
        // endif";
        System.out.println( "Testing secretaryOlderThanBossDirectorAgeChange\n" );
        Set<OCLExpression> stmts = new HashSet<OCLExpression>( );
        stmts.add( this.secretaryOlderThanBossAST );
        ImpactAnalyzer ia = new ImpactAnalyzerImpl( );
        createFilters(stmts, ia, false);

        Notification noti;
        Collection<EObject> instances;
        
        // change age of director
        noti = NotificationHelper.createAttributeChangeNotification(this.director, this.employeeAge, new Long( this.director.getAge( ) ), new Long( this.director.getAge( ) ) );
        instances = computeAffectedInstances(stmts, noti, ia, this.employee );
        compareInstances( instances, new EObject[] { this.director } );

        System.out.println( "--------------------------------------------------\n" );
    }
    @Test
    public void testBoss10YearsOlderThanJuniorEmployeeAgeChange(){

        // context Department \n"
        // inv boss10YearsOlderThanJunior: \n"
        // let t:Tuple(boss:Employee,junior:Employee)="
        // Tuple{boss=self.boss, junior=self.employee->sortedBy(age)->first()} in \n"
        // t.boss.age > t.junior.age + 10";
        System.out.println("Testing boss10YearsOlderThanJuniorEmployeeAgeChange\n");
        Set<OCLExpression> stmts = new HashSet<OCLExpression>( );
        stmts.add( this.boss10YearsOlderThanJuniorAST );
        ImpactAnalyzer ia = new ImpactAnalyzerImpl( );
        createFilters(stmts, ia, false);
        
        Notification noti;
        Collection<EObject> instances;
        
        //change age of employee
        noti = NotificationHelper.createAttributeChangeNotification(this.e1, this.employeeAge, new Long(42), new Long(1));
        instances = computeAffectedInstances(stmts, noti, ia, this.department );
        compareInstances( instances, new EObject[] { this.e1.getEmployer() } );
    }
    @Test
    public void testBoss10YearsOlderThanJuniorBossAgeChange(){

        // context Department \n"
        // inv boss10YearsOlderThanJunior: \n"
        // let t:Tuple(boss:Employee,junior:Employee)="
        // Tuple{boss=self.boss, junior=self.employee->sortedBy(age)->first()} in \n"
        // t.boss.age > t.junior.age + 10";
        System.out.println("Testing boss10YearsOlderThanJuniorBossAgeChange\n");
        Set<OCLExpression> stmts = new HashSet<OCLExpression>( );
        stmts.add( this.boss10YearsOlderThanJuniorAST );
        ImpactAnalyzer ia = new ImpactAnalyzerImpl( );
        createFilters(stmts, ia, false);
        
        Notification noti;
        Collection<EObject> instances;

        //change age of boss
        noti = NotificationHelper.createAttributeChangeNotification(this.boss1, this.employeeAge, new Long(42), new Long(52));
        instances = computeAffectedInstances(stmts, noti, ia, this.department );
        compareInstances( instances, new EObject[] { this.e1.getEmployer() } );

        System.out.println( "--------------------------------------------------\n" );
    }
    /**
     * Creates an instance of the company model ie 2 instances of Department
     * with e employees and one boss each.
     */
    private void createInstances( ) {

        this.div = CompanyFactory.eINSTANCE.createDivision();
        this.div.setBudget( 1234567 );
        this.div.setName( "Div1" );
        this.comp.eResource().getContents().add(this.div);

        this.director = CompanyFactory.eINSTANCE.createEmployee();
        this.director.setAge( 42 );
        this.director.setName( "Director" );
        this.director.setDirected( this.div );
        this.director.setSalary( 1234 );
        this.div.setDirector( this.director );
//        this.comp.eResource().getContents().add(this.director);

        this.secretary = CompanyFactory.eINSTANCE.createEmployee();
        this.secretary.setAge( 55 );
        this.secretary.setName( "Secretary" );
        this.secretary.setSalary( 1234 );
        this.director.setSecretary( this.secretary );
//        this.comp.eResource().getContents().add(this.secretary);

        this.dep1 = CompanyFactory.eINSTANCE.createDepartment();
        this.dep1.setName( "Dep1" );
        this.dep1.setBudget( 12345567 );
        this.dep1.setMaxJuniors( 5 );
//        this.comp.eResource().getContents().add(this.dep1);
        this.e1 = CompanyFactory.eINSTANCE.createEmployee();
        this.e1.setAge( 42 );
        this.e1.setName( "e1" );
        this.e1.setEmployer( this.dep1 );
        this.e1.setSalary( 1234 );
//        this.comp.eResource().getContents().add(this.e1);
        this.e2 = CompanyFactory.eINSTANCE.createFreelance();
        this.e2.setAge( 42 );
        this.e2.setName( "e2" );
        this.e2.setAssignment( 9 );
        this.e2.setEmployer( this.dep1 );
        this.e2.setSalary( 1234 );
//        this.comp.eResource().getContents().add(this.e2);
        this.boss1 = CompanyFactory.eINSTANCE.createEmployee();
        this.boss1.setAge( 43 );
        this.boss1.setName( "boss1" );
        this.boss1.setEmployer( this.dep1 );
        this.boss1.setManaged( this.dep1 );
        this.boss1.setSalary( 1234 );
//        this.comp.eResource().getContents().add(this.boss1);

        this.e1.setEmployer( dep1 );
        this.e2.setEmployer( dep1 );
        this.boss1.setEmployer( dep1 );
        this.dep1.setBoss( this.boss1 );

        this.dep2 = CompanyFactory.eINSTANCE.createDepartment();
        this.dep2.setName( "Dep2" );
        this.dep2.setBudget( 12345567 );
        this.dep2.setMaxJuniors( 5 );
//        this.comp.eResource().getContents().add(this.dep2);

        this.e3 = CompanyFactory.eINSTANCE.createEmployee();
        this.e3.setAge( 42 );
        this.e3.setName( "e3" );
        this.e3.setEmployer( this.dep2 );
        this.e3.setSalary( 1234 );
//        this.comp.eResource().getContents().add(this.e3);
        this.e4 = CompanyFactory.eINSTANCE.createFreelance();
        this.e4.setAge( 42 );
        this.e4.setName( "e4" );
        this.e2.setAssignment( 9 );
        this.e4.setEmployer( this.dep2 );
        this.e4.setSalary( 1234 );
//        this.comp.eResource().getContents().add(this.e4);
        this.boss2 = CompanyFactory.eINSTANCE.createEmployee();
        this.boss2.setAge( 43 );
        this.boss2.setName( "boss2" );
        this.boss2.setEmployer( this.dep2 );
        this.boss2.setManaged( this.dep2 );
        this.boss2.setSalary( 1234 );
//        this.comp.eResource().getContents().add(this.boss2);

        this.e3.setEmployer( dep2 );
        this.e4.setEmployer( dep2 );
        this.boss2.setEmployer( dep2 );

        this.dep2.setBoss( this.boss2 );

        this.div.getDepartment( ).add( this.dep1 );
        this.div.getDepartment( ).add( this.dep2 );

    }

    /**
     * @param stmts
     * @param ia
     * @param notifyNewContectElements
     */
    private void createFilters(Set<OCLExpression> stmts, ImpactAnalyzer ia, boolean notifyNewContectElements) {
        //for caching purpose only
        for ( Iterator<OCLExpression> i = stmts.iterator(); i.hasNext();){
            ia.createFilterForExpression(i.next(), notifyNewContectElements);
        }
    }

    /**
     * Computes the set of affected context instances for event <tt>evt</tt>.
     * @param expressions list of the effected {@link OCLExpression}s
     * @param noti the event
     * @param ia the instance of ImpactAnalyzer used to filter <tt>evt</tt>.
     * @param context
     * @return a Collection of {@link EObject}s representing the affected context instances.
     */
    private Collection<EObject> computeAffectedInstances(Set<OCLExpression> expressions, Notification noti, ImpactAnalyzer ia, EClass context) {
        Collection<EObject> instances = new HashSet<EObject>();
        for(Iterator<OCLExpression> i = expressions.iterator(); i.hasNext();){           
            instances = ia.getContextObjects(noti, i.next(), context);
        }
        return instances;
    }

    /**
     * @param instances
     * @param expectedInstances
     */
    private void compareInstances( Collection<EObject> instances, EObject[] expectedInstances ) {

        Set<EObject> expected = new HashSet<EObject>( );
        for ( int i = 0; i < expectedInstances.length; i++ ) {
            expected.add( expectedInstances[i] );
        }

        if ( instances.containsAll( expected ) && instances.size( ) == expected.size( ) ) {
            System.out.println( ">> SUCCESS exact match\n" );
        } else if ( instances.containsAll( expected ) && instances.size( ) != expected.size( ) ) {
            System.out.println( ">> SUCCESS \n excess context instances:\n" );
            instances.removeAll( expected );
            for ( Iterator<EObject> i = instances.iterator( ); i.hasNext( ); ) {
                System.out.println( i.next( ) + "\n" );
            }
        } else {
            System.out.println( ">> FAILURE\n" );
            expected.removeAll(instances);
            for(EObject o: expected){
                System.out.print(o +"not in result");
            }
            System.out.println("");
            fail( "Returned instances does not match expected instances!" );
        }
    }

    //    /**
    //     * Unfortunately not all features can be tested with the department model
    //     */
    //    private void extendModel( ) {
    //
    //         for some tests we need some additional classes
    //         MofClass a = this.mofPackage.getModel().getMofClass().createMofClass();
    //         a.setName("A");
    //         MofClass b = this.mofPackage.getModel().getMofClass().createMofClass();
    //         a.setName("B");
    //         MofClass c = this.mofPackage.getModel().getMofClass().createMofClass();
    //         a.setName("C");
    //         MofClass d = this.mofPackage.getModel().getMofClass().createMofClass();
    //         a.setName("D");
    //         // B is a subtype of A
    //         b.getSupertypes().add(a);
    //         // D-B-Association
    //         Association db = this.mofPackage.getModel().getAssociation().createAssociation();
    //         db.setName("DB-Assocation");
    //         AssociationEnd toB = this.mofPackage.getModel().getAssociationEnd().createAssociationEnd();
    //         toB.setName("toB");
    //         toB.setType(b);
    //         toB.setMultiplicity(this.mofPackage.getModel().createMultiplicityType(0,-1,true,true));
    //         db.getContents().add(toB);
    //         AssociationEnd toD = this.mofPackage.getModel().getAssociationEnd().createAssociationEnd();
    //         toB.setName("toD");
    //         toB.setType(d);
    //         toB.setMultiplicity(this.mofPackage.getModel().createMultiplicityType(0,-1,true,true));
    //         db.getContents().add(toD);
    //         // A-C-Association
    //         Association ac = this.mofPackage.getModel().getAssociation().createAssociation();
    //         ac.setName("DB-Assocation");
    //         AssociationEnd toC = this.mofPackage.getModel().getAssociationEnd().createAssociationEnd();
    //         toC.setName("toC");
    //         toC.setType(c);
    //         toC.setMultiplicity(this.mofPackage.getModel().createMultiplicityType(0,-1,true,true));
    //         ac.getContents().add(toC);
    //         AssociationEnd toA = this.mofPackage.getModel().getAssociationEnd().createAssociationEnd();
    //         toA.setName("toA");
    //         toA.setType(a);
    //         toA.setMultiplicity(this.mofPackage.getModel().createMultiplicityType(0,-1,true,true));
    //         ac.getContents().add(toA);
    //         this.companyPackage.getContents().add(a);
    //         this.companyPackage.getContents().add(b);
    //         this.companyPackage.getContents().add(c);
    //         this.companyPackage.getContents().add(d);
    //         this.companyPackage.getContents().add(ac);
    //         this.companyPackage.getContents().add(db);
    //    }
}
