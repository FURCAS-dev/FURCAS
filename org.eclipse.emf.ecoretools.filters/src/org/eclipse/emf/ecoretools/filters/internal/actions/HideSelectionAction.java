/***********************************************************************
 * Copyright (c) 2008 Anyware Technologies
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Anyware Technologies - initial API and implementation
 * 
 * $Id: HideSelectionAction.java,v 1.3 2008/04/28 09:55:15 jlescot Exp $
 **********************************************************************/
package org.eclipse.emf.ecoretools.filters.internal.actions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecoretools.filters.internal.FilterPlugin;
import org.eclipse.emf.ecoretools.filters.internal.Messages;
import org.eclipse.emf.ecoretools.filters.internal.commands.FilterSelectionCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramCommandStack;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramEditDomain;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.PlatformUI;

/**
 * 
 * TODO Describe the class here <br>
 * creation : 14 janv. 08
 * 
 * @author <a href="mailto:gilles.cannenterre@anyware-tech.com">Gilles
 *         Cannenterre</a>
 */
public class HideSelectionAction extends Action {

	protected IGraphicalEditPart host;

	public static String ID = "hideSelectionAction"; //$NON-NLS-1$

	public HideSelectionAction() {
		setId(ID);
		setText(Messages.HideSelectionAction_HideSelection);
		setToolTipText(Messages.HideSelectionAction_HideSelection_tooltip);
		setImageDescriptor(FilterPlugin.getImageDescriptor("icons/etool16/hideselection_exec.gif")); //$NON-NLS-1$
	}

	private List<IGraphicalEditPart> getSelection() {
		List<IGraphicalEditPart> partSelected = new ArrayList<IGraphicalEditPart>();
		ISelection selection = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().getSelection();
		if (false == selection instanceof IStructuredSelection) {
			return Collections.emptyList();
		}
		for (Object object : ((IStructuredSelection) selection).toList()) {
			if (false == object instanceof IGraphicalEditPart) {

			}
			if (object instanceof DiagramEditPart) {
				continue;
			}
			partSelected.add((IGraphicalEditPart) object);
		}
		return partSelected;
	}

	/**
	 * @see org.eclipse.jface.action.Action#run()
	 */
	@Override
	public void run() {
		List<IGraphicalEditPart> selection = getSelection();

		if (selection.isEmpty()) {
			return;
		}

		final TransactionalEditingDomain editingDomain = selection.get(0).getEditingDomain();
		final IDiagramEditDomain editDomain = selection.get(0).getDiagramEditDomain();

		Command cmd = new ICommandProxy(new FilterSelectionCommand(editingDomain, selection, false));

		final DiagramCommandStack commandStack = editDomain.getDiagramCommandStack();
		commandStack.execute(cmd, new NullProgressMonitor());
	}

	/**
	 * @see org.eclipse.jface.action.Action#isEnabled()
	 */
	@Override
	public boolean isEnabled() {
		return (false == getSelection().isEmpty());
	}

}