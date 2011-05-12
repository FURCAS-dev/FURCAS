package com.sap.furcas.ide.parserfactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.TokenStream;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.sap.furcas.modeladaptation.emf.adaptation.EMFModelAdapter;
import com.sap.furcas.runtime.common.interfaces.IRuleName;
import com.sap.furcas.runtime.common.util.EcoreHelper;
import com.sap.furcas.runtime.parser.ANTLR3LocationToken;
import com.sap.furcas.runtime.parser.InjectionOptionsBean;
import com.sap.furcas.runtime.parser.antlr3.ITokenFactory;
import com.sap.furcas.runtime.parser.impl.ModelInjector;
import com.sap.furcas.runtime.parser.impl.ObservableInjectingParser;
import com.sap.furcas.runtime.parser.textblocks.ITextBlocksTokenStream;
import com.sap.furcas.runtime.parser.textblocks.TextBlocksAwareModelAdapter;
import com.sap.furcas.runtime.parser.textblocks.observer.ParserTextBlocksHandler;
import com.sap.furcas.runtime.tcs.RuleNameFinder;
import com.sap.furcas.runtime.tcs.TcsUtil;
import com.sap.ide.cts.parser.incremental.antlr.ANTLRParserFactory;


public abstract class AbstractParserFactory<P extends ObservableInjectingParser, L extends Lexer>
	extends ANTLRParserFactory<P, L> {

    @Override
	public abstract EPackage getMetamodelPackage(ResourceSet connection);
	
	@Override
	public P createParser(TokenStream input, ResourceSet connection) {
		return createParser(input, connection, null, null);
	}

    @Override
	public P createParser(TokenStream input, ResourceSet resourceSet, Collection<URI> additionalPRIScope, Collection<URI> additionalCRIScope) {
        
		Collection<URI> priScope = new HashSet<URI>();
		Collection<URI> parserScope = getParserLookupScope(resourceSet);
		for (URI pri : parserScope) {
			priScope.add(pri);
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

			EPackage metamodelPackage = getMetamodelPackage(resourceSet);
			Set<URI> scope = new HashSet<URI>(priScope);
			if(additionalCRIScope != null) {
				scope.addAll(additionalCRIScope);
			}
			
		        Resource transientResource = EcoreHelper.createTransientParsingResource(resourceSet, metamodelPackage);
			TextBlocksAwareModelAdapter ma = new TextBlocksAwareModelAdapter(new EMFModelAdapter(resourceSet,
			        transientResource, Collections.singleton(getMetamodelUri(resourceSet)), scope));
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
					(ITextBlocksTokenStream) input, resourceSet,
					getMetamodelUri(resourceSet), TcsUtil.getSyntaxPartitions(
						resourceSet, getLanguageId()), priScope,
					additionalCRIScope));
			}
			return parser;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Set<URI> getParserLookupScope(ResourceSet connection) {
		return Collections.emptySet();
	}

	@Override
	public URI getMetamodelUri(ResourceSet connection) {
		EPackage mmPackage = getMetamodelPackage(connection);
		return mmPackage.eResource().getURI();
	}
	
	@Override
	public URI getSyntaxUri() {
	    //TODO default position of the mapping model file
	    return null;
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
		}catch(Exception e) {
			return null;
		}
	}
	
	@Override
	public IRuleName getRuleNameFinder() {
	    return new RuleNameFinder();
	}

}
