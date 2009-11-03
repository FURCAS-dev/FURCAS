/*******************************************************************************
 * Copyright (c) 2008 ikv++ technologies ag and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     ikv++ technologies ag - initial API and implementation
 *******************************************************************************/

package de.ikv.medini.qvt;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.oslo.ocl20.synthesis.OclEvaluatorImpl;
import org.oslo.ocl20.synthesis.OclEvaluatorVisitorImpl;
import org.oslo.ocl20.synthesis.RuntimeEnvironment;
import org.oslo.ocl20.synthesis.RuntimeEnvironmentImpl;

import uk.ac.kent.cs.kmf.util.ILog;
import uk.ac.kent.cs.kmf.util.OutputStreamLog;
import de.ikv.medini.qvt.execution.QvtSemanticAnalyserThreadPool;
import de.ikv.medini.qvt.model.qvtbase.Transformation;
import de.ikv.medini.qvt.model.qvtbase.TypedModel;

/**
 * The evaluator used by the {@link QvtProcessorImpl} to evaluate the AST produced by the {@link QvtSemanticAnalyserImpl}. It creates a data map representing the evaluation
 * context and passes it to a {@link QvtEvaluatorVisitorImpl} which traverses the AST and evaluates its expressions. The result of this evaluation is a collection of {@link Trace}s.
 * 
 * @author Michael Wagner
 * @author Omar Ekine
 * @author Joerg Kiegeland
 * 
 */
public class QvtEvaluatorImpl extends OclEvaluatorImpl {

	/**
	 * The name of the key used in the data map to indicate the execution mode. Its value can be either <code>true</code> for enforcement or <code>false</code> for checking
	 * only.
	 */
	public static final String QVT_ENFORCE_PROPERTY_NAME = "qvtEnforce";

	/**
	 * The name of the key used in the data map to indicate the execution direction. Its value can be any {@link TypedModel} object representing one of the transformation
	 * parameters in the QVT script
	 */
	public static final String QVT_EXECUTION_DIRECTION_PROPERTY_NAME = "qvtDirection";

	/**
	 * The name of the key used in the data map to specify the traces of the previous traces of the executed transformation. Its value can be any of the transformation typed model
	 * parameters in the QVT script
	 */
	public static final String QVT_RELATION_OLD_TRACES_SET_PROPERTY_NAME = "oldTracesList";

	/**
	 * The name of the key used in the data map to specify whether the 'when' or 'where' domain is currently being evaluated. Its value can be either <code>when</code> or
	 * <code>where</code>.
	 */
	public static final String QVT_LOCAL_EXECUTION_MODE_PROPERTY_NAME = "localExecutionMode";

	/**
	 * The name of the key used in the data map to specify the runtime environment. Its value can be any {@link RuntimeEnvironment} object.
	 */
	public static final String QVT_RUNTIME_ENVIRONMENT_PROPERTY_NAME = "env";

	/**
	 * The name of the key used in the data map to specify the log to use for output. Its value can be any {@link ILog} object.
	 */
	public static final String QVT_LOG_PROPERTY_NAME = "log";

	/**
	 * The executed transformation.
	 */
	protected Transformation transformation;

	/**
	 * The traces from the previous execution of this transformation.
	 */
	protected Collection oldTraces = new HashSet();

	/**
	 * Creates a QVT evaluator with the given processor and evaluator visitor.
	 * 
	 * @param qvtProcessor
	 *            the QVT processor.
	 * @param evaluator
	 *            the evaluator visitor.
	 */
	public QvtEvaluatorImpl(QvtProcessorImpl qvtProcessor, OclEvaluatorVisitorImpl evaluator) {
		super(qvtProcessor, evaluator);
	}

	/**
	 * Evaluates the transformation and returns the resulting traces. An evaluation context comprising of amongst other of a {@link RuntimeEnvironment} and the old traces is
	 * created and the evaluator visitor uses this context to do the actual evaluation.
	 * 
	 * @param enforce
	 *            flag to indicate whether to run in enforcement (<code>true</code>) or check only (<code>false</code>) mode.
	 * @param direction
	 *            the excution direction.
	 * @return a collection of {@link Trace}s.
	 */
	protected Collection evaluateQvt(boolean enforce, TypedModel direction) {

		if (this.renv == null) {
			this.renv = new RuntimeEnvironmentImpl();
		}

		if (this.log == null) {
			this.log = new OutputStreamLog(System.out);
		}

		// --- Create the context for the evalution ---
		Map data = new HashMap();
		data.put(QvtEvaluatorImpl.QVT_RUNTIME_ENVIRONMENT_PROPERTY_NAME, this.renv);
		data.put("log", this.log);
		data.put(QvtEvaluatorImpl.QVT_ENFORCE_PROPERTY_NAME, new Boolean(enforce));
		data.put(QvtEvaluatorImpl.QVT_EXECUTION_DIRECTION_PROPERTY_NAME, direction);
		data.put(QvtEvaluatorImpl.QVT_RELATION_OLD_TRACES_SET_PROPERTY_NAME, this.oldTraces);

		// --- Evaluate the input ---
		return (Collection) this.transformation.accept(this.getQvtEvaluatorVisitor(), data);
	}

