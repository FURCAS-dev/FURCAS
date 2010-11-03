package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.tests;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import junit.framework.AssertionFailedError;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ocl.ecore.ExpressionInOCL;
import org.eclipse.ocl.ecore.OCLExpression;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import company.CompanyFactory;
import company.Department;
import company.Division;
import company.Employee;
import company.Freelance;
import company.Student;

import de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzerFactory;
import de.hpi.sam.bp2009.solution.impactAnalyzer.OCLWithHiddenOppositesFactory;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.notifications.NotificationHelper;
import de.hpi.sam.bp2009.solution.impactAnalyzer.configuration.OptimizationActivation;
import de.hpi.sam.bp2009.solution.impactAnalyzer.tests.helper.BaseDepartmentTest;

/**
 * Tests whether the right context instances are computed. This is done as follows: A simple instance of the company model is
 * created. Each test tests only one statement. The statement is analyzed and a set of relevant events is generated and reported
 * to IA. The IA compute the affected context instances with the help of the InstanceScopeAnalysis. This set is then compared to a
 * set of expected context instances.
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
    private Student stud1;
    private Student stud2;

    @Override
    @Before
    public void setUp() {

        super.setUp();
        createInstances();
    }

    @Override
    @After
    public void tearDown() {
        EcoreUtil.delete(this.div);
        EcoreUtil.delete(this.dep1);
        EcoreUtil.delete(this.dep2);
        EcoreUtil.delete(this.e1);
        EcoreUtil.delete(this.e2);
        EcoreUtil.delete(this.e3);
        EcoreUtil.delete(this.e4);
        EcoreUtil.delete(this.boss1);
        EcoreUtil.delete(this.boss2);
        EcoreUtil.delete(this.director);
        EcoreUtil.delete(this.secretary);
        EcoreUtil.delete(this.stud1);
        EcoreUtil.delete(this.stud2);
        super.tearDown();
    }

    @Test
    public void testAnalysisOfASimpleRecursiveOperation() {
        // construct something like "new HumbaClass1().m()"
        final Department d1 = CompanyFactory.eINSTANCE.createDepartment();
        d1.setName("d1");
        d1.setBudget(10000);
        final Department d2 = CompanyFactory.eINSTANCE.createDepartment();
        d2.setName("d2");
        d2.setBudget(10000);
        final Department d3 = CompanyFactory.eINSTANCE.createDepartment();
        d3.setName("d3");
        d3.setBudget(10000);
        final Department d4 = CompanyFactory.eINSTANCE.createDepartment();
        d4.setName("d4");
        d4.setBudget(10000);
        d1.getSubDepartment().add(d2);
        d2.getSubDepartment().add(d3);
        d2.getSubDepartment().add(d4);
        this.comp.eResource().getContents().add(d1);
        Notification noti = NotificationHelper.createAttributeChangeNotification(d4, departmentBudget,
                d4.getBudget(), d4.getBudget()+1000);
        Collection<EObject> instances = computeAffectedInstances(this.getSumBudgetLimitAST(), noti);
        compareInstances(instances, new EObject[] { d1, d2, d4 });
    }

    @Test
    public void testBossHighestSalaryEmployeeSalaryChange() {

        // context Department inv BossHighestSalary:
        // self.employee->select(
        // e|e.salary >= self.boss.salary)->size() <= 1
        System.out.println("Testing BossHighestSalaryEmployeeSalaryChange\n");
        Notification noti;
        // change salary of an employee
        noti = NotificationHelper.createAttributeChangeNotification(this.e1, this.employeeSalary, this.e1.getSalary(),
                this.e1.getSalary()+1);
        Collection<EObject> instances = computeAffectedInstances(this.getBossHighestSalaryAST(), noti);
        compareInstances(instances, new EObject[] { this.dep1 });
    }

    @Test
    public void testBossHighestSalaryBossSalaryChange() {

        // context Department inv BossHighestSalary:
        // self.employee->select(
        // e|e.salary >= self.boss.salary)->size() <= 1
        System.out.println("Testing BossHighestSalaryBossSalaryChange\n");
        Notification noti;

        Collection<EObject> instances;

        // change salary of the boss
        noti = NotificationHelper.createAttributeChangeNotification(this.boss1, this.employeeSalary, this.boss1
                .getSalary(), this.boss1.getSalary()+1);
        instances = computeAffectedInstances(this.getBossHighestSalaryAST(), noti);
        compareInstances(instances, new EObject[] { this.dep1 });

    }

    @Test
    public void testBossHighestSalaryAddEmployee() {

        // context Department inv BossHighestSalary:
        // self.employee->select(
        // e|e.salary >= self.boss.salary)->size() <= 1
        System.out.println("Testing BossHighestSalaryAddEmployee\n");
        Notification noti;

        Collection<EObject> instances;
        // add new employee
        noti = NotificationHelper.createReferenceAddNotification(this.dep1, this.employeeRef, CompanyFactory.eINSTANCE
                .createEmployee());
        instances = computeAffectedInstances(this.getBossHighestSalaryAST(), noti);
        compareInstances(instances, new EObject[] { this.dep1 });
    }

    @Test
    public void testBossHighestSalaryAddBoss() {

        // context Department inv BossHighestSalary:
        // self.employee->select(
        // e|e.salary >= self.boss.salary)->size() <= 1
        System.out.println("Testing BossHighestSalaryAddBoss\n");
        Notification noti;

        Collection<EObject> instances;

        // add new boss
        noti = NotificationHelper.createReferenceAddNotification(this.dep1, this.bossRef, this.boss2);
        instances = computeAffectedInstances(this.getBossHighestSalaryAST(), noti);
        compareInstances(instances, new EObject[] { this.dep1 });
        System.out.println("--------------------------------------------------\n");
    }

    @Test
    public void testBossIsOldestEmployeeAgeChange() {

        // context Employee inv BossIsOldest:
        // self.age <= self.employer.boss.age
        System.out.println("Testing BossIsOldestEmployeeAgeChange\n");
        Collection<EObject> instances;
        Notification noti;

        // change age of an employee
        noti = NotificationHelper.createAttributeChangeNotification(this.e2, this.employeeAge, this.e2.getAge(),
                this.e2.getAge()+1);
        instances = computeAffectedInstances(this.getBossIsOldestAST(), noti);
        compareInstances(instances, new EObject[] { this.e2 });
    }

    @Test
    public void testBossIsOldestBossAgeChange() {

        // context Employee inv BossIsOldest:
        // self.age <= self.employer.boss.age
        System.out.println("Testing BossIsOldestBossAgeChange\n");
        Collection<EObject> instances;
        Notification noti;

        // change age of the boss
        noti = NotificationHelper.createAttributeChangeNotification(this.boss1, this.employeeAge, this.boss1.getAge(),
                this.boss1.getAge()+1);
        instances = computeAffectedInstances(this.getBossIsOldestAST(), noti);
        compareInstances(instances, new EObject[] { this.e1, this.e2, this.boss1, this.stud1 });

    }

    @Test
    public void testBossIsOldestAddEmployee() {

        // context Employee inv BossIsOldest:
        // self.age <= self.employer.boss.age
        System.out.println("Testing BossIsOldestAddEmployee\n");
        Set<EObject> expectedInstances = new HashSet<EObject>();
        expectedInstances.add(this.e2);
        
        Collection<EObject> instances;
        Notification noti;

        // add new employee
        noti = NotificationHelper.createReferenceAddNotification(this.e1, this.employerRef, this.dep2);
        instances = computeAffectedInstances(this.getBossIsOldestAST(), noti);
        compareInstances(instances, new EObject[] { this.e1 });

    }

    @Test
    public void testBossIsOldestAddBoss() {

        // context Employee inv BossIsOldest:
        // self.age <= self.employer.boss.age
        System.out.println("Testing BossIsOldestAddBoss\n");
        Set<EObject> expectedInstances = new HashSet<EObject>();
        expectedInstances.add(this.e2);
        
        Collection<EObject> instances;
        Notification noti;

        // add new boss
        noti = NotificationHelper.createReferenceAddNotification(this.dep1, this.bossRef, this.boss2);
        instances = computeAffectedInstances(this.getBossIsOldestAST(), noti);
        compareInstances(instances, new EObject[] { this.e1, this.e2, this.boss1, this.stud1 });

        System.out.println("--------------------------------------------------\n");
    }

    @Test
    public void testNotBossFreelance() {

        // context Department
        // inv NotBossFreelance:
        // not self.boss.oclIsTypeOf(Freelance)
        System.out.println("Testing NotBossFreelance\n");
        Notification noti = null;
        
        // add new boss
        noti = NotificationHelper.createReferenceAddNotification(this.dep2, this.bossRef, this.boss1);
        Collection<EObject> instances = computeAffectedInstances(this.getNotBossFreelanceAST(), noti);
        compareInstances(instances, new EObject[] { this.dep2 });
        System.out.println("--------------------------------------------------\n");
    }

    @Test
    public void testOldEmployeeEmployeeAgeChange() {

        // context Department
        // inv OldEmployee:
        // self.employee->exists(e | e.age > 45)
        System.out.println("Testing OldEmployeeEmployeeAgeChange\n");
        
        Notification noti;
        Collection<EObject> instances;
        // change age of an employee
        noti = NotificationHelper.createAttributeChangeNotification(this.e2, this.employeeAge, this.e2.getAge(),
                this.e2.getAge()+30);
        instances = computeAffectedInstances(this.getOldEmployeeAST(), noti);
        compareInstances(instances, new EObject[] { this.dep1 });

    }

    @Test
    public void testOldEmployeeBossAgeChange() {

        // context Department
        // inv OldEmployee:
        // self.employee->exists(e | e.age > 45)
        System.out.println("Testing OldEmployeeBossAgeChange\n");
        
        Notification noti;
        Collection<EObject> instances;
        // change age of the boss
        noti = NotificationHelper.createAttributeChangeNotification(this.boss1, this.employeeAge, this.boss1.getAge(),
                this.boss1.getAge()+30);
        instances = computeAffectedInstances(this.getOldEmployeeAST(), noti);
        compareInstances(instances, new EObject[] { this.dep1 });
    }

    @Test
    public void testOldEmployeeAddEmployee() {

        // context Department
        // inv OldEmployee:
        // self.employee->exists(e | e.age > 45)
        System.out.println("Testing OldEmployeeAddEmployee\n");
        
        Notification noti;
        Collection<EObject> instances;

        Employee newEmployee = CompanyFactory.eINSTANCE.createEmployee();
        newEmployee.setAge(46);
        // add new employee
        noti = NotificationHelper.createReferenceAddNotification(this.dep1, this.employeeRef, newEmployee);
        instances = computeAffectedInstances(this.getOldEmployeeAST(), noti);
        compareInstances(instances, new EObject[] { this.dep1 });
        System.out.println("--------------------------------------------------\n");
    }

    @Test
    public void testUniqueNamesEmployeeNameChange() {

        // context Employee
        // inv UniqueNames:
        // Employee.allInstances()->forAll(e |
        // e <> self implies e.name <> self.name)
        System.out.println("Testing UniqueNamesEmployeeNameChange\n");

        // change name of an employee
        // this does not trigger the allInstances change handling
        Notification noti = NotificationHelper.createAttributeChangeNotification(this.e2, this.employeeName, this.e2.getName(),
                this.e2.getName()+"Humba");

        Collection<EObject> instances = computeAffectedInstances(this.getUniqueNamesAST(), noti);
        compareInstances(instances, new EObject[] { this.e1, this.e2, this.e3, this.e4, this.boss1, this.boss2, this.director,
                this.secretary, this.stud1, this.stud2 });
    }
    
    @Test
    public void testUniqueNamesEmployeeAdd() {

        // context Employee
        // inv UniqueNames:
        // Employee.allInstances()->forAll(e |
        // e <> self implies e.name <> self.name)
        System.out.println("Testing UniqueNamesEmployeeAdd\n");

        // add a new employee
        Employee newEmployee = CompanyFactory.eINSTANCE.createEmployee();
        Notification noti = NotificationHelper.createElementAddNotification( rs.getResources().iterator().next(), null, (EObject)newEmployee);

        Collection<EObject> instances = computeAffectedInstances(this.getUniqueNamesAST(), noti);
        compareInstances(instances, new EObject[] { this.e1, this.e2, this.e3, this.e4, this.boss1, this.boss2, this.director,
                this.secretary, this.stud1, this.stud2, newEmployee });
        // remove the added employee to prevent him from appearing in other test cases
        EcoreUtil.delete(newEmployee);
    }
    
    @Test
    public void testUniqueNamesEmployeeRemove() {
        // context Employee
        // inv UniqueNames:
        // Employee.allInstances()->forAll(e |
        // e <> self implies e.name <> self.name)
        System.out.println("Testing UniqueNamesEmployeeRemove\n");
        // remove an employee
        Notification noti = NotificationHelper.createElementDeleteNotification( this.e1 );
        Collection<EObject> instances = computeAffectedInstances(this.getUniqueNamesAST(), noti);
        compareInstances(instances, new EObject[] { this.e2, this.e3, this.e4, this.boss1, this.boss2, this.director,
                this.secretary, this.stud1, this.stud2});
        
        System.out.println("--------------------------------------------------\n");
    }

    @Test
    public void testValidAssignment() {

        // context Freelance
        // inv ValidAssignment:
        // self.assignment >= 5 and self.assignment <= 30
        System.out.println("Testing ValidAssignment\n");

        // change age of an employee far enough
        Notification noti = NotificationHelper.createAttributeChangeNotification(this.e4, this.freelanceAssignment, 
                this.e4.getAssignment(), 31);
        Collection<EObject> instances = computeAffectedInstances(this.getValidAssignmentAST(), noti);
        compareInstances(instances, new EObject[] { this.e4 });

        // change age of an employee not far enough
        Notification noti2 = NotificationHelper.createAttributeChangeNotification(this.e4, this.freelanceAssignment, 
                this.e4.getAssignment(), 29);
        Collection<EObject> instances2 = computeAffectedInstances(this.getValidAssignmentAST(), noti2);
        compareInstances(instances2, new EObject[] { });
        System.out.println("--------------------------------------------------\n");

    }

    @Test
    public void testMaxJuniorsEmployeeAgeChange() {

        // context Department inv MaxJuniors:
        // self.employee->select(e|e.age < 25)->size() < self.maxJuniors
        System.out.println("Testing MaxJuniorsEmployeeAgeChange\n");
        Notification noti;
        Collection<EObject> instances;
        // change age of an employee so that it now falls under 25
        noti = NotificationHelper.createAttributeChangeNotification(this.e2, this.employeeAge, this.e2.getAge(),
                23);
        instances = computeAffectedInstances(this.getMaxJuniorsAST(), noti);
        compareInstances(instances, new EObject[] { this.dep1 });

        // change age of an employee so that it does not fall under 25
        noti = NotificationHelper.createAttributeChangeNotification(this.e2, this.employeeAge, this.e2.getAge(),
                this.e2.getAge()+1);
        instances = computeAffectedInstances(this.getMaxJuniorsAST(), noti);
        compareInstances(instances, new EObject[] { });
    }

    @Test
    public void testMaxJuniorsDepartmentMaxJuniorsChange() {

        // context Department inv MaxJuniors:
        // self.employee->select(e|e.age < 25)->size() < self.maxJuniors
        System.out.println("Testing MaxJuniorsDepartmentMaxJuniorsChange\n");
        Notification noti;
        Collection<EObject> instances;

        // change maxJuniors of a Department
        noti = NotificationHelper.createAttributeChangeNotification(this.dep1, this.departmentMaxJuniors, this.dep1
                .getMaxJuniors(), this.dep1.getMaxJuniors()+1);
        instances = computeAffectedInstances(this.getMaxJuniorsAST(), noti);
        compareInstances(instances, new EObject[] { this.dep1 });

    }

    @Test
    public void testMaxJuniorsAddEmployee() {

        // context Department inv MaxJuniors:
        // self.employee->select(e|e.age < 25)->size() < self.maxJuniors
        System.out.println("Testing MaxJuniorsAddEmployee\n");
        Notification noti;
        Collection<EObject> instances;

        // add new employee
        noti = NotificationHelper.createReferenceAddNotification(this.dep1, this.employeeRef, CompanyFactory.eINSTANCE
                .createEmployee());
        instances = computeAffectedInstances(this.getMaxJuniorsAST(), noti);
        compareInstances(instances, new EObject[] { this.dep1 });

        System.out.println("--------------------------------------------------\n");

    }

    @Test
    public void testNastyConstraintAddDepartment() {

        // context Division
        // inv nasty:
        // self.department->collect(d|
        // d.employee->including(d.boss)).salary->sum() < budget";
        System.out.println("Testing nastyAddDepartment\n");

        Notification noti;
        Collection<EObject> instances;

        // add new department
        noti = NotificationHelper.createReferenceAddNotification(this.div, this.departmentRef, CompanyFactory.eINSTANCE
                .createDepartment());
        instances = computeAffectedInstances(this.getNastyConstraintAST(), noti);
        compareInstances(instances, new EObject[] { this.div });

    }

    @Test
    public void testNastyConstraintAddEmployee() {

        // context Division
        // inv nasty:
        // self.department->collect(d|
        // d.employee->including(d.boss)).salary->sum() < budget";
        System.out.println("Testing nastyAddEmployee\n");

        Notification noti;
        Collection<EObject> instances;

        // add new employee
        noti = NotificationHelper.createReferenceAddNotification(this.dep1, this.employeeRef, CompanyFactory.eINSTANCE
                .createEmployee());
        instances = computeAffectedInstances(this.getNastyConstraintAST(), noti);
        compareInstances(instances, new EObject[] { this.div });

    }

    @Test
    public void testNastyConstraintAddBoss() {

        // context Division
        // inv nasty:
        // self.department->collect(d|
        // d.employee->including(d.boss)).salary->sum() < budget";
        System.out.println("Testing nastyAddBoss\n");
        Notification noti;
        Collection<EObject> instances;

        // add new boss
        noti = NotificationHelper.createReferenceAddNotification(this.dep1, this.bossRef, this.boss2);
        instances = computeAffectedInstances(this.getNastyConstraintAST(), noti);
        compareInstances(instances, new EObject[] { this.div });

    }

    @Test
    public void testNastyConstraintEmployeeSalaryChange() {

        // context Division
        // inv nasty:
        // self.department->collect(d|
        // d.employee->including(d.boss)).salary->sum() < budget";
        System.out.println("Testing nastyEmployeeSalaryChange\n");

        Notification noti;
        Collection<EObject> instances;

        // change salary of an employee
        noti = NotificationHelper.createAttributeChangeNotification(this.e1, this.employeeSalary, this.e1.getSalary(),
                this.e1.getSalary()+1);
        instances = computeAffectedInstances(this.getNastyConstraintAST(), noti);
        compareInstances(instances, new EObject[] { this.div });

    }

    @Test
    public void testNastyConstraintBossSalaryChange() {

        // context Division
        // inv nasty:
        // self.department->collect(d|
        // d.employee->including(d.boss)).salary->sum() < budget";
        System.out.println("Testing nastyBossSalaryChange\n");
        Notification noti;
        Collection<EObject> instances;

        // change salary of the boss
        noti = NotificationHelper.createAttributeChangeNotification(this.boss1, this.employeeSalary, this.boss1
                .getSalary(), this.boss1.getSalary()+1);
        instances = computeAffectedInstances(this.getNastyConstraintAST(), noti);
        compareInstances(instances, new EObject[] { this.div });

    }

    @Test
    public void testNastyConstraintDivisionBudgetChange() {

        // context Division
        // inv nasty:
        // self.department->collect(d|
        // d.employee->including(d.boss)).salary->sum() < budget";
        System.out.println("Testing nastyDivisionBudgetChange\n");
        Notification noti;
        Collection<EObject> instances;

        // change budget of the division
        noti = NotificationHelper.createAttributeChangeNotification(this.div, this.divisionBudget,
                this.div.getBudget(), this.div.getBudget()+1);
        instances = computeAffectedInstances(this.getNastyConstraintAST(), noti);
        compareInstances(instances, new EObject[] { this.div });

        System.out.println("--------------------------------------------------\n");
    }

    @Test
    public void testSecretaryOlderThanBossAddDirector() {

        // context Employee \n"
        // inv secretaryOlderThanBoss: \n"
        // if self.directed->notEmpty() and \n"
        // not self.secretary.oclIsUndefined() then \n"
        // self.age < self.secretary.age \n"
        // else true \n"
        // endif";
        System.out.println("Testing secretaryOlderThanBossAddDirector\n");
        Notification noti;
        Collection<EObject> instances;

        // add new director
        noti = NotificationHelper.createReferenceAddNotification(this.director, this.directedRef, CompanyFactory.eINSTANCE.createDivision());
        instances = computeAffectedInstances(this.getSecretaryOlderThanBossAST(), noti);
        compareInstances(instances, new EObject[] { this.director });
    }

    @Test
    public void testSecretaryOlderThanBossRemoveDirector() {

        // context Employee \n"
        // inv secretaryOlderThanBoss: \n"
        // if self.directed->notEmpty() and \n"
        // not self.secretary.oclIsUndefined() then \n"
        // self.age < self.secretary.age \n"
        // else true \n"
        // endif";
        System.out.println("Testing secretaryOlderThanBossRemoveDirector\n");
        Notification noti;
        Collection<EObject> instances;

        // remove director
        noti = NotificationHelper.createReferenceRemoveNotification(this.director, this.directedRef, this.div);
        instances = computeAffectedInstances(this.getSecretaryOlderThanBossAST(), noti);
        compareInstances(instances, new EObject[] { this.director });

    }

    @Test
    public void testSecretaryOlderThanBossDirectorSecretaryChange() {

        // context Employee \n"
        // inv secretaryOlderThanBoss: \n"
        // if self.directed->notEmpty() and \n"
        // not self.secretary.oclIsUndefined() then \n"
        // self.age < self.secretary.age \n"
        // else true \n"
        // endif";
        System.out.println("Testing secretaryOlderThanBossDirectorSecretaryChange\n");
        Notification noti;
        Collection<EObject> instances;

        // change secretary of the director
        Employee newEmployee = CompanyFactory.eINSTANCE.createEmployee();
        noti = NotificationHelper.createReferenceChangeNotification(this.director, this.employeeSecretary, this.director
                .getSecretary(), newEmployee);
        instances = computeAffectedInstances(this.getSecretaryOlderThanBossAST(), noti);
        compareInstances(instances, new EObject[] { this.director });

    }

    @Test
    public void testSecretaryOlderThanBossSecretaryAgeChange() {

        // context Employee \n"
        // inv secretaryOlderThanBoss: \n"
        // if self.directed->notEmpty() and \n"
        // not self.secretary.oclIsUndefined() then \n"
        // self.age < self.secretary.age \n"
        // else true \n"
        // endif";
        System.out.println("Testing secretaryOlderThanBossSecretaryAgeChange\n");
        Notification noti;
        Collection<EObject> instances;

        // change age of secretary
        noti = NotificationHelper.createAttributeChangeNotification(this.secretary, this.employeeAge, this.secretary
                .getAge(), this.secretary.getAge()+1);
        instances = computeAffectedInstances(this.getSecretaryOlderThanBossAST(), noti);
        if (OptimizationActivation.getOption().isUnusedDetectionActive()) {
            compareInstances(instances, new EObject[] {} ); // change is in unused if-branch
        } else {
            compareInstances(instances, new EObject[] { this.director, this.secretary });
        }
    }

    @Test
    public void testSecretaryOlderThanBossDirectorAgeChange() {

        // context Employee \n"
        // inv secretaryOlderThanBoss: \n"
        // if self.directed->notEmpty() and \n"
        // not self.secretary.oclIsUndefined() then \n"
        // self.age < self.secretary.age \n"
        // else true \n"
        // endif";
        System.out.println("Testing secretaryOlderThanBossDirectorAgeChange\n");
        Notification noti;
        Collection<EObject> instances;

        // change age of director
        noti = NotificationHelper.createAttributeChangeNotification(this.director, this.employeeAge, this.director
                .getAge(), this.director.getAge()+1);
        instances = computeAffectedInstances(this.getSecretaryOlderThanBossAST(), noti);
        compareInstances(instances, new EObject[] { this.director });

        System.out.println("--------------------------------------------------\n");
    }

    @Test
    public void testBoss10YearsOlderThanJuniorEmployeeAgeChange() {

        // context Department \n"
        // inv boss10YearsOlderThanJunior: \n"
        // let t:Tuple(boss:Employee,junior:Employee)="
        // Tuple{boss=self.boss, junior=self.employee->sortedBy(age)->first()} in \n"
        // t.boss.age > t.junior.age + 10";
        System.out.println("Testing boss10YearsOlderThanJuniorEmployeeAgeChange\n");
        Notification noti;
        Collection<EObject> instances;

        // change age of employee
        noti = NotificationHelper.createAttributeChangeNotification(this.e1, this.employeeAge, 42, 1);
        instances = computeAffectedInstances(this.getBoss10YearsOlderThanJuniorAST(), noti);
        compareInstances(instances, new EObject[] { this.e1.getEmployer() });
    }

    @Test
    public void testBoss10YearsOlderThanJuniorBossAgeChange() {

        // context Department \n"
        // inv boss10YearsOlderThanJunior: \n"
        // let t:Tuple(boss:Employee,junior:Employee)="
        // Tuple{boss=self.boss, junior=self.employee->sortedBy(age)->first()} in \n"
        // t.boss.age > t.junior.age + 10";
        System.out.println("Testing boss10YearsOlderThanJuniorBossAgeChange\n");
        Notification noti;
        Collection<EObject> instances;

        // change age of boss
        noti = NotificationHelper.createAttributeChangeNotification(this.boss1, this.employeeAge, 42, 52);
        instances = computeAffectedInstances(this.getBoss10YearsOlderThanJuniorAST(), noti);
        compareInstances(instances, new EObject[] { this.e1.getEmployer() });

        System.out.println("--------------------------------------------------\n");
    }

    @Test
    public void testCompareBossSalaryToJuniorSalaryBossChange() {
        // context Department \n"
        // inv compareBossSalaryToJuniorSalary: \n"
        // let t:Tuple(boss:Tuple(person:Employee, salary:Integer), junior:Tuple(person:Employee, salary:Integer))="
        // Tuple{Tuple{self.boss, self.boss.salary}, Tuple{self.employee->sortedBy(age)->first(),
        // self.employee->sortedBy(age)->first().salary}} in \n"
        // t.boss.person <> t.junior.person implies t.boss.salary > t.junior.salary + 100";
        System.out.println("Testing compareBossSalaryToJuniorSalaryBossChange\n");
        Notification noti;
        Collection<EObject> instances;

        // change boss of department
        noti = NotificationHelper.createReferenceChangeNotification(this.dep1, this.bossRef, CompanyFactory.eINSTANCE
                .createEmployee(), this.e1);
        instances = computeAffectedInstances(this.getCompareBossSalaryToJuniorSalaryAST(), noti);
        compareInstances(instances, new EObject[] { this.dep1 });
    }

    @Test
    public void testCompareBossSalaryToJuniorSalaryEmployeeSalaryChange() {
        // context Department \n"
        // inv compareBossSalaryToJuniorSalary: \n"
        // let t:Tuple(boss:Tuple(person:Employee, salary:Integer), junior:Tuple(person:Employee, salary:Integer))="
        // Tuple{Tuple{self.boss, self.boss.salary}, Tuple{self.employee->sortedBy(age)->first(),
        // self.employee->sortedBy(age)->first().salary}} in \n"
        // t.boss.person <> t.junior.person implies t.boss.salary > t.junior.salary + 100";
        System.out.println("Testing compareBossSalaryToJuniorSalaryEmployeeSalaryChange\n");
        Notification noti;
        Collection<EObject> instances;

        // change salary of employee
        noti = NotificationHelper
                .createAttributeChangeNotification(this.e1, this.employeeSalary, 1234, 12345);
        instances = computeAffectedInstances(this.getCompareBossSalaryToJuniorSalaryAST(), noti);
        compareInstances(instances, new EObject[] { this.dep1 });
    }

    @Test
    public void testCompareBossSalaryToJuniorSalaryEmployeeAgeChange() {
        // context Department \n"
        // inv compareBossSalaryToJuniorSalary: \n"
        // let t:Tuple(boss:Tuple(person:Employee, salary:Integer), junior:Tuple(person:Employee, salary:Integer))="
        // Tuple{Tuple{self.boss, self.boss.salary}, Tuple{self.employee->sortedBy(age)->first(),
        // self.employee->sortedBy(age)->first().salary}} in \n"
        // t.boss.person <> t.junior.person implies t.boss.salary > t.junior.salary + 100";
        System.out.println("Testing compareBossSalaryToJuniorSalaryEmployeeAgeChange\n");
        Notification noti;
        Collection<EObject> instances;

        // change age of employee
        noti = NotificationHelper.createAttributeChangeNotification(this.e1, this.employeeAge, 23, 34);
        instances = computeAffectedInstances(this.getCompareBossSalaryToJuniorSalaryAST(), noti);
        compareInstances(instances, new EObject[] { this.dep1 });
    }

    @Test
    public void testCompareBossSalaryToJuniorSalaryEmployeeAdd() {
        // context Department \n"
        // inv compareBossSalaryToJuniorSalary: \n"
        // let t:Tuple(boss:Tuple(person:Employee, salary:Integer), junior:Tuple(person:Employee, salary:Integer))="
        // Tuple{Tuple{self.boss, self.boss.salary}, Tuple{self.employee->sortedBy(age)->first(),
        // self.employee->sortedBy(age)->first().salary}} in \n"
        // t.boss.person <> t.junior.person implies t.boss.salary > t.junior.salary + 100";
        System.out.println("Testing compareBossSalaryToJuniorSalaryEmployeeAdd\n");
        Notification noti;
        Collection<EObject> instances;

        // add new employee
        noti = NotificationHelper.createReferenceChangeNotification(this.dep1, this.employeeRef, null, this.e3);
        instances = computeAffectedInstances(this.getCompareBossSalaryToJuniorSalaryAST(), noti);
        compareInstances(instances, new EObject[] { this.dep1 });
    }

    @Test
    public void testCompareBossSalaryToJuniorSalaryEmployeeRemove() {
        // context Department \n"
        // inv compareBossSalaryToJuniorSalary: \n"
        // let t:Tuple(boss:Tuple(person:Employee, salary:Integer), junior:Tuple(person:Employee, salary:Integer))="
        // Tuple{Tuple{self.boss, self.boss.salary}, Tuple{self.employee->sortedBy(age)->first(),
        // self.employee->sortedBy(age)->first().salary}} in \n"
        // t.boss.person <> t.junior.person implies t.boss.salary > t.junior.salary + 100";
        System.out.println("Testing compareBossSalaryToJuniorSalaryEmployeeRemove\n");
        Notification noti;
        Collection<EObject> instances;

        // remove employee
        noti = NotificationHelper.createReferenceChangeNotification(this.dep1, this.employeeRef, this.e1, null);
        instances = computeAffectedInstances(this.getCompareBossSalaryToJuniorSalaryAST(), noti);
        compareInstances(instances, new EObject[] { this.dep1 });

        System.out.println("--------------------------------------------------\n");

    }

    @Test
    public void testEmployeeInSameDepartmentAsInternEmployeeAdd() {
        // context Employee \n"
        // inv employeeInSameDepartmentAsIntern: \n"
        // self.employer = self.intern.employer";

        System.out.println("Testing employeeInSameDepartmentAsInternEmployeeAdd\n");
        // add Employee
        final Employee newEmployee = CompanyFactory.eINSTANCE.createEmployee();
        final boolean[] result = new boolean[1];
        newEmployee.setIntern(this.stud2);
        newEmployee.eAdapters().add(new AdapterImpl() {
            @Override
            public void notifyChanged(Notification notification) {
                Collection<EObject> instances = computeAffectedInstances(getEmployeeInSameDepartmentAsInternAST(), notification);
                try {
                    compareInstances(instances, new EObject[] { newEmployee });
                    result[0] = true;
                } catch (AssertionFailedError e) {
                    result[0] = false;
                }
            }
        });
        this.dep1.getEmployee().add(newEmployee);
        assertTrue(result[0]);
        // this notification is actually an ElementLifeCycleEvent which is not handled correctly atm
        // noti = NotificationHelper.createReferenceAddNotification(this.dep1, this.employeeRef, newEmployee);
    }

    @Test
    public void testEmployeeInSameDepartmentAsInternEmployeeInternChange() {
        // context Employee \n"
        // inv employeeInSameDepartmentAsIntern: \n"
        // self.employer = self.intern.employer";

        System.out.println("Testing employeeInSameDepartmentAsInternEmployeeInternChange\n");
        Notification noti;
        Collection<EObject> instances;

        // change intern reference
        Student newStudent = CompanyFactory.eINSTANCE.createStudent();
        newStudent.setEmployer(dep2);
        noti = NotificationHelper.createReferenceChangeNotification(this.e1, this.internRef, this.stud1, newStudent);
        instances = computeAffectedInstances(this.getEmployeeInSameDepartmentAsInternAST(), noti);
        compareInstances(instances, new EObject[] { this.e1 });

    }

    @Test
    public void testEmployeeInSameDepartmentAsInternEmployeeEmployerChange() {
        // context Employee \n"
        // inv employeeInSameDepartmentAsIntern: \n"
        // self.employer = self.intern.employer";

        System.out.println("Testing employeeInSameDepartmentAsInternEmployeeEmployerChange\n");
        Notification noti;
        Collection<EObject> instances;

        // change employer reference
        noti = NotificationHelper.createReferenceChangeNotification(this.e1, this.employerRef, this.dep1, this.dep2);
        instances = computeAffectedInstances(this.getEmployeeInSameDepartmentAsInternAST(), noti);
        compareInstances(instances, new EObject[] { this.e1 });

    }

    @Test
    public void testEmployeeInSameDepartmentAsInternStudentEmployerChange() {
        // context Employee \n"
        // inv employeeInSameDepartmentAsIntern: \n"
        // self.employer = self.intern.employer";

        System.out.println("Testing employeeInSameDepartmentAsInternStudentEmployerChange\n");
        Notification noti;
        Collection<EObject> instances;

        // change employer reference
        noti = NotificationHelper.createReferenceChangeNotification(this.stud1, this.employerRef, this.dep1, this.dep2);
        instances = computeAffectedInstances(this.getEmployeeInSameDepartmentAsInternAST(), noti);
        // since student is a subclass of employee (and therefore could have own interns), the impact of the above change also
        // includes stud1
        compareInstances(instances, new EObject[] { this.e1, this.stud1 });

        System.out.println("--------------------------------------------------\n");

    }
    
    @Test
    public void testCheckForBob() {

        System.out.println("Testing checkForBob\n");
        Notification noti;
        Collection<EObject> instances;

        // change employee name
        noti = NotificationHelper.createAttributeChangeNotification(this.e1, this.employeeName, "e1", "Bob");
        instances = computeAffectedInstances(this.getCheckForBobAST(), noti);
        compareInstances(instances, new EObject[] { this.e1 , this.e2, this.e3, this.e4, this.secretary, this.boss1, this.boss2, this.director, this.stud1, this.stud2});

        System.out.println("--------------------------------------------------\n");

    }
    
    @Test
    public void testDerivedPropertyHandlingIndirect(){
        System.out.println("Testing derivedPropertyHandling\n");
        Notification noti;
        Collection<EObject> instances;
        
        // Make e1 the employee of the month of div by making him the employee of the month of dep1.
        // That should influence the derived property Department.employeesOfTheMonth but this feature isn't implemented by default.
        // TODO implement a derived Property Notifier and apply it here to generate an impact via some sort of follow up notification.
        noti = NotificationHelper.createReferenceAddNotification(this.dep1, this.departmentEmployeeOfTheMonth, this.e1);
        instances = computeAffectedInstances(this.getLimitEmployeesOfTheMonthAST(), noti);
        compareInstances(instances, new EObject[] {});

    }
    
    @Test
    public void testDerivedPropertyHandlingDirect(){
        Notification noti;
        
        // Make e1 the employee of the month of div by directly manipulating the derived property.
        // Since the derived property is unmodifiable, this should return null.
        noti = NotificationHelper.createReferenceAddNotification(this.div, this.divisionEmployeesOfTheMonth, this.e1);
        assertTrue(noti == null);
        
        System.out.println("--------------------------------------------------\n");
    }



    // @Test
    // public void testDepartmentAlwaysInDivision(){
    //        
    // // context Department \n"
    // // inv departmentMustHaveDivision: \n"
    // // self.department2division->notEmpty()";
    // System.out.println("Testing departmentAlwaysInDivision\n");
    // Set<OCLExpression> stmts = new HashSet<OCLExpression>();
    // stmts.add(this.getdepartmentMustHaveDivisionAST());
    // 
    // 
    //        
    // Notification noti;
    // Collection<EObject> instances;
    //        
    // // create new department
    // EObject newElem = this.comp.getEFactoryInstance().create(this.department);
    // noti = NotificationHelper.createNewElementAddToResourceNotification(newElem, rs.getResources().iterator().next());
    // instances = computeAffectedInstances(TODO, noti);
    // compareInstances( instances, new EObject[] { newElem } );
    // // add department to division
    // // remove department from division
    // }

    /**
     * Creates an instance of the company model ie 2 instances of Department with e employees and one boss each.
     */
    private void createInstances() {

        this.div = CompanyFactory.eINSTANCE.createDivision();
        this.div.setBudget(1234567);
        this.div.setName("Div1");
        this.rs = new ResourceSetImpl();
        Resource r = this.rs.createResource(URI.createURI("http://rev/path/computation/test"));
        r.eAdapters().add(new ECrossReferenceAdapter());
        this.rs.getResources().add(r);
        r.getContents().add(this.div);

        this.director = CompanyFactory.eINSTANCE.createEmployee();
        this.director.setAge(42);
        this.director.setName("Director");
        this.director.setDirected(this.div);
        this.director.setSalary(1234);
        this.div.setDirector(this.director);

        this.secretary = CompanyFactory.eINSTANCE.createEmployee();
        this.secretary.setAge(55);
        this.secretary.setName("Secretary");
        this.secretary.setSalary(1234);
        this.secretary.setEmployer(this.dep1);
        this.director.setSecretary(this.secretary);

        this.dep1 = CompanyFactory.eINSTANCE.createDepartment();
        this.dep1.setName("Dep1");
        this.dep1.setBudget(12345567);
        this.dep1.setMaxJuniors(5);
        this.e1 = CompanyFactory.eINSTANCE.createEmployee();
        this.e1.setAge(42);
        this.e1.setName("e1");
        this.e1.setEmployer(this.dep1);
        this.e1.setSalary(1234);
        this.e2 = CompanyFactory.eINSTANCE.createFreelance();
        this.e2.setAge(42);
        this.e2.setName("e2");
        this.e2.setAssignment(9);
        this.e2.setEmployer(this.dep1);
        this.e2.setSalary(1234);
        this.boss1 = CompanyFactory.eINSTANCE.createFreelance();
        this.boss1.setAge(43);
        this.boss1.setName("boss1");
        this.boss1.setEmployer(this.dep1);
        this.boss1.setManaged(this.dep1);
        this.boss1.setSalary(1234);
        this.dep1.setBoss(this.boss1);

        this.stud1 = CompanyFactory.eINSTANCE.createStudent();
        this.stud1.setAge(22);
        this.stud1.setName("stud1");
        this.stud1.setSalary(234);
        this.stud1.setEmployer(this.dep1);
        this.e1.setIntern(this.stud1);

        this.dep2 = CompanyFactory.eINSTANCE.createDepartment();
        this.dep2.setName("Dep2");
        this.dep2.setBudget(12345567);
        this.dep2.setMaxJuniors(5);

        this.e3 = CompanyFactory.eINSTANCE.createEmployee();
        this.e3.setAge(42);
        this.e3.setName("e3");
        this.e3.setEmployer(this.dep2);
        this.e3.setSalary(1234);
        this.e4 = CompanyFactory.eINSTANCE.createFreelance();
        this.e4.setAge(42);
        this.e4.setName("e4");
        this.e2.setAssignment(9);
        this.e4.setEmployer(this.dep2);
        this.e4.setSalary(1234);
        this.boss2 = CompanyFactory.eINSTANCE.createEmployee();
        this.boss2.setAge(44);
        this.boss2.setName("boss2");
        this.boss2.setEmployer(this.dep2);
        this.boss2.setManaged(this.dep2);
        this.boss2.setSalary(2345);
        this.dep2.setBoss(this.boss2);

        this.stud2 = CompanyFactory.eINSTANCE.createStudent();
        this.stud2.setAge(23);
        this.stud2.setName("stud2");
        this.stud2.setSalary(234);
        this.stud2.setEmployer(this.dep2);
        this.e3.setIntern(this.stud2);

        this.div.getDepartment().add(this.dep1);
        this.div.getDepartment().add(this.dep2);

    }

    /**
     * Computes the set of affected context instances for event <tt>evt</tt>.
     * 
     * @param expressions
     *            list of the effected {@link OCLExpression}s
     * @param noti
     *            the event
     * @param context
     * @return a Collection of {@link EObject}s representing the affected context instances.
     */
    private Collection<EObject> computeAffectedInstances(ExpressionInOCL eiocl, Notification noti) {
        return ImpactAnalyzerFactory.INSTANCE.createImpactAnalyzer((OCLExpression) eiocl.getBodyExpression(),
                (EClass) eiocl.getContextVariable().getType(), /* notifyOnNewContextElements */ false,
                new OCLWithHiddenOppositesFactory())
                .getContextObjects(noti);
    }

    /**
     * @param instances
     * @param expectedInstances
     */
    private void compareInstances(Collection<EObject> instances, EObject[] expectedInstances) {
        Set<EObject> expected = new HashSet<EObject>();
        for (int i = 0; i < expectedInstances.length; i++) {
            expected.add(expectedInstances[i]);
        }
        if (instances.containsAll(expected) && instances.size() == expected.size()) {
            System.out.println(">> SUCCESS exact match\n");
        } else if (instances.containsAll(expected) && instances.size() != expected.size()) {
            System.out.println(">> SUCCESS \n excess context instances:\n");
            instances.removeAll(expected);
            for (Iterator<EObject> i = instances.iterator(); i.hasNext();) {
                System.out.println(i.next() + "\n");
            }
        } else {
            System.out.println(">> FAILURE\n");
            expected.removeAll(instances);
            for (EObject o : expected) {
                System.out.print(o + "not in result");
            }
            System.out.println("");
            fail("Returned instances does not match expected instances!");
        }
    }

    // /**
    // * Unfortunately not all features can be tested with the department model
    // */
    // private void extendModel( ) {
    //
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
    // }
}
