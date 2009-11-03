package com.sap.mi.fwk.ui.tree.dnd;

import java.util.Arrays;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DragSourceListener;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.ui.views.navigator.LocalSelectionTransfer;

/**
 * PROVISIONAL This API is subject to arbitrary change, including renaming or
 * removal.
 * <p>
 * 
 * @author d024127
 * 
 */
public class TreeNodeDragListener implements DragSourceListener {

	private StructuredViewer mViewer;

	public TreeNodeDragListener(StructuredViewer viewer) {
		this.mViewer = viewer;
	}

	public void dragFinished(DragSourceEvent event) {
		// TODO Auto-generated method stub
	}

	public void dragSetData(DragSourceEvent event) {
		event.data = mViewer.getSelection();
		LocalSelectionTransfer.getTransfer().setSelection(mViewer.getSelection());

		// test ? To String ?
		if (Arrays.asList(TextTransfer.getInstance().getSupportedTypes()).contains(event.dataType)) {
			String s = objectToSortedNameString(mViewer.getSelection());
			TextTransfer.getInstance().javaToNative(s, event.dataType);
		}

		event.doit = true;
	}

	public void dragStart(DragSourceEvent event) {
		event.doit = false;
		if (mViewer.getSelection() != null) {
			event.data = ((IStructuredSelection) mViewer.getSelection()).getFirstElement();
			event.data = mViewer.getSelection();
			LocalSelectionTransfer.getTransfer().setSelection(mViewer.getSelection());
			event.doit = true;
		}
	}

	private static String objectToSortedNameString(Object selection) {
		// Object lst = selection;
		// if (selection == null)
		//			return "(null)"; //$NON-NLS-1$

		if (selection instanceof IStructuredSelection) {
			IStructuredSelection ssel = (IStructuredSelection) selection;
			if (!ssel.isEmpty()) {
				StringBuilder sb = new StringBuilder();
				for (Object o : ssel.toList()) {
					sb.append(o).append(", "); //$NON-NLS-1$
				}
			}
		}
		return selection.toString();
	}
}
