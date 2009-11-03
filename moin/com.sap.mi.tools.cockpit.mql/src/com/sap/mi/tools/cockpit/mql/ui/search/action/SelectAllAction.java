package com.sap.mi.tools.cockpit.mql.ui.search.action;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

import com.sap.mi.tools.cockpit.mql.Messages;

/**
 * This action selects all entries currently showing in view.
 * 
 * @author d003456
 * 
 */
public final class SelectAllAction extends Action {

	private StructuredViewer viewer;

	private final static String SELECT_ALL_ACTION_LABEL = Messages.SelectAllAction_0_xmit;

	private final static String SELECT_ALL_ACTION_TOOLTIP = Messages.SelectAllAction_1_xtol;

	/**
	 * Creates the action.
	 */
	public SelectAllAction() {

		super("selectAll"); //$NON-NLS-1$
		setText(SelectAllAction.SELECT_ALL_ACTION_LABEL);
		setToolTipText(SelectAllAction.SELECT_ALL_ACTION_TOOLTIP);

	}

	public void setViewer(StructuredViewer viewer) {

		this.viewer = viewer;

	}

	private void collectExpandedAndVisible(TreeItem[] items, List<TreeItem> result) {

		for (int i = 0; i < items.length; i++) {
			final TreeItem item = items[i];
			result.add(item);
			if (item.getExpanded()) {
				collectExpandedAndVisible(item.getItems(), result);
			}
		}

	}

	/**
	 * Selects all rows from <code>MQLResultSet</code> in the view.
	 */
	@Override
	public void run() {

		if (this.viewer == null || this.viewer.getControl().isDisposed()) {
			return;
		}
		if (this.viewer instanceof TreeViewer) {
			final ArrayList<TreeItem> allVisible = new ArrayList<TreeItem>();
			final Tree tree = ((TreeViewer) this.viewer).getTree();
			collectExpandedAndVisible(tree.getItems(), allVisible);
			tree.setSelection(allVisible.toArray(new TreeItem[allVisible.size()]));
		} else if (this.viewer instanceof TableViewer) {
			((TableViewer) this.viewer).getTable().selectAll();
			//
			// force viewer selection change
			//
			this.viewer.setSelection(this.viewer.getSelection());
		}
	}
}
