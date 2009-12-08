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

package de.ikv.medini.qvtemf.test;

import com.sap.mi.textual.moin.standalone.StandaloneConnectionFactoryFacade;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import de.ikv.medini.qvt.test.QVTJMITestAdapter;

public class QVTJMITestAdapterForEUML extends QVTJMITestAdapter {
	private static final String mmbuildpath = "../OCLJMITest/mmbuild/demo.sap.com~euml~def_assmbl.zip";
	static RefPackage companyPackage = null;
//	@Override
//	public void initRepository() {
//		for (String metaModelID : this.metamodelIDs) {
//			this.buildMetaModelFromEcoreFile(this.getProperty("metamodel.ecore.dir") + metaModelID + ".ecore");
//		}
//		super.initRepository();
//	}
	@Override
	public void initRepository() {

		boolean doReflective = Boolean.valueOf(this.getProperty("doReflective"));

		setConnection(StandaloneConnectionFactoryFacade.getMetaModelConnection(mmbuildpath));
		for (String metaModelID : this.metamodelIDs) {
			addMetaModel((MofPackage) connection.getPackage(null, metaModelID).refMetaObject());
		}
		super.initRepository(); 
	}


}
