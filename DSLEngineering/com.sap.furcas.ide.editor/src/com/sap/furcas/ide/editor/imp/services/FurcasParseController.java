/*******************************************************************************
 * Copyright (c) 2011 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package com.sap.furcas.ide.editor.imp.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.Lexer;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.imp.parser.IParseController;
import org.eclipse.imp.parser.ISourcePositionLocator;
import org.eclipse.imp.parser.ParseControllerBase;
import org.eclipse.imp.parser.SimpleAnnotationTypeInfo;
import org.eclipse.imp.services.IAnnotationTypeInfo;
import org.eclipse.imp.services.ILanguageSyntaxProperties;
import org.eclipse.jface.text.IRegion;

import com.sap.furcas.ide.editor.commands.ParseCommand;
import com.sap.furcas.ide.editor.imp.AbstractFurcasEditor;
import com.sap.furcas.ide.editor.imp.AbstractFurcasEditor.ContentProvider;
import com.sap.furcas.ide.editor.imp.AbstractFurcasEditor.ParserCollection;
import com.sap.furcas.ide.parserfactory.AbstractParserFactory;
import com.sap.furcas.metamodel.FURCAS.textblocks.AbstractToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.metamodel.FURCAS.textblocks.Version;
import com.sap.furcas.runtime.parser.IModelInjector;
import com.sap.furcas.runtime.parser.ParsingError;
import com.sap.furcas.runtime.parser.impl.ObservableInjectingParser;
import com.sap.furcas.runtime.textblocks.TbNavigationUtil;
import com.sap.furcas.runtime.textblocks.TbUtil;
import com.sap.furcas.runtime.textblocks.model.VersionedTextBlockNavigator;
import com.sap.furcas.runtime.textblocks.modifcation.TbVersionUtil;
import com.sap.ide.cts.parser.errorhandling.SemanticParserException;

/**
 * {@link IParseController} implementation for generated FURCAS parsers.
 * This allows the IMP framework to call a FURCAS parser whenever needed.<p>
 * 
 * This class is generic and does not need a language specific implementation.
 * 
 * @author Stephan Erb
 *
 */
public abstract class FurcasParseController extends ParseControllerBase {

    protected EditingDomain editingDomain;
    protected ContentProvider contentProvider;
    protected ParserCollection parserCollection;
    protected final AbstractParserFactory<? extends ObservableInjectingParser, ? extends Lexer> parserFactory;
    
    protected final IAnnotationTypeInfo annotationTypeInfo;
    protected FurcasSourcePositionLocator sourcePositionLocator;
    protected ILanguageSyntaxProperties languageSyntaxProperties;
    
    protected boolean completelyItitialized = false;
        

    public FurcasParseController(AbstractParserFactory<? extends ObservableInjectingParser, ? extends Lexer>  parserFactory, ILanguageSyntaxProperties languageSyntaxProperties) {
        super(parserFactory.getLanguageId());
        this.parserFactory = parserFactory;
        this.annotationTypeInfo = new SimpleAnnotationTypeInfo();
        this.languageSyntaxProperties = languageSyntaxProperties;
    }
    
    @SuppressWarnings("hiding")
    public void completeInit(EditingDomain editingDomain, ContentProvider contentProvider, ParserCollection parserCollection) {
        this.editingDomain = editingDomain;
        this.contentProvider = contentProvider;
        this.parserCollection = parserCollection;
        
        completelyItitialized = true;
    }
    
    /**
     * Incrementally parse the content of the linked {@link AbstractFurcasEditor}. The given input argument,
     * representing the entire document content, is always ignored. The content for incremental parsing
     * is retrieved through a side channel which the caller does not need to know about. 
     * 
     * @return the root TextBlock
     */
    @Override
    public TextBlock parse(String input, IProgressMonitor monitor) {
        if (!completelyItitialized) {
            return null; // IMP will call us before we are done initializing
        }
        
        ParseCommand parseCommand = new ParseCommand(contentProvider.getCurrentRootBlock(), this);
        editingDomain.getCommandStack().execute(parseCommand);

        if (parseCommand.getParseException() != null) {
            handleParseException(parseCommand.getParseException());
        }
        return parseCommand.getNewBlock();
    }

    private void handleParseException(SemanticParserException parserException) {
        for (ParsingError ex : parserException.getIssuesList()) {
            // hack to correctly calculate the stop index: The offset from some exception
            // sources is a little bit off
            int stopIndex = ex.getStopIndex() - 2 <= ex.getIndex() ? ex.getIndex() : (ex.getStopIndex() - 2);

            handler.handleSimpleMessage(ex.getMessage(), ex.getIndex(), stopIndex, ex.getPosition(), ex.getEndPosition(),
                    ex.getLine(), ex.getEndLine());
        }
    }
    
