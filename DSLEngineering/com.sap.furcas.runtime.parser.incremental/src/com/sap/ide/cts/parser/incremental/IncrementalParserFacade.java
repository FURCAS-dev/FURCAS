package com.sap.ide.cts.parser.incremental;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.List;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.TokenSource;
import org.antlr.runtime.TokenStream;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.sap.furcas.metamodel.FURCAS.textblocks.AbstractToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.metamodel.FURCAS.textblocks.Version;
import com.sap.furcas.modeladaptation.emf.adaptation.EMFModelAdapter;
import com.sap.furcas.runtime.common.exceptions.ParserInstantiationException;
import com.sap.furcas.runtime.common.interfaces.IModelElementInvestigator;
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
import com.sap.furcas.runtime.textblocks.TbDebugUtil;
import com.sap.furcas.runtime.textblocks.modifcation.TbVersionUtil;
import com.sap.ide.cts.parser.Activator;
import com.sap.ide.cts.parser.errorhandling.SemanticParserException;
import com.sap.ide.cts.parser.errorhandling.SemanticParserException.Component;
import com.sap.ide.cts.parser.incremental.antlr.ANTLRIncrementalLexerAdapter;
import com.sap.ide.cts.parser.incremental.antlr.ANTLRLexerAdapter;

/**
 * Facade for handling incremental parser and lexer construction as well as
 * calling of parsing methods. Only completely configured components are exposed.
 * 
 * @author C5106462
 * @author Stephan Erb
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
    private final PartitionAssignmentHandler partitionAssignmentHandler;

    public IncrementalParserFacade(ParserFactory<? extends ObservableInjectingParser, ? extends Lexer> parserFactory,
            ResourceSet resourceSet, PartitionAssignmentHandler partitionAssignmentHandler) throws ParserInstantiationException {
        
        this.parserFactory = parserFactory;
        this.partitionAssignmentHandler = partitionAssignmentHandler;
        
        this.parserScope = new ParserScope(resourceSet, parserFactory);
        IModelAdapter modelAdapter = createModelAdapter();

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

        this.observer = createParserTextBlocksHandler();
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
     * the given root {@link TextBlock}. If lexing fails, the same old
     * TextBlock is returned.
     * 
     * @param rootBlock
     * @return
     */
    public TextBlock parseIncrementally(TextBlock oldBlock) throws SemanticParserException {
        return parseIncrementally(oldBlock, new NullProgressMonitor());
    }

    /**
     * Uses the {@link IncrementalParser} to parse only the necessary parts of
     * the given root {@link TextBlock}. If lexing fails, the same old
     * TextBlock is returned.
     * 
     * @param rootBlock
     * @param monitor
     * @return
     */
    public TextBlock parseIncrementally(TextBlock rootBlock, IProgressMonitor monitor) throws SemanticParserException {
        setDefaultPartitionFromRoot(rootBlock);
        
        if (lexAndPrepareParsing(rootBlock)) {
            TextBlock preparedTextBlock = getCurrentVersion(rootBlock);
            incrementalLexer.setCurrentTokenForParser((AbstractToken) preparedTextBlock.getSubNodes().get(0));
            observer.setRootBlock(preparedTextBlock);
            
            if (monitor.isCanceled()) {
                // Canceld during lexing. Safe to return here.
                return preparedTextBlock;
            }
            String preParseContent = TbDebugUtil.getDocumentNodeAsPlainString(preparedTextBlock);
            TextBlock resultBlock = incrementalParser.incrementalParse(preparedTextBlock, /*error mode*/ false, monitor);
            
            String postParseContent = TbDebugUtil.getDocumentNodeAsPlainString(resultBlock);
            Assert.isTrue(preParseContent.equals(postParseContent), "Content differs after parsing. \n" +
                    "Before:\n "+ preParseContent + "\nAfter:\n " + postParseContent);
            
            return resultBlock;
        } else {
            throw new SemanticParserException(getErrors(), Component.LEXICAL_ANALYSIS);
        }
    }
    
    /**
     * Sets the default partition that is used to assign all created model
     * elements. In this case the same partition as the one from the root blocks
     * corresponding model element is used.
     */
    private void setDefaultPartitionFromRoot(TextBlock root) {
        Resource defaultPartition = null;
        if (root.getCorrespondingModelElements().size() != 0) {
            defaultPartition = getParsingResult(root).eResource();
        } else {
            defaultPartition = root.eResource();
        }
        partitionAssignmentHandler.setDefaultPartition(defaultPartition);
        partitionAssignmentHandler.assignToDefaultTextBlocksPartition(root);
    }

    public List<ParsingError> dryParse(TextBlock rootBlock) throws ParserInstantiationException {
        CharStream inputStream = new ANTLRStringStream(rootBlock.getCachedString());
        TokenSource lexer = parserFactory.createLexer(inputStream);
        TokenStream tokenStream = new CommonTokenStream(lexer);
                
        IModelAdapter modelAdapter = new DefaultTextAwareModelAdapter(new EMFModelAdapter(parserScope.getResourceSet(),
                partitionAssignmentHandler, parserScope.getMetamodelLookup(), parserScope.getExplicitQueryScope()));
        
        ObservableInjectingParser p = parserFactory.createParser(tokenStream, modelAdapter);
        return p.checkSyntaxWithoutInjecting();
    }

    public static EObject getParsingResult(TextBlock rootBlock) {
        Collection<EObject> result = rootBlock.getCorrespondingModelElements();
        if (result.size() == 0) {
            return null;
        } else {
            return result.iterator().next();
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
        String preLexContent = TbDebugUtil.getDocumentNodeAsPlainString(previousVersionTb);
        
        incrementalLexer.setSource((AbstractToken) previousVersionTb.getSubNodes().get(0));
        boolean lexingSuccessful = incrementalLexer.lex(previousVersionTb);
        
        if (lexingSuccessful) {
            String postLexContent = TbDebugUtil.getDocumentNodeAsPlainString(getCurrentVersion(previousVersionTb));
            Assert.isTrue(preLexContent.equals(postLexContent), "Content differs after lexing. \n" +
                    "Before:\n "+ preLexContent + "\nAfter:\n " + postLexContent);
        }

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
    
    public ParserScope getParserScope() {
        return parserScope;
    }

    public IModelElementInvestigator getModelElementInvestigator() {
        return injector.getModelAdapter();
    }
    
    /*
     * The methods below are for the use by the {@link MappingRecoveringTextBlocksValidator}
     * They must be used with care as they directly alter the internal state of this facade.
     */
    
    /*package*/ ParserTextBlocksHandler createParserTextBlocksHandler() {
        return new ParserTextBlocksHandler(tbTokenStream, parserScope, partitionAssignmentHandler);
    }
    
    /*package*/ IModelAdapter createModelAdapter() {
        return new TextBlocksAwareModelAdapter(new EMFModelAdapter(parserScope.getResourceSet(),
                partitionAssignmentHandler, parserScope.getMetamodelLookup(), parserScope.getExplicitQueryScope()));
    }
    
    /*package*/ IModelAdapter getModelAdapter() {
        return injector.getModelAdapter(); 
    }

    /*package*/ ObservableInjectingParser getParser() {
        return domainParser;
    }
    
    /*package*/ IncrementalParser getIncrementalParser() {
        return incrementalParser;
    }
    
    /*package*/ LexerAdapter getLexer() {
        return incrementalLexer.getBatchLexer();
    }
    
    /*package*/ ANTLRIncrementalLexerAdapter getIncrementalLexer() {
        return incrementalLexer;
    }

}
