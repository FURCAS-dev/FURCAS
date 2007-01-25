/**
 * <copyright>
 *
 * Copyright (c) 2006 IBM Corporation and others.
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
 * $Id: StatesTest.java,v 1.2 2007/01/25 18:34:44 cdamus Exp $
 */

package org.eclipse.emf.ocl.tests;

import java.util.Arrays;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ocl.helper.ChoiceType;
import org.eclipse.emf.ocl.helper.ConstraintType;
import org.eclipse.emf.ocl.helper.HelperUtil;
import org.eclipse.emf.ocl.helper.IOCLHelper;
import org.eclipse.emf.ocl.parser.AbstractEnvironmentFactory;
import org.eclipse.emf.ocl.parser.EcoreEnvironment;
import org.eclipse.emf.ocl.parser.Environment;
import org.eclipse.emf.ocl.types.util.Types;

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
		IOCLHelper helper = HelperUtil.createOCLHelper(new StatefulFruitEnvironmentFactory());
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
		IOCLHelper helper = HelperUtil.createOCLHelper(new StatefulFruitEnvironmentFactory());
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
			
			fail("Should have failed to parse empty arglist"); //$NON-NLS-1$
		} catch (Exception e) {
			// success
			System.out.println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests the content-assist for states.
	 */
	public void test_stateContentAssist() {
		IOCLHelper helper = HelperUtil.createOCLHelper(new StatefulFruitEnvironmentFactory());
		helper.setContext(fruit);
		
		try {
			// simplest case of first path name part completion
			List choices = helper.getSyntaxHelp(
					ConstraintType.INVARIANT, "self.oclIsInState("); //$NON-NLS-1$
			assertNotNull(choices);
			assertChoice(choices, ChoiceType.STRUCTURAL_FEATURE, "Ripe"); //$NON-NLS-1$
			assertChoice(choices, ChoiceType.STRUCTURAL_FEATURE, "Bad"); //$NON-NLS-1$

			// case of no more completions (path is already complete)
			choices = helper.getSyntaxHelp(
					ConstraintType.INVARIANT, "self.oclIsInState(Ripe::"); //$NON-NLS-1$
			assertNotNull(choices);
			assertTrue(choices.isEmpty());
			
			// explicit source of non-self type
			choices = helper.getSyntaxHelp(
					ConstraintType.INVARIANT,
					"Apple.allInstances()->forAll(a : Apple | a.oclIsInState("); //$NON-NLS-1$
			assertNotNull(choices);
			assertChoice(choices, ChoiceType.STRUCTURAL_FEATURE, "Ripe"); //$NON-NLS-1$
			assertChoice(choices, ChoiceType.STRUCTURAL_FEATURE, "Bad"); //$NON-NLS-1$
			
			// implicit source of non-self type
//			choices = helper.getSyntaxHelp(
//					ConstraintType.INVARIANT,
//					"Apple.allInstances()->forAll(oclIsInState("); //$NON-NLS-1$
//			assertNotNull(choices);
//			assertChoice(choices, ChoiceType.STRUCTURAL_FEATURE, "Ripe"); //$NON-NLS-1$
//			assertChoice(choices, ChoiceType.STRUCTURAL_FEATURE, "Bad"); //$NON-NLS-1$
			
			// available second-level completions
			choices = helper.getSyntaxHelp(
					ConstraintType.INVARIANT,
					"Apple.allInstances()->forAll(a : Apple | a.oclIsInState(Bad::"); //$NON-NLS-1$
			assertNotNull(choices);
			assertChoice(choices, ChoiceType.STRUCTURAL_FEATURE, "Bruised"); //$NON-NLS-1$
			assertChoice(choices, ChoiceType.STRUCTURAL_FEATURE, "Rotten"); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	//
	// Test framework
	//
	
	private static List FRUIT_BAD = Arrays.asList(new String[] {"Bad"}); //$NON-NLS-1$
	
	public static class StatefulFruitEnvironmentFactory extends AbstractEnvironmentFactory {

		protected Environment createEnvironment(EPackage packageContext) {
			StatefulFruitEnvironment result = new StatefulFruitEnvironment();
			result.setFactory(this);
			return result;
		}

		protected EClassifier asEClassifier(Object context) {
			return (EClassifier) context;
		}

		protected EOperation asEOperation(Object operation) {
			return (EOperation) operation;
		}
		
		protected EStructuralFeature asEStructuralFeature(Object property) {
			return (EStructuralFeature) property;
		}

		public Environment createEnvironment(Environment parent) {
			StatefulFruitEnvironment result = new StatefulFruitEnvironment(parent);
			result.setFactory(this);
			return result;
		}
	}
	
	private static class StatefulFruitEnvironment extends EcoreEnvironment {
		private EObject fruitRipe;
		private EObject fruitBad;
		private EObject appleBruised;
		private EObject appleRotten;
		
		public StatefulFruitEnvironment() {
			super(fruitPackage);
			
			init();
		}
		
		public StatefulFruitEnvironment(Environment parent) {
			super(parent);
			
			init();
		}

		private void init() {
			fruitRipe = EcoreFactory.eINSTANCE.createEObject();
			((InternalEObject) fruitRipe).eSetClass(Types.STATE);
			fruitBad = EcoreFactory.eINSTANCE.createEObject();
			((InternalEObject) fruitBad).eSetClass(Types.STATE);
			appleBruised = EcoreFactory.eINSTANCE.createEObject();
			((InternalEObject) appleBruised).eSetClass(Types.STATE);
			appleRotten = EcoreFactory.eINSTANCE.createEObject();
			((InternalEObject) appleRotten).eSetClass(Types.STATE);
		}
		
		void setFactory(StatefulFruitEnvironmentFactory factory) {
			super.setFactory(factory);
		}
		
		protected void collectStates(EClassifier owner, List pathPrefix, List states) {
			if (owner == fruit) {
				if (pathPrefix.isEmpty()) {
					states.add(fruitRipe);
					states.add(fruitBad);
				}
			} else if (owner == apple) {
				if (pathPrefix.isEmpty()) {
					states.add(fruitBad);
				} else if (pathPrefix.equals(FRUIT_BAD)) {
					states.add(appleBruised);
					states.add(appleRotten);
				}
			}
		}
		
		public String getStateName(EObject state) {
			if (state == fruitRipe) {
				return "Ripe"; //$NON-NLS-1$
			} else if (state == fruitBad) {
				return "Bad"; //$NON-NLS-1$
			} else if (state == appleBruised) {
				return "Bruised"; //$NON-NLS-1$
			} else if (state == appleRotten) {
				return "Rotten"; //$NON-NLS-1$
			} else {
				return null;
			}
		}
	}
}
