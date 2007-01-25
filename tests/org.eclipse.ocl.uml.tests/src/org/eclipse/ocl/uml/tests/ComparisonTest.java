/**
 * <copyright>
 *
 * Copyright (c) 2006 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: ComparisonTest.java,v 1.1 2007/01/25 18:41:54 cdamus Exp $
 */

package org.eclipse.ocl.uml.tests;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.types.CollectionType;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.LiteralUnlimitedNatural;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * Tests for comparison (&lt;, &lt;=, &gt;=, &gt;) expressions.
 *
 * @author Christian W. Damus (cdamus)
 */
public class ComparisonTest
	extends AbstractTestSuite {

	private Package pkg;
	private Class thingType;
	private Property values;
	private DataType valueType;
	private Class numeroType;
	private Property numeros;
	
	private EPackage epkg;
	private EFactory efactory;
	private EClass ethingType;
	private EAttribute evalues;
	private EDataType evalueType;
	private EClass enumeroType;
	private EReference enumeros;
	
	private EObject thing;
	
	public ComparisonTest(String name) {
		super(name);
	}
	
	public static Test suite() {
		return new TestSuite(ComparisonTest.class, "Comparison/Ordering Tests"); //$NON-NLS-1$
	}
	
	/**
	 * Tests the &lt; operator.
	 */
	public void test_lessThan() {
		helper.setContext(thingType);
		
		try {
			// primitives
			assertTrue(check(helper, thing, "1 < 2")); //$NON-NLS-1$
			assertFalse(check(helper, thing, "21 < 2")); //$NON-NLS-1$
			assertTrue(check(helper, thing, "1 < 2.0")); //$NON-NLS-1$
			assertFalse(check(helper, thing, "21 < 2.0")); //$NON-NLS-1$
			assertTrue(check(helper, thing, "1.0 < 2")); //$NON-NLS-1$
			assertFalse(check(helper, thing, "21.0 < 2")); //$NON-NLS-1$
			assertTrue(check(helper, thing, "1.0 < 2.0")); //$NON-NLS-1$
			assertFalse(check(helper, thing, "21.0 < 2.0")); //$NON-NLS-1$
			assertTrue(check(helper, thing, "'a' < 'b'")); //$NON-NLS-1$
			assertFalse(check(helper, thing, "'ba' < 'b'")); //$NON-NLS-1$

			@SuppressWarnings("unchecked")
			List<Value> valuesList = (List<Value>) thing.eGet(evalues);
			
			valuesList.add(new Value("a")); //$NON-NLS-1$
			valuesList.add(new Value("b")); //$NON-NLS-1$
			
			assertTrue(check(helper, thing,
				"values->at(1) < values->at(2)")); //$NON-NLS-1$

			assertFalse(check(helper, thing,
				"values->at(2) < values->at(1)")); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests the &lt;= operator.
	 */
	public void test_lessThanOrEqual() {
		helper.setContext(thingType);
		
		try {
			// primitives
			assertTrue(check(helper, thing, "1 <= 2")); //$NON-NLS-1$
			assertTrue(check(helper, thing, "1 <= 1")); //$NON-NLS-1$
			assertFalse(check(helper, thing, "21 <= 2")); //$NON-NLS-1$
			assertTrue(check(helper, thing, "1 <= 2.0")); //$NON-NLS-1$
			assertTrue(check(helper, thing, "1 <= 1.0")); //$NON-NLS-1$
			assertFalse(check(helper, thing, "21 <= 2.0")); //$NON-NLS-1$
			assertTrue(check(helper, thing, "1.0 <= 2")); //$NON-NLS-1$
			assertTrue(check(helper, thing, "1.0 <= 1")); //$NON-NLS-1$
			assertFalse(check(helper, thing, "21.0 <= 2")); //$NON-NLS-1$
			assertTrue(check(helper, thing, "1.0 <= 2.0")); //$NON-NLS-1$
			assertTrue(check(helper, thing, "1.0 <= 1.0")); //$NON-NLS-1$
			assertFalse(check(helper, thing, "21.0 <= 2.0")); //$NON-NLS-1$
			assertTrue(check(helper, thing, "'a' <= 'b'")); //$NON-NLS-1$
			assertTrue(check(helper, thing, "'a' <= 'a'")); //$NON-NLS-1$
			assertFalse(check(helper, thing, "'ba' <= 'b'")); //$NON-NLS-1$

			@SuppressWarnings("unchecked")
			List<Value> valuesList = (List<Value>) thing.eGet(evalues);
			
			valuesList.add(new Value("a")); //$NON-NLS-1$
			valuesList.add(new Value("b")); //$NON-NLS-1$
			
			assertTrue(check(helper, thing,
				"values->at(1) <= values->at(2)")); //$NON-NLS-1$

			assertTrue(check(helper, thing,
				"values->at(1) <= values->at(1)")); //$NON-NLS-1$

			assertFalse(check(helper, thing,
				"values->at(2) <= values->at(1)")); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests the &gt; operator.
	 */
	public void test_greaterThan() {
		helper.setContext(thingType);
		
		try {
			// primitives
			assertTrue(check(helper, thing, "2 > 1")); //$NON-NLS-1$
			assertFalse(check(helper, thing, "2 > 21")); //$NON-NLS-1$
			assertTrue(check(helper, thing, "2 > 1.0")); //$NON-NLS-1$
			assertFalse(check(helper, thing, "2 > 21.0")); //$NON-NLS-1$
			assertTrue(check(helper, thing, "2.0 > 1")); //$NON-NLS-1$
			assertFalse(check(helper, thing, "2.0 > 21")); //$NON-NLS-1$
			assertTrue(check(helper, thing, "2.0 > 1.0")); //$NON-NLS-1$
			assertFalse(check(helper, thing, "2.0 > 21.0")); //$NON-NLS-1$
			assertTrue(check(helper, thing, "'b' > 'a'")); //$NON-NLS-1$
			assertFalse(check(helper, thing, "'a' > 'b'")); //$NON-NLS-1$

			@SuppressWarnings("unchecked")
			List<Value> valuesList = (List<Value>) thing.eGet(evalues);
			
			valuesList.add(new Value("b")); //$NON-NLS-1$
			valuesList.add(new Value("a")); //$NON-NLS-1$
			
			assertTrue(check(helper, thing,
				"values->at(1) > values->at(2)")); //$NON-NLS-1$

			assertFalse(check(helper, thing,
				"values->at(2) > values->at(1)")); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests the &gt;= operator.
	 */
	public void test_greaterThanOrEqual() {
		helper.setContext(thingType);
		
		try {
			// primitives
			assertTrue(check(helper, thing, "2 >= 1")); //$NON-NLS-1$
			assertTrue(check(helper, thing, "2 >= 2")); //$NON-NLS-1$
			assertFalse(check(helper, thing, "2 >= 21")); //$NON-NLS-1$
			assertTrue(check(helper, thing, "2 >= 1.0")); //$NON-NLS-1$
			assertTrue(check(helper, thing, "2 >= 2.0")); //$NON-NLS-1$
			assertFalse(check(helper, thing, "2 >= 21.0")); //$NON-NLS-1$
			assertTrue(check(helper, thing, "2.0 >= 1")); //$NON-NLS-1$
			assertTrue(check(helper, thing, "2.0 >= 2")); //$NON-NLS-1$
			assertFalse(check(helper, thing, "2.0 >= 21")); //$NON-NLS-1$
			assertTrue(check(helper, thing, "2.0 >= 1.0")); //$NON-NLS-1$
			assertTrue(check(helper, thing, "2.0 >= 2.0")); //$NON-NLS-1$
			assertFalse(check(helper, thing, "2.0 >= 21.0")); //$NON-NLS-1$
			assertTrue(check(helper, thing, "'b' >= 'a'")); //$NON-NLS-1$
			assertTrue(check(helper, thing, "'b' >= 'b'")); //$NON-NLS-1$
			assertFalse(check(helper, thing, "'a' >= 'b'")); //$NON-NLS-1$

			@SuppressWarnings("unchecked")
			List<Value> valuesList = (List<Value>) thing.eGet(evalues);
			
			valuesList.add(new Value("b")); //$NON-NLS-1$
			valuesList.add(new Value("a")); //$NON-NLS-1$
			
			assertTrue(check(helper, thing,
				"values->at(1) >= values->at(2)")); //$NON-NLS-1$

			assertTrue(check(helper, thing,
				"values->at(1) >= values->at(1)")); //$NON-NLS-1$

			assertFalse(check(helper, thing,
				"values->at(2) >= values->at(1)")); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests the sortedby iterator.
	 */
	public void test_sortedBy() {
		helper.setContext(thingType);
		
		try {
			@SuppressWarnings("unchecked")
			List<Value> valuesList = (List<Value>) thing.eGet(evalues);
			
			valuesList.add(new Value("b")); //$NON-NLS-1$
			valuesList.add(new Value("c")); //$NON-NLS-1$
			valuesList.add(new Value("a")); //$NON-NLS-1$
			
			LinkedHashSet<Value> expected = new LinkedHashSet<Value>();
			expected.add(valuesList.get(2));
			expected.add(valuesList.get(0));
			expected.add(valuesList.get(1));
			
			assertEquals(expected, evaluate(helper, thing,
				"values->sortedBy(e | e)")); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests the <code>=</code> and <code>&lt;&gt;</code> operators for the
	 * Invalid type.
	 */
	public void test_invalid_equality() {
		helper.setContext(thingType);
		
		try {
			assertFalse(check(helper, thing, "OclInvalid = 'a'")); //$NON-NLS-1$
			assertTrue(check(helper, thing, "OclInvalid <> 'a'")); //$NON-NLS-1$
			assertTrue(check(helper, thing, "OclInvalid = OclInvalid")); //$NON-NLS-1$
			assertFalse(check(helper, thing, "OclInvalid <> OclInvalid")); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests the <code>=</code> and <code>&lt;&gt;</code> operators for the
	 * OclVoid type.
	 */
	public void test_void_equality() {
		helper.setContext(thingType);
		
		try {
			assertFalse(check(helper, thing, "null = 'a'")); //$NON-NLS-1$
			assertTrue(check(helper, thing, "null <> 'a'")); //$NON-NLS-1$
			assertTrue(check(helper, thing, "null = null")); //$NON-NLS-1$
			assertFalse(check(helper, thing, "null <> null")); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests evaluation of the arithmetic operations on integers.
	 */
	public void test_integerArithmetic() {
		helper.setContext(thingType);
		
		try {
			assertEquals(new Integer(1), evaluate(helper, thing, "3 - 2")); //$NON-NLS-1$
			assertEquals(new Integer(3), evaluate(helper, thing, "1 + 2")); //$NON-NLS-1$
			assertEquals(new Double(2.0), evaluate(helper, thing, "6 / 3")); //$NON-NLS-1$
			assertEquals(new Integer(6), evaluate(helper, thing, "2 * 3")); //$NON-NLS-1$
			assertEquals(new Integer(-1), evaluate(helper, thing, "- 1")); //$NON-NLS-1$
			assertEquals(new Integer(3), evaluate(helper, thing, "(2 - 5).abs()")); //$NON-NLS-1$
			assertEquals(new Integer(3), evaluate(helper, thing, "3.max(2)")); //$NON-NLS-1$
			assertEquals(new Integer(2), evaluate(helper, thing, "3.min(2)")); //$NON-NLS-1$
			assertEquals(new Integer(3), evaluate(helper, thing, "7.div(2)")); //$NON-NLS-1$
			assertEquals(new Integer(1), evaluate(helper, thing, "7.mod(2)")); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests evaluation of the arithmetic operations on reals.
	 */
	public void test_realArithmetic() {
		helper.setContext(thingType);
		
		try {
			assertEquals(new Double(1.0), evaluate(helper, thing, "3.0 - 2.0")); //$NON-NLS-1$
			assertEquals(new Double(3.0), evaluate(helper, thing, "1.0 + 2.0")); //$NON-NLS-1$
			assertEquals(new Double(2.0), evaluate(helper, thing, "6.0 / 3.0")); //$NON-NLS-1$
			assertEquals(new Double(6.0), evaluate(helper, thing, "2.0 * 3.0")); //$NON-NLS-1$
			assertEquals(new Double(-1.0), evaluate(helper, thing, "- 1.0")); //$NON-NLS-1$
			assertEquals(new Double(3.0), evaluate(helper, thing, "(2.0 - 5.0).abs()")); //$NON-NLS-1$
			assertEquals(new Double(3.0), evaluate(helper, thing, "3.0.max(2.0)")); //$NON-NLS-1$
			assertEquals(new Double(2.0), evaluate(helper, thing, "3.0.min(2.0)")); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests evaluation of the arithmetic operations on integers, with real
	 * arguments.
	 */
	public void test_mixedArithmetic() {
		helper.setContext(thingType);
		
		try {
			assertEquals(new Double(1.0), evaluate(helper, thing, "3 - 2.0")); //$NON-NLS-1$
			assertEquals(new Double(3.0), evaluate(helper, thing, "1 + 2.0")); //$NON-NLS-1$
			assertEquals(new Double(2.0), evaluate(helper, thing, "6 / 3.0")); //$NON-NLS-1$
			assertEquals(new Double(6.0), evaluate(helper, thing, "2 * 3.0")); //$NON-NLS-1$
			assertEquals(new Double(3.0), evaluate(helper, thing, "3.max(2.0)")); //$NON-NLS-1$
			assertEquals(new Double(2.0), evaluate(helper, thing, "3.min(2.0)")); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	public void test_dotNotationForSymbolicOperationNames() {
		helper.setContext(getUMLInteger());
		
		Integer minusOne = new Integer(-1);
		Integer one = new Integer(1);
		Integer two = new Integer(2);
		Double doubleTwo = new Double(2.0);
		Integer three = new Integer(3);
		Integer six = new Integer(6);
		
		try {
			// new NUMERIC_OPERATION token
			assertEquals(one, evaluate(helper, one, "3.-(2)")); //$NON-NLS-1$
			assertEquals(three, evaluate(helper, one, "1.+(2)")); //$NON-NLS-1$
			assertEquals(doubleTwo, evaluate(helper, one, "6./(3)")); //$NON-NLS-1$
			assertEquals(six, evaluate(helper, one, "2.*(3)")); //$NON-NLS-1$
			assertTrue(check(helper, one, "1.<(2)")); //$NON-NLS-1$
			assertTrue(check(helper, one, "1.<=(2)")); //$NON-NLS-1$
			assertTrue(check(helper, one, "2.>=(1)")); //$NON-NLS-1$
			assertTrue(check(helper, one, "2.>(1)")); //$NON-NLS-1$
			
			// new operationCallExpCS rule
			assertEquals(one, evaluate(helper, three, "self.-(2)")); //$NON-NLS-1$
			assertEquals(three, evaluate(helper, one, "self.+(2)")); //$NON-NLS-1$
			assertEquals(doubleTwo, evaluate(helper, six, "self./(3)")); //$NON-NLS-1$
			assertEquals(six, evaluate(helper, two, "self.*(3)")); //$NON-NLS-1$
			assertTrue(check(helper, one, "self.<(2)")); //$NON-NLS-1$
			assertTrue(check(helper, one, "self.<=(2)")); //$NON-NLS-1$
			assertTrue(check(helper, two, "self.>=(1)")); //$NON-NLS-1$
			assertTrue(check(helper, two, "self.>(1)")); //$NON-NLS-1$
			
			// unary minus
			assertEquals(minusOne, evaluate(helper, one, "-1")); //$NON-NLS-1$
			assertEquals(minusOne, evaluate(helper, one, "-self")); //$NON-NLS-1$
			assertEquals(minusOne, evaluate(helper, one, "self.-()")); //$NON-NLS-1$
			assertEquals(one, evaluate(helper, one, "- self.-()")); //$NON-NLS-1$
			assertEquals(one, evaluate(helper, one, "- -1")); //$NON-NLS-1$
			assertEquals(one, evaluate(helper, one, "- -self")); //$NON-NLS-1$
			
			// unary not
			helper.setContext(getUMLBoolean());
			assertEquals(Boolean.FALSE, evaluate(helper, Boolean.TRUE, "not self")); //$NON-NLS-1$
			assertEquals(Boolean.FALSE, evaluate(helper, Boolean.TRUE, "self.not()")); //$NON-NLS-1$
			assertEquals(Boolean.TRUE, evaluate(helper, Boolean.TRUE, "not not self")); //$NON-NLS-1$
			assertEquals(Boolean.TRUE, evaluate(helper, Boolean.TRUE, "not self.not()")); //$NON-NLS-1$
			
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	public void test_javaImplementationsOfInfixOperators() {
		helper.setContext(thingType);
		
		Numero three = new Numero(3);
		Numero four = new Numero(4);
		Numero eight = new Numero(8);
		Numero twelve = new Numero(12);
		
		try {
			assertEquals(four, evaluate(helper, thing, "numeros->at(1) - numeros->at(2)")); //$NON-NLS-1$
			assertEquals(eight, evaluate(helper, thing, "numeros->at(1) + numeros->at(2)")); //$NON-NLS-1$
			assertEquals(three, evaluate(helper, thing, "numeros->at(1) / numeros->at(2)")); //$NON-NLS-1$
			assertEquals(twelve, evaluate(helper, thing, "numeros->at(1) * numeros->at(2)")); //$NON-NLS-1$
			assertTrue(check(helper, thing, "numeros->at(2) < numeros->at(1)")); //$NON-NLS-1$
			assertTrue(check(helper, thing, "numeros->at(2) <= numeros->at(1)")); //$NON-NLS-1$
			assertTrue(check(helper, thing, "numeros->at(1) > numeros->at(2)")); //$NON-NLS-1$
			assertTrue(check(helper, thing, "numeros->at(1) >= numeros->at(2)")); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	public void test_comparisonOfBooleanOperations_137487() {
		Class ctx = (Class) umlMetamodel.getOwnedType("Class"); //$NON-NLS-1$      
		helper.setContext(ctx); 

		try {
			assertTrue(check(helper, ctx, "self.conformsTo(self)")); //$NON-NLS-1$
			
			assertTrue(check(helper, ctx, "self.conformsTo(self) and true"));  //$NON-NLS-1$
			assertTrue(check(helper, ctx, "self.conformsTo(self) or false")); //$NON-NLS-1$
			assertTrue(check(helper, ctx, "self.conformsTo(self) xor false")); //$NON-NLS-1$
			assertTrue(check(helper, ctx, "self.conformsTo(self) implies true")); //$NON-NLS-1$
			assertFalse(check(helper, ctx, "self.conformsTo(self) implies false")); //$NON-NLS-1$
			assertTrue(check(helper, ctx, "self.conformsTo(self) = true")); //$NON-NLS-1$
			assertTrue(check(helper, ctx, "self.conformsTo(self) <> false")); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}

	public void test_enumerationLiteralEquality_137546() {
		EObject ctx = fruitEFactory.create((EClass) fruitEPackage.getEClassifier(
				apple.getName()));
		helper.setContext(apple);
		
		EEnum ecolor = (EEnum) fruitEPackage.getEClassifier(color.getName());
		ctx.eSet(ctx.eClass().getEStructuralFeature(fruit_color.getName()),
				ecolor.getEEnumLiteral(color_green.getName()));

		try {
			assertTrue(check(helper, ctx,
					"ocltest::Color::green = self.color")); //$NON-NLS-1$	
			assertTrue(check(helper, ctx,
					"self.color = ocltest::Color::green")); //$NON-NLS-1$	
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}

	/**
	 * Tests that unrecognized data types are represented by themselves, not
	 * by OclAny.
	 */
	public void test_dataTypes_137158() {
		Package upackage = umlf.createPackage();
		upackage.setName("mypkg"); //$NON-NLS-1$
		Class uclass = upackage.createOwnedClass("B", false); //$NON-NLS-1$
		DataType datatype = (DataType) pkg.createOwnedType("Thread", uml.getDataType()); //$NON-NLS-1$
		Operation operation = uclass.createOwnedOperation("f", null, null, datatype); //$NON-NLS-1$
		operation.setIsQuery(true);
		
		helper.setContext(uclass);
		
		try {
			OCLExpression<Classifier> expr = helper.createQuery("self.f()"); //$NON-NLS-1$
			
			Classifier type = expr.getType();
			assertSame(datatype, type);
			
			operation.setUpper(LiteralUnlimitedNatural.UNLIMITED);
			
			expr = helper.createQuery("self.f()"); //$NON-NLS-1$
			
			type = expr.getType();
			assertTrue(type instanceof CollectionType);
			type = ((org.eclipse.ocl.uml.CollectionType) type).getElementType();
			assertSame(datatype, type);
			
			operation.setUpper(1);
			operation.setType(ocl.getEnvironment().getOCLStandardLibrary().getOclAny());
			
			expr = helper.createQuery("self.f()"); //$NON-NLS-1$
			
			type = expr.getType();
			assertSame(getOCLStandardLibrary().getOclAny(), type);
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	//
	// Framework methods
	//
	
	protected void setUp() throws Exception {
		super.setUp();
		
		pkg = umlf.createPackage();
		pkg.setName("pkg"); //$NON-NLS-1$
		
		valueType = pkg.createOwnedPrimitiveType("Value"); //$NON-NLS-1$
		
		thingType = pkg.createOwnedClass("Thing", false); //$NON-NLS-1$
		
		values = thingType.createOwnedAttribute("values", valueType); //$NON-NLS-1$
		values.setUpper(LiteralUnlimitedNatural.UNLIMITED);
		values.setIsOrdered(true);
		values.setIsUnique(true);
		
		numeroType = (Class) pkg.createOwnedClass("Numero", false); //$NON-NLS-1$
		
		numeroType.createOwnedOperation(
				"+", //$NON-NLS-1$
				new BasicEList<String>(Collections.singleton("n")), //$NON-NLS-1$
				new BasicEList<Type>(Collections.singleton(numeroType)),
				numeroType).setIsQuery(true);
		numeroType.createOwnedOperation(
				"-", //$NON-NLS-1$
				new BasicEList<String>(Collections.singleton("n")), //$NON-NLS-1$
				new BasicEList<Type>(Collections.singleton(numeroType)),
				numeroType).setIsQuery(true);
		numeroType.createOwnedOperation(
				"*", //$NON-NLS-1$
				new BasicEList<String>(Collections.singleton("n")), //$NON-NLS-1$
				new BasicEList<Type>(Collections.singleton(numeroType)),
				numeroType).setIsQuery(true);
		numeroType.createOwnedOperation(
				"/", //$NON-NLS-1$
				new BasicEList<String>(Collections.singleton("n")), //$NON-NLS-1$
				new BasicEList<Type>(Collections.singleton(numeroType)),
				numeroType).setIsQuery(true);
		
		numeroType.createOwnedOperation(
				"-", //$NON-NLS-1$
				ECollections.<String> emptyEList(),
				ECollections.<Type> emptyEList(),
				numeroType).setIsQuery(true);
		
		numeroType.createOwnedOperation(
				"<", //$NON-NLS-1$
				new BasicEList<String>(Collections.singleton("n")), //$NON-NLS-1$
				new BasicEList<Type>(Collections.singleton(numeroType)),
				getUMLBoolean()).setIsQuery(true);
		numeroType.createOwnedOperation(
				"<=", //$NON-NLS-1$
				new BasicEList<String>(Collections.singleton("n")), //$NON-NLS-1$
				new BasicEList<Type>(Collections.singleton(numeroType)),
				getUMLBoolean()).setIsQuery(true);
		numeroType.createOwnedOperation(
				">", //$NON-NLS-1$
				new BasicEList<String>(Collections.singleton("n")), //$NON-NLS-1$
				new BasicEList<Type>(Collections.singleton(numeroType)),
				getUMLBoolean()).setIsQuery(true);
		numeroType.createOwnedOperation(
				">=", //$NON-NLS-1$
				new BasicEList<String>(Collections.singleton("n")), //$NON-NLS-1$
				new BasicEList<Type>(Collections.singleton(numeroType)),
				getUMLBoolean()).setIsQuery(true);
		
		numeros = thingType.createOwnedAttribute("numeros", numeroType); //$NON-NLS-1$
		numeros.setUpper(LiteralUnlimitedNatural.UNLIMITED);
		numeros.setIsOrdered(true);
		numeros.setIsUnique(true);
		
		// the Ecore counterpart
		
		epkg = UMLUtil.convertToEcore(pkg, null).iterator().next();
		
		ethingType = (EClass) epkg.getEClassifier(thingType.getName());
		enumeros = (EReference) ethingType.getEStructuralFeature(numeros.getName());
		evalues = (EAttribute) ethingType.getEStructuralFeature(values.getName());
		
		enumeroType = (EClass) epkg.getEClassifier(numeroType.getName());
		enumeroType.setInstanceClass(Numero.class);
		
		evalueType = (EDataType) epkg.getEClassifier(valueType.getName());
		evalueType.setInstanceClass(Value.class);
		
		efactory = epkg.getEFactoryInstance();
		thing = efactory.create(ethingType);
		
		EPackage.Registry.INSTANCE.put(epkg.getNsURI(), epkg);
		
		@SuppressWarnings("unchecked")
		EList<Numero> list = (EList<Numero>) thing.eGet(enumeros);
		list.add(new Numero(6));
		list.add(new Numero(2));
	}
	
	private static class Value implements Comparable<Value> {
		private final String value;
		
		Value(String value) {
			this.value = value;
		}
		
		public int compareTo(Value arg0) {
			return value.compareTo(((Value) arg0).value);
		}

		public int hashCode() {
			final int PRIME = 31;
			int result = 1;
			result = PRIME * result + ((value == null) ? 0 : value.hashCode());
			return result;
		}

		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			final Value other = (Value) obj;
			if (value == null) {
				if (other.value != null)
					return false;
			} else if (!value.equals(other.value))
				return false;
			return true;
		}
	}
	
	public static class Numero extends EObjectImpl {
		private int value;
		
		Numero() {
			super();
		}
		
		Numero(int value) {
			this.value = value;
		}
		
		public Numero plus(Numero n) {
			return new Numero(value + n.value);
		}
		
		public Numero minus(Numero n) {
			return new Numero(value - n.value);
		}
		
		public Numero times(Numero n) {
			return new Numero(value * n.value);
		}
		
		public Numero divide(Numero n) {
			return new Numero(value / n.value);
		}
		
		public Numero minus() {
			return new Numero(-value);
		}
		
		public boolean lessThan(Numero n) {
			return value < n.value;
		}
		
		public boolean lessThanEqual(Numero n) {
			return value <= n.value;
		}
		
		public boolean greaterThan(Numero n) {
			return value > n.value;
		}
		
		public boolean greaterThanEqual(Numero n) {
			return value >= n.value;
		}

		public int hashCode() {
			final int PRIME = 31;
			int result = 1;
			result = PRIME * result + value;
			return result;
		}

		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			final Numero other = (Numero) obj;
			if (value != other.value)
				return false;
			return true;
		}
		
		public String toString() {
			return "Numero(" + value + ")"; //$NON-NLS-1$ //$NON-NLS-2$
		}
	}
}
