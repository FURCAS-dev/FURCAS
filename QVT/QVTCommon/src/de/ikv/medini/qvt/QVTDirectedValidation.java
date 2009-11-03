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
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.oslo.ocl20.semantics.SemanticsVisitable;
import org.oslo.ocl20.semantics.bridge.Classifier;
import org.oslo.ocl20.semantics.bridge.Property;
import org.oslo.ocl20.semantics.model.expressions.OclExpression;
import org.oslo.ocl20.semantics.model.expressions.OperationCallExp;
import org.oslo.ocl20.semantics.model.expressions.StringLiteralExp;
import org.oslo.ocl20.semantics.model.expressions.VariableDeclaration;
import org.oslo.ocl20.semantics.model.expressions.VariableExp;
import org.oslo.ocl20.semantics.model.types.CollectionType;
import org.oslo.ocl20.standard.lib.OclAnyModelElement;
import org.oslo.ocl20.syntax.parser.ErrorManager;

import uk.ac.kent.cs.kmf.util.ILog;
import de.ikv.medini.qvt.model.qvtbase.Domain;
import de.ikv.medini.qvt.model.qvtbase.Pattern;
import de.ikv.medini.qvt.model.qvtbase.Predicate;
import de.ikv.medini.qvt.model.qvtbase.Transformation;
import de.ikv.medini.qvt.model.qvtbase.TypedModel;
import de.ikv.medini.qvt.model.qvtrelation.DomainPattern;
import de.ikv.medini.qvt.model.qvtrelation.Key;
import de.ikv.medini.qvt.model.qvtrelation.Relation;
import de.ikv.medini.qvt.model.qvtrelation.RelationCallExp;
import de.ikv.medini.qvt.model.qvtrelation.RelationDomain;
import de.ikv.medini.qvt.model.qvtrelation.RelationalTransformation;
import de.ikv.medini.qvt.model.qvttemplate.ColletionTemplateExp;
import de.ikv.medini.qvt.model.qvttemplate.ObjectTemplateExp;
import de.ikv.medini.qvt.model.qvttemplate.PropertyTemplateItem;
import de.ikv.medini.qvt.model.qvttemplate.TemplateExp;

/**
 * Class for direction-dependent semantic validation. The main task of this class is to order "when" and "where" clauses for a given direction.
 * 
 * @author Omar Ekine
 * @author Joerg Kiegeland
 */
public class QVTDirectedValidation {

	/**
	 * Flag whether concatenation shall be anaylyzed to bind variables or not.
	 */
	public static final boolean enableInverseConcat = true;

	/**
	 * Computes and orders "when" clauses for direction <code>targetModel</code> of relation <code>host</code>.
	 * 
	 * @param host
	 * @param targetModel
	 * @param currentlyResolvedVariables
	 *            List containing currently resolved variables. This list is enlarged by the variables bound by the analyzed "when" clauses.
	 * @param data
	 * @param processor
	 * @param log
	 * @param whenClauses
	 *            out parameter: contains all unresolved when clauses
	 * @return
	 */
	public static List computeOrderedWhenClauses(Relation host, TypedModel targetModel, List currentlyResolvedVariables, Object data, QvtProcessorImpl processor, ILog log, List whenClauses) {

		currentlyResolvedVariables.addAll(QVTDirectedValidation.computeCurrentlyResolvedVariables(host, data, processor, targetModel));
		whenClauses.clear();
		whenClauses.addAll(QVTDirectedValidation.collectAllWhenClauses(host, targetModel, data, processor));
		List orderedWhenClauses = new ArrayList();

		boolean goOn = true;
		while (goOn) {
			goOn = false;
			for (Iterator iter = whenClauses.iterator(); iter.hasNext() && !goOn;) {
				SemanticsVisitable semanticsVisitable = (SemanticsVisitable) iter.next();
				List dependsOnVar = QVTDirectedValidation.dependsOn(semanticsVisitable, true, data, processor);
				boolean isAdded = false;
				// TODO type Check if oclExp -> type must be boolean !!!
				QVTDirectedValidation.checkBooleanType(semanticsVisitable, log, processor);

				if (QVTDirectedValidation.computeOrderedClauseForRelationCallsInAnyExpressions(semanticsVisitable, currentlyResolvedVariables, whenClauses, orderedWhenClauses, goOn, isAdded, data,
				        processor, targetModel)) {
					goOn = true;
					iter = whenClauses.iterator();
					break;
				}

				if (semanticsVisitable instanceof OperationCallExp) {
					OperationCallExp operationCallExp = (OperationCallExp) semanticsVisitable;
					boolean[] goOnAndIsAdded = QVTDirectedValidation.computeOrderedWhenClauseForOperationCall(operationCallExp, currentlyResolvedVariables, whenClauses, orderedWhenClauses, goOn,
					        isAdded, data, processor, host, targetModel);
					goOn = goOnAndIsAdded[0];
					isAdded = goOnAndIsAdded[1];

					if (goOn) {
						iter = whenClauses.iterator();
					}
				}

				if (!isAdded && semanticsVisitable instanceof PropertyTemplateItem) {
					PropertyTemplateItem propertyTemplateItem = (PropertyTemplateItem) semanticsVisitable;
					boolean[] goOnAndIsAdded = QVTDirectedValidation.computeOrderedWhenClauseForPropertyTemplate(propertyTemplateItem, currentlyResolvedVariables, whenClauses, orderedWhenClauses,
					        goOn, isAdded, processor, log);
					goOn = goOnAndIsAdded[0];
					isAdded = goOnAndIsAdded[1];

					if (goOn) {
						iter = whenClauses.iterator();
					}
				}

				if (!isAdded && QVTDirectedValidation.enableInverseConcat
				        && QVTDirectedValidation.handleEnableInverseConcat(currentlyResolvedVariables, semanticsVisitable, whenClauses, orderedWhenClauses, processor, true)) {
					goOn = true;
					iter = whenClauses.iterator();
					break;
				}

				if (currentlyResolvedVariables.containsAll(dependsOnVar) && !isAdded) {
					orderedWhenClauses.add(semanticsVisitable);
					whenClauses.remove(semanticsVisitable);
					iter = whenClauses.iterator();
					goOn = true;
					isAdded = true;
				}
			}
		}

		if (QVTDirectedValidation.enableInverseConcat && whenClauses.size() > 0) {
			QVTDirectedValidation.handleEnableInverseConcat(currentlyResolvedVariables, whenClauses, orderedWhenClauses, processor);
		}

		// add unresolved clauses in order to better analyze the errors later
		orderedWhenClauses.addAll(whenClauses);

		return orderedWhenClauses;
	}

	private static void handleEnableInverseConcat(List currentlyResolvedVariables, List whenClauses, List orderedWhenClauses, QvtProcessorImpl processor) {
		for (Iterator iter = whenClauses.iterator(); iter.hasNext();) {
			SemanticsVisitable semanticsVisitable = (SemanticsVisitable) iter.next();
			if (QVTDirectedValidation.handleEnableInverseConcat(currentlyResolvedVariables, semanticsVisitable, whenClauses, orderedWhenClauses, processor, false)) {
				iter = whenClauses.iterator();
			}
		}
	}

	private static boolean handleEnableInverseConcat(List currentlyResolvedVariables, SemanticsVisitable semanticsVisitable, List whenClauses, List orderedWhenClauses, QvtProcessorImpl processor,
	        boolean requireUniqueAssignments) {

		if (!(semanticsVisitable instanceof PropertyTemplateItem)) {
			return false;
		}

		PropertyTemplateItem propertyTemplateItem = (PropertyTemplateItem) semanticsVisitable;
		OclExpression oclExpression = propertyTemplateItem.getValue();
		List matchParts = new ArrayList();

		if (!QVTDirectedValidation.hasStringMatching(matchParts, oclExpression, processor)) {
			return false;
		}

		if (requireUniqueAssignments) {
			int assignedVars = 0;
			for (Iterator iter2 = matchParts.iterator(); iter2.hasNext();) {
				Object var = iter2.next();
				if (var instanceof VariableDeclaration) {
					assignedVars++;
				}
			}
			if (assignedVars >= 2) {
				return false;
			}

		}
		for (Iterator iter2 = matchParts.iterator(); iter2.hasNext();) {
			Object var = iter2.next();
			if (var instanceof VariableDeclaration) {
				currentlyResolvedVariables.add(var);
				processor.markAsBindingClause(semanticsVisitable, (VariableDeclaration) var);
			}
		}

		orderedWhenClauses.add(semanticsVisitable);
		whenClauses.remove(semanticsVisitable);

		return true;
	}

