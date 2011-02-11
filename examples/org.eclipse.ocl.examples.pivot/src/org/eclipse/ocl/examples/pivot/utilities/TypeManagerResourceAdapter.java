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
 * $Id: TypeManagerResourceAdapter.java,v 1.4 2011/02/11 20:00:28 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.utilities;

import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * A CS2PivotResourceAdapter enhances the Resource for a Concrete Syntax model
 * to support synchronization with a Pivot model representation.
 */
public class TypeManagerResourceAdapter implements Adapter
{		
	public static TypeManagerResourceAdapter findAdapter(Resource resource) {
		if (resource == null) {
			return null;
		}
		return PivotUtil.getAdapter(TypeManagerResourceAdapter.class, resource);
	}
	
	public static TypeManagerResourceAdapter getAdapter(Resource resource, TypeManager typeManager) {
		List<Adapter> eAdapters = resource.eAdapters();
		TypeManagerResourceAdapter adapter = PivotUtil.getAdapter(TypeManagerResourceAdapter.class, eAdapters);
		if (adapter == null) {
			if (typeManager == null) {
				typeManager = new TypeManager();
			}
			adapter = new TypeManagerResourceAdapter(resource, typeManager);
			eAdapters.add(adapter);
		}
		return adapter;
	}
	
	protected final Resource resource;
	protected final TypeManager typeManager;
	
	public TypeManagerResourceAdapter(Resource resource, TypeManager typeManager) {
		this.resource = resource;
		this.typeManager = typeManager;
//		System.out.println(Thread.currentThread().getName() + " Create " + getClass().getSimpleName() + "@" + hashCode()
//			+ " " + resource.getClass().getSimpleName() + " " + resource.hashCode() + " " + resource.getURI()
//			+ " " + typeManager.getClass().getSimpleName() + "@" + typeManager.hashCode());		
	}

	public Resource getTarget() {
		return resource;
	}
	
	public TypeManager getTypeManager() {
		return typeManager;
	}

	public boolean isAdapterForType(Object type) {
		return type == TypeManagerResourceAdapter.class;
	}	

	public void notifyChanged(Notification notification) {
	}

	public void setTarget(Notifier newTarget) {
		assert (newTarget == resource) || (newTarget == null);
	}
}