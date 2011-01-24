/**
 * <copyright>
 *
 * Copyright (c) 2010,2011 E.D.Willink and others.
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
 * $Id: OCLinEcoreStandaloneSetup.java,v 1.3 2011/01/24 22:28:40 ewillink Exp $
 */

package org.eclipse.ocl.examples.xtext.oclinecore;

import org.eclipse.ocl.examples.xtext.oclinecore.cs2pivot.OCLinEcoreCS2Pivot;
import org.eclipse.ocl.examples.xtext.oclinecore.utilities.OCLinEcoreCS2MonikerVisitor;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class OCLinEcoreStandaloneSetup extends OCLinEcoreStandaloneSetupGenerated
{
	public static void doSetup() {
		init();
		new OCLinEcoreStandaloneSetup().createInjectorAndDoEMFRegistration();
	}

	public static void init() {
		OCLinEcoreCS2MonikerVisitor.FACTORY.getClass();
		OCLinEcoreCS2Pivot.FACTORY.getClass();
	}
}

