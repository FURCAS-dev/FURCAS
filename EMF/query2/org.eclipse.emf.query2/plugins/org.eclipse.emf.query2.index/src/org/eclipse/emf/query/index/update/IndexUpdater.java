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
package org.eclipse.emf.query.index.update;

import java.util.Map;

import org.eclipse.emf.common.util.URI;

/**
 * IndexUpdater can record the addition and removal of a resource, new
 * EObjects and references just by calling the respective methods. But the
 * sequence of calling these method is not arbitrary. Before adding an EObject
 * or reference you have to add the resource where it resides. If you index two
 * resources you can mix the calls for both resources, unless you keep the
 * sequence for the content of a single resource.
 * 
 * @author Martin Strenge - Initial API and implementation
 * @author Bernd Kolb - Initial API and implementation
 */
public interface IndexUpdater {

	/**
	 * Inserts resource and updates the indices.
	 * 
	 * @param uri
	 *            resource uri
	 * @param version
	 *            timestamp of the resource
	 */
	public void insertResource(URI uri, long version,
			Map<String, String> userData);

	/**
	 * Inserts an EObject in a given resource and updates the indices.
	 * 
	 * @param resourceUri
	 *            uri of the resource to which the EObject is added
	 * @param fragment
	 *            uri fragment of the given EObject
	 * @param typeUri
	 *            type uri of the given EObject
	 * @param name
	 *            EObject name
	 */
	public void insertEObject(URI resourceUri, String fragment, String typeUri,
			String name, Map<String, String> userData);

	/**
	 * Inserts an EReference for a given resource and updates the indices.
	 * 
	 * @param sourceResourceUri
	 *            uri of the resource which contains the source EObject
	 * @param sourceFragment
	 *            uri fragment of the source object
	 * @param typeUri
	 *            type uri of given EObject
	 * @param targetResourceUri
	 *            uri of the resource which contains the target EObject
	 * @param targetFragment
	 *            uri fragment of the target object
	 */
	public void insertEReference(URI sourceResourceUri, String sourceFragment,
			String typeUri, URI targetResourceUri, String targetFragment);

	/**
	 * Deletes the given resource and updates the indices
	 * 
	 * @param uri
	 *            resource uri to be deleted.
	 */
	public void deleteResource(URI uri);
}
