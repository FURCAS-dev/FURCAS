/**
 * <copyright>
 * 
 * Copyright (c) 2005, 2009 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   Zeligsoft - Bugs 243079, 244948, 244886, 245619
 *   Ed Willink - Bug 254919
 *   Obeo - Bug 291310
 *
 * </copyright>
 *
 * $Id: GenericTestSuite.java,v 1.2 2009/12/06 09:11:16 ewillink Exp $
 */

package org.eclipse.ocl.tests;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.EnvironmentFactory;
import org.eclipse.ocl.OCL;
import org.eclipse.ocl.OCLInput;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.SemanticException;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.helper.Choice;
import org.eclipse.ocl.helper.ChoiceKind;
import org.eclipse.ocl.helper.OCLHelper;
import org.eclipse.ocl.lpg.ProblemHandler;
import org.eclipse.ocl.parser.OCLProblemHandler;
import org.eclipse.ocl.types.OCLStandardLibrary;
import org.eclipse.ocl.util.OCLUtil;
import org.eclipse.ocl.utilities.Visitable;

/**
 * Default test framework.
 *
 * @author Christian W. Damus (cdamus)
 */
@SuppressWarnings("nls")
public abstract class GenericTestSuite<E extends EObject, PK extends E, T extends E, C extends T, CLS extends C, DT extends C, PT extends C, ET extends DT, O extends E, PM extends E, P extends E, PA extends P, PR extends P, EL, S, COA, SSA, CT>
	extends TestCase {

	// set this variable true when testing for memory leaks
    private static boolean DISPOSE_RESOURCE_SET = false;
	
    protected static final class CheckedTestSuite extends TestSuite {

		public CheckedTestSuite(String name) {
			super(name);
		}

		public void createTestSuite(Class<? extends GenericTestSuite> testClass, String testName) {
	        addTest(new TestSuite(testClass, testName));
		}

		public void addTestSuite(CheckedTestSuite suite) {
	        addTest(suite);
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

	public static void initializeStandalone() {
		if (initialized)
			return;
		initialized = true;
	}

	protected TestReflection.Static<E, PK, T, C, CLS, DT, PT, ET, O, PM, P, PA, PR, EL, S, COA, SSA, CT> staticReflection;
	protected OCL<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> ocl;
	protected Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> environment;
	protected TestReflection<E, PK, T, C, CLS, DT, PT, ET, O, PM, P, PA, PR, EL, S, COA, SSA, CT> reflection;
	protected OCLHelper<C, O, P, CT> helper;
	
	/**
	 * Asserts that the specified choice is to be found in the collection of
	 * <code>choices</code>.
	 * 
	 * @param choices a collection of {@link Choice}s
	 * @param kind the kind of choice to find
	 * @param name the name of the choice to find
	 */
	protected void assertChoice(Collection<Choice> choices, ChoiceKind kind, String name) {
		assertNotNull("Choice not found: " + name + ", " + kind, //$NON-NLS-2$
			findChoice(choices, kind, name));
	}
	
	protected void assertInvalid(Object value) {
		assertTrue("Expected invalid", ocl.isInvalid(value));
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
    protected void assertNoException(Diagnostic diagnostic, java.lang.Class<? extends Throwable> excType) {
    	if (excType.isInstance(diagnostic.getException())) {
    		fail("Diagnostic signals a(n) " + excType.getSimpleName());
    	}
    	
    	for (Diagnostic nested : diagnostic.getChildren()) {
    		assertNoException(nested, excType);
    	}
    }
	
	/**
	 * Asserts that the specified choice is <em>not</em> to be found in the
	 * collection of <code>choices</code>.
	 * 
	 * @param choices a collection of {@link Choice}s
	 * @param kind the kind of choice not to find
	 * @param name the name of the choice not to find
	 */
	protected void assertNotChoice(Collection<Choice> choices, ChoiceKind kind, String name) {
		assertNull("Choice found: " + name + ", " + kind, //$NON-NLS-2$
			findChoice(choices, kind, name));
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
			OCLExpression<C> expr = parse(
					"package " + reflection.getModelPackageName() +
					" context " + reflection.getStringTypeName() +
					" inv: " + contextFreeExpression +
					" endpackage");
			
			result = check(expr, "");
		} catch (Exception e) {
			fail("Check failed: " + e.getLocalizedMessage());
		}
		
		return result;
	}
    
    protected boolean check(OCLHelper<C, O, P, CT> aHelper, Object context,
            String expression) throws ParserException {
        
        CT constraint = aHelper.createInvariant(expression);
        return ocl.check(context, constraint);
    }
	
	protected boolean check(OCLExpression<C> expr, Object self) {
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
	
	protected OCLExpression<C> createBodyCondition(O context, String text) {
		OCLHelper<C, O, P, CT> helper =
			ocl.createOCLHelper();
		helper.setOperationContext(reflection.getOwner(context), context);
		
		OCLExpression<C> result = null;
		
		try {
			result = getBodyExpression(helper.createBodyCondition(text));
		} catch (Exception e) {
			e.printStackTrace();
			fail("Parse failed: " + e.getLocalizedMessage());
		}
		
		return result;
	}

	protected void createDocument(String text) {
		try {
			ocl
                .parse(new OCLInput(
                    text));
        } catch (Exception e) {
            fail("Failed to parse: " + e.getLocalizedMessage());
        }
	}

	protected OCLHelper<C, O, P, CT> createHelper() {
		return ocl.createOCLHelper();
	}
	
	protected OCLExpression<C> createInvariant(C context, String text) {
		OCLHelper<C, O, P, CT> helper =
			ocl.createOCLHelper();
		helper.setContext(context);
		
		OCLExpression<C> result = null;
		
		try {
			result = getBodyExpression(helper.createInvariant(text));
		} catch (Exception e) {
//			e.printStackTrace();
			fail("Parse failed: " + e.getLocalizedMessage());
		}
		
		return result;
	}

	protected OCL<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> createOCL() {
		return staticReflection.createOCL(resourceSet);
	}
	
	protected OCLExpression<C> createPostcondition(O context, String text) {
		OCLHelper<C, O, P, CT> helper =
			ocl.createOCLHelper();
		helper.setOperationContext(reflection.getOwner(context), context);
		
		OCLExpression<C> result = null;
		
		try {
			result = getBodyExpression(helper.createPostcondition(text));
		} catch (Exception e) {
			e.printStackTrace();
			fail("Parse failed: " + e.getLocalizedMessage());
		}
		
		return result;
	}
	
	protected OCLExpression<C> createPrecondition(O context, String text) {
		OCLHelper<C, O, P, CT> helper =
			ocl.createOCLHelper();
		helper.setOperationContext(reflection.getOwner(context), context);
		
		OCLExpression<C> result = null;
		
		try {
			result = getBodyExpression(helper.createPrecondition(text));
		} catch (Exception e) {
			e.printStackTrace();
			fail("Parse failed: " + e.getLocalizedMessage());
		}
		
		return result;
	}
	
	protected OCLExpression<C> createQuery(CLS context, String text) {
		OCLHelper<C, O, P, CT> helper = ocl.createOCLHelper();
		helper.setContext(context);
		
		OCLExpression<C> result = null;
		
		try {
			result = helper.createQuery(text);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Parse failed: " + e.getLocalizedMessage());
		}
		
		return result;
	}
	
	protected OCLExpression<C> createQuery(
			EnvironmentFactory<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> envFactory,
			C context, String text) {
		
		OCL<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> localOcl = OCL.newInstance(envFactory);
		OCLHelper<C, O, P, CT> helper = localOcl.createOCLHelper();
		helper.setContext(context);
		
		OCLExpression<C> result = null;
		
		try {
			result = helper.createQuery(text);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Parse failed: " + e.getLocalizedMessage());
		}
		
		return result;
	}

	protected void createVariableInEnvironment(String name, C type) {
		Variable<C, PM> var = environment.getOCLFactory().createVariable();
        var.setName(name);
        var.setType(type);
        environment.addElement(var.getName(), var, true);
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
			OCLExpression<C> expr = parse(
					"package " + reflection.getModelPackageName() +
						" context " + reflection.getStringTypeName() +
					" inv: " + contextFreeExpression +
					" endpackage");
			
			result = evaluate(expr, "");
		} catch (Exception e) {
			fail("Evaluation failed: " + e.getLocalizedMessage());
		}
		
		return result;
	}

	protected Object evaluate(OCLHelper<C, O, P, CT> aHelper,
            Object context,
            String expression) throws ParserException {
        
        OCLExpression<C> query = aHelper.createQuery(expression);
        return ocl.evaluate(context, query);
    }
	
	protected Object evaluate(OCLExpression<C> expr) {
		Object result = null;
		
		try {
			result = ocl.evaluate(null, expr);
		} catch (RuntimeException e) {
			fail("Evaluation failed: " + e.getLocalizedMessage());
		}
		
		return result;
	}
    
	protected Object evaluate(OCLExpression<C> expr, Object self) {
		Object result = null;
		
		try {
			result = ocl.evaluate(self, expr);
		} catch (RuntimeException e) {
			fail("Evaluation failed: " + e.getLocalizedMessage());
		}
		
		return result;
	}
	
	protected Choice findChoice(Collection<Choice> choices, ChoiceKind kind, String name) {
		Choice result = null;
		
		for (Choice c : choices) {
			if (c.getKind() == kind && name.equals(c.getName())) {
				result = c;
				break;
			}
		}
		
		return result;
	}
	
	protected OCLExpression<C> getBodyExpression(CT constraint) {
		return reflection.getBodyExpression(constraint);
	}
    
    /**
     * Obtains the diagnostic describing the problem in the last failed parse,
     * asserting that it is not <code>null</code>.
     * 
     * @return the diagnostic
     */
    protected Diagnostic getDiagnostic() {
    	OCLProblemHandler handler = (OCLProblemHandler) OCLUtil.getAdapter(
    		ocl.getEnvironment(), ProblemHandler.class);
    	
    	Diagnostic result = handler.getDiagnostic();
    	if (result == null) {
    		result = helper.getProblems();
    	}
    	
    	assertNotNull("No diagnostic", result);
    	
    	return result;
    }
	
    protected PT getEcoreBigDecimal() {
    	return reflection.getEcoreBigDecimal();
    }
	
    protected PT getEcoreBigInteger() {
    	return reflection.getEcoreBigInteger();
    }
	
    protected PT getEcoreLong() {
    	return reflection.getEcoreLong();
    }
	
	protected Object getInvalid() {
		return getOCLStandardLibrary().getInvalid();
	}
    
	protected C getMetaclass(String name) {
		return reflection.getMetaclass(name);
	}
	
	protected OCLStandardLibrary<C> getOCLStandardLibrary() {
		return ocl.getEnvironment().getOCLStandardLibrary();
	}

	abstract protected TestReflection.Static<E, PK, T, C, CLS, DT, PT, ET, O, PM, P, PA, PR, EL, S, COA, SSA, CT> getStaticReflection();
	
	public URI getTestModelURI(String localFileName) {
		String testPlugInId = staticReflection.getTestPlugInId();
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
	
	protected PT getUMLBoolean() {
		return reflection.getUMLBoolean();
	}
	
	protected PT getUMLInteger() {
		return reflection.getUMLInteger();
	}

	protected PK getUMLMetamodel() {
		return reflection.getUMLMetamodel();
	}
	
	protected PT getUMLString() {
		return reflection.getUMLString();
	}
	
	protected PT getUMLUnlimitedNatural() {
		return reflection.getUMLUnlimitedNatural();
	}

	protected void initializeResourceSet() {
	    resourceSet = staticReflection.createResourceSet();
		standardResources = new ArrayList<Resource>(resourceSet.getResources());
	}
	
	/**
	 * Parses the specified <code>text</code>.
	 * 
	 * @param text the OCL text
	 * @return the OCL expression
	 */
	protected OCLExpression<C> parse(String text) {
		OCLExpression<C> result = parseUnvalidated(text);
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
	protected OCLExpression<C> parseConstraint(String text) {
		OCLExpression<C> result = parseConstraintUnvalidated(text);
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
	protected OCLExpression<C> parseConstraintUnvalidated(String text) {
		List<CT> constraints;
		CT constraint = null;
		
		try {
			constraints = ocl.parse(new OCLInput(text));
			constraint = constraints.get(0);
		} catch (ParserException e) {
			fail("Parse failed: " + e.getLocalizedMessage());
		} catch (IllegalArgumentException e) {
			fail("Parse failed (illegal argument): " + e.getLocalizedMessage());
		}
		
		OCLExpression<C> result = null;
		result = getBodyExpression(constraint);
		
		assertNotNull(result);
		
		assertValidToString(result);
		
		return result;
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
	protected OCLExpression<C> parseDef(String text) {
		List<CT> constraints ;
		CT constraint = null;
		
		try {
			constraints = ocl.parse(new OCLInput(text));
			constraint = constraints.get(0);
		} catch (ParserException e) {
			fail("Parse failed: " + e.getLocalizedMessage());
		} catch (IllegalArgumentException e) {
			fail("Parse failed (illegal argument): " + e.getLocalizedMessage());
		}
		
		OCLExpression<C> result = null;
		result = getBodyExpression(constraint);
		
		validate(result);
		
		assertNotNull(result);
		
		assertValidToString(result);
		
		return result;
	}

	/**
	 * Parses the specified <code>text</code> without validating it.
	 * 
	 * @param text the OCL text
	 *    
	 * @return the OCL expression, unvalidated
	 */
	protected OCLExpression<C> parseUnvalidated(String text) {
		OCLExpression<C> result = parseConstraintUnvalidated(text);
		
		// forget the constraint because it interferes with validation
		EcoreUtil.remove(result);
		
		assertValidToString(result);
		
		return result;
	}
	
	@Override
    protected void setUp() {
		staticReflection = getStaticReflection();
		if ((resourceSet != null) && DISPOSE_RESOURCE_SET) {
        	disposeResourceSet();
        }
		if (!initialized) {
			noDebug = System.getProperty(staticReflection.getTestPlugInId() + ".nodebug") != null;
			boolean isRunning = false;
			try {
				Class<?> platformClass = Class.forName("org.eclipse.core.runtime.Platform");
				Method isRunningMethod = platformClass.getDeclaredMethod("isRunning");
				isRunning = Boolean.TRUE.equals(isRunningMethod.invoke(null));
			} catch (Exception e) {
			}
			if (!isRunning) {
				initializeStandalone();
			}
		}		
		if (resourceSet == null) {
			initializeResourceSet();
		}
		debugPrintln("==> Start  " + getName());
		ocl = createOCL();
		environment = ocl.getEnvironment();
		reflection = staticReflection.createReflection(environment);
		String repairs = System.getProperty(staticReflection.getTestPlugInId() + ".repairs");
		if (repairs != null)
			ocl.setParserRepairCount(Integer.parseInt(repairs));
//        ocl.setParseTracingEnabled(true);
//        ocl.setEvaluationTracingEnabled(true);
		
		helper = createHelper();
	}

	@Override
    protected void tearDown()
		throws Exception {
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
		for (java.lang.Class<?> aClass = getClass(); GenericTestSuite.class.isAssignableFrom(aClass); aClass = aClass.getSuperclass()) {
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
		
		debugPrintln("==> Finish " + getName());
	}

	protected void tearDownField(Field field) throws IllegalAccessException {
		field.set(this, null);
	}

	protected void tearDownStatic(java.lang.Class<?> aClass, Field field) {
		if (aClass != GenericTestSuite.class) {
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
	}
    
    /**
     * Validates an OCL expression, asserting that it is valid.
     * 
     * @param expr the OCL expression to validate
     * @param env an environment to use for validation
     */
    protected void validate(CT constraint) {
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
	protected void validate(OCLExpression<C> expr) {
		try {
			EObject eContainer = expr.eContainer();
			if ((eContainer != null)
					&& reflection.getConstraintClass().isAssignableFrom(eContainer.eContainer().getClass())) {
				// start validation from the constraint, for good measure
				@SuppressWarnings("unchecked")
				CT eContainerContainer = (CT) eContainer.eContainer();
				validate(eContainerContainer);
			} else {
				ocl.validate(expr);
			}
		} catch (SemanticException e) {
			fail("Validation failed: " + e.getLocalizedMessage());
		}
	}
}
