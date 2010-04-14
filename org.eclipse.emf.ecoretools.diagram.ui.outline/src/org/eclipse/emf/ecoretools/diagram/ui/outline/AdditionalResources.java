/***********************************************************************
 * Copyright (c) 2007 Anyware Technologies
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Anyware Technologies - initial API and implementation
 * 
 * $Id: AdditionalResources.java,v 1.1 2008/05/26 12:26:56 jlescot Exp $
 **********************************************************************/

package org.eclipse.emf.ecoretools.diagram.ui.outline;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.gmf.runtime.emf.core.resources.GMFResource;

/**
 * This object computes all the loaded resources from a resource set. <br>
 * creation : 8 juin 2005
 * 
 * @author <a href="mailto:david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public class AdditionalResources {

	private ResourceSet resourceSet;

	/**
	 * Constructor
	 * 
	 * @param rSet
	 *            the ResourceSet to be used to load these Additional Resources
	 */
	public AdditionalResources(ResourceSet rSet) {
		super();

		this.resourceSet = rSet;
	}

	/**
	 * Returns all the resources without the DI and the domain resources
	 * 
	 * @return the list of additional resources
	 */
	public List<Resource> getResources() {
		List<Resource> additionnalResources = new ArrayList<Resource>();
		for (Resource resource : resourceSet.getResources()) {
			// remove DI and domain resources
			if (resource instanceof GMFResource) {
				continue;
			}
			if (resourceSet.getResources().get(1) == resource) {
				continue;
			}
			additionnalResources.add(resource);
			// res.remove(res.size() - 1);
			// res.remove(res.size() - 1);
		}

		return additionnalResources;
	}
}
