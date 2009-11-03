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

package de.ikv.medini.qvt.execution;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.oslo.ocl20.semantics.SemanticsVisitable;
import org.oslo.ocl20.semantics.bridge.Enumeration;
import org.oslo.ocl20.semantics.bridge.OclModelElementType;
import org.oslo.ocl20.semantics.bridge.Property;
import org.oslo.ocl20.semantics.model.expressions.OclExpression;
import org.oslo.ocl20.semantics.model.expressions.OperationCallExp;
import org.oslo.ocl20.semantics.model.expressions.StringLiteralExp;
import org.oslo.ocl20.semantics.model.expressions.VariableDeclaration;
import org.oslo.ocl20.semantics.model.expressions.VariableExp;
import org.oslo.ocl20.semantics.model.types.BagType;
import org.oslo.ocl20.semantics.model.types.CollectionType;
import org.oslo.ocl20.semantics.model.types.OrderedSetType;
import org.oslo.ocl20.semantics.model.types.SequenceType;
import org.oslo.ocl20.semantics.model.types.SetType;
import org.oslo.ocl20.standard.lib.OclAny;
import org.oslo.ocl20.standard.lib.OclAnyModelElement;
import org.oslo.ocl20.standard.lib.OclBoolean;
import org.oslo.ocl20.standard.lib.OclBooleanImpl;
import org.oslo.ocl20.standard.lib.OclCollection;
import org.oslo.ocl20.standard.lib.OclSet;
import org.oslo.ocl20.standard.lib.OclString;
import org.oslo.ocl20.standard.lib.OclUndefined;
import org.oslo.ocl20.synthesis.RuntimeEnvironment;

import de.ikv.medini.qvt.QVTDirectedValidation;
import de.ikv.medini.qvt.QVTProcessorConsts;
import de.ikv.medini.qvt.QVTSuitableKey;
import de.ikv.medini.qvt.QvtEvaluatorImpl;
import de.ikv.medini.qvt.QvtEvaluatorVisitorImpl;
import de.ikv.medini.qvt.QvtProcessorImpl;
import de.ikv.medini.qvt.Trace;
import de.ikv.medini.qvt.execution.debug.QVTDebugPosition;
import de.ikv.medini.qvt.execution.debug.QVTSourcePosition;
import de.ikv.medini.qvt.model.qvtbase.Transformation;
import de.ikv.medini.qvt.model.qvtbase.TypedModel;
import de.ikv.medini.qvt.model.qvtrelation.Key;
import de.ikv.medini.qvt.model.qvtrelation.Relation;
import de.ikv.medini.qvt.model.qvtrelation.RelationCallExp;
import de.ikv.medini.qvt.model.qvtrelation.RelationDomain;
import de.ikv.medini.qvt.model.qvttemplate.ObjectTemplateExp;
import de.ikv.medini.qvt.model.qvttemplate.PropertyTemplateItem;
import de.ikv.medini.qvt.util.QvtSemanticTaskDebugInfo;

/**
 * This class executes one domain tuple (a "task") of a relation, by iterating over all bindings for that domain tuple. Note that there is at least one binding even if there are no
 * nested object templates. All bindings are sequentially processed. If one binding is waiting for another task to be executed, {@link #waitingForTask} is set to this task and the
 * execution of this binding (and all subsequent bindings) is suspended. This task is considered to have successfully executed (see {@link #executed}), if at least one binding
 * passed all "when" clauses successfully. This task is considered to have failed (see {@link #failed}), if for each binding at least one "when" clause failed. The task can also
 * fail, when it is never actually executed, e.g. when {@link #shallBeExecuted} is never set to <code>true</code>. However, an already failed task can be re-executed, when it is
 * belated propagated to be executed.
 * 
 * @author Michael Wagner
 * @author Omar Ekine
 * @author Joerg Kiegeland
 * 
 */
public class QvtSemanticTask implements Runnable {

	/**
	 * Flag whether to use optimized binding iterator. Changing the value of this flag may help identifying a bug in {@link QvtOptimizedSemanticBindingIterator} or in
	 * {@link QvtSemanticBindingIterator}.
	 */
	private static final boolean useOptimizedBindingIterator = true;

	/**
	 * Determines if a task shall resume if the waited-for task is not only executed but also all it's bindings are processed
	 */
	static boolean requireExecutedTaskToCompleteForWaitingTasks = true;

	private QvtEvaluatorVisitorImpl qvtEvaluatorVisitorImpl;

	/**
	 * The referred relation.
	 */
	private Relation relation;

	/**
	 * The referred trace
	 */
	private Trace trace;

	/**
	 * The referred target model
	 */
	private TypedModel targetModel;

	/**
	 * Cache for the calculated hash code for better performance
	 */
	private int hashCode;

	/**
	 * Binding iterator for nested object templates
	 */
	private Iterator qvtSemanticBindingIterator;

	/**
	 * Current binding
	 */
	private RuntimeEnvironment currentRuntimeEnvironment;

	/**
	 * Stores the task for which this tasks waits.
	 */
	private QvtSemanticTask waitingForTask;

	/**
	 * Stores the execution state in order to resume the execution at this state when it was suspended.
	 */
	private int instructionPointer = 0;

	/**
	 * Determines whether this task is called by a "where" clause or is originated from a top level relation (i.e. from {@link #relation}).
	 */
	private boolean shallBeExecuted = false;

	/**
	 * Determines whether this task is succuessfully executed.
	 */
	private boolean executed = false;

	/**
	 * Determines whether this task has failed.
	 */
	private boolean failed = false;

	private QvtSemanticTaskDebugInfo qvtSemanticTaskDebugInfo = new QvtSemanticTaskDebugInfo();

	/*
	 * A set of tasks which wait for this task. If null, no tasks wait for this task.
	 */
	private ArrayList waitingTasks = null;

	private RelationDomain initializeRelationDomain;

	private List initialTraceArguments;

	/**
	 * Instantiates a new task
	 * 
	 * @param relation
	 *            The relation of this task
	 * @param arguments
	 *            The source domain values, forming a key for this task
	 * @param targetModel
	 *            The target model
	 * @param qvtEvaluatorVisitorImpl
	 */
	public QvtSemanticTask(Relation relation, List arguments, TypedModel targetModel, QvtEvaluatorVisitorImpl qvtEvaluatorVisitorImpl) {
		this.relation = relation;
		this.qvtEvaluatorVisitorImpl = qvtEvaluatorVisitorImpl;
		// TODO check if already available
		// TODO check collision !!
		this.trace = new Trace(relation, arguments);
		this.targetModel = targetModel;
	}

	public QvtProcessorImpl getQvtProcessor() {
		return this.qvtEvaluatorVisitorImpl.getQvtProcessor();
	}

