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
 * $Id: EssentialOCLStandaloneSetup.java,v 1.1 2010/05/06 17:41:36 ewillink Exp $
 */

package org.eclipse.ocl.examples.xtext.essentialocl;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class EssentialOCLStandaloneSetup extends EssentialOCLStandaloneSetupGenerated{

	public static void doSetup() {
		new EssentialOCLStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

