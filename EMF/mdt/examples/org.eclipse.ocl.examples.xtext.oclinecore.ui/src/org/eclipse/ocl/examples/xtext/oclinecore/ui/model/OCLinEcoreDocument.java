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
 * $Id: OCLinEcoreDocument.java,v 1.7 2010/08/17 20:50:24 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclinecore.ui.model;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.ocl.examples.common.plugin.OCLExamplesCommonPlugin;
import org.eclipse.ocl.examples.xtext.oclinecore.resource.OCLinEcore2Ecore;
import org.eclipse.ocl.examples.xtext.oclstdlib.ui.model.BaseDocument;

/**
 * An OCLinEcoreDocument refines a document to support generation of an alternate (XMI) content
 * for use during save in place of its normal textual content.
 */
public class OCLinEcoreDocument extends BaseDocument
{
	/**
	 * Fill outputStream with the XMI representation of the Ecore to be saved.
	 */
	public void saveAsEcore(ResourceSet resourceSet, URI ecoreURI, Writer writer) throws IOException, CoreException {
		OCLinEcore2Ecore copier = new OCLinEcore2Ecore(resourceSet, resource2, ecoreURI);
		XMLResource ecoreResource = copier.exportToEcore();
		List<Resource.Diagnostic> errors = ecoreResource.getErrors();
		if (errors.size() > 0) {
			StringBuffer s = new StringBuffer();
			for (Resource.Diagnostic diagnostic : errors) {
				s.append("\n");
				s.append(diagnostic.toString());
			}
			throw new CoreException(new Status(IStatus.ERROR, OCLExamplesCommonPlugin.PLUGIN_ID, s.toString()));
		}
		ecoreResource.save(writer, null);
	}
}