	// TODO feauture !!! reqieres domain to be of type ?? !!!

	public boolean isFailed() {
		return this.failed;
	}

	/**
	 * Marks the task as failed or not failed
	 * 
	 * @param failed
	 */
	public void setFailed(boolean failed) {
		if (failed && this.executed) {
			throw new RuntimeException("Already executed task cannot be set to be failed");
		}
		if (this.failed != failed) {
			this.failed = failed;
			if (!failed) {
				this.qvtSemanticBindingIterator = null;
			}
			this.qvtEvaluatorVisitorImpl.getThreadPool().checkWaitingTasksForWork(this, !failed);
		}
	}

	public boolean isExecuted() {
		return this.executed;
	}

	/**
	 * If other tasks wait for this task and want to asked if this task is executed, they should not directly use {@link #isExecuted()} but this method
	 * 
	 * @return
	 */
	public boolean isExecutedForWaitingTasks() {
		return this.isExecuted() && (!QvtSemanticTask.requireExecutedTaskToCompleteForWaitingTasks || !this.hasWorkToDo());
	}

	public void setExecuted(boolean executed) {
		if (this.failed && executed) {
			throw new RuntimeException("Already failed task cannot be set to be executed: " + this.relation);
		}
		this.executed = executed;
		if (this.areTargetDomainValuesUndefined()) {
			throw new RuntimeException("areTargetDomainValuesUndefined()=true for executed tuple for relation " + this.relation.getName() + "!");
		}
	}

	public boolean isShallBeExecuted() {
		return this.shallBeExecuted;
	}

	public void setShallBeExecuted(boolean shallBeExecuted) {
		this.shallBeExecuted = shallBeExecuted;
	}

