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
 * Abstract class for multinary expressions
 */
public abstract class SpiMultinaryExpression implements SpiAttributeExpression {

	protected List<?> operands;

	/**
	 * Constructor takes a list of operands
	 * 
	 * @param operands
	 *            list of AttributeExpression instances
	 */
	public SpiMultinaryExpression(List<?> operands) {
		this.operands = operands;
	}

	/**
	 * Introspection
	 */
	public Iterator<?> getOperands() {
		return this.operands.iterator();
	}
}
