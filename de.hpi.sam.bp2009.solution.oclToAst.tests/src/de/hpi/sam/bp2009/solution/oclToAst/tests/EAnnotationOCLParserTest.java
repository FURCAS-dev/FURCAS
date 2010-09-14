/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.oclToAst.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import junit.framework.TestCase;
import junit.textui.TestRunner;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.query2.EcoreHelper;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.IntegerLiteralExp;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.OperationCallExp;
import org.eclipse.ocl.ecore.delegate.DelegateEPackageAdapter;
import org.eclipse.ocl.ecore.delegate.OCLDelegateDomain;
import org.eclipse.ocl.ecore.delegate.SettingBehavior;
import org.junit.Ignore;
import org.junit.Test;

import com.sap.emf.ocl.hiddenopposites.OCLWithHiddenOpposites;
import company.CompanyFactory;
import company.CompanyPackage;
import company.Department;
import company.Division;
import company.Employee;
import company.util.CompanyValidator;

import de.hpi.sam.bp2009.solution.oclToAst.EAnnotationOCLParser;
import de.hpi.sam.bp2009.solution.oclToAst.ErrorMessage;
import de.hpi.sam.bp2009.solution.oclToAst.OclToAstFactory;
import de.hpi.sam.bp2009.solution.oclToAst.impl.EAnnotationOCLParserImpl;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>EAnnotation OCL Parser</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.solution.oclToAst.EAnnotationOCLParser#convertOclAnnotation(org.eclipse.emf.ecore.EModelElement) <em>Convert Ocl Annotation</em>}</li>
 * </ul>
 * </p>
 */
public class EAnnotationOCLParserTest extends TestCase {

    /**
     * The fixture for this EAnnotation OCL Parser test case.
     */
    protected EAnnotationOCLParser fixture = null;

    public static void main(String[] args) {
        TestRunner.run(EAnnotationOCLParserTest.class);
    }

    /**
     * Sets the fixture for this EAnnotation OCL Parser test case.
     */
    protected void setFixture(EAnnotationOCLParser fixture) {
        this.fixture = fixture;
    }

    /**
     * Returns the fixture for this EAnnotation OCL Parser test case.
     * @generated
     */
    protected EAnnotationOCLParser getFixture() {
        return fixture;
    }

    /**

     * @see junit.framework.TestCase#setUp()
     */
    @Override
    public void setUp() {
        setFixture(OclToAstFactory.eINSTANCE.createEAnnotationOCLParser());
    }

    /**
     * @see junit.framework.TestCase#tearDown()
     */
    @Override
    public void tearDown() {
        setFixture(null);
    }

    /**
     * Tests the '{@link de.hpi.sam.bp2009.solution.oclToAst.EAnnotationOCLParser#convertOclAnnotation(org.eclipse.emf.ecore.EModelElement) <em>Convert Ocl Annotation</em>}' operation.
     * @see de.hpi.sam.bp2009.solution.oclToAst.EAnnotationOCLParser#convertOclAnnotation(org.eclipse.emf.ecore.EModelElement)
     */
    public void testConvertOclAnnotation__EModelElement() {
        EClass placeC = EcoreFactory.eINSTANCE.createEClass();
        placeC.setName("Place");	
        EAttribute placeTokens = EcoreFactory.eINSTANCE.createEAttribute();
        placeTokens.setName("noTokens");
        placeTokens.setEType(EcorePackage.eINSTANCE.getEInt());
        placeC.getEStructuralFeatures().add(placeTokens);

        EAnnotation anno= EcoreFactory.eINSTANCE.createEAnnotation();
        anno.setSource(OCLDelegateDomain.OCL_DELEGATE_URI);
        anno.getDetails().put("someKey", "self.noTokens>4");
        placeC.getEAnnotations().add(anno);

        getFixture().convertOclAnnotation(placeC);        
        assertTrue(placeC.getEAnnotation(Environment.OCL_NAMESPACE_URI).getContents().get(0) instanceof Constraint);
        assertTrue(((Constraint)placeC.getEAnnotation(Environment.OCL_NAMESPACE_URI).getContents().get(0)).getSpecification().getBodyExpression() instanceof OperationCallExp);
    }

