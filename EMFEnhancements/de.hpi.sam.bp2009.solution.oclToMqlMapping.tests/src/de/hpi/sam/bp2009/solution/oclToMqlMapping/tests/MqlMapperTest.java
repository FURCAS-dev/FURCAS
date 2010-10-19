package de.hpi.sam.bp2009.solution.oclToMqlMapping.tests;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.query.index.ui.IndexFactory;
import org.eclipse.emf.query2.EcoreHelper;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.OCL.Helper;
import org.eclipse.ocl.ecore.OCLExpression;
import org.junit.Test;

import company.CompanyFactory;
import company.CompanyPackage;
import company.Department;
import company.Division;
import company.Employee;
import company.Freelance;
import company.Student;
import company.impl.DepartmentImpl;
import company.impl.DivisionImpl;
import company.impl.EmployeeImpl;
import company.impl.FreelanceImpl;

import de.hpi.sam.bp2009.solution.oclToMqlMapping.impl.MappingOCL;


public class MqlMapperTest extends TestCase {
    protected Division div;
    protected Department dep1;
    protected Department dep2;
    protected Employee e1;
    protected Freelance e2;
    protected Employee e3;
    protected Freelance e4;
    protected Employee boss1;
    protected Employee boss2;
    protected Employee director;
    protected Employee d2;
    protected Employee secretary;
    protected Student stud1;
    protected Student stud2;
    protected CompanyPackage comp;
    protected DivisionImpl aDivision;
    protected DepartmentImpl aDepartment;
    protected Set<DepartmentImpl> allDepartments = new HashSet<DepartmentImpl>();
    protected Set<EmployeeImpl> allEmployees = new HashSet<EmployeeImpl>();
    protected EmployeeImpl aEmployee;
    protected Set<FreelanceImpl> allFreelances = new HashSet<FreelanceImpl>();
    protected FreelanceImpl aFreelance;
    protected int curDepartmentID;
    protected int curImployeeID;
    protected MappingOCL ocl;
    private static String expressionStringCollectAttribute;
    private static String expressionStringCollectNavigation;
    private static String expressionStringSelect1;
  
    private static String expressionStringSelect3;
    private static String expressionStringSelect4;
    private static String expressionStringSelect5;

    protected OCLExpression oclexpressionCompleteNav;
    protected OCLExpression oclexpressionCompleteAtt;
    protected OCLExpression oclexpressionCompleteSel1;
  
    protected OCLExpression oclexpressionCompleteSel3;
    protected OCLExpression oclexpressionCompleteSel4;
    protected OCLExpression oclexpressionCompleteSel5;
    protected Object statementAtt;
    protected Object statementNav;
    protected Object statementSel;
    private Division div2;
    