	private static boolean[] computeOrderedWhenClauseForPropertyTemplate(PropertyTemplateItem propertyTemplateItem, List currentlyResolvedVariables, List whenClauses, List orderedWhenClauses,
	        boolean goOn, boolean isAdded, QvtProcessorImpl processor, ILog log) {

		boolean[] goOnAndIsAdded = new boolean[] { goOn, isAdded };
		OclExpression oclExpression = propertyTemplateItem.getValue();

		if (processor.isParsingMode() && oclExpression instanceof OperationCallExp && QvtEvaluatorVisitorImpl.isRandomStringFunction((OperationCallExp) oclExpression)) {
			whenClauses.remove(propertyTemplateItem);
			goOnAndIsAdded[0] = true;
			goOnAndIsAdded[1] = true;
			return goOnAndIsAdded;
		}

		if (oclExpression instanceof VariableExp) {
			VariableExp variableExp = (VariableExp) oclExpression;

			if (!currentlyResolvedVariables.contains(variableExp.getReferredVariable())) {

				Property property = propertyTemplateItem.getReferredProperty();
				Classifier valueType = oclExpression.getType();
				if (property != null && property.getType() instanceof CollectionType && !(valueType instanceof CollectionType)) {
					ErrorManager.reportError(log, processor.getAnalyser().getSymbol(oclExpression), "SA: Variable '" + variableExp.getReferredVariable().getName()
					        + "' must be collection-typed when being bound by the collection-typed property '" + property.getName() + "'.");
				}

				orderedWhenClauses.add(propertyTemplateItem);
				whenClauses.remove(propertyTemplateItem);
				currentlyResolvedVariables.add(variableExp.getReferredVariable());
				processor.markAsBindingClause(propertyTemplateItem, variableExp.getReferredVariable());
				goOnAndIsAdded[0] = true;
				goOnAndIsAdded[1] = true;
			}
		}

		return goOnAndIsAdded;
	}

	private static boolean[] computeOrderedWhenClauseForOperationCall(OperationCallExp operationCallExp, List currentlyResolvedVariables, List whenClauses, List orderedWhenClauses, boolean goOn,
	        boolean isAdded, Object data, QvtProcessorImpl processor, Relation host, TypedModel targetModel) {

		boolean[] goOnAndIsAdded = new boolean[] { goOn, isAdded };

		if (!"=".equals(QVTDirectedValidation.getOperationName(operationCallExp))) {
			return goOnAndIsAdded;
		}

		OclExpression source = operationCallExp.getSource();
		OclExpression arg = (OclExpression) operationCallExp.getArguments().get(0);

		if (!isAdded && source instanceof VariableExp) {

			if (processor.isParsingMode() && arg instanceof OperationCallExp && QvtEvaluatorVisitorImpl.isRandomStringFunction((OperationCallExp) arg)) {
				whenClauses.remove(operationCallExp);
				goOnAndIsAdded[0] = true;
				goOnAndIsAdded[1] = true;
				return goOnAndIsAdded;
			}

			VariableExp sourceVariableExp = (VariableExp) source;
			VariableDeclaration referredVariable = sourceVariableExp.getReferredVariable();
			// TODO logic is inverse !!
			if (!currentlyResolvedVariables.contains(referredVariable) && currentlyResolvedVariables.containsAll(QVTDirectedValidation.dependsOn(arg, true, data, processor))) {
				orderedWhenClauses.add(operationCallExp);
				whenClauses.remove(operationCallExp);
				currentlyResolvedVariables.add(referredVariable);
				processor.markAsBindingClause(operationCallExp, referredVariable);
				goOnAndIsAdded[0] = true;
				goOnAndIsAdded[1] = true;
			}
		}

		if (!isAdded && arg instanceof VariableExp) {
			VariableExp argVariableExp = (VariableExp) arg;
			VariableDeclaration referredVariable = argVariableExp.getReferredVariable();
			// TODO logic is inverse !!
			if (currentlyResolvedVariables.containsAll(QVTDirectedValidation.dependsOn(source, true, data, processor))
			        && (!currentlyResolvedVariables.contains(referredVariable) || QVTDirectedValidation.collectAllTemplateVariablesInDirection(host, targetModel, data).contains(referredVariable))) {
				orderedWhenClauses.add(operationCallExp);
				whenClauses.remove(operationCallExp);
				currentlyResolvedVariables.add(referredVariable);
				processor.markAsBindingClause(operationCallExp, referredVariable);
				goOnAndIsAdded[0] = true;
				goOnAndIsAdded[1] = true;
				// swap so that alway -> var = definition !!
				operationCallExp.setSource(arg);
				operationCallExp.getArguments().clear();
				operationCallExp.getArguments().add(source);
			}
		}

		return goOnAndIsAdded;
	}

	/**
	 * Return the name of the referred operation
	 * 
	 * @param operationCallExp
	 * @return the name or <code>null</code> if the referred operation is not available
	 */
	private static String getOperationName(OperationCallExp operationCallExp) {
		if (operationCallExp.getReferredOperation() == null) {
			return "";
		}
		return operationCallExp.getReferredOperation().getName();
	}

	/**
	 * Checks and logs, that, if <code>semanticsVisitable</code> is a OCL expression, its type must be a boolean type.
	 * 
	 * @param semanticsVisitable
	 *            The expression to check
	 * @param log
	 * @param processor
	 */
	private static void checkBooleanType(SemanticsVisitable semanticsVisitable, ILog log, QvtProcessorImpl processor) {
		if (semanticsVisitable instanceof OclExpression && !(semanticsVisitable instanceof ObjectTemplateExp)) {
			OclExpression oclExp = (OclExpression) semanticsVisitable;
			if (oclExp.getType() == null || !oclExp.getType().conformsTo(processor.getTypeFactory().buildBooleanType()).booleanValue()) {
				ErrorManager.reportError(log, processor.getAnalyser().getSymbol(oclExp), "Expression is of type '" + oclExp.getType() + "', but must be of type 'Boolean'");
			}
		}
	}

	/**
	 * Determines whether <code>pattern</code> can be recognised as a concatenation of strings and constants.
	 * 
	 * @param matchParts
	 *            Concatenation items are put herein in the correct order.
	 * @param pattern
	 *            The ocl expression to be analyzed. Concantenations may be nested.
	 * @param processor
	 * @return
	 */
	public static boolean hasStringMatching(List matchParts, OclExpression pattern, QvtProcessorImpl processor) {
		if (pattern instanceof OperationCallExp) {
			OperationCallExp operationCallExp = (OperationCallExp) pattern;
			if (operationCallExp.getType().conformsTo(processor.getTypeFactory().buildStringType()).booleanValue()
			        && ("+".equals(QVTDirectedValidation.getOperationName(operationCallExp)) || "concat".equals(QVTDirectedValidation.getOperationName(operationCallExp)))) {
				OclExpression source = operationCallExp.getSource();
				OclExpression arg = (OclExpression) operationCallExp.getArguments().get(0);
				return QVTDirectedValidation.hasStringMatching(matchParts, source, processor) && QVTDirectedValidation.hasStringMatching(matchParts, arg, processor);
			}
		}
		if (pattern instanceof VariableExp) {
			matchParts.add(((VariableExp) pattern).getReferredVariable());
			return true;
		}
		if (pattern instanceof StringLiteralExp) {
			matchParts.add(pattern);
			return true;
		}
		return false;
	}

	/**
	 * Collects all "where" clauses of relation <code>relation</code>, which are {@link PropertyTemplateItem} instances of source domains or {@link OclExpression} instances of
	 * the "where {..}" statement or {@link ObjectTemplateExp} instances, which are put at the end of the list
	 * 
	 * @param relation
	 * @param direction
	 *            determines which domains are target domains
	 * @param currentlyResolvedVariables
	 * @return
	 */
	private static List collectAllWhereClauses(Relation relation, TypedModel direction, Object data, QvtProcessorImpl processor, List currentlyResolvedVariables) {
		List result = new ArrayList();
		result.addAll(QVTDirectedValidation.collectAllPropertyTemplateItemsDependingOnDirection(relation, direction, true, data, processor));
		result.addAll(QVTDirectedValidation.collectClauseExpressions(relation, relation.getWhere()));
		result.addAll(QVTDirectedValidation.collectAllObjectTemplatesOfRelationInDirection(relation, direction, data));
		return result;
	}

	/**
	 * 
	 * @param relation
	 * @param direction
	 * @param inDirection
	 * @param data
	 * @param processor
	 * @returns list of {@link PropertyTemplateItem} instances
	 */
	public static List collectAllPropertyTemplateItemsDependingOnDirection(Relation relation, TypedModel direction, boolean inDirection, Object data, QvtProcessorImpl processor) {
		List result = new ArrayList();
		List domains = relation.getDomain();

		for (Iterator iter = domains.iterator(); iter.hasNext();) {
			RelationDomain currentRelationDomain = (RelationDomain) iter.next();

			// currentRelationDomain.getTypedModel() != null -> no primitive domain
			if (currentRelationDomain.getTypedModel() == null) {
				continue;
			}

			if (currentRelationDomain.getTypedModel().equals(direction) && inDirection || !currentRelationDomain.getTypedModel().equals(direction) && !inDirection) {
				result.addAll(QVTDirectedValidation.collectAllPropertyTemplateItemsOfDomain(currentRelationDomain, data, processor));
			}
		}
		return result;
	}

