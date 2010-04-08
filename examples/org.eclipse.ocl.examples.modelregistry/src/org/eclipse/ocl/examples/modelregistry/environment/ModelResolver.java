/**
 * <copyright>
 *
 * Copyright (c) 2007,2010 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id: ModelResolver.java,v 1.2 2010/04/08 06:23:59 ewillink Exp $
 */
package org.eclipse.ocl.examples.modelregistry.environment;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ocl.examples.modelregistry.model.Accessor;
import org.eclipse.ocl.examples.modelregistry.model.ProjectRegistry;

public interface ModelResolver
{	
	/**
	 * Return the Ecore Resource for uri optionally loading it if not already loaded.
	 * 
	 * @param uri
	 * @param loadOnDemand
	 * @return
	 * @throws Exception
	 */
	public Resource getEcoreResource(URI uri, boolean loadOnDemand) throws Exception;

	public FileHandle getHandle();
	/**
	 * Return the project registry, creating and loading it if not already loaded.
	 * 
	 * @return the project registry
	 */
	public ProjectRegistry getProjectRegistry();
	
	/**
	 * Return the EMF Resource for uri optionally loading it if not already loaded.
	 * This is equivalent to getResourceSet().getResource().
	 * 
	 * @param uri
	 * @param loadOnDemand
	 * @return
	 * @throws Exception
	 */
	public Resource getResource(URI uri, boolean loadOnDemand) throws Exception;
	
	/**
	 * Return the ResourceSet in which loaded resources are maintained.
	 * 
	 * @return the resource set.
	 */
	public ResourceSet getResourceSet();
	
	/**
	 * Return the (Ecore) URI suitable for getting the (Ecore) resource defined by the
	 * accessor in the context of a file defined by its handle.
	 * @param accessor the name and type of resource to be located.
	 * @return the Ecore URI
	 */
	public <A extends Accessor<A>> URI getURI(A accessor);

	/**
	 * Return the (Ecore) URI suitable for getting the (Ecore) resource defined by the
	 * modelName in the context of a file defined by its handle.
	 * 
	 * This is just a convenience form of getURI(resource, new ModelNameAccessor(modelName)).
	 * 
	 * @param modelName the name of the model to be located.
	 * @return the Ecore URI
	 */
	public abstract URI getURI(String modelName);

	/**
	 * Return the (Ecore) URI suitable for getting the (Ecore) resource defined by the
	 * (java.net.URI) uri in the context of a file defined by its handle.
	 * 
	 * This is just a convenience form of getURI(resource, new URIAccessor(uri)).
	 * 
	 * @param uri the URI name of the model to be located.
	 * @return the Ecore URI
	 */
	public abstract URI getURI(java.net.URI uri);

}