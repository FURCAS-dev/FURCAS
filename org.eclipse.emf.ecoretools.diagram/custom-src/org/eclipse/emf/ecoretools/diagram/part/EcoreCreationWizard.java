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
 * $Id: EcoreCreationWizard.java,v 1.3 2008/04/28 15:23:59 jlescot Exp $
 **********************************************************************/

package org.eclipse.emf.ecoretools.diagram.part;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.WorkspaceModifyOperation;

/**
 * Wizard that offers creation facilities for the initialization of an empty
 * Ecore diagram/domain files, or initialization of an Ecore diagram from an
 * existing domain file.<br>
 * 
 * Creation : 26 Nov. 2007
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class EcoreCreationWizard extends Wizard implements INewWizard {

	private IStructuredSelection selection;

	private EcoreCreationWizardPage diagPage;

	/** The EMF Resource associated with the Diagram */
	protected Resource diagram;

	/**
	 * Get the initial selection when executing this wizard
	 * 
	 * @return IStructuredSelection
	 */
	public IStructuredSelection getSelection() {
		return selection;
	}

	/**
	 * @see org.eclipse.ui.IWorkbenchWizard#init(org.eclipse.ui.IWorkbench,
	 *      org.eclipse.jface.viewers.IStructuredSelection)
	 */
	public void init(IWorkbench workbench, IStructuredSelection theSelection) {
		this.selection = theSelection;
		setWindowTitle(Messages.EcoreCreationWizardTitle);
		setDefaultPageImageDescriptor(EcoreDiagramEditorPlugin.getBundledImageDescriptor("icons/wizban/NewEcoreWizard.gif")); //$NON-NLS-1$
		setDialogSettings(EcoreDiagramEditorPlugin.getInstance().getDialogSettings());
		setNeedsProgressMonitor(true);
	}

	/**
	 * @see org.eclipse.jface.wizard.IWizard#performFinish()
	 */
	@Override
	public boolean performFinish() {
		IRunnableWithProgress op = new WorkspaceModifyOperation(null) {

			@Override
			protected void execute(IProgressMonitor monitor) throws CoreException, InterruptedException {
				if (diagPage.isNewModel()) {
					// case of creating an empty domain/diagram Resources
					diagram = EcoreDiagramEditorUtil.createDiagram(diagPage.getDiagramModelURI(), diagPage.getDomainModelURI(), monitor);
				} else {
					// case of creating only a diagram Resource (the domain file
					// already exists)
					diagram = EcoreDiagramEditorUtil.createDiagramOnly(diagPage.getDiagramModelURI(), diagPage.getDomainModelURI(), diagPage.getDiagramEObject(), diagPage.isInitialized(), monitor);
				}
				if (diagram != null) {
					try {
						// try to open the current diagram resource into the
						// appropriate editor
						EcoreDiagramEditorUtil.openDiagram(diagram);
					} catch (PartInitException e) {
						ErrorDialog.openError(getContainer().getShell(), Messages.EcoreCreationWizardOpenEditorError, null, e.getStatus());
					}
				}
			}
		};
		try {
			getContainer().run(false, true, op);
		} catch (InterruptedException e) {
			return false;
		} catch (InvocationTargetException e) {
			if (e.getTargetException() instanceof CoreException) {
				ErrorDialog.openError(getContainer().getShell(), Messages.EcoreCreationWizardCreationError, null, ((CoreException) e.getTargetException()).getStatus());
			} else {
				EcoreDiagramEditorPlugin.getInstance().logError(org.eclipse.emf.ecoretools.diagram.Messages.EcoreCreationWizard_ErrorOnCreation, e.getTargetException());
			}
			return false;
		}
		return diagram != null;
	}

	/**
	 * @see org.eclipse.jface.wizard.IWizard#addPages()
	 */
	@Override
	public void addPages() {
		// Add the single wizard page used to configure the diagram resource
		// creation
		diagPage = new EcoreCreationWizardPage("NewEcoreToolsDiagram", getSelection()); //$NON-NLS-1$
		diagPage.setTitle(Messages.EcoreCreationWizard_DiagramModelFilePageTitle);
		diagPage.setDescription(Messages.EcoreCreationWizard_DiagramModelFilePageDescription);
		addPage(diagPage);
	}

	/**
	 * @see org.eclipse.jface.wizard.Wizard#canFinish()
	 */
	@Override
	public boolean canFinish() {
		return diagPage.isPageComplete();
	}

}
