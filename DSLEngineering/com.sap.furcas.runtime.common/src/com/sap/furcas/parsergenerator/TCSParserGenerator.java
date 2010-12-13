package com.sap.furcas.parsergenerator;

import java.io.File;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.runtime.common.exceptions.ParserInvokationException;

/**
 * Generator facade featuring the generation of ANTLR grammars from TCS syntaxes, and subsequently, featuring the generation of
 * lexers and parsers from these grammars.
 * 
 * @author Stephan Erb (d049157)
 * 
 */
public interface TCSParserGenerator {

    public TCSSyntaxContainerBean parseSyntax(GrammarGenerationSourceConfiguration sourceConfiguration, File syntaxDefFile) throws ParserInvokationException;

    public void generateGrammarFromSyntax(TCSSyntaxContainerBean syntaxBean,
            GrammarGenerationSourceConfiguration sourceConfiguration, GrammarGenerationTargetConfiguration targetConfiguration,
            GenerationErrorHandler errorhandler) throws GrammarGenerationException;

    public void generateParserFromGrammar(GrammarGenerationTargetConfiguration targetConfiguration,
            GenerationErrorHandler errorhandler);

    /**
     * Same as {@link #parseSyntax(GrammarGenerationSourceConfiguration, File)}
     * but additionally assigns the created {@link ConcreteSyntax} element to
     * the mapping {@link Resource} given by the
     * {@link GrammarGenerationTargetConfiguration <tt>tagetConfig</tt>}
     * 
     * @param sourceConfig
     *            the source config defining which {@link ResourceSet} and
     *            lookup scope to use.
     * @param syntaxDefFile
     *            the file from where to read the syntax.
     * @param targetConfig
     *            specifies to which resource (
     *            {@link GrammarGenerationTargetConfiguration#getMappingResource()}
     *            to use to store the syntax model.
     * @return The {@link TCSSyntaxContainerBean} representing the parse result.
     * @throws ParserInvokationException
     */
    public TCSSyntaxContainerBean parseSyntax(
            GrammarGenerationSourceConfiguration sourceConfig,
            File syntaxDefFile,
            GrammarGenerationTargetConfiguration targetConfig)
            throws ParserInvokationException;

    /**
     * Same as {@link #parseSyntax(GrammarGenerationSourceConfiguration, File, GrammarGenerationTargetConfiguration)}
     * but additionally uses the given {@link GenerationErrorHandler} to pass errors to.
     * 
   * @param sourceConfig
     *            the source config defining which {@link ResourceSet} and
     *            lookup scope to use.
     * @param syntaxDefFile
     *            the file from where to read the syntax.
     * @param targetConfig
     *            specifies to which resource (
     *            {@link GrammarGenerationTargetConfiguration#getMappingResource()}
     *            to use to store the syntax model.
     * @param resourceMarkingGenerationErrorHandler
     *            used to pass error markers to.
     * @return The {@link TCSSyntaxContainerBean} representing the parse result.
     * @throws ParserInvokationException
     */
    public TCSSyntaxContainerBean parseSyntax(
            GrammarGenerationSourceConfiguration sourceConfig,
            File syntaxDefFile,
            GrammarGenerationTargetConfiguration targetConfig,
            GenerationErrorHandler resourceMarkingGenerationErrorHandler)
            throws ParserInvokationException;

}