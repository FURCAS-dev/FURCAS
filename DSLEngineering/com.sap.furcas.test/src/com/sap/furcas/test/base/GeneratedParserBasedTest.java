package com.sap.furcas.test.base;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;

import org.antlr.runtime.Lexer;

import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.parsergenerator.GrammarGenerationException;
import com.sap.furcas.parsergenerator.TCSParserGenerator;
import com.sap.furcas.parsergenerator.TCSParserGeneratorFactory;
import com.sap.furcas.parsergenerator.tcs.t2m.grammar.ObservationDirectivesHelper;
import com.sap.furcas.runtime.common.exceptions.ParserGeneratorInvocationException;
import com.sap.furcas.runtime.parser.ParserFacade;
import com.sap.furcas.runtime.parser.exceptions.InvalidParserImplementationException;
import com.sap.furcas.runtime.parser.impl.ObservableInjectingParser;
import com.sun.tools.javac.Main;

/**
 * A Test base class that allows to generate a language specific parser from
 * a given TCS file.
 * 
 * The base class is configured (what to create, where to create it, ...) with the
 * help {@link GeneratedParserTestConfiguration}. 
 * 
 * @author Stephan Erb (d049157)
 * 
 */
public class GeneratedParserBasedTest {

    {{
            ObservationDirectivesHelper.doAddObserverParts = ObservationDirectivesHelper.ALL;
    }}

    public static ParserFacade generateParserForLanguage(GeneratedParserTestConfiguration testConfig, ClassLookup classLookup) throws GrammarGenerationException, ParserGeneratorInvocationException, InvalidParserImplementationException {
        ConcreteSyntax syntax = generateGrammar(testConfig);
        generateParser(testConfig);
        compileParser(testConfig);
        
        return loadParserFacade(testConfig, classLookup, syntax);
    }

    protected final static ConcreteSyntax generateGrammar(GeneratedParserTestConfiguration testConfig) throws GrammarGenerationException {
        SystemOutErrorHandler errorHandler = new SystemOutErrorHandler();
        try {
            TCSParserGenerator generator = TCSParserGeneratorFactory.INSTANCE.createTCSParserGenerator();
            return generator.generateGrammarFromSyntax(testConfig.getSourceConfiguration(), testConfig.getTargetConfiguration(), errorHandler);
        } catch (ParserGeneratorInvocationException e) {
            e.printStackTrace();
            fail("Failed to generate grammar:" + e.getMessage());
        }
        assertFalse("Must have completed without (critical) errors", errorHandler.hasFailedWithError());
        return null;
    }

    protected static void generateParser(GeneratedParserTestConfiguration testConfig) {
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

    protected static void compileParser(GeneratedParserTestConfiguration testConfig) {
        ByteArrayOutputStream errByteStream = new ByteArrayOutputStream();
        PrintStream systemErrOld = redirectSystemErrTo(errByteStream);
        try {
            int success = Main.compile(new String[] {
                    testConfig.getRelativePathToGeneratedLexerClass(),
                    testConfig.getRelativePathToGeneratedParserClass(),
                    "-cp",
                    System.getProperty("antlr.lib.dir") + File.pathSeparator + "../com.sap.furcas.runtime.parser/bin"
                            + File.pathSeparator + "../com.sap.furcas.runtime.common/bin" + File.pathSeparator
                            + "../com.sap.furcas.parsergenerator.emf/bin" });
            if (success != 0) {
                fail("Parser compilation failed with code '" + success + "'. Messages: \n" + errByteStream.toString());
            }
        } finally {
            restoreOldSystemErr(systemErrOld);
        }
    }

    protected static ParserFacade loadParserFacade(GeneratedParserTestConfiguration testConfig, ClassLookup classLookup, ConcreteSyntax syntax)
            throws ParserGeneratorInvocationException, InvalidParserImplementationException {
        // try loading compiled classes
        try {
            @SuppressWarnings("unchecked")
            Class<? extends Lexer> lexerclass = (Class<? extends Lexer>) classLookup.loadClass(testConfig.getClassNameOfCompiledLexer());
            @SuppressWarnings("unchecked")
            Class<? extends ObservableInjectingParser> parserclass = (Class<? extends ObservableInjectingParser>) classLookup.loadClass(testConfig.getClassNameOfCompiledParser());
            ParserFacade facade = new ParserFacade(parserclass, lexerclass, syntax);
            return facade;

        } catch (ClassNotFoundException cnfe) { // catching from Class.forName
            throw new ParserGeneratorInvocationException("Can't find generated classes " + testConfig.getClassNameOfCompiledLexer() + " and "
                    + testConfig.getClassNameOfCompiledLexer() + ". Try to do an Eclipse refresh on the project.", cnfe);
        }
    }

    private static PrintStream redirectSystemErrTo(ByteArrayOutputStream errByteStream) {
        PrintStream originalSystemErr = System.err;
        System.setErr(new PrintStream(errByteStream));
        return originalSystemErr;
    }

    private static void restoreOldSystemErr(PrintStream systemErr) {
        System.setErr(systemErr);
    }

    /**
     * If antlr wrote to System.err, fail the test with ANTLR messages. If err is empty, continue
     */
    private static void checkSystemErrForANTLRErrosAndFailIfNecessary(ByteArrayOutputStream errByteStream) {
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

    // FIXME: do cleanup somewhere...
//    @AfterClass
//    public static void teardown() {
//        if (generationHelper != null) {
//            // delete generated Files
//            File genDir = generationHelper.getGenerationDir();
//            assertTrue(genDir.getAbsolutePath() + " is not a directory", genDir.isDirectory());
//            File[] files = genDir.listFiles();
//            for (File file : files) {
//                if (file.getName().endsWith(".class")) { // keeping grammars for
//                    // lookup
//                    file.delete();
//                }
//            }
//        }
//    }

}
