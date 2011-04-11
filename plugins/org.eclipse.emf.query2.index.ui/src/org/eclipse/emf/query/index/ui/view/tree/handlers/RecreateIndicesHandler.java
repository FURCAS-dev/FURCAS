package org.eclipse.emf.query.index.ui.view.tree.handlers;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.query.index.internal.ui.builder.QueryIndexBuilder;
import org.eclipse.emf.query.index.ui.Messages;
import org.eclipse.emf.query.index.ui.images.IndexUIImageRegistry;
import org.eclipse.emf.query.index.ui.view.IndexView;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.progress.IProgressConstants;

/**
 * @author Animesh Kumar, SAP Labs India Pvt. Ltd.
 * 
 */
public class RecreateIndicesHandler implements IHandler {

	public void addHandlerListener(IHandlerListener handlerListener) {
	}

	public void dispose() {
	}

	public Object execute(ExecutionEvent event) throws ExecutionException {
		Job job = new Job(Messages.Query2IndexUI_RecreateIndicesHandler_BuildingIndices) {
			protected IStatus run(IProgressMonitor monitor) {
				setProperty(IProgressConstants.ICON_PROPERTY, IndexUIImageRegistry.getImage(IndexUIImageRegistry.TYPES_ICON));
				reBuildIndexes(monitor);
				final TreeViewer treeViewer = IndexView.getTreeViewer();
				Display display = treeViewer.getControl().getDisplay();
				if (!display.isDisposed()) {
					display.asyncExec(new Runnable() {
						public void run() {
							if (treeViewer.getControl().isDisposed()) {
								return;
							}
							treeViewer.refresh();
						}
					});
				}
				monitor.done();
				return Status.OK_STATUS;
			}
		};
		job.setUser(true);
		job.schedule();
		return null;
	}

	public boolean isEnabled() {
		return true;
	}

	public boolean isHandled() {
		return true;
	}

	public void removeHandlerListener(IHandlerListener handlerListener) {
	}

	private void reBuildIndexes(IProgressMonitor monitor) {
		IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
		monitor.beginTask(Messages.Query2IndexUI_RecreateIndicesHandler_BuildingIndices, projects.length);
		for (int i = 0; i < projects.length; i++) {
			try {
				IProject iProject = projects[i];
				if (iProject.isOpen()) {
					// String[] natureIds =
					// iProject.getDescription().getNatureIds();
					// for (int j = 0; j < natureIds.length; j++) {
					// if (QueryIndexNature.NATURE_ID.equals(natureIds[j])) {
					iProject.refreshLocal(IResource.DEPTH_INFINITE, null);
					iProject.build(QueryIndexBuilder.FULL_BUILD, monitor);
					monitor.worked(i);
					// }
					// }
				}
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
		monitor.done();
	}

}
