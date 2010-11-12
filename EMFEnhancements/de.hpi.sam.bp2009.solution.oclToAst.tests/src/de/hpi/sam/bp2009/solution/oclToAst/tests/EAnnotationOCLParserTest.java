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

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import junit.framework.TestCase;
import junit.textui.TestRunner;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.IntegerLiteralExp;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.OperationCallExp;
import org.eclipse.ocl.ecore.delegate.OCLDelegateDomain;
import org.eclipse.ocl.ecore.delegate.SettingBehavior;
import org.eclipse.ocl.ecore.delegate.ValidationBehavior;

import company.CompanyFactory;
import company.CompanyPackage;
import company.Department;
import company.Division;
import company.Employee;
import company.util.CompanyValidator;

import dataaccess.expressions.ExpressionsPackage;
import de.hpi.sam.bp2009.solution.oclToAst.EAnnotationOCLParser;
import de.hpi.sam.bp2009.solution.oclToAst.ErrorMessage;
import de.hpi.sam.bp2009.solution.oclToAst.OclToAstFactory;

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
        OCL ocl = OCL.newInstance();
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
        Entry<String, String> val = dep.eClass().getEAnnotation(OCLDelegateDomain.OCL_DELEGATE_URI).getDetails().get(0);
        String content = String.copyValueOf(val.getValue().toCharArray());
        val.setValue("null");
        expr = ValidationBehavior.INSTANCE.getInvariant(dep.eClass(), "NotBossFreelance", ocl);
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
        OCL ocl = OCL.newInstance();
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

        assertTrue("The departmentMustHaveDivision constraint is violated.", CompanyValidator.INSTANCE.validateDepartment_BossHighestSalary(dep, diagnostic, context));
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
        OCL ocl = OCL.newInstance();
        Object result = ocl.evaluate(operation, expr);
        assertTrue("Expected value: '4', got: " + result.toString(), "4".equals(result.toString()));
    }

    public void testAnnotationParsingOfNgpmMetaModel(){
        EAnnotationOCLParser parser = OclToAstFactory.eINSTANCE.createEAnnotationOCLParser();
        parser.traversalConvertOclAnnotations(ExpressionsPackage.eINSTANCE);
        printParserErrorMessages(parser);
        //TODO add all packages
        System.err.println("Incomplete! Currently not all packages added.");
    }

    private void printParserErrorMessages(EAnnotationOCLParser parser) {
        for(ErrorMessage e : parser.getAllOccurredErrorMessages()){
            if(e.getException()!=null){
                e.getException().printStackTrace();
            }
        }
    }
} //EAnnotationOCLParserTest
