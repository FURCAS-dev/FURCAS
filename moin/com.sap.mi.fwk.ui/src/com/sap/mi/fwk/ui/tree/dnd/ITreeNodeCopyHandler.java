package com.sap.mi.fwk.ui.tree.dnd;

/**
 * Tree nodes implementing this interface decide to handle a copy request
 * (usually by pressing ctrl + c) themselves.
 * 
 * @author d024127
 * 
 */
public interface ITreeNodeCopyHandler {

	/**
	 * The copy handler which is called when the user presses ctrl + c or
	 * selects the corresponding menu entry for copy.
	 * 
	 * @param source
	 *            The object where the menu entry was selected
	 * @param transfer
	 *            The current transfer object
	 * @return the result of the execution. Reserved for future use, must be
	 *         <code>null</code>.
	 */
	public boolean handleCopy(Object source, ITreeNodeTransfer transfer);
}
