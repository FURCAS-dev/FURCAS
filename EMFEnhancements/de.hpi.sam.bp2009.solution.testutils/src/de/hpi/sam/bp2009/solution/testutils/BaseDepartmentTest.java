/*******************************************************************************
 * Copyright (c) 2009, 2010 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package de.hpi.sam.bp2009.solution.testutils;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import junit.framework.TestCase;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.ocl.OCLInput;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.ExpressionInOCL;
import org.eclipse.ocl.ecore.OCL;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;

import com.sap.emf.ocl.hiddenopposites.EcoreEnvironmentFactoryWithHiddenOpposites;
import com.sap.emf.ocl.hiddenopposites.OCLWithHiddenOpposites;
import company.CompanyFactory;
import company.CompanyPackage;
import company.Employee;
import company.Freelance;
import company.impl.DepartmentImpl;
import company.impl.DivisionImpl;
import company.impl.EmployeeImpl;
import company.impl.FreelanceImpl;

/**
 * This is the super class for all tests based on the Department model.
 */
@Ignore
public class BaseDepartmentTest extends TestCase {

    protected ResourceSet rs = null;
    /**
     *  
     */
    protected EPackage companyPackage = null;

    /**
     * the package containing the Company/Department meta model
     */
    protected CompanyPackage comp = null;

    /**
     * the set for all instances of {@link DepartmentImpl}
     */
    protected Set<DepartmentImpl> allDepartments = new HashSet<DepartmentImpl>();

    /**
     * the set of all instances of {@link FreelanceImpl}
     */
    protected Set<FreelanceImpl> allFreelances = new HashSet<FreelanceImpl>();

    /**
     * the set of all instances of {@link EmployeeImpl}
     */
    protected Set<EmployeeImpl> allEmployees = new HashSet<EmployeeImpl>();

    /**
     * a ID used to create unique names for employees and freelances
     */
    protected int curImployeeID = 0;

    /**
     * a ID used to create unique names for departments
     */
    protected int curDepartmentID = 0;

    /**
     * a instances of {@link EmployeeImpl}
     */
    protected EmployeeImpl aEmployee = null;

    /**
     * a instance of {@link DepartmentImpl}
     */
    protected DepartmentImpl aDepartment = null;

    /**
     * an instance of {@link DivisionImpl}
     */
    protected DivisionImpl aDivision = null;

    /**
     * a instance of {@link FreelanceImpl}
     */
    protected FreelanceImpl aFreelance = null;

    // constaints
    /**
     * A boss is not allowed to be a freelance
     */
    public final String notBossFreelance = "context Department \n" + "  inv NotBossFreelance: \n"
            + "  not self.boss.oclIsTypeOf(Freelance)";

    /**
     * there must be at least one employee older than 45 in each department
     */
    public final String oldEmployee = "context Department \n" + "  inv OldEmployee: \n"
            + "  self.employee->exists(e | e.age > 45)";

    /**
     * different employees must have different names
     */
    public final String uniqueNames = "context Employee \n" + "inv UniqueNames: \n"
            + "  Employee.allInstances()->forAll(e | \n" + "  e <> self implies e.name <> self.name)";

    /**
     * the assignment of a freelance must be between 5 and 30
     */
    public final String validAssignment = "context Freelance \n" + "  inv ValidAssignment: \n"
            + "  self.assignment >= 5 and self.assignment <= 30";

    /**
     * there are at most maxJuniors allowed per department
     */
    public final String maxJuniors = "context Department inv MaxJuniors: \n"
            + "self.employee->select(e|e.age < 25)->size() < self.maxJuniors\n";

    /**
     * the boss must be older than his employees
     */
    public final String bossIsOldest = "context Employee inv BossIsOldest: \n" + "self.age <= self.employer.boss.age\n";

    /**
     * the boss always gets the most money
     */
    public final String bossHighestSalary = "context Department inv BossHighestSalary: \n" + "self.employee->select(\n"
            + "	e|e.salary >= self.boss.salary)->size() <= 1\n";

    /**
     * this is a nasty constraint with 2 navigation path introduced by collect() stating that the salaries of the employees and
     * the bosses must not exceed the division's budget.
     */
    public final String nastyConstraint = "context Division \n" + "inv nasty: \n" + "self.department->collect(d| \n"
            + "d.employee->including(d.boss)).salary->sum() < budget";
    