	/**
	 * Two tasks are equal if the traces are equal in target direction
	 */
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj != null) {
			if (obj instanceof QvtSemanticTask) {
				// return trace.equalsInDirection(((QvtSemanticTask) obj).trace, targetModel);
				return this.trace.equals(((QvtSemanticTask) obj).trace);
			}
			return false;
		}
		return false;
	}

	public int hashCode() {
		if (this.hashCode == 0) {
			this.hashCode = this.trace.hashCodeInDirection(this.targetModel);
		}
		return this.hashCode;
	}

	/**
	 * Executes a task by calculating all bindings if not calculated yet iterating over the bindings and executing/resuming them
	 */
	public synchronized void executeTask() {
		if (!this.hasWorkToDo()) {
			return;
		}
		this.setWaitingForTask(null);

		// TODO support for multiple target models !!
		if (this.qvtSemanticBindingIterator == null) {
			this.initializeSemanticBindingIterator();
		}

		// is old position ?
		while (this.currentRuntimeEnvironment != null || this.qvtSemanticBindingIterator.hasNext()) {

			if (this.currentRuntimeEnvironment == null) {
				this.initializeRuntimeEnvironment();
			}

			Map data = new HashMap();
			data.put(QvtEvaluatorImpl.QVT_EXECUTION_DIRECTION_PROPERTY_NAME, this.targetModel);
			Object executionResult = this.executeRelation(this.relation, data);

			if (executionResult instanceof QvtSemanticTask) {
				QvtSemanticTask taskToWaitFor = (QvtSemanticTask) executionResult;
				this.setWaitingForTask(taskToWaitFor);
				return;
			} else if (executionResult == OclBooleanImpl.TRUE) {
				if (!this.isExecuted()) {
					this.setExecuted(true);
				}
				this.qvtSemanticTaskDebugInfo.succussfullBindings++;
			} else if (executionResult == OclBooleanImpl.FALSE && !this.qvtSemanticBindingIterator.hasNext() && !this.isExecuted()) {
				this.setFailed(true);
				this.qvtSemanticTaskDebugInfo.unsuccussfullBindings++;
			}
			this.currentRuntimeEnvironment = null;
		}
	}

	private void initializeRuntimeEnvironment() {
		this.currentRuntimeEnvironment = (RuntimeEnvironment) this.qvtSemanticBindingIterator.next();
		this.instructionPointer = 0;
		List domains = this.relation.getDomain();
		for (Iterator iter = domains.iterator(), iterArgs = (this.getQvtProcessor().isParsingMode() ? this.initialTraceArguments : this.trace.getArguments()).iterator(); iter.hasNext();) {
			this.initializeRelationDomain = (RelationDomain) iter.next();
			Object relationDomainValue = iterArgs.next();
			if (this.getQvtProcessor().getDebugAdapter() != null) {
				if (Trace.isDefined((OclAny) relationDomainValue)) {
					this.getQvtProcessor().getDebugAdapter().doDebugWork();
				}
			}
			// If a trace domain value is undefined, it may be already set by an object template referring to the same variable declaration and already having a value assigned
			// by the binding iterator, so check for a defined value before assigning.
			if (Trace.isDefined((OclAny) relationDomainValue)) {
				Object oldValue = this.currentRuntimeEnvironment.getValue(this.initializeRelationDomain.getRootVariable().getName());
				if (Trace.isDefined((OclAny) oldValue) && !relationDomainValue.equals(oldValue)) {
					throw new RuntimeException("Domain variable " + this.initializeRelationDomain.getRootVariable().getName() + " of relation " + this.relation.getName()
					        + " cannot be assigned two different values. Ensure that arguments of relation calls to this relation pass only one value for this variable!");
				}
				this.currentRuntimeEnvironment.setValue(this.initializeRelationDomain.getRootVariable().getName(), relationDomainValue);
			}
		}
		this.initializeRelationDomain = null;
	}

	private void initializeSemanticBindingIterator() {

		if (this.getQvtProcessor().isParsingMode()) {
			this.initialTraceArguments = new ArrayList(this.trace.getArguments());
		}

		for (Iterator iter = this.relation.getDomain().iterator(), iterArgs = this.trace.getArguments().iterator(); iter.hasNext();) {
			RelationDomain relationDomain = (RelationDomain) iter.next();
			Object relationDomainValue = iterArgs.next();
			if (relationDomain.getPattern() != null) {
				if (!this.relation.isIsTopLevel() && QvtProcessorImpl.respectCheckOnlyFlag() && relationDomain.isIsCheckable()) {
					if (!(relationDomainValue instanceof OclAny) || Trace.isUndefined((OclAny) relationDomainValue)) {
						// mark a task as failed, if check-only domains are not assigned in non-toplevel relations
						this.setFailed(true);
						this.qvtSemanticBindingIterator = new ArrayList().iterator();
						return;
					}
				}
			}
		}

		Map data = new HashMap();

		if (!QvtSemanticTask.useOptimizedBindingIterator) {
			List variablesToIterate = this.qvtEvaluatorVisitorImpl.getQvtEvaluatorHelper().collectAllTemplateVariablesOfRelationExcludingRootVariableExcludingTargetDomain(this.relation,
			        this.targetModel, data);
			this.qvtSemanticBindingIterator = new QvtSemanticBindingIterator(variablesToIterate, this.qvtEvaluatorVisitorImpl.getQvtProcessor());
			return;
		}

		Map rootValues = new HashMap();

		for (Iterator iter = this.relation.getDomain().iterator(), iterArgs = this.trace.getArguments().iterator(); iter.hasNext();) {
			RelationDomain relationDomain = (RelationDomain) iter.next();
			Object relationDomainValue = iterArgs.next();
			if (relationDomain.getPattern() != null) {
				// case relationDomain is not a primitive domain
				rootValues.put(relationDomain.getPattern().getTemplateExpression(), relationDomainValue);
			}
		}

		List templatesToIterate = this.qvtEvaluatorVisitorImpl.getQvtEvaluatorHelper().collectAllNestedObjectTemplatesOfRelationExcludingTargetDomain(this.relation, this.targetModel, data);
		this.qvtSemanticBindingIterator = new QvtOptimizedSemanticBindingIterator(templatesToIterate, this.qvtEvaluatorVisitorImpl.getQvtProcessor(), rootValues);

		if (!this.qvtSemanticBindingIterator.hasNext()) {
			if (this.qvtSemanticTaskDebugInfo.failedClause == null) {
				if (this.qvtSemanticBindingIterator instanceof QvtOptimizedSemanticBindingIterator) {
					this.qvtSemanticTaskDebugInfo.failedClause = ((QvtOptimizedSemanticBindingIterator) this.qvtSemanticBindingIterator).getFailedClause();
				}
				if (this.qvtSemanticTaskDebugInfo.failedClause == null) {
					this.qvtSemanticTaskDebugInfo.failedClause = this.relation;
				}
			}
			this.setFailed(true);
		}
	}

	/**
	 * Determines whether {@link #executeTask()} should be called to proceed execution. Note that tasks in "when" modus are not allowed to return "true" here.
	 * 
	 * @return true if it is in "where" modus and if {@link #executeTask()} would change state
	 */
	public boolean hasWorkToDo() {

		if (!this.isShallBeExecuted()) {
			return false; // relation execution induced by a when-clause, so it is not required (and not allowed)
		}

		if (this.qvtSemanticBindingIterator == null) {
			return true; // executeRelation was never called yet
		}

		if (this.getWaitingForTask() != null) {

			if (this.getWaitingForTask().isExecutedForWaitingTasks()) {
				return true; // the waited-for task is executed, so we can proceed!
			}

			if (this.getWaitingForTask().isFailed()) {
				return true; // we can proceed - the waiting-for-task has failed
			}
			return false; // we still have to wait for the waiting-for-task
		}

		if (this.qvtSemanticBindingIterator.hasNext()) {
			return true; // there are still unprocessed bindings
		}
		return false;
	}

	/**
	 * Determines whether this task which already tackled work has now or at a later point of time still work to do.
	 * 
	 * Note that {@link #hasWorkToDo()} only covers the "now" point of time and not requires that work was already tackled. A further difference is that {@link #hasWorkToDo()}
	 * returns false if the task has to wait.
	 * 
	 * @return
	 */
	public boolean isComputing() {
		return this.currentRuntimeEnvironment != null;
	}

	/**
	 * Executes the task for the selected binding represented by {@link #currentRuntimeEnvironment}.
	 * 
	 * @param host
	 * @param data
	 * @return
	 */
	private Object executeRelation(Relation host, Object data) {
		this.qvtSemanticTaskDebugInfo.failedClause = null;

		// --- Unpack arguments ---
		((Map) data).put(QvtEvaluatorImpl.QVT_RUNTIME_ENVIRONMENT_PROPERTY_NAME, this.currentRuntimeEnvironment);
		((Map) data).put(QvtEvaluatorImpl.QVT_LOCAL_EXECUTION_MODE_PROPERTY_NAME, "when");

		boolean result = true;
		SemanticsVisitable[] orderedWhenClausesArray = this.getOrderedWhenClauseArrayForRelation(this.relation);

		boolean processedAllWhenClausesBefore = this.instructionPointer >= orderedWhenClausesArray.length;
		Object answerWhen = this.evaluateWhenClause((Map) data, orderedWhenClausesArray);

		if (answerWhen != null) {
			return answerWhen;
		}

		Collection variablesNotInstantiated = null;
		boolean processedAllWhenClauses = this.instructionPointer >= orderedWhenClausesArray.length;

		if (processedAllWhenClauses && !processedAllWhenClausesBefore || this.instructionPointer == 0 && orderedWhenClausesArray.length == 0) {
			this.createModelElements(host, (Map) data);
		}

		((Map) data).put(QvtEvaluatorImpl.QVT_LOCAL_EXECUTION_MODE_PROPERTY_NAME, "where");

		List orderedWhereClauses = this.getQvtProcessor().getWhereClausesFor(this.relation);

		Object answerWhere = this.evaluateWhereClause((Map) data, orderedWhenClausesArray, orderedWhereClauses, host);

		if (answerWhere != null) {
			return answerWhere;
		}

		boolean processedAllWhereClauses = this.instructionPointer >= orderedWhereClauses.size() + orderedWhenClausesArray.length;

		if (processedAllWhereClauses) {
			if (!this.tryRepopulate(host)) {
				throw new RuntimeException("Not all domain variables are bound though binding was succussful for relation " + host.getName() + "!");
			}
			this.trace.addBindingFrom(this.currentRuntimeEnvironment, this.qvtEvaluatorVisitorImpl.getQvtEvaluatorHelper(), data);
		}
		// --- result = literal's value ---
		return this.getQvtProcessor().getStdLibAdapter().Boolean(result);
	}

	public boolean hasProcessedAllClauses() {
		return !(this.instructionPointer < this.getQvtProcessor().getWhenClausesFor(this.relation).size() + this.getQvtProcessor().getWhereClausesFor(this.relation).size());
	}

	public SemanticsVisitable currentClause() {
		if (this.currentWhenClause() != null) {
			return this.currentWhenClause();
		}
		int whereInstructionPointer = this.instructionPointer - this.getQvtProcessor().getWhenClausesFor(this.relation).size();
		if (whereInstructionPointer < this.getQvtProcessor().getWhereClausesFor(this.relation).size()) {
			return (SemanticsVisitable) this.getQvtProcessor().getWhereClausesFor(this.relation).get(whereInstructionPointer);
		}
		return null;
	}

	public SemanticsVisitable currentWhenClause() {
		if (this.initializeRelationDomain != null) {
			return this.initializeRelationDomain;
		}
		if (this.instructionPointer < this.getQvtProcessor().getWhenClausesFor(this.relation).size()) {
			return (SemanticsVisitable) this.getQvtProcessor().getWhenClausesFor(this.relation).get(this.instructionPointer);
		}
		return null;
	}

	private SemanticsVisitable[] getOrderedWhenClauseArrayForRelation(Relation relation) {
		List orderedWhenClauses = this.getQvtProcessor().getWhenClausesFor(relation);
		return (SemanticsVisitable[]) orderedWhenClauses.toArray(new SemanticsVisitable[orderedWhenClauses.size()]);
	}

	private Object evaluateWhereClause(Map data, SemanticsVisitable[] orderedWhenClausesArray, List orderedWhereClauses, Relation host) {

		SemanticsVisitable[] orderedWhereClausesArray = (SemanticsVisitable[]) orderedWhereClauses.toArray(new SemanticsVisitable[orderedWhereClauses.size()]);

		for (; this.instructionPointer < orderedWhereClausesArray.length + orderedWhenClausesArray.length; this.instructionPointer++) {
			SemanticsVisitable semanticsVisitable = orderedWhereClausesArray[this.instructionPointer - orderedWhenClausesArray.length];
			this.qvtSemanticTaskDebugInfo.failedClause = semanticsVisitable; // save in case an exception terminates the transformation

			if (this.getQvtProcessor().getDebugAdapter() != null) {
				this.getQvtProcessor().getDebugAdapter().doDebugWork();
			}

			if (semanticsVisitable instanceof ObjectTemplateExp) {
				ObjectTemplateExp template = (ObjectTemplateExp) semanticsVisitable;
				Object answer = this.createOrBindObjectTemplate(template, host, data);
				if (answer != null) {
					return answer;
				}
			} else if (semanticsVisitable instanceof PropertyTemplateItem) {
				PropertyTemplateItem propertyTemplateItem = (PropertyTemplateItem) semanticsVisitable;
				Object answer = this.evaluateTargetDomainPropertyTemplate(propertyTemplateItem, data);
				if (answer != null) {
					return answer;
				}
			} else if (semanticsVisitable instanceof OclExpression) {
				OclExpression oclExpression = (OclExpression) semanticsVisitable;
				Object answer = this.evaluateWhereClauseOclExpression(oclExpression, data);
				if (answer != null) {
					return answer;
				}
			} else {
				throw new RuntimeException("unknown resolvable");
			}
		}

		return null;
	}

	/**
	 * Collects all tasks which could be executed by this task in where clauses
	 */
	public void lookAheadWhereRelationCalls(Collection result) {

		Map data = new HashMap();
		data.put(QvtEvaluatorImpl.QVT_EXECUTION_DIRECTION_PROPERTY_NAME, this.targetModel);
		data.put(QvtEvaluatorImpl.QVT_RUNTIME_ENVIRONMENT_PROPERTY_NAME, this.currentRuntimeEnvironment);
		data.put(QvtEvaluatorImpl.QVT_LOCAL_EXECUTION_MODE_PROPERTY_NAME, "when");

		SemanticsVisitable[] orderedWhenClausesArray = this.getOrderedWhenClauseArrayForRelation(this.relation);
		List orderedWhereClauses = this.getQvtProcessor().getWhereClausesFor(this.relation);

		SemanticsVisitable[] orderedWhereClausesArray = (SemanticsVisitable[]) orderedWhereClauses.toArray(new SemanticsVisitable[orderedWhereClauses.size()]);

		for (int instructionPointer = orderedWhenClausesArray.length; instructionPointer < orderedWhereClausesArray.length + orderedWhenClausesArray.length; instructionPointer++) {
			SemanticsVisitable semanticsVisitable = orderedWhereClausesArray[instructionPointer - orderedWhenClausesArray.length];

			if (semanticsVisitable instanceof ObjectTemplateExp) {
				// do nothing
			} else if (semanticsVisitable instanceof PropertyTemplateItem) {
				// do nothing
			} else if (semanticsVisitable instanceof OclExpression) {
				OclExpression oclExpression = (OclExpression) semanticsVisitable;
				if (oclExpression instanceof RelationCallExp) {
					RelationCallExp relationCall = (RelationCallExp) oclExpression;
					// Object currentResult = oclExpression.accept(this.qvtEvaluatorVisitorImpl, data);
					Object r = this.qvtEvaluatorVisitorImpl.buildTask(relationCall, data, this.targetModel);
					if (r instanceof QvtSemanticTask) {
						result.add(r);
					}
				}
			}
		}
	}

	private Object evaluateWhenClause(Map data, SemanticsVisitable[] orderedWhenClausesArray) {

		for (; this.instructionPointer < orderedWhenClausesArray.length; this.instructionPointer++) {
			SemanticsVisitable semanticsVisitable = orderedWhenClausesArray[this.instructionPointer];
			this.qvtSemanticTaskDebugInfo.failedClause = semanticsVisitable; // save in case an exception terminates the transformation

			if (this.getQvtProcessor().getDebugAdapter() != null) {
				this.getQvtProcessor().getDebugAdapter().doDebugWork();
			}

			if (semanticsVisitable instanceof PropertyTemplateItem) {
				PropertyTemplateItem propertyTemplateItem = (PropertyTemplateItem) semanticsVisitable;
				Object answer = this.evaluateSourceDomainPropertyTemplate(propertyTemplateItem, data);

				if (this.getQvtProcessor().getStdLibAdapter().Boolean(false).equals(answer)) {
					return answer;
				}
			} else if (semanticsVisitable instanceof OclExpression) {
				OclExpression oclExpression = (OclExpression) semanticsVisitable;
				Object answer = this.evaluateWhenClauseOclExpression(oclExpression, data);

				if (answer != null) {
					return answer;
				}
			} else {
				throw new RuntimeException("Not supported yet!");
			}
		}

		return null;

	}

	private Object evaluateWhereClauseOclExpression(OclExpression oclExpression, Map data) {
		boolean hadBeenVarAssignment = false;

		if (oclExpression instanceof OperationCallExp) {
			OperationCallExp operationCallExp = (OperationCallExp) oclExpression;

			if (operationCallExp.getReferredOperation().getName().equals("=") && operationCallExp.getSource() instanceof VariableExp) {
				VariableExp sourceVariableExp = (VariableExp) operationCallExp.getSource();
				VariableDeclaration sourceVariableDeclaration = sourceVariableExp.getReferredVariable();

				if (Trace.isUndefined((OclAny) this.currentRuntimeEnvironment.getValue(sourceVariableDeclaration.getName()))) {
					hadBeenVarAssignment = true;
					OclAny varValue = (OclAny) ((OclExpression) operationCallExp.getArguments().get(0)).accept(this.qvtEvaluatorVisitorImpl, data);
					this.currentRuntimeEnvironment.setValue(sourceVariableDeclaration.getName(), varValue);
				}
			}
		}

		if (hadBeenVarAssignment) {
			return null;
		}

		// check variable binding through relationcallexp !!!
		this.currentRuntimeEnvironment.setValue("SemTask", null);
		Object currentResult = oclExpression.accept(this.qvtEvaluatorVisitorImpl, data);
		QvtSemanticTask taskToWaitFor = (QvtSemanticTask) this.currentRuntimeEnvironment.getValue("SemTask");
		this.currentRuntimeEnvironment.setValue("SemTask", null);

		if (!(currentResult instanceof OclAny)) {
			throw new RuntimeException("Unexpected Object " + currentResult);
		}

		OclAny oclExpressionResult = (OclAny) currentResult;

		if (oclExpressionResult instanceof OclUndefined) {
			if (taskToWaitFor != null) {
				return taskToWaitFor;
			}
			throw new RuntimeException("The OCL expression at " + this.getQvtProcessor().getAnalyser().getMessage("", oclExpression)
			        + " evaluated to an undefined value! Rewrite this OCL expression to only return True or False!");
		}

		if (oclExpressionResult instanceof OclBoolean) {
			if (OclBooleanImpl.FALSE.equals(oclExpressionResult)) {
				this.qvtSemanticTaskDebugInfo.failedClause = oclExpression;
				if (this.getQvtProcessor().requireAssertWhereClause(oclExpression)) {
					throw new RuntimeException("The OCL expression at " + this.getQvtProcessor().getAnalyser().getMessage("", oclExpression)
					        + " evaluated to false! This is not allowed for where-clauses! Rewrite this OCL expression to only return True!"
					        + (this.getQvtProcessor().isBindingClause(oclExpression) ? " Note that since this clause binds variables, it is required to evaluate to true." : ""));
				}
				// return getQvtProcessor().getStdLibAdapter().Boolean(false);
				return null;
			}
		} else {
			throw new RuntimeException("Unexpected Object " + oclExpressionResult);
		}

		return null;
	}

	private Object evaluateTargetDomainPropertyTemplate(PropertyTemplateItem propertyTemplateItem, Map data) {
		OclExpression valueExp = propertyTemplateItem.getValue();
		VariableDeclaration targetVariable = propertyTemplateItem.getObjContainer().getBindsTo();

		Object targetValue = this.currentRuntimeEnvironment.getValue(targetVariable.getName());
		Property prop = propertyTemplateItem.getReferredProperty();
		OclAny oclValue = (OclAny) valueExp.accept(this.qvtEvaluatorVisitorImpl, data);

		if (this.overwriteTargetValue((OclAnyModelElement) targetValue)) {

			boolean matched;
			Object oldValue = this.getQvtProcessor().getModelEvaluationAdapter().getValueForFeauture(((OclAnyModelElement) targetValue).asJavaObject(), prop);
			if (oldValue instanceof Collection && !(oclValue.asJavaObject() instanceof Collection)) {
				matched = ((Collection) oldValue).contains(oclValue.asJavaObject());
			} else {
				matched = oldValue == oclValue.asJavaObject() || oldValue != null && oldValue.equals(oclValue.asJavaObject());
			}
			if (!matched) {
				if (this.getQvtProcessor().isParsingMode()) {
					return OclBooleanImpl.FALSE;
				}
				this.getQvtProcessor().getQvtModelManipulationAdaper().setOrAddValueForFeauture((OclAnyModelElement) targetValue, prop, oclValue);
				if (this.getQvtProcessor().logTasks()) {
					QvtSemanticAnalyserThreadPool.getLogger().print("(Set feature " + prop.getName() + ")");
				}
				QvtSemanticTaskDebugInfo.setOrAddValueForFeautureCount++;
			}
		}
		return null;
	}

	private void createModelElements(Relation host, Map data) {

		synchronized (this.qvtEvaluatorVisitorImpl.getTraces()) {

			if (!this.getQvtProcessor().isRandomMode() && !this.getQvtProcessor().isParsingMode()) {
				// search old binding over trace !!
				Trace.bindVariablesByTrace(this.qvtEvaluatorVisitorImpl.getOldTraces(), host, this.currentRuntimeEnvironment, this.targetModel, this.qvtEvaluatorVisitorImpl.getQvtEvaluatorHelper(),
				        this.getQvtProcessor(), data);
			}
		}
	}

	/**
	 * Repopulates the trace's domain values, if they are all defined
	 * 
	 * @param host
	 * @return true iff population was successful
	 */
	private boolean tryRepopulate(Relation host) {
		List argValues = new ArrayList();
		for (Iterator iter = host.getDomain().iterator(); iter.hasNext();) {
			RelationDomain currentRelationDomain = (RelationDomain) iter.next();
			VariableDeclaration currentVar = currentRelationDomain.getRootVariable();
			OclAny varValue = (OclAny) this.currentRuntimeEnvironment.getValue(currentVar.getName());
			if (Trace.isUndefined(varValue)) {
				return false;
			}
			argValues.add(this.currentRuntimeEnvironment.getValue(currentRelationDomain.getRootVariable().getName()));
		}
		this.trace.repopulateArguments(argValues);
		this.qvtEvaluatorVisitorImpl.addTrace(this.trace);
		return true;
	}

	private Object createOrBindObjectTemplate(ObjectTemplateExp template, Relation host, Map data) {

		VariableDeclaration currentTargetVar = template.getBindsTo();
		OclAny varValue = (OclAny) this.currentRuntimeEnvironment.getValue(currentTargetVar.getName());

		if (Trace.isUndefined(varValue)) {

			varValue = this.findByKey(template, data, false);
			if (Trace.isUndefined(varValue)) {

				if (this.getQvtProcessor().isParsingMode()) {
					return OclBooleanImpl.FALSE;
				}

				varValue = this.getQvtProcessor().getQvtModelManipulationAdaper().createOclAnyModelElement((OclModelElementType) currentTargetVar.getType(), this.targetModel);

				if (this.getQvtProcessor().logTasks()) {
					QvtSemanticAnalyserThreadPool.getLogger().print("(Created instance of class " + currentTargetVar.getType().getName() + ")");
				}
				QvtSemanticTaskDebugInfo.createOclAnyModelElementCount++;

				if (this.getQvtProcessor().isPropertySet(QVTProcessorConsts.PROP_INPLACE_IN_ONE_TRANSFORMATION)) {
					// .. should trigger top level relations again
				}
			}
			this.currentRuntimeEnvironment.setValue(currentTargetVar.getName(), varValue);
			this.tryRepopulate(host);
		} else if (this.getQvtProcessor().logTasks()) {
			OclAny varValueBykey = this.findByKey(template, data, true);
			if (Trace.isDefined(varValueBykey)) {
				if (!varValueBykey.equals(varValue)) {
					QvtSemanticAnalyserThreadPool.getLogger().print(
					        "(WARNING: Trace-bound value differs from key-bound value for variable " + currentTargetVar.getName() + " of relation " + host.getName() + ")");
				}
			}
		}
		return null;
	}

	/**
	 * Looks for a model element which matches object template <code>template</code> restricted on the properties defined by some suitable key
	 * 
	 * @param template
	 * @param data
	 * @param forLogging
	 *            if true, this method is not called to actually bind variables
	 * @return a matching element or null otherwise
	 */
	private OclAny findByKey(ObjectTemplateExp template, Map data, boolean forLogging) {
		List suitableKeys = QVTDirectedValidation.findSuitableKeys(template, this.getQvtProcessor());
		for (Iterator iter = suitableKeys.iterator(); iter.hasNext();) {
			QVTSuitableKey suitableKey = (QVTSuitableKey) iter.next();
			Key key = suitableKey.getKey();
			Collection candidates;
			if (suitableKey.getUseOppositeProperty()) {
				PropertyTemplateItem propertyTemplateItem = (PropertyTemplateItem) template.eContainer();
				VariableDeclaration parentVar = propertyTemplateItem.getObjContainer().getBindsTo();
				OclAny sourceValue = (OclAny) this.currentRuntimeEnvironment.getValue(parentVar.getName());
				candidates = QVTDirectedValidation.getValueList(sourceValue, propertyTemplateItem.getReferredProperty(), this.getQvtProcessor());
			} else {
				OclSet currentAllInstances = this.getQvtProcessor().getModelEvaluationAdapter().OclType_allInstances(this.getQvtProcessor().getStdLibAdapter().Type(template.getType()),
				        this.getQvtProcessor().getModelsForDirection(this.relation.getTransformation(), this.targetModel));
				candidates = (Collection) currentAllInstances.getImplementation();
			}

			VariableDeclaration currentTargetVar = template.getBindsTo();
			List matchedCandidates = new ArrayList();
			for (Iterator iterator = candidates.iterator(); iterator.hasNext();) {

				OclAny candidate = this.assureOclAny(iterator.next());
				OclAny oldValue = (OclAny) this.currentRuntimeEnvironment.getValue(currentTargetVar.getName());
				this.currentRuntimeEnvironment.setValue(currentTargetVar.getName(), candidate);
				try {
					if (this.matchCandidate(candidate, key, template, data)) {
						matchedCandidates.add(candidate);
					}
				} finally {
					this.currentRuntimeEnvironment.setValue(currentTargetVar.getName(), oldValue);
				}
				if (!this.getQvtProcessor().logTasks() && !matchedCandidates.isEmpty()) {
					break;
				}
			}
			if (!matchedCandidates.isEmpty()) {
				if (this.getQvtProcessor().logTasks()) {
					QvtSemanticAnalyserThreadPool.getLogger().print(
					        "(" + (forLogging ? "Would be able to bind" : "Bound") + " instance of class " + key.getIdentifies().getName() + " for variable " + currentTargetVar.getName()
					                + " by key for type " + key.getIdentifies().getName() + ")");
					if (matchedCandidates.size() >= 2) {
						QvtSemanticAnalyserThreadPool.getLogger().print("(WARNING: Last key found " + matchedCandidates.size() + " matching instances!)");
					}
				}
				return (OclAny) matchedCandidates.get(0);
			}
		}
		return null;
	}

	/**
	 * Checks whether element <code>candidate</code> equals in the property values given by key <code>key</code> with the values calculated for <code>template</code>
	 * 
	 * @param candidate
	 * @param key
	 * @param template
	 * @param data
	 * @return
	 */
	private boolean matchCandidate(OclAny candidate, Key key, ObjectTemplateExp template, Map data) {
		for (Iterator iterator2 = key.getPart().iterator(); iterator2.hasNext();) {
			Property prop = (Property) iterator2.next();
			PropertyTemplateItem propertyTemplateItem = QVTDirectedValidation.getPropertyTemplateItemFor(template, prop);
			if (propertyTemplateItem != null && !this.matchPropertyTemplateItem(propertyTemplateItem, candidate, false, data)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Returns a {@link OclAny} instance from <code>candidate</code>
	 * 
	 * @param candidate
	 * @return
	 */
	private OclAny assureOclAny(Object candidate) {
		if (candidate instanceof OclAny) {
			return (OclAny) candidate;
		} else {
			return this.getQvtProcessor().getStdLibAdapter().OclAny(candidate);
		}
	}

	private Object evaluateWhenClauseOclExpression(OclExpression oclExpression, Map data) {
		boolean hadBeenVarAssignment = false;

		if (oclExpression instanceof OperationCallExp) {
			OperationCallExp operationCallExp = (OperationCallExp) oclExpression;
			if (operationCallExp.getReferredOperation().getName().equals("=") && operationCallExp.getSource() instanceof VariableExp) {
				VariableExp sourceVariableExp = (VariableExp) operationCallExp.getSource();
				VariableDeclaration sourceVariableDeclaration = sourceVariableExp.getReferredVariable();
				if (Trace.isUndefined((OclAny) this.currentRuntimeEnvironment.getValue(sourceVariableDeclaration.getName()))) {
					hadBeenVarAssignment = true;
					oclExpression = (OclExpression) operationCallExp.getArguments().get(0);
					OclAny varValue = (OclAny) oclExpression.accept(this.qvtEvaluatorVisitorImpl, data);
					this.currentRuntimeEnvironment.setValue(sourceVariableDeclaration.getName(), varValue);
				}
			}
		}

		this.currentRuntimeEnvironment.setValue("SemTask", null);
		Object currentResult = oclExpression.accept(this.qvtEvaluatorVisitorImpl, data);
		QvtSemanticTask taskToWaitFor = (QvtSemanticTask) this.currentRuntimeEnvironment.getValue("SemTask");
		this.currentRuntimeEnvironment.setValue("SemTask", null);

		if (!(currentResult instanceof OclAny)) {
			throw new RuntimeException("Unexpected Object " + currentResult);
		}

		OclAny oclExpressionResult = (OclAny) currentResult;

		if (oclExpressionResult instanceof OclUndefined) {
			if (taskToWaitFor != null) {
				return taskToWaitFor;
			}
			if (!hadBeenVarAssignment) {
				throw new RuntimeException("The OCL expression  at " + this.getQvtProcessor().getAnalyser().getMessage("", oclExpression)
				        + " evaluated to an undefined value! Rewrite this OCL expression to only return True or False!");
			}

		}

		if (!hadBeenVarAssignment) {
			if (oclExpressionResult instanceof OclBoolean) {
				if (OclBooleanImpl.FALSE.equals(oclExpressionResult)) {
					this.qvtSemanticTaskDebugInfo.failedClause = oclExpression;
					return this.getQvtProcessor().getStdLibAdapter().Boolean(false);
				}
			} else {
				throw new RuntimeException("Unexpected Object " + oclExpressionResult);
			}
		}

		return null;
	}

	private Object evaluateSourceDomainPropertyTemplate(PropertyTemplateItem propertyTemplateItem, Map data) {
		VariableDeclaration sourceVariable = propertyTemplateItem.getObjContainer().getBindsTo();

		Object sourceValue = this.currentRuntimeEnvironment.getValue(sourceVariable.getName());

		if (!this.matchPropertyTemplateItem(propertyTemplateItem, sourceValue, true, data)) {
			return this.getQvtProcessor().getStdLibAdapter().Boolean(false);
		} else {
			return null;
		}

	}

	static public OclAny getPropertyValueOf(Property prop, Object sourceValue, QvtProcessorImpl processor) {
		if (sourceValue instanceof OclAnyModelElement) {
			sourceValue = ((OclAnyModelElement) sourceValue).asJavaObject();
		}

		Object javaValue = processor.getModelEvaluationAdapter().getValueForFeauture(sourceValue, prop);
		OclAny oclValue = null;

		if (prop.getType() instanceof CollectionType) {
			if (prop.getType() instanceof OrderedSetType) {
				oclValue = processor.getStdLibAdapter().OrderedSet(((OrderedSetType) prop.getType()).getElementType(), javaValue);
			} else if (prop.getType() instanceof SetType) {
				oclValue = processor.getStdLibAdapter().Set(((SetType) prop.getType()).getElementType(), javaValue);
			} else if (prop.getType() instanceof BagType) {
				oclValue = processor.getStdLibAdapter().Bag(((BagType) prop.getType()).getElementType(), javaValue);
			} else if (prop.getType() instanceof SequenceType) {
				oclValue = processor.getStdLibAdapter().Sequence(((SequenceType) prop.getType()).getElementType(), javaValue);
			} else {
				// TODO TODOMWA this schould never happend ... dirty
				oclValue = processor.getStdLibAdapter().Sequence(((CollectionType) prop.getType()).getElementType(), javaValue);
			}
		} else if (javaValue instanceof Collection) {
			// TODO TODOMWA remove this ... this case should never occur
			oclValue = processor.getStdLibAdapter().Collection((Collection) javaValue);
		} else if (prop != null && prop.getType() instanceof Enumeration) {
			oclValue = processor.getStdLibAdapter().Enumeration(prop.getType(), javaValue);
		} else {
			oclValue = processor.getStdLibAdapter().OclAny(javaValue);
		}

		return oclValue;

	}

	/**
	 * Tries to match the property template item <code>propertyTemplateItem</code> for the model element <code>sourceValue</code>.
	 * 
	 * @param propertyTemplateItem
	 * @param sourceValue
	 * @param allowBind
	 *            if true, assignments are allowed in order to match
	 * @param data
	 * @return
	 */
	private boolean matchPropertyTemplateItem(PropertyTemplateItem propertyTemplateItem, Object sourceValue, boolean allowBind, Map data) {

		// TODO check how to dreive property !!
		Property prop = propertyTemplateItem.getReferredProperty();

		OclAny oclValue = QvtSemanticTask.getPropertyValueOf(prop, sourceValue, this.getQvtProcessor());

		boolean varDef = false;
		OclExpression valueExp = propertyTemplateItem.getValue();

		if (allowBind && valueExp instanceof VariableExp) {
			VariableExp variablevalueExp = (VariableExp) valueExp;
			Object varValue = this.currentRuntimeEnvironment.getValue(variablevalueExp.getReferredVariable().getName());
			if (Trace.isUndefined((OclAny) varValue)) {
				varDef = true;
				this.currentRuntimeEnvironment.setValue(variablevalueExp.getReferredVariable().getName(), oclValue);
			}
		}

		if (!varDef) {
			OclAny expectedValue = (OclAny) valueExp.accept(this.qvtEvaluatorVisitorImpl, data);
			if (allowBind && QVTDirectedValidation.enableInverseConcat && expectedValue instanceof OclUndefined && this.canBindConcatVars(oclValue, propertyTemplateItem.getValue())) {
				// matching successful
				expectedValue = (OclAny) valueExp.accept(this.qvtEvaluatorVisitorImpl, data);
				if (!expectedValue.equals(oclValue)) {
					// algorithm canBindConcatVars must be erroneous
					throw new RuntimeException("Error occured when matching string " + oclValue.toString());
				}
			}
			if (prop.getType() instanceof CollectionType) {
				if (!(((OclCollection) oclValue).includes(expectedValue) == OclBooleanImpl.TRUE)) {
					this.qvtSemanticTaskDebugInfo.failedClause = propertyTemplateItem;
					return false;
				}

			} else {
				if (!expectedValue.equals(oclValue)) {
					this.qvtSemanticTaskDebugInfo.failedClause = propertyTemplateItem;
					return false;
				}
			}
		}

		return true;
	}

	/**
	 * Determines whether <code>oclValue</code> is a <code>String</code> value, which can be matched up by a concatenation of strings and constants expected in
	 * <code>pattern</code>.
	 * 
	 * @param oclValue
	 *            A computed OCL value
	 * @param pattern
	 *            The pattern to match the OCL value against
	 * @return
	 */
	private boolean canBindConcatVars(OclAny oclValue, OclExpression pattern) {
		List matchParts = new ArrayList();
		if (!(oclValue.asJavaObject() instanceof String) || !QVTDirectedValidation.hasStringMatching(matchParts, pattern, this.getQvtProcessor())) {
			return false;
		}

		String toMatch = (String) oclValue.asJavaObject();
		int fromIndex = 0;
		for (Iterator iter = matchParts.iterator(); iter.hasNext();) {
			Object matchPart = iter.next();
			if (matchPart instanceof VariableDeclaration && Trace.isUndefined((OclAny) this.currentRuntimeEnvironment.getValue(((VariableDeclaration) matchPart).getName()))) {
				VariableDeclaration var = (VariableDeclaration) matchPart;
				int beginIndex = fromIndex;
				int endIndex;
				if (iter.hasNext()) {
					StringLiteralExp s = (StringLiteralExp) iter.next();
					String str = s.getStringSymbol();
					if (iter.hasNext()) {
						endIndex = toMatch.indexOf(str, fromIndex);
					} else {
						// endIndex=toMatch.lastIndexOf(str,fromIndex); <- not works!!!! e.g. evaluate
						// "useCase1Activity".lastIndexOf("Activity",0)
						endIndex = toMatch.substring(fromIndex).lastIndexOf(str);
						if (endIndex != -1) {
							endIndex += fromIndex;
						}
					}
					if (endIndex == -1) {
						return false;
					}
					fromIndex = endIndex + str.length();

				} else {
					endIndex = toMatch.length();
					fromIndex = endIndex;
				}
				String javaValue = toMatch.substring(beginIndex, endIndex);
				this.currentRuntimeEnvironment.setValue(var.getName(), this.getQvtProcessor().getStdLibAdapter().OclAny(javaValue));
			} else {
				String str;
				if (matchPart instanceof VariableDeclaration) {
					Object varValue = this.currentRuntimeEnvironment.getValue(((VariableDeclaration) matchPart).getName());
					if (varValue instanceof OclString) {
						str = (String) ((OclString) varValue).asJavaObject();
					} else {
						return false;
					}
				} else {
					str = ((StringLiteralExp) matchPart).getStringSymbol();
				}
				if (!toMatch.substring(fromIndex).startsWith(str)) {
					return false;
				}
				fromIndex += str.length();
			}
		}
		if (fromIndex < toMatch.length()) {
			return false;
		}
		return true;
	}

	public void run() {
		this.executeTask();
	}

	public QvtSemanticTask getWaitingForTask() {
		return this.waitingForTask;
	}

	public void setWaitingForTask(QvtSemanticTask waitingForTask) {
		if (this.waitingForTask != waitingForTask) {
			if (this.waitingForTask != null) {
				this.waitingForTask.waitingTasks.remove(this);
			}
			this.waitingForTask = waitingForTask;
			if (this.waitingForTask != null) {
				if (this.waitingForTask.waitingTasks == null) {
					this.waitingForTask.waitingTasks = new ArrayList();
				}
				this.waitingForTask.waitingTasks.add(this);
			}
		}
	}

	public Relation getRelation() {
		return this.relation;
	}

	public Trace getTrace() {
		return this.trace;
	}

	/**
	 * Determines whether the given <code>target</code> model element should be overridden.<br>
	 * TODO replace this with an override strategy which can be plugged into the engine.
	 * 
	 * @param target
	 *            the model element to override.
	 * @return <code>true</code> if the engine has been configured not to run in strict mode and the model has been modified since the last transformation. <code>false</code>
	 *         otherwise.
	 */
	private boolean overwriteTargetValue(OclAnyModelElement target) {
		return true;
		// String strictSynchronization = getQvtProcessor().getProperty(QVTProcessorConsts.PROP_STRICT_SYCHRONIZATION);
		// if (strictSynchronization == null ||
		// strictSynchronization.equals(QVTProcessorConsts.PROP_STRICT_SYCHRONIZATION_ON_VALUE)) {
		// return true;
		// }
		//
		// Collection oldTraces = qvtEvaluatorVisitorImpl.getOldTraces();
		// Trace oldTrace = Trace.findTrace(oldTraces, relation, trace.getArguments(), targetModel);
		//
		// // if old trace does not exist, return true
		// if (oldTrace == null) {
		// return true;
		// }
		// return getQvtProcessor().getQvtModelManipulationAdaper().isModified(target, oldTrace);
	}

	public boolean equalsOnSourceDomains(QvtSemanticTask qvtSemanticTask) {
		return this.trace.equalsOnSourceDomains(qvtSemanticTask.trace, this.targetModel);
	}

	public boolean areTargetDomainValuesUndefined() {
		return this.trace.areDomainValuesUndefinedInDirection(this.targetModel);
	}

	public QvtSemanticTaskDebugInfo getDebugInfo() {
		return this.qvtSemanticTaskDebugInfo;
	}

	public boolean hasWaitingTasks() {
		return this.waitingTasks != null && this.waitingTasks.size() >= 1;
	}

	public Iterator getWaitingTasksIterator() {
		return this.waitingTasks == null ? new ArrayList().iterator() : this.waitingTasks.iterator();
	}

	public List getWaitingTasks() {
		return this.waitingTasks == null ? new ArrayList() : this.waitingTasks;
	}

	public TypedModel getTargetModel() {
		return this.targetModel;
	}

	/**
	 * Retrieves the value of the variable named <code>name</code> referring to binding number <code>bindingNumber</code> of the task
	 * 
	 * @param bindingNumber
	 * @param name
	 * @return
	 */
	public OclAny getValueFor(int bindingNumber, String name) {
		if (bindingNumber < this.trace.getBindings().size()) {
			Map binding = (Map) this.trace.getBindings().get(bindingNumber);
			return (OclAny) binding.get(name);
		} else {
			return (OclAny) this.currentRuntimeEnvironment.getValue(name);
		}
	}

	/**
	 * Sets the value of the variable named <code>name</code> referring to binding number <code>bindingNumber</code> of the task. Currently it is not implemented to change
	 * already finished bindings
	 * 
	 * @param bindingNumber
	 * @param name
	 * @param value
	 */
	public void setValueFor(int bindingNumber, String name, OclAny value) {
		if (bindingNumber < this.trace.getBindings().size()) {
			// TODO: KIE
			// Map binding = (Map) trace.getBindings().get(bindingNumber);
			// return (OclAny) binding.get(name);
		} else {
			this.currentRuntimeEnvironment.setValue(name, value);
		}
	}

	/**
	 * The current source line this task is suspended at
	 * 
	 * @return the line or -1 if this task is not suspended at a clause
	 */
	public int currentLine() {
		if (this.currentClause() != null) {
			return this.getQvtProcessor().getAnalyser().getBeginLine(this.currentClause());
		}
		return -1;
	}

	/**
	 * The task which called the current task first by a relation call
	 * 
	 * @return
	 */
	public QvtSemanticTask getCallerTask() {
		for (Iterator it = this.getWaitingTasksIterator(); it.hasNext();) {
			QvtSemanticTask waitingTask = (QvtSemanticTask) it.next();
			return waitingTask;
		}
		return null;
	}

	/**
	 * See {@link QvtSemanticAnalyserThreadPool#bringToFront(QvtSemanticTask)}
	 * 
	 */
	public void bringToFront() {
		this.qvtEvaluatorVisitorImpl.getThreadPool().bringToFront(this);
	}

	public QVTDebugPosition currentDebugPosition() {
		return new QVTDebugPosition(this, this.getCurrentBindingNumber(), this.currentSourcePosition());
	}

	public QVTSourcePosition currentSourcePosition() {
		return new QVTSourcePosition(this.getQvtProcessor().getTransformationPath(this.getTransformation()), this.currentLine());
	}

	private Transformation getTransformation() {
		return this.relation.getTransformation();
	}

	public int getCurrentBindingNumber() {
		return this.getTrace().getBindings().size();
	}

	public List getArguments() {
		return this.trace.getArguments();
	}

}
