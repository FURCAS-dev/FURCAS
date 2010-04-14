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
 * $Id: RenameDiagramAction.java,v 1.1 2008/05/26 12:26:56 jlescot Exp $
 **********************************************************************/

package org.eclipse.emf.ecoretools.diagram.ui.outline.actions;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecoretools.diagram.ui.outline.internal.Activator;
import org.eclipse.emf.ecoretools.diagram.ui.outline.internal.Messages;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.window.Window;

/**
 * Action used to rename the given diagram
 * 
 * Creation : 13 feb. 2008
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class RenameDiagramAction extends Action {

	private Diagram diagram;

	/**
	 * Constructor
	 * 
	 * @param diagramToRename
	 *            the Diagram to rename
	 */
	public RenameDiagramAction(Diagram diagramToRename) {
		this.diagram = diagramToRename;

		setText(Messages.RenameDiagramAction_RenameDiagram);
		setImageDescriptor(Activator.getImageDescriptor("icons/etool16/rename.gif")); //$NON-NLS-1$
	}

	/**
	 * @see org.eclipse.jface.action.Action#run()
	 */
	@Override
	public void run() {
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(diagram);
		if (editingDomain != null) {

			// Input name
			InputDialog dialog = new InputDialog(Activator.getDefault().getWorkbench().getDisplay().getActiveShell(), Messages.RenameDiagramAction_RenameExistingDiagram, Messages.RenameDiagramAction_NewName, diagram.getName(), null);
			if (dialog.open() == Window.OK) {
				String name = dialog.getValue();
				if (name != null && !name.equals("")) { //$NON-NLS-1$
					Command command = new SetCommand(editingDomain, diagram, NotationPackage.eINSTANCE.getDiagram_Name(), dialog.getValue());
					editingDomain.getCommandStack().execute(command);
				}
			}
		}
	}

}