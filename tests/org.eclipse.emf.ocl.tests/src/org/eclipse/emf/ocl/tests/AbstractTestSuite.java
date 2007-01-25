/**
 * <copyright>
 *
 * Copyright (c) 2005 IBM Corporation and others.
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
 * $Id$
 */

package org.eclipse.emf.ocl.tests;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ocl.expressions.OCLExpression;
import org.eclipse.emf.ocl.expressions.impl.ValidationVisitorImpl;
import org.eclipse.emf.ocl.expressions.util.ExpressionsUtil;
import org.eclipse.emf.ocl.helper.Choice;
import org.eclipse.emf.ocl.helper.ChoiceType;
import org.eclipse.emf.ocl.internal.parser.CompatibilityParser;
import org.eclipse.emf.ocl.parser.EcoreEnvironment;
import org.eclipse.emf.ocl.parser.Environment;
import org.eclipse.emf.ocl.parser.ParserException;
import org.eclipse.emf.ocl.query.QueryFactory;
import org.eclipse.emf.ocl.types.TypesPackage;
import org.eclipse.emf.ocl.uml.Constraint;
import org.eclipse.emf.ocl.utilities.Visitable;
import org.eclipse.ocl.internal.parser.OCLLexer;


/**
 * Mini-framework for the OCL tests.
 *
 * @author Christian W. Damus (cdamus)
 */
