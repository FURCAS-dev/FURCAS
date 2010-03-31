package com.sap.tc.moin.repository.test.query;

import java.io.StringWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.reflect.RefAssociation;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sap.company.CompanyPackage;
import com.sap.company.Department;
import com.sap.company.Divides;
import com.sap.company.Division;
import com.sap.company.Employee;
import com.sap.company.Freelance;
import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.PartitionsNotSavedException;
import com.sap.tc.moin.repository.mql.FromEntry;
import com.sap.tc.moin.repository.mql.FromFixedElement;
import com.sap.tc.moin.repository.mql.FromFixedSet;
import com.sap.tc.moin.repository.mql.FromType;
import com.sap.tc.moin.repository.mql.LocalWhereEntry;
import com.sap.tc.moin.repository.mql.MQLPreparedQuery;
import com.sap.tc.moin.repository.mql.MQLQuery;
import com.sap.tc.moin.repository.mql.MQLResultSet;
import com.sap.tc.moin.repository.mql.Operation;
import com.sap.tc.moin.repository.mql.QueryScopeProvider;
import com.sap.tc.moin.repository.mql.SelectAlias;
import com.sap.tc.moin.repository.mql.SelectAttrs;
import com.sap.tc.moin.repository.mql.SelectEntry;
import com.sap.tc.moin.repository.mql.WhereComparisonAttrs;
import com.sap.tc.moin.repository.mql.WhereEntry;
import com.sap.tc.moin.repository.mql.WhereInt;
import com.sap.tc.moin.repository.mql.WhereNestedAssoc;
import com.sap.tc.moin.repository.mql.WhereRelationAssoc;
import com.sap.tc.moin.repository.mql.WhereRelationFeature;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.test.fw.TestClient;
import com.sap.tc.moin.test.fw.TestMetaModels;
import com.sap.tc.moin.test.testcase.MoinTestCase;

/**
 * @author D045917
 * @author D046918
 * @version Apr 13, 2006
 */
public class TestSuiteCompanyQueryTests extends MoinTestCase {

