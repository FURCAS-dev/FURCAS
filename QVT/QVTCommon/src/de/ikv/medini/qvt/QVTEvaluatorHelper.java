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
import java.util.Iterator;
import java.util.List;

import org.oslo.ocl20.semantics.model.expressions.VariableDeclaration;

import de.ikv.medini.qvt.model.qvtbase.TypedModel;
import de.ikv.medini.qvt.model.qvtrelation.Relation;
import de.ikv.medini.qvt.model.qvtrelation.RelationDomain;
import de.ikv.medini.qvt.model.qvttemplate.ColletionTemplateExp;
import de.ikv.medini.qvt.model.qvttemplate.ObjectTemplateExp;
import de.ikv.medini.qvt.model.qvttemplate.TemplateExp;

/**
 * A utility class used by the QVT evaluator to query the AST.
 * 
 * @author Michael Wagner
 * @author Omar Ekine
 * @author Joerg Kiegeland
 * 
 */
public class QVTEvaluatorHelper {

	private QvtEvaluatorVisitorImpl qvtEvaluatorVisitor;

	public QVTEvaluatorHelper(QvtEvaluatorVisitorImpl qvtEvaluatorVisitorImpl) {
		this.qvtEvaluatorVisitor = qvtEvaluatorVisitorImpl;
	}

	/**
	 * 
	 * @param relation
	 * @param data
	 * @return a list of {@link VariableDeclaration} instances
	 */
	static public List collectAllTemplateVariablesOfRelation(Relation relation, Object data) {
		List result = new ArrayList();
		List domains = relation.getDomain();

		for (Iterator iter = domains.iterator(); iter.hasNext();) {
			RelationDomain currentRelationDomain = (RelationDomain) iter.next();
			result.addAll(QVTEvaluatorHelper.collectAllTemplateVariablesOfRelationDomain(currentRelationDomain, data));
		}
		return result;
	}

	/**
	 * 
	 * @param relation
	 * @param direction
	 * @param data
	 * @return a list of {@link VariableDeclaration} instances
	 */
	public List collectAllTemplateVariablesOfRelationExcludingTargetDomain(Relation relation, TypedModel direction, Object data) {
		List result = new ArrayList();
		List doamins = relation.getDomain();

		for (Iterator iter = doamins.iterator(); iter.hasNext();) {
			RelationDomain currentRelationDomain = (RelationDomain) iter.next();

			if (!direction.equals(currentRelationDomain.getTypedModel())) {
				result.addAll(QVTEvaluatorHelper.collectAllTemplateVariablesOfRelationDomain(currentRelationDomain, data));
			}
		}
		return result;
	}

	/**
	 * 
	 * @param relation
	 * @param direction
	 * @param data
	 * @return a list of {@link VariableDeclaration} instances
	 */
	public List collectAllTemplateVariablesOfRelationInDirection(Relation relation, TypedModel direction, Object data) {
		List result = new ArrayList();
		List doamins = relation.getDomain();

		for (Iterator iter = doamins.iterator(); iter.hasNext();) {
			RelationDomain currentRelationDomain = (RelationDomain) iter.next();

			if (direction.equals(currentRelationDomain.getTypedModel())) {
				result.addAll(QVTEvaluatorHelper.collectAllTemplateVariablesOfRelationDomain(currentRelationDomain, data));
			}
		}
		return result;
	}

	/**
	 * 
	 * @param relation
	 * @return a list of {@link VariableDeclaration} instances
	 */
	public List collectAllDomainRootVariablesOfRelation(Relation relation) {
		List result = new ArrayList();
		List doamins = relation.getDomain();

		for (Iterator iter = doamins.iterator(); iter.hasNext();) {
			RelationDomain currentRelationDomain = (RelationDomain) iter.next();
			result.add(currentRelationDomain.getRootVariable());
		}
		return result;
	}

	/**
	 * 
	 * @param relation
	 * @param direction
	 * @return a list of {@link RelationDomain} instances
	 */
	public List collectAllDomainsOfRelationInDirection(Relation relation, TypedModel direction) {
		List result = new ArrayList();
		List doamins = relation.getDomain();

		for (Iterator iter = doamins.iterator(); iter.hasNext();) {
			RelationDomain currentRelationDomain = (RelationDomain) iter.next();

			if (direction.equals(currentRelationDomain.getTypedModel())) {
				result.add(currentRelationDomain);
			}
		}
		return result;
	}

	/**
	 * 
	 * @param relation
	 * @param direction
	 * @return a list of {@link RelationDomain} instances
	 */
	public List collectAllDomainRootVariablesOfRelationInDirection(Relation relation, TypedModel direction) {
		List result = new ArrayList();

		for (Iterator iter = this.collectAllDomainsOfRelationInDirection(relation, direction).iterator(); iter.hasNext();) {
			RelationDomain currentRelationDomain = (RelationDomain) iter.next();
			result.add(currentRelationDomain.getRootVariable());
		}
		return result;
	}

	/**
	 * 
	 * @param relation
	 * @param direction
	 * @return a list of {@link RelationDomain} instances
	 */
	public List collectAllDomainsOfRelationNotInDirection(Relation relation, TypedModel direction) {
		List result = new ArrayList();
		List doamins = relation.getDomain();

		for (Iterator iter = doamins.iterator(); iter.hasNext();) {
			RelationDomain currentRelationDomain = (RelationDomain) iter.next();

			if (!direction.equals(currentRelationDomain.getTypedModel())) {
				result.add(currentRelationDomain);
			}
		}
		return result;
	}

