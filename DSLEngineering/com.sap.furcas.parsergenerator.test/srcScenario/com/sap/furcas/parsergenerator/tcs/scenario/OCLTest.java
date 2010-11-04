package com.sap.furcas.parsergenerator.tcs.scenario;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.sap.furcas.parsergenerator.base.FileBasedEcoreMetaModelLookUp;
import com.sap.furcas.parsergenerator.base.ExtendedGeneratedParserBasedTest;
import com.sap.furcas.parsergenerator.base.ParserGenerationTestHelper;
import com.sap.furcas.test.scenario.FixtureData;

/**
 * Simple Test for the custom Expression language
 */
@Ignore("Already broken in the moin codebase. Was not even included in the test suite.")
public class OCLTest extends ExtendedGeneratedParserBasedTest {


	private static final String DSLSAMPLEDIR = "./scenarioTestSample/";
	private static final String LANGUAGE = "OCL";

	// Problems with OperatorCalls
	@BeforeClass
	public static void setupParser() throws Exception {
		setParserGenerationTestHelper(ParserGenerationTestHelper.getDefault());
		setLookup(new FileBasedEcoreMetaModelLookUp(FixtureData.OCL_METAMODEL));
		generateParserForLanguage(LANGUAGE);
	}

	@Test
	public void testAcceptSample1() throws Exception {


	    parseString("self.vertices->forAll(p1, p2 |\r\n" + 
	            "(p1.x = p2.x and p1.y = p2.y) implies p1 = p2)", LANGUAGE, 0);
	}
	
	@Test
	public void testAcceptSample2() throws Exception {

	    parseString("let a : Integer = 1 in a + 1", LANGUAGE, 0);
	    
	    // syntax error leave out bits
	    parseString("let a  Integer = 1 in a + 1", LANGUAGE, 1);
	    parseString("let a : Integer = 1 in a  1", LANGUAGE, 1);
	}
	
	@Test
	public void testAcceptSample3() throws Exception {

	    parseString("Student.allInstances->forAll( p1, p2 | p1 <> p2 implies p1.name <> p2.name )", LANGUAGE, 0);
	    
	    // error cases
	    parseString("Student.allInstances->forAll( p1, p2 | p1 <> p2 imies p1.name <> p2.name )", LANGUAGE, 1);
	    parseString("Student.allInstances>forAll( p1, p2 | p1 <> p2 implies p1.name <> p2.name )", LANGUAGE, 2);
	    parseString("Student.allInstances->forAll p1, p2 | p1 <> p2 implies p1.name <> p2.name )", LANGUAGE, 2);
	}
	
	@Test
    public void testAcceptSample4() throws Exception {

        parseString("MOF!Class.allInstances()->collect(e|e.name)", LANGUAGE, 0);
    }

	@Test
    public void testAcceptSample5() throws Exception {

        parseString("MOF!Class.allInstances()->collect(e | e.name + \' extends \' + e.supertypes->iterate(e; acc : String = \'\' | acc + if acc = \'\' then \'\' else \' and \' endif + e.name))", LANGUAGE, 0);
    }
	
}
