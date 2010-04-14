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
 * $Id: ConfigureFilterDiagramAction.java,v 1.2 2008/04/28 09:55:15 jlescot Exp $
 **********************************************************************/
package org.eclipse.emf.ecoretools.filters.internal.actions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecoretools.filters.internal.FilterPlugin;
import org.eclipse.emf.ecoretools.filters.internal.Messages;
import org.eclipse.emf.ecoretools.filters.internal.dialogs.FilterDiagramSelectionDialog;
import org.eclipse.emf.ecoretools.filters.internal.utils.DiagramFilterUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;

/**
 * 
 * TODO Describe the class here <br>
 * creation : 4 oct. 07
 * 
 * @author <a href="mailto:gilles.cannenterre@anyware-tech.com">Gilles
 *         Cannenterre</a>
 */
public class ConfigureFilterDiagramAction extends Action {

	protected IGraphicalEditPart host;

	public static String ID = "configureFilterDiagramAction"; //$NON-NLS-1$

	public ConfigureFilterDiagramAction() {
		setId(ID);
		setImageDescriptor(FilterPlugin.getImageDescriptor("icons/etool16/configurefilter_exec.gif")); //$NON-NLS-1$
		setText(Messages.ConfigureFilterDiagramAction_Configure);
		setToolTipText(Messages.ConfigureFilterDiagramAction_Configure_tooltip);
	}

	private List<String> buildSelection(Diagram diagram) {
		List<String> intinialSelection = new ArrayList<String>();
		List<String> savedConfiguration = DiagramFilterUtil.getCurrentFilteredTypeConfiguration(diagram);
		for (String key : DiagramFilterUtil.getDiagramFilteredTypeDescription(diagram).keySet()) {
			if (DiagramFilterUtil.isInKey(key, savedConfiguration)) {
				intinialSelection.add(key);
			}
		}

		return intinialSelection;
	}

	private void processResult(Diagram diagram, Object[] result) {
		List<String> filteredTypes = new ArrayList<String>();
		for (Object object : result) {
			if (object instanceof String) {
				filteredTypes.add((String) object);
			}
		}
		DiagramFilterUtil.setCurrentFilteredTypeConfiguration(diagram, filteredTypes);
	}

	@Override
	public void run() {
		IEditorPart editorPart = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		if (false == editorPart instanceof DiagramEditor) {
			return;
		}

		host = ((DiagramEditor) editorPart).getDiagramEditPart();
		if (false == host instanceof IGraphicalEditPart) {
			return;
		}

		View view = (View) host.getModel();

		if (view.getDiagram() == null) {
			return;
		}

		final Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActivePart().getSite().getShell();
		FilterDiagramSelectionDialog dialog = new FilterDiagramSelectionDialog(shell, view.getDiagram());
		dialog.setInput(DiagramFilterUtil.getDiagramFilteredTypeDescription(view.getDiagram()));

		List<String> selection = buildSelection(view.getDiagram());
		dialog.setInitialElementSelections(selection);
		switch (dialog.open()) {
		// Cancel pressed
		case Window.CANCEL:
			// nothing to do
			break;
		// OK pressed
		case Window.OK:
			processResult(view.getDiagram(), dialog.getResult());
			break;
		}
	}
}
