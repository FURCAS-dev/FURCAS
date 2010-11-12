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
 * $Id: JavaModelRegistryEnvironment.java,v 1.2 2010/04/08 06:24:03 ewillink Exp $
 */
package org.eclipse.ocl.examples.modelregistry.standalone;

import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.ocl.examples.modelregistry.environment.ModelRegistryEnvironment;
import org.eclipse.ocl.examples.modelregistry.environment.ModelSerializationRegistry;
import org.eclipse.ocl.examples.modelregistry.model.ModelNameAccessor;
import org.eclipse.ocl.examples.modelregistry.model.NamespaceRegistry;
import org.eclipse.ocl.examples.modelregistry.model.URIAccessor;

public class JavaModelRegistryEnvironment extends ModelRegistryEnvironment
{
	/**
	 * Initialize the NamespaceRegistry with the ModelName and URI accessors.
	 */
	@Override protected void initializeNamespaceRegistry(NamespaceRegistry namespaceRegistry) {
		namespaceRegistry.addNamespace(ModelNameAccessor.NAMESPACE);
		namespaceRegistry.addNamespace(URIAccessor.NAMESPACE);
	}

	/**
	 * Initialize the ModelSerializationRegistry with the XML support.
	 */
	@Override protected void initializeModelSerializationRegistry(ModelSerializationRegistry modelSerializationRegistry) {
		modelSerializationRegistry.addSerializationFactory("XML", new EcoreResourceFactoryImpl());
	}		

	@Override public void logTheError(String string, Throwable e) {
		System.err.println(PLUGIN_ID + ":ERROR " + string);
		e.printStackTrace(System.err);
	}
}