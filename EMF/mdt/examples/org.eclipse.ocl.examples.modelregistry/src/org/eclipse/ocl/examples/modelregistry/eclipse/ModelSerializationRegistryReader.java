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
 * $Id: ModelSerializationRegistryReader.java,v 1.2 2010/04/08 06:23:50 ewillink Exp $
 */
package org.eclipse.ocl.examples.modelregistry.eclipse;


import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.plugin.RegistryReader;
import org.eclipse.ocl.examples.modelregistry.environment.ModelRegistryEnvironment;
import org.eclipse.ocl.examples.modelregistry.environment.ModelSerializationRegistry;
import org.osgi.framework.Bundle;

/**
 * A plugin extension reader that populates the ModelSerializationRegistry.
 */
public class ModelSerializationRegistryReader extends RegistryReader
{
	public static class BundleFactorySerialization extends ModelSerializationRegistry.FactorySerializationDelegate
	{
		protected final Bundle bundle;
		
		public BundleFactorySerialization(Bundle bundle, String serializationName, String className) {
			super(serializationName, className);
			this.bundle = bundle;
		}

		@Override protected Class<?> loadClass(String className) throws ClassNotFoundException {
			return bundle.loadClass(className);
		}
	}

	private static final String TAG_ENTRY = "entry";
	private static final String ATT_NAME = "name"; 
	private static final String ATT_FACTORY = "factory"; 

	private final ModelSerializationRegistry modelSerializationRegistry;
	
	public ModelSerializationRegistryReader(ModelSerializationRegistry modelSerializationRegistry) {
		super(Platform.getExtensionRegistry(),
//				ModelRegistryPlugin.getDefault().getBundle().getSymbolicName(), 
				EclipseModelRegistryEnvironment.EXTENSION_POINT_NAMESPACE, 
				EclipseModelRegistryEnvironment.MODEL_SERIALIZATION_PPID);
		this.modelSerializationRegistry = modelSerializationRegistry;
	}

	@Override protected boolean readElement(IConfigurationElement element) {
		IExtension extension = element.getDeclaringExtension();
		String namespaceIdentifier = extension.getNamespaceIdentifier();
		Bundle bundle = Platform.getBundle(namespaceIdentifier);	
	    if (element.getName().equals(TAG_ENTRY)) {
    		String name = element.getAttribute(ATT_NAME);
    		String factoryName = element.getAttribute(ATT_FACTORY);
    		if (name == null)
    			ModelRegistryEnvironment.logError("Missing name for model serialization", null);
    		else if (factoryName == null)
    			ModelRegistryEnvironment.logError("Missing factory class for '" + name + "' model serialization", null);
    		else
    			modelSerializationRegistry.addSerializationFactoryDelegate(name, new BundleFactorySerialization(bundle, name, factoryName));
	    	return true;
	    }
	    return false;
	}
}
