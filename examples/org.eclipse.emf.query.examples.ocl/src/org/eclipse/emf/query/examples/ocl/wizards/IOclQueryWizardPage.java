/**
 * <copyright>
 *
 * Copyright (c) 2005 IBM Corporation and others.
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
 * $Id$
 */

package org.eclipse.emf.query.examples.ocl.wizards;

import org.eclipse.jface.wizard.IWizardPage;

import org.eclipse.emf.query.ocl.conditions.OclConstraintCondition;


/**
 * Interface for OCL query wizard pages to provide the query condition.
 */
public interface IOclQueryWizardPage
	extends IWizardPage {
	
	/**
	 * Obtains the OCL constraint condition specified by the user in this page.
	 * 
	 * @return the condition, or <code>null</code> if the page is not complete
	 *     or the user canceled the wizard
	 */
	OclConstraintCondition getCondition();
}
