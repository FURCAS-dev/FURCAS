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
package org.eclipse.emf.query2;

import org.eclipse.emf.common.util.URI;

/**
 * A query scope provider can be used to dynamically calculate the scope of a
 * query. Semantically, a query scope is the given set of resources(URI's). The inclusive flag
 * is used to indicate if this set of resources defines the
 * search space (if the flag is true) or if the search scope is defined by the
 * entire connection scope minus the provided set of resources
 * (if the flag is false).
 * <p>
 * This interface <i>is</i> intended to be implemented by clients.
 */
public interface TypeScopeProvider {

	/**
	 * If this returns true, the resource scope
	 * limits the MQL search scope. Otherwise, the resource
	 *  scope is excluded from the search scope
	 * 
	 * @return true if the scope should include the resources
	 */
	boolean isInclusiveScope();

	/**
	 * The resource scope eventually is encoded as an array as URIs. The array
	 * should not be null!
	 * 
	 * @return the set of resources (as URIs) to be considered in the scope
	 */
	URI[] getResourceScope();

	//    /**
	//     * The container scope eventually is encoded as an array as CRIs. The array
	//     * should not be null!
	//     * 
	//     * @return the set of containers (as CRIs) to be considered in the scope
	//     */
	//    URI[] getContainerScope( );
}
