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
 * $Id: EPackageContentsItemSemanticEditPolicy.java,v 1.3 2009/02/02 08:39:06 jlescot Exp $
 **********************************************************************/

package org.eclipse.emf.ecoretools.diagram.edit.policies;

import org.eclipse.emf.ecoretools.diagram.edit.commands.EClass2CreateCommand;
import org.eclipse.emf.ecoretools.diagram.edit.commands.EDataType2CreateCommand;
import org.eclipse.emf.ecoretools.diagram.edit.commands.EEnum2CreateCommand;
import org.eclipse.emf.ecoretools.diagram.providers.EcoreElementTypes;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

/**
 * @generated
 */
public class EPackageContentsItemSemanticEditPolicy extends EcoreBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public EPackageContentsItemSemanticEditPolicy() {
		super(EcoreElementTypes.EPackage_1002);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (EcoreElementTypes.EClass_2003 == req.getElementType()) {
			return getGEFWrapper(new EClass2CreateCommand(req));
		}
		if (EcoreElementTypes.EDataType_2004 == req.getElementType()) {
			return getGEFWrapper(new EDataType2CreateCommand(req));
		}
		if (EcoreElementTypes.EEnum_2005 == req.getElementType()) {
			return getGEFWrapper(new EEnum2CreateCommand(req));
		}
		return super.getCreateCommand(req);
	}
}
