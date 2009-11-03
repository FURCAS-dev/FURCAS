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

package de.ikv.medini.oclemf.test;

import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.ikv.medini.ocl.test.OCLEMFTestAdapter;
import de.ikv.medini.oclemf.test.TestMetaModel.TestMetaModelPackage;

public class TestMetaModel_EMFAdapter extends OCLEMFTestAdapter {

	static EPackageImpl companyPackage = null;

	@Override
	public void initRepository() {

		boolean doReflective = Boolean.valueOf(this.getProperty("doReflective"));

		if (doReflective) {
			TestMetaModel_EMFAdapter.companyPackage = this.buildMetaModelFromEcoreFile(this.getProperty("metamodel.ecore.dir") + "TestMetaModel.ecore");
		} else {
			TestMetaModel_EMFAdapter.companyPackage = (EPackageImpl) TestMetaModelPackage.eINSTANCE;
			this.registerMetaModel(TestMetaModel_EMFAdapter.companyPackage);
			this.registerMetaModel(EcoreUtil.getAllContents(TestMetaModel_EMFAdapter.companyPackage, true));

		}
		super.initRepository();
	}

}
