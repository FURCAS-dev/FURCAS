/*******************************************************************************
 * Copyright (c) 2006, 2009 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     SAP AG - initial API and implementation
 *******************************************************************************/
package com.sap.tc.emf.test.query;

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.query.index.Index;
import org.eclipse.emf.query.index.internal.impl.PageableIndexImpl;
import org.eclipse.emf.query.index.internal.impl.PageableIndexImpl.Options;
import org.eclipse.emf.query2.test.mm.Company.CompanyPackage;
import org.eclipse.emf.query2.test.mm.generatedmetamodel.GeneratedmetamodelPackage;
import org.eclipse.emf.query2.test.mm.testcases.case001.Case001Package;
import org.eclipse.emf.query2.test.mm.testcases.case002.Case002Package;
import org.eclipse.emf.query2.test.mm.testcases.case004.Case004Package;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

import com.sap.tc.emf.test.query.setup.IndexerForTest;

public class QueryTestCase extends Assert {

	private static final Index DEFAULT_INDEX = new PageableIndexImpl(Options.PAGING_AND_DUMPING_DISABLED);

	static {

		IndexerForTest.index(getDefaultIndexStore(), // 
				EcorePackage.eINSTANCE.eResource(), // 
				GeneratedmetamodelPackage.eINSTANCE.eResource(), // 
				CompanyPackage.eINSTANCE.eResource(), //
				Case001Package.eINSTANCE.eResource(), //
				Case002Package.eINSTANCE.eResource(), //
				Case004Package.eINSTANCE.eResource());

	}

	public static Index getDefaultIndexStore() {
		return DEFAULT_INDEX;
	}

	@Before
	public void beforeTestMethod() throws Exception {

	}

	@After
	public void afterTestMethod() throws Exception {

	}
}
