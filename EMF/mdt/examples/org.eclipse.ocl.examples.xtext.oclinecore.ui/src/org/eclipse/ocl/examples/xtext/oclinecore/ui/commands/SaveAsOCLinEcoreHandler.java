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
 * $Id: SaveAsOCLinEcoreHandler.java,v 1.2 2010/05/03 05:54:43 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclinecore.ui.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ocl.examples.xtext.oclinecore.ui.model.OCLinEcoreDocumentProvider;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.xtext.ui.editor.XtextEditor;

public class SaveAsOCLinEcoreHandler extends AbstractHandler
{
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindow(event);
		if (window == null) {
			return null;
		}
		IEditorPart editor = HandlerUtil.getActiveEditor(event);
		if (!(editor instanceof XtextEditor)) {
			return null;
		}
		IDocumentProvider documentProvider = ((XtextEditor)editor).getDocumentProvider();
		if (!(documentProvider instanceof OCLinEcoreDocumentProvider)) {
			return null;
		}
		((OCLinEcoreDocumentProvider)documentProvider).setPersistAsEcore(editor.getEditorInput(), Boolean.FALSE);
		editor.doSaveAs();
		return null;
	}

}
