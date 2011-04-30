/*******************************************************************************
 * Copyright (c) 2009, 2011 Borland Software Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Radek Dvorak - initial API and implementation
 *     Axel Uhl (SAP AG) - Bug 342644
 *******************************************************************************/
package org.eclipse.ocl.uml.tests;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.EnvironmentFactory;
import org.eclipse.ocl.EvaluationEnvironment;
import org.eclipse.ocl.EvaluationHaltedException;
import org.eclipse.ocl.EvaluationVisitor;
import org.eclipse.ocl.EvaluationVisitorDecorator;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.uml.OCL;
import org.eclipse.ocl.uml.OCL.Query;
import org.eclipse.ocl.uml.UMLEnvironment;
import org.eclipse.ocl.uml.UMLEnvironmentFactory;
import org.eclipse.ocl.uml.UMLEvaluationEnvironment;
import org.eclipse.ocl.util.OCLUtil;
import org.eclipse.uml2.uml.CallOperationAction;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.SendSignalAction;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.UMLFactory;

/**
 * Tests usage of EvaluationHaltedException.
 * 
 * @author radvorak
 */
@SuppressWarnings("nls")
public class EvaluationHaltedTest
		extends AbstractTestSuite {

	org.eclipse.ocl.expressions.OCLExpression<Classifier> queryExp;
	org.eclipse.ocl.uml.OCL.Query query;
	InterruptibleEnvFactory envFactory = new InterruptibleEnvFactory();

	@Override
	public OCL createOCL() {
		return OCL.newInstance(envFactory);
	}

	@Override
	protected void setUp() {
		envFactory = new InterruptibleEnvFactory();
		super.setUp();
		helper.setContext(ocl.getEnvironment().getOCLStandardLibrary()
			.getString());

		try {
			// testing on iteration to check exception propagation through
			// nested #visitExpression() and operation call
			this.queryExp = helper
				.createQuery("Sequence { self }->collect(i | i.halt(self))");
			assertNull(helper.getProblems());

		} catch (Exception e) {
			fail("Failed to parse: " + e.getLocalizedMessage());
		}

		query = (Query) ocl.createQuery(queryExp);
	}

	public void testBasicEvaluationHalted() {
		assertNull(ocl.getEvaluationProblems());

		Object result = ocl.evaluate(HALT_KIND_BASIC, queryExp);
		assertInvalid(result);

		Diagnostic evaluationProblems = ocl.getEvaluationProblems();
		assertNotNull(evaluationProblems);
		assertNull(evaluationProblems.getException());
		assertEquals(evaluationProblems.getMessage(), HALT_KIND_BASIC);
		// clear problems from previous run
		ocl.evaluate(HALT_KIND_NONE, queryExp);
		assertNull(ocl.getProblems());
	}

	public void testEvaluationHaltedOnError() {
		assertNull(ocl.getEvaluationProblems());

		Object result = ocl.evaluate(HALT_KIND_ON_ERROR, queryExp);
		assertInvalid(result);

		Diagnostic evaluationProblems = ocl.getEvaluationProblems();
		assertNotNull(evaluationProblems);
		Throwable exception = evaluationProblems.getException();
		assertTrue(exception instanceof TestCauseException);
		assertEquals(evaluationProblems.getMessage(), HALT_KIND_ON_ERROR);

		// clear problems from previous run
		ocl.evaluate(HALT_KIND_NONE, queryExp);
		assertNull(ocl.getProblems());
	}

	public void testEvaluationHaltedWithCustomDiagnostic() {
		assertNull(ocl.getEvaluationProblems());

		Object result = ocl.evaluate(HALT_KIND_CUSTOM, queryExp);
		assertInvalid(result);

		Diagnostic evaluationProblems = ocl.getEvaluationProblems();
		assertSame(CUSTOM_DIAGNOSTIC_INSTANCE, evaluationProblems);
		assertNull(evaluationProblems.getException());
		assertEquals(evaluationProblems.getMessage(),
			CUSTOM_DIAGNOSTIC_INSTANCE.getMessage());
		// clear problems from previous run
		ocl.evaluate(HALT_KIND_NONE, queryExp);
		assertNull(ocl.getProblems());
	}

	public void testOCLCaughtExcConvertedToInvalid() {
		assertNull(ocl.getEvaluationProblems());

		assertInvalid(ocl.evaluate(HALT_KIND_BASIC, queryExp));
		assertNotNull(ocl.getEvaluationProblems());

		// no diagnostic should be available
		assertFalse(this.exceptionThrown);

		Object result = ocl.evaluate(OCL_CATCHED_EXC, queryExp);
		assertInvalid(result);
		// check we it was thrown
		assertTrue(this.exceptionThrown);
		// no evaluation halt due to evaluation problems
		assertNull(ocl.getEvaluationProblems());
	}

	public void testHaltedQuery() {
		assertNull(OCLUtil.getEvaluationProblems(query));

		assertListResult(query.evaluate(HALT_KIND_NONE), Collections.singletonList(HALT_KIND_NONE));
		assertNull(OCLUtil.getEvaluationProblems(query));

		envFactory.haltOnContextLessExecution = true;
		assertInvalid(query.evaluate(HALT_KIND_NONE));
		assertNotNull(OCLUtil.getEvaluationProblems(query));
		assertNotNull(OCLUtil.getEvaluationProblems(query).getMessage().equals(
			"Halt"));
		envFactory.haltOnContextLessExecution = false;
		// check we clear the problems on next evaluate
		query.evaluate(HALT_KIND_NONE);
		assertNull(OCLUtil.getEvaluationProblems(query));
	}

	public void testEvaluateListHaltedQuery() {
		assertNull(OCLUtil.getEvaluationProblems(query));

		List<?> listResult = query.evaluate(Arrays.asList(HALT_KIND_BASIC,
			HALT_KIND_NONE, HALT_KIND_CUSTOM));
		// check result
		assertEquals(3, listResult.size());
		assertInvalid(listResult.get(0));
		assertListResult(listResult.get(1), Collections
			.singletonList(HALT_KIND_NONE));
		assertInvalid(listResult.get(2));
		// check for problems
		Diagnostic batchProblems = OCLUtil.getEvaluationProblems(query);
		assertNotNull(batchProblems);
		// expect only 2 problems, HALT_KIND_NONE does not stop evaluation
		assertEquals(2, batchProblems.getChildren().size());
		assertEquals(HALT_KIND_BASIC, batchProblems.getChildren().get(0)
			.getMessage());
		assertEquals(HALT_KIND_CUSTOM, batchProblems.getChildren().get(1)
			.getMessage());

		// test problems cleanup on next run
		query.evaluate(Arrays.asList(HALT_KIND_NONE));
		assertNull(OCLUtil.getEvaluationProblems(query));
	}

	public void testSelectListHaltedQuery() {
		query = createQuery("Sequence { self }->exists(i | i.halt(self) = 'none')");
		assertNull(OCLUtil.getEvaluationProblems(query));

		List<?> listResult = query.select(Arrays.asList(HALT_KIND_BASIC,
			HALT_KIND_NONE, HALT_KIND_CUSTOM));
		// check result
		assertEquals(1, listResult.size());
		assertEquals(listResult.get(0), HALT_KIND_NONE);
		// check for problems
		Diagnostic batchProblems = OCLUtil.getEvaluationProblems(query);
		assertNotNull(batchProblems);
		// expect only 2 problems, HALT_KIND_NONE does not stop evaluation
		assertEquals(2, batchProblems.getChildren().size());
		assertEquals(HALT_KIND_BASIC, batchProblems.getChildren().get(0)
			.getMessage());
		assertEquals(HALT_KIND_CUSTOM, batchProblems.getChildren().get(1)
			.getMessage());

		// test problems cleanup on next run
		assertEquals(Arrays.asList(HALT_KIND_NONE), query.select(Arrays
			.asList(HALT_KIND_NONE)));
		assertNull(OCLUtil.getEvaluationProblems(query));
	}

	public void testRejectListHaltedQuery() {
		query = createQuery("Sequence { self }->one(i | i.halt(self) = 'none')");
		assertNull(OCLUtil.getEvaluationProblems(query));

		List<?> listResult = query.reject(Arrays.asList(HALT_KIND_BASIC,
			HALT_KIND_NONE, HALT_KIND_CUSTOM));
		// check result
		assertEquals(2, listResult.size());
		assertListResult(listResult, Arrays.asList(HALT_KIND_BASIC,
			HALT_KIND_CUSTOM));
		// check for problems
		Diagnostic batchProblems = OCLUtil.getEvaluationProblems(query);
		assertNotNull(batchProblems);
		// expect only 2 problems, HALT_KIND_NONE does not stop evaluation
		assertEquals(2, batchProblems.getChildren().size());
		assertEquals(HALT_KIND_BASIC, batchProblems.getChildren().get(0)
			.getMessage());
		assertEquals(HALT_KIND_CUSTOM, batchProblems.getChildren().get(1)
			.getMessage());

		// test problems cleanup on next run
		assertEquals(Collections.emptyList(), query.reject(Arrays
			.asList(HALT_KIND_NONE)));
		assertNull(OCLUtil.getEvaluationProblems(query));
	}

	public void testVariablesCleanup() {
		// let expression
		assertCleanupAfterHaltedEvaluation("let i : OclAny = true in halt('basic')");
		assertCleanupAfterHaltedEvaluation("let i : OclAny = halt('basic') in true");
		// any
		assertCleanupAfterHaltedEvaluation("Bag { 'foo' }->any(i | i.halt('basic').size() > 0)");
		// collect
		assertCleanupAfterHaltedEvaluation("Bag { 'foo' }->collect(i | i.halt('basic'))");
		// collectNested
		assertCleanupAfterHaltedEvaluation("Bag { Bag{ 'foo'} }->collectNested(i | i.halt('basic'))");		
		// exists
		assertCleanupAfterHaltedEvaluation("Bag { 'foo' }->exists(i | i.halt('basic').size() > 0)");
		// forAll
		assertCleanupAfterHaltedEvaluation("Bag { 'foo' }->forAll(i1, i2 | i1.halt('basic').size() > 0)");
		// isUnique
		assertCleanupAfterHaltedEvaluation("Bag { 'foo' }->isUnique(i | i.halt('basic'))");
		// one
		assertCleanupAfterHaltedEvaluation("Bag { 'foo' }->one(i | i.halt('basic').size() > 0)");
		// reject
		assertCleanupAfterHaltedEvaluation("Bag { 'foo' }->reject(i | i.halt('basic').size() > 0)");
		// select
		assertCleanupAfterHaltedEvaluation("Bag { 'foo' }->select(i | i.halt('basic').size() > 0)");
		// sortedBy
		assertCleanupAfterHaltedEvaluation("Bag { 'a', 'b' }->sortedBy(i | i.halt('basic'))");		
	}

	//
	// Framework part
	//
	static final String HALT_OPERATION_NAME = "halt";

	static final String HALT_KIND_BASIC = "basic";	

	static final String HALT_KIND_ON_ERROR = "error";	

	static final String HALT_KIND_CUSTOM = "custom";

	static final String HALT_KIND_NONE = "none";	

	static final String OCL_CATCHED_EXC = "ocl.catch";	

	static final Diagnostic CUSTOM_DIAGNOSTIC_INSTANCE = new BasicDiagnostic(
		HALT_KIND_CUSTOM, 0, HALT_KIND_CUSTOM, null);

	class InterruptibleEnv
			extends UMLEnvironment {

		Operation haltOperation;

		// this constructor is used to initialize the root environment
		InterruptibleEnv(EPackage.Registry registry, ResourceSet rset) {
			super(registry, rset);

			defineHaltOperation();
		}

		// this constructor is used to initialize child environments
		InterruptibleEnv(InterruptibleEnv parent) {
			super(parent);

			// get the parent's custom operations
			haltOperation = parent.haltOperation;
		}

		@Override
		protected void setFactory(
				EnvironmentFactory<Package, Classifier, Operation, Property, EnumerationLiteral, Parameter, State, CallOperationAction, SendSignalAction, Constraint, Class, EObject> factory) {
			super.setFactory(factory);
		}

		private void defineHaltOperation() {
			haltOperation = UMLFactory.eINSTANCE.createOperation();
			haltOperation.setName(HALT_OPERATION_NAME);
			haltOperation.setType(getOCLStandardLibrary().getString());
			Parameter parm = UMLFactory.eINSTANCE.createParameter();
			parm.setName("kind");
			parm.setType(getOCLStandardLibrary().getString());
			haltOperation.getOwnedParameters().add(parm);
			haltOperation.setIsQuery(true);

			addHelperOperation(getOCLStandardLibrary().getString(),
				haltOperation);
		}
	}

	class InterruptibleEvalEnv
			extends UMLEvaluationEnvironment {

		private Set<String> names = new HashSet<String>();

		InterruptibleEvalEnv(UMLEnvironmentFactory factory) {
			super(factory);
		}

		InterruptibleEvalEnv(
				EvaluationEnvironment<Classifier, Operation, Property, Class, EObject> parent) {
			super(parent);
		}

		@Override
		public boolean overrides(Operation operation, int opcode) {
			return operation.getName().equals(HALT_OPERATION_NAME);
		}

		@Override
		public Object callOperation(Operation operation, int opcode,
				Object source, Object[] args) {
			String kind = (String) args[0];
			if (HALT_KIND_BASIC.equals(kind)) {
				throw new EvaluationHaltedException(HALT_KIND_BASIC);
			} else if (HALT_KIND_ON_ERROR.equals(kind)) {
				TestCauseException error = new TestCauseException();
				error.fillInStackTrace();
				throw new EvaluationHaltedException(HALT_KIND_ON_ERROR, error);
			} else if (HALT_KIND_CUSTOM.equals(kind)) {
				throw new EvaluationHaltedException(CUSTOM_DIAGNOSTIC_INSTANCE);
			} else if (OCL_CATCHED_EXC.equals(kind)) {
				throw new TestCauseException();
			}

			assertEquals(HALT_KIND_NONE, kind);
			return kind;
		}

		@Override
		public void add(String name, Object value) {
			names.add(name);
			super.add(name, value);
		}

		@Override
		public Object remove(String name) {
			names.remove(name);
			return super.remove(name);
		}

		@Override
		public void clear() {
			names.clear();
		}

		boolean isEmpty() {
			return names.isEmpty();
		}
	}

	class InterruptibleEnvFactory
			extends UMLEnvironmentFactory {

		public boolean haltOnContextLessExecution = false;

		@Override
		public InterruptibleEnv createEnvironment() {
			InterruptibleEnv result = new InterruptibleEnv(
				getEPackageRegistry(), getResourceSet());
			result.setFactory(this);
			return result;
		}

		@Override
		public Environment<Package, Classifier, Operation, Property, EnumerationLiteral, Parameter, State, CallOperationAction, SendSignalAction, Constraint, Class, EObject> createEnvironment(
				Environment<Package, Classifier, Operation, Property, EnumerationLiteral, Parameter, State, CallOperationAction, SendSignalAction, Constraint, Class, EObject> parent) {
			if (!(parent instanceof InterruptibleEnv)) {
				throw new IllegalArgumentException(
					"Parent environment must be my environment: " + parent);
			}

			InterruptibleEnv result = new InterruptibleEnv(
				(InterruptibleEnv) parent);
			result.setFactory(this);
			return result;
		}

		@Override
		public EvaluationEnvironment<Classifier, Operation, Property, Class, EObject> createEvaluationEnvironment() {
			return new InterruptibleEvalEnv(this);
		}

		@Override
		public EvaluationEnvironment<Classifier, Operation, Property, Class, EObject> createEvaluationEnvironment(
				EvaluationEnvironment<Classifier, Operation, Property, Class, EObject> parent) {
			return new InterruptibleEvalEnv(parent);
		}

		@Override
		public EvaluationVisitor<Package, Classifier, Operation, Property, EnumerationLiteral, Parameter, State, CallOperationAction, SendSignalAction, Constraint, Class, EObject> createEvaluationVisitor(
				Environment<Package, Classifier, Operation, Property, EnumerationLiteral, Parameter, State, CallOperationAction, SendSignalAction, Constraint, Class, EObject> env,
				EvaluationEnvironment<Classifier, Operation, Property, Class, EObject> evalEnv,
				Map<? extends Class, ? extends Set<? extends EObject>> extentMap) {

			EvaluationVisitor<Package, Classifier, Operation, Property, EnumerationLiteral, Parameter, State, CallOperationAction, SendSignalAction, Constraint, Class, EObject> baseVisitor = super
				.createEvaluationVisitor(env, evalEnv, extentMap);
			if (haltOnContextLessExecution) {
				return new EvaluationVisitorDecorator<Package, Classifier, Operation, Property, EnumerationLiteral, Parameter, State, CallOperationAction, SendSignalAction, Constraint, Class, EObject>(
					baseVisitor) {

					@Override
					public Object visitExpression(
							org.eclipse.ocl.expressions.OCLExpression<Classifier> expression) {
						throw new EvaluationHaltedException("Halt");
					}
				};
			}
			return baseVisitor;
		}

	}

	private boolean exceptionThrown = false;

	private class TestCauseException
			extends RuntimeException {

		private static final long serialVersionUID = -2513266245112148087L;

		public TestCauseException() {
			exceptionThrown = true;
		}
	}

	private org.eclipse.ocl.uml.OCL.Query createQuery(String expression) {
		try {
			return (Query) ocl.createQuery(helper.createQuery(expression));
		} catch (ParserException e) {
			// processed bellow
			fail(e.getLocalizedMessage());
		}

		return null;
	}

	private void assertCleanupAfterHaltedEvaluation(String testExpression) {
		query = createQuery(testExpression);
		InterruptibleEvalEnv evalEnv = (InterruptibleEvalEnv) query
			.getEvaluationEnvironment();

		Object result = query.evaluate();
		assertInvalid(result);
		// expect the evaluation environment cleared
		assertTrue(evalEnv.isEmpty());

		Diagnostic evaluationProblems = OCLUtil.getEvaluationProblems(query);
		assertNotNull(evaluationProblems);
		assertTrue(evaluationProblems.getChildren().isEmpty());
		assertEquals(HALT_KIND_BASIC, evaluationProblems.getMessage());
	}

	private static void assertListResult(Object result, List<?> expectedElements) {
		assertTrue("result must be a List", result instanceof List<?>);
		assertNotNull("expectedElements must be a List", result instanceof List<?>);		
		List<?> resultCollection = (List<?>) result;
		assertEquals(expectedElements, resultCollection);
	}
}