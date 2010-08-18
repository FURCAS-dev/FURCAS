/*******************************************************************************
 * Copyright (c) 2008 ikv++ technologies ag and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     ikv++ technologies ag - initial API and implementation
 *******************************************************************************/

package de.ikv.medini.ocljmi.test;

import org.eclipse.emf.ecore.EPackage;

import com.sap.mi.textual.moin.standalone.StandaloneConnectionFactoryFacade;

import de.ikv.medini.ocl.test.OCLJMITestAdapter;

public class TestMetaModel_JMIAdapter extends OCLJMITestAdapter {

	private static final String mmbuildpath = "../OCLJMITest/mmbuild/demo.sap.com~testmetamodel~def_assmbl.zip";
	static EPackage companyPackage = null;

	@Override
	public void initRepository() {

		boolean doReflective = Boolean.valueOf(this.getProperty("doReflective"));

		setConnection(StandaloneConnectionFactoryFacade.getMetaModelConnection(mmbuildpath));
		addMetaModel((EPackage) connection.getPackage(TestMetaModelPackage.PACKAGE_DESCRIPTOR).refMetaObject());
		super.initRepository();
	}

}
