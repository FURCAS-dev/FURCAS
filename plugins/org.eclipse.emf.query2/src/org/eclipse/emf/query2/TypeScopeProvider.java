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
 * query. Semantically, a query scope is the union of a given set of partition
 * (identified by PRIs) and containers (identified by CRIs). The inclusive flag
 * is used to indicate if this union of partitions and containers defines the
 * search space (if the flag is true) or if the search scope is defined by the
 * entire connection scope minus the provided union of partitions and containers
 * (if the flag is false).
 * <p>
 * This interface <i>is</i> intended to be implemented by clients.
 */
public interface TypeScopeProvider {

	/**
	 * If this returns true, the union of the partition and container scope
	 * limits the MQL search scope. Otherwise, the union of partition and
	 * container scope is excluded from the search scope
	 * 
	 * @return true if the scope should include the partitions and containers
	 */
	boolean isInclusiveScope();

	/**
	 * The partition scope eventually is encoded as an array as PRIs. The array
	 * should not be null!
	 * 
	 * @return the set of partitions (as PRIs) to be considered in the scope
	 */
	URI[] getPartitionScope();

	//    /**
	//     * The container scope eventually is encoded as an array as CRIs. The array
	//     * should not be null!
	//     * 
	//     * @return the set of containers (as CRIs) to be considered in the scope
	//     */
	//    URI[] getContainerScope( );
}
