/**
 * 
 */
package com.sap.mi.tools.cockpit.mql.ui.search;

import org.eclipse.jface.viewers.TableViewer;
import org.omg.PortableInterceptor.INACTIVE;

/**
 * @author d003456
 * 
 */
public class TableViewerNavigator implements INavigate, INACTIVE {

	private final TableViewer viewer;

	/**
	 * Constructor
	 * 
	 * @param viewer
	 */
	public TableViewerNavigator(TableViewer viewer) {

		this.viewer = viewer;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.tools.cockpit.mql.ui.search.INavigate#navigateNext(boolean)
	 */
	public void navigateNext(boolean forward) {

		final int itemCount = this.viewer.getTable().getItemCount();
		if (itemCount == 0) {
			return;
		}
		final int[] selection = this.viewer.getTable().getSelectionIndices();
		int nextIndex = 0;
		if (selection.length > 0) {
			if (forward) {
				nextIndex = selection[selection.length - 1] + 1;
				if (nextIndex >= itemCount) {
					nextIndex = 0;
				}
			} else {
				nextIndex = selection[0] - 1;
				if (nextIndex < 0) {
					nextIndex = itemCount - 1;
				}
			}
		}
		this.viewer.getTable().setSelection(nextIndex);
		this.viewer.getTable().showSelection();

	}
}