	/**
	 * Returns all {@link VariableDeclaration} instances of relation <code>host</code> which are bound by source domain templates
	 * 
	 * @param host
	 * @param data
	 * @param processor
	 * @return
	 */
	private static List computeCurrentlyResolvedVariables(Relation host, Object data, QvtProcessorImpl processor, TypedModel targetModel) {
		if (!processor.isCleanMode()) {
			return QVTDirectedValidation.collectAllTemplateVariables(host, data, processor);
		} else {
			return QVTDirectedValidation.collectAllTemplateVariablesNotInDirection(host, targetModel, data, processor);
		}
	}

	/**
	 * Determines whether <code>currentVariable</code> should be instantiated (true) or bound by relation calls (false) when enforcing the target domain
	 * 
	 * @param relation
	 * @param currentVariable
	 * @param data
	 * @param targetModel
	 * @param processor
	 * @return
	 */
	public static boolean shouldBeInstantiatedInThisRelation(Relation relation, VariableDeclaration currentVariable, Map data, TypedModel targetModel, QvtProcessorImpl processor) {
		Collection allWhereClauseRelationCallsHavingVariableInTarget = QVTDirectedValidation.collectAllRelationCallsInWhereClauseWithVariableInTarget(relation, currentVariable.getName(), targetModel,
		        data);
		Collection relationCalls = QVTDirectedValidation.getRelationCallsWithDomainVariableTypeSubtypeOfVariable(currentVariable, currentVariable.getType(),
		        allWhereClauseRelationCallsHavingVariableInTarget, !processor.getQvtModelManipulationAdaper().isAbstract(currentVariable.getType()));
		return relationCalls.isEmpty();
	}

	/**
	 * Return all {@link VariableDeclaration} instances bound by {@link ObjectTemplateExp} instances of relation <code>relation</code>
	 * 
	 * @param relation
	 * @param data
	 * @param processor
	 * @return
	 */
	public static List collectAllTemplateVariables(Relation relation, Object data, QvtProcessorImpl processor) {
		List domains = relation.getDomain();
		List result = new ArrayList();
		for (Iterator iter = domains.iterator(); iter.hasNext();) {
			RelationDomain currentRelationDomain = (RelationDomain) iter.next();
			result.addAll(QVTDirectedValidation.collectAllTemplateVariables(currentRelationDomain, data));
		}
		return result;
	}

	/**
	 * Return all {@link VariableDeclaration} instances bound by {@link ObjectTemplateExp} instances of relation domain <code>relationDomain</code>
	 * 
	 * @param relationDomain
	 * @param data
	 * @param processor
	 * @return
	 */
	// TODO tricky remofe this for primitive domains !!!
	public static List collectAllTemplateVariables(RelationDomain relationDomain, Object data) {
		List result = new ArrayList();
		if (relationDomain.getTypedModel() != null) {
			QvtTemplateExpressionFinderVisitorImpl qvtTemplateExpressionFinderVisitor = new QvtTemplateExpressionFinderVisitorImpl();
			relationDomain.getPattern().getTemplateExpression().accept(qvtTemplateExpressionFinderVisitor, data);
			List templateExpressions = qvtTemplateExpressionFinderVisitor.getTemplateExpressions();
			for (Iterator iterator = templateExpressions.iterator(); iterator.hasNext();) {
				TemplateExp currentTemplateExp = (TemplateExp) iterator.next();
				if (currentTemplateExp instanceof ObjectTemplateExp) {
					ObjectTemplateExp currentObjectTemplateExp = (ObjectTemplateExp) currentTemplateExp;
					VariableDeclaration bindsTo = currentObjectTemplateExp.getBindsTo();
					result.add(bindsTo);
				} else if (currentTemplateExp instanceof ColletionTemplateExp) {
					throw new RuntimeException("NYI");
				} else {
					throw new RuntimeException("NYI");
				}
			}
		} else {
			result.add(relationDomain.getRootVariable());
		}
		return result;
	}

	/**
	 * Collect all {@link VariableDeclaration} instances of relation <code>relation</code> of domains having the direction <code>direction</code>.
	 * 
	 * @param relation
	 * @param direction
	 * @param data
	 * @param processor
	 * @return a list of {@link VariableDeclaration} instances
	 */
	public static List collectAllTemplateVariablesInDirection(Relation relation, TypedModel direction, Object data) {
		List domains = relation.getDomain();
		List result = new ArrayList();

		for (Iterator iter = domains.iterator(); iter.hasNext();) {
			RelationDomain currentRelationDomain = (RelationDomain) iter.next();

			if (direction.equals(currentRelationDomain.getTypedModel())) {
				result.addAll(QVTDirectedValidation.collectAllTemplateVariables(currentRelationDomain, data));
			}
		}
		return result;
	}

	/**
	 * Collect all {@link VariableDeclaration} instances of relation <code>relation</code> of domains not having the direction <code>direction</code>.
	 * 
	 * @param relation
	 * @param direction
	 * @param data
	 * @param processor
	 * @return a list of {@link VariableDeclaration} instances
	 */
	public static List collectAllTemplateVariablesNotInDirection(Relation relation, TypedModel direction, Object data, QvtProcessorImpl processor) {
		List domains = relation.getDomain();
		List result = new ArrayList();

		for (Iterator iter = domains.iterator(); iter.hasNext();) {
			RelationDomain currentRelationDomain = (RelationDomain) iter.next();

			if (!direction.equals(currentRelationDomain.getTypedModel())) {
				result.addAll(QVTDirectedValidation.collectAllTemplateVariables(currentRelationDomain, data));
			}
		}
		return result;
	}

	/**
	 * 
	 * Collects all "when" domain expressions of relation <code>relation</code>, which are {@link PropertyTemplateItem} instances of source domains and {@link OclExpression}
	 * instances of the when clause.
	 * 
	 * @param relation
	 * @param direction
	 *            determines which domains are source domains
	 * @param data
	 * @param processor
	 * @return
	 */
	private static List collectAllWhenClauses(Relation relation, TypedModel direction, Object data, QvtProcessorImpl processor) {

		List result = QVTDirectedValidation.collectAllPropertyTemplateItemsDependingOnDirection(relation, direction, false, data, processor);
		result.addAll(QVTDirectedValidation.collectClauseExpressions(relation, relation.getWhen()));
		return result;
	}

	private static Collection collectClauseExpressions(Relation relation, Pattern pattern) {
		List result = new ArrayList();

		if (pattern == null) {
			return result;
		}

		List predicates = pattern.getPredicate();

		for (Iterator iter = predicates.iterator(); iter.hasNext();) {
			Predicate currentPredicate = (Predicate) iter.next();
			OclExpression contitionExpression = currentPredicate.getContitionExpression();
			result.add(contitionExpression);
		}

		return result;
	}

	/**
	 * 
	 * @param currentRelationDomain
	 * @param data
	 * @param processor
	 * @return returns list of {@link PropertyTemplateItem} instances
	 */
	private static Collection collectAllPropertyTemplateItemsOfDomain(RelationDomain currentRelationDomain, Object data, QvtProcessorImpl processor) {

		List result = new ArrayList();
		DomainPattern domainPattern = currentRelationDomain.getPattern();
		TemplateExp currentTemplateExpression = domainPattern.getTemplateExpression();
		QvtTemplateExpressionFinderVisitorImpl qvtTemplateExpressionFinderVisitor = new QvtTemplateExpressionFinderVisitorImpl();
		currentTemplateExpression.accept(qvtTemplateExpressionFinderVisitor, data);
		List templateExpressions = qvtTemplateExpressionFinderVisitor.getTemplateExpressions();

		for (Iterator iterator = templateExpressions.iterator(); iterator.hasNext();) {
			TemplateExp currentTemplateExp = (TemplateExp) iterator.next();

			if (currentTemplateExp instanceof ObjectTemplateExp) {
				ObjectTemplateExp currentObjectTemplateExp = (ObjectTemplateExp) currentTemplateExp;
				List propertyTemplateItems = currentObjectTemplateExp.getPart();

				for (Iterator propertyTemplateItemsIterator = propertyTemplateItems.iterator(); propertyTemplateItemsIterator.hasNext();) {
					PropertyTemplateItem currentPropertyTemplateItem = (PropertyTemplateItem) propertyTemplateItemsIterator.next();
					result.add(currentPropertyTemplateItem);
				}
			} else if (currentTemplateExp instanceof ColletionTemplateExp) {
				throw new RuntimeException("Collection Templates are not yet supported.");
			} else {
				throw new RuntimeException("Unsupported template type: " + currentTemplateExp.getClass().getName());
			}
		}

		return result;
	}

