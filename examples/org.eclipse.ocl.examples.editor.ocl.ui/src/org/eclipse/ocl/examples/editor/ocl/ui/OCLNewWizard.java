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
 * $Id: OCLNewWizard.java,v 1.1 2010/03/11 14:52:52 ewillink Exp $
 */
package org.eclipse.ocl.examples.editor.ocl.ui;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ocl.examples.editor.ui.wizards.PagedNewWizard;

/**
 * This is a sample new wizard. Its role is to create a new file 
 * resource in the provided container. If the container resource
 * (a folder or a project) is selected in the workspace 
 * when the wizard is opened, it will accept it as the target
 * container. The wizard creates one file with the extension
 * defined by derivation. If a sample multi-page editor (also available
 * as a template) is registered for the same extension, it will
 * be able to open it.
 */

public class OCLNewWizard extends PagedNewWizard
{
	@Override protected OCLNewWizardPage createNewWizardPage(ISelection selection) {
		return new OCLNewWizardPage(selection);
	}
	
	/**
	 * We will initialize file contents with a sample text.
	 */
	@Override protected InputStream openContentStream() {
		String contents =
			"--\n" +
			"-- Elimination of the errors requires a package path to be defined.\n" +
			"--\n" +
			"-- First check that your project has the Model Registry Nature by using the\n" +
			"-- right button menu of your project in Package Explorer or Navigator Views.\n" +
			"-- If, under QVT Declarative Natures, this offers an Add Model Registry Nature option,\n" +
			"-- select it; if it offers Remove Model Registry Nature, leave the selection unchanged.\n" +
			"--\n" +
			"-- Select the Properties of this model by typing Alt + Enter\n" +
			"--  (or select Properties from the right button menu in Package Explorer or Navigator Views.)\n" +
			"-- Then select Model Registry\n" +
			"-- Then use New...\n" +
			"--  to specify e.g. Ecore as the Accessor Name\n" +
			"--  and Browse Registered Packages... to select http://www.eclipse.org/emf/2002/Ecore\n" +
			"--   and consequently platform:/plugin/org.eclipse.emf.ecore/model/Ecore.ecore as the Model URI\n" +
			"-- Then OK and OK again\n" +
			"-- \n" +
			"context ecore::EClass\n" +
			"inv: 1 = 1\n";
		return new ByteArrayInputStream(contents.getBytes());
	}
}