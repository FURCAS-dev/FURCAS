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
 * $Id: EnvironmentResourceAdapter.java,v 1.1 2011/01/30 11:17:26 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.utilities;

import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.examples.pivot.PivotEnvironment;
import org.eclipse.ocl.lpg.ProblemHandler;

/**
 * A EnvironmentResourceAdapter enhances the Resource to idenify its environment.
 */
public class EnvironmentResourceAdapter implements Adapter
{		
	public static EnvironmentResourceAdapter findAdapter(Resource resource) {
		if (resource == null) {
			return null;
		}
		return PivotUtil.getAdapter(EnvironmentResourceAdapter.class, resource);
	}
	
	public static EnvironmentResourceAdapter getAdapter(Resource resource, PivotEnvironment environment) {
		List<Adapter> eAdapters = resource.eAdapters();
		EnvironmentResourceAdapter adapter = PivotUtil.getAdapter(EnvironmentResourceAdapter.class, eAdapters);
		if (adapter == null) {
			adapter = new EnvironmentResourceAdapter(resource, environment);
			eAdapters.add(adapter);
		}
		return adapter;
	}
	
	protected final Resource resource;
	protected final PivotEnvironment environment;
	
	public EnvironmentResourceAdapter(Resource resource, PivotEnvironment environment) {
		this.resource = resource;
		this.environment = environment;
	}

	public TypeManager createTypeManager() {
		return new TypeManager();
	}

	public Resource getTarget() {
		return resource;
	}

	public PivotEnvironment getEnvironment() {
		return environment;
	}

	public ProblemHandler getProblemHandler() {
		return environment != null ? environment.getProblemHandler() : null;
	}
	
//	public TypeManager getTypeManager() {
//		return typeManager;
//	}

	public boolean isAdapterForType(Object type) {
		return type == EnvironmentResourceAdapter.class;
	}	

	public void notifyChanged(Notification notification) {
	}

	public void setTarget(Notifier newTarget) {
		assert (newTarget == resource) || (newTarget == null);
	}
}