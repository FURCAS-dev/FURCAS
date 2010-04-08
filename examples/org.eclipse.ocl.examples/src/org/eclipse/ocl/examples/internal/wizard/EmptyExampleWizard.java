/**
 * <copyright>
 * 
 * Copyright (c) 2009,2010 E.D.Willink and others.
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
 * $Id: EmptyExampleWizard.java,v 1.2 2010/04/08 06:24:43 ewillink Exp $
 */
package org.eclipse.ocl.examples.internal.wizard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class EmptyExampleWizard extends AbstractExampleWizard
{	
	@Override
	protected Collection<ProjectDescriptor> getProjectDescriptors() {
		List<ProjectDescriptor> projects = new ArrayList<ProjectDescriptor>(4);
		projects.add(new ProjectDescriptor("org.eclipse.ocl.examples", "zips/empty.zip", "EmptyOCLProject"));  //$NON-NLS-1$//$NON-NLS-2$ //$NON-NLS-3$		
		return projects;
	}
}
