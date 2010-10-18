/*******************************************************************************
 * Copyright (c) 2006, 2009 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     SAP AG - initial API and implementation
 *******************************************************************************/
package com.sap.tc.emf.test.query;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.query.index.Index;
import org.eclipse.emf.query.index.internal.impl.GlobalTables;
import org.eclipse.emf.query.index.internal.impl.PageableIndexImpl;
import org.eclipse.emf.query2.FromEntry;
import org.eclipse.emf.query2.FromFixedSet;
import org.eclipse.emf.query2.FromType;
import org.eclipse.emf.query2.LocalWhereEntry;
import org.eclipse.emf.query2.Operation;
import org.eclipse.emf.query2.Query;
import org.eclipse.emf.query2.QueryContext;
import org.eclipse.emf.query2.QueryProcessor;
import org.eclipse.emf.query2.QueryProcessorFactory;
import org.eclipse.emf.query2.ResultSet;
import org.eclipse.emf.query2.SelectAlias;
import org.eclipse.emf.query2.SelectAttrs;
import org.eclipse.emf.query2.SelectEntry;
import org.eclipse.emf.query2.TypeScopeProvider;
import org.eclipse.emf.query2.WhereComparisonAttrs;
import org.eclipse.emf.query2.WhereEntry;
import org.eclipse.emf.query2.WhereInt;
import org.eclipse.emf.query2.WhereNestedReference;
import org.eclipse.emf.query2.WhereRelationReference;
import org.eclipse.emf.query2.internal.moinql.controller.QueryProcessorImpl;
import org.eclipse.emf.query2.test.mm.Company.CompanyFactory;
import org.eclipse.emf.query2.test.mm.Company.CompanyPackage;
import org.eclipse.emf.query2.test.mm.Company.Department;
import org.eclipse.emf.query2.test.mm.Company.Division;
import org.eclipse.emf.query2.test.mm.Company.Employee;
import org.eclipse.emf.query2.test.mm.Company.Freelance;
import org.eclipse.emf.query2.test.mm.generatedmetamodel.GeneratedmetamodelPackage;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.sap.tc.emf.test.query.setup.DefaultTestClientImpl;
import com.sap.tc.emf.test.query.setup.IndexerForTest;
import com.sap.tc.emf.test.query.setup.TestClient;

/**
 * @author D045917
 * @author D046918
 * @version Apr 13, 2006
 */
public class TestSuiteCompanyQueryTests extends QueryTestCase {

	private static final String COMPANY_MM_CONTAINER_NAME = "sap.com/tc/moin/test/company";

	private TestClient testClient1;

	private URI[] globalPartitionScope;

	private Resource partitionDivAndDep = null;

	private Resource partitionBosses = null;

	private Resource partitionCommonEmployees = null;

	private Department department11 = null;

	private Department department12 = null;

	private CompanyPackage companyPackage = null;

	private Division division1 = null;

	private Division division2 = null;

	private Department department21 = null;

	private Department department22 = null;

	private Employee rainerDirector = null;

	private Employee meinolfDivision1Departments = null;

	private Employee jensDivision2Departments = null;

	private Employee boris = null;

	private Employee stefan = null;

	private Freelance eduardFreeLance = null;

	private Freelance simonFreeLance = null;

	private Index index = null;

	static {
		IndexerForTest.index(getDefaultIndexStore(), EcorePackage.eINSTANCE.eResource(), CompanyPackage.eINSTANCE.eResource());
	}

