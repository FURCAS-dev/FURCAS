package com.sap.furcas.parsergenerator.tcs.generator;

import java.io.File;
import java.util.Collection;
import java.util.List;

import com.sap.furcas.parsergenerator.GenerationErrorHandler;
import com.sap.furcas.parsergenerator.GrammarGenerationException;
import com.sap.furcas.parsergenerator.GrammarGenerationSourceConfiguration;
import com.sap.furcas.parsergenerator.GrammarGenerationTargetConfiguration;
import com.sap.furcas.parsergenerator.TCSParserGenerator;
import com.sap.furcas.parsergenerator.TCSSyntaxContainerBean;
import com.sap.furcas.parsergenerator.TCSSyntaxContainerBeanWithConfig;
import com.sap.furcas.runtime.common.exceptions.ParserInvokationException;

public class TCSParserGeneratorImpl implements TCSParserGenerator {

	@Override
	public TCSSyntaxContainerBean parseSyntax(
			GrammarGenerationSourceConfiguration sourceConfiguration,
			File syntaxDefFile) throws ParserInvokationException {
		return SyntaxParser.parse(sourceConfiguration, syntaxDefFile);
	}

	@Override
	public TCSSyntaxContainerBeanWithConfig parseSyntaxWithConfig(
			GrammarGenerationSourceConfiguration sourceConfiguration,
			File syntaxDefFile, Collection<File> syntaxDefFiles)
			throws ParserInvokationException {
		return SyntaxParser.parseWithConfig(sourceConfiguration, syntaxDefFile,
				syntaxDefFiles);
	}

	@Override
	public void generateParserFromGrammar(
			GrammarGenerationTargetConfiguration targetConfiguration,
			GenerationErrorHandler errorhandler) {
		ParserGenerator.buildParser(targetConfiguration.getGrammarTargetFile(),
				errorhandler);
	}

	@Override
	public void generateGrammarFromSyntax(TCSSyntaxContainerBean syntaxBean,
			GrammarGenerationSourceConfiguration sourceConfiguration,
			GrammarGenerationTargetConfiguration targetConfiguration,
			GenerationErrorHandler errorhandler)
			throws GrammarGenerationException {
		GrammarGenerator.buildGrammar(sourceConfiguration, targetConfiguration,
				errorhandler, syntaxBean);
	}

	@Override
	public void generateGrammarFromSyntaxWithConfig(
			TCSSyntaxContainerBeanWithConfig syntaxBean,
			GrammarGenerationSourceConfiguration sourceConfiguration,
			GrammarGenerationTargetConfiguration targetConfiguration,
			GenerationErrorHandler errorhandler)
			throws GrammarGenerationException {
		GrammarGenerator.buildGrammarWithConfig(sourceConfiguration,
				targetConfiguration, errorhandler, syntaxBean);
	}

	@Override
	public void generateGrammarFromSyntaxWithConfiguration(
			TCSSyntaxContainerBeanWithConfig syntaxBeanWithConfiguration,
			GrammarGenerationSourceConfiguration sourceConfiguration,
			GrammarGenerationTargetConfiguration targetConfiguration,
			File configurationFile, List<File> syntaxFiles,
			GenerationErrorHandler errorhandler)
			throws GrammarGenerationException {
		GrammarGenerator.buildGrammarWithConfiguration(
				syntaxBeanWithConfiguration, sourceConfiguration,
				targetConfiguration, configurationFile, syntaxFiles,
				errorhandler);
	}

}
