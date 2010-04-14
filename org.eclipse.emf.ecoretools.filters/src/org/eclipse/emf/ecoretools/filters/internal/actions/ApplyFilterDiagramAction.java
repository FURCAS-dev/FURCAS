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
 * $Id: ApplyFilterDiagramAction.java,v 1.2 2008/04/28 09:55:15 jlescot Exp $
 **********************************************************************/
package org.eclipse.emf.ecoretools.filters.internal.actions;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecoretools.filters.internal.FilterPlugin;
import org.eclipse.emf.ecoretools.filters.internal.Messages;
import org.eclipse.emf.ecoretools.filters.internal.commands.FilterDiagramCommand;
import org.eclipse.emf.ecoretools.filters.internal.utils.DiagramFilterUtil;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramCommandStack;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.action.Action;
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
public class ApplyFilterDiagramAction extends Action {

	protected IGraphicalEditPart host;

	public static String ID = "applyFilterDiagramAction"; //$NON-NLS-1$

	public ApplyFilterDiagramAction() {
		setId(ID);
		setText(Messages.ApplyFilterDiagramAction_ApplyFilter);
		setToolTipText(Messages.ApplyFilterDiagramAction_ApplyFilter_tooltip);
		setImageDescriptor(FilterPlugin.getImageDescriptor("icons/etool16/applyfilter_exec.gif")); //$NON-NLS-1$
		updateImageDescriptor(getCurrentDiagram());
	}

	private Diagram getCurrentDiagram() {
		IEditorPart editorPart = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		if (false == editorPart instanceof DiagramEditor) {
			return null;
		}
		host = ((DiagramEditor) editorPart).getDiagramEditPart();
		if (false == host instanceof IGraphicalEditPart) {
			return null;
		}
		View view = (View) host.getModel();

		Diagram diagram = view.getDiagram();

		return diagram;
	}

	@Override
	public void run() {
		Diagram diagram = getCurrentDiagram();

		if (diagram == null) {
			return;
		}

		Command cmd = new ICommandProxy(new FilterDiagramCommand(host.getEditingDomain(), diagram, DiagramFilterUtil.getCurrentFilteredTypeConfiguration(diagram), false));

		final DiagramCommandStack commandStack = (host).getDiagramEditDomain().getDiagramCommandStack();
		commandStack.execute(cmd, new NullProgressMonitor());

		updateImageDescriptor(diagram);
	}

	private void updateImageDescriptor(Diagram diagram) {
		if (diagram == null) {
			setChecked(false);
		}
		if (DiagramFilterUtil.isDiagramFiltered(diagram)) {
			setChecked(true);
		} else {
			setChecked(false);
		}
	}

}
