/**
 * Copyright (c) 2008, 2009 Anyware Technologies and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Gilles Cannenterre (Anyware Technologies) - initial API and implementation
 *    Jacques LESCOT (Anyware Technologies) - Bug #238052 : Restore related elements actions should be also available for shortcut elements
 *    Mariot Chauvin (Obeo)  - Bug #294090 : NPE could be thrown in RestoreRelatedLinksAction#isEnabled
 *
 * $Id: RestoreRelatedLinksAction.java,v 1.11 2010/01/20 16:56:03 jlescot Exp $
 */
package org.eclipse.emf.ecoretools.diagram.edit.actions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecoretools.diagram.Messages;
import org.eclipse.emf.ecoretools.diagram.edit.commands.ArrangeRelatedNodesCommand;
import org.eclipse.emf.ecoretools.diagram.edit.commands.RestoreRelatedLinksCommand;
import org.eclipse.emf.ecoretools.diagram.edit.commands.RestoreRelatedMissingNodesCommand;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EPackageEditPart;
import org.eclipse.emf.ecoretools.diagram.part.EcoreDiagramEditorPlugin;
import org.eclipse.gef.commands.CompoundCommand;
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
 * Triggers restoration of the outgoing or ingoing links for the selected parts <br>
 * creation : 15 avr. 2008
 * 
 * @author <a href="mailto:gilles.cannenterre@anyware-tech.com">Gilles
 *         Cannenterre</a>
 */
public class RestoreRelatedLinksAction extends Action {

	protected IGraphicalEditPart host;

	public static String ID = "restoreRelatedLinksAction"; //$NON-NLS-1$

	public RestoreRelatedLinksAction() {
		setId(ID);
		setText(Messages.RestoreRelatedLinksAction_RestoreRelatedElements);
		setToolTipText(Messages.RestoreRelatedLinksAction_RestoreRelatedElements_tooltip);
		setImageDescriptor(EcoreDiagramEditorPlugin.getBundledImageDescriptor("icons/etool16/restorerelatedlinks_exec.gif")); //$NON-NLS-1$
	}

	private Diagram getCurrentDiagram() {
		IEditorPart editorPart = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		if (editorPart instanceof DiagramEditor) {
			host = ((DiagramEditor) editorPart).getDiagramEditPart();
			return ((View) host.getModel()).getDiagram();
		}
		return null;
	}

	private List<View> getSelection() {
		List<View> viewSelected = new ArrayList<View>();
		ISelection selection = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().getSelection();
		if (!(selection instanceof IStructuredSelection)) {
			return Collections.emptyList();
		}
		for (Object object : ((IStructuredSelection) selection).toList()) {
			if (object instanceof IGraphicalEditPart && !(object instanceof DiagramEditPart)) {
				viewSelected.add(((IGraphicalEditPart) object).getNotationView());
			}
		}
		return viewSelected;
	}

	/**
	 * @see org.eclipse.jface.action.Action#run()
	 */
	@Override
	public void run() {
		List<View> selection = getSelection();

		if (!selection.isEmpty() && host instanceof DiagramEditPart) {
			final DiagramCommandStack commandStack = host.getDiagramEditDomain().getDiagramCommandStack();
			CompoundCommand cmd = new CompoundCommand(Messages.RestoreRelatedLinksAction_RestoreRelatedLinks);

			cmd.add(new ICommandProxy(new RestoreRelatedMissingNodesCommand((DiagramEditPart) host, selection)));
			cmd.add(new ICommandProxy(new RestoreRelatedLinksCommand((DiagramEditPart) host, selection)));
			cmd.add(new ICommandProxy(new ArrangeRelatedNodesCommand((DiagramEditPart) host, selection)));

			commandStack.execute(cmd, new NullProgressMonitor());
		}
	}

	/**
	 * @see org.eclipse.jface.action.Action#isEnabled()
	 */
	@Override
	public boolean isEnabled() {
		if (!getSelection().isEmpty()) {
			final Diagram diagram = getCurrentDiagram();
			return diagram != null && EPackageEditPart.MODEL_ID.equals(getCurrentDiagram().getType());
		}
		return false;	
	}

}
