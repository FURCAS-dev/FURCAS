package com.sap.mi.textual.test.scenarios;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.sap.furcas.runtime.common.exceptions.GrammarGenerationException;
import com.sap.furcas.runtime.common.exceptions.ModelAdapterException;
import com.sap.furcas.runtime.common.interfaces.IMetaModelLookup;
import com.sap.furcas.runtime.parser.exceptions.SyntaxParsingException;
import com.sap.mi.textual.test.util.EcoreMetaLookUp;
import com.sap.mi.textual.test.util.StubModelAdapter;


/**
 * util class to run parsing tests with manually manipulated ANTLR grammar instead of generated one.
 * @author C5107456
 *
 */
public class PartialTest extends ExtendedGeneratedParserBasedTest {

	private static final String DSLSAMPLEDIR = "./scenarioTestSample/";
	private static final String LANGUAGE = "XPath";
	private static IMetaModelLookup lookup;
	
	@Before
	public void testXPathGenerationOnly() throws FileNotFoundException, SyntaxParsingException, ModelAdapterException, GrammarGenerationException, IOException {
	    lookup = new EcoreMetaLookUp( "XPath1.ecore", "XPath1.ecore");
	    super.generateAndCompileParser(LANGUAGE);
	}
	
	@Ignore
	@Test
	public void testSample1() throws Exception {
		
		StubModelAdapter stubModelHandler = parseFile("XPathSample01.sam", LANGUAGE, DSLSAMPLEDIR);
		 stubModelHandler = parseFile("XPathSample02.sam", LANGUAGE, DSLSAMPLEDIR, 0);
		
	}
	
}
