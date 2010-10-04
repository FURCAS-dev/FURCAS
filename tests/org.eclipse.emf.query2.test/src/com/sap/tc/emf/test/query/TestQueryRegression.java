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

import java.io.IOException;
import java.util.Arrays;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.query.index.Index;
import org.eclipse.emf.query2.QueryContext;
import org.eclipse.emf.query2.QueryFormatException;
import org.eclipse.emf.query2.QueryProcessor;
import org.eclipse.emf.query2.QueryProcessorFactory;
import org.eclipse.emf.query2.ResultSet;
import org.eclipse.emf.query2.TypeScopeProvider;
import org.eclipse.emf.query2.internal.moinql.controller.QueryProcessorImpl;
import org.eclipse.emf.query2.test.mm.testcases.case001.A1;
import org.eclipse.emf.query2.test.mm.testcases.case001.B1;
import org.eclipse.emf.query2.test.mm.testcases.case001.Case001Factory;
import org.eclipse.emf.query2.test.mm.testcases.case001.Case001Package;
import org.eclipse.emf.query2.test.mm.testcases.case002.B2;
import org.eclipse.emf.query2.test.mm.testcases.case002.C2;
import org.eclipse.emf.query2.test.mm.testcases.case002.Case002Factory;
import org.eclipse.emf.query2.test.mm.testcases.case002.Case002Package;
import org.eclipse.emf.query2.test.mm.testcases.case004.A4;
import org.eclipse.emf.query2.test.mm.testcases.case004.B4;
import org.eclipse.emf.query2.test.mm.testcases.case004.Case004Factory;
import org.eclipse.emf.query2.test.mm.testcases.case004.Case004Package;
import org.eclipse.emf.query2.test.mm.testcases.case004.D4;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.sap.tc.emf.test.query.setup.DefaultTestClientImpl;
import com.sap.tc.emf.test.query.setup.IndexerForTest;
import com.sap.tc.emf.test.query.setup.TestClient;

public class TestQueryRegression extends QueryTestCase {

	private TestClient testClient1;
	private Index index;

	@Override
	@Before
	public void beforeTestMethod() throws Exception {

		super.beforeTestMethod();
		// this._testClient1 = getTestHelper().getDefaultTestClient(3, 4, true);
		this.testClient1 = new DefaultTestClientImpl();
		// this.testClient1.setAsCurrentClient();

		this.index = getDefaultIndexStore();
	}

	@Override
	@After
	public void afterTestMethod() throws Exception {

		if (this.testClient1 != null) {
			this.testClient1.clear();
			this.testClient1 = null;
		}
		this.index = null;
		super.afterTestMethod();
	}

	private QueryProcessor getMQLProcessor() {

		return QueryProcessorFactory.getDefault().createQueryProcessor(index);
	}

	@Test
	@Ignore
	public void testQueryWithInconsistency() throws Exception {

		throw new RuntimeException("test not migrated yet");

		// Resource res1 =
		// this.testClient1.getOrCreateResourceStable("res_inc_chain_1.xmi");
		// Resource res2 =
		// this.testClient1.getOrCreateResourceStable("res_inc_chain_2.xmi");
		// Resource res3 =
		// this.testClient1.getOrCreateResourceStable("res_inc_chain_3.xmi");
		// Resource res4 =
		// this.testClient1.getOrCreateResourceStable("res_inc_chain_4.xmi");
		// Resource res5 =
		// this.testClient1.getOrCreateResourceStable("res_inc_chain_5.xmi");
		// Resource res6 =
		// this.testClient1.getOrCreateResourceStable("res_inc_chain_6.xmi");
		//
		// URI uriA17 = EcoreUtil.getURI(Case017Package.Literals.A17);
		//
		// // first chain
		// A17 e1 = Case017Factory.eINSTANCE.createA17();
		// A17 e2 = Case017Factory.eINSTANCE.createA17();
		// A17 e3 = Case017Factory.eINSTANCE.createA17();
		// e1.getToEnd().add(e2);
		// e2.getToEnd().add(e3);
		//
		// res1.getContents().add(e1);
		// res2.getContents().add(e2);
		// res3.getContents().add(e3);
		//
		// ResourceIndexFeederImpl resourceSetIndexImpl = new
		// ResourceIndexFeederImpl(IIndexStore.INSTANCE);
		// // resourceSetIndexImpl.index(res1);
		// // // resourceSetIndexImpl.index(res2);
		// // resourceSetIndexImpl.index(res3);
		//
		// // second chain
		// A17 e4 = Case017Factory.eINSTANCE.createA17();
		// A17 e5 = Case017Factory.eINSTANCE.createA17();
		// A17 e6 = Case017Factory.eINSTANCE.createA17();
		// e4.getToEnd().add(e5);
		// e5.getToEnd().add(e6);
		//
		// res4.getContents().add(e4);
		// res5.getContents().add(e5);
		// res6.getContents().add(e6);
		//
		// resourceSetIndexImpl.index(res4);
		// resourceSetIndexImpl.index(res5);
		// resourceSetIndexImpl.index(res6);
		//
		// MQLProcessor mql = this.getMQLProcessor();
		//
		// MQLResultSet rs = mql.execute("select c, b, a " //
		// + "from [" + uriA17 + "] as c, " //
		// + "[" + uriA17 + "] as a, " //
		// + "[" + uriA17 + "] as b " //
		// + "where c.toEnd = b " //
		// + "where b.toEnd = a "); //
		//
		// System.out.println(rs.toString());
		//
		// assertTrue(rs.getSize() == 1);

	}

