/**
 * <copyright>
 *
 * Copyright (c) 2005, 2008 IBM Corporation, Zeligsoft Inc. and others.
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
 * $Id: AbstractTestSuite.java,v 1.12 2008/08/30 23:33:11 cdamus Exp $
 */

package org.eclipse.ocl.uml.tests;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import junit.framework.Test;
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

    // set this variable true when testing for memory leaks
    private static boolean DISPOSE_UML_METAMODEL = false;
    
	protected static ResourceSet resourceSet;
	
	protected static org.eclipse.ocl.uml.UMLPackage ocltypes =
        org.eclipse.ocl.uml.UMLPackage.eINSTANCE;
	
	protected static UMLPackage uml = UMLPackage.eINSTANCE;
	protected static UMLFactory umlf = uml.getUMLFactory();
	
	protected static Package umlMetamodel;
	protected static Package umlPrimitiveTypes;
	
	protected static Package fruitPackage;
	protected static EPackage fruitEPackage;
	protected static EFactory fruitEFactory;
	
	protected static Class fruit;
	protected static Operation fruit_ripen;
	protected static Operation fruit_preferredColor;
	protected static Operation fruit_newFruit;
	protected static Operation fruit_setColor;
	protected static Property fruit_color;
    protected static Property fruit_friends;
	
	protected static Class apple;
	protected static Property apple_label;
	protected static Property apple_tree;
    protected static Property apple_appleFriends;
	protected static Operation apple_labelOper;
	protected static Operation apple_newApple;
	
	protected static AssociationClass stem;
	protected static Property stem_length;
	
	protected static Class tree;
	protected static Property tree_apples;
    protected static Property tree_height;
	
	protected static Enumeration color;
	protected static EnumerationLiteral color_black;
	protected static EnumerationLiteral color_red;
	protected static EnumerationLiteral color_green;
	protected static EnumerationLiteral color_yellow;
	protected static EnumerationLiteral color_orange;
	protected static EnumerationLiteral color_brown;
	protected static EnumerationLiteral color_pink;
	
	protected static Class forest;
	protected static Property forest_trees;
	protected static Property forest_trees_zoneQualifier;
	protected static Property forest_trees_indexQualifier;
    protected static Property forest_area;
	
	protected static Association a_forest_tree;
	protected static Property a_forest_tree_forest;
	
	protected static Class util;
	protected static Property util_orderedSet;
	protected static Property util_set;
	protected static Property util_bag;
	protected static Property util_sequence;
	protected static Operation util_processOrderedSet;
	protected static Operation util_processSet;
	protected static Operation util_processBag;
	protected static Operation util_processSequence;
	
	protected OCL ocl;
	protected OCLHelper<Classifier, Operation, Property, Constraint> helper;
	
	public AbstractTestSuite(String name) {
		super(name);
	}

	/**
	 * Creates the test suite.
	 * 
	 * @return the suite
	 */
	public static Test suite() {
		TestSuite result = new TestSuite("OCL Tests for UML Metamodel"); //$NON-NLS-1$
		
		result.addTest(BasicOCLTest.suite());
        result.addTest(PrimitiveTypesTest.suite());
		result.addTest(ComparisonTest.suite());
		result.addTest(CollectionsTest.suite());
		result.addTest(AssociationTest.suite());
		result.addTest(IteratorsTest.suite());
        result.addTest(KeywordsTest.suite());
        result.addTest(PrecedenceTest.suite());
		result.addTest(TuplesTest.suite());
		result.addTest(StatesTest.suite());
		result.addTest(MessagesTest.suite());
		result.addTest(ProfilesTest.suite());
		result.addTest(InvariantConstraintsTest.suite());
		result.addTest(OperationConstraintsTest.suite());
		result.addTest(LocationInformationTest.suite());
		result.addTest(FeatureRedefinitionTest.suite());
		result.addTest(DefExpressionTest.suite());
		result.addTest(InitOrDerExpressionTest.suite());
        result.addTest(UMLTest.suite());
		result.addTest(OCLDocumentTest.suite());
        result.addTest(UtilitiesTest.suite());
        result.addTest(UMLEnvironmentTest.suite());
		result.addTest(org.eclipse.ocl.uml.helper.tests.AbstractTestSuite.suite());
		result.addTest(RegressionTest.suite());
		result.addTest(ValidationTest.suite());
		result.addTest(TypesValidatorTest.suite());
		result.addTest(ExpressionsValidatorTest.suite());
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
				OCLUMLUtil.findPackage(
						Collections.singletonList(fruitPackage.getName()),
						resourceSet));

		ocl = createOCL();
