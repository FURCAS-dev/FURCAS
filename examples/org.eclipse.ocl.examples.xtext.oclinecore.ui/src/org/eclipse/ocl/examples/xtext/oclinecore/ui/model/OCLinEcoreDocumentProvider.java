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
 * $Id: OCLinEcoreDocumentProvider.java,v 1.2 2010/04/16 18:09:45 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclinecore.ui.model;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IResource;
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
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.xtext.parsetree.reconstr.XtextSerializationException;
import org.eclipse.xtext.ui.editor.model.XtextDocumentProvider;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;

import com.google.inject.Inject;

public class OCLinEcoreDocumentProvider extends XtextDocumentProvider
{
	@Inject
	private IResourceSetProvider resourceSetProvider;
	
	private Map<IDocument,Boolean> loadedAsEcoreMap = new HashMap<IDocument,Boolean>();
	
	private Map<IDocument,Boolean> saveAsEcoreMap = new HashMap<IDocument,Boolean>();

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
	protected void doSaveDocument(IProgressMonitor monitor, Object element, IDocument document, boolean overwrite) throws CoreException {
		if ((element instanceof IFileEditorInput) && (document instanceof OCLinEcoreDocument) && (saveAsEcoreMap.get(document) == Boolean.TRUE)) {
			ByteArrayOutputStream ecoreStream = new ByteArrayOutputStream();
			String savedContent = document.get();
			try {
				((OCLinEcoreDocument) document).saveAsEcore(ecoreStream);
				document.set(ecoreStream.toString());
				super.doSaveDocument(monitor, element, document, overwrite);
				loadedAsEcoreMap.put(document, Boolean.TRUE);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				document.set(savedContent);
			}
		}
		else {
			super.doSaveDocument(monitor, element, document, overwrite);
		}
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

	@Override
	public boolean isDeleted(Object element) {
		IDocument document = getDocument(element);
		Boolean loadIsEcore = loadedAsEcoreMap.get(document);
		Boolean saveIsEcore = saveAsEcoreMap.get(document);
		if (loadIsEcore != saveIsEcore) {
			return true;		// Causes Save to do SaveAs
		}
		return super.isDeleted(element);
	}

	protected boolean isXML(InputStream inputStream) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		String line = reader.readLine();
		inputStream.reset();
		return (line != null) && line.startsWith("<?xml");
	}

	@Override
	protected void setDocumentContent(IDocument document, InputStream inputStream, String encoding) throws CoreException {
		try {
			if (!inputStream.markSupported()) {
				inputStream = createResettableInputStream(inputStream);
			}
			boolean asEcore = isXML(inputStream);
			loadedAsEcoreMap.put(document, asEcore);
			saveAsEcoreMap.put(document, asEcore);
			if (asEcore) {
				ResourceSet resourceSet = resourceSetProvider.get(null);
				Resource ecoreResource = resourceSet.createResource(URI.createFileURI("$ecore$.ecore"), EcorePackage.eCONTENT_TYPE);
				ecoreResource.load(inputStream, null);
				DocumentCS documentCS = importAsDocumentCS(ecoreResource);
				Resource xtextResource = resourceSet.createResource(URI.createFileURI("$xtext$.oclinecore"), OCLinEcoreCSTPackage.eCONTENT_TYPE);
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

	public void setPersistAsEcore(Object element, Boolean asEcore) {
		saveAsEcoreMap.put(getDocument(element), asEcore);
		setCanSaveDocument(element);
	}
}
