package com.sap.furcas.parsergenerator.tcs.generator;

import java.io.File;
import java.io.IOException;

import com.sap.furcas.parsergenerator.GenerationErrorHandler;
import com.sap.furcas.parsergenerator.GrammarGenerationException;
import com.sap.furcas.parsergenerator.GrammarGenerationSourceConfiguration;
import com.sap.furcas.parsergenerator.GrammarGenerationTargetConfiguration;
import com.sap.furcas.parsergenerator.TCSParserGenerator;
import com.sap.furcas.parsergenerator.TCSSyntaxContainerBean;
import com.sap.furcas.runtime.common.exceptions.ParserInvokationException;
import com.sap.furcas.runtime.parser.ParsingError;
import com.sap.furcas.runtime.parser.exceptions.SyntaxParsingException;

public class TCSParserGeneratorImpl implements TCSParserGenerator {
    
    @Override
    public TCSSyntaxContainerBean parseSyntax(GrammarGenerationSourceConfiguration sourceConfiguration, File syntaxDefFile) throws ParserInvokationException{
        return SyntaxParser.parse(sourceConfiguration, syntaxDefFile);
    }

    @Override
    public void generateGrammarFromSyntax(TCSSyntaxContainerBean syntaxBean,
            GrammarGenerationSourceConfiguration sourceConfiguration, GrammarGenerationTargetConfiguration targetConfiguration, GenerationErrorHandler errorhandler)
            throws GrammarGenerationException {
        GrammarGenerator.buildGrammar(sourceConfiguration, targetConfiguration, errorhandler, syntaxBean);
    }

    @Override
    public void generateParserFromGrammar(GrammarGenerationTargetConfiguration targetConfiguration,
            GenerationErrorHandler errorhandler) {

        ParserGenerator.buildParser(targetConfiguration.getGrammarTargetFile(), errorhandler);
    }

    @Override
    public TCSSyntaxContainerBean parseSyntax(
            GrammarGenerationSourceConfiguration sourceConfiguration,
            File syntaxDefFile,
            GrammarGenerationTargetConfiguration targetConfig) throws ParserInvokationException {
        TCSSyntaxContainerBean result = SyntaxParser.parse(sourceConfiguration, syntaxDefFile);
        if(targetConfig.getMappingResource() != null) {
            targetConfig.getMappingResource().getContents().add(result.getSyntax());
            try {
                targetConfig.getMappingResource().save(null);
            } catch (IOException e) {
                throw new RuntimeException(
                        "Could not save syntax mapping model to resource: "
                                + targetConfig.getMappingResource().getURI());
            }
        }
        return result;
    }

    @Override
    public TCSSyntaxContainerBean parseSyntax(
            GrammarGenerationSourceConfiguration sourceConfig,
            File syntaxDefFile,
            GrammarGenerationTargetConfiguration targetConfig,
            GenerationErrorHandler resourceMarkingGenerationErrorHandler) {
        TCSSyntaxContainerBean result = null;
        try {
            result = SyntaxParser.parse(sourceConfig, syntaxDefFile);
            if(targetConfig.getMappingResource() != null) {
                targetConfig.getMappingResource().getContents().add(result.getSyntax());
            
                    targetConfig.getMappingResource().save(null);
            
            }
        } catch (ParserInvokationException e1) {
            if(e1.getCause() instanceof SyntaxParsingException) {
                for (ParsingError pe : ((SyntaxParsingException) e1.getCause()).getErrorList()) {
                    resourceMarkingGenerationErrorHandler.error(pe);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(
                    "Could not save syntax mapping model to resource: "
                            + targetConfig.getMappingResource().getURI());
        }
        return result;
    }

}
