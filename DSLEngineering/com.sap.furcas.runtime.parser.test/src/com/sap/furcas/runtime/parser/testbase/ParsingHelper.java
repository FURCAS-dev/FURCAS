package com.sap.furcas.runtime.parser.testbase;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.sap.furcas.runtime.parser.IModelAdapter;
import com.sap.furcas.runtime.parser.ModelParsingResult;
import com.sap.furcas.runtime.parser.ParserFacade;
import com.sap.furcas.runtime.parser.ParsingError;
import com.sap.furcas.runtime.parser.exceptions.UnknownProductionRuleException;

/**
 * Parser generation test base class. Provides several methods for parsing text fragments / files using a generated parsers.
 */
public class ParsingHelper {

    private final ParserFacade parserFacade;

    public ParsingHelper(ParserFacade parserFacade) {
        this.parserFacade = parserFacade;
    }

    public ModelParsingResult parseString(String sample, IModelAdapter modelAdapter) throws IOException, UnknownProductionRuleException {
        InputStream charStream = new ByteArrayInputStream(sample.getBytes());
        ModelParsingResult result = parse(charStream, modelAdapter);
        return result;
    }

    public StubModelAdapter parseString(String sample, int expectedErrors) throws IOException, UnknownProductionRuleException {
        StubModelAdapter stubModelHandler = new StubModelAdapter();

        InputStream charStream = new ByteArrayInputStream(sample.getBytes());
        parseStream(expectedErrors, charStream, stubModelHandler);
        return stubModelHandler;
    }

    public StubModelAdapter parseFile(String dslSampleFile, String DSLSAMPLEDIR) throws Exception {
        return parseFile(dslSampleFile, DSLSAMPLEDIR, 0);
    }

    public StubModelAdapter parseFile(String dslSampleFile, String DSLSAMPLEDIR, int expectedErrors) throws Exception {
        StubModelAdapter stubModelHandler = new StubModelAdapter();
        parseFile(dslSampleFile, DSLSAMPLEDIR, expectedErrors, stubModelHandler);
        return stubModelHandler;
    }

    public ModelParsingResult parseFile(String dslSampleFile, String DSLSAMPLEDIR, int expectedErrors, IModelAdapter adapter) throws Exception {
        InputStream charStream = new FileInputStream(DSLSAMPLEDIR + dslSampleFile);
        return parseStream(expectedErrors, charStream, adapter);
    }

    public ModelParsingResult parseStream(int expectedErrors, InputStream in, IModelAdapter modelAdapter) throws IOException,
            UnknownProductionRuleException {

        ModelParsingResult result = parse(in, modelAdapter);
        checkModelForParsingErrors(expectedErrors, result);
        return result;
    }

    private ModelParsingResult parse(InputStream in, IModelAdapter modelAdapter) throws IOException,
            UnknownProductionRuleException {
        return parserFacade.parseProductionRule(in, modelAdapter, /* use main rule */null, null, null);
    }

    private void checkModelForParsingErrors(int expectedErrors, ModelParsingResult result) {
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
