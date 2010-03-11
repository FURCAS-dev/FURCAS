/**
 * <copyright>
 *
 * Copyright (c) 2006 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: InterpreterExampleWizard.java,v 1.1 2010/03/11 10:16:54 ewillink Exp $
 */

package org.eclipse.ocl.examples.internal.wizard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class InterpreterExampleWizard
	extends AbstractExampleWizard {
	
	protected Collection getProjectDescriptors() {
		// We need the interpreter example to be unzipped along with the
		// EMF library example model, edit and editor examples
		List projects = new ArrayList(4);
		projects.add(new ProjectDescriptor("org.eclipse.ocl.examples", "zips/library.zip", "org.eclipse.emf.examples.library"));  //$NON-NLS-1$//$NON-NLS-2$ //$NON-NLS-3$
		projects.add(new ProjectDescriptor("org.eclipse.ocl.examples", "zips/libraryEdit.zip", "org.eclipse.emf.examples.library.edit")); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		projects.add(new ProjectDescriptor("org.eclipse.ocl.examples", "zips/libraryEditor.zip", "org.eclipse.emf.examples.library.editor"));  //$NON-NLS-1$//$NON-NLS-2$ //$NON-NLS-3$
		projects.add(new ProjectDescriptor("org.eclipse.ocl.examples", "zips/interpreter.zip", "org.eclipse.ocl.examples.interpreter")); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		
		return projects;
	}
}
