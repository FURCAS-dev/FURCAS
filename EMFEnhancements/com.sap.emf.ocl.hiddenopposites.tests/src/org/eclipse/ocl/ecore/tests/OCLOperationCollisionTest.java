/*******************************************************************************
 * Copyright (c) 2008 Obeo, Zeligsoft Inc., and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *     Zeligsoft - Bug 243079 (fix test so that it will work)
 *******************************************************************************/
package org.eclipse.ocl.ecore.tests;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.ocl.EvaluationEnvironment;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.EcoreEnvironment;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.helper.OCLHelper;

import com.sap.emf.ocl.hiddenopposites.DefaultOppositeEndFinder;
import com.sap.emf.ocl.hiddenopposites.EcoreEnvironmentFactoryWithHiddenOpposites;
import com.sap.emf.ocl.hiddenopposites.EvaluationEnvironmentWithHiddenOppositesImpl;
import com.sap.emf.ocl.hiddenopposites.OCLWithHiddenOpposites;

/**
 * Shows the "operation names collision" bug. When defining a new EOperations
 * which name is the same as a predefined operation (even if its signature does
 * not correspond), an opCode is affected to the OperationCallExp and the
 * evaluation returns <code>null</code> without going through the
 * EvaluationEnvironment's callOperation method.
 * 
 * @author <a href="mailto:laurent.goubet@obeo.fr">Laurent Goubet</a>
 */
@SuppressWarnings("nls")
public class OCLOperationCollisionTest
		extends AbstractTestSuite {

	/**
	 * Name of the colliding operation we'll provide as an additional EOperation
	 * on type String.
	 */
	private static final String OPERATION_STRING_LAST = "last";

	/** Flag to see whether the custom environment was called. */
	private boolean enteredMyOperationBody;

	@Override
	protected void setUp() {
		super.setUp();
		((EcoreEnvironment) ocl.getEnvironment()).addHelperOperation(ocl
			.getEnvironment().getOCLStandardLibrary().getString(),
			getLastOperation());
	}

	@Override
	protected OCL createOCL() {
		return OCLWithHiddenOpposites.newInstance(new MyEnvironmentFactory());
	}

	/**
	 * This will simply create an EOperation named "last" with a return type
	 * equal to the primitive OCL "String" type.
	 * 
	 * @return The created EOperation.
	 */
	public EOperation getLastOperation() {
		EOperation operation = EcoreFactory.eINSTANCE.createEOperation();
		operation.setName(OPERATION_STRING_LAST);
		operation.setEType(ocl.getEnvironment().getOCLStandardLibrary()
			.getString());
		return operation;
	}

	/**
	 * Creates and return a "dummy" ecore model : a single EPackage "package"
	 * containing a single EClass "Class".
	 * 
	 * @return the created EPackage.
	 */
	public EPackage getDummyModel() {
		EPackage packaje = EcoreFactory.eINSTANCE.createEPackage();
		packaje.setName("package");

		EClass clazz = EcoreFactory.eINSTANCE.createEClass();
		clazz.setName("Class");

		packaje.getEClassifiers().add(clazz);
		return packaje;
	}

	/**
	 * Actual test displaying our collision.
	 * 
	 * @throws ParserException
	 *             This shouldn't be thrown.
	 */
	public void testEvaluation()
			throws ParserException {
		OCLHelper<EClassifier, ?, ?, ?> helper = ocl.createOCLHelper();
		helper.setContext(EcorePackage.eINSTANCE.getENamedElement());
		OCLExpression<EClassifier> expression = helper
			.createQuery("self.name.last()");
		try {
			ocl.createQuery(expression).evaluate(
				getDummyModel().getEClassifiers().get(0));
			assertTrue(
				"Evaluation should have gone through MyEvaluationEnvironment#callOperation()",
				enteredMyOperationBody);
		} catch (UnsupportedOperationException e) {
			// expected behavior
		}
	}

	/**
	 * Dummy environment factory. Will allow us to create our own evaluation
	 * environment.
	 */
	private class MyEnvironmentFactory
			extends EcoreEnvironmentFactoryWithHiddenOpposites {

		@Override
		public EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject> createEvaluationEnvironment() {
			return new MyEvaluationEnvironment();
		}

		@Override
		public EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject> createEvaluationEnvironment(
				EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject> parent) {
			return new MyEvaluationEnvironment(parent);
		}
	}

	/**
	 * Dummy Evaluation environment. Will throw an
	 * {@link UnsupportedOperationException} if its callOperation method is
	 * called on the {@value OPERATION_STRING_LAST} method.
	 * 
	 * @author <a href="mailto:laurent.goubet@obeo.fr">Laurent Goubet</a>
	 */
	private class MyEvaluationEnvironment
			extends EvaluationEnvironmentWithHiddenOppositesImpl {

		/**
		 * Default constructor.
		 */
		public MyEvaluationEnvironment() {
			super(new DefaultOppositeEndFinder(EPackage.Registry.INSTANCE));
		}

		/**
		 * This constructor is needed by the factory.
		 * 
		 * @param parent
		 *            Parent evaluation environment.
		 */
		public MyEvaluationEnvironment(
				EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject> parent) {
			super(parent);
		}

		@Override
		public Object callOperation(EOperation operation, int opcode,
				Object source, Object[] args) {
			if (OPERATION_STRING_LAST.equals(operation.getName())) {
				enteredMyOperationBody = true;
			}
			return super.callOperation(operation, opcode, source, args);
		}
	}
}
