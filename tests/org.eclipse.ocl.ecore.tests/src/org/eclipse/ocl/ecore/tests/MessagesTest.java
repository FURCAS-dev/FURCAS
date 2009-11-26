/**
 * <copyright>
 * 
 * Copyright (c) 2006, 2009 IBM Corporation and others.
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
 * $Id: MessagesTest.java,v 1.6 2009/11/26 20:45:49 ewillink Exp $
 */

package org.eclipse.ocl.ecore.tests;

import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
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
 * Tests for message expressions.
 *
 * @author Christian W. Damus (cdamus)
 */
public class MessagesTest
	extends AbstractTestSuite {
	
	/**
	 * Tests the parsing of the hasSent ("^") expression for operations.
	 */
	public void test_hasSent_operation() {
		helper.setOperationContext(fruit, fruit_ripen);
		
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
		helper.setOperationContext(fruit, fruit_ripen);
		
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
		helper.setOperationContext(fruit, fruit_ripen);
		
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
		helper.setOperationContext(fruit, fruit_ripen);
		
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
		helper.setOperationContext(fruit, fruit_ripen);
		
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
		helper.setOperationContext(fruit, fruit_ripen);
		
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
		helper.setOperationContext(fruit, fruit_ripen);
		
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
		helper.setOperationContext(apple, fruit_ripen);
		
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
		helper.setOperationContext(fruit, fruit_ripen);
		
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
		helper.setOperationContext(fruit, fruit_ripen);
		
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
		helper.setOperationContext(apple, fruit_ripen);
		
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
		helper.setOperationContext(fruit, fruit_ripen);
		
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
		helper.setOperationContext(fruit, fruit_ripen);
		
		try {
			List<Choice> choices = helper.getSyntaxHelp(
					ConstraintKind.POSTCONDITION,
					"self^"); //$NON-NLS-1$
			assertNotNull(choices);
			assertChoice(choices, ChoiceKind.OPERATION, "newFruit"); //$NON-NLS-1$
			assertChoice(choices, ChoiceKind.OPERATION, "setColor"); //$NON-NLS-1$
			assertNotChoice(choices, ChoiceKind.OPERATION, "oclIsKindOf"); //$NON-NLS-1$
			
			choices = helper.getSyntaxHelp(
					ConstraintKind.POSTCONDITION, "self^^"); //$NON-NLS-1$
			assertNotNull(choices);
			assertChoice(choices, ChoiceKind.OPERATION, "newFruit"); //$NON-NLS-1$
			assertChoice(choices, ChoiceKind.OPERATION, "setColor"); //$NON-NLS-1$
			assertNotChoice(choices, ChoiceKind.OPERATION, "oclIsKindOf"); //$NON-NLS-1$

			// doesn't parse
			choices = helper.getSyntaxHelp(
					ConstraintKind.POSTCONDITION, "self^^^"); //$NON-NLS-1$
			assertNotNull(choices);
			assertChoice(choices, ChoiceKind.VARIABLE, "color"); //$NON-NLS-1$

			choices = helper.getSyntaxHelp(
					ConstraintKind.POSTCONDITION,
					"Apple.allInstances()->any(true)^"); //$NON-NLS-1$
			assertNotNull(choices);
			assertChoice(choices, ChoiceKind.OPERATION, "newFruit"); //$NON-NLS-1$
			assertChoice(choices, ChoiceKind.OPERATION, "setColor"); //$NON-NLS-1$
			assertChoice(choices, ChoiceKind.OPERATION, "label"); //$NON-NLS-1$
			assertNotChoice(choices, ChoiceKind.OPERATION, "oclIsKindOf"); //$NON-NLS-1$
			
			choices = helper.getSyntaxHelp(
					ConstraintKind.POSTCONDITION,
					"Apple.allInstances()->collect(a : Apple | a^^"); //$NON-NLS-1$
			assertNotNull(choices);
			assertChoice(choices, ChoiceKind.OPERATION, "newFruit"); //$NON-NLS-1$
			assertChoice(choices, ChoiceKind.OPERATION, "setColor"); //$NON-NLS-1$
			assertChoice(choices, ChoiceKind.OPERATION, "label"); //$NON-NLS-1$
			assertNotChoice(choices, ChoiceKind.OPERATION, "oclIsKindOf"); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests the presentation of signal send choices.
	 */
	public void test_contentAssist_signals() {
		helper.setOperationContext(fruit, fruit_ripen);
		
		try {
			List<Choice> choices = helper.getSyntaxHelp(
					ConstraintKind.POSTCONDITION,
					"self^"); //$NON-NLS-1$
			assertNotNull(choices);
			assertChoice(choices, ChoiceKind.SIGNAL, "Drop"); //$NON-NLS-1$

			choices = helper.getSyntaxHelp(
					ConstraintKind.POSTCONDITION, "self^^"); //$NON-NLS-1$
			assertNotNull(choices);
			assertChoice(choices, ChoiceKind.SIGNAL, "Drop"); //$NON-NLS-1$

			// doesn't parse
			choices = helper.getSyntaxHelp(
					ConstraintKind.POSTCONDITION, "self^^^"); //$NON-NLS-1$
			assertNotNull(choices);
			assertChoice(choices, ChoiceKind.VARIABLE, "color"); //$NON-NLS-1$

			choices = helper.getSyntaxHelp(
					ConstraintKind.POSTCONDITION,
					"Apple.allInstances()->any(true)^"); //$NON-NLS-1$
			assertNotNull(choices);
			assertChoice(choices, ChoiceKind.SIGNAL, "Drop"); //$NON-NLS-1$
			
			choices = helper.getSyntaxHelp(
					ConstraintKind.POSTCONDITION,
					"Apple.allInstances()->collect(a : Apple | a^^"); //$NON-NLS-1$
			assertNotNull(choices);
			assertChoice(choices, ChoiceKind.SIGNAL, "Drop"); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	//
	// Test framework
	//
	
	@Override
	protected OCL createOCL() {
		return OCL.newInstance(new MessagingFruitEnvironmentFactory(this));
	}
	
	@Override
    public void setUp() {
		super.setUp();
		expectModified = true;
	}
	
	public static class MessagingFruitEnvironmentFactory extends EcoreEnvironmentFactory {

		protected final AbstractTestSuite suite;
		
		public MessagingFruitEnvironmentFactory(AbstractTestSuite suite) {
			this.suite = suite;
		}
		
		@Override
        public EcoreEnvironment createEnvironment() {
			return new MessagingFruitEnvironment(this, suite);
		}

		@Override
        public EcoreEnvironment createEnvironment(
				Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> parent) {
			return new MessagingFruitEnvironment(this, parent, suite);
		}
	}
	
	private static class MessagingFruitEnvironment extends EcoreEnvironment implements InitEnvironment {
		protected final AbstractTestSuite suite;
		private EClass dropSignal;
		
		private EList<EClassifier> signals = new BasicEList<EClassifier>();
		
		public MessagingFruitEnvironment(MessagingFruitEnvironmentFactory factory, AbstractTestSuite suite) {
			super(resourceSet.getPackageRegistry());
			this.suite = suite;
			setFactory(factory);
			setContextPackage(suite.fruitPackage);

//			init();
		}
		
		public MessagingFruitEnvironment(
				MessagingFruitEnvironmentFactory factory,
				Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> parent, AbstractTestSuite suite) {
			super(parent);
			this.suite = suite;
			setFactory(factory);
			
			init();
		}
		
		public void init() {
			dropSignal = EcoreFactory.eINSTANCE.createEClass();
			dropSignal.setName("Drop"); //$NON-NLS-1$
			
			EStructuralFeature property = EcoreFactory.eINSTANCE.createEAttribute();
			property.setName("delay"); //$NON-NLS-1$
			property.setEType(getOCLStandardLibrary().getReal());
			dropSignal.getEStructuralFeatures().add(property);
			property = EcoreFactory.eINSTANCE.createEReference();
			property.setName("stem"); //$NON-NLS-1$
			property.setEType(suite.stem);
			dropSignal.getEStructuralFeatures().add(property);
			
			signals.add(dropSignal);
			
			suite.fruitPackage.getEClassifiers().add(dropSignal);
		}

        
        @Override
        public UMLReflection<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint> getUMLReflection() {
            return new UMLReflectionImpl() {
        		@Override
                public List<EClassifier> getSignals(EClassifier owner) {
        			if (owner == suite.fruit || owner == suite.apple) {
        				return signals;
        			}
        			
        			return super.getSignals(owner);
        		}};
        }
	}
}
