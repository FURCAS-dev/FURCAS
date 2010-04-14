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
 * $Id: OpenDiagramEditPolicy.java,v 1.13 2009/03/19 14:35:15 jlescot Exp $
 **********************************************************************/

package org.eclipse.emf.ecoretools.diagram.edit.policies;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecoretools.diagram.Messages;
import org.eclipse.emf.ecoretools.diagram.edit.dialogs.ManageDiagramsDialog;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EPackageEditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EPackageNameEditPart;
import org.eclipse.emf.ecoretools.diagram.part.EcoreDiagramContentInitializer;
import org.eclipse.emf.ecoretools.diagram.part.EcoreDiagramEditor;
import org.eclipse.emf.ecoretools.diagram.part.EcoreDiagramEditorPlugin;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.OpenEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.services.layout.LayoutService;
import org.eclipse.gmf.runtime.diagram.ui.services.layout.LayoutType;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.jface.window.Window;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

/**
 * @generated NOT
 */
public class OpenDiagramEditPolicy extends OpenEditPolicy {

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.OpenEditPolicy#getOpenCommand(org.eclipse.gef.Request)
	 */
	@Override
	protected Command getOpenCommand(Request request) {
		EditPart targetEditPart = getTargetEditPart(request);
		if (targetEditPart instanceof EPackageNameEditPart && targetEditPart.getParent() != null) {
			targetEditPart = targetEditPart.getParent();
		}
		if (false == targetEditPart instanceof GraphicalEditPart) {
			return UnexecutableCommand.INSTANCE;
		}

		return new ICommandProxy(new OpenDiagramCommand(((GraphicalEditPart) targetEditPart).resolveSemanticElement(), ((EObject) targetEditPart.getModel()).eResource()));
	}

	/**
	 * This command open a Dialog used to manage existing diagrams. It is
	 * possible to create new one, delete/rename an existing one, or open the
	 * selected in a new editor.
	 */
	public static class OpenDiagramCommand extends AbstractTransactionalCommand {

		/**
		 * The list of Diagrams that are associated with the given domain
		 * Element
		 */
		private List<Diagram> allDiagrams = new ArrayList<Diagram>();

		/** A given model element */
		private EObject domainElement;

		/** The diagram resource where Diagrams are created */
		private Resource diagramResource;

		/**
		 * Constructor
		 * 
		 * @param domainElt
		 *            the domain element on which the diagram should be
		 *            associated
		 * @param diagResource
		 */
		public OpenDiagramCommand(EObject domainElt, Resource diagResource) {
			super(TransactionUtil.getEditingDomain(domainElt), Messages.OpenDiagramEditPolicy_OpenDiagram, null);
			this.domainElement = domainElt;
			this.diagramResource = diagResource;

			if (domainElement instanceof EPackage) {
				for (EObject currentDiag : diagramResource.getContents()) {
					if (currentDiag instanceof Diagram && domainElement.equals(((Diagram) currentDiag).getElement())) {
						allDiagrams.add((Diagram) currentDiag);
					}
				}
			}
		}

		/**
		 * @see org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor,
		 *      org.eclipse.core.runtime.IAdaptable)
		 */
		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
			// Open dialog
			final Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor().getSite().getShell();
			ManageDiagramsDialog manageDiagramsDialog = new ManageDiagramsDialog(shell, allDiagrams);
			switch (manageDiagramsDialog.open()) {
			// Cancel pressed
			case Window.CANCEL: {
				// nothing to do
				break;
			}
				// OK pressed
			case Window.OK: {
				okPressed(manageDiagramsDialog.getSelectedDiagram());
				break;
			}
				// Create pressed
			case ManageDiagramsDialog.CREATE: {
				createPressed(manageDiagramsDialog.getInitializeContentButtonState());
				break;
			}
				// Delete pressed
			case ManageDiagramsDialog.DELETE: {
				deletePressed(manageDiagramsDialog.getSelectedDiagram());
				break;
			}
				// Things gone bad ...
			default: {
				return CommandResult.newErrorCommandResult(Messages.OpenDiagramEditPolicy_OperationFailed);
			}
			}
			return CommandResult.newOKCommandResult();
		}

