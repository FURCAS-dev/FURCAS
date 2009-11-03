/**
 * 
 */
package com.sap.mi.tools.cockpit.editor.ui.listener;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DragSourceListener;

import com.sap.mi.tools.cockpit.editor.model.RefObjectNode;
import com.sap.mi.tools.cockpit.editor.ui.MOINBrowserView;

/**
 * @author d003456
 *
 */
public class ModelBrowserDragSourceListener implements DragSourceListener {

	/**
	 * @param viewer
	 */
	public ModelBrowserDragSourceListener(MOINBrowserView viewer) {

		Assert.isNotNull(viewer);
		this.viewer = viewer;
	}

	private final MOINBrowserView viewer;
	
	/* (non-Javadoc)
	 * @see org.eclipse.swt.dnd.DragSourceListener#dragFinished(org.eclipse.swt.dnd.DragSourceEvent)
	 */
	public void dragFinished(DragSourceEvent event) {}

	/* (non-Javadoc)
	 * @see org.eclipse.swt.dnd.DragSourceListener#dragSetData(org.eclipse.swt.dnd.DragSourceEvent)
	 */
	public void dragSetData(DragSourceEvent event) {
	}

	/* (non-Javadoc)
	 * @see org.eclipse.swt.dnd.DragSourceListener#dragStart(org.eclipse.swt.dnd.DragSourceEvent)
	 */
	public void dragStart(DragSourceEvent event) {

		event.doit = false;
		if (this.viewer.getCurrSelection() != null && this.viewer.getCurrSelection() instanceof RefObjectNode) {
			event.data = new StructuredSelection(this.viewer.getCurrSelection());
			org.eclipse.jface.util.LocalSelectionTransfer.getTransfer().setSelection(
					new StructuredSelection(this.viewer.getCurrSelection()));
			event.doit = true;
		}
	}

}