    public TextBlock parse(TextBlock root) throws SemanticParserException {
        // ensure to work on previous version
        TextBlock oldBlock = TbVersionUtil.getOtherVersion(root, Version.PREVIOUS);
        if (oldBlock == null) {
            oldBlock = root;
        }

        // reset errors in modelinjector
        parserCollection.parser.getInjector().getErrorList().clear();
        // set the start token to the lexer
        parserCollection.lexer.setSource(oldBlock.getTokens().get(0));

        // always call the lexer. We need lexed tokens to colorize them later on
        boolean syntacticallyCorrect = parserCollection.lexer.lex(oldBlock);
        if (!syntacticallyCorrect) {
            throw new SemanticParserException(parserCollection.incrementalParser.getErrorList(), oldBlock, null);
        }
        
        try {
            System.out.println("dry parse");
            dryParse(contentProvider.getCurrentRootBlock());
        } catch (SemanticParserException e) {
            System.out.println("dry parse failed");
            throw e;
        }
        
        // dry parse succeded. We can go ahead and actually update our model.
        System.out.println("incremental parse");
        TextBlock newlyLexedTextBlock = TbVersionUtil.getOtherVersion(oldBlock, Version.CURRENT);
        if (newlyLexedTextBlock != null) {
            parserCollection.lexer.setCurrentTokenForParser(newlyLexedTextBlock.getTokens().get(0));
            parserCollection.textBlocksHandler.setRootBlock(newlyLexedTextBlock);

            TextBlock newBlock = parserCollection.incrementalParser.incrementalParse(newlyLexedTextBlock, /*errorMode*/false);

            EObject result = null;
            if (newBlock.getCorrespondingModelElements().size() > 0) {
                result = newBlock.getCorrespondingModelElements().iterator().next();
            }
            if (result == null) {
                throw new SemanticParserException(parserCollection.incrementalParser.getErrorList(), oldBlock, result);
            }

            ArrayList<ParsingError> errorList = new ArrayList<ParsingError>();
            errorList.addAll(parserCollection.incrementalParser.getErrorList());
            if (errorList.size() > 0) {
                throw new SemanticParserException(errorList, newBlock, result);
            }
            return newBlock;

        } else {
            throw new SemanticParserException(parserCollection.incrementalParser.getErrorList(), oldBlock, null);
        }
    }
    
    /**
     * Execute a parse run with a dummy {@link IModelInjector} that does not actually
     * create any model elements. This may be useful if you only want to do a
     * syntax check without modifying anything.
     */
    public void dryParse(TextBlock rootBlock) throws SemanticParserException {
        ObservableInjectingParser p = createDryParser(rootBlock);
        List<ParsingError> errorList = p.checkSyntaxWithoutInjecting();
        if (errorList != null && errorList.size() > 0) {
            throw new SemanticParserException(errorList, rootBlock, null);
        }
    }
    
    private ObservableInjectingParser createDryParser(TextBlock rootBlock) {
        Lexer lexer = parserCollection.parserFactory.createLexer(new ANTLRStringStream(rootBlock.getCachedString()));
        return parserCollection.parserFactory.createParser(new CommonTokenStream(lexer), editingDomain.getResourceSet());
    }

    @Override
    public Iterator<AbstractToken> getTokenIterator(final IRegion region) {
        if (!completelyItitialized) {
            return null; // IMP will call us before we are done initializing
        }
        final VersionedTextBlockNavigator navigator = new VersionedTextBlockNavigator(Version.CURRENT);
        final int regionEnd = region.getOffset() + region.getLength() - 1;
        
        return new Iterator<AbstractToken>() {
            
            private AbstractToken currentToken = navigator.getFloorToken(contentProvider.getCurrentRootBlock(), region.getOffset());
            
            @Override
            public boolean hasNext() {
                AbstractToken nextToken = TbNavigationUtil.nextToken(currentToken);
                return nextToken != null && TbUtil.getAbsoluteOffset(nextToken) + nextToken.getLength() < regionEnd;
            }
            @Override
            public AbstractToken next() {
                currentToken = TbNavigationUtil.nextToken(currentToken);
                return currentToken;
            }
            @Override
            public void remove() {
                throw new IllegalArgumentException("Unimplemented");

            };
        };
    }
    
    @Override
    public TextBlock getCurrentAst() {
        if (!completelyItitialized) {
            return null; // IMP will call us before we are done initializing
        }
        return contentProvider.getCurrentRootBlock();
    }

    @Override
    public ISourcePositionLocator getSourcePositionLocator() {
        if (sourcePositionLocator == null) {
            sourcePositionLocator = new FurcasSourcePositionLocator();
        }
        return sourcePositionLocator;
    }

    @Override
    public ILanguageSyntaxProperties getSyntaxProperties() {
        return languageSyntaxProperties;
    }

    @Override
    public IAnnotationTypeInfo getAnnotationTypeInfo() {
        return annotationTypeInfo;
    }
        
}