	@Test
	public void testNullReference() throws Exception {

		QueryProcessor mql = this.getMQLProcessor();
		Resource res = this.testClient1.getOrCreateResourceStable("jojoWhassaaap.xmi");
		Resource res1 = this.testClient1.getOrCreateResourceStable("beforejuergen1b.xmi");
		TypeScopeProvider qsp = mql.getInclusiveQueryScopeProvider(new URI[] { res.getURI(), res1.getURI() });

		URI uriA1 = EcoreUtil.getURI(Case001Package.Literals.A1);

		A1 a = Case001Factory.eINSTANCE.createA1();
		B1 b = Case001Factory.eINSTANCE.createB1();
		a.getBs().add(b);
		res.getContents().add(a);

		A1 a2 = Case001Factory.eINSTANCE.createA1();
		res1.getContents().add(a2);

		// ResourceIndexFeederImpl resourceSetIndexImpl = new
		// ResourceIndexFeederImpl(IIndexStore.INSTANCE);
		// resourceSetIndexImpl.index(res);
		// resourceSetIndexImpl.index(res1);

		ResultSet rs = mql.execute("select a " //
				+ "from [" + uriA1 + "] as a " //
				+ "where a.bs = null", this.getQueryContext(qsp)); //

		System.out.println(rs.toString());

		URI uriElementA = EcoreUtil.getURI(a);
		URI uriElementA2 = EcoreUtil.getURI(a2);

		assertTrue("unexpected size: " + rs.getSize(), rs.getSize() > 0);
		assertTrue("unexpected list: " + uriElementA2 + " --- " + Arrays.asList(rs.getUris("a")), Arrays.asList(rs.getUris("a")).contains(
				uriElementA2));
		assertFalse("unexpected list: " + uriElementA + " --- " + Arrays.asList(rs.getUris("a")), Arrays.asList(rs.getUris("a")).contains(
				uriElementA));
	}

	@Test
	public void testNullReferenceWithoutInstancesOfNullReferencedType() throws Exception {

		QueryProcessor mql = this.getMQLProcessor();
		Resource res = this.testClient1.getOrCreateResourceStable("beforejuergen1.xmi");
		TypeScopeProvider qspOld = mql.getInclusiveQueryScopeProvider(new URI[] { res.getURI() });
		QueryContext qsp = this.getQueryContext(qspOld);

		URI uriA1 = EcoreUtil.getURI(Case001Package.Literals.A1);
		URI uriB1 = EcoreUtil.getURI(Case001Package.Literals.B1);

		A1 a = Case001Factory.eINSTANCE.createA1();
		res.getContents().add(a);
		URI uriA = EcoreUtil.getURI(a);

		IndexerForTest.index(getDefaultIndexStore(), res);

		// just verify execution without errors:
		ResultSet rs = mql.execute("select a " //
				+ "from [" + uriA1 + "] as a " //
				+ "where a.bs in (select b from [" + uriB1 + "] as b)", qsp);
		//

		rs = mql.execute("select a " //
				+ "from [" + uriA1 + "] as a " //
				+ "where a.bs = null", qsp); //

		assertTrue("unexpected size: " + rs.getSize(), rs.getSize() > 0);
		assertTrue("unexpected list: " + uriA + " --- " + Arrays.asList(rs.getUris("a")), Arrays.asList(rs.getUris("a")).contains(uriA));

	}

