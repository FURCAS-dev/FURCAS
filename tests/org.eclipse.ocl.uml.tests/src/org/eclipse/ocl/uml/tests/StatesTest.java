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
 * $Id: StatesTest.java,v 1.2 2007/02/14 14:46:16 cdamus Exp $
 */

package org.eclipse.ocl.uml.tests;

import java.util.List;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.ocl.helper.Choice;
import org.eclipse.ocl.helper.ChoiceKind;
import org.eclipse.ocl.helper.ConstraintKind;
import org.eclipse.uml2.uml.StateMachine;

/**
 * Tests for state expressions.
 *
 * @author Christian W. Damus (cdamus)
 */
public class StatesTest
	extends AbstractTestSuite {
	
	public StatesTest(String name) {
		super(name);
	}
	
	public static Test suite() {
		return new TestSuite(StatesTest.class, "State Expression Tests"); //$NON-NLS-1$
	}
	
	/**
	 * Tests the parsing of the oclIsInState() expression.
	 */
	public void test_isInState() {
		helper.setContext(fruit);
		
		try {
			// test implicit and explicit source
			helper.createInvariant(
					"oclIsInState(Ripe) implies not self.oclIsInState(Bad)"); //$NON-NLS-1$

			// test source of different type than context (and also implicit)
			helper.createInvariant(
				"Apple.allInstances()->forAll(not oclIsInState(Bad::Rotten))"); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		try {
			// just to make sure that the second test, above, wasn't a fluke.
			// Fruit doesn't have this state
			helper.createInvariant(
				"Fruit.allInstances()->forAll(not oclIsInState(Bad::Rotten))"); //$NON-NLS-1$
			
			fail("Should have failed to parse non-existent state"); //$NON-NLS-1$
		} catch (Exception e) {
			// success
			System.out.println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
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
				"self.oclIsInState()"); //$NON-NLS-1$
			
			fail("Should have failed to parse empty arglist"); //$NON-NLS-1$
		} catch (Exception e) {
			// success
			System.out.println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		try {
			// too many arguments
			helper.createInvariant(
				"Apple.allInstances()->forAll(oclIsInState(Bad, Rotten))"); //$NON-NLS-1$
			
			fail("Should have failed to parse overabundant arglist"); //$NON-NLS-1$
		} catch (Exception e) {
			// success
			System.out.println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		try {
			// wrong kind of argument
			helper.createInvariant(
				"self.oclIsInState(color <> Color::black)"); //$NON-NLS-1$
			
			fail("Should have failed to parse arg of wrong type"); //$NON-NLS-1$
		} catch (Exception e) {
			// success
			System.out.println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		try {
			// another kind of wrong kind of argument
			helper.createInvariant(
				"self.oclIsInState(OclTest::Fruit)"); //$NON-NLS-1$
			
			fail("Should have failed to parse arg of wrong type"); //$NON-NLS-1$
		} catch (Exception e) {
			// success
			System.out.println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
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
					ConstraintKind.INVARIANT, "self.oclIsInState("); //$NON-NLS-1$
			assertNotNull(choices);
			assertChoice(choices, ChoiceKind.STATE, "Ripe"); //$NON-NLS-1$
			assertChoice(choices, ChoiceKind.STATE, "Bad"); //$NON-NLS-1$

			// case of no more completions (path is already complete)
			choices = helper.getSyntaxHelp(
					ConstraintKind.INVARIANT, "self.oclIsInState(Ripe::"); //$NON-NLS-1$
			assertNotNull(choices);
			assertTrue(choices.isEmpty());
			
			// explicit source of non-self type
			choices = helper.getSyntaxHelp(
					ConstraintKind.INVARIANT,
					"Apple.allInstances()->forAll(a : Apple | a.oclIsInState("); //$NON-NLS-1$
			assertNotNull(choices);
			assertChoice(choices, ChoiceKind.STATE, "Ripe"); //$NON-NLS-1$
			assertChoice(choices, ChoiceKind.STATE, "Bad"); //$NON-NLS-1$
			
			// implicit source of non-self type
//			choices = helper.getSyntaxHelp(
//					ConstraintType.INVARIANT,
//					"Apple.allInstances()->forAll(oclIsInState("); //$NON-NLS-1$
//			assertNotNull(choices);
//			assertChoice(choices, ChoiceType.STATE, "Ripe"); //$NON-NLS-1$
//			assertChoice(choices, ChoiceType.STATE, "Bad"); //$NON-NLS-1$
			
			// available second-level completions
			choices = helper.getSyntaxHelp(
					ConstraintKind.INVARIANT,
					"Apple.allInstances()->forAll(a : Apple | a.oclIsInState(Bad::"); //$NON-NLS-1$
			assertNotNull(choices);
			assertChoice(choices, ChoiceKind.STATE, "Bruised"); //$NON-NLS-1$
			assertChoice(choices, ChoiceKind.STATE, "Rotten"); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests the case of multiple state machines with same-named states.
	 */
	public void test_multipleStateMachines() {
		helper.setContext(fruit);
		StateMachine machine2 = (StateMachine) fruit.createOwnedBehavior("Machine2", uml.getStateMachine()); //$NON-NLS-1$
		machine2.createRegion("Region1").createSubvertex("Ripe", uml.getState()); //$NON-NLS-1$ //$NON-NLS-2$
		
		try {
			try {
				// qualify reference with first machine name
				helper.createInvariant(
						"oclIsInState(Lifecycle::Ripe) implies not self.oclIsInState(Bad)"); //$NON-NLS-1$

				// qualify reference with second machine name
				helper.createInvariant(
						"oclIsInState(Machine2::Ripe) implies not self.oclIsInState(Bad)"); //$NON-NLS-1$
			} catch (Exception e) {
				fail("Failed to parse: " + e.getLocalizedMessage()); //$NON-NLS-1$
			}
			
			try {
				// ambiguous reference
				helper.createInvariant(
					"oclIsInState(Ripe) implies not self.oclIsInState(Bad)"); //$NON-NLS-1$
				
				fail("Should have failed to parse ambiguous state"); //$NON-NLS-1$
			} catch (Exception e) {
				// success
				System.out.println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
			}
		} finally {
			machine2.destroy();
		}
	}
}
