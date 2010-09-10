package com.sap.mi.textual.epi.builder;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

public class BuildHelper {
	public static boolean isModelProject(IProject project) {
		return true;
	}
	
	public static ResourceSet getResourceSetForProject(IProject project) {
		return new ResourceSetImpl();
	}
}
