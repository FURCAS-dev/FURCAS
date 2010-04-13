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
 * $Id: RefreshAction.java,v 1.5 2008/05/19 09:26:31 jlescot Exp $
 **********************************************************************/

package org.eclipse.emf.ecoretools.internal.actions;

import org.eclipse.emf.ecoretools.internal.Activator;
import org.eclipse.emf.ecoretools.internal.Messages;
import org.eclipse.emf.ecoretools.internal.views.AnalysisView;
import org.eclipse.jface.action.Action;
import org.eclipse.ui.plugin.AbstractUIPlugin;

/**
 * Action that refresh an analysis view
 * 
 * @author <a href="david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public class RefreshAction extends Action {

	private AnalysisView analysisView;

	/**
	 * Constructor
	 * 
	 * @param view
	 *            the analysis view that must be refresh
	 */
	public RefreshAction(AnalysisView view) {
		super(Messages.RefreshAction_Refresh);
		setDescription(Messages.RefreshAction_Refresh_description);
		setToolTipText(Messages.RefreshAction_Refresh_tooltip);
		setImageDescriptor(AbstractUIPlugin.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "icons/elcl16/refresh.gif")); //$NON-NLS-1$
		setDisabledImageDescriptor(AbstractUIPlugin.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "icons/dlcl16/refresh.gif")); //$NON-NLS-1$

		analysisView = view;
	}

	/**
	 * Runs the action.
	 */
	@Override
	public void run() {
		analysisView.refresh();
	}
}
