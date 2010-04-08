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
 * $Id: EclipseModelRegistryEnvironment.java,v 1.2 2010/04/08 06:23:48 ewillink Exp $
 */
package org.eclipse.ocl.examples.modelregistry.eclipse;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;
import java.net.URL;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.ocl.examples.modelregistry.environment.ModelRegistryEnvironment;
import org.eclipse.ocl.examples.modelregistry.environment.ModelSerializationRegistry;
import org.eclipse.ocl.examples.modelregistry.model.NamespaceRegistry;

public class EclipseModelRegistryEnvironment extends ModelRegistryEnvironment
{
	// The extension point namespace
	public static final String EXTENSION_POINT_NAMESPACE = "org.eclipse.ocl.modelregistry";
	// The accessor namespace extension point name
	public static final String NAMESPACE_PPID = "namespace";
	// The model serialization extension point name
	public static final String MODEL_SERIALIZATION_PPID = "model_serialization";
	
	/**
	 * Return a File to access the URI, or null if the URI cannot be
	 * resolved to a file protocol.
	 * 
	 * @return the File
	 * @throws URISyntaxException if the URI syntax is bad
	 * @throws IOException if URL resolution fails
	 */
	@Override public File getFile(URI uri) throws URISyntaxException, IOException {
		String fileString = uri.toString();
		URL url = new URL(fileString);
		URL resolvedURL = FileLocator.toFileURL(url);
		if (!"file".equals(resolvedURL.getProtocol()))
			return null;
		return new File(resolvedURL.toString().substring(5));
	}	

	@Override
	protected void initializeNamespaceRegistry(NamespaceRegistry namespaceRegistry) {
	    new NamespaceRegistryReader(namespaceRegistry).readRegistry();
	}
	
	@Override protected void initializeModelSerializationRegistry(ModelSerializationRegistry modelSerializationRegistry) {
	    new ModelSerializationRegistryReader(modelSerializationRegistry).readRegistry();
	}
	
	@Override public void logTheError(String string, Throwable e) {
		logException(newError(string, e), false);
	}		

	public void logException(Throwable e, boolean showErrorDialog) {
		if (e instanceof InvocationTargetException) {
			e = ((InvocationTargetException) e).getTargetException();
		}
		IStatus status = null;
		if (e instanceof CoreException) {
			status = ((CoreException) e).getStatus();
		} else {
			String message = e.getMessage();
			if (message == null)
				message = e.toString();
			status = new Status(IStatus.ERROR, PLUGIN_ID, IStatus.OK, message, e);
		}
		ModelRegistryPlugin.log(status, showErrorDialog);
	}
	
    /**
     * Return a CoreException with Error severity containing a text description and optionally
     * wrapping a further exception.
     * @param text description of exception
     * @param exception optional wrapped exception
     */
    public CoreException newError(String text, Throwable exception) {
        return new CoreException(new Status(IStatus.ERROR,
				PLUGIN_ID, IStatus.ERROR, "ERROR -- " + text, exception));
    }  
}