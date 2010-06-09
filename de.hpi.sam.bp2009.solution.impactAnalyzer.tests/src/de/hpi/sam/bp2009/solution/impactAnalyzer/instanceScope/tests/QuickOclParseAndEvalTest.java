package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.tests;

import java.util.Collection;

import junit.framework.TestCase;

import org.eclipse.emf.ecore.EObject;
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
  private MethodSignature signature;
  private OCL ocl;
  private Helper oclHelper;

  @Before
  public void setUp()
  {
    class1 = ClassesFactory.eINSTANCE.createSapClass();
    class1.setName("class1");
    class2 = ClassesFactory.eINSTANCE.createSapClass();
    class2.setName("class2");
    signature = ClassesFactory.eINSTANCE.createMethodSignature();
    signature.setName("context");
    param = ClassesFactory.eINSTANCE.createParameter();
    param.setName("p");
    ctd = ClassesFactory.eINSTANCE.createClassTypeDefinition();
    ctd.setClazz(class1);
    param.setOwnedTypeDefinition(ctd);
    signature.setOwner(class2);
    ocl = OCL.newInstance();
    oclHelper = ocl.createOCLHelper();
    oclHelper.setContext(ClassesPackage.eINSTANCE.getParameter());
  }

  /**
   * Ensures that an OclInvalid value does not pass a select filter, yet the select iterator
   * returns a valid result
   */
  @Test
  public void testParseAndEvaluateOclExpressionWithCollectOfNullValue() throws ParserException
  {
    OCLExpression expression5 = oclHelper.createQuery("Set{1, 2}->collect(null)");
    Object result5 = ocl.evaluate(param, expression5);
    assertEquals(2, ((Collection<?>) result5).size());
    assertTrue(((Collection<?>) result5).contains(null));
  }

  /**
   * Ensures that an OclInvalid value does not pass a select filter, yet the select iterator
   * returns a valid result
   */
  @Test
  public void testParseAndEvaluateOclExpressionWithCollectOverOclInvalid() throws ParserException
  {
    OCLExpression expression5 = oclHelper.createQuery("Set{self, invalid}->collect(i | i)");
    Object result5 = ocl.evaluate(param, expression5);
    assertTrue(((EObject) result5).eClass().getName().equals("OclInvalid_Class"));
  }

  /**
   * Ensures that an OclInvalid value does not pass a select filter, yet the select iterator
   * returns a valid result
   */
  @Test
  public void testParseAndEvaluateOclExpressionWithSelectOverOclInvalid() throws ParserException
  {
    OCLExpression expression5 = oclHelper.createQuery("Set{self, invalid}->select(i | i.name = 'p')");
    Object result5 = ocl.evaluate(param, expression5);
    assertEquals(1, ((Collection<?>) result5).size());
  }

  @Test
  public void testParseAndEvaluateOclExpression() throws ParserException
  {
    OCLExpression expression = oclHelper.createQuery("self.ownedTypeDefinition.oclAsType(data::classes::ClassTypeDefinition).clazz");
    Object result = ocl.evaluate(param, expression);
    assertEquals(class1, result);
  }

  @Test
  public void testParseAndEvaluateOclExpressionWithPropertyCallOnNullValue() throws ParserException
  {
    param.setOwnedTypeDefinition(null);
    OCLExpression expression2 = oclHelper.createQuery("self.ownedTypeDefinition.oclAsType(data::classes::ClassTypeDefinition).clazz.oclIsInvalid()");
    Object result2 = ocl.evaluate(param, expression2);
    assertTrue((Boolean)result2);
  }

  @Test
  public void testParseAndEvaluateOclExpressionWithCollectOverNullValue() throws ParserException
  {
    param.setOwnedTypeDefinition(null);
    OCLExpression expression3 = oclHelper.createQuery("self.ownedTypeDefinition.oclAsType(data::classes::ClassTypeDefinition)->collect(clazz)");
    Object result3 = ocl.evaluate(param, expression3);
    assertEquals(0, ((Collection< ? >)result3).size());
  }

  @Test
  public void testParseAndEvaluateOclExpressionCollectWithBodyEvaluatingToNull() throws ParserException
  {
    param.setOwnedTypeDefinition(ctd);
    ctd.setClazz(null);
    OCLExpression expression4 = oclHelper.createQuery("self.ownedTypeDefinition.oclAsType(data::classes::ClassTypeDefinition)->collect(clazz)");
    Object result4 = ocl.evaluate(param, expression4);
    assertTrue(((Bag< ? >)result4).contains(null));
  }

  @Test
  public void testParseAndEvaluateOclExpressionWithImplicitCollectOverOperationCallResult() throws ParserException
  {
    OCLExpression expression4 = oclHelper.createQuery("self.ownedTypeDefinition.oclAsType(data::classes::ClassTypeDefinition).clazz.getAssociationEnds().otherEnd()");
    Object result4 = ocl.evaluate(param, expression4);
    assertTrue(((EObject) result4).eClass().getName().equals("OclInvalid_Class"));
  }

  @Test
  public void testParseAndEvaluateOclExpressionWithDelegatesToSimulationt() throws ParserException
  {
    OCLExpression expression4 = oclHelper.createQuery("self.ownedTypeDefinition.oclAsType(data::classes::ClassTypeDefinition).clazz.getAssociationEnds().otherEnd()->select(delegation->notEmpty()).type.clazz->reject(c|c=self)->asSet()");
    Object result4 = ocl.evaluate(param, expression4);
    assertTrue(((EObject) result4).eClass().getName().equals("OclInvalid_Class"));
  }

  @Test
  public void testParseAndEvaluateOclExpressionWithImplicitSetLiteral() throws ParserException
  {
    OCLExpression expression4 = oclHelper.createQuery("self.ownedTypeDefinition->isEmpty()");
    Object result4 = ocl.evaluate(param, expression4);
    assertFalse((Boolean) result4);
  }

  @Test
  public void testParseAndEvaluateOclExpressionWithImplicitSetLiteralCheckingForIsEmpty() throws ParserException
  {
    param.setOwnedTypeDefinition(null);
    OCLExpression expression5 = oclHelper.createQuery("self.ownedTypeDefinition->isEmpty()");
    Object result5 = ocl.evaluate(param, expression5);
    assertTrue((Boolean) result5);
  }

  @Test
  public void testParseAndEvaluateOclExpressionWithNullInSetLiteral() throws ParserException
  {
    param.setOwnedTypeDefinition(null);
    OCLExpression expression5 = oclHelper.createQuery("Set{null}->isEmpty()");
    Object result5 = ocl.evaluate(param, expression5);
    assertTrue((Boolean) result5);
  }

  @Test
  public void testParseAndEvaluateOclExpressionWithEmptySetLiteralIncludingNull() throws ParserException
  {
    OCLExpression expression4 = oclHelper.createQuery("Set{}->including(null)->isEmpty()");
    Object result4 = ocl.evaluate(param, expression4);
    assertFalse((Boolean) result4);
  }

}
