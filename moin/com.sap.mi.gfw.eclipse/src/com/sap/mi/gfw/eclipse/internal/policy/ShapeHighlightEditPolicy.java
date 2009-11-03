package com.sap.mi.gfw.eclipse.internal.policy;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.GraphicalEditPolicy;

import com.sap.mi.gfw.eclipse.internal.config.IConfigurationProvider;
import com.sap.mi.gfw.platform.ga.IVisualState;
import com.sap.mi.gfw.platform.ga.IVisualStateHolder;

/**
 * An EditPolicy, which gives feedback for if an EditPart is selected. It does not create any commands.
 * 
 * @see com.sap.ide.eclipse.gf.policy.IEditPolicyFactory#createShapeHighlightEditPolicy()
 */
public class ShapeHighlightEditPolicy extends GraphicalEditPolicy {

	private IConfigurationProvider _configurationProvider;

	/**
	 * Creates a new ShapeHighlightEditPolicy.
	 * 
	 * @param configurationProvider
	 *            The IConfigurationProvider.
	 */
	protected ShapeHighlightEditPolicy(IConfigurationProvider configurationProvider) {
		_configurationProvider = configurationProvider;
	}

	protected final IConfigurationProvider getConfigurationProvider() {
		return _configurationProvider;
	}

	/**
	 * Returns a _target EditPart only, if the request is REQ_SELECTION_HOVER. By this it filters all other requests out (note, that this
	 * EditPolicy does not overwrite getCommand(), which is usually used to filter the requests).
	 * 
	 * @see org.eclipse.gef.EditPolicy#getTargetEditPart(org.eclipse.gef.Request)
	 */
	@Override
	public EditPart getTargetEditPart(Request request) {
		return request.getType().equals(RequestConstants.REQ_SELECTION_HOVER) ? getHost() : null;
	}

	/**
	 * Is called, when the previously 'selected' EditPart is 'deselected'. It then disables the highlight of the selected EditPart.
	 * 
	 * @see org.eclipse.gef.EditPolicy#eraseTargetFeedback(org.eclipse.gef.Request)
	 */
	@Override
	public void eraseTargetFeedback(Request request) {
		IFigure containerFigure = ((GraphicalEditPart) getHost()).getFigure();
		if (containerFigure instanceof IVisualStateHolder) {
			IVisualStateHolder feedbackRenderer = (IVisualStateHolder) containerFigure;
			IVisualState vs = feedbackRenderer.getVisualState();
			vs.setActionTargetFeedback(IVisualState.ACTION_TARGET_FEEDBACK_OFF);
		}
	}

	/**
	 * Is called when the EditPart is 'selected'. It then checks, if the request is one of those, which can be handled by the selected
	 * EditPart (which means that EditPart.getCommand(request) returns an executeable command. In this case it highlights the selected
	 * EditPart.
	 * 
	 * @see org.eclipse.gef.EditPolicy#showTargetFeedback(org.eclipse.gef.Request)
	 */
	@Override
	public void showTargetFeedback(Request request) {
		if (request.getType().equals(RequestConstants.REQ_CONNECTION_START)
				|| request.getType().equals(RequestConstants.REQ_CONNECTION_END)
				|| request.getType().equals(RequestConstants.REQ_RECONNECT_TARGET)
				|| request.getType().equals(RequestConstants.REQ_RECONNECT_SOURCE) || request.getType().equals(RequestConstants.REQ_CREATE)
				|| request.getType().equals(RequestConstants.REQ_ADD)) {
			Command command = getHost().getCommand(request);
			showHighlight(command != null && command.canExecute());
		}
	}

	// ===================== private helper methods ===========================

	private void showHighlight(boolean canExecute) {
		IFigure containerFigure = ((GraphicalEditPart) getHost()).getFigure();
		if (containerFigure instanceof IVisualStateHolder) {
			IVisualStateHolder feedbackRenderer = (IVisualStateHolder) containerFigure;
			IVisualState vs = feedbackRenderer.getVisualState();
			if (canExecute)
				vs.setActionTargetFeedback(IVisualState.ACTION_TARGET_ALLOWED);
			else
				vs.setActionTargetFeedback(IVisualState.ACTION_TARGET_FORBIDDEN);
		}
	}
}