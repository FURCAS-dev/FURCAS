package com.sap.mi.textual.test.scenarios;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.runtime.parser.IModelAdapter;
import com.sap.furcas.runtime.parser.ModelParsingResult;
import com.sap.furcas.test.parsing.base.EcoreMetaModelLookUp;
import com.sap.furcas.test.parsing.base.ExtendedGeneratedParserBasedTest;
import com.sap.furcas.test.parsing.base.ParserGenerationTestHelper;
import com.sap.furcas.test.parsing.base.StubModelAdapter;
import com.sap.furcas.test.parsing.base.StubModelElement;

/**
 * Simple Test for the custom BibText language
 */
public class BibTextGenerationTest extends ExtendedGeneratedParserBasedTest {


	private static final String DSLSAMPLEDIR = "./scenarioTestSample/";
	private static final String LANGUAGE = "Bibtext";

	
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
	    		"author = \"John Doe\"." 
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
	}
	
	@Test
	public void testSample1() throws Exception {
		
		StubModelAdapter stubModelHandler = parseFile("BibTextSample01.sam", LANGUAGE, DSLSAMPLEDIR, 0);
		
		Set authors = stubModelHandler.getElementsbyType("BibText::Author");
		assertEquals(3, authors.size());
		
		Set articles = stubModelHandler.getElementsbyType("BibText::Article");
		assertEquals(3, articles.size());
	}
	
	@Test
	public void testSample2() throws Exception {
		
		StubModelAdapter stubModelHandler = parseFile("BibTextSample02.sam", LANGUAGE, DSLSAMPLEDIR, 1);
		
		Set authors = stubModelHandler.getElementsbyType("BibText::Author");
		assertEquals(3, authors.size());
		
		Set articles = stubModelHandler.getElementsbyType("BibText::Article");
		assertEquals(3, articles.size());
	}
	
	 @Test
	    public void testMissingElement() throws Exception {
	        IModelAdapter modelAdapter = new StubModelAdapter();
	        String sample = "Article";
	        ModelParsingResult result = parseString(sample, LANGUAGE, modelAdapter );
	        assertEquals(1, result.getErrors().size());
	        assertEquals(1, result.getErrors().get(0).getLine());
	        assertEquals(0, result.getErrors().get(0).getPosition());
	        assertEquals(1, result.getErrors().get(0).getEndLine());
	        assertEquals(7, result.getErrors().get(0).getEndPosition());
	    }
	    
	    @Test
	    public void testBadReference() throws Exception {
	        IModelAdapter modelAdapter = new StubModelAdapter();
	        String sample = "article {Testing, \"Harry\", year = \"2002\"}";
	        ModelParsingResult result = parseString(sample, LANGUAGE, modelAdapter );
	        assertEquals(1, result.getErrors().size());
	        assertEquals(1, result.getErrors().get(0).getLine());
	        assertEquals(18, result.getErrors().get(0).getPosition());
	        assertEquals(1, result.getErrors().get(0).getEndLine());
	        assertEquals(25, result.getErrors().get(0).getEndPosition());
	    }
	    
	    @Test
	    public void testbadKeyword() throws Exception {
	        IModelAdapter modelAdapter = new StubModelAdapter();
	        String sample = "article22 {)}";
	        ModelParsingResult result = parseString(sample, LANGUAGE, modelAdapter );
	        assertEquals(2, result.getErrors().size());
	        assertEquals(1, result.getErrors().get(0).getLine());
	        assertEquals(11, result.getErrors().get(0).getPosition());
	        assertEquals(1, result.getErrors().get(0).getEndLine());
	        assertEquals(11, result.getErrors().get(0).getEndPosition());
	    }
}
