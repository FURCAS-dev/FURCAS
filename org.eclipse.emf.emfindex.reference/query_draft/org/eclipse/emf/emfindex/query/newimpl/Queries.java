/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.emfindex.query.newimpl;

import org.eclipse.emf.emfindex.ContainerDescriptor;
import org.eclipse.emf.emfindex.EObjectDescriptor;
import org.eclipse.emf.emfindex.ResourceDescriptor;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class Queries {
	
	public final static StringProperty<EObjectDescriptor> obj_name = new StringProperty<EObjectDescriptor>(EObjectDescriptor.class,"name");
	public final static ResourceDescriptorProperty<EObjectDescriptor> obj_resourceDesc = new ResourceDescriptorProperty<EObjectDescriptor>(EObjectDescriptor.class,"resourceDescriptor");
	public final static URIProperty<EObjectDescriptor> obj_URI = new URIProperty<EObjectDescriptor>(EObjectDescriptor.class,"URI");
	
	public final static URIProperty<ResourceDescriptor> res_URI = new URIProperty<ResourceDescriptor>(ResourceDescriptor.class,"URI");
	public final static ContainerDescriptorProperty<ResourceDescriptor> res_container = new ContainerDescriptorProperty<ResourceDescriptor>(ResourceDescriptor.class,"URI");
	
	public final static StringProperty<ContainerDescriptor> con_name = new StringProperty<ContainerDescriptor>(ContainerDescriptor.class,"name");
	
	public static <X> QueryImpl<X> from(Class<X> clazz) {
		return new QueryImpl<X>(clazz);
	}
	
	public static <T> AbstractPredicate<T> not(AbstractPredicate<T> target) {
		return new AbstractPredicate.Not<T>(target);
	}
}
