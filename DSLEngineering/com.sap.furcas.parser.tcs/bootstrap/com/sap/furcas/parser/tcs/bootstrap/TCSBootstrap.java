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
import java.io.FileOutputStream;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.parsergenerator.GrammarGenerationSourceConfiguration;
import com.sap.furcas.parsergenerator.GrammarGenerationTargetConfiguration;
import com.sap.furcas.parsergenerator.TCSParserGenerator;
import com.sap.furcas.parsergenerator.TCSParserGeneratorFactory;
import com.sap.furcas.parsergenerator.TCSSyntaxContainerBean;
import com.sap.furcas.runtime.common.exceptions.ParserGeneratorInvocationException;
import com.sap.furcas.runtime.common.exceptions.ParserInvokationException;

public class TCSBootstrap {
    private static final String LANGUAGE_NAME = "TCS";
    private static final String GENERATIONDIR = "./generationTemp/";
    private static final String PACKAGE = "generated";
    private static final String MAPPINGS = "mappings";
    private static final String GRAMMAR = GENERATIONDIR + PACKAGE + "/"+LANGUAGE_NAME+".g";
    private static final String SYNTAXDEFINITION = "./syntaxdefinition/"+LANGUAGE_NAME+".tcs";
    
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
            if (file.isFile() && file.getName().startsWith(LANGUAGE_NAME)) {
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
            syntaxBean = generator.parseSyntax(sourceConfiguration, new File(SYNTAXDEFINITION), targetConfiguration);
            assertFalse("Must have completed without (critical) errors", errorHandler.hasFailedWithError());
            assertEquals(LANGUAGE_NAME, syntaxBean.getSyntax().getName());
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
            // Move mapping to target resource. This will cause the appropriate
            // URIs to be generated into the parser. Can't save to this resource because
            // we want a platform plugin URI. Move again after parser generation to be
            // able to save.
            Resource mappingResource = sourceConfiguration.getResourceSet().createResource(URI.createPlatformPluginURI(
                    "/com.sap.furcas.parser.tcs/"+MAPPINGS+"/"+LANGUAGE_NAME+".tcs", /* encode */ false));
            mappingResource.getContents().add(syntaxBean.getSyntax());
            generator.generateGrammarFromSyntax(syntaxBean, sourceConfiguration, targetConfiguration, errorHandler);
            assertFalse("Must have completed without (critical) errors", errorHandler.hasFailedWithError());
            FileOutputStream outputStream = new FileOutputStream(new File(GENERATIONDIR+LANGUAGE_NAME+".tcs"));
            mappingResource.save(outputStream, null);
            outputStream.close();
        } catch (Exception e) {
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
