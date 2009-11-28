/**
 * <copyright>
 * 
 * Copyright (c) 2006, 2007 IBM Corporation and others.
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
 * $Id: StatesTest.java,v 1.4 2009/11/28 18:10:36 ewillink Exp $
 */

package org.eclipse.ocl.uml.tests;

import java.util.List;

import org.eclipse.ocl.helper.Choice;
import org.eclipse.ocl.helper.ChoiceKind;
import org.eclipse.ocl.helper.ConstraintKind;
import org.eclipse.uml2.uml.StateMachine;

/**
 * Tests for state expressions.
 *
 * @author Christian W. Damus (cdamus)
 */
@SuppressWarnings("nls")
public class StatesTest
	extends AbstractTestSuite {
	
	/**
	 * Tests the parsing of the oclIsInState() expression.
	 */
	public void test_isInState() {
		helper.setContext(fruit);
		
		try {
			// test implicit and explicit source
			helper.createInvariant(
					"oclIsInState(Ripe) implies not self.oclIsInState(Bad)");

			// test source of different type than context (and also implicit)
			helper.createInvariant(
				"Apple.allInstances()->forAll(not oclIsInState(Bad::Rotten))");
		} catch (Exception e) {
			fail("Failed to parse: " + e.getLocalizedMessage());
		}
		
		try {
			// just to make sure that the second test, above, wasn't a fluke.
			// Fruit doesn't have this state
			helper.createInvariant(
				"Fruit.allInstances()->forAll(not oclIsInState(Bad::Rotten))");
			
			fail("Should have failed to parse non-existent state");
		} catch (Exception e) {
			// success
			System.out.println("Got expected error: " + e.getLocalizedMessage());
		}
	}
	
	/**
	 * Tests some validation of the oclIsInState() expression.
	 */
	public void test_isInState_validation() {
		helper.setContext(fruit);
		
		try {
			// not enough arguments
			helper.createInvariant(
				"self.oclIsInState()");
			
			fail("Should have failed to parse empty arglist");
		} catch (Exception e) {
			// success
			System.out.println("Got expected error: " + e.getLocalizedMessage());
		}
		
		try {
			// too many arguments
			helper.createInvariant(
				"Apple.allInstances()->forAll(oclIsInState(Bad, Rotten))");
			
			fail("Should have failed to parse overabundant arglist");
		} catch (Exception e) {
			// success
			System.out.println("Got expected error: " + e.getLocalizedMessage());
		}
		
		try {
			// wrong kind of argument
			helper.createInvariant(
				"self.oclIsInState(color <> Color::black)");
			
			fail("Should have failed to parse arg of wrong type");
		} catch (Exception e) {
			// success
			System.out.println("Got expected error: " + e.getLocalizedMessage());
		}
		
		try {
			// another kind of wrong kind of argument
			helper.createInvariant(
				"self.oclIsInState(OclTest::Fruit)");
			
			fail("Should have failed to parse arg of wrong type");
		} catch (Exception e) {
			// success
			System.out.println("Got expected error: " + e.getLocalizedMessage());
		}
	}
	
	/**
	 * Tests the content-assist for states.
	 */
	public void test_stateContentAssist() {
		helper.setContext(fruit);
		
		try {
			// simplest case of first path name part completion
			List<Choice> choices = helper.getSyntaxHelp(
					ConstraintKind.INVARIANT, "self.oclIsInState(");
			assertNotNull(choices);
			assertChoice(choices, ChoiceKind.STATE, "Ripe");
			assertChoice(choices, ChoiceKind.STATE, "Bad");

			// case of no more completions (path is already complete)
			choices = helper.getSyntaxHelp(
					ConstraintKind.INVARIANT, "self.oclIsInState(Ripe::");
			assertNotNull(choices);
			assertTrue(choices.isEmpty());
			
			// explicit source of non-self type
			choices = helper.getSyntaxHelp(
					ConstraintKind.INVARIANT,
					"Apple.allInstances()->forAll(a : Apple | a.oclIsInState(");
			assertNotNull(choices);
			assertChoice(choices, ChoiceKind.STATE, "Ripe");
			assertChoice(choices, ChoiceKind.STATE, "Bad");
			
			// implicit source of non-self type
//			choices = helper.getSyntaxHelp(
//					ConstraintType.INVARIANT,
//					"Apple.allInstances()->forAll(oclIsInState(");
//			assertNotNull(choices);
//			assertChoice(choices, ChoiceType.STATE, "Ripe");
//			assertChoice(choices, ChoiceType.STATE, "Bad");
			
			// available second-level completions
			choices = helper.getSyntaxHelp(
					ConstraintKind.INVARIANT,
					"Apple.allInstances()->forAll(a : Apple | a.oclIsInState(Bad::");
			assertNotNull(choices);
			assertChoice(choices, ChoiceKind.STATE, "Bruised");
			assertChoice(choices, ChoiceKind.STATE, "Rotten");
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage());
		}
	}
	
	/**
	 * Tests the case of multiple state machines with same-named states.
	 */
	public void test_multipleStateMachines() {
        expectModified = true;
		helper.setContext(fruit);
		StateMachine machine2 = (StateMachine) fruit.createOwnedBehavior("Machine2", uml.getStateMachine());
		machine2.createRegion("Region1").createSubvertex("Ripe", uml.getState());
		
		try {
			try {
				// qualify reference with first machine name
				helper.createInvariant(
						"oclIsInState(Lifecycle::Ripe) implies not self.oclIsInState(Bad)");

				// qualify reference with second machine name
				helper.createInvariant(
						"oclIsInState(Machine2::Ripe) implies not self.oclIsInState(Bad)");
			} catch (Exception e) {
				fail("Failed to parse: " + e.getLocalizedMessage());
			}
			
			try {
				// ambiguous reference
				helper.createInvariant(
					"oclIsInState(Ripe) implies not self.oclIsInState(Bad)");
				
				fail("Should have failed to parse ambiguous state");
			} catch (Exception e) {
				// success
				System.out.println("Got expected error: " + e.getLocalizedMessage());
			}
		} finally {
			machine2.destroy();
		}
	}
}
