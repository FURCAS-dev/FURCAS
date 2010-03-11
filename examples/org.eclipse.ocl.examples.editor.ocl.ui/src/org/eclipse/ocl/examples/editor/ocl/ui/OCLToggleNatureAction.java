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
 * $Id: OCLToggleNatureAction.java,v 1.1 2010/03/11 14:52:52 ewillink Exp $
 */
package org.eclipse.ocl.examples.editor.ocl.ui;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.ocl.examples.editor.ui.OCLExamplesEditorPlugin;
import org.eclipse.ocl.examples.editor.ui.builder.AbstractToggleNatureAction;

public class OCLToggleNatureAction extends AbstractToggleNatureAction
{
	private static final String OCL_EXAMPLES_OCL_NATURE_ID = "org.eclipse.ocl.examples.editor.ocl.ui.OCLNature"; //$NON-NLS-1$

	public OCLToggleNatureAction() {
		super(OCLCreationFactory.INSTANCE);
	}

	@Override
	protected void toggleNature(IProject project) {
		try {
			IProjectDescription description = project.getDescription();
			String[] natures = description.getNatureIds();

			for (int i = 0; i < natures.length; ++i) {
				if (OCL_EXAMPLES_OCL_NATURE_ID.equals(natures[i])) {
					// Remove the nature
					String[] newNatures = new String[natures.length - 1];
					System.arraycopy(natures, 0, newNatures, 0, i);
					System.arraycopy(natures, i+1, newNatures, i, newNatures.length - i);
					description.setNatureIds(newNatures);
					project.setDescription(description, null);
					break;
				}
			}
		} catch (CoreException e) {
			OCLExamplesEditorPlugin.logError("Failed to remove nature '" + OCL_EXAMPLES_OCL_NATURE_ID + "'", e);
		}
		super.toggleNature(project);
	}
}