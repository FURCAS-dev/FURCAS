/**
 * <copyright>
 * 
 * Copyright (c) 2005,2011 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   Zeligsoft - Bugs 243079, 244948, 244886, 245619
 *   E.D.Willink - Bug 191689, 254919, 296409, 298634
 *   Obeo - Bug 291310
 *
 * </copyright>
 *
 * $Id: PivotTestSuite.java,v 1.9 2011/05/30 16:09:59 ewillink Exp $
 */

package org.eclipse.ocl.examples.pivot.tests;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.spi.LoggingEvent;
import org.apache.log4j.spi.ThrowableInformation;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.ocl.examples.library.oclstdlib.OCLstdlib;
import org.eclipse.ocl.examples.pivot.ClassifierType;
import org.eclipse.ocl.examples.pivot.Comment;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.Enumeration;
import org.eclipse.ocl.examples.pivot.EnumerationLiteral;
import org.eclipse.ocl.examples.pivot.Environment;
import org.eclipse.ocl.examples.pivot.EnvironmentFactory;
import org.eclipse.ocl.examples.pivot.EvaluationException;
import org.eclipse.ocl.examples.pivot.ExpressionInOcl;
import org.eclipse.ocl.examples.pivot.InvalidValueException;
import org.eclipse.ocl.examples.pivot.OCL;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.ParserException;
import org.eclipse.ocl.examples.pivot.PivotFactory;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.SemanticException;
import org.eclipse.ocl.examples.pivot.StandardLibrary;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.ecore.Ecore2Pivot;
import org.eclipse.ocl.examples.pivot.helper.OCLHelper;
import org.eclipse.ocl.examples.pivot.util.Visitable;
import org.eclipse.ocl.examples.pivot.utilities.PivotEnvironment;
import org.eclipse.ocl.examples.pivot.utilities.PivotEnvironmentFactory;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.pivot.utilities.TypeManagerResourceAdapter;
import org.eclipse.ocl.examples.pivot.utilities.TypeManagerResourceSetAdapter;
import org.eclipse.ocl.examples.pivot.values.BooleanValue;
import org.eclipse.ocl.examples.pivot.values.CollectionValue;
import org.eclipse.ocl.examples.pivot.values.OrderedSetValue;
import org.eclipse.ocl.examples.pivot.values.RealValue;
import org.eclipse.ocl.examples.pivot.values.Value;
import org.eclipse.ocl.examples.pivot.values.ValueFactory;
import org.eclipse.ocl.examples.xtext.essentialocl.EssentialOCLStandaloneSetup;
import org.eclipse.osgi.util.NLS;
import org.eclipse.xtext.diagnostics.ExceptionDiagnostic;

/**
 * Default test framework.
 *
 * @author Christian W. Damus (cdamus)
 */
