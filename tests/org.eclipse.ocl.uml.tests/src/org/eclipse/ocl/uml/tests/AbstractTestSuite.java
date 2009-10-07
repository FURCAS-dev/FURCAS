/**
 * <copyright>
 *
 * Copyright (c) 2005, 2009 IBM Corporation, Zeligsoft Inc. and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   Zeligsoft - Bug 245897, 179990
 *   Radek Dvorak - Bug 261128
 *
 * </copyright>
 *
 * $Id: AbstractTestSuite.java,v 1.18 2009/10/07 20:41:45 ewillink Exp $
 */

package org.eclipse.ocl.uml.tests;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.EnvironmentFactory;
import org.eclipse.ocl.OCLInput;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.SemanticException;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.helper.Choice;
import org.eclipse.ocl.helper.ChoiceKind;
import org.eclipse.ocl.helper.OCLHelper;
import org.eclipse.ocl.lpg.ProblemHandler;
import org.eclipse.ocl.parser.OCLProblemHandler;
import org.eclipse.ocl.types.OCLStandardLibrary;
import org.eclipse.ocl.uml.ExpressionInOCL;
import org.eclipse.ocl.uml.OCL;
import org.eclipse.ocl.uml.UMLEnvironmentFactory;
import org.eclipse.ocl.uml.util.OCLUMLUtil;
import org.eclipse.ocl.util.OCLUtil;
import org.eclipse.ocl.utilities.Visitable;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.AssociationClass;
import org.eclipse.uml2.uml.CallOperationAction;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.InstanceValue;
import org.eclipse.uml2.uml.LiteralBoolean;
import org.eclipse.uml2.uml.LiteralInteger;
import org.eclipse.uml2.uml.LiteralNull;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.LiteralUnlimitedNatural;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.SendSignalAction;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.uml2.uml.resource.UMLResource;
import org.eclipse.uml2.uml.util.UMLUtil;

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

		public void createTestSuite(java.lang.Class<? extends AbstractTestSuite> testClass, String testName) {
	        addTest(new TestSuite(testClass, testName));
		}

		public void addTestSuite(CheckedTestSuite suite) {
	        addTest(suite);
		}
	}

    // set this variable true when testing for memory leaks
    private static boolean DISPOSE_UML_METAMODEL = false;
    
	protected static final ExecutorService exec = Executors
		.newSingleThreadExecutor();

	protected static ResourceSet resourceSet;
	private static ArrayList<Resource> standardResources;
	
	protected static org.eclipse.ocl.uml.UMLPackage ocltypes =
        org.eclipse.ocl.uml.UMLPackage.eINSTANCE;
	
	protected static UMLPackage uml = UMLPackage.eINSTANCE;
	protected static UMLFactory umlf = uml.getUMLFactory();
	
	protected static Package umlMetamodel;
	protected static Package umlPrimitiveTypes;
	protected static Package ecorePrimitiveTypes;

	private static void initializeResourceSet() {
		Environment.Registry.INSTANCE.registerEnvironment(
			new UMLEnvironmentFactory().createEnvironment());
	    resourceSet = new ResourceSetImpl();
	    OCL.initialize(resourceSet);
		// Make sure that the UML metamodel and primitive types
		//   libraries are loaded
		umlMetamodel = (Package) resourceSet.getResource(
				URI.createURI(UMLResource.UML_METAMODEL_URI),
				true).getContents().get(0);
		umlPrimitiveTypes = (Package) resourceSet.getResource(
				URI.createURI(UMLResource.UML_PRIMITIVE_TYPES_LIBRARY_URI),
				true).getContents().get(0);
		ecorePrimitiveTypes = (Package) resourceSet.getResource(
				URI.createURI(UMLResource.ECORE_PRIMITIVE_TYPES_LIBRARY_URI),
				true).getContents().get(0);
		//
		standardResources = new ArrayList<Resource>(resourceSet.getResources());
	}
	
	protected Package fruitPackage;
	protected EPackage fruitEPackage;
	protected EFactory fruitEFactory;
	
	protected Class fruit;
	protected Operation fruit_ripen;
	protected Operation fruit_preferredColor;
	protected Operation fruit_newFruit;
	protected Operation fruit_setColor;
	protected Property fruit_color;
    protected Property fruit_friends;
	
	protected Class apple;
	protected Property apple_label;
	protected Property apple_tree;
    protected Property apple_appleFriends;
	protected Operation apple_labelOper;
	protected Operation apple_newApple;
	
	protected AssociationClass stem;
	protected Property stem_length;
	
	protected Class tree;
	protected Property tree_apples;
    protected Property tree_height;
	
	protected Enumeration color;
	protected EnumerationLiteral color_black;
	protected EnumerationLiteral color_red;
	protected EnumerationLiteral color_green;
	protected EnumerationLiteral color_yellow;
	protected EnumerationLiteral color_orange;
	protected EnumerationLiteral color_brown;
	protected EnumerationLiteral color_pink;
	
	protected Class forest;
	protected Property forest_trees;
	protected Property forest_trees_zoneQualifier;
	protected Property forest_trees_indexQualifier;
    protected Property forest_area;
	
	protected Association a_forest_tree;
	protected Property a_forest_tree_forest;
	
	protected Class util;
	protected Property util_orderedSet;
	protected Property util_set;
	protected Property util_bag;
	protected Property util_sequence;
	protected Operation util_processOrderedSet;
	protected Operation util_processSet;
	protected Operation util_processBag;
	protected Operation util_processSequence;
	
	protected OCL ocl;
	protected OCLHelper<Classifier, Operation, Property, Constraint> helper;

	/**
	 * Set this true to suppress a failure from modifying the fruitPackage
	 */
	protected boolean expectModified = false;

	/**
	 * Creates the test suite.
	 * 
	 * @return the suite
	 */
	public static CheckedTestSuite suite() {
		CheckedTestSuite result = new CheckedTestSuite("OCL Tests for UML Metamodel"); //$NON-NLS-1$
		
		result.createTestSuite(BasicOCLTest.class, "Basic Tests"); //$NON-NLS-1$
        result.createTestSuite(PrimitiveTypesTest.class, "Primitive Type Tests"); //$NON-NLS-1$
		result.createTestSuite(ComparisonTest.class, "Comparison/Ordering Tests"); //$NON-NLS-1$
		result.createTestSuite(CollectionsTest.class, "Collection Type Tests"); //$NON-NLS-1$
		result.createTestSuite(AssociationTest.class, "Association Tests"); //$NON-NLS-1$
		result.createTestSuite(IteratorsTest.class, "Iterator Tests"); //$NON-NLS-1$
        result.createTestSuite(KeywordsTest.class, "LPG and OCL Keyword Tests"); //$NON-NLS-1$
        result.createTestSuite(PrecedenceTest.class, "Operator Precedence Tests"); //$NON-NLS-1$
		result.createTestSuite(TuplesTest.class, "Tuple Tests"); //$NON-NLS-1$
		result.createTestSuite(StatesTest.class, "State Expression Tests"); //$NON-NLS-1$
		result.createTestSuite(MessagesTest.class, "Message Expression Tests"); //$NON-NLS-1$
		result.createTestSuite(ProfilesTest.class, "Profile Constraint Tests"); //$NON-NLS-1$
		result.createTestSuite(InvariantConstraintsTest.class, "Invariant Constraints"); //$NON-NLS-1$
		result.createTestSuite(OperationConstraintsTest.class, "Operation Constraints"); //$NON-NLS-1$
		result.createTestSuite(LocationInformationTest.class, "Location Information Tests"); //$NON-NLS-1$
		result.createTestSuite(FeatureRedefinitionTest.class, "Feature redefinition tests"); //$NON-NLS-1$
		result.createTestSuite(DefExpressionTest.class, "Def Expression Tests"); //$NON-NLS-1$
		result.createTestSuite(InitOrDerExpressionTest.class, "Initial and Derivation Expression Tests"); //$NON-NLS-1$
        result.createTestSuite(UMLTest.class, "UML-Specific Tests"); //$NON-NLS-1$
		result.createTestSuite(OCLDocumentTest.class, "OCL Document Parsing Tests"); //$NON-NLS-1$
        result.createTestSuite(UtilitiesTest.class, "OCLUMLUtil Utility Class Tests"); //$NON-NLS-1$
        result.createTestSuite(UMLEnvironmentTest.class, "UML Environment Tests"); //$NON-NLS-1$
		result.addTestSuite(org.eclipse.ocl.uml.helper.tests.AbstractTestSuite.suite());
		result.createTestSuite(RegressionTest.class, "Regression Tests"); //$NON-NLS-1$
		result.createTestSuite(ValidationTest.class, "Expression Validation Tests"); //$NON-NLS-1$
		result.createTestSuite(TypesValidatorTest.class, "Types Validator Tests"); //$NON-NLS-1$
		result.createTestSuite(ExpressionsValidatorTest.class, "Expressions Validator Tests"); //$NON-NLS-1$
		result.createTestSuite(SerializationTest.class, "Serialization Tests"); //$NON-NLS-1$
		result.createTestSuite(EvaluationHaltedTest.class, "UML Halted Evaluation Tests"); //$NON-NLS-1$
		
		return result;
	}
	
	//
	// Framework methods
	//
	
	@Override
    protected void setUp() {
		
		System.out.println("==> Start  " + getName()); //$NON-NLS-1$
		
        if ((resourceSet != null) && DISPOSE_UML_METAMODEL) {
        	disposeResourceSet();
        }
		if (!initialized) {
			boolean isRunning = false;
			try {
				java.lang.Class<?> platformClass = java.lang.Class.forName("org.eclipse.core.runtime.Platform"); //$NON-NLS-1$
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
			OCLUMLUtil.findPackage(
					Collections.singletonList(fruitPackage.getName()),
					resourceSet));
		
		ocl = createOCL();
//        ocl.setParseTracingEnabled(true);
//        ocl.setEvaluationTracingEnabled(true);
		
		helper = createHelper();
	}
	
	protected OCL createOCL() {
		OCL newInstance = OCL.newInstance(resourceSet);
		String repairs = System.getProperty("org.eclipse.ocl.uml.tests.repairs"); //$NON-NLS-1$
		if (repairs != null)
			newInstance.setParserRepairCount(Integer.parseInt(repairs));
		return newInstance;
	}
	
	protected OCLHelper<Classifier, Operation, Property, Constraint> createHelper() {
		return ocl.createOCLHelper();
	}
	
	/**
	 * Clean up on behalf of derived tests, alleviating them of the tedious need to avoid
	 * leaks. All loaded resources are unloaded and all fields are nulled, by invoking
	 * tearDown_xxx() if such a method is available, or setting it to null otherwise.
	 * public access must be provided.
	 * 
	 * This method is final to force invocation. Provide a tearDown_xxx method to do
	 * some derived action during tearDown.
	 */
	@Override
    protected final void tearDown()
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

	public void tearDown_fruitEPackage() {
		resourceSet.getPackageRegistry().remove(fruitEPackage.getNsURI());
		fruitEPackage = null;
	}
    
    protected final Classifier getMetaclass(String name) {
        return (Classifier) umlMetamodel.getOwnedType(name);
    }
	
	/**
	 * Parses the specified <code>text</code>.
	 * 
	 * @param text the OCL text
	 * @return the OCL expression
	 */
	protected OCLExpression<Classifier> parse(String text) {
		OCLExpression<Classifier> result = parseUnvalidated(text);
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
	protected OCLExpression<Classifier> parseUnvalidated(String text) {
		OCLExpression<Classifier> result = parseConstraintUnvalidated(text);
		
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
	protected void validate(OCLExpression<Classifier> expr) {
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
	protected OCLExpression<Classifier> parseConstraint(String text) {
		OCLExpression<Classifier> result = parseConstraintUnvalidated(text);
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
	protected OCLExpression<Classifier> parseConstraintUnvalidated(String text) {
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
		
		OCLExpression<Classifier> result = null;
		result = getBodyExpression(constraint);
		
		assertNotNull(result);
		
		assertValidToString(result);
		
		return result;
	}
	
	protected final OCLExpression<Classifier> getBodyExpression(
			Constraint constraint) {
		
		return ((ExpressionInOCL) constraint.getSpecification()).getBodyExpression();
	}
	
	protected final String getStereotype(Constraint constraint) {
		EList<String> keywords = constraint.getKeywords();
		return keywords.isEmpty()? null : keywords.get(0);
	}
    
    protected Object evaluate(
            OCLHelper<Classifier, Operation, Property, Constraint> aHelper,
            Object context,
            String expression) throws ParserException {
        
        OCLExpression<Classifier> query = aHelper.createQuery(expression);
        return ocl.evaluate(context, query);
    }
    
    protected boolean check(
            OCLHelper<Classifier, Operation, Property, Constraint> aHelper,
            Object context,
            String expression) throws ParserException {
        
        Constraint constraint = aHelper.createInvariant(expression);
        return ocl.check(context, constraint);
    }
	
	protected Object evaluate(OCLExpression<Classifier> expr) {
		Object result = null;
		
		try {
			result = ocl.evaluate(null, expr);
		} catch (RuntimeException e) {
			fail("Evaluation failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		return result;
	}
	
	protected Object evaluate(OCLExpression<Classifier> expr, Object self) {
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
			OCLExpression<Classifier> expr = parse(
					"package UMLPrimitiveTypes context \"String\" inv: " + //$NON-NLS-1$
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
			OCLExpression<Classifier> expr = parse(
					"package UMLPrimitiveTypes context \"String\" inv: " + //$NON-NLS-1$
					contextFreeExpression + " endpackage"); //$NON-NLS-1$
			
			result = evaluate(expr, ""); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Evaluation failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		return result;
	}
	
	protected boolean check(OCLExpression<Classifier> expr, Object self) {
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
	protected OCLExpression<Classifier> parseDef(String text) {
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
		
		OCLExpression<Classifier> result = null;
		result = getBodyExpression(constraint);
		
		validate(result);
		
		assertNotNull(result);
		
		assertValidToString(result);
		
		return result;
	}
	
	protected OCLExpression<Classifier> createQuery(Classifier context, String text) {
		OCLHelper<Classifier, Operation, Property, Constraint> helper =
			ocl.createOCLHelper();
		helper.setContext(context);
		
		OCLExpression<Classifier> result = null;
		
		try {
			result = helper.createQuery(text);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		return result;
	}
	
	protected OCLExpression<Classifier> createQuery(
			EnvironmentFactory<Package, Classifier, Operation, Property, EnumerationLiteral, Parameter, State, CallOperationAction, SendSignalAction, Constraint, Class, EObject> envFactory,
			Classifier context, String text) {
		
		OCL localOcl = OCL.newInstance(envFactory);
		OCLHelper<Classifier, Operation, Property, Constraint> helper =
			localOcl.createOCLHelper();
		helper.setContext(context);
		
		OCLExpression<Classifier> result = null;
		
		try {
			result = helper.createQuery(text);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		return result;
	}
	
	protected OCLExpression<Classifier> createInvariant(Classifier context, String text) {
		OCLHelper<Classifier, Operation, Property, Constraint> helper =
			ocl.createOCLHelper();
		helper.setContext(context);
		
		OCLExpression<Classifier> result = null;
		
		try {
			result = getBodyExpression(helper.createInvariant(text));
		} catch (Exception e) {
			e.printStackTrace();
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		return result;
	}
	
	protected OCLExpression<Classifier> createPrecondition(Operation context, String text) {
		OCLHelper<Classifier, Operation, Property, Constraint> helper =
			ocl.createOCLHelper();
		helper.setOperationContext((Classifier) context.getOwner(), context);
		
		OCLExpression<Classifier> result = null;
		
		try {
			result = getBodyExpression(helper.createPrecondition(text));
		} catch (Exception e) {
			e.printStackTrace();
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		return result;
	}
	
	protected OCLExpression<Classifier> createPostcondition(Operation context, String text) {
		OCLHelper<Classifier, Operation, Property, Constraint> helper =
			ocl.createOCLHelper();
		helper.setOperationContext((Classifier) context.getOwner(), context);
		
		OCLExpression<Classifier> result = null;
		
		try {
			result = getBodyExpression(helper.createPostcondition(text));
		} catch (Exception e) {
			e.printStackTrace();
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		return result;
	}
	
	protected OCLExpression<Classifier> createBodyCondition(Operation context, String text) {
		OCLHelper<Classifier, Operation, Property, Constraint> helper =
			ocl.createOCLHelper();
		helper.setOperationContext((Classifier) context.getOwner(), context);
		
		OCLExpression<Classifier> result = null;
		
		try {
			result = getBodyExpression(helper.createBodyCondition(text));
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
	
	protected OCLStandardLibrary<Classifier> getOCLStandardLibrary() {
		return ocl.getEnvironment().getOCLStandardLibrary();
	}
	
	protected Object getInvalid() {
		return getOCLStandardLibrary().getInvalid();
	}
	
	protected void assertInvalid(Object value) {
		assertTrue("Expected invalid", ocl.isInvalid(value)); //$NON-NLS-1$
	}
	
	protected PrimitiveType getUMLBoolean() {
		return (PrimitiveType) umlPrimitiveTypes.getOwnedType("Boolean"); //$NON-NLS-1$
	}
	
	protected PrimitiveType getUMLString() {
		return (PrimitiveType) umlPrimitiveTypes.getOwnedType("String"); //$NON-NLS-1$
	}
	
	protected PrimitiveType getUMLInteger() {
		return (PrimitiveType) umlPrimitiveTypes.getOwnedType("Integer"); //$NON-NLS-1$
	}
	
	protected PrimitiveType getUMLUnlimitedNatural() {
		return (PrimitiveType) umlPrimitiveTypes.getOwnedType("UnlimitedNatural"); //$NON-NLS-1$
	}
	
	protected PrimitiveType getEcoreLong() {
		return (PrimitiveType) ecorePrimitiveTypes.getOwnedType("ELong"); //$NON-NLS-1$
	}
	
	protected PrimitiveType getEcoreBigDecimal() {
		return (PrimitiveType) ecorePrimitiveTypes.getOwnedType("EBigDecimal"); //$NON-NLS-1$
	}
	
	protected PrimitiveType getEcoreBigInteger() {
		return (PrimitiveType) ecorePrimitiveTypes.getOwnedType("EBigInteger"); //$NON-NLS-1$
	}
	
	protected InstanceSpecification instantiate(Package pkg, Classifier classifier) {
		InstanceSpecification result = (InstanceSpecification) pkg.createPackagedElement(
				null, uml.getInstanceSpecification());
		
		if (classifier != null) {
			result.getClassifiers().add(classifier);
		}
		
		return result;
	}
	
	protected Slot setValue(
			InstanceSpecification instance,
			Property property,
			Object value) {
		
		Slot result = null;
		
		for (Slot slot : instance.getSlots()) {
			if (slot.getDefiningFeature() == property) {
				result = slot;
				slot.getValues().clear();
				break;
			}
		}
		
		if (result == null) {
			result = instance.createSlot();
			result.setDefiningFeature(property);
		}
		
		if (value instanceof Collection<?>) {
			for (Object e : (Collection<?>) value) {
				addValue(result, e);
			}
		} else {
			addValue(result, value);
		}
		
		return result;
	}
	
	protected void clearValue(
			InstanceSpecification instance,
			Property property) {
		
		for (Slot slot : instance.getSlots()) {
			if (slot.getDefiningFeature() == property) {
				instance.getSlots().remove(slot);
				break;
			}
		}
	}
	
	protected Slot addValue(
			InstanceSpecification instance,
			Property property,
			Object value) {
		
		Slot result = null;
		
		for (Slot slot : instance.getSlots()) {
			if (slot.getDefiningFeature() == property) {
				result = slot;
				break;
			}
		}
		
		if (result == null) {
			result = setValue(instance, property, value);
		} else {
			addValue(result, value);
		}
		
		return result;
	}
	
	protected ValueSpecification addValue(Slot slot, Object value) {
		ValueSpecification result;
		
		if (value instanceof InstanceSpecification) {
			InstanceValue valueSpec = (InstanceValue) slot.createValue(
					null, null, uml.getInstanceValue());
			valueSpec.setInstance((InstanceSpecification) value);
			result = valueSpec;
		} else if (value instanceof String) {
			LiteralString valueSpec = (LiteralString) slot.createValue(
					null, null, uml.getLiteralString());
			valueSpec.setValue((String) value);
			result = valueSpec;
		} else if (value instanceof Integer) {
			if (slot.getDefiningFeature().getType() == getUMLUnlimitedNatural()) {
				LiteralUnlimitedNatural valueSpec =
					(LiteralUnlimitedNatural) slot.createValue(
						null, null, uml.getLiteralUnlimitedNatural());
				valueSpec.setValue(((Integer) value).intValue());
				result = valueSpec;
			} else {
				LiteralInteger valueSpec = (LiteralInteger) slot.createValue(
						null, null, uml.getLiteralInteger());
				valueSpec.setValue(((Integer) value).intValue());
				result = valueSpec;
			}
		} else if (value instanceof Boolean) {
			LiteralBoolean valueSpec = (LiteralBoolean) slot.createValue(
					null, null, uml.getLiteralBoolean());
			valueSpec.setValue(((Boolean) value).booleanValue());
			result = valueSpec;
		} else if (value == null) {
			LiteralNull valueSpec = (LiteralNull) slot.createValue(
					null, null, uml.getLiteralNull());
			result = valueSpec;
		} else {
			throw new IllegalArgumentException("Unrecognized slot value: " + value); //$NON-NLS-1$
		}
		
		return result;
	}
	
	protected Object getValue(InstanceSpecification owner, Property property) {
		for (Slot slot : owner.getSlots()) {
			if (slot.getDefiningFeature() == property) {
				EList<ValueSpecification> values = slot.getValues();
				
				if (!property.isMultivalued()) {
					return values.isEmpty()? null : convert(values.get(0));
				} else {
					EList<Object> result = new BasicEList.FastCompare<Object>(values.size());
					
					for (ValueSpecification value : values) {
						result.add(convert(value));
					}
					
					return result;
				}
			}
		}
		
		fail("No such property value: " + property.getName()); //$NON-NLS-1$
		return null;
	}
	
	protected Object convert(ValueSpecification value) {
		Object result;
		
		if (value instanceof InstanceValue) {
			result = ((InstanceValue) value).getInstance();
		} else if (value instanceof LiteralString) {
			result = ((LiteralString) value).stringValue();
		} else if (value instanceof LiteralInteger) {
			result = ((LiteralInteger) value).integerValue();
		} else if (value instanceof LiteralUnlimitedNatural) {
			result = ((LiteralUnlimitedNatural) value).integerValue();
		} else if (value instanceof LiteralBoolean) {
			result = ((LiteralBoolean) value).booleanValue();
		} else if (value instanceof LiteralNull) {
			result = null;
		} else {
			throw new IllegalArgumentException("Unrecognized slot value: " + value); //$NON-NLS-1$
		}
		
		return result;
	}
	
	protected InstanceSpecification link(
			Package pkg,
			InstanceSpecification instance1, Property end1,
			InstanceSpecification instance2, Property end2,
			Association assoc) {
		
		InstanceSpecification result = instantiate(pkg, assoc);
		
		setValue(result, end1, instance2);
		if (end1.getOwningAssociation() == null) {
			addValue(instance1, end1, instance2);
		}
		
		setValue(result, end2, instance1);
		if (end2.getOwningAssociation() == null) {
			addValue(instance2, end2, instance1);
		}
		
		return result;
	}
	
	protected InstanceSpecification link(
			Package pkg,
			InstanceSpecification instance1, Property end1,
			Object[] qualifierValues,
			InstanceSpecification instance2, Property end2,
			Association assoc) {
		
		InstanceSpecification result = link(pkg, instance1, end1, instance2, end2, assoc);
		
		List<Property> qualifiers = end1.getQualifiers();
		int count = qualifiers.size();
		
		for (int i = 0; i < count; i++) {
			setValue(result, qualifiers.get(i), qualifierValues[i]);
		}
		
		return result;
	}
	
	protected void unload(EObject eObject) {
	    eObject.eAdapters().clear();
	    for (Iterator<EObject> iter = eObject.eAllContents(); iter.hasNext();) {
	        iter.next().eAdapters().clear();
	    }
	}
	
	protected void unload(Collection<? extends EObject> eObjects) {
	    for (EObject eObject : eObjects) {
	        unload(eObject);
	    }
	}
	
	private static void disposeResourceSet() {
        for (Resource res : resourceSet.getResources()) {
            res.unload();
            res.eAdapters().clear();
        }
        resourceSet.getResources().clear();
        resourceSet.eAdapters().clear();
        resourceSet = null;
        umlMetamodel = null;
        umlPrimitiveTypes = null;
        ecorePrimitiveTypes = null;
		standardResources = null;
	}
	
	public static URI getTestModelURI(String localFileName) {
		String testPlugInId = "org.eclipse.ocl.uml.tests"; //$NON-NLS-1$
		try {
			java.lang.Class<?> platformClass = java.lang.Class.forName("org.eclipse.core.runtime.Platform"); //$NON-NLS-1$
			Method getBundle = platformClass.getDeclaredMethod("getBundle", new java.lang.Class[] {String.class}); //$NON-NLS-1$
			Object bundle = getBundle.invoke(null, new Object[] {testPlugInId});
			
			if (bundle != null) {
				Method getEntry = bundle.getClass().getMethod("getEntry", new java.lang.Class[] {String.class}); //$NON-NLS-1$
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
	
	private void initFruitPackage() {
		URI uri = getTestModelURI("/model/OCLTest.uml"); //$NON-NLS-1$		
		Resource res = resourceSet.getResource(uri, true);
		
		fruitPackage = (Package) res.getContents().get(0);
		
		fruit = (Class) fruitPackage.getOwnedType("Fruit"); //$NON-NLS-1$
		fruit_ripen = fruit.getOwnedOperation("ripen", null, null); //$NON-NLS-1$
		fruit_preferredColor = fruit.getOwnedOperation("preferredColor", null, null); //$NON-NLS-1$
		fruit_newFruit = fruit.getOwnedOperation("newFruit", null, null); //$NON-NLS-1$
		fruit_setColor = fruit.getOwnedOperation("setColor", null, null); //$NON-NLS-1$
        fruit_color = fruit.getOwnedAttribute("color", null); //$NON-NLS-1$
        fruit_friends = fruit.getOwnedAttribute("friends", null); //$NON-NLS-1$
		
		apple = (Class) fruitPackage.getOwnedType("Apple"); //$NON-NLS-1$
		apple_label = apple.getOwnedAttribute("label", null); //$NON-NLS-1$
		apple_tree = apple.getOwnedAttribute("tree", null); //$NON-NLS-1$
        apple_appleFriends = apple.getOwnedAttribute("appleFriends", null); //$NON-NLS-1$
		apple_labelOper = apple.getOwnedOperation("label", null, null); //$NON-NLS-1$
		apple_newApple = apple.getOwnedOperation("newApple", null, null); //$NON-NLS-1$
		
		stem = (AssociationClass) fruitPackage.getOwnedType("Stem"); //$NON-NLS-1$
		stem_length = stem.getOwnedAttribute("length", null); //$NON-NLS-1$
		
		tree = (Class) fruitPackage.getOwnedType("Tree"); //$NON-NLS-1$
		tree_apples = tree.getOwnedAttribute("apples", null); //$NON-NLS-1$
		tree_height = tree.getOwnedAttribute("height", null); //$NON-NLS-1$
        
		color = (Enumeration) fruitPackage.getOwnedType("Color"); //$NON-NLS-1$
		color_black = color.getOwnedLiteral("black"); //$NON-NLS-1$
		color_red = color.getOwnedLiteral("red"); //$NON-NLS-1$
		color_green = color.getOwnedLiteral("green"); //$NON-NLS-1$
		color_yellow = color.getOwnedLiteral("yellow"); //$NON-NLS-1$
		color_orange = color.getOwnedLiteral("orange"); //$NON-NLS-1$
		color_brown = color.getOwnedLiteral("brown"); //$NON-NLS-1$
		color_pink = color.getOwnedLiteral("pink"); //$NON-NLS-1$
		
		forest = (Class) fruitPackage.getOwnedType("Forest"); //$NON-NLS-1$
		forest_trees = forest.getOwnedAttribute("trees", null); //$NON-NLS-1$
		forest_trees_zoneQualifier = forest_trees.getQualifier("zone", null); //$NON-NLS-1$
		forest_trees_indexQualifier = forest_trees.getQualifier("index", null); //$NON-NLS-1$
        forest_area = forest.getOwnedAttribute("area", null); //$NON-NLS-1$
		
		a_forest_tree = (Association) fruitPackage.getOwnedType("A_Forest_Tree"); //$NON-NLS-1$
		a_forest_tree_forest = a_forest_tree.getOwnedEnd("forest", null); //$NON-NLS-1$
		
		util = (Class) fruitPackage.getOwnedType("FruitUtil"); //$NON-NLS-1$
		util_orderedSet = util.getOwnedAttribute("orderedSet", null); //$NON-NLS-1$
		util_set = util.getOwnedAttribute("set", null); //$NON-NLS-1$
		util_bag = util.getOwnedAttribute("bag", null); //$NON-NLS-1$
		util_sequence = util.getOwnedAttribute("sequence", null); //$NON-NLS-1$
		util_processOrderedSet = util.getOwnedOperation("processOrderedSet", null, null); //$NON-NLS-1$
		util_processSet = util.getOwnedOperation("processSet", null, null); //$NON-NLS-1$
		util_processBag = util.getOwnedOperation("processBag", null, null); //$NON-NLS-1$
		util_processSequence = util.getOwnedOperation("processSequence", null, null); //$NON-NLS-1$
		
		
		// convert the Package to Ecore for evaluation on instances
		fruitEPackage = UMLUtil.convertToEcore(fruitPackage, null).iterator().next();
		resourceSet.getPackageRegistry().put(fruitEPackage.getNsURI(), fruitEPackage);
		fruitEFactory = fruitEPackage.getEFactoryInstance();
		res.setTrackingModification(true);
	}
}
