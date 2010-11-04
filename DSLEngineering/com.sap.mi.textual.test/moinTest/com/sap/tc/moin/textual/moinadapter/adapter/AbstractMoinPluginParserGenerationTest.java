/**
 * 
 */
package com.sap.tc.moin.textual.moinadapter.adapter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import com.sap.furcas.parsergenerator.GrammarGenerationException;
import com.sap.furcas.runtime.common.exceptions.ModelAdapterException;
import com.sap.furcas.runtime.common.interfaces.IMetaModelLookup;
import com.sap.furcas.runtime.parser.IModelAdapter;
import com.sap.furcas.runtime.parser.ModelParsingResult;
import com.sap.furcas.runtime.parser.ParserFacade;
import com.sap.furcas.runtime.parser.ParsingError;
import com.sap.furcas.runtime.parser.exceptions.InvalidParserImplementationException;
import com.sap.furcas.runtime.parser.exceptions.SyntaxParsingException;
import com.sap.furcas.runtime.parser.exceptions.UnknownProductionRuleException;
import com.sap.furcas.test.util.StubModelAdapter;
import com.sap.ide.cts.editor.test.util.ParserGenerationTestHelper;

/**
 *
 */
public class AbstractMoinPluginParserGenerationTest {

    public AbstractMoinPluginParserGenerationTest() {
        generationHelper  = new ParserGenerationTestHelper("./mointest", Arrays.asList(new String[] {"generated"}), true);
    }
    
    private static PrintStream systemErr;
    private static ByteArrayOutputStream errByteStream;

    private static ParserGenerationTestHelper generationHelper;


    @BeforeClass 
    public static void redirectStrem() throws Exception {
        // redirect Std.err to be able to check it for errors
        errByteStream = new ByteArrayOutputStream();
        systemErr = System.err; // Hold on to the original value
        System.setErr(new PrintStream(errByteStream));
    }

    protected ModelParsingResult parseString(String sample, String language, IModelAdapter modelAdapter)
    throws InstantiationException,
    IllegalAccessException, InvocationTargetException,
    NoSuchMethodException, IOException, NoSuchFieldException, UnknownProductionRuleException, InvalidParserImplementationException {
        
        
        InputStream charStream = new ByteArrayInputStream(sample.getBytes());
        ModelParsingResult result = generationHelper.parseStream(language, charStream, modelAdapter);
        return result;
    }
    
    protected StubModelAdapter parseString(String sample, String language, int expectedErrors)
    throws InstantiationException,
    IllegalAccessException, InvocationTargetException,
    NoSuchMethodException, IOException, NoSuchFieldException, UnknownProductionRuleException, InvalidParserImplementationException {
        StubModelAdapter stubModelHandler =  new StubModelAdapter();
        
        InputStream charStream = new ByteArrayInputStream(sample.getBytes());
        doParseFromStream(language, expectedErrors, charStream, stubModelHandler);
        return stubModelHandler;
    }

    protected StubModelAdapter parseFile(String dslSampleFile,  String LANGUAGE, String DSLSAMPLEDIR)
    throws Exception {
        return parseFile(dslSampleFile, LANGUAGE, DSLSAMPLEDIR, 0);
    }


    protected StubModelAdapter parseFile(String dslSampleFile, String LANGUAGE, String DSLSAMPLEDIR, int expectedErrors)
    throws Exception {
        
        StubModelAdapter stubModelHandler =  new StubModelAdapter();
        parseFile(dslSampleFile, LANGUAGE, DSLSAMPLEDIR, expectedErrors, stubModelHandler);
        return stubModelHandler;
    }
    
    protected void parseFile(String dslSampleFile, String LANGUAGE, String DSLSAMPLEDIR, int expectedErrors, IModelAdapter adapter)
    throws Exception {
        InputStream charStream = new FileInputStream(DSLSAMPLEDIR + dslSampleFile);
        doParseFromStream(LANGUAGE, expectedErrors, charStream, adapter);
    }
    

