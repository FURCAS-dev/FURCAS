/*******************************************************************************
 * Copyright (c) 2009, 2010 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     SAP AG - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.ecore.tests;

import java.util.Collection;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.ocl.ecore.IteratorExp;
import org.eclipse.ocl.ecore.LetExp;
import org.eclipse.ocl.ecore.OperationCallExp;
import org.eclipse.ocl.ecore.OppositePropertyCallExp;
import org.eclipse.ocl.expressions.OCLExpression;
import org.junit.Ignore;


/**
 * Tests for iterator expressions.
 * 
 * @author Christian W. Damus (cdamus)
 */
@SuppressWarnings("nls")
public class OppositePropertyCallExpTest
		extends AbstractTestSuite {

	protected EPackage hiddenOppositesPackage;
	protected EFactory hiddenOppositesFactory;
	protected EClass sup1;
	protected EReference sup1_sup2;
	protected EClass sup2;
	protected EClass sub;
	protected EReference sup2_sup1;
	protected EClass unrelated;
	protected EReference unrelated_hidden;
	protected EReference unrelated_forward;

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
	 * Test parsing an expression that contains an OppositePropertyCallExp with
	 * implicit "self"
	 */
	public void test_parseSimpleContainerOppositePropertyCallExpWithImplicitSelf() {
		OCLExpression<EClassifier> expr = parseConstraint(
			"package ocltest context Stem " +
			"inv: stemOfApple->notEmpty() " +
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
	 * a "hidden opposite" of a containment reference inherited from a superclass
	 */
	@Ignore("Ignored to make Maven build work")
	// also renamed because JUnit 3.x doesn't know annotations 
	public void ignoredtest_parseMoreSpecificInheritedOppositePropertyCallExpInsteadMoreGeneralPropertyCallExp() {
		initHiddenOppositesTestPackage();
		helper.setContext(sub);
		try {
			String expr = "self.sup1";
			OCLExpression<EClassifier> ast = helper.createQuery(expr);
			assertTrue(ast instanceof OppositePropertyCallExp);
			OppositePropertyCallExp opce = (OppositePropertyCallExp) ast;
			assertTrue(opce.getReferredOppositeProperty() == sup1_sup2);
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage());
		}
	}
	
	/**
	 * Implicit source expressions, e.g., an iterator variable, must take preference over
	 * implicit source expressions defined by enclosing scopes. This must also hold for a hidden
	 * opposite being resolved on the inner implicit scope before a regular property is resolved
	 * for the outer implicit scope. 
	 */
	@Ignore("Ignored to make Maven build work")
	// also renamed because JUnit 3.x doesn't know annotations 
	public void ignoredtest_parseOppositePropertyCallExpOnNestedImplicitSource() {
		initHiddenOppositesTestPackage();
		helper.setContext(unrelated);
		try {
			String expr = "let s:Set(Sup2) = Set{} in s->exists(hidden = null)";
			OCLExpression<EClassifier> ast = helper.createQuery(expr);
			assertTrue(ast instanceof LetExp);
			OCLExpression<EClassifier> iterator = ((LetExp) ast).getIn();
			assertTrue(iterator instanceof IteratorExp);
			OCLExpression<EClassifier> body = ((IteratorExp) iterator).getBody();
			assertTrue(body instanceof OperationCallExp); // .=(null)
			OperationCallExp opCallExp = (OperationCallExp) body;
			OCLExpression<EClassifier> opce = opCallExp.getSource();
			assertTrue(opce instanceof OppositePropertyCallExp);
			assertTrue(((OppositePropertyCallExp) opce).getReferredOppositeProperty() == unrelated_forward);
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
	
	private void initHiddenOppositesTestPackage() {
		URI uri = getTestModelURI("/model/HiddenOpposites.ecore");
		Resource res = resourceSet.getResource(uri, true);
		hiddenOppositesPackage = (EPackage) res.getContents().get(0);
		resourceSet.getPackageRegistry().put(hiddenOppositesPackage.getNsURI(), hiddenOppositesPackage);
		hiddenOppositesFactory = hiddenOppositesPackage.getEFactoryInstance();
		sup1 = (EClass) hiddenOppositesPackage.getEClassifier("Sup1");
		sup1_sup2 = (EReference) sup1.getEStructuralFeature("sup2");
		sup2 = (EClass) hiddenOppositesPackage.getEClassifier("Sup2");
		sup2_sup1 = (EReference) sup2.getEStructuralFeature("sup1");
		sub = (EClass) hiddenOppositesPackage.getEClassifier("Sub");
		unrelated = (EClass) hiddenOppositesPackage.getEClassifier("Unrelated");
		unrelated_forward = (EReference) unrelated.getEStructuralFeature("forward");
		unrelated_hidden = (EReference) unrelated.getEStructuralFeature("hidden");
	}
}
