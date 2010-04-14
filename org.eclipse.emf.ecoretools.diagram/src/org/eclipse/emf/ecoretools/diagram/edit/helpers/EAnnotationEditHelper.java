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
 * $Id: EAnnotationEditHelper.java,v 1.3 2008/04/28 15:23:59 jlescot Exp $
 **********************************************************************/

package org.eclipse.emf.ecoretools.diagram.edit.helpers;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;

/**
 * @generated
 */
public class EAnnotationEditHelper extends EcoreBaseEditHelper {

	private final static String baseString = "EAnnotation"; //$NON-NLS-1$

	@Override
	protected ICommand getConfigureCommand(ConfigureRequest req) {
		if (req.getElementToConfigure() instanceof EAnnotation) {
			setDefaultNameForElement((EAnnotation) req.getElementToConfigure());
		}
		return super.getConfigureCommand(req);
	}

	private void setDefaultNameForElement(EAnnotation elementToConfigure) {
		EModelElement container = elementToConfigure.getEModelElement();
		Boolean foundName = false;
		int count = 0;
		while (!foundName && count < 10000) {
			if (container.getEAnnotation(baseString + count) == null) {
				elementToConfigure.setSource(baseString + count);
				foundName = true;
			}
			count++;
		}
	}
}
