package com.sap.ide.moftool.editor.action;

import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.IStructuredSelection;

import com.sap.ide.moftool.editor.core.service.ModelElementService;
import com.sap.ide.moftool.editor.plugin.MOFToolEditorPlugin;

public abstract class AbstractMoftoolAction<T extends Object> extends Action {

	private IStructuredSelection mSelection = null;

	/**
	 * the input Object ( e.g. of an empty tree ).
	 * 
	 */
	private T mInputObject = null;

	public AbstractMoftoolAction(IStructuredSelection selection, T inputObject, String text, String image) {
		super(text, MOFToolEditorPlugin.getDefault().getImageDescriptor(image));
		this.mInputObject = inputObject;
		if (selection != null) {
			mSelection = selection;
			setEnabled(enabledForSelection(selection) && !ModelElementService.isForeignObject((RefBaseObject) inputObject) );
			setContext(selection);
		}
	}

	private final boolean enabledForSelection(IStructuredSelection structuredSelection) {
		return true; // may be altered to !structuredSelecttion.isEmpty();
	}

	private final void setContext(IStructuredSelection sel) {
		this.mSelection = sel;
	}

	@Override
	public final void run() {
		runWithSelection(this.mInputObject, this.mSelection);
	}

	/**
	 * For DEFAULTEMPTY, only one call, passing the full selection is executed
	 * 
	 * @param structuredSelection
	 */
	public abstract void runWithSelection(T inputObject, IStructuredSelection structuredSelection);

	private final boolean visibleForContext(Object context) {
		return (context instanceof RefBaseObject);
	}

	private final boolean enabledForContext(RefBaseObject context) {
		return true;
	}

	private final void setRootInput(T rootInput) {
		this.mInputObject = rootInput;
	}
}