	public QvtEvaluatorVisitorImpl getQvtEvaluatorVisitor() {
		return (QvtEvaluatorVisitorImpl) this.evaluator;
	}

	/**
	 * This is a convenience method that simply sets the given <code>transformation</code>, runtime environment <code>renv</code>, creates a log pointing to the standard
	 * output and calls {@link #evaluateQvt(boolean, TypedModel)}.
	 * 
	 * @param transformation
	 *            the transformation to evaluate.
	 * @param enforce
	 *            the execution mode. <code>true</code> for enforcement, <code>false</code> for check only.
	 * @param direction
	 *            the excution direction.
	 * @param renv
	 *            the runtime environment.
	 * @return a collection of {@link Trace}s.
	 * @see #evaluateQvt(boolean, TypedModel)
	 */
	public Collection evaluateQvt(Transformation transformation, boolean enforce, TypedModel direction, RuntimeEnvironment renv) {
		// --- Set local variables ---
		this.transformation = transformation;
		this.renv = renv;
		this.log = new OutputStreamLog(System.out);

		// --- Evaluate ---
		return this.evaluateQvt(enforce, direction);
	}

	/**
	 * This is a convenience method that simply sets the given <code>transformation</code>, creates a new runtime environment, creates a log pointing to the standard output and
	 * calls {@link #evaluateQvt(boolean, TypedModel)}.
	 * 
	 * @param transformation
	 *            the transformation to evaluate.
	 * @param enforce
	 *            the execution mode. <code>true</code> for enforcement, <code>false</code> for check only.
	 * @param direction
	 *            the excution direction.
	 * @return a collection of {@link Trace}s.
	 * @see #evaluateQvt(boolean, TypedModel)
	 */
	public Collection evaluateQvt(Transformation transformation, boolean enforce, TypedModel direction) {
		// --- Set local variables ---
		this.transformation = transformation;
		this.renv = new RuntimeEnvironmentImpl();
		this.log = new OutputStreamLog(System.out);

		// --- Evaluate ---
		return this.evaluateQvt(enforce, direction);
	}

	/**
	 * This is a convenience method that simply sets the given <code>transformation</code>, runtime environment <code>renv</code>, <code>log</code> and calls
	 * {@link #evaluateQvt(boolean, TypedModel)}.
	 * 
	 * @param transformation
	 *            the transformation to evaluate.
	 * @param enforce
	 *            the execution mode. <code>true</code> for enforcement, <code>false</code> for check only.
	 * @param direction
	 *            the excution direction.
	 * @param renv
	 *            the runtime environment.
	 * @param log
	 *            the log to use for output.
	 * @return a collection of {@link Trace}s.
	 * @see #evaluateQvt(boolean, TypedModel)
	 */
	public Collection evaluateQvt(Transformation transformation, boolean enforce, TypedModel direction, RuntimeEnvironment renv, ILog log) {
		// --- Set local variables ---
		this.transformation = transformation;
		this.renv = renv;
		this.log = log;

		// --- Evaluate ---
		return this.evaluateQvt(enforce, direction);
	}

	/**
	 * This is a convenience method that simply sets the given <code>transformation</code>, runtime environment <code>renv</code>, <code>log</code> <code>oldTraces</code>
	 * and calls {@link #evaluateQvt(boolean, TypedModel)}.
	 * 
	 * @param transformation
	 *            the transformation to evaluate.
	 * @param enforce
	 *            the execution mode. <code>true</code> for enforcement, <code>false</code> for check only.
	 * @param direction
	 *            the excution direction.
	 * @param renv
	 *            the runtime environment.
	 * @param oldTraces
	 *            the traces of this transformation's previous execution.
	 * @param log
	 *            the log to use for output.
	 * @return a collection of {@link Trace}s.
	 * @see #evaluateQvt(boolean, TypedModel)
	 */
	public Collection evaluateQvt(Transformation transformation, boolean enforce, TypedModel direction, RuntimeEnvironment renv, Collection oldTraces, ILog log) {
		// --- Set local variables ---
		this.transformation = transformation;
		this.renv = renv;
		this.log = log;
		this.oldTraces = oldTraces;

		// --- Evaluate ---
		return this.evaluateQvt(enforce, direction);
	}

	public QvtSemanticAnalyserThreadPool getThreadPool() {
		return ((QvtEvaluatorVisitorImpl) this.evaluator).getThreadPool();
	}
}
