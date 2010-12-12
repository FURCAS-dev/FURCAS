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
package org.eclipse.ocl.examples.impactanalyzer.tests.instanceScope;

import java.util.Collection;

import junit.framework.TestCase;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.DynamicEObjectImpl;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.SemanticException;
import org.eclipse.ocl.ecore.LoopExp;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCL.Helper;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.util.Bag;
import org.junit.Before;
import org.junit.Test;

import company.CompanyFactory;
import company.CompanyPackage;

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
    ocl = org.eclipse.ocl.examples.impactanalyzer.util.OCL.newInstance();
    oclHelper = ocl.createOCLHelper();
    oclHelper.setContext(ClassesPackage.eINSTANCE.getParameter());
  }

  /**
   * Check if a type name parses as a type literal
   */
  @Test
  public void testParseAndEvaluateOclExpressionWithTypeLiteral() throws ParserException {
      oclHelper.setContext(CompanyPackage.eINSTANCE.getDepartment());
      OCLExpression expression4 = oclHelper.createQuery("company::Division");
      Object result4 = ocl.evaluate(null, expression4);
      assertTrue(result4 instanceof EClass);
      assertEquals(CompanyPackage.eINSTANCE.getDivision(), result4);
      OCLExpression expression5 = oclHelper.createQuery("Division");
      Object result5 = ocl.evaluate(null, expression5);
      assertTrue(result5 instanceof EClass);
      assertEquals(CompanyPackage.eINSTANCE.getDivision(), result5);
  }

  /**
   * Check what happens when ->at(...) argument is out of bounds
   */
  @Test
  public void testParseAndEvaluateOclExpressionWithOutOfBoundsAtArgument() throws ParserException {
      oclHelper.setContext(CompanyPackage.eINSTANCE.getDepartment());
      OCLExpression expression4 = oclHelper.createQuery("Sequence{1..2}->at(3)");
      Object result4 = ocl.evaluate(CompanyFactory.eINSTANCE.createDepartment(), expression4);
      assertTrue(result4 instanceof DynamicEObjectImpl);
      assertEquals("OclInvalid_Class", ((DynamicEObjectImpl) result4).eClass().getName());
  }

  /**
   * Check what happens when last value of a range is invalid instead of an Integer. Interestingly, this aborts the whole
   * evaluation and even "bypasses" a trailing oclIsInvalid().
   */
  @Test
  public void testParseAndEvaluateOclExpressionWithInvalidAsLastPartOfRange() throws ParserException {
      oclHelper.setContext(CompanyPackage.eINSTANCE.getDepartment());
      OCLExpression expression4 = oclHelper.createQuery("(Sequence{1..(self.parentDepartment.subDepartment->size())}->select(i | i>0)).oclIsInvalid()");
      Object result4 = ocl.evaluate(CompanyFactory.eINSTANCE.createDepartment(), expression4);
      assertTrue(result4 instanceof DynamicEObjectImpl);
      assertEquals("OclInvalid_Class", ((DynamicEObjectImpl) result4).eClass().getName());
  }

  /**
   * Check if invalid can be passed into an operation as argument
   */
  @Test
  public void testParseAndEvaluateOclExpressionWithMixOfPrimitiveAndObjectTypesInCollectionLiteral() throws ParserException {
      OCLExpression expression4 = oclHelper.createQuery("Set{1, 2, self}->select(i | i.oclIsKindOf(Integer))");
      Object result4 = ocl.evaluate(CompanyFactory.eINSTANCE.createDepartment(), expression4);
      assertTrue(result4 instanceof Collection);
      assertTrue(((Collection<?>) result4).contains(1));
      assertTrue(((Collection<?>) result4).contains(2));
  }

  /**
   * Check if invalid can be passed into an operation as argument
   */
  @Test
  public void testParseAndEvaluateOclExpressionWithInvalidInOperationArgument() throws ParserException {
      EClass cl = CompanyPackage.eINSTANCE.getDepartment();
      EOperation op = EcoreFactory.eINSTANCE.createEOperation();
		try {
			op.setName("myOp");
			op.setEType(EcorePackage.eINSTANCE.getEBoolean());
			EParameter param = EcoreFactory.eINSTANCE.createEParameter();
			param.setName("humba");
			param.setEType(org.eclipse.emf.ecore.EcorePackage.eINSTANCE
					.getEClassifier());
			op.getEParameters().add(param);
			cl.getEOperations().add(op);
			oclHelper.setOperationContext(cl, op);
			oclHelper.createBodyCondition("humba.oclIsInvalid()");
			oclHelper.setContext(cl);
			OCLExpression expression4 = oclHelper
					.createQuery("self.myOp(invalid)");
			Object result4 = ocl.evaluate(
					CompanyFactory.eINSTANCE.createDepartment(), expression4);
			assertEquals(true, result4);
		} finally {
    	  cl.getEOperations().remove(op);
      }
  }

    /**
     * Ensure that "or" and "and" do shortcut evaluation for invalid arguments
     */
    @Test
    public void testParseAndEvaluateOclExpressionWithInvalidInBooleanShortcutEval() throws ParserException {
        OCLExpression expression4 = oclHelper.createQuery("false and invalid");
        Object result4 = ocl.evaluate(null, expression4);
        assertEquals(false, result4);
        OCLExpression expression5 = oclHelper.createQuery("true or invalid");
        Object result5 = ocl.evaluate(null, expression5);
        assertEquals(true, result5);
        OCLExpression expression6 = oclHelper.createQuery("(invalid or true).oclIsInvalid()");
        Object result6 = ocl.evaluate(null, expression6);
        assertEquals(true, result6);
        OCLExpression expression7 = oclHelper.createQuery("(invalid and false).oclIsInvalid()");
        Object result7 = ocl.evaluate(null, expression7);
        assertEquals(true, result7);
    }

  /**
   * Testing if a let-expression evaluates to OclInvalid if the initExpression evaluates to OclInvalid although
   * the variable is not used in the "in" expression.
   */
  @Test
  public void testParseAndEvaluateOclExpressionWithInvalidLetInitExpression() throws ParserException {
      OCLExpression expression4 = oclHelper
              .createQuery("let x:Integer=self.name.size() in 1+2");
      Object result4 = ocl.evaluate(null, expression4);
      assertEquals(3, result4);
  }

    /**
     * Testing if two iterator variables appear as such
     */
    @Test
    public void testParseAndEvaluateOclExpressionForAllWithTwoIterators() throws ParserException {
        OCLExpression expression4 = oclHelper
                .createQuery("Set{1, 2, 3}->forAll(i, j | i+j <> 7)");
        assertEquals(2, ((LoopExp) expression4).getIterator().size());
        Object result4 = ocl.evaluate(param, expression4);
        assertEquals(true, result4);
    }

    /**
     * Testing if an iterate's accumulator expression is really evaluated even when the iterate is applied to an empty collection
     */
    @Test
    public void testParseAndEvaluateOclExpressionAccumulatorForIterateOnEmptyCollection() throws ParserException {
        OCLExpression expression4 = oclHelper
                .createQuery("let s:Set(Integer)=Set{} in s->iterate(i:Integer; acc:Integer=1 | acc+1)");
        Object result4 = ocl.evaluate(param, expression4);
        assertEquals(1, result4);
    }

  /**
   * Testing if shadowing a variable by an iterator leads to incorrect results because the shadowed
   * variable is overwritten by the iterator values
   */
  @Test
  public void testParseAndEvaluateOclExpressionIteratorShadowingLetVariable() throws ParserException
  {
    param.setOwnedTypeDefinition(ctd);
    ctd.setClazz(null);
    try {
        OCLExpression expression4 = oclHelper.createQuery("let i:Integer=1 in if self.ownedTypeDefinition->select(i|i.oclAsType(ClassTypeDefinition).clazz->notEmpty())->isEmpty() then i else 0 endif");
        Object result4 = ocl.evaluate(param, expression4);
        assertEquals(1, result4);
    } catch (SemanticException e) {
        // it's ok if the OCL implementation doesn't accept shadowing:
        assertEquals("Variable name already used: (i)", e.getMessage());
    }
  }

  /**
   * Ensures that an OclInvalid value does not pass a select filter, yet the select iterator
   * returns a valid result
   */
  @Test
  public void testParseAndEvaluateOclExpressionWithTupleWithNull() throws ParserException
  {
    param.setName(null);
    OCLExpression expression5 = oclHelper.createQuery("Tuple{c:Tuple(d:String)=Tuple{d=self.name}}.c.d");
    Object result5 = ocl.evaluate(param, expression5);
    assertNull(result5);
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
  public void testParseAndEvaluateOclExpressionWithIncludingNullInSequence() throws ParserException
  {
    OCLExpression expression5 = oclHelper.createQuery("Sequence{1}->including(null)");
    Object result5 = ocl.evaluate(param, expression5);
    assertEquals(2, ((Collection<?>) result5).size());
    assertTrue(((Collection<?>) result5).contains(null));
  }

  /**
   * Ensures that an OclInvalid value does not pass a select filter, yet the select iterator
   * returns a valid result
   */
  @Test
  public void testParseAndEvaluateOclExpressionWithSizeOverSequenceContainingNull() throws ParserException
  {
    OCLExpression expression5 = oclHelper.createQuery("Sequence{1}->including(null)->size()");
    Object result5 = ocl.evaluate(param, expression5);
    assertEquals(2, result5);
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
    assertTrue(((Collection<?>) result4).isEmpty());
  }

  @Test
  public void testParseAndEvaluateOclExpressionWithDelegatesToSimulation() throws ParserException
  {
    OCLExpression expression4 = oclHelper.createQuery("self.ownedTypeDefinition.oclAsType(data::classes::ClassTypeDefinition).clazz.getAssociationEnds().otherEnd()->select(delegation->notEmpty()).type.clazz->reject(c|c=self)->asSet()");
    Object result4 = ocl.evaluate(param, expression4);
    assertTrue(((Collection<?>) result4).isEmpty());
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
