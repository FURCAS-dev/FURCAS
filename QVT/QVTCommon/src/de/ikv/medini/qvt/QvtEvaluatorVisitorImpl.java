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

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.oslo.ocl20.semantics.bridge.Classifier;
import org.oslo.ocl20.semantics.bridge.Property;
import org.oslo.ocl20.semantics.bridge.Tag;
import org.oslo.ocl20.semantics.model.contexts.Constraint;
import org.oslo.ocl20.semantics.model.expressions.OclExpression;
import org.oslo.ocl20.semantics.model.expressions.OperationCallExp;
import org.oslo.ocl20.semantics.model.expressions.VariableDeclaration;
import org.oslo.ocl20.semantics.model.expressions.VariableExp;
import org.oslo.ocl20.standard.lib.OclAny;
import org.oslo.ocl20.standard.lib.OclAnyModelElement;
import org.oslo.ocl20.standard.lib.OclBooleanImpl;
import org.oslo.ocl20.standard.lib.OclIntegerImpl;
import org.oslo.ocl20.standard.lib.OclSet;
import org.oslo.ocl20.standard.lib.OclUndefined;
import org.oslo.ocl20.standard.lib.OclUndefinedImpl;
import org.oslo.ocl20.synthesis.OclEvaluatorVisitorImpl;
import org.oslo.ocl20.synthesis.RuntimeEnvironment;
import org.oslo.ocl20.synthesis.RuntimeEnvironmentImpl;

import de.ikv.medini.qvt.execution.QvtSemanticAnalyserThreadPool;
import de.ikv.medini.qvt.execution.QvtSemanticTask;
import de.ikv.medini.qvt.model.qvtbase.Domain;
import de.ikv.medini.qvt.model.qvtbase.Function;
import de.ikv.medini.qvt.model.qvtbase.FunctionParameter;
import de.ikv.medini.qvt.model.qvtbase.Pattern;
import de.ikv.medini.qvt.model.qvtbase.Predicate;
import de.ikv.medini.qvt.model.qvtbase.Rule;
import de.ikv.medini.qvt.model.qvtbase.TypedModel;
import de.ikv.medini.qvt.model.qvtrelation.DomainPattern;
import de.ikv.medini.qvt.model.qvtrelation.Key;
import de.ikv.medini.qvt.model.qvtrelation.Relation;
import de.ikv.medini.qvt.model.qvtrelation.RelationCallExp;
import de.ikv.medini.qvt.model.qvtrelation.RelationDomain;
import de.ikv.medini.qvt.model.qvtrelation.RelationImplementation;
import de.ikv.medini.qvt.model.qvtrelation.RelationalTransformation;
import de.ikv.medini.qvt.model.qvttemplate.ObjectTemplateExp;
import de.ikv.medini.qvt.model.qvttemplate.PropertyTemplateItem;
import de.ikv.medini.qvt.qvt.QvtVisitor;

/**
 * The QVT evaluator visitor is used by the {@link QvtEvaluatorImpl} to traverse the transformation AST and evaluate ist expressions.
 * 
 * @author Michael Wagner
 * @author Omar Ekine
 * @author Joerg Kiegeland
 * 
 */
public class QvtEvaluatorVisitorImpl extends OclEvaluatorVisitorImpl implements QvtVisitor {

	/*
	 * Flag indicating whether on where-relation-calls should be waited-for (if disabled, old engine behavior is simulated)
	 */
	static private boolean enableExtendedWhereClauseEvaluation = true;

	private QVTEvaluatorHelper qvtEvaluatorHelper;

	private List relationBindingItemList = new ArrayList();

	private Set traces = new HashSet();

	private List tracesOrdered;

	private Collection oldTraces = new HashSet();

	private QvtSemanticAnalyserThreadPool qvtSemanticAnalyserThreadPool;

	/**
	 * Creates a QVT evaluator visitor with the given <code>qvtProcessor</code>.
	 * 
	 * @param qvtProcessor
	 *            the QVT processor.
	 */
	public QvtEvaluatorVisitorImpl(QvtProcessorImpl qvtProcessor) {
		super(qvtProcessor);
		this.qvtEvaluatorHelper = new QVTEvaluatorHelper(this);
	}

