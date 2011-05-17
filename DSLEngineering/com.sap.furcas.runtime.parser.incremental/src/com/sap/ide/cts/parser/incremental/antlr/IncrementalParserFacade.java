package com.sap.ide.cts.parser.incremental.antlr;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.List;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.TokenSource;
import org.antlr.runtime.TokenStream;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.metamodel.FURCAS.textblocks.Version;
import com.sap.furcas.modeladaptation.emf.adaptation.EMFModelAdapter;
import com.sap.furcas.runtime.common.exceptions.ParserInstantiationException;
import com.sap.furcas.runtime.common.util.EcoreHelper;
import com.sap.furcas.runtime.parser.IModelAdapter;
import com.sap.furcas.runtime.parser.ParserFactory;
import com.sap.furcas.runtime.parser.ParsingError;
import com.sap.furcas.runtime.parser.PartitionAssignmentHandler;
import com.sap.furcas.runtime.parser.impl.DefaultTextAwareModelAdapter;
import com.sap.furcas.runtime.parser.impl.ModelInjector;
import com.sap.furcas.runtime.parser.impl.ObservableInjectingParser;
import com.sap.furcas.runtime.parser.impl.ParserScope;
import com.sap.furcas.runtime.parser.textblocks.ITextBlocksTokenStream;
import com.sap.furcas.runtime.parser.textblocks.TextBlocksAwareModelAdapter;
import com.sap.furcas.runtime.parser.textblocks.observer.ParserTextBlocksHandler;
import com.sap.furcas.runtime.textblocks.modifcation.TbVersionUtil;
import com.sap.ide.cts.parser.Activator;
import com.sap.ide.cts.parser.errorhandling.SemanticParserException;
import com.sap.ide.cts.parser.errorhandling.SemanticParserException.Component;
import com.sap.ide.cts.parser.incremental.IncrementalParser;
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
    private final ITextBlocksTokenStream tbTokenStream;
    private final ObservableInjectingParser domainParser;
    private final IncrementalParser incrementalParser;
    private final ModelInjector injector;
    private final ParserTextBlocksHandler observer;
    private final ParserScope parserScope;
    private final Resource transientResource;

    public IncrementalParserFacade(ParserFactory<? extends ObservableInjectingParser, ? extends Lexer> parserFactory,
            ResourceSet resourceSet, PartitionAssignmentHandler partitionAssignmentHandler) throws ParserInstantiationException {
        
        this.transientResource = EcoreHelper.createTransientParsingResource(
                resourceSet, parserFactory.getMetamodelURIs().iterator().next().toString());
        
        this.parserScope = new ParserScope(resourceSet, transientResource, parserFactory);
        
        TextBlocksAwareModelAdapter modelAdapter = new TextBlocksAwareModelAdapter(new EMFModelAdapter(
                resourceSet, transientResource, parserScope.getMetamodelLookup(), parserScope.getExplicitQueryScope()));

        this.parserFactory = parserFactory;
        // TODO use token wrapper factory here
        TextBlockReuseStrategyImpl reuseStrategy = new TextBlockReuseStrategyImpl(parserFactory.createLexer(null), modelAdapter);

        Lexer domainLexer = parserFactory.createLexer(null);
        ANTLRLexerAdapter lexerAdapter = new ANTLRLexerAdapter(domainLexer, reuseStrategy);
        this.incrementalLexer = new ANTLRIncrementalLexerAdapter(lexerAdapter, modelAdapter);
        this.tbTokenStream = parserFactory.createIncrementalTokenStream(incrementalLexer);

        this.domainParser = parserFactory.createParser(tbTokenStream, modelAdapter);
        this.incrementalParser = new IncrementalParser(domainParser, parserScope, reuseStrategy, partitionAssignmentHandler);

        // TODO use token wrapper factory here
        this.injector = new ModelInjector(domainParser.getTokenNames());
        this.injector.setModelAdapter(modelAdapter);
        setInjector(domainLexer, domainParser, injector);

        this.observer = new ParserTextBlocksHandler(tbTokenStream, parserScope, partitionAssignmentHandler);
        this.domainParser.setObserver(observer);
    }

    private static void setInjector(Lexer domainLexer, ObservableInjectingParser domainParser, ModelInjector injector) {
        domainParser.setInjector(injector);
        try {
            Field f = domainLexer.getClass().getField("ei");
            f.set(domainLexer, injector);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        } catch (NoSuchFieldException nsfe) {
            Activator.logWarning("Lexer has no ModelInjector field ei, lexer errors will only be reported to System.err");
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Uses the {@link IncrementalParser} to parse only the necessary parts of
     * the given root {@link TextBlock}.
     * 
     * @param rootBlock
     * @return
     */
    public TextBlock parseIncrementally(TextBlock rootBlock) throws SemanticParserException {
        if (lexAndPrepareParsing(rootBlock)) {
            TextBlock preparedTextBlock = getCurrentVersion(rootBlock);
            incrementalLexer.setCurrentTokenForParser(preparedTextBlock.getTokens().get(0));
            observer.setRootBlock(preparedTextBlock);
            TextBlock newRoot = incrementalParser.incrementalParse(preparedTextBlock);
            return newRoot;
        } else {
            throw new SemanticParserException(getErrors(), Component.LEXICAL_ANALYSIS);
        }
    }

    public List<ParsingError> dryParse(TextBlock rootBlock) throws ParserInstantiationException {
        CharStream inputStream = new ANTLRStringStream(rootBlock.getCachedString());
        TokenSource lexer = parserFactory.createLexer(inputStream);
        TokenStream tokenStream = new CommonTokenStream(lexer);
                
        IModelAdapter modelAdapter = new DefaultTextAwareModelAdapter(new EMFModelAdapter(parserScope.getResourceSet(),
                transientResource, parserScope.getMetamodelLookup(), parserScope.getExplicitQueryScope()));
        
        ObservableInjectingParser p = parserFactory.createParser(tokenStream, modelAdapter);
        return p.checkSyntaxWithoutInjecting();
    }

    public static Object getParsingResult(TextBlock rootBlock) {
        Collection<EObject> result = rootBlock.getCorrespondingModelElements();
        if (result.size() == 0) {
            return null;
        } else if (result.size() == 1) {
            return result.iterator().next();
        } else {
            return result;
        }
    }

    /**
     * Preparse all components for a new parse run, such as resetting the batch parser and setting the source for the
     * lexer. Operates on the {@link Version#PREVIOUS} version of <code>rootBlock</code>.
     * 
     * @param rootBlock
     *            the block that should be used to prepare parsing on
     * @return <code>true</code> if and only if lexing was successful
     */
    private boolean lexAndPrepareParsing(TextBlock rootBlock) {
        // reset parser states to beginning
        domainParser.reset();
        // go back to beginning of stream
        tbTokenStream.reset();
        TextBlock previousVersionTb = TbVersionUtil.getOtherVersion(rootBlock, Version.PREVIOUS);
        incrementalLexer.setSource(previousVersionTb.getTokens().get(0));
        boolean lexingSuccessful = incrementalLexer.lex(previousVersionTb);

        return lexingSuccessful;
    }

    private TextBlock getCurrentVersion(TextBlock rootBlock) {
        TextBlock currentVersionTb = TbVersionUtil.getOtherVersion(rootBlock, Version.CURRENT);
        return currentVersionTb;
    }

    /**
     * Returns the errors that where collected during the incremental parse run.
     * 
     * @return the list of {@link ParsingError} that occured during parsing.
     */
    public List<ParsingError> getErrors() {
        return injector.getErrorList();
    }
    
    public ParserFactory<? extends ObservableInjectingParser, ? extends Lexer> getParserFactory() {
        return parserFactory;
        
    }

}
