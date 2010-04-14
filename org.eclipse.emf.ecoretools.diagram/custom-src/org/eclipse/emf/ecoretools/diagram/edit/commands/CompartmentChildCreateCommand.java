/**
 * Copyright (c) 2008, 2009 Anyware Technologies and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Anyware Technologies - initial API and implementation
 */
package org.eclipse.emf.ecoretools.diagram.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.diagram.ui.commands.CreateCommand;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.notation.View;

/**
 * Command used to add a child element at a specified position
 * (it should be installed in a Compartment using a List layout).
 * 
 * Creation : 28 mar. 2008
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class CompartmentChildCreateCommand extends CreateCommand {

	private int index;

	public CompartmentChildCreateCommand(TransactionalEditingDomain editingDomain, ViewDescriptor viewDescriptor, View containerView, int index) {
		super(editingDomain, viewDescriptor, containerView);
		this.index = index;
	}

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.commands.CreateCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor, org.eclipse.core.runtime.IAdaptable)
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		View view = ViewService.getInstance().createView(viewDescriptor.getViewKind(), viewDescriptor.getElementAdapter(), containerView, viewDescriptor.getSemanticHint(), index,
				viewDescriptor.isPersisted(), viewDescriptor.getPreferencesHint());
		Assert.isNotNull(view, "failed to create a view"); //$NON-NLS-1$
		viewDescriptor.setView(view);

		return CommandResult.newOKCommandResult(viewDescriptor);
	}

}