	/**
	 * Computes and orders "where" clauses for direction <code>targetModel</code> of relation <code>host</code>.
	 * 
	 * @param host
	 * @param targetModel
	 * @param currentlyResolvedVariables
	 *            List containing currently resolved variables. This list is enlarged by the variables bound by the analyzed "where" clauses.
	 * @param data
	 * @param processor
	 * @param log
	 * @return
	 */
	public static List computeOrderedWhereClauses(Relation host, final TypedModel targetModel, List currentlyResolvedVariables, final Object data, final QvtProcessorImpl processor, ILog log) {

		// A SemanticsVisitable to List<VariableDeclaration> map: saves for every clause the variables which are resolved before this clause.
		Map saveResolvedVars = new HashMap();

		// A SemanticsVisitable to List<SemanticsVisitable> map: Each clause of orderedWhereClauses can have a set of clauses from which each resolves the same variable(s)
		Map clauseToSameResolvingClauses = new HashMap();

		currentlyResolvedVariables = new ArrayList(currentlyResolvedVariables);

		if (!processor.isCleanMode()) {
			// a target object template' variable shall be bound by e.g. relation calls or by instantiation represented by
			// its object template, so remove them here
			currentlyResolvedVariables.removeAll(QVTDirectedValidation.collectAllTemplateVariablesInDirection(host, targetModel, data));
		} else {
			// even if we are in clean mode, a assigned target object template variable may still be undefined when "undefined" was assigned e.g. by a statement
			// "targetVar=undefined".
			// TODO: there are two groups of assignments: those which are assigned anything and those which are are assigned anything except "undefined". The
			// current implementation only knows the first group. To do it better, we should also know the second group of bound variables.
			currentlyResolvedVariables.removeAll(QVTDirectedValidation.collectAllTemplateVariablesInDirection(host, targetModel, data));
		}

		List whereClauses = QVTDirectedValidation.collectAllWhereClauses(host, targetModel, data, processor, currentlyResolvedVariables);
		ArrayList orderedWhereClauses = new ArrayList();

		boolean goOn = true;
		while (goOn) {
			goOn = false;
			for (Iterator iter = whereClauses.iterator(); iter.hasNext() && !goOn;) {
				SemanticsVisitable semanticsVisitable = (SemanticsVisitable) iter.next();
				List dependsOnVar = QVTDirectedValidation.dependsOn(semanticsVisitable, false, /* targetModel, */data, processor);
				boolean isAdded = false;

				QVTDirectedValidation.checkBooleanType(semanticsVisitable, log, processor);
				List oldCurrentlyResolvedVariables = new ArrayList(currentlyResolvedVariables);
				saveResolvedVars.put(semanticsVisitable, oldCurrentlyResolvedVariables);

				if (QVTDirectedValidation.computeOrderedClauseForRelationCallsInAnyExpressions(semanticsVisitable, currentlyResolvedVariables, whereClauses, orderedWhereClauses, goOn, isAdded, data,
				        processor, targetModel)) {
					goOn = true;
					iter = whereClauses.iterator();
					break;
				}

				if (semanticsVisitable instanceof OperationCallExp) {
					OperationCallExp operationCallExp = (OperationCallExp) semanticsVisitable;
					boolean[] goOnAndIsAdded = QVTDirectedValidation.computeOrderedWhereClauseForOperationCall(operationCallExp, currentlyResolvedVariables, whereClauses, orderedWhereClauses, goOn,
					        isAdded, data, processor);
					goOn = goOnAndIsAdded[0];
					isAdded = goOnAndIsAdded[1];

					if (goOn) {
						iter = whereClauses.iterator();
					}
				}

				if (semanticsVisitable instanceof ObjectTemplateExp) {
					ObjectTemplateExp template = (ObjectTemplateExp) semanticsVisitable;
					VariableDeclaration referredVariable = template.getBindsTo();
					List currentlyResolvedVariablesWithMe = new ArrayList(currentlyResolvedVariables);
					currentlyResolvedVariablesWithMe.add(referredVariable);

					if (currentlyResolvedVariablesWithMe.containsAll(dependsOnVar)) {
						if (!currentlyResolvedVariables.contains(referredVariable)) {
							if (processor.isParsingMode()) {
								/*
								 * We give only a warning, since instead of object creation, there can be following cases at execution time:
								 * 
								 * 1. Bound by key
								 * 
								 * 2. Bound by relation parameter
								 * 
								 * 3. Bound by ignored relation calls
								 */
								ErrorManager.reportWarning(log, processor.getAnalyser().getSymbol(semanticsVisitable), "In QVT parsing mode, element creation by the object template '"
								        + referredVariable.getName() + "' in relation " + host.getName() + " will not be permitted!");
							}
							if (processor.getQvtModelManipulationAdaper().isAbstract(referredVariable.getType())) {
								ErrorManager.reportWarning(log, processor.getAnalyser().getSymbol(semanticsVisitable), "Instantiation of an abstract metaclass '" + referredVariable.getType()
								        + "' for variable '" + referredVariable.getName() + "' in relation '" + host.getName() + "' will fail!");

							}
							orderedWhereClauses.add(semanticsVisitable);
							whereClauses.remove(semanticsVisitable);
							currentlyResolvedVariables.add(referredVariable);
							processor.markAsBindingClause(semanticsVisitable, referredVariable);
							goOn = true;
							iter = whereClauses.iterator();
							break;
						}
					}
				}

				if (semanticsVisitable instanceof PropertyTemplateItem) {
					PropertyTemplateItem propertyTemplateItem = (PropertyTemplateItem) semanticsVisitable;
					Property prop = propertyTemplateItem.getReferredProperty();
					if (prop != null && !processor.getQvtModelManipulationAdaper().isChangeable(prop)) {
						ErrorManager.reportWarning(log, processor.getAnalyser().getSymbol(semanticsVisitable), "The property '" + prop.getName() + "' is not changeable!");
					}
				}

				if (currentlyResolvedVariables.containsAll(dependsOnVar) && !isAdded) {
					List resolvedVars = new ArrayList();

					// check whether there exists a clause resolving the same variables
					if (QVTDirectedValidation.getResolvingVariables(semanticsVisitable, resolvedVars, data, processor, targetModel)) {
						for (Iterator varIter = resolvedVars.iterator(); varIter.hasNext();) {
							VariableDeclaration varDecl = (VariableDeclaration) varIter.next();
							SemanticsVisitable clause = processor.getBindingClause(varDecl);
							if (clause != null && orderedWhereClauses.contains(clause)/* filter when clauses! */) {
								List formerResolvedVars = (List) saveResolvedVars.get(clause);
								List dependsOnVar2 = new ArrayList(dependsOnVar);
								dependsOnVar2.removeAll(resolvedVars); // since of ObjectTemplateExp adding its on var as dependency
								if (formerResolvedVars.containsAll(dependsOnVar2)) {
									List clauses = (List) clauseToSameResolvingClauses.get(clause);
									if (clauses == null) {
										clauses = new ArrayList();
										clauseToSameResolvingClauses.put(clause, clauses);
										clauses.add(clause);
									}
									clauses.add(semanticsVisitable);
									isAdded = true;
									break;
								}
							}
						}
					}

					if (!isAdded) {
						orderedWhereClauses.add(semanticsVisitable);
					}
					whereClauses.remove(semanticsVisitable);
					iter = whereClauses.iterator();
					goOn = true;
					isAdded = true;
				}
			}
		}

		for (Iterator iterClause = clauseToSameResolvingClauses.keySet().iterator(); iterClause.hasNext();) {
			SemanticsVisitable representativeClause = (SemanticsVisitable) iterClause.next();
			List clauses = (List) clauseToSameResolvingClauses.get(representativeClause);
			final List definedVars = (List) saveResolvedVars.get(representativeClause);

			QVTDirectedValidation.sortClausesByTypeSpecialization(targetModel, data, processor, clauses, definedVars);

			int insertIndex = orderedWhereClauses.indexOf(representativeClause);
			orderedWhereClauses.remove(representativeClause);
			List allResolvedVars = new ArrayList(definedVars);

			// now put the clauses into the orderedWhereClauses back
			for (Iterator clausesIter = clauses.iterator(); clausesIter.hasNext();) {
				SemanticsVisitable aClause = (SemanticsVisitable) clausesIter.next();
				List oldResolvedVars = new ArrayList(allResolvedVars);
				QVTDirectedValidation.getResolvingVariables(aClause, allResolvedVars, data, processor, targetModel);
				List newResolvedVars = new ArrayList(allResolvedVars);
				newResolvedVars.removeAll(oldResolvedVars);
				processor.markAsBindingClause(aClause, newResolvedVars);
				orderedWhereClauses.add(insertIndex, aClause);
				insertIndex++;
			}

		}

		for (Iterator iter = whereClauses.iterator(); iter.hasNext();) {
			SemanticsVisitable clause = (SemanticsVisitable) iter.next();
			String unresolvedVar = QVTDirectedValidation.getUnresolvedVar(clause, currentlyResolvedVariables, data, processor);
			ErrorManager.reportError(log, processor.getAnalyser().getSymbol(clause), "where clause of relation '" + host.getName() + "' could not be resolved" + unresolvedVar + "!");
		}

		// add unresolved clauses in order to better analyze the errors later
		orderedWhereClauses.addAll(whereClauses);

		return orderedWhereClauses;
	}

