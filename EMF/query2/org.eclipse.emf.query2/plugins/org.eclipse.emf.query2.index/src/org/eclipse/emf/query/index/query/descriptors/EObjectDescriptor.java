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
package org.eclipse.emf.query.index.query.descriptors;

import org.eclipse.emf.common.util.URI;

/**
 * <p>
 * 	Information about EObjects is kept in the EObjectDescriptor.
 * </p>
 * <p>
 * It contains information like:
 * <li>type</li>
 * <li>container resource</li>
 * <li>name</li>
 * <li>EObject fragment</li>
 * <li>userdata</li>
 * </p>
 */
public interface EObjectDescriptor {

	/**
	 * @return uri of the resource containing the EObject
	 */
	URI getResourceURI();

	/**
	 * @return name of the EObject
	 */
	String getName();

	/**
	 * @return EObject fragment in uri
	 */
	String getFragment();

	/**
	 * @return type uri of the EObject
	 */
	String getEClassURI();

	String getUserData(String key);

}
