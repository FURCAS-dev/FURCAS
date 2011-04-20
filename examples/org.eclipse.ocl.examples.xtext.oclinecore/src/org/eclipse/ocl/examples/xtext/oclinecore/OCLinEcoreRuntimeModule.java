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
 * $Id: OCLinEcoreRuntimeModule.java,v 1.11 2011/04/20 19:02:56 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclinecore;

import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.BaseFragmentProvider;
import org.eclipse.ocl.examples.xtext.base.utilities.CS2PivotLinker;
import org.eclipse.ocl.examples.xtext.base.utilities.PivotDiagnostician;
import org.eclipse.ocl.examples.xtext.essentialocl.services.EssentialOCLCrossReferenceSerializer;
import org.eclipse.ocl.examples.xtext.essentialocl.services.EssentialOCLLinkingDiagnosticMessageProvider;
import org.eclipse.ocl.examples.xtext.essentialocl.services.EssentialOCLLinkingService;
import org.eclipse.ocl.examples.xtext.essentialocl.services.EssentialOCLQualifiedNameProvider;
import org.eclipse.ocl.examples.xtext.oclinecore.services.OCLinEcoreValueConverterService;
import org.eclipse.ocl.examples.xtext.oclinecore.utilities.OCLinEcoreCSResource;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.linking.ILinker;
import org.eclipse.xtext.linking.ILinkingDiagnosticMessageProvider;
import org.eclipse.xtext.linking.ILinkingService;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.parsetree.reconstr.ITokenSerializer.ICrossReferenceSerializer;
import org.eclipse.xtext.resource.IFragmentProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.service.SingletonBinding;

import com.google.inject.Binder;
import com.google.inject.name.Names;

/**
 * Use this class to register components to be used within the IDE.
 */
public class OCLinEcoreRuntimeModule extends AbstractOCLinEcoreRuntimeModule
{
	@Override
	public void configure(Binder binder) {
		super.configure(binder);
		binder.bindConstant().annotatedWith(Names.named(org.eclipse.xtext.validation.CompositeEValidator.USE_EOBJECT_VALIDATOR)).to(false);
	}
	
	@Override
	@SingletonBinding
	public Class<? extends Diagnostician> bindDiagnostician() {
		return PivotDiagnostician.class;
	}

	// Reference value to text serialisation.
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

	// External reference loading and resolution.
	@Override
	public Class<? extends ILinkingService> bindILinkingService() {
		return EssentialOCLLinkingService.class;
	}

	// Name value to text serialisation.
	@Override
	public Class<? extends IQualifiedNameProvider> bindIQualifiedNameProvider() {
		return EssentialOCLQualifiedNameProvider.class;
	}
	
	// DataType text to value parsing.
	@Override
	public Class<? extends IValueConverterService> bindIValueConverterService() {
	  return OCLinEcoreValueConverterService.class;
	}

//	@Override
//	public Class<? extends IGlobalScopeProvider> bindIGlobalScopeProvider() {
//		return OCLinEcoreGlobalScopeProvider.class;
//	}

//	@Override
//	public Class<? extends IScopeProvider> bindIScopeProvider() {
//		return OCLinEcoreCSScopeProvider.class;
//	}
	
	@Override
	public Class<? extends XtextResource> bindXtextResource() {
		return OCLinEcoreCSResource.class;
	}
}
