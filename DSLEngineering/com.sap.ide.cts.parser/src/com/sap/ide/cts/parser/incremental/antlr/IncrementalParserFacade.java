package com.sap.ide.cts.parser.incremental.antlr;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.List;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.Lexer;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xml.type.internal.DataValue.URI;

import com.sap.furcas.metamodel.textblocks.TextBlock;
import com.sap.furcas.metamodel.textblocks.Version;
import com.sap.furcas.runtime.parser.IModelAdapter;
import com.sap.furcas.runtime.parser.exceptions.UnknownProductionRuleException;
import com.sap.furcas.runtime.parser.impl.ModelInjector;
import com.sap.furcas.runtime.parser.impl.ObservableInjectingParser;
import com.sap.furcas.runtime.parser.impl.ParsingError;
import com.sap.furcas.runtime.parser.textblocks.observer.ParserTextBlocksHandler;
import com.sap.furcas.runtime.tcs.TcsUtil;
import com.sap.furcas.runtime.textblocks.modifcation.TbVersionUtil;
import com.sap.ide.cts.parser.incremental.IncrementalParser;
import com.sap.ide.cts.parser.incremental.ParserFactory;
import com.sap.ide.cts.parser.incremental.TextBlockReuseStrategyImpl;


/**
 * Facade for handling incremental parser and lexer construction as well as
 * calling of parsing methods.
 * 
 * @author C5106462
 * 
 */
public class IncrementalParserFacade {

	private final ParserFactory<? extends ObservableInjectingParser, ? extends Lexer> parserFactory;
	private final ANTLRIncrementalLexerAdapter incrementalLexer;
	private final ANTLRIncrementalTokenStream tbTokenStream;
	private final ObservableInjectingParser domainParser;
	private final IncrementalParser incrementalParser;
	private final ModelInjector injector;
	private int TT_NL;
	private int TT_WS;
	private int TT_COMMENT;
	private final ParserTextBlocksHandler observer;
	private int TT_MULTI_COMMENT;

	public IncrementalParserFacade(
			ParserFactory<? extends ObservableInjectingParser, ? extends Lexer> parserFactory,
			IModelAdapter modelAdapter, ResourceSet connection,
			Collection<URI> additionalCRIScope) {
		this.parserFactory = parserFactory;
		// TODO use token wrapper factory her
		TextBlockReuseStrategyImpl reuseStrategy = new TextBlockReuseStrategyImpl(
				parserFactory.createLexer(null), modelAdapter);
		Lexer domainLexer = parserFactory.createLexer(null);
		ANTLRLexerAdapter lexerAdapter = new ANTLRLexerAdapter(domainLexer,
				reuseStrategy, connection);
		incrementalLexer = new ANTLRIncrementalLexerAdapter(lexerAdapter,
				modelAdapter, connection);
		tbTokenStream = (ANTLRIncrementalTokenStream) parserFactory
				.createIncrementalTokenStream(incrementalLexer);

		this.domainParser = parserFactory.createParser(tbTokenStream,
				connection);

		incrementalParser = new IncrementalParser(connection, parserFactory,
				incrementalLexer, domainParser, reuseStrategy,
				additionalCRIScope);

		// TODO use token wrapper factory here
		this.injector = new ModelInjector(domainParser.getTokenNames());
		injector.setModelAdapter(modelAdapter);

		domainParser.setInjector(injector);

		observer = new ParserTextBlocksHandler(tbTokenStream, connection,
				parserFactory.getMetamodelUri(connection), TcsUtil
						.getSyntaxePartitions(connection, parserFactory
								.getLanguageId()), parserFactory
						.getParserLookupScope(connection), additionalCRIScope);
		domainParser.setObserver(observer);
		try {
			try {
				Field f = domainLexer.getClass().getField("ei");
				f.set(domainLexer, injector);
			} catch (NoSuchFieldException nsfe) {
				System.out
						.println("Warning, lexer has no ModelInjector field ei, lexer errors will only be reported to System.err");
			}

			TT_NL = ((Integer) domainParser.getClass().getField("NL").get(null))
					.intValue();

			TT_WS = ((Integer) domainParser.getClass().getField("WS").get(null))
					.intValue();
			TT_COMMENT = ((Integer) domainParser.getClass().getField("COMMENT")
					.get(null)).intValue();
			// TT_MULTI_COMMENT = ((Integer) domainParser.getClass().getField(
			// "MULTI_LINE_COMMENT").get(null)).intValue();
		} catch (IllegalArgumentException e) {
			throw new RuntimeException(e);
		} catch (SecurityException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		} catch (NoSuchFieldException e) {
			throw new RuntimeException(e);
		}

		tbTokenStream.setTokenTypeChannel(TT_NL, 99);

		// tbTokenStream.discardTokenType(TT_WS);
		tbTokenStream.setTokenTypeChannel(TT_WS, 99);
		tbTokenStream.setTokenTypeChannel(TT_COMMENT, 99);
		tbTokenStream.setTokenTypeChannel(TT_MULTI_COMMENT, 99);
	}

