package com.sap.mi.fwk.ui.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

import com.sap.mi.fwk.ModelAdapter;
import com.sap.mi.fwk.ui.dnd.ModelClipboard;
import com.sap.mi.fwk.ui.internal.dnd.DefaultTreeNodeTransfer;
import com.sap.mi.fwk.ui.tree.dnd.ITreeNodeCopyHandler;
import com.sap.mi.fwk.ui.tree.dnd.ITreeNodeTransfer;
import com.sap.mi.fwk.ui.tree.dnd.ITreeNodeTransferHandler.TransferOperationEnum;

/**
 * <pre>
 * &lt;handler class=&quot;com.sap.mi.fwk.ui.handler.CopyHandler&quot; 
 * 		commandId=&quot;org.eclipse.ui.edit.copy&quot;&gt;
 * 	&lt;activeWhen&gt;
 * 		...
 * 	&lt;/activeWhen&gt;
 * 	&lt;enabledWhen&gt;
 * 		...
 * 	&lt;/enabledWhen&gt;
 * &lt;/handler&gt;
 * </pre>
 * 
 * @author d024127
 * 
 */
public class CopyHandler extends AbstractHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		IStructuredSelection strSel = ModelAdapter.getInstance().adaptObject(selection, IStructuredSelection.class);
		if (strSel != null && !strSel.isEmpty()) {
			// is target object a ITreeNodeCopyHandler ?
			ITreeNodeCopyHandler dtn = ModelAdapter.getInstance().adaptObject(strSel.getFirstElement(), ITreeNodeCopyHandler.class);
			if (dtn != null) {
				ITreeNodeTransfer tnt = new DefaultTreeNodeTransfer(strSel, TransferOperationEnum.OPERATION_CLIPBOARD_COPY);
				return dtn.handleCopy(dtn, tnt);
			}

			// node does not implement ITreeNodeCopyHandler, so let's framework
			// try to handle using the SWT clipboard
			ModelClipboard mc = ModelClipboard.getDefault();
			mc.setContent(strSel);
		}
		return null;
	}
}