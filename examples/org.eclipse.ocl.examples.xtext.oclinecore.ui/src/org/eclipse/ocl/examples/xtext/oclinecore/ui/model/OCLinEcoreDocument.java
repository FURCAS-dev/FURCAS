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
 * $Id: OCLinEcoreDocument.java,v 1.6 2010/08/17 17:03:58 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclinecore.ui.model;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.List;

import org.apache.log4j.Logger;
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
import org.eclipse.xtext.resource.XtextResource;

public class OCLinEcoreDocument extends BaseDocument
{
	private static final Logger log = Logger.getLogger(OCLinEcoreDocument.class);
	
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

	@Override
	public void setInput(XtextResource resource) {
		// Works around Bug 309383 to avoid second untranslated read
		String contents = get();
		if (contents != null) {
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			Writer writer = new OutputStreamWriter(outputStream);
			try {
				writer.write(contents);
				writer.close();
				InputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
				resource.load(inputStream, null);
			} catch (IOException e) {
				log.error(e.getMessage(), e);
			}
		}
		super.setInput(resource);
	}
}
