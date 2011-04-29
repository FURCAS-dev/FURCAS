/**
 * Copyright (c) 2009, 2011 Obeo and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *     Axel Uhl (SAP AG) - Bug 342644
 */
package org.eclipse.ocl.ecore.tests;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.ocl.EvaluationVisitor;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.expressions.OCLExpression;

/**
 * This framework can be used to ease the testing of the evaluation visitor
 * implementation.
 * 
 * @author Laurent Goubet (lgoubet)
 */
@SuppressWarnings("nls")
public abstract class AbstractEvaluationTest
		extends AbstractTestSuite {

	public static Test suite() {
		TestSuite suite = new TestSuite("Evaluation visitor tests");

		suite.addTest(new TestSuite(EvaluationBooleanOperationTest.class,
			"Boolean operations Tests"));
		suite.addTest(new TestSuite(EvaluationCollectionOperationTest.class,
			"Collection operations Tests"));
		suite.addTest(new TestSuite(EvaluationNumberOperationTest.class,
			"Numeric operations Tests"));
		suite.addTest(new TestSuite(EvaluationOclAnyOperationTest.class,
			"OclAny operations Tests"));
		suite.addTest(new TestSuite(EvaluationStringOperationTest.class,
			"String operations Tests"));

		return suite;
	}

	/**
	 * Instance of the invalid type. This is a shortcut for
	 * 
	 * <pre>
	 * ocl.getEnvironment().getOCLStandardLibrary().getInvalid()
	 * </pre>
	 */
	protected Object invalidObject;

	/** This is the visitor that will be tested by the underlying tests. */
	protected EvaluationVisitor<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> visitor;

	/**
	 * Creates a query given the expression that is to be evaluated, then
	 * asserts its result contains all elements included in
	 * <code>expectedResult</code>.
	 * 
	 * @param expectedResult
	 *            Collection with which the query's result is to be compared.
	 * @param expression
	 *            Expression that is to be evaluated. Note that we'll use
	 *            {@link EClass} as this expression's context.
	 */
	@SuppressWarnings("unchecked")
	protected void assertResultContainsAll(Collection<Object> expectedResult, String expression) {
		OCLExpression<EClassifier> query = createQuery(EcorePackage.eINSTANCE
			.getEClass(), expression);
		Object result = visitor.visitExpression(query);

		assertTrue(expectedResult.getClass().isInstance(result));
		assertSame(expectedResult.size(), ((Collection<Object>) result).size());
		assertTrue(((Collection<Object>) result).containsAll(expectedResult));
	}

	/**
	 * Creates a query given the expression that is to be evaluated, then
	 * asserts its result contains all elements included in
	 * <code>expectedResult</code>.
	 * 
	 * @param expectedResultExpression
	 *            Expression which is to be evaluated to determine the expected
	 *            result.
	 * @param expression
	 *            Expression that is to be evaluated. Note that we'll use
	 *            {@link EClass} as this expression's context.
	 */
	@SuppressWarnings("unchecked")
	protected void assertResultContainsAll(String expectedResultExpression, String expression) {
		OCLExpression<EClassifier> expectedResultQuery = createQuery(
			EcorePackage.eINSTANCE.getEClass(), expectedResultExpression);
		Object result = visitor.visitExpression(expectedResultQuery);

		assertTrue(result instanceof Collection<?>);
		assertResultContainsAll((Collection<Object>) result, expression);
	}

	/**
	 * Creates a query given the expression that is to be evaluated, then
	 * asserts its result is equal to the given <code>expectedResult</code>.
	 * <p>
	 * If either the expected result or the expression result is a double, we'll
	 * compare the two with a margin of 0.001.
	 * </p>
	 * 
	 * @param expectedResult
	 *            Object with which the query's result is to be compared.
	 * @param expression
	 *            Expression that is to be evaluated. Note that we'll use
	 *            {@link EClass} as this expression's context.
	 */
	@SuppressWarnings("unchecked")
	protected void assertResult(Object expectedResult, String expression) {
		OCLExpression<EClassifier> query = createQuery(EcorePackage.eINSTANCE
			.getEClass(), expression);
		Object result = visitor.visitExpression(query);
		if (expectedResult instanceof Double && result instanceof Double) {
			assertEquals(((Double) expectedResult).doubleValue(),
				((Double) result).doubleValue(), 0.001d);
		} else if (expectedResult instanceof LinkedHashSet<?>) {
			/*
			 * Set is represented as HashSet but may also be emptySet,
			 * OrderedSet as LinkedHashSet. Java does not check for the ordering
			 * when calling equals, we'll then statically check for the instance
			 * type. Bag and Sequence do not present the same issue because of
			 * the implementation of BagImpl#equals().
			 */
			assertTrue(result instanceof LinkedHashSet<?>);
			assertSame(((LinkedHashSet<?>) result).size(),
				((LinkedHashSet<?>) expectedResult).size());
			final Iterator<Object> resultIterator = ((LinkedHashSet<Object>) result)
				.iterator();
			final Iterator<Object> expectedResultIterator = ((LinkedHashSet<Object>) expectedResult)
				.iterator();
			while (resultIterator.hasNext()) {
				assertEquals(resultIterator.next(), expectedResultIterator
					.next());
			}
		} else if (expectedResult instanceof Set<?>) {
			assertTrue(result instanceof Set<?> && !(result instanceof LinkedHashSet<?>));
			assertEquals(expectedResult, result);
		} else if (expectedResult instanceof Collection<?>) {
			assertTrue(expectedResult.getClass().isInstance(result));
			assertEquals(expectedResult, result);
		} else {
			assertEquals(expectedResult, result);
		}
	}

	/**
	 * This will evaluate the given OCL expression and assert its result is
	 * equal to {@link Boolean#TRUE}.
	 * 
	 * @param expression
	 *            Expression that is to be evaluated. Note that we'll use
	 *            {@link EClass} as this expression's context.
	 */
	protected void assertResultTrue(String expression) {
		assertResult(Boolean.TRUE, expression);
	}

	/**
	 * This will evaluate the given OCL expression and assert its result is
	 * equal to {@link Boolean#FALSE}.
	 * 
	 * @param expression
	 *            Expression that is to be evaluated. Note that we'll use
	 *            {@link EClass} as this expression's context.
	 */
	protected void assertResultFalse(String expression) {
		assertResult(Boolean.FALSE, expression);
	}

	/**
	 * This will evaluate the given OCL expression and assert its result is
	 * equal to the OCL library's invalid Object.
	 * 
	 * @param expression
	 *            Expression that is to be evaluated. Note that we'll use
	 *            {@link EClass} as this expression's context.
	 */
	protected void assertResultInvalid(String expression) {
		assertResult(invalidObject, expression);
	}

	/**
	 * Creates a query given the expression that is to be evaluated, then
	 * asserts its result is equal to the evaluation of the given
	 * <code>expectedResultExpression</code>.
	 * <p>
	 * If either the expected result or the expression result is a double, we'll
	 * compare the two with a margin of 0.001.
	 * </p>
	 * 
	 * @param expectedResult
	 *            Object with which the query's result is to be compared.
	 * @param expression
	 *            Expression that is to be evaluated. Note that we'll use
	 *            {@link EClass} as this expression's context.
	 */
	protected void assertExpressionResults(String expectedResultExpression, String expression) {
		OCLExpression<EClassifier> expectedResultQuery = createQuery(
			EcorePackage.eINSTANCE.getEClass(), expectedResultExpression);
		Object result = visitor.visitExpression(expectedResultQuery);

		assertResult(result, expression);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ocl.ecore.tests.AbstractTestSuite#setUp()
	 */
	@Override
	protected void setUp() {
		super.setUp();
		visitor = EcoreEnvironmentFactory.INSTANCE.createEvaluationVisitor(ocl
			.getEnvironment(), ocl.getEvaluationEnvironment(), ocl
			.getExtentMap());
		invalidObject = ocl.getEnvironment().getOCLStandardLibrary()
			.getInvalid();
	}
}