	@Test
	public void reducedSubtypeQuery() {

		QueryProcessor processor = this.getMQLProcessor();
		TypeScopeProvider qspOld = processor.getInclusiveQueryScopeProvider(new URI[] { EcorePackage.eINSTANCE.eResource().getURI() });
		QueryContext qsp = this.getQueryContext(qspOld);

		URI namedElementUri = EcoreUtil.getURI(EcorePackage.Literals.ENAMED_ELEMENT);
		URI typedElementUri = EcoreUtil.getURI(EcorePackage.Literals.ETYPED_ELEMENT);
		URI classifierUri = EcoreUtil.getURI(EcorePackage.Literals.ECLASSIFIER);
		URI packageUri = EcoreUtil.getURI(EcorePackage.Literals.EPACKAGE);
		URI dataTypeUri = EcoreUtil.getURI(EcorePackage.Literals.EDATA_TYPE);
		URI classUri = EcoreUtil.getURI(EcorePackage.Literals.ECLASS);

		String query0 = "select ne from [" + namedElementUri + "] as ne";
		ResultSet resultSet0 = processor.execute(query0, qsp);
		int sizeOfAllNamedElements = resultSet0.getSize();

		String query1 = "select clf from [" + classifierUri + "] as clf";
		ResultSet resultSet1 = processor.execute(query1, qsp);
		int sizeOfAllClassifiers = resultSet1.getSize();

		String query2 = "select pck from [" + packageUri + "] as pck";
		ResultSet resultSet2 = processor.execute(query2, qsp);
		int sizeOfAllPackages = resultSet2.getSize();

		String query9 = "select te from [" + typedElementUri + "] as te";
		ResultSet resultSet9 = processor.execute(query9, qsp);
		int sizeOfAllTypedElements = resultSet9.getSize();

		String query3 = "select dt from [" + dataTypeUri + "] as dt";
		ResultSet resultSet3 = processor.execute(query3, qsp);
		int sizeOfAllDatatypes = resultSet3.getSize();

		String query7 = "select cl from [" + classUri + "] as cl";
		ResultSet resultSet7 = processor.execute(query7, qsp);
		int sizeOfAllClasses = resultSet7.getSize();

		String query4 = "select ne from [" + namedElementUri + "] withoutsubtypes {[" + classifierUri + "]} as ne";
		ResultSet resultSet4 = processor.execute(query4, qsp);
		int sizeOfAllNamedElementsMinusClassifiers = resultSet4.getSize();

		String query5 = "select ne from [" + namedElementUri + "] withoutsubtypes {[" + classifierUri + "], [" + packageUri + "]} as ne";
		ResultSet resultSet5 = processor.execute(query5, qsp);
		int sizeOfAllNamedElementsMinusClassifiersAndPackages = resultSet5.getSize();

		// String query6 = "select clf from ["
		// + classifierUri
		// +
		// "] withoutsubtypes {Model::Association, Model::PrimitiveType, Model::StructureType, Model::EnumerationType, Model::Class} as clf";
		// MQLResultSet resultSet6 = processor.execute(query6, qsp);
		// int sizeOfAllNamedElementsMinusClassifiersAndPackagesAndTypedElements
		// = resultSet6.getSize();

		String query8 = "select ne from [" + namedElementUri + "] withoutsubtypes {[" + classifierUri + "], [" + packageUri + "], ["
				+ typedElementUri + "]} as ne";
		ResultSet resultSet8 = processor.execute(query8, qsp);
		int sizeOfAllNamedElementsMinusClassifiersAndPackagesAndTypedElements = resultSet8.getSize();

		assertEquals(sizeOfAllNamedElements - sizeOfAllClassifiers, sizeOfAllNamedElementsMinusClassifiers);
		assertEquals(sizeOfAllNamedElements - (sizeOfAllClassifiers + sizeOfAllPackages), sizeOfAllNamedElementsMinusClassifiersAndPackages);
		assertEquals(sizeOfAllNamedElements - (sizeOfAllClassifiers + sizeOfAllPackages + sizeOfAllTypedElements),
				sizeOfAllNamedElementsMinusClassifiersAndPackagesAndTypedElements);
		// assertEquals(sizeOfAllClassifiersMinusAssociationsAndClasses,
		// sizeOfAllClassifiersMinusAssociationsAndClasses2);
	}

