package com.sap.mi.fwk.ui.internal.dnd;

import java.util.ArrayList;
import java.util.List;

import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.texteditor.IWorkbenchActionDefinitionIds;

import com.sap.mi.fwk.ui.ModelAdapterUI;
import com.sap.mi.fwk.ui.dnd.ModelClipboard;
import com.sap.mi.fwk.ui.internal.RetargetSelectionAction;
import com.sap.mi.fwk.ui.internal.messages.MiFwkUiMessages;

/**
 * Copies a number of {@link RefBaseObject}s to the default clipboard. To be used
 * in connection with {@link PasteObjectsAction}
 * 
 * @author d031150
 */
public final class CopyObjectsAction extends RetargetSelectionAction {

	private final List<RefBaseObject> mObjects = new ArrayList<RefBaseObject>();

	public CopyObjectsAction() {
		super(MiFwkUiMessages.CopyObjectsAction_name, IWorkbenchActionDefinitionIds.COPY, ActionFactory.COPY);

		ISharedImages images = PlatformUI.getWorkbench().getSharedImages();
		setDisabledImageDescriptor(images.getImageDescriptor(ISharedImages.IMG_TOOL_COPY_DISABLED));
		setImageDescriptor(images.getImageDescriptor(ISharedImages.IMG_TOOL_COPY));
		
		selectionChanged(StructuredSelection.EMPTY);
	}

	@Override
	public void run() {
		if (mObjects.isEmpty())
			return;

		ModelClipboard cb = ModelClipboard.getDefault();
		cb.setContent(mObjects.toArray(new RefBaseObject[mObjects.size()]));
	}

	@Override
	protected boolean updateSelection(IStructuredSelection selection) {
		mObjects.clear();
		if (selection == null || selection.isEmpty())
			return false;

		Object[] elements = selection.toArray();
		for (Object element : elements) {
			RefBaseObject o = ModelAdapterUI.getInstance().getRefBaseObject(element);
			if (o == null)
				o = ModelAdapterUI.getInstance().getRefObject(element);
			if (o != null) {
				mObjects.add(o);
			} else {
				mObjects.clear();
				return false;
			}
		}
		return true;
	}

}
