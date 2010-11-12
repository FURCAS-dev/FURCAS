/**
 * <copyright>
 * 
 * Copyright (c) 2008,2010 Eclipse Modeling Project and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: UniversalTextEditor.java,v 1.1 2010/03/11 14:51:21 ewillink Exp $
 */
package org.eclipse.ocl.examples.editor.ui.text;

import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.imp.editor.UniversalEditor;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextViewerExtension6;
import org.eclipse.jface.text.IUndoManager;
import org.eclipse.jface.text.IUndoManagerExtension;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.text.undo.DocumentUndoManagerRegistry;
import org.eclipse.text.undo.IDocumentUndoManager;

public class UniversalTextEditor extends UniversalEditor implements ITextEditorWithUndoContext
{
	@Override
	public void doSave(IProgressMonitor progressMonitor) {
		//
		//	Bugzilla 224324 part 1. Ensure that partial text operation does not continue across save.
		//
		IDocument document = getDocumentProvider().getDocument(getEditorInput());
		if (document != null) {
			IDocumentUndoManager documentUndoManager = DocumentUndoManagerRegistry.getDocumentUndoManager(document);
			if (documentUndoManager != null)
				documentUndoManager.commit();
		}
		super.doSave(progressMonitor);
	}
	
	public IUndoContext getUndoContext() {
		ISourceViewer sourceViewer = getSourceViewer();
		if (sourceViewer instanceof ITextViewerExtension6) {
			IUndoManager undoManager= ((ITextViewerExtension6)sourceViewer).getUndoManager();
			if (undoManager instanceof IUndoManagerExtension)
				return ((IUndoManagerExtension)undoManager).getUndoContext();
		}
		return null;
	}
}
