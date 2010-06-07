package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.tests;

import junit.framework.TestCase;

import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCL.Helper;
import org.eclipse.ocl.ecore.OCLExpression;
import org.junit.Test;

import data.classes.ClassTypeDefinition;
import data.classes.ClassesFactory;
import data.classes.ClassesPackage;
import data.classes.MethodSignature;
import data.classes.Parameter;
import data.classes.SapClass;

public class QuickOclParseAndEvalTest extends TestCase {
	@Test
	public void testParseAndEvaluateOclExpression() throws ParserException {
                SapClass class1 = ClassesFactory.eINSTANCE.createSapClass();
                class1.setName("class1");
                SapClass class2 = ClassesFactory.eINSTANCE.createSapClass();
                class2.setName("class2");
		MethodSignature context = ClassesFactory.eINSTANCE.createMethodSignature();
		context.setName("context");
		Parameter param = ClassesFactory.eINSTANCE.createParameter();
		param.setName("p");
		ClassTypeDefinition ctd = ClassesFactory.eINSTANCE.createClassTypeDefinition();
		ctd.setClazz(class1);
		param.setOwnedTypeDefinition(ctd);
		context.setOwner(class2);
		
                OCL ocl = OCL.newInstance();
                Helper oclHelper = ocl.createOCLHelper();
                oclHelper.setContext(ClassesPackage.eINSTANCE.getParameter());
                OCLExpression expression = oclHelper.createQuery("self.ownedTypeDefinition.clazz");
		Object result = ocl.evaluate(param, expression);
		assertNotNull(result);
	}
}
