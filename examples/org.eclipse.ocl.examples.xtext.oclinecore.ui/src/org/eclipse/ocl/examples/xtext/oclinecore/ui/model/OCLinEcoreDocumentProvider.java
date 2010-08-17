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
 * $Id: OCLinEcoreDocumentProvider.java,v 1.7 2010/08/17 17:03:58 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclinecore.ui.model;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.ui.util.EditUIUtil;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.text.IDocument;
import org.eclipse.ocl.examples.common.plugin.OCLExamplesCommonPlugin;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreDocumentCS;
import org.eclipse.ocl.examples.xtext.oclinecore.resource.Ecore2OCLinEcore;
import org.eclipse.ocl.examples.xtext.oclinecore.ui.OCLinEcoreResourceForEditorInputFactory;
import org.eclipse.ocl.examples.xtext.oclinecore.ui.OCLinEcoreUiPluginHelper;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.xtext.parsetree.reconstr.XtextSerializationException;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.XtextDocumentProvider;

public class OCLinEcoreDocumentProvider extends XtextDocumentProvider
{
//	@Inject
//	private IResourceSetProvider resourceSetProvider;
	
	private Map<IDocument,Boolean> loadedAsEcoreMap = new HashMap<IDocument,Boolean>();
	
	private Map<IDocument,Boolean> saveAsEcoreMap = new HashMap<IDocument,Boolean>();

	private Map<IDocument, URI> uriMap = new HashMap<IDocument, URI>();		// Helper for setDocumentContent

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
			StringWriter ecoreWriter = new StringWriter();
			String savedContent = document.get();
			try {
				ResourceSet resourceSet = getResourceSet();
				URI uri = EditUIUtil.getURI((IFileEditorInput)element);
				((OCLinEcoreDocument) document).saveAsEcore(resourceSet, uri, ecoreWriter);
				document.set(ecoreWriter.toString());
				super.doSaveDocument(monitor, element, document, overwrite);
				loadedAsEcoreMap.put(document, Boolean.TRUE);
			} catch (Exception e) {
				OCLinEcoreUiPluginHelper helper = OCLinEcoreUiPluginHelper.INSTANCE;
				String title = helper.getString("_UI_SaveFailure_title", true);
				String message = helper.getString("_UI_SaveFailure_message", true);
				ErrorDialog.openError(null, title, message, helper.createErrorStatus(e));
				e.printStackTrace();
			} finally {
				document.set(savedContent);
			}
		}
		else {
			super.doSaveDocument(monitor, element, document, overwrite);
		}
	}

	public ResourceSet getResourceSet() {
		return ((OCLinEcoreResourceForEditorInputFactory) getResourceForEditorInputFactory()).getResourceSet();
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
	protected boolean setDocumentContent(IDocument document, IEditorInput editorInput, String encoding) throws CoreException {
		URI uri = EditUIUtil.getURI(editorInput);
		uriMap.put(document, uri);
		return super.setDocumentContent(document, editorInput, encoding);
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
				ResourceSet resourceSet = getResourceSet();
				URI uri = uriMap.get(document);
				Resource ecoreResource = resourceSet.createResource(uri, EcorePackage.eCONTENT_TYPE);
				ecoreResource.load(inputStream, null);
				List<Resource.Diagnostic> allErrors = null;
				for (Resource resource : resourceSet.getResources()) {
					List<Resource.Diagnostic> errors = resource.getErrors();
					if (errors.size() > 0) {
						if (allErrors == null) {
							allErrors = new ArrayList<Resource.Diagnostic>();
						}
						allErrors.addAll(errors);
					}
				}
				if (allErrors != null) {
					StringBuffer s = new StringBuffer();
					for (Resource.Diagnostic diagnostic : allErrors) {
						s.append("\n");
						s.append(diagnostic.toString());
					}
					throw new CoreException(new Status(IStatus.ERROR, OCLExamplesCommonPlugin.PLUGIN_ID, s.toString()));
				}
				OCLinEcoreDocumentCS documentCS = Ecore2OCLinEcore.importFromEcore(resourceSet, "", ecoreResource);		
				Resource xtextResource = documentCS.eResource();		
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				try {
					xtextResource.save(outputStream, null);
				} catch (XtextSerializationException e) {
					List<Diagnostic> diagnostics = ((XtextResource) xtextResource).validateConcreteSyntax();
					if (diagnostics.size() > 0) {
						StringBuffer s = new StringBuffer();
						s.append("Concrete Syntax validation failed");
						for (Diagnostic diagnostic : diagnostics) {
							s.append("\n");
							s.append(diagnostic.toString());
						}
						throw new CoreException(new Status(IStatus.ERROR, OCLExamplesCommonPlugin.PLUGIN_ID, s.toString(), e));
					}
					else {
						throw new CoreException(new Status(IStatus.ERROR, OCLExamplesCommonPlugin.PLUGIN_ID, "Failed to load", e));
					}
				}
				xtextResource.unload();
				resourceSet.getResources().remove(xtextResource);
				resourceSet.getResources().remove(ecoreResource);
				inputStream = new ByteArrayInputStream(outputStream.toByteArray());
			}
		} catch (IOException e) {
			throw new CoreException(new Status(IStatus.ERROR, OCLExamplesCommonPlugin.PLUGIN_ID, "Failed to load", e));
		}
		super.setDocumentContent(document, inputStream, encoding);		// FIXME encoding
	}

	public void setPersistAsEcore(Object element, Boolean asEcore) {
		saveAsEcoreMap.put(getDocument(element), asEcore);
		setCanSaveDocument(element);
	}
}
