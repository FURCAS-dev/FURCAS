/**
 * <copyright>
 *
 * Copyright (c) 2005, 2008 IBM Corporation, Zeligsoft Inc., and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Zeligsoft - Bug 256040
 * 
 * $Id: OCLEcorePlugin.java,v 1.6 2010/04/08 06:27:21 ewillink Exp $
 * 
 *
 * </copyright>
 *
 * $Id: OCLEcorePlugin.java,v 1.6 2010/04/08 06:27:21 ewillink Exp $
 */
package org.eclipse.ocl.ecore.internal;

import org.eclipse.ocl.ecore.parser.OCLAnalyzer;
import org.eclipse.ocl.ecore.parser.ValidationVisitor;
import org.eclipse.ocl.helper.OCLSyntaxHelper;
import org.eclipse.ocl.parser.AbstractOCLAnalyzer;

import com.google.inject.AbstractModule;

/**
 * The OCLEcoreModule defines the Ecore-specific overrides of generic OCL classes.
 */
public class OCLEcoreModule extends AbstractModule
{
	@Override
	protected void configure() {
		bind(AbstractOCLAnalyzer.IProvider.class).to(OCLAnalyzer.Provider.class);
		bind(OCLSyntaxHelper.IProvider.class).to(org.eclipse.ocl.ecore.internal.helper.OCLSyntaxHelper.Provider.class);
		bind(ValidationVisitor.IProvider.class).to(ValidationVisitor.Provider.class);
	}
}
