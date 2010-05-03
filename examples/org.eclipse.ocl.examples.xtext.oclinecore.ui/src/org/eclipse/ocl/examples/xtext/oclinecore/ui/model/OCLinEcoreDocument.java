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
 * $Id: OCLinEcoreDocument.java,v 1.3 2010/05/03 05:54:42 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclinecore.ui.model;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ocl.examples.common.plugin.OCLExamplesCommonPlugin;
import org.eclipse.ocl.examples.xtext.oclinecore.resource.OCLinEcore2Ecore;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.XtextDocument;

public class OCLinEcoreDocument extends XtextDocument
{
	private static final Logger log = Logger.getLogger(OCLinEcoreDocument.class);

	protected XtextResource resource2;
	
	public void saveAsEcore(ResourceSet resourceSet, URI ecoreURI, OutputStream outputStream) throws IOException, CoreException {
		OCLinEcore2Ecore copier = new OCLinEcore2Ecore(resourceSet, resource2, ecoreURI);
		Resource ecoreResource = copier.exportToEcore();
		List<Resource.Diagnostic> errors = ecoreResource.getErrors();
		if (errors.size() > 0) {
			StringBuffer s = new StringBuffer();
			for (Resource.Diagnostic diagnostic : errors) {
				s.append("\n");
				s.append(diagnostic.toString());
			}
			throw new CoreException(new Status(IStatus.ERROR, OCLExamplesCommonPlugin.PLUGIN_ID, s.toString()));
		}
		ecoreResource.save(outputStream, null);
	}

	@Override
	public void setInput(XtextResource resource) {
		// Works around Bug 309383 to avoid second untranslated read
		this.resource2 = resource;
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
