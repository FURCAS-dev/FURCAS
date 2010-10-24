package com.sap.furcas.parsergenerator.tcs.scenario;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.test.parsing.base.EcoreMetaModelLookUp;
import com.sap.furcas.test.parsing.base.ExtendedGeneratedParserBasedTest;
import com.sap.furcas.test.parsing.base.ParserGenerationTestHelper;
import com.sap.furcas.test.parsing.base.StubModelAdapter;
import com.sap.furcas.test.parsing.base.StubModelElement;

/**
 * Simple Test for the custom BibText language, using a syntax variant with function templates
 */
public class BibTextWithFunctionTest extends ExtendedGeneratedParserBasedTest {


	private static final String DSLSAMPLEDIR = "./scenarioTestSample/";
	private static final String LANGUAGE = "BibtextWithFunction";

	
	@BeforeClass
	public static void setupParser() throws Exception {
		setParserGenerationTestHelper(ParserGenerationTestHelper.getDefault());
		setLookup(new EcoreMetaModelLookUp("BibText.ecore", "BibText1.ecore"));
		generateParserForLanguage(LANGUAGE);
	}
	
	
	/**
	 * Tests references are set, this protects against bugs relating to naming of classes.
	 * @throws Exception
	 */
	@Test
    public void testReferences() throws Exception {
	    String sample = "article{" + 
	    		"  Testing, \"John Doe\"," + 
	    		"  year = \"2002\"" + 
	    		"}" + 
	    		"author = testKey, \"John Doe\"." 
	    		;
	    StubModelAdapter stubModelHandler = parseString(sample, LANGUAGE, 0);
	    Set<StubModelElement> authors = stubModelHandler.getElementsbyType("BibText::Author");
        assertEquals(1, authors.size());
        StubModelElement johnDoe = authors.iterator().next();
        
        Set<StubModelElement> articles = stubModelHandler.getElementsbyType("BibText::Article");
        assertEquals(1, articles.size());
        StubModelElement article = articles.iterator().next();
        
        // now check the reference was set using the right property name
//        assertNotNull(johnDoe.get("articles")); StubModelHandler not powerful enough
        assertNotNull(article.get("author"));
        
        assertEquals(johnDoe, article.get("author"));
        
        assertEquals("testKey", johnDoe.get("key"));
        assertEquals("Testing", article.get("key"));
	}
	
}
