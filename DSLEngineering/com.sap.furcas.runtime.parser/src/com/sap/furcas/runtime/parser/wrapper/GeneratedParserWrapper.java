/*******************************************************************************
 * Copyright (c) 2008 SAP
 * see https://research.qkal.sap.corp/mediawiki/index.php/CoMONET
 * 
 * Date: $Date: 2010-02-05 15:00:44 +0100 (Fr, 05 Feb 2010) $
 * Revision: $Revision: 9371 $
 * Author: $Author: c5106462 $
 *******************************************************************************/
package com.sap.furcas.runtime.parser.wrapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.List;
import java.util.Map;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.Parser;
import org.antlr.runtime.TokenStream;

import com.sap.furcas.runtime.parser.IModelAdapter;
import com.sap.furcas.runtime.parser.IParsingObserver;
import com.sap.furcas.runtime.parser.InjectionOptionsBean;
import com.sap.furcas.runtime.parser.ParsingError;
import com.sap.furcas.runtime.parser.TextLocation;
import com.sap.furcas.runtime.parser.exceptions.InvalidParserImplementationException;
import com.sap.furcas.runtime.parser.exceptions.UnknownProductionRuleException;
import com.sap.furcas.runtime.parser.impl.ModelInjector;
import com.sap.furcas.runtime.parser.impl.ObservableInjectingParser;


/**
 * This class provides access to parsers generated for SAP DSL Engineering.
 * Such generated classes extend org.antlr.Parser and org.antlr.Lexer, but also have 
 * some additional members, such as one method for each production Rule.
 *  This class provides access to these members.
 */
public class GeneratedParserWrapper {

    private ObservableInjectingParser parser;
    private Lexer lexer;

    private Class<? extends Parser> parserClass;
	private Class<? extends Lexer> lexerClass;


    private int TT_NL;
    private int TT_WS;
    private int TT_COMMENT;

    private ModelInjector injector;


    /**
     * @param parserClass
     * @param lexerClass
     * @throws NoSuchMethodException 
     * @throws InvocationTargetException 
     * @throws IllegalAccessException 
     * @throws InstantiationException 
     * @throws SecurityException 
     * @throws IllegalArgumentException 
     * @throws NoSuchFieldException 
     */
    public GeneratedParserWrapper(Class<? extends ObservableInjectingParser> parserClass, Class<? extends Lexer> lexerClass) throws InvalidParserImplementationException  {
        if(parserClass == null || lexerClass == null) {
            throw new IllegalArgumentException("parserClass or lexerclass is null:" + parserClass + "," + lexerClass);
        }
        try {
            this.lexer = lexerClass.getDeclaredConstructor((Class[]) null).newInstance((Object[])null);
            this.parser = parserClass.getDeclaredConstructor(new Class[] {TokenStream.class}).newInstance(new Object[] {null});    
            this.parserClass = parserClass;
            this.lexerClass = lexerClass;
    
            this.injector = new ModelInjector(parser.getTokenNames());
//            Field f = parserClass.getField("ei");
//            f.set(parser, injector);
   
            parser.setInjector(injector);
            
            try {
                Field f = lexerClass.getField("ei");
                f.set(lexer, injector);
            } catch (NoSuchFieldException nsfe) {
                System.out.println("Warning, lexer has no ModelInjector fiel ei, lexer errors will only be reported to System.err");
            }
            
            TT_NL = ((Integer)parserClass.getField("NL").get(null)).intValue();
            TT_WS = ((Integer) parserClass.getField("WS").get(null)).intValue();
            TT_COMMENT = ((Integer) parserClass.getField("COMMENT").get(null))
                    .intValue();
        } catch (IllegalArgumentException e) {
            throw new InvalidParserImplementationException(e);
        } catch (InstantiationException e) {
            throw new InvalidParserImplementationException(e);
        } catch (IllegalAccessException e) {
            throw new InvalidParserImplementationException(e);
        } catch (InvocationTargetException e) {
            throw new InvalidParserImplementationException(e);
        } catch (NoSuchMethodException e) {
            throw new InvalidParserImplementationException(e);
        } catch (NoSuchFieldException e) {
            throw new InvalidParserImplementationException(e);
        }

    }



