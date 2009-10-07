/**
 * <copyright>
 * 
 * Copyright (c) 2005, 2008 IBM Corporation, Zeligsoft Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   Zeligsoft - Bugs 243079, 244948, 244886, 245619
 *
 * </copyright>
 *
 * $Id: AbstractTestSuite.java,v 1.20 2009/10/07 20:39:28 ewillink Exp $
 */

package org.eclipse.ocl.ecore.tests;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.ocl.EnvironmentFactory;
import org.eclipse.ocl.OCLInput;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.SemanticException;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.EcoreEnvironment;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.ecore.internal.OCLFactoryImpl;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.helper.Choice;
import org.eclipse.ocl.helper.ChoiceKind;
import org.eclipse.ocl.helper.OCLHelper;
import org.eclipse.ocl.lpg.ProblemHandler;
import org.eclipse.ocl.parser.OCLProblemHandler;
import org.eclipse.ocl.types.OCLStandardLibrary;
import org.eclipse.ocl.util.OCLUtil;
import org.eclipse.ocl.utilities.OCLFactory;
import org.eclipse.ocl.utilities.Visitable;


/**
 * Mini-framework for the OCL tests.
 *
 * @author Christian W. Damus (cdamus)
 */
public abstract class AbstractTestSuite
	extends TestCase {
	
    protected static final class CheckedTestSuite extends TestSuite {

		public CheckedTestSuite(String name) {
			super(name);
		}

		public void createTestSuite(Class<? extends AbstractTestSuite> testClass, String testName) {
	        addTest(new TestSuite(testClass, testName));
		}

		public void addTestSuite(CheckedTestSuite suite) {
	        addTest(suite);
		}
	}

	// set this variable true when testing for memory leaks
    private static boolean DISPOSE_RESOURCE_SET = false;

	protected static final org.eclipse.ocl.ecore.EcorePackage ocltypes =
        org.eclipse.ocl.ecore.EcorePackage.eINSTANCE;
	protected static final EcorePackage ecore = EcorePackage.eINSTANCE;

	protected static ResourceSet resourceSet;
	private static ArrayList<Resource> standardResources;
	
	private static void disposeResourceSet() {
        for (Resource res : resourceSet.getResources()) {
            res.unload();
            res.eAdapters().clear();
        }
        resourceSet.getResources().clear();
        resourceSet.eAdapters().clear();
        resourceSet = null;
		standardResources = null;
	}

	protected static void initializeResourceSet() {
	    resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
			"ecore", new EcoreResourceFactoryImpl()); //$NON-NLS-1$
		resourceSet.getPackageRegistry().put(EcorePackage.eINSTANCE.getNsURI(), EcorePackage.eINSTANCE);
		//
		standardResources = new ArrayList<Resource>(resourceSet.getResources());
	}
	
	protected EPackage fruitPackage;
	protected EFactory fruitFactory;
	
	protected EClass fruit;
	protected EOperation fruit_ripen;
	protected EOperation fruit_preferredColor;
	protected EOperation fruit_newFruit;
	protected EOperation fruit_setColor;
	protected EAttribute fruit_color;
	
	protected EClass apple;
	protected EAttribute apple_label;
	protected EReference apple_stem;
	protected EOperation apple_labelOper;
	protected EOperation apple_newApple;
	
	protected EClass stem;
	
	protected EEnum color;
	protected EEnumLiteral color_black;
	protected EEnumLiteral color_red;
	protected EEnumLiteral color_green;
	protected EEnumLiteral color_yellow;
	protected EEnumLiteral color_orange;
	protected EEnumLiteral color_brown;
	protected EEnumLiteral color_pink;
	
	protected EClass util;
	protected EReference util_orderedSet;
	protected EReference util_set;
	protected EReference util_bag;
	protected EReference util_sequence;
	protected EOperation util_processOrderedSet;
	protected EOperation util_processSet;
	protected EOperation util_processBag;
	protected EOperation util_processSequence;
	
	protected OCL ocl;
	protected OCLHelper<EClassifier, EOperation, EStructuralFeature, Constraint>
	helper;
	protected final OCLFactory oclFactory = OCLFactoryImpl.INSTANCE;

	/**
	 * Set this true to suppress a failure from modifying the fruitPackage
	 */
	protected boolean expectModified = false;
	
	public static URI getTestModelURI(String localFileName) {
		String testPlugInId = "org.eclipse.ocl.ecore.tests"; //$NON-NLS-1$
		try {
			Class<?> platformClass = Class.forName("org.eclipse.core.runtime.Platform"); //$NON-NLS-1$
			Method getBundle = platformClass.getDeclaredMethod("getBundle", new Class[] {String.class}); //$NON-NLS-1$
			Object bundle = getBundle.invoke(null, new Object[] {testPlugInId});
			
			if (bundle != null) {
				Method getEntry = bundle.getClass().getMethod("getEntry", new Class[] {String.class}); //$NON-NLS-1$
				URL url = (URL) getEntry.invoke(bundle, new Object[] {localFileName});
				return URI.createURI(url.toString());
			}
		} catch (Exception e) {
			// not running in Eclipse
		}
		String urlString = System.getProperty(testPlugInId);
		if (urlString == null)
			TestCase.fail("'" + testPlugInId + "' property not defined; use the launch configuration to define it"); //$NON-NLS-1$ //$NON-NLS-2$
		return URI.createFileURI(urlString + "/" + localFileName); //$NON-NLS-1$
	}

	private static boolean initialized = false;

	public static void initializeStandalone() {
		if (initialized)
			return;
		initialized = true;
	}

	/**
	 * Creates the test suite.
	 * 
	 * @return the suite
	 */
	public static Test suite() {
		CheckedTestSuite result = new CheckedTestSuite("OCL Tests for Ecore Metamodel"); //$NON-NLS-1$
		
		result.createTestSuite(BasicOCLTest.class, "Basic Tests"); //$NON-NLS-1$
		result.createTestSuite(KeywordsTest.class, "OCL Keyword Tests"); //$NON-NLS-1$
		result.createTestSuite(ComparisonTest.class, "Comparison/Ordering Tests"); //$NON-NLS-1$
        result.createTestSuite(PrimitiveTypesTest.class, "Primitive Type Tests"); //$NON-NLS-1$
        result.createTestSuite(PredefinedSuperTypeInheritedOperationTest.class,
        	"Inheritance of additional operations"); //$NON-NLS-1$
		result.createTestSuite(CollectionsTest.class, "Collection Type Tests"); //$NON-NLS-1$
		result.createTestSuite(IteratorsTest.class, "Iterator Tests"); //$NON-NLS-1$
		result.createTestSuite(TuplesTest.class, "Tuple Tests"); //$NON-NLS-1$
		result.createTestSuite(AssociationTest.class, "Association Tests"); //$NON-NLS-1$
		result.createTestSuite(StatesTest.class, "State Expression Tests"); //$NON-NLS-1$
		result.createTestSuite(MessagesTest.class, "Message Expression Tests"); //$NON-NLS-1$
		result.createTestSuite(InvariantConstraintsTest.class, "Invariant Constraints"); //$NON-NLS-1$
		result.createTestSuite(OperationConstraintsTest.class, "Operation Constraints"); //$NON-NLS-1$
		result.createTestSuite(LocationInformationTest.class, "Location Information Tests"); //$NON-NLS-1$
		result.createTestSuite(DefExpressionTest.class, "Def Expression Tests"); //$NON-NLS-1$
		result.createTestSuite(OCLOperationCollisionTest.class,
			"Collision with OCL Standard Operation"); //$NON-NLS-1$
		result.createTestSuite(FeatureRedefinitionTest.class, "Feature redefinition tests"); //$NON-NLS-1$
		result.createTestSuite(InitOrDerExpressionTest.class, "Initial and Derivation Expression Tests"); //$NON-NLS-1$
		result.createTestSuite(OCLDocumentTest.class, "OCL Document Parsing Tests"); //$NON-NLS-1$
		result.createTestSuite(AbstractVisitorTest.class, "AbstractVisitor Tests"); //$NON-NLS-1$
		result.createTestSuite(TypeConformanceTests.class, "Primitive Type Conformance Tests"); //$NON-NLS-1$
		result.addTestSuite(org.eclipse.ocl.ecore.helper.tests.AbstractTestSuite.suite());
		result.createTestSuite(RegressionTest.class, "Regression Tests"); //$NON-NLS-1$
		result.createTestSuite(EcoreEnvironmentTest.class, "Ecore Environment Tests"); //$NON-NLS-1$
        result.createTestSuite(ExtensibilityTest.class, "Extensibility Tests"); //$NON-NLS-1$
		result.createTestSuite(ValidationTest.class, "Expression Validation Tests"); //$NON-NLS-1$
		result.createTestSuite(ProblemOptionTest.class, "Problem Option Tests"); //$NON-NLS-1$
		result.createTestSuite(ParsingOptionsTest.class, "Parsing Options Tests"); //$NON-NLS-1$
		result.createTestSuite(TypesValidatorTest.class, "Types Validator Tests"); //$NON-NLS-1$
		result.createTestSuite(ExpressionsValidatorTest.class, "Expressions Validator Tests"); //$NON-NLS-1$
		result.createTestSuite(SerializationTest.class, "Serialization Tests"); //$NON-NLS-1$
		result.createTestSuite(EvaluationHaltedTest.class, "Ecore Halted Evaluation Tests"); //$NON-NLS-1$
		
		return result;
	}
	
	//
	// Framework methods
	//
	
	@Override
    protected void setUp() {
		
		System.out.println("==> Start  " + getName()); //$NON-NLS-1$
		
        if ((resourceSet != null) && DISPOSE_RESOURCE_SET) {
        	disposeResourceSet();
        }
		if (!initialized) {
			boolean isRunning = false;
			try {
				Class<?> platformClass = Class.forName("org.eclipse.core.runtime.Platform"); //$NON-NLS-1$
				Method isRunningMethod = platformClass.getDeclaredMethod("isRunning"); //$NON-NLS-1$
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
		initFruitPackage();
		
		assertSame(
			fruitPackage,
			resourceSet.getPackageRegistry().getEPackage(fruitPackage.getNsURI()));
		assertSame(
			fruitPackage,
			EcoreEnvironment.findPackage(Collections.singletonList(fruitPackage.getName()), resourceSet.getPackageRegistry()));

		ocl = createOCL();
//        ocl.setParseTracingEnabled(true);
//        ocl.setEvaluationTracingEnabled(true);
		
		helper = createHelper();
	}
	
	protected OCL createOCL() {
		OCL newInstance = OCL.newInstance(new EcoreEnvironmentFactory(resourceSet.getPackageRegistry()));
		String repairs = System.getProperty("org.eclipse.ocl.ecore.tests.repairs"); //$NON-NLS-1$
		if (repairs != null)
			newInstance.setParserRepairCount(Integer.parseInt(repairs));
		return newInstance;
	}
	
	protected OCLHelper<EClassifier, EOperation, EStructuralFeature, Constraint>
	createHelper() {
		return ocl.createOCLHelper();
	}
	
	@Override
    protected void tearDown()
		throws Exception {
		final Resource resource = fruitPackage.eResource();
		final boolean isModified = resource.isModified();
		final boolean expectIsModified = expectModified;
		//
		//	Unload any resources that a test may have loaded.
		//
		for (ListIterator<Resource> i = resourceSet.getResources().listIterator(); i.hasNext(); ) {
			Resource res = i.next();
			if (((res == resource) && isModified) || !standardResources.contains(res)) {
				i.remove();
				res.unload();
                res.eAdapters().clear();
			}				
		}
		//
		//	Null out any references that a test may have left behind, so that unwanted
		//	objects are not locked into memory.
		//
		for (java.lang.Class<?> aClass = getClass(); AbstractTestSuite.class.isAssignableFrom(aClass); aClass = aClass.getSuperclass()) {
			for (Field field : aClass.getDeclaredFields()) {
				int modifiers = field.getModifiers();
				if (Modifier.isFinal(modifiers)) {
				}
				else if (!Modifier.isStatic(modifiers)) {
					java.lang.Class<?> fieldType = field.getType();
					if (Object.class.isAssignableFrom(fieldType)) {
						String fieldName = field.getName();
						try {
							String tearDownName = "tearDown_" + fieldName; //$NON-NLS-1$
							Method method = aClass.getDeclaredMethod(tearDownName);
							try {
								method.invoke(this);
							} catch (Exception e) {
								// tearDown_xxx must be public
								fail("Failed to invoke " + getClass().getSimpleName() + "." + tearDownName + " : " + e);   //$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$
							}
						}
						catch (NoSuchMethodException e) {
							try {
								field.set(this, null);
							} catch (Exception e1) {
								// xxx without a tearDown_xxx must be public to ensure that leakage can be stopped
								fail("Failed to set " + getClass().getSimpleName() + "." + fieldName + " to null : " + e1);  //$NON-NLS-1$//$NON-NLS-2$ //$NON-NLS-3$
							}
						}
					}
				}
				else if (aClass != AbstractTestSuite.class) {
					// Tests may not have statics since they are prone to memory leakage
					fail("static test variable:" + field);  //$NON-NLS-1$
				}
			}
		}
		assertTrue(isModified == expectIsModified  );	    
		
		System.out.println("==> Finish " + getName()); //$NON-NLS-1$
	}

	protected void tearDown_ocl() {
		ocl.dispose();
		ocl = null;
	}
	
	/**
	 * Parses the specified <code>text</code>.
	 * 
	 * @param text the OCL text
	 * @return the OCL expression
	 */
	protected OCLExpression<EClassifier> parse(String text) {
		OCLExpression<EClassifier> result = parseUnvalidated(text);
		validate(result);
		
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
	protected OCLExpression<EClassifier> parseUnvalidated(String text) {
		OCLExpression<EClassifier> result = parseConstraintUnvalidated(text);
		
		// forget the constraint because it interferes with validation
		EcoreUtil.remove(result);
		
		assertValidToString(result);
		
		return result;
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
            fail("Validation failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }
    }
    
	/**
	 * Validates an OCL expression, asserting that it is valid.
	 * 
	 * @param expr the OCL expression to validate
	 * @param env an environment to use for validation
	 */
	protected void validate(OCLExpression<EClassifier> expr) {
		try {
			if ((expr.eContainer() != null)
					&& (expr.eContainer().eContainer() instanceof Constraint)) {
				// start validation from the constraint, for good measure
				validate((Constraint) expr.eContainer().eContainer());
			} else {
				ocl.validate(expr);
			}
		} catch (SemanticException e) {
			fail("Validation failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Parses the specified <code>text</code> as an OCL constraint.
	 * 
	 * @param text the OCL text
	 * @return the OCL constraint expression
	 */
	protected OCLExpression<EClassifier> parseConstraint(String text) {
		OCLExpression<EClassifier> result = parseConstraintUnvalidated(text);
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
	protected OCLExpression<EClassifier> parseConstraintUnvalidated(String text) {
		List<Constraint> constraints;
		Constraint constraint = null;
		
		try {
			constraints = ocl.parse(new OCLInput(text));
			constraint = constraints.get(0);
		} catch (ParserException e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		} catch (IllegalArgumentException e) {
			fail("Parse failed (illegal argument): " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		OCLExpression<EClassifier> result = null;
		result = constraint.getSpecification().getBodyExpression();
		
		assertNotNull(result);
		
		assertValidToString(result);
		
		return result;
	}
	
	protected Object evaluate(OCLExpression<EClassifier> expr) {
		Object result = null;
		
		try {
			result = ocl.evaluate(null, expr);
		} catch (RuntimeException e) {
			fail("Evaluation failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		return result;
	}
	
    protected Object evaluate(
            OCLHelper<EClassifier, EOperation, EStructuralFeature, Constraint> aHelper,
            Object context,
            String expression) throws ParserException {
        
        OCLExpression<EClassifier> query = aHelper.createQuery(expression);
        return ocl.evaluate(context, query);
    }
    
    protected boolean check(
            OCLHelper<EClassifier, EOperation, EStructuralFeature, Constraint> aHelper,
            Object context,
            String expression) throws ParserException {
        
        Constraint constraint = aHelper.createInvariant(expression);
        return ocl.check(context, constraint);
    }
    
	protected Object evaluate(OCLExpression<EClassifier> expr, Object self) {
		Object result = null;
		
		try {
			result = ocl.evaluate(self, expr);
		} catch (RuntimeException e) {
			fail("Evaluation failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		return result;
	}
	
	protected boolean check(String contextFreeExpression) {
		boolean result = false;
		
		try {
			OCLExpression<EClassifier> expr = parse(
					"package ecore context EString inv: " + //$NON-NLS-1$
					contextFreeExpression + " endpackage"); //$NON-NLS-1$
			
			result = check(expr, ""); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Check failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		return result;
	}
	
	protected Object evaluate(String contextFreeExpression) {
		Object result = null;
		
		try {
			OCLExpression<EClassifier> expr = parse(
					"package ecore context EString inv: " + //$NON-NLS-1$
					contextFreeExpression + " endpackage"); //$NON-NLS-1$
			
			result = evaluate(expr, ""); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Evaluation failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		return result;
	}
	
	protected boolean check(OCLExpression<EClassifier> expr, Object self) {
		boolean result = false;
		
		try {
			result = ocl.check(self, expr);
		} catch (RuntimeException e) {
			fail("Check failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
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
	protected OCLExpression<EClassifier> parseDef(String text) {
		List<Constraint> constraints ;
		Constraint constraint = null;
		
		try {
			constraints = ocl.parse(new OCLInput(text));
			constraint = constraints.get(0);
		} catch (ParserException e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		} catch (IllegalArgumentException e) {
			fail("Parse failed (illegal argument): " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		OCLExpression<EClassifier> result = null;
		result = constraint.getSpecification().getBodyExpression();
		
		validate(result);
		
		assertNotNull(result);
		
		assertValidToString(result);
		
		return result;
	}
	
	protected OCLExpression<EClassifier> createQuery(EClass context, String text) {
		OCLHelper<EClassifier, EOperation, EStructuralFeature, Constraint> helper =
			ocl.createOCLHelper();
		helper.setContext(context);
		
		OCLExpression<EClassifier> result = null;
		
		try {
			result = helper.createQuery(text);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		return result;
	}
	
	protected OCLExpression<EClassifier> createQuery(
			EnvironmentFactory<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> envFactory,
			EClass context, String text) {
		
		OCL localOcl = OCL.newInstance(envFactory);
		OCLHelper<EClassifier, EOperation, EStructuralFeature, Constraint> helper =
			localOcl.createOCLHelper();
		helper.setContext(context);
		
		OCLExpression<EClassifier> result = null;
		
		try {
			result = helper.createQuery(text);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		return result;
	}
	
	protected OCLExpression<EClassifier> createInvariant(EClass context, String text) {
		OCLHelper<EClassifier, EOperation, EStructuralFeature, Constraint> helper =
			ocl.createOCLHelper();
		helper.setContext(context);
		
		OCLExpression<EClassifier> result = null;
		
		try {
			result = helper.createInvariant(text).getSpecification().getBodyExpression();
		} catch (Exception e) {
			e.printStackTrace();
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		return result;
	}
	
	protected OCLExpression<EClassifier> createPrecondition(EOperation context, String text) {
		OCLHelper<EClassifier, EOperation, EStructuralFeature, Constraint> helper =
			ocl.createOCLHelper();
		helper.setOperationContext(context.getEContainingClass(), context);
		
		OCLExpression<EClassifier> result = null;
		
		try {
			result = helper.createPrecondition(text).getSpecification().getBodyExpression();
		} catch (Exception e) {
			e.printStackTrace();
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		return result;
	}
	
	protected OCLExpression<EClassifier> createPostcondition(EOperation context, String text) {
		OCLHelper<EClassifier, EOperation, EStructuralFeature, Constraint> helper =
			ocl.createOCLHelper();
		helper.setOperationContext(context.getEContainingClass(), context);
		
		OCLExpression<EClassifier> result = null;
		
		try {
			result = helper.createPostcondition(text).getSpecification().getBodyExpression();
		} catch (Exception e) {
			e.printStackTrace();
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		return result;
	}
	
	protected OCLExpression<EClassifier> createBodyCondition(EOperation context, String text) {
		OCLHelper<EClassifier, EOperation, EStructuralFeature, Constraint> helper =
			ocl.createOCLHelper();
		helper.setOperationContext(context.getEContainingClass(), context);
		
		OCLExpression<EClassifier> result = null;
		
		try {
			result = helper.createBodyCondition(text).getSpecification().getBodyExpression();
		} catch (Exception e) {
			e.printStackTrace();
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
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
	
	/**
	 * Asserts that the <code>toString</code> representation of an AST node as
	 * generated by the toString visitor does not throw a run-time exception
	 * and is not <code>null</code>.
	 * 
	 * @param node a visitable AST node
	 */
	void assertValidToString(Visitable node) {
		try {
			String toString = node.toString();
			assertNotNull("ToStringVisitorImpl returned null", toString); //$NON-NLS-1$
		} catch (RuntimeException e) {
			e.printStackTrace();
			fail("ToStringVisitorImpl threw an exception: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Asserts that the specified choice is to be found in the collection of
	 * <code>choices</code>.
	 * 
	 * @param choices a collection of {@link Choice}s
	 * @param kind the kind of choice to find
	 * @param name the name of the choice to find
	 */
	protected void assertChoice(Collection<Choice> choices, ChoiceKind kind, String name) {
		assertNotNull("Choice not found: " + name + ", " + kind, //$NON-NLS-1$ //$NON-NLS-2$
			findChoice(choices, kind, name));
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
		assertNull("Choice found: " + name + ", " + kind, //$NON-NLS-1$ //$NON-NLS-2$
			findChoice(choices, kind, name));
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
    		fail("Diagnostic signals a(n) " + excType.getSimpleName()); //$NON-NLS-1$
    	}
    	
    	for (Diagnostic nested : diagnostic.getChildren()) {
    		assertNoException(nested, excType);
    	}
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
    	
    	assertNotNull("No diagnostic", result); //$NON-NLS-1$
    	
    	return result;
    }
	
	protected OCLStandardLibrary<EClassifier> getOCLStandardLibrary() {
		return ocl.getEnvironment().getOCLStandardLibrary();
	}
	
	protected Object getInvalid() {
		return getOCLStandardLibrary().getInvalid();
	}
	
	protected void assertInvalid(Object value) {
		assertTrue("Expected invalid", ocl.isInvalid(value)); //$NON-NLS-1$
	}
	
	protected void initFruitPackage() {
		URI uri = getTestModelURI("/model/OCLTest.ecore"); //$NON-NLS-1$
		Resource res = resourceSet.getResource(uri, true);
		
		fruitPackage = (EPackage) res.getContents().get(0);
		resourceSet.getPackageRegistry().put(fruitPackage.getNsURI(), fruitPackage);
		
		fruitFactory = fruitPackage.getEFactoryInstance();
		
		fruit = (EClass) fruitPackage.getEClassifier("Fruit"); //$NON-NLS-1$
		fruit_ripen = fruit.getEOperations().get(0);
		fruit_preferredColor = fruit.getEOperations().get(1);
		fruit_newFruit = fruit.getEOperations().get(2);
		fruit_setColor = fruit.getEOperations().get(3);
		fruit_color = (EAttribute) fruit.getEStructuralFeature("color"); //$NON-NLS-1$
		
		apple = (EClass) fruitPackage.getEClassifier("Apple"); //$NON-NLS-1$
		apple_label = (EAttribute) apple.getEStructuralFeature("label"); //$NON-NLS-1$
		apple_stem = (EReference) apple.getEStructuralFeature("stem"); //$NON-NLS-1$
		apple_labelOper = apple.getEOperations().get(0);
		apple_newApple = apple.getEOperations().get(1);
		
		stem = (EClass) fruitPackage.getEClassifier("Stem"); //$NON-NLS-1$
		
		color = (EEnum) fruitPackage.getEClassifier("Color"); //$NON-NLS-1$
		color_black = color.getEEnumLiteral("black"); //$NON-NLS-1$
		color_red = color.getEEnumLiteral("red"); //$NON-NLS-1$
		color_green = color.getEEnumLiteral("green"); //$NON-NLS-1$
		color_yellow = color.getEEnumLiteral("yellow"); //$NON-NLS-1$
		color_orange = color.getEEnumLiteral("orange"); //$NON-NLS-1$
		color_brown = color.getEEnumLiteral("brown"); //$NON-NLS-1$
		color_pink = color.getEEnumLiteral("pink"); //$NON-NLS-1$
		
		util = (EClass) fruitPackage.getEClassifier("FruitUtil"); //$NON-NLS-1$
		util_orderedSet = (EReference) util.getEStructuralFeature("orderedSet"); //$NON-NLS-1$
		util_set = (EReference) util.getEStructuralFeature("set"); //$NON-NLS-1$
		util_bag = (EReference) util.getEStructuralFeature("bag"); //$NON-NLS-1$
		util_sequence = (EReference) util.getEStructuralFeature("sequence"); //$NON-NLS-1$
		util_processOrderedSet = util.getEOperations().get(0);
		util_processSet = util.getEOperations().get(1);
		util_processBag = util.getEOperations().get(2);
		util_processSequence = util.getEOperations().get(3);
		res.setTrackingModification(true);
	}
}
