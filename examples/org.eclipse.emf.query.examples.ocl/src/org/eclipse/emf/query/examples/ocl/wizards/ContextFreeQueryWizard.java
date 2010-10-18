/**
 * <copyright>
 *
 * Copyright (c) 2005, 2007 IBM Corporation and others.
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

/**
 * A wizard the prompts the user for a context-free OCL constraint condition
 * expression.
 */
public class ContextFreeQueryWizard
	extends AbstractQueryWizard {

	/**
	 * Initializes me.
	 */
	public ContextFreeQueryWizard() {
		super();
	}

	@Override
	protected IOCLQueryWizardPage createOclQueryPage() {
		return new ContextFreeQueryWizardPage();
	}
}
