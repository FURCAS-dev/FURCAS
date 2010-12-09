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
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.query.index.Index;
import org.eclipse.emf.query2.QueryContext;
import org.eclipse.emf.query2.QueryFormatException;
import org.eclipse.emf.query2.QueryProcessor;
import org.eclipse.emf.query2.QueryProcessorFactory;
import org.eclipse.emf.query2.internal.moinql.controller.QueryProcessorImpl;
import org.eclipse.emf.query2.test.mm.Company.CompanyPackage;
import org.eclipse.emf.query2.test.mm.generatedmetamodel.GeneratedmetamodelPackage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sap.tc.emf.test.query.setup.DefaultTestClientImpl;
import com.sap.tc.emf.test.query.setup.TestClient;

public class TestSuiteNegativeQueryTests extends QueryTestCase {

	private TestClient testClient1;

	private Index index;

	@Override
	@Before
	public void beforeTestMethod() throws Exception {

		super.beforeTestMethod();

		this.testClient1 = new DefaultTestClientImpl();

		// EcoreIndexFeeder feederImpl = new EcoreIndexFeederImpl(
		// IIndexStore.INSTANCE );
		//
		// ResourceIndexFeeder resFeeder = new ResourceIndexFeederImpl(
		// IIndexStore.INSTANCE );

		this.index = getDefaultIndexStore();

		// try {
		// ModelPartition p1 = this.testClient1.getOrCreatePartitionStable(
		// "negative_query_partition1" );
		// ModelPartition p2 = this.testClient1.getOrCreatePartitionStable(
		// "negative_query_partition2" );
		// ModelPartition p3 = this.testClient1.getOrCreatePartitionStable(
		// "negative_query_partition3" );
		// this.globalPartitionScope = new URI[] { p1.getPri( ), p2.getPri( ),
		// p3.getPri( ) };
		//
		// } catch ( Exception e1 ) {
		// e1.printStackTrace( );
		// }

	}

	@After
	public void afterTestMethod() throws Exception {

		if (this.testClient1 != null) {
			this.testClient1.clear();
			this.testClient1 = null;
		}
		super.afterTestMethod();
	}

	private boolean verifyNegativeTest(String query) {

		QueryProcessor mql = this.getMQLProcessor();
		try {
			mql.execute(query, this.getQueryContext());
		} catch (QueryFormatException e) {
			// if (logger.isTraced(LogSeverity.INFO)) {
			// logger.trace(LogSeverity.INFO, "Query: \n" + query);
			// logger.trace(LogSeverity.INFO,
			// "did not preprocess with message: " + e.getLocalizedMessage());
			// }
			return true;
		}

		assertTrue("Query >> " + query + " << did not produce an MQL FormatException!", false);
		return false;
	}

	private QueryProcessor getMQLProcessor() {

		return QueryProcessorFactory.getDefault().createQueryProcessor(index);
	}

	private QueryContext getQueryContext() {
		return new QueryContext() {

			public URI[] getResourceScope() {
				return new URI[0];
			}

			public ResourceSet getResourceSet() {
				return TestSuiteNegativeQueryTests.this.testClient1.getResourceSet();
			}

		};
	}

	/*
	 * Actual TESTs
	 */

	@Test
	public void derivedAttributesAreNotSupported() throws Exception {

		String query = "select ref.eReferenceType from [" + EcoreUtil.getURI(EcorePackage.eINSTANCE.getEReference()) + "] as modelClass";

		this.verifyNegativeTest(query);
	}

	@Test
	public void unMatchingAliasesInSelect() throws Exception {

		String query = "select alias1 from [" + EcoreUtil.getURI(EcorePackage.eINSTANCE.getEClass()) + "] as alias2";

		this.verifyNegativeTest(query);
	}

	@Test
	public void fromTypeDoesNotExist() throws Exception {

		String query = "select nec from [" + EcorePackage.eINSTANCE.getNsURI() + "#//NotExistingClass] as nec";

		this.verifyNegativeTest(query);
	}

