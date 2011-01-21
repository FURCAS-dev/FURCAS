package com.sap.furcas.parsergenerator;

import java.io.File;
import java.util.Collection;
import java.util.List;

import com.sap.furcas.runtime.common.exceptions.ParserInvokationException;

/**
 * Generator facade featuring the generation of ANTLR grammars from TCS
 * syntaxes, and subsequently, featuring the generation of lexers and parsers
 * from these grammars.
 * 
 * @author Stephan Erb (d049157)
 * 
 */
public interface TCSParserGenerator {

	public TCSSyntaxContainerBean parseSyntax(
			GrammarGenerationSourceConfiguration sourceConfiguration,
			File syntaxDefFile) throws ParserInvokationException;
	
	public TCSSyntaxContainerBeanWithConfig parseSyntaxWithConfig(
			GrammarGenerationSourceConfiguration sourceConfiguration,
			File syntaxDefFile, Collection<File>syntaxDefFiles) throws ParserInvokationException;

	public void generateGrammarFromSyntax(TCSSyntaxContainerBean syntaxBean,
			GrammarGenerationSourceConfiguration sourceConfiguration,
			GrammarGenerationTargetConfiguration targetConfiguration,
			GenerationErrorHandler errorhandler)
			throws GrammarGenerationException;

	public void generateParserFromGrammar(
			GrammarGenerationTargetConfiguration targetConfiguration,
			GenerationErrorHandler errorhandler);
	
	void generateGrammarFromSyntaxWithConfiguration(TCSSyntaxContainerBeanWithConfig syntaxBeanWithConfiguration,GrammarGenerationSourceConfiguration sourceConfiguration,
			GrammarGenerationTargetConfiguration targetConfiguration,
			File configurationFile,List<File> syntaxFiles,
			GenerationErrorHandler errorhandler)
			throws GrammarGenerationException;

	void generateGrammarFromSyntaxWithConfig(
			TCSSyntaxContainerBeanWithConfig syntaxBean,
			GrammarGenerationSourceConfiguration sourceConfiguration,
			GrammarGenerationTargetConfiguration targetConfiguration,
			GenerationErrorHandler errorhandler)
			throws GrammarGenerationException;

}