/**
 * 
 */
package com.sap.furcas.parser.tcs.bootstrap;

import com.sap.furcas.parsergenerator.GrammarGenerationSourceConfiguration;
import com.sap.furcas.parsergenerator.GrammarGenerationTargetConfiguration;

/**
 *
 */
public class TCSBootStrap {

    private static final String GENERATIONDIR = "./generationTmp/";
    private static final String GRAMMAR = GENERATIONDIR + "TCS.g";
    private static final String SYNTAXDEFINITION = "./syntaxdefinition/TCS.tcs";
    
    private static GrammarGenerationSourceConfiguration sourceConfiguration;
    private static GrammarGenerationTargetConfiguration targetConfiguration;

//    
//    @BeforeClass
//    public static void setup() {
//        File grammarFile = new File(GRAMMAR);
//        File syntaxDefFile = new File(SYNTAXDEFINITION);
//
//        sourceConfiguration = new GrammarGenerationSourceConfiguration(syntaxDefFile, createResourceSet(), createReferenceScope());
//        targetConfiguration = new GrammarGenerationTargetConfiguration("", grammarFile);
//    }
//    
//    private static Set<URI> createReferenceScope() {
//        Set<URI> referenceScope = Collections.emptySet();
//        return referenceScope;
//    }
//
//    private static ResourceSet createResourceSet() {
//        ResourceSet resourceSet = new ResourceSetImpl();
//        resourceSet.getPackageRegistry().put(FURCASPackage.eNS_URI, FURCASPackage.eINSTANCE);
//        resourceSet.getPackageRegistry().put(FURCASPackage.eNAME, FURCASPackage.eINSTANCE);
//        return resourceSet;
//    }
//
//    /**
//     * Step 1: Parse the TCS.tcs and generate a corresponding ANTLR grammar.
//     */
//    @Test
//    public void step1_GenerateGrammar() throws GrammarGenerationException, ParserGeneratorInvocationException {
//        ErrorHandler errorHandler = new ErrorHandler();
//
//        TCSParserGenerator generator = TCSParserGeneratorFactory.INSTANCE.createTCSParserGenerator();
//        generator.generateGrammarFromSyntax(sourceConfiguration, targetConfiguration, errorHandler);
//
//        assertFalse("Must have completed without (critical) errors", errorHandler.hasFailedWithError());
//    }
//
//    /**
//     * Step 2: Use ANTLR to generate  TCSParser.java and TCSLexer.java.
//     */
//    @Test
//    public void step2_GenerateParser() throws GrammarGenerationException, ParserGeneratorInvocationException {
//        ErrorHandler errorHandler = new ErrorHandler();
//
//        TCSParserGenerator generator = TCSParserGeneratorFactory.INSTANCE.createTCSParserGenerator();
//        generator.generateGrammarFromSyntax(sourceConfiguration, targetConfiguration, errorHandler);
//        
//        assertFalse("Must have completed without (critical) errors", errorHandler.hasFailedWithError());
//    }
    
}
