package com.sap.mi.fwk.ui.dnd;

import java.util.List;
import java.util.Set;
import java.util.Map.Entry;

import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.dnd.TransferData;
import org.eclipse.swt.events.TypedEvent;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;

import com.sap.mi.fwk.ui.ModelAdapterUI;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.DeepCopyResultSet;

/**
 * TODO [ModelDragDropSupport] add description
 * 
 * @author d031150
 */
public final class ModelDragDropSupport {

	public static Transfer[] getTransfersDragSource() {
		return ModelClipboard.getAllTransfers();
	}

	public static Transfer[] getTypicalTransfersDropTarget() {
		return ModelClipboard.getTargetTransfers();
	}

	public static void dragSetData(IStructuredSelection selection, DragSourceEvent event) {
		ModelClipboard cb = new ModelClipboard();
		cb.setContent(selection);
		Set<Entry<Transfer, Object>> transferData = cb.toTransfer().entrySet();
		for (Entry<Transfer, Object> entry : transferData) {
			if (entry.getKey().isSupportedType(event.dataType)) {
				event.data = entry.getValue();
				return;
			}
		}
	}

	public static void dragEnter(DropTargetEvent event) {
		Transfer[] targetTransfers = getTypicalTransfersDropTarget();
		for (Transfer transfer : targetTransfers) {
			for (TransferData dataType : event.dataTypes) {
				if (transfer.isSupportedType(dataType)) {
					event.currentDataType = dataType;
					return;
				}
			}
		}
	}

	/**
	 * Answers whether the given selection can be aggregated below the given
	 * target object. As long as this is <code>true</code> for one object in the
	 * selection, <code>true</code> is returned.
	 * 
	 * @param target
	 * @param dataType
	 */
	public static boolean validateDropForCopy(Object target, TransferData dataType) {
		LocalSelectionTransfer localTransfer = LocalSelectionTransfer.getTransfer();
		if (localTransfer.isSupportedType(dataType)) {
			IStructuredSelection sel = (IStructuredSelection) localTransfer.getSelection();
			List<RefObject> objects = ModelClipboard.toRefObjects(sel, RefObject.class);
			if (objects.isEmpty()) {
				return false;
			}
			RefObject parent = ModelAdapterUI.getInstance().getRefObject(target);
			if (parent != null) {
				boolean isAllowed = ModelClipboard.isTransferAllowed(parent, objects);
				return isAllowed;
			}
		}
		if (MriTransfer.getInstance().isSupportedType(dataType)) {
			return true;
		}
		return false;
	}

	/**
	 * Duplicates the content of the given drop event. To be used in drag and
	 * drop scenarios where a {@link MriTransferData} is available in the
	 * {@link DropTargetEvent drop target event's} {@link TypedEvent#data data}
	 * field.
	 * 
	 * @see ModelClipboard#duplicateAndPaste(Object, Connection)
	 */
	public static DeepCopyResultSet copyFromDropData(Object data, Object dropObject) {

		// if target connection or new parent are not given, try to infer them
		// from the event
		Connection[] targetConnectionArray = new Connection[1];
		RefBaseObject[] newParentArray = new RefBaseObject[1];
		IWorkbenchPart targetPart = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActivePart();
		ModelClipboard.determineConnectionAndNewParent(dropObject, targetConnectionArray, newParentArray, targetPart);
		if (targetConnectionArray[0] == null) {
			return null;
		}
		Object parent = newParentArray[0] != null ? newParentArray[0] : dropObject;

		// use an internal clipboard so that the content is not written to the
		// SWT clipboard
		ModelClipboard cb = new ModelClipboard();
		if (data instanceof MriTransferData) {
			cb.setContent((MriTransferData) data);
		} else if (data instanceof IStructuredSelection) {
			cb.setContent((IStructuredSelection) data);
		} else {
			return null;
		}

		DeepCopyResultSet result = cb.duplicateAndPaste(parent, targetConnectionArray[0]);
		return result;
	}

}
