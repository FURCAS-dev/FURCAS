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
 * $Id: OCLinEcoreRuntimeModule.java,v 1.5 2010/05/09 10:26:23 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclinecore;

import org.eclipse.ocl.examples.xtext.oclinecore.scoping.OCLinEcoreGlobalScopeProvider;
import org.eclipse.ocl.examples.xtext.oclinecore.scoping.OCLinEcoreScopeProvider;
import org.eclipse.ocl.examples.xtext.oclinecore.services.OCLinEcoreCrossReferenceSerializer;
import org.eclipse.ocl.examples.xtext.oclinecore.services.OCLinEcoreLinkingService;
import org.eclipse.ocl.examples.xtext.oclinecore.services.OCLinEcoreQualifiedNameProvider;
import org.eclipse.ocl.examples.xtext.oclinecore.services.OCLinEcoreValueConverterService;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.linking.ILinkingService;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.parsetree.reconstr.ITokenSerializer.ICrossReferenceSerializer;
import org.eclipse.xtext.scoping.IGlobalScopeProvider;
import org.eclipse.xtext.scoping.IScopeProvider;

/**
 * Use this class to register components to be used within the IDE.
 */
public class OCLinEcoreRuntimeModule extends AbstractOCLinEcoreRuntimeModule
{
	// Reference value to text serialisation.
	public Class<? extends ICrossReferenceSerializer> bindICrossReferenceSerializer() {
		return OCLinEcoreCrossReferenceSerializer.class;
	}

	// External reference loading and resolution.
	@Override
	public Class<? extends ILinkingService> bindILinkingService() {
		return OCLinEcoreLinkingService.class;
	}

	// Name value to text serialisation.
	@Override
	public Class<? extends IQualifiedNameProvider> bindIQualifiedNameProvider() {
		return OCLinEcoreQualifiedNameProvider.class;
	}
	
	// DataType text to value parsing.
	@Override
	public Class<? extends IValueConverterService> bindIValueConverterService() {
	  return OCLinEcoreValueConverterService.class;
	}

	@Override
	public Class<? extends IGlobalScopeProvider> bindIGlobalScopeProvider() {
		return OCLinEcoreGlobalScopeProvider.class;
	}

	@Override
	public Class<? extends IScopeProvider> bindIScopeProvider() {
		return OCLinEcoreScopeProvider.class;
	}
}
