package org.eclipse.emf.query2.syntax.test;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.query2.LocalWhereEntry;
import org.eclipse.emf.query2.Operation;
import org.eclipse.emf.query2.Query;
import org.eclipse.emf.query2.QueryStandaloneSetup;
import org.eclipse.emf.query2.SelectAttrs;
import org.eclipse.emf.query2.WhereClause;
import org.eclipse.emf.query2.WhereEntry;
import org.eclipse.emf.query2.WhereString;
import org.eclipse.emf.query2.query.FromEntry;
import org.eclipse.emf.query2.query.MQLquery;
import org.eclipse.emf.query2.query.Model;
import org.eclipse.emf.query2.query.NamedQuery;
import org.eclipse.emf.query2.query.QueryFactory;
import org.eclipse.emf.query2.query.QueryPackage;
import org.eclipse.emf.query2.query.SelectEntry;
import org.eclipse.emf.query2.query.StringAttributeWhereEntry;
import org.eclipse.emf.query2.query.StringOperator;
import org.eclipse.emf.query2.transformation.QueryTransformer;
import org.eclipse.xtext.linking.lazy.LazyLinkingResource;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.google.inject.Injector;

public class TestTransformation extends Assert {

	private static Model model;

	@BeforeClass
	public static void setup() {
		new org.eclipse.emf.mwe.utils.StandaloneSetup().setPlatformUri("..");
		Injector injector = new QueryStandaloneSetup().createInjectorAndDoEMFRegistration();

		XtextResourceSet set = injector.getInstance(XtextResourceSet.class);
		set.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
		URI resourceURI = URI.createURI("platform:/resource/org.eclipse.emf.query2.syntax.test/test/testSimpleTrafo.query");
		URI normalized = set.getURIConverter().normalize(resourceURI);
		LazyLinkingResource xtextResource = (LazyLinkingResource) set.getResource(normalized, true);
		model = (Model) xtextResource.getContents().get(0);

	}

	private MQLquery findQuery(String queryName) {
		if (queryName == null) {
			return model.getDefaultQuery();
		}
		for (NamedQuery query : model.getNamedQueries()) {
			if (query.getName().equals(queryName)) {
				return query.getQuery();
			}
		}
		return null;
	}

	private String doTransformation(String queryName) {
		MQLquery query = findQuery(queryName);
		Query transform = QueryTransformer.transform(query);
		String string = transform.toString().replaceAll("\\n", " ").trim();
		return string;
	}

	@Test
	public void testSelectEClass() throws Exception {
		String string = doTransformation("SelectEClass");
		assertEquals("select a from type: platform:/resource/org.eclipse.emf.query2.syntax.test/model/Ecore.ecore#//EClass as a", string);
	}

	@Test
	public void testSelectEClassWhereNameEqualsEAttribute() {
		String string = doTransformation("SelectEClassWhereNameEqualsEAttribute");
		assertEquals("select a from type: platform:/resource/org.eclipse.emf.query2.syntax.test/model/Ecore.ecore#//EClass as a "
				+ "where for a(name EQUAL 'EAttribute')", string);
	}

	@Test
	public void testSelectAttrTwoWhereAnd() {
		String string = doTransformation("SelectAttrTwoWhereAnd");
		assertEquals("select a.name from type: platform:/resource/org.eclipse.emf.query2.syntax.test/model/Ecore.ecore#//EClass as a "
				+ "where for a(name EQUAL 'EAttribute') " + "where for a(abstract EQUAL true)", string);
	}

	@Test
	public void testSelectAttrWhereAttrLong() {
		String string = doTransformation("SelectAttrWhereAttrLong");
		assertEquals(
				"select a.lowerBound from type: platform:/resource/org.eclipse.emf.query2.syntax.test/model/Ecore.ecore#//ETypedElement as a "
						+ "where for a(upperBound SMALLER 5)", string);
	}

	@Test
	public void testSelectAttrWhereAttrVar() {
		String string = doTransformation("SelectAttrWhereAttrVar");
		assertEquals("select a.lowerBound,        b.upperBound "
				+ "from type: platform:/resource/org.eclipse.emf.query2.syntax.test/model/Ecore.ecore#//ETypedElement as a,      "
				+ "type: platform:/resource/org.eclipse.emf.query2.syntax.test/model/Ecore.ecore#//ETypedElement as b "
				+ "where b.upperBound >= a.lowerBound", string);
	}

	@Test
	public void testSelectAttrWhereAttrNull() {
		String string = doTransformation("SelectAttrWhereAttrNull");
		assertEquals(
				"select a.lowerBound from type: platform:/resource/org.eclipse.emf.query2.syntax.test/model/Ecore.ecore#//ETypedElement as a "
						+ "where for a(lowerBound EQUAL null)", string);
	}

	@Test
	public void testSelectEClassWhereRefNull() {
		String string = doTransformation("SelectEClassWhereRefNull");
		assertEquals("select a from type: platform:/resource/org.eclipse.emf.query2.syntax.test/model/Ecore.ecore#//EClass as a "
				+ "where for a(eOperations EQUAL null)", string);
	}

