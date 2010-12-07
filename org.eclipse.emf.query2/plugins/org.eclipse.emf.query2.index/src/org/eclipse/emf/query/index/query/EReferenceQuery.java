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
 * @author Martin Strenge, SAP AG
 * @author Bernd Kolb, SAP AG
 * 
 */
public interface EReferenceQuery<T> extends Query<T, EReferenceDescriptor> {

	/**
	 * @return The {@link EObjectQuery} for the link's source object
	 */
	public EObjectQuery<EObjectDescriptor> sourceEObject();

	/**
	 * @return The {@link EObjectQuery} for the link's target object
	 */
	public EObjectQuery<EObjectDescriptor> targetEObject();

	public void eReferenceURI(URI eReferenceURI);
}
