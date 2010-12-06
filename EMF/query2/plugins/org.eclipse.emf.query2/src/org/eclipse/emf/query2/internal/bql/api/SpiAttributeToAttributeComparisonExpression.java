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

import org.eclipse.emf.query2.internal.fql.SpiFqlComparisonOperation;
import org.eclipse.emf.query2.internal.fql.SpiFqlPrimitiveType;

/**
 * Implements comparisons of two attributes.
 */
public final class SpiAttributeToAttributeComparisonExpression extends SpiLeafExpression {

	private SpiFqlComparisonOperation operator;

	private SpiAttributeInModelElement comparedAttributeInModelElement;

	/**
	 * Constructor takes the attribute id and the attribute value.
	 * <p>
	 * LIMITATION: all strings returned by the facility should cut off any
	 * trailing blanks as this is the standard behaviour from OpenSQL (which is
	 * the driving implementation) of BQL. Attribute comparisons between strings
	 * therefore simply ignore trailing blanks.
	 */
	public SpiAttributeToAttributeComparisonExpression(String anId, SpiFqlPrimitiveType attributeValueType,
			SpiFqlComparisonOperation operator, SpiAttributeInModelElement comparedAttributeInModelElement) {
		super(anId, attributeValueType);
		this.operator = operator;
		this.comparedAttributeInModelElement = comparedAttributeInModelElement;
	}

	/**
	 * Introspection
	 */
	public SpiAttributeInModelElement getComparedAttributeInModelElement() {

		return this.comparedAttributeInModelElement;
	}

	public SpiFqlComparisonOperation getOperator() {

		return this.operator;
	}

	public void toString(StringBuffer sb, int ident, boolean newline) {

		if (newline) {
			SpiUtils.toStringNewLine(sb, ident);
		}
		sb.append(SpiUtils.OPENING_PARENTHESES);
		sb.append(this.getAttributeId());
		sb.append(SpiUtils.simpleComparisonOperatorToString(this.operator));
		sb.append(this.comparedAttributeInModelElement.toString());
		sb.append(SpiUtils.CLOSING_PARENTHESES);
	}

}