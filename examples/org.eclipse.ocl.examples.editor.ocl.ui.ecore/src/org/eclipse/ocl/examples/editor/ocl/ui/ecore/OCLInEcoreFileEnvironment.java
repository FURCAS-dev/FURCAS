package org.eclipse.ocl.examples.editor.ocl.ui.ecore;

import lpg.runtime.Monitor;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.ocl.examples.modelregistry.environment.FileHandle;
import org.eclipse.ocl.examples.parser.ocl.OCLFileAnalyzer;
import org.eclipse.ocl.examples.parser.ocl.environment.OCLFileEnvironment;

public class OCLInEcoreFileEnvironment extends OCLFileEnvironment
{
	public OCLInEcoreFileEnvironment(FileHandle file, ResourceSet resourceSet, XMIResource astResource) {
		super(file, resourceSet, astResource);
	}

	@Override
	public OCLFileAnalyzer createAnalyzer(Monitor monitor) {
		return new OCLInEcoreFileAnalyzer(this, monitor);
	}
}