	@Test
	public void whereClauseWithOr() throws Exception {

		String query = "select cl from [" + EcoreUtil.getURI(EcorePackage.eINSTANCE.getEClass()) + "] as cl where cl.name = 'a' or c.name = 'b'";

		this.verifyNegativeTest(query);
	}

	@Test
	public void nullComparisonOnPrimitiveTypeInWhereClause() throws Exception {

		String query = "select dep from [" + EcoreUtil.getURI(CompanyPackage.eINSTANCE.getDepartment()) + "] as dep where dep.budget = null";

		this.verifyNegativeTest(query);
	}

	@Test
	public void comparisonTooLong() throws Exception {

		String query = "select mm from ["
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass0())
				+ "] as mm where name = 'Thisisalongstringwhichismorethan200characters :                                                                                                                                                                       n'";

		this.verifyNegativeTest(query);
	}

	@Test
	public void nestedQueryWithMoreThanOneSelect() throws Exception {

		String query = "select cl0.name from [" + EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass0())
				+ "] as cl0 where cl0.assoc0x1EndB in (select cl1, cl1.name from [" + EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass1()) + "] as cl1 "
				+ " where for cl1(name ='ModelClass1Inst0'))";

		this.verifyNegativeTest(query);
	}

	@Test
	public void nestedQueryWithOneAttributeSelect() throws Exception {

		String query = "select cl0.name from [" + EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass0())
				+ "] as cl0 where cl0.assoc0x1EndB in (select cl1.name from [" + EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass1()) + "] as cl1)";

		this.verifyNegativeTest(query);
	}

	@Test
	public void fromTypeWithNotInElements() throws Exception {

		String query = "select cl0.name from [" + EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass0()) + "] as cl0 not in elements{}";

		this.verifyNegativeTest(query);
	}

	@Test
	public void fromTypeWithSameAlias() throws Exception {

		String query = "select mm from [" + EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass0()) + "] as mm, ["
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass0()) + "] as mm";

		this.verifyNegativeTest(query);
	}

	@Test
	public void invalidEscapeInLikePattern() throws Exception {

		String query = "select mm from [" + EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass0()) + "] as mm where mm.name like 'this pattern is \\invalid'";

		this.verifyNegativeTest(query);
	}

	// @Test
	// public void executionOverLoad( ) throws Exception {
	//
	// String query = "select m from [" + EcoreUtil.getURI(
	// EcorePackage.eINSTANCE.getEClass( ) ) + "] as m, [" + EcoreUtil.getURI(
	// EcorePackage.eINSTANCE.getEClass( ) ) + "] as m2, [" + EcoreUtil.getURI(
	// EcorePackage.eINSTANCE.getEClass( ) ) + "] as m3, ["
	// + EcoreUtil.getURI( EcorePackage.eINSTANCE.getEClass( ) ) + "] as m4, ["
	// + EcoreUtil.getURI( EcorePackage.eINSTANCE.getEClass( ) ) + "] as m5, ["
	// + EcoreUtil.getURI( EcorePackage.eINSTANCE.getEClass( ) ) + "] as m6";
	//
	// MQLProcessor mql = this.getMQLProcessor( );
	// boolean executionFailed = false;
	// try {
	// mql.execute( query );
	// } catch ( MQLExecutionException e ) {
	// executionFailed = true;
	// }
	//
	// assertTrue( "Query >> " + query +
	// " << did not produce an MQL ExecutionException!", executionFailed );
	// }

	@Test
	public void invalidSubTypeExclusion() throws Exception {

		String query = "select clf from [" + EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass0()) + "] withoutsubtypes {} as clf";
		this.verifyNegativeTest(query);

		String query2 = "select clf from [" + EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass0()) + "] withoutsubtypes {["
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass0()) + "]} as clf";
		this.verifyNegativeTest(query2);

		String query3 = "select clf from [" + EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass0()) + "] withoutsubtypes {["
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass1()) + "]} as clf";
		this.verifyNegativeTest(query3);
	}
}
