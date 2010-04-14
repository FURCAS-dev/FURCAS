/***********************************************************************
 * Copyright (c) 2009 Anyware Technologies
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Anyware Technologies - initial API and implementation
 *
 * $Id: EcoreCreationEditPolicy.java,v 1.1 2009/04/20 14:35:13 jlescot Exp $
 **********************************************************************/
package org.eclipse.emf.ecoretools.diagram.edit.policies;

import org.eclipse.emf.ecoretools.diagram.part.EcoreVisualIDRegistry;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.notation.View;

/**
 * Provide some additional check during a "Move" action in the diagram area.
 */
public class EcoreCreationEditPolicy extends CreationEditPolicy {

	public EcoreCreationEditPolicy() {
		super();
	}

	// Bug 238887 : Prevent dropping an EAttribute in the EOperations
	// compartment of an EClass
	@Override
	protected ICommand getReparentViewCommand(IGraphicalEditPart gep) {
		View viewToMove = (View) gep.getModel();
		if (viewToMove != null) {
			View newParentView = (View) getHost().getModel();
			if (newParentView != null) {
				// We check if the reparent is possible at notational level
				if (EcoreVisualIDRegistry.canCreateNode(newParentView, EcoreVisualIDRegistry.getVisualID(viewToMove.getType()))) {
					return super.getReparentViewCommand(gep);
				}
			}
		}
		return UnexecutableCommand.INSTANCE;
	}
}
