package com.sap.furcas.parsergenerator.base;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.sap.furcas.runtime.parser.IModelAdapter;
import com.sap.furcas.runtime.parser.ModelParsingResult;
import com.sap.furcas.runtime.parser.exceptions.InvalidParserImplementationException;
import com.sap.furcas.runtime.parser.exceptions.UnknownProductionRuleException;
import com.sap.furcas.runtime.parser.impl.ParsingError;

/**
 *  Parser generation test base class. Provides several methods for parsing text
 *  fragments / files using a generated parsers. 
 */
public abstract class ExtendedGeneratedParserBasedTest extends GeneratedParserBasedTest {

    protected ModelParsingResult parseString(String sample, String language, IModelAdapter modelAdapter) throws IOException,
            UnknownProductionRuleException, InvalidParserImplementationException {

        InputStream charStream = new ByteArrayInputStream(sample.getBytes());
        ModelParsingResult result = getParserGenerationTestHelper().parseStream(language, charStream, modelAdapter);
        return result;
    }

    protected StubModelAdapter parseString(String sample, String language, int expectedErrors) throws IOException,
            UnknownProductionRuleException, InvalidParserImplementationException {
        StubModelAdapter stubModelHandler = new StubModelAdapter();

        InputStream charStream = new ByteArrayInputStream(sample.getBytes());
        doParseFromStream(language, expectedErrors, charStream, stubModelHandler);
        return stubModelHandler;
    }

    protected StubModelAdapter parseFile(String dslSampleFile, String LANGUAGE, String DSLSAMPLEDIR) throws Exception {
        return parseFile(dslSampleFile, LANGUAGE, DSLSAMPLEDIR, 0);
    }

    protected StubModelAdapter parseFile(String dslSampleFile, String LANGUAGE, String DSLSAMPLEDIR, int expectedErrors)
            throws Exception {

        StubModelAdapter stubModelHandler = new StubModelAdapter();
        parseFile(dslSampleFile, LANGUAGE, DSLSAMPLEDIR, expectedErrors, stubModelHandler);
        return stubModelHandler;
    }

    protected void parseFile(String dslSampleFile, String LANGUAGE, String DSLSAMPLEDIR, int expectedErrors, IModelAdapter adapter)
            throws Exception {
        InputStream charStream = new FileInputStream(DSLSAMPLEDIR + dslSampleFile);
        doParseFromStream(LANGUAGE, expectedErrors, charStream, adapter);
    }

    // /**
    // * @return
    // * @throws InvalidParserImplementationException
    // * @throws IOException
    // */
    // protected ParserFacade getParserFacade(String language) throws
    // IOException, InvalidParserImplementationException {
    // return generationHelper.getFacade(language);
    // }

    protected void doParseFromStream(String LANGUAGE, int expectedErrors, InputStream in, IModelAdapter modelAdapter)
            throws IOException, UnknownProductionRuleException, InvalidParserImplementationException {

        ModelParsingResult result = getParserGenerationTestHelper().parseStream(LANGUAGE, in, modelAdapter);
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
                } else { // fail special message if more than 0 errors were
                    // expected, so that it is obvious this test indeed
                    // intended some errors
                    assertEquals("Bad number of errors after parsing\n" + messages.toString(), expectedErrors, errors.size());
                }
            }
        } else {
            // fail if expected errors are more than 0
            assertEquals("No errors occured, but errors were expected. ", expectedErrors, 0);
        }
    }
}
