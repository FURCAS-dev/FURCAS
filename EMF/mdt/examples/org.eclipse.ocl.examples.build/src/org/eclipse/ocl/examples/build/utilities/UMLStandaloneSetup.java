/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
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
 * $Id: UMLStandaloneSetup.java,v 1.2 2011/01/24 20:54:27 ewillink Exp $
 */
package org.eclipse.ocl.examples.build.utilities;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.mapping.ecore2xml.Ecore2XMLPackage;
import org.eclipse.emf.mwe.core.ConfigurationException;
import org.eclipse.emf.mwe.utils.Mapping;
import org.eclipse.emf.mwe.utils.StandaloneSetup;
import org.eclipse.uml2.uml.UMLPlugin;
import org.eclipse.uml2.uml.resource.CMOF2UMLResource;
import org.eclipse.uml2.uml.resource.UMLResource;

/**
 * Initializes UML support.
 */
public class UMLStandaloneSetup extends StandaloneSetup
{
	private Logger log = Logger.getLogger(getClass());

	/**
	 * Adds an <tt>org.eclipse.uml2.uml.dynamic_package</tt> extension
	 * 
	 * @param m the mapping
	 * <br><tt>from</tt>: The absolute or relative URI of the UML profile represented by the dynamic Ecore package,
	 * <br><tt>to</tt>: A namespace URI that uniquely identifies a dynamic Ecore package
	 * @throws ConfigurationException
	 *             <ul>
	 *             <li>No known reason
	 *             </ul>
	 */
	public void addRegisterDynamicPackage(final Mapping m) throws ConfigurationException {
		log.info("Adding Dynamic UML mapping from '" + m.getFrom() + "' to '" + m.getTo() + "'");
		try {
			URI ecoreURI = URI.createURI(m.getTo());
			UMLPlugin.getEPackageNsURIToProfileLocationMap().put(m.getFrom(), ecoreURI);
		}
		catch (final Exception e) {
			throw new ConfigurationException(e);
		}
	}

	/**
	 * sets the org.eclipse.uml2.uml.resources uri for standalone execution
	 * 
	 * @param pathToUMLResources which is typically "../org.eclipse.uml2.uml.resources"
	 */
	public void setUmlResourcesUri(String pathToUMLResources) {
		File f = new File(pathToUMLResources);
		if (!f.exists())
			throw new ConfigurationException("The pathToUMLResources location '" + pathToUMLResources + "' does not exist");
		if (!f.isDirectory())
			throw new ConfigurationException("The pathToUMLResources location must point to a directory");
		String path = f.getAbsolutePath();
		try {
			path = f.getCanonicalPath();
		}
		catch (IOException e) {
			log.error("Error when registering UML Resources location", e);
		}
		log.info("Registering UML Resources uri '" + path + "'");
		ResourceSet targetResourceSet = null;
		Resource.Factory.Registry resourceFactoryRegistry = targetResourceSet != null
			? targetResourceSet.getResourceFactoryRegistry()
			: Resource.Factory.Registry.INSTANCE;
		resourceFactoryRegistry.getExtensionToFactoryMap().put(
				UMLResource.FILE_EXTENSION, UMLResource.Factory.INSTANCE);
		resourceFactoryRegistry.getExtensionToFactoryMap().put(
				CMOF2UMLResource.FILE_EXTENSION, CMOF2UMLResource.Factory.INSTANCE);
		Map<URI, URI> uriMap = targetResourceSet != null
			? targetResourceSet.getURIConverter().getURIMap()
			: URIConverter.URI_MAP;		
//	uriMap.put(URI.createURI(UMLEnvironment.OCL_STANDARD_LIBRARY_NS_URI), URI.createFileURI(oclLocation + "/model/oclstdlib.uml")); //$NON-NLS-1$
		uriMap.put(URI.createURI(UMLResource.PROFILES_PATHMAP), URI.createFileURI(path + "/profiles/")); //$NON-NLS-1$
		uriMap.put(URI.createURI(UMLResource.METAMODELS_PATHMAP), URI.createFileURI(path + "/metamodels/")); //$NON-NLS-1$
		uriMap.put(URI.createURI(UMLResource.LIBRARIES_PATHMAP), URI.createFileURI(path + "/libraries/")); //$NON-NLS-1$
		registry.put(Ecore2XMLPackage.eNS_URI, Ecore2XMLPackage.eINSTANCE);
		UMLPlugin.getEPackageNsURIToProfileLocationMap().put("http://www.eclipse.org/uml2/schemas/Ecore/5", URI.createURI("pathmap://UML_PROFILES/Ecore.profile.uml#_0"));
		UMLPlugin.getEPackageNsURIToProfileLocationMap().put("http://www.eclipse.org/uml2/schemas/Standard/1", URI.createURI("pathmap://UML_PROFILES/Standard.profile.uml#_0"));
	}

	/**
	 * sets the org.eclipse.uml2.uml uri for standalone execution
	 * 
	 * @param pathToUML which is typically "../org.eclipse.uml2.uml"
	 */
	public void setUmlUri(String pathToUML) {
		File f = new File(pathToUML);
		if (!f.exists())
			throw new ConfigurationException("The pathToUML location '" + pathToUML + "' does not exist");
		if (!f.isDirectory())
			throw new ConfigurationException("The pathToUML location must point to a directory");
		String path = f.getAbsolutePath();
		try {
			path = f.getCanonicalPath();
		}
		catch (IOException e) {
			log.error("Error when registering UML location", e);
		}
		log.info("Registering UML uri '" + path + "'");
		ResourceSet targetResourceSet = null;
		Map<URI, URI> uriMap = targetResourceSet != null
			? targetResourceSet.getURIConverter().getURIMap()
			: URIConverter.URI_MAP;		
		uriMap.put(URI.createURI("platform:/plugin/org.eclipse.uml2.uml/"), URI.createFileURI(path + "/")); //$NON-NLS-1$
	}
}
