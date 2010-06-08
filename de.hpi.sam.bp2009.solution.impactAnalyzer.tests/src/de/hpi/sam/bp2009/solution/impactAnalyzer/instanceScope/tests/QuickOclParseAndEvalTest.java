package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.tests;

import java.util.Collection;

import junit.framework.TestCase;

import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCL.Helper;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.util.Bag;
import org.junit.Before;
import org.junit.Test;

import data.classes.ClassTypeDefinition;
import data.classes.ClassesFactory;
import data.classes.ClassesPackage;
import data.classes.MethodSignature;
import data.classes.Parameter;
import data.classes.SapClass;


public class QuickOclParseAndEvalTest extends TestCase
{
  private SapClass class1;
  private SapClass class2;
  private Parameter param;
  private ClassTypeDefinition ctd;
  private MethodSignature context;
  private OCL ocl;
  private Helper oclHelper;

  @Before
  public void setUp()
  {
    class1 = ClassesFactory.eINSTANCE.createSapClass();
    class1.setName("class1");
    class2 = ClassesFactory.eINSTANCE.createSapClass();
    class2.setName("class2");
    context = ClassesFactory.eINSTANCE.createMethodSignature();
    context.setName("context");
    param = ClassesFactory.eINSTANCE.createParameter();
    param.setName("p");
    ctd = ClassesFactory.eINSTANCE.createClassTypeDefinition();
    ctd.setClazz(class1);
    param.setOwnedTypeDefinition(ctd);
    context.setOwner(class2);
    ocl = OCL.newInstance();
    oclHelper = ocl.createOCLHelper();
    oclHelper.setContext(ClassesPackage.eINSTANCE.getParameter());
  }

  @Test
  public void testParseAndEvaluateOclExpression() throws ParserException
  {
    OCLExpression expression = oclHelper.createQuery("self.ownedTypeDefinition.oclAsType(data::classes::ClassTypeDefinition).clazz");
    Object result = ocl.evaluate(param, expression);
    assertEquals(class1, result);
  }

  public void testParseAndEvaluateOclExpressionWithPropertyCallOnNullValue() throws ParserException
  {
    param.setOwnedTypeDefinition(null);
    OCLExpression expression2 = oclHelper.createQuery("self.ownedTypeDefinition.oclAsType(data::classes::ClassTypeDefinition).clazz.oclIsInvalid()");
    Object result2 = ocl.evaluate(param, expression2);
    assertTrue((Boolean)result2);
  }

  public void testParseAndEvaluateOclExpressionWithCollectOverNullValue() throws ParserException
  {
    param.setOwnedTypeDefinition(null);
    OCLExpression expression3 = oclHelper.createQuery("self.ownedTypeDefinition.oclAsType(data::classes::ClassTypeDefinition)->collect(clazz)");
    Object result3 = ocl.evaluate(param, expression3);
    assertEquals(0, ((Collection< ? >)result3).size());
  }

  public void testParseAndEvaluateOclExpressionCollectWithBodyEvaluatingToNull() throws ParserException
  {
    param.setOwnedTypeDefinition(ctd);
    ctd.setClazz(null);
    OCLExpression expression4 = oclHelper.createQuery("self.ownedTypeDefinition.oclAsType(data::classes::ClassTypeDefinition)->collect(clazz)");
    Object result4 = ocl.evaluate(param, expression4);
    assertTrue(((Bag< ? >)result4).contains(null));
  }
}
