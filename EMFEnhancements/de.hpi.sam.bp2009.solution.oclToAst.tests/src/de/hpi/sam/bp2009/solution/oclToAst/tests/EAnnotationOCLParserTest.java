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
package de.hpi.sam.bp2009.solution.oclToAst.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.EcoreEnvironment;
import org.eclipse.ocl.ecore.IntegerLiteralExp;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.OperationCallExp;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.ecore.delegate.OCLDelegateDomain;
import org.eclipse.ocl.ecore.delegate.SettingBehavior;
import org.eclipse.ocl.ecore.delegate.ValidationBehavior;
import org.eclipse.ocl.utilities.UMLReflection;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import behavioral.actions.ActionsPackage;
import behavioral.events.EventsPackage;

import company.CompanyFactory;
import company.CompanyPackage;
import company.Department;
import company.Division;
import company.Employee;
import company.util.CompanyValidator;

import de.hpi.sam.bp2009.solution.oclToAst.EAnnotationOCLParser;
import de.hpi.sam.bp2009.solution.oclToAst.ErrorMessage;
import de.hpi.sam.bp2009.solution.oclToAst.OclToAstFactory;

/**
 * <!-- begin-user-doc --> A test case for the model object '<em><b>EAnnotation OCL Parser</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 * <li>{@link de.hpi.sam.bp2009.solution.oclToAst.EAnnotationOCLParser#convertOclAnnotation(org.eclipse.emf.ecore.EModelElement)
 * <em>Convert Ocl Annotation</em>}</li>
 * </ul>
 * </p>
 */
public class EAnnotationOCLParserTest {

    /**
     * The fixture for this EAnnotation OCL Parser test case.
     */
    protected EAnnotationOCLParser fixture = null;

    /**
     * Sets the fixture for this EAnnotation OCL Parser test case.
     */
    protected void setFixture(EAnnotationOCLParser fixture) {
        this.fixture = fixture;
    }

    /**
     * Returns the fixture for this EAnnotation OCL Parser test case.
     * 
     * @generated
     */
    protected EAnnotationOCLParser getFixture() {
        return fixture;
    }

    /**
     * @see junit.framework.TestCase#setUp()
     */
    @Before
    public void setUp() {
        setFixture(OclToAstFactory.eINSTANCE.createEAnnotationOCLParser());
    }

    /**
     * @see junit.framework.TestCase#tearDown()
     */
    @After
    public void tearDown() {
        setFixture(null);
    }

    /**
     * Tests the '
     * {@link de.hpi.sam.bp2009.solution.oclToAst.EAnnotationOCLParser#convertOclAnnotation(org.eclipse.emf.ecore.EModelElement)
     * <em>Convert Ocl Annotation</em>}' operation.
     * 
     * @see de.hpi.sam.bp2009.solution.oclToAst.EAnnotationOCLParser#convertOclAnnotation(org.eclipse.emf.ecore.EModelElement)
     */
    @Test
    public void testConvertOclAnnotation__EModelElement() {
        EClass placeC = EcoreFactory.eINSTANCE.createEClass();
        placeC.setName("Place");
        EAttribute token = EcoreFactory.eINSTANCE.createEAttribute();
        token.setName("noTokens");
        token.setEType(EcorePackage.eINSTANCE.getEInt());
        placeC.getEStructuralFeatures().add(token);

        EAnnotation anno = EcoreFactory.eINSTANCE.createEAnnotation();
        anno.setSource(OCLDelegateDomain.OCL_DELEGATE_URI);
        anno.getDetails().put("someKey", "self.noTokens>4");
        placeC.getEAnnotations().add(anno);

        getFixture().convertOclAnnotation(placeC);
        // ValidationBehavior.INSTANCE.getInvariant(placeC, "someKey", OCL.newInstance());
        assertTrue(placeC.getEAnnotation(OCLDelegateDomain.OCL_DELEGATE_URI).getContents().get(0) instanceof OCLExpression);
        assertTrue(((OCLExpression) placeC.getEAnnotation(OCLDelegateDomain.OCL_DELEGATE_URI).getContents().get(0))
                instanceof OperationCallExp);
    }

