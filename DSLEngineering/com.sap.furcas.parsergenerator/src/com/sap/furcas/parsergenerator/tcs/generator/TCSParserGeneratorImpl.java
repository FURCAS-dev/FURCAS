package com.sap.furcas.parsergenerator.tcs.generator;

import java.io.File;

import com.sap.furcas.parsergenerator.GenerationErrorHandler;
import com.sap.furcas.parsergenerator.GrammarGenerationException;
import com.sap.furcas.parsergenerator.GrammarGenerationSourceConfiguration;
import com.sap.furcas.parsergenerator.GrammarGenerationTargetConfiguration;
import com.sap.furcas.parsergenerator.TCSParserGenerator;
import com.sap.furcas.parsergenerator.TCSSyntaxContainerBean;
import com.sap.furcas.runtime.common.exceptions.ParserInvokationException;

public class TCSParserGeneratorImpl implements TCSParserGenerator {

    @Override
    public void generateGrammarFromSyntax(GrammarGenerationSourceConfiguration sourceConfiguration,
            GrammarGenerationTargetConfiguration targetConfiguration, GenerationErrorHandler errorhandler, TCSSyntaxContainerBean containerBean)
            throws GrammarGenerationException {
        GrammarGenerator.buildGrammar(sourceConfiguration, targetConfiguration, errorhandler, containerBean);
    }

    @Override
    public void generateParserFromGrammar(GrammarGenerationTargetConfiguration targetConfiguration,
            GenerationErrorHandler errorhandler) {

        ParserGenerator.buildParser(targetConfiguration.getGrammarTargetFile(), errorhandler);
    }

    @Override
    public TCSSyntaxContainerBean parseSyntax(GrammarGenerationSourceConfiguration sourceConfiguration, File syntaxDefFile) throws ParserInvokationException{
        return SyntaxParser.parse(sourceConfiguration, syntaxDefFile);
    }


}
