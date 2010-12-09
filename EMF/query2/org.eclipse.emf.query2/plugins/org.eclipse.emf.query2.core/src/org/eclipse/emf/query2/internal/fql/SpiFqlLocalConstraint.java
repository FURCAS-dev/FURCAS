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
 * An FqlConstraint is a local constraint over the query entry. It has several
 * forms as indicated by the subtypes of this interface.
 * 
 * @author D045917
 */
public interface SpiFqlLocalConstraint {

	/**
	 * The owning query entry of this condition.
	 */
	SpiFqlQueryEntry getFqlQueryEntry();
}
