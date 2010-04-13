/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.emfindex;

import java.util.List;

import org.eclipse.emf.common.util.URI;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public interface ResourceDescriptor extends BaseDescriptor {
	
	public static final long UNSPECIFIED_VERSION = 0l;
	
	URI getURI();
	
	long getIndexedVersion();
	
	ContainerDescriptor getContainer();
	
	/**
	 * Containment.
	 */
	List<EObjectDescriptor> getEObjectDescriptors();
	

	/**
	 * Containment.
	 */
	List<EReferenceDescriptor> getEReferenceDescriptors();
}