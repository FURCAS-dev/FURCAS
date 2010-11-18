/**
 * 
 */
package com.sap.furcas.parser.tcs.bootstrap;

import static com.sap.furcas.parser.tcs.bootstrap.BootstrapHelper.createReferenceScope;
import static com.sap.furcas.parser.tcs.bootstrap.BootstrapHelper.createResourceSet;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

import java.io.File;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.parsergenerator.GrammarGenerationException;
import com.sap.furcas.parsergenerator.GrammarGenerationSourceConfiguration;
import com.sap.furcas.parsergenerator.GrammarGenerationTargetConfiguration;
import com.sap.furcas.parsergenerator.TCSParserGenerator;
import com.sap.furcas.parsergenerator.TCSParserGeneratorFactory;
import com.sap.furcas.parsergenerator.TCSSyntaxContainerBean;
import com.sap.furcas.runtime.common.exceptions.ParserGeneratorInvocationException;
import com.sap.furcas.runtime.common.exceptions.ParserInvokationException;

public class TCSBootstrap {
    
    private static final String GENERATIONDIR = "./generationTemp/";
    private static final String PACKAGE = "generated";
    private static final String GRAMMAR = GENERATIONDIR + PACKAGE + "/TCS.g";
    private static final String SYNTAXDEFINITION = "./syntaxdefinition/TCS.tcs";
    
    private static GrammarGenerationSourceConfiguration sourceConfiguration;
    private static GrammarGenerationTargetConfiguration targetConfiguration;
    private static TCSParserGenerator generator;

    /**
     * Result of Step #1: The parsed TCS.tcs
     */
    private static TCSSyntaxContainerBean syntaxBean;
    
    
    @BeforeClass
    public static void setup() throws ParserGeneratorInvocationException {
        sourceConfiguration = new GrammarGenerationSourceConfiguration(createResourceSet(), createReferenceScope());
        targetConfiguration = new GrammarGenerationTargetConfiguration(PACKAGE, new File(GRAMMAR));
        generator = TCSParserGeneratorFactory.INSTANCE.createTCSParserGenerator();
    }
    
    @Test
    public void phase1_step0_deleteOldBootstrapFiles() {
        File dir = new File(GENERATIONDIR + PACKAGE);
        for (File file : dir.listFiles()) {
            if (file.isFile() && file.getName().startsWith("TCS")) {
                file.delete();
            }
        }
    }
    
    /**
     * Step 1: Parse the TCS.tcs syntax definition
     */
    @Test
    public void phase1_step1_parseSyntaxDefintion() {
        SystemOutErrorHandler errorHandler = new SystemOutErrorHandler();
        try {
            syntaxBean = generator.parseSyntax(sourceConfiguration, new File(SYNTAXDEFINITION));
            assertFalse("Must have completed without (critical) errors", errorHandler.hasFailedWithError());
            assertEquals("TCS", syntaxBean.getSyntax().getName());
        } catch (ParserInvokationException e) {
            e.printStackTrace();
            fail("Failed to parse syntax:" + e.getMessage());
        }
    }
    
    /**
     * Step 2: Walk the syntax and generate a corresponding ANTLR grammar
     */
    @Test
    public void phase1_step2_generateGrammar() {
        SystemOutErrorHandler errorHandler = new SystemOutErrorHandler();
        try {
            generator.generateGrammarFromSyntax(syntaxBean, sourceConfiguration, targetConfiguration, errorHandler);
            assertFalse("Must have completed without (critical) errors", errorHandler.hasFailedWithError());
        } catch (GrammarGenerationException e) {
            e.printStackTrace();
            fail("Failed to parse syntax:" + e.getMessage());
        }
    }

    /**
     * Step 3: Use ANTLR to generate a TCSParser.java and TCSLexer.java from the grammar.
     */
    @Test
    public void phase1_step3_generateParser() {
        SystemOutErrorHandler errorHandler = new SystemOutErrorHandler();
        generator.generateParserFromGrammar(targetConfiguration, errorHandler);
        assertFalse("Must have completed without (critical) errors", errorHandler.hasFailedWithError());
    }
    
}
