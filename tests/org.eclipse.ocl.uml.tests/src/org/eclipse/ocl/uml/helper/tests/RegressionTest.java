/**
 * <copyright>
 *
 * Copyright (c) 2005, 2008 IBM Corporation, Zeligsoft Inc., and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   Zeligsoft - Bug 207365
 *
 * </copyright>
 *
 * $Id: RegressionTest.java,v 1.4 2009/10/07 20:42:33 ewillink Exp $
 */

package org.eclipse.ocl.uml.helper.tests;

import java.util.List;

import org.eclipse.ocl.helper.Choice;
import org.eclipse.ocl.helper.ChoiceKind;
import org.eclipse.ocl.helper.ConstraintKind;
import org.eclipse.uml2.uml.Classifier;

/**
 * Regression tests for specific RATLC defects.
 *
 * @author Christian W. Damus (cdamus)
 */
public class RegressionTest
	extends AbstractTestSuite {

	/**
	 * Regression test to check that we complete on the right-most
	 * sub-expression to the left of the '.' (i.e., not treating this
	 * particular case as a boolean expression "self.opposite = self" to be
	 * completed).
	 */
	public void test_completionOfRightmostSubexpression_RATLC00537918() {
		helper.setContext(getMetaclass("Property")); //$NON-NLS-1$
		List<Choice> choices = helper.getSyntaxHelp(
				ConstraintKind.INVARIANT,
				"self.opposite = self."); //$NON-NLS-1$
		
		// formerly, the choices offered would be the choices appropriate to
		//    the OCL Boolean type, because that is the type of
		//    "self.eOpposite = self".  We want, instead, completions for
		//    "self" which is the right-most minimal subexpression
		assertChoice(choices, ChoiceKind.PROPERTY, "opposite"); //$NON-NLS-1$
	}
	
	/**
	 * Regression test to check that we complete on the right-most
	 * sub-expression to the left of the '.', accounting for closing
	 * parentheses.
	 */
	public void test_completionOfRightmost_parentheses_RATLC00537918() {
		helper.setContext(getMetaclass("Property")); //$NON-NLS-1$
		List<Choice> choices = helper.getSyntaxHelp(
				ConstraintKind.INVARIANT,
				"(self.opposite = self)."); //$NON-NLS-1$
		
		// in this case, the right-most subexpression really is the entire
		//    "self.eOpposite = self" because of the parenthesization, so we
		//    should get the Boolean choices, not EReference choices
		assertNotChoice(choices, ChoiceKind.PROPERTY, "opposite"); //$NON-NLS-1$
		assertChoice(choices, ChoiceKind.OPERATION, "oclIsUndefined"); //$NON-NLS-1$
	}
	
	/**
	 * Regression test to check that we can get the correct completions on
	 * the let variables in a let expression.
	 */
	public void test_completionOnLetVariable_RATLC00537918() {
		helper.setContext(getMetaclass("Class")); //$NON-NLS-1$
		List<Choice> choices = helper.getSyntaxHelp(
				ConstraintKind.INVARIANT,
				"let p : Package = self.getNearestPackage() in 'foo_'.concat(p."); //$NON-NLS-1$
		
		assertChoice(choices, ChoiceKind.PROPERTY, "ownedType"); //$NON-NLS-1$
		assertChoice(choices, ChoiceKind.PROPERTY, "nestedPackage"); //$NON-NLS-1$
	}
	
	/**
	 * Regression test to check that we can get the correct completions on
	 * let expressions as a whole.
	 */
	public void test_completionOnLetExpression_RATLC00537918() {
		helper.setContext(getMetaclass("Class")); //$NON-NLS-1$
		List<Choice> choices = helper.getSyntaxHelp(
				ConstraintKind.INVARIANT,
				"(let p : Package = self.getNearestPackage() in p.name)."); //$NON-NLS-1$
		
		assertChoice(choices, ChoiceKind.OPERATION, "toLower"); //$NON-NLS-1$
	}
	
	/**
	 * Regression test to check that we can get the correct completions on
	 * the iterator variables in a loop expression.
	 */
	public void test_completionOnIteratorVariable_RATLC00537918() {
		helper.setContext(getMetaclass("Class")); //$NON-NLS-1$
		List<Choice> choices = helper.getSyntaxHelp(
				ConstraintKind.INVARIANT,
				"self.superClass->collect(i : Class | i."); //$NON-NLS-1$
		
		assertChoice(choices, ChoiceKind.OPERATION, "getNearestPackage"); //$NON-NLS-1$
		assertChoice(choices, ChoiceKind.PROPERTY, "package"); //$NON-NLS-1$
	}
	
	/**
	 * Regression test to check that we can get the correct completions on
	 * the accumulator (second iterator variable) in "iterate" expressions.
	 */
	public void test_completionOnAccumulator_RATLC00537918() {
		helper.setContext(getMetaclass("Class")); //$NON-NLS-1$
		List<Choice> choices = helper.getSyntaxHelp(
				ConstraintKind.INVARIANT,
				"self.superClass->iterate(i : Class; a : String = '' | a."); //$NON-NLS-1$
		
		assertChoice(choices, ChoiceKind.OPERATION, "concat"); //$NON-NLS-1$
		
		// try completion on the iterator variable, also
		choices = helper.getSyntaxHelp(
				ConstraintKind.INVARIANT,
				"self.superClass->iterate(i : Class; a : String = '' | a.concat(i."); //$NON-NLS-1$
	
		assertChoice(choices, ChoiceKind.PROPERTY, "name"); //$NON-NLS-1$
	}
	
	/**
	 * Regression test to check that we can get the correct completions on
	 * the an "iterate" expression (which formerly would be empty).
	 */
	public void test_completionOnIterate_RATLC00537918() {
		helper.setContext(getMetaclass("Class")); //$NON-NLS-1$
		List<Choice> choices = helper.getSyntaxHelp(
				ConstraintKind.INVARIANT,
				"self.superClass->iterate(i : Class; a : String = '' | a.concat(i.name))."); //$NON-NLS-1$
		
		assertChoice(choices, ChoiceKind.OPERATION, "concat"); //$NON-NLS-1$
	}
	
	/**
	 * Regression test to check that we can get the correct completions on
	 * the an iterator expression (which formerly would be empty) resulting in
	 * a sequence.
	 */
	public void test_completionOnIterator_sequence_RATLC00537918() {
		helper.setContext((Classifier) umlMetamodel.getOwnedType("Class")); //$NON-NLS-1$
		List<Choice> choices = helper.getSyntaxHelp(
				ConstraintKind.INVARIANT,
				"Sequence{'abc', 'a', 'ab'}->"); //$NON-NLS-1$
		
		assertChoice(choices, ChoiceKind.OPERATION, "subSequence"); //$NON-NLS-1$
	}
	
	/**
	 * Regression test to check that we can get the correct completions on
	 * the an iterator expression (which formerly would be empty) resulting in
	 * an ordered set.
	 */
	public void test_completionOnIterator_orderedSet_RATLC00537918() {
		helper.setContext(getMetaclass("Class")); //$NON-NLS-1$
		List<Choice> choices = helper.getSyntaxHelp(
				ConstraintKind.INVARIANT,
				"self.ownedAttribute->select(i : Property | i.redefinedProperty->isEmpty())->"); //$NON-NLS-1$
		
		assertChoice(choices, ChoiceKind.OPERATION, "subOrderedSet"); //$NON-NLS-1$
	}
	
	/**
	 * Regression test to check that we can get the correct completions on
	 * the an iterator expression (which formerly would be empty) resulting in
	 * a bag.
	 */
	public void test_completionOnIterator_bag_RATLC00537918() {
		helper.setContext(getMetaclass("Class")); //$NON-NLS-1$
		List<Choice> choices = helper.getSyntaxHelp(
				ConstraintKind.INVARIANT,
				"Set{'abc', 'a', 'ab'}->collect(i : String | i.size())->"); //$NON-NLS-1$
		
		// bags do not support symmetricDifference as sets do
		assertNotChoice(choices, ChoiceKind.OPERATION, "symmetricDifference"); //$NON-NLS-1$
	}
	
	/**
	 * Regression test to check that we can get the correct completions on
	 * an if expression if it is eclosed in parentheses.
	 */
	public void test_completionOnIfExpression_RATLC00537918() {
		helper.setContext(getMetaclass("Class")); //$NON-NLS-1$
		List<Choice> choices = helper.getSyntaxHelp(
				ConstraintKind.INVARIANT,
				"(if true then 'a' else 'b' endif)."); //$NON-NLS-1$
		
		assertChoice(choices, ChoiceKind.OPERATION, "concat"); //$NON-NLS-1$
		
		choices = helper.getSyntaxHelp(
				ConstraintKind.INVARIANT,
				"if true then 'a' else 'b' endif."); //$NON-NLS-1$
	
		// we don't support completion of the "endif" token, though
		assertNotChoice(choices, ChoiceKind.OPERATION, "concat"); //$NON-NLS-1$
	}
	
	/**
	 * Regression test to check that we can get suggestions for variable names
	 * when invoking syntax completion without a ".", "->", or "::" trigger
	 * in invariant constraints.
	 */
	public void test_variables_RATLC00535552() {
		helper.setContext(getMetaclass("Class")); //$NON-NLS-1$
		List<Choice> choices = helper.getSyntaxHelp(
				ConstraintKind.INVARIANT,
				"let pkgName : String = getNearestPackage().name in"); //$NON-NLS-1$
		
		assertChoice(choices, ChoiceKind.VARIABLE, "pkgName"); //$NON-NLS-1$
		
		// also should get "self"
		assertChoice(choices, ChoiceKind.VARIABLE, "self"); //$NON-NLS-1$
		
		// also should get suggestions of structural features of "self"
		assertChoice(choices, ChoiceKind.PROPERTY, "superClass"); //$NON-NLS-1$
		
		// also should get suggestions of behavioral features of "self"
		assertChoice(choices, ChoiceKind.OPERATION, "allParents"); //$NON-NLS-1$
		assertChoice(choices, ChoiceKind.OPERATION, "oclAsType"); //$NON-NLS-1$
		
		choices = helper.getSyntaxHelp(
				ConstraintKind.INVARIANT,
				"superClass->collect(sc : Class | "); //$NON-NLS-1$
	
		// loop variables
		assertChoice(choices, ChoiceKind.VARIABLE, "sc"); //$NON-NLS-1$
	}
	
	/**
	 * Regression test to check that we can get suggestions for parameter names
	 * when invoking syntax completion without a ".", "->", or "::" trigger
	 * in operation constraints.
	 */
	public void test_parameters_RATLC00535552() {
		helper.setOperationContext(apple, apple_labelOper);
		List<Choice> choices = helper.getSyntaxHelp(
				ConstraintKind.INVARIANT,
				"'' <> "); //$NON-NLS-1$
		
		// operation parameter
		assertChoice(choices, ChoiceKind.VARIABLE, "text"); //$NON-NLS-1$
	}
	
	/**
	 * Regression test to check that we can get suggestions for partial names
	 * when invoking syntax completion without a ".", "->", or "::" trigger
	 * in invariant constraints.
	 */
	public void test_partial_property_RATLC00535552() {
		helper.setContext(getMetaclass("Classifier")); //$NON-NLS-1$
		List<Choice> choices = helper.getSyntaxHelp(
				ConstraintKind.INVARIANT,
				"self.gen"); //$NON-NLS-1$
		
		assertChoice(choices, ChoiceKind.PROPERTY, "general"); //$NON-NLS-1$
		assertChoice(choices, ChoiceKind.PROPERTY, "generalization"); //$NON-NLS-1$
		assertNotChoice(choices, ChoiceKind.OPERATION, "getNearestPackage"); //$NON-NLS-1$
	}
	
	/**
	 * Regression test to check that we can get suggestions for partial names
	 * when invoking syntax completion without a ".", "->", or "::" trigger
	 * in invariant constraints.
	 */
	public void test_partial_operation_RATLC00535552() {
		helper.setContext(getMetaclass("Class")); //$NON-NLS-1$
		List<Choice> choices = helper.getSyntaxHelp(
				ConstraintKind.INVARIANT,
				"self.allP"); //$NON-NLS-1$
		
		assertChoice(choices, ChoiceKind.OPERATION, "allParents"); //$NON-NLS-1$
		assertNotChoice(choices, ChoiceKind.OPERATION, "allFeatures"); //$NON-NLS-1$
		assertNotChoice(choices, ChoiceKind.OPERATION, "oclAsType"); //$NON-NLS-1$
	}
	
	/**
	 * Regression test to check that we can get suggestions for partial names
	 * when invoking syntax completion without a ".", "->", or "::" trigger
	 * in invariant constraints.
	 */
	public void test_partial_type_RATLC00535552() {
		helper.setContext(getMetaclass("Classifier")); //$NON-NLS-1$
		List<Choice> choices = helper.getSyntaxHelp(
				ConstraintKind.INVARIANT,
				"if self.oclIsKindOf(uml::Cl"); //$NON-NLS-1$
		
		assertChoice(choices, ChoiceKind.TYPE, "Class"); //$NON-NLS-1$
		assertNotChoice(choices, ChoiceKind.TYPE, "Enumeration"); //$NON-NLS-1$
	}
	
	/**
	 * Regression test to check that we can get suggestions for partial names
	 * when invoking syntax completion without a ".", "->", or "::" trigger
	 * in invariant constraints.
	 */
	public void test_partial_enumLiteral_RATLC00535552() {
		helper.setContext(apple);
		List<Choice> choices = helper.getSyntaxHelp(
				ConstraintKind.INVARIANT,
				"if color <> Color::bl"); //$NON-NLS-1$
		
		assertChoice(choices, ChoiceKind.ENUMERATION_LITERAL, "black"); //$NON-NLS-1$
		assertNotChoice(choices, ChoiceKind.ENUMERATION_LITERAL, "red"); //$NON-NLS-1$
	}
	
	/**
	 * Regression test to check that we can get suggestions for partial names
	 * when invoking syntax completion without a ".", "->", or "::" trigger
	 * in invariant constraints.
	 */
	public void test_partial_collectionOperation_RATLC00535552() {
		helper.setContext(apple);
		List<Choice> choices = helper.getSyntaxHelp(
				ConstraintKind.INVARIANT,
				"Apple.allInstances()->symm"); //$NON-NLS-1$
		
		assertChoice(choices, ChoiceKind.OPERATION, "symmetricDifference"); //$NON-NLS-1$
		assertNotChoice(choices, ChoiceKind.OPERATION, "collect"); //$NON-NLS-1$
	}
	
	/**
	 * Regression test to check that we can get suggestions for variable names
	 * from an empty string.
	 */
	public void test_emptyExpression_RATLC00535552() {
		helper.setContext(apple);
		List<Choice> choices = helper.getSyntaxHelp(
				ConstraintKind.INVARIANT,
				""); //$NON-NLS-1$
		
		assertChoice(choices, ChoiceKind.VARIABLE, "self"); //$NON-NLS-1$
		assertChoice(choices, ChoiceKind.PROPERTY, "tree"); //$NON-NLS-1$
		assertChoice(choices, ChoiceKind.ASSOCIATION_CLASS, "stem"); //$NON-NLS-1$
		assertChoice(choices, ChoiceKind.PROPERTY, "color"); //$NON-NLS-1$
	}
	
	/**
	 * Regression test to check that we can get suggestions for variable names
	 * from an utterly unparseable expression.
	 */
	public void test_garbageExpression_RATLC00535552() {
		helper.setContext(apple);
		List<Choice> choices = helper.getSyntaxHelp(
				ConstraintKind.INVARIANT,
				"{@grr!"); //$NON-NLS-1$
		
		assertChoice(choices, ChoiceKind.VARIABLE, "self"); //$NON-NLS-1$
		assertChoice(choices, ChoiceKind.PROPERTY, "tree"); //$NON-NLS-1$
		assertChoice(choices, ChoiceKind.ASSOCIATION_CLASS, "stem"); //$NON-NLS-1$
		assertChoice(choices, ChoiceKind.PROPERTY, "color"); //$NON-NLS-1$
	}
	
	/**
	 * Tests that the oclIsNew() operation is only suggested in postcondition
	 * context.
	 */
	public void test_oclIsNewOnlyInPostconditions_116664() {
		helper.setContext(apple);
		
		List<Choice> choices = helper.getSyntaxHelp(ConstraintKind.INVARIANT, "self.ocl"); //$NON-NLS-1$
		assertNotChoice(choices, ChoiceKind.OPERATION, "oclIsNew"); //$NON-NLS-1$
		
		helper.setOperationContext(apple, apple_newApple);
		
		choices = helper.getSyntaxHelp(ConstraintKind.PRECONDITION, "self.ocl"); //$NON-NLS-1$
		assertNotChoice(choices, ChoiceKind.OPERATION, "oclIsNew"); //$NON-NLS-1$
		
		choices = helper.getSyntaxHelp(ConstraintKind.BODYCONDITION, "self.ocl"); //$NON-NLS-1$
		assertNotChoice(choices, ChoiceKind.OPERATION, "oclIsNew"); //$NON-NLS-1$
		
		// this time we should find this choice
		choices = helper.getSyntaxHelp(ConstraintKind.POSTCONDITION, "self.ocl"); //$NON-NLS-1$
		assertChoice(choices, ChoiceKind.OPERATION, "oclIsNew"); //$NON-NLS-1$
	}
}
