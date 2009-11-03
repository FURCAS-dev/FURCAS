package com.sap.mi.gfw.eclipse.internal.parts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

import com.sap.mi.gfw.eclipse.internal.config.IConfigurationProvider;
import com.sap.mi.gfw.eclipse.internal.util.draw2d.GFChopboxAnchor;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.mm.pictograms.Anchor;
import com.sap.mi.gfw.mm.pictograms.Connection;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;

/**
 * The Class AnchorEditPart.
 */
public abstract class AnchorEditPart extends AbstractGraphicalEditPart implements IAnchorEditPart, NodeEditPart {

	private ConnectionAnchor connectionAnchor;

	/**
	 * The delegate.
	 */
	protected IPictogramElementDelegate delegate;

	/**
	 * Instantiates a new anchor edit part.
	 * 
	 * @param configurationProvider
	 *            the configuration provider
	 * @param anchor
	 *            the anchor
	 */
	public AnchorEditPart(IConfigurationProvider configurationProvider, Anchor anchor) {
		setModel(anchor);
		delegate = new PictogramElementDelegate(configurationProvider, anchor, this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#activate()
	 */
	@Override
	public void activate() {
		super.activate();
		delegate.activate();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#createFigure()
	 */
	@Override
	protected IFigure createFigure() {
		IFigure figure = delegate.createFigure();
		connectionAnchor = new GFChopboxAnchor(figure);

		return figure;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#deactivate()
	 */
	@Override
	public void deactivate() {
		delegate.deactivate();
		super.deactivate();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.pf.eclipse.internal.config.IConfigurationProviderHolder#getConfigurationProvider()
	 */
	public IConfigurationProvider getConfigurationProvider() throws IllegalStateException {
		return delegate.getConfigurationProvider();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#getModelSourceConnections()
	 */
	@Override
	public List<Connection> getModelSourceConnections() {

		Anchor anchor = (Anchor) getModel();
		List<Connection> connections = new ArrayList<Connection>();

		if (anchor != null) {
			connections.addAll(anchor.getOutgoingConnections());
		}

		return connections;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#getModelTargetConnections()
	 */
	@Override
	public List<Connection> getModelTargetConnections() {

		Anchor anchor = (Anchor) getModel();
		List<Connection> connections = new ArrayList<Connection>();

		if (anchor != null) {
			connections.addAll(anchor.getIncomingConnections());
		}

		return connections;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.pf.eclipse.internal.parts.IPictogramElementEditPart#getPictogramElement()
	 */
	public PictogramElement getPictogramElement() {
		return delegate.getPictogramElement();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.NodeEditPart#getSourceConnectionAnchor(org.eclipse.gef.ConnectionEditPart)
	 */
	public ConnectionAnchor getSourceConnectionAnchor(ConnectionEditPart connection) {
		return connectionAnchor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.NodeEditPart#getSourceConnectionAnchor(org.eclipse.gef.Request)
	 */
	public ConnectionAnchor getSourceConnectionAnchor(Request request) {
		return connectionAnchor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.NodeEditPart#getTargetConnectionAnchor(org.eclipse.gef.ConnectionEditPart)
	 */
	public ConnectionAnchor getTargetConnectionAnchor(ConnectionEditPart connection) {
		return connectionAnchor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.NodeEditPart#getTargetConnectionAnchor(org.eclipse.gef.Request)
	 */
	public ConnectionAnchor getTargetConnectionAnchor(Request request) {
		return connectionAnchor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.editparts.AbstractEditPart#refreshVisuals()
	 */
	@Override
	protected void refreshVisuals() {
		super.refreshVisuals();
		delegate.refreshFigureForEditPart();
		getFigure().setVisible(getPictogramElement().isVisible());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.editparts.AbstractEditPart#refreshChildren()
	 */
	@Override
	protected void refreshChildren() {
		super.refreshChildren();

		// refresh edit parts for child PEs as well
		delegate.refreshEditPartsForModelChildrenAndSourceConnections(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.editparts.AbstractEditPart#getModelChildren()
	 */
	@Override
	public List getModelChildren() {
		return super.getModelChildren();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#getAdapter(java.lang.Class)
	 */
	@Override
	public Object getAdapter(Class key) {
		Object ret = delegate.getAdapter(key);
		if (ret == null) {
			ret = super.getAdapter(key);
		}
		return ret;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IFeatureProviderHolder#getFeatureProvider()
	 */
	public IFeatureProvider getFeatureProvider() {
		IFeatureProvider ret = null;
		if (delegate != null) {
			ret = delegate.getFeatureProvider();
		}
		return ret;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.eclipse.internal.parts.IPictogramElementEditPart#getPictogramElementDelegate()
	 */
	public IPictogramElementDelegate getPictogramElementDelegate() {
		return delegate;
	}

}