/***********************************************************************
 * Copyright (c) 2008 Anyware Technologies and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Anyware Technologies - initial API and implementation
 *
 * $Id: Messages.java,v 1.1 2008/04/28 15:47:42 jlescot Exp $
 **********************************************************************/
package org.eclipse.emf.ecoretools.registration;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.emf.ecoretools.registration.messages"; //$NON-NLS-1$

	public static String EcoreRegisteringAction_CanNotBeRegistered;

	public static String EcoreRegisteringAction_EPackageRegistration;

	public static String EcoreUnregisteringAction_CanNotBeUnregistered;

	public static String EcoreUnregisteringAction_EPackageRegistration;

	public static String EMFRegisterAction_UnableToOpenView;

	public static String RegisteredPackagesLabelProvider_GeneratedJava;

	public static String RegisteredPackageView_CopyNsURI;

	public static String RegisteredPackageView_CopyNsURI_tooltip;

	public static String RegisteredPackageView_Origin;

	public static String RegisteredPackageView_PackageName;

	public static String RegisteredPackageView_RegisteredPackages;

	public static String RegisteredPackageView_RegisteredURI;

	public static String RegisteredPackageView_Unregister;

	public static String RegisteredPackageView_UnregisterSelectedPackages;
	
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
