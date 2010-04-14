/***********************************************************************
 * Copyright (c) 2007, 2008 Anyware Technologies
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Anyware Technologies - initial API and implementation
 *
 * $Id: PackageDiagramDragDropEditPolicy.java,v 1.16 2009/04/27 13:28:05 jlescot Exp $
 **********************************************************************/

package org.eclipse.emf.ecoretools.diagram.edit.policies;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecoretools.diagram.edit.commands.EcoreCreateShortcutDecorationsCommand;
import org.eclipse.emf.ecoretools.diagram.edit.commands.RestoreRelatedLinksCommand;
import org.eclipse.emf.ecoretools.diagram.edit.commands.UpdateEditPartCommand;
import org.eclipse.emf.ecoretools.diagram.part.EcoreDiagramEditorPlugin;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DiagramDragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.diagram.ui.requests.ArrangeRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;

/**
 * 
 * Custom drag and drop edit policy that creates shortcuts only for elements
 * already present in target diagram <br>
 * creation : 01 sept. 2007
 * 
 * @author <a href="mailto:gilles.cannenterre@anyware-tech.com">Gilles
 *         Cannenterre</a>
 */
public class PackageDiagramDragDropEditPolicy extends DiagramDragDropEditPolicy {

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.DiagramDragDropEditPolicy#getDropCommand(org.eclipse.gef.requests.ChangeBoundsRequest)
	 */
	@Override
	protected Command getDropCommand(ChangeBoundsRequest dropRequest) {
		List<CreateViewRequest.ViewDescriptor> shortcutViewDescriptors = new ArrayList<CreateViewRequest.ViewDescriptor>();
		List<CreateViewRequest.ViewDescriptor> normalViewDescriptors = new ArrayList<CreateViewRequest.ViewDescriptor>();
		for (Object nextPart : dropRequest.getEditParts()) {
			if (nextPart instanceof IGraphicalEditPart) {
				EObject nextObject = ((IGraphicalEditPart) nextPart).resolveSemanticElement();
				// Continue if element is the diagram canvas
				if (nextObject != null && !getHostView().getElement().equals(nextObject)) {
					// Create a shortcut depending on whether a view already
					// exists
					if (!isElementInView(nextObject, dropRequest) && getHostView().getElement() == nextObject.eContainer()) {
						normalViewDescriptors.add(new CreateViewRequest.ViewDescriptor(new EObjectAdapter(nextObject), Node.class, null, getDiagramPreferencesHint()));
					} else {
						shortcutViewDescriptors.add(new CreateViewRequest.ViewDescriptor(new EObjectAdapter(nextObject), Node.class, null, getDiagramPreferencesHint()));
					}
				}
			}
		}

		Command shortcutCommand = null;
		if (!shortcutViewDescriptors.isEmpty()) {
			shortcutCommand = createShortcutsCommand(castToDropObjectsRequest(dropRequest), shortcutViewDescriptors);
		}
		Command normalCommand = null;
		if (!normalViewDescriptors.isEmpty()) {
			normalCommand = createViewsAndRestoreRelatedLinks(castToDropObjectsRequest(dropRequest), normalViewDescriptors);
		}
		if (shortcutCommand != null) {
			Command createBoth = shortcutCommand.chain(normalCommand);
			return createBoth;
		}

		return normalCommand;
	}

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.DiagramDragDropEditPolicy#getDropObjectsCommand(org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest)
	 */
	@Override
	public Command getDropObjectsCommand(DropObjectsRequest dropRequest) {
		List<CreateViewRequest.ViewDescriptor> shortcutViewDescriptors = new ArrayList<CreateViewRequest.ViewDescriptor>();
		List<CreateViewRequest.ViewDescriptor> normalViewDescriptors = new ArrayList<CreateViewRequest.ViewDescriptor>();
		for (Object nextObject : dropRequest.getObjects()) {
			// Continue if element is the diagram canvas
			if (nextObject instanceof EObject && !getHostView().getElement().equals(nextObject)) {
				// Create a shortcut depending on whether a view already exists
				if (!isElementInView(nextObject, dropRequest) && getHostView().getElement() == ((EObject) nextObject).eContainer()) {
					normalViewDescriptors.add(new CreateViewRequest.ViewDescriptor(new EObjectAdapter((EObject) nextObject), Node.class, null, getDiagramPreferencesHint()));
				} else {
					shortcutViewDescriptors.add(new CreateViewRequest.ViewDescriptor(new EObjectAdapter((EObject) nextObject), Node.class, null, getDiagramPreferencesHint()));
				}
			}
		}

		Command shortcutCommand = null;
		if (!shortcutViewDescriptors.isEmpty()) {
			shortcutCommand = createShortcutsCommand(dropRequest, shortcutViewDescriptors);
		}
		Command normalCommand = null;
		if (!normalViewDescriptors.isEmpty()) {
			normalCommand = createViewsAndRestoreRelatedLinks(dropRequest, normalViewDescriptors);
		}
		if (shortcutCommand != null) {
			Command createBoth = shortcutCommand.chain(normalCommand);
			return createBoth.chain(new ICommandProxy(new UpdateEditPartCommand(getEditingDomain(), getHost())));
		}
		if (normalCommand != null) {
			return normalCommand.chain(new ICommandProxy(new UpdateEditPartCommand(getEditingDomain(), getHost())));
		}
		return UnexecutableCommand.INSTANCE;
	}

