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
 * $Id: FilterDiagramSelectionDialog.java,v 1.2 2008/04/28 09:55:15 jlescot Exp $
 **********************************************************************/
package org.eclipse.emf.ecoretools.filters.internal.dialogs;

import org.eclipse.emf.ecoretools.filters.internal.Messages;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.CheckedTreeSelectionDialog;

/**
 * 
 * TODO Describe the class here <br>
 * creation : 14 nov. 07
 * 
 * @author <a href="mailto:gilles.cannenterre@anyware-tech.com">Gilles
 *         Cannenterre</a>
 */
public class FilterDiagramSelectionDialog extends CheckedTreeSelectionDialog {

	public FilterDiagramSelectionDialog(Shell parent, Diagram diagram) {
		super(parent, new FilterDiagramViewerLabelProvider(diagram), new FilterDiagramViewerContentProvider());
		setTitle(Messages.ConfigureFilter_Dialog_title);
		setMessage(Messages.ConfigureFilter_Dialog_message);
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite composite = (Composite) super.createDialogArea(parent);
		getTreeViewer().getTree().setLinesVisible(true);
		return composite;
	}
}
