package com.sap.emf.ocl.prepared.test;

import junit.framework.TestCase;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.IntegerLiteralExp;
import org.eclipse.ocl.ecore.OCL.Helper;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.OperationCallExp;
import org.junit.Test;

import com.sap.emf.ocl.hiddenopposites.OCLWithHiddenOpposites;
import com.sap.emf.ocl.prepared.PreparedOCLExpression;

public class TestPreparedOCLExpressions extends TestCase {
    @Test
    public void testUnparameterizedExpression() throws ParserException {
        Helper helper = OCLWithHiddenOpposites.newInstance().createOCLHelper();
        EClass eClassClass = EcorePackage.eINSTANCE.getEClass();
        helper.setContext(eClassClass);
        OCLExpression e = helper.createQuery("self.eStructuralFeatures->size() > 5");
        IntegerLiteralExp ile = (IntegerLiteralExp) ((OperationCallExp) e).getArgument().get(0);
        PreparedOCLExpression prepared = new PreparedOCLExpression(e, ile);
        assertEquals(true, prepared.evaluate(eClassClass, 3));
        assertEquals(false, prepared.evaluate(eClassClass, 100));
    }
}
