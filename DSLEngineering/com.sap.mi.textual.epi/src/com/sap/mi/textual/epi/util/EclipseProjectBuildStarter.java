package com.sap.mi.textual.epi.util;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.widgets.Shell;

import com.sap.mi.textual.epi.Activator;

public class EclipseProjectBuildStarter {

	public static void buildProject(final IProject project, Shell shell) {
		try {
            ProgressMonitorDialog monitorDialog = new ProgressMonitorDialog(shell);
            monitorDialog.run(true, true, new IRunnableWithProgress() {
                public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
                    try {
                        project.build(IncrementalProjectBuilder.FULL_BUILD, monitor);
                    } catch (CoreException e) {
                        Activator.logError(e);
                    }
                }
            });
        } catch (InterruptedException e) {
           Activator.logError(e);
        } catch (InvocationTargetException e) {
            Activator.logError(e);
        }
	}
	
}
