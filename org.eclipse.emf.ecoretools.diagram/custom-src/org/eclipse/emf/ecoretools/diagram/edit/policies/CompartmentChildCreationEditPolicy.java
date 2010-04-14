/**
 * Copyright (c) 2008 Anyware Technologies and others
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

import java.util.List;

import org.eclipse.draw2d.FlowLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.draw2d.geometry.Transposer;
import org.eclipse.emf.ecoretools.diagram.edit.commands.CompartmentChildCreateCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.DropRequest;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.notation.View;

/**
 * A CreationEditPolicy that could be used in addition with a FlowLayout to
 * support child ordering at creation
 * 
 * Creation : 28 mar. 2008
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class CompartmentChildCreationEditPolicy extends EcoreCreationEditPolicy {

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy#getCreateCommand(org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest)
	 */
	protected Command getCreateCommand(CreateViewRequest request) {
		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost()).getEditingDomain();
		CompositeTransactionalCommand cc = new CompositeTransactionalCommand(editingDomain, DiagramUIMessages.AddCommand_Label);

		for (CreateViewRequest.ViewDescriptor descriptor : (List<CreateViewRequest.ViewDescriptor>) request.getViewDescriptors()) {
			cc.compose(new CompartmentChildCreateCommand(editingDomain, descriptor, (View) (getHost().getModel()), getFeedbackIndexFor(request)));
		}
		return new ICommandProxy(cc.reduce());
	}

	protected int getFeedbackIndexFor(Request request) {
		List<EditPart> children = (List<EditPart>) getHost().getChildren();
		if (children.isEmpty())
			return -1;

		Transposer transposer = new Transposer();
		transposer.setEnabled(!isHorizontal());

		Point p = transposer.t(getLocationFromRequest(request));
		// EcoreDiagramEditorPlugin.getInstance().getLog().log(new
		// Status(IStatus.INFO, EcoreDiagramEditorPlugin.ID, p.toString()));

		// Current row bottom, initialize to below the bottom.
		int rowBottom = Integer.MIN_VALUE;
		int candidate = -1;
		// When the request is created outside the Compartment, the element is
		// added at the end of the list (this is the case when the element is
		// created from the parent header accelerator
		if (transposer.t(getAbsoluteBounds(((GraphicalEditPart) getHost()))).contains(p)) {
			for (int i = 0; i < children.size(); i++) {
				EditPart child = children.get(i);
				Rectangle rect = transposer.t(getAbsoluteBounds(((GraphicalEditPart) child)));
				if (rect.y > rowBottom) {
					// We are in a new row, so if we don't have a candidate but
					// yet are within the previous row, then the current entry
					// becomes the candidate. This is because we know we must be
					// to the right of center of the last Figure in the previous
					// row, so this Figure (which is at the start of a new row)
					// is the candidate.
					if (p.y <= rowBottom) {
						if (candidate == -1) {
							candidate = i;
						}
						break;
					} else {
						// Mouse's Y is outside the row, so reset the candidate
						candidate = -1;
					}
				}
				rowBottom = Math.max(rowBottom, rect.bottom());
				if (candidate == -1) {
					// See if we have a possible candidate. It is a candidate if
					// the cursor is left of the center of this candidate.
					if (p.x <= rect.x + (rect.width / 2)) {
						candidate = i;
					}
				}
				if (candidate != -1) {
					// We have a candidate, see if the rowBottom has grown to
					// include the mouse Y.
					if (p.y <= rowBottom) {
						// Now we have determined that the cursor.Y is above the
						// bottom of the current row of figures. Stop now, to
						// prevent the next row from being searched
						break;
					}
				}
			}
		}
		return candidate;
	}

	protected boolean isHorizontal() {
		IFigure figure = ((GraphicalEditPart) getHost()).getContentPane();
		return ((FlowLayout) figure.getLayoutManager()).isHorizontal();
	}

	private Point getLocationFromRequest(Request request) {
		return ((DropRequest) request).getLocation();
	}

	private Rectangle getAbsoluteBounds(GraphicalEditPart ep) {
		Rectangle bounds = ep.getFigure().getBounds().getCopy();
		ep.getFigure().translateToAbsolute(bounds);
		return bounds;
	}
}
