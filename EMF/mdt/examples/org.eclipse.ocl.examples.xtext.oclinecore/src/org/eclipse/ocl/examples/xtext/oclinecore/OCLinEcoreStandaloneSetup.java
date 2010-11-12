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
 * $Id: OCLinEcoreStandaloneSetup.java,v 1.1 2010/05/06 17:48:42 ewillink Exp $
 */

package org.eclipse.ocl.examples.xtext.oclinecore;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class OCLinEcoreStandaloneSetup extends OCLinEcoreStandaloneSetupGenerated{

	public static void doSetup() {
		new OCLinEcoreStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

