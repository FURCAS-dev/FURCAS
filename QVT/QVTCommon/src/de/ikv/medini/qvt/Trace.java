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

import org.oslo.ocl20.semantics.bridge.Property;
import org.oslo.ocl20.semantics.model.expressions.VariableDeclaration;
import org.oslo.ocl20.standard.lib.OclAny;
import org.oslo.ocl20.standard.lib.OclAnyModelElement;
import org.oslo.ocl20.standard.lib.OclBooleanImpl;
import org.oslo.ocl20.standard.lib.OclUndefined;
import org.oslo.ocl20.synthesis.RuntimeEnvironment;

import de.ikv.medini.qvt.execution.QvtSemanticAnalyserThreadPool;
import de.ikv.medini.qvt.model.qvtbase.TypedModel;
import de.ikv.medini.qvt.model.qvtrelation.Relation;
import de.ikv.medini.qvt.model.qvtrelation.RelationDomain;
import de.ikv.medini.qvt.model.qvttemplate.ObjectTemplateExp;
import de.ikv.medini.qvt.model.qvttemplate.PropertyTemplateItem;

/**
 * A trace stores the mapping of source domain values to target domain values. It also stores a list of all bindings having equal domain values but different values for nested
 * object templates.
 * 
 * @author Michael Wagner
 * @author Omar Ekine
 * @author Joerg Kiegeland
 * 
 */
public class Trace {

	/**
	 * Flag indicating whether the primary key property is enforced even on non-toplevel relations. The old engine behavior enforced this behavior. A value of "false" realizes a
	 * feature here referred to as "local relations". The local-relations-feature is downward compatible with the old engine behavior.
	 */
	private static boolean enforcePrimaryKey = false;

	/**
	 * Holds the cached hash code
	 */
	int hashCode = 0;

	Relation relation;

	/**
	 * Values for the domains
	 */
	List arguments;

	/**
	 * Holds bindings of the trace. A binding is a map from variable names to values.
	 */
	List bindings = new ArrayList();

	/**
	 * The last modification time of this trace.
	 */
	private long modificationTime = 0;

	private ArrayList mediniIdentifiersOfBindings;

	public void putMediniIdentifiersOfBindings(String mediniIdentifier) {
		if (this.mediniIdentifiersOfBindings == null) {
			this.mediniIdentifiersOfBindings = new ArrayList();
		}
		this.mediniIdentifiersOfBindings.add(mediniIdentifier);
	}

