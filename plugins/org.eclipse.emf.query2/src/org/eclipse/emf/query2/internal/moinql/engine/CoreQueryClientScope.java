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
package org.eclipse.emf.query2.internal.moinql.engine;

import java.util.Collections;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.query2.internal.index.SpiFacilityQueryClientScope;


public class CoreQueryClientScope implements SpiFacilityQueryClientScope {

	//    private CoreConnection conn;

	//    private ClientSpec[] clientSpecs;

	private Set<URI> partitionScope;

	private boolean partitionScopeInclusive;

	/**
	 * This constructor creates a core query client scope which acts over the
	 * entire scope of the connection
	 */
	@SuppressWarnings("unchecked")
	public CoreQueryClientScope() {

		this(Collections.EMPTY_SET, false);
	}

	/**
	 * This constructor creates a core query client scope which acts over the
	 * partition scope as indicated by the PRI set and the boolean (for an
	 * exclusive or inclusive scope)
	 */
	@SuppressWarnings("unchecked")
	//    public CoreQueryClientScope( CoreConnection conn, Set<PRI> partitionScope, boolean partitionScopeInclusive ) {
	public CoreQueryClientScope(Set<URI> partitionScope, boolean partitionScopeInclusive) {

		// we keep the connection
		//        this.conn = conn;

		// we keep the client specs
		//        Collection<ClientSpec> clientSpecsCollection = conn.getSession( ).getCompoundClientSpec( ).getClientSpecs( );
		//        this.clientSpecs = clientSpecsCollection.toArray( new ClientSpec[clientSpecsCollection.size( )] );

		// the scope
		this.partitionScope = (partitionScope == null ? Collections.EMPTY_SET : partitionScope);

		this.partitionScopeInclusive = partitionScopeInclusive;
	}

	//    public ClientSpec[] getQueryClientScope( ) {
	//
	//        return this.clientSpecs;
	//    }
	//
	//    public CoreConnection getConnection( ) {
	//
	//        throw new IllegalArgumentException();
	////        return this.conn;
	//    }

	public boolean isPartitionScopeInclusive() {

		return this.partitionScopeInclusive;
	}

	public Set<URI> getPartitionsScope() {

		return this.partitionScope;
	}
}
