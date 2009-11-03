package com.sap.mi.gfw.eclipse.internal.policy;

import org.eclipse.gef.EditPolicy;

import com.sap.mi.gfw.eclipse.internal.config.AbstractConfigurationProviderHolder;
import com.sap.mi.gfw.eclipse.internal.config.IConfigurationProvider;

/**
 * A default implementation of the interface IEditPolicyFactory.
 */
public class DefaultEditPolicyFactory extends AbstractConfigurationProviderHolder implements IEditPolicyFactory {

	/**
	 * Creates a new DefaultEditPolicyFactory.
	 * 
	 * @param configurationProvider
	 *            The IConfigurationProvider, to which this factory belongs.
	 */
	public DefaultEditPolicyFactory(IConfigurationProvider configurationProvider) {
		super(configurationProvider);
	}

	public void dispose() {
	}

	public EditPolicy createShapeForbidLayoutEditPolicy() {
		return new ShapeForbidLayoutEditPolicy(getConfigurationProvider());
	}

	public EditPolicy createShapeXYLayoutEditPolicy() {
		// return new ShapeXYLayoutEditPolicy(getConfigurationProvider().getCommandFactory());
		return new ShapeContainerAndXYLayoutEditPolicy(getConfigurationProvider());
	}

	public EditPolicy createShapeHighlightEditPolicy() {
		return new ShapeHighlightEditPolicy(getConfigurationProvider());
	}

	public EditPolicy createConnectionHighlightEditPolicy() {
		return new ConnectionHighlightEditPolicy(getConfigurationProvider());
	}

	public EditPolicy createConnectionEditPolicy() {
		return new GFNodeEditPolicy(getConfigurationProvider());
	}

	public EditPolicy createDirectEditPolicy() {
		return new DefaultDirectEditPolicy(getConfigurationProvider());
	}

	public EditPolicy createModelObjectDeleteEditPolicy(IConfigurationProvider configurationProvider) {
		return new ModelObjectDeleteEditPolicy(configurationProvider);
	}

	public EditPolicy createConnectionBendpointsEditPolicy() {
		return new ConnectionBendpointEditPolicy(getConfigurationProvider());
		// return new MoveBendpointEditPolicy();
	}

	public EditPolicy createConnectionDeleteEditPolicy(IConfigurationProvider configurationProvider) {
		return new DefaultConnectionEditPolicy(configurationProvider);
	}

}