package org.eclipse.emf.query2.syntax.test;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.query2.LocalWhereEntry;
import org.eclipse.emf.query2.Operation;
import org.eclipse.emf.query2.Query;
import org.eclipse.emf.query2.SelectAttrs;
import org.eclipse.emf.query2.WhereClause;
import org.eclipse.emf.query2.WhereEntry;
import org.eclipse.emf.query2.WhereString;
import org.eclipse.emf.query2.syntax.QueryStandaloneSetup;
import org.eclipse.emf.query2.syntax.query.AliasAttributeExpression;
import org.eclipse.emf.query2.syntax.query.ExpressionWhereEntry;
import org.eclipse.emf.query2.syntax.query.FromEntry;
import org.eclipse.emf.query2.syntax.query.MQLquery;
import org.eclipse.emf.query2.syntax.query.Model;
import org.eclipse.emf.query2.syntax.query.NamedQuery;
import org.eclipse.emf.query2.syntax.query.Operator;
import org.eclipse.emf.query2.syntax.query.QueryFactory;
import org.eclipse.emf.query2.syntax.query.QueryPackage;
import org.eclipse.emf.query2.syntax.query.SelectEntry;
import org.eclipse.emf.query2.syntax.query.StringExpression;
import org.eclipse.emf.query2.syntax.transformation.QueryTransformer;
import org.eclipse.xtext.linking.lazy.LazyLinkingResource;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.inject.Injector;

public class TestTransformation extends Assert {

	private static final String RESOURCE = "/resource/"; //$NON-NLS-1$
	private static final String PLUGIN = "/plugin/"; //$NON-NLS-1$

	private static Model model;

	private static String loadLocation = PLUGIN;
	
	@BeforeClass
	public static void setup() {
		new org.eclipse.emf.mwe.utils.StandaloneSetup().setPlatformUri(".."); //$NON-NLS-1$
		Injector injector = new QueryStandaloneSetup().createInjectorAndDoEMFRegistration();

		XtextResourceSet set = injector.getInstance(XtextResourceSet.class);
		set.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
		URI resourceURI = URI.createURI("platform:"+loadLocation+"org.eclipse.emf.query2.syntax.test/test/testSimpleTrafo.query"); //$NON-NLS-1$ //$NON-NLS-2$
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
		String string = transform.toString().replaceAll("\\n", " ").trim(); //$NON-NLS-1$ //$NON-NLS-2$
		return string;
	}
	
	private String doTransformation(String queryName, Object[] parameters) {
		MQLquery query = findQuery(queryName);
		Query transform = QueryTransformer.transform(query, parameters);
		String string = transform.toString().replaceAll("\\n", " ").trim(); //$NON-NLS-1$ //$NON-NLS-2$
		return string;
	}

	@Test
	public void testSelectEClass() throws Exception {
		String string = doTransformation("SelectEClass"); //$NON-NLS-1$
		assertEquals("select a from type: platform:"+loadLocation+"org.eclipse.emf.query2.syntax.test/model/Ecore.ecore#//EClass as a", string); //$NON-NLS-1$ //$NON-NLS-2$
	}

	@Test
	public void testSelectEClassWhereNameEqualsEAttribute() {
		String string = doTransformation("SelectEClassWhereNameEqualsEAttribute"); //$NON-NLS-1$
		assertEquals("select a from type: platform:"+loadLocation+"org.eclipse.emf.query2.syntax.test/model/Ecore.ecore#//EClass as a " //$NON-NLS-1$ //$NON-NLS-2$
				+ "where for a(name EQUAL 'EAttribute')", string); //$NON-NLS-1$
	}

	@Test
	public void testSelectAttrTwoWhereAnd() {
		String string = doTransformation("SelectAttrTwoWhereAnd"); //$NON-NLS-1$
		assertEquals("select a.name from type: platform:"+loadLocation+"org.eclipse.emf.query2.syntax.test/model/Ecore.ecore#//EClass as a " //$NON-NLS-1$ //$NON-NLS-2$
				+ "where for a(name EQUAL 'EAttribute') " + "where for a(abstract EQUAL true)", string); //$NON-NLS-1$ //$NON-NLS-2$
	}

	@Test
	public void testSelectAttrWhereAttrLong() {
		String string = doTransformation("SelectAttrWhereAttrLong"); //$NON-NLS-1$
		assertEquals(
				"select a.lowerBound from type: platform:"+loadLocation+"org.eclipse.emf.query2.syntax.test/model/Ecore.ecore#//ETypedElement as a " //$NON-NLS-1$ //$NON-NLS-2$
						+ "where for a(upperBound SMALLER 5)", string); //$NON-NLS-1$
	}

	@Test
	public void testSelectAttrWhereAttrVar() {
		String string = doTransformation("SelectAttrWhereAttrVar"); //$NON-NLS-1$
		assertEquals("select a.lowerBound,        b.upperBound " //$NON-NLS-1$
				+ "from type: platform:"+loadLocation+"org.eclipse.emf.query2.syntax.test/model/Ecore.ecore#//ETypedElement as a,      " //$NON-NLS-1$ //$NON-NLS-2$
				+ "type: platform:"+loadLocation+"org.eclipse.emf.query2.syntax.test/model/Ecore.ecore#//ETypedElement as b " //$NON-NLS-1$ //$NON-NLS-2$
				+ "where b.upperBound >= a.lowerBound", string); //$NON-NLS-1$
	}

