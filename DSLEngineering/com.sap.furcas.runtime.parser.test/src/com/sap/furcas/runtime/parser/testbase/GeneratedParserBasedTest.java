package com.sap.furcas.runtime.parser.testbase;

import com.sap.furcas.parsergenerator.GrammarGenerationException;
import com.sap.furcas.parsergenerator.TCSParserGenerator;
import com.sap.furcas.parsergenerator.TCSParserGeneratorFactory;
import com.sap.furcas.parsergenerator.TCSSyntaxContainerBean;
import com.sap.furcas.runtime.common.exceptions.ParserGeneratorInvocationException;
import com.sap.furcas.runtime.common.exceptions.ParserInvokationException;
import com.sap.furcas.runtime.parser.ParserFacade;
import com.sap.furcas.runtime.parser.exceptions.InvalidParserImplementationException;

/**
 * A Test base class that allows to generate a language specific parser from a given TCS file.
 * 
 * The base class is configured (what to create, where to create it, ...) with the help
 * {@link GeneratedParserTestConfiguration}.
 * 
 * @author Stephan Erb
 * 
 */
public abstract class GeneratedParserBasedTest {

    public static TCSSyntaxContainerBean parseSyntax(GeneratedParserTestConfiguration testConfig)
            throws ParserGeneratorInvocationException, ParserInvokationException {

        TCSParserGenerator generator = TCSParserGeneratorFactory.INSTANCE.createTCSParserGenerator();
        TCSSyntaxContainerBean syntaxBean = generator.parseSyntax(testConfig.getSourceConfiguration(), testConfig.getSyntaxDefinitionFile());
        
        return syntaxBean;
    }

    protected static ParserFacade generateParserForLanguage(TCSSyntaxContainerBean syntaxBean,
            GeneratedParserTestConfiguration testConfig, ClassLookup classLookup)
            throws GrammarGenerationException, ParserGeneratorInvocationException, InvalidParserImplementationException {
        
        ParserGenerator generator = new ParserGenerator(testConfig);
        try {
            generator.generateGrammar(syntaxBean);
            generator.generateParser();
            generator.compileParser();

            return generator.loadParserFacade(classLookup);
        } finally {
            generator.cleanUp();
        }
    }

}