	/**
	 * returns a modelElement as created by the ModelAdapter, or null
	 * 
	 * @param in
	 * @param productionRule
	 * @param targetModelAdapter
	 * @param bean
	 * @param observer
	 * @return
	 * @throws IOException
	 * @throws UnknownProductionRuleException
	 */
	public Object parse(TextBlock rootBlock, String productionRule)
			throws IOException, UnknownProductionRuleException {
		if (productionRule == null) {
			productionRule = "main";
		}
		Object parsedModelElement = null;
		try {
			if (lexAndPrepareParsing(rootBlock)) {
				TextBlock preparedTextBlock = getCurrentVersion(rootBlock);
				incrementalLexer.setCurrentTokenForParser(preparedTextBlock
						.getTokens().get(0));
				observer.setRootBlock(preparedTextBlock);
				// if lexing was not successful, there is no chance that parsing
				// will be
				Method productionRuleMethod = domainParser.getClass()
						.getMethod(productionRule, (Class[]) null);

				if (!Modifier.isFinal(productionRuleMethod.getModifiers())) {
					throw new UnknownProductionRuleException(productionRule
							+ " is not a production rule in generated Parser.");
				}

				parsedModelElement = productionRuleMethod.invoke(domainParser,
						(Object[]) null);

				domainParser.setDelayedReferencesAfterParsing();
			}

		} catch (java.lang.reflect.InvocationTargetException ite) {
			if (ite.getCause() != null
					&& ite.getCause() instanceof IncompatibleClassChangeError) {
				// was once caused by having DSLParsing.jar deployed in 2
				// plugins at the same time
				throw new RuntimeException(
						"Tip: Check classes are only once on the classpath.",
						ite);
			} else {
				throw new RuntimeException("invoking method " + productionRule
						+ "() on parser class " + domainParser.getClass()
						+ " caused an exception.", ite);
			}
		} catch (IllegalAccessException e) {
			// all generated parsing rule methods should be public, so this
			// should never happen
			throw new RuntimeException(e);
		} catch (NoSuchMethodException e) {
			throw new UnknownProductionRuleException("No production rule "
					+ productionRule + " known in parser "
					+ domainParser.getClass().getName());
		}

		return parsedModelElement;
	}

	/**
	 * Uses the {@link IncrementalParser} to parse only the necessary parts of
	 * the given root {@link TextBlock}.
	 * 
	 * @param rootBlock
	 * @return
	 */
	public TextBlock parseIncrementally(TextBlock rootBlock) {
		if (lexAndPrepareParsing(rootBlock)) {
			TextBlock preparedTextBlock = getCurrentVersion(rootBlock);
			incrementalLexer.setCurrentTokenForParser(preparedTextBlock
					.getTokens().get(0));
			observer.setRootBlock(preparedTextBlock);
			TextBlock newRoot = incrementalParser
					.incrementalParse(preparedTextBlock);
			return newRoot;
		} else {
			return rootBlock;
		}
	}
	
	public List<ParsingError> dryParse(TextBlock rootBlock) {
		ObservableInjectingParser p = getParserFactory().createParser(
				new CommonTokenStream(getParserFactory().createLexer(
						new ANTLRStringStream(rootBlock.getCachedString()))),
				TcsUtil.getConnectionFromRefObject(rootBlock));
		return p.checkSyntaxWithoutInjecting();
	}

	public static Object getParsingResult(TextBlock rootBlock) {
		Collection<EObject> result = rootBlock
				.getCorrespondingModelElements();
		if (result.size() == 0) {
			return null;
		} else if (result.size() == 1) {
			return result.iterator().next();
		} else {
			return result;
		}
	}

	/**
	 * Preparse all components for a new parse run, such as resetting the batch
	 * parser and setting the source for the lexer.
	 * 
	 * @param rootBlock
	 *            the block that should be used to prepare parsing on
	 */
	private boolean lexAndPrepareParsing(TextBlock rootBlock) {
		// reset parser states to beginning
		domainParser.reset();
		// go back to beginning of stream
		tbTokenStream.reset();
		TextBlock previousVersionTb = TbVersionUtil.getOtherVersion(rootBlock,
				Version.PREVIOUS);
		incrementalLexer.setSource(previousVersionTb.getTokens().get(0));
		boolean lexingSuccessful = incrementalLexer.lex(previousVersionTb);

		return lexingSuccessful;
	}

	private TextBlock getCurrentVersion(TextBlock rootBlock) {
		TextBlock currentVersionTb = TbVersionUtil.getOtherVersion(rootBlock,
				Version.CURRENT);
		return currentVersionTb;
	}

	/**
	 * Returns the errors that where collected during the parse run.
	 * 
	 * @return the list of {@link ParsingError} that occured during parsing.
	 */
	public List<ParsingError> getErrors() {
		return injector.getErrorList();
	}

	public Class<? extends Lexer> getLexerClass() {
		return parserFactory.getLexerClass();
	}

	public Class<? extends ObservableInjectingParser> getParserClass() {
		return parserFactory.getParserClass();
	}
	
	public ParserFactory<? extends ObservableInjectingParser, ? extends Lexer> getParserFactory() {
		return parserFactory;
	}
}
