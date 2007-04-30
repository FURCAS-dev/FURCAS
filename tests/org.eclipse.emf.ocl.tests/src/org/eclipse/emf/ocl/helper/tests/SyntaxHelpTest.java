/**
 * <copyright>
 * 
 * Copyright (c) 2005, 2006 IBM Corporation and others.
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

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ocl.helper.Choice;
import org.eclipse.emf.ocl.helper.ChoiceType;
import org.eclipse.emf.ocl.helper.ConstraintType;
import org.eclipse.emf.ocl.helper.HelperUtil;
import org.eclipse.emf.ocl.helper.IOCLHelper;
import org.eclipse.emf.ocl.tests.MessagesTest;
import org.eclipse.emf.ocl.tests.StatesTest;

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
		IOCLHelper helper = HelperUtil.createOCLHelper();
		
		helper.setContext(EcorePackage.eINSTANCE.getEClass());
		List choices = helper.getSyntaxHelp(ConstraintType.INVARIANT, "self."); //$NON-NLS-1$
		
		assertChoice(choices, ChoiceType.STRUCTURAL_FEATURE, "eAttributes"); //$NON-NLS-1$
		
		choices = helper.getSyntaxHelp(ConstraintType.INVARIANT, "self.name."); //$NON-NLS-1$
		
		assertChoice(choices, ChoiceType.BEHAVIORAL_FEATURE, "toLower"); //$NON-NLS-1$
	}
	
	/**
	 * Tests completion of enumeration literals in classifier invariant
	 * constraints.
	 */
	public void test_completeInvariant_enumLiteral() {
		IOCLHelper helper = HelperUtil.createOCLHelper();

		helper.setContext(fruit);
		
		try {
			List choices = helper.getSyntaxHelp(
					ConstraintType.INVARIANT,
					"color <> Color::"); //$NON-NLS-1$
			assertNotNull(choices);
			
			assertChoice(choices, ChoiceType.STRUCTURAL_FEATURE, "red"); //$NON-NLS-1$
			assertChoice(choices, ChoiceType.STRUCTURAL_FEATURE, "brown"); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests completion of attributes in classifier invariant
	 * constraints.
	 */
	public void test_completeInvariant_attribute() {
		IOCLHelper helper = HelperUtil.createOCLHelper();

		helper.setContext(fruit);
		
		try {
			List choices = helper.getSyntaxHelp(ConstraintType.INVARIANT, "self."); //$NON-NLS-1$
			assertNotNull(choices);
			
			assertChoice(choices, ChoiceType.ENUMERATION_LITERAL, "color"); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests completion of references (association ends) in classifier invariant
	 * constraints.
	 */
	public void test_completeInvariant_reference() {
		IOCLHelper helper = HelperUtil.createOCLHelper();

		helper.setContext(apple);
		
		try {
			List choices = helper.getSyntaxHelp(ConstraintType.INVARIANT, "self."); //$NON-NLS-1$
			assertNotNull(choices);
			
			assertChoice(choices, ChoiceType.STRUCTURAL_FEATURE, "stem"); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests completion of operations in classifier invariant
	 * constraints.
	 */
	public void test_completeInvariant_operation() {
		IOCLHelper helper = HelperUtil.createOCLHelper();

		helper.setContext(fruit);
		
		try {
			List choices = helper.getSyntaxHelp(ConstraintType.INVARIANT, "self."); //$NON-NLS-1$
			assertNotNull(choices);
			
			assertChoice(choices, ChoiceType.BEHAVIORAL_FEATURE, "preferredColor"); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests completion of enumeration literals in operation precondition
	 * constraints.
	 */
	public void test_completePrecondition_enumLiteral() {
		IOCLHelper helper = HelperUtil.createOCLHelper();

		helper.setContextOperation(fruit, fruit_ripen);
		
		try {
			List choices = helper.getSyntaxHelp(
					ConstraintType.PRECONDITION,
					"color <> Color::"); //$NON-NLS-1$
			assertNotNull(choices);
			
			assertChoice(choices, ChoiceType.STRUCTURAL_FEATURE, "red"); //$NON-NLS-1$
			assertChoice(choices, ChoiceType.STRUCTURAL_FEATURE, "brown"); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests completion of attributes in operation body conditions.
	 */
	public void test_completeBodyCondition_attribute() {
		IOCLHelper helper = HelperUtil.createOCLHelper();

		helper.setContextOperation(fruit, fruit_preferredColor);
		
		try {
			List choices = helper.getSyntaxHelp(
					ConstraintType.BODYCONDITION,
					"self."); //$NON-NLS-1$
			assertNotNull(choices);
			
			assertChoice(choices, ChoiceType.ENUMERATION_LITERAL, "color"); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests completion of references (association ends) in operation precondition
	 * constraints.
	 */
	public void test_completePrecondition_reference() {
		IOCLHelper helper = HelperUtil.createOCLHelper();

		helper.setContextOperation(apple, apple_labelOper);
		
		try {
			List choices = helper.getSyntaxHelp(
					ConstraintType.PRECONDITION,
					"self."); //$NON-NLS-1$
			assertNotNull(choices);
			
			assertChoice(choices, ChoiceType.STRUCTURAL_FEATURE, "stem"); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests completion of operations in operation postcondition
	 * constraints.
	 */
	public void test_completePostcondition_operation() {
		IOCLHelper helper = HelperUtil.createOCLHelper();

		helper.setContextOperation(fruit, fruit_ripen);
		
		try {
			List choices = helper.getSyntaxHelp(
					ConstraintType.POSTCONDITION,
					"self."); //$NON-NLS-1$
			assertNotNull(choices);
			
			assertChoice(choices, ChoiceType.BEHAVIORAL_FEATURE, "preferredColor"); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests completion of parameters in operation precondition
	 * constraints.
	 */
	public void test_completePrecondition_parameter() {
		IOCLHelper helper = HelperUtil.createOCLHelper();

		helper.setContextOperation(fruit, apple_labelOper);
		
		try {
			List choices = helper.getSyntaxHelp(
					ConstraintType.PRECONDITION,
					"text."); //$NON-NLS-1$
			assertNotNull(choices);
			
			assertChoice(choices, ChoiceType.BEHAVIORAL_FEATURE, "toLower"); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests completion of the result variable in operation postcondition
	 * constraints.
	 */
	public void test_completePostcondition_result() {
		IOCLHelper helper = HelperUtil.createOCLHelper();

		helper.setContextOperation(fruit, fruit_preferredColor);
		
		try {
			List choices = helper.getSyntaxHelp(
					ConstraintType.POSTCONDITION,
					"result."); //$NON-NLS-1$
			assertNotNull(choices);
			
			assertChoice(choices, ChoiceType.BEHAVIORAL_FEATURE, "oclIsUndefined"); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests that allInstances() is only suggested for type expressions.
	 */
	public void test_allInstances() {
		IOCLHelper helper = HelperUtil.createOCLHelper();

		helper.setContext(apple);
		
		try {
			List choices = helper.getSyntaxHelp(ConstraintType.INVARIANT, "self."); //$NON-NLS-1$
			assertNotNull(choices);
			
			assertNotChoice(choices, ChoiceType.BEHAVIORAL_FEATURE, "allInstances"); //$NON-NLS-1$
			
			choices = helper.getSyntaxHelp(ConstraintType.INVARIANT, "Apple."); //$NON-NLS-1$
			assertNotNull(choices);
			
			assertChoice(choices, ChoiceType.BEHAVIORAL_FEATURE, "allInstances"); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Obtains all of the choices for the OclAny type and prints them out.
	 */
	public void test_anyChoices() {
		IOCLHelper helper = HelperUtil.createOCLHelper();

		helper.setContext(apple);
		
		try {
			List choices = helper.getSyntaxHelp(ConstraintType.INVARIANT, "self.oclAsType(OclAny)."); //$NON-NLS-1$
			dumpChoices(choices);
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Obtains all of the choices for a UML class and prints them out.
	 */
	public void test_eclassChoices() {
		IOCLHelper helper = HelperUtil.createOCLHelper();

		helper.setContext(apple);
		
		try {
			List choices = helper.getSyntaxHelp(ConstraintType.INVARIANT, "self."); //$NON-NLS-1$
			dumpChoices(choices);
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Obtains all of the choices for a tuple type and prints them out.
	 */
	public void test_tupleChoices() {
		IOCLHelper helper = HelperUtil.createOCLHelper();

		helper.setContext(apple);
		
		try {
			List choices = helper.getSyntaxHelp(ConstraintType.INVARIANT,
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
		IOCLHelper helper = HelperUtil.createOCLHelper();

		helper.setContext(apple);
		
		try {
			List choices = helper.getSyntaxHelp(ConstraintType.INVARIANT, "Apple."); //$NON-NLS-1$
			dumpChoices(choices);
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Obtains all of the choices for the Integer type and prints them out.
	 */
	public void test_integerChoices() {
		IOCLHelper helper = HelperUtil.createOCLHelper();

		helper.setContext(apple);
		
		try {
			List choices = helper.getSyntaxHelp(ConstraintType.INVARIANT, "1."); //$NON-NLS-1$
			dumpChoices(choices);
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Obtains all of the choices for the Real type and prints them out.
	 */
	public void test_realChoices() {
		IOCLHelper helper = HelperUtil.createOCLHelper();

		helper.setContext(apple);
		
		try {
			List choices = helper.getSyntaxHelp(ConstraintType.INVARIANT, "1.0."); //$NON-NLS-1$
			dumpChoices(choices);
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Obtains all of the choices for the String type and prints them out.
	 */
	public void test_stringChoices() {
		IOCLHelper helper = HelperUtil.createOCLHelper();

		helper.setContext(apple);
		
		try {
			List choices = helper.getSyntaxHelp(ConstraintType.INVARIANT, "'foo'."); //$NON-NLS-1$
			dumpChoices(choices);
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Obtains all of the choices for the Set type and prints them out.
	 */
	public void test_setChoices() {
		IOCLHelper helper = HelperUtil.createOCLHelper();

		helper.setContext(apple);
		
		try {
			List choices = helper.getSyntaxHelp(ConstraintType.INVARIANT, "Set{self}->"); //$NON-NLS-1$
			dumpChoices(choices);
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Obtains all of the choices for the OrderedSet type and prints them out.
	 */
	public void test_orderedSetChoices() {
		IOCLHelper helper = HelperUtil.createOCLHelper();

		helper.setContext(apple);
		
		try {
			List choices = helper.getSyntaxHelp(ConstraintType.INVARIANT, "OrderedSet{self}->"); //$NON-NLS-1$
			dumpChoices(choices);
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Obtains all of the choices for the Sequence type and prints them out.
	 */
	public void test_sequenceChoices() {
		IOCLHelper helper = HelperUtil.createOCLHelper();

		helper.setContext(apple);
		
		try {
			List choices = helper.getSyntaxHelp(ConstraintType.INVARIANT, "Sequence{self}->"); //$NON-NLS-1$
			dumpChoices(choices);
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Obtains all of the choices for the Bag type and prints them out.
	 */
	public void test_bagChoices() {
		IOCLHelper helper = HelperUtil.createOCLHelper();

		helper.setContext(apple);
		
		try {
			List choices = helper.getSyntaxHelp(ConstraintType.INVARIANT, "Bag{self}->"); //$NON-NLS-1$
			dumpChoices(choices);
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Obtains all of the choices for a nested collection type and prints them out.
	 */
	public void test_nestedCollectionChoices() {
		IOCLHelper helper = HelperUtil.createOCLHelper();

		helper.setContext(apple);
		
		try {
			List choices = helper.getSyntaxHelp(ConstraintType.INVARIANT, "Set{Sequence{self}}->"); //$NON-NLS-1$
			dumpChoices(choices);
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Obtains all of the choices for a state expression and prints them out.
	 */
	public void test_stateChoices() {
		IOCLHelper helper = HelperUtil.createOCLHelper(
				new StatesTest.StatefulFruitEnvironmentFactory());

		helper.setContext(apple);
		
		try {
			List choices = helper.getSyntaxHelp(
					ConstraintType.INVARIANT, "self.oclIsInState("); //$NON-NLS-1$
			dumpChoices(choices);
			
			System.out.println("----"); //$NON-NLS-1$
			
			choices = helper.getSyntaxHelp(
					ConstraintType.INVARIANT, "self.oclIsInState(Bad::"); //$NON-NLS-1$
			dumpChoices(choices);
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Obtains all of the choices for a message expression and prints them out.
	 */
	public void test_messageChoices() {
		IOCLHelper helper = HelperUtil.createOCLHelper(
				new MessagesTest.MessagingFruitEnvironmentFactory());

		helper.setContextOperation(apple, fruit_ripen);
		
		try {
			List choices = helper.getSyntaxHelp(
					ConstraintType.POSTCONDITION, "self^^"); //$NON-NLS-1$
			dumpChoices(choices);
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
    
    public void test_completeCollectionValuedSubexpression() {
        IOCLHelper helper = HelperUtil.createOCLHelper();

        helper.setContext(apple);
        
        try {
            List<Choice> choices = helper.getSyntaxHelp(
                    ConstraintType.INVARIANT, "true and false implies color->"); //$NON-NLS-1$
            
            // iterators and collection operations
            assertChoice(choices, ChoiceType.BEHAVIORAL_FEATURE, "forAll"); //$NON-NLS-1$
            assertChoice(choices, ChoiceType.BEHAVIORAL_FEATURE, "size"); //$NON-NLS-1$
            
            // not features of Apple
            assertNotChoice(choices, ChoiceType.STRUCTURAL_FEATURE, "color"); //$NON-NLS-1$
            assertNotChoice(choices, ChoiceType.BEHAVIORAL_FEATURE, "preferredLabel"); //$NON-NLS-1$
        } catch (Exception e) {
            fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }
    }
	
	//
	// Test framework
	//
	
	private void dumpChoices(Collection choices) {
		assertNotNull(choices);
		
		for (Iterator iter = choices.iterator(); iter.hasNext();) {
			Choice next = (Choice) iter.next();
			
			System.out.println("    " + next); //$NON-NLS-1$
		}
	}
}
