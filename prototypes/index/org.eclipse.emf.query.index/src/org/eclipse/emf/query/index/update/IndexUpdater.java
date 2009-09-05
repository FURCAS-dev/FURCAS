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
 * @author Martin Strenge - Initial API and implementation
 * @author Bernd Kolb - Initial API and implementation
 * 
 */
public interface IndexUpdater {

	public void insertResource(URI uri, long version, Map<String, String> userData);

	public void insertEObject(URI resourceUri, String fragment, String typeUri, String name, Map<String, String> userData);

	public void insertEReference(URI sourceResourceUri, String sourceFragment, String typeUri, URI targetResourceUri, String targetFragment);

	public void deleteResource(URI uri);
}
