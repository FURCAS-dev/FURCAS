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
 * $Id: NamespaceRegistryReader.java,v 1.2 2010/04/08 06:23:50 ewillink Exp $
 */
package org.eclipse.ocl.examples.modelregistry.eclipse;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.plugin.RegistryReader;
import org.eclipse.ocl.examples.modelregistry.environment.ModelRegistryEnvironment;
import org.eclipse.ocl.examples.modelregistry.model.Accessor;
import org.eclipse.ocl.examples.modelregistry.model.ModelNameAccessor;
import org.eclipse.ocl.examples.modelregistry.model.NamespaceRegistry;

/**
 * A plugin extension reader that populates the NamespaceRegistry.
 */
public class NamespaceRegistryReader extends RegistryReader
{
	private static final String TAG_ACCESSOR = "accessor";
	private static final String ATT_CLASS = "class";
	
	private final NamespaceRegistry namespaceRegistry;
	
	public NamespaceRegistryReader(NamespaceRegistry namespaceRegistry) {
		super(Platform.getExtensionRegistry(),
//				ModelRegistryPlugin.getDefault().getBundle().getSymbolicName(), 
				EclipseModelRegistryEnvironment.EXTENSION_POINT_NAMESPACE, 
				EclipseModelRegistryEnvironment.NAMESPACE_PPID);
		this.namespaceRegistry = namespaceRegistry;
	}

	@Override
	protected boolean readElement(IConfigurationElement element) {
	    if (element.getName().equals(TAG_ACCESSOR)) {
	    	try {
	    		readElementInternal(element, ModelNameAccessor.NAMESPACE);
			} catch (CoreException e) {
				ModelRegistryEnvironment.logError("Failed to load class for '" + element.getAttribute(ATT_CLASS) + "'", e);
				return false;
			}
	    	return true;
	    }
	    return false;
	}

	private <A extends Accessor<A>> void readElementInternal(IConfigurationElement element, Accessor.Namespace<A> unusedNamespace) throws CoreException {
		Accessor.Installer<?> accessorInstaller = (Accessor.Installer<?>) element.createExecutableExtension(ATT_CLASS);
		namespaceRegistry.addNamespace(accessorInstaller.getNamespace());
	}
}
