/*******************************************************************************
 * Copyright (c) 2007,2010 Eclipse Modeling Project and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     E.D.Willink - copied from org.eclipse.ui.editors.text.TextFileDocumentProvider$NullProvider
 *******************************************************************************/
package org.eclipse.ocl.examples.editor.ui.common;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.content.IContentType;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.ui.editors.text.EditorsUI;
import org.eclipse.ui.editors.text.IStorageDocumentProvider;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.ui.texteditor.IDocumentProviderExtension;
import org.eclipse.ui.texteditor.IDocumentProviderExtension2;
import org.eclipse.ui.texteditor.IDocumentProviderExtension3;
import org.eclipse.ui.texteditor.IDocumentProviderExtension4;
import org.eclipse.ui.texteditor.IDocumentProviderExtension5;
import org.eclipse.ui.texteditor.IElementStateListener;

/**
 * NullProvider provides stub behaviour for MultiPageEditPart pages until their contents are
 * demand-created when the page is first opened. 
 */
public class NullProvider implements IDocumentProvider, IDocumentProviderExtension, IDocumentProviderExtension2, IDocumentProviderExtension3, IDocumentProviderExtension4, IDocumentProviderExtension5, IStorageDocumentProvider 
{
	public static IDocumentProvider INSTANCE = new NullProvider();
	static final private IStatus STATUS_ERROR = new Status(IStatus.ERROR, EditorsUI.PLUGIN_ID, IStatus.OK, "TextEditorMessages.NullProvider_error", null);

	public void connect(Object element) throws CoreException {}
	public void disconnect(Object element) {}
	public IDocument getDocument(Object element) { return null; }
	public void resetDocument(Object element) throws CoreException {}
	public void saveDocument(IProgressMonitor monitor, Object element, IDocument document, boolean overwrite) throws CoreException {}
	public long getModificationStamp(Object element) { return 0; }
	public long getSynchronizationStamp(Object element) { return 0; }
	public boolean isDeleted(Object element) { return true; }
	public boolean mustSaveDocument(Object element) { return false; }
	public boolean canSaveDocument(Object element) { return false; }
	public IAnnotationModel getAnnotationModel(Object element) { return null; }
	public void aboutToChange(Object element) {}
	public void changed(Object element) {}
	public void addElementStateListener(IElementStateListener listener) {}
	public void removeElementStateListener(IElementStateListener listener) {}
	public boolean isReadOnly(Object element) { return true; }
	public boolean isModifiable(Object element) { return false; }
	public void validateState(Object element, Object computationContext) throws CoreException {}
	public boolean isStateValidated(Object element) { return true; }
	public void updateStateCache(Object element) throws CoreException {}
	public void setCanSaveDocument(Object element) {}
	public IStatus getStatus(Object element) { return STATUS_ERROR; }
	public void synchronize(Object element) throws CoreException {}
	public void setProgressMonitor(IProgressMonitor progressMonitor) {}
	public IProgressMonitor getProgressMonitor() { return new NullProgressMonitor(); }
	public boolean isSynchronized(Object element) { return true; }
	public boolean isNotSynchronizedException(Object element, CoreException ex) { return false; }
	public String getDefaultEncoding() { return null; }
	public String getEncoding(Object element) { return null; }
	public void setEncoding(Object element, String encoding) {}
	public IContentType getContentType(Object element) throws CoreException { return null; }
}