    @Override
    protected void setUp() throws Exception {
        super.setUp();

        createInstances();
        createInstances(1, 1, 1);    
        expressionStringSelect1 = "Employee.allInstances()->select(e:Employee|e.age = 55)";
      
        expressionStringSelect3 = "Employee.allInstances()->select(e:Employee|e.secretary.age = 55)";//navigation

        expressionStringSelect4 = "Employee.allInstances()->select(e:Employee|e.name = e.secretary.name)";//comparison with navigation

        expressionStringSelect5 = "Employee.allInstances()->select(e:Employee|e.age = e.salary)";//comp without navigation

        expressionStringCollectAttribute = "Employee.allInstances()->collect(p:Employee|p.age)";
        expressionStringCollectNavigation ="Employee.allInstances()->collect(p:Employee|p.directed)";

        ocl =MappingOCL.newInstance();
        Helper oclhelper= ocl.createOCLHelper();

        
        ResourceSetImpl resourceset = new ResourceSetImpl();
        Resource r = this.comp.eResource();
        resourceset.getResources().add(r);
      

        EcoreHelper.getInstance().addResourceToDefaultIndex(IndexFactory.getInstance(), r);
        TreeIterator<EObject> it = r.getAllContents();
        Map<EClass, Set<EObject>> map = new HashMap<EClass, Set<EObject>>();

        while(it.hasNext()){
            EObject element =it.next();

            if(map.get(element.eClass())==null)
                map.put(element.eClass(), new HashSet<EObject>());
            map.get(element.eClass()).add(element);

        }
        ocl.setExtentMap(map);
        oclhelper.setContext(CompanyPackage.eINSTANCE.getEmployee());

        try {
            oclexpressionCompleteAtt = oclhelper.createQuery(expressionStringCollectAttribute);
            oclexpressionCompleteNav =oclhelper.createQuery(expressionStringCollectNavigation);
            oclexpressionCompleteSel1 = oclhelper.createQuery(expressionStringSelect1);
            //            oclexpressionCompleteSel2 = oclhelper.createQuery(expressionStringSelect2);
            oclexpressionCompleteSel3 = oclhelper.createQuery(expressionStringSelect3);
            oclexpressionCompleteSel4 = oclhelper.createQuery(expressionStringSelect4);
            oclexpressionCompleteSel5 = oclhelper.createQuery(expressionStringSelect5);



        } catch (ParserException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
     
    }


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
    private EmployeeImpl createEmployee() {

        EmployeeImpl e = (EmployeeImpl) CompanyFactory.eINSTANCE.createEmployee();
        e.setName("empl" + this.curImployeeID);
        e.setAge(42);
        e.setSalary(55);
        this.curImployeeID++;
        this.allEmployees.add(e);
        if (this.comp.eResource() != null) {
            this.comp.eResource().getContents().add(e);
        }
        return e;
    }
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
    private void createInstances() {

        this.div = CompanyFactory.eINSTANCE.createDivision();
        this.div.setBudget(1234567);
        this.div.setName("Div1");
        
        this.div2 = CompanyFactory.eINSTANCE.createDivision();
        this.div2.setBudget(12345678);
        this.div2.setName("Div2");

        this.comp = company.CompanyPackage.eINSTANCE;
        this.comp.eResource().getContents().add(this.div);
        this.comp.eResource().getContents().add(this.div2);

        this.director = CompanyFactory.eINSTANCE.createEmployee();
        this.director.setAge(42);
        this.director.setName("Director");
        this.director.setDirected(this.div);
        this.director.setSalary(1234);
        this.div.setDirector(this.director);
        
        this.d2 = CompanyFactory.eINSTANCE.createEmployee();
        this.d2.setAge(100);
        this.d2.setName("Director2");
        this.d2.setDirected(this.div2);
        this.d2.setSalary(1000);
        this.div2.setDirector(this.d2);

        this.secretary = CompanyFactory.eINSTANCE.createEmployee();
        this.secretary.setAge(55);
        this.secretary.setName("Secretary");
        this.secretary.setSalary(55);
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

        this.boss1 = CompanyFactory.eINSTANCE.createEmployee();
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
        this.boss2.setAge(43);
        this.boss2.setName("boss2");
        this.boss2.setEmployer(this.dep2);
        this.boss2.setManaged(this.dep2);
        this.boss2.setSalary(1234);

        this.dep2.setBoss(this.boss2);

        this.stud2 = CompanyFactory.eINSTANCE.createStudent();
        this.stud2.setAge(23);
        this.stud2.setName("stud2");
        this.stud2.setSalary(234);
        this.stud2.setEmployer(this.dep2);
        this.e3.setIntern(this.stud2);

        this.div.getDepartment().add(this.dep1);
        this.div.getDepartment().add(this.dep2);
        this.div2.getDepartment().add(this.dep1);
        this.div2.getDepartment().add(this.dep2);

    }
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        this.dep1=null;
        this.dep2=null;
        this.e1=null;
        this.e2=null;
        this.e3=null;
        this.e4=null;
        this.boss1=null;
        this.boss2=null;
        this.director=null;
        this.d2=null;
        this.secretary=null;
        this.stud1=null;
        this.stud2=null;
        this.comp.eResource().getContents().remove(2);
        this.comp.eResource().getContents().remove(1);
     
     
        this.div=null;
        this.div2=null;
        this.aDivision= null;
        this.aDepartment=null;
        this.allDepartments = new HashSet<DepartmentImpl>();
        this.allEmployees = new HashSet<EmployeeImpl>();
        this.aEmployee=null;
        this.allFreelances = new HashSet<FreelanceImpl>();
        this.aFreelance=null;
        this.curDepartmentID=0;
        this.curImployeeID=0;
        this.ocl=null;
        expressionStringCollectAttribute=null;
        expressionStringCollectNavigation=null;
        expressionStringSelect1=null;

        expressionStringSelect3=null;
        expressionStringSelect4=null;
        expressionStringSelect5=null;

        this.oclexpressionCompleteNav=null;
        this.oclexpressionCompleteAtt=null;
        this.oclexpressionCompleteSel1=null;

        this.oclexpressionCompleteSel3=null;
        this.oclexpressionCompleteSel4=null;
        this.oclexpressionCompleteSel5=null;
        this.statementAtt=null;
        this.statementNav=null;
        this.statementSel=null;

    }
  
