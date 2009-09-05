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
package org.eclipse.emf.query.index.internal.impl;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.query.index.internal.maps.LeanMap;

/**
 * @author Martin Strenge - Initial API and implementation
 * @author Bernd Kolb - Initial API and implementation
 * 
 */
public class GlobalTables {

	public PagingResourceDescriptorMap<URI, PageableResourceDescriptorImpl> resourceIndex;

	public LeanMap<String, URI> elementTypeIndex;

}
