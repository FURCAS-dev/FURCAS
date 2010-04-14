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
 * $Id: FilterTypeSelectionCommand.java,v 1.4 2008/04/28 09:55:14 jlescot Exp $
 **********************************************************************/
package org.eclipse.emf.ecoretools.filters.internal.commands;

import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecoretools.filters.internal.Messages;
import org.eclipse.emf.ecoretools.filters.internal.utils.DiagramFilterUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;

/**
 * 
 * TODO Describe the class here <br>
 * creation : 14 janv. 08
 * 
 * @author <a href="mailto:gilles.cannenterre@anyware-tech.com">Gilles
 *         Cannenterre</a>
 */
public class FilterTypeSelectionCommand extends AbstractTransactionalCommand {

	private Diagram diagramToFilter;

	private List<String> typesToFilter;

	private boolean show;

	public FilterTypeSelectionCommand(TransactionalEditingDomain domain, Diagram diagramToFilter, List<String> typesToFilter, boolean show) {
		super(domain, Messages.FilterTypeSelectionCommand_FilterType, null);
		this.diagramToFilter = diagramToFilter;
		this.typesToFilter = typesToFilter;
		this.show = show;
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) {
		for (TreeIterator<EObject> it = diagramToFilter.eAllContents(); it.hasNext();) {
			EObject currentDiagramElement = it.next();
			if (false == currentDiagramElement instanceof View) {
				continue;
			}
			if (DiagramFilterUtil.isFilteredType((View) currentDiagramElement, typesToFilter)) {
				((View) currentDiagramElement).setVisible(show);
			}
		}
		return CommandResult.newOKCommandResult();
	}

}
