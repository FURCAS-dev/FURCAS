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
 * $Id: EOperationEditHelper.java,v 1.3 2008/04/28 15:23:59 jlescot Exp $
 **********************************************************************/

package org.eclipse.emf.ecoretools.diagram.edit.helpers;

import java.util.Iterator;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;

/**
 * @generated
 */
public class EOperationEditHelper extends EcoreBaseEditHelper {

	private final static String baseString = "EOperation"; //$NON-NLS-1$

	@Override
	protected ICommand getConfigureCommand(ConfigureRequest req) {
		if (req.getElementToConfigure() instanceof EOperation) {
			setDefaultNameForElement((EOperation) req.getElementToConfigure());
		}
		return super.getConfigureCommand(req);
	}

	private void setDefaultNameForElement(EOperation elementToConfigure) {
		EClass container = elementToConfigure.getEContainingClass();
		int count = 0;
		for (Iterator it = container.getEOperations().iterator(); it.hasNext();) {
			EOperation eOperation = (EOperation) it.next();
			if (eOperation.getName() != null) {
				if (eOperation.getName().equals(baseString + count)) {
					count++;
				}
			}
		}
		elementToConfigure.setName(baseString + count);
	}
}