	/**
	 * Executes the transformation <code>host</code> using the context <code>data</code>.
	 * 
	 * @param host
	 *            the transformation to execute.
	 * @param data
	 *            the {@link Map} describing the execution context.
	 * @return a {@link Collection} of {@link Trace}s
	 */
	public Object visit(RelationalTransformation host, Object data) {
		// --- Unpack arguments ---
		this.qvtSemanticAnalyserThreadPool = new QvtSemanticAnalyserThreadPool(this.getQvtProcessor(), 0, host, data);
		TypedModel targetModel = (TypedModel) ((Map) data).get(QvtEvaluatorImpl.QVT_EXECUTION_DIRECTION_PROPERTY_NAME);
		this.traces = new HashSet();
		this.tracesOrdered = new ArrayList();
		this.oldTraces = (Collection) ((Map) data).get(QvtEvaluatorImpl.QVT_RELATION_OLD_TRACES_SET_PROPERTY_NAME);

		// TODO setup keys

		// TODO setup Querys

		// process all toplevel relations !
		List rules = host.getRule();

		if (!this.getQvtProcessor().isRandomMode()) {
			for (Iterator iter = rules.iterator(); iter.hasNext();) {
				Rule rule = (Rule) iter.next();

				if (!(rule instanceof Relation)) {
					throw new RuntimeException("Internal error: All rules in a relational transformation must be relations");
				}

				Relation relation = (Relation) rule;
				// TODO set execute only top level ?
				if (relation.isIsTopLevel()) {
					int count = this.qvtSemanticAnalyserThreadPool.getTaskCount();
					this.executeToplevelRelation((Relation) rule, targetModel, data);
					if (this.getQvtProcessor().isDebugMode()) {
						int count2 = this.qvtSemanticAnalyserThreadPool.getTaskCount();
						QvtSemanticAnalyserThreadPool.getLogger().println("(Relation '" + relation.getName() + "' initially has " + (count2 - count) + " tuple(s) to evaluate)");
					}
				}
			}
		}
		// start the actual processing
		this.qvtSemanticAnalyserThreadPool.complete();
		if (this.getQvtProcessor().isRandomMode()) {
			// Add old traces to new traces to preserve traces of old random-mode transformations.
			for (Iterator iter = this.oldTraces.iterator(); iter.hasNext();) {
				Trace element = (Trace) iter.next();
				this.addTrace(element);
			}
		} else if (this.getQvtProcessor().isParsingMode()) {
			this.deleteMatchedElements(this.traces, targetModel, data);
			// Clear traces since they have no useful meaning and they contain many dangling references
			this.traces.clear();
			this.tracesOrdered.clear();
		} else {
			Trace.cleanupTraces(this.traces, this.oldTraces, targetModel, this.qvtEvaluatorHelper, this.getQvtProcessor(), data);
		}

		return this.tracesOrdered;
	}

