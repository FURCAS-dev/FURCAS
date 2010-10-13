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
 * A selection indicates whether a query entry from an FQL entry is part of the
 * result set.
 * 
 * @author D045917
 */
public interface SpiFqlSelection {

	/**
	 * Each FqlSelection is owned by a QueryEntry. At least the MRIs for the
	 * entry will be part of the facility result set.
	 */
	SpiFqlQueryEntry getOwningQueryEntry();

	/**
	 * Returns 0 or more attribute selections. These will be part of the result
	 * set on top of the actual returning element.
	 */
	SpiFqlAttributeSelection[] getAttributeSelections();
}
