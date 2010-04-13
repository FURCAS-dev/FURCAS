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
 * $Id: OCLinEcoreDocumentProvider.java,v 1.1 2010/04/13 06:47:03 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclinecore.ui.model;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.text.IDocument;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.DocumentCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreCSTFactory;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreCSTPackage;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.PackageCS;
import org.eclipse.ocl.examples.xtext.oclinecore.resource.Ecore2OCLinEcore;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.xtext.parsetree.reconstr.XtextSerializationException;
import org.eclipse.xtext.ui.editor.model.XtextDocumentProvider;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;

import com.google.inject.Inject;

public class OCLinEcoreDocumentProvider extends XtextDocumentProvider
{
	@Inject
	private IResourceSetProvider resourceSetProvider;

	public static InputStream createResettableInputStream(InputStream inputStream) throws IOException {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		byte[] buffer = new byte[4096];
		int len;
			while ((len = inputStream.read(buffer, 0, buffer.length)) > 0) {
				outputStream.write(buffer, 0, len);
			}
		return new ByteArrayInputStream(outputStream.toByteArray());
	}

	@Override
	protected void setDocumentContent(IDocument document, InputStream inputStream, String encoding) throws CoreException {
		try {
			if (!inputStream.markSupported()) {
				inputStream = createResettableInputStream(inputStream);
			}
			if (isXML(inputStream)) {
				ResourceSet resourceSet = resourceSetProvider.get(null);
				Resource ecoreResource = resourceSet.createResource(URI.createFileURI("$ecore$.ecore"), EcorePackage.eCONTENT_TYPE);
				ecoreResource.load(inputStream, null);
				DocumentCS documentCS = importAsDocumentCS(ecoreResource);
				// FIXME needs to exist in workspace
				Resource xtextResource = resourceSet.createResource(URI.createFileURI("xtext.oclinecore"), OCLinEcoreCSTPackage.eCONTENT_TYPE);
				xtextResource.getContents().add(documentCS);		
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				xtextResource.save(outputStream, null);
				xtextResource.unload();
				resourceSet.getResources().remove(xtextResource);
				resourceSet.getResources().remove(ecoreResource);
				inputStream = new ByteArrayInputStream(outputStream.toByteArray());
			}
		} catch (XtextSerializationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.setDocumentContent(document, inputStream, encoding);		// FIXME encoding
	}

	public DocumentCS importAsDocumentCS(Resource ecoreResource) {
		Ecore2OCLinEcore converter = new Ecore2OCLinEcore();
		List<EObject> csObjects = converter.convertAll(ecoreResource.getContents());
		DocumentCS documentCS = OCLinEcoreCSTFactory.eINSTANCE.createDocumentCS();
		List<PackageCS> packages = documentCS.getPackages();
		for (EObject csObject : csObjects) {
			packages.add((PackageCS) csObject);
		}
		return documentCS;
	}

	public boolean isXML(InputStream inputStream) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		String line = reader.readLine();
		inputStream.reset();
		return line.startsWith("<?xml");
	}

//	@Override
//	protected void setupDocument(Object element, IDocument document) {
//		String s1 = document.get();
//		super.setupDocument(element, document);
//		String s2 = document.get();
//	}

	@Override
	protected void doSaveDocument(IProgressMonitor monitor, Object element, IDocument document, boolean overwrite) throws CoreException {
		if ((element instanceof IFileEditorInput) && (document instanceof OCLinEcoreDocument)) {
			try {
				((OCLinEcoreDocument) document).saveAsEcore();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		super.doSaveDocument(monitor, element, document, overwrite);
	}

}