	/**
	 * Delete matched-up structured in the source domains
	 * 
	 * @param traces
	 * @param targetModel
	 * @param data
	 */
	private void deleteMatchedElements(Set traces, TypedModel targetModel, Object data) {

		Map relationToRemovalCandidates = new HashMap();
		// Map relationToSourceVarDecls = new HashMap();

		Set elementsToDelete = new HashSet();

		/*
		 * First delete all matched-up references
		 */
		for (Iterator iter = traces.iterator(); iter.hasNext();) {
			Trace currentTrace = (Trace) iter.next();
			Relation currentTraceRelation = currentTrace.getRelation();

			List propertyTemplateItems = QVTDirectedValidation.collectAllPropertyTemplateItemsDependingOnDirection(currentTraceRelation, targetModel, false, data, this.getQvtProcessor());

			for (Iterator bindingsIter = currentTrace.getBindings().iterator(); bindingsIter.hasNext();) {
				Map currentBindings = (Map) bindingsIter.next();

				for (Iterator iterator = propertyTemplateItems.iterator(); iterator.hasNext();) {
					PropertyTemplateItem propertyTemplateItem = (PropertyTemplateItem) iterator.next();
					VariableDeclaration containingVarDecl = propertyTemplateItem.getObjContainer().getBindsTo();
					OclAnyModelElement sourceElement = (OclAnyModelElement) currentBindings.get(containingVarDecl.getName());

					VariableDeclaration refTarget;
					if (propertyTemplateItem.getValue() instanceof VariableExp) {
						refTarget = ((VariableExp) propertyTemplateItem.getValue()).getReferredVariable();
					} else if (propertyTemplateItem.getValue() instanceof ObjectTemplateExp) {
						refTarget = ((ObjectTemplateExp) propertyTemplateItem.getValue()).getBindsTo();
					} else {
						continue;
					}

					OclAny targetElement = (OclAny) currentBindings.get(refTarget.getName());
					if (targetElement != null) {
						Property prop = propertyTemplateItem.getReferredProperty();
						if (this.getQvtProcessor().getQvtModelManipulationAdaper().unsetOrRemoveValueForFeauture(sourceElement, prop, targetElement)) {
							if (this.getQvtProcessor().logTasks()) {
								QvtSemanticAnalyserThreadPool.getLogger().println("Unset feature " + prop + " which was bound in the current trace of " + currentTraceRelation.getName());
							}
						} else {
							if (this.getQvtProcessor().logTasks()) {
								OclAny v = QvtSemanticTask.getPropertyValueOf(prop, sourceElement, this.getQvtProcessor());
								String actualString = Trace.isDefined(v) ? "" + v.asJavaObject() : "undefined";
								QvtSemanticAnalyserThreadPool.getLogger().println(
								        "Failed to unset feature " + prop + " for element " + sourceElement + " which was bound in the current trace of " + currentTraceRelation.getName()
								                + ". Actual value was " + actualString + ". Expected value is " + targetElement);
							}
						}
					}

				}

			}

		}

		/*
		 * Then delete all matched-up elements, if they have no more outgoing references
		 */
		for (Iterator iter = traces.iterator(); iter.hasNext();) {
			Trace currentTrace = (Trace) iter.next();
			Relation currentTraceRelation = currentTrace.getRelation();
			Set removalCandidateDecls = (Set) relationToRemovalCandidates.get(currentTraceRelation);
			if (removalCandidateDecls == null) {
				removalCandidateDecls = this.getRemovalCandidateDecls(currentTraceRelation, targetModel, data);
				relationToRemovalCandidates.put(currentTraceRelation, removalCandidateDecls);
			}
			Set removalCandidateElements = this.getElementsForVarDecls(currentTrace, removalCandidateDecls);

			if (this.getQvtProcessor().logTasks()) {
				QvtSemanticAnalyserThreadPool.getLogger().println("Added " + removalCandidateElements.size() + " deletion candidates for relation " + currentTraceRelation.getName());
			}

			// List templateVariables =
			// QVTDirectedValidation.collectAllTemplateVariablesNotInDirection(currentTraceRelation, targetModel, data,
			// this.getQvtProcessor());
			// Set sourceElements = getElementsForVarDecls(currentTrace, templateVariables);

			for (Iterator iterator = removalCandidateElements.iterator(); iterator.hasNext();) {
				OclAny element = (OclAny) iterator.next();
				if (!elementsToDelete.contains(element) && this.getQvtProcessor().getQvtModelManipulationAdaper().areAllReferencesWithin(element, new HashSet())) {
					elementsToDelete.add(element);
					if (this.getQvtProcessor().logTasks()) {
						QvtSemanticAnalyserThreadPool.getLogger().println("Delete " + element + " which was bound in the current trace of " + currentTraceRelation.getName());
					}
					this.getQvtProcessor().getQvtModelManipulationAdaper().deleteElementInTarget(element);
				} else {
					element = element == element ? element : element;

				}

			}
		}

		// for (Iterator iterator = elementsToDelete.iterator(); iterator.hasNext();) {
		// OclAny element = (OclAny) iterator.next();
		// getQvtProcessor().getQvtModelManipulationAdaper().deleteElementInTarget(element);
		// }

	}

	/**
	 * Get all elements from the given trace corresponding to the given variable declarations
	 * 
	 * @param currentTrace
	 * @param varDecls
	 * @return
	 */
	private Set getElementsForVarDecls(Trace currentTrace, Collection varDecls) {
		Set result = new HashSet();
		for (Iterator bindingsIter = currentTrace.getBindings().iterator(); bindingsIter.hasNext();) {
			Map currentBindings = (Map) bindingsIter.next();
			for (Iterator iterator = varDecls.iterator(); iterator.hasNext();) {
				VariableDeclaration var = (VariableDeclaration) iterator.next();
				OclAny val = (OclAny) currentBindings.get(var.getName());
				if (Trace.isDefined(val)) {
					result.add(val);
				}
			}
		}
		return result;
	}

	/**
	 * Get those variable declarations in the source domains which may create elements in backward direction
	 * 
	 * @param relation
	 * @param targetModel
	 * @param data
	 * @return list of {@link VariableDeclaration}
	 */
	private Set getRemovalCandidateDecls(Relation relation, TypedModel targetModel, Object data) {
		Set removalCandidateDecls = new HashSet();
		List templateVariables = QVTDirectedValidation.collectAllObjectTemplatesOfRelationExcludingDirection(relation, targetModel, data);
		for (Iterator iterator = templateVariables.iterator(); iterator.hasNext();) {
			ObjectTemplateExp template = (ObjectTemplateExp) iterator.next();
			VariableDeclaration var = template.getBindsTo();
			Domain dom = QVTDirectedValidation.getDomainOf(template);
			if (dom != null && !targetModel.equals(dom.getTypedModel()) && this.getDomainCountUsingVarDecl(relation, var) <= 1 && this.varUsagesInSourceDomains(var, targetModel)) {
				removalCandidateDecls.add(var);
			}
		}
		return removalCandidateDecls;
	}

