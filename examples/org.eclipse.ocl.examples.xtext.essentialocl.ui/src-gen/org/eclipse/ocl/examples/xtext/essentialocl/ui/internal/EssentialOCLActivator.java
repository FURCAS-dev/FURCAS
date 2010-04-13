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
 * $Id: EssentialOCLActivator.java,v 1.1 2010/04/13 06:33:11 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.ui.internal;

import org.apache.log4j.Logger;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.util.Modules;

import java.util.Map;
import java.util.HashMap;

/**
 * Generated
 */
public class EssentialOCLActivator extends AbstractUIPlugin {

	private Map<String,Injector> injectors = new HashMap<String,Injector>();
	private static EssentialOCLActivator INSTANCE;

	public Injector getInjector(String languageName) {
		return injectors.get(languageName);
	}
	
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		INSTANCE = this;
		try {
			
			injectors.put("org.eclipse.ocl.examples.xtext.essentialocl.EssentialOCL", Guice.createInjector(
				Modules.override(Modules.override(getRuntimeModule("org.eclipse.ocl.examples.xtext.essentialocl.EssentialOCL")).with(getUiModule("org.eclipse.ocl.examples.xtext.essentialocl.EssentialOCL"))).with(getSharedStateModule())
			));
			
		} catch (Exception e) {
			Logger.getLogger(getClass()).error(e.getMessage(), e);
			throw e;
		}
	}
	
	public static EssentialOCLActivator getInstance() {
		return INSTANCE;
	}
	
	protected Module getRuntimeModule(String grammar) {
		
		if ("org.eclipse.ocl.examples.xtext.essentialocl.EssentialOCL".equals(grammar)) {
		  return new org.eclipse.ocl.examples.xtext.essentialocl.EssentialOCLRuntimeModule();
		}
		
		throw new IllegalArgumentException(grammar);
	}
	protected Module getUiModule(String grammar) {
		
		if ("org.eclipse.ocl.examples.xtext.essentialocl.EssentialOCL".equals(grammar)) {
		  return new org.eclipse.ocl.examples.xtext.essentialocl.ui.EssentialOCLUiModule(this);
		}
		
		throw new IllegalArgumentException(grammar);
	}
	
	protected Module getSharedStateModule() {
		return new org.eclipse.xtext.ui.shared.SharedStateModule();
	}
	
}
