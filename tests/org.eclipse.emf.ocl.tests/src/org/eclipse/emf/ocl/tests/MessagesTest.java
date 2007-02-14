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
 * $Id: MessagesTest.java,v 1.5 2007/02/14 14:46:12 cdamus Exp $
 */

package org.eclipse.emf.ocl.tests;

import java.util.List;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ocl.helper.ChoiceType;
import org.eclipse.emf.ocl.helper.ConstraintType;
import org.eclipse.emf.ocl.helper.HelperUtil;
import org.eclipse.emf.ocl.helper.IOCLHelper;
import org.eclipse.emf.ocl.parser.AbstractEnvironmentFactory;
import org.eclipse.emf.ocl.parser.EcoreEnvironment;
import org.eclipse.emf.ocl.parser.Environment;
import org.eclipse.emf.ocl.types.util.Types;
import org.eclipse.emf.ocl.uml.util.UMLTypeUtil;

/**
 * Tests for message expressions.
 *
 * @author Christian W. Damus (cdamus)
 */
public class MessagesTest
	extends AbstractTestSuite {
	
	public MessagesTest(String name) {
		super(name);
	}
	
	public static Test suite() {
		return new TestSuite(MessagesTest.class, "Message Expression Tests"); //$NON-NLS-1$
	}
	
	/**
	 * Tests the parsing of the hasSent ("^") expression for operations.
	 */
	public void test_hasSent_operation() {
		IOCLHelper helper = HelperUtil.createOCLHelper(new MessagingFruitEnvironmentFactory());
		helper.setContextOperation(fruit, fruit_ripen);
		
		try {
			// test query operation calls without any arguments
			helper.createPostcondition("self^preferredColor()"); //$NON-NLS-1$

			// test non-query operation calls without any arguments
			helper.createPostcondition("self ^ newFruit()"); //$NON-NLS-1$

			// test operation calls with one argument.  Incidentally put a more
			//    interesting expression as the target
			helper.createPostcondition(
					"Apple.allInstances()->any(true) ^ripen(Color::yellow)"); //$NON-NLS-1$
			
			// test operation calls with multiple arguments
			helper.createPostcondition(
					"Fruit.allInstances()->forAll(f | self^setColor(f, Color::red))"); //$NON-NLS-1$
			
			// test operation signature conformance matching
			helper.createPostcondition(
					"Apple.allInstances()->forAll(a | self^setColor(a, Color::red))"); //$NON-NLS-1$
			
			// test operation signature conformance matching with null object type
			helper.createPostcondition(
					"Apple.allInstances()->forAll(a | self^setColor(null, Color::red))"); //$NON-NLS-1$
			
			// test operation signature conformance matching with null data type
			helper.createPostcondition(
					"Apple.allInstances()->forAll(a | self^setColor(a, null))"); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests the validation of the hasSent ("^") expression for operations.
	 */
	public void test_hasSent_operation_validation() {
		IOCLHelper helper = HelperUtil.createOCLHelper(new MessagingFruitEnvironmentFactory());
		helper.setContextOperation(fruit, fruit_ripen);
		
		try {
			// non-existent operation
			helper.createPostcondition("self^label('foo')"); //$NON-NLS-1$
			
			fail("Should have failed to parse unknown operation"); //$NON-NLS-1$
		} catch (Exception e) {
			// success
			System.out.println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		try {
			// non-conformant argument
			helper.createPostcondition("self^setColor(self, 'red')"); //$NON-NLS-1$
			
			fail("Should have failed to parse non-conformant arg"); //$NON-NLS-1$
		} catch (Exception e) {
			// success
			System.out.println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests parsing of the hasSent ("^") expression with unspecified value
	 * expressions for operations.
	 */
	public void test_hasSent_operation_unspecifiedValue() {
		IOCLHelper helper = HelperUtil.createOCLHelper(new MessagingFruitEnvironmentFactory());
		helper.setContextOperation(fruit, fruit_ripen);
		
		try {
			helper.createPostcondition(
					"Apple.allInstances()->any(true)^ripen(? : Color)"); //$NON-NLS-1$
			
			helper.createPostcondition(
					"Fruit.allInstances()->forAll(f | self^setColor(? : Fruit, ? : Color))"); //$NON-NLS-1$
			
			helper.createPostcondition(
					"Apple.allInstances()->any(true)^ripen(?)"); //$NON-NLS-1$
	
			helper.createPostcondition(
					"Fruit.allInstances()->forAll(f | self^setColor(?, ?))"); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests validation of the hasSent ("^") expression with unspecified value
	 * expressions for operations.
	 */
	public void test_hasSent_operation_unspecifiedValue_validation() {
		IOCLHelper helper = HelperUtil.createOCLHelper(new MessagingFruitEnvironmentFactory());
		helper.setContextOperation(fruit, fruit_ripen);
		
		try {
			// non-existent operation
			helper.createPostcondition("self^label(?)"); //$NON-NLS-1$
			
			fail("Should have failed to parse unknown operation"); //$NON-NLS-1$
		} catch (Exception e) {
			// success
			System.out.println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		try {
			// non-conformant argument
			helper.createPostcondition("self^setColor(self, ? : String)"); //$NON-NLS-1$
			
			fail("Should have failed to parse non-conformant arg"); //$NON-NLS-1$
		} catch (Exception e) {
			// success
			System.out.println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests the parsing of the sentMessages ("^^") expression for operations.
	 */
	public void test_sentMessages_operation() {
		IOCLHelper helper = HelperUtil.createOCLHelper(new MessagingFruitEnvironmentFactory());
		helper.setContextOperation(fruit, fruit_ripen);
		
		try {
			// test query operation calls without any arguments
			helper.createPostcondition(
					"self^^preferredColor()->notEmpty()"); //$NON-NLS-1$

			// test non-query operation calls without any arguments
			helper.createPostcondition("self^^newFruit()->first().oclIsKindOf(OclMessage)"); //$NON-NLS-1$

			// test operation calls with one argument.  Incidentally put a more
			//    interesting expression as the target
			helper.createPostcondition(
					"Apple.allInstances()->any(true)^^ripen(Color::yellow)->notEmpty()"); //$NON-NLS-1$
			
			// test operation calls with multiple arguments
			helper.createPostcondition(
					"Fruit.allInstances()->collect(f | self^^setColor(f, Color::red))->notEmpty()"); //$NON-NLS-1$
			
			// test operation signature conformance matching
			helper.createPostcondition(
					"Apple.allInstances()->collect(a | self^^setColor(a, Color::red))->notEmpty()"); //$NON-NLS-1$
			
			// test operation signature conformance matching with null object type
			helper.createPostcondition(
					"Apple.allInstances()->collect(a | self^^setColor(null, Color::red))->notEmpty()"); //$NON-NLS-1$
			
			// test operation signature conformance matching with null data type
			helper.createPostcondition(
					"Apple.allInstances()->collect(a | self^^setColor(a, null))->notEmpty()"); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests the parsing of OclMessage expressions for operations.
	 */
	public void test_message_access_operation() {
		IOCLHelper helper = HelperUtil.createOCLHelper(new MessagingFruitEnvironmentFactory());
		helper.setContextOperation(fruit, fruit_ripen);
		
		try {
			// test type conformance
			helper.createPostcondition(
					"let msgs : Sequence(OclMessage) = self^^preferredColor() in " +  //$NON-NLS-1$
					"msgs->forAll(m | m.hasReturned() and m.isOperationCall() and not m.isSignalSent())"); //$NON-NLS-1$

			// test non-query operation calls without any arguments
			helper.createPostcondition("self^^newFruit()->first().oclIsKindOf(OclMessage)"); //$NON-NLS-1$

			// test operation calls with one argument.  Incidentally put a more
			//    interesting expression as the target
			helper.createPostcondition(
					"Apple.allInstances()->any(true)^^ripen(Color::yellow)->notEmpty()"); //$NON-NLS-1$
			
			// types of the OclMessage properties are determined by the actual
			//    operation type, not by the MessageExp arguments
			helper.createPostcondition(
					"let msgs : Collection(OclMessage) = Fruit.allInstances()->collect(f | self^^setColor(?, ?)) in " + //$NON-NLS-1$
					"msgs->forAll(m | m.fruit.color = Color::black implies m.newColor = Color::black)"); //$NON-NLS-1$
			
			// return values
			helper.createPostcondition(
					"let msgs : Collection(OclMessage) = Fruit.allInstances()->collect(f | self^^newFruit()) in " + //$NON-NLS-1$
					"msgs->forAll(m | m.hasReturned() implies m.result().color = Color::green)"); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests the validation of the setMessages ("^^") expression for operations.
	 */
	public void test_sentMessages_operation_validation() {
		IOCLHelper helper = HelperUtil.createOCLHelper(new MessagingFruitEnvironmentFactory());
		helper.setContextOperation(fruit, fruit_ripen);
		
		try {
			// non-existent operation
			helper.createPostcondition("self^^label('foo')->notEmpty()"); //$NON-NLS-1$
			
			fail("Should have failed to parse unknown operation"); //$NON-NLS-1$
		} catch (Exception e) {
			// success
			System.out.println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		try {
			// non-conformant argument
			helper.createPostcondition("self^^setColor(self, 'red')->notEmpty()"); //$NON-NLS-1$
			
			fail("Should have failed to parse non-conformant arg"); //$NON-NLS-1$
		} catch (Exception e) {
			// success
			System.out.println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests the parsing of the hasSent ("^") expression for signals.
	 */
	public void test_hasSent_signal() {
		IOCLHelper helper = HelperUtil.createOCLHelper(new MessagingFruitEnvironmentFactory());
		helper.setContextOperation(apple, fruit_ripen);
		
		try {
			helper.createPostcondition("self^Drop(3, self.stem)"); //$NON-NLS-1$

			helper.createPostcondition("self ^ Drop(? : Real, ? : Stem)"); //$NON-NLS-1$

			helper.createPostcondition("self ^Drop(? : Integer, ?)"); //$NON-NLS-1$

			helper.createPostcondition("self^Drop(?, ?)"); //$NON-NLS-1$

			helper.createPostcondition(
					"Apple.allInstances()->any(true)^Drop(3, stem)"); //$NON-NLS-1$
			
			helper.createPostcondition(
					"Apple.allInstances()->exists(a | a^Drop(3, stem))"); //$NON-NLS-1$
	
			helper.createPostcondition(
					"Fruit.allInstances()->forAll(f | f^Drop(?, ?) implies self^Drop(?, ?))"); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests the validation of the hasSent ("^") expression for signals.
	 */
	public void test_hasSent_signal_validation() {
		IOCLHelper helper = HelperUtil.createOCLHelper(new MessagingFruitEnvironmentFactory());
		helper.setContextOperation(fruit, fruit_ripen);
		
		try {
			// non-existent signal
			helper.createPostcondition("self^Rot(3, stem)"); //$NON-NLS-1$
			
			fail("Should have failed to parse unknown signal"); //$NON-NLS-1$
		} catch (Exception e) {
			// success
			System.out.println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		try {
			// non-conformant argument
			helper.createPostcondition("self^Drop('red', ?)"); //$NON-NLS-1$
			
			fail("Should have failed to parse non-conformant arg"); //$NON-NLS-1$
		} catch (Exception e) {
			// success
			System.out.println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests the parsing of the sentMessages ("^^") expression for signals.
	 */
	public void test_sentMessages_signal() {
		IOCLHelper helper = HelperUtil.createOCLHelper(new MessagingFruitEnvironmentFactory());
		helper.setContextOperation(fruit, fruit_ripen);
		
		try {
			helper.createPostcondition(
					"self^^Drop(3, self.oclAsType(Apple).stem)->notEmpty()"); //$NON-NLS-1$

			helper.createPostcondition("self^^Drop(?, ?)->first().oclIsKindOf(OclMessage)"); //$NON-NLS-1$

			helper.createPostcondition(
					"Apple.allInstances()->any(true)^^Drop(3, ?)->notEmpty()"); //$NON-NLS-1$
			
			helper.createPostcondition(
					"Apple.allInstances()->collect(a | self^^Drop(null, ? : Stem))->notEmpty()"); //$NON-NLS-1$
			
			helper.createPostcondition(
					"Apple.allInstances()->collect(a | self^^Drop(3, null))->notEmpty()"); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests the parsing of OclMessage expressions for signals.
	 */
	public void test_message_access_signal() {
		IOCLHelper helper = HelperUtil.createOCLHelper(new MessagingFruitEnvironmentFactory());
		helper.setContextOperation(apple, fruit_ripen);
		
		try {
			helper.createPostcondition(
					"let msgs : Sequence(OclMessage) = self^^Drop(?, ?) in " +  //$NON-NLS-1$
					"msgs->forAll(m | m.isSignalSent() and not m.isOperationCall())"); //$NON-NLS-1$

			helper.createPostcondition("self^^Drop(?, ?)->first().oclIsKindOf(OclMessage)"); //$NON-NLS-1$

			helper.createPostcondition(
					"let msgs : Collection(OclMessage) = Fruit.allInstances()->collect(f | self^^Drop(?, ?)) in " + //$NON-NLS-1$
					"msgs->forAll(m | m.delay > 0 and stem <> self.stem)"); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests the validation of the setMessages ("^^") expression for signals.
	 */
	public void test_sentMessages_signal_validation() {
		IOCLHelper helper = HelperUtil.createOCLHelper(new MessagingFruitEnvironmentFactory());
		helper.setContextOperation(fruit, fruit_ripen);
		
		try {
			// non-existent signal
			helper.createPostcondition("self^^Rot('now')->notEmpty()"); //$NON-NLS-1$
			
			fail("Should have failed to parse unknown signal"); //$NON-NLS-1$
		} catch (Exception e) {
			// success
			System.out.println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		try {
			// non-conformant argument
			helper.createPostcondition("self^^Drop(self, ?)->notEmpty()"); //$NON-NLS-1$
			
			fail("Should have failed to parse non-conformant arg"); //$NON-NLS-1$
		} catch (Exception e) {
			// success
			System.out.println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests the presentation of operation call choices.
	 */
	public void test_contentAssist_operations() {
		IOCLHelper helper = HelperUtil.createOCLHelper(new MessagingFruitEnvironmentFactory());
		helper.setContextOperation(fruit, fruit_ripen);
		
		try {
			List choices = helper.getSyntaxHelp(
					ConstraintType.POSTCONDITION,
					"self^"); //$NON-NLS-1$
			assertNotNull(choices);
			assertChoice(choices, ChoiceType.BEHAVIORAL_FEATURE, "newFruit"); //$NON-NLS-1$
			assertChoice(choices, ChoiceType.BEHAVIORAL_FEATURE, "setColor"); //$NON-NLS-1$
			assertNotChoice(choices, ChoiceType.BEHAVIORAL_FEATURE, "oclIsKindOf"); //$NON-NLS-1$
			
			choices = helper.getSyntaxHelp(
					ConstraintType.POSTCONDITION, "self^^"); //$NON-NLS-1$
			assertNotNull(choices);
			assertChoice(choices, ChoiceType.BEHAVIORAL_FEATURE, "newFruit"); //$NON-NLS-1$
			assertChoice(choices, ChoiceType.BEHAVIORAL_FEATURE, "setColor"); //$NON-NLS-1$
			assertNotChoice(choices, ChoiceType.BEHAVIORAL_FEATURE, "oclIsKindOf"); //$NON-NLS-1$

			// doesn't parse
			choices = helper.getSyntaxHelp(
					ConstraintType.POSTCONDITION, "self^^^"); //$NON-NLS-1$
			assertNotNull(choices);
			assertChoice(choices, ChoiceType.VARIABLE, "color"); //$NON-NLS-1$

			choices = helper.getSyntaxHelp(
					ConstraintType.POSTCONDITION,
					"Apple.allInstances()->any(true)^"); //$NON-NLS-1$
			assertNotNull(choices);
			assertChoice(choices, ChoiceType.BEHAVIORAL_FEATURE, "newFruit"); //$NON-NLS-1$
			assertChoice(choices, ChoiceType.BEHAVIORAL_FEATURE, "setColor"); //$NON-NLS-1$
			assertChoice(choices, ChoiceType.BEHAVIORAL_FEATURE, "label"); //$NON-NLS-1$
			assertNotChoice(choices, ChoiceType.BEHAVIORAL_FEATURE, "oclIsKindOf"); //$NON-NLS-1$
			
			choices = helper.getSyntaxHelp(
					ConstraintType.POSTCONDITION,
					"Apple.allInstances()->collect(a : Apple | a^^"); //$NON-NLS-1$
			assertNotNull(choices);
			assertChoice(choices, ChoiceType.BEHAVIORAL_FEATURE, "newFruit"); //$NON-NLS-1$
			assertChoice(choices, ChoiceType.BEHAVIORAL_FEATURE, "setColor"); //$NON-NLS-1$
			assertChoice(choices, ChoiceType.BEHAVIORAL_FEATURE, "label"); //$NON-NLS-1$
			assertNotChoice(choices, ChoiceType.BEHAVIORAL_FEATURE, "oclIsKindOf"); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests the presentation of signal send choices.
	 */
	public void test_contentAssist_signals() {
		IOCLHelper helper = HelperUtil.createOCLHelper(new MessagingFruitEnvironmentFactory());
		helper.setContextOperation(fruit, fruit_ripen);
		
		try {
			List choices = helper.getSyntaxHelp(
					ConstraintType.POSTCONDITION,
					"self^"); //$NON-NLS-1$
			assertNotNull(choices);
			assertChoice(choices, ChoiceType.BEHAVIORAL_FEATURE, "Drop"); //$NON-NLS-1$

			choices = helper.getSyntaxHelp(
					ConstraintType.POSTCONDITION, "self^^"); //$NON-NLS-1$
			assertNotNull(choices);
			assertChoice(choices, ChoiceType.BEHAVIORAL_FEATURE, "Drop"); //$NON-NLS-1$

			// doesn't parse
			choices = helper.getSyntaxHelp(
					ConstraintType.POSTCONDITION, "self^^^"); //$NON-NLS-1$
			assertNotNull(choices);
			assertChoice(choices, ChoiceType.VARIABLE, "color"); //$NON-NLS-1$

			choices = helper.getSyntaxHelp(
					ConstraintType.POSTCONDITION,
					"Apple.allInstances()->any(true)^"); //$NON-NLS-1$
			assertNotNull(choices);
			assertChoice(choices, ChoiceType.BEHAVIORAL_FEATURE, "Drop"); //$NON-NLS-1$
			
			choices = helper.getSyntaxHelp(
					ConstraintType.POSTCONDITION,
					"Apple.allInstances()->collect(a : Apple | a^^"); //$NON-NLS-1$
			assertNotNull(choices);
			assertChoice(choices, ChoiceType.BEHAVIORAL_FEATURE, "Drop"); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	//
	// Test framework
	//
	
	protected void tearDown()
		throws Exception {

		// let the next test re-initialize the fruit package to eliminate the
		//    Drop signal
		fruitPackage = null;
		
		super.tearDown();
	}
	
	public static class MessagingFruitEnvironmentFactory extends AbstractEnvironmentFactory {

		protected Environment createEnvironment(EPackage packageContext) {
			MessagingFruitEnvironment result = new MessagingFruitEnvironment();
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
			MessagingFruitEnvironment result = new MessagingFruitEnvironment(parent);
			result.setFactory(this);
			return result;
		}
	}
	
	private static class MessagingFruitEnvironment extends EcoreEnvironment {
		private EClass dropSignal;
		
		private EList signals = new BasicEList();
		
		public MessagingFruitEnvironment() {
			super(fruitPackage);
			
			init();
		}
		
		public MessagingFruitEnvironment(Environment parent) {
			super(parent);
			
			init();
		}

		private void init() {
			dropSignal = EcoreFactory.eINSTANCE.createEClass();
			dropSignal.setName("Drop"); //$NON-NLS-1$
			UMLTypeUtil.setSignal(dropSignal, true);
			
			EStructuralFeature property = EcoreFactory.eINSTANCE.createEAttribute();
			property.setName("delay"); //$NON-NLS-1$
			property.setEType(Types.OCL_REAL);
			dropSignal.getEStructuralFeatures().add(property);
			property = EcoreFactory.eINSTANCE.createEReference();
			property.setName("stem"); //$NON-NLS-1$
			property.setEType(stem);
			dropSignal.getEStructuralFeatures().add(property);
			
			signals.add(dropSignal);
			
			fruitPackage.getEClassifiers().add(dropSignal);
		}
		
		void setFactory(MessagingFruitEnvironmentFactory factory) {
			super.setFactory(factory);
		}
		
		public EList getSignals(EClassifier owner) {
			if (getParent() != null) {
				return getParent().getSignals(owner);
			} else if (owner == fruit || owner == apple) {
				return signals;
			}
			
			return super.getSignals(owner);
		}
	}
}