	/**
	 * Returns true if the given variable is used only within source domains
	 * 
	 * @param var
	 * @param targetModel
	 * @return
	 */
	private boolean varUsagesInSourceDomains(VariableDeclaration var, TypedModel targetModel) {
		for (Iterator iterator = var.getVariableExps().iterator(); iterator.hasNext();) {
			VariableExp varExp = (VariableExp) iterator.next();
			Domain dom = QVTDirectedValidation.getDomainOf(varExp);
			if (dom != null && targetModel.equals(dom.getTypedModel())) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Returns the number of domains of a relation which refer to the given variable declaration
	 * 
	 * @param currentTraceRelation
	 * @param bindsTo
	 * @return
	 */
	private int getDomainCountUsingVarDecl(Relation currentTraceRelation, VariableDeclaration bindsTo) {
		int result = 0;
		for (Iterator iter = currentTraceRelation.getDomain().iterator(); iter.hasNext();) {
			Domain dom = (Domain) iter.next();
			if (dom instanceof RelationDomain) {
				RelationDomain relDomain = (RelationDomain) dom;
				if (relDomain.getRootVariable() == bindsTo) {
					result++;
				}
			}
		}
		return result;
	}

	/**
	 * This method simply calls <code>executeToplevelRelation(relation, direction, data, 0)</code>.
	 * 
	 * @param relation
	 *            the top level relation to execute.
	 * @param direction
	 *            the execution direction.
	 * @param data
	 *            the execution context {@link Map}.
	 * @return <code>true</code> if the execution was successful, <code>false</code> otherwise.
	 */
	public boolean executeToplevelRelation(Relation relation, TypedModel direction, Object data) {
		return this.executeToplevelRelation(relation, direction, data, 0);
	}

	/**
	 * Executes the given top level <code>relation</code> in the given <code>direction</code>.
	 * 
	 * @param relation
	 *            the top relation to execute.
	 * @param direction
	 *            the execution direction.
	 * @param data
	 *            the execution context {@link Map}.
	 * @param currentDomain
	 *            the
	 * @return
	 */
	public boolean executeToplevelRelation(Relation relation, TypedModel direction, Object data, int currentDomain) {
		RuntimeEnvironment orginalEnv = (RuntimeEnvironment) ((Map) data).get(QvtEvaluatorImpl.QVT_RUNTIME_ENVIRONMENT_PROPERTY_NAME);

		if (currentDomain < relation.getDomain().size()) {
			RuntimeEnvironment env = orginalEnv.newEnvironment();
			((Map) data).put(QvtEvaluatorImpl.QVT_RUNTIME_ENVIRONMENT_PROPERTY_NAME, env);
			RelationDomain currentRelationDomain = (RelationDomain) relation.getDomain().get(currentDomain);

			if (!currentRelationDomain.getTypedModel().equals(direction)) {
				OclSet allInstances = this.processor.getModelEvaluationAdapter().OclType_allInstances(this.processor.getStdLibAdapter().Type(currentRelationDomain.getRootVariable().getType()),
				        this.getQvtProcessor().getModelsForDirection(relation.getTransformation(), currentRelationDomain.getTypedModel()));
				Collection allJavaInstances = (Collection) allInstances.getImplementation();

				if (this.getQvtProcessor().isRandomMode() && !allJavaInstances.isEmpty()) {
					allJavaInstances = QvtEvaluatorVisitorImpl.getRandomPermutation(allJavaInstances);
				}

				for (Iterator iter = allJavaInstances.iterator(); iter.hasNext();) {
					RuntimeEnvironment innerEnv = env.newEnvironment();
					((Map) data).put(QvtEvaluatorImpl.QVT_RUNTIME_ENVIRONMENT_PROPERTY_NAME, innerEnv);
					Object currentJavaInstance = iter.next();
					OclAny currentInstance = this.processor.getStdLibAdapter().OclAny(currentJavaInstance);
					env.setValue(currentRelationDomain.getRootVariable().getName(), currentInstance);
					this.executeToplevelRelation(relation, direction, data, currentDomain + 1);
					if (this.getQvtProcessor().isRandomMode() && this.qvtSemanticAnalyserThreadPool.hasCreatedRandomTask()) {
						break;
					}
				}

				env.setValue(currentRelationDomain.getRootVariable().getName(), null);
				return true;
			}

			return this.executeToplevelRelation(relation, direction, data, currentDomain + 1);
		}

		relation.accept(this, data);
		return true;
	}

	public Object visit(Relation host, Object data) {
		// TODO change code for check mode !!!
		RuntimeEnvironment env = (RuntimeEnvironment) ((Map) data).get(QvtEvaluatorImpl.QVT_RUNTIME_ENVIRONMENT_PROPERTY_NAME);
		TypedModel targetModel = (TypedModel) ((Map) data).get(QvtEvaluatorImpl.QVT_EXECUTION_DIRECTION_PROPERTY_NAME);
		List variablesToIterate = this.qvtEvaluatorHelper.collectAllTemplateVariablesOfRelationExcludingRootVariableExcludingTargetDomain(host, targetModel, data);

		List domains = host.getDomain();
		List arguments = new ArrayList(domains.size());

		for (Iterator iter = domains.iterator(); iter.hasNext();) {
			RelationDomain currentRelationDomain = (RelationDomain) iter.next();
			arguments.add(env.getValue(currentRelationDomain.getRootVariable().getName()));
		}

		QvtSemanticTask qvtSemanticTask = new QvtSemanticTask(host, arguments, targetModel, this);
		qvtSemanticTask.setShallBeExecuted(true);
		return this.qvtSemanticAnalyserThreadPool.addTask(qvtSemanticTask, new boolean[] { false });
	}

	public QvtProcessorImpl getQvtProcessor() {
		return (QvtProcessorImpl) this.processor;
	}

	public Object visit(RelationCallExp host, Object data) {
		// TODO prevent double where !!!
		// TODO caché
		synchronized (this.relationBindingItemList) {

			boolean isWhere = "where".equals(((Map) data).get(QvtEvaluatorImpl.QVT_LOCAL_EXECUTION_MODE_PROPERTY_NAME));
			TypedModel targetModel = (TypedModel) ((Map) data).get(QvtEvaluatorImpl.QVT_EXECUTION_DIRECTION_PROPERTY_NAME);
			if (targetModel == null) {
				targetModel = this.getQvtProcessor().getDirectionContext();
			}

			RuntimeEnvironment oldRuntimeEnvironment = (RuntimeEnvironment) ((Map) data).get(QvtEvaluatorImpl.QVT_RUNTIME_ENVIRONMENT_PROPERTY_NAME);
			Object r = this.buildTask(host, data, targetModel);
			if (!(r instanceof QvtSemanticTask)) {
				return r;
			}
			QvtSemanticTask newTask = (QvtSemanticTask) r;
			if (isWhere) {
				newTask.setShallBeExecuted(true);
			}

			boolean[] promotedToBeExecuted = { false };
			QvtSemanticTask qvtSemanticTaskInQueue = this.qvtSemanticAnalyserThreadPool.addTask(newTask, promotedToBeExecuted);

			if (!QvtEvaluatorVisitorImpl.enableExtendedWhereClauseEvaluation && isWhere) {
				if (qvtSemanticTaskInQueue.isFailed()) {
					if (qvtSemanticTaskInQueue.getQvtProcessor().logTasks()) {
						QvtSemanticAnalyserThreadPool.getLogger().print("(reuse already failed task of relation " + qvtSemanticTaskInQueue.getRelation().getName() + ")");
					}
					qvtSemanticTaskInQueue.setFailed(false);
					// throw new RuntimeException("Relation already failed!");

				}
				((Map) data).put(QvtEvaluatorImpl.QVT_RUNTIME_ENVIRONMENT_PROPERTY_NAME, oldRuntimeEnvironment);
				return this.getQvtProcessor().getStdLibAdapter().Boolean(this.copyDomainObjectTemplateValues(qvtSemanticTaskInQueue, oldRuntimeEnvironment, host, targetModel, newTask.getArguments()));
			} else if (qvtSemanticTaskInQueue.isExecutedForWaitingTasks()) {
				((Map) data).put(QvtEvaluatorImpl.QVT_RUNTIME_ENVIRONMENT_PROPERTY_NAME, oldRuntimeEnvironment);
				return this.getQvtProcessor().getStdLibAdapter().Boolean(this.copyDomainObjectTemplateValues(qvtSemanticTaskInQueue, oldRuntimeEnvironment, host, targetModel, newTask.getArguments()));
			} else if (qvtSemanticTaskInQueue.isFailed()) {
				if (isWhere && promotedToBeExecuted[0]) {
					if (qvtSemanticTaskInQueue.getQvtProcessor().logTasks()) {
						QvtSemanticAnalyserThreadPool.getLogger().print("(reuse already failed task of relation " + qvtSemanticTaskInQueue.getRelation().getName() + ")");
					}
					qvtSemanticTaskInQueue.setFailed(false);
					oldRuntimeEnvironment.setValue("SemTask", qvtSemanticTaskInQueue);
					return OclUndefinedImpl.UNDEFINED;
				}
				((Map) data).put(QvtEvaluatorImpl.QVT_RUNTIME_ENVIRONMENT_PROPERTY_NAME, oldRuntimeEnvironment);
				return this.getQvtProcessor().getStdLibAdapter().Boolean(false);
			} else {
				oldRuntimeEnvironment.setValue("SemTask", qvtSemanticTaskInQueue);
				return OclUndefinedImpl.UNDEFINED;
			}
		}
	}

	/**
	 * Builds a task from the given relation call. Returns this task or another object the relation call cannot be build up.
	 * 
	 * @param host
	 * @param data
	 * @param targetModel
	 * @return
	 */
	public Object buildTask(RelationCallExp host, Object data, TypedModel targetModel) {

		List arguments = host.getArgument();
		List argValues = new ArrayList();
		Relation relation = host.getReferredRelation();
		List domains = relation.getDomain();
		Iterator argIter = arguments.iterator();

		for (Iterator iter = domains.iterator(); iter.hasNext();) {
			OclExpression currentArgExp = (OclExpression) argIter.next();
			OclAny currentValue = (OclAny) currentArgExp.accept(this, data);
			RelationDomain currentRelationDomain = (RelationDomain) iter.next();
			if (!(targetModel != null && targetModel.equals(currentRelationDomain.getTypedModel())) && currentValue instanceof OclUndefined) {
				/**
				 * Relation calls shall always fail if the source domains are not defined
				 */
				return this.getQvtProcessor().getStdLibAdapter().Boolean(false);
			}

			// Checks whether actual parameter type conform to formal parameter type
			if (!(currentValue == null || currentValue instanceof OclUndefined) && currentValue.oclType().asJavaObject() == null) {
				throw new RuntimeException("QvtEvaluationVisitorImpl: cannot retrieve RTTI");
			}
			if (!(currentValue == null || currentValue instanceof OclUndefined) && currentValue.oclType().asJavaObject() != null
			        && !((Classifier) currentValue.oclType().asJavaObject()).conformsTo(currentRelationDomain.getRootVariable().getType()).booleanValue()) {
				return this.getQvtProcessor().getStdLibAdapter().Boolean(false);
			}

			argValues.add(currentValue);
		}

		return new QvtSemanticTask(relation, argValues, targetModel, this);
	}

	private boolean copyDomainObjectTemplateValues(QvtSemanticTask qvtSemanticTask, RuntimeEnvironment targetRuntimeEnvironment, RelationCallExp relationCallExp, TypedModel targetModel, List argValues) {

		Relation relation = relationCallExp.getReferredRelation();
		List domains = relation.getDomain();
		Iterator argIter = relationCallExp.getArgument().iterator();
		Iterator argValuesIter = qvtSemanticTask.getTrace().getArguments().iterator();
		Iterator actualParamIter = argValues.iterator();
		int i = 0;
		int targetDomains = 0;
		int targetValuesDiffer = 0;

		for (Iterator iter = domains.iterator(); iter.hasNext();) {
			Domain currentDomain = (Domain) iter.next();
			OclExpression currentArgExp = (OclExpression) argIter.next();
			OclAny currentArgValue = (OclAny) argValuesIter.next();
			OclAny oldValue = (OclAny) actualParamIter.next();
			String sourceName = currentDomain.getName();
			boolean valuesDiffer = !(currentArgValue != null && oldValue != null && currentArgValue.equalTo(oldValue) == OclBooleanImpl.TRUE);
			if (targetModel.equals(currentDomain.getTypedModel())) {
				targetDomains++;
				if (valuesDiffer) {

					if (Trace.isUndefined(currentArgValue)) {
						qvtSemanticTask.getTrace().getArguments().set(i, oldValue);
						valuesDiffer = false;
					} else if (Trace.isUndefined(oldValue)) {
						if (currentArgExp instanceof VariableExp) {
							VariableExp currentVariableExp = (VariableExp) currentArgExp;
							if (!(currentArgValue == null || currentArgValue instanceof OclUndefined) && currentArgValue.oclType().asJavaObject() != null
							        && !((Classifier) currentArgValue.oclType().asJavaObject()).conformsTo(currentVariableExp.getType()).booleanValue()) {
								return false;
							}
							targetRuntimeEnvironment.setValue(currentVariableExp.getReferredVariable().getName(), currentArgValue);
							valuesDiffer = false;
						}
					}
					if (valuesDiffer) {
						targetValuesDiffer++;
					}
				}
			} else {
				if (valuesDiffer) {
					throw new RuntimeException(this.processor.getAnalyser().getMessage(
					        "Double binding for source domain with different values in " + relation.getName() + " '" + sourceName + "' " + currentArgValue + " != " + oldValue + "! ", currentDomain));
				}
			}
			i++;
		}

		return targetValuesDiffer == 0;
	}

	public Object visit(ObjectTemplateExp host, Object data) {
		RuntimeEnvironment env = (RuntimeEnvironment) ((Map) data).get(QvtEvaluatorImpl.QVT_RUNTIME_ENVIRONMENT_PROPERTY_NAME);
		// TODO if var name = null!!
		Object result = env.getValue(host.getBindsTo().getName());
		Classifier type = host.getBindsTo().getType();
		result = this.wrapJavaObjectAsOclType(type, result);
		return result;
	}

	public Object visit(PropertyTemplateItem host, Object data) {
		// TODO
		throw new RuntimeException();
	}

	public Object visit(OperationCallExp host, Object data) {
		if (host.getReferredOperation() instanceof Function) {
			RuntimeEnvironment oldRuntimeEnvironment = (RuntimeEnvironment) ((Map) data).get(QvtEvaluatorImpl.QVT_RUNTIME_ENVIRONMENT_PROPERTY_NAME);

			RuntimeEnvironment newRuntimeEnvironment = new RuntimeEnvironmentImpl();
			List arguments = host.getArguments();
			List argValues = new ArrayList();
			for (Iterator iter = arguments.iterator(); iter.hasNext();) {
				OclExpression currentArgExp = (OclExpression) iter.next();
				argValues.add(currentArgExp.accept(this, data));
			}
			Function function = (Function) host.getReferredOperation();
			List parameters = function.getOwnedParameter();
			Iterator valuesIter = argValues.iterator();
			for (Iterator iter = parameters.iterator(); iter.hasNext();) {
				if (!valuesIter.hasNext()) {
					throw new RuntimeException("Illegal state!");
				}
				FunctionParameter currentFunctionParameter = (FunctionParameter) iter.next();
				OclAny currentValue = (OclAny) valuesIter.next();
				if (this.getQvtProcessor().logTasks() && function.getName().startsWith("_debug")) {
					QvtSemanticAnalyserThreadPool.getLogger().print("[" + currentValue.asJavaObject() + "]");
				}
				newRuntimeEnvironment.setValue(currentFunctionParameter.getName(), currentValue);
			}
			((Map) data).put(QvtEvaluatorImpl.QVT_RUNTIME_ENVIRONMENT_PROPERTY_NAME, newRuntimeEnvironment);

			OclAny result = (OclAny) function.getQueryExpression().accept(this, data);

			if (this.getQvtProcessor().isRandomMode() && QvtEvaluatorVisitorImpl.isRandomStringFunction(host)) {
				result = this.processor.getStdLibAdapter().OclAny(
				        this.getRandomString(this.getIntParam("fromLength", 0, newRuntimeEnvironment), this.getIntParam("toLength", 15, newRuntimeEnvironment), this.getIntParam("fromChar", 65,
				                newRuntimeEnvironment), this.getIntParam("toChar", 90, newRuntimeEnvironment)));
			}
			((Map) data).put(QvtEvaluatorImpl.QVT_RUNTIME_ENVIRONMENT_PROPERTY_NAME, oldRuntimeEnvironment);
			return result;
		}
		return super.visit(host, data);

	}

	static public boolean isRandomStringFunction(OperationCallExp host) {
		return host.getReferredOperation().getName().startsWith("getRandom");
	}

	protected int getIntParam(String paramName, int default_, RuntimeEnvironment runtimeEnvironment) {
		if (runtimeEnvironment.getValue(paramName) instanceof OclIntegerImpl) {
			return ((OclIntegerImpl) runtimeEnvironment.getValue(paramName)).int_impl();
		}
		return default_;
	}

	protected String getRandomString(int fromLength, int toLength, int fromChar, int toChar) {
		long count = QvtEvaluatorVisitorImpl.getRandom(fromLength, toLength);
		String s = "";
		for (int i = 0; i < count; i++) {
			s += "" + this.getRandomChar(fromChar, toChar);
		}
		return s;
	}

	protected char getRandomChar(int fromChar, int toChar) {
		return (char) QvtEvaluatorVisitorImpl.getRandom(fromChar, toChar);
	}

	/**
	 * Returns a random value between <code>from</code> and <code>to</code>
	 * 
	 * @param from
	 * @param to
	 * @return
	 */
	static public long getRandom(long from, long to) {
		double r = Math.random();
		long ri = Math.round(from + r * (to - from));
		return ri;
	}

	/**
	 * Get random item from list
	 * 
	 * @param list
	 * @return
	 */
	static public Object getRandomItemFromList(List list) {
		return list.get((int) QvtEvaluatorVisitorImpl.getRandom(0, list.size() - 1));
	}

	/**
	 * Returns a permutation of the given list
	 * 
	 * @param baseList
	 * @return
	 */
	public static List getRandomPermutation(Collection baseList) {
		List permutation = new ArrayList(baseList);
		for (int sourceIndex = 0; sourceIndex < baseList.size(); sourceIndex++) {
			int targetIndex = (int) QvtEvaluatorVisitorImpl.getRandom(0, baseList.size() - 1);
			Object target = permutation.get(targetIndex);
			Object source = permutation.get(sourceIndex);
			permutation.set(sourceIndex, target);
			permutation.set(targetIndex, source);
		}
		return permutation;
	}

	public QVTEvaluatorHelper getQvtEvaluatorHelper() {
		return this.qvtEvaluatorHelper;
	}

	// public List getRelationBindingItemList() {
	// return relationBindingItemList;
	// }

	public Object getTraces() {
		return this.traces;
	}

	public Collection getOldTraces() {
		return this.oldTraces;
	}

	public void addTrace(Trace trace) {
		if (this.traces.add(trace)) {
			this.tracesOrdered.add(trace);
		}
	}

	public QvtSemanticAnalyserThreadPool getThreadPool() {
		return this.qvtSemanticAnalyserThreadPool;
	}

	/**
	 * @see org.oslo.ocl20.semantics.QvtVisitor#visit(de.ikv.medini.qvt.model.qvtrelation.RelationDomain, java.lang.Object)
	 */
	public Object visit(RelationDomain host, Object data) {
		throw new RuntimeException("This type of host cannot be evaluated!");
	}

	/**
	 * @see org.oslo.ocl20.semantics.QvtVisitor#visit(org.oslo.ocl20.semantics.model.contexts.Constraint, java.lang.Object)
	 */
	public Object visit(Constraint host, Object data) {
		throw new RuntimeException("This type of host cannot be evaluated!");
	}

	/**
	 * @see org.oslo.ocl20.semantics.QvtVisitor#visit(de.ikv.medini.qvt.model.qvtrelation.DomainPattern, java.lang.Object)
	 */
	public Object visit(DomainPattern host, Object data) {
		throw new RuntimeException("This type of host cannot be evaluated!");
	}

	/**
	 * @see org.oslo.ocl20.semantics.QvtVisitor#visit(de.ikv.medini.qvt.model.qvtrelation.Key, java.lang.Object)
	 */
	public Object visit(Key host, Object data) {
		throw new RuntimeException("This type of host cannot be evaluated!");
	}

	/**
	 * @see org.oslo.ocl20.semantics.QvtVisitor#visit(de.ikv.medini.qvt.model.qvtbase.Predicate, java.lang.Object)
	 */
	public Object visit(Predicate host, Object data) {
		throw new RuntimeException("This type of host cannot be evaluated!");
	}

	/**
	 * @see org.oslo.ocl20.semantics.QvtVisitor#visit(de.ikv.medini.qvt.model.qvtbase.Pattern, java.lang.Object)
	 */
	public Object visit(Pattern host, Object data) {
		throw new RuntimeException("This type of host cannot be evaluated!");
	}

	/**
	 * @see org.oslo.ocl20.semantics.QvtVisitor#visit(de.ikv.medini.qvt.model.qvtrelation.RelationImplementation, java.lang.Object)
	 */
	public Object visit(RelationImplementation host, Object data) {
		throw new RuntimeException("This type of host cannot be evaluated!");
	}

	/**
	 * @see org.oslo.ocl20.semantics.QvtVisitor#visit(org.oslo.ocl20.semantics.bridge.Tag, java.lang.Object)
	 */
	public Object visit(Tag host, Object data) {
		throw new RuntimeException("This type of host cannot be evaluated!");
	}

	/**
	 * @see org.oslo.ocl20.semantics.QvtVisitor#visit(de.ikv.medini.qvt.model.qvtbase.TypedModel, java.lang.Object)
	 */
	public Object visit(TypedModel host, Object data) {
		throw new RuntimeException("This type of host cannot be evaluated!");
	}

	/**
	 * @see org.oslo.ocl20.semantics.QvtVisitor#visit(de.ikv.medini.qvt.model.qvtbase.Function, java.lang.Object)
	 */
	public Object visit(Function host, Object data) {
		throw new RuntimeException("This type of host cannot be evaluated!");
	}

}
