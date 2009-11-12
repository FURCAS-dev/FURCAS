/*******************************************************************************
 * Copyright (c) 2008 SAP
 * see https://research.qkal.sap.corp/mediawiki/index.php/CoMONET
 * 
 * Date: $Date: 2009-11-10 14:52:04 +0100 (Di, 10 Nov 2009) $
 * Revision: $Revision: 8522 $
 * Author: $Author: d043530 $
 *******************************************************************************/
package com.sap.mi.textual.grammar;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.antlr.runtime.Lexer;
import org.antlr.runtime.Parser;

import com.sap.mi.textual.grammar.exceptions.InvalidParserImplementationException;
import com.sap.mi.textual.grammar.exceptions.UnknownProductionRuleException;
import com.sap.mi.textual.grammar.impl.IParsingObserver;
import com.sap.mi.textual.grammar.impl.ObservableInjectingParser;
import com.sap.mi.textual.grammar.impl.ParsingError;
import com.sap.mi.textual.grammar.impl.TextLocation;
import com.sap.mi.textual.grammar.wrapper.GeneratedParserWrapper;

/**
 * The parser Facade provides access to the model injecting capabilities of a generated parser.
 * The facade is initialized by looking up a generated instance of org.antlr.Parser and Lexer,
 * then allows to use these for parsing of inputStreams any number of times.
 */
public class ParserFacade  {

    private final GeneratedParserWrapper wrapper;
 
    @SuppressWarnings("unchecked")
    public ParserFacade(Class parserClass, Class lexerClass) throws InvalidParserImplementationException  {
        wrapper = new GeneratedParserWrapper(parserClass, lexerClass );
    }
    
    public ParserFacade(ObservableInjectingParser parser, Lexer lexer) throws InvalidParserImplementationException  {
        wrapper = new GeneratedParserWrapper(parser, lexer );
    }
    
    /**
     * 
     * @param in may not be null
     * @param modelHandler may not be null
     * @param productionRule may be null, then main will be used
     * @param bean may be null, then default will be used
     * @param observer may be null
     * @return a result containing the root parsed modelElement (or a Collection of roots), errors, and a map of text locations for elements
     * @throws IOException
     * @throws UnknownProductionRuleException
     */
    public ModelParsingResult parseProductionRule( InputStream in, IModelAdapter modelHandler, String productionRule, InjectionOptionsBean bean, IParsingObserver observer)
    throws IOException, UnknownProductionRuleException {
        if (in == null || modelHandler == null  ) {
            throw new IllegalArgumentException("One of the arguments is null");
        }
        if (productionRule == null) {
            productionRule = "main";
        }
        if (bean == null) {
            // create the default options
            bean = new InjectionOptionsBean();
        }
        assert wrapper != null; // done by constructor
        Object parsedModelElement = wrapper.parse(in, productionRule, modelHandler, bean, observer);
        
        List<ParsingError> errors = wrapper.getErrors();
        Map<Object, TextLocation> locMap = wrapper.getLocationMap();
        ModelParsingResult pr = new ModelParsingResult(parsedModelElement, errors, locMap);
        return pr;
    }
    
    public Class<? extends Parser> getParserClass() {
    	return wrapper.getParserClass();
    }
    
    public Class<? extends Lexer> getLexerClass() {
    	return wrapper.getLexerClass();
    }
//    
//    public ModelParsingResult parseProductionRule( InputStream in, IModelAdapter modelHandler, String productionRule, InjectionOptionsBean bean)
//    throws IOException, UnknownProductionRuleException {
//        return parseProductionRule(in, modelHandler, productionRule, bean, null);
//    }
//    
//    
//    /**
//     * parses uses default production rule
//     */
//    public ModelParsingResult parse(InputStream in, IModelAdapter modelHandler)
//            throws IOException, UnknownProductionRuleException {
//
//        return parse(in, modelHandler, (InjectionOptionsBean) null);
//    }
//
//    public ModelParsingResult parse(  InputStream in, IModelAdapter modelHandler, InjectionOptionsBean bean)
//            throws IOException, UnknownProductionRuleException {
//
//        String productionRule = "main";
//        return parseProductionRule(in, modelHandler, productionRule, bean);
//    }
//
//    public ModelParsingResult parseProductionRule(InputStream in, IModelAdapter modelHandler, String productionRule)
//            throws IOException, UnknownProductionRuleException {
//        return parseProductionRule(in, modelHandler, productionRule, null );
//    }
}



