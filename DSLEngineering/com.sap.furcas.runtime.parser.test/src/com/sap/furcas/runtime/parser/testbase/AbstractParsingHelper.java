/*******************************************************************************
 * Copyright (c) 2010-2011 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package com.sap.furcas.runtime.parser.testbase;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.ByteArrayInputStream;
import java.io.File;
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
 * Parsing helper for parsing text fragments / files using a generated parser.
 */
public abstract class AbstractParsingHelper<ParsingResult> {

//    public static class ParsingResult {
//        /**
//         * The injected model as the result of the parsing
//         */
//        public final ModelParsingResult result;
//        /**
//         * The model adapter used to 
//         */
//        public final IModelAdapter modelAdapter;
//        
//        public ParsingResult(ModelParsingResult result, IModelAdapter modelAdapter) {
//            this.result = result;
//            this.modelAdapter = modelAdapter;
//        }
//    }
    
    private final ParserFacade parserFacade;

    public AbstractParsingHelper(ParserFacade parserFacade) {
        this.parserFacade = parserFacade;
    }
    
    protected abstract IModelAdapter createModelAdapter();

    protected abstract ParsingResult createParsingResult(IModelAdapter modelAdapter, ModelParsingResult result);

    public ParsingResult parseString(String sample) throws IOException, UnknownProductionRuleException {
        InputStream charStream = new ByteArrayInputStream(sample.getBytes());
        IModelAdapter modelAdapter = createModelAdapter();
        ModelParsingResult result = parseStream(charStream, modelAdapter);
        return createParsingResult(modelAdapter, result);
    }
    
    public ModelParsingResult parseString(String sample, IModelAdapter modelAdapter) throws IOException, UnknownProductionRuleException {
        InputStream charStream = new ByteArrayInputStream(sample.getBytes());
        return parseStream(charStream, modelAdapter);
    }
    
    public ParsingResult parseString(String sample, int expectedErrors) throws IOException, UnknownProductionRuleException {
        InputStream charStream = new ByteArrayInputStream(sample.getBytes());
        IModelAdapter modelAdapter = createModelAdapter();
        ModelParsingResult result = parseStream(charStream, expectedErrors, modelAdapter);
        return createParsingResult(modelAdapter, result);
    }
    
    public ParsingResult parseFile(String dslSampleFile, String DSLSAMPLEDIR, int expectedErrors) throws Exception {
        IModelAdapter modelAdapter = createModelAdapter();
        InputStream charStream = new FileInputStream(new File(DSLSAMPLEDIR + dslSampleFile));
        ModelParsingResult result = parseStream(charStream, expectedErrors, modelAdapter);
        return createParsingResult(modelAdapter, result);
    }

    public ModelParsingResult parseFile(String dslSampleFile, String DSLSAMPLEDIR, int expectedErrors, IModelAdapter modelAdapter) throws Exception {
        return parseFile(new File(DSLSAMPLEDIR + dslSampleFile), expectedErrors, modelAdapter);
    }
    
    protected ModelParsingResult parseFile(File file, int expectedErrors, IModelAdapter modelAdapter) throws Exception {
        InputStream charStream = new FileInputStream(file);
        return parseStream(charStream, expectedErrors, modelAdapter);
    }

    /**
     * Low level parsing method offering full control over the used model adapter.
     */
    public ModelParsingResult parseStream(InputStream in, int expectedErrors, IModelAdapter modelAdapter) throws IOException, UnknownProductionRuleException {
        ModelParsingResult result = parseStream(in, modelAdapter);
        checkModelForParsingErrors(expectedErrors, result);
        return result;
    }

    /**
     * Low level parsing method offering full control over the used model adapter.
     */
    public ModelParsingResult parseStream(InputStream in, IModelAdapter modelAdapter) throws IOException,
            UnknownProductionRuleException {
        return parserFacade.parseProductionRule(in, modelAdapter, /* use main rule */null, null, null);
    }
    
    protected void checkModelForParsingErrors(int expectedErrors, ModelParsingResult result) {
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
