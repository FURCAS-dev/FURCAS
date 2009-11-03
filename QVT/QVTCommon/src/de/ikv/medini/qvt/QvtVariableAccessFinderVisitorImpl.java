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

import org.oslo.ocl20.semantics.model.expressions.IteratorExp;
import org.oslo.ocl20.semantics.model.expressions.OclExpression;
import org.oslo.ocl20.semantics.model.expressions.VariableDeclaration;
import org.oslo.ocl20.semantics.model.expressions.VariableExp;

import de.ikv.medini.qvt.model.qvtbase.TypedModel;
import de.ikv.medini.qvt.model.qvtrelation.Relation;
import de.ikv.medini.qvt.model.qvtrelation.RelationCallExp;
import de.ikv.medini.qvt.model.qvtrelation.RelationDomain;
import de.ikv.medini.qvt.model.qvttemplate.ObjectTemplateExp;

/**
 * Finds all variables on which the top level expression depends on
 * 
 * @author Michael Wagner
 * @author Omar Ekine
 * @author Joerg Kiegeland
 */
public class QvtVariableAccessFinderVisitorImpl extends QvtExpressionFinderVisitorImpl {

	/**
	 * List of {@link VariableDeclaration} instances
	 */
	private List variables = new ArrayList();

	private boolean isWhen = false;

	private TypedModel direction;

	public QvtVariableAccessFinderVisitorImpl(boolean isWhen, TypedModel direction) {
		super();
		this.isWhen = isWhen;
		this.direction = direction;
	}

	public List getVariables() {
		return this.variables;
	}

	public Object visit(VariableExp host, Object data) {
		this.addToVariables(host.getReferredVariable());
		return null;
	}

	public Object visit(ObjectTemplateExp host, Object data) {
		this.addToVariables(host.getBindsTo());
		return null;
	}

	private void addToVariables(VariableDeclaration variableDeclaration) {
		if (!this.variables.contains(variableDeclaration)) {
			this.variables.add(variableDeclaration);
		}
	}

	public Object visit(RelationCallExp host, Object data) {
		List arguments = host.getArgument();
		Relation relation = host.getReferredRelation();
		Iterator domainIter = relation.getDomain().iterator();
		for (Iterator iter = arguments.iterator(); iter.hasNext();) {
			RelationDomain relationDomain = (RelationDomain) domainIter.next();
			OclExpression currentArgument = (OclExpression) iter.next();

			/*
			 * Delegate resolving the expression if the expression is not a variable.
			 */
			if (!(currentArgument instanceof VariableExp)) {
				currentArgument.accept(this, data);
			} else
			/*
			 * A variable argument being mapped on a source domain or primitive domain need to be resolved.
			 */
			if (!(this.direction != null && this.direction.equals(relationDomain.getTypedModel()))) {
				currentArgument.accept(this, data);
			}
		}
		return null;
	}

	public Object visit(IteratorExp host, Object data) {
		super.visit(host, data);
		List iterator = host.getIterators();
		for (Iterator iter = iterator.iterator(); iter.hasNext();) {
			VariableDeclaration variableDeclaration = (VariableDeclaration) iter.next();
			while (this.variables.remove(variableDeclaration)) {
				;
			}
		}
		return null;
	}

}
