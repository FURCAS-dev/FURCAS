package com.sap.mi.gfw.eclipse.internal.policy;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.requests.GroupRequest;

import com.sap.mi.gfw.command.GenericFeatureCommandWithContext;
import com.sap.mi.gfw.eclipse.internal.command.GefCommandWrapper;
import com.sap.mi.gfw.eclipse.internal.config.IConfigurationProvider;
import com.sap.mi.gfw.features.IDeleteFeature;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.context.impl.DeleteContext;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;

/**
 * An EditPolicy to handle the deletion of EditParts.
 * 
 * @see com.sap.ide.eclipse.gf.policy.IEditPolicyFactory#createModelObjectDeleteEditPolicy(com.sap.ide.eclipse.gf.command.ICommandFactory)
 */
public class ModelObjectDeleteEditPolicy extends ComponentEditPolicy {

	private IConfigurationProvider _configurationProvider;

	/**
	 * Creates a new ModelObjectDeleteEditPolicy.
	 * 
	 * @param configurationProvider
	 *            The IConfigurationProvider.
	 */
	protected ModelObjectDeleteEditPolicy(IConfigurationProvider configurationProvider) {
		_configurationProvider = configurationProvider;
	}

	protected final IConfigurationProvider getConfigurationProvider() {
		return _configurationProvider;
	}

	/**
	 * Is called, when an EditPart shall be deleted. It creates an ICommandFactory.createDeleteModelObjectCommand().
	 * 
	 * @see org.eclipse.gef.editpolicies.ComponentEditPolicy#createDeleteCommand(org.eclipse.gef.requests.GroupRequest)
	 */
	@Override
	protected Command createDeleteCommand(GroupRequest request) {
		if (getHost().getParent() == null) // do not allow to delete the
			// root-object itself
			return null;

		EditPart modelObjectEditPart = getHost();

		Object model = modelObjectEditPart.getModel();

		if (!(model instanceof PictogramElement))
			return null;

		DeleteContext context = new DeleteContext((PictogramElement) model);
		IFeatureProvider featureProvider = getConfigurationProvider().getDiagramTypeProvider().getFeatureProvider();
		IDeleteFeature feature = null;
		if (featureProvider != null) {
			feature = featureProvider.getDeleteFeature(context);
		}
		if (feature == null)
			return null;

		GenericFeatureCommandWithContext command = new GenericFeatureCommandWithContext(feature, context);

		return new GefCommandWrapper(command, featureProvider.getConnection());

	}
}