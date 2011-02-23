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

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.query.index.query.descriptors.EObjectDescriptor;
import org.eclipse.emf.query.index.query.descriptors.EReferenceDescriptor;

/**
 * Query the local tables inside the resource maps to get information about
 * {@link EReferenceDescriptor}. Depending on the navigation direction set
 * during the resource scope calculation we have to use different indices.
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
 * <li>evaluate constraints on the source element.</li>
 * </p>
 * <p>
 * The algorithm for the forward navigation is analogous to the example above.
 * </p>
 * <p>
 * An EReferenceQuery can be created from the IndexQueryFactory:-<br>
 * <code> EReferenceQuery<EReferenceDescriptor> refQuery = IndexQueryFactory.createEReferenceQuery();</code>
 * </p>
 * <p>
 * Input to an EReferenceQuery can be set in one of the three following ways:-
 * <ul>
 * <li>Set the source EObject information for the EReferenceQuery. <br>
 * <code>
		refQuery.sourceEObject().name("*s1");
 * </code></li>
 * <li>Set the target EObject information for the EReferenceQuery. <br>
 * <code>
		rrefQuery.targetEObject().name("*s2");
 * </code></li>
 * <li>Set the Object Information for the query(usually to retrieve the resource
 * for the EObject).<br>
 * <code>
		resQuery.userData("key", "abc*"); </code></li>
 * </ul>
 * </p>
 * <p>
 * An EReferenceQuery can be executed as follows:-<br>
 * <code>index.executeQueryCommand(new QueryCmd<EReferenceDescriptor, EReferenceDescriptor, EReferenceQuery<EReferenceDescriptor>>(refQuery));</code>
 * </p>
 * 
 * @author Martin Strenge, SAP AG
 * @author Bernd Kolb, SAP AG
 * 
 */
public interface EReferenceQuery<T> extends Query<T, EReferenceDescriptor> {

	/**
	 * @return {@link EObjectQuery} for the link's source object
	 */
	public EObjectQuery<EObjectDescriptor> sourceEObject();

	/**
	 * @return {@link EObjectQuery} for the link's target object
	 */
	public EObjectQuery<EObjectDescriptor> targetEObject();

	public void eReferenceURI(URI eReferenceURI);
}
