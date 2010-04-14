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
 * $Id: EPackageEditPart.java,v 1.8 2009/02/02 08:39:06 jlescot Exp $
 **********************************************************************/

package org.eclipse.emf.ecoretools.diagram.edit.parts;

import org.eclipse.emf.ecoretools.diagram.edit.policies.AlphaXYLayoutEditPolicy;
import org.eclipse.emf.ecoretools.diagram.edit.policies.EPackageCanonicalEditPolicy;
import org.eclipse.emf.ecoretools.diagram.edit.policies.EPackageItemSemanticEditPolicy;
import org.eclipse.emf.ecoretools.diagram.edit.policies.EcoretoolsEditPolicyRoles;
import org.eclipse.emf.ecoretools.diagram.edit.policies.PackageDiagramDragDropEditPolicy;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class EPackageEditPart extends DiagramEditPart {

	/**
	 * @generated
	 */
	public final static String MODEL_ID = "EcoreTools"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 79;

	/**
	 * @generated
	 */
	public EPackageEditPart(View view) {
		super(view);
	}

	/**
	 * @generated NOT
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new EPackageItemSemanticEditPolicy());
		installEditPolicy(EcoretoolsEditPolicyRoles.PSEUDO_CANONICAL_ROLE, new EPackageCanonicalEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new PackageDiagramDragDropEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new AlphaXYLayoutEditPolicy());

		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.POPUPBAR_ROLE);
	}

}
