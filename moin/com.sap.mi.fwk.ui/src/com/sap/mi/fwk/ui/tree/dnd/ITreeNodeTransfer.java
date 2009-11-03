package com.sap.mi.fwk.ui.tree.dnd;

import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;

import org.eclipse.jface.viewers.IStructuredSelection;

import com.sap.mi.fwk.ui.tree.dnd.ITreeNodeTransferHandler.TransferOperationEnum;
import com.sap.tc.moin.repository.Connection;

/**
 * This interfaces transports objects during a drag/drop or copy/paste
 * operation.
 * 
 * @author d024127
 * 
 */
public interface ITreeNodeTransfer {

	/**
	 * Gets the current transfer operation
	 * 
	 * @return one of {@link TransferOperationEnum}
	 */
	public TransferOperationEnum getTransferOperartion();

	/**
	 * Gets the current selection. Keep in mind that during a copy operation
	 * when {@link ITreeNodeCopyHandler#handleCopy(Object, ITreeNodeTransfer)}
	 * is called this method returns the current selection not the objects in
	 * the clipboard.
	 * 
	 * @return The current selection
	 */
	public IStructuredSelection getSelection();

	/**
	 * Returns all {@link RefBaseObject}s in this transfer object. Usually the
	 * selection is inspected and all {@link RefBaseObject}s in the selection
	 * are revealed in the given connection and returned.
	 * 
	 * @param con
	 *            The connection to resolve the objects in
	 * @return An object array or empty, must not be null
	 */
	public RefBaseObject[] getRefBaseObjects(Connection con);

}