	@Test
	public void testConstantComparisonWithAllNumberTypes() throws Exception {

		QueryProcessor mql = this.getMQLProcessor();

		Resource res = this.testClient1.getOrCreateResourceStable("mql_constants_test.xmi");
		TypeScopeProvider qspOld = mql.getInclusivePartitionScopeProvider(res.getURI());
		QueryContext qsp = this.getQueryContext(qspOld);

		URI uriD4 = EcoreUtil.getURI(Case004Package.Literals.D4);

		D4 d4 = Case004Factory.eINSTANCE.createD4();

		d4.setAttributeDouble(0.0);
		d4.setAttributeFloat(0.0f);
		d4.setAttributeInteger(0);
		d4.setAttributeLong(0L);

		res.getContents().add(d4);
		URI UriD4Instance = EcoreUtil.getURI(d4);

		String queryDouble = "select d4 from [" + uriD4 + "] as d4 where d4.attributeDouble = 0.0";
		String queryDouble2 = "select d4 from [" + uriD4 + "] as d4 where d4.attributeDouble < "
				+ (((Number) Float.MAX_VALUE).doubleValue() * 2.0d);
		String queryDouble3 = "select d4 from [" + uriD4 + "] as d4 where d4.attributeDouble < " + Double.POSITIVE_INFINITY;
		String queryDouble4 = "select d4 from [" + uriD4 + "] as d4 where d4.attributeDouble > " + Double.NEGATIVE_INFINITY;
		String queryFloat = "select d4 from [" + uriD4 + "] as d4 where d4.attributeFloat = 0.0";
		String queryFloat2 = "select d4 from [" + uriD4 + "] as d4 where d4.attributeFloat = "
				+ (((Number) Float.MAX_VALUE).doubleValue() * 2.0d);
		String queryFloat3 = "select d4 from [" + uriD4 + "] as d4 where d4.attributeFloat < " + Float.POSITIVE_INFINITY;
		String queryFloat4 = "select d4 from [" + uriD4 + "] as d4 where d4.attributeFloat > " + Float.NEGATIVE_INFINITY;
		String queryFloat5 = "select d4 from [" + uriD4 + "] as d4 where d4.attributeFloat = "
				+ -(((Number) Float.MAX_VALUE).doubleValue() * 2.0d);
		String queryLong = "select d4 from [" + uriD4 + "] as d4 where d4.attributeLong = 0";
		String queryLong2 = "select d4 from [" + uriD4 + "] as d4 where d4.attributeLong < " + (Long.MAX_VALUE);
		String queryInt = "select d4 from [" + uriD4 + "] as d4 where d4.attributeInteger = 0";
		String queryInt2 = "select d4 from [" + uriD4 + "] as d4 where d4.attributeInteger = " + Long.MAX_VALUE;

		// expected exceptions
		try {
			mql.execute(queryFloat2, qsp);
			fail("Did expect exception");
		} catch (QueryFormatException e) {
			// expected
		}

		try {
			mql.execute(queryFloat3, qsp);
			fail("Did expect exception");
		} catch (QueryFormatException e) {
			// expected
		}

		try {
			mql.execute(queryFloat4, qsp);
			fail("Did expect exception");
		} catch (QueryFormatException e) {
			// expected
		}

		try {
			mql.execute(queryFloat5, qsp);
			fail("Did expect exception");
		} catch (QueryFormatException e) {
			// expected
		}

		try {
			mql.execute(queryDouble3, qsp);
			fail("Did expect exception");
		} catch (QueryFormatException e) {
			// expected
		}

		try {
			mql.execute(queryDouble4, qsp);
			fail("Did expect exception");
		} catch (QueryFormatException e) {
			// expected
		}

		try {
			mql.execute(queryInt2, qsp);
			fail("Did expect exception");
		} catch (QueryFormatException e) {
			// expected
		}

		// queries expected to be correct
		try {
			ResultSet rsDouble2 = mql.execute(queryDouble2, qsp);
			ResultSet rsDouble = mql.execute(queryDouble, qsp);
			ResultSet rsFloat = mql.execute(queryFloat, qsp);
			ResultSet rsLong = mql.execute(queryLong, qsp);
			ResultSet rsLong2 = mql.execute(queryLong2, qsp);
			ResultSet rsInt = mql.execute(queryInt, qsp);

			assertFalse(rsDouble.isEmpty());
			assertFalse(rsDouble2.isEmpty());
			assertFalse(rsFloat.isEmpty());
			assertFalse(rsLong.isEmpty());
			assertFalse(rsLong2.isEmpty());
			assertFalse(rsInt.isEmpty());

			assertTrue(Arrays.asList(rsDouble.getUris("d4")).contains(UriD4Instance));
			assertTrue(Arrays.asList(rsDouble2.getUris("d4")).contains(UriD4Instance));
			assertTrue(Arrays.asList(rsFloat.getUris("d4")).contains(UriD4Instance));
			assertTrue(Arrays.asList(rsLong.getUris("d4")).contains(UriD4Instance));
			assertTrue(Arrays.asList(rsLong2.getUris("d4")).contains(UriD4Instance));
			assertTrue(Arrays.asList(rsInt.getUris("d4")).contains(UriD4Instance));

		} catch (QueryFormatException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}

		// mp.delete();
		// this.testClient1.getConnection().save();
	}

