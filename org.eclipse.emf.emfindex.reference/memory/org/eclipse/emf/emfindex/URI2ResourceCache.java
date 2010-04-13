/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.emfindex;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.index.ecore.emfindex.EmfindexPackage;
import org.eclipse.emf.index.ecore.emfindex.impl.ResourceDescriptorImpl;

/**
 * An exemplary cache to optimize queries.
 * 
 * @author koehnlein
 */
public class URI2ResourceCache implements IndexAdapter {

	private Map<URI, ResourceDescriptor> uriResourceDescriptorCache;

	private boolean isActive;

	public URI2ResourceCache() {
		uriResourceDescriptorCache = new HashMap<URI, ResourceDescriptor>();
		isActive = true;
	}

	public void clear() {
		uriResourceDescriptorCache.clear();
	}

	public void notifyChanged(Notification notification) {
		if (isActive) {
			Object oldValue = notification.getOldValue();
			Object newValue = notification.getNewValue();
			Object feature = notification.getFeature();
			if (feature == EmfindexPackage.Literals.CONTAINER_DESCRIPTOR__RESOURCE_DESCRIPTORS
					|| notification.getFeatureID(Resource.class) == Resource.RESOURCE__CONTENTS) {
				if (oldValue instanceof ResourceDescriptorImpl) {
					uriResourceDescriptorCache.remove(((ResourceDescriptor) oldValue).getURI());
				}
				if (newValue instanceof ResourceDescriptorImpl) {
					uriResourceDescriptorCache.put(((ResourceDescriptor) newValue).getURI(),
							(ResourceDescriptor) newValue);
				}
			}
		}
	}

	/**
	 * @param resourceURI
	 * @return
	 */
	public ResourceDescriptor findResourceDescriptor(URI resourceURI) {
		return uriResourceDescriptorCache.get(resourceURI);
	}

}
