/***********************************************************************
 * Copyright (c) 2009 Anyware Technologies
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Jacques Lescot (Anyware Technologies) - initial API and implementation
 *
 * $Id: UpDiagramAction.java,v 1.4 2009/05/06 13:36:41 jlescot Exp $
 **********************************************************************/
package org.eclipse.emf.ecoretools.diagram.edit.actions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecoretools.diagram.Messages;
import org.eclipse.emf.ecoretools.diagram.part.EcoreDiagramEditor;
import org.eclipse.emf.ecoretools.diagram.part.EcoreDiagramEditorPlugin;
import org.eclipse.emf.ecoretools.diagram.part.INavigationListener;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.gef.ui.actions.WorkbenchPartAction;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;

/**
 * This action enables to navigate easily to the parent diagram of the current
 * diagram. <br>
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class UpDiagramAction extends WorkbenchPartAction implements INavigationListener {

	/**
	 * The Constructor
	 * 
	 * @param part
	 *            the IWorkbenchPart
	 */
	public UpDiagramAction(IWorkbenchPart part) {
		super(part);
		EcoreDiagramEditor editor = (EcoreDiagramEditor) getWorkbenchPart();
		editor.getNavigationManager().addNavigationListener(this);
	}

	/**
	 * @see org.eclipse.gef.ui.actions.WorkbenchPartAction#dispose()
	 */
	public void dispose() {
		EcoreDiagramEditor editor = (EcoreDiagramEditor) getWorkbenchPart();
		editor.getNavigationManager().removeNavigationListener(this);
		super.dispose();
	}

	/**
	 * @see org.eclipse.emf.ecoretools.diagram.part.INavigationListener#diagramChanged(Diagram)
	 */
	public void diagramChanged(Diagram newDiagram) {
		refresh();
	}

	/**
	 * Check whether at least one diagram is considered as a parent one
	 * 
	 * @return <code>true</code> whether a parent diagram exists
	 */
	protected boolean calculateEnabled() {
		return !getParentDiagrams().isEmpty();
	}

	/**
	 * Initializes the action
	 * 
	 * @see org.eclipse.gef.ui.actions.WorkbenchPartAction#init()
	 */
	protected void init() {
		setId(EcoreActionConstants.OPEN_PARENT_DIAGRAM);
		setText(Messages.UpDiagramAction_OpenParentAction);
	}

	/**
	 * @see org.eclipse.jface.action.IAction#run()
	 */
	public void run() {
		EcoreDiagramEditor editor = (EcoreDiagramEditor) getWorkbenchPart();
		List<Diagram> possibleDiagrams = getParentDiagrams();
		if (!possibleDiagrams.isEmpty()) {
			Diagram selectedDiagram = (Diagram) chooseDiagram(possibleDiagrams.toArray(new Diagram[possibleDiagrams.size()]));
			if (selectedDiagram != null) {
				editor.setDiagram(selectedDiagram);
			}
		}

	}

	private List<Diagram> getParentDiagrams() {
		EcoreDiagramEditor editor = (EcoreDiagramEditor) getWorkbenchPart();
		List<Diagram> parentDiagrams = new ArrayList<Diagram>();
		// Get the current diagram
		Diagram activeDiagram = editor.getDiagram();

		if (activeDiagram != null) {
			// Get the model object (the model object associated with the
			// current diagram)
			EObject modelObject = activeDiagram.getElement();

			while (modelObject.eContainer() != null && parentDiagrams.isEmpty()) {
				EObject parentModelObject = modelObject.eContainer();

				// We search all existing diagrams
				for (EObject currentDiag : activeDiagram.eResource().getContents()) {
					if (currentDiag instanceof Diagram && parentModelObject.equals(((Diagram) currentDiag).getElement())) {
						parentDiagrams.add((Diagram) currentDiag);
					}
				}
				modelObject = parentModelObject;
			}
		}

		return parentDiagrams;
	}

	/**
	 * Returns the destination Diagram from a choices list
	 * 
	 * @param elements
	 *            the list of available Diagrams
	 * @return the selected Diagram
	 */
	private Diagram chooseDiagram(Diagram[] elements) {
		Diagram selectedDiagram = null;
		if (elements.length == 1) {
			selectedDiagram = elements[0];
		} else {
			ElementListSelectionDialog dialog = new ElementListSelectionDialog(getWorkbenchPart().getSite().getShell(), new AdapterFactoryLabelProvider(EcoreDiagramEditorPlugin.getInstance()
					.getItemProvidersAdapterFactory()));
			dialog.setMultipleSelection(false);
			dialog.setTitle(Messages.UpDiagramAction_DiagramSelection);
			dialog.setMessage(Messages.UpDiagramAction_SelectDiagram);
			dialog.setElements(elements);

			if (dialog.open() == Window.OK) {
				Object[] selection = dialog.getResult();

				if (selection != null && selection.length > 0) {
					selectedDiagram = (Diagram) selection[0];
				}
			}
		}

		return selectedDiagram;
	}
}
