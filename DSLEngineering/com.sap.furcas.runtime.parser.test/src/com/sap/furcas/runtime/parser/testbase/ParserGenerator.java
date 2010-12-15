/*******************************************************************************
 * Copyright (c) 2009, 2010 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package com.sap.furcas.runtime.parser.testbase;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;

import org.antlr.runtime.Lexer;

import com.sap.furcas.parsergenerator.GrammarGenerationException;
import com.sap.furcas.parsergenerator.TCSParserGenerator;
import com.sap.furcas.parsergenerator.TCSParserGeneratorFactory;
import com.sap.furcas.parsergenerator.TCSSyntaxContainerBean;
import com.sap.furcas.runtime.common.exceptions.ParserGeneratorInvocationException;
import com.sap.furcas.runtime.parser.ParserFacade;
import com.sap.furcas.runtime.parser.exceptions.InvalidParserImplementationException;
import com.sap.furcas.runtime.parser.impl.ObservableInjectingParser;
import com.sun.tools.javac.Main;

/**
 * A class that allows to generate a language specific parser from a given TCS file.
 * Its methods must be called in the follwoing order:
 * 
 *      generateGrammar(),
 *      generateParser(),
 *      compileParser(),
 *      loadParserFacade().
 * 
 * The class is configured (what to create, where to create it, ...) with the help
 * {@link GeneratedParserTestConfiguration}. It is used by the {@link GeneratedParserBasedTest}.
 * 
 * @author Stephan Erb
 */
public class ParserGenerator {
    
    private final GeneratedParserTestConfiguration testConfig;

    public ParserGenerator(GeneratedParserTestConfiguration testConfig) {
        this.testConfig = testConfig;
    }

    public void generateGrammar(TCSSyntaxContainerBean syntaxBean) throws GrammarGenerationException {
        SystemOutErrorHandler errorHandler = new SystemOutErrorHandler();
        try {
            TCSParserGenerator generator = TCSParserGeneratorFactory.INSTANCE.createTCSParserGenerator();
            generator.generateGrammarFromSyntax(syntaxBean, testConfig.getSourceConfiguration(),
                    testConfig.getTargetConfiguration(), errorHandler);
        } catch (ParserGeneratorInvocationException e) {
            e.printStackTrace();
            fail("Failed to generate grammar:" + e.getMessage());
        }
        assertFalse("Must have completed without (critical) errors", errorHandler.hasFailedWithError());
    }

    public void generateParser() {
        ByteArrayOutputStream errByteStream = new ByteArrayOutputStream();
        PrintStream systemErrOld = redirectSystemErrTo(errByteStream);

        SystemOutErrorHandler errorHandler = new SystemOutErrorHandler();
        try {
            TCSParserGenerator generator = TCSParserGeneratorFactory.INSTANCE.createTCSParserGenerator();
            generator.generateParserFromGrammar(testConfig.getTargetConfiguration(), errorHandler);
        } catch (ParserGeneratorInvocationException e) {
            e.printStackTrace();
            fail("Failed go generate Parser/Lexer class: " + e.getMessage());
        } finally {
            restoreOldSystemErr(systemErrOld);
        }
        checkSystemErrForANTLRErrosAndFailIfNecessary(errByteStream);
        assertFalse("Must have completed without (critical) errors. See syserr.", errorHandler.hasFailedWithError());
    }

    public void compileParser() {
        ByteArrayOutputStream errByteStream = new ByteArrayOutputStream();
        PrintStream systemErrOld = redirectSystemErrTo(errByteStream);
        try {
            int success = Main.compile(new String[] {
                    testConfig.getRelativePathToGeneratedLexerClass(),
                    testConfig.getRelativePathToGeneratedParserClass(),
                    "-cp",
                    "../org.antlr/bin" + File.pathSeparator + "../com.sap.furcas.runtime.parser/bin"
                            + File.pathSeparator + "../com.sap.furcas.runtime.common/bin" + File.pathSeparator
                            + "../com.sap.furcas.parsergenerator.emf/bin" + File.pathSeparator
                            + "../com.sap.furcas.runtime.tcs/bin" });
            if (success != 0) {
                fail("Parser compilation failed with code '" + success + "'. Messages: \n" + errByteStream.toString());
            }
        } finally {
            restoreOldSystemErr(systemErrOld);
        }
    }

    public ParserFacade loadParserFacade(ClassLookup classLookup) throws ParserGeneratorInvocationException, InvalidParserImplementationException {
        // try loading compiled classes
        try {
            @SuppressWarnings("unchecked")
            Class<? extends Lexer> lexerclass = (Class<? extends Lexer>) classLookup.loadClass(testConfig
                    .getClassNameOfCompiledLexer());
            @SuppressWarnings("unchecked")
            Class<? extends ObservableInjectingParser> parserclass = (Class<? extends ObservableInjectingParser>) classLookup
                    .loadClass(testConfig.getClassNameOfCompiledParser());
            ParserFacade facade = new ParserFacade(parserclass, lexerclass, testConfig.getLanguageName());
            return facade;

        } catch (ClassNotFoundException cnfe) {
            throw new ParserGeneratorInvocationException("Can't find generated classes "
                    + testConfig.getClassNameOfCompiledLexer() + " and " + testConfig.getClassNameOfCompiledLexer()
                    + ". Try to do an Eclipse refresh on the project.", cnfe);
        }
    }

    protected static PrintStream redirectSystemErrTo(ByteArrayOutputStream errByteStream) {
        PrintStream originalSystemErr = System.err;
        System.setErr(new PrintStream(errByteStream));
        return originalSystemErr;
    }

    protected static void restoreOldSystemErr(PrintStream systemErr) {
        System.setErr(systemErr);
    }

    /**
     * If antlr wrote to System.err, fail the test with ANTLR messages. If err is empty, continue
     */
    protected static void checkSystemErrForANTLRErrosAndFailIfNecessary(ByteArrayOutputStream errByteStream) {
        String errString = errByteStream.toString().trim();
        if (!"".equals(errString)) {
            if (errString.toLowerCase().indexOf("error") > -1) { // ignore
                // warnings written to System.err
                fail(errString);
            } else {
                System.out.println(errString);
                errByteStream.reset(); // discarding warnings from stream, so
                // that error only shows errors
            }
        }
    }

    public void cleanUp() {
        File genDir = new File(testConfig.getRelativePathToGeneratedFiles());
        assertTrue(genDir.getAbsolutePath() + " is supposed to be a directory", genDir.isDirectory());

        for (File file : genDir.listFiles()) {
            if (       file.getName().startsWith(testConfig.getLanguageName()) && file.getName().endsWith(".java")
                    || file.getName().startsWith(testConfig.getLanguageName()) && file.getName().endsWith(".class")
                    || file.getName().startsWith(testConfig.getLanguageName()) && file.getName().endsWith(".g")
                    || file.getName().equals(testConfig.getLanguageName() + ".tokens")) {
                file.delete();
            }
        }
    }
    
}