    /**
     * A division is allowed a maximum number of employees of the month equal to its number of departments.
     * If a department has no employee of the month, another on can have two.
     */
    public final String limitEmployeesOfTheMonth = "context Division \n" + "inv limitEmployeesOfTheMonth: \n" + "self.employeesOfTheMonth->size() <= self.department->size()";
    
    /**
     * Only directors are allowed to have a secretary
     */
    public final String divisionBossSecretary = "context Employee \n" + "inv divBossSecretary: \n"
            + "if self.directed->isEmpty() then \n" + "   self.secretary.oclIsUndefined() \n" + "else \n"
            + "   not self.secretary.oclIsUndefined() \n" + "endif";

    /**
     * for security reasons, secretaries must be older than their bosses ;-) the secretary is modeled as an attribute
     */
    public final String secretaryOlderThanBoss = "context Employee \n" + "inv secretaryOlderThanBoss: \n"
            + "if self.directed->notEmpty() and \n" + "  not self.secretary.oclIsUndefined() then \n"
            + "    self.age < self.secretary.age \n" + "else true \n" + "endif";

    /**
     * A boss must be at least 10 years older than the youngest employee in the managed department.
     */
    public final String boss10YearsOlderThanJunior = "context Department \n" + "inv boss10YearsOlderThanJunior: \n"
            + "let t:Tuple(boss:Employee,junior:Employee)="
            + "Tuple{boss=self.boss, junior=self.employee->sortedBy(age)->first()} in \n" + "t.boss.age > t.junior.age + 10";

    /**
     * the expenses per department must not exceed its budget
     */
    public final String expensesRestriction = "context Department inv BudgetRestriction: \n"
            + "self.calcExpenses() <= self.budget";
    
    /**
     * A simple allInstances() expression to test instance creation/deletion filters
     */
    public final String simpleAllInstances = "context Employee inv InstanceCount: \n"
            + "Employee.allInstances()->size() = 17";

    // /**
    // * defines how to calculate expenses: The sum of the employee's salary plus
    // * the boss' salary
    // */
    // public final String expensesCalculation = "context Department \n" + "def: calcExpenses():Integer = \n" +
    // "self.employee->iterate(e: sum=0 | sum + self.salary) + self.boss.salary";

    /**
     * each department must be in a division
     */
    public final String departmentMustHaveDivision = "context Department inv departmentMustHaveDivision: \n"
            + "self.department2division->notEmpty()";

    public final String compareBossSalaryToJuniorSalary = "context Department \n"
            + "inv compareBossSalaryToJuniorSalary: \n"
            + "let bt:Tuple(bp:Employee,bs:Integer)=Tuple{bp=self.boss, bs=self.boss.salary} in "
            + "let jt:Tuple(jp:Employee, js:Integer)=Tuple{jp=self.employee->sortedBy(age)->first(), js=self.employee->sortedBy(age)->first().salary} in "
            + "let t:Tuple(b:Tuple(p1:Employee, s1:Integer), j:Tuple(p2:Employee, s2:Integer))=" + "Tuple{b=bt, j=jt} in \n"
            + "t.b.p1 <> t.j.p2 implies t.b.s1 > t.j.s2 + 100";

    public final String employeeInSameDepartmentAsIntern = "context Employee \n"
            + "inv employeeInSameDepartmentAsIntern: \n" + "self.employer = self.intern.employer";

    public final String checkForBob = "context Employee inv checkForBob: Employee.allInstances()->select(e:Employee | e.name = 'Bob')->asOrderedSet()->first().oclAsType(Employee).name = 'Bob'";
    
    public final String sumBudgetLimit = "context company::Department inv: self.sumBudget() < 10000";

    /*
     * OCLExpression representing the constrains above
     */
    public ExpressionInOCL notBossFreelanceAST = null;

    public ExpressionInOCL oldEmployeeAST = null;

    public ExpressionInOCL uniqueNamesAST = null;

    public ExpressionInOCL validAssignmentAST = null;

    public ExpressionInOCL maxJuniorsAST = null;

