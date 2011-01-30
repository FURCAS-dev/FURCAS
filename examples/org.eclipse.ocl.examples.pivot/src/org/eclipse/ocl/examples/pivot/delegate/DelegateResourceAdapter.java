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
 * $Id: DelegateResourceAdapter.java,v 1.1 2011/01/30 11:16:29 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.delegate;

import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * DelegateResourceAdapter extends a Resource to load and unload DelegateDomains
 * for each package with a delegate annotation, when the resource is loaded and
 * unloaded.
 * 
 * @since 3.0
 */
public class DelegateResourceAdapter extends AdapterImpl
{
	public static DelegateResourceAdapter getAdapter(Resource resource) {
		DelegateResourceAdapter adapter = (DelegateResourceAdapter) EcoreUtil.getAdapter(resource.eAdapters(), DelegateResourceAdapter.class);
		if (adapter == null) {
			adapter = new DelegateResourceAdapter();
			resource.eAdapters().add(adapter);
		}
		return adapter;
	}

	@Override
	public Resource getTarget() {
		return (Resource) super.getTarget();
	}

	@Override
	public boolean isAdapterForType(Object type) {
		return type == DelegateResourceAdapter.class;
	}

	@Override
	public void notifyChanged(Notification notification) {
	    int featureID = notification.getFeatureID(Resource.class);
	    int eventType = notification.getEventType();
	    if ((featureID == Resource.RESOURCE__IS_LOADED) && (eventType == Notification.SET)) 
	    {
	    	Resource resource = getTarget();
			EList<EObject> contents = resource.getContents();
	    	if (notification.getNewBooleanValue()) {
				EPackage.Registry packageRegistry = resource.getResourceSet().getPackageRegistry();
				installPackages(packageRegistry, contents);
	    	}
	    	else {
	    		unloadDelegates(contents);
	    	}
	    }
	}

	protected void installPackages(EPackage.Registry packageRegistry, List<? extends EObject> contents) {
		for (EObject eObject : contents) {
			if (eObject instanceof EPackage) {
				EPackage ePackage = (EPackage)eObject;
				packageRegistry.put(ePackage.getNsURI(), ePackage);
				installPackages(packageRegistry, ePackage.getESubpackages());
			}
		}
	}

	@Override
	public void setTarget(Notifier newTarget) {
		Resource resource = (Resource)newTarget;
		super.setTarget(resource);
	}

	protected void unloadDelegates(List<? extends EObject> contents) {
		for (EObject eObject : contents) {
			if (eObject instanceof EPackage) {
				EPackage ePackage = (EPackage)eObject;
				DelegateEPackageAdapter adapter = DelegateEPackageAdapter.getAdapter(ePackage);
				adapter.unloadDelegates();
				unloadDelegates(ePackage.getESubpackages());
			}
		}		
	}
}
