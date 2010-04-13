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
package org.eclipse.emf.query2.internal.bql.api;

import org.eclipse.emf.query2.internal.fql.SpiFqlPrimitiveType;

/**
 * Implements the handling of a single attribute id
 */
@Deprecated
public abstract class SpiLeafExpression implements SpiAttributeExpression {

	private String attributeId;

	private SpiFqlPrimitiveType attributeValueType;

	/**
	 * Constructs a leaf expression by the attribute id.
	 */
	public SpiLeafExpression(String attributeId, SpiFqlPrimitiveType attributeValueType) {

		this.attributeId = attributeId;
		this.attributeValueType = attributeValueType;
	}

	/**
	 * Introspection
	 */
	public String getAttributeId() {

		return this.attributeId;
	}

	public SpiFqlPrimitiveType getAttributeValueType() {

		return this.attributeValueType;
	}

	public String getAttributeValueForPrinting(Object value) {

		return (value == null ? "null" : value.toString()); //$NON-NLS-1$
	}
}
