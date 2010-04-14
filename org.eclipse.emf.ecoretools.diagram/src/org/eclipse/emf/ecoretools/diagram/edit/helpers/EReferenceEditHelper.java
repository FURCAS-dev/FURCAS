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
 * $Id: EReferenceEditHelper.java,v 1.3 2008/04/28 15:23:59 jlescot Exp $
 **********************************************************************/

package org.eclipse.emf.ecoretools.diagram.edit.helpers;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;

/**
 * @generated
 */
public class EReferenceEditHelper extends EcoreBaseEditHelper {

	private final static String baseString = "EReference"; //$NON-NLS-1$

	@Override
	protected ICommand getConfigureCommand(ConfigureRequest req) {
		if (req.getElementToConfigure() instanceof EReference) {
			setDefaultNameForElement((EReference) req.getElementToConfigure());
		}
		return super.getConfigureCommand(req);
	}

	private void setDefaultNameForElement(EReference elementToConfigure) {
		EClass container = elementToConfigure.getEContainingClass();
		Boolean foundName = false;
		int count = 0;
		while (!foundName && count < 10000) {
			if (container.getEStructuralFeature(baseString + count) == null) {
				elementToConfigure.setName(baseString + count);
				foundName = true;
			}
			count++;
		}
	}
}
