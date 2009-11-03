package com.sap.mi.gfw.eclipse.internal.policy;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.requests.CreateRequest;

import com.sap.mi.gfw.eclipse.internal.config.IConfigurationProvider;

/**
 * An EditPolicy, which 'forbids' any Layout dependent Commands. All methods of this EditPolicy return null, which is different from using
 * no EditPolicy at all, because it will create a visible feedback that the requests are forbidden. This EditPolicy can for example be used
 * for those EditParts, which do not have any children.
 * 
 * @see com.sap.ide.eclipse.gf.policy.IEditPolicyFactory#createShapeForbidLayoutEditPolicy()
 */
public class ShapeForbidLayoutEditPolicy extends LayoutEditPolicy {

	private IConfigurationProvider _configurationProvider;

	/**
	 * Creates a new ShapeForbidLayoutEditPolicy.
	 * 
	 * @param configurationProvider
	 *            The IConfigurationProvider.
	 */
	protected ShapeForbidLayoutEditPolicy(IConfigurationProvider configurationProvider) {
		_configurationProvider = configurationProvider;
	}

	protected final IConfigurationProvider getConfigurationProvider() {
		return _configurationProvider;
	}

	/**
	 * Returns null.
	 * 
	 * @see org.eclipse.gef.editpolicies.LayoutEditPolicy#createChildEditPolicy(org.eclipse.gef.EditPart)
	 */
	@Override
	protected EditPolicy createChildEditPolicy(EditPart child) {
		return null;
	}

	/**
	 * Returns null.
	 * 
	 * @see org.eclipse.gef.editpolicies.LayoutEditPolicy#getCreateCommand(org.eclipse.gef.requests.CreateRequest)
	 */
	@Override
	protected Command getCreateCommand(CreateRequest request) {
		return null;
	}

	/**
	 * Returns null.
	 * 
	 * @see org.eclipse.gef.editpolicies.LayoutEditPolicy#getMoveChildrenCommand(org.eclipse.gef.Request)
	 */
	@Override
	protected Command getMoveChildrenCommand(Request request) {
		return null;
	}

	/**
	 * Returns null.
	 * 
	 * @see org.eclipse.gef.editpolicies.LayoutEditPolicy#getDeleteDependantCommand(org.eclipse.gef.Request)
	 */
	@Override
	protected Command getDeleteDependantCommand(Request request) {
		return null;
	}
}
