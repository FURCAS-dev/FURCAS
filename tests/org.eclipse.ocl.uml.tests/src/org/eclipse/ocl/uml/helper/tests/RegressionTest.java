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
 *   Zeligsoft - Bug 207365
 *
 * </copyright>
 *
 * $Id: RegressionTest.java,v 1.6 2009/11/28 18:01:12 ewillink Exp $
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
@SuppressWarnings("nls")
public class RegressionTest
	extends AbstractTestSuite {

	/**
	 * Regression test to check that we complete on the right-most
	 * sub-expression to the left of the '.' (i.e., not treating this
	 * particular case as a boolean expression "self.opposite = self" to be
	 * completed).
	 */
	public void test_completionOfRightmostSubexpression_RATLC00537918() {
		helper.setContext(getMetaclass("Property"));
		List<Choice> choices = helper.getSyntaxHelp(
				ConstraintKind.INVARIANT,
				"self.opposite = self.");
		
		// formerly, the choices offered would be the choices appropriate to
		//    the OCL Boolean type, because that is the type of
		//    "self.eOpposite = self".  We want, instead, completions for
		//    "self" which is the right-most minimal subexpression
		assertChoice(choices, ChoiceKind.PROPERTY, "opposite");
	}
	
	/**
	 * Regression test to check that we complete on the right-most
	 * sub-expression to the left of the '.', accounting for closing
	 * parentheses.
	 */
	public void test_completionOfRightmost_parentheses_RATLC00537918() {
		helper.setContext(getMetaclass("Property"));
		List<Choice> choices = helper.getSyntaxHelp(
				ConstraintKind.INVARIANT,
				"(self.opposite = self).");
		
		// in this case, the right-most subexpression really is the entire
		//    "self.eOpposite = self" because of the parenthesization, so we
		//    should get the Boolean choices, not EReference choices
		assertNotChoice(choices, ChoiceKind.PROPERTY, "opposite");
		assertChoice(choices, ChoiceKind.OPERATION, "oclIsUndefined");
	}
	
	/**
	 * Regression test to check that we can get the correct completions on
	 * the let variables in a let expression.
	 */
	public void test_completionOnLetVariable_RATLC00537918() {
		helper.setContext(getMetaclass("Class"));
		List<Choice> choices = helper.getSyntaxHelp(
				ConstraintKind.INVARIANT,
				"let p : Package = self.getNearestPackage() in 'foo_'.concat(p.");
		
		assertChoice(choices, ChoiceKind.PROPERTY, "ownedType");
		assertChoice(choices, ChoiceKind.PROPERTY, "nestedPackage");
	}
	
	/**
	 * Regression test to check that we can get the correct completions on
	 * let expressions as a whole.
	 */
	public void test_completionOnLetExpression_RATLC00537918() {
		helper.setContext(getMetaclass("Class"));
		List<Choice> choices = helper.getSyntaxHelp(
				ConstraintKind.INVARIANT,
				"(let p : Package = self.getNearestPackage() in p.name).");
		
		assertChoice(choices, ChoiceKind.OPERATION, "toLower");
	}
	
	/**
	 * Regression test to check that we can get the correct completions on
	 * the iterator variables in a loop expression.
	 */
	public void test_completionOnIteratorVariable_RATLC00537918() {
		helper.setContext(getMetaclass("Class"));
		List<Choice> choices = helper.getSyntaxHelp(
				ConstraintKind.INVARIANT,
				"self.superClass->collect(i : Class | i.");
		
		assertChoice(choices, ChoiceKind.OPERATION, "getNearestPackage");
		assertChoice(choices, ChoiceKind.PROPERTY, "package");
	}
	
	/**
	 * Regression test to check that we can get the correct completions on
	 * the accumulator (second iterator variable) in "iterate" expressions.
	 */
	public void test_completionOnAccumulator_RATLC00537918() {
		helper.setContext(getMetaclass("Class"));
		List<Choice> choices = helper.getSyntaxHelp(
				ConstraintKind.INVARIANT,
				"self.superClass->iterate(i : Class; a : String = '' | a.");
		
		assertChoice(choices, ChoiceKind.OPERATION, "concat");
		
		// try completion on the iterator variable, also
		choices = helper.getSyntaxHelp(
				ConstraintKind.INVARIANT,
				"self.superClass->iterate(i : Class; a : String = '' | a.concat(i.");
	
		assertChoice(choices, ChoiceKind.PROPERTY, "name");
	}
	
	/**
	 * Regression test to check that we can get the correct completions on
	 * the an "iterate" expression (which formerly would be empty).
	 */
	public void test_completionOnIterate_RATLC00537918() {
		helper.setContext(getMetaclass("Class"));
		List<Choice> choices = helper.getSyntaxHelp(
				ConstraintKind.INVARIANT,
				"self.superClass->iterate(i : Class; a : String = '' | a.concat(i.name)).");
		
		assertChoice(choices, ChoiceKind.OPERATION, "concat");
	}
	
	/**
	 * Regression test to check that we can get the correct completions on
	 * the an iterator expression (which formerly would be empty) resulting in
	 * a sequence.
	 */
	public void test_completionOnIterator_sequence_RATLC00537918() {
		helper.setContext((Classifier) getUMLMetamodel().getOwnedType("Class"));
		List<Choice> choices = helper.getSyntaxHelp(
				ConstraintKind.INVARIANT,
				"Sequence{'abc', 'a', 'ab'}->");
		
		assertChoice(choices, ChoiceKind.OPERATION, "subSequence");
	}
	
	/**
	 * Regression test to check that we can get the correct completions on
	 * the an iterator expression (which formerly would be empty) resulting in
	 * an ordered set.
	 */
	public void test_completionOnIterator_orderedSet_RATLC00537918() {
		helper.setContext(getMetaclass("Class"));
		List<Choice> choices = helper.getSyntaxHelp(
				ConstraintKind.INVARIANT,
				"self.ownedAttribute->select(i : Property | i.redefinedProperty->isEmpty())->");
		
		assertChoice(choices, ChoiceKind.OPERATION, "subOrderedSet");
	}
	
	/**
	 * Regression test to check that we can get the correct completions on
	 * the an iterator expression (which formerly would be empty) resulting in
	 * a bag.
	 */
	public void test_completionOnIterator_bag_RATLC00537918() {
		helper.setContext(getMetaclass("Class"));
		List<Choice> choices = helper.getSyntaxHelp(
				ConstraintKind.INVARIANT,
				"Set{'abc', 'a', 'ab'}->collect(i : String | i.size())->");
		
		// bags do not support symmetricDifference as sets do
		assertNotChoice(choices, ChoiceKind.OPERATION, "symmetricDifference");
	}
	
	/**
	 * Regression test to check that we can get the correct completions on
	 * an if expression if it is eclosed in parentheses.
	 */
	public void test_completionOnIfExpression_RATLC00537918() {
		helper.setContext(getMetaclass("Class"));
		List<Choice> choices = helper.getSyntaxHelp(
				ConstraintKind.INVARIANT,
				"(if true then 'a' else 'b' endif).");
		
		assertChoice(choices, ChoiceKind.OPERATION, "concat");
		
		choices = helper.getSyntaxHelp(
				ConstraintKind.INVARIANT,
				"if true then 'a' else 'b' endif.");
	
		// we don't support completion of the "endif" token, though
		assertNotChoice(choices, ChoiceKind.OPERATION, "concat");
	}
	
	/**
	 * Regression test to check that we can get suggestions for variable names
	 * when invoking syntax completion without a ".", "->", or "::" trigger
	 * in invariant constraints.
	 */
	public void test_variables_RATLC00535552() {
		helper.setContext(getMetaclass("Class"));
		List<Choice> choices = helper.getSyntaxHelp(
				ConstraintKind.INVARIANT,
				"let pkgName : String = getNearestPackage().name in");
		
		assertChoice(choices, ChoiceKind.VARIABLE, "pkgName");
		
		// also should get "self"
		assertChoice(choices, ChoiceKind.VARIABLE, "self");
		
		// also should get suggestions of structural features of "self"
		assertChoice(choices, ChoiceKind.PROPERTY, "superClass");
		
		// also should get suggestions of behavioral features of "self"
		assertChoice(choices, ChoiceKind.OPERATION, "allParents");
		assertChoice(choices, ChoiceKind.OPERATION, "oclAsType");
		
		choices = helper.getSyntaxHelp(
				ConstraintKind.INVARIANT,
				"superClass->collect(sc : Class | ");
	
		// loop variables
		assertChoice(choices, ChoiceKind.VARIABLE, "sc");
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
				"'' <> ");
		
		// operation parameter
		assertChoice(choices, ChoiceKind.VARIABLE, "text");
	}
	
	/**
	 * Regression test to check that we can get suggestions for partial names
	 * when invoking syntax completion without a ".", "->", or "::" trigger
	 * in invariant constraints.
	 */
	public void test_partial_property_RATLC00535552() {
		helper.setContext(getMetaclass("Classifier"));
		List<Choice> choices = helper.getSyntaxHelp(
				ConstraintKind.INVARIANT,
				"self.gen");
		
		assertChoice(choices, ChoiceKind.PROPERTY, "general");
		assertChoice(choices, ChoiceKind.PROPERTY, "generalization");
		assertNotChoice(choices, ChoiceKind.OPERATION, "getNearestPackage");
	}
	
	/**
	 * Regression test to check that we can get suggestions for partial names
	 * when invoking syntax completion without a ".", "->", or "::" trigger
	 * in invariant constraints.
	 */
	public void test_partial_operation_RATLC00535552() {
		helper.setContext(getMetaclass("Class"));
		List<Choice> choices = helper.getSyntaxHelp(
				ConstraintKind.INVARIANT,
				"self.allP");
		
		assertChoice(choices, ChoiceKind.OPERATION, "allParents");
		assertNotChoice(choices, ChoiceKind.OPERATION, "allFeatures");
		assertNotChoice(choices, ChoiceKind.OPERATION, "oclAsType");
	}
	
	/**
	 * Regression test to check that we can get suggestions for partial names
	 * when invoking syntax completion without a ".", "->", or "::" trigger
	 * in invariant constraints.
	 */
	public void test_partial_type_RATLC00535552() {
		helper.setContext(getMetaclass("Classifier"));
		List<Choice> choices = helper.getSyntaxHelp(
				ConstraintKind.INVARIANT,
				"if self.oclIsKindOf(uml::Cl");
		
		assertChoice(choices, ChoiceKind.TYPE, "Class");
		assertNotChoice(choices, ChoiceKind.TYPE, "Enumeration");
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
				"if color <> Color::bl");
		
		assertChoice(choices, ChoiceKind.ENUMERATION_LITERAL, "black");
		assertNotChoice(choices, ChoiceKind.ENUMERATION_LITERAL, "red");
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
				"Apple.allInstances()->symm");
		
		assertChoice(choices, ChoiceKind.OPERATION, "symmetricDifference");
		assertNotChoice(choices, ChoiceKind.OPERATION, "collect");
	}
	
	/**
	 * Regression test to check that we can get suggestions for variable names
	 * from an empty string.
	 */
	public void test_emptyExpression_RATLC00535552() {
		helper.setContext(apple);
		List<Choice> choices = helper.getSyntaxHelp(
				ConstraintKind.INVARIANT,
				"");
		
		assertChoice(choices, ChoiceKind.VARIABLE, "self");
		assertChoice(choices, ChoiceKind.PROPERTY, "tree");
		assertChoice(choices, ChoiceKind.ASSOCIATION_CLASS, "stem");
		assertChoice(choices, ChoiceKind.PROPERTY, "color");
	}
	
	/**
	 * Regression test to check that we can get suggestions for variable names
	 * from an utterly unparseable expression.
	 */
	public void test_garbageExpression_RATLC00535552() {
		helper.setContext(apple);
		List<Choice> choices = helper.getSyntaxHelp(
				ConstraintKind.INVARIANT,
				"{@grr!");
		
		assertChoice(choices, ChoiceKind.VARIABLE, "self");
		assertChoice(choices, ChoiceKind.PROPERTY, "tree");
		assertChoice(choices, ChoiceKind.ASSOCIATION_CLASS, "stem");
		assertChoice(choices, ChoiceKind.PROPERTY, "color");
	}
	
	/**
	 * Tests that the oclIsNew() operation is only suggested in postcondition
	 * context.
	 */
	public void test_oclIsNewOnlyInPostconditions_116664() {
		helper.setContext(apple);
		
		List<Choice> choices = helper.getSyntaxHelp(ConstraintKind.INVARIANT, "self.ocl");
		assertNotChoice(choices, ChoiceKind.OPERATION, "oclIsNew");
		
		helper.setOperationContext(apple, apple_newApple);
		
		choices = helper.getSyntaxHelp(ConstraintKind.PRECONDITION, "self.ocl");
		assertNotChoice(choices, ChoiceKind.OPERATION, "oclIsNew");
		
		choices = helper.getSyntaxHelp(ConstraintKind.BODYCONDITION, "self.ocl");
		assertNotChoice(choices, ChoiceKind.OPERATION, "oclIsNew");
		
		// this time we should find this choice
		choices = helper.getSyntaxHelp(ConstraintKind.POSTCONDITION, "self.ocl");
		assertChoice(choices, ChoiceKind.OPERATION, "oclIsNew");
	}
}
