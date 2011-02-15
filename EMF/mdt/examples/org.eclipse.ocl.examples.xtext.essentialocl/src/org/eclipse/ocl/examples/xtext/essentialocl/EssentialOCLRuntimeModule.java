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
 * $Id: EssentialOCLRuntimeModule.java,v 1.3 2011/02/11 20:00:46 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl;

import org.eclipse.ocl.examples.xtext.base.cs2pivot.BaseFragmentProvider;
import org.eclipse.ocl.examples.xtext.base.utilities.CS2PivotLinker;
import org.eclipse.ocl.examples.xtext.base.utilities.NoEObjectCompositeEValidator;
import org.eclipse.ocl.examples.xtext.essentialocl.services.EssentialOCLCrossReferenceSerializer;
import org.eclipse.ocl.examples.xtext.essentialocl.services.EssentialOCLLinkingDiagnosticMessageProvider;
import org.eclipse.ocl.examples.xtext.essentialocl.services.EssentialOCLLinkingService;
import org.eclipse.ocl.examples.xtext.essentialocl.services.EssentialOCLQualifiedNameProvider;
import org.eclipse.ocl.examples.xtext.essentialocl.services.EssentialOCLValueConverterService;
import org.eclipse.ocl.examples.xtext.essentialocl.utilities.EssentialOCLCSResource;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.linking.ILinker;
import org.eclipse.xtext.linking.ILinkingDiagnosticMessageProvider;
import org.eclipse.xtext.linking.ILinkingService;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.parsetree.reconstr.ITokenSerializer.ICrossReferenceSerializer;
import org.eclipse.xtext.resource.IFragmentProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.validation.CompositeEValidator;

/**
 * Use this class to register components to be used within the IDE.
 */
public class EssentialOCLRuntimeModule extends org.eclipse.ocl.examples.xtext.essentialocl.AbstractEssentialOCLRuntimeModule
{	
	public Class<? extends CompositeEValidator> bindCompositeEValidator() {
		return NoEObjectCompositeEValidator.class;
	}

	public Class<? extends ICrossReferenceSerializer> bindICrossReferenceSerializer() {
		return EssentialOCLCrossReferenceSerializer.class;
	}
	
	// URI remapping from CS to pivot
	@Override
	public Class<? extends IFragmentProvider> bindIFragmentProvider() {
		return BaseFragmentProvider.class;
	}
	
	@Override
	public Class<? extends ILinker> bindILinker() {
		return CS2PivotLinker.class;
	}
	
	public Class<? extends ILinkingDiagnosticMessageProvider> bindILinkingDiagnosticMessageProvider() {
		return EssentialOCLLinkingDiagnosticMessageProvider.class;
	}
	@Override
	public Class<? extends XtextResource> bindXtextResource() {
		return EssentialOCLCSResource.class;
	}

	// External reference loading and resolution.
	@Override
	public Class<? extends ILinkingService> bindILinkingService() {
		return EssentialOCLLinkingService.class;
	}

	@Override
	public Class<? extends IQualifiedNameProvider> bindIQualifiedNameProvider() {
		return EssentialOCLQualifiedNameProvider.class;
	}

//	@Override
//	public Class<? extends IScopeProvider> bindIScopeProvider() {
//		return EssentialOCLCSScopeProvider.class;
//	}

	@Override
	public Class<? extends IValueConverterService> bindIValueConverterService() {
	  return EssentialOCLValueConverterService.class;
	}
}
