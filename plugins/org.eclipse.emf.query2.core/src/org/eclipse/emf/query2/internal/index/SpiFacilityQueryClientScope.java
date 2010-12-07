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
package org.eclipse.emf.query2.internal.index;

import java.util.Set;

import org.eclipse.emf.common.util.URI;

/**
 * Defines the query client scope, which is generally an array of ClientSpecs
 * 
 * @author D045917
 */
public interface SpiFacilityQueryClientScope {

	/**
	 * The Query client scope is determined by an array of client specs
	 * 
	 * @return An array of {@link ClientSpec ClientSpecs} defining the scope for
	 *         the query
	 */
	//    ClientSpec[] getQueryClientScope( );
	/**
	 * Defines, if the partitions in {@link #getPartitionsScope()} describe the
	 * inclusive or exclusive query scope.
	 * 
	 * @return <code>false</code> if the set returned by
	 *         {@link #getPartitionsScope()} is to be negotiated as scope,
	 *         <code>true</code> otherwise.
	 */
	public boolean isPartitionScopeInclusive();

	/**
	 * Returns the set of PRIs describing the inclusive or exclusive scope for a
	 * query. Pay attention to the value of {@link #isPartitionScopeInclusive()}
	 * !
	 * 
	 * @return A set of unique {@link PRI}s
	 */
	public Set<URI> getPartitionsScope();

}
