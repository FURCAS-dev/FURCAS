package com.sap.mi.tools.mmdeploy.internal.view;

import org.eclipse.jface.viewers.ContentViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;

/**
 * Sorts metamodels depending on sort direction
 * 
 * @author d031150
 */
public final class MmSorter extends ViewerComparator {
	@Override
	public int compare(Viewer viewer, Object e1, Object e2) {
		Tree tree = (Tree) viewer.getControl();
		int dir = tree.getSortDirection();
		int sortColIdx = tree.indexOf(tree.getSortColumn());

		// "Others" is always first or last
		if (e1 instanceof MmWorkingSetNode && e2 instanceof MmWorkingSetNode) {
			if (((MmWorkingSetNode) e1).isOthers())
				return SWT.UP == dir ? 1 : -1;
			if (((MmWorkingSetNode) e2).isOthers())
				return SWT.UP == dir ? -1 : 1;
		}

		MmLabelProvider labelProvider = (MmLabelProvider) ((ContentViewer) viewer).getLabelProvider();
		String text1 = labelProvider.getColumnText(e1, sortColIdx);
		String text2 = labelProvider.getColumnText(e2, sortColIdx);
		if (SWT.UP == dir)
			return text1.compareTo(text2);
		else if (SWT.DOWN == dir)
			return text2.compareTo(text1);
		return super.compare(viewer, e1, e2);
	}

	/**
	 * Switches sort direction
	 */
	public final static class MmSortListener implements Listener {
		private final Viewer mViewer;

		public MmSortListener(Viewer viewer) {
			mViewer = viewer;
		}

		public void handleEvent(Event e) {
			TreeColumn newCol = ((TreeColumn) e.widget);
			Tree tree = newCol.getParent();
			TreeColumn oldCol = tree.getSortColumn();
			tree.setSortColumn(newCol);
			int oldDir = tree.getSortDirection();
			// Default sort behavior (see Windows Explorer):
			// direction is only inverted if same column is clicked,
			// if other column is clicked, the default direction UP is
			// preserved.
			int newDir = (oldDir == SWT.UP && oldCol.equals(newCol)) ? SWT.DOWN : SWT.UP;
			tree.setSortDirection(newDir);

			mViewer.refresh();
			// sorter does the rest
		}
	}

}
