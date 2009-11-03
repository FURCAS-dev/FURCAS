package com.sap.mi.fwk.ui.tree.dnd;

/**
 * PROVISIONAL This API is subject to arbitrary change, including renaming or
 * removal.
 * <p>
 * 
 * @author d024127
 * 
 */
public interface ITreeNodeTransferHandler {

	public static enum TransferOperationEnum {
		OPERATION_DRAGDROP_MOVE, // operation for simple drag/drop
		OPERATION_DRAGDROP_COPY, // operation for drag + ctrl key
		OPERATION_CLIPBOARD_COPY, // operation for pressing ctrl + C and
									// copying to clipboard
		OPERATION_CLIPBOARD_PASTE, // operation for pressing ctrl + V and
									// 	pasting from clipboard
		OPERATION_UNKNOWN; // unknown operation
	}

	/**
	 * This method is invoked when the user either releases the mouse (drops)
	 * some objects or when the user presses ctrl + v.
	 * 
	 * @param target
	 *            The object where the selection has been dropped or where ctrl +
	 *            v has been pressed
	 * @param transfer
	 *            All selected objects
	 * @return True, if transfer was successful
	 * @see TransferOperationEnum
	 */
	public boolean handleTransfer(Object target, ITreeNodeTransfer transfer);

	/**
	 * This method is invoked when the user hovers over an objects or when the
	 * paste menu entry is about to be activated. If the method returns false,
	 * the menu entry will be disable or the mouse pointer will show the no
	 * parking sign to visualize that a drop is not possible. This this method
	 * is called frequently it must be reasonable fast.
	 * 
	 * @param target
	 *            The object where the selection is hovering over or where ctrl +
	 *            v should be activated
	 * @param transfer
	 *            All selected objects
	 * @return True, if transfer is allowed
	 * @see TransferOperationEnum
	 */
	public boolean isTransferAllowed(Object target, ITreeNodeTransfer transfer);
}