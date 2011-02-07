/**
 * <copyright>
 *
 * Copyright (c) 2010,2011 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: DelegateResourceSetAdapter.java,v 1.1 2011/01/30 11:16:29 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.delegate;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * DelegateResourceSetAdapter extends a ResourceSet to support a registry of local
 * registries.
 * 
 * @since 3.0
 */
public class DelegateResourceSetAdapter extends AdapterImpl
{
	public static DelegateResourceSetAdapter getAdapter(EModelElement modelElement) {
		Resource resource = modelElement.eResource();
		if (resource == null) {
			return null;
		}
		ResourceSet resourceSet = resource.getResourceSet();
		if (resourceSet == null) {
			return null;
		}
		return getAdapter(resourceSet);
	}
	
	public static DelegateResourceSetAdapter getAdapter(ResourceSet resourceSet) {
		DelegateResourceSetAdapter adapter = (DelegateResourceSetAdapter) EcoreUtil.getAdapter(resourceSet.eAdapters(), DelegateResourceSetAdapter.class);
		if (adapter == null) {
			adapter = new DelegateResourceSetAdapter();
			resourceSet.eAdapters().add(adapter);
		}
		return adapter;
	}
	
	public static <T> T getRegistry(EModelElement modelElement, Class<T> registryClass, T defaultRegistry) {
		Resource resource = modelElement.eResource();
		if (resource == null) {
			return defaultRegistry;
		}
		ResourceSet resourceSet = resource.getResourceSet();
		if (resourceSet == null) {
			return defaultRegistry;
		}
		DelegateResourceSetAdapter adapter = getAdapter(resourceSet);
		T registry = null;
		if (adapter != null) {
			registry = adapter.getRegistry(registryClass);
		}
		return registry != null ? registry : defaultRegistry;
	}
		
	private Map<Class<? extends Object>, Object> registryRegistry = new HashMap<Class<? extends Object>, Object>();
	
	public <T> T getRegistry(Class<T> registryClass) {
		@SuppressWarnings("unchecked")
		T registry = (T) registryRegistry.get(registryClass);
		return registry;
	}

	@Override
	public boolean isAdapterForType(Object type) {
		return type == DelegateResourceSetAdapter.class;
	}

	public <T> T putRegistry(Class<T> registryClass, T newRegistry) {
		@SuppressWarnings("unchecked")
		T oldRegistry = (T) registryRegistry.put(registryClass, newRegistry);
		return oldRegistry;
	}

	@Override
	public void setTarget(Notifier newTarget) {
		ResourceSet resourceSet = (ResourceSet)newTarget;
		super.setTarget(resourceSet);
	}
}
