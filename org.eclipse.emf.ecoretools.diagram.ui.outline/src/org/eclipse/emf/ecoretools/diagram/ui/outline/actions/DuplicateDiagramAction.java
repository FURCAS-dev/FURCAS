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
 * $Id: DuplicateDiagramAction.java,v 1.1 2008/05/26 12:26:56 jlescot Exp $
 **********************************************************************/
package org.eclipse.emf.ecoretools.diagram.ui.outline.actions;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecoretools.diagram.ui.outline.internal.Activator;
import org.eclipse.emf.ecoretools.diagram.ui.outline.internal.Messages;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.action.Action;

/**
 * An action used to duplicate the given diagram. The new diagram is added at
 * the same level than the initial diagram.
 * 
 * Creation 27 mars 08
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class DuplicateDiagramAction extends Action {

	// The diagram to duplicate
	private Diagram diagram;

	/**
	 * Constructor
	 * 
	 * @param diag
	 *            the Diagram to duplicate
	 */
	public DuplicateDiagramAction(Diagram diag) {
		super(Messages.DuplicateDiagramAction_DuplicateDiagram, Activator.getImageDescriptor("icons/etool16/duplicateDiagram.png")); //$NON-NLS-1$

		this.diagram = diag;
	}

	/**
	 * @see org.eclipse.jface.action.Action#run()
	 */
	public void run() {
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(diagram);
		if (editingDomain != null) {
			// Clone the current diagram
			Diagram clonedDiagram = (Diagram) EcoreUtil.copy(diagram);
			// Give a new name
			clonedDiagram.setName(diagram.getName() + Messages.DuplicateDiagramAction_Duplicated);

			Command command = new AddCommand(editingDomain, diagram.eResource().getContents(), clonedDiagram);
			// Execute changes through a Command so that Undo/Redo is supported
			editingDomain.getCommandStack().execute(command);

		}
	}
}
