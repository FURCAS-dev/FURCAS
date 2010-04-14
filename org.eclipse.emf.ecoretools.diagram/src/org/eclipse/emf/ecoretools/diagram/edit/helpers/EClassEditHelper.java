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
 * $Id: EClassEditHelper.java,v 1.5 2008/04/28 15:23:59 jlescot Exp $
 **********************************************************************/

package org.eclipse.emf.ecoretools.diagram.edit.helpers;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;

/**
 * @generated
 */
public class EClassEditHelper extends EcoreBaseEditHelper {

	private final static String baseString = "EClass"; //$NON-NLS-1$

	@Override
	protected ICommand getConfigureCommand(ConfigureRequest req) {
		if (req.getElementToConfigure() instanceof EClass) {
			setDefaultNameForElement((EClass) req.getElementToConfigure());
		}
		return super.getConfigureCommand(req);
	}

	private void setDefaultNameForElement(EClass elementToConfigure) {
		EPackage container = elementToConfigure.getEPackage();
		Boolean foundName = false;
		int count = 0;
		while (!foundName && count < 10000) {
			if (container.getEClassifier(baseString + count) == null) {
				elementToConfigure.setName(baseString + count);
				foundName = true;
			}
			count++;
		}
	}
}
