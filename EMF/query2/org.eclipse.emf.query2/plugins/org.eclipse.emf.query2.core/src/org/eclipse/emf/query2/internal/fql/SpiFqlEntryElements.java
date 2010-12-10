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

import org.eclipse.emf.common.util.URI;

/**
 * An FqlEntryElements embodies a query entry which denotes a fixed set of
 * elements. All these elements are instances of the given query entry types.
 * Also note that the scope of this query entry is implicit defined by the
 * partitions of the provided MRIs
 * 
 * @author D045917
 */
public interface SpiFqlEntryElements extends SpiFqlQueryEntry {

	/**
	 * The fixed elements of this query entry. This method does not return null.
	 */
	URI[] getFixedElements();

}