    protected static final MoinLogger logger = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_TEST, MoinLocationEnum.MOIN_TEST, BaseSyntheticQueryTests.class );

    private static final String COMPANY_MM_CONTAINER_NAME = "sap.com/tc/moin/test/company";

    private Connection conn;

    private TestClient testClient1;

    private PRI[] globalPartitionScope;

    private CRI[] containerScope;

    private ModelPartition partitionDivAndDep = null;

    private ModelPartition partitionBosses = null;

    private ModelPartition partitionCommonEmployees = null;

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

    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        // Call setup of parent test case
        super.beforeTestMethod( );

        if ( logger.isTraced( MoinSeverity.INFO ) ) {
            logger.trace( MoinSeverity.INFO, "Query Test Starting ==> " );
        }

        this.testClient1 = getTestHelper( ).getDefaultTestClient( true );
        this.testClient1.setAsCurrentClient( );

        this.conn = this.testClient1.getConnection( );

        this.instantiate( );

        try {
            // save 
            this.conn.save( );
        } catch ( PartitionsNotSavedException e ) {
            throw new RuntimeException( e );
        }

    }

    @Override
    @After
    public void afterTestMethod( ) throws Exception {

        if ( logger.isTraced( MoinSeverity.INFO ) ) {
            logger.trace( MoinSeverity.INFO, "==> Query Test Finishing " );
        }
        this.department11 = null;
        this.department12 = null;
        this.deleteCompanyPartition( );

        if ( this.testClient1 != null ) {
            this.testClient1.clear( );
            this.testClient1 = null;
        }
        this.conn = null;
        super.afterTestMethod( );
    }

    public void deleteCompanyPartition( ) {

        try {
            this.partitionDivAndDep.delete( );
            this.partitionBosses.delete( );
            this.partitionCommonEmployees.delete( );
            this.conn.save( );
        } catch ( Exception e ) {
            e.printStackTrace( );
        }
    }

    private void instantiate( ) {

        try {
            this.partitionDivAndDep = this.testClient1.getOrCreatePartitionStable( "TutorialQueries_Company_DivAndDep" );
            this.partitionBosses = this.testClient1.getOrCreatePartitionStable( "TutorialQueries_Company_Bosses" );
            this.partitionCommonEmployees = this.testClient1.getOrCreatePartitionStable( "TutorialQueries_Company_CommonEmployees" );
            this.companyPackage = (CompanyPackage) this.conn.getPackage( TestMetaModels.COMPANY_CN, TestMetaModels.COMPANY_TPE );
        } catch ( Exception e1 ) {
            e1.printStackTrace( );
        }

        this.globalPartitionScope = new PRI[] { this.partitionDivAndDep.getPri( ), this.partitionBosses.getPri( ), this.partitionCommonEmployees.getPri( ) };
        this.containerScope = new CRI[] { this.partitionDivAndDep.getPri( ).getCri( ) };

        this.division1 = conn.createElementInPartition( Division.class, null );
        this.division1.setName( "division1" );
        this.division1.setBudget( 1000000 );
        this.division2 = conn.createElementInPartition( Division.class, null );
        this.division2.setName( "division2" );
        this.division2.setBudget( 2000000 );

        this.department11 = conn.createElementInPartition( Department.class, null );
        this.department11.setName( "department11" );
        this.department11.setMaxJuniors( 5 );
        this.department11.setBudget( 600000 );
        this.department12 = conn.createElementInPartition( Department.class, null );
        this.department12.setName( "department12" );
        this.department12.setMaxJuniors( 5 );
        this.department12.setBudget( 400000 );
        this.department21 = conn.createElementInPartition( Department.class, null );
        this.department21.setName( "department21" );
        this.department21.setMaxJuniors( 5 );
        this.department21.setBudget( 1200000 );
        this.department22 = conn.createElementInPartition( Department.class, null );
        this.department22.setName( "department22" );
        this.department22.setMaxJuniors( 5 );
        this.department22.setBudget( 800000 );

        this.division1.getDepartment( ).add( this.department11 );
        this.division1.getDepartment( ).add( this.department12 );
        this.division2.getDepartment( ).add( this.department21 );
        this.division2.getDepartment( ).add( this.department22 );

        this.rainerDirector = conn.createElementInPartition( Employee.class, null );
        this.rainerDirector.setAge( 50 );
        this.rainerDirector.setName( "Rainer" );
        this.rainerDirector.setSalary( 100000 );
        this.rainerDirector.setDirected( this.division1 );
        this.rainerDirector.setDirected( this.division2 );

        this.meinolfDivision1Departments = conn.createElementInPartition( Employee.class, null );
        this.meinolfDivision1Departments.setAge( 36 );
        this.meinolfDivision1Departments.setName( "Meinolf" );
        this.meinolfDivision1Departments.setSalary( 50000 );
        this.meinolfDivision1Departments.setManaged( this.department11 );
        this.meinolfDivision1Departments.setManaged( this.department12 );

        this.jensDivision2Departments = conn.createElementInPartition( Employee.class, null );
        this.jensDivision2Departments.setAge( 40 );
        this.jensDivision2Departments.setName( "Jens" );
        this.jensDivision2Departments.setSalary( 70000 );
        this.jensDivision2Departments.setManaged( this.department21 );
        this.jensDivision2Departments.setManaged( this.department22 );

        this.boris = conn.createElementInPartition( Employee.class, null );
        this.boris.setAge( 25 );
        this.boris.setName( "Boris" );
        this.boris.setSalary( 20000 );
        this.boris.setEmployer( this.department11 );

        this.stefan = conn.createElementInPartition( Employee.class, null );
        this.stefan.setAge( 30 );
        this.stefan.setName( "Stefan" );
        this.stefan.setSalary( 30000 );
        this.stefan.setEmployer( this.department12 );

        this.eduardFreeLance = conn.createElementInPartition( Freelance.class, null );
        this.eduardFreeLance.setAge( 35 );
        this.eduardFreeLance.setName( "Eduard" );
        this.eduardFreeLance.setSalary( 40000 );
        this.eduardFreeLance.setEmployer( this.department21 );
        this.eduardFreeLance.setAssignment( 100 );

        this.simonFreeLance = conn.createElementInPartition( Freelance.class, null );
        this.simonFreeLance.setAge( 40 );
        this.simonFreeLance.setName( "Simon" );
        this.simonFreeLance.setSalary( 40000 );
        this.simonFreeLance.setEmployer( this.department22 );
        this.simonFreeLance.setAssignment( 200 );

        this.partitionDivAndDep.assignElement( this.division1 );
        this.partitionDivAndDep.assignElement( this.division2 );
        this.partitionDivAndDep.assignElement( this.department11 );
        this.partitionDivAndDep.assignElement( this.department12 );
        this.partitionDivAndDep.assignElement( this.department21 );
        this.partitionDivAndDep.assignElement( this.department22 );
        this.partitionBosses.assignElement( this.rainerDirector );
        this.partitionBosses.assignElement( this.meinolfDivision1Departments );
        this.partitionBosses.assignElement( this.jensDivision2Departments );
        this.partitionCommonEmployees.assignElement( this.boris );
        this.partitionCommonEmployees.assignElement( this.stefan );
        this.partitionCommonEmployees.assignElement( this.eduardFreeLance );
        this.partitionCommonEmployees.assignElement( this.simonFreeLance );
    }

    /**
     * Return the elements (MRIs) and names of all employees (but not those who
     * freelance), which are younger than 40.
     */
    @Test
    public void employeesUnder40_ast( ) {

        // from clause
        FromType employees = new FromType( "em", new String[] { "Company", "Employee" }, COMPANY_MM_CONTAINER_NAME, true );
        FromEntry[] fromEntries = new FromEntry[] { employees };

        // select clause
        SelectAttrs selectEmployeeName = new SelectAttrs( "em", new String[] { "name" } );
        SelectAlias selectEm = new SelectAlias( "em" );
        SelectEntry[] selectEntries = new SelectEntry[] { selectEm, selectEmployeeName };

        // where entries
        WhereInt whereYoung = new WhereInt( "age", Operation.SMALLER, 40 );
        WhereEntry whereEmYoung = new LocalWhereEntry( "em", whereYoung );
        WhereEntry[] whereEntries = new WhereEntry[] { whereEmYoung };

        // the actual query
        MQLQuery query = new MQLQuery( selectEntries, fromEntries, whereEntries );

        // verify pretty-print
        String querypp = "select em,\n       em.name\nfrom type: " + COMPANY_MM_CONTAINER_NAME + "#Company::Employee withoutSubtypes as em\nwhere for em(age SMALLER 40)\n";
        assertEquals( query.toString( ), querypp );

        // execute the query
        MQLPreparedQuery preparedQuery = this.conn.getMQLProcessor( ).prepare( query );

        this.employeesUnder40_check( preparedQuery );
    }

    /**
     * Return the elements (MRIs) and names of all employees (but not those who
     * freelance), which are younger than 40.
     */
    @Test
    public void employeesUnder40( ) {

        String query = "select em, em.name from \"" + COMPANY_MM_CONTAINER_NAME + "\"#Company::Employee withoutsubtypes as em " + " where for em(age < 40)";

        // execute the query
        MQLPreparedQuery preparedQuery = this.conn.getMQLProcessor( ).prepare( query );

        this.employeesUnder40_check( preparedQuery );
    }

    /**
     * Return the elements (MRIs) and names of all employees (but not those who
     * freelance), which are younger than 40.
     */
    @Test
    public void employeesUnder40_2( ) {

        String query = "select em, em.name from \"" + COMPANY_MM_CONTAINER_NAME + "\"#Company::Employee withoutsubtypes as em " + " where em.age < 40";

        // execute the query
        MQLPreparedQuery preparedQuery = this.conn.getMQLProcessor( ).prepare( query );

        this.employeesUnder40_check( preparedQuery );
    }

    private void employeesUnder40_check( MQLPreparedQuery preparedQuery ) {

        QueryScopeProvider queryScopeProvider = this.conn.getMQLProcessor( ).getInclusivePartitionScopeProvider( this.globalPartitionScope );
        MQLResultSet resultSet = this.conn.getMQLProcessor( ).execute( preparedQuery, queryScopeProvider );

        // verify the result set
        RefObject[] resultEmployees = resultSet.getRefObjects( "em" );
        Set<RefObject> resultEmployeesSet = new HashSet<RefObject>( Arrays.asList( resultEmployees ) );
        assertTrue( resultEmployeesSet.contains( this.meinolfDivision1Departments ) );
        assertTrue( resultEmployeesSet.contains( this.boris ) );
        assertTrue( resultEmployeesSet.contains( this.stefan ) );
        Writer writer = new StringWriter( );
        resultSet.asCSV( writer );
        assertEquals( resultSet.toString( ), writer.toString( ) );
    }

    @Test
    public void employeesWithoutBosses( ) {

        String query1 = "select em from \"" + COMPANY_MM_CONTAINER_NAME + "\"#Company::Employee withoutsubtypes as em where em.employer = null";

        MQLPreparedQuery preparedQuery1 = this.conn.getMQLProcessor( ).prepare( query1 );

        String query2 = "select em.name from \"" + COMPANY_MM_CONTAINER_NAME + "\"#Company::Employee withoutsubtypes as em where em.employer = null";

        MQLPreparedQuery preparedQuery2 = this.conn.getMQLProcessor( ).prepare( query2 );

        this.employeesWithoutBosses_check( preparedQuery1, preparedQuery2 );
    }

    private void employeesWithoutBosses_check( MQLPreparedQuery preparedQuery1, MQLPreparedQuery preparedQuery2 ) {

        QueryScopeProvider queryScopeProvider = this.conn.getMQLProcessor( ).getInclusivePartitionScopeProvider( this.globalPartitionScope );
        MQLResultSet resultSet1 = this.conn.getMQLProcessor( ).execute( preparedQuery1, queryScopeProvider );
        MQLResultSet resultSet2 = this.conn.getMQLProcessor( ).execute( preparedQuery2, queryScopeProvider );

        assertEquals( resultSet1.getSize( ), resultSet2.getSize( ) );
    }


    /**
     * Return the names of all the companies divisions and their departments
     */
    @Test
    public void allDepartmentsAndDivisions_ast( ) {

        // from clause
        FromType divisisions = new FromType( "div", new String[] { "Company", "Division" }, COMPANY_MM_CONTAINER_NAME, false );
        FromType departments = new FromType( "dep", new String[] { "Company", "Department" }, COMPANY_MM_CONTAINER_NAME, false );
        FromEntry[] fromEntries = new FromEntry[] { divisisions, departments };

        // select clause
        SelectAttrs selectDivisionName = new SelectAttrs( "div", new String[] { "name" } );
        SelectAttrs selectDepartmentName = new SelectAttrs( "dep", new String[] { "name" } );
        SelectEntry[] selectEntries = new SelectEntry[] { selectDivisionName, selectDepartmentName };

        // where entries
        WhereRelationAssoc whereDivides = new WhereRelationAssoc( "div", "department", null, new String[] { "Company", "Divides" }, "dep" );
        WhereEntry[] whereEntries = new WhereEntry[] { whereDivides };

        // the actual query
        MQLQuery query = new MQLQuery( selectEntries, fromEntries, whereEntries );

        // verify pretty-print
        String querypp = "select div.name,\n       dep.name\nfrom type: " + COMPANY_MM_CONTAINER_NAME + "#Company::Division as div,\n     type: " + COMPANY_MM_CONTAINER_NAME + "#Company::Department as dep\nwhere div.department[null#Company::Divides] = dep\n";
        assertEquals( query.toString( ), querypp );

        MQLPreparedQuery preparedQuery = this.conn.getMQLProcessor( ).prepare( query );

        this.allDepartmentsAndDivisions_check( preparedQuery );
    }

    /**
     * Return the names of all the companies divisions and their departments
     */
    @Test
    public void allDepartmentsAndDivisions( ) {

        String query = "select div.name, dep.name from Company::Division as div, " + "\"" + COMPANY_MM_CONTAINER_NAME + "\"#Company::Department as dep " + " where div.department[Company::Divides] = dep";
        MQLPreparedQuery preparedQuery = this.conn.getMQLProcessor( ).prepare( query );

        this.allDepartmentsAndDivisions_check( preparedQuery );
    }

    @Test
    public void allDepartmentsAndDivisions_2( ) {

        RefAssociation refDividesAssoc = this.conn.getAssociation( Divides.ASSOCIATION_DESCRIPTOR );
        Association dividesAssoc = refDividesAssoc.refMetaObject( );
        MRI dividesAssocMri = ( (Partitionable) dividesAssoc ).get___Mri( );

        List<AssociationEnd> dividesAssocEnds = this.conn.getJmiHelper( ).getAssociationEnds( dividesAssoc );
        AssociationEnd assocEnd = null;
        if ( dividesAssocEnds.get( 0 ).getName( ).equals( "department" ) ) {
            assocEnd = dividesAssocEnds.get( 0 );
        } else {
            assocEnd = dividesAssocEnds.get( 1 );
        }
        int assocEndNumber = ( this.conn.getJmiHelper( ).isFirstAssociationEnd( dividesAssoc, assocEnd ) ? 0 : 1 );

        String query = "select div.name, dep.name from type \"" + ( (Partitionable) this.division1.refMetaObject( ) ).get___Mri( ) + "\" as div, Company::Department as dep where div." + assocEndNumber + "[\"" + dividesAssocMri + "\"] = dep";
        MQLPreparedQuery preparedQuery = this.conn.getMQLProcessor( ).prepare( query );

        this.allDepartmentsAndDivisions_check( preparedQuery );
    }


    private void allDepartmentsAndDivisions_check( MQLPreparedQuery preparedQuery ) {

        QueryScopeProvider queryScopeProvider = this.conn.getMQLProcessor( ).getInclusivePartitionScopeProvider( this.globalPartitionScope );
        MQLResultSet resultSet = this.conn.getMQLProcessor( ).execute( preparedQuery, queryScopeProvider );

        // verify the result set
        assertEquals( resultSet.getAttribute( 0, "div", "name" ), this.division1.getName( ) );
        assertEquals( resultSet.getAttribute( 1, "div", "name" ), this.division1.getName( ) );
        assertEquals( resultSet.getAttribute( 2, "div", "name" ), this.division2.getName( ) );
        assertEquals( resultSet.getAttribute( 3, "div", "name" ), this.division2.getName( ) );
        assertEquals( resultSet.getAttribute( 0, "dep", "name" ), this.department11.getName( ) );
        assertEquals( resultSet.getAttribute( 1, "dep", "name" ), this.department12.getName( ) );
        assertEquals( resultSet.getAttribute( 2, "dep", "name" ), this.department21.getName( ) );
        assertEquals( resultSet.getAttribute( 3, "dep", "name" ), this.department22.getName( ) );
    }

    /**
     * Return the names of all companys divisions and their departments
     */
    @Test
    public void allDepartmentsAndDivisions_withFeature_ast( ) {

        // from clause
        FromType divisions = new FromType( "div", new String[] { "Company", "Division" }, COMPANY_MM_CONTAINER_NAME, false );
        FromType departments = new FromType( "dep", new String[] { "Company", "Department" }, COMPANY_MM_CONTAINER_NAME, false );
        FromEntry[] fromEntries = new FromEntry[] { divisions, departments };

        // select clause
        SelectAttrs selectDivisionName = new SelectAttrs( "div", new String[] { "name" } );
        SelectAttrs selectDepartmentName = new SelectAttrs( "dep", new String[] { "name" } );
        SelectEntry[] selectEntries = new SelectEntry[] { selectDivisionName, selectDepartmentName };

        // where entries
        WhereRelationFeature whereDivides = new WhereRelationFeature( "div", "department", "dep" );
        WhereEntry[] whereEntries = new WhereEntry[] { whereDivides };

        // the actual query
        MQLQuery query = new MQLQuery( selectEntries, fromEntries, whereEntries );

        // verify pretty-print
        String querypp = "select div.name,\n       dep.name\nfrom type: " + COMPANY_MM_CONTAINER_NAME + "#Company::Division as div,\n     type: " + COMPANY_MM_CONTAINER_NAME + "#Company::Department as dep\nwhere div.department = dep\n";
        assertEquals( query.toString( ), querypp );

        MQLPreparedQuery preparedQuery = this.conn.getMQLProcessor( ).prepare( query );

        this.allDepartmentsAndDivisions_check( preparedQuery );
    }

    /**
     * Return the names of all company�s divisions and their departments
     */
    @Test
    public void allDepartmentsAndDivisions_withFeature( ) {

        String query = "select div.name, dep.name from Company::Division as div, " + "\"" + COMPANY_MM_CONTAINER_NAME + "\"#Company::Department as dep " + " where div.department = dep";
        MQLPreparedQuery preparedQuery = this.conn.getMQLProcessor( ).prepare( query );

        this.allDepartmentsAndDivisions_check( preparedQuery );
    }

    /**
     * Return the MRIs and names of departments, which do not belong to a
     * division whose budget is more than 1.000.000 Euros
     */
    @Test
    public void departmentsWithSmallDivisions_ast( ) {

        // sub-query: Get all divisions whose budget is more than 1.000.000
        // Euros
        FromType divisions = new FromType( "div", new String[] { "Company", "Division" }, COMPANY_MM_CONTAINER_NAME, false );
        FromEntry[] divFromEntries = new FromEntry[] { divisions };
        SelectAlias selectDiv = new SelectAlias( "div" );
        SelectEntry[] divSelectEntries = new SelectEntry[] { selectDiv };
        WhereInt whereBudget = new WhereInt( "budget", Operation.GREATER, 1000000 );
        WhereEntry whereDivBudget = new LocalWhereEntry( "div", whereBudget );
        WhereEntry[] divWhereEntries = new WhereEntry[] { whereDivBudget };
        MQLQuery nestedQuery = new MQLQuery( divSelectEntries, divFromEntries, divWhereEntries );

        // from clause
        FromType departments = new FromType( "dep", new String[] { "Company", "Department" }, COMPANY_MM_CONTAINER_NAME, false );
        FromEntry[] fromEntries = new FromEntry[] { departments };

        // select clause
        SelectAlias selectDep = new SelectAlias( "dep" );
        SelectAttrs selectDepartmentName = new SelectAttrs( "dep", new String[] { "name" } );
        SelectEntry[] selectEntries = new SelectEntry[] { selectDepartmentName, selectDep };

        // where entries
        WhereNestedAssoc whereDivides = new WhereNestedAssoc( true, "dep", new String[] { "Company", "Divides" }, null, "division", nestedQuery );
        WhereEntry[] whereEntries = new WhereEntry[] { whereDivides };

        // the actual query
        MQLQuery query = new MQLQuery( selectEntries, fromEntries, whereEntries );

        // verify pretty-print
        String querypp = "select dep.name,\n       dep\nfrom type: " + COMPANY_MM_CONTAINER_NAME + "#Company::Department as dep\nwhere dep.division[null#Company::Divides] not in\n       select div\n       from type: " + COMPANY_MM_CONTAINER_NAME
                         + "#Company::Division as div\n       where for div(budget GREATER 1000000)\n       \n";
        assertEquals( query.toString( ), querypp );

        MQLPreparedQuery preparedQuery = this.conn.getMQLProcessor( ).prepare( query );

        this.departmentsWithSmallDivisions_check( preparedQuery );
    }

    /**
     * Return the MRIs and names of departments, which do not belong to a
     * division whose budget is more than 1.000.000 Euros
     */
    @Test
    public void departmentsWithSmallDivisions( ) {

        String query = "select dep.name, dep " + "from Company::Department as dep " + "where dep.division[Company::Divides] not in " + "(select div " + " from Company::Division as div where " + " for div(budget > 1000000))";
        MQLPreparedQuery preparedQuery = this.conn.getMQLProcessor( ).prepare( query );

        this.departmentsWithSmallDivisions_check( preparedQuery );
    }

    /**
     * Return the MRIs and names of departments, which do not belong to a
     * division whose budget is more than 1.000.000 Euros
     */
    @Test
    public void departmentsWithSmallDivisions_2( ) {

        String query = "select dep.name, dep " + "from Company::Department as dep " + "where dep.division[Company::Divides] not in " + "(select div " + " from Company::Division as div where " + " div.budget > 1000000)";
        MQLPreparedQuery preparedQuery = this.conn.getMQLProcessor( ).prepare( query );

        this.departmentsWithSmallDivisions_check( preparedQuery );
    }

    /**
     * Return the MRIs and names of departments, which do not belong to a
     * division whose budget is more than 1.000.000 Euros
     */
    @Test
    public void departmentsWithSmallDivisions_3( ) {

        String query = "select dep.name, dep " + "from Company::Department as dep " + "where dep.division[Company::Divides] not in " + "(select div " + " from Company::Division as div where " + " div.budget >= 1000001)";
        MQLPreparedQuery preparedQuery = this.conn.getMQLProcessor( ).prepare( query );

        this.departmentsWithSmallDivisions_check( preparedQuery );
    }

    /**
     * Return the MRIs and names of departments, which do not belong to a
     * division whose budget is more than 1.000.000 Euros
     */
    @Test
    public void departmentsWithSmallDivisions_4( ) {

        RefAssociation refDividesAssoc = this.conn.getAssociation( Divides.ASSOCIATION_DESCRIPTOR );
        Association dividesAssoc = (Association) refDividesAssoc.refMetaObject( );
        MRI dividesAssocMri = ( (Partitionable) dividesAssoc ).get___Mri( );

        List<AssociationEnd> dividesAssocEnds = this.conn.getJmiHelper( ).getAssociationEnds( dividesAssoc );
        AssociationEnd assocEnd = null;
        if ( dividesAssocEnds.get( 0 ).getName( ).equals( "division" ) ) {
            assocEnd = dividesAssocEnds.get( 0 );
        } else {
            assocEnd = dividesAssocEnds.get( 1 );
        }
        int assocEndNumber = ( this.conn.getJmiHelper( ).isFirstAssociationEnd( dividesAssoc, assocEnd ) ? 0 : 1 );


        String query = "select dep.name, dep from Company::Department as dep where dep." + assocEndNumber + "[\"" + dividesAssocMri + "\"] not in (select div from Company::Division as div where div.budget > 1000000)";
        MQLPreparedQuery preparedQuery = this.conn.getMQLProcessor( ).prepare( query );

        this.departmentsWithSmallDivisions_check( preparedQuery );
    }

    private void departmentsWithSmallDivisions_check( MQLPreparedQuery preparedQuery ) {

        QueryScopeProvider queryScopeProvider = this.conn.getMQLProcessor( ).getInclusivePartitionScopeProvider( this.globalPartitionScope );
        MQLResultSet resultSet = this.conn.getMQLProcessor( ).execute( preparedQuery, queryScopeProvider );

        // verify the result set
        assertEquals( resultSet.getAttribute( 0, "dep", "name" ), this.department11.getName( ) );
        assertEquals( resultSet.getAttribute( 1, "dep", "name" ), this.department12.getName( ) );
        // lexicographic ordering guarantees the order (because of the name)
        assertEquals( resultSet.getMri( 0, "dep" ), ( (Partitionable) this.department11 ).get___Mri( ) );
        assertEquals( resultSet.getMri( 1, "dep" ), ( (Partitionable) this.department12 ).get___Mri( ) );
    }

    /**
     * Return the budgets of all departments and divisions where the department
     * has a larger budget than the division
     */
    @Test
    public void departmentsWhichAreBiggerThanDivisions_ast( ) {

        // from clause
        FromType divisisions = new FromType( "div", new String[] { "Company", "Division" }, COMPANY_MM_CONTAINER_NAME, false );
        FromType departments = new FromType( "dep", new String[] { "Company", "Department" }, COMPANY_MM_CONTAINER_NAME, false );
        FromEntry[] fromEntries = new FromEntry[] { divisisions, departments };

        // select clause
        SelectAttrs selectDivisionBudget = new SelectAttrs( "div", new String[] { "budget" } );
        SelectAttrs selectDepartmentBudget = new SelectAttrs( "dep", new String[] { "budget" } );
        SelectEntry[] selectEntries = new SelectEntry[] { selectDivisionBudget, selectDepartmentBudget };

        // where entries
        WhereComparisonAttrs whereBudgets = new WhereComparisonAttrs( "div", "budget", Operation.SMALLER, "dep", "budget" );
        WhereEntry[] whereEntries = new WhereEntry[] { whereBudgets };

        // the actual query
        MQLQuery query = new MQLQuery( selectEntries, fromEntries, whereEntries );

        // verify pretty-print
        String querypp = "select div.budget,\n       dep.budget\nfrom type: " + COMPANY_MM_CONTAINER_NAME + "#Company::Division as div,\n     type: " + COMPANY_MM_CONTAINER_NAME + "#Company::Department as dep\nwhere div.budget < dep.budget\n";
        assertEquals( query.toString( ), querypp );

        MQLPreparedQuery preparedQuery = this.conn.getMQLProcessor( ).prepare( query );

        this.departmentsWhichAreBiggerThanDivisions_check( preparedQuery );
    }

    /**
     * Return the budgets of all departments and divisions where the department
     * has a larger budget than the division
     */
    @Test
    public void departmentsWhichAreBiggerThanDivisions( ) {

        String query = "select div.budget, dep.budget from Company::Division as div, " + "Company::Department as dep where div.budget < dep.budget";
        MQLPreparedQuery preparedQuery = this.conn.getMQLProcessor( ).prepare( query );

        this.departmentsWhichAreBiggerThanDivisions_check( preparedQuery );
    }

    private void departmentsWhichAreBiggerThanDivisions_check( MQLPreparedQuery preparedQuery ) {

        QueryScopeProvider queryScopeProvider = this.conn.getMQLProcessor( ).getInclusivePartitionScopeProvider( this.globalPartitionScope );
        MQLResultSet resultSet = this.conn.getMQLProcessor( ).execute( preparedQuery, queryScopeProvider );

        // verify the result set
        assertEquals( resultSet.getAttribute( 0, "dep", "budget" ), new Integer( this.department21.getBudget( ) ) );
        assertEquals( resultSet.getAttribute( 0, "div", "budget" ), new Integer( this.division1.getBudget( ) ) );
    }


    /**
     * Return all departments and their employees (including freelance workers),
     * where the departments are taken from container (DC) sap.com/sap/ag and
     * the employees are not taken from certain partitions
     */
    @Test
    public void departmentsAndEmployeesFromSAP_ast( ) {

        // from clause
        QueryScopeProvider queryScopeProvider1 = this.conn.getMQLProcessor( ).getInclusiveCriScopeProvider( this.containerScope[0] );
        FromType departments = new FromType( "dep", new String[] { "Company", "Department" }, true, queryScopeProvider1 );
        QueryScopeProvider queryScopeProvider2 = this.conn.getMQLProcessor( ).getQueryScopeProvider( false, new PRI[] { this.partitionBosses.getPri( ) }, new CRI[0] );
        FromType employees = new FromType( "em", new String[] { "Company", "Employee" }, false, queryScopeProvider2 );
        FromEntry[] fromEntries = new FromEntry[] { departments, employees };

        // select clause
        SelectAttrs selectDepartment = new SelectAttrs( "dep", new String[] { "name" } );
        SelectAttrs selectEmployee = new SelectAttrs( "em", new String[] { "name" } );
        SelectEntry[] selectEntries = new SelectEntry[] { selectDepartment, selectEmployee };

        // where entries
        WhereRelationFeature whereDivides = new WhereRelationFeature( "em", "employer", "dep" );
        WhereEntry[] whereEntries = new WhereEntry[] { whereDivides };

        // the actual query
        MQLQuery query = new MQLQuery( selectEntries, fromEntries, whereEntries );

        // verify pretty-print
        String querypp = "select dep.name,\n       em.name\nfrom type: null#Company::Department withoutSubtypes as dep\n           in containers {" + this.containerScope[0] + "},\n     type: null#Company::Employee as em\n           not in partitions {" + this.partitionBosses.getPri( )
                         + "}\nwhere em.employer = dep\n";
        assertEquals( query.toString( ), querypp );

        MQLPreparedQuery preparedQuery = this.conn.getMQLProcessor( ).prepare( query );

        this.departmentsAndEmployeesFromSAP_check( preparedQuery );
    }

    /**
     * Return all departments and their employees (including freelance workers),
     * where the departments are taken from container (DC) sap.com/sap/ag and
     * the employees are not taken from the bosses
     */
    @Test
    public void departmentsAndEmployeesFromSAP( ) {

        String query = "select dep.name, em.name " + "from Company::Department as dep in containers{\"" + this.containerScope[0] + "\"}, " + "Company::Employee as em not in partitions{\"" + this.partitionBosses.getPri( ) + "\" }" + "where em.employer = dep";
        MQLPreparedQuery preparedQuery = this.conn.getMQLProcessor( ).prepare( query );

        this.departmentsAndEmployeesFromSAP_check( preparedQuery );

    }

    private void departmentsAndEmployeesFromSAP_check( MQLPreparedQuery preparedQuery ) {

        QueryScopeProvider queryScopeProvider = this.conn.getMQLProcessor( ).getInclusivePartitionScopeProvider( this.globalPartitionScope );
        MQLResultSet resultSet = this.conn.getMQLProcessor( ).execute( preparedQuery, queryScopeProvider );

        // verify the result set
        assertEquals( resultSet.getAttribute( 0, "dep", "name" ), this.department11.getName( ) );
        assertEquals( resultSet.getAttribute( 0, "em", "name" ), this.boris.getName( ) );
        assertEquals( resultSet.getAttribute( 1, "dep", "name" ), this.department12.getName( ) );
        assertEquals( resultSet.getAttribute( 1, "em", "name" ), this.stefan.getName( ) );
        assertEquals( resultSet.getAttribute( 2, "dep", "name" ), this.department21.getName( ) );
        assertEquals( resultSet.getAttribute( 2, "em", "name" ), this.eduardFreeLance.getName( ) );
        assertEquals( resultSet.getAttribute( 3, "dep", "name" ), this.department22.getName( ) );
        assertEquals( resultSet.getAttribute( 3, "em", "name" ), this.simonFreeLance.getName( ) );
    }

    /**
     * For a given department, provide its employees (including freelance
     * workers)
     */
    @Test
    public void deparmentsAndEmployees_ast( ) {

        // from clause
        FromType employees = new FromType( "em", new String[] { "Company", "Employee" }, COMPANY_MM_CONTAINER_NAME, false );
        FromEntry department = new FromFixedElement( "dep", ( (Partitionable) this.department11 ).get___Mri( ) );
        FromEntry[] fromEntries = new FromEntry[] { employees, department };

        // select clause
        SelectAttrs selectEmployeeName = new SelectAttrs( "em", new String[] { "name" } );
        SelectEntry[] selectEntries = new SelectEntry[] { selectEmployeeName };

        // where entries
        WhereRelationFeature whereDivides = new WhereRelationFeature( "dep", "employee", "em" );
        WhereEntry[] whereEntries = new WhereEntry[] { whereDivides };

        // the actual query
        MQLQuery query = new MQLQuery( selectEntries, fromEntries, whereEntries );

        // verify pretty-print
        String querypp = "select em.name\nfrom type: " + COMPANY_MM_CONTAINER_NAME + "#Company::Employee as em,\n     fixedElement: " + ( (Partitionable) this.department11 ).get___Mri( ) + " as dep\nwhere dep.employee = em\n";
        String querypp2 = query.toString( );
        assertEquals( querypp, querypp2 );

        MQLPreparedQuery preparedQuery = this.conn.getMQLProcessor( ).prepare( query );

        this.deparmentsAndEmployees_check( preparedQuery );
    }

    /**
     * For a given department, provide its employees (including freelance
     * workers)
     */
    @Test
    public void deparmentsAndEmployees( ) {

        String query = "select em.name from \"" + COMPANY_MM_CONTAINER_NAME + "\"#Company::Employee as em, " + "\"" + ( (Partitionable) this.department11 ).get___Mri( ) + "\" as dep where dep.employee = em";

        MQLPreparedQuery preparedQuery = this.conn.getMQLProcessor( ).prepare( query );

        this.deparmentsAndEmployees_check( preparedQuery );
    }

    private void deparmentsAndEmployees_check( MQLPreparedQuery preparedQuery ) {

        QueryScopeProvider queryScopeProvider = this.conn.getMQLProcessor( ).getInclusivePartitionScopeProvider( this.globalPartitionScope );
        MQLResultSet resultSet = this.conn.getMQLProcessor( ).execute( preparedQuery, queryScopeProvider );

        // verify the result set
        assertEquals( resultSet.getAttribute( 0, "em", "name" ), this.boris.getName( ) );
    }

    /**
     * Return the employees (including freelance workers) of the departments
     * identified by the provided MRIs
     */
    @Test
    public void employeesForAGivenDepartment_ast( ) {

        // from clause
        FromType employees = new FromType( "em", new String[] { "Company", "Employee" }, COMPANY_MM_CONTAINER_NAME, false );
        FromType departments = new FromFixedSet( "dep", new String[] { "Company", "Department" }, COMPANY_MM_CONTAINER_NAME, new MRI[] { ( (Partitionable) this.department11 ).get___Mri( ), ( (Partitionable) this.department12 ).get___Mri( ) } );
        FromEntry[] fromEntries = new FromEntry[] { employees, departments };

        // select clause
        SelectAttrs selectEmployeeName = new SelectAttrs( "em", new String[] { "name" } );
        SelectEntry[] selectEntries = new SelectEntry[] { selectEmployeeName };

        // where entries
        WhereRelationFeature whereDivides = new WhereRelationFeature( "dep", "employee", "em" );
        WhereEntry[] whereEntries = new WhereEntry[] { whereDivides };

        // the actual query
        MQLQuery query = new MQLQuery( selectEntries, fromEntries, whereEntries );

        // verify pretty-print
        String querypp = "select em.name\nfrom type: " + COMPANY_MM_CONTAINER_NAME + "#Company::Employee as em,\n     type: " + COMPANY_MM_CONTAINER_NAME + "#Company::Department as dep\n           in elements {" + ( (Partitionable) this.department11 ).get___Mri( ) + ",\n                        "
                         + ( (Partitionable) this.department12 ).get___Mri( ) + "}\nwhere dep.employee = em\n";
        String querypp2 = query.toString( );
        assertEquals( querypp.substring( 0, 300 ), querypp2.substring( 0, 300 ) );

        MQLPreparedQuery preparedQuery = this.conn.getMQLProcessor( ).prepare( query );

        this.employeesForAGivenDepartment_check( preparedQuery );
    }

    /**
     * Return the employees (including freelance workers) of the departments
     * identified by the provided MRIs
     */
    @Test
    public void employeesForAGivenDepartment( ) {

        String query = "select em.name from \"" + COMPANY_MM_CONTAINER_NAME + "\"#Company::Employee as em, " + "Company::Department as dep in elements{\"" + ( (Partitionable) this.department11 ).get___Mri( ) + "\", \"" + ( (Partitionable) this.department12 ).get___Mri( )
                       + "\"} where dep.employee = em";

        MQLPreparedQuery preparedQuery = this.conn.getMQLProcessor( ).prepare( query );

        String ppQuerypp = "(select[PF] em.name(STRING)\n from {" + COMPANY_MM_CONTAINER_NAME + "#Company::Employee,\n       " + COMPANY_MM_CONTAINER_NAME + "#Company::Freelance,\n       " + COMPANY_MM_CONTAINER_NAME + "#Company::Student} as em,\n      {" + COMPANY_MM_CONTAINER_NAME
                           + "#Company::Department} as dep\n       in E{" + ( (Partitionable) this.department11 ).get___Mri( ) + ",\n            " + ( (Partitionable) this.department12 ).get___Mri( ) + "}\n where dep.employee[ " + COMPANY_MM_CONTAINER_NAME + "#Company::WorksIn @] = em) as result";
        String ppQuerypp2 = preparedQuery.toString( );
        assertEquals( ppQuerypp.substring( 0, 407 ), ppQuerypp2.substring( 0, 407 ) );

        this.employeesForAGivenDepartment_check( preparedQuery );
    }

    /**
     * Return the employees (including freelance workers) of the departments
     * identified by the provided MRIs
     */
    @Test
    public void employeesForAGivenDepartment_2( ) {

        String query = "select em.name from \"" + COMPANY_MM_CONTAINER_NAME + "\"#Company::Employee as em where em.employer in (select dep from Company::Department as dep in elements{\"" + ( (Partitionable) this.department11 ).get___Mri( ) + "\", \""
                       + ( (Partitionable) this.department12 ).get___Mri( ) + "\"})";

        MQLPreparedQuery preparedQuery = this.conn.getMQLProcessor( ).prepare( query );

        this.employeesForAGivenDepartment_check( preparedQuery );
    }

    private void employeesForAGivenDepartment_check( MQLPreparedQuery preparedQuery ) {

        QueryScopeProvider queryScopeProvider = this.conn.getMQLProcessor( ).getInclusivePartitionScopeProvider( this.globalPartitionScope );
        MQLResultSet resultSet = this.conn.getMQLProcessor( ).execute( preparedQuery, queryScopeProvider );

        // verify the result set
        assertEquals( resultSet.getAttribute( 0, "em", "name" ), this.boris.getName( ) );
        assertEquals( resultSet.getAttribute( 1, "em", "name" ), this.stefan.getName( ) );
    }

    @Test
    public void verySpecificEmployees( ) {

        String query = "select em.name from \"" + COMPANY_MM_CONTAINER_NAME + "\"#Company::Employee as em " + " where for em(age > 35 or (name like 'S*') and not(name like '*f'))";

        // execute the query
        MQLPreparedQuery preparedQuery = this.conn.getMQLProcessor( ).prepare( query );

        this.verySpecificEmployees_check( preparedQuery );
    }

    private void verySpecificEmployees_check( MQLPreparedQuery preparedQuery ) {

        QueryScopeProvider queryScopeProvider = this.conn.getMQLProcessor( ).getInclusivePartitionScopeProvider( this.globalPartitionScope );
        MQLResultSet resultSet = this.conn.getMQLProcessor( ).execute( preparedQuery, queryScopeProvider );

        // read the result
        assertEquals( resultSet.getAttribute( 0, "em", "name" ), "Jens" );
        assertEquals( resultSet.getAttribute( 1, "em", "name" ), "Rainer" );
        assertEquals( resultSet.getAttribute( 2, "em", "name" ), "Simon" );
        assertEquals( resultSet.getAttribute( 3, "em", "name" ), "Stefan" );
    }

    @Test
    public void employeesWhichAreDirectors( ) {

        // get directors
        String query = "select em.name from \"" + COMPANY_MM_CONTAINER_NAME + "\"#Company::Employee as em " + " where em.directed in (select div from Company::Division as div)";

        // execute the query
        MQLPreparedQuery preparedQuery = this.conn.getMQLProcessor( ).prepare( query );

        this.employeesWhichAreDirectors_check( preparedQuery );
    }

    @Test
    public void employeesWhichAreDirectors_2( ) {

        // get directors
        String query = "select em.name from \"" + COMPANY_MM_CONTAINER_NAME + "\"#Company::Employee as em " + " where em.directed <> null";

        // execute the query
        MQLPreparedQuery preparedQuery = this.conn.getMQLProcessor( ).prepare( query );

        this.employeesWhichAreDirectors_check( preparedQuery );
    }

    @Test
    public void employeesWhichAreDirectors_3( ) {

        // get directors
        String query = "select em.name from \"" + COMPANY_MM_CONTAINER_NAME + "\"#Company::Employee as em " + " where em.directed[Company::Directs] <> null";

        // execute the query
        MQLPreparedQuery preparedQuery = this.conn.getMQLProcessor( ).prepare( query );

        this.employeesWhichAreDirectors_check( preparedQuery );
    }

    private void employeesWhichAreDirectors_check( MQLPreparedQuery preparedQuery ) {

        QueryScopeProvider queryScopeProvider = this.conn.getMQLProcessor( ).getInclusivePartitionScopeProvider( this.globalPartitionScope );
        MQLResultSet resultSet = this.conn.getMQLProcessor( ).execute( preparedQuery, queryScopeProvider );

        // read the result
        assertEquals( resultSet.getAttribute( 0, "em", "name" ), "Rainer" );
    }

    @Test
    public void employeesWhichAreNotDirectors( ) {

        // get all non-directors
        String query = "select em.name from \"" + COMPANY_MM_CONTAINER_NAME + "\"#Company::Employee as em " + " where em.directed not in (select div from Company::Division as div)";

        // execute the query
        MQLPreparedQuery preparedQuery = this.conn.getMQLProcessor( ).prepare( query );

        this.employeesWhichAreNotDirectors_check( preparedQuery );
    }

    @Test
    public void employeesWhichAreNotDirectors_2( ) {

        // get all non-directors
        String query = "select em.name from \"" + COMPANY_MM_CONTAINER_NAME + "\"#Company::Employee as em " + " where em.directed = null";

        // execute the query
        MQLPreparedQuery preparedQuery = this.conn.getMQLProcessor( ).prepare( query );

        this.employeesWhichAreNotDirectors_check( preparedQuery );
    }

    @Test
    public void employeesWhichAreNotDirectors_3( ) {

        // get all non-directors
        String query = "select em.name from \"" + COMPANY_MM_CONTAINER_NAME + "\"#Company::Employee as em " + " where em.directed[Company::Directs] = null";

        // execute the query
        MQLPreparedQuery preparedQuery = this.conn.getMQLProcessor( ).prepare( query );

        this.employeesWhichAreNotDirectors_check( preparedQuery );
    }

    private void employeesWhichAreNotDirectors_check( MQLPreparedQuery preparedQuery ) {

        QueryScopeProvider queryScopeProvider = this.conn.getMQLProcessor( ).getInclusivePartitionScopeProvider( this.globalPartitionScope );
        MQLResultSet resultSet = this.conn.getMQLProcessor( ).execute( preparedQuery, queryScopeProvider );

        // read the result
        assertEquals( resultSet.getAttribute( 0, "em", "name" ), "Boris" );
        assertEquals( resultSet.getAttribute( 1, "em", "name" ), "Eduard" );
        assertEquals( resultSet.getAttribute( 2, "em", "name" ), "Jens" );
        assertEquals( resultSet.getAttribute( 3, "em", "name" ), "Meinolf" );
        assertEquals( resultSet.getAttribute( 4, "em", "name" ), "Simon" );
        assertEquals( resultSet.getAttribute( 5, "em", "name" ), "Stefan" );

    }

    @Test
    public void metaCheckOnEmployeeInPartition( ) {

        String query = "select cl.name from Model::Class as cl in containers{\"" + COMPANY_MM_CONTAINER_NAME + "\"} where cl.isSingleton = false where cl.name like '*Employee*'";
        MQLResultSet resultSet = this.conn.getMQLProcessor( ).execute( query );

        assertEquals( resultSet.getAttributes( 0, "cl" )[0], "Employee" );
        MofClass employee = (MofClass) resultSet.getRefObject( 0, "cl" );
        assertEquals( employee.getName( ), "Employee" );
        employee = (MofClass) ( resultSet.getRefObjects( "cl" )[0] );
        assertEquals( employee.getName( ), "Employee" );
    }

}