@SuppressWarnings("nls")
public abstract class PivotTestSuite
	extends TestCase {

	// set this variable true when testing for memory leaks
    private static boolean DISPOSE_RESOURCE_SET = false;
	public static final String PLUGIN_ID = "org.eclipse.ocl.examples.xtext.tests";
	
    public static final class CheckedTestSuite extends TestSuite {

		public CheckedTestSuite(String name) {
			super(name);
		}

		public void createTestSuite(Class<? extends PivotTestSuite> testClass, String testName) {
	        addTest(new TestSuite(testClass, testName));
		}

		public void addTestSuite(CheckedTestSuite suite) {
	        addTest(suite);
		}
	}
	private static final class TestCaseAppender extends ConsoleAppender {

		public TestCaseAppender() {
			super(new SimpleLayout(), SYSTEM_OUT); 
			setName("TestHarness");
		}
		
		@Override
		public void append(LoggingEvent event) {
			if (event.getLevel().isGreaterOrEqual(Level.INFO)) {
				String renderedMessage = event.getRenderedMessage();
				ThrowableInformation throwableInformation = event.getThrowableInformation();
				Throwable throwable = throwableInformation != null ? throwableInformation.getThrowable() : null;
				throw new Error(renderedMessage, throwable);
			}
//			super.append(event);
		}
	}
    
	protected static boolean noDebug = false;
	protected static ResourceSet resourceSet;
	private static ArrayList<Resource> standardResources;

	private static boolean initialized = false;
	
	public static void debugPrintln(String string) {
		if (!noDebug) {
			System.out.println(string);
		}		
	}

	public static boolean eclipseIsRunning() {
		try {
			Class<?> platformClass = Class.forName("org.eclipse.core.runtime.Platform");
			Method isRunningMethod = platformClass.getDeclaredMethod("isRunning");
			return Boolean.TRUE.equals(isRunningMethod.invoke(null));
		} catch (Exception e) {
		}
		return false;
	}

	public static void initializeStandalone() {
		if (initialized)
			return;
		initialized = true;
	}

	protected TypeManager typeManager;
	protected ValueFactory valueFactory;
	protected OCL ocl;
	protected Environment environment;
	protected OCLHelper helper;

	public void addSupertype(org.eclipse.ocl.examples.pivot.Class aClass, org.eclipse.ocl.examples.pivot.Class superClass) {
		aClass.getSuperClasses().add(superClass);
	}
    
	/**
	 * Assert that an expression cannot be used as an invariant, because an exception is thrown
	 * with a diagnostic of severity containing a message that is the result of messageTemplate
	 * resolved by bindings.
	 */
    protected void assertBadInvariant(Class<?> exception, int severity,
   		String expression, String messageTemplate, String... bindings) {
		String denormalized = denormalize(expression);
		Resource resource = null;
        try {
    		PivotEnvironment environment = (PivotEnvironment) helper.getEnvironment();
    		TypeManager typeManager = environment.getTypeManager();
    		Type contextClassifier = environment.getContextClassifier();
    		URI uri = typeManager.getResourceIdentifier(expression, null);
			resource = PivotUtil.createXtextResource(typeManager, uri, contextClassifier, expression);
			PivotUtil.checkResourceErrors("Errors in '" + expression + "'", resource);
            fail("Should not have parsed \"" + denormalized + "\"");
        } catch (ParserException e) {
        	assertEquals("Exception for \"" + denormalized + "\"", exception, e.getClass());
        	Resource.Diagnostic diagnostic = getDiagnostic(resource);
			assertNoException(diagnostic, ClassCastException.class);
        	assertNoException(diagnostic, NullPointerException.class);
//        	assertEquals("Severity for \"" + denormalized + "\"", severity, diagnostic.getSeverity());
        	String expectedMessage = NLS.bind(messageTemplate, bindings);
        	assertEquals("Message for \"" + denormalized + "\"", expectedMessage, diagnostic.getMessage());
        } catch (IOException e) {
			fail(e.getMessage());
		} finally {
			if (resource != null) {
				TypeManagerResourceAdapter adapter = TypeManagerResourceAdapter.findAdapter(resource);
				if (adapter != null) {
					adapter.dispose();
				}
			}
		}	   
    }
	 
	/**
	 * Assert that an expression cannot be used as a query, because an exception is thrown
	 * with a diagnostic of severity containing a message that is the result of messageTemplate
	 * resolved by bindings.
	 * @throws IOException 
	 */
     protected void assertBadQuery(Class<?> exception, int severity,
    		 String expression, String messageTemplate, Object... bindings) {
		String denormalized = denormalize(expression);
		Resource resource = null;
		try {
    		PivotEnvironment environment = (PivotEnvironment) helper.getEnvironment();
    		TypeManager typeManager = environment.getTypeManager();
    		Type contextClassifier = environment.getContextClassifier();
    		URI uri = typeManager.getResourceIdentifier(expression, null);
			resource = PivotUtil.createXtextResource(typeManager, uri, contextClassifier, expression);
			PivotUtil.checkResourceErrors("Errors in '" + expression + "'", resource);
            fail("Should not have parsed \"" + denormalized + "\"");
        } catch (ParserException e) {
        	assertEquals("Exception for \"" + denormalized + "\"", exception, e.getClass());
        	Resource.Diagnostic diagnostic = getDiagnostic(resource);
//			assertNoException(diagnostic, ClassCastException.class);
//        	assertNoException(diagnostic, NullPointerException.class);
//        	assertEquals("Severity for \"" + denormalized + "\"", severity, diagnostic.getSeverity());
        	String expectedMessage = NLS.bind(messageTemplate, bindings);
        	assertEquals("Message for \"" + denormalized + "\"", expectedMessage, diagnostic.getMessage());
        } catch (IOException e) {
			fail(e.getMessage());
		} finally {
			if (resource != null) {
				TypeManagerResourceAdapter adapter = TypeManagerResourceAdapter.findAdapter(resource);
				if (adapter != null) {
					adapter.dispose();
				}
			}
		}	   
	}
     
    protected void assertSemanticErrorQuery(String expression,
    		 String messageTemplate, Object... bindings) {
    	 assertBadQuery(SemanticException.class, Diagnostic.ERROR,
    		 expression, messageTemplate, bindings);	   
	}
	
	/**
	 * Assert that an expression can be parsed as an invariant for a context and return the invariant.
	 */
	protected ExpressionInOcl assertInvariant(Type context, String expression) {
		helper.setContext(context);
		
		String denormalized = denormalize(expression);		
		try {
			ExpressionInOcl result = helper.createInvariant(denormalized);
			return result;
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage());
			return null;
		}		
	}

	/**
	 * Assert that an expression evaluated as an invariant for a context returns false.
	 */
	protected Object assertInvariantFalse(Object context, String expression) {
		String denormalized = denormalize(expression);
		try {
			Object value = check(helper, context, denormalized);
			assertEquals(denormalized, false, value);
			return value;
		} catch (ParserException e) {
            fail("Failed to parse or evaluate \"" + denormalized + "\": " + e.getLocalizedMessage());
			return null;
		}
	}

	/**
	 * Assert that an expression evaluated as an invariant for a context returns true.
	 */
	protected Object assertInvariantTrue(Object context, String expression) {
		String denormalized = denormalize(expression);
		try {
			Object value = check(helper, context, denormalized);
			assertEquals(denormalized, true, value);
			return value;
		} catch (ParserException e) {
            fail("Failed to parse or evaluate \"" + denormalized + "\": " + e.getLocalizedMessage());
			return null;
		}
	}

	/**
	 * Asserts that a exception of the specified kind is not signalled by
	 * the a given diagnostic or (recursively) its children.
	 * 
	 * @param diagnostic a diagnostic
	 * @param excType an exception that must not be indicated by the diagnostic
	 * 
	 * @since 1.2
	 */
    protected void assertNoException(Resource.Diagnostic diagnostic, java.lang.Class<? extends Throwable> excType) {
    	if (diagnostic instanceof ExceptionDiagnostic) {
	    	if (excType.isInstance(((ExceptionDiagnostic)diagnostic).getException())) {
	    		fail("Diagnostic signals a(n) " + excType.getSimpleName());
	    	}
	    	
//	    	for (Diagnostic nested : diagnostic.getChildren()) {
//	    		assertNoException(nested, excType);
//	    	}
    	}
    }
	
	/**
	 * Asserts that the specified choice is <em>not</em> to be found in the
	 * collection of <code>choices</code>.
	 * 
	 * @param choices a collection of {@link Choice}s
	 * @param kind the kind of choice not to find
	 * @param name the name of the choice not to find
	 *
	protected void assertNotChoice(Collection<Choice> choices, ChoiceKind kind, String name) {
		assertNull("Choice found: " + name + ", " + kind, //$NON-NLS-2$
			findChoice(choices, kind, name));
	} */
	
	/**
	 * Assert that an expression can be parsed as a query for a context and return the query.
	 */
	protected ExpressionInOcl assertQuery(Type context, String expression) {
		helper.setContext(context);
		String denormalized = denormalize(expression);
		try {
			ExpressionInOcl result = helper.createQuery(denormalized);
			return result;
		} catch (Exception e) {
//			e.printStackTrace();
			fail("Parse failed: " + e.getLocalizedMessage());
			return null;
		}
	}

	/**
	 * Assert that the result of evaluating an expression as a query is not undefined.
	 * @return the evaluation result
	 */
	protected Value assertQueryDefined(Object context, String expression) {
		String denormalized = denormalize(expression);
		try {
			Value value = evaluate(helper, context, denormalized);
			assertFalse(denormalized + " expected defined: ", value.isUndefined());
			return value;
		} catch (ParserException e) {
            fail("Failed to parse or evaluate \"" + denormalized + "\": " + e.getLocalizedMessage());
			return null;
		}
	}

	/**
	 * Assert that the result of evaluating an expression as a query is equal to expected.
	 * @return the evaluation result
	 */
	protected Object assertQueryEquals(Object context, Object expected, String expression) {
		String denormalized = denormalize(expression);
		try {
			if (expected instanceof EEnumLiteral) {
				Resource resource = ((EEnumLiteral)expected).eResource();
				Ecore2Pivot ecore2Pivot = Ecore2Pivot.getAdapter(resource, typeManager);
				expected = ecore2Pivot.getCreated(EnumerationLiteral.class, (EEnumLiteral)expected);
			}
			Value expectedValue = expected instanceof Value ? (Value)expected : valueFactory.valueOf(expected);
			Value value = evaluate(helper, context, denormalized);
//			String expectedAsString = String.valueOf(expected);
//			String valueAsString = String.valueOf(value);
			assertEquals(denormalized, expectedValue, value);
			// FIXME Following is probably redundant
			if (expectedValue instanceof OrderedSetValue) {
				assertTrue(denormalized, value instanceof OrderedSetValue);
				Iterator<?> es = ((OrderedSetValue)expectedValue).iterator();
				Iterator<?> vs = ((OrderedSetValue)value).iterator();
				while (es.hasNext()) {
					Object e = es.next();
					Object v = vs.next();
					assertEquals(denormalized, e, v);
				}
			}
			return value;
		} catch (ParserException e) {
            fail("Failed to parse or evaluate \"" + denormalized + "\": " + e.getLocalizedMessage());
			return null;
		}
	}

	/**
	 * Assert that the result of evaluating an expression as a query is equal to expected.
	 * @return the evaluation result
	 */
	protected Object assertQueryEquals(Object context, BigDecimal expected, BigDecimal delta, String expression) {
		String denormalized = denormalize(expression);
		try {
			BigDecimal value = (BigDecimal) evaluate(helper, context, denormalized);
			assertTrue(denormalized, (value.compareTo(expected.add(delta)) >= 0) && (value.compareTo(expected.subtract(delta)) >= 0));
			return value;
		} catch (ParserException e) {
            fail("Failed to parse or evaluate \"" + denormalized + "\": " + e.getLocalizedMessage());
			return null;
		}
	}

	/**
	 * Assert that the result of evaluating an expression as a query is equal to expected.
	 * @return the evaluation result
	 */
	protected Object assertQueryEquals(Object context, Number expected, String expression, double tolerance) {
		String denormalized = denormalize(expression);
		try {
			Value expectedValue = valueFactory.valueOf(expected);
			Value value = evaluate(helper, context, denormalized);
			BigDecimal expectedVal = ((RealValue)expectedValue).bigDecimalValue();
			BigDecimal val = ((RealValue)value).bigDecimalValue();
			double delta = val.subtract(expectedVal).doubleValue();
			if ((delta < -tolerance) || (tolerance < delta)) {
				assertEquals(denormalized, expected, value);
			}
			return value;
		} catch (ParserException e) {
            fail("Failed to parse or evaluate \"" + denormalized + "\": " + e.getLocalizedMessage());
			return null;
		}
	}

	/**
	 * Assert that the result of evaluating an expression as a query is the same as expected.
	 */
	protected Object assertQueryEvaluate(Object context, String expression) {
		String denormalized = denormalize(expression);
		try {
			Object value = evaluate(helper, context, denormalized);
			return value;
		} catch (ParserException e) {
            fail("Failed to parse or evaluate \"" + denormalized + "\": " + e.getLocalizedMessage());
            return null;
		}
	}

	/**
	 * Assert that the result of evaluating an expression as a query is false.
	 * @return the evaluation result
	 */
	protected Object assertQueryFalse(Object context, String expression) {
		String denormalized = denormalize(expression);
		try {
			Value value = evaluate(helper, context, denormalized);
			assertEquals(denormalized, valueFactory.getFalse(), value);
			return value;
		} catch (ParserException e) {
            fail("Failed to parse or evaluate \"" + denormalized + "\": " + e.getLocalizedMessage());
			return null;
		}
	}

	/**
	 * Assert that the result of evaluating an expression as a query is invalid.
	 * @return the evaluation result
	 */
	protected Value assertQueryInvalid(Object context, String expression) {
		String denormalized = denormalize(expression);
		try {
			Value value = evaluate(helper, context, denormalized);
			fail(denormalized + " expected: invalid but was: " + value);
		} catch (EvaluationException e) {
//			assertEquals("Invalid Value Reason", reason, e.getMessage());
//			assertEquals("Invalid Value Throwable", exceptionClass, e.getCause().getClass());
		} catch (ParserException e) {
            fail("Failed to parse or evaluate \"" + denormalized + "\": " + e.getLocalizedMessage());
		}
		return null;
	}

	protected Object assertQueryInvalid(Object context, String expression,
			String reason, Class<?> exceptionClass) {
		String denormalized = denormalize(expression);
		try {
			Value value = evaluate(helper, context, denormalized);
			fail(denormalized + " expected: invalid but was: " + value);
//           fail("Expected invalid for \"" + denormalized + "\"");
		} catch (EvaluationException e) {
			assertEquals("Invalid Value Reason", reason, e.getMessage());
			assertEquals("Invalid Value Throwable", exceptionClass, e.getCause().getClass());
		} catch (ParserException e) {
            fail("Failed to parse or evaluate \"" + denormalized + "\": " + e.getLocalizedMessage());
		}
		return null;
	}

	/**
	 * Assert that the result of evaluating an expression as a query is not null.
	 * @return the evaluation result
	 */
	protected Object assertQueryNotJavaNull(Object context, String expression) {
		String denormalized = denormalize(expression);
		try {
			Object value = evaluate(helper, context, denormalized);
			assertNotNull(denormalized, value);
			return value;
		} catch (ParserException e) {
            fail("Failed to parse or evaluate \"" + denormalized + "\": " + e.getLocalizedMessage());
			return null;
		}
	}
	
	/**
	 * Assert that the result of evaluating an expression as a query is not the same as expected.
	 * @return the evaluation result
	 */
	protected Object assertQueryNotSame(Object context, Object expected, String expression) {
		String denormalized = denormalize(expression);
		try {
			Object value = evaluate(helper, context, denormalized);
			assertNotSame(denormalized, expected, value);
			return value;
		} catch (ParserException e) {
            fail("Failed to parse or evaluate \"" + denormalized + "\": " + e.getLocalizedMessage());
			return null;
		}
	}

	/**
	 * Assert that the result of evaluating an expression as a query is OCL null.
	 * @return the evaluation result
	 */
	protected Object assertQueryNull(Object context, String expression) {
		String denormalized = denormalize(expression);
		try {
			Value value = evaluate(helper, context, denormalized);
			if (!value.isNull()) {
				assertEquals(denormalized, valueFactory.getNull(), value);
			}
			return value;
		} catch (ParserException e) {
            fail("Failed to parse or evaluate \"" + denormalized + "\": " + e.getLocalizedMessage());
			return null;
		}
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
	protected Object assertQueryResults(Object context, String expectedResultExpression, String expression) {
		String denormalizedExpectedResultExpression = denormalize(expectedResultExpression);
		try {
			Object expectedResultQuery = evaluate(helper, context, denormalizedExpectedResultExpression);
			Object result = assertQueryEquals(context, expectedResultQuery, expression);
			return result;
		} catch (ParserException e) {
            fail("Failed to parse or evaluate \"" + denormalizedExpectedResultExpression + "\": " + e.getLocalizedMessage());
			return null;
		}
	}
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
	protected Object assertResultContainsAll(Object context, CollectionValue expectedResult, String expression) {
		String denormalizedExpression = denormalize(expression);
		try {
			Value result = evaluate(helper, context, denormalizedExpression);
			assertTrue(expectedResult.getClass().isInstance(result));
			assertSame(expectedResult.intSize(), ((CollectionValue) result).intSize());
			BooleanValue actualResult = ((CollectionValue) result).includesAll(expectedResult);
			assertTrue("Expected " + result + " to contain " + expectedResult, actualResult.isTrue());
			return result;
		} catch (InvalidValueException e) {
	        fail("Failed to evaluate \"" + denormalizedExpression + "\": " + e.getLocalizedMessage());
		} catch (ParserException e) {
            fail("Failed to parse or evaluate \"" + denormalizedExpression + "\": " + e.getLocalizedMessage());
		}
		return null;
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
	protected Object assertResultContainsAll(Object context, String expectedResultExpression, String expression) {
		String denormalizedExpectedResultExpression = denormalize(expectedResultExpression);
		try {
			Value expectedResultQuery = evaluate(helper, null, denormalizedExpectedResultExpression);
			assertTrue(expectedResultQuery instanceof CollectionValue);
			Object result = assertResultContainsAll(context, (CollectionValue) expectedResultQuery, expression);
			return result;
		} catch (ParserException e) {
            fail("Failed to parse or evaluate \"" + denormalizedExpectedResultExpression + "\": " + e.getLocalizedMessage());
			return null;
		}
	}

	/**
	 * Assert that the result of evaluating an expression as a query is the same as expected.
	 * @return the evaluation result
	 *
	protected Object assertQuerySame(Object context, Object expected, String expression) {
		String denormalized = denormalize(expression);
		try {
			Object value = evaluate(helper, context, denormalized);
			assertSame(denormalized, expected, value);
			return value;
		} catch (ParserException e) {
            fail("Failed to parse or evaluate \"" + denormalized + "\": " + e.getLocalizedMessage());
			return null;
		}
	} */

	/**
	 * Assert that the result of evaluating an expression as a query is true.
	 * @return the evaluation result
	 */
	protected Object assertQueryTrue(Object context, String expression) {
		String denormalized = denormalize(expression);
		try {
			Value value = evaluate(helper, context, denormalized);
			assertEquals(denormalized, valueFactory.getTrue(), value);
			return value;
		} catch (ParserException e) {
            fail("Failed to parse or evaluate \"" + denormalized + "\": " + e.getLocalizedMessage());
			return null;
		}
	}

	/**
	 * Assert that the result of evaluating an expression as a query is an unlimited value.
	 * @return the evaluation result
	 */
	protected Object assertQueryUnlimited(Object context, String expression) {
		String denormalized = denormalize(expression);
		try {
			Value value = evaluate(helper, context, denormalized);
			if (!value.isUnlimited()) {
				assertEquals(denormalized, valueFactory.getUnlimited(), value);
			}
			return value;
		} catch (ParserException e) {
            fail("Failed to parse or evaluate \"" + denormalized + "\": " + e.getLocalizedMessage());
			return null;
		}
	}
    
    /**
	 * Asserts that the <code>toString</code> representation of an AST node as
	 * generated by the toString visitor does not throw a run-time exception
	 * and is not <code>null</code>.
	 * 
	 * @param node a visitable AST node
	 */
	protected void assertValidToString(Visitable node) {
		try {
			String toString = node.toString();
			assertNotNull("ToStringVisitorImpl returned null", toString);
		} catch (RuntimeException e) {
			e.printStackTrace();
			fail("ToStringVisitorImpl threw an exception: " + e.getLocalizedMessage());
		}
	}
	
	protected boolean check(String contextFreeExpression) {
		boolean result = false;
		
		try {
			String document = denormalize("package %uml context %String" +
					" inv: " + contextFreeExpression + " endpackage");
			ExpressionInOcl expr = parse(document);
			
			result = check(expr, "");
		} catch (Exception e) {
			fail("Check failed: " + e.getLocalizedMessage());
		}
		
		return result;
	}
    
    protected boolean check(OCLHelper aHelper, Object context,
            String expression) throws ParserException {
        
    	ExpressionInOcl constraint = aHelper.createInvariant(expression);
        return ocl.check(context, constraint);
    }
	
	protected boolean check(ExpressionInOcl expr, Object self) {
		boolean result = false;
		
		try {
			result = ocl.check(self, expr);
		} catch (RuntimeException e) {
			fail("Check failed: " + e.getLocalizedMessage());
		}
		
		return result;
	}
 	
	/**
	 * This can be called by subclasses to provide a meaningful error message
	 * when the tests are run with an encoding distinct from UTF-8.
	 */
	protected void checkForUTF8Encoding() {
		String testCharacter = "´";
		int length = testCharacter.length();
		if ((length != 1) || (testCharacter.charAt(0) != 0xB4)) {
			StringBuffer s = new StringBuffer();
			s.append("The Resource text file encoding should be set to UTF-8: test character was");
			for (int i = 0; i < length; i++){
				s.append(" ");
				s.append(Integer.toHexString(testCharacter.charAt(i)));
			}
			s.append(" rather than B4");
			fail(s.toString());
		}
	}

	protected ExpressionInOcl createBodyCondition(Operation context, String text) {
		OCLHelper helper = ocl.createOCLHelper();
		helper.setOperationContext(context.getClass_(), context);
		
		ExpressionInOcl result = null;
		
		try {
			result = helper.createBodyCondition(text);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Parse failed: " + e.getLocalizedMessage());
		}
		
		return result;
	}

	public org.eclipse.ocl.examples.pivot.Class createClass() {
		return PivotFactory.eINSTANCE.createClass();
	}

	/**
	 * Return an isOrdered,isUnique collection containing args.
	 */
	protected CollectionValue createCollection(boolean isOrdered, boolean isUnique, Value... args) {
		if (isOrdered)
			return isUnique ? valueFactory.createOrderedSetValue(args) : valueFactory.createSequenceValue(args);
		else
			return isUnique ? valueFactory.createSetValue(args) : valueFactory.createBagValue(args);
	}

	public Comment createComment() {
		return PivotFactory.eINSTANCE.createComment();
	}

	protected void createDocument(String text) {
		throw new UnsupportedOperationException();
//		try {
//			ocl.parse(new OCLInput(text));
//        } catch (Exception e) {
//            fail("Failed to parse: " + e.getLocalizedMessage());
//        }
	}

	public void createGeneralization(Type special, Type general) {
		if ((special instanceof org.eclipse.ocl.examples.pivot.Class) && (general instanceof org.eclipse.ocl.examples.pivot.Class))
			((org.eclipse.ocl.examples.pivot.Class)special).getSuperClasses().add((org.eclipse.ocl.examples.pivot.Class)general);
	}

	protected OCLHelper createHelper() {
		return ocl.createOCLHelper();
	}
	
	protected ExpressionInOcl createInvariant(Type context, String expression) {
		return assertInvariant(context, expression);
	}

	protected Property createOwnedAttribute(org.eclipse.ocl.examples.pivot.Class aClass, String name, Type type) {
		Property eAttribute = PivotFactory.eINSTANCE.createProperty();
		eAttribute.setName(name);
		eAttribute.setType(type);
		aClass.getOwnedAttributes().add(eAttribute);
		return eAttribute;
	}

	protected org.eclipse.ocl.examples.pivot.Class createOwnedClass(org.eclipse.ocl.examples.pivot.Package aPackage, String name, boolean isAbstract) {
		org.eclipse.ocl.examples.pivot.Class eClass = PivotFactory.eINSTANCE.createClass();
		eClass.setName(name);
		eClass.setIsAbstract(isAbstract);
		aPackage.getOwnedTypes().add(eClass);
		return eClass;
	}

	protected Enumeration createOwnedEnumeration(org.eclipse.ocl.examples.pivot.Package aPackage, String name) {
		Enumeration eEnum = PivotFactory.eINSTANCE.createEnumeration();
		eEnum.setName(name);
		aPackage.getOwnedTypes().add(eEnum);
		return eEnum;
	}

	protected EnumerationLiteral createOwnedLiteral(Enumeration anEnumeration, String name) {
		EnumerationLiteral eLiteral = PivotFactory.eINSTANCE.createEnumerationLiteral();
		eLiteral.setName(name);
		anEnumeration.getOwnedLiterals().add(eLiteral);
		return eLiteral;
	}

	protected Operation createOwnedOperation(org.eclipse.ocl.examples.pivot.Class aClass, String name, List<String> paramNames, List<Type> paramTypes, Type type, boolean isQuery) {
		Operation eOperation = PivotFactory.eINSTANCE.createOperation();
		eOperation.setName(name);
		eOperation.setType(type);
		if (paramNames != null) {
			for (int i = 0; i < paramNames.size(); i++) {
				createOwnedParameter(eOperation, paramNames.get(i), paramTypes.get(i));
			}
		}
		aClass.getOwnedOperations().add(eOperation);
		return eOperation;
	}

	protected Parameter createOwnedParameter(Operation eOperation, String name, Type type) {
		Parameter eParameter = PivotFactory.eINSTANCE.createParameter();
		eParameter.setName(name);
		eParameter.setType(type);
		eOperation.getOwnedParameters().add(eParameter);
		return eParameter;
	}

	protected Operation createOwnedPrimitiveOperation(Type aPrimitiveType, String name, EList<String> paramNames, EList<Type> paramTypes, Type type, boolean isQuery) {
		return createOwnedOperation((org.eclipse.ocl.examples.pivot.Class) aPrimitiveType, name, paramNames, paramTypes, type, isQuery);
	}

	protected org.eclipse.ocl.examples.pivot.Class createOwnedPrimitiveType(org.eclipse.ocl.examples.pivot.Package aPackage, String name) {
		org.eclipse.ocl.examples.pivot.Class eClass = PivotFactory.eINSTANCE.createClass();
		eClass.setName(name);
		aPackage.getOwnedTypes().add(eClass);
		return eClass;
	}

	protected Property createOwnedReference(org.eclipse.ocl.examples.pivot.Class aClass, String name, org.eclipse.ocl.examples.pivot.Class type) {
		Property eReference = PivotFactory.eINSTANCE.createProperty();
		eReference.setName(name);
		eReference.setType(type);
		aClass.getOwnedAttributes().add(eReference);
		return eReference;
	}

	protected OCL createOCL() {
		Registry packageRegistry = resourceSet.getPackageRegistry();
		PivotEnvironmentFactory envFactory = new PivotEnvironmentFactory(packageRegistry, typeManager);
		return OCL.newInstance(envFactory);
	}

	protected org.eclipse.ocl.examples.pivot.Package createPackage(org.eclipse.ocl.examples.pivot.Package parentPackage, String name) {
		org.eclipse.ocl.examples.pivot.Package aPackage = typeManager.createPackage(name, null);
		if (parentPackage != null) {
			parentPackage.getNestedPackages().add(aPackage);
		}
		else {
			typeManager.installPackage(aPackage);
		}
		return aPackage;
	}
	
	protected ExpressionInOcl createPostcondition(Operation context, String text) {
		OCLHelper helper = ocl.createOCLHelper();
		helper.setOperationContext(context.getClass_(), context);
		
		ExpressionInOcl result = null;
		
		try {
			result = helper.createPostcondition(text);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Parse failed: " + e.getLocalizedMessage());
		}
		
		return result;
	}
	
	protected ExpressionInOcl createPrecondition(Operation context, String text) {
		OCLHelper helper = ocl.createOCLHelper();
		helper.setOperationContext(context.getClass_(), context);
		
		ExpressionInOcl result = null;
		
		try {
			result = helper.createPrecondition(text);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Parse failed: " + e.getLocalizedMessage());
		}
		
		return result;
	}
	
	protected ExpressionInOcl createQuery(org.eclipse.ocl.examples.pivot.Class context, String expression) {
		return assertQuery(context, expression);
	}
	
	protected ExpressionInOcl createQuery(
			EnvironmentFactory envFactory,
			Type context, String text) {
		
		OCL localOcl = OCL.newInstance(envFactory);
		OCLHelper helper = localOcl.createOCLHelper();
		helper.setContext(context);
		
		ExpressionInOcl result = null;
		
		try {
			result = helper.createQuery(text);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Parse failed: " + e.getLocalizedMessage());
		}
		
		return result;
	}
	
	public ResourceSet createResourceSet() {
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
			"ecore", new EcoreResourceFactoryImpl());
		resourceSet.getPackageRegistry().put(PivotPackage.eINSTANCE.getNsURI(), PivotPackage.eINSTANCE);
		return resourceSet;
	}

	protected void createVariableInEnvironment(String name, Type type) {
		Variable var = environment.getOCLFactory().createVariable();
        var.setName(name);
        var.setType(type);
        environment.addElement(var.getName(), var, true);
	}

	/**
	 * Replace every %xxx occurrence on expression by the binding-specific value of
	 * denormalization of xxx if defined or xxx otherwise.
	 */
	public String denormalize(String expression) {
		StringBuffer s = new StringBuffer();
		int iMax = expression.length();
		for (int i = 0; i < iMax; i++) {
			char c = expression.charAt(i);
			if (c == '%') {
				int iStart = ++i;
				for (; i < iMax; i++){
					c = expression.charAt(i);
					if (!Character.isLetterOrDigit(c)) {
						break;
					}
				}
				s.append(expression.substring(iStart, i));
//				String mapped = reflection.denormalize(key);
//				s.append(mapped != null ? mapped : key);
			}
			if (i < iMax)
				s.append(c);
				
		}
		return s.toString();
	}	
	
	protected void disposeResourceSet() {
        for (Resource res : resourceSet.getResources()) {
            res.unload();
            res.eAdapters().clear();
        }
        resourceSet.getResources().clear();
        resourceSet.eAdapters().clear();
        resourceSet = null;
		standardResources = null;
	}
	
	protected Object evaluate(String contextFreeExpression) {
		Object result = null;
		
		try {
			String document = denormalize("package %uml context %String" +
					" inv: " + contextFreeExpression +" endpackage");
			ExpressionInOcl expr = parse(document);
			
			result = evaluate(expr, "");
		} catch (Exception e) {
			fail("Evaluation failed: " + e.getLocalizedMessage());
		}
		
		return result;
	}

	protected Value evaluate(OCLHelper aHelper, Object context,
            String expression) throws ParserException {
		if (context instanceof EObject) {
			EClass eClass = ((EObject)context).eClass();
			Type pivotType = typeManager.getPivotType(eClass.getName());
			if (pivotType == null) {
				Resource resource = eClass.eResource();
				Ecore2Pivot ecore2Pivot = Ecore2Pivot.getAdapter(resource, typeManager);
				pivotType = ecore2Pivot.getCreated(Type.class, eClass);
			}
			aHelper.setContext(pivotType);
		}
		ExpressionInOcl query = aHelper.createQuery(expression);
//        @SuppressWarnings("unused")
//		String s = query.toString();
        try {
        	return ocl.evaluate(context, query);
        } finally {
			typeManager.getPivotResourceSet().getResources().remove(query.eResource());
		}
    }
	
	protected Object evaluate(ExpressionInOcl expr) {
		Object result = null;
		
		try {
			result = ocl.evaluate(null, expr);
		} catch (RuntimeException e) {
			fail("Evaluation failed: " + e.getLocalizedMessage());
		}
		
		return result;
	}
    
	protected Object evaluate(ExpressionInOcl expr, Object self) {
		Object result = null;
		
		try {
			result = ocl.evaluate(self, expr);
		} catch (RuntimeException e) {
			fail("Evaluation failed: " + e.getLocalizedMessage());
		}
		
		return result;
	}
	
	/**
	 * Retrieves the first {@link org.eclipse.uml2.uml.Property} with the specified '<em><b>Name</b></em>', and '<em><b>Type</b></em>' from the '<em><b>Attribute</b></em>' reference list.
	 * @param name The '<em><b>Name</b></em>' of the {@link org.eclipse.uml2.uml.Property} to retrieve, or <code>null</code>.
	 * @param type The '<em><b>Type</b></em>' of the {@link org.eclipse.uml2.uml.Property} to retrieve, or <code>null</code>.
	 * @return The first {@link org.eclipse.uml2.uml.Property} with the specified '<em><b>Name</b></em>', and '<em><b>Type</b></em>', or <code>null</code>.
	 */
	protected Property getAttribute(Type classifier, String name, Type type) {
		if (!(classifier instanceof org.eclipse.ocl.examples.pivot.Class))
			return null;
		Property feature = PivotUtil.getNamedElement(((org.eclipse.ocl.examples.pivot.Class)classifier).getOwnedAttributes(), name);
		if (feature == null)
			return null;
		// check type
		return feature;
	}

	public ClassifierType getClassifierType(Type type) {
		ClassifierType classifierType = typeManager.getClassifierType(type);
		typeManager.addLockedElement(classifierType);
		return classifierType;
	}
   
    /**
     * Obtains the diagnostic describing the problem in the last failed parse,
     * asserting that it is not <code>null</code>.
     * 
     * @return the diagnostic
     */
    protected Resource.Diagnostic getDiagnostic(Resource resource) {
    	org.eclipse.emf.ecore.resource.Resource.Diagnostic diagnostic = resource.getErrors().get(0);
		return diagnostic;
    }
    
	protected Type getMetaclass(String name) {
		return typeManager.getRequiredLibraryType(name);
	}
	
	protected Object getNull() {
		return valueFactory.getNull();
	}
	
	protected StandardLibrary getOCLStandardLibrary() {
		return ocl.getEnvironment().getOCLStandardLibrary();
	}
	
	public URI getTestModelURI(String localFileName) {
		String testPlugInId = getTestPlugInId();
		try {
			java.lang.Class<?> platformClass = java.lang.Class.forName("org.eclipse.core.runtime.Platform");
			Method getBundle = platformClass.getDeclaredMethod("getBundle", new java.lang.Class[] {String.class});
			Object bundle = getBundle.invoke(null, new Object[] {testPlugInId});
			
			if (bundle != null) {
				Method getEntry = bundle.getClass().getMethod("getEntry", new java.lang.Class[] {String.class});
				URL url = (URL) getEntry.invoke(bundle, new Object[] {localFileName});
				return URI.createURI(url.toString());
			}
		} catch (Exception e) {
			// not running in Eclipse
		}
		String urlString = System.getProperty(testPlugInId);
		if (urlString == null)
			TestCase.fail("'" + testPlugInId + "' property not defined; use the launch configuration to define it"); //$NON-NLS-2$
		return URI.createFileURI(urlString + "/" + localFileName);
	}

	public String getTestPlugInId() {
		return PLUGIN_ID;
	}
	
	protected Type getUMLBoolean() {
		return getOCLStandardLibrary().getBooleanType();
	}
	
	protected Type getUMLInteger() {
		return getOCLStandardLibrary().getIntegerType();
	}

	protected org.eclipse.ocl.examples.pivot.Package getUMLMetamodel() {
		return typeManager.getPivotMetaModel();
	}
	
	protected Type getUMLString() {
		return getOCLStandardLibrary().getStringType();
	}
	
	protected Type getUMLUnlimitedNatural() {
		return getOCLStandardLibrary().getUnlimitedNaturalType();
	}

	protected void initializeResourceSet() {
	    resourceSet = createResourceSet();
		standardResources = new ArrayList<Resource>(resourceSet.getResources());
	}
	
	/**
	 * Parses the specified <code>text</code>.
	 * 
	 * @param text the OCL text
	 * @return the OCL expression
	 */
	protected ExpressionInOcl parse(String text) {
		ExpressionInOcl result = parseUnvalidated(text);
		validate(result);
		
		assertValidToString(result);
		
		return result;
	}
	
	/**
	 * Parses the specified <code>text</code> as an OCL constraint.
	 * 
	 * @param text the OCL text
	 * @return the OCL constraint expression
	 */
	protected ExpressionInOcl parseConstraint(String text) {
		ExpressionInOcl result = parseConstraintUnvalidated(text);
		validate(result);
		
		assertValidToString(result);
		
		return result;
	}
	
	/**
	 * Parses the specified <code>text</code> as an OCL constraint, without
	 * validating it.
	 * 
	 * @param text the OCL text
	 * @return the OCL constraint expression, unvalidated
	 */
	protected ExpressionInOcl parseConstraintUnvalidated(String text) {
		throw new UnsupportedOperationException();
/*		List<Constraint> constraints;
		Constraint constraint = null;
		
		try {
			constraints = ocl.parse(new OCLInput(text));
			constraint = constraints.get(0);
		} catch (ParserException e) {
			fail("Parse failed: " + e.getLocalizedMessage());
		} catch (IllegalArgumentException e) {
			fail("Parse failed (illegal argument): " + e.getLocalizedMessage());
		}
		
		ExpressionInOcl result = null;
		result = (ExpressionInOcl) constraint.getSpecification();
		
		assertNotNull(result);
		
		assertValidToString(result);
		
		return result; */
	}
	
	/**
	 * Parses the specified <code>text</code> as a def expression.  This differs
	 * from the {@link #parse} method in not separating the expression from its
	 * constraint, which is critically important to the structure of the defined
	 * feature.
	 * 
	 * @param env the environment in which the operation or property is to be defined
	 * @param text the OCL text
	 * @return the OCL def expression
	 */
	protected ExpressionInOcl parseDef(String text) {
		throw new UnsupportedOperationException();
/*		List<Constraint> constraints ;
		Constraint constraint = null;
		
		try {
			constraints = ocl.parse(new OCLInput(text));
			constraint = constraints.get(0);
		} catch (ParserException e) {
			fail("Parse failed: " + e.getLocalizedMessage());
		} catch (IllegalArgumentException e) {
			fail("Parse failed (illegal argument): " + e.getLocalizedMessage());
		}
		
		ExpressionInOcl result = (ExpressionInOcl) constraint.getSpecification();		
		assertNotNull(result);
		validate(result);		
		assertValidToString(result);		
		return result; */
	}

	/**
	 * Parses the specified <code>text</code> without validating it.
	 * 
	 * @param text the OCL text
	 *    
	 * @return the OCL expression, unvalidated
	 */
	protected ExpressionInOcl parseUnvalidated(String text) {
		ExpressionInOcl result = parseConstraintUnvalidated(text);
		
		// forget the constraint because it interferes with validation
		EcoreUtil.remove(result);
		
		assertValidToString(result);
		
		return result;
	}

	/**
	 * Create a Resource to register a binding-dependent pkg for access with a given nsPrefix and nsUri.
	 */
	protected org.eclipse.ocl.examples.pivot.Package registerPackage(org.eclipse.ocl.examples.pivot.Package pkg, String nsPrefix, String nsUri) {
		pkg.setNsPrefix(nsPrefix);
        pkg.setNsURI(nsUri);
		Resource resource = new ResourceImpl(URI.createURI(nsUri));
        resource.getContents().add(pkg);
        resourceSet.getResources().add(resource);					// FIXME UML needs this
        resourceSet.getPackageRegistry().put(nsUri, pkg);			//  whereas Ecore needs this
        return pkg;
	}
	
	@Override
    protected void setUp() {
//    	System.out.println("-----Starting " + getClass().getSimpleName() + "." + getName() + "-----");
		Logger rootLogger = Logger.getRootLogger();
//		rootLogger.setLevel(Level.TRACE);
		rootLogger.addAppender(new TestCaseAppender());
//		rootLogger.removeAppender("default");
		OCLstdlib.install();
		EssentialOCLStandaloneSetup.doSetup();
		typeManager = new TypeManager();
		valueFactory = typeManager.getValueFactory();
		if ((resourceSet != null) && DISPOSE_RESOURCE_SET) {
        	disposeResourceSet();
        }
		if (!initialized) {
			noDebug = System.getProperty(getTestPlugInId() + ".nodebug") != null;
			if (!eclipseIsRunning()) {
				initializeStandalone();
			}
		}		
		if (resourceSet == null) {
			initializeResourceSet();
		}
//		debugPrintln("==> Start  " + getName());
		ocl = createOCL();
		environment = ocl.getEnvironment();
//		reflection = staticReflection.createReflection(environment);
		String repairs = System.getProperty(getTestPlugInId() + ".repairs");
		if (repairs != null)
			ocl.setParserRepairCount(Integer.parseInt(repairs));
//        ocl.setParseTracingEnabled(true);
//        ocl.setEvaluationTracingEnabled(true);
		
		helper = createHelper();
	}

	@Override
    protected void tearDown()
		throws Exception {
		TypeManagerResourceSetAdapter rsAdapter = TypeManagerResourceSetAdapter.findAdapter(resourceSet);
		if (rsAdapter != null) {
			resourceSet.eAdapters().remove(rsAdapter);
		}
		//
		//	Unload any resources that a test may have loaded.
		//
		for (ListIterator<Resource> i = resourceSet.getResources().listIterator(); i.hasNext(); ) {
			Resource res = i.next();
			if (!standardResources.contains(res)) {
				i.remove();
				res.unload();
                res.eAdapters().clear();
			}				
		}
		//
		//	Null out any references that a test may have left behind, so that unwanted
		//	objects are not locked into memory.
		//
		for (java.lang.Class<?> aClass = getClass(); PivotTestSuite.class.isAssignableFrom(aClass); aClass = aClass.getSuperclass()) {
			for (Field field : aClass.getDeclaredFields()) {
				int modifiers = field.getModifiers();
				if (Modifier.isFinal(modifiers)) {
				}
				else if (!Modifier.isStatic(modifiers)) {
					java.lang.Class<?> fieldType = field.getType();
					if (Object.class.isAssignableFrom(fieldType)) {
						String fieldName = field.getName();
						try {
							String tearDownName = "tearDown_" + fieldName;
							Method method = aClass.getDeclaredMethod(tearDownName);
							try {
								tearDownUsing(method);
							} catch (Exception e) {
								// tearDown_xxx must be public
								fail("Failed to invoke " + getClass().getSimpleName() + "." + tearDownName + " : " + e);  //$NON-NLS-2$//$NON-NLS-3$
							}
						}
						catch (NoSuchMethodException e) {
							try {
								tearDownField(field);
							} catch (Exception e1) {
								// xxx without a tearDown_xxx must be public to ensure that leakage can be stopped
								fail("Failed to set " + getClass().getSimpleName() + "." + fieldName + " to null : " + e1); //$NON-NLS-2$ //$NON-NLS-3$
							}
						}
					}
				} else {
					tearDownStatic(aClass, field);
				}
			}
		}
		
//		debugPrintln("==> Finish " + getName());
	}

	protected void tearDownField(Field field) throws IllegalAccessException {
		field.set(this, null);
	}

	protected void tearDownStatic(java.lang.Class<?> aClass, Field field) {
		if (aClass != PivotTestSuite.class) {
			// Tests may not have statics since they are prone to memory leakage
			fail("static test variable:" + field); 
		}
	}

	protected void tearDownUsing(Method method)
			throws IllegalAccessException, InvocationTargetException {
		method.invoke(this);
	}

	protected void tearDown_ocl() {
		ocl.dispose();
		ocl = null;
		typeManager = null;
		valueFactory = null;
	}
    
    /**
     * Validates an OCL expression, asserting that it is valid.
     * 
     * @param expr the OCL expression to validate
     * @param env an environment to use for validation
     */
    protected void validate(Constraint constraint) {
        try {
            ocl.validate(constraint);
        } catch (SemanticException e) {
            fail("Validation failed: " + e.getLocalizedMessage());
        }
    }
    
	/**
	 * Validates an OCL expression, asserting that it is valid.
	 * 
	 * @param expr the OCL expression to validate
	 * @param env an environment to use for validation
	 */
	protected void validate(ExpressionInOcl expr) {
		try {
			EObject eContainer = expr.eContainer();
			if ((eContainer != null)
					&& Constraint.class.isAssignableFrom(eContainer.eContainer().getClass())) {
				// start validation from the constraint, for good measure
				Constraint eContainerContainer = (Constraint) eContainer.eContainer();
				validate(eContainerContainer);
			} else {
				ocl.validate(expr.getBodyExpression());
			}
		} catch (SemanticException e) {
			fail("Validation failed: " + e.getLocalizedMessage());
		}
	}
}
