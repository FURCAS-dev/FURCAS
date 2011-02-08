/**
 * <copyright>
 *
 * Copyright (c) 2010,2011 E.D.Willink and others.
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
 * $Id: OCLinEcoreDocumentProvider.java,v 1.10 2011/02/08 17:49:26 ewillink Exp $
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

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.edit.ui.util.EditUIUtil;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.ocl.examples.common.plugin.OCLExamplesCommonPlugin;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.ecore.Ecore2Pivot;
import org.eclipse.ocl.examples.pivot.uml.UML2Pivot;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.xtext.base.pivot2cs.Pivot2CS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreCSTPackage;
import org.eclipse.ocl.examples.xtext.oclinecore.pivot2cs.OCLinEcorePivot2CS;
import org.eclipse.ocl.examples.xtext.oclinecore.ui.OCLinEcoreUiPluginHelper;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.xtext.parsetree.reconstr.XtextSerializationException;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.XtextDocumentProvider;

/**
 * OCLinEcoreDocumentProvider orchestrates the load and saving of optional XMI content
 * externally while maintaining the serialised human friendly form internally. 
 */
public class OCLinEcoreDocumentProvider extends XtextDocumentProvider
{
	private static final Logger log = Logger.getLogger(OCLinEcoreDocumentProvider.class);
	
	public static final String PERSIST_AS_ECORE = "ecore";
	public static final String PERSIST_AS_PIVOT = "pivot";
	public static final String PERSIST_AS_OCLINECORE = "oclinecore";
	public static final String PERSIST_AS_UML = "uml";

	private Map<IDocument,String> loadedAsMap = new HashMap<IDocument,String>();
	
	private Map<IDocument,String> saveAsMap = new HashMap<IDocument,String>();

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
		String saveAs = saveAsMap.get(document);
		if ((element instanceof IFileEditorInput) && (document instanceof OCLinEcoreDocument) && !PERSIST_AS_OCLINECORE.equals(saveAs)) {
			StringWriter xmlWriter = new StringWriter();
			try {
//				URI uri = EditUIUtil.getURI((IFileEditorInput)element);
				if (PERSIST_AS_ECORE.equals(saveAs)) {
//					ResourceSet resourceSet = getResourceSet();
					((OCLinEcoreDocument) document).saveAsEcore(xmlWriter);
				}
				else if (PERSIST_AS_PIVOT.equals(saveAs)) {
//					ResourceSet resourceSet = getResourceSet();
					((OCLinEcoreDocument) document).saveAsPivot(xmlWriter);
				}
				else if (PERSIST_AS_UML.equals(saveAs)) {
//					ResourceSet resourceSet = getResourceSet();
					((OCLinEcoreDocument) document).saveAsUML(xmlWriter);
				}
				else {
					log.warn("Unknown saveAs '" + saveAs + "'");
				}
				IDocument saveDocument = new Document();
				saveDocument.set(xmlWriter.toString());
				super.doSaveDocument(monitor, element, saveDocument, overwrite);
				loadedAsMap.put(document, saveAs);
			} catch (Exception e) {
				OCLinEcoreUiPluginHelper helper = OCLinEcoreUiPluginHelper.INSTANCE;
				String title = helper.getString("_UI_SaveFailure_title", true);
				String message = helper.getString("_UI_SaveFailure_message", true);
				ErrorDialog.openError(null, title, message, helper.createErrorStatus(e));
			}
		}
		else {
			super.doSaveDocument(monitor, element, document, overwrite);
		}
	}

//	@Deprecated
//	public ResourceSet getResourceSet() {
//		return ((OCLinEcoreResourceForEditorInputFactory) getResourceForEditorInputFactory()).getResourceSet();
//	}

	@Override
	public boolean isDeleted(Object element) {
		IDocument document = getDocument(element);
		String loadIsEcore = loadedAsMap.get(document);
		String saveIsEcore = saveAsMap.get(document);
		if ((loadIsEcore != null) && !loadIsEcore.equals(saveIsEcore)) {
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
			boolean isXML = isXML(inputStream);		
			String persistAs = PERSIST_AS_OCLINECORE;
			if (isXML) {
				ResourceSet resourceSet = new ResourceSetImpl(); // getResourceSet();
				URI uri = uriMap.get(document);
				Resource xmiResource = resourceSet.createResource(uri, null);
				xmiResource.load(inputStream, null);
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
//				RootPackageCS documentCS = Ecore2OCLinEcore.importFromEcore(resourceSet, "", ecoreResource);		
				TypeManager typeManager = new TypeManager();
				Resource pivotResource = null;
				if (xmiResource.getContents().size() > 0) {
					EObject xmiRoot = xmiResource.getContents().get(0);
					if (xmiRoot instanceof EPackage) {
						Ecore2Pivot ecore2Pivot = Ecore2Pivot.getAdapter(xmiResource, typeManager);
						org.eclipse.ocl.examples.pivot.Package pivotRoot = ecore2Pivot.getPivotRoot();
						pivotResource = pivotRoot.eResource();
						persistAs = PERSIST_AS_ECORE;
					}
					else if (xmiRoot instanceof org.eclipse.ocl.examples.pivot.Package) {
						pivotResource = xmiResource;
						persistAs = PERSIST_AS_PIVOT;
					}
					else if (xmiRoot instanceof org.eclipse.uml2.uml.Package) {
						UML2Pivot uml2Pivot = UML2Pivot.getAdapter(xmiResource, typeManager);
						org.eclipse.ocl.examples.pivot.Package pivotRoot = uml2Pivot.getPivotRoot();
						pivotResource = pivotRoot.eResource();
						persistAs = PERSIST_AS_UML;
					}
					// FIXME general extensibility
				}
//				
				ResourceSet csResourceSet = resourceSet; //new ResourceSetImpl();
//				csResourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("cs", new EcoreResourceFactoryImpl());
				csResourceSet.getPackageRegistry().put(PivotPackage.eNS_URI, PivotPackage.eINSTANCE);
//				Resource csResource = csResourceSet.createResource(uri);
				URI oclinecoreURI = xmiResource.getURI().appendFileExtension("oclinecore");
				Resource csResource = resourceSet.createResource(oclinecoreURI, OCLinEcoreCSTPackage.eCONTENT_TYPE);
				Map<Resource, Resource> cs2PivotResourceMap = new HashMap<Resource, Resource>();
				cs2PivotResourceMap.put(csResource, pivotResource);
				Pivot2CS pivot2cs = new OCLinEcorePivot2CS(cs2PivotResourceMap, typeManager);
				pivot2cs.update();
//				csResource.save(null);
				Resource xtextResource = csResource;		
				
				
//				Resource xtextResource = documentCS.eResource();		
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
//				resourceSet.getResources().remove(pivotResource);
				resourceSet.getResources().remove(xmiResource);
				inputStream = new ByteArrayInputStream(outputStream.toByteArray());
			}
			loadedAsMap.put(document, persistAs);
			saveAsMap.put(document, persistAs);
		} catch (IOException e) {
			throw new CoreException(new Status(IStatus.ERROR, OCLExamplesCommonPlugin.PLUGIN_ID, "Failed to load", e));
		}
		super.setDocumentContent(document, inputStream, encoding);
	}

	public void setPersistAs(Object element, String persistAs) {
		saveAsMap.put(getDocument(element), persistAs);
		setCanSaveDocument(element);
	}
}
