package com.sap.mi.tools.cockpit.editor.ui.listener;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.DropTargetListener;
import org.eclipse.swt.widgets.TreeItem;

import com.sap.mi.fwk.ConnectionManager;
import com.sap.mi.fwk.internal.tracing.MiLocations;
import com.sap.mi.tools.cockpit.editor.Messages;
import com.sap.mi.tools.cockpit.editor.model.ModelPartitionNode;
import com.sap.mi.tools.cockpit.editor.model.RefObjectNode;
import com.sap.mi.tools.cockpit.editor.model.RefObjectNodeSearcher;
import com.sap.mi.tools.cockpit.editor.model.command.MoveToParitionCommand;
import com.sap.mi.tools.cockpit.editor.model.properties.PropertyHelper;
import com.sap.mi.tools.cockpit.editor.ui.MOINBrowserView;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

/**
 * @author d003456
 * 
 */
public class ModelBrowserDropListener implements DropTargetListener {

	private final MOINBrowserView viewer;

	private final RefObjectNodeSearcher refObjectNodeSearcher;

	private static final Logger tracer = Logger.getLogger(MiLocations.MI_MODELBROWSER);

	private static final String SEARCH_START = "Search started for "; //$NON-NLS-1$

	private static final String MESSAGE_DIALOG_TITLE = Messages.ModelBrowserDragAndDropListener_0_xhed;

	private static final String MESSAGE_DIALOG_REF_OBJECT_NULL = Messages.ModelBrowserDragAndDropListener_1_xmsg;

