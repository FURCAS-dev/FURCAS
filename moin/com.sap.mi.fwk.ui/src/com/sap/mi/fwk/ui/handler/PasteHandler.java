package com.sap.mi.fwk.ui.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.HandlerEvent;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;

import com.sap.mi.fwk.IRunnableWithConnection;
import com.sap.mi.fwk.ModelAdapter;
import com.sap.mi.fwk.ui.ConnectionManagerUI;
import com.sap.mi.fwk.ui.ModelAdapterUI;
import com.sap.mi.fwk.ui.dnd.ModelClipboard;
import com.sap.mi.fwk.ui.internal.dnd.DNDHelper;
import com.sap.mi.fwk.ui.internal.dnd.DefaultTreeNodeTransfer;
import com.sap.mi.fwk.ui.tree.dnd.ITreeNodeTransfer;
import com.sap.mi.fwk.ui.tree.dnd.ITreeNodeTransferHandler;
import com.sap.mi.fwk.ui.tree.dnd.ITreeNodeTransferHandler.TransferOperationEnum;
import com.sap.mi.fwk.ui.tree.nodes.ITreeNode;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

/**
 * Generic paste handler to be used in extension point org.eclipse.ui.handlers.
 * 
 * <p/>Example:
 * 
 * <pre>
 * &lt;handler class=&quot;com.sap.mi.fwk.ui.handler.PasteHandler&quot;
 *  commandId=&quot;org.eclipse.ui.edit.paste&quot;&gt;
 *  &lt;activeWhen&gt;
 *    &lt;iterate&gt;
 *      &lt;instanceof
 *        value=&quot;com.sap.mi.fwk.ui.tree.nodes.ITreeNode&quot;&gt;
 *      &lt;/instanceof&gt;
 *     &lt;/iterate&gt;
 *    &lt;/activeWhen&gt;
 * &lt;/handler&gt;
 * </pre>
 * 
 * @author d024127
 * 
 */
public class PasteHandler extends AbstractHandler {

	private transient ITreeNodeTransfer transfer;

	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		IStructuredSelection strSel = ModelAdapter.getInstance().adaptObject(selection, IStructuredSelection.class);
		if (strSel != null && !strSel.isEmpty()) {
			ITreeNodeTransferHandler dtn = ModelAdapter.getInstance().adaptObject(strSel.getFirstElement(), ITreeNodeTransferHandler.class);
			if (dtn != null) {
				// ensure connection is available otherwise return
				// since the node has no option to react opun an asynchronous
				// refresh
				Connection con = getConnection((ITreeNode<?>) dtn);
				if (con == null) {
					return null;
				}

				DefaultTreeNodeTransfer tnt = new DefaultTreeNodeTransfer(strSel, TransferOperationEnum.OPERATION_CLIPBOARD_PASTE);

				// use cache if possible
				if (!(tnt.equals(this.transfer))) {
					this.transfer = tnt;
				}
				return dtn.handleTransfer(dtn, this.transfer);
			}

			// ok, no treenode, but maybe a refobject ...
			RefObject refObj = ModelAdapterUI.getInstance().getRefObject(strSel.getFirstElement());
			if (refObj != null) {
				Connection targetConnection = ModelAdapterUI.getInstance().getConnection(refObj);
				ModelClipboard mc = ModelClipboard.getDefault();
				mc.duplicateAndPaste(refObj, targetConnection);
			}
		}
		return null;
	}

	private boolean isEnabled(IStructuredSelection strSel) {
		if (!strSel.isEmpty()) {
			Object element = strSel.getFirstElement();
			if (element instanceof ITreeNode<?>) {
				ITreeNode<?> treeNode = (ITreeNode<?>) element;
				ITreeNodeTransferHandler dtn = ModelAdapter.getInstance().adaptObject(element, ITreeNodeTransferHandler.class);
				if (dtn != null) {
					Connection con = getConnection(treeNode);
					if (con == null) {
						return false;
					}
					// construct transferable
					DefaultTreeNodeTransfer tnt = new DefaultTreeNodeTransfer(strSel, TransferOperationEnum.OPERATION_CLIPBOARD_PASTE);
					if (!(tnt.equals(this.transfer))) {
						this.transfer = tnt;
					}
					return dtn.isTransferAllowed(dtn, this.transfer);
				}
			}

			RefObject refObj = ModelAdapterUI.getInstance().getRefObject(element);
			if (refObj != null) {
				Connection targetConnection = ModelAdapterUI.getInstance().getConnection(refObj);
				ModelClipboard mc = ModelClipboard.getDefault();
				return mc.isTransferAllowed(refObj, targetConnection);
			}
		}	
		return false;
	}
	
	public boolean isEnabled() {
		if (PlatformUI.getWorkbench().isClosing() || PlatformUI.getWorkbench().getActiveWorkbenchWindow() == null) {
			return false;
		}
		ISelectionService selectionService = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService();
		ISelection selection = selectionService.getSelection();
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection strSel = (IStructuredSelection) selection;
			if( isEnabled(strSel) ) {
				return true;
			}
		}
		return super.isEnabled();
	}

	/**
	 * Retrieves the connection for a given node and initializes the connection
	 * asynchronously if necessary. Once the connection is available it will
	 * refresh the current handler resulting in updating the context menu
	 * showing the entry.
	 * 
	 * @param treeNode
	 * @return
	 */
	private Connection getConnection(ITreeNode<?> treeNode) {
		Connection con = (Connection) treeNode.getAdapter(Connection.class);
		if (con == null) {
			IProject project = DNDHelper.getProject(treeNode);
			if (project == null) {
				return null;
			}

			IRunnableWithConnection runnable = new IRunnableWithConnection() {
				public void run(Connection connection, IProgressMonitor monitor) {
					Display.getDefault().asyncExec(new Runnable() {
						public void run() {
							// update the context menu
							HandlerEvent he = new HandlerEvent(PasteHandler.this, true, false);
							fireHandlerChanged(he);
						}
					});
				}
			};
			con = ConnectionManagerUI.getInstance().getOrCreateDefaultConnectionAsync(project, runnable);
		}
		return con;
	}
}