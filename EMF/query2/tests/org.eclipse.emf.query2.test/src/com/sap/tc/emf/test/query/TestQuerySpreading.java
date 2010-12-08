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

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.query.index.Index;
import org.eclipse.emf.query2.QueryContext;
import org.eclipse.emf.query2.QueryProcessor;
import org.eclipse.emf.query2.QueryProcessorFactory;
import org.eclipse.emf.query2.ResultSet;
import org.eclipse.emf.query2.TypeScopeProvider;
import org.eclipse.emf.query2.internal.moinql.controller.QueryProcessorImpl;
import org.eclipse.emf.query2.test.mm.testcases.case001.A1;
import org.eclipse.emf.query2.test.mm.testcases.case001.B1;
import org.eclipse.emf.query2.test.mm.testcases.case001.Case001Factory;
import org.eclipse.emf.query2.test.mm.testcases.case001.Case001Package;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sap.tc.emf.test.query.setup.DefaultTestClientImpl;
import com.sap.tc.emf.test.query.setup.IndexerForTest;
import com.sap.tc.emf.test.query.setup.TestClient;

public class TestQuerySpreading extends QueryTestCase {

	private TestClient testClient;
	private Index index;

	@Before
	public void beforeTestMethod() throws Exception {
		super.beforeTestMethod();
		this.testClient = new DefaultTestClientImpl();
		this.index = getDefaultIndexStore();
	}

	@After
	public void afterTestMethod() throws Exception {
		if (this.testClient != null) {
			this.testClient.clear();
			this.testClient = null;
		}
		this.index = null;
		super.afterTestMethod();
	}

	private void resetTestClient() {
		if (this.testClient != null) {
			this.testClient.clear();
			this.testClient = null;
		}
		this.testClient = new DefaultTestClientImpl();
	}

	private QueryProcessor getMQLProcessor() {

		return QueryProcessorFactory.getDefault().createQueryProcessor(index);
	}

	private QueryContext getQueryContext(final TypeScopeProvider scopeProvider) {
		return new QueryContext() {

			@Override
			public URI[] getResourceScope() {
				return scopeProvider.getPartitionScope();
			}

			@Override
			public ResourceSet getResourceSet() {
				// TODO Auto-generated method stub
				return TestQuerySpreading.this.testClient.getResourceSet();
			}

		};
	}

	@Test
	public void testDominantMixedSubdominantDirty() throws Exception {

		QueryProcessor mql = this.getMQLProcessor();

		Resource mixedDirty_NonDirty = this.testClient.getOrCreateResourceStable("mixedDirty_nonDirty.xmi");
		Resource mixedDirty_Dirty = this.testClient.getOrCreateResourceStable("mixedDirty_dirty.xmi");

		mixedDirty_Dirty.getContents().clear();
		mixedDirty_NonDirty.getContents().clear();

		URI aType = EcoreUtil.getURI(Case001Package.eINSTANCE.getA1());
		URI bType = EcoreUtil.getURI(Case001Package.eINSTANCE.getB1());

		A1 a1 = Case001Factory.eINSTANCE.createA1();
		A1 a2 = Case001Factory.eINSTANCE.createA1();
		B1 b = Case001Factory.eINSTANCE.createB1();

		a1.getBs().add(b);

		mixedDirty_NonDirty.getContents().add(a1);
		mixedDirty_Dirty.getContents().add(a2);
		mixedDirty_Dirty.getContents().add(b);

		mixedDirty_Dirty.save(null);
		mixedDirty_NonDirty.save(null);

		IndexerForTest.index(getDefaultIndexStore(), mixedDirty_Dirty, mixedDirty_NonDirty);

		// reset the client to clear resource set
		this.resetTestClient();

		// load the dirty partition and make it dirty
		mixedDirty_Dirty = this.testClient.getOrCreateResourceStable("mixedDirty_dirty.xmi");
		mixedDirty_Dirty.setModified(true);

		String query = String.format("select a, b from [%s] as a, [%s] as b in resources{[%s]} where a.bs = b", aType, bType,
				mixedDirty_Dirty.getURI());

		TypeScopeProvider scopeProvider = mql.getInclusivePartitionScopeProvider(mixedDirty_Dirty.getURI(), mixedDirty_NonDirty.getURI());
		ResultSet resultSet = mql.execute(query, this.getQueryContext(scopeProvider));

		assertEquals(1, resultSet.getSize());

		mixedDirty_NonDirty = this.testClient.getOrCreateResourceStable("mixedDirty_nonDirty.xmi");

		mixedDirty_Dirty.delete(null);
		mixedDirty_NonDirty.delete(null);

		IndexerForTest.delete(getDefaultIndexStore(), mixedDirty_Dirty.getURI(), mixedDirty_NonDirty.getURI());
	}

}