    @Test
    public void testVisitExpressionCompleteAtt() {
        String att= "{100=1, 55=1, 42=3, 43=2}";
        statementAtt = ocl.evaluate(CompanyPackage.eINSTANCE.getEmployee(), oclexpressionCompleteAtt);

        assertEquals(att, statementAtt.toString());
    }
    
    @Test
    public void testVisitExpressionCompleteNav() {
        String regex="company\\.impl\\.DivisionImpl@([0-9A-Za-z]+) \\(name: Div1, budget: 1234567\\)=1";
        String regex2="company\\.impl\\.DivisionImpl@([0-9A-Za-z]+) \\(name: Div2, budget: 12345678\\)=1";
        Pattern pattern=Pattern.compile(regex);
        Pattern pattern2=Pattern.compile(regex2);
        statementNav = ocl.evaluate(CompanyPackage.eINSTANCE.getEmployee(), oclexpressionCompleteNav);
        Matcher match=pattern.matcher(statementNav.toString());
        Matcher match2=pattern2.matcher(statementNav.toString());
        boolean matches1= match.find();
        boolean matches2=match2.find();
        boolean matches= matches1 && matches2;
        assertTrue(matches);
    }
    @Test
    public void testVisitExpressionSelect1() {
        String sel= "\\[company\\.impl\\.EmployeeImpl@([0-9A-Za-z]+) \\(name: Secretary, age: 55, salary: 55\\)\\]";

        Pattern pattern=Pattern.compile(sel);
        statementSel = ocl.evaluate(CompanyPackage.eINSTANCE.getEmployee(), oclexpressionCompleteSel1);
        System.out.println(statementSel.toString());
        Matcher match=pattern.matcher("test_sel1"+statementSel.toString());
        boolean matches= match.find();
        assertTrue(matches);
    }

    @Test
    public void testVisitExpressionSelect3() {

        String sel="\\[company\\.impl\\.EmployeeImpl@([0-9A-Za-z]+) \\(name: Director, age: 42, salary: 1234\\)\\]";
        Pattern pattern=Pattern.compile(sel);
        statementSel = ocl.evaluate(CompanyPackage.eINSTANCE.getEmployee(), oclexpressionCompleteSel3);
        System.out.println(statementSel.toString());
        Matcher match=pattern.matcher("test_sel3"+statementSel.toString());
        boolean matches= match.find();
        assertTrue(matches);
    }
    @Test
    public void testVisitExpressionSelect4() {

        statementSel = ocl.evaluate(CompanyPackage.eINSTANCE.getEmployee(), oclexpressionCompleteSel4);
        String sel="[]";
        System.out.println("test_sel4"+statementSel.toString());
        assertEquals(sel, statementSel.toString());
    }

    @Test
    public void testVisitExpressionSelect5() {
        String sel= "\\[company\\.impl\\.EmployeeImpl@([0-9A-Za-z]+) \\(name: Secretary, age: 55, salary: 55\\)\\]";
        Pattern pattern=Pattern.compile(sel);
        statementSel = ocl.evaluate(CompanyPackage.eINSTANCE.getEmployee(), oclexpressionCompleteSel5);
        System.out.println("test_sel5"+statementSel.toString());

        Matcher match=pattern.matcher(statementSel.toString());
        boolean matches= match.find();
        assertTrue(matches);
    }
   
}

