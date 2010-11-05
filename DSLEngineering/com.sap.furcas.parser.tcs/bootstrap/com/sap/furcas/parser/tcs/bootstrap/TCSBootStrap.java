/**
 * 
 */
package com.sap.furcas.parser.tcs.bootstrap;

import static org.junit.Assert.assertFalse;

import java.io.File;
import java.util.Collections;
import java.util.Set;

import org.antlr.tool.Message;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.metamodel.FURCAS.FURCASPackage;
import com.sap.furcas.parsergenerator.GenerationErrorHandler;
import com.sap.furcas.parsergenerator.GrammarGenerationException;
import com.sap.furcas.parsergenerator.GrammarGenerationSourceConfiguration;
import com.sap.furcas.parsergenerator.GrammarGenerationTargetConfiguration;
import com.sap.furcas.parsergenerator.TCSParserGenerator;
import com.sap.furcas.parsergenerator.TCSParserGeneratorFactory;
import com.sap.furcas.runtime.common.exceptions.ParserGeneratorInvocationException;
import com.sap.furcas.runtime.parser.ParsingError;

/**
 *
 */
public class TCSBootStrap {

    private static class ErrorHandler implements GenerationErrorHandler {

        private boolean failedWithError = false;

        @Override
        public void error(ParsingError exception) {
            failedWithError = true;
            System.out.println("ERROR: " + exception.getMessage());
        }

        @Override
        public void fatalError(ParsingError exception) {
            failedWithError = true;
            System.out.println("FATAL ERROR: " + exception.getMessage());
        }

        @Override
        public void warning(ParsingError exception) {
            System.out.println("WARNING: " + exception.getMessage());
        }

        @Override
        public void error(Message err) {
            failedWithError = true;
            System.out.println("ERROR: " + err);
        }

        @Override
        public void warn(Message warn) {
            System.out.println("WARNING: " + warn);
        }

        @Override
        public void info(String info) {
            System.out.println("INFO: " + info);
        }

        public boolean hasFailedWithError() {
            return failedWithError;
        }

    }

    private static final String GENERATIONDIR = "./generationTmp/";
    private static final String GRAMMAR = GENERATIONDIR + "TCS.g";
    private static final String SYNTAXDEFINITION = "./syntaxdefinition/TCS.tcs";
    
    private static GrammarGenerationSourceConfiguration sourceConfiguration;
    private static GrammarGenerationTargetConfiguration targetConfiguration;

    
    @BeforeClass
    public static void setup() {
        File grammarFile = new File(GRAMMAR);
        File syntaxDefFile = new File(SYNTAXDEFINITION);

        sourceConfiguration = new GrammarGenerationSourceConfiguration(syntaxDefFile, createResourceSet(), createReferenceScope());
        targetConfiguration = new GrammarGenerationTargetConfiguration("", grammarFile);
    }
    
    private static Set<URI> createReferenceScope() {
        Set<URI> referenceScope = Collections.emptySet();
        return referenceScope;
    }

    private static ResourceSet createResourceSet() {
        ResourceSet resourceSet = new ResourceSetImpl();
        resourceSet.getPackageRegistry().put(FURCASPackage.eNS_URI, FURCASPackage.eINSTANCE);
        resourceSet.getPackageRegistry().put(FURCASPackage.eNAME, FURCASPackage.eINSTANCE);
        return resourceSet;
    }

    /**
     * Step 1: Parse the TCS.tcs and generate a corresponding ANTLR grammar.
     */
    @Test
    public void step1_GenerateGrammar() throws GrammarGenerationException, ParserGeneratorInvocationException {
        ErrorHandler errorHandler = new ErrorHandler();

        TCSParserGenerator generator = TCSParserGeneratorFactory.INSTANCE.createTCSParserGenerator();
        generator.generateGrammarFromSyntax(sourceConfiguration, targetConfiguration, errorHandler);

        assertFalse("Must have completed without (critical) errors", errorHandler.hasFailedWithError());
    }

    /**
     * Step 2: Use ANTLR to generate  TCSParser.java and TCSLexer.java.
     */
    @Test
    public void step2_GenerateParser() throws GrammarGenerationException, ParserGeneratorInvocationException {
        ErrorHandler errorHandler = new ErrorHandler();

        TCSParserGenerator generator = TCSParserGeneratorFactory.INSTANCE.createTCSParserGenerator();
        generator.generateGrammarFromSyntax(sourceConfiguration, targetConfiguration, errorHandler);

        assertFalse("Must have completed without (critical) errors", errorHandler.hasFailedWithError());
    }
    
}