	/**
	 * Sorts the given clauses by the specialization of the variables they resolve
	 * 
	 * @param targetModel
	 * @param data
	 * @param processor
	 * @param clauses
	 *            the clauses to sort
	 * @param definedVars
	 *            these variables are not looked at
	 */
	private static void sortClausesByTypeSpecialization(final TypedModel targetModel, final Object data, final QvtProcessorImpl processor, List clauses, final List definedVars) {
		Collections.sort(clauses, new Comparator() {

			public int compare(Object o1, Object o2) {
				SemanticsVisitable clause1 = (SemanticsVisitable) o1; // return -1 to favor it
				SemanticsVisitable clause2 = (SemanticsVisitable) o2; // return 1 to favor it
				List resolvedVars = new ArrayList();
				QVTDirectedValidation.getResolvingVariables(clause1, resolvedVars, data, processor, targetModel);
				QVTDirectedValidation.getResolvingVariables(clause2, resolvedVars, data, processor, targetModel);
				for (Iterator varIter = resolvedVars.iterator(); varIter.hasNext();) {
					VariableDeclaration varDecl = (VariableDeclaration) varIter.next();
					if (definedVars.contains(varDecl)) {
						continue;
					}
					Classifier classifier1 = this.getMostSpecific(clause1, varDecl);
					Classifier classifier2 = this.getMostSpecific(clause2, varDecl);
					if (classifier1 != null && classifier2 != null) {
						if (QVTDirectedValidation.isSubTypeOf(classifier1, classifier2, true)) {
							return 1;
						}
						if (QVTDirectedValidation.isSubTypeOf(classifier2, classifier1, true)) {
							return -1;
						}
						// now, both classifiers are equal
						if (processor.getQvtModelManipulationAdaper().isAbstract(classifier1)) {
							// we cannot instantiate abstract metaclasses, so let the relation call create the element
							if (clause1 instanceof ObjectTemplateExp) {
								return 1;
							} else if (clause2 instanceof ObjectTemplateExp) {
								return -1;
							}
						} else {
							// in the non-abstract case, let the relation itself create the element
							if (clause1 instanceof ObjectTemplateExp) {
								return -1;
							} else if (clause2 instanceof ObjectTemplateExp) {
								return 1;
							}
						}
					}
				}
				return 0;
			}

			private Classifier getMostSpecific(SemanticsVisitable clause, VariableDeclaration variableDeclaration) {

				if (clause instanceof ObjectTemplateExp) {
					return ((ObjectTemplateExp) clause).getType();
				}

				Classifier result = null;
				Collection relationCalls = QVTDirectedValidation.extractRelationCalls(clause, data);
				for (Iterator iter = relationCalls.iterator(); iter.hasNext();) {
					RelationCallExp currentRelationCall = (RelationCallExp) iter.next();
					Relation relation = currentRelationCall.getReferredRelation();
					int indexOfVariable = QVTDirectedValidation.getIndexOfVariable(currentRelationCall, variableDeclaration.getName());
					if (indexOfVariable == -1) {
						continue;
					}
					RelationDomain relationDomain = (RelationDomain) relation.getDomain().get(indexOfVariable);
					if (!(QvtProcessorImpl.respectCheckOnlyFlag() && relationDomain.isIsCheckable())) {
						Classifier domainType = relationDomain.getRootVariable().getType();
						if (result == null || QVTDirectedValidation.isSubTypeOf(result, domainType, true)) {
							result = domainType;
						}
					}
				}

				return result;
			}
		});
	}

	/**
	 * Tells whether the given VariableDeclaration is always resolved to a not-undefined value
	 * 
	 * @param referredVariable
	 * @param processor
	 * @param targetModel
	 * @return
	 */
	private static boolean isResolvedValueAlwaysDefined(VariableDeclaration varDecl, QvtProcessorImpl processor, TypedModel targetModel) {
		SemanticsVisitable expression = processor.getBindingClause(varDecl);
		List vars = QVTDirectedValidation.getOrderedClauseForRelationCalls(expression, processor, new ArrayList(), targetModel);
		if (vars != null && vars.contains(varDecl)) {
			return true;
		}
		if (expression instanceof ObjectTemplateExp) {
			return true;
		}
		return false;
	}

	/**
	 * Returns the list of variable declarations which are bound by a relation call with respect to the given target model
	 * 
	 * @param relationCallExp
	 * @param currentlyResolvedVariables
	 * @param targetModel
	 * @return a list of <code>VariableDeclaration</code> instances
	 */
	private static List getVariablesBoundByRelationCall(RelationCallExp relationCallExp, List currentlyResolvedVariables, TypedModel targetModel) {

		List result = new ArrayList();
		Relation referredRelation = relationCallExp.getReferredRelation();
		Iterator domainIter = referredRelation.getDomain().iterator();
		List args = relationCallExp.getArgument();

		for (Iterator iterator = args.iterator(); iterator.hasNext();) {
			OclExpression currentArg = (OclExpression) iterator.next();
			RelationDomain relationDomain = (RelationDomain) domainIter.next();

			if (targetModel.equals(relationDomain.getTypedModel())) {

				if (currentArg instanceof VariableExp) {
					VariableExp currentVariableExp = (VariableExp) currentArg;

					if (!currentlyResolvedVariables.contains(currentVariableExp.getReferredVariable())) {
						result.add(currentVariableExp.getReferredVariable());
					}
				}
			}
		}

		return result;
	}

	/**
	 * Finds nested relation calls in "or" expressions recursively.
	 * 
	 * @param boundVariables
	 *            for each found relation call the bound variables are added, so its a list of a list of <code>VariableDeclaration</code> instances
	 * @param pattern
	 *            the OCL expression to analyze
	 * @param processor
	 * @param currentlyResolvedVariables
	 * @param targetModel
	 * @return true iff the analysed OCL expresssion only contains relation calls, which are only allowed to be connected by "or"
	 */
	public static boolean findNestedRelationCalls(List boundVariables, SemanticsVisitable pattern, QvtProcessorImpl processor, List currentlyResolvedVariables, TypedModel targetModel) {
		if (pattern instanceof OperationCallExp) {
			OperationCallExp operationCallExp = (OperationCallExp) pattern;
			if (operationCallExp.getType() != null && operationCallExp.getType().conformsTo(processor.getTypeFactory().buildBooleanType()).booleanValue()
			        && "or".equals(QVTDirectedValidation.getOperationName(operationCallExp))) {
				OclExpression source = operationCallExp.getSource();
				OclExpression arg = (OclExpression) operationCallExp.getArguments().get(0);
				return QVTDirectedValidation.findNestedRelationCalls(boundVariables, source, processor, currentlyResolvedVariables, targetModel)
				        && QVTDirectedValidation.findNestedRelationCalls(boundVariables, arg, processor, currentlyResolvedVariables, targetModel);
			}
			if (operationCallExp.getType() != null && operationCallExp.getType().conformsTo(processor.getTypeFactory().buildBooleanType()).booleanValue()
			        && "and".equals(QVTDirectedValidation.getOperationName(operationCallExp))) {
				OclExpression source = operationCallExp.getSource();
				OclExpression arg = (OclExpression) operationCallExp.getArguments().get(0);
				List originalBoundVariables = new ArrayList(boundVariables);
				if (QVTDirectedValidation.findNestedRelationCalls(boundVariables, source, processor, currentlyResolvedVariables, targetModel)) {
					// we do not look at the second expression
					return true;
				}
				// restore state, as if first expression was never looked at, and rely on the second expression
				boundVariables.clear();
				boundVariables.addAll(originalBoundVariables);
				return QVTDirectedValidation.findNestedRelationCalls(boundVariables, arg, processor, currentlyResolvedVariables, targetModel);
			}
		}
		if (pattern instanceof RelationCallExp) {
			boundVariables.add(QVTDirectedValidation.getVariablesBoundByRelationCall((RelationCallExp) pattern, currentlyResolvedVariables, targetModel));
			return true;
		}
		return false;
	}

	/**
	 * 
	 * Calculates in currentlyResolvedVariables all variables bound by relation calls found in the given pattern, also considering {@link ObjectTemplateExp} as pattern
	 * 
	 * @param pattern
	 * @param currentlyResolvedVariables
	 * @param data
	 * @param processor
	 * @param targetModel
	 * @return
	 */
	public static boolean getResolvingVariables(SemanticsVisitable pattern, List currentlyResolvedVariables, Object data, QvtProcessorImpl processor, TypedModel targetModel) {
		if (pattern instanceof ObjectTemplateExp) {
			currentlyResolvedVariables.add(((ObjectTemplateExp) pattern).getBindsTo());
			return true;
		}
		return QVTDirectedValidation.computeOrderedClauseForRelationCallsInAnyExpressions(pattern, currentlyResolvedVariables, null, null, false, false, data, processor, targetModel);
	}