    public ExpressionInOCL bossIsOldestAST = null;

    public ExpressionInOCL bossHighestSalaryAST = null;

    public ExpressionInOCL expensesRestrictionAST = null;

    public ExpressionInOCL nastyConstraintAST = null;
    
    public ExpressionInOCL limitEmployeesOfTheMonthAST = null;

    public ExpressionInOCL divisionBossSecretaryAST = null;

    public ExpressionInOCL secretaryOlderThanBossAST = null;

    public ExpressionInOCL boss10YearsOlderThanJuniorAST = null;

    public ExpressionInOCL departmentMustHaveDivisionAST = null;

    public ExpressionInOCL compareBossSalaryToJuniorSalaryAST = null;

    public ExpressionInOCL employeeInSameDepartmentAsInternAST = null;

    public ExpressionInOCL checkForBobAST = null;

    public ExpressionInOCL simpleAllInstancesAST = null;
    
    public ExpressionInOCL sumBudgetLimitAST = null;
    
    /*
     * for easy access to the model
     */
    protected EClass division = null;

    protected EAttribute divisionBudget = null;

    protected EClass department = null;

    protected EAttribute departmentName = null;

    protected EAttribute departmentMaxJuniors = null;

    protected EAttribute departmentBudget = null;

    protected EClass employee = null;

    protected EAttribute employeeName = null;

    protected EAttribute employeeAge = null;

    protected EAttribute employeeSalary = null;

    protected EReference employeeSecretary = null;
    
    protected EAttribute employeeIsSecretary = null;

    protected EClass freelance = null;

    protected EClass student = null;

    protected EAttribute freelanceAssignment = null;

    protected EReference departmentRef = null;
    
    protected EReference departmentEmployeeOfTheMonth = null;
    
    protected EReference divisionEmployeesOfTheMonth = null;

    protected EReference bossRef = null;

    protected EReference managedRef = null;

    protected EReference employerRef = null;

    protected EReference employeeRef = null;

    protected EReference directedRef = null;

    protected EReference internRef = null;

