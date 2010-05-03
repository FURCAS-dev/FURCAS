/**
 * <copyright>
 *
 * Copyright (c) 2005, 2009 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   Zeligsoft - Bug 245897, 179990
 *   Radek Dvorak - Bug 261128
 *   Ed Willink - Bug 254919, 298634
 *
 * </copyright>
 *
 * $Id: AbstractTestSuite.java,v 1.23 2010/05/03 09:38:49 ewillink Exp $
 */

package org.eclipse.ocl.uml.tests;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.tests.GenericFruitTestSuite;
import org.eclipse.ocl.uml.util.OCLUMLUtil;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.AssociationClass;
import org.eclipse.uml2.uml.CallOperationAction;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.DataType;
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
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * Extended test framework for tests using the UML binding and the Fruit meta-model.
 *
 * @author Christian W. Damus (cdamus)
 */
@SuppressWarnings("nls")
public abstract class AbstractTestSuite
	extends GenericFruitTestSuite<EObject, Package, Type, Classifier, Class, DataType, PrimitiveType, Enumeration, Operation, Parameter, Property,
	Property, Property, EnumerationLiteral, State, CallOperationAction, SendSignalAction, Constraint> {
    
	protected static final ExecutorService exec = Executors
		.newSingleThreadExecutor();
	
	protected static org.eclipse.ocl.uml.UMLPackage ocltypes =
        org.eclipse.ocl.uml.UMLPackage.eINSTANCE;
	
	protected static UMLPackage uml = UMLPackage.eINSTANCE;
	protected static UMLFactory umlf = uml.getUMLFactory();
	
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

	/**
	 * Adds parser-style independent tests to the test suite.
	 * 
	 * @param result the suite
	 */
	public static void suite(CheckedTestSuite result) {
		result.createTestSuite(BasicOCLTest.class, "Basic Tests");
        result.createTestSuite(PrimitiveTypesTest.class, "Primitive Type Tests");
		result.createTestSuite(ComparisonTest.class, "Comparison/Ordering Tests");
		result.createTestSuite(CollectionsTest.class, "Collection Type Tests");
		result.createTestSuite(AssociationTest.class, "Association Tests");
		result.createTestSuite(IteratorsTest.class, "Iterator Tests");
        result.createTestSuite(KeywordsTest.class, "LPG and OCL Keyword Tests");
        result.createTestSuite(PrecedenceTest.class, "Operator Precedence Tests");
		result.createTestSuite(TuplesTest.class, "Tuple Tests");
		result.createTestSuite(StatesTest.class, "State Expression Tests");
		result.createTestSuite(MessagesTest.class, "Message Expression Tests");
		result.createTestSuite(ProfilesTest.class, "Profile Constraint Tests");
		result.createTestSuite(InvariantConstraintsTest.class, "Invariant Constraints");
		result.createTestSuite(OperationConstraintsTest.class, "Operation Constraints");
		result.createTestSuite(LocationInformationTest.class, "Location Information Tests");
		result.createTestSuite(FeatureRedefinitionTest.class, "Feature redefinition tests");
		result.createTestSuite(DefExpressionTest.class, "Def Expression Tests");
		result.createTestSuite(InitOrDerExpressionTest.class, "Initial and Derivation Expression Tests");
        result.createTestSuite(UMLTest.class, "UML-Specific Tests");
		result.createTestSuite(OCLDocumentTest.class, "OCL Document Parsing Tests");
        result.createTestSuite(UtilitiesTest.class, "OCLUMLUtil Utility Class Tests");
        result.createTestSuite(UMLEnvironmentTest.class, "UML Environment Tests");
		result.addTestSuite(org.eclipse.ocl.uml.helper.tests.AbstractTestSuite.suite());
		result.createTestSuite(RegressionTest.class, "Regression Tests");
		result.createTestSuite(ValidationTest.class, "Expression Validation Tests");
		result.createTestSuite(TypesValidatorTest.class, "Types Validator Tests");
		result.createTestSuite(ExpressionsValidatorTest.class, "Expressions Validator Tests");
		result.createTestSuite(SerializationTest.class, "Serialization Tests");
		result.createTestSuite(EvaluationHaltedTest.class, "UML Halted Evaluation Tests");
	}
	
	/**
	 * Adds backtracking tests to the test suite.
	 * 
	 * @param result the suite
	 */
	public static void suiteBacktracking(CheckedTestSuite result) {
		result.createTestSuite(ParserBacktrackingTest.class, "Parser Backtracking Tests");
	}
	
	//
	// Framework methods
	//

	@Override
	public UMLTestReflection.Static getStaticReflection() {
		return UMLTestReflection.Static.INSTANCE;
	}
	
	/**
	 * Clean up on behalf of derived tests, alleviating them of the tedious need to avoid
	 * leaks. All loaded resources are unloaded and all fields are nulled, by invoking
	 * tearDown_xxx() if such a method is available, or setting it to null otherwise.
	 * public access must be provided.
	 * 
	 * This method is final to force invocation. Provide a tearDown_xxx method to do
	 * some derived action during tearDown.
	 *
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
							String tearDownName = "tearDown_" + fieldName;
							Method method = aClass.getDeclaredMethod(tearDownName);
							try {
								method.invoke(this);
							} catch (Exception e) {
								// tearDown_xxx must be public
								fail("Failed to invoke " + getClass().getSimpleName() + "." + tearDownName + " : " + e);
							}
						}
						catch (NoSuchMethodException e) {
							try {
								field.set(this, null);
							} catch (Exception e1) {
								// xxx without a tearDown_xxx must be public to ensure that leakage can be stopped
								fail("Failed to set " + getClass().getSimpleName() + "." + fieldName + " to null : " + e1);
							}
						}
					}
				}
				else if (aClass != AbstractTestSuite.class) {
					// Tests may not have statics since they are prone to memory leakage
					fail("static test variable:" + field); 
				}
			}
		}
		assertTrue(isModified == expectIsModified  );	    
		System.out.println("==> Finish " + getName());
	} */

	@Override
	protected void tearDownField(Field field) throws IllegalAccessException {
		field.set(this, null);
	}

	@Override
	protected final void tearDownStatic(java.lang.Class<?> aClass, Field field) {
		if (aClass != AbstractTestSuite.class) {
			super.tearDownStatic(aClass, field);
		}
	}

	@Override
	protected void tearDownUsing(Method method)
			throws IllegalAccessException, InvocationTargetException {
		method.invoke(this);
	}

	public void tearDown_fruitEPackage() {
		resourceSet.getPackageRegistry().remove(fruitEPackage.getNsURI());
		fruitEPackage = null;
	}
	
	protected final String getStereotype(Constraint constraint) {
		EList<String> keywords = constraint.getKeywords();
		return keywords.isEmpty()? null : keywords.get(0);
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
			throw new IllegalArgumentException("Unrecognized slot value: " + value);
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
		
		fail("No such property value: " + property.getName());
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
			throw new IllegalArgumentException("Unrecognized slot value: " + value);
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
	
	@Override
	protected void initFruitPackage() {
		URI uri = getTestModelURI("/model/OCLTest.uml");
		Resource res = resourceSet.getResource(uri, true);
		
		fruitPackage = (Package) res.getContents().get(0);
		
		fruit = (Class) fruitPackage.getOwnedType("Fruit");
		fruit_ripen = fruit.getOwnedOperation("ripen", null, null);
		fruit_preferredColor = fruit.getOwnedOperation("preferredColor", null, null);
		fruit_newFruit = fruit.getOwnedOperation("newFruit", null, null);
		fruit_setColor = fruit.getOwnedOperation("setColor", null, null);
        fruit_color = fruit.getOwnedAttribute("color", null);
        fruit_friends = fruit.getOwnedAttribute("friends", null);
		
		apple = (Class) fruitPackage.getOwnedType("Apple");
		apple_label = apple.getOwnedAttribute("label", null);
		apple_tree = apple.getOwnedAttribute("tree", null);
        apple_appleFriends = apple.getOwnedAttribute("appleFriends", null);
		apple_labelOper = apple.getOwnedOperation("label", null, null);
		apple_newApple = apple.getOwnedOperation("newApple", null, null);
		
		stem = (AssociationClass) fruitPackage.getOwnedType("Stem");
		stem_length = stem.getOwnedAttribute("length", null);
		
		tree = (Class) fruitPackage.getOwnedType("Tree");
		tree_apples = tree.getOwnedAttribute("apples", null);
		tree_height = tree.getOwnedAttribute("height", null);
        
		color = (Enumeration) fruitPackage.getOwnedType("Color");
		color_black = color.getOwnedLiteral("black");
		color_red = color.getOwnedLiteral("red");
		color_green = color.getOwnedLiteral("green");
		color_yellow = color.getOwnedLiteral("yellow");
		color_orange = color.getOwnedLiteral("orange");
		color_brown = color.getOwnedLiteral("brown");
		color_pink = color.getOwnedLiteral("pink");
		
		forest = (Class) fruitPackage.getOwnedType("Forest");
		forest_trees = forest.getOwnedAttribute("trees", null);
		forest_trees_zoneQualifier = forest_trees.getQualifier("zone", null);
		forest_trees_indexQualifier = forest_trees.getQualifier("index", null);
        forest_area = forest.getOwnedAttribute("area", null);
		
		a_forest_tree = (Association) fruitPackage.getOwnedType("A_Forest_Tree");
		a_forest_tree_forest = a_forest_tree.getOwnedEnd("forest", null);
		
		util = (Class) fruitPackage.getOwnedType("FruitUtil");
		util_orderedSet = util.getOwnedAttribute("orderedSet", null);
		util_set = util.getOwnedAttribute("set", null);
		util_bag = util.getOwnedAttribute("bag", null);
		util_sequence = util.getOwnedAttribute("sequence", null);
		util_processOrderedSet = util.getOwnedOperation("processOrderedSet", null, null);
		util_processSet = util.getOwnedOperation("processSet", null, null);
		util_processBag = util.getOwnedOperation("processBag", null, null);
		util_processSequence = util.getOwnedOperation("processSequence", null, null);
		
		
		// convert the Package to Ecore for evaluation on instances
		fruitEPackage = UMLUtil.convertToEcore(fruitPackage, null).iterator().next();
		resourceSet.getPackageRegistry().put(fruitEPackage.getNsURI(), fruitEPackage);
		fruitEFactory = fruitEPackage.getEFactoryInstance();
		res.setTrackingModification(true);

		assertSame(
			fruitPackage,
			OCLUMLUtil.findPackage(
					Collections.singletonList(fruitPackage.getName()),
					resourceSet));
	}
}
