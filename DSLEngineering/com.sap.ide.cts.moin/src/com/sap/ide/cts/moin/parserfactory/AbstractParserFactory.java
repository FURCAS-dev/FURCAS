package com.sap.ide.cts.moin.parserfactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.sap.furcas.parsergenerator.emf.RuleNameFinder;
import com.sap.furcas.parsing.textblocks.ITextBlocksTokenStream;
import com.sap.furcas.parsing.textblocks.TextBlocksAwareModelAdapter;
import com.sap.furcas.parsing.textblocks.observer.ParserTextBlocksHandler;
import com.sap.furcas.runtime.common.interfaces.IRuleName;
import com.sap.furcas.runtime.parser.ANTLR3LocationToken;
import com.sap.furcas.runtime.parser.InjectionOptionsBean;
import com.sap.furcas.runtime.parser.antlr3.ITokenFactory;
import com.sap.furcas.runtime.parser.impl.ModelInjector;
import com.sap.furcas.runtime.parser.impl.ObservableInjectingParser;
import com.sap.ide.cts.parser.incremental.antlr.ANTLRParserFactory;
import com.sap.tc.moin.textual.emfadapter.adapter.MOINModelAdapter;


public abstract class AbstractParserFactory<P extends ObservableInjectingParser, L extends Lexer>
	extends ANTLRParserFactory<P, L> {
	private final IRuleName ruleNameFinder = new RuleNameFinder();

    @Override
	public abstract EPackage getMetamodelPackage(ResourceSet connection);

	/**
	 * Return the names of the constants that define the tokens in the parser class (see
	 * {@link #getParserClass()}) that are to be considered part of the so-called
	 * "hidden channel." Typical examples are comment token types such as "WS", "NL", "COMMENT",
	 * or "MULTI_LINE_COMMENT"
	 */
	public abstract String[] getHiddenChannelTokenNames();
	
	public abstract Integer[] getOmittedTokensForFormatting();

	@Override
	public P createParser(TokenStream input, ResourceSet connection) {
		return createParser(input, connection, null, null);
	}

	@Override
	public P createParser(TokenStream input, ResourceSet connection,
		Set<URI> additionalPRIScope, Set<URI> additionalCRIScope) {
		Set<URI> priScope = new HashSet<URI>();
		Collection<URI> parserScope = getParserLookupScope(connection);
		if (parserScope != null) {
			for (URI pri : parserScope) {
				priScope.add(pri);
			}
		}
		if (additionalPRIScope != null) {
			for (URI pri : additionalPRIScope) {
				priScope.add(pri);
			}
		}
		Class<P> parserClass = getParserClass();
		try {
			Constructor<P> c = parserClass.getConstructor(TokenStream.class);
			P parser = c.newInstance(input);
			if (input instanceof CommonTokenStream) {
				int[] hiddenChannelTokens = getHiddenChannelTokens();
				for (int hiddenChannelToken : hiddenChannelTokens) {
					((CommonTokenStream) input).setTokenTypeChannel(
						hiddenChannelToken, Token.HIDDEN_CHANNEL);
				}
			}

			EPackage metamodelPackage = getMetamodelPackage(connection);
			TextBlocksAwareModelAdapter ma = new TextBlocksAwareModelAdapter(
				new MOINModelAdapter(metamodelPackage, connection, priScope,
					additionalCRIScope));
			ModelInjector mi = new ModelInjector(parser.getTokenNames());
			InjectionOptionsBean injectionOptionsBean = new InjectionOptionsBean();
			injectionOptionsBean.setLocationsPropertyNameInModel(false, null);
			mi.setOptions(injectionOptionsBean);
			mi.setModelAdapter(ma);
			parser.setLanguageId(getLanguageId());
			parser.setInjector(mi);
			if (input instanceof ITextBlocksTokenStream) {
				ma.setTextBlocksStream((ITextBlocksTokenStream) input);
				parser.setObserver(new ParserTextBlocksHandler(
					(ITextBlocksTokenStream) input, connection,
					getMetamodelUri(connection), TcsUtil.getSyntaxePartitions(
						connection, getLanguageId()), priScope,
					additionalCRIScope));
			}
			return parser;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Collection<URI> getParserLookupScope(ResourceSet connection) {
		return null;
	}

	@Override
	public URI getMetamodelUri(ResourceSet connection) {
		EPackage mmPackage = getMetamodelPackage(connection);
		return mmPackage.eResource().getURI();
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

	public int[] getHiddenChannelTokens() {
		int[] result = new int[getHiddenChannelTokenNames().length];
		int i = 0;
		for (String tokenName : getHiddenChannelTokenNames()) {
			Field tokenConstant;
			try {
				tokenConstant = getParserClass().getDeclaredField(tokenName);
				int token = tokenConstant.getInt(null);
				result[i++] = token;
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		return result;
	}

	@Override
	public String getSyntaxUUID() {
		Class<P> parserClass = getParserClass();
		try {
			Constructor<P> c = parserClass.getConstructor(TokenStream.class);
			P parser = c.newInstance(new ANTLRStringStream());
			return parser.getSyntaxUUID();
		}catch(Exception e) {
			return null;
		}
	}
	
	@Override
	public IRuleName getRuleNameFinder() {
	    return ruleNameFinder;
	}

}
