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
 * $Id: ITextEditorWithUndoContext.java,v 1.2 2010/04/13 16:04:04 ewillink Exp $
 */
package org.eclipse.ocl.examples.editor.ui.text;

import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.ui.IReusableEditor;
import org.eclipse.ui.texteditor.ITextEditor;

public interface ITextEditorWithUndoContext extends ITextEditor, IReusableEditor
{
	public IUndoContext getUndoContext();
}
