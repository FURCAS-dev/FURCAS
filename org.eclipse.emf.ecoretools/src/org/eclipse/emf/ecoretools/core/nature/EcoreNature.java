/***********************************************************************
 * Copyright (c) 2007 Anyware Technologies
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Anyware Technologies - initial API and implementation
 *
 * $Id: EcoreNature.java,v 1.4 2008/04/28 15:49:07 jlescot Exp $
 **********************************************************************/
package org.eclipse.emf.ecoretools.core.nature;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecoretools.internal.Activator;

/**
 * Provide a default nature for Ecore related projects
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class EcoreNature implements IProjectNature {

	/** The Ecore Nature ID */
	public static final String ECORE_NATURE_ID = Activator.PLUGIN_ID + ".ecorenature"; //$NON-NLS-1$

	private IProject project;

	/**
	 * @see org.eclipse.core.resources.IProjectNature#configure()
	 */
	public void configure() throws CoreException {
		// Add nature-specific information
		// for the project, such as adding a builder
		// to a project's build spec.
	}

	/**
	 * @see org.eclipse.core.resources.IProjectNature#deconfigure()
	 */
	public void deconfigure() throws CoreException {
		// Remove the nature-specific information here.
	}

	/**
	 * @see org.eclipse.core.resources.IProjectNature#getProject()
	 */
	public IProject getProject() {
		return project;
	}

	/**
	 * @see org.eclipse.core.resources.IProjectNature#setProject(org.eclipse.core.resources.IProject)
	 */
	public void setProject(IProject value) {
		project = value;
	}

}
