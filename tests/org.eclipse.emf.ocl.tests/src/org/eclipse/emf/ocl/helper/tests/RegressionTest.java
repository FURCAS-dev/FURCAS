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
 * $Id$
 */

package org.eclipse.emf.ocl.helper.tests;

import java.util.List;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ocl.helper.ChoiceType;
import org.eclipse.emf.ocl.helper.ConstraintType;
import org.eclipse.emf.ocl.helper.HelperUtil;
import org.eclipse.emf.ocl.helper.IOCLHelper;

/**
 * Regression tests for specific RATLC defects.
 *
 * @author Christian W. Damus (cdamus)
 */
public class RegressionTest
	extends AbstractTestSuite {

	public RegressionTest(String name) {
		super(name);
	}
	
	public static Test suite() {
		return new TestSuite(RegressionTest.class, "Regression Tests"); //$NON-NLS-1$
	}
	
	/**
	 * Regression test to check that we complete on the right-most
	 * sub-expression to the left of the '.'.
	 */
	public void test_completionOfRightmostSubexpression_RATLC00537918() {
		IOCLHelper helper = HelperUtil.createOCLHelper();
		
		helper.setContext(EcorePackage.eINSTANCE.getEReference());
		List choices = helper.getSyntaxHelp(
				ConstraintType.INVARIANT,
				"self.eOpposite = self."); //$NON-NLS-1$
		
		// formerly, the choices offered would be the choices appropriate to
		//    the OCL Boolean type, because that is the type of
		//    "self.eOpposite = self".  We want, instead, completions for
		//    "self" which is the right-most minimal subexpression
		assertChoice(choices, ChoiceType.STRUCTURAL_FEATURE, "eOpposite"); //$NON-NLS-1$
	}
	
	/**
	 * Regression test to check that we complete on the right-most
	 * sub-expression to the left of the '.', accounting for closing
	 * parentheses.
	 */
	public void test_completionOfRightmost_parentheses_RATLC00537918() {
		IOCLHelper helper = HelperUtil.createOCLHelper();
		
		helper.setContext(EcorePackage.eINSTANCE.getEReference());
		List choices = helper.getSyntaxHelp(
				ConstraintType.INVARIANT,
				"(self.eOpposite = self)."); //$NON-NLS-1$
		
		// in this case, the right-most subexpression really is the entire
		//    "self.eOpposite = self" because of the parenthesization, so we
		//    should get the Boolean choices, not EReference choices
		assertNotChoice(choices, ChoiceType.STRUCTURAL_FEATURE, "eOpposite"); //$NON-NLS-1$
		assertChoice(choices, ChoiceType.BEHAVIORAL_FEATURE, "oclIsUndefined"); //$NON-NLS-1$
	}
	
	/**
	 * Regression test to check that we can get the correct completions on
	 * the let variables in a let expression.
	 */
	public void test_completionOnLetVariable_RATLC00537918() {
		IOCLHelper helper = HelperUtil.createOCLHelper();
		
		helper.setContext(EcorePackage.eINSTANCE.getEClass());
		List choices = helper.getSyntaxHelp(
				ConstraintType.INVARIANT,
				"let p : EPackage = self.ePackage in 'foo_'.concat(p."); //$NON-NLS-1$
		
		assertChoice(choices, ChoiceType.STRUCTURAL_FEATURE, "eClassifiers"); //$NON-NLS-1$
	}
	
	/**
	 * Regression test to check that we can get the correct completions on
	 * let expressions as a whole.
	 */
	public void test_completionOnLetExpression_RATLC00537918() {
		IOCLHelper helper = HelperUtil.createOCLHelper();
		
		helper.setContext(EcorePackage.eINSTANCE.getEClass());
		List choices = helper.getSyntaxHelp(
				ConstraintType.INVARIANT,
				"(let p : EPackage = self.ePackage in p.name)."); //$NON-NLS-1$
		
		assertChoice(choices, ChoiceType.BEHAVIORAL_FEATURE, "toLower"); //$NON-NLS-1$
	}
	
	/**
	 * Regression test to check that we can get the correct completions on
	 * the iterator variables in a loop expression.
	 */
	public void test_completionOnIteratorVariable_RATLC00537918() {
		IOCLHelper helper = HelperUtil.createOCLHelper();
		
		helper.setContext(EcorePackage.eINSTANCE.getEClass());
		List choices = helper.getSyntaxHelp(
				ConstraintType.INVARIANT,
				"self.eSuperTypes->collect(i : EClass | i."); //$NON-NLS-1$
		
		assertChoice(choices, ChoiceType.STRUCTURAL_FEATURE, "ePackage"); //$NON-NLS-1$
	}
	
	/**
	 * Regression test to check that we can get the correct completions on
	 * the accumulator (second iterator variable) in "iterate" expressions.
	 */
	public void test_completionOnAccumulator_RATLC00537918() {
		IOCLHelper helper = HelperUtil.createOCLHelper();
		
		helper.setContext(EcorePackage.eINSTANCE.getEClass());
		List choices = helper.getSyntaxHelp(
				ConstraintType.INVARIANT,
				"self.eSuperTypes->iterate(i : EClass; a : String = '' | a."); //$NON-NLS-1$
		
		assertChoice(choices, ChoiceType.BEHAVIORAL_FEATURE, "concat"); //$NON-NLS-1$
		
		// try completion on the iterator variable, also
		choices = helper.getSyntaxHelp(
				ConstraintType.INVARIANT,
				"self.eSuperTypes->iterate(i : EClass; a : String = '' | a.concat(i."); //$NON-NLS-1$
	
		assertChoice(choices, ChoiceType.STRUCTURAL_FEATURE, "name"); //$NON-NLS-1$
	}
	
	/**
	 * Regression test to check that we can get the correct completions on
	 * the an "iterate" expression (which formerly would be empty).
	 */
	public void test_completionOnIterate_RATLC00537918() {
		IOCLHelper helper = HelperUtil.createOCLHelper();
		
		helper.setContext(EcorePackage.eINSTANCE.getEClass());
		List choices = helper.getSyntaxHelp(
				ConstraintType.INVARIANT,
				"self.eSuperTypes->iterate(i : EClass; a : String = '' | a.concat(i.name))."); //$NON-NLS-1$
		
		assertChoice(choices, ChoiceType.BEHAVIORAL_FEATURE, "concat"); //$NON-NLS-1$
	}
	
	/**
	 * Regression test to check that we can get the correct completions on
	 * the an iterator expression (which formerly would be empty) resulting in
	 * a sequence.
	 */
	public void test_completionOnIterator_sequence_RATLC00537918() {
		IOCLHelper helper = HelperUtil.createOCLHelper();
		
		helper.setContext(EcorePackage.eINSTANCE.getEClass());
		List choices = helper.getSyntaxHelp(
				ConstraintType.INVARIANT,
				"Sequence{'abc', 'a', 'ab'}->"); //$NON-NLS-1$
		
		assertChoice(choices, ChoiceType.BEHAVIORAL_FEATURE, "subSequence"); //$NON-NLS-1$
	}
	
	/**
	 * Regression test to check that we can get the correct completions on
	 * the an iterator expression (which formerly would be empty) resulting in
	 * an ordered set.
	 */
	public void test_completionOnIterator_orderedSet_RATLC00537918() {
		IOCLHelper helper = HelperUtil.createOCLHelper();
		
		helper.setContext(EcorePackage.eINSTANCE.getEClass());
		List choices = helper.getSyntaxHelp(
				ConstraintType.INVARIANT,
				"self.eSuperTypes->select(i : EClass | i.eSuperTypes->isEmpty())->"); //$NON-NLS-1$
		
		assertChoice(choices, ChoiceType.BEHAVIORAL_FEATURE, "subOrderedSet"); //$NON-NLS-1$
	}
	
	/**
	 * Regression test to check that we can get the correct completions on
	 * the an iterator expression (which formerly would be empty) resulting in
	 * a bag.
	 */
	public void test_completionOnIterator_bag_RATLC00537918() {
		IOCLHelper helper = HelperUtil.createOCLHelper();
		
		helper.setContext(EcorePackage.eINSTANCE.getEClass());
		List choices = helper.getSyntaxHelp(
				ConstraintType.INVARIANT,
				"Set{'abc', 'a', 'ab'}->collect(i : String | i.size())->"); //$NON-NLS-1$
		
		// bags do not support symmetricDifference as sets do
		assertNotChoice(choices, ChoiceType.BEHAVIORAL_FEATURE, "symmetricDifference"); //$NON-NLS-1$
	}
	
	/**
	 * Regression test to check that we can get the correct completions on
	 * an if expression if it is eclosed in parentheses.
	 */
	public void test_completionOnIfExpression_RATLC00537918() {
		IOCLHelper helper = HelperUtil.createOCLHelper();
		
		helper.setContext(EcorePackage.eINSTANCE.getEClass());
		List choices = helper.getSyntaxHelp(
				ConstraintType.INVARIANT,
				"(if true then 'a' else 'b' endif)."); //$NON-NLS-1$
		
		assertChoice(choices, ChoiceType.BEHAVIORAL_FEATURE, "concat"); //$NON-NLS-1$
		
		choices = helper.getSyntaxHelp(
				ConstraintType.INVARIANT,
				"if true then 'a' else 'b' endif."); //$NON-NLS-1$
	
		// we don't support completion of the "endif" token, though
		assertNotChoice(choices, ChoiceType.BEHAVIORAL_FEATURE, "concat"); //$NON-NLS-1$
	}
	
	/**
	 * Regression test to check that we can get suggestions for variable names
	 * when invoking syntax completion without a ".", "->", or "::" trigger
	 * in invariant constraints.
	 */
	public void test_variables_RATLC00535552() {
		IOCLHelper helper = HelperUtil.createOCLHelper();
		
		helper.setContext(EcorePackage.eINSTANCE.getEClass());
		List choices = helper.getSyntaxHelp(
				ConstraintType.INVARIANT,
				"let pkgName : String = ePackage.name in"); //$NON-NLS-1$
		
		assertChoice(choices, ChoiceType.VARIABLE, "pkgName"); //$NON-NLS-1$
		
		// also should get "self"
		assertChoice(choices, ChoiceType.VARIABLE, "self"); //$NON-NLS-1$
		
		// also should get suggestions of structural features of "self"
		assertChoice(choices, ChoiceType.STRUCTURAL_FEATURE, "eSuperTypes"); //$NON-NLS-1$
		
		// also should get suggestions of behavioral features of "self"
		assertChoice(choices, ChoiceType.BEHAVIORAL_FEATURE, "oclAsType"); //$NON-NLS-1$
		
		choices = helper.getSyntaxHelp(
				ConstraintType.INVARIANT,
				"eSuperTypes->collect(st : EClass | "); //$NON-NLS-1$
	
		// loop variables
		assertChoice(choices, ChoiceType.VARIABLE, "st"); //$NON-NLS-1$
	}
	
	/**
	 * Regression test to check that we can get suggestions for parameter names
	 * when invoking syntax completion without a ".", "->", or "::" trigger
	 * in operation constraints.
	 */
	public void test_parameters_RATLC00535552() {
		IOCLHelper helper = HelperUtil.createOCLHelper();
		
		helper.setContextOperation(apple, apple_labelOper);
		List choices = helper.getSyntaxHelp(
				ConstraintType.INVARIANT,
				"'' <> "); //$NON-NLS-1$
		
		// operation parameter
		assertChoice(choices, ChoiceType.VARIABLE, "text"); //$NON-NLS-1$
	}
	
	/**
	 * Regression test to check that we can get suggestions for partial names
	 * when invoking syntax completion without a ".", "->", or "::" trigger
	 * in invariant constraints.
	 */
	public void test_partial_property_RATLC00535552() {
		IOCLHelper helper = HelperUtil.createOCLHelper();
		
		helper.setContext(EcorePackage.eINSTANCE.getEClass());
		List choices = helper.getSyntaxHelp(
				ConstraintType.INVARIANT,
				"self.eSuper"); //$NON-NLS-1$
		
		assertChoice(choices, ChoiceType.STRUCTURAL_FEATURE, "eSuperTypes"); //$NON-NLS-1$
		assertNotChoice(choices, ChoiceType.STRUCTURAL_FEATURE, "ePackage"); //$NON-NLS-1$
	}
	
	/**
	 * Regression test to check that we can get suggestions for partial names
	 * when invoking syntax completion without a ".", "->", or "::" trigger
	 * in invariant constraints.
	 */
	public void test_partial_operation_RATLC00535552() {
		IOCLHelper helper = HelperUtil.createOCLHelper();
		
		helper.setContext(EcorePackage.eINSTANCE.getEClass());
		List choices = helper.getSyntaxHelp(
				ConstraintType.INVARIANT,
				"self.oclIs"); //$NON-NLS-1$
		
		assertChoice(choices, ChoiceType.BEHAVIORAL_FEATURE, "oclIsUndefined"); //$NON-NLS-1$
		assertNotChoice(choices, ChoiceType.BEHAVIORAL_FEATURE, "oclAsType"); //$NON-NLS-1$
	}
	
	/**
	 * Regression test to check that we can get suggestions for partial names
	 * when invoking syntax completion without a ".", "->", or "::" trigger
	 * in invariant constraints.
	 */
	public void test_partial_type_RATLC00535552() {
		IOCLHelper helper = HelperUtil.createOCLHelper();
		
		helper.setContext(EcorePackage.eINSTANCE.getEClassifier());
		List choices = helper.getSyntaxHelp(
				ConstraintType.INVARIANT,
				"if self.oclIsKindOf(ecore::ECl"); //$NON-NLS-1$
		
		assertChoice(choices, ChoiceType.STRUCTURAL_FEATURE, "EClass"); //$NON-NLS-1$
		assertNotChoice(choices, ChoiceType.STRUCTURAL_FEATURE, "EEnum"); //$NON-NLS-1$
	}
	
	/**
	 * Regression test to check that we can get suggestions for partial names
	 * when invoking syntax completion without a ".", "->", or "::" trigger
	 * in invariant constraints.
	 */
	public void test_partial_enumLiteral_RATLC00535552() {
		IOCLHelper helper = HelperUtil.createOCLHelper();
		
		helper.setContext(apple);
		List choices = helper.getSyntaxHelp(
				ConstraintType.INVARIANT,
				"if color <> Color::bl"); //$NON-NLS-1$
		
		assertChoice(choices, ChoiceType.STRUCTURAL_FEATURE, "black"); //$NON-NLS-1$
		assertNotChoice(choices, ChoiceType.STRUCTURAL_FEATURE, "red"); //$NON-NLS-1$
	}
	
	/**
	 * Regression test to check that we can get suggestions for partial names
	 * when invoking syntax completion without a ".", "->", or "::" trigger
	 * in invariant constraints.
	 */
	public void test_partial_collectionOperation_RATLC00535552() {
		IOCLHelper helper = HelperUtil.createOCLHelper();
		
		helper.setContext(apple);
		List choices = helper.getSyntaxHelp(
				ConstraintType.INVARIANT,
				"Apple.allInstances()->symm"); //$NON-NLS-1$
		
		assertChoice(choices, ChoiceType.BEHAVIORAL_FEATURE, "symmetricDifference"); //$NON-NLS-1$
		assertNotChoice(choices, ChoiceType.BEHAVIORAL_FEATURE, "collect"); //$NON-NLS-1$
	}
	
	/**
	 * Regression test to check that we can get suggestions for variable names
	 * from an empty string.
	 */
	public void test_emptyExpression_RATLC00535552() {
		IOCLHelper helper = HelperUtil.createOCLHelper();
		
		helper.setContext(apple);
		List choices = helper.getSyntaxHelp(
				ConstraintType.INVARIANT,
				""); //$NON-NLS-1$
		
		assertChoice(choices, ChoiceType.VARIABLE, "self"); //$NON-NLS-1$
		assertChoice(choices, ChoiceType.STRUCTURAL_FEATURE, "stem"); //$NON-NLS-1$
		assertChoice(choices, ChoiceType.ENUMERATION_LITERAL, "color"); //$NON-NLS-1$
	}
	
	/**
	 * Regression test to check that we can get suggestions for variable names
	 * from an utterly unparseable expression.
	 */
	public void test_garbageExpression_RATLC00535552() {
		IOCLHelper helper = HelperUtil.createOCLHelper();
		
		helper.setContext(apple);
		List choices = helper.getSyntaxHelp(
				ConstraintType.INVARIANT,
				"{@grr!"); //$NON-NLS-1$
		
		assertChoice(choices, ChoiceType.VARIABLE, "self"); //$NON-NLS-1$
		assertChoice(choices, ChoiceType.STRUCTURAL_FEATURE, "stem"); //$NON-NLS-1$
		assertChoice(choices, ChoiceType.ENUMERATION_LITERAL, "color"); //$NON-NLS-1$
	}
	
	/**
	 * Tests that the oclIsNew() operation is only suggested in postcondition
	 * context.
	 */
	public void test_oclIsNewOnlyInPostconditions_116664() {
		IOCLHelper helper = HelperUtil.createOCLHelper();
		
		helper.setContext(apple);
		
		List choices = helper.getSyntaxHelp(ConstraintType.INVARIANT, "self.ocl"); //$NON-NLS-1$
		assertNotChoice(choices, ChoiceType.BEHAVIORAL_FEATURE, "oclIsNew"); //$NON-NLS-1$
		
		helper.setContext(apple_newApple);
		
		choices = helper.getSyntaxHelp(ConstraintType.PRECONDITION, "self.ocl"); //$NON-NLS-1$
		assertNotChoice(choices, ChoiceType.BEHAVIORAL_FEATURE, "oclIsNew"); //$NON-NLS-1$
		
		choices = helper.getSyntaxHelp(ConstraintType.BODYCONDITION, "self.ocl"); //$NON-NLS-1$
		assertNotChoice(choices, ChoiceType.BEHAVIORAL_FEATURE, "oclIsNew"); //$NON-NLS-1$
		
		// this time we should find this choice
		choices = helper.getSyntaxHelp(ConstraintType.POSTCONDITION, "self.ocl"); //$NON-NLS-1$
		assertChoice(choices, ChoiceType.BEHAVIORAL_FEATURE, "oclIsNew"); //$NON-NLS-1$
	}
}
