/**
 * <copyright>
 *
 * Copyright (c) 2010 Eclipse Modeling Project and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: OCLInEcoreDocumentProvider.java,v 1.3 2010/03/22 01:21:56 ewillink Exp $
 */
package org.eclipse.ocl.examples.editor.ocl.ui.ecore;

import java.io.IOException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.ui.util.EditUIUtil;
import org.eclipse.jface.text.IDocument;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.editors.text.FileDocumentProvider;

/**
 * An OCLInEcoreDocumentProvider provides the OCL text as the Document of an
 * Ecore Resource and installs an OCLInEcoreSynchronizer to transfer OCL changes
 * back to the Ecore Resource.
 */
public class OCLInEcoreDocumentProvider extends FileDocumentProvider
{
	private final class MyOCLInEcoreSynchronizer extends OCLInEcoreSynchronizer
	{
		private final IDocument document;

		private MyOCLInEcoreSynchronizer(IDocument document) {
			this.document = document;
		}

		@Override
		protected void updateDocument(final String newText) {
			final Display display = editor.getDisplay();
			if (display != null) {
				if (display.getThread() == Thread.currentThread()) {
					String oldText = document.get();
					if (needsUpdate(newText, oldText)) {
						document.set(newText);
					}
				}
				else {
					display.asyncExec(new Runnable() {
						public void run() {
							if (!display.isDisposed()) {
								String oldText = document.get();
								if (needsUpdate(newText, oldText)) {
									document.set(newText);
								}
							}
						}
					});
				}
			}
		}

		private boolean needsUpdate(String newText, String oldText) {
			int iNewMax = newText.length();
			int iOldMax = oldText.length();
			int iOld = 0;
			int iNew = 0;
			while ((iNew < iNewMax) && (iOld < iOldMax)) {
				char newChar = newText.charAt(iNew++);
				char oldChar = oldText.charAt(iOld++);
				if (newChar != oldChar) {
					while (Character.isWhitespace(newChar)) {
						newChar = iNew < iNewMax ? newText.charAt(iNew++) : null;
					}
					while (Character.isWhitespace(oldChar)) {
						oldChar = iOld < iOldMax ? oldText.charAt(iOld++) : null;
					}
					if (newChar != oldChar) {
						return true;
					}
					// FIXME check whitespace is between tokens
				}
			}
			return (iNew != iNewMax) || (iOld != iOldMax);
		}
	}

	protected final IOCLInEcoreEditor editor;
	
	public OCLInEcoreDocumentProvider(IOCLInEcoreEditor editor) {
		this.editor = editor;		
	}

	@Override
	protected boolean setDocumentContent(final IDocument document,
			IEditorInput editorInput, String encoding) throws CoreException {
		URI uri = EditUIUtil.getURI(editorInput);
		ResourceSet resourceSet = editor.getResourceSet();		
		Resource resource = resourceSet.getResource(uri, true);
		try {
			resource.load(null);
			resource.setTrackingModification(true);
			OCLInEcoreSynchronizer annotationSynchronizer = new MyOCLInEcoreSynchronizer(document);
			resourceSet.eAdapters().add(annotationSynchronizer);
			annotationSynchronizer.importFromResources();
		} catch (IOException e) {
			IStatus iStatus = new Status(IStatus.ERROR, OCLInEcorePlugin.kPluginID, "Failed to open", e);
			throw new CoreException(iStatus);
		}
		return true;
	}
}