//        ocl.setParseTracingEnabled(true);
//        ocl.setEvaluationTracingEnabled(true);
		
		helper = createHelper();
	}
	
	protected OCL createOCL() {
		return OCL.newInstance(resourceSet);
	}
	
	protected OCLHelper<Classifier, Operation, Property, Constraint> createHelper() {
		return ocl.createOCLHelper();
	}
	
	@Override
    protected void tearDown()
		throws Exception {
		
	    ocl.dispose();
        helper = null;
	    ocl = null;
	    
	    disposeResourceSet();
	    
		System.out.println("==> Finish " + getName()); //$NON-NLS-1$
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
	
	protected Object getOclInvalid() {
		return getOCLStandardLibrary().getOclInvalid();
	}
	
	protected void assertInvalid(Object value) {
		assertTrue("Expected OclInvalid", ocl.isInvalid(value)); //$NON-NLS-1$
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
		
		if (value instanceof Collection) {
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
	
	protected static void unload(EObject eObject) {
	    eObject.eAdapters().clear();
	    for (Iterator<EObject> iter = eObject.eAllContents(); iter.hasNext();) {
	        iter.next().eAdapters().clear();
	    }
	}
	
	protected static void unload(Collection<? extends EObject> eObjects) {
	    for (EObject eObject : eObjects) {
	        unload(eObject);
	    }
	}
	
	private static void disposeResourceSet() {
        if (resourceSet != null) {
            if (DISPOSE_UML_METAMODEL) {
                for (Resource res : resourceSet.getResources()) {
                    res.unload();
                    res.eAdapters().clear();
                }
                resourceSet.getResources().clear();
                resourceSet.eAdapters().clear();
                resourceSet = null;
                
                umlMetamodel = null;
                umlPrimitiveTypes = null;
            } else {
                // unload and remove all resources but the UML Metamodel.
                // Don't clear the resource set's adapter-list
                
                Set<Resource> toPreserve = new java.util.HashSet<Resource>();
                toPreserve.add(umlMetamodel.eResource());
                toPreserve.add(umlPrimitiveTypes.eResource());
                
                for (Resource res : resourceSet.getResources()) {
                    if (!toPreserve.contains(res)) {
                        res.unload();
                        res.eAdapters().clear();
                    }
                }
                
                resourceSet.getResources().retainAll(toPreserve);
            }
        }
        
        fruitPackage = null;
	}
	
	private static void initFruitPackage() {
		URL url = null;

		try {
			java.lang.Class<?> platformClass = java.lang.Class.forName("org.eclipse.core.runtime.Platform"); //$NON-NLS-1$
			Method getBundle = platformClass.getDeclaredMethod("getBundle", new java.lang.Class[] {String.class}); //$NON-NLS-1$
			Object bundle = getBundle.invoke(null, new Object[] {"org.eclipse.ocl.uml.tests"}); //$NON-NLS-1$
			
			if (bundle != null) {
				Method getEntry = bundle.getClass().getMethod("getEntry", new java.lang.Class[] {String.class}); //$NON-NLS-1$
				url = (URL) getEntry.invoke(bundle, new Object[] {"/model/OCLTest.uml"}); //$NON-NLS-1$
			}
		} catch (Exception e) {
			// not running in Eclipse
		}
		
		if (url == null) {
			try {
				Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
						UMLResource.FILE_EXTENSION, UMLResource.Factory.INSTANCE);
				String urlString = System.getProperty("org.eclipse.ocl.uml.tests.testmodel"); //$NON-NLS-1$
				if (!urlString.startsWith("file:")) { //$NON-NLS-1$
					urlString = "file:" + urlString; //$NON-NLS-1$
				}
				url = new URL(urlString);
			} catch (MalformedURLException e) {
				fail(e.getLocalizedMessage());
			}
		}
		
		disposeResourceSet();
		
		if (resourceSet == null) {
		    resourceSet = new ResourceSetImpl();
		}
		
		Resource res = resourceSet.getResource(URI.createURI(url.toString()), true);
		
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
		
		// also make sure that the UML metamodel and primitive types
		//   libraries are loaded
		
		umlMetamodel = (Package) resourceSet.getResource(
				URI.createURI(UMLResource.UML_METAMODEL_URI),
				true).getContents().get(0);
		umlPrimitiveTypes = (Package) resourceSet.getResource(
				URI.createURI(UMLResource.UML_PRIMITIVE_TYPES_LIBRARY_URI),
				true).getContents().get(0);
		
		// convert the Package to Ecore for evaluation on instances
		fruitEPackage = UMLUtil.convertToEcore(fruitPackage, null).iterator().next();
		EPackage.Registry.INSTANCE.put(fruitEPackage.getNsURI(), fruitEPackage);
		fruitEFactory = fruitEPackage.getEFactoryInstance();
	}
}
