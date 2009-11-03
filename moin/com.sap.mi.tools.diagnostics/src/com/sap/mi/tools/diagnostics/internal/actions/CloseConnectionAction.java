package com.sap.mi.tools.diagnostics.internal.actions;

import java.io.IOException;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;

import com.sap.mi.tools.diagnostics.internal.messages.DiagnosticsMessages;
import com.sap.mi.tools.diagnostics.internal.model.ConnectionNode;
import com.tssap.util.ui.dialog.ExtendedMessageDialog;

/**
 * Closes a connection
 * 
 * @author d031150
 */
public class CloseConnectionAction extends DiagnosticsViewerAction {

	private final Shell mShell;

	CloseConnectionAction(Shell shell, StructuredViewer viewer) {
		super("Close", viewer); //$NON-NLS-1$
		mShell = shell;
	}

	@Override
	protected boolean updateSelection(IStructuredSelection structuredSelection) {
		if (!structuredSelection.isEmpty()) {
			Object firstElement = structuredSelection.getFirstElement();
			if (firstElement instanceof ConnectionNode) {
				ConnectionNode connectionNode = ((ConnectionNode) firstElement);
				if (!connectionNode.isAlive())
					return false;
				return true;
			}
		}
		return false;
	}

	public boolean isAvailable() {
		IStructuredSelection selection = getStructuredSelection();
		if (!selection.isEmpty()) {
			Object firstElement = selection.getFirstElement();
			if (firstElement instanceof ConnectionNode) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void run() {
		IStructuredSelection selection = getStructuredSelection();
		Object firstElement = selection.getFirstElement();
		if (firstElement instanceof ConnectionNode) {
			ConnectionNode connectionNode = (ConnectionNode) firstElement;
			try {
				if (connectionNode.isDirty()) {
					boolean proceed = MessageDialog.openQuestion(mShell,
							DiagnosticsMessages.CloseConnectionAction_dirtyDialog_title,
							DiagnosticsMessages.CloseConnectionAction_dirtyDialog_text);
					if (!proceed)
						return;
				} else {
					MessageDialog dialog = new MessageDialog(mShell,
							DiagnosticsMessages.CloseConnectionAction_closeDialog_title, null,
							DiagnosticsMessages.CloseConnectionAction_closeDialog_text, MessageDialog.WARNING,
							new String[] { IDialogConstants.OK_LABEL, IDialogConstants.CANCEL_LABEL }, 0);
					if (dialog.open() != Window.OK)
						return;
				}
				connectionNode.close();
			} catch (IOException e) {
				ExtendedMessageDialog.showError(mShell, "Error on Close", //$NON-NLS-1$
						e.getMessage(), null, new String[] { IDialogConstants.OK_LABEL }, e);
			}
		}

		mViewer.refresh();
	}

}
