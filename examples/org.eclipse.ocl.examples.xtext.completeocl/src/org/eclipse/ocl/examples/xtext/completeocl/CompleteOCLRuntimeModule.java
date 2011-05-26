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
 * $Id: CompleteOCLRuntimeModule.java,v 1.11 2011/05/15 20:22:18 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.completeocl;

import org.eclipse.ocl.examples.xtext.base.cs2pivot.BaseFragmentProvider;
import org.eclipse.ocl.examples.xtext.base.utilities.CS2PivotLinker;
import org.eclipse.ocl.examples.xtext.completeocl.scoping.CompleteOCLScopeProvider;
import org.eclipse.ocl.examples.xtext.completeocl.utilities.CompleteOCLCSResource;
import org.eclipse.ocl.examples.xtext.essentialocl.services.EssentialOCLCrossReferenceSerializer;
import org.eclipse.ocl.examples.xtext.essentialocl.services.EssentialOCLLinkingDiagnosticMessageProvider;
import org.eclipse.ocl.examples.xtext.essentialocl.services.EssentialOCLLinkingService;
import org.eclipse.ocl.examples.xtext.essentialocl.services.EssentialOCLQualifiedNameProvider;
import org.eclipse.ocl.examples.xtext.essentialocl.services.EssentialOCLValueConverterService;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.linking.ILinker;
import org.eclipse.xtext.linking.ILinkingDiagnosticMessageProvider;
import org.eclipse.xtext.linking.ILinkingService;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.parsetree.reconstr.ITokenSerializer.ICrossReferenceSerializer;
import org.eclipse.xtext.resource.IFragmentProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.scoping.IScopeProvider;

import com.google.inject.Binder;
import com.google.inject.name.Names;

/**
 * Use this class to register components to be used within the IDE.
 */
public class CompleteOCLRuntimeModule extends org.eclipse.ocl.examples.xtext.completeocl.AbstractCompleteOCLRuntimeModule
{
	@Override
	public void configure(Binder binder) {
		super.configure(binder);
		binder.bindConstant().annotatedWith(Names.named(org.eclipse.xtext.validation.CompositeEValidator.USE_EOBJECT_VALIDATOR)).to(false);
	}

	public Class<? extends ICrossReferenceSerializer> bindICrossReferenceSerializer() {
		return EssentialOCLCrossReferenceSerializer.class;
	}
	
	// Potential resolution of Pivot fragments for CST resource
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
	public Class<? extends ILinkingService> bindILinkingService() {
		return EssentialOCLLinkingService.class;
	}

	@Override
	public Class<? extends IQualifiedNameProvider> bindIQualifiedNameProvider() {
		return EssentialOCLQualifiedNameProvider.class;
	}

	@Override
	public Class<? extends IScopeProvider> bindIScopeProvider() {
		return CompleteOCLScopeProvider.class;
	}

	@Override
	public Class<? extends IValueConverterService> bindIValueConverterService() {
	  return EssentialOCLValueConverterService.class;
	}
	
	@Override
	public Class<? extends XtextResource> bindXtextResource() {
		return CompleteOCLCSResource.class;
	}
}