    /**
     * @return
     * @throws InvalidParserImplementationException 
     * @throws IOException 
     */
    protected ParserFacade getParserFacade(String language) throws IOException, InvalidParserImplementationException {
        return generationHelper.getFacade(language);
    }

    protected void doParseFromStream(String LANGUAGE,
            int expectedErrors, InputStream in, IModelAdapter modelAdapter)
            throws IOException, InstantiationException, IllegalAccessException,
            InvocationTargetException, NoSuchMethodException,
            NoSuchFieldException, UnknownProductionRuleException, InvalidParserImplementationException {
        
        ModelParsingResult result = generationHelper.parseStream(LANGUAGE, in, modelAdapter);
        checkModelErrors(expectedErrors, result);
    }
    
    private void checkModelErrors(int expectedErrors, ModelParsingResult result) {
        // check for parsing errors
        List<ParsingError> errors = result.getErrors();

        if (errors != null && errors.size() > 0) {
            if (expectedErrors != errors.size()) {
                StringBuffer messages = new StringBuffer();
                for (ParsingError parsingError : errors) {
                    messages.append(parsingError.getMessage()).append(" in line ").append(parsingError.getLine()).append('\n');
                }
                if (expectedErrors == 0) {
                    fail(messages.toString());
                } else { // fail special message if more than 0 errors were expected, so that it is obvious this test indeed intended some errors
                    assertEquals("Bad number of errors after parsing\n" + messages.toString(), expectedErrors, errors.size());
                }
            }
        } else {
            // fail if expected errors are more than 0
            assertEquals("No errors occured, but errors were expected. ", expectedErrors, 0 );
        }
    }

    protected final static void generateParser(String language,
			IMetaModelLookup<?> lookup) throws FileNotFoundException,
			SyntaxParsingException, ModelAdapterException,
			GrammarGenerationException, IOException {

		Connection connection = MOINTCSMetaConnectionProvider
				.getTestConnection();
		generationHelper.generateParserGrammar(language, lookup, connection,
				MOINTCSMetaConnectionProvider
						.getPartitionsOfMetamodel("demo.sap.com/tcsmeta"));
		generateAndCompileParser(language);

	}

	protected final static void generateParser(String language,
			IMetaModelLookup<?> lookup, Set<PRI> partitions,
			Connection connection) throws FileNotFoundException,
			SyntaxParsingException, ModelAdapterException,
			GrammarGenerationException, IOException {
		generationHelper.generateParserGrammar(language, lookup, connection,
				partitions);
		generateAndCompileParser(language);
	}


    protected static void generateAndCompileParser(String languageName) {
        
        generationHelper.generateParserClasses(languageName);
        // if antlr wrote to System.err, fail the test with ANTLR messages. If err is empty, continue
        String errString = errByteStream.toString().trim(); 
        if (! "".equals(errString)) {
            if (errString.toLowerCase().indexOf("error")>-1) { // ignore warnings written to System.err
                fail(errString);
            } else {
                System.out.println(errString);
                errByteStream.reset(); // discarding warnings from stream, so that error only shows errors
            }
        }


        // compile generated Java
        int success = generationHelper.compileParser(languageName);
        if (success != 0) {
            systemErr.println(errByteStream.toString());
            fail("Parser compilation failed with code '" + success + "'. Messages: \n" + errByteStream.toString());
        }
    }

    @AfterClass public static void tearDown() {
        // restore the original value
        System.setErr(systemErr);

        // delete generated Files
        File genDir = generationHelper.getGenerationDir();
        assertTrue(genDir.getAbsolutePath() +" is not a directory", genDir.isDirectory());
        File[] files = genDir.listFiles();
        for (int i = 0; i < files.length; i++) {
            File file = files[i];
            if (file.getName().endsWith(".class")) { // keeping grammars for lookup
                file.delete();
                
            }
//          file.delete();
        }

    }
    
}
