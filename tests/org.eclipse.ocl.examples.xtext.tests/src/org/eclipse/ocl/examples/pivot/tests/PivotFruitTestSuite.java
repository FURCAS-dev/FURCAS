/**
 * <copyright>
 * 
 * Copyright (c) 2011 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   L.Goubet, E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: PivotFruitTestSuite.java,v 1.2 2011/05/06 09:05:14 ewillink Exp $
 */

package org.eclipse.ocl.examples.pivot.tests;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.examples.common.utils.EcoreUtils;
import org.eclipse.ocl.examples.pivot.AssociationClass;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.ecore.Ecore2Pivot;
import org.eclipse.ocl.examples.pivot.utilities.PivotConstants;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.uml2.uml.Association;

/**
 * Test suite with a simple Fruit model.
 */
@SuppressWarnings("nls")
public abstract class PivotFruitTestSuite extends PivotTestSuite
{
	protected EPackage fruitEPackage;
	protected EFactory fruitEFactory;

	protected org.eclipse.ocl.examples.pivot.Package fruitPackage;
	
	protected EClass fruit;
	protected EOperation fruit_ripen;
	protected EOperation fruit_preferredColor;
	protected EOperation fruit_newFruit;
	protected EOperation fruit_setColor;
	protected EAttribute fruit_color;
	protected EAttribute fruit_name;
//    protected EReference fruit_friends;
	
	protected EClass apple;
	protected Property apple_label;
	protected Property apple_tree;
    protected Property apple_appleFriends;
	protected Operation apple_labelOper;
	protected Operation apple_newApple;
	
	protected AssociationClass stem;
	protected Property stem_length;
	
	protected EClass tree;
    protected EReference tree_fruits;
//	protected Property tree_apples;
//    protected Property tree_height;
	protected EAttribute tree_name;
	
	protected EEnum color;
	protected EEnumLiteral color_black;
	protected EEnumLiteral color_red;
	protected EEnumLiteral color_green;
	protected EEnumLiteral color_yellow;
	protected EEnumLiteral color_orange;
	protected EEnumLiteral color_brown;
	protected EEnumLiteral color_pink;
	
	protected org.eclipse.ocl.examples.pivot.Class forest;
	protected Property forest_trees;
	protected Property forest_trees_zoneQualifier;
	protected Property forest_trees_indexQualifier;
    protected Property forest_area;
	
	protected Association a_forest_tree;
	protected Property a_forest_tree_forest;
	
	protected org.eclipse.ocl.examples.pivot.Class util;
	protected Property util_orderedSet;
	protected Property util_set;
	protected Property util_bag;
	protected Property util_sequence;
	protected Operation util_processOrderedSet;
	protected Operation util_processSet;
	protected Operation util_processBag;
	protected Operation util_processSequence;


	private EEnumLiteral getELiteral(EEnum eEnum, String name) {
		return eEnum.getEEnumLiteral(name);
	}
	
	private EOperation getEOperation(EClass eClass, String name, Object object, Object object2) {
		return EcoreUtils.getNamedElement(eClass.getEOperations(), name);
	}

	private EAttribute getEAttribute(EClass cls, String name, Object object) {
		return (EAttribute) cls.getEStructuralFeature(name);
	}

	private EReference getEReference(EClass cls, String name, Object object) {
		return (EReference) cls.getEStructuralFeature(name);
	}

	private EClassifier getEClassifier(EPackage ePackage, String name) {
		return ePackage.getEClassifier(name);
	}
	
