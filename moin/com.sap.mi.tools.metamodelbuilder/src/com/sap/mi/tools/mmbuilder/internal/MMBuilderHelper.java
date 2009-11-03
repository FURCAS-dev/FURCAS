package com.sap.mi.tools.mmbuilder.internal;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;

public class MMBuilderHelper {

	public static final IProject getProject(Object obj) {
		if (obj instanceof IProject) {
			return (IProject) obj;
		}
		if (obj instanceof IAdaptable) {
			return (IProject) ((IAdaptable) obj).getAdapter(IProject.class);
		}
		return null;
	}
	
	public static final void checkCancellation(IProgressMonitor monitor) {
		if(monitor.isCanceled()) {
			throw new OperationCanceledException();
		}
	}

}
