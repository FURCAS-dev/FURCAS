package org.eclipse.emf.ecoretools.diagram.ui.outline.actions;

import org.eclipse.emf.ecoretools.diagram.ui.outline.internal.Messages;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.ui.handlers.CollapseAllHandler;

/**
 * This action delegate collapses all expanded elements in a Navigator view.
 * 
 */
public class CollapseAllAction extends Action {

	private final TreeViewer treeViewer;

	/**
	 * Create the CollapseAll action.
	 * 
	 * @param aViewer
	 *            The viewer to be collapsed.
	 */
	public CollapseAllAction(TreeViewer aViewer) {
		super(Messages.CollapseAllAction_CollapseAll);
		setToolTipText(Messages.CollapseAllAction_CollapseAll);
		setActionDefinitionId(CollapseAllHandler.COMMAND_ID);
		treeViewer = aViewer;
	}

	public void run() {
		if (treeViewer != null) {
			treeViewer.collapseAll();
		}
	}
}