	protected void initFruitPackage() {
		URI uri = getTestModelURI("/model/Fruit.ecore");
		Resource ecoreResource = resourceSet.getResource(uri, true);
		fruitEPackage = (EPackage)ecoreResource.getContents().get(0);
		fruitEFactory = fruitEPackage.getEFactoryInstance();
		Ecore2Pivot ecore2Pivot = Ecore2Pivot.getAdapter(ecoreResource, typeManager);
		fruitPackage = PivotUtil.getNamedElement(ecore2Pivot.getPivotRoot().getNestedPackages(), "fruit");
		
		fruit = (EClass) getEClassifier(fruitEPackage, "Fruit");
		fruit_ripen = getEOperation(fruit, "ripen", null, null);
		fruit_preferredColor = getEOperation(fruit, "preferredColor", null, null);
		fruit_newFruit = getEOperation(fruit, "newFruit", null, null);
		fruit_setColor = getEOperation(fruit, "setColor", null, null);
        fruit_color = getEAttribute(fruit, "color", null);
        fruit_name = getEAttribute(fruit, "name", null);
//        fruit_friends = getEReference(fruit, "friends", null);
		
		apple = (EClass) getEClassifier(fruitEPackage, "Apple");
/*		apple_label = getOwnedAttribute(apple, "label", null);
		apple_tree = getOwnedAttribute(apple, "tree", null);
        apple_appleFriends = getOwnedAttribute(apple, "appleFriends", null);
		apple_labelOper = getOwnedOperation(apple, "label", null, null);
		apple_newApple = getOwnedOperation(apple, "newApple", null, null);
		
//		stem = (AssociationClass) getOwnedType(fruitPackage, "Stem");
//		stem_length = getOwnedAttribute(stem, "length", null);
*/		
		tree = (EClass) getEClassifier(fruitEPackage, "Tree");
		tree_fruits = getEReference(tree, "fruits", null);
//		tree_apples = getOwnedAttribute(tree, "apples", null);
//		tree_height = getOwnedAttribute(tree, "height", null);
        tree_name = getEAttribute(tree, "name", null);
       
		color = (EEnum) getEClassifier(fruitEPackage, "Color");
		color_black = getELiteral(color, "black");
		color_red = getELiteral(color, "red");
		color_green = getELiteral(color, "green");
		color_yellow = getELiteral(color, "yellow");
		color_orange = getELiteral(color, "orange");
		color_brown = getELiteral(color, "brown");
		color_pink = getELiteral(color, "pink");
/*		
//		forest = (org.eclipse.ocl.examples.pivot.Class) getOwnedType(fruitPackage, "Forest");
//		forest_trees = getOwnedAttribute(forest, "trees", null);
//		forest_trees_zoneQualifier = forest_trees.getQualifier("zone", null);
//		forest_trees_indexQualifier = forest_trees.getQualifier("index", null);
//        forest_area = getOwnedAttribute(forest, "area", null);
		
//		a_forest_tree = (Association) getOwnedType(fruitPackage, "A_Forest_Tree");
//		a_forest_tree_forest = a_forest_tree.getOwnedEnd("forest", null);
		
		util = (org.eclipse.ocl.examples.pivot.Class) getOwnedType(fruitPackage, "FruitUtil");
		util_orderedSet = getOwnedAttribute(util, "orderedSet", null);
		util_set = getOwnedAttribute(util, "set", null);
		util_bag = getOwnedAttribute(util, "bag", null);
		util_sequence = getOwnedAttribute(util, "sequence", null);
		util_processOrderedSet = getOwnedOperation(util, "processOrderedSet", null, null);
		util_processSet = getOwnedOperation(util, "processSet", null, null);
		util_processBag = getOwnedOperation(util, "processBag", null, null);
		util_processSequence = getOwnedOperation(util, "processSequence", null, null);
*/		
		
		// convert the Package to Ecore for evaluation on instances
//		fruitEPackage = UMLUtil.convertToEcore(fruitPackage, null).iterator().next();
//		resourceSet.getPackageRegistry().put(fruitEPackage.getNsURI(), fruitEPackage);
//		fruitEFactory = fruitEPackage.getEFactoryInstance();
//		res.setTrackingModification(true);

//		assertSame(
//			fruitPackage,
//			OCLUMLUtil.findPackage(
//					Collections.singletonList(fruitPackage.getName()),
//					resourceSet));
	}

	@Override
    protected void setUp() {
        super.setUp();
		typeManager.addGlobalNamespace(PivotConstants.OCL_NAME, typeManager.getPivotMetaModel());
    }
}
