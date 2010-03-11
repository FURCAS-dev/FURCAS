package org.eclipse.ocl.examples.editor.ui.text;

import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.ui.IReusableEditor;
import org.eclipse.ui.texteditor.ITextEditor;

public interface ITextEditorWithUndoContext extends ITextEditor, IReusableEditor
{
	public IUndoContext getUndoContext();
}
