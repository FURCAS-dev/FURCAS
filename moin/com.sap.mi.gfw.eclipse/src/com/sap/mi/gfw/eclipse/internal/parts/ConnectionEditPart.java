package com.sap.mi.gfw.eclipse.internal.parts;

import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editparts.AbstractConnectionEditPart;

import com.sap.mi.gfw.eclipse.internal.config.IConfigurationProvider;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.mm.pictograms.Connection;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;

/**
 * A ConnectionEditPart, which model is of the type Connection.
 */
public abstract class ConnectionEditPart extends AbstractConnectionEditPart implements IConnectionEditPart {

	private final IAnchorContainerDelegate delegate;

	/**
	 * Creates a new ConnectionEditPart.
	 * 
	 * @param configurationProvider
	 *            the configuration provider
	 * @param connection
	 *            the connection
	 */
	public ConnectionEditPart(IConfigurationProvider configurationProvider, Connection connection) {
		setModel(connection);
		delegate = new AnchorContainerDelegate(configurationProvider, connection, this);
	}

	/**
	 * Adds this EditPart as an AnchorListener on activation.
	 */
	@Override
	public void activate() {
		super.activate();
		delegate.activate();
	}

	// ======================= overwriteable behaviour ========================

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.editparts.AbstractEditPart#createEditPolicies()
	 */
	@Override
	protected void createEditPolicies() {
		installEditPolicy(EditPolicy.CONNECTION_ENDPOINTS_ROLE, getConfigurationProvider().getEditPolicyFactory()
				.createConnectionHighlightEditPolicy());

		installEditPolicy(EditPolicy.CONNECTION_ROLE, getConfigurationProvider().getEditPolicyFactory().createConnectionDeleteEditPolicy(
				getConfigurationProvider()));

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#createFigure()
	 */
	@Override
	protected IFigure createFigure() {
		IFigure ret = delegate.createFigure();
		return ret;
	}

	/**
	 * Removes this EditPart as an AnchorListener on deactivation.
	 */
	@Override
	public void deactivate() {
		delegate.deactivate();
		super.deactivate();
	}

	/**
	 * Gets the configuration provider.
	 * 
	 * @return The IConfigurationProvider of this EditPart
	 */
	public IConfigurationProvider getConfigurationProvider() {
		return delegate.getConfigurationProvider();
	}

	/**
	 * Gets the connection.
	 * 
	 * @return the connection
	 */
	protected Connection getConnection() {
		Connection ret = null;
		if (getPictogramElement() instanceof Connection) {
			ret = (Connection) getPictogramElement();
		}
		return ret;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.pf.eclipse.internal.parts.IPictogramElementEditPart#getPictogramElement()
	 */
	public PictogramElement getPictogramElement() {
		return delegate.getPictogramElement();
	}

	/**
	 * Refresh visuals.
	 */

	// ========================= standard behaviour ===========================
	/**
	 * This method is called, whenever the data of the underlying ModelObject changes. It must update the figures to display the changed
	 * data. Sub-classes will nearly always overwrite this method.
	 * <p>
	 * By default this method takes care to update the labels of the attributes (if existing) and to update the arrows at the
	 * connection-endpoints, so sub-classes should call super.refreshVisuals().
	 * 
	 * @see org.eclipse.gef.editparts.AbstractEditPart#refreshVisuals()
	 */
	@Override
	protected void refreshVisuals() {
		super.refreshVisuals();
		delegate.refreshFigureForEditPart();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.editparts.AbstractEditPart#getModelChildren()
	 */
	@Override
	public List getModelChildren() {
		List list = super.getModelChildren();
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#getModelSourceConnections()
	 */
	@Override
	public List getModelSourceConnections() {
		return super.getModelSourceConnections();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#getModelTargetConnections()
	 */
	@Override
	public List getModelTargetConnections() {
		return super.getModelTargetConnections();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.editparts.AbstractConnectionEditPart#getAdapter(java.lang.Class)
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

	public void forceVisualRefresh() {
		getPictogramElementDelegate().setForceRefresh(true);
		refreshVisuals();
		getPictogramElementDelegate().setForceRefresh(false);
	}

	@Override
	public String toString() {
		return getClass().getName() + "@" + Integer.toHexString(hashCode()); //$NON-NLS-1$
	}
}