		private void okPressed(Diagram diagram) {
			openEditor(diagram);
		}

		private IEditorInput getEditorInput(Diagram diagram) {
			URI parentUri = diagram.eResource().getURI();
			URI uri = parentUri.appendFragment(diagram.eResource().getURIFragment(diagram));
			return new URIEditorInput(uri);
		}

		/**
		 * @param diagram
		 */
		protected void openEditor(Diagram diagram) {
			if (diagram != null) {
				IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
				IEditorPart editorPart = activePage.getActiveEditor();
				try {
					if (editorPart instanceof EcoreDiagramEditor) {
						((EcoreDiagramEditor) editorPart).setDiagram(diagram);
					} else {
						activePage.openEditor(getEditorInput(diagram), getEditorID());
					}
				} catch (PartInitException e) {
					EcoreDiagramEditorPlugin.getInstance().logError(Messages.OpenDiagramEditPolicy_CanNotOpen);
				}
			}
		}

		/**
		 * @param initializeContent
		 * @return Diagram
		 */
		protected Diagram createPressed(boolean initializeContent) {
			try {
				Diagram diagram = intializeNewDiagram(initializeContent);
				openEditor(diagram);
				return diagram;
			} catch (ExecutionException e) {
				EcoreDiagramEditorPlugin.getInstance().logError(Messages.OpenDiagramEditPolicy_CanNotOpen);
			}
			return null;
		}

		/**
		 * @param diagram
		 */
		protected void deletePressed(Diagram diagram) {
			if (diagram != null) {
				// Close associated diagram
				IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
				IEditorPart editor = page.findEditor(getEditorInput(diagram));
				if (editor != null) {
					page.closeEditor(editor, true);
				}
				assert diagramResource != null;
				diagramResource.getContents().remove(diagram);
				// multiDiagramFacet.getDiagramLinks().remove(diagram);
			}
		}

		/**
		 * @param initializeContent
		 * @return Diagram
		 * @throws ExecutionException
		 * @generated
		 */
		protected Diagram intializeNewDiagram(boolean initializeContent) throws ExecutionException {
			Diagram diagram = ViewService.createDiagram(getDiagramDomainElement(), getDiagramKind(), getPreferencesHint());
			if (diagram == null) {
				throw new ExecutionException(NLS.bind(Messages.OpenDiagramEditPolicy_CanNotCreateDiagram, getDiagramKind()));
			}
			setDefaultNameForDiagram(diagram);

			// multiDiagramFacet.getDiagramLinks().add(diagram);
			assert diagramResource != null;
			diagramResource.getContents().add(diagram);

			if (initializeContent) {
				// Initialize diagram content
				EcoreDiagramContentInitializer initializer = new EcoreDiagramContentInitializer();
				initializer.setInitEPackageContent(false);
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
			}
			return diagram;
		}

		/**
		 * @generated
		 */
		protected EObject getDiagramDomainElement() {
			return domainElement;
		}

		/**
		 * @generated
		 */
		protected PreferencesHint getPreferencesHint() {
			// XXX prefhint from target diagram's editor?
			return EcoreDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT;
		}

		/**
		 * @generated
		 */
		protected String getDiagramKind() {
			return EPackageEditPart.MODEL_ID;
		}

		/**
		 * @generated
		 */
		protected String getEditorID() {
			return EcoreDiagramEditor.ID;
		}

		private void setDefaultNameForDiagram(Diagram elementToConfigure) {
			EPackage pseudoContainer = (EPackage) elementToConfigure.getElement();
			String baseString = pseudoContainer.getName() + "_Diagram"; //$NON-NLS-1$
			int count = 0;
			for (Diagram diagram : allDiagrams) {
				if (diagram.getName().equals(baseString + count)) {
					count++;
				}
			}
			elementToConfigure.setName(baseString + count);
		}
	}
}
