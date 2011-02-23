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

import org.eclipse.emf.query.index.internal.impl.query.EObjectQueryImpl;
import org.eclipse.emf.query.index.internal.impl.query.EReferenceQueryImpl;
import org.eclipse.emf.query.index.internal.impl.query.ResourceQueryImpl;
import org.eclipse.emf.query.index.query.descriptors.EObjectDescriptor;
import org.eclipse.emf.query.index.query.descriptors.EReferenceDescriptor;
import org.eclipse.emf.query.index.query.descriptors.ResourceDescriptor;

/**
 * A Factory to create Queries for the {@link ResourceDescriptor},
 * {@link EObjectDescriptor} or {@link EReferenceDescriptor}.<br>
 * There are three dedicated query types for each of the descriptors which are
 * created in this class.
 * <p>
 * Clients can use it to create:-
 * <ul>
 * <li>EObjectQuery:- <br>
 * Query the local tables inside the resource maps to get information about
 * EObjectDescriptor.EObjectQuery is used to reduce the scope of the optional
 * nested ResourceQuery by using the global type map. During the iteration over
 * the page content, we can use the available local indices to narrow the
 * element scope as efficient as possible. The EObjectQuery uses the Type Map
 * and Element Map. With the given indices a non-pattern fragment has the
 * highest selectivity, followed by the element type, and the fragment pattern,
 * which needs to iterate over all fragments to find a match. All other
 * conditions are evaluated on all elements in the resulting element scope.</li>
 * <li>EReferenceQuery:-<br>
 * Query the local tables inside the resource maps to get information about
 * EReferenceDescriptor. Depending on the navigation direction set during the
 * resource scope calculation we have to use different indices.
 * <p>
 * Backward navigation requires the Incoming Link Map and forward navigation can
 * use the Outgoing Link Map. <br>
 * The constraint evaluation is explained by the backward navigation with given
 * pattern for the target fragment.
 * <ol>
 * <li>Iterate over the keys of the Incoming Link Map and find a match for the
 * target fragment</li>
 * <li>Evaluate the reference constraints (e.g. type) and the target element
 * constraints</li>
 * <li>If source element constraints exist get the source ResourceDescriptor
 * (may be the same in case of an intra-resource link)</li>
 * <li>Evaluate constraints on the source element.</li>
 * </p>
 * <p>
 * The algorithm for the forward navigation is analogous to the example above.</li>
 * </li> </ol>
 * <li>ResourceQuery:-<br>
 * Query the resource maps to get information from the resource descriptors.
 * <p>
 * It the most limited query of the three possible types of queries on indices.
 * It can just use the Resource Map to check the validity of an URI (i.e.
 * whether the resource exists in the Index) or scan all entries in the Resource
 * Map for a match with an URI pattern.
 * </p>
 * </li>
 * </ul>
 * <p>
 * 
 * @author Martin Strenge, SAP AG
 * @author Bernd Kolb, SAP AG
 * 
 */
public class IndexQueryFactory {

	public static EObjectQuery<EObjectDescriptor> createEObjectQuery() {
		return new EObjectQueryImpl<EObjectDescriptor>();
	}

	public static EReferenceQuery<EReferenceDescriptor> createEReferenceQuery() {
		return new EReferenceQueryImpl<EReferenceDescriptor>();
	}

	public static ResourceQuery<ResourceDescriptor> createResourceQuery() {
		return new ResourceQueryImpl<ResourceDescriptor>();
	}

}
