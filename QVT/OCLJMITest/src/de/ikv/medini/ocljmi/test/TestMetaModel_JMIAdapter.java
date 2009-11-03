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

import testmetamodel.TestMetaModelPackage;

import com.sap.mi.textual.moin.standalone.StandaloneConnectionFactoryFacade;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import de.ikv.medini.ocl.test.OCLJMITestAdapter;

public class TestMetaModel_JMIAdapter extends OCLJMITestAdapter {

	private static final String mmbuildpath = "C:/data/cts/FURCAS/furcas_full/QVT/OCLJMITest/mmbuild/demo.sap.com~testmetamodel~def_assmbl.zip";
	static RefPackage companyPackage = null;

	@Override
	public void initRepository() {

		boolean doReflective = Boolean.valueOf(this.getProperty("doReflective"));

		setConnection(StandaloneConnectionFactoryFacade.getMetaModelConnection(mmbuildpath));
		addMetaModel((MofPackage) connection.getPackage(TestMetaModelPackage.PACKAGE_DESCRIPTOR).refMetaObject());
		super.initRepository();
	}

}
