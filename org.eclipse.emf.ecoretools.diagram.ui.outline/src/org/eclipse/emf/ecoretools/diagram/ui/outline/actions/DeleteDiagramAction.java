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
 * $Id: DeleteDiagramAction.java,v 1.1 2008/05/26 12:26:56 jlescot Exp $
 **********************************************************************/

package org.eclipse.emf.ecoretools.diagram.ui.outline.actions;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecoretools.diagram.ui.outline.internal.Activator;
import org.eclipse.emf.ecoretools.diagram.ui.outline.internal.Messages;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.action.Action;

/**
 * Action used to delete the selected diagram
 * 
 * Creation : 13 feb. 2008
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class DeleteDiagramAction extends Action {

	private Diagram diagram;

	/**
	 * Constructor
	 * 
	 * @param diagramToDelete
	 *            the Diagram to delete
	 */
	public DeleteDiagramAction(Diagram diagramToDelete) {
		this.diagram = diagramToDelete;

		setText(Messages.DeleteDiagramAction_DeleteDiagram);
		setImageDescriptor(Activator.getImageDescriptor("icons/etool16/delete.gif")); //$NON-NLS-1$
	}

	/**
	 * We must have previously checked that this is not the current diagram
	 * 
	 * @see org.eclipse.jface.action.Action#isEnabled()
	 */
	@Override
	public boolean isEnabled() {
		return true;
	}

	/**
	 * @see org.eclipse.jface.action.Action#run()
	 */
	@Override
	public void run() {
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(diagram);
		if (editingDomain != null) {
			EList<EObject> diagrams = diagram.eResource().getContents();
			Command command = new RemoveCommand(editingDomain, diagrams, diagram);
			editingDomain.getCommandStack().execute(command);
		}
	}

}
