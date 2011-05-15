package com.sap.furcas.ide.parserfactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.TokenStream;

import com.sap.furcas.runtime.common.exceptions.ParserInstantiationException;
import com.sap.furcas.runtime.common.interfaces.IRuleName;
import com.sap.furcas.runtime.parser.ANTLR3LocationToken;
import com.sap.furcas.runtime.parser.IModelAdapter;
import com.sap.furcas.runtime.parser.InjectionOptionsBean;
import com.sap.furcas.runtime.parser.antlr3.ITokenFactory;
import com.sap.furcas.runtime.parser.impl.ModelInjector;
import com.sap.furcas.runtime.parser.impl.ObservableInjectingParser;
import com.sap.furcas.runtime.tcs.RuleNameFinder;
import com.sap.ide.cts.parser.incremental.antlr.ANTLRParserFactory;

public abstract class AbstractParserFactory<P extends ObservableInjectingParser, L extends Lexer> extends ANTLRParserFactory<P, L> {

    @Override
    public P createParser(TokenStream input, IModelAdapter modelAdapter) throws ParserInstantiationException {
        try {
            Class<P> parserClass = getParserClass();
            Constructor<P> c = parserClass.getConstructor(TokenStream.class);
            P parser;
            parser = c.newInstance(input);
            ModelInjector mi = new ModelInjector(parser.getTokenNames());
            InjectionOptionsBean injectionOptionsBean = new InjectionOptionsBean();
            injectionOptionsBean.setLocationsPropertyNameInModel(false, null);
            mi.setOptions(injectionOptionsBean);
            mi.setModelAdapter(modelAdapter);
            parser.setLanguageId(getLanguageId());
            parser.setInjector(mi);
            return parser;

        } catch (IllegalArgumentException e) {
            throw new ParserInstantiationException(e);
        } catch (InstantiationException e) {
            throw new ParserInstantiationException(e);
        } catch (IllegalAccessException e) {
            throw new ParserInstantiationException(e);
        } catch (InvocationTargetException e) {
            throw new ParserInstantiationException(e.getCause());
        } catch (SecurityException e) {
            throw new ParserInstantiationException(e);
        } catch (NoSuchMethodException e) {
            throw new ParserInstantiationException(e);
        }
    }

    @Override
    public L createLexer(CharStream input, ITokenFactory<? extends ANTLR3LocationToken> factory) {
        L lex = createLexer(input);
        try {
            Field tokenFactory = lex.getClass().getDeclaredField("tokenFactory");
            tokenFactory.set(lex, factory);
            return lex;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public L createLexer(CharStream input) {
        try {
            Constructor<L> c = getLexerClass().getConstructor(CharStream.class);
            L lexer = c.newInstance(input);
            return lexer;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getSyntaxUUID() {
        Class<P> parserClass = getParserClass();
        try {
            Constructor<P> c = parserClass.getConstructor(TokenStream.class);
            P parser = c.newInstance(new ANTLRStringStream());
            return parser.getSyntaxUUID();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public IRuleName getRuleNameFinder() {
        return new RuleNameFinder();
    }

}