	@Before
	public void beforeTestMethod() throws Exception {

		this.instantiate();

		try {
			// save
			this.testClient1.saveAll();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}

	private QueryProcessor getMQLProcessor() {

		return QueryProcessorFactory.getDefault().createQueryProcessor(index);
	}

	private ResultSet executeQuery(Object query, QueryContext context) {
		if (query instanceof String) {
			return this.getMQLProcessor().execute((String) query, context);
		} else if (query instanceof Query) {
			return this.getMQLProcessor().execute((Query) query, context);
		} else {
			throw new IllegalArgumentException("unexpected query representation");
		}
	}

	private QueryContext getQueryContext(final TypeScopeProvider scopeProvider) {
		return new QueryContext() {

			@Override
			public URI[] getResourceScope() {
				return scopeProvider.getPartitionScope();
			}

			@Override
			public ResourceSet getResourceSet() {
				// TODO Auto-generated method stub
				return TestSuiteCompanyQueryTests.this.testClient1.getResourceSet();
			}

		};
	}

	@After
	public void afterTestMethod() throws Exception {

		this.department11 = null;
		this.department12 = null;
		this.deleteCompanyPartition();

		if (this.testClient1 != null) {
			this.testClient1.clear();
			this.testClient1 = null;
		}

	}

	public void deleteCompanyPartition() {

		try {
			this.partitionDivAndDep.delete(Collections.emptyMap());
			this.partitionBosses.delete(Collections.emptyMap());
			this.partitionCommonEmployees.delete(Collections.emptyMap());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void instantiate() {

		this.testClient1 = new DefaultTestClientImpl();

		this.companyPackage = CompanyPackage.eINSTANCE;

		this.index = getDefaultIndexStore();

		try {
			this.partitionDivAndDep = this.testClient1.getOrCreateResourceStable("TutorialQueries_Company_DivAndDep.xmi");
			this.partitionBosses = this.testClient1.getOrCreateResourceStable("TutorialQueries_Company_Bosses.xmi");
			this.partitionCommonEmployees = this.testClient1.getOrCreateResourceStable("TutorialQueries_Company_CommonEmployees.xmi");
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		this.globalPartitionScope = new URI[] { this.partitionDivAndDep.getURI(), this.partitionBosses.getURI(),
				this.partitionCommonEmployees.getURI() };

		this.division1 = CompanyFactory.eINSTANCE.createDivision();
		this.division1.setName("division1");
		this.division1.setBudget(1000000);
		this.division2 = CompanyFactory.eINSTANCE.createDivision();
		this.division2.setName("division2");
		this.division2.setBudget(2000000);

		this.department11 = CompanyFactory.eINSTANCE.createDepartment();
		this.department11.setName("department11");
		this.department11.setMaxJuniors(5);
		this.department11.setBudget(600000);
		this.department12 = CompanyFactory.eINSTANCE.createDepartment();
		this.department12.setName("department12");
		this.department12.setMaxJuniors(5);
		this.department12.setBudget(400000);
		this.department21 = CompanyFactory.eINSTANCE.createDepartment();
		this.department21.setName("department21");
		this.department21.setMaxJuniors(5);
		this.department21.setBudget(1200000);
		this.department22 = CompanyFactory.eINSTANCE.createDepartment();
		this.department22.setName("department22");
		this.department22.setMaxJuniors(5);
		this.department22.setBudget(800000);

		this.division1.getDepartment().add(this.department11);
		this.division1.getDepartment().add(this.department12);
		this.division2.getDepartment().add(this.department21);
		this.division2.getDepartment().add(this.department22);

		this.rainerDirector = CompanyFactory.eINSTANCE.createEmployee();
		this.rainerDirector.setAge(50);
		this.rainerDirector.setName("Rainer");
		this.rainerDirector.setSalary(100000);
		this.rainerDirector.setDirected(this.division1);
		this.rainerDirector.setDirected(this.division2);

		this.meinolfDivision1Departments = CompanyFactory.eINSTANCE.createEmployee();
		this.meinolfDivision1Departments.setAge(36);
		this.meinolfDivision1Departments.setName("Meinolf");
		this.meinolfDivision1Departments.setSalary(50000);
		this.meinolfDivision1Departments.setManaged(this.department11);
		this.meinolfDivision1Departments.setManaged(this.department12);

		this.jensDivision2Departments = CompanyFactory.eINSTANCE.createEmployee();
		this.jensDivision2Departments.setAge(40);
		this.jensDivision2Departments.setName("Jens");
		this.jensDivision2Departments.setSalary(70000);
		this.jensDivision2Departments.setManaged(this.department21);
		this.jensDivision2Departments.setManaged(this.department22);

		this.boris = CompanyFactory.eINSTANCE.createEmployee();
		this.boris.setAge(25);
		this.boris.setName("Boris");
		this.boris.setSalary(20000);
		this.boris.setEmployer(this.department11);

		this.stefan = CompanyFactory.eINSTANCE.createEmployee();
		this.stefan.setAge(30);
		this.stefan.setName("Stefan");
		this.stefan.setSalary(30000);
		this.stefan.setEmployer(this.department12);

		this.eduardFreeLance = CompanyFactory.eINSTANCE.createFreelance();
		this.eduardFreeLance.setAge(35);
		this.eduardFreeLance.setName("Eduard");
		this.eduardFreeLance.setSalary(40000);
		this.eduardFreeLance.setEmployer(this.department21);
		this.eduardFreeLance.setAssignment(100);

		this.simonFreeLance = CompanyFactory.eINSTANCE.createFreelance();
		this.simonFreeLance.setAge(40);
		this.simonFreeLance.setName("Simon");
		this.simonFreeLance.setSalary(40000);
		this.simonFreeLance.setEmployer(this.department22);
		this.simonFreeLance.setAssignment(200);

		this.partitionDivAndDep.getContents().add(this.division1);
		this.partitionDivAndDep.getContents().add(this.division2);
		this.partitionDivAndDep.getContents().add(this.department11);
		this.partitionDivAndDep.getContents().add(this.department12);
		this.partitionDivAndDep.getContents().add(this.department21);
		this.partitionDivAndDep.getContents().add(this.department22);
		this.partitionBosses.getContents().add(this.rainerDirector);
		this.partitionBosses.getContents().add(this.meinolfDivision1Departments);
		this.partitionBosses.getContents().add(this.jensDivision2Departments);
		this.partitionCommonEmployees.getContents().add(this.boris);
		this.partitionCommonEmployees.getContents().add(this.stefan);
		this.partitionCommonEmployees.getContents().add(this.eduardFreeLance);
		this.partitionCommonEmployees.getContents().add(this.simonFreeLance);
	}

	/**
	 * Return the elements (MRIs) and names of all employees (but not those who
	 * freelance), which are younger than 40.
	 */
	@Test
	public void employeesUnder40_ast() {
		
		

		URI employeeUri = EcoreUtil.getURI(CompanyPackage.Literals.EMPLOYEE);

		// from clause
		FromType employees = new FromType("em", employeeUri, true);
		FromEntry[] fromEntries = new FromEntry[] { employees };

		// select clause
		SelectAttrs selectEmployeeName = new SelectAttrs("em", new String[] { "name" });
		SelectAlias selectEm = new SelectAlias("em");
		SelectEntry[] selectEntries = new SelectEntry[] { selectEm, selectEmployeeName };

		// where entries
		WhereInt whereYoung = new WhereInt("age", Operation.SMALLER, 40);
		WhereEntry whereEmYoung = new LocalWhereEntry("em", whereYoung);
		WhereEntry[] whereEntries = new WhereEntry[] { whereEmYoung };

		// the actual query
		Query query = new Query(selectEntries, fromEntries, whereEntries);

		// verify pretty-print
		String querypp = "select em,\n       em.name\nfrom type: " + employeeUri + " withoutSubtypes as em\nwhere for em(age SMALLER 40)\n";
		assertEquals(query.toString(), querypp);

		// execute the query
		this.employeesUnder40_check(query);
	}

	/**
	 * Return the elements (MRIs) and names of all employees (but not those who
	 * freelance), which are younger than 40.
	 */
	@Test
	public void employeesUnder40() {

		String query = "select em, em.name from [" + EcoreUtil.getURI(CompanyPackage.Literals.EMPLOYEE) + "] withoutsubtypes as em "
				+ " where for em(age < 40)";

		// execute the query
		this.employeesUnder40_check(query);
	}
//	@Test
//	public void testDirtyReindexProblem(){
//		String query = "select em, em.name from [" + EcoreUtil.getURI(CompanyPackage.Literals.EMPLOYEE) + "] withoutsubtypes as em "
//		+ " where for em(age < 40)";
//
//		
//		
//		// execute the query
//		this.employeesUnder40_check(query);
//		
//		boris.setAge(41);
//		assertTrue(boris.eResource().isModified());
//		this.employeesUnder40_check_dirty(query);
//		
//
//	}
	
	@Test
	public void employeesAsManagers(){
		
		String query = "select em,em.name,dep.name " + " from ["
		+ EcoreUtil.getURI(CompanyPackage.Literals.EMPLOYEE) + "] as em, " + " ["
		+ EcoreUtil.getURI(CompanyPackage.Literals.DEPARTMENT) + "] as dep"
		+ "  where em.managed = dep ";
		
		TypeScopeProvider queryScopeProvider = this.getMQLProcessor().getInclusivePartitionScopeProvider(this.globalPartitionScope);
		QueryContext queryContext = this.getQueryContext(queryScopeProvider);
		ResultSet resultSet = this.executeQuery(query, queryContext);

		// verify the result set
		URI[] resultEmployees = resultSet.getUris("em");
		Set<EObject> resultEmployeesSet = new HashSet<EObject>();
		for (URI uri : resultEmployees) {
			resultEmployeesSet.add(queryContext.getResourceSet().getEObject(uri, true));
		}
		assertTrue(resultEmployeesSet.contains(this.meinolfDivision1Departments));
		
		Writer writer = new StringWriter();
		resultSet.asCSV(writer);
		assertEquals(resultSet.toString(), writer.toString());

	}

	/**
	 * Return the elements (MRIs) and names of all employees (but not those who
	 * freelance), which are younger than 40.
	 */
	@Test
	public void employeesUnder40_2() {

		String query = "select em, em.name from [" + EcoreUtil.getURI(CompanyPackage.Literals.EMPLOYEE) + "] withoutsubtypes as em "
				+ " where em.age < 40";

		// execute the query
		this.employeesUnder40_check(query);
	}

	private void employeesUnder40_check(Object preparedQuery) {

		TypeScopeProvider queryScopeProvider = this.getMQLProcessor().getInclusivePartitionScopeProvider(this.globalPartitionScope);
		QueryContext queryContext = this.getQueryContext(queryScopeProvider);
		ResultSet resultSet = this.executeQuery(preparedQuery, queryContext);

		// verify the result set
		URI[] resultEmployees = resultSet.getUris("em");
		Set<EObject> resultEmployeesSet = new HashSet<EObject>();
		for (URI uri : resultEmployees) {
			resultEmployeesSet.add(queryContext.getResourceSet().getEObject(uri, true));
		}
		
		
		assertTrue(resultEmployeesSet.contains(this.meinolfDivision1Departments));
		assertTrue(resultEmployeesSet.contains(this.boris));
		assertTrue(resultEmployeesSet.contains(this.stefan));
		Writer writer = new StringWriter();
		resultSet.asCSV(writer);
		assertEquals(resultSet.toString(), writer.toString());
	}
	
//	private void employeesUnder40_check_dirty(Object preparedQuery) {
//
//		TypeScopeProvider queryScopeProvider = this.getMQLProcessor().getInclusivePartitionScopeProvider(this.globalPartitionScope);
//		QueryContext queryContext = this.getQueryContext(queryScopeProvider);
//		ResultSet resultSet = this.executeQuery(preparedQuery, queryContext);
//
//		// verify the result set
//		URI[] resultEmployees = resultSet.getUris("em");
//		Set<EObject> resultEmployeesSet = new HashSet<EObject>();
//		for (URI uri : resultEmployees) {
//			resultEmployeesSet.add(queryContext.getResourceSet().getEObject(uri, true));
//		}
//		assertTrue(resultEmployeesSet.contains(this.meinolfDivision1Departments));
//		assertFalse(resultEmployeesSet.contains(this.boris));
//		assertTrue(resultEmployeesSet.contains(this.stefan));
//		Writer writer = new StringWriter();
//		resultSet.asCSV(writer);
//		assertEquals(resultSet.toString(), writer.toString());
//	}

	@Test
	public void employeesWithoutBosses() {

		String query1 = "select em from [" + EcoreUtil.getURI(CompanyPackage.Literals.EMPLOYEE)
				+ "] withoutsubtypes as em where em.employer = null";

		String query2 = "select em.name from [" + EcoreUtil.getURI(CompanyPackage.Literals.EMPLOYEE)
				+ "] withoutsubtypes as em where em.employer = null";

		this.employeesWithoutBosses_check(query1, query2);
	}

	private void employeesWithoutBosses_check(Object preparedQuery1, Object preparedQuery2) {

		TypeScopeProvider queryScopeProvider = this.getMQLProcessor().getInclusivePartitionScopeProvider(this.globalPartitionScope);
		ResultSet resultSet1 = this.executeQuery(preparedQuery1, this.getQueryContext(queryScopeProvider));
		
		ResultSet resultSet2 = this.executeQuery(preparedQuery2, this.getQueryContext(queryScopeProvider));

		assertEquals(resultSet1.getSize(), resultSet2.getSize());
	}

	/**
	 * Return the names of all the companies divisions and their departments
	 */
	@Test
	public void allDepartmentsAndDivisions_ast() {

		// from clause
		FromType divisisions = new FromType("div", EcoreUtil.getURI(CompanyPackage.Literals.DIVISION), false);
		FromType departments = new FromType("dep", EcoreUtil.getURI(CompanyPackage.Literals.DEPARTMENT), false);
		FromEntry[] fromEntries = new FromEntry[] { divisisions, departments };

		// select clause
		SelectAttrs selectDivisionName = new SelectAttrs("div", new String[] { "name" });
		SelectAttrs selectDepartmentName = new SelectAttrs("dep", new String[] { "name" });
		SelectEntry[] selectEntries = new SelectEntry[] { selectDivisionName, selectDepartmentName };

		// where entries
		WhereRelationReference whereDivides = new WhereRelationReference("div", "department", "dep");
		WhereEntry[] whereEntries = new WhereEntry[] { whereDivides };

		// the actual query
		Query query = new Query(selectEntries, fromEntries, whereEntries);

		// verify pretty-print
		String querypp = "select div.name,\n       dep.name\nfrom type: " + EcoreUtil.getURI(CompanyPackage.Literals.DIVISION)
				+ " as div,\n     type: " + EcoreUtil.getURI(CompanyPackage.Literals.DEPARTMENT) + " as dep\nwhere div.department = dep\n";
		assertEquals(query.toString(), querypp);

		this.allDepartmentsAndDivisions_check(query);
	}

	/**
	 * Return the names of all the companies divisions and their departments
	 */
	@Test
	public void allDepartmentsAndDivisions() {

		String query = "select div.name, dep.name from [" + EcoreUtil.getURI(CompanyPackage.Literals.DIVISION) + "] as div, " + "["
				+ EcoreUtil.getURI(CompanyPackage.Literals.DEPARTMENT) + "] as dep " + " where div.department = dep";

		this.allDepartmentsAndDivisions_check(query);
	}

	@Test
	public void allDepartmentsAndDivisions_2() {

		// FIXME: needed ?
		// RefAssociation refDividesAssoc = getAssociation(
		// Divides.ASSOCIATION_DESCRIPTOR );
		// Association dividesAssoc = refDividesAssoc.refMetaObject( );
		// URI dividesAssocMri = ( (EObject) dividesAssoc ).get___Mri( );
		//
		// List<AssociationEnd> dividesAssocEnds = getJmiHelper(
		// ).getAssociationEnds( dividesAssoc );
		// AssociationEnd assocEnd = null;
		// if ( dividesAssocEnds.get( 0 ).getName( ).equals( "department" ) ) {
		// assocEnd = dividesAssocEnds.get( 0 );
		// } else {
		// assocEnd = dividesAssocEnds.get( 1 );
		// }
		// int assocEndNumber = ( this.conn.getJmiHelper(
		// ).isFirstAssociationEnd( dividesAssoc, assocEnd ) ? 0 : 1 );
		//
		// String query = "select div.name, dep.name from type \"" +
		// EcoreUtil.getURI(( (EObject) this.division1.eClass() )) +
		// "\" as div, Company::Department as dep where div." + assocEndNumber +
		// "[\"" + dividesAssocMri + "\"] = dep";
		// MQLPreparedQuery preparedQuery = getMQLProcessor( ).prepare( query );
		//
		// this.allDepartmentsAndDivisions_check( preparedQuery );
	}

	private void allDepartmentsAndDivisions_check(Object preparedQuery) {

		TypeScopeProvider queryScopeProvider = this.getMQLProcessor().getInclusivePartitionScopeProvider(this.globalPartitionScope);
		ResultSet resultSet = this.executeQuery(preparedQuery, this.getQueryContext(queryScopeProvider));

		// verify the result set
		assertEquals(resultSet.getAttribute(0, "div", "name"), this.division1.getName());
		assertEquals(resultSet.getAttribute(1, "div", "name"), this.division1.getName());
		assertEquals(resultSet.getAttribute(2, "div", "name"), this.division2.getName());
		assertEquals(resultSet.getAttribute(3, "div", "name"), this.division2.getName());
		assertEquals(resultSet.getAttribute(0, "dep", "name"), this.department11.getName());
		assertEquals(resultSet.getAttribute(1, "dep", "name"), this.department12.getName());
		assertEquals(resultSet.getAttribute(2, "dep", "name"), this.department21.getName());
		assertEquals(resultSet.getAttribute(3, "dep", "name"), this.department22.getName());
	}

	/**
	 * Return the names of all companys divisions and their departments
	 */
	@Test
	public void allDepartmentsAndDivisions_withFeature_ast() {

		// from clause
		FromType divisions = new FromType("div", EcoreUtil.getURI(CompanyPackage.Literals.DIVISION), false);
		FromType departments = new FromType("dep", EcoreUtil.getURI(CompanyPackage.Literals.DEPARTMENT), false);
		FromEntry[] fromEntries = new FromEntry[] { divisions, departments };

		// select clause
		SelectAttrs selectDivisionName = new SelectAttrs("div", new String[] { "name" });
		SelectAttrs selectDepartmentName = new SelectAttrs("dep", new String[] { "name" });
		SelectEntry[] selectEntries = new SelectEntry[] { selectDivisionName, selectDepartmentName };

		// where entries
		WhereRelationReference whereDivides = new WhereRelationReference("div", "department", "dep");
		WhereEntry[] whereEntries = new WhereEntry[] { whereDivides };

		// the actual query
		Query query = new Query(selectEntries, fromEntries, whereEntries);

		// verify pretty-print
		String querypp = "select div.name,\n       dep.name\nfrom type: " + EcoreUtil.getURI(CompanyPackage.Literals.DIVISION)
				+ " as div,\n     type: " + EcoreUtil.getURI(CompanyPackage.Literals.DEPARTMENT) + " as dep\nwhere div.department = dep\n";
		assertEquals(query.toString(), querypp);

		this.allDepartmentsAndDivisions_check(query);
	}

	/**
	 * Return the names of all company�s divisions and their departments
	 */
	@Test
	public void allDepartmentsAndDivisions_withFeature() {

		String query = "select div.name, dep.name from [" + EcoreUtil.getURI(CompanyPackage.Literals.DIVISION) + "] as div, " + "["
				+ EcoreUtil.getURI(CompanyPackage.Literals.DEPARTMENT) + "] as dep " + " where div.department = dep";

		this.allDepartmentsAndDivisions_check(query);
	}

	/**
	 * Return the MRIs and names of departments, which do not belong to a
	 * division whose budget is more than 1.000.000 Euros
	 */
	@Test
	public void departmentsWithSmallDivisions_ast() {

		// sub-query: Get all divisions whose budget is more than 1.000.000
		// Euros
		FromType divisions = new FromType("div", EcoreUtil.getURI(CompanyPackage.Literals.DIVISION), false);
		FromEntry[] divFromEntries = new FromEntry[] { divisions };
		SelectAlias selectDiv = new SelectAlias("div");
		SelectEntry[] divSelectEntries = new SelectEntry[] { selectDiv };
		WhereInt whereBudget = new WhereInt("budget", Operation.GREATER, 1000000);
		WhereEntry whereDivBudget = new LocalWhereEntry("div", whereBudget);
		WhereEntry[] divWhereEntries = new WhereEntry[] { whereDivBudget };
		Query nestedQuery = new Query(divSelectEntries, divFromEntries, divWhereEntries);

		// from clause
		FromType departments = new FromType("dep", EcoreUtil.getURI(CompanyPackage.Literals.DEPARTMENT), false);
		FromEntry[] fromEntries = new FromEntry[] { departments };

		// select clause
		SelectAlias selectDep = new SelectAlias("dep");
		SelectAttrs selectDepartmentName = new SelectAttrs("dep", new String[] { "name" });
		SelectEntry[] selectEntries = new SelectEntry[] { selectDepartmentName, selectDep };

		// where entries
		WhereNestedReference whereDivides = new WhereNestedReference(true, "dep", "division", nestedQuery);

		WhereEntry[] whereEntries = new WhereEntry[] { whereDivides };

		// the actual query
		Query query = new Query(selectEntries, fromEntries, whereEntries);

		// verify pretty-print
		String querypp = "select dep.name,\n       dep\nfrom type: " + EcoreUtil.getURI(CompanyPackage.Literals.DEPARTMENT)
				+ " as dep\nwhere dep.division not  in\n       select div\n       from type: "
				+ EcoreUtil.getURI(CompanyPackage.Literals.DIVISION) + " as div\n       where for div(budget GREATER 1000000)\n       \n";
		assertEquals(query.toString(), querypp);

		this.departmentsWithSmallDivisions_check(query);
	}

	/**
	 * Return the MRIs and names of departments, which do not belong to a
	 * division whose budget is more than 1.000.000 Euros
	 */
	@Test
	public void departmentsWithSmallDivisions() {

		String query = "select dep.name, dep " + "from [" + EcoreUtil.getURI(CompanyPackage.Literals.DEPARTMENT) + "] as dep "
				+ "where dep.division not in " + "(select div " + " from [" + EcoreUtil.getURI(CompanyPackage.Literals.DIVISION)
				+ "] as div where " + " for div(budget > 1000000))";

		this.departmentsWithSmallDivisions_check(query);
	}

	/**
	 * Return the MRIs and names of departments, which do not belong to a
	 * division whose budget is more than 1.000.000 Euros
	 */
	@Test
	public void departmentsWithSmallDivisions_2() {

		String query = "select dep.name, dep " + "from [" + EcoreUtil.getURI(CompanyPackage.Literals.DEPARTMENT) + "] as dep "
				+ "where dep.division not in " + "(select div " + " from [" + EcoreUtil.getURI(CompanyPackage.Literals.DIVISION)
				+ "] as div where " + " div.budget > 1000000)";

		this.departmentsWithSmallDivisions_check(query);
	}

	/**
	 * Return the MRIs and names of departments, which do not belong to a
	 * division whose budget is more than 1.000.000 Euros
	 */
	@Test
	public void departmentsWithSmallDivisions_3() {

		String query = "select dep.name, dep " + "from [" + EcoreUtil.getURI(CompanyPackage.Literals.DEPARTMENT) + "] as dep "
				+ "where dep.division not in " + "(select div " + " from [" + EcoreUtil.getURI(CompanyPackage.Literals.DIVISION)
				+ "] as div where " + " div.budget >= 1000001)";

		this.departmentsWithSmallDivisions_check(query);
	}

	/**
	 * Return the MRIs and names of departments, which do not belong to a
	 * division whose budget is more than 1.000.000 Euros
	 */
	@Test
	public void departmentsWithSmallDivisions_4() {

		// FIXME: needed ?
		// RefAssociation refDividesAssoc = this.conn.getAssociation(
		// Divides.ASSOCIATION_DESCRIPTOR );
		// Association dividesAssoc = (Association)
		// refDividesAssoc.refMetaObject( );
		// URI dividesAssocMri = ( (Partitionable) dividesAssoc ).get___Mri( );
		//
		// List<AssociationEnd> dividesAssocEnds = this.conn.getJmiHelper(
		// ).getAssociationEnds( dividesAssoc );
		// AssociationEnd assocEnd = null;
		// if ( dividesAssocEnds.get( 0 ).getName( ).equals( "division" ) ) {
		// assocEnd = dividesAssocEnds.get( 0 );
		// } else {
		// assocEnd = dividesAssocEnds.get( 1 );
		// }
		// int assocEndNumber = ( this.conn.getJmiHelper(
		// ).isFirstAssociationEnd( dividesAssoc, assocEnd ) ? 0 : 1 );
		//
		//
		// String query =
		// "select dep.name, dep from Company::Department as dep where dep." +
		// assocEndNumber + "[\"" + dividesAssocMri +
		// "\"] not in (select div from Company::Division as div where div.budget > 1000000)";
		// MQLPreparedQuery preparedQuery = getMQLProcessor( ).prepare( query );
		//
		// this.departmentsWithSmallDivisions_check( preparedQuery );
	}

	private void departmentsWithSmallDivisions_check(Object preparedQuery) {

		TypeScopeProvider queryScopeProvider = this.getMQLProcessor().getInclusivePartitionScopeProvider(this.globalPartitionScope);
		ResultSet resultSet = this.executeQuery(preparedQuery, this.getQueryContext(queryScopeProvider));

		// verify the result set
		assertEquals(resultSet.getAttribute(0, "dep", "name"), this.department11.getName());
		assertEquals(resultSet.getAttribute(1, "dep", "name"), this.department12.getName());
		// lexicographic ordering guarantees the order (because of the name)
		assertEquals(resultSet.getUri(0, "dep"), EcoreUtil.getURI((this.department11)));
		assertEquals(resultSet.getUri(1, "dep"), EcoreUtil.getURI((this.department12)));
	}

	/**
	 * Return the budgets of all departments and divisions where the department
	 * has a larger budget than the division
	 */
	@Test
	public void departmentsWhichAreBiggerThanDivisions_ast() {

		// from clause
		FromType divisisions = new FromType("div", EcoreUtil.getURI(CompanyPackage.Literals.DIVISION), false);
		FromType departments = new FromType("dep", EcoreUtil.getURI(CompanyPackage.Literals.DEPARTMENT), false);
		FromEntry[] fromEntries = new FromEntry[] { divisisions, departments };

		// select clause
		SelectAttrs selectDivisionBudget = new SelectAttrs("div", new String[] { "budget" });
		SelectAttrs selectDepartmentBudget = new SelectAttrs("dep", new String[] { "budget" });
		SelectEntry[] selectEntries = new SelectEntry[] { selectDivisionBudget, selectDepartmentBudget };

		// where entries
		WhereComparisonAttrs whereBudgets = new WhereComparisonAttrs("div", "budget", Operation.SMALLER, "dep", "budget");
		WhereEntry[] whereEntries = new WhereEntry[] { whereBudgets };

		// the actual query
		Query query = new Query(selectEntries, fromEntries, whereEntries);

		// verify pretty-print
		String querypp = "select div.budget,\n       dep.budget\nfrom type: " + EcoreUtil.getURI(CompanyPackage.Literals.DIVISION)
				+ " as div,\n     type: " + EcoreUtil.getURI(CompanyPackage.Literals.DEPARTMENT)
				+ " as dep\nwhere div.budget < dep.budget\n";
		assertEquals(query.toString(), querypp);

		this.departmentsWhichAreBiggerThanDivisions_check(query);
	}

	/**
	 * Return the budgets of all departments and divisions where the department
	 * has a larger budget than the division
	 */
	@Test
	public void departmentsWhichAreBiggerThanDivisions() {

		String query = "select div.budget, dep.budget from [" + EcoreUtil.getURI(CompanyPackage.Literals.DIVISION) + "]  as div, ["
				+ EcoreUtil.getURI(CompanyPackage.Literals.DEPARTMENT) + "] as dep where div.budget < dep.budget";

		this.departmentsWhichAreBiggerThanDivisions_check(query);
	}

	private void departmentsWhichAreBiggerThanDivisions_check(Object preparedQuery) {

		TypeScopeProvider queryScopeProvider = this.getMQLProcessor().getInclusivePartitionScopeProvider(this.globalPartitionScope);
		ResultSet resultSet = this.executeQuery(preparedQuery, this.getQueryContext(queryScopeProvider));

		// verify the result set
		assertEquals(resultSet.getAttribute(0, "dep", "budget"), new Integer(this.department21.getBudget()));
		assertEquals(resultSet.getAttribute(0, "div", "budget"), new Integer(this.division1.getBudget()));
	}

	/**
	 * Return all departments and their employees (including freelance workers),
	 * where the departments are taken from container (DC) sap.com/sap/ag and
	 * the employees are not taken from certain partitions
	 */
	@Test
	public void departmentsAndEmployeesFromSAP_ast() {

		// from clause
		// QueryScopeProvider queryScopeProvider1 = getMQLProcessor(
		// ).getInclusiveCriScopeProvider( this.containerScope[0] );
		// FromType departments = new FromType( "dep", new String[] { "Company",
		// "Department" }, true, queryScopeProvider1 );
		// QueryScopeProvider queryScopeProvider2 = getMQLProcessor(
		// ).getQueryScopeProvider( false, new PRI[] {
		// this.partitionBosses.getPri( ) }, new CRI[0] );
		// FromType employees = new FromType( "em", new String[] { "Company",
		// "Employee" }, false, queryScopeProvider2 );
		// FromEntry[] fromEntries = new FromEntry[] { departments, employees };
		//
		// // select clause
		// SelectAttrs selectDepartment = new SelectAttrs( "dep", new String[] {
		// "name" } );
		// SelectAttrs selectEmployee = new SelectAttrs( "em", new String[] {
		// "name" } );
		// SelectEntry[] selectEntries = new SelectEntry[] { selectDepartment,
		// selectEmployee };
		//
		// // where entries
		// WhereRelationFeature whereDivides = new WhereRelationFeature( "em",
		// "employer", "dep" );
		// WhereEntry[] whereEntries = new WhereEntry[] { whereDivides };
		//
		// // the actual query
		// MQLQuery query = new MQLQuery( selectEntries, fromEntries,
		// whereEntries );
		//
		// // verify pretty-print
		// String querypp =
		// "select dep.name,\n       em.name\nfrom type: null#Company::Department withoutSubtypes as dep\n           in containers {"
		// + this.containerScope[0] +
		// "},\n     type: null#Company::Employee as em\n           not in partitions {"
		// + this.partitionBosses.getPri( )
		// + "}\nwhere em.employer = dep\n";
		// assertEquals( query.toString( ), querypp );
		//
		// MQLPreparedQuery preparedQuery = getMQLProcessor( ).prepare( query );
		//
		// this.departmentsAndEmployeesFromSAP_check( preparedQuery );
	}

	/**
	 * Return all departments and their employees (including freelance workers),
	 * where the departments are taken from container (DC) sap.com/sap/ag and
	 * the employees are not taken from the bosses
	 */
	@Test
	public void departmentsAndEmployeesFromSAP() {

		// String query = "select dep.name, em.name " +
		// "from Company::Department as dep in containers{\"" +
		// this.containerScope[0] + "\"}, " +
		// "Company::Employee as em not in partitions{\"" +
		// this.partitionBosses.getPri( ) + "\" }" + "where em.employer = dep";
		// MQLPreparedQuery preparedQuery = getMQLProcessor( ).prepare( query );
		//
		// this.departmentsAndEmployeesFromSAP_check( preparedQuery );

	}

	private void departmentsAndEmployeesFromSAP_check(Object preparedQuery) {

		TypeScopeProvider queryScopeProvider = this.getMQLProcessor().getInclusivePartitionScopeProvider(this.globalPartitionScope);
		ResultSet resultSet = this.executeQuery(preparedQuery, this.getQueryContext(queryScopeProvider));

		// verify the result set
		assertEquals(resultSet.getAttribute(0, "dep", "name"), this.department11.getName());
		assertEquals(resultSet.getAttribute(0, "em", "name"), this.boris.getName());
		assertEquals(resultSet.getAttribute(1, "dep", "name"), this.department12.getName());
		assertEquals(resultSet.getAttribute(1, "em", "name"), this.stefan.getName());
		assertEquals(resultSet.getAttribute(2, "dep", "name"), this.department21.getName());
		assertEquals(resultSet.getAttribute(2, "em", "name"), this.eduardFreeLance.getName());
		assertEquals(resultSet.getAttribute(3, "dep", "name"), this.department22.getName());
		assertEquals(resultSet.getAttribute(3, "em", "name"), this.simonFreeLance.getName());
	}

	/**
	 * For a given department, provide its employees (including freelance
	 * workers)
	 */
	@Test
	@Ignore("FixedElement (currently) not supported, therefore duplicate of employeesForAGivenDepartment_ast")
	public void deparmentsAndEmployees_ast() {

		// from clause
		FromType employees = new FromType("em", EcoreUtil.getURI(CompanyPackage.Literals.EMPLOYEE), false);
		FromEntry department = new FromFixedSet("dep", EcoreUtil.getURI(this.department11.eClass()), new URI[] { EcoreUtil
				.getURI((this.department11)) });
		FromEntry[] fromEntries = new FromEntry[] { employees, department };

		// select clause
		SelectAttrs selectEmployeeName = new SelectAttrs("em", new String[] { "name" });
		SelectEntry[] selectEntries = new SelectEntry[] { selectEmployeeName };

		// where entries
		WhereRelationReference whereDivides = new WhereRelationReference("dep", "employee", "em");
		WhereEntry[] whereEntries = new WhereEntry[] { whereDivides };

		// the actual query
		Query query = new Query(selectEntries, fromEntries, whereEntries);

		// verify pretty-print
		String querypp = "select em.name\nfrom type: " + EcoreUtil.getURI(CompanyPackage.Literals.EMPLOYEE)
				+ " as em,\n     fixedElement: " + EcoreUtil.getURI(this.department11) + " as dep\nwhere dep.employee = em\n";
		String querypp2 = query.toString();
		assertEquals(querypp, querypp2);

		this.deparmentsAndEmployees_check(query);
	}

	/**
	 * For a given department, provide its employees (including freelance
	 * workers)
	 */
	@Test
	public void deparmentsAndEmployees() {

		String query = "select em.name from [" + EcoreUtil.getURI(CompanyPackage.Literals.EMPLOYEE) + "] as em, ["
				+ EcoreUtil.getURI(CompanyPackage.Literals.DEPARTMENT) + "] as dep in elements { " + "["
				+ EcoreUtil.getURI(this.department11) + "] } where dep.employee = em";

		this.deparmentsAndEmployees_check(query);
	}

	private void deparmentsAndEmployees_check(Object preparedQuery) {

		TypeScopeProvider queryScopeProvider = this.getMQLProcessor().getInclusivePartitionScopeProvider(this.globalPartitionScope);
		ResultSet resultSet = this.executeQuery(preparedQuery, this.getQueryContext(queryScopeProvider));

		// verify the result set
		assertEquals(resultSet.getAttribute(0, "em", "name"), this.boris.getName());
	}

	/**
	 * Return the employees (including freelance workers) of the departments
	 * identified by the provided MRIs
	 */
	@Test
	public void employeesForAGivenDepartment_ast() {

		// from clause
		FromType employees = new FromType("em", EcoreUtil.getURI(CompanyPackage.Literals.EMPLOYEE), false);
		FromType departments = new FromFixedSet("dep", EcoreUtil.getURI(CompanyPackage.Literals.DEPARTMENT), new URI[] {
				EcoreUtil.getURI(this.department11), EcoreUtil.getURI(this.department12) });
		FromEntry[] fromEntries = new FromEntry[] { employees, departments };

		// select clause
		SelectAttrs selectEmployeeName = new SelectAttrs("em", new String[] { "name" });
		SelectEntry[] selectEntries = new SelectEntry[] { selectEmployeeName };

		// where entries
		WhereRelationReference whereDivides = new WhereRelationReference("dep", "employee", "em");
		WhereEntry[] whereEntries = new WhereEntry[] { whereDivides };

		// the actual query
		Query query = new Query(selectEntries, fromEntries, whereEntries);

		// verify pretty-print
		String querypp = "select em.name\nfrom type: " + EcoreUtil.getURI(CompanyPackage.Literals.EMPLOYEE) + " as em,\n     type: "
				+ EcoreUtil.getURI(CompanyPackage.Literals.DEPARTMENT) + " as dep\n           in elements {"
				+ EcoreUtil.getURI(this.department11) + ",\n                        " + EcoreUtil.getURI(this.department12)
				+ "}\nwhere dep.employee = em\n";
		String querypp2 = query.toString();
		assertEquals(querypp.substring(0, 300), querypp2.substring(0, 300));

		this.employeesForAGivenDepartment_check(query);
	}

	/**
	 * Return the employees (including freelance workers) of the departments
	 * identified by the provided MRIs
	 */
	@Test
	public void employeesForAGivenDepartment() {

		String query = "select em.name from [" + EcoreUtil.getURI(CompanyPackage.Literals.EMPLOYEE) + "] as em, ["
				+ EcoreUtil.getURI(CompanyPackage.Literals.DEPARTMENT) + "] as dep in elements{[" + EcoreUtil.getURI(this.department11)
				+ "], [" + EcoreUtil.getURI(this.department12) + "]} where dep.employee = em";

		this.employeesForAGivenDepartment_check(query);
	}

	/**
	 * Return the employees (including freelance workers) of the departments
	 * identified by the provided MRIs
	 */
	@Test
	public void employeesForAGivenDepartment_2() {

		String query = "select em.name from [" + EcoreUtil.getURI(CompanyPackage.Literals.EMPLOYEE)
				+ "] as em where em.employer in (select dep from [" + EcoreUtil.getURI(CompanyPackage.Literals.DEPARTMENT)
				+ "] as dep in elements{[" + EcoreUtil.getURI(this.department11) + "], [" + EcoreUtil.getURI(this.department12) + "]})";

		this.employeesForAGivenDepartment_check(query);
	}

	private void employeesForAGivenDepartment_check(Object preparedQuery) {

		TypeScopeProvider queryScopeProvider = this.getMQLProcessor().getInclusivePartitionScopeProvider(this.globalPartitionScope);
		ResultSet resultSet = this.executeQuery(preparedQuery, this.getQueryContext(queryScopeProvider));

		// verify the result set
		assertEquals(resultSet.getAttribute(0, "em", "name"), this.boris.getName());
		assertEquals(resultSet.getAttribute(1, "em", "name"), this.stefan.getName());
	}

	@Test
	public void verySpecificEmployees() {

		String query = "select em.name from [" + EcoreUtil.getURI(CompanyPackage.Literals.EMPLOYEE) + "] as em "
				+ " where for em(age > 35 or (name like 'S*') and not(name like '*f'))";

		// execute the query
		this.verySpecificEmployees_check(query);
	}

	private void verySpecificEmployees_check(Object preparedQuery) {

		TypeScopeProvider queryScopeProvider = this.getMQLProcessor().getInclusivePartitionScopeProvider(this.globalPartitionScope);
		ResultSet resultSet = this.executeQuery(preparedQuery, this.getQueryContext(queryScopeProvider));

		// read the result
		assertEquals(resultSet.getAttribute(0, "em", "name"), "Jens");
		assertEquals(resultSet.getAttribute(1, "em", "name"), "Rainer");
		assertEquals(resultSet.getAttribute(2, "em", "name"), "Simon");
		assertEquals(resultSet.getAttribute(3, "em", "name"), "Stefan");
	}

	@Test
	public void employeesWhichAreDirectors() {

		// get directors
		String query = "select em.name from [" + EcoreUtil.getURI(CompanyPackage.Literals.EMPLOYEE) + "] as em "
				+ " where em.directed in (select div from [" + EcoreUtil.getURI(CompanyPackage.Literals.DIVISION) + "] as div)";

		// execute the query
		this.employeesWhichAreDirectors_check(query);
	}

	@Test
	public void employeesWhichAreDirectors_2() {

		// get directors
		String query = "select em.name from [" + EcoreUtil.getURI(CompanyPackage.Literals.EMPLOYEE) + "] as em "
				+ " where em.directed <> null";

		// execute the query
		this.employeesWhichAreDirectors_check(query);
	}

	@Test
	public void employeesWhichAreDirectors_3() {

		// get directors
		String query = "select em.name from [" + EcoreUtil.getURI(CompanyPackage.Literals.EMPLOYEE) + "] as em "
				+ " where em.directed <> null";

		// execute the query
		this.employeesWhichAreDirectors_check(query);
	}

	private void employeesWhichAreDirectors_check(Object preparedQuery) {

		TypeScopeProvider queryScopeProvider = this.getMQLProcessor().getInclusivePartitionScopeProvider(this.globalPartitionScope);
		ResultSet resultSet = this.executeQuery(preparedQuery, this.getQueryContext(queryScopeProvider));

		// read the result
		assertEquals(resultSet.getAttribute(0, "em", "name"), "Rainer");
	}

	@Test
	public void employeesWhichAreNotDirectors() {

		// get all non-directors
		String query = "select em.name from [" + EcoreUtil.getURI(CompanyPackage.Literals.EMPLOYEE) + "] as em "
				+ " where em.directed not in (select div from [" + EcoreUtil.getURI(CompanyPackage.Literals.DIVISION) + "]  as div)";

		// execute the query
		this.employeesWhichAreNotDirectors_check(query);
	}

	@Test
	public void employeesWhichAreNotDirectors_2() {

		// get all non-directors
		String query = "select em.name from [" + EcoreUtil.getURI(CompanyPackage.Literals.EMPLOYEE) + "] as em "
				+ " where em.directed = null";

		// execute the query
		this.employeesWhichAreNotDirectors_check(query);
	}

	@Test
	public void employeesWhichAreNotDirectors_3() {

		// get all non-directors
		String query = "select em.name from [" + EcoreUtil.getURI(CompanyPackage.Literals.EMPLOYEE) + "] as em "
				+ " where em.directed = null";

		// execute the query
		this.employeesWhichAreNotDirectors_check(query);
	}

	private void employeesWhichAreNotDirectors_check(Object preparedQuery) {

		TypeScopeProvider queryScopeProvider = this.getMQLProcessor().getInclusivePartitionScopeProvider(this.globalPartitionScope);
		ResultSet resultSet = this.executeQuery(preparedQuery, this.getQueryContext(queryScopeProvider));

		// read the result
		assertEquals(resultSet.getAttribute(0, "em", "name"), "Boris");
		assertEquals(resultSet.getAttribute(1, "em", "name"), "Eduard");
		assertEquals(resultSet.getAttribute(2, "em", "name"), "Jens");
		assertEquals(resultSet.getAttribute(3, "em", "name"), "Meinolf");
		assertEquals(resultSet.getAttribute(4, "em", "name"), "Simon");
		assertEquals(resultSet.getAttribute(5, "em", "name"), "Stefan");
		
	}

	@Test
	public void metaCheckOnEmployeeInPartition() {

		// FIXME: do we need this test ?
		// String query =
		// "select cl.name from Model::Class as cl in containers{\"" +
		// COMPANY_MM_CONTAINER_NAME
		// + "\"} where cl.isSingleton = false where cl.name like '*Employee*'";
		// MQLResultSet resultSet = this.getMQLProcessor().execute(query);
		//
		// assertEquals(resultSet.getAttributes(0, "cl")[0], "Employee");
		// EClass employee = (EClass) resultSet.getRefObject(0, "cl");
		// assertEquals(employee.getName(), "Employee");
		// employee = (EClass) (resultSet.getRefObjects("cl")[0]);
		// assertEquals(employee.getName(), "Employee");
	}

}
