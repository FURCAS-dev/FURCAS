package com.sap.furcas.parsergenerator.tcs.scenario;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import java.util.Iterator;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.parsergenerator.base.FileBasedEcoreMetaModelLookUp;
import com.sap.furcas.parsergenerator.base.ExtendedGeneratedParserBasedTest;
import com.sap.furcas.parsergenerator.base.ParserGenerationTestHelper;
import com.sap.furcas.parsergenerator.base.StubModelAdapter;
import com.sap.furcas.parsergenerator.base.StubModelElement;
import com.sap.furcas.test.scenario.FixtureData;

/**
 * Simple Test for the custom Problem language, which acts like a log file.
 */
public class ProblemTest extends ExtendedGeneratedParserBasedTest {

	private static final String LANGUAGE = "Problem";

	
	@BeforeClass
	public static void setupParser() throws Exception {
		setParserGenerationTestHelper(ParserGenerationTestHelper.getDefault());
		setLookup(new FileBasedEcoreMetaModelLookUp(FixtureData.PROBLEM_METAMODEL));
		generateParserForLanguage(LANGUAGE);
	}


	/**
	 * test syntax errors cause parsing errors
	 * @throws Exception
	 */
	@Test
	public void testSampleDirect() throws Exception {
	    String sample = "error 'testerror' at 'somewhere';\n" +
	    		"warning 'testwarning' at 'somewhereelse';\n";
	    StubModelAdapter stubModelHandler = parseString(sample, LANGUAGE,  0);

	    Set<StubModelElement> problems = stubModelHandler.getElementsbyType("Problem::Problem");
        assertEquals(2, problems.size());
        
        Iterator<StubModelElement> it = problems.iterator();
        StubModelElement element = it.next();
        StubModelElement element2 = it.next();
        
        StubModelElement severity = (StubModelElement) element.get("severity");
        StubModelElement severity2 = (StubModelElement) element2.get("severity");

        assertNotSame(severity.type, severity2.type);
        if (! "error".equals(severity.type)) {        
            StubModelElement temp = severity;
            severity = severity2;
            severity2 = temp;
            
            temp = element;
            element = element2;
            element2 = temp;
        }
        
        assertEquals("error", severity.type);
        assertEquals("testerror", element.get("description"));
        assertEquals("somewhere", element.get("location"));
        
       
        assertEquals("warning", severity2.type);
        assertEquals("testwarning", element2.get("description"));
        assertEquals("somewhereelse", element2.get("location"));
        

	}
}