    public void testInvocationDelegate_AST_Usage(){
        Department dep = CompanyFactory.eINSTANCE.createDepartment();
        dep.setBudget(10000);
        dep.setName("Company");
        Employee boss = CompanyFactory.eINSTANCE.createEmployee();
        boss.setName("boss");
        boss.setAge(40);
        boss.setManaged(dep);
        boss.setSalary(1000);
        Employee e1 = CompanyFactory.eINSTANCE.createEmployee();
        e1.setAge(20);
        e1.setName("employee1");
        e1.setSalary(100);
        dep.setBoss(boss);
        e1.setEmployer(dep);

        getFixture().traversalConvertOclAnnotations(CompanyPackage.eINSTANCE);
        OCL ocl = OCLWithHiddenOpposites.newInstance();
        //change the annotation string value to proof usage of already parsed ast.
        Entry<String, String> value = CompanyPackage.eINSTANCE.getDepartment().getEOperations().get(0).getEAnnotation(OCLDelegateDomain.OCL_DELEGATE_URI).getDetails().get(0);
        String v = String.copyValueOf(value.getValue().toCharArray());
        value.setValue("null");
        int result = dep.calcExpenses();
        assertEquals("Expected budget: 1100, got: " + result , 1100, result);
        value.setValue(v);
        EAnnotation anno = null;
        anno = CompanyPackage.eINSTANCE.getDepartment().getEAnnotation(Environment.OCL_NAMESPACE_URI);
        assertTrue("No annotation found, annotation converting failed.", anno != null);
        OCLExpression expr = null;
        //change the annotation string value to proof usage of already parsed ast.
        Entry<String, String> val = CompanyPackage.eINSTANCE.getDepartment().getEAnnotation(OCLDelegateDomain.OCL_DELEGATE_URI).getDetails().get(0);
        String content = String.copyValueOf(val.getValue().toCharArray());
        val.setValue("null");
        expr = (OCLExpression) ((Constraint)anno.getContents().get(0)).getSpecification().getBodyExpression();
        //expected Expression: 
        // not (self.boss.oclIsTypeOf(Freelance))
        assertTrue("No parsed ast found, probably annotation converting failed.", expr != null);
        assertTrue("The found ast is not the expected one.", expr instanceof OperationCallExp);
        Object r = ocl.evaluate(dep, expr);
        assertTrue("Expected value: 'false' , got: " + r.toString(), (Boolean) r);
        val.setValue(content);
    }
    
    public void testSettingDelegate_AST_Usage(){
        CompanyFactory compFac = CompanyFactory.eINSTANCE;
        Division div = compFac.createDivision();
        div.setName("Div1");
        div.setBudget(2000);
        Department dep = compFac.createDepartment();
        dep.setName("Dep1");
        div.getDepartment().add(dep);

        //create initial expression
        EAnnotation anno = EcoreFactory.eINSTANCE.createEAnnotation();
        anno.setSource(OCLDelegateDomain.OCL_DELEGATE_URI);
        anno.setEModelElement(CompanyPackage.eINSTANCE.getDepartment_Budget());
        anno.getDetails().put(SettingBehavior.INITIAL_CONSTRAINT_KEY, "10000");

        getFixture().traversalConvertOclAnnotations(CompanyPackage.eINSTANCE);
        OCL ocl = OCLWithHiddenOpposites.newInstance();
        //change the annotation string value to proof usage of already parsed ast.
        CompanyPackage.eINSTANCE.getDepartment_Budget().getEAnnotation(OCLDelegateDomain.OCL_DELEGATE_URI).getDetails().get(0).setValue("-2");
        OCLExpression expr = SettingBehavior.INSTANCE.getFeatureBody(ocl, CompanyPackage.eINSTANCE.getDepartment_Budget());
        assertTrue("Constraint defining the initial value of department.budget could not be parsed.", expr instanceof IntegerLiteralExp);
        Object result = ocl.evaluate(dep, expr);
        assertTrue(result instanceof Integer);
        assertTrue("The parsed AST was not used.\n" +
                "Expected value: 10000, got: " + result.toString(), ((Integer)result).equals(new Integer(10000)));
        //remove annotation, that was only added for test case
        EcoreUtil.remove(CompanyPackage.eINSTANCE.getDepartment_Budget().getEAnnotation(OCLDelegateDomain.OCL_DELEGATE_URI));
    }
    
    public void testValidationDelegate_AST_Usage(){
        Department dep = CompanyFactory.eINSTANCE.createDepartment();
        Division div = CompanyFactory.eINSTANCE.createDivision();
        Employee e1 = CompanyFactory.eINSTANCE.createFreelance();
        e1.setName("e1");
        e1.setEmployer(dep);
        dep.setBoss(e1);
        div.setName("div1");
        div.getDepartment().add(dep);
        dep.setName("dep1");        
        
        getFixture().traversalConvertOclAnnotations(CompanyPackage.eINSTANCE);
        Map<Object, Object> context = new HashMap<Object, Object>();
        context.put(Environment.SELF_VARIABLE_NAME, dep);
        // the expression "not (self.boss.oclIsTypeOf(Freelance))" is validated and should be violated
        assertFalse("The NotBossFreelance constraint should be violated.", CompanyValidator.INSTANCE.validateDepartment_NotBossFreelance(dep, Diagnostician.INSTANCE.createDefaultDiagnostic(dep), context));
    }
    
