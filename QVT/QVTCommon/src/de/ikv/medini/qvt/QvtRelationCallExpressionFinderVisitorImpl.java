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
import java.util.List;

import de.ikv.medini.qvt.model.qvtrelation.RelationCallExp;

/**
 * @author Omar Ekine
 * @author Joerg Kiegeland
 * 
 */
public class QvtRelationCallExpressionFinderVisitorImpl extends QvtExpressionFinderVisitorImpl {

	private List relationCallExpressions = new ArrayList();

	public QvtRelationCallExpressionFinderVisitorImpl() {
		super();
	}

	public Object visit(RelationCallExp host, Object data) {
		this.addToRelationCallExpressions(host);
		return super.visit(host, data);
	}

	private void addToRelationCallExpressions(RelationCallExp relationCallExp) {
		if (!this.relationCallExpressions.contains(relationCallExp)) {
			this.relationCallExpressions.add(relationCallExp);
		}
	}

	public Collection getRelationCallExpressions() {
		return this.relationCallExpressions;
	}
}
