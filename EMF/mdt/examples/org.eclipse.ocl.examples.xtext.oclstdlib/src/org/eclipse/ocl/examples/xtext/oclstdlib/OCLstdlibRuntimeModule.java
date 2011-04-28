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
 * $Id: OCLstdlibRuntimeModule.java,v 1.4 2011/04/20 19:03:01 ewillink Exp $
 */

package org.eclipse.ocl.examples.xtext.oclstdlib;

import org.eclipse.ocl.examples.xtext.base.cs2pivot.BaseFragmentProvider;
import org.eclipse.ocl.examples.xtext.base.utilities.CS2PivotLinker;
import org.eclipse.ocl.examples.xtext.essentialocl.services.EssentialOCLLinkingDiagnosticMessageProvider;
import org.eclipse.ocl.examples.xtext.oclstdlib.scoping.OCLstdlibScopeProvider;
import org.eclipse.ocl.examples.xtext.oclstdlib.services.OCLstdlibLinkingService;
import org.eclipse.ocl.examples.xtext.oclstdlib.services.OCLstdlibValueConverterService;
import org.eclipse.ocl.examples.xtext.oclstdlib.utilities.OCLstdlibCSResource;
import org.eclipse.ocl.examples.xtext.oclstdlib.validation.OCLstdlibCompositeEValidator;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.linking.ILinker;
import org.eclipse.xtext.linking.ILinkingDiagnosticMessageProvider;
import org.eclipse.xtext.linking.ILinkingService;
import org.eclipse.xtext.resource.IFragmentProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.validation.CompositeEValidator;

import com.google.inject.Binder;
import com.google.inject.name.Names;

/**
 * Use this class to register components to be used within the IDE.
 */
public class OCLstdlibRuntimeModule extends org.eclipse.ocl.examples.xtext.oclstdlib.AbstractOCLstdlibRuntimeModule
{	
	@Override
	public void configure(Binder binder) {
		super.configure(binder);
		binder.bindConstant().annotatedWith(Names.named(org.eclipse.xtext.validation.CompositeEValidator.USE_EOBJECT_VALIDATOR)).to(false);
	}

	public Class<? extends CompositeEValidator> bindCompositeEValidator() {
		return OCLstdlibCompositeEValidator.class;
	}

	@Override
	public Class<? extends IValueConverterService> bindIValueConverterService() {
	  return OCLstdlibValueConverterService.class;
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

	// External reference loading and resolution.
	@Override
	public Class<? extends ILinkingService> bindILinkingService() {
		return OCLstdlibLinkingService.class;
	}

	@Override
	public Class<? extends IScopeProvider> bindIScopeProvider() {
		return OCLstdlibScopeProvider.class;
	}
	
	@Override
	public Class<? extends XtextResource> bindXtextResource() {
		return OCLstdlibCSResource.class;
	}
}
