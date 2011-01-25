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
 * $Id: MessagesTest.java,v 1.8 2011/01/25 10:43:36 auhl Exp $
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
@SuppressWarnings("nls")
public class MessagesTest
	extends AbstractTestSuite {
	
	/**
	 * Tests the parsing of the hasSent ("^") expression for operations.
	 */
	public void test_hasSent_operation() {
		helper.setOperationContext(fruit, fruit_ripen);
		
		try {
			// test query operation calls without any arguments
			helper.createPostcondition("self^preferredColor()");

			// test non-query operation calls without any arguments
			helper.createPostcondition("self ^ newFruit()");

			// test operation calls with one argument.  Incidentally put a more
			//    interesting expression as the target
			helper.createPostcondition(
					"Apple.allInstances()->any(true) ^ripen(Color::yellow)");
			
			// test operation calls with multiple arguments
			helper.createPostcondition(
					"Fruit.allInstances()->forAll(f | self^setColor(f, Color::red))");
			
			// test operation signature conformance matching
			helper.createPostcondition(
					"Apple.allInstances()->forAll(a | self^setColor(a, Color::red))");
			
			// test operation signature conformance matching with null object type
			helper.createPostcondition(
					"Apple.allInstances()->forAll(a | self^setColor(null, Color::red))");
			
			// test operation signature conformance matching with null data type
			helper.createPostcondition(
					"Apple.allInstances()->forAll(a | self^setColor(a, null))");
		} catch (Exception e) {
			fail("Failed to parse: " + e.getLocalizedMessage());
		}
	}
	
	/**
	 * Tests the validation of the hasSent ("^") expression for operations.
	 */
	public void test_hasSent_operation_validation() {
		helper.setOperationContext(fruit, fruit_ripen);
		
		try {
			// non-existent operation
			helper.createPostcondition("self^label('foo')");
			
			fail("Should have failed to parse unknown operation");
		} catch (Exception e) {
			// success
			System.out.println("Got expected error: " + e.getLocalizedMessage());
		}
		
		try {
			// non-conformant argument
			helper.createPostcondition("self^setColor(self, 'red')");
			
			fail("Should have failed to parse non-conformant arg");
		} catch (Exception e) {
			// success
			System.out.println("Got expected error: " + e.getLocalizedMessage());
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
					"Apple.allInstances()->any(true)^ripen(? : Color)");
			
			helper.createPostcondition(
					"Fruit.allInstances()->forAll(f | self^setColor(? : Fruit, ? : Color))");
			
			helper.createPostcondition(
					"Apple.allInstances()->any(true)^ripen(?)");
	
			helper.createPostcondition(
					"Fruit.allInstances()->forAll(f | self^setColor(?, ?))");
		} catch (Exception e) {
			fail("Failed to parse: " + e.getLocalizedMessage());
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
			helper.createPostcondition("self^label(?)");
			
			fail("Should have failed to parse unknown operation");
		} catch (Exception e) {
			// success
			System.out.println("Got expected error: " + e.getLocalizedMessage());
		}
		
		try {
			// non-conformant argument
			helper.createPostcondition("self^setColor(self, ? : String)");
			
			fail("Should have failed to parse non-conformant arg");
		} catch (Exception e) {
			// success
			System.out.println("Got expected error: " + e.getLocalizedMessage());
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
					"self^^preferredColor()->notEmpty()");

			// test non-query operation calls without any arguments
			helper.createPostcondition("self^^newFruit()->first().oclIsKindOf(OclMessage)");

			// test operation calls with one argument.  Incidentally put a more
			//    interesting expression as the target
			helper.createPostcondition(
					"Apple.allInstances()->any(true)^^ripen(Color::yellow)->notEmpty()");
			
			// test operation calls with multiple arguments
			helper.createPostcondition(
					"Fruit.allInstances()->collect(f | self^^setColor(f, Color::red))->notEmpty()");
			
			// test operation signature conformance matching
			helper.createPostcondition(
					"Apple.allInstances()->collect(a | self^^setColor(a, Color::red))->notEmpty()");
			
			// test operation signature conformance matching with null object type
			helper.createPostcondition(
					"Apple.allInstances()->collect(a | self^^setColor(null, Color::red))->notEmpty()");
			
			// test operation signature conformance matching with null data type
			helper.createPostcondition(
					"Apple.allInstances()->collect(a | self^^setColor(a, null))->notEmpty()");
		} catch (Exception e) {
			fail("Failed to parse: " + e.getLocalizedMessage());
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
					"let msgs : Sequence(OclMessage) = self^^preferredColor() in " +
					"msgs->forAll(m | m.hasReturned() and m.isOperationCall() and not m.isSignalSent())");

			// test non-query operation calls without any arguments
			helper.createPostcondition("self^^newFruit()->first().oclIsKindOf(OclMessage)");

			// test operation calls with one argument.  Incidentally put a more
			//    interesting expression as the target
			helper.createPostcondition(
					"Apple.allInstances()->any(true)^^ripen(Color::yellow)->notEmpty()");
			
			// types of the OclMessage properties are determined by the actual
			//    operation type, not by the MessageExp arguments
			helper.createPostcondition(
					"let msgs : Collection(OclMessage) = Fruit.allInstances()->collect(f | self^^setColor(?, ?)) in " +
					"msgs->forAll(m | m.fruit.color = Color::black implies m.newColor = Color::black)");
			
			// return values
			helper.createPostcondition(
					"let msgs : Collection(OclMessage) = Fruit.allInstances()->collect(f | self^^newFruit()) in " +
					"msgs->forAll(m | m.hasReturned() implies m.result().color = Color::green)");
		} catch (Exception e) {
			fail("Failed to parse: " + e.getLocalizedMessage());
		}
	}
	
	/**
	 * Tests the validation of the setMessages ("^^") expression for operations.
	 */
	public void test_sentMessages_operation_validation() {
		helper.setOperationContext(fruit, fruit_ripen);
		
		try {
			// non-existent operation
			helper.createPostcondition("self^^label('foo')->notEmpty()");
			
			fail("Should have failed to parse unknown operation");
		} catch (Exception e) {
			// success
			System.out.println("Got expected error: " + e.getLocalizedMessage());
		}
		
		try {
			// non-conformant argument
			helper.createPostcondition("self^^setColor(self, 'red')->notEmpty()");
			
			fail("Should have failed to parse non-conformant arg");
		} catch (Exception e) {
			// success
			System.out.println("Got expected error: " + e.getLocalizedMessage());
		}
	}
	
	/**
	 * Tests the parsing of the hasSent ("^") expression for signals.
	 */
	public void test_hasSent_signal() {
		helper.setOperationContext(apple, fruit_ripen);
		
		try {
			helper.createPostcondition("self^Drop(3, self.stem)");

			helper.createPostcondition("self ^ Drop(? : Real, ? : Stem)");

			helper.createPostcondition("self ^Drop(? : Integer, ?)");

			helper.createPostcondition("self^Drop(?, ?)");

			helper.createPostcondition(
					"Apple.allInstances()->any(true)^Drop(3, stem)");
			
			helper.createPostcondition(
					"Apple.allInstances()->exists(a | a^Drop(3, stem))");
	
			helper.createPostcondition(
					"Fruit.allInstances()->forAll(f | f^Drop(?, ?) implies self^Drop(?, ?))");
		} catch (Exception e) {
			fail("Failed to parse: " + e.getLocalizedMessage());
		}
	}
	
	/**
	 * Tests the validation of the hasSent ("^") expression for signals.
	 */
	public void test_hasSent_signal_validation() {
		helper.setOperationContext(fruit, fruit_ripen);
		
		try {
			// non-existent signal
			helper.createPostcondition("self^Rot(3, stem)");
			
			fail("Should have failed to parse unknown signal");
		} catch (Exception e) {
			// success
			System.out.println("Got expected error: " + e.getLocalizedMessage());
		}
		
		try {
			// non-conformant argument
			helper.createPostcondition("self^Drop('red', ?)");
			
			fail("Should have failed to parse non-conformant arg");
		} catch (Exception e) {
			// success
			System.out.println("Got expected error: " + e.getLocalizedMessage());
		}
	}
	
	/**
	 * Tests the parsing of the sentMessages ("^^") expression for signals.
	 */
	public void test_sentMessages_signal() {
		helper.setOperationContext(fruit, fruit_ripen);
		
		try {
			helper.createPostcondition(
					"self^^Drop(3, self.oclAsType(Apple).stem)->notEmpty()");

			helper.createPostcondition("self^^Drop(?, ?)->first().oclIsKindOf(OclMessage)");

			helper.createPostcondition(
					"Apple.allInstances()->any(true)^^Drop(3, ?)->notEmpty()");
			
			helper.createPostcondition(
					"Apple.allInstances()->collect(a | self^^Drop(null, ? : Stem))->notEmpty()");
			
			helper.createPostcondition(
					"Apple.allInstances()->collect(a | self^^Drop(3, null))->notEmpty()");
		} catch (Exception e) {
			fail("Failed to parse: " + e.getLocalizedMessage());
		}
	}
	
	/**
	 * Tests the parsing of OclMessage expressions for signals.
	 */
	public void test_message_access_signal() {
		helper.setOperationContext(apple, fruit_ripen);
		
		try {
			helper.createPostcondition(
					"let msgs : Sequence(OclMessage) = self^^Drop(?, ?) in " +
					"msgs->forAll(m | m.isSignalSent() and not m.isOperationCall())");

			helper.createPostcondition("self^^Drop(?, ?)->first().oclIsKindOf(OclMessage)");

			helper.createPostcondition(
					"let msgs : Collection(OclMessage) = Fruit.allInstances()->collect(f | self^^Drop(?, ?)) in " +
					"msgs->forAll(m | m.delay > 0 and stem <> self.stem)");
		} catch (Exception e) {
			fail("Failed to parse: " + e.getLocalizedMessage());
		}
	}
	
	/**
	 * Tests the validation of the setMessages ("^^") expression for signals.
	 */
	public void test_sentMessages_signal_validation() {
		helper.setOperationContext(fruit, fruit_ripen);
		
		try {
			// non-existent signal
			helper.createPostcondition("self^^Rot('now')->notEmpty()");
			
			fail("Should have failed to parse unknown signal");
		} catch (Exception e) {
			// success
			System.out.println("Got expected error: " + e.getLocalizedMessage());
		}
		
		try {
			// non-conformant argument
			helper.createPostcondition("self^^Drop(self, ?)->notEmpty()");
			
			fail("Should have failed to parse non-conformant arg");
		} catch (Exception e) {
			// success
			System.out.println("Got expected error: " + e.getLocalizedMessage());
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
					"self^");
			assertNotNull(choices);
			assertChoice(choices, ChoiceKind.OPERATION, "newFruit");
			assertChoice(choices, ChoiceKind.OPERATION, "setColor");
			assertNotChoice(choices, ChoiceKind.OPERATION, "oclIsKindOf");
			
			choices = helper.getSyntaxHelp(
					ConstraintKind.POSTCONDITION, "self^^");
			assertNotNull(choices);
			assertChoice(choices, ChoiceKind.OPERATION, "newFruit");
			assertChoice(choices, ChoiceKind.OPERATION, "setColor");
			assertNotChoice(choices, ChoiceKind.OPERATION, "oclIsKindOf");

			// doesn't parse
			choices = helper.getSyntaxHelp(
					ConstraintKind.POSTCONDITION, "self^^^");
			assertNotNull(choices);
			assertChoice(choices, ChoiceKind.VARIABLE, "color");

			choices = helper.getSyntaxHelp(
					ConstraintKind.POSTCONDITION,
					"Apple.allInstances()->any(true)^");
			assertNotNull(choices);
			assertChoice(choices, ChoiceKind.OPERATION, "newFruit");
			assertChoice(choices, ChoiceKind.OPERATION, "setColor");
			assertChoice(choices, ChoiceKind.OPERATION, "label");
			assertNotChoice(choices, ChoiceKind.OPERATION, "oclIsKindOf");
			
			choices = helper.getSyntaxHelp(
					ConstraintKind.POSTCONDITION,
					"Apple.allInstances()->collect(a : Apple | a^^");
			assertNotNull(choices);
			assertChoice(choices, ChoiceKind.OPERATION, "newFruit");
			assertChoice(choices, ChoiceKind.OPERATION, "setColor");
			assertChoice(choices, ChoiceKind.OPERATION, "label");
			assertNotChoice(choices, ChoiceKind.OPERATION, "oclIsKindOf");
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage());
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
					"self^");
			assertNotNull(choices);
			assertChoice(choices, ChoiceKind.SIGNAL, "Drop");

			choices = helper.getSyntaxHelp(
					ConstraintKind.POSTCONDITION, "self^^");
			assertNotNull(choices);
			assertChoice(choices, ChoiceKind.SIGNAL, "Drop");

			// doesn't parse
			choices = helper.getSyntaxHelp(
					ConstraintKind.POSTCONDITION, "self^^^");
			assertNotNull(choices);
			assertChoice(choices, ChoiceKind.VARIABLE, "color");

			choices = helper.getSyntaxHelp(
					ConstraintKind.POSTCONDITION,
					"Apple.allInstances()->any(true)^");
			assertNotNull(choices);
			assertChoice(choices, ChoiceKind.SIGNAL, "Drop");
			
			choices = helper.getSyntaxHelp(
					ConstraintKind.POSTCONDITION,
					"Apple.allInstances()->collect(a : Apple | a^^");
			assertNotNull(choices);
			assertChoice(choices, ChoiceKind.SIGNAL, "Drop");
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage());
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
			return new MessagingFruitEnvironment(parent, suite);
		}
	}
	
	private static class MessagingFruitEnvironment extends EcoreEnvironment implements InitEnvironment {
		protected final AbstractTestSuite suite;
		private EClass dropSignal;
		
		private EList<EClassifier> signals = new BasicEList<EClassifier>();
		
		public MessagingFruitEnvironment(MessagingFruitEnvironmentFactory factory, AbstractTestSuite suite) {
			super(factory, null);
			this.suite = suite;
			setContextPackage(suite.fruitPackage);

//			init();
		}
		
		public MessagingFruitEnvironment(
				Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> parent, AbstractTestSuite suite) {
			super(parent);
			this.suite = suite;
			
			init();
		}
		
		public void init() {
			dropSignal = EcoreFactory.eINSTANCE.createEClass();
			dropSignal.setName("Drop");
			
			EStructuralFeature property = EcoreFactory.eINSTANCE.createEAttribute();
			property.setName("delay");
			property.setEType(getOCLStandardLibrary().getReal());
			dropSignal.getEStructuralFeatures().add(property);
			property = EcoreFactory.eINSTANCE.createEReference();
			property.setName("stem");
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
