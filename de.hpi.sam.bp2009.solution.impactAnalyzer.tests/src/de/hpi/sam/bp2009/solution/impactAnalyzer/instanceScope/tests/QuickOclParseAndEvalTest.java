package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.tests;

import junit.framework.TestCase;

import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCL.Helper;
import org.eclipse.ocl.ecore.OCLExpression;
import org.junit.Test;

import data.classes.ClassesFactory;
import data.classes.ClassesPackage;
import data.classes.MethodSignature;

public class QuickOclParseAndEvalTest extends TestCase {
	@Test
	public void testParseAndEvaluateOclExpression() throws ParserException {
		OCL ocl = OCL.newInstance();
		Helper oclHelper = ocl.createOCLHelper();
		oclHelper.setContext(ClassesPackage.eINSTANCE.getMethodSignature());
		OCLExpression expression = oclHelper.createQuery("self.name->isEmpty()");
		MethodSignature context = ClassesFactory.eINSTANCE.createMethodSignature();
		Object result = ocl.evaluate(context, expression);
		assertNotNull(result);
	}
}