	@Test
	public void testSelectAttrTwoWhereOr() {
		String string = doTransformation("SelectAttrTwoWhereOr");
		assertEquals(
				"select a.name from type: platform:/resource/org.eclipse.emf.query2.syntax.test/model/Ecore.ecore#//EClass as a where for a(or (name EQUAL 'EAttribute', abstract EQUAL true))",
				string);
	}

	@Test
	public void testSelectAttrThreeWhereOr() {
		String string = doTransformation("SelectAttrThreeWhereOr");
		assertEquals(
				"select a.name from type: platform:/resource/org.eclipse.emf.query2.syntax.test/model/Ecore.ecore#//EClass as a where for a(or (name EQUAL 'EAttribute', abstract EQUAL true, abstract EQUAL true, interface EQUAL true))",
				string);
	}

	@Test
	public void testSelectAttrThreeWhereAnd() {
		String string = doTransformation("SelectAttrThreeWhereAnd");
		System.out.println(string);
		assertEquals(
				"select a.name from type: platform:/resource/org.eclipse.emf.query2.syntax.test/model/Ecore.ecore#//EClass as a where for a(name EQUAL 'EAttribute') where for a(abstract EQUAL true) where for a(abstract EQUAL true) where for a(interface EQUAL true)",
				string);
	}

	@Test
	public void testSelectAttrThreeWhereOrAnd() {
		String string = doTransformation("SelectAttrThreeWhereOrAnd");
		assertEquals(
				"select a.name from type: platform:/resource/org.eclipse.emf.query2.syntax.test/model/Ecore.ecore#//EClass as a where for a(or (name EQUAL 'EAttribute', and (abstract EQUAL true, interface EQUAL true)))",
				string);
	}

	@Ignore
	@Test
	public void testSimpleTransformation() throws Exception {
		MQLquery query = QueryFactory.eINSTANCE.createMQLquery();

		String fromAlias1 = "selectAlias";
		String fromAlias2 = "fromAlias";

		// FROM ENTRIES
		FromEntry fromEntry1 = QueryFactory.eINSTANCE.createFromEntry();
		fromEntry1.setAlias(fromAlias1);
		fromEntry1.setType(QueryPackage.eINSTANCE.getSelectEntry());

		FromEntry fromEntry2 = QueryFactory.eINSTANCE.createFromEntry();
		fromEntry2.setAlias(fromAlias2);
		fromEntry2.setType(QueryPackage.eINSTANCE.getFromEntry());

		// SELECT ENTRIES
		SelectEntry selectEntry1 = QueryFactory.eINSTANCE.createSelectEntry();
		selectEntry1.setSelect(fromEntry1);

		SelectEntry selectEntry2 = QueryFactory.eINSTANCE.createSelectEntry();
		selectEntry2.setSelect(fromEntry2);
		selectEntry2.setAttribute(QueryPackage.eINSTANCE.getFromEntry_Alias());

		// WHERE ENTRIES
		StringAttributeWhereEntry whereEntry = QueryFactory.eINSTANCE.createStringAttributeWhereEntry();
		whereEntry.setAlias(fromEntry2);
		whereEntry.setAttribute(QueryPackage.eINSTANCE.getFromEntry_Alias());
		whereEntry.setOperator(StringOperator.EQUAL);
		whereEntry.setPattern(fromAlias1);

		query.getFromEntries().add(fromEntry1);
		query.getFromEntries().add(fromEntry2);
		query.getSelectEntries().add(selectEntry1);
		query.getSelectEntries().add(selectEntry2);
		query.setWhereEntry(whereEntry);

		Query transform = QueryTransformer.transform(query);

		System.out.println(transform);

		org.eclipse.emf.query2.SelectEntry[] selectEntries = transform.getSelectEntries();
		org.eclipse.emf.query2.FromEntry[] fromEntries = transform.getFromEntries();
		WhereEntry[] whereEntries = transform.getWhereEntries();

		assertEquals(2, selectEntries.length);
		assertEquals(2, fromEntries.length);
		assertEquals(1, whereEntries.length);

		assertEquals(fromAlias1, selectEntries[0].getAliasName());
		assertEquals(fromAlias2, selectEntries[1].getAliasName());

		assertEquals(QueryPackage.eINSTANCE.getFromEntry_Alias().getName(), ((SelectAttrs) selectEntries[1]).getAttrNames()[0]);

		assertEquals(fromAlias1, fromEntries[0].getAliasName());
		assertEquals(fromAlias2, fromEntries[1].getAliasName());

		assertTrue(whereEntries[0] instanceof LocalWhereEntry);

		LocalWhereEntry localWhereEntry = (LocalWhereEntry) whereEntries[0];

		assertEquals(fromAlias2, localWhereEntry.getLeftAlias());

		WhereClause whereClause = localWhereEntry.getNestedClause();

		assertTrue(whereClause instanceof WhereString);

		WhereString whereClauseString = (WhereString) whereClause;

		assertEquals(QueryPackage.eINSTANCE.getFromEntry_Alias().getName(), whereClauseString.getAttrName());
		assertEquals(Operation.EQUAL, whereClauseString.getOperation());
		assertEquals(fromAlias1, whereClauseString.getStringValue());

	}

}
