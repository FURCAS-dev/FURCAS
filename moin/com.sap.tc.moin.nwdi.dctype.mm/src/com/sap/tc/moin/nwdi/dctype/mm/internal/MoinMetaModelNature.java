package com.sap.tc.moin.nwdi.dctype.mm.internal;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.runtime.CoreException;

public final class MoinMetaModelNature implements IProjectNature {

	private IProject mProject;


	public MoinMetaModelNature() {

		super( );
	}


	public void configure( ) throws CoreException {

	}


	public void deconfigure( ) throws CoreException {

	}


	public IProject getProject( ) {

		return mProject;
	}


	public void setProject( IProject project ) {

		mProject = project;
	}

}
