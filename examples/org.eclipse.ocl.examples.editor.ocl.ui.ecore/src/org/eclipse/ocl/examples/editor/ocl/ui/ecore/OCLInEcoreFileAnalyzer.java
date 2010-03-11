/**
 * 
 */
package org.eclipse.ocl.examples.editor.ocl.ui.ecore;

import java.util.List;

import lpg.runtime.Monitor;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.examples.parser.environment.ICSTFileEnvironment;
import org.eclipse.ocl.examples.parser.ocl.OCLFileAnalyzer;
import org.eclipse.ocl.examples.parser.ocl.environment.OCLFileEnvironment;
import org.eclipse.ocl.examples.parser.ocl.environment.OCLTopLevelEnvironment;

/**
 */
public class OCLInEcoreFileAnalyzer extends OCLFileAnalyzer
{
	public OCLInEcoreFileAnalyzer(OCLFileEnvironment environment, Monitor monitor) {
		super(environment, monitor);
	}

	@Override
	protected void installConstraints(OCLTopLevelEnvironment environment, List<Constraint> constraints) {
		ICSTFileEnvironment<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> fileEnvironment = environment.getFileEnvironment();
		ResourceSet resourceSet = fileEnvironment.getResourceSet();
		OCLInEcoreSynchronizer synchronizer = OCLInEcoreSynchronizer.getAdapter(resourceSet);
		if (synchronizer != null) {		// null if a parse scheduled too promptly
			synchronizer.exportConstraintsToResource(environment, constraints);
		}
	}
}
