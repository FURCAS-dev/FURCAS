/**
 * <copyright>
 *
 * Copyright (c) 2011 E.D.Willink and others.
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
 * $Id: TypeManagerResourceSetAdapter.java,v 1.1 2011/03/01 08:47:20 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.utilities;

import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.resource.ResourceSet;

/**
 * A TypeManagerResourceSetAdapter associates a TypeManager with a ResourceSet so
 * that Resource creation can re-use a shared TypeManager.
 */
public class TypeManagerResourceSetAdapter implements Adapter
{		
	public static TypeManagerResourceSetAdapter findAdapter(ResourceSet resourceSet) {
		if (resourceSet == null) {
			return null;
		}
		return PivotUtil.getAdapter(TypeManagerResourceSetAdapter.class, resourceSet);
	}
	
	public static TypeManagerResourceSetAdapter getAdapter(ResourceSet resourceSet, TypeManager typeManager) {
		List<Adapter> eAdapters = resourceSet.eAdapters();
		TypeManagerResourceSetAdapter adapter = PivotUtil.getAdapter(TypeManagerResourceSetAdapter.class, eAdapters);
		if (adapter == null) {
			if (typeManager == null) {
				typeManager = new TypeManager();
			}
			adapter = new TypeManagerResourceSetAdapter(resourceSet, typeManager);
			eAdapters.add(adapter);
		}
		return adapter;
	}
	
	protected final ResourceSet resourceSet;
	protected final TypeManager typeManager;
	
	public TypeManagerResourceSetAdapter(ResourceSet resourceSet, TypeManager typeManager) {
		this.resourceSet = resourceSet;
		this.typeManager = typeManager;
	}

	public ResourceSet getTarget() {
		return resourceSet;
	}
	
	public TypeManager getTypeManager() {
		return typeManager;
	}

	public boolean isAdapterForType(Object type) {
		return type == TypeManagerResourceSetAdapter.class;
	}	

	public void notifyChanged(Notification notification) {
	}

	public void setTarget(Notifier newTarget) {
		assert (newTarget == resourceSet) || (newTarget == null);
	}
}