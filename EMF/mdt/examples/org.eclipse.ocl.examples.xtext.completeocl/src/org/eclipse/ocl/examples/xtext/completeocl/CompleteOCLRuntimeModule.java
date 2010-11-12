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
 * $Id: CompleteOCLRuntimeModule.java,v 1.4 2010/05/09 10:37:45 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.completeocl;

import org.eclipse.ocl.examples.xtext.completeocl.scoping.CompleteOCLScopeProvider;
import org.eclipse.ocl.examples.xtext.completeocl.services.CompleteOCLLinkingService;
import org.eclipse.ocl.examples.xtext.essentialocl.services.EssentialOCLValueConverterService;
import org.eclipse.ocl.examples.xtext.oclinecore.services.OCLinEcoreCrossReferenceSerializer;
import org.eclipse.ocl.examples.xtext.oclinecore.services.OCLinEcoreQualifiedNameProvider;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.linking.ILinkingService;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.parsetree.reconstr.ITokenSerializer.ICrossReferenceSerializer;
import org.eclipse.xtext.scoping.IScopeProvider;

/**
 * Use this class to register components to be used within the IDE.
 */
public class CompleteOCLRuntimeModule extends org.eclipse.ocl.examples.xtext.completeocl.AbstractCompleteOCLRuntimeModule
{
	public Class<? extends ICrossReferenceSerializer> bindICrossReferenceSerializer() {
		return OCLinEcoreCrossReferenceSerializer.class;
	}

	@Override
	public Class<? extends ILinkingService> bindILinkingService() {
		return CompleteOCLLinkingService.class;
	}

	@Override
	public Class<? extends IQualifiedNameProvider> bindIQualifiedNameProvider() {
		return OCLinEcoreQualifiedNameProvider.class;
	}

	@Override
	public Class<? extends IScopeProvider> bindIScopeProvider() {
		return CompleteOCLScopeProvider.class;
	}

	@Override
	public Class<? extends IValueConverterService> bindIValueConverterService() {
	  return EssentialOCLValueConverterService.class;
	}
}