    public void testHiddenOpposite_AST_Usage(){
        Department dep = CompanyFactory.eINSTANCE.createDepartment();
        Division div = CompanyFactory.eINSTANCE.createDivision();
        div.setName("div1");
        div.getDepartment().add(dep);
        dep.setName("dep1");
        
        getFixture().traversalConvertOclAnnotations(CompanyPackage.eINSTANCE);
        Map<Object, Object> context = new HashMap<Object, Object>();
        context.put(Environment.SELF_VARIABLE_NAME, CompanyPackage.eINSTANCE.getDepartment());
        // the expression "self.department2division->notEmpty()" is validated and should be valid
        BasicDiagnostic diagnostic = Diagnostician.INSTANCE.createDefaultDiagnostic(dep);
        
        DelegateEPackageAdapter adap = DelegateEPackageAdapter.getAdapter(CompanyPackage.eINSTANCE);
        OCLDelegateDomain delDom = (OCLDelegateDomain) adap.getDelegateDomain(OCLDelegateDomain.OCL_DELEGATE_URI);
        // setting new ocl instance to enable evaluating of hidden opposites
        delDom.setOCL(OCLWithHiddenOpposites.newInstance());

        assertTrue("The departmentMustHaveDivision constraint is violated.", CompanyValidator.INSTANCE.validateDepartment_departmentMustHaveDivision(dep, diagnostic, context));
        assertEquals(diagnostic.toString(), Diagnostic.OK, diagnostic.getSeverity());
    }

    /**
     * Tests the '{@link de.hpi.sam.bp2009.solution.oclToAst.EAnnotationOCLParser#convertOclAnnotation(org.eclipse.emf.ecore.EModelElement) <em>Convert Ocl Annotation</em>}' operation.
     * @see de.hpi.sam.bp2009.solution.oclToAst.EAnnotationOCLParser#convertOclAnnotation(org.eclipse.emf.ecore.EModelElement)
     */
    public void testConvertOclAnnotation__EOperation() {
        EClass aClass= EcoreFactory.eINSTANCE.createEClass();
        aClass.setName("aClass");

        EOperation operation = EcoreFactory.eINSTANCE.createEOperation();
        operation.setName("doSomething");	
        operation.setEType(EcorePackage.eINSTANCE.getEInt());

        aClass.getEOperations().add(operation);
        EAnnotation anno= EcoreFactory.eINSTANCE.createEAnnotation();
        anno.setSource(OCLDelegateDomain.OCL_DELEGATE_URI);
        anno.getDetails().put("body", "4");
        operation.getEAnnotations().add(anno);
        getFixture().convertOclAnnotation(operation);
        
        //change ocl expression string to ensure usage of already parsed ast
        anno.getDetails().get(0).setValue("null");
        EAnnotation annotation = operation.getEAnnotation(Environment.OCL_NAMESPACE_URI);
        annotation.getContents();
        OCLExpression expr = (OCLExpression) ((Constraint)operation.getEAnnotation(Environment.OCL_NAMESPACE_URI).getContents().get(0)).getSpecification().getBodyExpression();
        assertTrue(expr instanceof IntegerLiteralExp);
        OCL ocl = OCLWithHiddenOpposites.newInstance();
        Object result = ocl.evaluate(operation, expr);
        assertTrue("Expected value: '4', got: " + result.toString(), "4".equals(result.toString()));
    }
    
    @Test
    @Ignore
    public void testRunAnnotationsParserOnMdrsMetamodel() {
        String uri = "file://c:/Documents%20and%20Settings/D043530/emfmdrs-workspace/com.sap.mdrs.ecore/model/mdrs.ecore";
        final ResourceSet load_resourceSet = new ResourceSetImpl();
        /*
         * Register XML Factory implementation using DEFAULT_EXTENSION
         */
        load_resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new EcoreResourceFactoryImpl());
        /*
         * Load the resource using the URI
         */
        Resource r;
        try {
            r = load_resourceSet.getResource(URI.createURI(uri), true);
        } catch (Exception e1) {
            e1.printStackTrace();
            return;
        }
        EcoreHelper.getInstance().addResourceToDefaultIndex(r);

        try {
            r.load(null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        EAnnotationOCLParser parser = new EAnnotationOCLParserImpl();
        parser.traversalConvertOclAnnotations((EPackage) r.getContents().get(0));
        for(ErrorMessage e : parser.getAllOccurredErrorMessages()){
            if(e.getException()!=null){
                e.getException().printStackTrace();
            }
        }
        try {
            r.save(null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

} //EAnnotationOCLParserTest