	@Test
	public void testObjectValueComparison() throws IOException {

		QueryProcessor mql = this.getMQLProcessor();

		Resource res = this.testClient1.getOrCreateResourceStable("QueryRegressionTests_objValueComp.xmi");
		TypeScopeProvider qspOld = mql.getInclusivePartitionScopeProvider(res.getURI());
		QueryContext qsp = this.getQueryContext(qspOld);

		URI uriA1 = EcoreUtil.getURI(Case001Package.Literals.A1);
		URI uriB2 = EcoreUtil.getURI(Case001Package.Literals.B1);

		String query = "select a, b " // //$NON-NLS-1$
				+ "from [" + uriA1 + "] as a, [" + uriB2 + "] as b " // //$NON-NLS-1$
				+ "where a.bs = b"; //  //$NON-NLS-1$

		ResultSet rsBefore = mql.execute(query, qsp);
		int sizeBeforeTest = rsBefore.getSize();
		rsBefore = null;

		A1 a1_1 = Case001Factory.eINSTANCE.createA1();

		B1 b1_1 = Case001Factory.eINSTANCE.createB1();
		B1 b1_2 = Case001Factory.eINSTANCE.createB1();
		B1 b1_3 = Case001Factory.eINSTANCE.createB1();
		B1 b1_4 = Case001Factory.eINSTANCE.createB1();

		a1_1.getBs().add(b1_1);
		a1_1.getBs().add(b1_2);
		a1_1.getBs().add(b1_3);
		a1_1.getBs().add(b1_4);

		res.getContents().add(a1_1);

		IndexerForTest.index(getDefaultIndexStore(), res);
		// res.save(null);

		ResultSet rs = mql.execute(query, qsp);

		assertEquals("Unexpected rs size", a1_1.getBs().size() + sizeBeforeTest, rs.getSize()); //$NON-NLS-1$
		assertTrue(Arrays.asList(rs.getUris("a")).contains(EcoreUtil.getURI(a1_1))); //$NON-NLS-1$
		assertTrue(Arrays.asList(rs.getUris("b")).contains(EcoreUtil.getURI(b1_1))); //$NON-NLS-1$
		assertTrue(Arrays.asList(rs.getUris("b")).contains(EcoreUtil.getURI(b1_2))); //$NON-NLS-1$
		assertTrue(Arrays.asList(rs.getUris("b")).contains(EcoreUtil.getURI(b1_3))); //$NON-NLS-1$
		assertTrue(Arrays.asList(rs.getUris("b")).contains(EcoreUtil.getURI(b1_4))); //$NON-NLS-1$

		// res.save(null);
	}

