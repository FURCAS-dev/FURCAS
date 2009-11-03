package com.sap.tc.moin.versioning.di.impl;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.ui.PlatformUI;


public class Utils {

	/**
	 * Provides the readable project name if project is a DC project
	 * @param project
	 * @return
	 */
	private static String getDecoratedProjectName(IProject project) {
		
		String decoratedProjectName = PlatformUI.getWorkbench().getDecoratorManager().getLabelDecorator().decorateText(project.getName(), project);
		return decoratedProjectName;
	}

	public static String getFilePath(IFile file) {
		
		IProject project = file.getProject();
		IPath projectPath = new Path(getDecoratedProjectName(project));
	    IPath filePath = file.getFullPath().removeFirstSegments(1);
	    String pathString = projectPath.append(filePath).toOSString();
	    return pathString;
	}

}
