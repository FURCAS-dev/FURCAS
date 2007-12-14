/**
 * <copyright>
 * 
 * Copyright (c) 2005, 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: AbstractTestSuite.java,v 1.8 2007/12/14 17:09:25 cdamus Exp $
 */

package org.eclipse.ocl.ecore.tests;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

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
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.ocl.EnvironmentFactory;
import org.eclipse.ocl.OCLInput;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.SemanticException;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.EcoreEnvironment;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.ecore.internal.OCLFactoryImpl;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.helper.Choice;
import org.eclipse.ocl.helper.ChoiceKind;
import org.eclipse.ocl.helper.OCLHelper;
import org.eclipse.ocl.types.OCLStandardLibrary;
import org.eclipse.ocl.utilities.OCLFactory;
import org.eclipse.ocl.utilities.Visitable;


/**
 * Mini-framework for the OCL tests.
 *
 * @author Christian W. Damus (cdamus)
 */
public abstract class AbstractTestSuite
	extends TestCase {

	protected static org.eclipse.ocl.ecore.EcorePackage ocltypes =
        org.eclipse.ocl.ecore.EcorePackage.eINSTANCE;
	protected static EcorePackage ecore = EcorePackage.eINSTANCE;
	
	protected static EPackage fruitPackage;
	protected static EFactory fruitFactory;
	
	protected static EClass fruit;
	protected static EOperation fruit_ripen;
	protected static EOperation fruit_preferredColor;
	protected static EOperation fruit_newFruit;
	protected static EOperation fruit_setColor;
	protected static EAttribute fruit_color;
	
	protected static EClass apple;
	protected static EAttribute apple_label;
	protected static EReference apple_stem;
	protected static EOperation apple_labelOper;
	protected static EOperation apple_newApple;
	
	protected static EClass stem;
	
	protected static EEnum color;
	protected static EEnumLiteral color_black;
	protected static EEnumLiteral color_red;
	protected static EEnumLiteral color_green;
	protected static EEnumLiteral color_yellow;
	protected static EEnumLiteral color_orange;
	protected static EEnumLiteral color_brown;
	protected static EEnumLiteral color_pink;
	
	protected static EClass util;
	protected static EReference util_orderedSet;
	protected static EReference util_set;
	protected static EReference util_bag;
	protected static EReference util_sequence;
	protected static EOperation util_processOrderedSet;
	protected static EOperation util_processSet;
	protected static EOperation util_processBag;
	protected static EOperation util_processSequence;
	
	protected OCL ocl;
	protected OCLHelper<EClassifier, EOperation, EStructuralFeature, Constraint>
	helper;
	protected final OCLFactory oclFactory = OCLFactoryImpl.INSTANCE;
	
	public AbstractTestSuite(String name) {
		super(name);
	}

	/**
	 * Creates the test suite.
	 * 
	 * @return the suite
	 */
	public static Test suite() {
		TestSuite result = new TestSuite("OCL Tests for Ecore Metamodel"); //$NON-NLS-1$
		
		result.addTest(BasicOCLTest.suite());
		result.addTest(KeywordsTest.suite());
		result.addTest(ComparisonTest.suite());
        result.addTest(PrimitiveTypesTest.suite());
		result.addTest(CollectionsTest.suite());
		result.addTest(IteratorsTest.suite());
		result.addTest(TuplesTest.suite());
		result.addTest(AssociationTest.suite());
		result.addTest(StatesTest.suite());
		result.addTest(MessagesTest.suite());
		result.addTest(InvariantConstraintsTest.suite());
		result.addTest(OperationConstraintsTest.suite());
		result.addTest(LocationInformationTest.suite());
		result.addTest(DefExpressionTest.suite());
		result.addTest(InitOrDerExpressionTest.suite());
		result.addTest(OCLDocumentTest.suite());
		result.addTest(AbstractVisitorTest.suite());
		result.addTest(org.eclipse.ocl.ecore.helper.tests.AbstractTestSuite.suite());
		result.addTest(RegressionTest.suite());
		result.addTest(EcoreEnvironmentTest.suite());
        result.addTest(ExtensibilityTest.suite());
		result.addTest(ValidationTest.suite());
		result.addTest(ProblemOptionTest.suite());
		result.addTest(SerializationTest.suite());
		
		return result;
	}
	
	//
	// Framework methods
	//
	
	@Override
    protected void setUp()
		throws Exception {
		
		System.out.println("==> Start  " + getName()); //$NON-NLS-1$
		
		if (fruitPackage == null) {
			initFruitPackage();
		}
		
		assertSame(
				fruitPackage,
				EPackage.Registry.INSTANCE.getEPackage(fruitPackage.getNsURI()));
		assertSame(
				fruitPackage,
				EcoreEnvironment.findPackage(Collections.singletonList(fruitPackage.getName())));

		ocl = createOCL();
//        ocl.setParseTracingEnabled(true);
//        ocl.setEvaluationTracingEnabled(true);
		
		helper = createHelper();
	}
	
	protected OCL createOCL() {
		return OCL.newInstance();
	}
	
	protected OCLHelper<EClassifier, EOperation, EStructuralFeature, Constraint>
	createHelper() {
		return ocl.createOCLHelper();
	}
	
	@Override
    protected void tearDown()
		throws Exception {
		
	    ocl.dispose();
	    
		System.out.println("==> Finish " + getName()); //$NON-NLS-1$
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
	
	protected OCLStandardLibrary<EClassifier> getOCLStandardLibrary() {
		return ocl.getEnvironment().getOCLStandardLibrary();
	}
	
	protected Object getOclInvalid() {
		return getOCLStandardLibrary().getOclInvalid();
	}
	
	protected void assertInvalid(Object value) {
		assertTrue("Expected OclInvalid", ocl.isInvalid(value)); //$NON-NLS-1$
	}
	
	private static void initFruitPackage() {
		URL url = null;

		try {
			Class<?> platformClass = Class.forName("org.eclipse.core.runtime.Platform"); //$NON-NLS-1$
			Method getBundle = platformClass.getDeclaredMethod("getBundle", new Class[] {String.class}); //$NON-NLS-1$
			Object bundle = getBundle.invoke(null, new Object[] {"org.eclipse.ocl.ecore.tests"}); //$NON-NLS-1$
			
			if (bundle != null) {
				Method getEntry = bundle.getClass().getMethod("getEntry", new Class[] {String.class}); //$NON-NLS-1$
				url = (URL) getEntry.invoke(bundle, new Object[] {"/model/OCLTest.ecore"}); //$NON-NLS-1$
			}
		} catch (Exception e) {
			// not running in Eclipse
		}
		
		if (url == null) {
			try {
				Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
						"ecore", new XMIResourceFactoryImpl()); //$NON-NLS-1$
				String urlString = System.getProperty("org.eclipse.ocl.ecore.tests.testmodel"); //$NON-NLS-1$
				if (!urlString.startsWith("file:")) { //$NON-NLS-1$
					urlString = "file:" + urlString; //$NON-NLS-1$
				}
				url = new URL(urlString);
			} catch (MalformedURLException e) {
				fail(e.getLocalizedMessage());
			}
		}
		
		ResourceSet rset = new ResourceSetImpl();
		Resource res = rset.getResource(URI.createURI(url.toString()), true);
		
		fruitPackage = (EPackage) res.getContents().get(0);
		EPackage.Registry.INSTANCE.put(fruitPackage.getNsURI(), fruitPackage);
		
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
	}
}
