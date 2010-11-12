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
 * $Id: EssentialOCLRuntimeModule.java,v 1.1 2010/04/13 06:32:27 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl;

import org.eclipse.ocl.examples.xtext.essentialocl.services.EssentialOCLValueConverterService;
import org.eclipse.xtext.conversion.IValueConverterService;

/**
 * Use this class to register components to be used within the IDE.
 */
public class EssentialOCLRuntimeModule extends org.eclipse.ocl.examples.xtext.essentialocl.AbstractEssentialOCLRuntimeModule
{
	@Override
	public Class<? extends IValueConverterService> bindIValueConverterService() {
	  return EssentialOCLValueConverterService.class;
	}
}
