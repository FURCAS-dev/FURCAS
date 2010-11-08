package com.sap.furcas.parsergenerator.tcs.scenario;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import java.io.File;
import java.util.Iterator;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.runtime.parser.ParserFacade;
import com.sap.furcas.test.base.GeneratedParserBasedTest;
import com.sap.furcas.test.base.GeneratedParserTestConfiguration;
import com.sap.furcas.test.base.ParsingHelper;
import com.sap.furcas.test.base.StubModelAdapter;
import com.sap.furcas.test.base.StubModelElement;
import com.sap.furcas.test.fixture.FixtureData;

/**
 * Simple Test for the custom Problem language, which acts like a log file.
 */
public class ProblemTest extends GeneratedParserBasedTest {

    private static final String LANGUAGE = "Problem";
    private static final File TCS = FixtureData.PROBLEM_TCS;
    private static final File[] METAMODELS = { FixtureData.PROBLEM_METAMODEL };

    private static ParsingHelper parsingHelper;

    @BeforeClass
    public static void setupParser() throws Exception {
        GeneratedParserTestConfiguration testConfig = new GeneratedParserTestConfiguration(LANGUAGE, TCS, METAMODELS);
        ParserFacade facade = generateParserForLanguage(testConfig);
        parsingHelper = new ParsingHelper(facade);
    }

    /**
     * test syntax errors cause parsing errors
     * 
     * @throws Exception
     */
    @Test
    public void testSampleDirect() throws Exception {
        String sample = "error 'testerror' at 'somewhere';\n" + "warning 'testwarning' at 'somewhereelse';\n";
        StubModelAdapter stubModelHandler = parsingHelper.parseString(sample, 0);

        Set<StubModelElement> problems = stubModelHandler.getElementsbyType("Problem::Problem");
        assertEquals(2, problems.size());

        Iterator<StubModelElement> it = problems.iterator();
        StubModelElement element = it.next();
        StubModelElement element2 = it.next();

        StubModelElement severity = (StubModelElement) element.get("severity");
        StubModelElement severity2 = (StubModelElement) element2.get("severity");

        assertNotSame(severity.type, severity2.type);
        if (!"error".equals(severity.type)) {
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
