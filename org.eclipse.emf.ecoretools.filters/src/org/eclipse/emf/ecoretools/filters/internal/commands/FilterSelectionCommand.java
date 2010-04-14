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
 * $Id: FilterSelectionCommand.java,v 1.4 2008/04/28 09:55:15 jlescot Exp $
 **********************************************************************/
package org.eclipse.emf.ecoretools.filters.internal.commands;

import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecoretools.filters.internal.Messages;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.View;

/**
 * 
 * TODO Describe the class here <br>
 * creation : 14 janv. 08
 * 
 * @author <a href="mailto:gilles.cannenterre@anyware-tech.com">Gilles
 *         Cannenterre</a>
 */
public class FilterSelectionCommand extends AbstractTransactionalCommand {

	private List<IGraphicalEditPart> selection;

	private boolean show;

	public FilterSelectionCommand(TransactionalEditingDomain domain, List<IGraphicalEditPart> selection, boolean show) {
		super(domain, Messages.FilterSelectionCommand_FilterSelection, null);
		this.selection = selection;
		this.show = show;
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) {
		for (IGraphicalEditPart part : selection) {
			View view = part.getNotationView();
			if (view == null) {
				continue;
			}
			view.setVisible(show);
		}
		return CommandResult.newOKCommandResult();
	}

}
