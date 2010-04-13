/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.emfindex;

import java.util.List;

/**
 * A descriptor for something that contains resources, e.g. an Eclipse project
 * or a folder. Containers can be nested. 
 * 
 * @author koehnlein
 */
public interface ContainerDescriptor extends BaseDescriptor {

	final String DEFAULT_CONTAINER_NAME = "EMFINDEX_DEFAULT_CONTAINER";
	
	/**
	 * Containment.
	 * 
	 * @return
	 */
	List<ResourceDescriptor> getResourceDescriptors();
	
	String getName();
	
}