    /**
     * Declare a public String field 
     * @param stringFieldName
     * @return
     */
    protected ExpressionInOCL getAST(String stringFieldName) {
        try {
            Field stringField = getClass().getField(stringFieldName);
            Field astField = getClass().getField(stringFieldName+"AST");
            ExpressionInOCL result = (ExpressionInOCL) astField.get(this);
            if (result == null) {
                result = (ExpressionInOCL) parse((String) stringField.get(this), this.comp).iterator().next().getSpecification();
                astField.set(this, result);
            }
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    protected ExpressionInOCL getNotBossFreelanceAST() {
        return getAST("notBossFreelance");
    }
    
    protected ExpressionInOCL getOldEmployeeAST() {
        return getAST("oldEmployee");
    }

    protected ExpressionInOCL getUniqueNamesAST() {
        return getAST("uniqueNames");
    }

    protected ExpressionInOCL getValidAssignmentAST() {
        return getAST("validAssignment");
    }

    protected ExpressionInOCL getMaxJuniorsAST() {
        return getAST("maxJuniors");
    }

    protected ExpressionInOCL getBossIsOldestAST() {
        return getAST("bossIsOldest");
    }
    
    protected ExpressionInOCL getSumBudgetLimitAST() {
        return getAST("sumBudgetLimit");
    }

    protected ExpressionInOCL getBossHighestSalaryAST() {
        return getAST("bossHighestSalary");
    }

    protected ExpressionInOCL getExpensesRestrictionAST() {
        return getAST("expensesRestriction");
    }

    protected ExpressionInOCL getNastyConstraintAST() {
        return getAST("nastyConstraint");
    }

    protected ExpressionInOCL getLimitEmployeesOfTheMonthAST() {
        return getAST("limitEmployeesOfTheMonth");
    }
    
    protected ExpressionInOCL getDivisionBossSecretaryAST() {
        return getAST("divisionBossSecretary");
    }

    protected ExpressionInOCL getSecretaryOlderThanBossAST() {
        return getAST("secretaryOlderThanBoss");
    }

    protected ExpressionInOCL getBoss10YearsOlderThanJuniorAST() {
        return getAST("boss10YearsOlderThanJunior");
    }

    protected ExpressionInOCL getDepartmentMustHaveDivisionAST() {
        return getAST("departmentMutsHaveDivision");
    }

    protected ExpressionInOCL getCompareBossSalaryToJuniorSalaryAST() {
        return getAST("compareBossSalaryToJuniorSalary");
    }

    protected ExpressionInOCL getEmployeeInSameDepartmentAsInternAST() {
        return getAST("employeeInSameDepartmentAsIntern");
    }

    protected ExpressionInOCL getCheckForBobAST() {
        return getAST("checkForBob");
    }

    protected ExpressionInOCL getSimpleAllInstancesAST() {
        return getAST("simpleAllInstances");
    }

    @Override
    @Before
    public void setUp() {
        beforeTestMethod();
    }

    @Override
    @After
    public void tearDown() {
        this.resetInstances();
    }

    protected void beforeTestMethod() {
        // build up the test model
        buildModel();
    }

    /**
     * creates a whole bunch of instances
     * 
     * @param numDepartments
     *            the number of departments
     * @param numEmployees
     *            the number of employees (not freelance) per department
     * @param numFreelance
     *            the number of freelance per department
     */
    protected void createInstances(double numDepartments, int numEmployees, int numFreelance) {

        int maxNumJuniors = 3;
        int budget = 50000;

        this.aDivision = (DivisionImpl) CompanyFactory.eINSTANCE.createDivision();
        this.aDivision.setName("The super Division");
        this.aDivision.setBudget(2000000);
        for (double i = 0; i < numDepartments; i++) {
            createDepartment(numEmployees, numFreelance, maxNumJuniors, budget);
        }
        // pick some instances to which the events will be related
        this.aDepartment = this.allDepartments.iterator().next();
        this.aDivision.getDepartment().add(this.aDepartment);
        this.aEmployee = this.allEmployees.iterator().next();
        this.aFreelance = this.allFreelances.iterator().next();

    }

    /**
     * This method fetches some meta object form the model which are used to create ModelChangeEvents later on
     */
    private void buildModel() {
        this.comp = company.CompanyPackage.eINSTANCE;
        this.division = this.comp.getDivision();
        this.divisionBudget = (EAttribute) this.division.getEStructuralFeature("budget");
        this.department = this.comp.getDepartment();
        this.departmentName = (EAttribute) this.department.getEStructuralFeature("name");
        this.departmentMaxJuniors = (EAttribute) this.department.getEStructuralFeature("maxJuniors");
        this.departmentBudget = (EAttribute) this.department.getEStructuralFeature("budget");
        this.bossRef = (EReference) this.department.getEStructuralFeature("boss");
        this.employeeRef = (EReference) this.department.getEStructuralFeature("employee");
        this.departmentRef = (EReference) this.division.getEStructuralFeature("department");
        this.departmentEmployeeOfTheMonth = (EReference) this.department.getEStructuralFeature("employeeOfTheMonth");
        this.divisionEmployeesOfTheMonth = (EReference) this.division.getEStructuralFeature("employeesOfTheMonth");
        this.employee = this.comp.getEmployee();
        this.employeeName = (EAttribute) this.employee.getEStructuralFeature("name");
        this.employeeAge = (EAttribute) this.employee.getEStructuralFeature("age");
        this.employeeSalary = (EAttribute) this.employee.getEStructuralFeature("salary");
        this.employerRef = (EReference) this.employee.getEStructuralFeature("employer");
        this.employeeSecretary = (EReference) this.employee.getEStructuralFeature("secretary");
        this.directedRef = (EReference) this.employee.getEStructuralFeature("directed");
        this.managedRef = (EReference) this.employee.getEStructuralFeature("managed");
        this.internRef = (EReference) this.employee.getEStructuralFeature("intern");
        this.freelance = this.comp.getFreelance();
        this.student = this.comp.getStudent();
        this.freelanceAssignment = (EAttribute) this.freelance.getEStructuralFeature("assignment");
        this.rs = new ResourceSetImpl();
        this.rs.eAdapters().add(new ECrossReferenceAdapter());
        this.rs.getResources().add(this.comp.eResource());
    }

    /**
     * Creates a Department instance
     * 
     * @param employees
     *            number of employees which are not freelances in the department
     * @param freelances
     *            the number of freelances in the department
     * @param maxJuniors
     *            the value for the maxJunior attribute
     * @param budget
     *            the value for the budget attribute
     */
    private DepartmentImpl createDepartment(int employees, int freelances, int maxNumJuniors, int budget) {

        DepartmentImpl dep = (DepartmentImpl) CompanyFactory.eINSTANCE.createDepartment();
        dep.setName("Dep" + this.curDepartmentID);
        dep.setMaxJuniors(maxNumJuniors);
        dep.setBudget(budget);
        this.curDepartmentID++;
        EmployeeImpl e = null;
        FreelanceImpl f = null;
        for (int i = 0; i < employees; i++) {
            e = createEmployee();
            dep.getEmployee().add(e);
            e.setEmployer(dep);
        }
        for (int i = 0; i < freelances; i++) {
            f = createFreelance();
            dep.getEmployee().add(f);
            f.setEmployer(dep);
        }
        this.allDepartments.add(dep);
        if (this.comp.eResource() != null) {
            this.comp.eResource().getContents().add(dep);
        }
        return dep;
    }

    /**
     * @return an instance of {@link Employee}
     */
    private EmployeeImpl createEmployee() {

        EmployeeImpl e = (EmployeeImpl) CompanyFactory.eINSTANCE.createEmployee();
        e.setName("empl" + this.curImployeeID);
        e.setAge(42);
        e.setSalary(2345);
        this.curImployeeID++;
        this.allEmployees.add(e);
        if (this.comp.eResource() != null) {
            this.comp.eResource().getContents().add(e);
        }
        return e;
    }

    /**
     * @return a instances of {@link Freelance}
     */
    private FreelanceImpl createFreelance() {

        FreelanceImpl f = (FreelanceImpl) CompanyFactory.eINSTANCE.createFreelance();
        f.setName("empl" + this.curImployeeID);
        f.setAge(42);
        f.setAssignment(7);
        f.setSalary(2345);
        this.curImployeeID++;
        this.allFreelances.add(f);
        if (this.comp.eResource() != null) {
            this.comp.eResource().getContents().add(f);
        }
        return f;
    }

    /**
     * @param expression
     *            to parse
     * @return a list of {@link Constraint}s parsed from given expression
     */
    public static List<Constraint> parse(String expression, EPackage basePackage) {
        OCLInput exp = new OCLInput(expression);
        String nsPrefix = basePackage.getNsPrefix();
        EPackage.Registry.INSTANCE.put(nsPrefix, basePackage);
        OCL ocl = OCLWithHiddenOpposites.newInstance();
        ocl = OCLWithHiddenOpposites.newInstance(((EcoreEnvironmentFactoryWithHiddenOpposites) ocl.getEnvironment().getFactory()).
                createPackageContext(ocl.getEnvironment(), basePackage));
        List<Constraint> result = null;
        try {
            result = ocl.parse(exp);
        } catch (ParserException e) {
            System.err.println("Error while parsing Expression:" + exp);
            e.printStackTrace();
        }
        return result;
    }

    private void resetInstances() {

        this.rs = null;
        this.companyPackage = null;
        this.comp = null;
        this.allDepartments = null;
        this.allFreelances = null;
        this.allEmployees = null;
        this.aEmployee = null;
        this.aDepartment = null;
        this.aDivision = null;
        this.aFreelance = null;
        this.division = null;
        this.divisionBudget = null;
        this.department = null;
        this.departmentName = null;
        this.departmentMaxJuniors = null;
        this.departmentBudget = null;
        this.employee = null;
        this.employeeName = null;
        this.employeeAge = null;
        this.employeeSalary = null;
        this.employeeSecretary = null;
        this.freelance = null;
        this.student = null;
        this.freelanceAssignment = null;
        this.departmentRef = null;
        this.departmentEmployeeOfTheMonth = null;
        this.divisionEmployeesOfTheMonth = null;
        this.bossRef = null;
        this.managedRef = null;
        this.employerRef = null;
        this.employeeRef = null;
        this.directedRef = null;
    }
}