    @Test
    public void testInvocationDelegate_AST_Usage() {
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
        OCL ocl = org.eclipse.ocl.examples.impactanalyzer.util.OCL.newInstance();
        // change the annotation string value to proof usage of already parsed ast.
        Entry<String, String> value = CompanyPackage.eINSTANCE.getDepartment().getEOperations().get(0)
                .getEAnnotation(OCLDelegateDomain.OCL_DELEGATE_URI).getDetails().get(0);
        String v = String.copyValueOf(value.getValue().toCharArray());
        value.setValue(null);
        int result = dep.calcExpenses();
        assertEquals("Expected budget: 1100, got: " + result, 1100, result);
        value.setValue(v);
        EAnnotation anno = null;
        anno = CompanyPackage.eINSTANCE.getDepartment().getEAnnotation(OCLDelegateDomain.OCL_DELEGATE_URI);
        assertTrue("No annotation found, annotation converting failed.", anno != null);
        OCLExpression expr = null;
        // change the annotation string value to proof usage of already parsed ast.
        Entry<String, String> val = dep.eClass().getEAnnotation(OCLDelegateDomain.OCL_DELEGATE_URI).getDetails().get(0);
        String content = String.copyValueOf(val.getValue().toCharArray());
        val.setValue(null);
        expr = ValidationBehavior.INSTANCE.getInvariant(dep.eClass(), "NotBossFreelance", ocl);
        // expected Expression:
        // not (self.boss.oclIsTypeOf(Freelance))
        assertTrue("No parsed ast found, probably annotation converting failed.", expr != null);
        assertTrue("The found ast is not the expected one.", expr instanceof OperationCallExp);
        Object r = ocl.evaluate(dep, expr);
        assertTrue("Expected value: 'false' , got: " + r.toString(), (Boolean) r);
        val.setValue(content);
    }

    @Test
    public void testSettingDelegate_AST_Usage() {
        CompanyFactory compFac = CompanyFactory.eINSTANCE;
        Division div = compFac.createDivision();
        div.setName("Div1");
        div.setBudget(2000);
        Department dep = compFac.createDepartment();
        dep.setName("Dep1");
        div.getDepartment().add(dep);

        // create initial expression
        EAnnotation anno = EcoreFactory.eINSTANCE.createEAnnotation();
        anno.setSource(OCLDelegateDomain.OCL_DELEGATE_URI);
        anno.setEModelElement(CompanyPackage.eINSTANCE.getDepartment_Budget());
        anno.getDetails().put(SettingBehavior.INITIAL_CONSTRAINT_KEY, "10000");

        getFixture().traversalConvertOclAnnotations(CompanyPackage.eINSTANCE);
        OCL ocl = org.eclipse.ocl.examples.impactanalyzer.util.OCL.newInstance();
        // change the annotation string value to proof usage of already parsed ast.
        CompanyPackage.eINSTANCE.getDepartment_Budget().getEAnnotation(OCLDelegateDomain.OCL_DELEGATE_URI).getDetails().get(0)
                .setValue("-2");
        OCLExpression expr = SettingBehavior.INSTANCE.getFeatureBody(ocl, CompanyPackage.eINSTANCE.getDepartment_Budget());
        assertTrue("Constraint defining the initial value of department.budget could not be parsed.",
                expr instanceof IntegerLiteralExp);
        Object result = ocl.evaluate(dep, expr);
        assertTrue(result instanceof Integer);
        assertTrue("The parsed AST was not used.\n" + "Expected value: 10000, got: " + result.toString(),
                ((Integer) result).equals(new Integer(10000)));
        // remove annotation, that was only added for test case
        EcoreUtil.remove(CompanyPackage.eINSTANCE.getDepartment_Budget().getEAnnotation(OCLDelegateDomain.OCL_DELEGATE_URI));
    }

    @Test
    public void testValidationDelegate_AST_Usage() {
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
        assertFalse(
                "The NotBossFreelance constraint should be violated.",
                CompanyValidator.INSTANCE.validateDepartment_NotBossFreelance(dep,
                        Diagnostician.INSTANCE.createDefaultDiagnostic(dep), context));
    }

    @Test
    public void testHiddenOpposite_AST_Usage() {
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

        assertTrue("The departmentMustHaveDivision constraint is violated.",
                CompanyValidator.INSTANCE.validateDepartment_BossHighestSalary(dep, diagnostic, context));
        assertEquals(diagnostic.toString(), Diagnostic.OK, diagnostic.getSeverity());
    }

