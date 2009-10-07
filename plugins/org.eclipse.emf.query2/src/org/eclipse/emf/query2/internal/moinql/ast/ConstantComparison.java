/*******************************************************************************
 * Copyright (c) 2006, 2009 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     SAP AG - initial API and implementation
 *******************************************************************************/
/*
 * Created on 16.02.2006
 */
package org.eclipse.emf.query2.internal.moinql.ast;

import org.eclipse.emf.query2.internal.fql.SpiFqlPrimitiveType;

/**
 * Compares an attribute of the particular atomic entry with a constant. It
 * comes in two flavors: 1) numeric comparison and 2) like-equality.
 */
public abstract class ConstantComparison extends WhereClause {

	protected String attrName;

	protected SpiFqlPrimitiveType attrType;

	protected boolean isMultiValued;

	public String getAttrName() {

		return this.attrName;
	}

	public boolean isMultiValued() {

		return this.isMultiValued;
	}

	public SpiFqlPrimitiveType getAttrType() {

		return this.attrType;
	}

	public void setAttrName(String attrName) {

		this.attrName = attrName;
	}

	public void setMultiValued(boolean isMultiValued) {

		this.isMultiValued = isMultiValued;
	}

	public void setAttrType(SpiFqlPrimitiveType attrType) {

		this.attrType = attrType;
	}

}
