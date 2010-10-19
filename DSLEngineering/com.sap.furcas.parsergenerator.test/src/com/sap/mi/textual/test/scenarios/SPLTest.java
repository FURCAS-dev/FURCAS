package com.sap.mi.textual.test.scenarios;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.sap.furcas.test.parsing.base.EcoreMetaModelLookUp;
import com.sap.furcas.test.parsing.base.ExtendedGeneratedParserBasedTest;
import com.sap.furcas.test.parsing.base.ParserGenerationTestHelper;
import com.sap.furcas.test.parsing.base.StubModelAdapter;
import com.sap.furcas.test.parsing.testutils.StringListHelper;

/**
 * Simple Test for the SPL language, especially the word patterns
 */
@Ignore
public class SPLTest extends ExtendedGeneratedParserBasedTest {

	private static final String LANGUAGE = "SPL";
	private static final String DSLSAMPLEDIR = "./scenarioTestSample/";
	
	
	@BeforeClass
	public static void setupParser() throws Exception {
		setParserGenerationTestHelper(ParserGenerationTestHelper.getDefault());
		setLookup(new EcoreMetaModelLookUp("SPL.ecore"));
		generateParserForLanguage(LANGUAGE);
	}
	

	/**
     * test syntax errors cause parsing errors
     * @throws Exception
     */
    @Test
    public void testSample02Direct() throws Exception {
        
        StubModelAdapter stubModelHandler = getSPLStubAdapter();
        
        parseFile("SPLSample02.sam", LANGUAGE, DSLSAMPLEDIR, 0, stubModelHandler);
        
    }

	/**
	 * test syntax errors cause parsing errors
	 * @throws Exception
	 */
	@Test
	public void testSample01Direct() throws Exception {
	    
        StubModelAdapter stubModelHandler = getSPLStubAdapter();
        
        parseFile("SPLSample01.sam", LANGUAGE, DSLSAMPLEDIR, 0, stubModelHandler);
        
	}


    /**
     * @return
     */
    private StubModelAdapter getSPLStubAdapter() {
        StubModelAdapter stubModelHandler = new StubModelAdapter();
        // help stub along with supertypes
        stubModelHandler.supertypes.put("SPL::Argument", StringListHelper.list("SPL::VariableDeclaration", "SPL::Declaration"));
        stubModelHandler.supertypes.put("SPL::WhenHeader", StringListHelper.list("SPL::VariableDeclaration", "SPL::Declaration"));
        stubModelHandler.supertypes.put("SPL::Iterator", StringListHelper.list("SPL::VariableDeclaration", "SPL::Declaration"));
        stubModelHandler.supertypes.put("SPL::VariableDeclaration", StringListHelper.list("SPL::Declaration"));
        stubModelHandler.supertypes.put("SPL::StructureDeclaration", StringListHelper.list("SPL::Declaration"));
        stubModelHandler.supertypes.put("SPL::FunctionDeclaration", StringListHelper.list("SPL::Declaration"));
        stubModelHandler.supertypes.put("SPL::LocalFunctionDeclaration", StringListHelper.list("SPL::FunctionDeclaration", "SPL::Declaration"));
        stubModelHandler.supertypes.put("SPL::RemoteFunctionDeclaration", StringListHelper.list("SPL::FunctionDeclaration", "SPL::Declaration"));
        return stubModelHandler;
    }
}
