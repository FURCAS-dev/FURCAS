/***********************************************************************
 * Copyright (c) 2007 Anyware Technologies
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Anyware Technologies - initial API and implementation
 *
 * $Id: RemoveDiagramCommand.java,v 1.6 2008/04/28 15:23:59 jlescot Exp $
 **********************************************************************/

package org.eclipse.emf.ecoretools.diagram.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecoretools.diagram.Messages;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.MultiDiagramLinkStyle;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

/**
 * 
 * Removes package associated diagrams <br>
 * creation : 01 sept. 2007
 * 
 * @author <a href="mailto:gilles.cannenterre@anyware-tech.com">Gilles
 *         Cannenterre</a>
 */
public class RemoveDiagramCommand extends AbstractTransactionalCommand {

	private MultiDiagramLinkStyle diagramFacet;

	/**
	 * Constructor
	 */
	public RemoveDiagramCommand(MultiDiagramLinkStyle linkStyle) {
		// editing domain is taken for original diagram, if we open diagram from
		// another file, we should use another editing domain
		super(TransactionUtil.getEditingDomain(linkStyle), Messages.RemoveDiagramCommand_RemoveDiagram, null);
		diagramFacet = linkStyle;
	}

	/**
	 * @see org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor,
	 *      org.eclipse.core.runtime.IAdaptable)
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		try {
			@SuppressWarnings("unchecked")
			EList<Diagram> diagramLinks = diagramFacet.getDiagramLinks();
			for (Diagram diagram : diagramLinks) {
				if (diagram != null) {
					// Close associated diagram
					URI uri = diagram.eResource().getURI();
					uri = uri.appendFragment(diagram.eResource().getURIFragment(diagram));
					IEditorInput editorInput = new URIEditorInput(uri);
					IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
					IEditorPart editor = page.findEditor(editorInput);
					if (editor != null) {
						page.closeEditor(editor, true);
					}
					// Remove from resource
					assert diagramFacet.eResource() != null;
					diagramFacet.eResource().getContents().remove(diagram);
				}
			}
			diagramLinks.clear();
			return CommandResult.newOKCommandResult();
		} catch (Exception ex) {
			throw new ExecutionException(Messages.RemoveDiagramCommand_CanNotRemove, ex);
		}
	}
}
