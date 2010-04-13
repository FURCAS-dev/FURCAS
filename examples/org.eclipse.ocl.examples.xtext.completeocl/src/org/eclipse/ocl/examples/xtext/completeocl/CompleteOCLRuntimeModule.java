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
 * $Id: CompleteOCLRuntimeModule.java,v 1.1 2010/04/13 06:38:26 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.completeocl;

import org.eclipse.ocl.examples.xtext.essentialocl.services.EssentialOCLValueConverterService;
import org.eclipse.xtext.conversion.IValueConverterService;

/**
 * Use this class to register components to be used within the IDE.
 */
public class CompleteOCLRuntimeModule extends org.eclipse.ocl.examples.xtext.completeocl.AbstractCompleteOCLRuntimeModule
{
	@Override
	public Class<? extends IValueConverterService> bindIValueConverterService() {
	  return EssentialOCLValueConverterService.class;
	}
}
