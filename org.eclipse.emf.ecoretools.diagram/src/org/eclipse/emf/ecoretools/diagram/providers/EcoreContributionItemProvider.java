/*
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
 * $Id: EcoreContributionItemProvider.java,v 1.3 2009/02/02 08:39:06 jlescot Exp $
 */
package org.eclipse.emf.ecoretools.diagram.providers;

import org.eclipse.emf.ecoretools.diagram.part.ValidateAction;
import org.eclipse.gmf.runtime.common.ui.services.action.contributionitem.AbstractContributionItemProvider;
import org.eclipse.gmf.runtime.common.ui.util.IWorkbenchPartDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.printing.actions.PrintPreviewAction;
import org.eclipse.gmf.runtime.diagram.ui.printing.render.actions.EnhancedPrintActionHelper;
import org.eclipse.gmf.runtime.diagram.ui.printing.render.actions.RenderedPrintPreviewAction;
import org.eclipse.jface.action.IAction;

/**
 * @generated
 */
public class EcoreContributionItemProvider extends AbstractContributionItemProvider {

	/**
	 * @generated
	 */
	@Override
	protected IAction createAction(String actionId, IWorkbenchPartDescriptor partDescriptor) {
		if (actionId.equals(PrintPreviewAction.ID)) {
			return new RenderedPrintPreviewAction(new EnhancedPrintActionHelper());
		}
		if (actionId.equals(ValidateAction.ID)) {
			return new ValidateAction(partDescriptor.getPartPage());
		}
		return super.createAction(actionId, partDescriptor);
	}
}
