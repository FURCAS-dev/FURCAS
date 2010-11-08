/**
 * 
 */
package com.sap.furcas.parser.tcs.bootstrap;

import static com.sap.furcas.parser.tcs.bootstrap.BootstrapHelper.createReferenceScope;
import static com.sap.furcas.parser.tcs.bootstrap.BootstrapHelper.createResourceSet;
import static org.junit.Assert.assertFalse;

import java.io.File;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.parsergenerator.GrammarGenerationException;
import com.sap.furcas.parsergenerator.GrammarGenerationSourceConfiguration;
import com.sap.furcas.parsergenerator.GrammarGenerationTargetConfiguration;
import com.sap.furcas.parsergenerator.TCSParserGenerator;
import com.sap.furcas.parsergenerator.TCSParserGeneratorFactory;
import com.sap.furcas.runtime.common.exceptions.ParserGeneratorInvocationException;

public class TCSBootstrap {
    
    private static final String GENERATIONDIR = "./generationTemp/";
    private static final String GRAMMAR = GENERATIONDIR + "TCS.g";
    private static final String PACKAGE = "generated";
    private static final String SYNTAXDEFINITION = "./syntaxdefinition/TCS.tcs";
    
    private static GrammarGenerationSourceConfiguration sourceConfiguration;
    private static GrammarGenerationTargetConfiguration targetConfiguration;

    
    @BeforeClass
    public static void setup() {
        sourceConfiguration = new GrammarGenerationSourceConfiguration(new File(SYNTAXDEFINITION), createResourceSet(), createReferenceScope());
        targetConfiguration = new GrammarGenerationTargetConfiguration(PACKAGE, new File(GRAMMAR));
    }
    
    /**
     * Step 1: Parse the TCS.tcs and generate a corresponding ANTLR grammar.
     */
    @Test
    public void step1_GenerateGrammar() throws GrammarGenerationException, ParserGeneratorInvocationException {
        SystemOutErrorHandler errorHandler = new SystemOutErrorHandler();

        TCSParserGenerator generator = TCSParserGeneratorFactory.INSTANCE.createTCSParserGenerator();
        generator.generateGrammarFromSyntax(sourceConfiguration, targetConfiguration, errorHandler);

        assertFalse("Must have completed without (critical) errors", errorHandler.hasFailedWithError());
    }

    /**
     * Step 2: Use ANTLR to generate  TCSParser.java and TCSLexer.java.
     */
    @Test
    public void step2_GenerateParser() throws GrammarGenerationException, ParserGeneratorInvocationException {
        SystemOutErrorHandler errorHandler = new SystemOutErrorHandler();

        TCSParserGenerator generator = TCSParserGeneratorFactory.INSTANCE.createTCSParserGenerator();
        generator.generateGrammarFromSyntax(sourceConfiguration, targetConfiguration, errorHandler);
        
        assertFalse("Must have completed without (critical) errors", errorHandler.hasFailedWithError());
    }
    
}
