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
 * $Id: NewEcoreProjectWizard.java,v 1.4 2008/05/19 09:26:31 jlescot Exp $
 **********************************************************************/
package org.eclipse.emf.ecoretools.ui.wizards;

import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceStatus;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.emf.ecoretools.core.nature.EcoreNature;
import org.eclipse.emf.ecoretools.internal.Activator;
import org.eclipse.emf.ecoretools.internal.Messages;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.osgi.util.NLS;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;
import org.eclipse.ui.part.ISetSelectionTarget;
import org.eclipse.ui.plugin.AbstractUIPlugin;

/**
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class NewEcoreProjectWizard extends Wizard implements INewWizard {

	private WizardNewProjectCreationPage mainPage;

	// The workbench
	private IWorkbench currentWorkbench;

	// cache of newly-created project
	private IProject newProject;

	/**
	 * The <code>BasicNewResourceWizard</code> implementation of this
	 * <code>IWorkbenchWizard</code> method records the given workbench and
	 * selection, and initializes the default banner image for the pages by
	 * calling <code>initializeDefaultPageImageDescriptor</code>. Subclasses
	 * may extend.
	 * 
	 * @see org.eclipse.ui.IWorkbenchWizard#init(org.eclipse.ui.IWorkbench,
	 *      org.eclipse.jface.viewers.IStructuredSelection)
	 */
	public void init(IWorkbench workbench, IStructuredSelection currentSelection) {
		this.currentWorkbench = workbench;
	}

	/**
	 * @see org.eclipse.jface.wizard.Wizard#addPages()
	 */
	@Override
	public void addPages() {
		super.addPages();

		mainPage = new WizardNewProjectCreationPage(Messages.NewEcoreProjectWizard_NewEcoreProject);
		mainPage.setImageDescriptor(AbstractUIPlugin.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "icons/wizban/newprj_wiz.png")); //$NON-NLS-1$
		mainPage.setTitle(Messages.NewEcoreProjectWizard_EcoreProject_title);
		mainPage.setDescription(Messages.NewEcoreProjectWizard_EcoreProject_description);
		this.addPage(mainPage);
	}

	/**
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	@Override
	public boolean performFinish() {
		createNewProject();

		if (newProject == null) {
			return false;
		}

		selectAndReveal(newProject);

		return true;
	}

	/**
	 * Creates a new project resource with the selected name.
	 * <p>
	 * In normal usage, this method is invoked after the user has pressed Finish
	 * on the wizard; the enablement of the Finish button implies that all
	 * controls on the pages currently contain valid values.
	 * </p>
	 * <p>
	 * Note that this wizard caches the new project once it has been
	 * successfully created; subsequent invocations of this method will answer
	 * the same project resource without attempting to create it again.
	 * </p>
	 * 
	 * @return the created project resource, or <code>null</code> if the
	 *         project was not created
	 */
	private IProject createNewProject() {
		if (newProject != null) {
			return newProject;
		}

		// get a project handle
		final IProject newProjectHandle = mainPage.getProjectHandle();

		// get a project descriptor
		URI location = null;
		if (!mainPage.useDefaults()) {
			location = mainPage.getLocationURI();
		}

		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		final IProjectDescription description = workspace.newProjectDescription(newProjectHandle.getName());
		description.setLocationURI(location);
		// Add the Ecore Nature to the project
		description.setNatureIds(new String[] { EcoreNature.ECORE_NATURE_ID });

		// create the new project operation
		WorkspaceModifyOperation op = new WorkspaceModifyOperation() {

			@Override
			protected void execute(IProgressMonitor monitor) throws CoreException {
				createProject(description, newProjectHandle, monitor);
			}
		};

		// run the new project creation operation
		try {
			getContainer().run(true, true, op);
		} catch (InterruptedException e) {
			return null;
		} catch (InvocationTargetException e) {
			// ie.- one of the steps resulted in a core exception
			Throwable t = e.getTargetException();
			if (t instanceof CoreException) {
				if (((CoreException) t).getStatus().getCode() == IResourceStatus.CASE_VARIANT_EXISTS) {
					MessageDialog.openError(getShell(), Messages.NewEcoreProjectWizard_CreationProblems, NLS.bind(
							Messages.NewEcoreProjectWizard_CaseSensitive_warning,
							newProjectHandle.getName()));
				} else {
					ErrorDialog.openError(getShell(), Messages.NewEcoreProjectWizard_CreationProblems, null, ((CoreException) t).getStatus());
				}
			} else {
				// CoreExceptions are handled above, but unexpected runtime
				// exceptions and errors may still occur.
				Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, 0, t.toString(), t));
				MessageDialog.openError(getShell(), Messages.NewEcoreProjectWizard_CreationProblems, NLS.bind(Messages.NewEcoreProjectWizard_InternalError, t.getMessage()));
			}
			return null;
		}

		newProject = newProjectHandle;

		return newProject;
	}

	/**
	 * Creates a project resource given the project handle and description.
	 * 
	 * @param description
	 *            the project description to create a project resource for
	 * @param projectHandle
	 *            the project handle to create a project resource for
	 * @param monitor
	 *            the progress monitor to show visual progress with
	 * 
	 * @exception CoreException
	 *                if the operation fails
	 * @exception OperationCanceledException
	 *                if the operation is canceled
	 */
	void createProject(IProjectDescription description, IProject projectHandle, IProgressMonitor monitor) throws CoreException, OperationCanceledException {
		try {
			monitor.beginTask("", 2000);//$NON-NLS-1$

			projectHandle.create(description, new SubProgressMonitor(monitor, 1000));

			if (monitor.isCanceled()) {
				throw new OperationCanceledException();
			}

			projectHandle.open(IResource.BACKGROUND_REFRESH, new SubProgressMonitor(monitor, 1000));

		} finally {
			monitor.done();
		}
	}

	/**
	 * Selects and reveals the newly added resource in all parts of the active
	 * workbench window's active page.
	 * 
	 * @param newResource
	 *            the Resource to select and show
	 * @see ISetSelectionTarget
	 */
	protected void selectAndReveal(IResource newResource) {
		selectAndReveal(newResource, currentWorkbench.getActiveWorkbenchWindow());
	}

	/**
	 * Attempts to select and reveal the specified resource in all parts within
	 * the supplied workbench window's active page.
	 * <p>
	 * Checks all parts in the active page to see if they implement
	 * <code>ISetSelectionTarget</code>, either directly or as an adapter. If
	 * so, tells the part to select and reveal the specified resource.
	 * </p>
	 * 
	 * @param resource
	 *            the resource to be selected and revealed
	 * @param window
	 *            the workbench window to select and reveal the resource
	 * 
	 * @see ISetSelectionTarget
	 */
	public static void selectAndReveal(IResource resource, IWorkbenchWindow window) {
		// validate the input
		if (window == null || resource == null) {
			return;
		}
		IWorkbenchPage page = window.getActivePage();
		if (page == null) {
			return;
		}

		// get all the view and editor parts
		List<IWorkbenchPart> parts = new ArrayList<IWorkbenchPart>();
		IWorkbenchPartReference refs[] = page.getViewReferences();
		for (int i = 0; i < refs.length; i++) {
			IWorkbenchPart part = refs[i].getPart(false);
			if (part != null) {
				parts.add(part);
			}
		}
		refs = page.getEditorReferences();
		for (int i = 0; i < refs.length; i++) {
			if (refs[i].getPart(false) != null) {
				parts.add(refs[i].getPart(false));
			}
		}

		final ISelection selection = new StructuredSelection(resource);
		Iterator<IWorkbenchPart> itr = parts.iterator();
		while (itr.hasNext()) {
			IWorkbenchPart part = itr.next();

			// get the part's ISetSelectionTarget implementation
			ISetSelectionTarget target = null;
			if (part instanceof ISetSelectionTarget) {
				target = (ISetSelectionTarget) part;
			} else {
				target = (ISetSelectionTarget) part.getAdapter(ISetSelectionTarget.class);
			}

			if (target != null) {
				// select and reveal resource
				final ISetSelectionTarget finalTarget = target;
				window.getShell().getDisplay().asyncExec(new Runnable() {

					public void run() {
						finalTarget.selectReveal(selection);
					}
				});
			}
		}
	}

}
