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

import java.util.Iterator;
import java.util.List;

/**
 * Implements the AND operator.
 */
@Deprecated
public final class SpiAnd extends SpiMultinaryExpression {

	/**
	 * Constructor takes a list of operands
	 */
	public SpiAnd(List anExpressionList) {

		super(anExpressionList);
	}

	/**
     *
     */
	public void toString(StringBuffer sb, int ident, boolean newline) {

		if (newline) {
			SpiUtils.toStringNewLine(sb, ident);
		}
		sb.append(SpiUtils.OPENING_PARENTHESES);
		sb.append(SpiUtils.AND);
		for (Iterator it = this.getOperands(); it.hasNext();) {
			((SpiAttributeExpression) it.next()).toString(sb, ident + 1, true);
		}
		sb.append(SpiUtils.CLOSING_PARENTHESES);
	}
}