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
 * $Id: EStringToStringMapEntryEditHelper.java,v 1.3 2008/04/28 15:23:59 jlescot Exp $
 **********************************************************************/

package org.eclipse.emf.ecoretools.diagram.edit.helpers;

import java.util.Iterator;

import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;

/**
 * @generated
 */
public class EStringToStringMapEntryEditHelper extends EcoreBaseEditHelper {

	private final static String baseString = "EStringToStringMapEntry"; //$NON-NLS-1$

	@Override
	protected ICommand getConfigureCommand(ConfigureRequest req) {
		if ((req.getElementToConfigure() instanceof BasicEMap.Entry) && (req.getElementToConfigure() instanceof EObject)) {
			setDefaultNameForElement((BasicEMap.Entry) req.getElementToConfigure());
		}
		return super.getConfigureCommand(req);
	}

	private void setDefaultNameForElement(BasicEMap.Entry elementToConfigure) {
		EAnnotation container = (EAnnotation) ((EObject) elementToConfigure).eContainer();
		int count = 0;
		for (Iterator it = container.getDetails().iterator(); it.hasNext();) {
			BasicEMap.Entry eDetail = (BasicEMap.Entry) it.next();
			if (eDetail.getKey() != null) {
				if (eDetail.getKey().equals(baseString + count)) {
					count++;
				}
			}
		}
		elementToConfigure.setKey(baseString + count);
	}
}