	@Test
	public void testSelectAttrWhereAttrNull() {
		String string = doTransformation("SelectAttrWhereAttrNull"); //$NON-NLS-1$
		assertEquals(
				"select a.lowerBound from type: platform:"+loadLocation+"org.eclipse.emf.query2.syntax.test/model/Ecore.ecore#//ETypedElement as a " //$NON-NLS-1$ //$NON-NLS-2$
						+ "where for a(eType EQUAL null)", string); //$NON-NLS-1$
	}

	@Test
	public void testSelectEClassWhereRefNull() {
		String string = doTransformation("SelectEClassWhereRefNull"); //$NON-NLS-1$
		assertEquals("select a from type: platform:"+loadLocation+"org.eclipse.emf.query2.syntax.test/model/Ecore.ecore#//EClass as a " //$NON-NLS-1$ //$NON-NLS-2$
				+ "where for a(eOperations EQUAL null)", string); //$NON-NLS-1$
	}

	@Test
	public void testSelectAttrTwoWhereOr() {
		String string = doTransformation("SelectAttrTwoWhereOr"); //$NON-NLS-1$
		assertEquals(
				"select a.name from type: platform:"+loadLocation+"org.eclipse.emf.query2.syntax.test/model/Ecore.ecore#//EClass as a where for a(or (name EQUAL 'EAttribute', abstract EQUAL true))", //$NON-NLS-1$ //$NON-NLS-2$
				string);
	}

	@Test
	public void testSelectAttrThreeWhereOr() {
		String string = doTransformation("SelectAttrThreeWhereOr"); //$NON-NLS-1$
		assertEquals(
				"select a.name from type: platform:"+loadLocation+"org.eclipse.emf.query2.syntax.test/model/Ecore.ecore#//EClass as a where for a(or (name EQUAL 'EAttribute', abstract EQUAL true, abstract EQUAL true, interface EQUAL true))", //$NON-NLS-1$ //$NON-NLS-2$
				string);
	}

	@Test
	public void testSelectAttrThreeWhereAnd() {
		String string = doTransformation("SelectAttrThreeWhereAnd"); //$NON-NLS-1$
		assertEquals(
				"select a.name from type: platform:"+loadLocation+"org.eclipse.emf.query2.syntax.test/model/Ecore.ecore#//EClass as a where for a(name EQUAL 'EAttribute') where for a(abstract EQUAL true) where for a(abstract EQUAL true) where for a(interface EQUAL true)", //$NON-NLS-1$ //$NON-NLS-2$
				string);
	}

	@Test
	public void testSelectAttrThreeWhereOrAnd() {
		String string = doTransformation("SelectAttrThreeWhereOrAnd"); //$NON-NLS-1$
		assertEquals(
				"select a.name from type: platform:"+loadLocation+"org.eclipse.emf.query2.syntax.test/model/Ecore.ecore#//EClass as a where for a(or (name EQUAL 'EAttribute', and (abstract EQUAL true, interface EQUAL true)))", //$NON-NLS-1$ //$NON-NLS-2$
				string);
	}

	@Test
	public void testSelectPar() {
		String string = doTransformation("SelectPar"); //$NON-NLS-1$
		assertEquals(
				"select a.name from type: platform:"+loadLocation+"org.eclipse.emf.query2.syntax.test/model/Ecore.ecore#//EClass as a where for a(or (name EQUAL 'EAttribute', abstract EQUAL true)) where for a(interface EQUAL true)", //$NON-NLS-1$ //$NON-NLS-2$
				string);
	}
	
	@Test
	public void testSelectPar2() {
		String string = doTransformation("SelectPar2"); //$NON-NLS-1$
		assertEquals(
				"select a.name from type: platform:"+loadLocation+"org.eclipse.emf.query2.syntax.test/model/Ecore.ecore#//EClass as a where for a(or (name EQUAL 'EAttribute', and (abstract EQUAL true, interface EQUAL true)))", //$NON-NLS-1$ //$NON-NLS-2$
				string);
	}


	@Test
	public void testSelectPar2AsParameter() {
		Object[] parameters = new Object[] { "EAttribute", true, true } ; //$NON-NLS-1$
		String string = doTransformation("SelectPar2AsParameter", parameters); //$NON-NLS-1$
		assertEquals(
				"select a.name from type: platform:"+loadLocation+"org.eclipse.emf.query2.syntax.test/model/Ecore.ecore#//EClass as a where for a(or (name EQUAL 'EAttribute', and (abstract EQUAL true, interface EQUAL true)))", //$NON-NLS-1$ //$NON-NLS-2$
				string);
	}
	
	@Test
	public void testSimpleTransformation() throws Exception {
		MQLquery query = QueryFactory.eINSTANCE.createMQLquery();

		String fromAlias1 = "selectAlias"; //$NON-NLS-1$
		String fromAlias2 = "fromAlias"; //$NON-NLS-1$

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
		ExpressionWhereEntry whereEntry = QueryFactory.eINSTANCE.createExpressionWhereEntry();
		AliasAttributeExpression lhs = QueryFactory.eINSTANCE.createAliasAttributeExpression();
		lhs.setAlias(fromEntry2);
		lhs.setAttribute(QueryPackage.eINSTANCE.getFromEntry_Alias());
		
		StringExpression rhs = QueryFactory.eINSTANCE.createStringExpression();
		rhs.setValue(fromAlias1);
		
		whereEntry.setLhs(lhs);
		whereEntry.setOperator(Operator.EQUAL);
		whereEntry.setRhs(rhs);
		
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