	/**
	 * Creates {@link ModelBrowserDropListener}.
	 * 
	 * @param viewer
	 *            the {@link MOINBrowserView} viewer
	 */
	public ModelBrowserDropListener(MOINBrowserView viewer) {

		Assert.isNotNull(viewer);
		this.viewer = viewer;
		this.refObjectNodeSearcher = new RefObjectNodeSearcher(this.viewer);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.swt.dnd.DropTargetListener#dragEnter(org.eclipse.swt.dnd.DropTargetEvent)
	 */
	public void dragEnter(DropTargetEvent event) {

		// show always move mouse image
		if (event.detail == DND.DROP_DEFAULT) {
			if ((event.operations & DND.DROP_COPY) != 0) {
				event.detail = DND.DROP_COPY;
			} else {
				event.detail = DND.DROP_NONE;
			}
		}
		event.detail = DND.DROP_MOVE;
		final ISelection obj = org.eclipse.jface.util.LocalSelectionTransfer.getTransfer().getSelection();
		// will accept only RefObject
		if (MOINBrowserView.getRefObject(obj) == null) {
			event.detail = DND.DROP_NONE;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.swt.dnd.DropTargetListener#dragLeave(org.eclipse.swt.dnd.DropTargetEvent)
	 */
	public void dragLeave(DropTargetEvent event) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.swt.dnd.DropTargetListener#dragOperationChanged(org.eclipse.swt.dnd.DropTargetEvent)
	 */
	public void dragOperationChanged(DropTargetEvent event) {

		if (event.detail == DND.DROP_DEFAULT) {
			if ((event.operations & DND.DROP_COPY) != 0) {
				event.detail = DND.DROP_COPY;
			} else if ((event.operations & DND.DROP_MOVE) != 0) {
				event.detail = DND.DROP_MOVE;
			} else {
				event.detail = DND.DROP_NONE;
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.swt.dnd.DropTargetListener#dragOver(org.eclipse.swt.dnd.DropTargetEvent)
	 */
	public void dragOver(DropTargetEvent event) {

		event.detail = DND.DROP_MOVE;
		final ISelection selection = org.eclipse.jface.util.LocalSelectionTransfer.getTransfer().getSelection();
		final RefObject refObject = MOINBrowserView.getRefObject(selection);
		final TreeItem target = (TreeItem) event.item;
		if (refObject == null) {
			event.detail = DND.DROP_NONE;
			event.feedback = DND.FEEDBACK_NONE;
			return;
		}

		if (isModelBrowserElement(selection, target)) {
			if (!(target.getData() instanceof ModelPartitionNode)) {
				event.detail = DND.DROP_NONE;
			} else {
				final ModelPartitionNode modelPartitionNode = (ModelPartitionNode) target.getData();
				if (!isMoveOnModelPartitionNodeAllowed(refObject, modelPartitionNode)) {
					event.detail = DND.DROP_NONE;
				} else {
					// event.feedback = DND.FEEDBACK_EXPAND;
					event.feedback = DND.FEEDBACK_SELECT;
				}
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.swt.dnd.DropTargetListener#drop(org.eclipse.swt.dnd.DropTargetEvent)
	 */
	public void drop(DropTargetEvent event) {

		final ISelection obj = org.eclipse.jface.util.LocalSelectionTransfer.getTransfer().getSelection();
		final RefObject refObject = MOINBrowserView.getRefObject(obj);
		final String msg = ""; //$NON-NLS-1$
		final TreeItem target = (TreeItem) event.item;

		if (isModelBrowserElement(obj, target)) {
			moveRefObjectFromMyView(event, refObject, target);
			this.refObjectNodeSearcher.revealRefObjectNodeinModelTree(refObject);
		} else {
			revealRefObjectFromOtherView(event, refObject, msg);
		}

	}

	private void revealRefObjectFromOtherView(DropTargetEvent event, final RefObject refObject, String msg) {

		if (refObject == null) {
			event.detail = DND.DROP_NONE;
			ModelBrowserDropListener.tracer.logp(Level.FINE, ModelBrowserDropListener.class.getName(), "revealRefObjectFromOtherView", //$NON-NLS-1$
					ModelBrowserDropListener.MESSAGE_DIALOG_REF_OBJECT_NULL);
			MessageDialog.openInformation(this.viewer.getTreeViewer().getControl().getShell(),
					ModelBrowserDropListener.MESSAGE_DIALOG_TITLE, ModelBrowserDropListener.MESSAGE_DIALOG_REF_OBJECT_NULL);
		} else {
			// trace search is starting
			final PropertyHelper helper = new PropertyHelper();
			final String name = helper.getQualifiedName(refObject);
			if (ModelBrowserDropListener.tracer.isLoggable(Level.FINE)) {
				msg = ModelBrowserDropListener.SEARCH_START + name;
			}
			ModelBrowserDropListener.tracer.logp(Level.FINE, ModelBrowserDropListener.class.getName(), "revealRefObjectFromOtherView", msg); //$NON-NLS-1$

			// reveal RefObject, otherwise display message and trace
			if (!this.refObjectNodeSearcher.revealRefObjectNodeinModelTree(refObject)) {
				msg = ""; //$NON-NLS-1$
				final String msgPattern = Messages.ModelBrowserDragAndDropListener_2_xmsg;
				msg = MessageFormat.format(msgPattern, new Object[] { name });
				ModelBrowserDropListener.tracer.logp(Level.FINE, ModelBrowserDropListener.class.getName(), "revealRefObjectFromOtherView", msg); //$NON-NLS-1$
				MessageDialog.openInformation(this.viewer.getTreeViewer().getControl().getShell(),
						ModelBrowserDropListener.MESSAGE_DIALOG_TITLE, msg);
			}
		}
	}

	private void moveRefObjectFromMyView(DropTargetEvent event, final RefObject refObject, TreeItem target) {

		if (target.getData() instanceof ModelPartitionNode) {
			final ModelPartitionNode partNode = (ModelPartitionNode) target.getData();
			final ModelPartition mp = partNode.getValue();
			if (isMoveOnModelPartitionNodeAllowed(refObject, partNode)) {
				new MoveToParitionCommand(refObject, mp).execute();
				final Collection<Connection> connections = new ArrayList<Connection>();
				connections.add(refObject.get___Connection());
				final IStatus status = ConnectionManager.getInstance().save(connections, null);
				if (status != null && !status.isOK()) {
					ModelBrowserDropListener.tracer.logp(Level.SEVERE, ModelBrowserDropListener.class.getName(),
							"moveRefObjectFromMyView", status.getMessage(), status.getException()); //$NON-NLS-1$
				}
			} else {
				event.detail = DND.DROP_NONE;
			}
		}
	}

	private boolean isModelBrowserElement(ISelection selection, TreeItem target) {

		boolean result = false;
		if (selection != null && target != null && !selection.isEmpty() && selection instanceof IStructuredSelection) {
			final IStructuredSelection structSelection = (IStructuredSelection) selection;
			if (!structSelection.isEmpty() && structSelection.getFirstElement() instanceof RefObjectNode && target.getData() != null) {
				result = true;
			}
		}
		return result;
	}

	private boolean isMoveOnModelPartitionNodeAllowed(RefObject refObject, ModelPartitionNode modelPartionNode) {

		final Collection<Partitionable> elements = modelPartionNode.getValue().getElements();
		return !elements.contains(refObject);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.swt.dnd.DropTargetListener#dropAccept(org.eclipse.swt.dnd.DropTargetEvent)
	 */
	public void dropAccept(DropTargetEvent event) {

	}
}
