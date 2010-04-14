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
 * $Id: HideSemanticAction.java,v 1.3 2008/04/28 09:55:15 jlescot Exp $
 **********************************************************************/
package org.eclipse.emf.ecoretools.filters.internal.actions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecoretools.filters.internal.FilterPlugin;
import org.eclipse.emf.ecoretools.filters.internal.Messages;
import org.eclipse.emf.ecoretools.filters.internal.commands.FilterSemanticSelectionCommand;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramCommandStack;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;

/**
 * 
 * TODO Describe the class here <br>
 * creation : 14 janv. 08
 * 
 * @author <a href="mailto:gilles.cannenterre@anyware-tech.com">Gilles
 *         Cannenterre</a>
 */
public class HideSemanticAction extends Action {

	protected IGraphicalEditPart host;

	public static String ID = "hideSemanticAction"; //$NON-NLS-1$

	public HideSemanticAction() {
		setId(ID);
		setText(Messages.HideSemanticAction_HideSemanticModel);
		setToolTipText(Messages.HideSemanticAction_HideSemanticModel_tooltip);
		setImageDescriptor(FilterPlugin.getImageDescriptor("icons/etool16/hidesemantic_exec.gif")); //$NON-NLS-1$
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

	private List<EObject> getSelection() {
		List<EObject> semanticSelected = new ArrayList<EObject>();
		ISelection selection = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().getSelection();
		if (false == selection instanceof IStructuredSelection) {
			return Collections.emptyList();
		}
		for (Object object : ((IStructuredSelection) selection).toList()) {
			if (false == object instanceof IGraphicalEditPart) {
				continue;
			}
			if (object instanceof DiagramEditPart) {
				continue;
			}
			View view = ((IGraphicalEditPart) object).getNotationView();
			if (view == null) {
				continue;
			}
			if (semanticSelected.contains(view.getElement())) {
				continue;
			}
			semanticSelected.add(view.getElement());
		}
		return semanticSelected;
	}

	/**
	 * @see org.eclipse.jface.action.Action#run()
	 */
	@Override
	public void run() {
		List<EObject> selection = getSelection();

		if (selection.isEmpty()) {
			return;
		}

		Diagram diagram = getCurrentDiagram();

		if (diagram == null) {
			return;
		}

		Command cmd = new ICommandProxy(new FilterSemanticSelectionCommand(host.getEditingDomain(), diagram, selection, false));

		final DiagramCommandStack commandStack = (host).getDiagramEditDomain().getDiagramCommandStack();
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