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
 * $Id: StatesTest.java,v 1.7 2011/01/25 10:43:36 auhl Exp $
 */

package org.eclipse.ocl.ecore.tests;

import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.EcoreEnvironment;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.ecore.internal.UMLReflectionImpl;
import org.eclipse.ocl.helper.Choice;
import org.eclipse.ocl.helper.ChoiceKind;
import org.eclipse.ocl.helper.ConstraintKind;
import org.eclipse.ocl.utilities.UMLReflection;

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
//			assertChoice(choices, ChoiceType.STRUCTURAL_FEATURE, "Ripe");
//			assertChoice(choices, ChoiceType.STRUCTURAL_FEATURE, "Bad");
			
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
	
	//
	// Test framework
	//
	
	@Override
	protected OCL createOCL() {
		return OCL.newInstance(new StatefulFruitEnvironmentFactory(this));
	}
	
	private static final List<String> FRUIT_BAD = Arrays.asList(new String[] {"Bad"});
	
	public static class StatefulFruitEnvironmentFactory extends EcoreEnvironmentFactory {
		protected final AbstractTestSuite suite;
		
		public StatefulFruitEnvironmentFactory(AbstractTestSuite suite) {
			this.suite = suite;
		}
		
		@Override
        public EcoreEnvironment createEnvironment() {
			return new StatefulFruitEnvironment(this, suite);
		}

		@Override
        public EcoreEnvironment createEnvironment(
				Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> parent) {
			return new StatefulFruitEnvironment(this, parent, suite);
		}
	}
	
	private static class StatefulFruitEnvironment extends EcoreEnvironment {
		protected final AbstractTestSuite suite;
		private EObject fruitRipe;
		private EObject fruitBad;
		private EObject appleBruised;
		private EObject appleRotten;
		
		public StatefulFruitEnvironment(StatefulFruitEnvironmentFactory factory, AbstractTestSuite suite) {
			super(factory, null);
			this.suite = suite;
			setContextPackage(suite.fruitPackage);
			
			initStates();
		}
		
		public StatefulFruitEnvironment(
				StatefulFruitEnvironmentFactory factory,
				Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> parent, AbstractTestSuite suite) {
			super(parent);
			this.suite = suite;
			
			initStates();
		}
		
		private void initStates() {
			fruitRipe = EcoreFactory.eINSTANCE.createEObject();
			((InternalEObject) fruitRipe).eSetClass(
					(EClass) getOCLStandardLibrary().getState());
			fruitBad = EcoreFactory.eINSTANCE.createEObject();
			((InternalEObject) fruitBad).eSetClass(
					(EClass) getOCLStandardLibrary().getState());
			appleBruised = EcoreFactory.eINSTANCE.createEObject();
			((InternalEObject) appleBruised).eSetClass(
					(EClass) getOCLStandardLibrary().getState());
			appleRotten = EcoreFactory.eINSTANCE.createEObject();
			((InternalEObject) appleRotten).eSetClass(
					(EClass) getOCLStandardLibrary().getState());
		}

		@Override
        protected void collectStates(EClassifier owner, List<String> pathPrefix, List<EObject> states) {
			if (owner == suite.fruit) {
				if (pathPrefix.isEmpty()) {
					states.add(fruitRipe);
					states.add(fruitBad);
				}
			} else if (owner == suite.apple) {
				if (pathPrefix.isEmpty()) {
					states.add(fruitBad);
				} else if (pathPrefix.equals(FRUIT_BAD)) {
					states.add(appleBruised);
					states.add(appleRotten);
				}
			}
		}
		
        
        @Override
        public UMLReflection<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint> getUMLReflection() {
            return new UMLReflectionImpl() {
        		@Override
                public String getName(Object namedElement) {
        			if (namedElement == fruitRipe) {
        				return "Ripe";
        			} else if (namedElement == fruitBad) {
        				return "Bad";
        			} else if (namedElement == appleBruised) {
        				return "Bruised";
        			} else if (namedElement == appleRotten) {
        				return "Rotten";
        			} else {
        				return super.getName(namedElement);
        			}
        		}};
        }
	}
}
