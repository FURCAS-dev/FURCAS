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
 * $Id: EssentialOCLValueConverterService.java,v 1.7 2010/05/21 20:12:10 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.services;

import org.eclipse.ocl.examples.xtext.oclstdlib.services.OCLstdlibValueConverterService;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;

public class EssentialOCLValueConverterService extends OCLstdlibValueConverterService
{
	@ValueConverter(rule = "Identifier")
	public IValueConverter<String> Identifier() {
		return ID();		// FIXME Why is this needed (testImportsSerialize fails without it)
	}
}
