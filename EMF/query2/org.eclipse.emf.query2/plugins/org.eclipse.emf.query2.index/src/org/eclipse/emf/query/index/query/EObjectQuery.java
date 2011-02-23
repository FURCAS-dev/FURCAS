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
import org.eclipse.emf.query.index.query.descriptors.ResourceDescriptor;

/**
 * Query the local tables inside the resource maps to get information about
 * {@link EObjectDescriptor}.
 * <p>
 * EObjectQuery is used to reduce the scope of the optional nested ResourceQuery
 * by using the global type map. During the iteration over the page content, we
 * can use the available local indices to narrow the element scope as efficient
 * as possible. The EObjectQuery uses the Type Map and Element Map. With the
 * given indices a non-pattern fragment has the highest selectivity, followed by
 * the element type, and the fragment pattern, which needs to iterate over all
 * fragments to find a match. All other conditions are evaluated on all elements
 * in the resulting element scope.
 * </p>
 * <p>
 * An EObject query can be created from the IndexQueryFactory:-<br>
 * <code>EObjectQuery<EObjectDescriptor> eObjectQuery = IndexQueryFactory.createEObjectQuery();</code>
 * </p>
 * <p>
 * Input to an EObjectQuery can be set in one of the three following ways:-
 * <ul>
 * <li>Set the resource uri for the EObject Query. <br>
 * <code>
		eObjectQuery.resource().uri(r.getURI().toString());
 * </code></li>
 * <li>Set the Object Information for the query.<br>
 * <code>
		eObjectQuery.userData("key", "wxy*");</code></li>
 * <li>Set the type Information for the query:- <br>
 * <code>
 * eObjectQuery.eClassURI(EcoreUtil.getURI(EcorePackage.Literals.ECLASS));
		eObjectQuery.fragment("/1*");
		</code></li>
 * </ul>
 * </p>
 * <p>
 * An EObjectQuery can be executed as follows:-<br>
 * <code>index.executeQueryCommand(new QueryCmd<EObjectDescriptor, EObjectDescriptor, EObjectQuery<EObjectDescriptor>>(eObjectQuery));</code>
 * </p>
 * 
 * @author Martin Strenge, SAP AG
 * @author Bernd Kolb, SAP AG
 * 
 */
public interface EObjectQuery<T> extends Query<T, EObjectDescriptor> {

	public void name(String name);

	public void nameContains(String nameSegment);

	public void nameStartsWith(String nameStart);

	public void nameEndsWith(String nameEnd);

	public void eClassURI(URI eClassURI);

	public void fragment(String fragment);

	public ResourceQuery<ResourceDescriptor> resource();

	void userData(String key, String value);

}
