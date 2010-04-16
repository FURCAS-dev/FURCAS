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
 * $Id: OCLinEcoreDocument.java,v 1.2 2010/04/16 18:09:45 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclinecore.ui.model;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Collection;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.DocumentCS;
import org.eclipse.ocl.examples.xtext.oclinecore.resource.OCLinEcore2Ecore;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.XtextDocument;

public class OCLinEcoreDocument extends XtextDocument
{
	private static final Logger log = Logger.getLogger(OCLinEcoreDocument.class);

	protected XtextResource resource2;
	
	public void saveAsEcore(OutputStream outputStream) throws IOException {
		URI ecoreURI = URI.createFileURI("$ecore$.ecore");
		Resource ecoreResource = new EcoreResourceFactoryImpl().createResource(ecoreURI);
		OCLinEcore2Ecore copier = new OCLinEcore2Ecore();
		DocumentCS document = (DocumentCS) resource2.getContents().get(0);
		Collection<? extends EObject> ecoreContents = copier.convertAll(document.getPackages());
		ecoreResource.getContents().addAll(ecoreContents);
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
