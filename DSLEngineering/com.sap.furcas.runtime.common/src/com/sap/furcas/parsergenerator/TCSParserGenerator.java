package com.sap.furcas.parsergenerator;

import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;


/**
 * Generator facade featuring the generation of ANTLR grammars from TCS syntaxes, and subsequently, featuring the generation of
 * lexers and parsers from these grammars.
 * 
 * @author Stephan Erb (d049157)
 * 
 */
public interface TCSParserGenerator {

    public ConcreteSyntax generateGrammarFromSyntax(GrammarGenerationSourceConfiguration sourceConfiguration, GrammarGenerationTargetConfiguration targetConfiguration, GenerationErrorHandler errorhandler) throws GrammarGenerationException;
    
    public void generateParserFromGrammar(GrammarGenerationTargetConfiguration targetConfiguration, GenerationErrorHandler errorhandler);

}