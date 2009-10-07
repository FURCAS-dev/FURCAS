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
package org.eclipse.emf.query2.internal.fql;

/**
 * An FqlValueConstraint constrains the attribute value of the query entry and
 * has two forms as indicated by its subtypes.
 * 
 * @author D045917
 */
public interface SpiFqlValueConstraint extends SpiFqlLocalConstraint {

	/**
	 * The attribute name of the constraint
	 */
	String getAttrName();

	/**
	 * Indicates whether the attribute is multi-valued
	 */
	boolean isMultiValued();

	/**
	 * The primitive type of the attribute
	 */
	SpiFqlPrimitiveType getAttrType();
}
