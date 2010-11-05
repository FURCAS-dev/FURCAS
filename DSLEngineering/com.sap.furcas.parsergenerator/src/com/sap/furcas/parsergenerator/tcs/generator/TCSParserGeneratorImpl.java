package com.sap.furcas.parsergenerator.tcs.generator;

import com.sap.furcas.parsergenerator.GenerationErrorHandler;
import com.sap.furcas.parsergenerator.GrammarGenerationException;
import com.sap.furcas.parsergenerator.GrammarGenerationSourceConfiguration;
import com.sap.furcas.parsergenerator.GrammarGenerationTargetConfiguration;
import com.sap.furcas.parsergenerator.TCSParserGenerator;

public class TCSParserGeneratorImpl implements TCSParserGenerator {

    @Override
    public void generateGrammarFromSyntax(GrammarGenerationSourceConfiguration sourceConfiguration,
            GrammarGenerationTargetConfiguration targetConfiguration, GenerationErrorHandler errorhandler)
            throws GrammarGenerationException {

        GrammarGenerator.buildGrammar(sourceConfiguration, targetConfiguration, errorhandler);
    }

    @Override
    public void generateParserFromGrammar(GrammarGenerationTargetConfiguration targetConfiguration,
            GenerationErrorHandler errorhandler) {

        ParserGenerator.buildParser(targetConfiguration.getGrammarTargetFile(), errorhandler);
    }

}
