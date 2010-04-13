/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.emfindex.query;

import org.eclipse.emf.emfindex.ContainerDescriptor;

/**
 * @author koehnlein
 */
public class ContainerDescriptorQuery extends AbstractBaseDescriptorQuery<ContainerDescriptor> {


	private String name;

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

}
