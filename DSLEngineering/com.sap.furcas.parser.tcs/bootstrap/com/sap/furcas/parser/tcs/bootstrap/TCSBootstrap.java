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
    
    private static final String GRAMMAR_FOR_INTERFACE = GENERATIONDIR + PACKAGE + "/SyntaxConfiguration.g";
    private static final String SYNTAXDEFINITION_FOR_INTERFACE = "./syntaxdefinition/SyntaxConfiguration.tcs";
    
    private static GrammarGenerationSourceConfiguration sourceConfiguration;
    private static GrammarGenerationTargetConfiguration targetConfiguration;
    private static TCSParserGenerator generator;
    
    private static GrammarGenerationSourceConfiguration sourceConfigurationForInterface;
    private static GrammarGenerationTargetConfiguration targetConfigurationForInterface;
//    private static TCSParserGenerator generatorForInterface;

    /**
     * Result of Step #1: The parsed TCS.tcs
     */
    private static TCSSyntaxContainerBean syntaxBean;
    private static TCSSyntaxContainerBean syntaxBeanForInterface;
    
    
    @BeforeClass
    public static void setup() throws ParserGeneratorInvocationException {
        sourceConfiguration = new GrammarGenerationSourceConfiguration(createResourceSet(), createReferenceScope());
        targetConfiguration = new GrammarGenerationTargetConfiguration(PACKAGE, new File(GRAMMAR));
        generator = TCSParserGeneratorFactory.INSTANCE.createTCSParserGenerator();
        
        sourceConfigurationForInterface = new GrammarGenerationSourceConfiguration(createResourceSet(), createReferenceScope());
        targetConfigurationForInterface = new GrammarGenerationTargetConfiguration(PACKAGE, new File(GRAMMAR_FOR_INTERFACE));
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
    
    @Test
    public void phase1_1_step0_deleteOldBootstrapFiles() {
        File dir = new File(GENERATIONDIR + PACKAGE);
        for (File file : dir.listFiles()) {
            if (file.isFile() && file.getName().startsWith("SyntaxConfiguration")) {
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
     * Step 1_1: Parse the SyntaxConfiguration.tcs syntax definition for the interface specification
     */
    @Test
    public void phase1_1_step1_parseSyntaxDefintion() {
        SystemOutErrorHandler errorHandler = new SystemOutErrorHandler();
        try {
            syntaxBeanForInterface = generator.parseSyntax(sourceConfigurationForInterface, new File(SYNTAXDEFINITION_FOR_INTERFACE));
            assertFalse("Must have completed without (critical) errors", errorHandler.hasFailedWithError());
            assertEquals("SyntaxConfiguration", syntaxBeanForInterface.getSyntax().getName());
            
        } catch (ParserInvokationException e) {
            e.printStackTrace();
            fail("Failed to parse syntax:" + e.getMessage());
        }
    }
    
    /**
     * Step 2: Walk the syntax of TCS and generate a corresponding ANTLR grammar
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
     * Step 2_2: Walk the syntax of SyntaxConfiguration and generate a corresponding ANTLR grammar
     */
    @Test
    public void phase1_1_step2_generateGrammar() {
        SystemOutErrorHandler errorHandler = new SystemOutErrorHandler();
        try {
//            generatorForInterface.generateGrammarFromSyntax(syntaxBeanForInterface, sourceConfigurationForInterface, targetConfigurationForInterface, errorHandler);
            generator.generateGrammarFromSyntax(syntaxBeanForInterface, sourceConfigurationForInterface, targetConfigurationForInterface, errorHandler);
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
    
    /**
     * Step 3: Use ANTLR to generate a SyntaxConfigurationParser.java and SyntaxConfigurationLexer.java from the grammar.
     */
    @Test
    public void phase1_1_step3_generateParser() {
        SystemOutErrorHandler errorHandler = new SystemOutErrorHandler();
        generator.generateParserFromGrammar(targetConfigurationForInterface, errorHandler);
        assertFalse("Must have completed without (critical) errors", errorHandler.hasFailedWithError());
        
    }
    
}
