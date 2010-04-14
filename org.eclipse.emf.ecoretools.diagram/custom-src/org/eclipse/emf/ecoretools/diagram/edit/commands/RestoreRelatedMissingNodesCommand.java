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
 * $Id: RestoreRelatedMissingNodesCommand.java,v 1.8 2009/01/29 10:02:08 jlescot Exp $
 */
package org.eclipse.emf.ecoretools.diagram.edit.commands;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecoretools.diagram.Messages;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EReferenceUtils;
import org.eclipse.emf.ecoretools.diagram.part.EcoreLinkDescriptor;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;

/**
 * 
 * Restores the missing nodes of outgoing or incoming links for the selected
 * parts <br>
 * creation : 15 avr. 2008
 * 
 * @author <a href="mailto:gilles.cannenterre@anyware-tech.com">Gilles
 *         Cannenterre</a>
 */
public class RestoreRelatedMissingNodesCommand extends RestoreRelatedLinksCommand {

	public RestoreRelatedMissingNodesCommand(DiagramEditPart diagramEditPart, List<?> selection) {
		super(diagramEditPart, selection);
	}

	/**
	 * @see org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor,
	 *      org.eclipse.core.runtime.IAdaptable)
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		for (Object object : adapters) {
			if (object instanceof IAdaptable) {
				IAdaptable ad = (IAdaptable) object;
				View view = (View) ad.getAdapter(View.class);
				if (view != null) {
					refreshMissingNodes(view);
				}
			} else if (object instanceof View) {
				refreshMissingNodes((View) object);
			}

		}

		return CommandResult.newOKCommandResult();
	}

	/**
	 * Refresh related missing nodes for graphicalEditPart
	 * 
	 * @param graphicalEditPart
	 */
	protected void refreshMissingNodes(View notationView) {
		Map<EObject, View> domain2NotationMap = new HashMap<EObject, View>();

		// Create related missing nodes for all semantic link
		Collection<? extends EcoreLinkDescriptor> linkDescriptors = getLinkDescriptorToProcess(notationView, domain2NotationMap);
		createRelatedMissingNodes(linkDescriptors, domain2NotationMap);
	}

	/**
	 * Create related missing nodes corresponding to linkDescriptions
	 * 
	 * @param part
	 * @param linkDescriptors
	 * @param domain2NotationMap
	 */
	protected void createRelatedMissingNodes(Collection<? extends EcoreLinkDescriptor> linkDescriptors, Map<EObject, View> domain2NotationMap) {
		// map diagram
		mapModel(diagram, domain2NotationMap);

		List<EObject> objectViews = new ArrayList<EObject>();
		for (EcoreLinkDescriptor nextLinkDescriptor : linkDescriptors) {
			// EditPart sourceEditPart =
			// getEditPart(nextLinkDescriptor.getSource(), domain2NotationMap);
			// EditPart targetEditPart =
			// getEditPart(nextLinkDescriptor.getDestination(),
			// domain2NotationMap);
			View sourceView = domain2NotationMap.get(nextLinkDescriptor.getSource());
			View targetView = domain2NotationMap.get(nextLinkDescriptor.getDestination());

			// Create missing parts
			List<CreateViewRequest.ViewDescriptor> normalViewDescriptors = new ArrayList<CreateViewRequest.ViewDescriptor>();
			List<CreateViewRequest.ViewDescriptor> shortcutViewDescriptors = new ArrayList<CreateViewRequest.ViewDescriptor>();
			if (sourceView == null) {
				if (nextLinkDescriptor.getSource() != null && !objectViews.contains(nextLinkDescriptor.getSource())) {
					updateDescriptors(nextLinkDescriptor.getSource(), normalViewDescriptors, shortcutViewDescriptors);
					objectViews.add(nextLinkDescriptor.getSource());
				}
			} else {
				setViewVisible(Collections.singletonList(sourceView));
			}

			if (targetView == null) {
				if (nextLinkDescriptor.getDestination() != null && !objectViews.contains(nextLinkDescriptor.getDestination())) {
					updateDescriptors(nextLinkDescriptor.getDestination(), normalViewDescriptors, shortcutViewDescriptors);
					objectViews.add(nextLinkDescriptor.getDestination());
				}
			} else {
				setViewVisible(Collections.singletonList(targetView));
			}

			CompoundCommand compoundCmd = new CompoundCommand(Messages.RestoreRelatedMissingNodesCommand_CreateMissingNodes);

			if (false == normalViewDescriptors.isEmpty()) {
				CreateViewRequest cvr = new CreateViewRequest(normalViewDescriptors);
				cvr.setLocation(new Point(-1, -1));
				Command cmd = host.getCommand(cvr);

				compoundCmd.add(cmd);
			}
			if (false == shortcutViewDescriptors.isEmpty()) {
				CreateViewRequest cvr = new CreateViewRequest(shortcutViewDescriptors);
				cvr.setLocation(new Point(-1, -1));
				Command cmd = host.getCommand(cvr);
				cmd.chain(new ICommandProxy(new EcoreCreateShortcutDecorationsCommand(getEditingDomain(), diagram, shortcutViewDescriptors)));

				compoundCmd.add(cmd);
			}

			if (compoundCmd != null && compoundCmd.canExecute()) {
				EReferenceUtils.executeCommand(compoundCmd, host);
			}
		}
		objectViews.clear();

	}

	private void updateDescriptors(final EObject object, List<CreateViewRequest.ViewDescriptor> normalViewDescriptors, List<CreateViewRequest.ViewDescriptor> shortcutViewDescriptors) {
		if (object.eContainer() == diagram.getElement()) {
			normalViewDescriptors.add(new CreateViewRequest.ViewDescriptor(new EObjectAdapter(object), Node.class, null, host.getDiagramPreferencesHint()));
		} else {
			shortcutViewDescriptors.add(new CreateViewRequest.ViewDescriptor(new EObjectAdapter(object), Node.class, null, host.getDiagramPreferencesHint()));
		}
	}

}