	/**
	 * 
	 * Calculates in currentlyResolvedVariables all variables bound by relation calls found in the given pattern
	 * 
	 * @param pattern
	 * @param currentlyResolvedVariables
	 * @param whereClauses
	 * @param orderedWhereClauses
	 * @param goOn
	 * @param isAdded
	 * @param data
	 * @param processor
	 * @param targetModel
	 * @return
	 */
	public static boolean computeOrderedClauseForRelationCallsInAnyExpressions(SemanticsVisitable pattern, List currentlyResolvedVariables, List whereClauses, List orderedWhereClauses, boolean goOn,
	        boolean isAdded, Object data, QvtProcessorImpl processor, TypedModel targetModel) {

		if (orderedWhereClauses != null && !currentlyResolvedVariables.containsAll(QVTDirectedValidation.dependsOn(pattern, true, data, processor))) {
			return false;
		}

		Collection result = new HashSet();

		Collection relationCallExpressions = QVTDirectedValidation.extractRelationCalls(pattern, data);

		for (Iterator iterator = relationCallExpressions.iterator(); iterator.hasNext();) {
			RelationCallExp currentRelationCall = (RelationCallExp) iterator.next();
			result.addAll(QVTDirectedValidation.getVariablesBoundByRelationCall(currentRelationCall, currentlyResolvedVariables, targetModel));
		}

		if (!result.isEmpty()) {
			if (orderedWhereClauses != null) {
				orderedWhereClauses.add(pattern);
				processor.markAsBindingClause(pattern, new ArrayList(result));
				whereClauses.remove(pattern);
			}
			currentlyResolvedVariables.addAll(result);
			return true;
		}

		return false;
	}

	/**
	 * Returns a collection of all {@link RelationCallExp} instances in the given pattern
	 * 
	 * @param pattern
	 * @param data
	 * @return
	 */
	private static Collection extractRelationCalls(SemanticsVisitable pattern, Object data) {
		QvtRelationCallExpressionFinderVisitorImpl relationCallFinderVisitor = new QvtRelationCallExpressionFinderVisitorImpl();
		pattern.accept(relationCallFinderVisitor, data);
		Collection relationCallExpressions = relationCallFinderVisitor.getRelationCallExpressions();
		return relationCallExpressions;
	}

	private static boolean computeOrderedClauseForRelationCalls(SemanticsVisitable pattern, List currentlyResolvedVariables, List whereClauses, List orderedWhereClauses, boolean goOn,
	        boolean isAdded, Object data, QvtProcessorImpl processor, TypedModel targetModel) {

		List boundVariablesByOneRelation = QVTDirectedValidation.getOrderedClauseForRelationCalls(pattern, processor, currentlyResolvedVariables, targetModel);
		if (boundVariablesByOneRelation != null) {
			orderedWhereClauses.add(pattern);
			whereClauses.remove(pattern);
			currentlyResolvedVariables.addAll(boundVariablesByOneRelation);
			processor.markAsBindingClause(pattern, boundVariablesByOneRelation);
			return true;
		}

		return false;
	}

	private static List getOrderedClauseForRelationCalls(SemanticsVisitable pattern, QvtProcessorImpl processor, List currentlyResolvedVariables, TypedModel targetModel) {

		List boundVariables = new ArrayList();
		if (QVTDirectedValidation.findNestedRelationCalls(boundVariables, pattern, processor, currentlyResolvedVariables, targetModel)) {
			if (boundVariables.isEmpty()) {
				// should not happen, but handle it anyway!
				return null;
			}
			if (boundVariables.contains(new ArrayList())) {
				// at least one relation call does not bind an unbound variable
				return null;
			}
			List boundVariablesByOneRelation = (List) boundVariables.get(0);
			for (Iterator iter = boundVariables.iterator(); iter.hasNext();) {
				List boundVariablesByAnotherRelation = (List) iter.next();
				if (!boundVariablesByOneRelation.equals(boundVariablesByAnotherRelation)) {
					// all relation calls must bind the same set of variables, so return false
					return null;
				}
			}
			return boundVariablesByOneRelation;
		}

		return null;
	}

	private static boolean[] computeOrderedWhereClauseForOperationCall(OperationCallExp operationCallExp, List currentlyResolvedVariables, List whereClauses, ArrayList orderedWhereClauses,
	        boolean goOn, boolean isAdded, Object data, QvtProcessorImpl processor) {

		boolean[] goOnAndIsAdded = new boolean[] { goOn, isAdded };

		if (!"=".equals(QVTDirectedValidation.getOperationName(operationCallExp))) {
			return goOnAndIsAdded;
		}

		OclExpression source = operationCallExp.getSource();
		OclExpression arg = (OclExpression) operationCallExp.getArguments().get(0);

		if (!isAdded && source instanceof VariableExp) {
			VariableExp sourceVariableExp = (VariableExp) source;
			VariableDeclaration referredVariable = sourceVariableExp.getReferredVariable();
			// TODO logic is inverse !!
			if (!currentlyResolvedVariables.contains(referredVariable) && currentlyResolvedVariables.containsAll(QVTDirectedValidation.dependsOn(arg, false, data, processor))) {
				orderedWhereClauses.add(operationCallExp);
				whereClauses.remove(operationCallExp);
				currentlyResolvedVariables.add(referredVariable);
				processor.markAsBindingClause(operationCallExp, referredVariable);
				goOnAndIsAdded[0] = true;
				goOnAndIsAdded[1] = true;
			}
		}

		if (!isAdded && arg instanceof VariableExp) {
			VariableExp argVariableExp = (VariableExp) arg;
			VariableDeclaration referredVariable = argVariableExp.getReferredVariable();
			// TODO logic is inverse !!
			if (currentlyResolvedVariables.containsAll(QVTDirectedValidation.dependsOn(source, false, data, processor)) && !currentlyResolvedVariables.contains(referredVariable)) {
				orderedWhereClauses.add(operationCallExp);
				whereClauses.remove(operationCallExp);
				currentlyResolvedVariables.add(referredVariable);
				processor.markAsBindingClause(operationCallExp, referredVariable);
				goOnAndIsAdded[0] = true;
				goOnAndIsAdded[1] = true;
				// swap so that alway -> var = definition !!
				operationCallExp.setSource(arg);
				operationCallExp.getArguments().clear();
				operationCallExp.getArguments().add(source);
			}
		}

		return goOnAndIsAdded;
	}

	/**
	 * Finds the {@link ObjectTemplateExp} instance owned by of <code>template</code> which uses property <code>prop</code>
	 * 
	 * @param template
	 * @param prop
	 * @return the found {@link ObjectTemplateExp} instance or null otherwise
	 */
	public static PropertyTemplateItem getPropertyTemplateItemFor(ObjectTemplateExp template, Property prop) {
		for (Iterator propertyTemplateItemsIterator = template.getPart().iterator(); propertyTemplateItemsIterator.hasNext();) {
			PropertyTemplateItem currentPropertyTemplateItem = (PropertyTemplateItem) propertyTemplateItemsIterator.next();
			if (currentPropertyTemplateItem.getReferredProperty() == prop) {
				return currentPropertyTemplateItem;
			}
		}
		return null;
	}

	/**
	 * Finds suitable keys for object template <code>template</code>
	 * 
	 * @param template
	 * @param transformation
	 *            transformation which contains the keys
	 * @param processor
	 * @return list of {@link QVTSuitableKey} instances
	 */
	static public List findSuitableKeys(ObjectTemplateExp template, Transformation transformation, QvtProcessorImpl processor) {
		List result = new ArrayList();
		EList keys = ((RelationalTransformation) transformation).getOwnedKey();
		for (Iterator iter = keys.iterator(); iter.hasNext();) {
			Key key = (Key) iter.next();
			if (template.getType().conformsTo(key.getIdentifies()).booleanValue()) {
				QVTSuitableKey suitableKey = new QVTSuitableKey(key, template);
				for (Iterator iterator = key.getPart().iterator(); iterator.hasNext();) {
					Property prop = (Property) iterator.next();
					PropertyTemplateItem currentPropertyTemplateItem = QVTDirectedValidation.getPropertyTemplateItemFor(template, prop);
					if (currentPropertyTemplateItem == null) {
						if (template.eContainer() instanceof PropertyTemplateItem) {
							Property prop2 = ((PropertyTemplateItem) template.eContainer()).getReferredProperty();
							if (prop2 != null && processor.getQvtModelManipulationAdaper().isOpposite(prop, prop2)) {
								suitableKey.setUseOppositeProperty(true);
								continue;
							}
						}
						suitableKey = null;
						break;
					}
				}
				if (suitableKey != null) {
					result.add(suitableKey);
				}
			}
		}
		return result;
	}

