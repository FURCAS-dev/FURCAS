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
 * $Id: ModelRegistryEnvironment.java,v 1.2 2010/04/08 06:24:02 ewillink Exp $
 */
package org.eclipse.ocl.examples.modelregistry.environment;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import org.eclipse.emf.common.util.URI;
import org.eclipse.ocl.examples.modelregistry.model.NamespaceRegistry;
import org.eclipse.ocl.examples.modelregistry.standalone.JavaModelRegistryEnvironment;

/**
 * The ModelRegistryEnvironment defines the singleton facilities of the Model Registry and
 * their initialisation.
 * 
 * Derived StandaloneModelRegistryEnvironment and EclipseModelRegistryEnvironment
 * define environments that are initialised programmatically or by plug-in extensions. 
 */
public abstract class ModelRegistryEnvironment
{
	// The plug-in ID
	public static final String PLUGIN_ID = "org.eclipse.ocl.examples.modelregistry";

	// The shared instance
	private static ModelRegistryEnvironment INSTANCE = null;
	
	public static ModelRegistryEnvironment getInstance() {
		if (INSTANCE == null)
			INSTANCE = new JavaModelRegistryEnvironment();
		return INSTANCE;
	}
	
	public static void logError(String string, Throwable e) {
		getInstance().logTheError(string, e);
	}

	private NamespaceRegistry namespaceRegistry = null;
	private ModelSerializationRegistry modelSerializationRegistry = null;
	
	protected ModelRegistryEnvironment() {
		INSTANCE = this;
	}
	
	protected ModelSerializationRegistry createModelSerializationRegistry() {
		return new ModelSerializationRegistry();
	}
	
	protected NamespaceRegistry createNamespaceRegistry() {
		return new NamespaceRegistry();
	}
	
	/**
	 * Return a File to access the URI, or null if the URI cannot be
	 * resolved to a file protocol.
	 * 
	 * @return the File
	 * @throws URISyntaxException if the URI syntax is bad
	 * @throws IOException if URL resolution fails
	 */
	public File getFile(URI uri) throws URISyntaxException, IOException {
		String fileString = uri.toString();
		URL url = new URL(fileString);
		if (!"file".equals(url.getProtocol()))
			return null;
		return new File(url.toString().substring(5));
	}	
	
	public ModelSerializationRegistry getModelSerializationRegistry() {
		if (modelSerializationRegistry == null) {
			modelSerializationRegistry = createModelSerializationRegistry();
			initializeModelSerializationRegistry(modelSerializationRegistry);
		}
		return modelSerializationRegistry;
	}
	
	public NamespaceRegistry getNamespaceRegistry() {
		if (namespaceRegistry == null) {
			namespaceRegistry = createNamespaceRegistry();
			initializeNamespaceRegistry(namespaceRegistry);
		}
		return namespaceRegistry;
	}
	
	/**
	 * Install any required content in the ModelSerializationRegistry.
	 */
	protected abstract void initializeModelSerializationRegistry(ModelSerializationRegistry modelSerializationRegistry);	

	/**
	 * Install any required content in the NamespaceRegistry.
	 */
	protected abstract void initializeNamespaceRegistry(NamespaceRegistry namespaceRegistry);
	
	public abstract void logTheError(String string, Throwable e);
}
