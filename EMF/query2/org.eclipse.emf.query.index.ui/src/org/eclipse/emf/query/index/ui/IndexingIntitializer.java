package org.eclipse.emf.query.index.ui;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.ui.IStartup;
/**
 * Starts the indexing of the projects with indexing nature on IDE startup
 */

public class IndexingIntitializer implements IStartup {

	@Override
	public void earlyStartup() {
		IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
		for (int i = 0; i < projects.length; i++) {
			try {
				String[] natureIds=projects[i].getDescription().getNatureIds();
				for (int j = 0; j < natureIds.length; j++) {
					if("org.eclipse.emf.query.index.ui.queryIndexNature".equals(natureIds[j])){
						projects[i].build(IncrementalProjectBuilder.FULL_BUILD, new NullProgressMonitor());
					}
				}
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
		
	}

}
