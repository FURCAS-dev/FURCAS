/**
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
 * $Id: EReferenceUtils.java,v 1.11 2009/01/29 10:02:08 jlescot Exp $
 */
package org.eclipse.emf.ecoretools.diagram.edit.parts;

import java.util.Collections;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecoretools.diagram.Messages;
import org.eclipse.emf.ecoretools.diagram.edit.commands.UpdateLinkedEReferenceDeferredCommand;
import org.eclipse.emf.ecoretools.diagram.part.EcoreDiagramEditorPlugin;
import org.eclipse.emf.transaction.Transaction;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.util.StringStatics;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramGraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.util.EditPartUtil;

/**
 * 
 * TODO Describe the class here <br>
 * creation : 15 janv. 08
 * 
 * @author <a href="mailto:gilles.cannenterre@anyware-tech.com">Gilles
 *         Cannenterre</a>
 */
public class EReferenceUtils {

	/**
	 * Track eopposite link
	 */
	public static void trackReferences(EReferenceEditPart referenceEditPart) {
		EObject eReference = referenceEditPart.resolveSemanticElement();
		if (false == eReference instanceof EReference) {
			return;
		}
		EditPart targetPart = referenceEditPart.getTarget();
		if (false == targetPart instanceof IGraphicalEditPart) {
			return;
		}
		EReferenceEditPart oppositeEditPart = null;
		for (Object part : ((IGraphicalEditPart) targetPart).getSourceConnections()) {
			if (false == part instanceof EReferenceEditPart) {
				continue;
			}
			if (((EReferenceEditPart) part).resolveSemanticElement() == ((EReference) eReference).getEOpposite()) {
				oppositeEditPart = (EReferenceEditPart) part;
				break;
			}
		}
		if (oppositeEditPart == null) {
			return;
		}
		// Hide line of the non selected reference
		EReferenceEditPart masterPart;
		EReferenceEditPart slavePart;
		if (oppositeEditPart.getSelected() != EditPart.SELECTED_NONE) {
			referenceEditPart.getPrimaryShape().setHideLine(true);
			oppositeEditPart.getPrimaryShape().setHideLine(false);
			masterPart = oppositeEditPart;
			slavePart = referenceEditPart;
		} else {
			oppositeEditPart.getPrimaryShape().setHideLine(true);
			referenceEditPart.getPrimaryShape().setHideLine(false);
			masterPart = referenceEditPart;
			slavePart = oppositeEditPart;
		}

		TransactionalEditingDomain editingDomain = masterPart.getEditingDomain();
		Command cmd = new ICommandProxy(new UpdateLinkedEReferenceDeferredCommand(editingDomain, masterPart, slavePart));
		executeCommand(cmd, masterPart);
	}

	/**
	 * Executes the supplied command inside an <code>unchecked action</code>
	 * Taken from the CanonicalEditPolicy class
	 * 
	 * @param cmd
	 *            command that can be executed (i.e., cmd.canExecute() == true)
	 * @param part
	 */
	public static void executeCommand(final Command cmd, IGraphicalEditPart part) {
		Map<String, Boolean> options = null;
		boolean isActivating = true;
		// use the viewer to determine if we are still initializing the diagram
		// do not use the DiagramEditPart.isActivating since
		// ConnectionEditPart's parent will not be a diagram edit part
		EditPartViewer viewer = part.getViewer();
		if (viewer instanceof DiagramGraphicalViewer) {
			isActivating = ((DiagramGraphicalViewer) viewer).isInitializing();
		}

		if (isActivating || !EditPartUtil.isWriteTransactionInProgress(part, false, false))
			options = Collections.singletonMap(Transaction.OPTION_UNPROTECTED, Boolean.TRUE);

		AbstractEMFOperation operation = new AbstractEMFOperation((part).getEditingDomain(), StringStatics.BLANK, options) {

			@Override
			protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

				cmd.execute();

				return Status.OK_STATUS;
			}
		};
		try {
			operation.execute(new NullProgressMonitor(), null);
		} catch (ExecutionException e) {
			EcoreDiagramEditorPlugin.getInstance().logError(Messages.EReferenceUtils_CanNotExecute, e);
		}
	}

}
