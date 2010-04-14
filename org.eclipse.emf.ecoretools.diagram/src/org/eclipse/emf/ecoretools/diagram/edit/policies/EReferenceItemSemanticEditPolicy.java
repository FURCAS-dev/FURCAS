/***********************************************************************
 * Copyright (c) 2007 Anyware Technologies
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Anyware Technologies - initial API and implementation
 *
 * $Id: EReferenceItemSemanticEditPolicy.java,v 1.4 2009/02/02 08:39:06 jlescot Exp $
 **********************************************************************/

package org.eclipse.emf.ecoretools.diagram.edit.policies;

import java.util.List;

import org.eclipse.emf.ecoretools.diagram.edit.commands.EAnnotationReferencesCreateCommand;
import org.eclipse.emf.ecoretools.diagram.edit.commands.EAnnotationReferencesReorientCommand;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EAnnotationReferencesEditPart;
import org.eclipse.emf.ecoretools.diagram.providers.EcoreElementTypes;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class EReferenceItemSemanticEditPolicy extends EcoreBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public EReferenceItemSemanticEditPolicy() {
		super(EcoreElementTypes.EReference_3002);
	}

	/**
	 * @generated NOT
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		// Destroy representations from all over the notation model file
		CompoundCommand cc = getDestroyEdgesCommand();
		List<View> representations = DestroyElementUtils.findRepresentations(getSemanticElement(), (View) getHost().getModel());
		for (View representationViewToDelete : representations) {
			cc.add(getGEFWrapper(new DestroyElementCommand(new DestroyElementRequest(getEditingDomain(), representationViewToDelete, false))));
		}
		cc.add(getGEFWrapper(new DestroyElementCommand(req)));
		return cc.unwrap();
	}

	/**
	 * @generated
	 */
	protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {
		Command command = req.getTarget() == null ? getStartCreateRelationshipCommand(req) : getCompleteCreateRelationshipCommand(req);
		return command != null ? command : super.getCreateRelationshipCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getStartCreateRelationshipCommand(CreateRelationshipRequest req) {
		if (EcoreElementTypes.EAnnotationReferences_3001 == req.getElementType()) {
			return null;
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {
		if (EcoreElementTypes.EAnnotationReferences_3001 == req.getElementType()) {
			return getGEFWrapper(new EAnnotationReferencesCreateCommand(req, req.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * Returns command to reorient EReference based link. New link target or
	 * source should be the domain model element associated with this node.
	 * 
	 * @generated
	 */
	protected Command getReorientReferenceRelationshipCommand(ReorientReferenceRelationshipRequest req) {
		switch (getVisualID(req)) {
		case EAnnotationReferencesEditPart.VISUAL_ID:
			return getGEFWrapper(new EAnnotationReferencesReorientCommand(req));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}

}
