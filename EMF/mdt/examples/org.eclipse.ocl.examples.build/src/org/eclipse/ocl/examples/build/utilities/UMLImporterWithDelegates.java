package org.eclipse.ocl.examples.build.utilities;

import org.eclipse.emf.common.util.Monitor;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.uml2.uml.ecore.importer.UMLImporter;

public class UMLImporterWithDelegates extends UMLImporter {

	@Override
	public void adjustEPackage(Monitor monitor, EPackage ePackage) {
		super.adjustEPackage(monitor, ePackage);
	}

}
