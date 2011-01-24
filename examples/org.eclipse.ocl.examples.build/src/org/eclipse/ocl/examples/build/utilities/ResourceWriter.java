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
 * $Id: ResourceWriter.java,v 1.2 2011/01/24 20:54:27 ewillink Exp $
 */
package org.eclipse.ocl.examples.build.utilities;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.lib.WorkflowComponentWithModelSlot;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;

/**
 * Writes a designated <tt>modelSlot</tt> to a specified <tt>uri</tt>.
 */
public class ResourceWriter extends WorkflowComponentWithModelSlot
{
	private Logger log = Logger.getLogger(getClass());	
	private String uri;

	public String getUri() {
		return uri;
	}

	public void invokeInternal(WorkflowContext ctx, ProgressMonitor arg1, Issues arg2) {
		URI fileURI = URI.createPlatformResourceURI(uri, true);
		log.info("Writing '" + fileURI + "'");
		Resource inputResource = (Resource) ctx.get(getModelSlot());
		ResourceSet resourceSet = inputResource.getResourceSet();
		try {
			Resource saveResource = resourceSet.createResource(fileURI);
			saveResource.getContents().addAll(inputResource.getContents());
			saveResource.save(null);
			inputResource.getContents().addAll(saveResource.getContents());
		} catch (IOException e) {
			throw new WrappedException(e);
		}
	}

	public void setUri(String uri) {
		this.uri = uri;
	}
}
