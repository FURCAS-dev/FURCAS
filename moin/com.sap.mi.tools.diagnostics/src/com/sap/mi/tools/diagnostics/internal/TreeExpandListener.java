package com.sap.mi.tools.diagnostics.internal;

import org.eclipse.jface.viewers.AbstractTreeViewer;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.ITreeViewerListener;
import org.eclipse.jface.viewers.TreeExpansionEvent;

/**
 * <p>Title:       TreeExpandListener</p>
 * <p>Description: Listener expands all children of a tree item having exactly one child</p>
 * <p>Copyright:   Copyright (c) 2004</p>
 * <p>Company:     SAP AG</p>
 * @author        d031150
 * @since         NY 
 */
public class TreeExpandListener implements ITreeViewerListener {
	
	private AbstractTreeViewer mViewer;
	private ITreeContentProvider mProvider;

	/**
	 * @see org.eclipse.jface.viewers.ITreeViewerListener#treeCollapsed(org.eclipse.jface.viewers.TreeExpansionEvent)
	 */
	public void treeCollapsed(TreeExpansionEvent event) {
	}

	/**
	 * @see org.eclipse.jface.viewers.ITreeViewerListener#treeExpanded(org.eclipse.jface.viewers.TreeExpansionEvent)
	 */
	public void treeExpanded(TreeExpansionEvent event) {
		mViewer = event.getTreeViewer();
		mProvider = (ITreeContentProvider) mViewer.getContentProvider();
		expandElement(event.getElement());
	}
	
	/**
	 * Expands an element iff it has one child
	 */
	private void expandElement(Object element) {
		if (element != null) {
			Object[] children = mProvider.getChildren(element);
			if (children != null && children.length == 1) {
				mViewer.expandToLevel(element, 1);
				expandElement(children[0]);
			}
		}
	}

}
