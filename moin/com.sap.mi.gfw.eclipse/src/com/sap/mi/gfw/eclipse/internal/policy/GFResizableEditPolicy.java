package com.sap.mi.gfw.eclipse.internal.policy;

import java.util.Collections;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.editpolicies.ResizableEditPolicy;

import com.sap.mi.gfw.eclipse.internal.config.IConfigurationProvider;
import com.sap.mi.gfw.eclipse.internal.util.draw2d.GfwHandleHelper;
import com.sap.mi.gfw.eclipse.internal.util.draw2d.TransparentGhostFigure;
import com.sap.mi.gfw.features.IResizeConfiguration;
import com.sap.mi.gfw.features.IResizeShapeFeature;
import com.sap.mi.gfw.features.context.IResizeShapeContext;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;

public class GFResizableEditPolicy extends ResizableEditPolicy {
	private GfwEditPolicyDelegate delegate;
	private IResizeShapeContext resizeShapeContext;

	public GFResizableEditPolicy(IConfigurationProvider cfgProvider) {
		setDelegate(new GfwEditPolicyDelegate(cfgProvider));
	}

	public GFResizableEditPolicy(IConfigurationProvider configurationProvider, IResizeShapeContext resizeShapeContext) {
		this(configurationProvider);
		setResizeShapeContext(resizeShapeContext);
	}

	@Override
	protected IFigure createDragSourceFeedbackFigure() {
		IFigure feedback = new TransparentGhostFigure(getHostFigure(), 70, getConfigurationProvider().getDiagramEditor().getZoomLevel());
		addFeedback(feedback);
		return feedback;
	}

	@Override
	protected List createSelectionHandles() {
		if (getResizeShapeFeature() == null || !getResizeShapeFeature().canResizeShape(getResizeShapeContext())) {
			return Collections.EMPTY_LIST;
		}

		GraphicalEditPart owner = (GraphicalEditPart) getHost();
		List list = GfwHandleHelper.createShapeHandles(owner, getConfigurationProvider(), getResizeDirections(), isDragAllowed());
		return list;
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

	protected IConfigurationProvider getConfigurationProvider() {
		return getDelegate().getConfigurationProvider();
	}

	private GfwEditPolicyDelegate getDelegate() {
		return delegate;
	}

	@Override
	public int getResizeDirections() {
		int ret = 0;
		IResizeConfiguration resizeConfiguration = getResizeShapeFeature().getResizeConfiguration();
		if (resizeConfiguration.isHorizantalResizeAllowed()) {
			ret = ret | PositionConstants.EAST_WEST;
		}
		if (resizeConfiguration.isVerticalResizeAllowed()) {
			ret = ret | PositionConstants.NORTH_SOUTH;
		}
		return ret;
	}

	private IResizeShapeContext getResizeShapeContext() {
		return resizeShapeContext;
	}

	private IResizeShapeFeature getResizeShapeFeature() {
		return getConfigurationProvider().getFeatureProvider().getResizeShapeFeature(getResizeShapeContext());
	}

	private void setDelegate(GfwEditPolicyDelegate delegate) {
		this.delegate = delegate;
	}

	private void setResizeShapeContext(IResizeShapeContext resizeShapeContext) {
		this.resizeShapeContext = resizeShapeContext;
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
		if (((PictogramElement) getHost().getModel()).is___Alive()) {
			getDelegate().showPrimarySelection(getHostFigure());
			addSelectionHandles();
		}
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
}
