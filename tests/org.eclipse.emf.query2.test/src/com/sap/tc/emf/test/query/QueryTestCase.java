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
import org.eclipse.emf.query.index.query.QueryExecutor;
import org.eclipse.emf.query.index.update.IndexUpdater;
import org.eclipse.emf.query.index.update.ResourceIndexer;
import org.eclipse.emf.query.index.update.UpdateCommandAdapter;
import org.eclipse.emf.query2.test.mm.Company.CompanyPackage;
import org.eclipse.emf.query2.test.mm.generatedmetamodel.GeneratedmetamodelPackage;
import org.eclipse.emf.query2.test.mm.testcases.case001.Case001Package;
import org.eclipse.emf.query2.test.mm.testcases.case002.Case002Package;
import org.eclipse.emf.query2.test.mm.testcases.case004.Case004Package;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

public class QueryTestCase extends Assert {

	private static final Index DEFAULT_INDEX = new PageableIndexImpl(Options.PAGING_AND_DUMPING_DISABLED);

	static {

		DEFAULT_INDEX.executeUpdateCommand(new UpdateCommandAdapter() {

			@Override
			public void execute(IndexUpdater updater, QueryExecutor queryExecutor) {
				ResourceIndexer indexer = new ResourceIndexer();
				indexer.resourceChanged(updater, EcorePackage.eINSTANCE.eResource());
				indexer.resourceChanged(updater, GeneratedmetamodelPackage.eINSTANCE.eResource());
				indexer.resourceChanged(updater, CompanyPackage.eINSTANCE.eResource());
				indexer.resourceChanged(updater, Case001Package.eINSTANCE.eResource());
				indexer.resourceChanged(updater, Case002Package.eINSTANCE.eResource());
				indexer.resourceChanged(updater, Case004Package.eINSTANCE.eResource());
			}
		});

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
