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
 * Expression with attribute search criteria. An attribute expression can
 * contain operations e.g. equals, greater, like. Attribute expressions can be
 * nested using AND and OR operations. Facility specific properties such as the
 * partition in the NWDI facility can be encoded using pseudo attributes. TODO
 * specify more specific attribute expressions such as greater expression, equal
 * expression, like expression, AND expression and OR expression and specify how
 * to construct complex attribute expressions.
 * 
 */
public interface SpiAttributeExpression {

	public void toString(StringBuffer sb, int ident, boolean newline);
}