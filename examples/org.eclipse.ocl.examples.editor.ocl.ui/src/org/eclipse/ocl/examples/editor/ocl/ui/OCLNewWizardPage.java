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
 * $Id: OCLNewWizardPage.java,v 1.1 2010/03/11 14:52:52 ewillink Exp $
 */
package org.eclipse.ocl.examples.editor.ocl.ui;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ocl.examples.editor.ui.wizards.PagedNewWizardPage;

/**
 * The "New" wizard page allows setting the container for the new file as well
 * as the file name. The page will only accept file name without the extension
 * OR with the extension that matches the expected one (ocl).
 */
public class OCLNewWizardPage extends PagedNewWizardPage
{
	public OCLNewWizardPage(ISelection selection) {
		super(selection, OCLCreationFactory.INSTANCE);
	}
}