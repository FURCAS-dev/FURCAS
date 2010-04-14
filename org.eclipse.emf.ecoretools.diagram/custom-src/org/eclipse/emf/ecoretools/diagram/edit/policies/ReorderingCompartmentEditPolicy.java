/**
 * Copyright (c) 2008, 2009 Anyware Technologies and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Anyware Technologies - initial API and implementation
 */
package org.eclipse.emf.ecoretools.diagram.edit.policies;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecoretools.diagram.edit.commands.CompartmentReorderEObjectCommand;
import org.eclipse.emf.ecoretools.diagram.part.EcoreVisualIDRegistry;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.core.commands.AddCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ResizableEditPolicyEx;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.View;

/**
 * A LayoutEditPolicy that could be used in addition with a FlowLayout to
 * support child reordering
 * 
 * Creation : 11 mar. 2008
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class ReorderingCompartmentEditPolicy extends org.eclipse.gef.editpolicies.FlowLayoutEditPolicy {

	// The domain model list that contains the element to reorder
	private EStructuralFeature feature = null;

	/**
	 * @param feature
	 *            The EStructutalFeature containing elements to reorder
	 */
	public ReorderingCompartmentEditPolicy(EStructuralFeature feature) {
		super();
		this.feature = feature;
	}

	/**
	 * @see org.eclipse.gef.editpolicies.OrderedLayoutEditPolicy#createAddCommand(org.eclipse.gef.EditPart,
	 *      org.eclipse.gef.EditPart)
	 */
	protected Command createAddCommand(EditPart child, EditPart after) {
		View viewToMove = (View) child.getModel();
		if (viewToMove != null) {
			View newParentView = (View) getHost().getModel();
			if (newParentView != null) {
				// We check if the move/add is possible at notational level
				if (EcoreVisualIDRegistry.canCreateNode(newParentView, EcoreVisualIDRegistry.getVisualID(viewToMove.getType()))) {
					int index = getHost().getChildren().indexOf(after);
					TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost()).getEditingDomain();
					AddCommand command = new AddCommand(editingDomain, new EObjectAdapter(newParentView), new EObjectAdapter(viewToMove), index);
					return new ICommandProxy(command);
				}
			}
		}
		return UnexecutableCommand.INSTANCE;

	}

	/**
	 * @see org.eclipse.gef.editpolicies.OrderedLayoutEditPolicy#createChildEditPolicy(org.eclipse.gef.EditPart)
	 */
	protected EditPolicy createChildEditPolicy(EditPart child) {
		ResizableEditPolicyEx policy = new ResizableEditPolicyEx();
		policy.setResizeDirections(0);
		return policy;
	}

	/**
	 * @see org.eclipse.gef.editpolicies.OrderedLayoutEditPolicy#createMoveChildCommand(org.eclipse.gef.EditPart,
	 *      org.eclipse.gef.EditPart)
	 */
	protected Command createMoveChildCommand(EditPart child, EditPart after) {
		int newIndex;
		int moveOffset;

		int childIndex = getHost().getChildren().indexOf(child);
		int afterIndex = getHost().getChildren().indexOf(after);

		if (afterIndex == -1) {
			// Move the child to the last position
			newIndex = getHost().getChildren().size() - 1;
			moveOffset = newIndex - childIndex;
		} else {
			newIndex = afterIndex;
			moveOffset = afterIndex - childIndex;
			if (childIndex <= afterIndex) {
				newIndex--;
				moveOffset--;
			}
		}

		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost()).getEditingDomain();
		CompartmentReorderEObjectCommand command = new CompartmentReorderEObjectCommand(editingDomain, "", (EList<EObject>) ((View) child.getParent().getModel()).getElement().eGet(feature), child, //$NON-NLS-1$
				after);

		return new ICommandProxy(command);
	}

	/**
	 * @see org.eclipse.gef.editpolicies.LayoutEditPolicy#getCreateCommand(org.eclipse.gef.requests.CreateRequest)
	 */
	protected Command getCreateCommand(CreateRequest request) {
		return null;
	}

	/**
	 * @see org.eclipse.gef.editpolicies.LayoutEditPolicy#getDeleteDependantCommand(org.eclipse.gef.Request)
	 */
	protected Command getDeleteDependantCommand(Request request) {
		return null;
	}

	/**
	 * @see org.eclipse.gef.editpolicies.LayoutEditPolicy#getOrphanChildrenCommand(org.eclipse.gef.Request)
	 */
	protected Command getOrphanChildrenCommand(Request request) {
		return null;
	}

	@Override
	public void eraseTargetFeedback(Request request) {
		// Need to handle case of REQ_DROP request's type to erase feedback
		if (RequestConstants.REQ_DROP.equals(request.getType()))
			eraseLayoutTargetFeedback(request);
		super.eraseTargetFeedback(request);
	}
}
