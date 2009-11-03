package com.sap.mi.tools.mmbuilder;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.progress.IProgressService;

import com.sap.mi.fwk.internal.tracing.MiLocations;
import com.sap.mi.fwk.ui.projectselection.ProjectSelectionDialog;
import com.sap.mi.tools.mmbuilder.internal.MMBuilderConstants;
import com.sap.mi.tools.mmbuilder.internal.MMBuilderHelper;
import com.sap.mi.tools.mmbuilder.internal.MMBuilderMessages;
import com.sap.mi.tools.mmbuilder.internal.MetamodelBuildNature;
import com.tssap.util.trace.TracerI;
import com.tssap.util.trace.TracingManager;

/**
 * @no-implement For internal use only, not intended to be use by external clients.
 */
public final class AddNatureHandler extends AbstractHandler {

	private static final TracerI sTracer = TracingManager.getTracer(MiLocations.MI_METAMODELBUILDER);

	public Object execute(final ExecutionEvent arg0) throws ExecutionException {

		final IStructuredSelection selection = (IStructuredSelection) HandlerUtil.getCurrentSelection(arg0);
		final Object[] objs = selection.toArray();

		for (final Object object : objs) {

			// MMBuilderHelper.checkCancellation(monitor);

			final IProject project = MMBuilderHelper.getProject(object);
			if (project != null && project.isAccessible()) {
				try {
					IProject metaModelProject = null;
					if (!MetamodelBuildNature.hasMetamodelBuilderNature(project) && !MetamodelBuildNature.isJaproProject(project)) {

						// Ask user for folder to link for XMIs
						// since this code invokes a non swt dialog
						// an automated ui test could not be provided
						final ProjectSelectionDialog psDlg = new ProjectSelectionDialog(Display.getDefault().getActiveShell());
						psDlg.setTitle(MMBuilderMessages.AddNatureHandler_SelectMetamodel);

						String msg = MMBuilderMessages.bind(MMBuilderMessages.AddNatureHandler_SelMetamodelText, project.getName());
						psDlg.setMessage(msg);

						psDlg.setEmptyListMessage(MMBuilderMessages.AddNatureHandler_no_dc);
						psDlg.setEmptySelectionMessage(MMBuilderMessages.AddNatureHandler_no_selection);

						IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
						List<IProject> moinProjects = new ArrayList<IProject>();
						for (IProject currentProject : projects) {
							if (currentProject.isAccessible() && currentProject.isNatureEnabled(MMBuilderConstants.META_MODEL_NATURE_ID)) {
								moinProjects.add(currentProject);
							}
						}
						psDlg.setElements(moinProjects.toArray(new IProject[moinProjects.size()]));

						metaModelProject = psDlg.openDialog();
						if (metaModelProject == null) {
							return null;
						}
					}

					final IProject finalMMProject = metaModelProject;
					IRunnableWithProgress operation = new IRunnableWithProgress() {
						public void run(IProgressMonitor monitor) throws InterruptedException, InvocationTargetException {
							try {
								addNature(project, finalMMProject, monitor);
							} catch (OperationCanceledException e) {
								throw new InterruptedException();
							} catch (CoreException e) {
								throw new InvocationTargetException(e);
							}
						}
					};

					try {
						IProgressService ps = PlatformUI.getWorkbench().getProgressService();
						ps.busyCursorWhile(operation);
					} catch (InterruptedException e) {
						// $JL-EXC$
						// do nothing if user or eclipse cancels
						sTracer.debug("Operation canceled by user"); //$NON-NLS-1$
					} catch (Exception e) {
						sTracer.error("Exception during nature removal", e); //$NON-NLS-1$
						final Shell shell = HandlerUtil.getActiveShellChecked(arg0);
						final String msg = MMBuilderMessages.bind(MMBuilderMessages.AddNatureHandler_errorMsg, project.getName());
						MessageDialog.openError(shell, MMBuilderMessages.AddNatureHandler_errorTitle, msg);
					}

				} catch (final Exception e) {
					AddNatureHandler.sTracer.error("Error adding the nature", e); //$NON-NLS-1$
					final Shell shell = HandlerUtil.getActiveShellChecked(arg0);
					final String msg = NLS.bind(MMBuilderMessages.AddNatureHandler_errorMsg, project.getName());
					MessageDialog.openError(shell, MMBuilderMessages.AddNatureHandler_errorTitle, msg);
				}
			}
		}
		return null;
	}

	/**
	 * Toggles sample nature on a project
	 * 
	 * @param wrapperProject
	 *            to have sample nature added or removed
	 * @throws CoreException
	 * @throws CoreException
	 */
	public void addNature(final IProject wrapperProject, final IProject metamodelProject, IProgressMonitor monitor) throws CoreException,
			OperationCanceledException {

		if (monitor == null) {
			monitor = new NullProgressMonitor();
		}

		if (metamodelProject != null) {
			final String moinFolderPathName = metamodelProject.getLocation().append(MMBuilderConstants.MOIN_FOLDER).toString();
			final IPath moinFolderPath = new Path(moinFolderPathName);

			// Create XMI folder and link it
			final IFolder xmiFolder = wrapperProject.getFolder(MMBuilderConstants.XMI_SRC_PATH);
			if (!xmiFolder.exists()) {
				xmiFolder.create(true, true, monitor);
			}

			final IFolder linkFolder = xmiFolder.getFolder(MMBuilderConstants.MOIN_FOLDER);
			if (!linkFolder.exists()) {
				linkFolder.createLink(moinFolderPath, IResource.ALLOW_MISSING_LOCAL | IResource.REPLACE, monitor);
			}

			final String javaFolderPathName = metamodelProject.getLocation().append(MMBuilderConstants.JAVA_SRC_FOLDER).toString();
			final IPath javaFolderPath = new Path(javaFolderPathName);
			
			final IFolder javaFolder = xmiFolder.getFolder(MMBuilderConstants.JAVA_SRC_FOLDER);
			if (!javaFolder.exists()) {
				javaFolder.createLink(javaFolderPath, IResource.ALLOW_MISSING_LOCAL | IResource.REPLACE, monitor);
			}

			wrapperProject.refreshLocal(IResource.DEPTH_ONE, monitor);
		}

		final IProjectDescription description = wrapperProject.getDescription();
		final String[] natures = description.getNatureIds();

		final Set<String> naturesSet = new HashSet<String>(natures.length);
		naturesSet.addAll(Arrays.asList(natures));
		naturesSet.add(MMBuilderConstants.NATURE_ID);

		description.setNatureIds(naturesSet.toArray(new String[naturesSet.size()]));

		wrapperProject.setDescription(description, monitor);
	}
}