    /**
     * Tests the '
     * {@link de.hpi.sam.bp2009.solution.oclToAst.EAnnotationOCLParser#convertOclAnnotation(org.eclipse.emf.ecore.EModelElement)
     * <em>Convert Ocl Annotation</em>}' operation.
     * 
     * @see de.hpi.sam.bp2009.solution.oclToAst.EAnnotationOCLParser#convertOclAnnotation(org.eclipse.emf.ecore.EModelElement)
     */
    @Test
    public void testConvertOclAnnotation__EOperation() {
        EClass aClass = EcoreFactory.eINSTANCE.createEClass();
        aClass.setName("aClass");

        EOperation operation = EcoreFactory.eINSTANCE.createEOperation();
        operation.setName("doSomething");
        operation.setEType(EcorePackage.eINSTANCE.getEInt());

        aClass.getEOperations().add(operation);
        EAnnotation anno = EcoreFactory.eINSTANCE.createEAnnotation();
        anno.setSource(OCLDelegateDomain.OCL_DELEGATE_URI);
        anno.getDetails().put("body", "4");
        operation.getEAnnotations().add(anno);
        getFixture().convertOclAnnotation(operation);

        // change ocl expression string to ensure usage of already parsed ast
        anno.getDetails().get(0).setValue("null");
        EAnnotation annotation = operation.getEAnnotation(OCLDelegateDomain.OCL_DELEGATE_URI);
        annotation.getContents();
        OCLExpression expr = (OCLExpression) operation.getEAnnotation(OCLDelegateDomain.OCL_DELEGATE_URI)
                .getContents().get(0);
        assertTrue(expr instanceof IntegerLiteralExp);
        OCL ocl = org.eclipse.ocl.examples.impactanalyzer.util.OCL.newInstance();
        Object result = ocl.evaluate(operation, expr);
        assertTrue("Expected value: '4', got: " + result.toString(), "4".equals(result.toString()));
    }

    /**
     * Benchmark test comparing the time consumption using {@link EcoreEnvironment#getDefinition(Object)} to get the body condition 
     * of an operation body defined by an {@link OCLExpression} with stereotype <blockquote>body</blockquote> and if no body expression 
     * is returned, {@link EcoreEnvironment#getBodyCondition(EOperation)} is called to get the body expression instead of 
     * using {@link EcoreEnvironment#getBodyCondition(EOperation)} first. 
     */
    @Test
    @Ignore
    public void testOperationBodyResolvingPerformance() {
        EOperation op = CompanyPackage.eINSTANCE.getDepartment().getEAllOperations().get(0);
        Constraint con = null;
        Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env = OCL.newInstance().getEnvironment();
        
        //ensure all constraints got already parsed
        getFixture().traversalConvertOclAnnotations(CompanyPackage.eINSTANCE);
        for(int j = 10; j > 0; j--){
            //looking up a constraint with stereotype body in getDefinition() first and after failing 
            //usage of getBodyCondition() to resolve the operation's body expression.
            double beforeBody = System.nanoTime();
            for(int i = 20; i > 0; i--){
                con = getDefinitionOrBodyConstraint(op, env);              
            }
            double afterBody = System.nanoTime();
    
            assertNotNull(con);
            con.setStereotype(UMLReflection.DEFINITION);
    
            //looking up a constraint with stereotype definition in getDefinition() should be successful.
            double beforeDef = System.nanoTime();
            for(int i = 20; i > 0; i--){
                con = getDefinitionOrBodyConstraint(op, env);
            }
            double afterDef = System.nanoTime();
    
            assertNotNull(con);
            con.setStereotype(UMLReflection.BODY);
            System.out.println("Time using stereotype 'body'      : " + (afterBody-beforeBody) + " ns \nTime using stereotype 'definition': " + (afterDef - beforeDef) + " ns");
            System.out.println("Using getDefinition() is " + (afterBody-beforeBody)/(afterDef - beforeDef) + "times faster\n");
        }
    }

    /**
     * @param op operation the body expression should be returned for
     * @param env the OCL Environment
     * @return a {@link Constraint} representing the body of the given operation.
     */
    private Constraint getDefinitionOrBodyConstraint(
            EOperation op,
            Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env) {
        Constraint con = null;
        con = env.getDefinition(op);
        if (con == null){
            con = env.getBodyCondition(op);
        }            
        return con;
    }

    @Test
    public void testAnnotationParsingOfNgpmMetaModel() {
        EAnnotationOCLParser parser = OclToAstFactory.eINSTANCE.createEAnnotationOCLParser();
        //FIXME currently parsing of dataaccess.expressions package fails in test case, but is successful in runtime
//        parser.traversalConvertOclAnnotations(ExpressionsPackage.eINSTANCE);
        parser.traversalConvertOclAnnotations(EventsPackage.eINSTANCE);
        parser.traversalConvertOclAnnotations(ActionsPackage.eINSTANCE);
        // TODO add all packages
        printParserErrorMessages(parser);
        System.err.println("Incomplete! Currently not all packages added.");
    }

    private void printParserErrorMessages(EAnnotationOCLParser parser) {
        for (ErrorMessage e : parser.getAllOccurredErrorMessages()) {
            if (e.getException() != null) {
                e.getException().printStackTrace();
            }
        }
    }
} // EAnnotationOCLParserTest
