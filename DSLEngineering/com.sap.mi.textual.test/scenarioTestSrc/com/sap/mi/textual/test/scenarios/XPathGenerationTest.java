package com.sap.mi.textual.test.scenarios;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.textual.common.exceptions.GrammarGenerationException;
import com.sap.furcas.textual.common.exceptions.ModelAdapterException;
import com.sap.furcas.textual.common.interfaces.IMetaModelLookup;
import com.sap.ide.cts.editor.test.util.ParserGenerationTestHelper;
import com.sap.mi.textual.grammar.exceptions.SyntaxParsingException;
import com.sap.mi.textual.test.util.EcoreMetaLookUp;

/**
 * Tests currently fail for unknown reason, maybe tcs syntax is corrupt
 */
public class XPathGenerationTest extends ExtendedGeneratedParserBasedTest {


	private static final String DSLSAMPLEDIR = "./scenarioTestSample/";
	private static final String LANGUAGE = "XPath";
	private static IMetaModelLookup lookup;

	
	@BeforeClass
	public static void setupParser() throws Exception {
		setParserGenerationTestHelper(ParserGenerationTestHelper.getDefault());
		setLookup(new EcoreMetaLookUp("XPath1.ecore", "XPath.ecore"));
		generateParserForLanguage(LANGUAGE);
	}
	
	
	@Test
	public void testSample1() throws Exception {
		
		parseFile("XPathSample01.sam", LANGUAGE, DSLSAMPLEDIR);
		
	}
	
	@Test
	public void testSample2() throws Exception {
		
		parseFile("XPathSample02.sam", LANGUAGE, DSLSAMPLEDIR, 0);
		
	}
}
