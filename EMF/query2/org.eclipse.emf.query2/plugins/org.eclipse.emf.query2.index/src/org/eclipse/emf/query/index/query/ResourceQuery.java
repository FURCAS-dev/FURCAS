/*******************************************************************************
 * Copyright (c) 2009 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     SAP AG - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.query.index.query;

import org.eclipse.emf.query.index.query.descriptors.ResourceDescriptor;

/**
 * Query the resource maps to get information from the resource
 * descriptors.
 * <p>
 * It the most limited query of the three possible types of queries on
 * indices. It can just use the Resource Map to check the validity of an URI
 * (i.e. whether the resource exists in the Index) or scan all entries in the
 * Resource Map for a match with an URI pattern.
 * </p>
 * <p>
 * A ResourceQuery can be created from the IndexQueryFactory:-<br>
 * <code> ResourceQuery<ResourceDescriptor> resQuery = IndexQueryFactory.createResourceQuery();</code>
 * </p>
 * <p>
 * Input to an ResourceQuery can be set in one of the three following ways:-
 * <ul>
 * <li>Set the resource uri for the ResourceQuery. <br>
 * <code>
		resQuery.uri(r.getURI().toString());
 * </code></li>
 * <li>Set the Object Information for the query(usually to retrieve the resource for the EObject).<br>
 * <code>
		resQuery.userData("key", "abc*"); </code></li>
 * </ul>
 * </p>
 * <p>
 * A ResourceQuery can be executed as follows:-<br>
 * <code>index.executeQueryCommand(new QueryCmd<ResourceDescriptor, ResourceDescriptor, ResourceQuery<ResourceDescriptor>>(resQuery));</code>
 * </p> 
 * @author Martin Strenge, SAP AG
 * @author Bernd Kolb, SAP AG
 * 
 */
public interface ResourceQuery<T> extends Query<T, ResourceDescriptor> {

	void uri(String uri);

	void userData(String key, String value);

}
