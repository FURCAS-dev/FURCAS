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
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.View;

/**
 * Command used to reorder an element both in the domain model and graphically
 * (it should be installed in a Compartment using a List layout).
 * 
 * Creation : 11 mar. 2008
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class CompartmentReorderEObjectCommand extends AbstractTransactionalCommand {

	// The child EditPart to move
	EditPart childEditPart = null;

	// The EditPart that should be after the moved one when the command is done
	EditPart afterEditPart = null;

	// The list of elements in which reposition will take place (domain model
	// side).
	private EList<EObject> elements;

	/**
	 * Constructs a runtime instance of
	 * <code>CompartmentReorderEObjectCommand</code>.
	 * 
	 * @param editingDomain
	 *            the editing domain through which model changes are made
	 * @param label
	 *            label for command
	 * @param elements
	 *            the list of elements in which reposition will take place
	 * @param childEditPart
	 *            the child being moved
	 * @param afterEditPart
	 *            <code>null</code> or the EditPart that should be after (or to
	 *            the right of) the child being moved
	 */
	public CompartmentReorderEObjectCommand(TransactionalEditingDomain editingDomain, String label, EList<EObject> elements, EditPart childEditPart, EditPart afterEditPart) {

		super(editingDomain, label, getWorkspaceFiles(((View) childEditPart.getModel()).getElement()));

		this.elements = elements;
		this.childEditPart = childEditPart;
		this.afterEditPart = afterEditPart;
	}

	/**
	 * @see org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor,
	 *      org.eclipse.core.runtime.IAdaptable)
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
		CommandResult commandResult = null;
		try {
			View movedView = (View) childEditPart.getModel();
			EObject movedElement = movedView.getElement();

			View afterView = afterEditPart == null ? null : (View) afterEditPart.getModel();
			EObject afterElement = afterView == null ? null : afterView.getElement();

			// 1. Reorder the movedElement in the domain model
			int newSemanticPosition = afterElement == null ? elements.size() - 1 : elements.indexOf(afterElement) > elements.indexOf(movedElement) ? elements.indexOf(afterElement) - 1 : elements
					.indexOf(afterElement);
			elements.move(newSemanticPosition, movedElement);

			// 2. And then reorder the movedElement graphically
			EList<?> views = ((View) movedView.eContainer()).getChildren();
			int newViewPosition = afterView == null ? views.size() - 1 : views.indexOf(afterView) > views.indexOf(movedView) ? views.indexOf(afterView) - 1 : views.indexOf(afterView);
			ViewUtil.repositionChildAt((View) childEditPart.getParent().getModel(), (View) childEditPart.getModel(), newViewPosition);

		} catch (RuntimeException exp) {
			commandResult = CommandResult.newErrorCommandResult(exp);
		}
		return (commandResult == null) ? CommandResult.newOKCommandResult() : commandResult;
	}

}
