package com.sap.mi.textual.test.scenarios;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.test.parsing.base.ExtendedGeneratedParserBasedTest;
import com.sap.furcas.test.parsing.base.StubModelElement;
import com.sap.furcas.test.util.EcoreMetaModelLookUp;
import com.sap.furcas.test.util.StubModelAdapter;
import com.sap.ide.cts.editor.test.util.ParserGenerationTestHelper;

/**
 * Simple Test for the custom Expression language
 */
public class EnumTestAutomatic extends ExtendedGeneratedParserBasedTest {

	private static final String LANGUAGE = "EnumTestAutomatic";

	
	@BeforeClass
	public static void setupParser() throws Exception {
		setParserGenerationTestHelper(ParserGenerationTestHelper.getDefault());
		setLookup(new EcoreMetaModelLookUp("Enumeration.ecore"));
		generateParserForLanguage(LANGUAGE);
	}


	/**
	 * test syntax errors cause parsing errors
	 * @throws Exception
	 */
	@Test
	public void testSampleDirect() throws Exception {

	    StubModelAdapter stubModelHandler = parseString("mars with speed slow", LANGUAGE,  0);

	    Set<StubModelElement> expressions = stubModelHandler.getElementsbyType("enumtest::PlanetExpression");
        assertEquals(1, expressions.size());
        StubModelElement element = expressions.iterator().next();
        StubModelElement planet = (StubModelElement) element.get("planet");
        assertEquals("mars", planet.type);
        StubModelElement speed = (StubModelElement) element.get("speed");
        assertEquals("slow", speed.type);
	}
}