/**
 * <copyright>
 *
 * Copyright (c) 2005, 2007 IBM Corporation and others.
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
 * $Id: SyntaxHelpTest.java,v 1.4 2009/11/28 18:03:15 ewillink Exp $
 */

package org.eclipse.ocl.uml.helper.tests;

import java.util.Collection;
import java.util.List;

import org.eclipse.ocl.helper.Choice;
import org.eclipse.ocl.helper.ChoiceKind;
import org.eclipse.ocl.helper.ConstraintKind;

/**
 * Tests the syntax help support, esp. for operation context.
 *
 * @author Christian W. Damus (cdamus)
 */
@SuppressWarnings("nls")
public class SyntaxHelpTest
	extends AbstractTestSuite {
	
	/**
	 * Tests completion of enumeration literals in classifier invariant
	 * constraints.
	 */
	public void test_completeInvariant_enumLiteral() {
		helper.setContext(fruit);
		
		try {
			List<Choice> choices = helper.getSyntaxHelp(
					ConstraintKind.INVARIANT,
					"color <> Color::");
			assertNotNull(choices);
			
			assertChoice(choices, ChoiceKind.ENUMERATION_LITERAL, "red");
			assertChoice(choices, ChoiceKind.ENUMERATION_LITERAL, "brown");
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage());
		}
	}
	
	/**
	 * Tests completion of attributes in classifier invariant
	 * constraints.
	 */
	public void test_completeInvariant_attribute() {
		helper.setContext(fruit);
		
		try {
			List<Choice> choices = helper.getSyntaxHelp(ConstraintKind.INVARIANT, "self.");
			assertNotNull(choices);
			
			assertChoice(choices, ChoiceKind.PROPERTY, "color");
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage());
		}
	}
	
	/**
	 * Tests completion of references (association ends) in classifier invariant
	 * constraints.
	 */
	public void test_completeInvariant_reference() {
		helper.setContext(apple);
		
		try {
			List<Choice> choices = helper.getSyntaxHelp(ConstraintKind.INVARIANT, "self.");
			assertNotNull(choices);
			
			assertChoice(choices, ChoiceKind.PROPERTY, "tree");
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage());
		}
	}
	
	/**
	 * Tests completion of operations in classifier invariant
	 * constraints.
	 */
	public void test_completeInvariant_operation() {
		helper.setContext(fruit);
		
		try {
			List<Choice> choices = helper.getSyntaxHelp(ConstraintKind.INVARIANT, "self.");
			assertNotNull(choices);
			
			assertChoice(choices, ChoiceKind.OPERATION, "preferredColor");
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage());
		}
	}
	
	/**
	 * Tests completion of enumeration literals in operation precondition
	 * constraints.
	 */
	public void test_completePrecondition_enumLiteral() {
		helper.setOperationContext(fruit, fruit_ripen);
		
		try {
			List<Choice> choices = helper.getSyntaxHelp(
					ConstraintKind.PRECONDITION,
					"color <> Color::");
			assertNotNull(choices);
			
			assertChoice(choices, ChoiceKind.ENUMERATION_LITERAL, "red");
			assertChoice(choices, ChoiceKind.ENUMERATION_LITERAL, "brown");
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage());
		}
	}
	
	/**
	 * Tests completion of attributes in operation body conditions.
	 */
	public void test_completeBodyCondition_attribute() {
		helper.setOperationContext(fruit, fruit_preferredColor);
		
		try {
			List<Choice> choices = helper.getSyntaxHelp(
					ConstraintKind.BODYCONDITION,
					"self.");
			assertNotNull(choices);
			
			assertChoice(choices, ChoiceKind.PROPERTY, "color");
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage());
		}
	}
	
	/**
	 * Tests completion of references (association ends) in operation precondition
	 * constraints.
	 */
	public void test_completePrecondition_reference() {
		helper.setOperationContext(apple, apple_labelOper);
		
		try {
			List<Choice> choices = helper.getSyntaxHelp(
					ConstraintKind.PRECONDITION,
					"self.");
			assertNotNull(choices);
			
			assertChoice(choices, ChoiceKind.PROPERTY, "tree");
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage());
		}
	}
	
	/**
	 * Tests completion of operations in operation postcondition
	 * constraints.
	 */
	public void test_completePostcondition_operation() {
		helper.setOperationContext(fruit, fruit_ripen);
		
		try {
			List<Choice> choices = helper.getSyntaxHelp(
					ConstraintKind.POSTCONDITION,
					"self.");
			assertNotNull(choices);
			
			assertChoice(choices, ChoiceKind.OPERATION, "preferredColor");
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage());
		}
	}
	
	/**
	 * Tests completion of parameters in operation precondition
	 * constraints.
	 */
	public void test_completePrecondition_parameter() {
		helper.setOperationContext(fruit, apple_labelOper);
		
		try {
			List<Choice> choices = helper.getSyntaxHelp(
					ConstraintKind.PRECONDITION,
					"text.");
			assertNotNull(choices);
			
			assertChoice(choices, ChoiceKind.OPERATION, "toLower");
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage());
		}
	}
	
	/**
	 * Tests completion of the result variable in operation postcondition
	 * constraints.
	 */
	public void test_completePostcondition_result() {
		helper.setOperationContext(fruit, fruit_preferredColor);
		
		try {
			List<Choice> choices = helper.getSyntaxHelp(
					ConstraintKind.POSTCONDITION,
					"result.");
			assertNotNull(choices);
			
			assertChoice(choices, ChoiceKind.OPERATION, "oclIsUndefined");
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage());
		}
	}
	
	/**
	 * Tests that allInstances() is only suggested for type expressions.
	 */
	public void test_allInstances() {
		helper.setContext(apple);
		
		try {
			List<Choice> choices = helper.getSyntaxHelp(ConstraintKind.INVARIANT, "self.");
			assertNotNull(choices);
			
			assertNotChoice(choices, ChoiceKind.OPERATION, "allInstances");
			
			choices = helper.getSyntaxHelp(ConstraintKind.INVARIANT, "Apple.");
			assertNotNull(choices);
			
			assertChoice(choices, ChoiceKind.OPERATION, "allInstances");
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage());
		}
	}
	
	/**
	 * Obtains all of the choices for the OclAny type and prints them out.
	 */
	public void test_anyChoices() {
		helper.setContext(apple);
		
		try {
			List<Choice> choices = helper.getSyntaxHelp(ConstraintKind.INVARIANT, "self.oclAsType(OclAny).");
			dumpChoices(choices);
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage());
		}
	}
	
	/**
	 * Obtains all of the choices for a UML class and prints them out.
	 */
	public void test_eclassChoices() {
		helper.setContext(apple);
		
		try {
			List<Choice> choices = helper.getSyntaxHelp(ConstraintKind.INVARIANT, "self.");
			dumpChoices(choices);
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage());
		}
	}
	
	/**
	 * Obtains all of the choices for a tuple type and prints them out.
	 */
	public void test_tupleChoices() {
		helper.setContext(apple);
		
		try {
			List<Choice> choices = helper.getSyntaxHelp(ConstraintKind.INVARIANT,
					"Tuple{s : String = null, a : Apple = null}.");
			dumpChoices(choices);
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage());
		}
	}
	
	/**
	 * Obtains all of the choices for the OclType type and prints them out.
	 */
	public void test_typeChoices() {
		helper.setContext(apple);
		
		try {
			List<Choice> choices = helper.getSyntaxHelp(ConstraintKind.INVARIANT, "Apple.");
			dumpChoices(choices);
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage());
		}
	}
	
	/**
	 * Obtains all of the choices for the Integer type and prints them out.
	 */
	public void test_integerChoices() {
		helper.setContext(apple);
		
		try {
			List<Choice> choices = helper.getSyntaxHelp(ConstraintKind.INVARIANT, "1.");
			dumpChoices(choices);
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage());
		}
	}
	
	/**
	 * Obtains all of the choices for the Real type and prints them out.
	 */
	public void test_realChoices() {
		helper.setContext(apple);
		
		try {
			List<Choice> choices = helper.getSyntaxHelp(ConstraintKind.INVARIANT, "1.0.");
			dumpChoices(choices);
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage());
		}
	}
	
	/**
	 * Obtains all of the choices for the String type and prints them out.
	 */
	public void test_stringChoices() {
		helper.setContext(apple);
		
		try {
			List<Choice> choices = helper.getSyntaxHelp(ConstraintKind.INVARIANT, "'foo'.");
			dumpChoices(choices);
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage());
		}
	}
	
	/**
	 * Obtains all of the choices for the Set type and prints them out.
	 */
	public void test_setChoices() {
		helper.setContext(apple);
		
		try {
			List<Choice> choices = helper.getSyntaxHelp(ConstraintKind.INVARIANT, "Set{self}->");
			dumpChoices(choices);
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage());
		}
	}
	
	/**
	 * Obtains all of the choices for the OrderedSet type and prints them out.
	 */
	public void test_orderedSetChoices() {
		helper.setContext(apple);
		
		try {
			List<Choice> choices = helper.getSyntaxHelp(ConstraintKind.INVARIANT, "OrderedSet{self}->");
			dumpChoices(choices);
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage());
		}
	}
	
	/**
	 * Obtains all of the choices for the Sequence type and prints them out.
	 */
	public void test_sequenceChoices() {
		helper.setContext(apple);
		
		try {
			List<Choice> choices = helper.getSyntaxHelp(ConstraintKind.INVARIANT, "Sequence{self}->");
			dumpChoices(choices);
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage());
		}
	}
	
	/**
	 * Obtains all of the choices for the Bag type and prints them out.
	 */
	public void test_bagChoices() {
		helper.setContext(apple);
		
		try {
			List<Choice> choices = helper.getSyntaxHelp(ConstraintKind.INVARIANT, "Bag{self}->");
			dumpChoices(choices);
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage());
		}
	}
	
	/**
	 * Obtains all of the choices for a nested collection type and prints them out.
	 */
	public void test_nestedCollectionChoices() {
		helper.setContext(apple);
		
		try {
			List<Choice> choices = helper.getSyntaxHelp(ConstraintKind.INVARIANT, "Set{Sequence{self}}->");
			dumpChoices(choices);
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage());
		}
	}
	
	/**
	 * Obtains all of the choices for a state expression and prints them out.
	 */
	public void test_stateChoices() {
		helper.setContext(apple);
		
		try {
			List<Choice> choices = helper.getSyntaxHelp(
					ConstraintKind.INVARIANT, "self.oclIsInState(");
			dumpChoices(choices);
			
			System.out.println("----");
			
			choices = helper.getSyntaxHelp(
					ConstraintKind.INVARIANT, "self.oclIsInState(Bad::");
			dumpChoices(choices);
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage());
		}
	}
	
	/**
	 * Obtains all of the choices for a message expression and prints them out.
	 */
	public void test_messageChoices() {
		helper.setOperationContext(apple, fruit_ripen);
		
		try {
			List<Choice> choices = helper.getSyntaxHelp(
					ConstraintKind.POSTCONDITION, "self^^");
			dumpChoices(choices);
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage());
		}
	}
	
	//
	// Test framework
	//
	
	private void dumpChoices(Collection<Choice> choices) {
		assertNotNull(choices);
		
		for (Choice next : choices) {
			System.out.println("    " + next);
		}
	}
}
