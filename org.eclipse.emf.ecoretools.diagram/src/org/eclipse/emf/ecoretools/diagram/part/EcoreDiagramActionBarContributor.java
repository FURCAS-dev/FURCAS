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
 * $Id: EcoreDiagramActionBarContributor.java,v 1.5 2009/05/06 14:19:21 jlescot Exp $
 **********************************************************************/

package org.eclipse.emf.ecoretools.diagram.part;

import org.eclipse.emf.ecoretools.diagram.Messages;
import org.eclipse.emf.ecoretools.diagram.edit.actions.EcoreActionConstants;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramActionBarContributor;
import org.eclipse.gmf.runtime.diagram.ui.printing.render.actions.EnhancedPrintActionHelper;
import org.eclipse.gmf.runtime.diagram.ui.printing.render.actions.RenderedPrintPreviewAction;
import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.actions.RetargetAction;

/**
 * @generated
 */
public class EcoreDiagramActionBarContributor extends DiagramActionBarContributor {

	/**
	 * @generated
	 */
	protected Class getEditorClass() {
		return EcoreDiagramEditor.class;
	}

	/**
	 * @generated
	 */
	protected String getEditorId() {
		return EcoreDiagramEditor.ID;
	}

	/**
	 * @generated
	 */
	public void init(IActionBars bars, IWorkbenchPage page) {
		super.init(bars, page);
		// print preview
		IMenuManager fileMenu = bars.getMenuManager().findMenuUsingPath(IWorkbenchActionConstants.M_FILE);
		assert fileMenu != null;
		IAction printPreviewAction = new RenderedPrintPreviewAction(new EnhancedPrintActionHelper());
		fileMenu.insertBefore("print", printPreviewAction); //$NON-NLS-1$
		IMenuManager editMenu = bars.getMenuManager().findMenuUsingPath(IWorkbenchActionConstants.M_EDIT);
		assert editMenu != null;
		if (editMenu.find("validationGroup") == null) { //$NON-NLS-1$
			editMenu.add(new GroupMarker("validationGroup")); //$NON-NLS-1$
		}
		IAction validateAction = new ValidateAction(page);
		editMenu.appendToGroup("validationGroup", validateAction); //$NON-NLS-1$
	}
	
	@Override
	protected void buildActions() {
		super.buildActions();
		
		RetargetAction action = null;
		
		// Previous Diagram
        action = new RetargetAction(EcoreActionConstants.PREVIOUS_DIAGRAM, Messages.EcoreDiagramActionBarContributor_PreviousDiagram);
        action.setImageDescriptor(EcoreDiagramEditorPlugin.findImageDescriptor("icons/elcl16/go-previous.png")); //$NON-NLS-1$
        action.setToolTipText(Messages.EcoreDiagramActionBarContributor_GoToPreviousDiagram);
        addRetargetAction(action);
        // Open Parent Diagram
        action = new RetargetAction(EcoreActionConstants.OPEN_PARENT_DIAGRAM, Messages.EcoreDiagramActionBarContributor_OpenParentDiagram);
        action.setImageDescriptor(EcoreDiagramEditorPlugin.findImageDescriptor("icons/elcl16/go-up.png")); //$NON-NLS-1$
        action.setToolTipText(Messages.EcoreDiagramActionBarContributor_OpenTheParentDiagram);
        addRetargetAction(action);
        // Next Diagram
        action = new RetargetAction(EcoreActionConstants.NEXT_DIAGRAM, Messages.EcoreDiagramActionBarContributor_NextDiagram);
        action.setImageDescriptor(EcoreDiagramEditorPlugin.findImageDescriptor("icons/elcl16/go-next.png")); //$NON-NLS-1$
        action.setToolTipText(Messages.EcoreDiagramActionBarContributor_GoToNextDiagram);
        addRetargetAction(action);
	}
	
	@Override
	public void contributeToToolBar(IToolBarManager toolBarManager) {
		// TODO Auto-generated method stub
		super.contributeToToolBar(toolBarManager);
		
		// Navigate actions
        toolBarManager.add(new Separator());
        toolBarManager.add(getAction(EcoreActionConstants.PREVIOUS_DIAGRAM));
        toolBarManager.add(getAction(EcoreActionConstants.OPEN_PARENT_DIAGRAM));
        toolBarManager.add(getAction(EcoreActionConstants.NEXT_DIAGRAM));
	}
}