	protected boolean isElementInView(Object nextObject, Request request) {
		@SuppressWarnings("unchecked")
		EList<View> views = getHostView().getChildren();
		for (View nextView : views) {
			if (nextView.getEAnnotation("Shortcut") != null) { //$NON-NLS-1$
				continue;
			}
			if (nextView.getElement() == null) {
				continue;
			}
			if (nextView.getElement().equals(nextObject)) {
				return true;
			}
		}
		return false;
	}

	protected Command createShortcutsCommand(DropObjectsRequest dropRequest, List<ViewDescriptor> viewDescriptors) {
		Command createCommand = createViewsAndRestoreRelatedLinks(dropRequest, viewDescriptors);
		if (createCommand != null) {
			// Chain a "Create Shortcut" command
			createCommand.chain(new ICommandProxy(new EcoreCreateShortcutDecorationsCommand(getEditingDomain(), getHostView(), viewDescriptors)));
		}
		return createCommand;
	}

	protected Command createViewsAndRestoreRelatedLinks(DropObjectsRequest dropRequest, List<ViewDescriptor> viewDescriptors) {

		CreateViewRequest createViewRequest = new CreateViewRequest(viewDescriptors);
		createViewRequest.setLocation(dropRequest.getLocation());
		Command createCommand = getHost().getCommand(createViewRequest);

		if (createCommand != null) {
			List result = (List) createViewRequest.getNewObject();
			dropRequest.setResult(result);

			// Chain a "Restore Related Links" command
			createCommand.chain(new ICommandProxy(new RestoreRelatedLinksCommand(getDiagramEditPart(), (List<?>) createViewRequest.getNewObject())));

			// Chain an "Arrange Selection" command
			ArrangeRequest arrangeRequest = new ArrangeRequest(RequestConstants.REQ_ARRANGE_DEFERRED);
			arrangeRequest.setViewAdaptersToArrange(result);
			createCommand.chain(getHost().getCommand(arrangeRequest));
		}

		return createCommand;
	}

	private DiagramEditPart getDiagramEditPart() {
		if (getHost() instanceof DiagramEditPart) {
			return (DiagramEditPart) getHost();
		}
		IEditorPart editorPart = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		if (false == editorPart instanceof DiagramEditor) {
			return null;
		}
		return ((DiagramEditor) editorPart).getDiagramEditPart();
	}

	private TransactionalEditingDomain getEditingDomain() {
		if (getHost() instanceof IGraphicalEditPart) {
			return ((IGraphicalEditPart) getHost()).getEditingDomain();
		}
		return null;
	}

	private View getHostView() {
		return (View) getHost().getModel();
	}

	private PreferencesHint getDiagramPreferencesHint() {
		return EcoreDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT;
	}
}
