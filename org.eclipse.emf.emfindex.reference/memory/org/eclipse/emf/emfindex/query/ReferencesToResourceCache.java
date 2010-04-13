/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.emfindex.query;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.emfindex.EReferenceDescriptor;
import org.eclipse.emf.emfindex.EReferenceDescriptorIterator;
import org.eclipse.emf.emfindex.IndexAdapter;
import org.eclipse.emf.emfindex.ResourceDescriptor;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

/**
 * @author koehnlein - Initial contribution and API
 */
public class ReferencesToResourceCache implements IndexAdapter {
	
	private Multimap<URI, EReferenceDescriptor> cache = new HashMultimap<URI, EReferenceDescriptor>();

	public void clear() {
		cache.clear();
	}

	public void notifyChanged(Notification notification) {
		Object oldValue = notification.getOldValue();
		int eventType = notification.getEventType();
		if(oldValue instanceof ResourceDescriptor) {
			ResourceDescriptor resourceDescriptor = (ResourceDescriptor) oldValue;
			if(eventType == Notification.REMOVE 
					|| eventType == Notification.SET) {
				for(EReferenceDescriptorIterator eReferenceDescriptorIterator = new EReferenceDescriptorIterator(resourceDescriptor); eReferenceDescriptorIterator.hasNext();) {
					EReferenceDescriptor next = eReferenceDescriptorIterator.next();
					URI targetResourceURI = next.getTargetResourceURI();
					cache.remove(targetResourceURI, next);
				}
			}
		}
		Object newValue = notification.getNewValue();
		if(newValue instanceof ResourceDescriptor) {
			ResourceDescriptor resourceDescriptor = (ResourceDescriptor) newValue;
			if(eventType == Notification.ADD || eventType == Notification.SET) {
				for(EReferenceDescriptorIterator eReferenceDescriptorIterator = new EReferenceDescriptorIterator(resourceDescriptor); eReferenceDescriptorIterator.hasNext();) {
					EReferenceDescriptor next = eReferenceDescriptorIterator.next();
					URI targetResourceURI = next.getTargetResourceURI();
					cache.put(targetResourceURI, next);
				}
			}
		}
	}

	public Iterable<EReferenceDescriptor> getReferencesTargetingResource(URI resourceURI) {
		return cache.get(resourceURI);
	}
}
