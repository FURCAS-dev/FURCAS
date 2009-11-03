package com.sap.mi.gfw.eclipse.internal.dnd;

import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.dnd.AbstractTransferDropTargetListener;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gef.requests.CreationFactory;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.dnd.DND;
import org.eclipse.ui.views.navigator.LocalSelectionTransfer;

public class ObjectsTransferDropTargetListener extends AbstractTransferDropTargetListener {

	public ObjectsTransferDropTargetListener(EditPartViewer viewer) {
		super(viewer, LocalSelectionTransfer.getInstance());
		setEnablementDeterminedByCommand(true);
	}

	@Override
	protected void handleDrop() {
		super.handleDrop();
	}

	@Override
	protected void updateTargetRequest() {
		((CreateRequest) getTargetRequest()).setLocation(getDropLocation());
	}

	@Override
	protected Request createTargetRequest() {
		CreateRequest request = new CreateRequest();

		request.setFactory(new MyCreationFactory());
		request.setLocation(getDropLocation());
		return request;
	}

	@Override
	protected void handleDragOver() {

		super.handleDragOver();

		Command command = getCommand();
		if (command != null && command.canExecute())
			getCurrentEvent().detail = DND.DROP_COPY;
	}

	private class MyCreationFactory implements CreationFactory {

		public MyCreationFactory() {
		}

		public Object getNewObject() {
			return LocalSelectionTransfer.getInstance().getSelection();
		}

		public Object getObjectType() {
			return ISelection.class;
		}
	}
}