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

/**
 * Attribute of a model element specified by a model element expression
 */
@Deprecated
public final class SpiAttributeInModelElement {

	private SpiModelElementExpression modelElementExpression;

	private String attributeId;

	/**
	 * @param modelElementExpression
	 *            model element expression which specifies the model elements of
	 *            the attribute
	 * @param attributeId
	 *            ID of the attribute
	 */
	public SpiAttributeInModelElement(SpiModelElementExpression modelElementExpression, String attributeId) {

		this.modelElementExpression = modelElementExpression;
		this.attributeId = attributeId;
	}

	/**
	 * @return Returns the attributeId.
	 */
	public String getAttributeId() {

		return this.attributeId;
	}

	/**
	 * @return Returns the modelElementExpression.
	 */
	public SpiModelElementExpression getModelElementExpression() {

		return this.modelElementExpression;
	}

	/**
     *
     */
	@Override
	public String toString() {

		return this.modelElementExpression.getAlias() + "." + this.attributeId; //$NON-NLS-1$
	}
}
