package com.sap.mi.textual.test.scenarios;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.sap.furcas.test.parsing.base.ExtendedGeneratedParserBasedTest;
import com.sap.furcas.test.util.EcoreMetaModelLookUp;
import com.sap.ide.cts.editor.test.util.ParserGenerationTestHelper;

/**
 * Simple Test for the custom Expression language
 */
public class OCLTest extends ExtendedGeneratedParserBasedTest {


	private static final String DSLSAMPLEDIR = "./scenarioTestSample/";
	private static final String LANGUAGE = "OCL";

	// Problems with OperatorCalls
	@BeforeClass
	public static void setupParser() throws Exception {
		setParserGenerationTestHelper(ParserGenerationTestHelper.getDefault());
		setLookup(new EcoreMetaModelLookUp("OCL.ecore"));
		generateParserForLanguage(LANGUAGE);
	}

	@Test
	public void testAcceptSample1() throws Exception {


	    parseString("self.vertices->forAll(p1, p2 |\r\n" + 
	            "(p1.x = p2.x and p1.y = p2.y) implies p1 = p2)", LANGUAGE, 0);
	}
	
	@Test
	@Ignore
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
