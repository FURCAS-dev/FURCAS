package com.sap.emf.ocl.prepared.test;

import junit.framework.TestCase;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.BooleanLiteralExp;
import org.eclipse.ocl.ecore.IntegerLiteralExp;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCL.Helper;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.OperationCallExp;
import org.eclipse.ocl.ecore.StringLiteralExp;
import org.junit.Test;

import com.sap.emf.ocl.prepared.PreparedOCLExpression;

public class TestPreparedOCLExpressions extends TestCase {
    @Test
    public void testIntegerParameterizedExpressionMixingLiteralsWithValues() throws ParserException {
        Helper helper = OCL.newInstance().createOCLHelper();
        EClass eClassClass = EcorePackage.eINSTANCE.getEClass();
        helper.setContext(eClassClass);
        OCLExpression e = helper.createQuery("self.eStructuralFeatures->size() > 1111");
        IntegerLiteralExp ile = (IntegerLiteralExp) ((OperationCallExp) e).getArgument().get(0);
        PreparedOCLExpression prepared = new PreparedOCLExpression(e, ile);
        assertEquals(true, prepared.evaluate(eClassClass, prepared.createParameterValue(1111, 3)));
        assertEquals(false, prepared.evaluate(eClassClass, prepared.createParameterValue(1111, 100)));
    }

    @Test
    public void testIntegerParameterizedExpressionAccessByValue() throws ParserException {
        Helper helper = OCL.newInstance().createOCLHelper();
        EClass eClassClass = EcorePackage.eINSTANCE.getEClass();
        helper.setContext(eClassClass);
        OCLExpression e = helper.createQuery("self.eStructuralFeatures->size() > 1111");
        PreparedOCLExpression prepared = new PreparedOCLExpression(e, 1111);
        assertEquals(true, prepared.evaluate(eClassClass, prepared.createParameterValue(1111, 3)));
        assertEquals(false, prepared.evaluate(eClassClass, prepared.createParameterValue(1111, 100)));
    }

    @Test
    public void testIntegerParameterizedExpressionAccessByPosition() throws ParserException {
        Helper helper = OCL.newInstance().createOCLHelper();
        EClass eClassClass = EcorePackage.eINSTANCE.getEClass();
        helper.setContext(eClassClass);
        OCLExpression e = helper.createQuery("self.eStructuralFeatures->size() > 1111");
        PreparedOCLExpression prepared = new PreparedOCLExpression(e, 1111);
        assertEquals(true, prepared.evaluate(eClassClass, prepared.createPositionalParameterValue(0, 3)));
        assertEquals(false, prepared.evaluate(eClassClass, prepared.createPositionalParameterValue(0, 100)));
    }

    @Test
    public void testBooleanParameterizedExpressionWithPositionalAccess() throws ParserException {
        Helper helper = OCL.newInstance().createOCLHelper();
        EClass eClassClass = EcorePackage.eINSTANCE.getEClass();
        helper.setContext(eClassClass);
        OCLExpression e = helper.createQuery("true and self.eStructuralFeatures->size() > 3");
        BooleanLiteralExp ble = (BooleanLiteralExp) ((OperationCallExp) e).getSource();
        PreparedOCLExpression prepared = new PreparedOCLExpression(e, ble);
        assertEquals(true, prepared.evaluate(eClassClass, prepared.createPositionalParameterValue(0, true)));
        assertEquals(false, prepared.evaluate(eClassClass, prepared.createPositionalParameterValue(0, false)));
    }

    @Test
    public void testStringParameterizedExpression() throws ParserException {
        Helper helper = OCL.newInstance().createOCLHelper();
        EClass eClassClass = EcorePackage.eINSTANCE.getEClass();
        helper.setContext(eClassClass);
        OCLExpression e = helper.createQuery("self.name = '?'");
        StringLiteralExp ble = (StringLiteralExp) ((OperationCallExp) e).getArgument().get(0);
        PreparedOCLExpression prepared = new PreparedOCLExpression(e, ble);
        assertEquals(true, prepared.evaluate(eClassClass, prepared.createParameterValue("?", "EClass")));
        assertEquals(false, prepared.evaluate(eClassClass, prepared.createParameterValue("?", "SomethingElse")));
    }

}