	/**
	 * 
	 * @param relation
	 * @param direction
	 * @return a list of {@link VariableDeclaration} instances
	 */
	public List collectAllDomainRootVariablesOfRelationNotInDirection(Relation relation, TypedModel direction) {
		List result = new ArrayList();

		for (Iterator iter = this.collectAllDomainsOfRelationNotInDirection(relation, direction).iterator(); iter.hasNext();) {
			RelationDomain currentRelationDomain = (RelationDomain) iter.next();
			result.add(currentRelationDomain.getRootVariable());
		}
		return result;
	}

	/**
	 * 
	 * @param relation
	 * @param direction
	 * @param data
	 * @return a list of {@link VariableDeclaration} instances
	 */
	public List collectAllTemplateVariablesOfRelationExcludingRootVariableExcludingTargetDomain(Relation relation, TypedModel direction, Object data) {
		List result = new ArrayList();
		List domains = new ArrayList(relation.getDomain());

		for (Iterator iter = domains.iterator(); iter.hasNext();) {
			RelationDomain currentRelationDomain = (RelationDomain) iter.next();

			if (!direction.equals(currentRelationDomain.getTypedModel())) {
				result.addAll(this.collectAllTemplateVariablesOfRelationDomainExcludingRootVariable(currentRelationDomain, data));
			}
		}
		return result;
	}

	/**
	 * 
	 * @param relationDomain
	 * @param data
	 * @return a list of {@link VariableDeclaration} instances
	 */
	public List collectAllTemplateVariablesOfRelationDomainExcludingRootVariable(RelationDomain relationDomain, Object data) {
		List result = QVTEvaluatorHelper.collectAllTemplateVariablesOfRelationDomain(relationDomain, data);
		result.remove(this.getRootVariableOfRelationDomain(relationDomain));
		return result;
	}

	/**
	 * 
	 * @param relationDomain
	 * @param data
	 * @return a list of {@link VariableDeclaration} instances
	 */
	static public List collectAllTemplateVariablesOfRelationDomain(RelationDomain relationDomain, Object data) {
		List result = new ArrayList();
		QvtTemplateExpressionFinderVisitorImpl qvtTemplateExpressionFinderVisitor = new QvtTemplateExpressionFinderVisitorImpl();

		if (relationDomain.getPattern() == null) {
			result.add(relationDomain.getRootVariable()); // this line results in saving primitive domains to traces
			return result;
		}

		relationDomain.getPattern().getTemplateExpression().accept(qvtTemplateExpressionFinderVisitor, data);
		List templateExpressions = qvtTemplateExpressionFinderVisitor.getTemplateExpressions();

		for (Iterator iterator = templateExpressions.iterator(); iterator.hasNext();) {
			TemplateExp currentTemplateExp = (TemplateExp) iterator.next();

			if (currentTemplateExp instanceof ObjectTemplateExp) {
				ObjectTemplateExp currentObjectTemplateExp = (ObjectTemplateExp) currentTemplateExp;
				VariableDeclaration bindsTo = currentObjectTemplateExp.getBindsTo();
				result.add(bindsTo);
			} else if (currentTemplateExp instanceof ColletionTemplateExp) {
				throw new RuntimeException("Collection Templates are not yet supported.");
			} else {
				throw new RuntimeException("Unsupported template kind: " + currentTemplateExp.getClass().getName());
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
	public List collectAllNestedObjectTemplatesOfRelationExcludingTargetDomain(Relation relation, TypedModel direction, Object data) {
		return QVTDirectedValidation.collectAllNestedObjectTemplatesOfRelationExcludingTargetDomain(relation, direction, data);
	}

	public VariableDeclaration getRootVariableOfRelationDomain(RelationDomain relationDomain) {
		return relationDomain.getRootVariable();
	}

	/**
	 * Collect all {@link VariableDeclaration} instances of relation <code>relation</code> of source domains having the direction <code>direction</code>.
	 * 
	 * @param relation
	 * @param direction
	 * @param data
	 * @param processor
	 * @return a list of {@link VariableDeclaration} instances
	 */
	public static List collectAllTemplateVariablesInDirection(Relation relation, TypedModel direction, Object data, QvtProcessorImpl processor) {
		return QVTDirectedValidation.collectAllTemplateVariablesInDirection(relation, direction, data);
	}

	public List collectAllNestedObjectTemplatesOfRelationOfTargetDomain(Relation relation, TypedModel direction, Object data) {
		List result = new ArrayList();
		List domains = new ArrayList(relation.getDomain());

		for (Iterator iter = domains.iterator(); iter.hasNext();) {
			RelationDomain currentRelationDomain = (RelationDomain) iter.next();

			if (direction.equals(currentRelationDomain.getTypedModel())) {
				result.addAll(QVTDirectedValidation.collectAllNestedObjectTemplatesOfRelationDomain(currentRelationDomain, data));
			}
		}
		return result;
	}

	public ObjectTemplateExp getNestedObjectTemplateBindingToVariable(Relation relation, TypedModel direction, Object data, String variable) {
		List nestedObjectTemplatesOfTargetDomain = this.collectAllNestedObjectTemplatesOfRelationOfTargetDomain(relation, direction, data);

		for (Iterator iter = nestedObjectTemplatesOfTargetDomain.iterator(); iter.hasNext();) {
			ObjectTemplateExp currentTemplate = (ObjectTemplateExp) iter.next();

			if (variable.equals(currentTemplate.getBindsTo().getName())) {
				return currentTemplate;
			}
		}

		return null;
	}
}
