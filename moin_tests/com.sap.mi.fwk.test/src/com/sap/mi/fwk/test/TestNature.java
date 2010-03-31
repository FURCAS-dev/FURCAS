package com.sap.mi.fwk.test;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.runtime.CoreException;

/**
 * A nature used for testing purposes
 * 
 * @author d031150
 */
public final class TestNature implements IProjectNature {
	
	public static final String NATURE_ID = "com.sap.mi.fwk.TestNature";
	public static final String BUILDER_ID = "com.sap.mi.fwk.TestFileBuilder";

	private IProject mProject;
	
	public void configure() throws CoreException {
	}
	
	public void deconfigure() throws CoreException {
	}
	
	public IProject getProject() {
		return mProject;
	}
	
	public void setProject(IProject project) {
		mProject = project;
	}

}