	/**
	 * 
	 * @param template
	 * @param processor
	 * @return list of {@link QVTSuitableKey} instances
	 */
	static public List findSuitableKeys(ObjectTemplateExp template, QvtProcessorImpl processor) {
		return QVTDirectedValidation.findSuitableKeys(template, QVTDirectedValidation.getTransformationOf(template), processor);

	}

	/**
	 * List all {@link VariableDeclaration} instances referred to in expression <code>semanticsVisitable</code>.
	 * 
	 * @param semanticsVisitable
	 * @param isWhen
	 * @param data
	 * @param processor
	 * @param relation
	 * @return
	 */
	public static List dependsOn(SemanticsVisitable semanticsVisitable, boolean isWhen, Object data, QvtProcessorImpl processor) {
		if (semanticsVisitable instanceof ObjectTemplateExp) {
			ObjectTemplateExp template = (ObjectTemplateExp) semanticsVisitable;
			List result = new ArrayList();
			result.add(template.getBindsTo());
			List suitableKeys = QVTDirectedValidation.findSuitableKeys(template, processor);
			if (suitableKeys.size() >= 2) {
				String s = "";
				for (Iterator iter = suitableKeys.iterator(); iter.hasNext();) {
					QVTSuitableKey suitableKey = (QVTSuitableKey) iter.next();
					s += ("".equals(s) ? "" : ", ") + suitableKey.getKey().getIdentifies().getName();
				}
				ErrorManager.reportWarning(processor.getLog(), processor.getAnalyser().getSymbol(template), "Found " + suitableKeys.size() + " suitable keys for types " + s
				        + " for current object template, they are applied in this order at evaluation time");
			}
			for (Iterator iter = suitableKeys.iterator(); iter.hasNext();) {
				QVTSuitableKey suitableKey = (QVTSuitableKey) iter.next();
				for (Iterator iterator2 = suitableKey.getKey().getPart().iterator(); iterator2.hasNext();) {
					Property prop = (Property) iterator2.next();
					PropertyTemplateItem propertyTemplateItem = QVTDirectedValidation.getPropertyTemplateItemFor(template, prop);
					if (propertyTemplateItem != null) {
						OclExpression valueExp = propertyTemplateItem.getValue();
						if (valueExp instanceof ObjectTemplateExp) {
							result.add(((ObjectTemplateExp) valueExp).getBindsTo());
						} else {
							result.addAll(QVTDirectedValidation.dependsOn(valueExp, isWhen, data, processor));
						}
					}
				}
				if (suitableKey.getUseOppositeProperty()) {
					PropertyTemplateItem propertyTemplateItem = (PropertyTemplateItem) template.eContainer();
					VariableDeclaration currentTargetVar = propertyTemplateItem.getObjContainer().getBindsTo();
					result.add(currentTargetVar);
				}
			}
			return result;
		}

		QvtVariableAccessFinderVisitorImpl qvtVariableAccessFinderVisitor = new QvtVariableAccessFinderVisitorImpl(isWhen, processor.getTargetTypedModel());
		semanticsVisitable.accept(qvtVariableAccessFinderVisitor, data);
		List result = new ArrayList(qvtVariableAccessFinderVisitor.getVariables());

		if (semanticsVisitable instanceof PropertyTemplateItem) {
			ObjectTemplateExp semanticsVisitableObjectTemplate = ((PropertyTemplateItem) semanticsVisitable).getObjContainer();
			result.add(semanticsVisitableObjectTemplate.getBindsTo());
		}

		return result;
	}

	/**
	 * Finds the containing {@link Relation}
	 * 
	 * @param node
	 *            the contained node, may be null
	 * @return the relation or null otherwise
	 */
	public static Relation getRelationOf(SemanticsVisitable node) {
		EObject container = node;
		while (!(container instanceof Relation) && container != null) {
			container = container.eContainer();
		}
		return (Relation) container;
	}

	/**
	 * Finds the containing {@link Domain}
	 * 
	 * @param node
	 *            the contained node, may be null
	 * @return the relation or null otherwise
	 */
	public static Domain getDomainOf(SemanticsVisitable node) {
		EObject container = node;
		while (!(container instanceof Domain) && container != null) {
			container = container.eContainer();
		}
		return (Domain) container;
	}

	/**
	 * Finds the containing {@link Transformation}
	 * 
	 * @param node
	 *            the contained node
	 * @return the transformation or null otherwise
	 */
	static Transformation getTransformationOf(SemanticsVisitable node) {
		EObject container = node.eContainer();
		while (!(container instanceof Transformation) && container != null) {
			container = container.eContainer();
		}
		return (Transformation) container;
	}

	/**
	 * Returns a textual description if there is a variable in <code>semanticsVisitable</code> which is not bound by <code>currentlyResolvedVariables</code>.
	 * 
	 * @param semanticsVisitable
	 * @param currentlyResolvedVariables
	 * @param data
	 * @param processor
	 * @return
	 */
	static String getUnresolvedVar(SemanticsVisitable semanticsVisitable, List currentlyResolvedVariables, Object data, QvtProcessorImpl processor) {
		List dependsOnVar = QVTDirectedValidation.dependsOn(semanticsVisitable, true, data, processor);
		List unresolvedVariables = new ArrayList(dependsOnVar);
		unresolvedVariables.removeAll(currentlyResolvedVariables);
		String unresolvedVar = "";
		if (unresolvedVariables.size() >= 1) {
			return " (variable '" + ((VariableDeclaration) unresolvedVariables.get(0)).getName() + "' is not assigned)";
		}
		return "";
	}

	/**
	 * 
	 * @param relation
	 * @param direction
	 * @param data
	 * @return a list of {@link ObjectTemplateExp} instances
	 */
	static public List collectAllNestedObjectTemplatesOfRelationExcludingTargetDomain(Relation relation, TypedModel direction, Object data) {
		List result = new ArrayList();
		List domains = new ArrayList(relation.getDomain());

		for (Iterator iter = domains.iterator(); iter.hasNext();) {
			RelationDomain currentRelationDomain = (RelationDomain) iter.next();

			if (!direction.equals(currentRelationDomain.getTypedModel())) {
				result.addAll(QVTDirectedValidation.collectAllNestedObjectTemplatesOfRelationDomain(currentRelationDomain, data));
			}
		}
		return result;
	}

	/**
	 * 
	 * @param relationDomain
	 * @param data
	 * @return a list of {@link ObjectTemplateExp} instances
	 */
	static public List collectAllNestedObjectTemplatesOfRelationDomain(RelationDomain relationDomain, Object data) {
		List result = new ArrayList();
		QvtTemplateExpressionFinderVisitorImpl qvtTemplateExpressionFinderVisitor = new QvtTemplateExpressionFinderVisitorImpl();

		if (relationDomain.getPattern() == null) {
			// primitive domain
			return result;
		}

		relationDomain.getPattern().getTemplateExpression().accept(qvtTemplateExpressionFinderVisitor, data);
		List templateExpressions = qvtTemplateExpressionFinderVisitor.getTemplateExpressions();

		for (Iterator iterator = templateExpressions.iterator(); iterator.hasNext();) {
			TemplateExp currentTemplateExp = (TemplateExp) iterator.next();
			if (currentTemplateExp instanceof ObjectTemplateExp) {
				ObjectTemplateExp currentObjectTemplateExp = (ObjectTemplateExp) currentTemplateExp;
				if (currentObjectTemplateExp.eContainer() instanceof PropertyTemplateItem) {
					// currentObjectTemplateExp is nested
					result.add(currentObjectTemplateExp);
				}
			} else if (currentTemplateExp instanceof ColletionTemplateExp) {
				throw new RuntimeException("NYI");
			} else {
				throw new RuntimeException("NYI");
			}
		}
		return result;
	}

	/**
	 * 
	 * @param relation
	 * @param direction
	 * @param data
	 * @return a list of {@link ObjectTemplateExp} instances
	 */
	static public List collectAllObjectTemplatesOfRelationExcludingDirection(Relation relation, TypedModel direction, Object data) {
		List result = new ArrayList();
		List domains = new ArrayList(relation.getDomain());

		for (Iterator iter = domains.iterator(); iter.hasNext();) {
			RelationDomain currentRelationDomain = (RelationDomain) iter.next();

			if (!direction.equals(currentRelationDomain.getTypedModel())) {
				result.addAll(QVTDirectedValidation.collectAllObjectTemplatesOfRelationDomain(currentRelationDomain, data));
			}
		}
		return result;
	}

