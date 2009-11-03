package com.sap.mi.tools.diagnostics.internal;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Control;

import com.sap.mi.tools.diagnostics.internal.messages.DiagnosticsMessages;
import com.sap.mi.tools.diagnostics.internal.model.NoJmxDummyNode;

/**
 * Double click listener for the diagnostics view
 * 
 * @author d031150
 */
final class DiagnosticDoubleClickListener implements IDoubleClickListener {

	public void doubleClick(final DoubleClickEvent event) {
		IStructuredSelection sel = (IStructuredSelection) event.getSelection();
		Object firstElement = sel.getFirstElement();

		if (firstElement instanceof NoJmxDummyNode) {
			final Control control = event.getViewer().getControl();
			control.getDisplay().asyncExec(new Runnable() {
				public void run() {
					String options = "-Dcom.sun.management.jmxremote -Dcom.sun.management.jmxremote.port=9876 " //$NON-NLS-1$
							+ "-Dcom.sun.management.jmxremote.authenticate=false " //$NON-NLS-1$
							+ "-Dcom.sun.management.jmxremote.ssl=false"; //$NON-NLS-1$
					MessageDialog.openInformation(control.getShell(),
							DiagnosticsMessages.DoubleClick_noJmxDialog_title, DiagnosticsMessages.bind(
									DiagnosticsMessages.DoubleClick_noJmxDialog_text, options));

					Clipboard clipboard = new Clipboard(control.getDisplay());
					try {
						clipboard.setContents(new Object[] { options }, new Transfer[] { TextTransfer.getInstance() });
					} finally {
						clipboard.dispose();
					}
				}
			});
		}
	}
}