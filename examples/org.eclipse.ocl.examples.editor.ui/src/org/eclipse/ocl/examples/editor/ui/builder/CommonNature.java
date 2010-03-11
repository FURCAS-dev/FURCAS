/**
 * <copyright>
 * 
 * Copyright (c) 2007,2010 Eclipse Modeling Project and others.
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
 * $Id: CommonNature.java,v 1.1 2010/03/11 14:51:24 ewillink Exp $
 */
package org.eclipse.ocl.examples.editor.ui.builder;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.imp.builder.ProjectNatureBase;
import org.eclipse.imp.runtime.IPluginLog;
import org.eclipse.ocl.examples.editor.ui.ICreationFactory;

public abstract class CommonNature extends ProjectNatureBase
{	
	protected final ICreationFactory creationFactory;

	protected CommonNature(ICreationFactory creationFactory) {
		this.creationFactory = creationFactory;
	}

	@Override
	public void addToProject(IProject project) {
		super.addToProject(project);
//		new SmapiProjectNature(getLanguageName()).addToProject(project);
	};

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.resources.IProjectNature#deconfigure()
	 */
	@Override
	public void deconfigure() throws CoreException {
		try {
//			System.out.println("deleteMarkers(deconfigure) " + creationFactory.getProblemMarkerId() + " INFINITE " + getProject());
			getProject().deleteMarkers(creationFactory.getProblemMarkerId(), false, IResource.DEPTH_INFINITE);
		} catch (CoreException ce) {
		}
		super.deconfigure();
	}

	@Override
	public String getBuilderID() {
		return creationFactory.getBuilderId();
	}

	public String getLanguageID() {
		return creationFactory.getLanguageID();
	}

    @Deprecated  // Use getLanguageID()
	public String getLanguageName() {
		return getLanguageID();
	}

	@Override
	public IPluginLog getLog() {
		return creationFactory.getPlugin();
	}

	@Override
	public String getNatureID() {
		return creationFactory.getNatureId();
	}

	@Override
	protected void refreshPrefs() {
		// TODO implement preferences and hook in here
	}

	public boolean removeFromProject(IProject project) throws CoreException {
		String natureId = getNatureID();
		IProjectDescription description = project.getDescription();
		String[] natures = description.getNatureIds();
		for (int i = 0; i < natures.length; ++i) {
			if (natureId.equals(natures[i])) {
				// Remove the nature
				String[] newNatures = new String[natures.length - 1];
				System.arraycopy(natures, 0, newNatures, 0, i);
				System.arraycopy(natures, i + 1, newNatures, i,
						natures.length - i - 1);
				description.setNatureIds(newNatures);
				project.setDescription(description, null);
				return true;
			}
		}
		return false;
	}
}
