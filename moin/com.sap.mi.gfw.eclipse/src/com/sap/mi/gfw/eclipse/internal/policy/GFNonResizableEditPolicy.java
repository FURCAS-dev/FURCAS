package com.sap.mi.gfw.eclipse.internal.policy;

import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;

import com.sap.mi.gfw.eclipse.internal.config.IConfigurationProvider;
import com.sap.mi.gfw.eclipse.internal.util.draw2d.GfwHandleHelper;
import com.sap.mi.gfw.eclipse.internal.util.draw2d.TransparentGhostFigure;

public class GFNonResizableEditPolicy extends NonResizableEditPolicy {
	private GfwEditPolicyDelegate delegate;

	public GFNonResizableEditPolicy(IConfigurationProvider cfgProvider) {
		setDelegate(new GfwEditPolicyDelegate(cfgProvider));
	}

	private IConfigurationProvider getConfigurationProvider() {
		return getDelegate().getConfigurationProvider();
	}

	private GfwEditPolicyDelegate getDelegate() {
		return delegate;
	}

	private void setDelegate(GfwEditPolicyDelegate delegate) {
		this.delegate = delegate;
	}

	@Override
	protected IFigure createDragSourceFeedbackFigure() {
		IFigure feedback = new TransparentGhostFigure(getHostFigure(), 70, getConfigurationProvider().getDiagramEditor().getZoomLevel());
		addFeedback(feedback);
		return feedback;
	}

	@Override
	protected List createSelectionHandles() {
		GraphicalEditPart owner = (GraphicalEditPart) getHost();
		List list = GfwHandleHelper.createShapeHandles(owner, getConfigurationProvider(), 0, isDragAllowed());
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.editpolicies.SelectionHandlesEditPolicy#hideSelection()
	 */
	@Override
	protected void hideSelection() {
		getDelegate().hideSelection(getHostFigure());
		removeSelectionHandles();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.editpolicies.SelectionEditPolicy#showPrimarySelection()
	 */
	@Override
	protected void showPrimarySelection() {
		getDelegate().showPrimarySelection(getHostFigure());
		addSelectionHandles();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.editpolicies.SelectionHandlesEditPolicy#showSelection()
	 */
	@Override
	protected void showSelection() {
		getDelegate().showSelection(getHostFigure());
		addSelectionHandles();
	}

	@Override
	public void eraseSourceFeedback(Request request) {
		/* dispose ghosts */
		List<IFigure> children = getFeedbackLayer().getChildren();
		for (IFigure child : children) {
			if (child instanceof TransparentGhostFigure) {
				((TransparentGhostFigure) child).dispose();
			}
		}
		super.eraseSourceFeedback(request);
	}
}
