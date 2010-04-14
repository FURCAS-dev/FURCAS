/***********************************************************************
 * Copyright (c) 2009 Anyware Technologies
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Jacques Lescot (Anyware Technologies) - initial API and implementation
 *
 * $Id: PreviousDiagramAction.java,v 1.2 2009/05/06 13:36:41 jlescot Exp $
 **********************************************************************/
package org.eclipse.emf.ecoretools.diagram.edit.actions;

import org.eclipse.emf.ecoretools.diagram.Messages;
import org.eclipse.emf.ecoretools.diagram.part.EcoreDiagramEditor;
import org.eclipse.emf.ecoretools.diagram.part.INavigationListener;
import org.eclipse.gef.ui.actions.WorkbenchPartAction;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.ui.IWorkbenchPart;

/**
 * This action enables to navigate to the previous diagram. <br>
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class PreviousDiagramAction extends WorkbenchPartAction implements INavigationListener {

	/**
	 * The Constructor
	 * 
	 * @param part
	 *            the IWorkbenchPart
	 */
	public PreviousDiagramAction(IWorkbenchPart part) {
		super(part);
		EcoreDiagramEditor modeler = (EcoreDiagramEditor) getWorkbenchPart();
		modeler.getNavigationManager().addNavigationListener(this);
	}

	/**
	 * @see org.eclipse.gef.ui.actions.WorkbenchPartAction#dispose()
	 */
	public void dispose() {
		EcoreDiagramEditor modeler = (EcoreDiagramEditor) getWorkbenchPart();
		modeler.getNavigationManager().removeNavigationListener(this);
		super.dispose();
	}

	/**
	 * Return true whether the action could be performed
	 * 
	 * @return <code>true</code> whether the action is enabled, false otherwise
	 */
	protected boolean calculateEnabled() {
		EcoreDiagramEditor editor = (EcoreDiagramEditor) getWorkbenchPart();
		return editor.getNavigationManager().canDoPrevious();
	}

	/**
	 * Initializes the action
	 * 
	 * @see org.eclipse.gef.ui.actions.WorkbenchPartAction#init()
	 */
	protected void init() {
		setId(EcoreActionConstants.PREVIOUS_DIAGRAM);
		setText(Messages.PreviousDiagramAction_PreviousDiagram);
	}

	/**
	 * @see org.eclipse.jface.action.IAction#run()
	 */
	public void run() {
		EcoreDiagramEditor editor = (EcoreDiagramEditor) getWorkbenchPart();
		editor.getNavigationManager().previous();
	}

	/**
	 * @see org.eclipse.emf.ecoretools.diagram.part.topcased.modeler.editor.INavigationListener#diagramChanged(org.topcased.modeler.di.model.Diagram)
	 */
	public void diagramChanged(Diagram newDiagram) {
		refresh();
	}
}
