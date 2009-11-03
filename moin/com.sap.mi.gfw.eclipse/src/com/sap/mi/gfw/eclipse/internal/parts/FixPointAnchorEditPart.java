/*
 * Created on 05.04.2005
 */
package com.sap.mi.gfw.eclipse.internal.parts;

import org.eclipse.gef.EditPolicy;

import com.sap.mi.gfw.eclipse.internal.config.IConfigurationProvider;
import com.sap.mi.gfw.mm.pictograms.FixPointAnchor;

/**
 * The Class FixPointAnchorEditPart.
 */
public class FixPointAnchorEditPart extends AnchorEditPart implements IFixPointAnchorEditPart {

	/**
	 * The Constructor.
	 * 
	 * @param anchor
	 *            the anchor
	 * @param configurationProvider
	 *            the configuration provider
	 */
	public FixPointAnchorEditPart(IConfigurationProvider configurationProvider, FixPointAnchor anchor) {
		super(configurationProvider, anchor);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.editparts.AbstractEditPart#createEditPolicies()
	 */
	@Override
	protected void createEditPolicies() {
		installEditPolicy(EditPolicy.COMPONENT_ROLE, getConfigurationProvider().getEditPolicyFactory().createModelObjectDeleteEditPolicy(
				getConfigurationProvider()));
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, getConfigurationProvider().getEditPolicyFactory().createConnectionEditPolicy());
	}
}