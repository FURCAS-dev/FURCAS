package com.sap.ide.cts.editor.prettyprint;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import generated.TCSLexer;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import tcs.ClassTemplate;
import tcs.TcsPackage;
import tcs.Template;

import com.sap.ide.cts.editor.test.util.ConcreteSyntaxBasedTest;
import com.sap.mi.textual.tcs.util.TcsUtil;

public class MOINImportedModelAdapterTest extends ConcreteSyntaxBasedTest {

	MOINImportedModelAdapter adapter;
	TcsPackage pck;

	@Before
	public void initAdapter() {
		initMetamodelId("demo.sap.com/tcsmeta");
		initSyntax(TCSLexer.class.getResourceAsStream("TCS.tcs"));
		pck = connection.getPackage(TcsPackage.PACKAGE_DESCRIPTOR);
	}

	@Test
	public void testGet() {

		assertEquals(syntax.getLexer(), MOINImportedModelAdapter.get(syntax,
				"lexer"));
	}

	@Test
	public void testGetBool() {
		ClassTemplate main = TcsUtil.getMainClassTemplate(syntax);
		assertEquals(main.isMain(), MOINImportedModelAdapter.getBool(main,
				"isMain"));
	}

	@Test
	public void testGetBoolUndefinedIsFalse() {
		ClassTemplate temp = (ClassTemplate) pck.getClassTemplate()
				.refCreateInstance();
		temp.setMode(null);
		assertEquals(false, MOINImportedModelAdapter.getBoolUndefinedIsFalse(
				temp, "mode"));
	}

	@Test
	public void testGetCol() {
		Iterator<Template> start = syntax.getTemplates().iterator();
		Object next = start.next();
		assertEquals(next, MOINImportedModelAdapter.getCol(syntax, "templates")
				.next());
	}

	@Ignore
	@Test
	public void testGetEnumLiteralName() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testGetInt() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testGetME() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testGetMetaobject() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testGetName() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testGetString() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testGetTypeName() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testIsAModelElement() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testIsEnumLiteral() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testIsPrimitive() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testNextString() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testRefImmediateComposite() {
		fail("Not yet implemented");
	}

}