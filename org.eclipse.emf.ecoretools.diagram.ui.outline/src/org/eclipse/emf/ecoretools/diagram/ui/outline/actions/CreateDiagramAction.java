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
 * $Id: CreateDiagramAction.java,v 1.1 2008/05/26 12:26:56 jlescot Exp $
 **********************************************************************/

package org.eclipse.emf.ecoretools.diagram.ui.outline.actions;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecoretools.diagram.ui.outline.internal.Activator;
import org.eclipse.emf.ecoretools.diagram.ui.outline.internal.Messages;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.window.Window;

/**
 * Action used to create a new diagram of a given type
 * 
 * Creation : 13 feb. 2008
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class CreateDiagramAction extends Action {

	private EObject selectedElt;

	private Resource diagResource;

	private String diagType;

	private PreferencesHint prefHint;

	/**
	 * Constructor
	 * 
	 * @param selectedObject
	 *            the selected Element on which the diagram is to be associated
	 * @param diagramResource
	 *            the Resource associated with the diagram file
	 * @param diagramType
	 *            the type of diagram to create
	 * @param preferencesHint
	 *            the PreferencesHint
	 */
	public CreateDiagramAction(EObject selectedObject, Resource diagramResource, String diagramType, PreferencesHint preferencesHint) {
		this.selectedElt = selectedObject;
		this.diagResource = diagramResource;
		this.diagType = diagramType;
		this.prefHint = preferencesHint;

		setText(Messages.CreateDiagramAction_CreateNewDiagram);
		setImageDescriptor(Activator.getImageDescriptor("icons/etool16/add.gif")); //$NON-NLS-1$
	}

	/**
	 * @see org.eclipse.jface.action.Action#isEnabled()
	 */
	public boolean isEnabled() {
		return selectedElt != null && diagResource != null && diagType != null;
	}

	/**
	 * This methods creates a new Diagram to be associated with the given domain
	 * element
	 * 
	 * @see org.eclipse.jface.action.Action#run()
	 */
	public void run() {
		InputDialog dialog = new InputDialog(Activator.getDefault().getWorkbench().getDisplay().getActiveShell(), Messages.CreateDiagramAction_DialogCreateNewDiagram, Messages.CreateDiagramAction_DialogDiagramName, Messages.CreateDiagramAction_DialogDefaultDiagramName, null);
		if (dialog.open() == Window.OK) {
			String name = dialog.getValue();
			if (name != null && !name.equals("")) { //$NON-NLS-1$
				Diagram d = ViewService.createDiagram(selectedElt, diagType, prefHint);
				d.setName(name);
				// TODO if we want to initialize diagram contents, the action
				// should be moved into the appropriate editor plugin. No
				// generic method here
				// new EcoreDiagramContentInitializer().initDiagramContent(d);

				TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(diagResource);
				editingDomain.getCommandStack().execute(new AddCommand(editingDomain, diagResource.getContents(), d));
			}
		}
	}

}