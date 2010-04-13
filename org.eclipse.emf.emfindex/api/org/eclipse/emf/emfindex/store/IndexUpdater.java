/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.emfindex.store;

import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;

/**
 * @author koehnlein - Initial contribution and API
 */
public interface IndexUpdater {

	public final static String DEFAULT_CONTAINER = "EMFINDEX_DEFAULT_CONTAINER";

	public void createContainer(String containerName, Map<String, String> userData);

	/**
	 * Deletes the Container with the given name and its contents from the index.
	 */
	public void deleteContainer(String containerName);

	public void createOrUpdateResource(String containerName, URI resourceURI, long version, Map<String, String> userData);

	/**
	 * Deletes the Resource with the given resourceURI and its contents from the index.
	 */
	public void deleteResource(URI resourceURI);

	public void createOrUpdateEObject(URI resourceURI, String fragment, String name, EClass type,
			Map<String, String> userData);

	/**
	 * Deletes the EObject with the given URI from the index.
	 */
	public void deleteEObject(URI resourceURI, String fragment);

	public void createOrUpdateEReference(URI sourceResourceURI, String sourceFragment, URI targetEObjectURI,
			EReference reference, Map<String, String> userData);

	/**
	 * Deletes the EReference matching the parameters from the index.
	 */
	public void deleteEReference(URI sourceResourceURI, String sourceFragment, URI targetEObjectURI,
			EReference reference);

}
