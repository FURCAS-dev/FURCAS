package org.eclipse.emf.ocl.examples.internal.wizard;

import java.util.Collection;
import java.util.Collections;


public class InterpreterExampleWizard
	extends AbstractExampleWizard {

	protected Collection getProjectDescriptors() {
		// We simply need the interpreter zip to be unzipped as a project
		//  into the workspace.
		return Collections.singletonList(new ProjectDescriptor("org.eclipse.emf.ocl.examples", "zips/interpreter.zip", "org.eclipse.emf.ocl.examples.interpreter"));  //$NON-NLS-1$//$NON-NLS-2$ //$NON-NLS-3$
	}
}
