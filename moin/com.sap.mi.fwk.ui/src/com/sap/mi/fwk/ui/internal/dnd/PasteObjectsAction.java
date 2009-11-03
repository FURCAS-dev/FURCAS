package com.sap.mi.fwk.ui.internal.dnd;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.texteditor.IWorkbenchActionDefinitionIds;

import com.sap.mi.fwk.ui.dnd.ModelClipboard;
import com.sap.mi.fwk.ui.internal.RetargetSelectionAction;
import com.sap.mi.fwk.ui.internal.messages.MiFwkUiMessages;
import com.sap.tc.moin.repository.DeepCopyResultSet;

/**
 * Pastes a number of {@link RefObject}s from the clipboard to either a
 * selected {@link RefObject} (which is assumed to be the new parent), or as
 * root objects.
 * 
 * @author d031150
 */
public final class PasteObjectsAction extends RetargetSelectionAction {

	// private static final TracerI sTracer =
	// TracingManager.getTracer(PasteRefObjectsAction.class);

	private Object mNewParent;
	private DeepCopyResultSet mCopyResult;

	public PasteObjectsAction() {
		super(MiFwkUiMessages.PasteObjectsAction_name, IWorkbenchActionDefinitionIds.PASTE, ActionFactory.PASTE);
		ISharedImages images = PlatformUI.getWorkbench().getSharedImages();
		setImageDescriptor(images.getImageDescriptor(ISharedImages.IMG_TOOL_PASTE));
		setDisabledImageDescriptor(images.getImageDescriptor(ISharedImages.IMG_TOOL_PASTE_DISABLED));

		selectionChanged(StructuredSelection.EMPTY);
	}

	@Override
	public void run() {
		// TODO [CopyPaste] detect custom association/type
		mCopyResult = getClipboard().duplicateAndPaste(mNewParent, null);
	}

	public DeepCopyResultSet getResult() {
		return mCopyResult;
	}

	/**
	 * Determines the action's enablement
	 */
	@Override
	protected boolean updateSelection(IStructuredSelection selection) {
		mNewParent = null;
		mCopyResult = null;

		// Exactly one element as parent?
		if (selection == null || selection.size() != 1)
			return false;
		mNewParent = selection.getFirstElement();
		if (mNewParent == null)
			return false;

		// Any content present?
		ModelClipboard cb = getClipboard();
		if (!cb.hasContent())
			return false;

		// Paste possible in target object?
		boolean isAllowed = cb.isTransferAllowed(mNewParent, null);
		return isAllowed;
	}

	private ModelClipboard getClipboard() {
		ModelClipboard cb = ModelClipboard.getDefault();
		return cb;
	}

}