	public String getMediniIdentifiersOfBinding(Map binding) {
		try {
			return (String) this.mediniIdentifiersOfBindings.get(this.bindings.indexOf(binding));
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * The medini identifier of this trace. If possible, this value should not change accross transformations.
	 */
	// private String mediniIdentifier;
	public Trace(Relation relation, List arguments) {
		this.relation = relation;
		this.arguments = new ArrayList(arguments);
	}

	/**
	 * Checks on equality with possible trace instance <code>object</code> considering all domains
	 */
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}
		if (object instanceof Trace) {
			Trace trace = (Trace) object;
			if (!this.relation.getName().equals(trace.relation.getName())) {
				return false;
			}
			Iterator iterToCompareTo = trace.arguments.iterator();
			for (Iterator iter = this.arguments.iterator(); iter.hasNext();) {
				OclAny currentArgument = (OclAny) iter.next();
				OclAny currentArgumentToCompareTo = (OclAny) iterToCompareTo.next();
				if (Trace.isUndefined(currentArgument) || Trace.isUndefined(currentArgumentToCompareTo)) {
					if (!(Trace.isUndefined(currentArgument) && Trace.isUndefined(currentArgumentToCompareTo))) {
						return false;
					}
				} else if (currentArgument.equalTo(currentArgumentToCompareTo) == OclBooleanImpl.FALSE) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

	/**
	 * Determines if the given value is undefined, including the case it is null
	 * 
	 * @param value
	 * @return
	 */
	public static boolean isUndefined(OclAny value) {
		return value == null || value instanceof OclUndefined;
	}

	public static boolean isDefined(OclAny value) {
		return !Trace.isUndefined(value);
	}

	public static boolean areAllUndefined(Collection values) {
		for (Iterator iter = values.iterator(); iter.hasNext();) {
			OclAny element = (OclAny) iter.next();
			if (!Trace.isUndefined(element)) {
				return false;
			}
		}
		return true;
	}

	public static Collection removeUndefined(Collection values) {
		Collection result = new ArrayList();
		for (Iterator iter = values.iterator(); iter.hasNext();) {
			OclAny element = (OclAny) iter.next();
			if (Trace.isDefined(element)) {
				result.add(element);
			}
		}
		return result;
	}

	public int hashCode() {
		if (this.hashCode == 0) {
			this.hashCode = this.relation.hashCode();
			for (Iterator iter = this.arguments.iterator(); iter.hasNext();) {
				OclAny currentArg = (OclAny) iter.next();
				if (currentArg != null) {
					this.hashCode = this.hashCode ^ currentArg.hashCode();
				}
			}
			if (this.hashCode == 0) {
				this.hashCode = 1;
			}
		}

		return this.hashCode;
	}

	/**
	 * Checks on equality with trace <code>trace</code> not considering the target domains if the source domains are a primary key
	 * 
	 * @param trace
	 * @param direction
	 * @return
	 */
	public boolean equalsInDirection(Trace trace, TypedModel direction) {
		if (this.sourceDomainsArePrimaryKey()) {
			return this.equalsOnSourceDomains(trace, direction);
		}
		return this.equals(trace);
	}

	/**
	 * Checks on equality with trace <code>trace</code> not considering the target domains
	 * 
	 * @param trace
	 * @param targetModel
	 * @return
	 */
	public boolean equalsOnSourceDomains(Trace trace, TypedModel targetModel) {
		if (trace == null) {
			return false;
		}
		if (!this.relation.getName().equals(trace.relation.getName())) {
			return false;
		}
		Iterator iterToCompareTo = trace.arguments.iterator();
		List domains = this.relation.getDomain();
		Iterator domainIter = domains.iterator();
		for (Iterator iter = this.arguments.iterator(); iter.hasNext();) {
			OclAny currentArgument = (OclAny) iter.next();
			RelationDomain currentRelationDomain = (RelationDomain) domainIter.next();
			OclAny currentArgumentToCompareTo = (OclAny) iterToCompareTo.next();
			if (!(targetModel != null && targetModel.equals(currentRelationDomain.getTypedModel()))) {
				/*
				 * if (currentRelationDomain.getRootVariable().getType() instanceof Primitive) { //currentArgumentToCompareTo is undefined, since primitive trace values are not
				 * saved } else
				 */
				if (Trace.isUndefined(currentArgument) || Trace.isUndefined(currentArgumentToCompareTo)) {
					if (!(Trace.isUndefined(currentArgument) && Trace.isUndefined(currentArgumentToCompareTo))) {
						return false;
					}
				} else if (currentArgument.equalTo(currentArgumentToCompareTo) == OclBooleanImpl.FALSE) {
					return false;
				}

			}
		}
		return true;
	}

	/**
	 * Checks whether the source domains constitute a primary key or not. If they constitute a primary key, there must not exist two traces having the same source domain values and
	 * different target domain values.
	 * 
	 * @return
	 */
	public boolean sourceDomainsArePrimaryKey() {
		if (Trace.enforcePrimaryKey) {
			return true;
		}
		return this.relation.isIsTopLevel();
	}

	/**
	 * Calculates the hash code not considering domains of direction <code>direction</code>.
	 * 
	 * @param direction
	 * @return
	 */
	public int hashCodeInDirection(TypedModel direction) {
		int hashCodeInDirection = this.relation.hashCode();
		List domains = this.relation.getDomain();
		Iterator domainIter = domains.iterator();
		for (Iterator iter = this.arguments.iterator(); iter.hasNext();) {
			OclAny currentArg = (OclAny) iter.next();
			RelationDomain currentRelationDomain = (RelationDomain) domainIter.next();
			if (!(direction != null && direction.equals(currentRelationDomain.getTypedModel()))) {
				hashCodeInDirection = hashCodeInDirection ^ currentArg.hashCode();
			}
		}
		if (hashCodeInDirection == 0) {
			hashCodeInDirection = 1;
		}

		return hashCodeInDirection;
	}

	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append(this.relation.getName() + "(");
		buffer.append(this.arguments.toString());
		buffer.append(")");
		return buffer.toString();
	}

	public List getArguments() {
		return this.arguments;
	}

	public List getBindings() {
		return this.bindings;
	}

	/**
	 * Adds a binding to the trace by evaluating bound variables of a {@link RuntimeEnvironment} instance.
	 * 
	 * @param runtimeEnvironment
	 * @param qvtEvaluatorHelper
	 * @param data
	 */
	public void addBindingFrom(RuntimeEnvironment runtimeEnvironment, QVTEvaluatorHelper qvtEvaluatorHelper, Object data) {
		Map binding = new HashMap();
		List templateVariables = QVTEvaluatorHelper.collectAllTemplateVariablesOfRelation(this.relation, data);
		for (Iterator iter = templateVariables.iterator(); iter.hasNext();) {
			VariableDeclaration currentVariableDeclaration = (VariableDeclaration) iter.next();
			binding.put(currentVariableDeclaration.getName(), runtimeEnvironment.getValue(currentVariableDeclaration.getName()));
		}
		this.getBindings().add(binding);
	}

	public void addBinding(Map binding) {
		this.getBindings().add(binding);
	}

	/**
	 * Finds a trace in <code>traces</code> which conforms to the domain values <code>arguments</code>
	 * 
	 * @param traces
	 * @param relation
	 * @param arguments
	 * @param direction
	 * @return
	 */
	public static Trace findTrace(Collection traces, Relation relation, List arguments, TypedModel direction) {
		Trace referenceTrace = new Trace(relation, arguments);
		for (Iterator iter = traces.iterator(); iter.hasNext();) {
			Trace currentTrace = (Trace) iter.next();
			if (referenceTrace.equalsInDirection(currentTrace, direction)) {
				return currentTrace;
			}
		}
		for (Iterator iter = traces.iterator(); iter.hasNext();) {
			Trace currentTrace = (Trace) iter.next();
			if (referenceTrace.equalsOnSourceDomains(currentTrace, direction)) {
				return currentTrace;
			}
		}
		return null;
	}

	/**
	 * Allocates the target traces, medini identifiers of their source trace counterparts.
	 * 
	 * @param sourceTraces
	 *            traces whose identifiers should be allocated to those in <code>targetTraces</code>.
	 * @param targetTraces
	 *            traces whose identifiers should be set to those in <code>sourceTraces</code>.
	 * @param direction
	 *            the direction whose traces are to be considered.
	 * @param overwrite
	 *            flag to indicate wheter an identifier should be overwritten, if it already exist.
	 */
	public static void allocateMediniIdentifiers(Collection sourceTraces, Collection targetTraces, TypedModel direction, boolean overwrite) {
		for (Iterator iter = targetTraces.iterator(); iter.hasNext();) {
			Trace currentTargetTrace = (Trace) iter.next();

			// check if medini identifier should be overwritten

			if (currentTargetTrace.hasBindingMediniIdentifiers() && !overwrite) {
				continue;
			}

			Trace currentSourceTrace = Trace.findTrace(sourceTraces, currentTargetTrace.getRelation(), currentTargetTrace.getArguments(), direction);

			if (currentSourceTrace != null) {
				currentTargetTrace.assignMediniIdentifiersOfBindings(currentSourceTrace);
			}
		}
	}

	private void assignMediniIdentifiersOfBindings(Trace trace) {
		this.mediniIdentifiersOfBindings = trace.mediniIdentifiersOfBindings;
	}

	private boolean hasBindingMediniIdentifiers() {
		return this.mediniIdentifiersOfBindings != null;
	}

	public static Trace bindVariablesByTrace(Collection oldTraces, Relation relation, RuntimeEnvironment env, TypedModel direction, QVTEvaluatorHelper qvtEvaluatorHelper,
	        QvtProcessorImpl qvtProcessorImpl, Object data) {
		List argValues = new ArrayList();
		List domains = relation.getDomain();
		for (Iterator iter = domains.iterator(); iter.hasNext();) {
			RelationDomain currentRelationDomain = (RelationDomain) iter.next();
			OclAny value = (OclAny) env.getValue(currentRelationDomain.getRootVariable().getName());
			if (!(direction != null && direction.equals(currentRelationDomain.getTypedModel())) && value == null) {
				throw new RuntimeException("invalid state");
			}
			argValues.add(value);
		}
		Trace currentTrace = Trace.findTrace(oldTraces, relation, argValues, direction);
		if (currentTrace != null) {
			// now find binding !!
			List bindings = currentTrace.getBindings();
			List boudVariables = qvtEvaluatorHelper.collectAllTemplateVariablesOfRelationExcludingTargetDomain(relation, direction, data);
			for (Iterator iterator = bindings.iterator(); iterator.hasNext();) {
				Map currentBinding = (Map) iterator.next();
				boolean isValidBinding = true;
				/*
				 * We test for conformance with the object templates in the source domains
				 */
				isValidBinding = Trace.checkBindingForVariables(boudVariables, currentBinding, env, false);
				if (isValidBinding) {
					List targetTemplates = qvtEvaluatorHelper.collectAllTemplateVariablesOfRelationInDirection(relation, direction, data);
					/*
					 * We test for conformance with the object templates in the target domains
					 */
					isValidBinding = Trace.checkBindingForVariables(targetTemplates, currentBinding, env, true);
					if (isValidBinding) {
						Trace.bindVariablesFromBinding(targetTemplates, currentBinding, env, qvtProcessorImpl);
						return currentTrace;
					}
				}
			}
			/*
			 * No binding was valid, so just set the target domain root variables if there is any binding (see test case OrderedBindingsTestCase)
			 */
			if (bindings.iterator().hasNext()) {
				Map currentBinding = (Map) bindings.iterator().next();

				List targetRootVariables = qvtEvaluatorHelper.collectAllDomainRootVariablesOfRelationInDirection(relation, direction);
				/*
				 * We test for conformance with the target domain root variables
				 */
				boolean isValidBinding = Trace.checkBindingForVariables(targetRootVariables, currentBinding, env, true);
				if (isValidBinding) {
					Trace.bindVariablesFromBinding(targetRootVariables, currentBinding, env, qvtProcessorImpl);
					return currentTrace;
				}
			}
		}
		return null;
	}

	/**
	 * Bind given variables with values from given binding
	 * 
	 * @param variableDeclarations
	 * @param binding
	 * @param env
	 * @param qvtProcessorImpl
	 */
	private static void bindVariablesFromBinding(List variableDeclarations, Map binding, RuntimeEnvironment env, QvtProcessorImpl qvtProcessorImpl) {
		for (Iterator iterator2 = variableDeclarations.iterator(); iterator2.hasNext();) {
			VariableDeclaration currentVariableDeclaration = (VariableDeclaration) iterator2.next();
			OclAny oldValue = (OclAny) binding.get(currentVariableDeclaration.getName());
			OclAny targetValue = qvtProcessorImpl.getQvtModelManipulationAdaper().findElementInTarget(oldValue);
			if (!(targetValue == null || targetValue instanceof OclUndefined)) {
				env.setValue(currentVariableDeclaration.getName(), targetValue);
			}
		}
	}

	/**
	 * We test for conformance of the given binding with the bound variables for the all variables in 'variableDeclarations'
	 * 
	 */
	private static boolean checkBindingForVariables(List variableDeclarations, Map binding, RuntimeEnvironment env, boolean allowUndefined) {
		for (Iterator iterator1 = variableDeclarations.iterator(); iterator1.hasNext();) {
			VariableDeclaration currentVariableDeclaration = (VariableDeclaration) iterator1.next();
			OclAny val1 = (OclAny) binding.get(currentVariableDeclaration.getName());
			OclAny val2 = (OclAny) env.getValue(currentVariableDeclaration.getName());

			/*
			 * Case val1 is not set, val2 is not set: a target element will be created
			 * 
			 * Case val1 is not set, val2 is set: the source target element will be used
			 * 
			 * Case val1 is set, val2 is not set: the trace target element will be used
			 * 
			 * Case val1 is set, val2 is set: val1 and val2 must be equal for the binding to be valid
			 */

			if (!Trace.isUndefined(val1) && !Trace.isUndefined(val2)) {
				if (val1.equalTo(val2) != OclBooleanImpl.TRUE) {
					return false;
				}
			} else if (!allowUndefined) {
				return false;
			}

		}
		return true;
	}

	/**
	 * Does the following:
	 * <ul>
	 * <li> Deletes all elements from the target model which where induced by a former transformation, but are not induced by the current transformation anymore. </li>
	 * <li>Resets values set by the previous transformation but not set by the current one.
	 * </ul>
	 * 
	 * @param newTraces
	 *            traces of the current transformation
	 * @param oldTraces
	 *            traces of the former transformation
	 * @param direction
	 * @param qvtEvaluatorHelper
	 * @param qvtProcessor
	 * @param transformation
	 * @param data
	 */
	// TODO both ways ... source and target !!
	public static void cleanupTraces(Collection newTraces, Collection oldTraces, TypedModel direction, QVTEvaluatorHelper qvtEvaluatorHelper, QvtProcessorImpl qvtProcessor, Object data) {
		Trace.enforceDeletion(newTraces, oldTraces, direction, qvtEvaluatorHelper, qvtProcessor, data);
		Trace.resetObsoleteValuesSetByPreviousTransformation(newTraces, oldTraces, direction, qvtProcessor, qvtEvaluatorHelper, data);
	}

	private static void resetObsoleteValuesSetByPreviousTransformation(Collection newTraces, Collection oldTraces, TypedModel direction, QvtProcessorImpl qvtProcessor,
	        QVTEvaluatorHelper qvtEvaluatorHelper, Object data) {
		for (Iterator iter = oldTraces.iterator(); iter.hasNext();) {
			Trace currentOldTrace = (Trace) iter.next();
			Trace currentNewTrace = Trace.findTrace(newTraces, currentOldTrace.getRelation(), currentOldTrace.getArguments(), direction);

			if (currentNewTrace == null) {
				continue;
			}
			Trace.resetObsoleteValuesSetByPreviousTransformation(currentNewTrace, currentOldTrace, direction, qvtProcessor, qvtEvaluatorHelper, data);
		}
	}

	private static void resetObsoleteValuesSetByPreviousTransformation(Trace newTrace, Trace oldTrace, TypedModel direction, QvtProcessorImpl qvtProcessor, QVTEvaluatorHelper qvtEvaluatorHelper,
	        Object data) {

		List targetTemplateVariables = qvtEvaluatorHelper.collectAllTemplateVariablesOfRelationInDirection(oldTrace.getRelation(), direction, data);
		List targetRootVariables = qvtEvaluatorHelper.collectAllDomainRootVariablesOfRelationInDirection(oldTrace.getRelation(), direction);

		for (Iterator iter = targetTemplateVariables.iterator(); iter.hasNext();) {
			VariableDeclaration variableDeclaration = (VariableDeclaration) iter.next();
			String currentVariable = variableDeclaration.getName();

			// ignore target domain root variable
			if (Trace.isRootVariable(targetRootVariables, currentVariable)) {
				continue;
			}

			ObjectTemplateExp currentVariableObjectTemplate = qvtEvaluatorHelper.getNestedObjectTemplateBindingToVariable(newTrace.getRelation(), direction, data, currentVariable);

			if (currentVariableObjectTemplate == null) {
				continue;
			}

			// the target model element is the one bound to the parent variable of the current variable
			PropertyTemplateItem propertyTemplateItem = (PropertyTemplateItem) currentVariableObjectTemplate.eContainer();
			ObjectTemplateExp targetModelElementObjectTemplate = (ObjectTemplateExp) propertyTemplateItem.eContainer();
			String targetModelElementBindingVariable = targetModelElementObjectTemplate.getBindsTo().getName();
			Collection targetModelElements = Trace.findBindingValues(newTrace, targetModelElementBindingVariable);

			if (targetModelElements == null || targetModelElements.isEmpty()) {
				continue;
			}

			// the values to unset are those set by the previous transformation but not by the current one.
			Collection currentOldBindingValues = Trace.removeUndefined(Trace.findBindingValues(oldTrace, currentVariable));
			Collection currentNewBindingValues = Trace.removeUndefined(Trace.findBindingValues(newTrace, currentVariable));
			Collection oldValuesNotInNewValues = Trace.getOldValuesNotInNewValues(currentOldBindingValues, currentNewBindingValues, qvtProcessor);

			if (oldValuesNotInNewValues.isEmpty()) {
				continue;
			}

			Property property = propertyTemplateItem.getReferredProperty();
			qvtProcessor.getQvtModelManipulationAdaper().unsetOrRemoveValuesForFeature((OclAnyModelElement) targetModelElements.iterator().next(), property, oldValuesNotInNewValues);
		}
	}

	private static boolean isRootVariable(List domainRootVariables, String bindingVariable) {
		for (Iterator iter = domainRootVariables.iterator(); iter.hasNext();) {
			VariableDeclaration currentRootVariable = (VariableDeclaration) iter.next();

			if (bindingVariable.equals(currentRootVariable.getName())) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Returns the elements in <code>oldValues</code> that are still in the target model but not in <code>newValues</code>.
	 * 
	 * @param oldValues
	 *            a collection of {@link OclAnyModelElement}s.
	 * @param newValues
	 *            a collection of {@link OclAnyModelElement}s.
	 * @param qvtProcessor
	 *            the QVT processor.
	 * @return a collection of {@link OclAnyModelElement}s.
	 */
	private static Collection getOldValuesNotInNewValues(Collection oldValues, Collection newValues, QvtProcessorImpl qvtProcessor) {
		Collection result = new ArrayList();

		for (Iterator iter = oldValues.iterator(); iter.hasNext();) {
			Object currentOldValue = iter.next();

			if (!newValues.contains(currentOldValue)) {
				if (currentOldValue instanceof OclAnyModelElement) {
					Object elementInTarget = qvtProcessor.getQvtModelManipulationAdaper().findElementInTarget((OclAnyModelElement) currentOldValue);
					if (elementInTarget != null) {
						result.add(elementInTarget);
					}
				} else {
					result.add(currentOldValue);
				}
			}
		}

		return result;
	}

	private static void enforceDeletion(Collection newTraces, Collection oldTraces, TypedModel direction, QVTEvaluatorHelper qvtEvaluatorHelper, QvtProcessorImpl qvtProcessor, Object data) {
		Collection allOldVarDecls = qvtProcessor.logTasks() ? new ArrayList() : null;
		Collection allOldElements = Trace.collectAllReferedElementsInDirection(oldTraces, direction, qvtEvaluatorHelper, data, allOldVarDecls);
		Collection allNewElements = Trace.collectAllReferedElementsInDirection(newTraces, direction, qvtEvaluatorHelper, data, null);

		Iterator iterDecls = allOldVarDecls == null ? null : allOldVarDecls.iterator();
		for (Iterator iter = allOldElements.iterator(); iter.hasNext();) {
			OclAny currentOldElement = (OclAny) iter.next();
			VariableDeclaration currentOldVarDecl = iterDecls == null ? null : (VariableDeclaration) iterDecls.next();
			OclAny currentOldElementInTargetModel = qvtProcessor.getQvtModelManipulationAdaper().findElementInTarget(currentOldElement);

			if (currentOldElementInTargetModel != null) {
				if (!allNewElements.contains(currentOldElementInTargetModel)) {
					qvtProcessor.getQvtModelManipulationAdaper().deleteElementInTarget(currentOldElementInTargetModel);

					if (currentOldVarDecl != null && !(currentOldElementInTargetModel instanceof OclUndefined) && currentOldVarDecl.eContainer() instanceof Relation) {
						QvtSemanticAnalyserThreadPool.getLogger().println(
						        "Delete " + currentOldElementInTargetModel + " which was bound in an old trace by " + ((Relation) currentOldVarDecl.eContainer()).getName() + "."
						                + currentOldVarDecl.getName());
					}
				}
			}
		}
	}

	/**
	 * Collects all induced elements of a transformation
	 * 
	 * @param traces
	 *            traces of the transformation
	 * @param direction
	 *            direction of the transformation
	 * @param qvtEvaluatorHelper
	 * @param data
	 * @param variableDeclarations
	 *            If variableDeclarations is not null, then the corresponding variable declarations are collected into this collection for debugging purposes, too.
	 * @return the collected elements
	 */
	public static Collection collectAllReferedElementsInDirection(Collection traces, TypedModel direction, QVTEvaluatorHelper qvtEvaluatorHelper, Object data, Collection variableDeclarations) {
		Collection result = new HashSet();

		for (Iterator iter = traces.iterator(); iter.hasNext();) {
			Trace currentTrace = (Trace) iter.next();
			Relation currentTraceRelation = currentTrace.getRelation();
			List templateVariables = qvtEvaluatorHelper.collectAllTemplateVariablesOfRelationInDirection(currentTraceRelation, direction, data);
			List bindings = currentTrace.getBindings();

			for (Iterator bindingsIter = bindings.iterator(); bindingsIter.hasNext();) {
				Map currentBindings = (Map) bindingsIter.next();

				for (Iterator templateVariablesIter = templateVariables.iterator(); templateVariablesIter.hasNext();) {
					VariableDeclaration currentTemplateVariableDeclaration = (VariableDeclaration) templateVariablesIter.next();
					result.add(currentBindings.get(currentTemplateVariableDeclaration.getName()));

					if (variableDeclarations != null) {
						variableDeclarations.add(currentTemplateVariableDeclaration);
					}
				}
			}
		}
		return result;
	}

	/**
	 * 
	 * @param trace
	 * @param bindingVariable
	 * @return a collection of {@link OclAny} instances
	 */
	public static Collection findBindingValues(Trace trace, String bindingVariable) {

		ArrayList result = new ArrayList();
		List bindings = trace.getBindings();

		for (Iterator bindingsIter = bindings.iterator(); bindingsIter.hasNext();) {
			Map currentBindings = (Map) bindingsIter.next();

			if (!currentBindings.containsKey(bindingVariable)) {
				continue;
			}
			result.add(currentBindings.get(bindingVariable));
		}

		return result;
	}

	public Relation getRelation() {
		return this.relation;
	}

	public long getModificationTime() {
		return this.modificationTime;
	}

	/**
	 * Sets the last modification time of this trace to the given value.
	 * 
	 * @param modificationTime
	 *            the last modification time of this trace in millisecs.
	 */
	public void setModificationTime(long modificationTime) {
		this.modificationTime = modificationTime;
	}

	/**
	 * Checks whether at least one of the domain values for domains of direction <code>direction</code> is undefined
	 * 
	 * @param direction
	 * @return
	 */
	public boolean areDomainValuesUndefinedInDirection(TypedModel direction) {
		List domains = this.relation.getDomain();
		Iterator domainIter = domains.iterator();

		for (Iterator iter = this.arguments.iterator(); iter.hasNext();) {
			OclAny currentArgument = (OclAny) iter.next();
			RelationDomain currentRelationDomain = (RelationDomain) domainIter.next();

			if (direction != null && direction.equals(currentRelationDomain.getTypedModel()) && Trace.isUndefined(currentArgument)) {
				return true;
			}
		}
		return false;
	}

	public String logDefinedDomainValues() {
		String result = "";
		List domains = this.relation.getDomain();
		Iterator domainIter = domains.iterator();

		for (Iterator iter = this.arguments.iterator(); iter.hasNext();) {
			OclAny currentArgument = (OclAny) iter.next();
			RelationDomain currentRelationDomain = (RelationDomain) domainIter.next();

			if (!Trace.isUndefined(currentArgument)) {
				result += currentRelationDomain.getName() + "=" + currentArgument + " ";
			}
		}
		return result;
	}

	/**
	 * Repopulates the domain values of this trace with the given values. Be careful since this operation modifies the hash code!
	 * 
	 * @param argValues
	 */
	public void repopulateArguments(List argValues) {
		this.getArguments().clear();
		this.getArguments().addAll(argValues);
		// invalidate cachsed hashCode
		this.hashCode = 0;
	}
}
