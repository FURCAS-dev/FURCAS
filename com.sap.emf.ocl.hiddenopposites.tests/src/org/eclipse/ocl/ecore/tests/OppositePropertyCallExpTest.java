/**
 * <copyright>
 * 
 * Copyright (c) 2006, 2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   E.D.Willink - Bug 296409
 *
 * </copyright>
 *
 * $Id: IteratorsTest.java,v 1.10 2009/12/16 21:00:50 ewillink Exp $
 */

package org.eclipse.ocl.ecore.tests;

import java.util.Collection;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.ocl.ecore.OperationCallExp;
import org.eclipse.ocl.expressions.OCLExpression;

import com.sap.emf.ocl.oclwithhiddenopposites.expressions.OppositePropertyCallExp;


/**
 * Tests for iterator expressions.
 * 
 * @author Christian W. Damus (cdamus)
 */
@SuppressWarnings("nls")
public class OppositePropertyCallExpTest
		extends AbstractTestSuite {

	/**
	 * Test parsing an expression that contains an OppositePropertyCallExp
	 */
	public void test_parseSimpleContainerOppositePropertyCallExp() {
		OCLExpression<EClassifier> expr = parseConstraint(
			"package ocltest context Stem " +
			"inv: self.stemOfApple->notEmpty() " +
			"endpackage");
		assertTrue(expr instanceof OperationCallExp);
		OCLExpression<EClassifier> source = ((OperationCallExp) expr).getSource();
		assertTrue(source instanceof OppositePropertyCallExp);
		OppositePropertyCallExp opce = (OppositePropertyCallExp) source;
		assertEquals(apple_stem, opce.getReferredOppositeProperty());
	}

	/**
	 * Test evaluating an expression that contains an OppositePropertyCallExp
	 */
	@SuppressWarnings("unchecked")
	public void test_evaluateSimpleOppositePropertyCallExp() {
		helper.setContext(apple);
		
		try {
			String expr = "self.droppedUnderTree->notEmpty()";
			Resource res = new ResourceImpl();
	        res.eAdapters().add(new ECrossReferenceAdapter());
			// add some fruits to the resource.  Note that these fruits are
			//   not direct instances of the Fruit class that we are constraining
			EObject tree1 = fruitFactory.create(tree);
			res.getContents().add(tree1);
			EObject apple1 = fruitFactory.create(apple);
			res.getContents().add(apple1);
			((Collection<EObject>) tree1.eGet(tree_fruitsDroppedUnder)).add(apple1);
			
			EObject apple2 = fruitFactory.create(apple);
			res.getContents().add(apple2);
			apple2.eSet(fruit_color, color_yellow);
			
			assertTrue((Boolean) evaluate(helper, apple1, expr));
			assertFalse((Boolean) evaluate(helper, apple2, expr));
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage());
		}
	}
	
	/**
	 * Test evaluating an expression that contains an OppositePropertyCallExp
	 */
	public void test_evaluateSimpleContainerOppositePropertyCallExp() {
		helper.setContext(stem);
		
		try {
			String expr = "self.stemOfApple->notEmpty()";
			Resource res = new ResourceImpl();
	        res.eAdapters().add(new ECrossReferenceAdapter());
			// add some fruits to the resource.  Note that these fruits are
			//   not direct instances of the Fruit class that we are constraining
			EObject stem1 = fruitFactory.create(stem);
			res.getContents().add(stem1);
			EObject stem2 = fruitFactory.create(stem);
			res.getContents().add(stem2);
			
			EObject apple1 = fruitFactory.create(apple);
			res.getContents().add(apple1);
			apple1.eSet(fruit_color, color_yellow);
			apple1.eSet(apple_stem, stem1);
			
			// apple1 has forward reference stem to stem1, so stem1 has non-empty opposite reference stemOfApple 
			assertTrue((Boolean) evaluate(helper, stem1, expr));
			assertFalse((Boolean) evaluate(helper, stem2, expr));
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage());
		}
	}
	
	/**
	 * Test evaluating an expression that contains an OppositePropertyCallExp using
	 * a "hidden opposite" of a containment reference inherited from a superclass
	 */
	@SuppressWarnings("unchecked")
	public void test_evaluateInheritedContainerOppositePropertyCallExp() {
		helper.setContext(apple);
		
		try {
			String expr = "self.tree->select(name='Apple Tree')->notEmpty()";
			Resource res = new ResourceImpl();
	        res.eAdapters().add(new ECrossReferenceAdapter());
			// add some fruits to the resource.  Note that these fruits are
			//   not direct instances of the Fruit class that we are constraining
			EObject tree1 = fruitFactory.create(tree);
			tree1.eSet(tree_name, "Apple Tree");
			res.getContents().add(tree1);
			
			EObject apple1 = fruitFactory.create(apple);
			res.getContents().add(apple1);
			((Collection<EObject>) tree1.eGet(tree_fruits)).add(apple1);
			EObject apple2 = fruitFactory.create(apple);
			res.getContents().add(apple2);
			
			// apple1 has forward reference stem to stem1, so stem1 has non-empty opposite reference stemOfApple 
			assertTrue((Boolean) evaluate(helper, apple1, expr));
			assertFalse((Boolean) evaluate(helper, apple2, expr));
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage());
		}
	}
	
	/**
	 * Test evaluating an expression that contains an OppositePropertyCallExp using
	 * a "hidden opposite" of a non-containment reference inherited from a superclass
	 */
	@SuppressWarnings("unchecked")
	public void test_evaluateInheritedOppositePropertyCallExp() {
		helper.setContext(apple);
		
		try {
			String expr = "self.droppedUnderTree->select(name='Apple Tree')->notEmpty()";
			Resource res = new ResourceImpl();
	        res.eAdapters().add(new ECrossReferenceAdapter());
			// add some fruits to the resource.  Note that these fruits are
			//   not direct instances of the Fruit class that we are constraining
			EObject tree1 = fruitFactory.create(tree);
			tree1.eSet(tree_name, "Apple Tree");
			res.getContents().add(tree1);
			
			EObject apple1 = fruitFactory.create(apple);
			res.getContents().add(apple1);
			((Collection<EObject>) tree1.eGet(tree_fruitsDroppedUnder)).add(apple1);
			EObject apple2 = fruitFactory.create(apple);
			res.getContents().add(apple2);
			
			// apple1 has forward reference stem to stem1, so stem1 has non-empty opposite reference stemOfApple 
			assertTrue((Boolean) evaluate(helper, apple1, expr));
			assertFalse((Boolean) evaluate(helper, apple2, expr));
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage());
		}
	}
	
}
