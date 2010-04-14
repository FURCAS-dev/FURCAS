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
 * $Id: InitializeAndLayoutDiagramCommand.java,v 1.8 2008/04/28 15:23:59 jlescot Exp $
 **********************************************************************/
package org.eclipse.emf.ecoretools.diagram.edit.commands;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecoretools.diagram.Messages;
import org.eclipse.emf.ecoretools.diagram.part.EcoreDiagramContentInitializer;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.services.layout.LayoutService;
import org.eclipse.gmf.runtime.diagram.ui.services.layout.LayoutType;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Node;

/**
 * 
 * Initialize diagram content and perform default layout <br>
 * creation : 3 janv. 2008
 * 
 * @author <a href="mailto:gilles.cannenterre@anyware-tech.com">Gilles
 *         Cannenterre</a>
 */
public class InitializeAndLayoutDiagramCommand extends AbstractTransactionalCommand {

	private Diagram diagram;

	private boolean initEPackageContent;

	public InitializeAndLayoutDiagramCommand(TransactionalEditingDomain domain, Diagram diagram, boolean initEPackageContent) {
		super(domain, Messages.CommandName_InitializeAndLayoutDiagram, null);
		this.diagram = diagram;
		this.initEPackageContent = initEPackageContent;
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		if (diagram == null) {
			return CommandResult.newWarningCommandResult(Messages.InitializeAndLayoutDiagramCommand_UnableToProceed, null);
		}
		// Initialize diagram content
		EcoreDiagramContentInitializer initializer = new EcoreDiagramContentInitializer();
		initializer.setInitEPackageContent(initEPackageContent);
		initializer.initDiagramContent(diagram);

		// Layout diagram content if necessary
		if (false == diagram.getChildren().isEmpty()) {
			List<Node> nodes = new ArrayList<Node>();
			for (Object view : diagram.getChildren()) {
				if (view instanceof Node) {
					nodes.add((Node) view);
				}
			}
			LayoutService.getInstance().layoutNodes(nodes, true, LayoutType.DEFAULT);
		}

		return CommandResult.newOKCommandResult();
	}

}
