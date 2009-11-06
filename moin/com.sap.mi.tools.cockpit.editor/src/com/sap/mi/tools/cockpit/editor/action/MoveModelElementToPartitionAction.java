/**
 * 
 */
package com.sap.mi.tools.cockpit.editor.action;

import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;

import com.sap.mi.fwk.ConnectionManager;
import com.sap.mi.fwk.internal.tracing.MiLocations;
import com.sap.mi.fwk.ui.tree.nodes.ITreeNode;
import com.sap.mi.tools.cockpit.editor.Messages;
import com.sap.mi.tools.cockpit.editor.model.ProjectRootNode;
import com.sap.mi.tools.cockpit.editor.model.RefObjectNode;
import com.sap.mi.tools.cockpit.editor.model.RefObjectNodeSearcher;
import com.sap.mi.tools.cockpit.editor.model.command.MoveToParitionCommand;
import com.sap.mi.tools.cockpit.editor.ui.MOINBrowserView;
import com.sap.mi.tools.cockpit.editor.ui.dialog.select.SelectPartionDialog;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;

/**
 * @author d003456
 *
 */
public class MoveModelElementToPartitionAction extends Action {

	private static final Logger tracer = Logger.getLogger(MiLocations.MI_MODELBROWSER);

	private final MOINBrowserView viewer;

	private final RefObjectNodeSearcher refObjectNodeSearcher;

	/**
	 * @param viewer
	 */
	public MoveModelElementToPartitionAction(MOINBrowserView viewer) {

		super("MoveModelElementToPartitionAction"); //$NON-NLS-1$
		Assert.isNotNull(viewer);
		this.viewer = viewer;
		this.refObjectNodeSearcher = new RefObjectNodeSearcher(this.viewer);
		setText(Messages.MoveModelElementToPartitionAction_0_xmit);
		setToolTipText(Messages.MoveModelElementToPartitionAction_1_xtol);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.action.Action#run()
	 */
	@Override
	public void run() {

		final ITreeNode<?> node = this.viewer.getCurrSelection();
		if (node != null && node instanceof RefObjectNode) {
			final RefObjectNode refObjectNode = (RefObjectNode) node;

			final ProjectRootNode projectNode = getProjectRootNode(refObjectNode);
			final SelectPartionDialog dialog = new SelectPartionDialog(Display.getCurrent().getActiveShell(), false, projectNode
					.getPartitinsOfProject(), refObjectNode.getValue().get___Partition());
			if (dialog.open() == Window.OK) {
				final ModelPartition modelPartition = (ModelPartition) dialog.getFirstResult();

				new MoveToParitionCommand(refObjectNode.getValue(), modelPartition).execute();

				final Collection<Connection> connections = new ArrayList<Connection>();
				connections.add(refObjectNode.getValue().get___Connection());
				final IStatus status = ConnectionManager.getInstance().save(connections, null);
				if (status != null && !status.isOK()) {
					MoveModelElementToPartitionAction.tracer.logp(Level.SEVERE, MoveModelElementToPartitionAction.class.getName(),
							"moveRefObjectFromMyView", status.getMessage(), status.getException()); //$NON-NLS-1$
				}
				this.refObjectNodeSearcher.revealRefObjectNodeinModelTree(refObjectNode.getValue());
			}
		}
	}

	private ProjectRootNode getProjectRootNode(ITreeNode<?> parent) {

		while (!(parent instanceof ProjectRootNode)) {
			parent = (ITreeNode<?>) parent.getParent();
		}
		return (ProjectRootNode) parent;
	}

}
