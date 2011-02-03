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
 * ReferenceDescriptor describes an EReference.
 * </p>
 * <p>
 * It contains information like:
 * <li>fragment uri of Source EObject</li>
 * <li>fragment uri of Target EObject</li>
 * <li>uri of the resource containing the source EObject</li>
 * <li>uri of the resource containing the target EObject</li>
 * <li>uri of the EReference</li>
 * </p>
 */
public interface EReferenceDescriptor {

	String getSourceFragment();

	String getTargetFragment();

	URI getSourceResourceURI();

	URI getTargetResourceURI();

	String getEReferenceURI();

}