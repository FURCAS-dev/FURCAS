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
 * $Id: SyntaxHelpTest.java,v 1.1 2007/01/25 18:32:32 cdamus Exp $
 */

package org.eclipse.ocl.ecore.helper.tests;

import java.util.Collection;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.tests.MessagesTest;
import org.eclipse.ocl.ecore.tests.StatesTest;
import org.eclipse.ocl.helper.Choice;
import org.eclipse.ocl.helper.ChoiceKind;
import org.eclipse.ocl.helper.ConstraintKind;

/**
 * Tests the syntax help support, esp. for operation context.
 *
 * @author Christian W. Damus (cdamus)
 */
public class SyntaxHelpTest
	extends AbstractTestSuite {

	/**
	 * Initializes me with my name.
	 */
	public SyntaxHelpTest(String name) {
		super(name);
	}
	
	public static Test suite() {
		return new TestSuite(SyntaxHelpTest.class, "Syntax Help Tests"); //$NON-NLS-1$
	}
	
	/**
	 * Basic completion test for metamodel level.
	 */
	public void testMetaModelCompletions() {
		helper.setContext(EcorePackage.eINSTANCE.getEClass());
		List<Choice> choices = helper.getSyntaxHelp(ConstraintKind.INVARIANT, "self."); //$NON-NLS-1$
		
		assertChoice(choices, ChoiceKind.PROPERTY, "eAttributes"); //$NON-NLS-1$
		
		choices = helper.getSyntaxHelp(ConstraintKind.INVARIANT, "self.name."); //$NON-NLS-1$
		
		assertChoice(choices, ChoiceKind.OPERATION, "toLower"); //$NON-NLS-1$
	}
	
	/**
	 * Tests completion of enumeration literals in classifier invariant
	 * constraints.
	 */
	public void test_completeInvariant_enumLiteral() {
		helper.setContext(fruit);
		
		try {
			List<Choice> choices = helper.getSyntaxHelp(
					ConstraintKind.INVARIANT,
					"color <> Color::"); //$NON-NLS-1$
			assertNotNull(choices);
			
			assertChoice(choices, ChoiceKind.ENUMERATION_LITERAL, "red"); //$NON-NLS-1$
			assertChoice(choices, ChoiceKind.ENUMERATION_LITERAL, "brown"); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests completion of attributes in classifier invariant
	 * constraints.
	 */
	public void test_completeInvariant_attribute() {
		helper.setContext(fruit);
		
		try {
			List<Choice> choices = helper.getSyntaxHelp(ConstraintKind.INVARIANT, "self."); //$NON-NLS-1$
			assertNotNull(choices);
			
			assertChoice(choices, ChoiceKind.PROPERTY, "color"); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests completion of references (association ends) in classifier invariant
	 * constraints.
	 */
	public void test_completeInvariant_reference() {
		helper.setContext(apple);
		
		try {
			List<Choice> choices = helper.getSyntaxHelp(ConstraintKind.INVARIANT, "self."); //$NON-NLS-1$
			assertNotNull(choices);
			
			assertChoice(choices, ChoiceKind.PROPERTY, "stem"); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests completion of operations in classifier invariant
	 * constraints.
	 */
	public void test_completeInvariant_operation() {
		helper.setContext(fruit);
		
		try {
			List<Choice> choices = helper.getSyntaxHelp(ConstraintKind.INVARIANT, "self."); //$NON-NLS-1$
			assertNotNull(choices);
			
			assertChoice(choices, ChoiceKind.OPERATION, "preferredColor"); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
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
					"color <> Color::"); //$NON-NLS-1$
			assertNotNull(choices);
			
			assertChoice(choices, ChoiceKind.ENUMERATION_LITERAL, "red"); //$NON-NLS-1$
			assertChoice(choices, ChoiceKind.ENUMERATION_LITERAL, "brown"); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
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
					"self."); //$NON-NLS-1$
			assertNotNull(choices);
			
			assertChoice(choices, ChoiceKind.PROPERTY, "color"); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
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
					"self."); //$NON-NLS-1$
			assertNotNull(choices);
			
			assertChoice(choices, ChoiceKind.PROPERTY, "stem"); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
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
					"self."); //$NON-NLS-1$
			assertNotNull(choices);
			
			assertChoice(choices, ChoiceKind.OPERATION, "preferredColor"); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
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
					"text."); //$NON-NLS-1$
			assertNotNull(choices);
			
			assertChoice(choices, ChoiceKind.OPERATION, "toLower"); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
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
					"result."); //$NON-NLS-1$
			assertNotNull(choices);
			
			assertChoice(choices, ChoiceKind.OPERATION, "oclIsUndefined"); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests that allInstances() is only suggested for type expressions.
	 */
	public void test_allInstances() {
		helper.setContext(apple);
		
		try {
			List<Choice> choices = helper.getSyntaxHelp(ConstraintKind.INVARIANT, "self."); //$NON-NLS-1$
			assertNotNull(choices);
			
			assertNotChoice(choices, ChoiceKind.OPERATION, "allInstances"); //$NON-NLS-1$
			
			choices = helper.getSyntaxHelp(ConstraintKind.INVARIANT, "Apple."); //$NON-NLS-1$
			assertNotNull(choices);
			
			assertChoice(choices, ChoiceKind.OPERATION, "allInstances"); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Obtains all of the choices for the OclAny type and prints them out.
	 */
	public void test_anyChoices() {
		helper.setContext(apple);
		
		try {
			List<Choice> choices = helper.getSyntaxHelp(ConstraintKind.INVARIANT, "self.oclAsType(OclAny)."); //$NON-NLS-1$
			dumpChoices(choices);
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Obtains all of the choices for a UML class and prints them out.
	 */
	public void test_eclassChoices() {
		helper.setContext(apple);
		
		try {
			List<Choice> choices = helper.getSyntaxHelp(ConstraintKind.INVARIANT, "self."); //$NON-NLS-1$
			dumpChoices(choices);
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Obtains all of the choices for a tuple type and prints them out.
	 */
	public void test_tupleChoices() {
		helper.setContext(apple);
		
		try {
			List<Choice> choices = helper.getSyntaxHelp(ConstraintKind.INVARIANT,
					"Tuple{s : String = null, a : Apple = null}."); //$NON-NLS-1$
			dumpChoices(choices);
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Obtains all of the choices for the OclType type and prints them out.
	 */
	public void test_typeChoices() {
		helper.setContext(apple);
		
		try {
			List<Choice> choices = helper.getSyntaxHelp(ConstraintKind.INVARIANT, "Apple."); //$NON-NLS-1$
			dumpChoices(choices);
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Obtains all of the choices for the Integer type and prints them out.
	 */
	public void test_integerChoices() {
		helper.setContext(apple);
		
		try {
			List<Choice> choices = helper.getSyntaxHelp(ConstraintKind.INVARIANT, "1."); //$NON-NLS-1$
			dumpChoices(choices);
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Obtains all of the choices for the Real type and prints them out.
	 */
	public void test_realChoices() {
		helper.setContext(apple);
		
		try {
			List<Choice> choices = helper.getSyntaxHelp(ConstraintKind.INVARIANT, "1.0."); //$NON-NLS-1$
			dumpChoices(choices);
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Obtains all of the choices for the String type and prints them out.
	 */
	public void test_stringChoices() {
		helper.setContext(apple);
		
		try {
			List<Choice> choices = helper.getSyntaxHelp(ConstraintKind.INVARIANT, "'foo'."); //$NON-NLS-1$
			dumpChoices(choices);
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Obtains all of the choices for the Set type and prints them out.
	 */
	public void test_setChoices() {
		helper.setContext(apple);
		
		try {
			List<Choice> choices = helper.getSyntaxHelp(ConstraintKind.INVARIANT, "Set{self}->"); //$NON-NLS-1$
            assertNotNull(choices);
			dumpChoices(choices);
            
            assertChoice(choices, ChoiceKind.OPERATION, "union"); //$NON-NLS-1$
            assertChoice(choices, ChoiceKind.OPERATION, "forAll"); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Obtains all of the choices for the OrderedSet type and prints them out.
	 */
	public void test_orderedSetChoices() {
		helper.setContext(apple);
		
		try {
			List<Choice> choices = helper.getSyntaxHelp(ConstraintKind.INVARIANT, "OrderedSet{self}->"); //$NON-NLS-1$
            assertNotNull(choices);
			dumpChoices(choices);
            
            assertChoice(choices, ChoiceKind.OPERATION, "subOrderedSet"); //$NON-NLS-1$
            assertChoice(choices, ChoiceKind.OPERATION, "forAll"); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Obtains all of the choices for the Sequence type and prints them out.
	 */
	public void test_sequenceChoices() {
		helper.setContext(apple);
		
		try {
			List<Choice> choices = helper.getSyntaxHelp(ConstraintKind.INVARIANT, "Sequence{self}->"); //$NON-NLS-1$
            assertNotNull(choices);
            dumpChoices(choices);
            
            assertChoice(choices, ChoiceKind.OPERATION, "subSequence"); //$NON-NLS-1$
            assertChoice(choices, ChoiceKind.OPERATION, "forAll"); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Obtains all of the choices for the Bag type and prints them out.
	 */
	public void test_bagChoices() {
		helper.setContext(apple);
		
		try {
			List<Choice> choices = helper.getSyntaxHelp(ConstraintKind.INVARIANT, "Bag{self}->"); //$NON-NLS-1$
            assertNotNull(choices);
            dumpChoices(choices);
            
            assertChoice(choices, ChoiceKind.OPERATION, "intersection"); //$NON-NLS-1$
            assertChoice(choices, ChoiceKind.OPERATION, "forAll"); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Obtains all of the choices for a nested collection type and prints them out.
	 */
	public void test_nestedCollectionChoices() {
		helper.setContext(apple);
		
		try {
			List<Choice> choices = helper.getSyntaxHelp(ConstraintKind.INVARIANT, "Set{Sequence{self}}->"); //$NON-NLS-1$
			dumpChoices(choices);
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Obtains all of the choices for a state expression and prints them out.
	 */
	public void test_stateChoices() {
		ocl = OCL.newInstance(new StatesTest.StatefulFruitEnvironmentFactory());
		helper = ocl.createOCLHelper();

		helper.setContext(apple);
		
		try {
			List<Choice> choices = helper.getSyntaxHelp(
					ConstraintKind.INVARIANT, "self.oclIsInState("); //$NON-NLS-1$
			dumpChoices(choices);
			
			System.out.println("----"); //$NON-NLS-1$
			
			choices = helper.getSyntaxHelp(
					ConstraintKind.INVARIANT, "self.oclIsInState(Bad::"); //$NON-NLS-1$
			dumpChoices(choices);
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Obtains all of the choices for a message expression and prints them out.
	 */
	public void test_messageChoices() {
		ocl = OCL.newInstance(new MessagesTest.MessagingFruitEnvironmentFactory());
		helper = ocl.createOCLHelper();

		helper.setOperationContext(apple, fruit_ripen);
		
		try {
			List<Choice> choices = helper.getSyntaxHelp(
					ConstraintKind.POSTCONDITION, "self^^"); //$NON-NLS-1$
			dumpChoices(choices);
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	//
	// Test framework
	//
	
	private void dumpChoices(Collection<Choice> choices) {
		assertNotNull(choices);
		
		for (Choice next : choices) {
			System.out.println("    " + next); //$NON-NLS-1$
		}
	}
}