	@Test
	public void testObjectValueComparisonAndAttrComparison() throws IOException {

		QueryProcessor mql = this.getMQLProcessor();

		Resource res = this.testClient1.getOrCreateResourceStable("QueryRegressionTests_objValueCompAndAttrComp.xmi");
		TypeScopeProvider qspOld = mql.getInclusivePartitionScopeProvider(res.getURI());
		QueryContext qsp = this.getQueryContext(qspOld);

		URI uriA4 = EcoreUtil.getURI(Case004Package.Literals.A4);
		URI uriB4 = EcoreUtil.getURI(Case004Package.Literals.B4);

		String query = "select a " // //$NON-NLS-1$
				+ "from [" + uriA4 + "] as a, [" + uriB4 + "] as b " // //$NON-NLS-1$
				+ "where a.manyBs = b " // //$NON-NLS-1$
				+ "where for b(onePrimitive like '*_*')"; //  //$NON-NLS-1$

		ResultSet rsBefore = mql.execute(query, qsp);
		int sizeBeforeTest = rsBefore.getSize();
		rsBefore = null;

		A4 a_1 = Case004Factory.eINSTANCE.createA4();

		B4 b_1 = Case004Factory.eINSTANCE.createB4();
		B4 b_2 = Case004Factory.eINSTANCE.createB4();
		B4 b_3 = Case004Factory.eINSTANCE.createB4();
		B4 b_4 = Case004Factory.eINSTANCE.createB4();

		b_1.setOnePrimitive("b_1"); //$NON-NLS-1$
		b_2.setOnePrimitive("b_2"); //$NON-NLS-1$
		b_3.setOnePrimitive("b_3"); //$NON-NLS-1$
		b_4.setOnePrimitive("b_4"); //$NON-NLS-1$

		a_1.getManyBs().add(b_1);
		a_1.getManyBs().add(b_2);
		a_1.getManyBs().add(b_3);
		a_1.getManyBs().add(b_4);

		res.getContents().add(a_1);
		// res.getContents().add(b_1);
		// res.getContents().add(b_2);
		// res.getContents().add(b_3);
		// res.getContents().add(b_4);

		IndexerForTest.index(getDefaultIndexStore(), res);
		// res.save(null);

		ResultSet rs = mql.execute(query, qsp);

		System.out.println(rs);
		System.out.println(a_1.getManyBs());

		assertEquals("Unexpected rs size", a_1.getManyBs().size() + sizeBeforeTest, rs.getSize()); //$NON-NLS-1$
		assertTrue(Arrays.asList(rs.getUris("a")).contains(EcoreUtil.getURI(a_1))); //$NON-NLS-1$

		// res.delete(null);
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
				return TestQueryRegression.this.testClient1.getResourceSet();
			}

		};
	}

	@Test
	public void testUriAcceptance() throws Exception {
		try {
			QueryProcessor mql = this.getMQLProcessor();
			String query = "select a from [" + EcoreUtil.getURI(Case004Package.Literals.A4)
					+ "] as a in elements{[http://a@b.c:80/as düf~4_sa\u0123s%20ac\\]d\\\\fd#fragment]}";
			System.out.println(query);
			mql.execute(query, this.getQueryContext(null));
		} catch (QueryFormatException e) {
			fail(e.getMessage());
		} catch (Exception e) {
		}
	}

	@Test
	public void testNotInEmptySubquery() throws Exception {
		QueryProcessor mql = this.getMQLProcessor();

		Resource res = this.testClient1.getOrCreateResourceStable("QueryRegressionTests_testNotInEmptySubquery.xmi");
		TypeScopeProvider qspOld = mql.getInclusivePartitionScopeProvider(res.getURI());
		QueryContext qsp = this.getQueryContext(qspOld);

		URI uriA4 = EcoreUtil.getURI(Case004Package.Literals.A4);
		URI uriB4 = EcoreUtil.getURI(Case004Package.Literals.B4);

		A4 a_1 = Case004Factory.eINSTANCE.createA4();
		res.getContents().clear();
		res.getContents().add(a_1);
		res.save(null);

		IndexerForTest.index(getDefaultIndexStore(), res);
		res.unload();

		String query = String.format("select a from [%s] as a where a.manyBs not in (select b from [%s] as b)", uriA4, uriB4);

		ResultSet rs = mql.execute(query, qsp);

		assertEquals(1, rs.getSize());
		assertEquals(EcoreUtil.getURI(a_1), rs.getUri(0, "a"));

		IndexerForTest.delete(getDefaultIndexStore(), res.getURI());

		res.delete(null);
	}

	@Test
	public void testUnassignedEObject() throws Exception {
		QueryProcessor mql = this.getMQLProcessor();

		Resource res = this.testClient1.getOrCreateResourceStable("QueryRegressionTests_testUnassignedEObject.xmi");
		TypeScopeProvider qspOld = mql.getInclusivePartitionScopeProvider(res.getURI());
		QueryContext qsp = this.getQueryContext(qspOld);

		URI uriC2 = EcoreUtil.getURI(Case002Package.Literals.C2);
		URI uriB2 = EcoreUtil.getURI(Case002Package.Literals.B2);

		C2 c2 = Case002Factory.eINSTANCE.createC2();
		B2 b2 = Case002Factory.eINSTANCE.createB2();
		B2 b2fake = Case002Factory.eINSTANCE.createB2();

		res.getContents().clear();
		res.getContents().add(c2);
		res.getContents().add(b2fake);
		c2.setB(b2);

		String query = String.format("select c from [%s] as c, [%s] as b where c.b = b", uriC2, uriB2);

		ResultSet rs = mql.execute(query, qsp);

		assertEquals(0, rs.getSize());

	}
}