public abstract class AbstractTestSuite
	extends TestCase {

	protected static TypesPackage ocltypes = TypesPackage.eINSTANCE;
	protected static EClass oclBoolean = ocltypes.getPrimitiveBoolean();
	
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
	
	public AbstractTestSuite(String name) {
		super(name);
	}

	/**
	 * Creates the test suite.
	 * 
	 * @return the suite
	 */
	public static Test suite() {
		TestSuite result = new TestSuite("Old OCL API Tests"); //$NON-NLS-1$
		
		result.addTest(BasicOCLTest.suite());
		result.addTest(ComparisonTest.suite());
		result.addTest(CollectionsTest.suite());
		result.addTest(IteratorsTest.suite());
		result.addTest(TuplesTest.suite());
		result.addTest(StatesTest.suite());
		result.addTest(MessagesTest.suite());
		result.addTest(InvariantConstraintsTest.suite());
		result.addTest(OperationConstraintsTest.suite());
		result.addTest(ExpressionsUtilTest.suite());
		result.addTest(LocationInformationTest.suite());
		result.addTest(AssociationTest.suite());
		result.addTest(DefExpressionTest.suite());
		result.addTest(InitOrDerExpressionTest.suite());
		result.addTest(org.eclipse.emf.ocl.helper.tests.AbstractTestSuite.suite());
		result.addTest(RegressionTest.suite());
		result.addTest(QueryFactoryTest.suite());
		result.addTest(EcoreEnvironmentTest.suite());
		result.addTest(ValidationTest.suite());
		result.addTest(SerializationTest.suite());
		
		return result;
	}
	
	//
	// Framework methods
	//
	
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
	}
	
	protected void tearDown()
		throws Exception {
		
		System.out.println("==> Finish " + getName()); //$NON-NLS-1$
	}
	
	/**
	 * Parses the specified <code>text</code>.
	 * 
	 * @param text the OCL text
	 * @return the OCL expression
	 */
	protected OCLExpression parse(String text) {
		Environment[] env = new Environment[1];
		OCLExpression result = parseUnvalidated(text, env);
		validate(result, env[0]);
		
		assertValidToString(result);
		
		return result;
	}
	
	/**
	 * Parses the specified <code>text</code> without validating it.
	 * 
	 * @param text the OCL text
	 * @return the OCL expression, unvalidated
	 */
	protected OCLExpression parseUnvalidated(String text) {
		return parseUnvalidated(text, null);
	}
	
	/**
	 * Parses the specified <code>text</code> without validating it.
	 * 
	 * @param text the OCL text
	 * @param env an OUT parameter providing the expression's environment
	 *    (which is interesting for validation, for example).  Must be
	 *    a single-element array, or <code>null</code> if the environment
	 *    is not required
	 *    
	 * @return the OCL expression, unvalidated
	 */
	protected OCLExpression parseUnvalidated(String text, Environment[] env) {
		OCLExpression result = parseConstraintUnvalidated(text, env);
		
		// forget the constraint because it interferes with validation
		EcoreUtil.remove(result);
		
		assertValidToString(result);
		
		return result;
	}

	private Environment createEnvironment(Constraint constraint) {
		ENamedElement context = (ENamedElement) constraint.getConstrainedElement().get(0);
		return createEnvironment(context);
	}
	
	protected Environment createEnvironment(ENamedElement context) {
		Environment result = null;
		
		if (context instanceof EClassifier) {
			result = ExpressionsUtil.createClassifierContext((EClassifier) context);
		} else if (context instanceof EOperation) {
			result = ExpressionsUtil.createOperationContext((EOperation) context);
		} else if (context instanceof EStructuralFeature) {
			result = ExpressionsUtil.createPropertyContext((EStructuralFeature) context);
		}
		
		return result;
	}
	
	/**
	 * Validates an OCL expression, asserting that it is valid.
	 * 
	 * @param expr the OCL expression to validate
	 */
	protected void validate(OCLExpression expr) {
		validate(expr, null);
	}
	
	/**
	 * Validates an OCL expression, asserting that it is valid.
	 * 
	 * @param expr the OCL expression to validate
	 * @param env an environment to use for validation
	 */
	protected void validate(OCLExpression expr, Environment env) {
		try {
			Visitable v;
			
			if (expr.eContainer() instanceof Constraint) {
				// start validation from the constraint, for good measure
				v = (Constraint) expr.eContainer();
			} else {
				v = expr;
			}
			
			v.accept(ValidationVisitorImpl.getInstance(env));
		} catch (IllegalArgumentException e) {
			fail("Validation failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Parses the specified <code>text</code> as an OCL constraint.
	 * 
	 * @param text the OCL text
	 * @return the OCL constraint expression
	 */
	protected OCLExpression parseConstraint(String text) {
		Environment[] env = new Environment[1];
		OCLExpression result = parseConstraintUnvalidated(text, env);
		validate(result, env[0]);
		
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
	protected OCLExpression parseConstraintUnvalidated(String text) {
		OCLLexer lexer = new OCLLexer(text.toCharArray());
		CompatibilityParser parser = new CompatibilityParser(lexer);
//		parser.setTraceFlag(true);
		
		EList constraints = new BasicEList();
		Constraint constraint = null;
		
		try {
			parser.parsePackageDeclarationCS(constraints);
			constraint = (Constraint) constraints.get(0);
		} catch (ParserException e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		} catch (IllegalArgumentException e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		OCLExpression result = null;
		result = constraint.getBody();
		
		assertNotNull(result);
		
		assertValidToString(result);
		
		return result;
	}
	
	/**
	 * Parses the specified <code>text</code> as an OCL constraint, without
	 * validating it.
	 * 
	 * @param text the OCL text
	 * @param env an OUT parameter providing the expression's environment
	 *    (which is interesting for validation, for example).  Must be
	 *    a single-element array, or <code>null</code> if the environment
	 *    is not required
	 *    
	 * @return the OCL constraint expression, unvalidated
	 */
	protected OCLExpression parseConstraintUnvalidated(String text, Environment[] env) {
		OCLLexer lexer = new OCLLexer(text.toCharArray());
		CompatibilityParser parser = new CompatibilityParser(lexer);
//		parser.setTraceFlag(true);
		
		EList constraints = new BasicEList();
		Constraint constraint = null;
		
		try {
			parser.parsePackageDeclarationCS(constraints);
			constraint = (Constraint) constraints.get(0);
		} catch (ParserException e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		} catch (IllegalArgumentException e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		OCLExpression result = null;
		result = constraint.getBody();
		
		assertNotNull(result);
		
		if (env != null) {
			env[0] = createEnvironment(constraint);
		}
		
		assertValidToString(result);
		
		return result;
	}
	
	protected Object evaluate(OCLExpression expr) {
		Object result = null;
		
		try {
			result = QueryFactory.eINSTANCE.createQuery(expr).evaluate();
		} catch (RuntimeException e) {
			fail("Validation failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		return result;
	}
	
	protected Object evaluate(OCLExpression expr, Object self) {
		Object result = null;
		
		try {
			result = QueryFactory.eINSTANCE.createQuery(expr).evaluate(self);
		} catch (RuntimeException e) {
			fail("Validation failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		return result;
	}
	
	protected boolean check(String contextFreeExpression) {
		boolean result = false;
		
		try {
			OCLExpression expr = ExpressionsUtil.createInvariant(
					EcorePackage.Literals.ESTRING, contextFreeExpression, true);
			
			assertValidToString(expr);
			
			result = QueryFactory.eINSTANCE.createQuery(expr).check(""); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Validation failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		return result;
	}
	
	protected Object evaluate(String contextFreeExpression) {
		Object result = null;
		
		try {
			OCLExpression expr = ExpressionsUtil.createInvariant(
					EcorePackage.Literals.ESTRING, contextFreeExpression, true);
			
			assertValidToString(expr);
			
			result = QueryFactory.eINSTANCE.createQuery(expr).evaluate(""); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Validation failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		return result;
	}
	
	protected boolean check(OCLExpression expr, Object self) {
		boolean result = false;
		
		try {
			result = QueryFactory.eINSTANCE.createQuery(expr).check(self);
		} catch (RuntimeException e) {
			fail("Validation failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
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
	protected OCLExpression parseDef(String text) {
		OCLLexer lexer = new OCLLexer(text.toCharArray());
		CompatibilityParser parser = new CompatibilityParser(lexer);
//		parser.setTraceFlag(true);
		
		EList constraints = new BasicEList();
		Constraint constraint = null;
		
		try {
			parser.parsePackageDeclarationCS(constraints);
			constraint = (Constraint) constraints.get(0);
		} catch (ParserException e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		} catch (IllegalArgumentException e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		OCLExpression result = null;
		result = constraint.getBody();
		
		validate(result, createEnvironment(constraint));
		
		assertNotNull(result);
		
		assertValidToString(result);
		
		return result;
	}
	
	protected Choice findChoice(Collection choices, ChoiceType kind, String name) {
		Choice result = null;
		
		for (Iterator i = choices.iterator(); i.hasNext();) {
			Choice c = (Choice) i.next();
			
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
	protected void assertChoice(Collection choices, ChoiceType kind, String name) {
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
	protected void assertNotChoice(Collection choices, ChoiceType kind, String name) {
		assertNull("Choice found: " + name + ", " + kind, //$NON-NLS-1$ //$NON-NLS-2$
			findChoice(choices, kind, name));
	}
	
	private static void initFruitPackage() {
		URL url = null;

		try {
			Class platformClass = Class.forName("org.eclipse.core.runtime.Platform"); //$NON-NLS-1$
			Method getBundle = platformClass.getDeclaredMethod("getBundle", new Class[] {String.class}); //$NON-NLS-1$
			Object bundle = getBundle.invoke(null, new Object[] {"org.eclipse.emf.ocl.tests"}); //$NON-NLS-1$
			
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
				String urlString = System.getProperty("org.eclipse.emf.ocl.tests.testmodel"); //$NON-NLS-1$
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
		fruit_ripen = (EOperation) fruit.getEOperations().get(0);
		fruit_preferredColor = (EOperation) fruit.getEOperations().get(1);
		fruit_newFruit = (EOperation) fruit.getEOperations().get(2);
		fruit_setColor = (EOperation) fruit.getEOperations().get(3);
		fruit_color = (EAttribute) fruit.getEStructuralFeature("color"); //$NON-NLS-1$
		
		apple = (EClass) fruitPackage.getEClassifier("Apple"); //$NON-NLS-1$
		apple_label = (EAttribute) apple.getEStructuralFeature("label"); //$NON-NLS-1$
		apple_stem = (EReference) apple.getEStructuralFeature("stem"); //$NON-NLS-1$
		apple_labelOper = (EOperation) apple.getEOperations().get(0);
		apple_newApple = (EOperation) apple.getEOperations().get(1);
		
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
		util_processOrderedSet = (EOperation) util.getEOperations().get(0);
		util_processSet = (EOperation) util.getEOperations().get(1);
		util_processBag = (EOperation) util.getEOperations().get(2);
		util_processSequence = (EOperation) util.getEOperations().get(3);
	}
}
