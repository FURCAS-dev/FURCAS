/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id: CompleteOCLStandaloneSetup.java,v 1.1 2010/05/06 18:00:44 ewillink Exp $
 */

package org.eclipse.ocl.examples.xtext.completeocl;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class CompleteOCLStandaloneSetup extends CompleteOCLStandaloneSetupGenerated{

	public static void doSetup() {
		new CompleteOCLStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