	/**
	 * 
	 * @param relation
	 * @param direction
	 * @param data
	 * @return a list of {@link ObjectTemplateExp} instances
	 */
	static public List collectAllObjectTemplatesOfRelationInDirection(Relation relation, TypedModel direction, Object data) {
		List result = new ArrayList();
		List domains = new ArrayList(relation.getDomain());

		for (Iterator iter = domains.iterator(); iter.hasNext();) {
			RelationDomain currentRelationDomain = (RelationDomain) iter.next();

			if (direction.equals(currentRelationDomain.getTypedModel())) {
				result.addAll(QVTDirectedValidation.collectAllObjectTemplatesOfRelationDomain(currentRelationDomain, data));
			}
		}
		return result;
	}

	/**
	 * 
	 * @param relation
	 * @param direction
	 * @return list of {@link ObjectTemplateExp} instances
	 */
	static public List collectAllDomainsInDirection(Relation relation, TypedModel direction) {
		List result = new ArrayList();
		List domains = new ArrayList(relation.getDomain());

		for (Iterator iter = domains.iterator(); iter.hasNext();) {
			RelationDomain currentRelationDomain = (RelationDomain) iter.next();

			if (direction.equals(currentRelationDomain.getTypedModel())) {
				TemplateExp x = currentRelationDomain.getPattern().getTemplateExpression();
				if (x instanceof ObjectTemplateExp) {
					result.add(x);
				}
			}
		}
		return result;
	}

	/**
	 * 
	 * @param relation
	 * @param direction
	 * @return list of {@link ObjectTemplateExp} instances
	 */
	static public List collectAllDomainsExcludingDirection(Relation relation, TypedModel direction) {
		List result = new ArrayList();
		List domains = new ArrayList(relation.getDomain());

		for (Iterator iter = domains.iterator(); iter.hasNext();) {
			RelationDomain currentRelationDomain = (RelationDomain) iter.next();

			if (!direction.equals(currentRelationDomain.getTypedModel()) && currentRelationDomain.getPattern() != null) {
				TemplateExp x = currentRelationDomain.getPattern().getTemplateExpression();
				if (x instanceof ObjectTemplateExp) {
					result.add(x);
				}
			}
		}
		return result;
	}

	/**
	 * 
	 * @param relationDomain
	 * @param data
	 * @return a list of {@link ObjectTemplateExp} instances
	 */
	static public List collectAllObjectTemplatesOfRelationDomain(RelationDomain relationDomain, Object data) {
		List result = new ArrayList();
		QvtTemplateExpressionFinderVisitorImpl qvtTemplateExpressionFinderVisitor = new QvtTemplateExpressionFinderVisitorImpl();

		if (relationDomain.getPattern() == null) {
			// primitive domain
			return result;
		}

		relationDomain.getPattern().getTemplateExpression().accept(qvtTemplateExpressionFinderVisitor, data);
		List templateExpressions = qvtTemplateExpressionFinderVisitor.getTemplateExpressions();

		return templateExpressions;
	}

	/**
	 * Collects all "where" relation calls of relation <code>relation</code> which bind <code>variableName</code> in direction <code>targetModel</code>
	 * 
	 * @param relation
	 * @param variableName
	 * @param targetModel
	 * @param data
	 * @return
	 */
	public static Collection collectAllRelationCallsInWhereClauseWithVariableInTarget(Relation relation, String variableName, TypedModel targetModel, Map data) {
		ArrayList result = new ArrayList();
		Collection whereClauseExpressions = QVTDirectedValidation.collectClauseExpressions(relation, relation.getWhere());
		result = QVTDirectedValidation.getRelationCallsWithVariableInTarget(whereClauseExpressions, variableName, targetModel, data);
		return result;
	}

	/**
	 * Collects all relation calls contained in "where" clauses of <code>whereClauseExpressions</code> which bind <code>variableName</code> in direction
	 * <code>targetModel</code>
	 * 
	 * @param whereClauseExpressions
	 * @param variableName
	 * @param targetModel
	 * @param data
	 * @return
	 */
	private static ArrayList getRelationCallsWithVariableInTarget(Collection whereClauseExpressions, String variableName, TypedModel targetModel, Map data) {
		ArrayList result = new ArrayList();

		for (Iterator iter = whereClauseExpressions.iterator(); iter.hasNext();) {
			OclExpression currentExpression = (OclExpression) iter.next();
			QvtRelationCallExpressionFinderVisitorImpl relationCallFinderVisitor = new QvtRelationCallExpressionFinderVisitorImpl();
			currentExpression.accept(relationCallFinderVisitor, data);
			Collection relationCallExpressions = relationCallFinderVisitor.getRelationCallExpressions();

			for (Iterator iterator = relationCallExpressions.iterator(); iterator.hasNext();) {
				RelationCallExp currentRelationCall = (RelationCallExp) iterator.next();

				if (QVTDirectedValidation.hasVariableInTarget(currentRelationCall, variableName, targetModel)) {
					result.add(currentRelationCall);
				}
			}
		}

		return result;
	}

	/**
	 * Checks whether <code>variableName</code> is bound by relation call <code>relationCall</code> for direction <code>targetModel</code>
	 * 
	 * @param relationCall
	 * @param variableName
	 * @param targetModel
	 * @return
	 */
	private static boolean hasVariableInTarget(RelationCallExp relationCall, String variableName, TypedModel targetModel) {
		int indexOfVariable = QVTDirectedValidation.getIndexOfVariable(relationCall, variableName);

		if (indexOfVariable == -1) {
			return false;
		}

		Relation relation = relationCall.getReferredRelation();
		Domain relationDomains = (Domain) relation.getDomain().get(indexOfVariable);

		if (relationDomains.getTypedModel() != null && relationDomains.getTypedModel().equals(targetModel)) {
			return true;
		}

		return false;
	}

	/**
	 * Collects all relation calls binding variable <code>variableDeclaration</code> with a model element instance which is a subtype of the type
	 * <code>variableDeclaration.getType()</code>
	 * 
	 * @param variableDeclaration
	 * @param relationCalls
	 * @param requireStrictSubtype
	 *            true if subtype relation is strict, meaning that equal types are not considered
	 * @return
	 */
	public static Collection getRelationCallsWithDomainVariableTypeSubtypeOfVariable(VariableDeclaration variableDeclaration, Classifier type, Collection relationCalls, boolean requireStrictSubtype) {

		Collection result = new ArrayList();

		for (Iterator iter = relationCalls.iterator(); iter.hasNext();) {
			RelationCallExp currentRelationCall = (RelationCallExp) iter.next();
			Relation relation = currentRelationCall.getReferredRelation();
			int indexOfVariable = QVTDirectedValidation.getIndexOfVariable(currentRelationCall, variableDeclaration.getName());

			if (indexOfVariable == -1) {
				continue;
			}

			RelationDomain relationDomain = (RelationDomain) relation.getDomain().get(indexOfVariable);
			if (!(QvtProcessorImpl.respectCheckOnlyFlag() && relationDomain.isIsCheckable())) {
				if (QVTDirectedValidation.isSubTypeOf(type, relationDomain.getRootVariable().getType(), requireStrictSubtype)) {
					result.add(currentRelationCall);
				}
			}
		}
		return result;
	}

	private static boolean isSubTypeOf(Classifier superType, Classifier subType, boolean requireStrictSubtype) {
		if (requireStrictSubtype) {
			return subType.conformsTo(superType).booleanValue() && !superType.conformsTo(subType).booleanValue();
		} else {
			return subType.conformsTo(superType).booleanValue();
		}
	}

	private static int getIndexOfVariable(RelationCallExp relationCall, String variableName) {
		EList argumentList = relationCall.getArgument();

		int index = 0;

		for (Iterator iter = argumentList.iterator(); iter.hasNext();) {
			OclExpression currentExpression = (OclExpression) iter.next();

			if (!(currentExpression instanceof VariableExp)) {
				index++;
				continue;
			}

			VariableExp currentVariableExpression = (VariableExp) currentExpression;
			if (currentVariableExpression.getReferredVariable().getName().equals(variableName)) {
				return index;
			}
			index++;
		}

		return -1;
	}

	/**
	 * Returns the values for property <code>prop</code> of element <code>element</code>
	 * 
	 * @param element
	 * @param prop
	 * @param processor
	 * @return
	 */
	public static List getValueList(Object element, Property prop, QvtProcessorImpl processor) {

		Object sourceValue;
		if (element instanceof OclAnyModelElement) {
			sourceValue = ((OclAnyModelElement) element).asJavaObject();
		} else {
			sourceValue = element;
		}
		if (sourceValue == null) {
			throw new RuntimeException("Internal error in QVTDirectedValidation.getValueList(): parent object template not assigned");
		}

		Object javaValue = processor.getModelEvaluationAdapter().getValueForFeauture(sourceValue, prop);

		List vals;
		if (javaValue instanceof Collection) {
			vals = new ArrayList((Collection) javaValue);
		} else {
			vals = new ArrayList();
			if (javaValue != null) {
				vals.add(javaValue);
			}
		}
		return vals;
	}
}
