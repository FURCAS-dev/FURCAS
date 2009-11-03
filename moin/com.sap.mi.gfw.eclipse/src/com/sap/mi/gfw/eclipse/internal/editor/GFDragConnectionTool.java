package com.sap.mi.gfw.eclipse.internal.editor;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gef.tools.ConnectionDragCreationTool;

import com.sap.mi.gfw.eclipse.internal.requests.ContextButtonDragRequest;
import com.sap.mi.gfw.tb.ContextButtonEntry;

/**
 * The Class GFDragConnectionTool.
 */
public class GFDragConnectionTool extends ConnectionDragCreationTool {

	/**
	 * changed order: feedback gets deleted after command is executed (popup!).
	 * 
	 * @return true, if handle create connection
	 */
	@Override
	protected boolean handleCreateConnection() {

		Command endCommand = getCommand();
		setCurrentCommand(endCommand);
		executeCurrentCommand();
		eraseSourceFeedback();

		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.tools.ConnectionDragCreationTool#handleButtonUp(int)
	 */
	@Override
	protected boolean handleButtonUp(int button) {
		boolean b = super.handleButtonUp(button);
		setViewer(diagramEditor.getGraphicalViewer());
		diagramEditor.getEditDomain().setActiveTool(diagramEditor.getEditDomain().getDefaultTool());
		return b;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.tools.AbstractConnectionCreationTool#createTargetRequest()
	 */
	@Override
	protected Request createTargetRequest() {
		ContextButtonDragRequest request = new ContextButtonDragRequest();
		request.setType(getCommandName());
		request.setContextButtonEntry(contextButtonEntry);
		return request;
	}

	private DiagramEditor diagramEditor;

	private ContextButtonEntry contextButtonEntry;

	/**
	 * Start connection.
	 * 
	 * @param targetEditPart
	 *            the target edit part
	 * @param diagramEditor
	 *            the diagram editor
	 * @param contextButtonEntry
	 *            the context button entry
	 */
	public void startConnection(EditPart targetEditPart, DiagramEditor diagramEditor, ContextButtonEntry contextButtonEntry) {

		this.diagramEditor = diagramEditor;
		this.contextButtonEntry = contextButtonEntry;
		activate();
		setConnectionSource(targetEditPart);
		lockTargetEditPart(targetEditPart);

		((CreateConnectionRequest) getTargetRequest()).setSourceEditPart(getTargetEditPart());
		Command command = getCommand();
		if (command != null) {
			setState(STATE_CONNECTION_STARTED);
			setCurrentCommand(command);
		}

		handleDrag();
		setViewer(diagramEditor.getGraphicalViewer());
		unlockTargetEditPart();
	}

	/**
	 * Continue connection.
	 * 
	 * @param targetEditPart
	 *            the target edit part
	 * @param diagramEditor
	 *            the diagram editor
	 * @param contextButtonEntry
	 *            the context button entry
	 * @param targetTargetEditPart
	 *            the target target edit part
	 */
	public void continueConnection(EditPart targetEditPart, DiagramEditor diagramEditor, ContextButtonEntry contextButtonEntry,
			EditPart targetTargetEditPart) {

		this.diagramEditor = diagramEditor;
		this.contextButtonEntry = contextButtonEntry;
		activate();
		setConnectionSource(targetEditPart);
		lockTargetEditPart(targetEditPart);

		CreateConnectionRequest createConnectionRequest = ((CreateConnectionRequest) getTargetRequest());
		createConnectionRequest.setSourceEditPart(targetEditPart);
		createConnectionRequest.setTargetEditPart(targetTargetEditPart);
		Command command = getCommand();
		if (command != null) {
			setState(STATE_CONNECTION_STARTED);
			setCurrentCommand(command);
		}

		handleDrag();
		setViewer(diagramEditor.getGraphicalViewer());
		unlockTargetEditPart();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.tools.AbstractConnectionCreationTool#updateTargetRequest()
	 */
	@Override
	protected void updateTargetRequest() {
		// setViewer(diagramEditor.getGraphicalViewer());
		// unlockTargetEditPart();
		updateTargetUnderMouse();

		CreateConnectionRequest request = (CreateConnectionRequest) getTargetRequest();
		request.setType(getCommandName());
		//

		Point absoluteMousePosition = diagramEditor.getMouseLocation();
		request.setLocation(absoluteMousePosition);

	}

}