    /**
     * @param parser2
     * @param lexer2
     * @throws InvalidParserImplementationException 
     */
    public GeneratedParserWrapper(ObservableInjectingParser parser2, Lexer lexer2) throws InvalidParserImplementationException {
        this.lexer = lexer2;
        this.parser = parser2;    
        this.parserClass = parser.getClass();

        this.injector = new ModelInjector(parser.getTokenNames());
//      Field f = parserClass.getField("ei");
//      f.set(parser, injector);
        try {
            parser.setInjector(injector);

            try {
                Field f = lexer.getClass().getField("ei");
                f.set(lexer, injector);
            } catch (NoSuchFieldException nsfe) {
                System.out.println("Warning, lexer has no ModelInjector fiel ei, lexer errors will only be reported to System.err");
            }

            TT_NL = ((Integer)parserClass.getField("NL").get(null)).intValue();
            TT_WS = ((Integer) parserClass.getField("WS").get(null)).intValue();
            TT_COMMENT = ((Integer) parserClass.getField("COMMENT").get(null))
            .intValue();
        } catch (IllegalArgumentException e) {
            throw new InvalidParserImplementationException(e);
        } catch (IllegalAccessException e) {
            throw new InvalidParserImplementationException(e);
        } catch (NoSuchFieldException e) {
            throw new InvalidParserImplementationException(e);
        }

    }


    /**
     * returns a modelElement as cretaed by the ModelAdapter, or null
     * @param in
     * @param productionRule
     * @param targetModelAdapter
     * @param bean 
     * @param observer 
     * @return
     * @throws IOException 
     * @throws UnknownProductionRuleException 
     */
    public Object parse(InputStream in, String productionRule, IModelAdapter targetModelAdapter, InjectionOptionsBean bean, IParsingObserver observer) throws IOException, UnknownProductionRuleException {
        return parse(in, productionRule, targetModelAdapter, bean, observer, true);
    }
    /**
     * returns a modelElement as cretaed by the ModelAdapter, or null
     * @param in
     * @param productionRule
     * @param targetModelAdapter
     * @param bean 
     * @param observer 
     * @return
     * @throws IOException 
     * @throws UnknownProductionRuleException 
     */
    public Object parse(InputStream in, String productionRule, IModelAdapter targetModelAdapter, InjectionOptionsBean bean, IParsingObserver observer, boolean setDelayedreferences) throws IOException, UnknownProductionRuleException {
        if (in == null || productionRule == null || targetModelAdapter == null) {
            throw new IllegalArgumentException("Argument is null " + in + ", " + productionRule + ", " + targetModelAdapter);
        }
        Object parsedModelElement = null;
        this.injector.setModelAdapter(targetModelAdapter);
        this.injector.setOptions(bean);
        try {
           
            InputStreamReader isr = new InputStreamReader(in);
            Reader reader = new BufferedReader(isr);
            StringBuilder s = new StringBuilder();
            char buffer[] = new char[2048];
            int size;
            while((size = reader.read(buffer)) > 0) {
                s.append(buffer, 0, size);
            }
            ANTLRStringStream stream = new ANTLRStringStream(s.toString());

            lexer.setCharStream(stream);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
           
            tokens.setTokenTypeChannel(TT_NL, 99);

            tokens.discardTokenType(TT_WS);
            tokens.setTokenTypeChannel(TT_COMMENT, 99);

            parser.setTokenStream(tokens);
            parser.setObserver(observer);
            
            Method productionRuleMethod = parserClass.getMethod(productionRule, (Class[]) null);
            
          
            if (! Modifier.isFinal(productionRuleMethod.getModifiers())) {
                throw new UnknownProductionRuleException(productionRule + " is not a production rule in generated Parser.");
            }
            
            parsedModelElement = productionRuleMethod.invoke(parser, (Object[])null);
            
            if(setDelayedreferences) {
                parser.setDelayedReferencesAfterParsing();
            }
            
        } catch(java.lang.reflect.InvocationTargetException ite) {
            if (ite.getCause() != null && ite.getCause() instanceof IncompatibleClassChangeError) {
                // was once caused by having DSLParsing.jar deployed in 2 plugins at the same time 
                throw new RuntimeException("Tip: Check classes are only once on the classpath.", ite);
            } else {
                throw new RuntimeException("invoking method "+ productionRule + "() on parser class " + parserClass + " caused an exception.", ite);
            }
        } catch (IllegalAccessException e) {
            // all generated parsing rule methods should be public, so this should never happen
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new UnknownProductionRuleException("No production rule " + productionRule + " known in parser " + parserClass.getName());
        }     

        return parsedModelElement;
    }



    /**
     * @return
     */
    public List<ParsingError> getErrors() {
        return injector.getErrorList();
    }
    
    /**
     * @return
     */
    public Map<Object, TextLocation> getLocationMap() {
        return injector.getLocationsMap();
    }
    
    public Class<? extends Parser> getParserClass() {
		return parserClass;
	}

	public Class<? extends Lexer> getLexerClass() {
		return lexerClass;
	}

 
    
}
