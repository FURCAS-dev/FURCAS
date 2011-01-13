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
package org.eclipse.ocl.examples.testutils;

import java.util.HashSet;
import java.util.Set;

import junit.framework.TestCase;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;

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

    /*
     * for easy access to the model
     */
    protected EClass companyClass = null;
    
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

    protected EAttribute numberEmployeesOfTheMonth = null;
    
    protected EAttribute eotmDelta = null;

    protected EReference bossRef = null;

    protected EReference managedRef = null;

    protected EReference employerRef = null;

    protected EReference employeeRef = null;

    protected EReference directedRef = null;

    protected EReference internRef = null;

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
        this.companyClass = this.comp.getCompany();
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
        this.numberEmployeesOfTheMonth = (EAttribute) this.division.getEStructuralFeature("numberEmployeesOfTheMonth");
        this.eotmDelta = (EAttribute) this.companyClass.getEStructuralFeature("eotmDelta");
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
        this.companyClass = null;
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
        this.numberEmployeesOfTheMonth = null;
        this.eotmDelta = null;
        this.bossRef = null;
        this.managedRef = null;
        this.employerRef = null;
        this.employeeRef = null;
        this.directedRef = null;
    }
}
