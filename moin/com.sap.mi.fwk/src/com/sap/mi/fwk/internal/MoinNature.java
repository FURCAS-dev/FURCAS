package com.sap.mi.fwk.internal;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.runtime.CoreException;

/**
 * Implementation of the generic Moin nature that is present in all projects.
 * Its id is <code>com.sap.mi.fwk.dcfwk.MoinNature</code>.
 * 
 * @author d031150
 */
public final class MoinNature implements IProjectNature {

	private IProject mProject;

	public MoinNature() {
		super();
	}

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
