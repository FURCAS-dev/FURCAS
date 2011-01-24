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
 * $Id: EssentialOCLStandaloneSetup.java,v 1.2 2011/01/24 21:31:47 ewillink Exp $
 */

package org.eclipse.ocl.examples.xtext.essentialocl;

import org.eclipse.ocl.examples.xtext.essentialocl.cs2pivot.EssentialOCLCS2Pivot;
import org.eclipse.ocl.examples.xtext.essentialocl.utilities.EssentialOCLCS2MonikerVisitor;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class EssentialOCLStandaloneSetup extends EssentialOCLStandaloneSetupGenerated
{
	public static void doSetup() {
		init();
		new EssentialOCLStandaloneSetup().createInjectorAndDoEMFRegistration();
	}

	public static void init() {
		EssentialOCLCS2MonikerVisitor.FACTORY.getClass();
		EssentialOCLCS2Pivot.FACTORY.getClass();
	}
}

