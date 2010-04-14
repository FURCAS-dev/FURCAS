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
 * $Id: ShowHiddenPartAction.java,v 1.4 2008/04/28 09:55:15 jlescot Exp $
 **********************************************************************/
package org.eclipse.emf.ecoretools.filters.internal.actions;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecoretools.filters.internal.FilterPlugin;
import org.eclipse.emf.ecoretools.filters.internal.Messages;
import org.eclipse.emf.ecoretools.filters.internal.commands.ShowHiddenPartsCommand;
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
 * creation : 14 janv. 08
 * 
 * @author <a href="mailto:gilles.cannenterre@anyware-tech.com">Gilles
 *         Cannenterre</a>
 */
public class ShowHiddenPartAction extends Action {

	protected IGraphicalEditPart host;

	public static String ID = "showHiddenPartAction"; //$NON-NLS-1$

	public ShowHiddenPartAction() {
		setId(ID);
		setText(Messages.ShowHiddenPartAction_ShowAllHiddenParts);
		setToolTipText(Messages.ShowHiddenPartAction_ShowAllHiddenParts_tooltip);
		setImageDescriptor(FilterPlugin.getImageDescriptor("icons/etool16/showhiddentpart_exec.gif")); //$NON-NLS-1$
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

	/**
	 * @see org.eclipse.jface.action.Action#run()
	 */
	@Override
	public void run() {
		Diagram diagram = getCurrentDiagram();

		if (diagram == null) {
			return;
		}

		Command cmd = new ICommandProxy(new ShowHiddenPartsCommand(host.getEditingDomain(), diagram));

		final DiagramCommandStack commandStack = (host).getDiagramEditDomain().getDiagramCommandStack();
		commandStack.execute(cmd, new NullProgressMonitor());
	}

	/**
	 * @see org.eclipse.jface.action.Action#isEnabled()
	 */
	@Override
	public boolean isEnabled() {
		if (getCurrentDiagram() == null) {
			return false;
		}
		for (TreeIterator<EObject> it = getCurrentDiagram().eAllContents(); it.hasNext();) {
			EObject currentDiagramElement = it.next();
			if (false == currentDiagramElement instanceof View) {
				continue;
			}
			if (((View) currentDiagramElement).isVisible() == false) {
				return true;
			}
		}
		return false;
	}

}