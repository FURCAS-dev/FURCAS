/**
 * <copyright>
 * 
 * Copyright (c) 2011 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: OCLinEcoreTutorialWizard.java,v 1.1 2011/05/31 15:02:08 asanchez Exp $
 */
package org.eclipse.ocl.examples.internal.wizard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class OCLinEcoreTutorialWizard extends AbstractExampleWizard
{	
	@Override
	protected Collection<ProjectDescriptor> getProjectDescriptors() {
		List<ProjectDescriptor> projects = new ArrayList<ProjectDescriptor>(4);
		projects.add(new ProjectDescriptor("org.eclipse.ocl.examples", "zips/oclinecoretutorial.zip", "OCLinEcoreTutorial"));  //$NON-NLS-1$//$NON-NLS-2$ //$NON-NLS-3$		
		return projects;
	}
}
