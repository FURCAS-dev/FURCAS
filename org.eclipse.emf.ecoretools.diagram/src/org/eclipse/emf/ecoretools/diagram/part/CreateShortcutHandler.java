/***********************************************************************
 * Copyright (c) 2007, 2009 Anyware Technologies
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Anyware Technologies - initial API and implementation
 *
 * $Id: CreateShortcutHandler.java,v 1.1 2009/02/02 08:39:07 jlescot Exp $
 **********************************************************************/

package org.eclipse.emf.ecoretools.diagram.part;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecoretools.diagram.edit.commands.EcoreCreateShortcutDecorationsCommand;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EPackageEditPart;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.CreateCommand;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * @generated
 */
public class CreateShortcutHandler extends AbstractHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		if (selection != null && !selection.isEmpty() && selection instanceof StructuredSelection) {
			Object firstElt = ((StructuredSelection) selection).getFirstElement();
			TransactionalEditingDomain editingDomain = ((EPackageEditPart) firstElt).getEditingDomain();
			if (firstElt instanceof EPackageEditPart) {
				final View view = (View) ((EPackageEditPart) firstElt).getModel();
				EcoreElementChooserDialog elementChooser = new EcoreElementChooserDialog(HandlerUtil.getActiveShellChecked(event), view);
				int result = elementChooser.open();
				if (result != Window.OK) {
					return null;
				}
				URI selectedModelElementURI = elementChooser.getSelectedModelElementURI();
				final EObject selectedElement;
				try {
					selectedElement = editingDomain.getResourceSet().getEObject(selectedModelElementURI, true);
				} catch (WrappedException e) {
					EcoreDiagramEditorPlugin.getInstance().logError("Exception while loading object: " + selectedModelElementURI.toString(), e); //$NON-NLS-1$
					return null;
				}

				if (selectedElement == null) {
					return null;
				}
				CreateViewRequest.ViewDescriptor viewDescriptor = new CreateViewRequest.ViewDescriptor(new EObjectAdapter(selectedElement), Node.class, null,
						EcoreDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				ICommand command = new CreateCommand(editingDomain, viewDescriptor, view);
				command = command.compose(new EcoreCreateShortcutDecorationsCommand(editingDomain, view, viewDescriptor));
				try {
					OperationHistoryFactory.getOperationHistory().execute(command, new NullProgressMonitor(), null);
				} catch (ExecutionException e) {
					EcoreDiagramEditorPlugin.getInstance().logError("Unable to create shortcut", e); //$NON-NLS-1$
				}
			}
		}
		return null;
	}
}
