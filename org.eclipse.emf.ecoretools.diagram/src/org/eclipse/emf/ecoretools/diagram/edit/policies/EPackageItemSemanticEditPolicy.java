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
 * $Id: EPackageItemSemanticEditPolicy.java,v 1.3 2009/02/02 08:39:06 jlescot Exp $
 **********************************************************************/

package org.eclipse.emf.ecoretools.diagram.edit.policies;

import org.eclipse.emf.ecoretools.diagram.edit.commands.EAnnotationCreateCommand;
import org.eclipse.emf.ecoretools.diagram.edit.commands.EClassCreateCommand;
import org.eclipse.emf.ecoretools.diagram.edit.commands.EDataTypeCreateCommand;
import org.eclipse.emf.ecoretools.diagram.edit.commands.EEnumCreateCommand;
import org.eclipse.emf.ecoretools.diagram.edit.commands.EPackageCreateCommand;
import org.eclipse.emf.ecoretools.diagram.providers.EcoreElementTypes;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.commands.DuplicateEObjectsCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;

/**
 * @generated
 */
public class EPackageItemSemanticEditPolicy extends EcoreBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public EPackageItemSemanticEditPolicy() {
		super(EcoreElementTypes.EPackage_79);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (EcoreElementTypes.EClass_1001 == req.getElementType()) {
			return getGEFWrapper(new EClassCreateCommand(req));
		}
		if (EcoreElementTypes.EPackage_1002 == req.getElementType()) {
			return getGEFWrapper(new EPackageCreateCommand(req));
		}
		if (EcoreElementTypes.EAnnotation_1003 == req.getElementType()) {
			return getGEFWrapper(new EAnnotationCreateCommand(req));
		}
		if (EcoreElementTypes.EDataType_1004 == req.getElementType()) {
			return getGEFWrapper(new EDataTypeCreateCommand(req));
		}
		if (EcoreElementTypes.EEnum_1005 == req.getElementType()) {
			return getGEFWrapper(new EEnumCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getDuplicateCommand(DuplicateElementsRequest req) {
		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost()).getEditingDomain();
		return getGEFWrapper(new DuplicateAnythingCommand(editingDomain, req));
	}

	/**
	 * @generated
	 */
	private static class DuplicateAnythingCommand extends DuplicateEObjectsCommand {

		/**
		 * @generated
		 */
		public DuplicateAnythingCommand(TransactionalEditingDomain editingDomain, DuplicateElementsRequest req) {
			super(editingDomain, req.getLabel(), req.getElementsToBeDuplicated(), req.getAllDuplicatedElementsMap());
		}
	}
}
