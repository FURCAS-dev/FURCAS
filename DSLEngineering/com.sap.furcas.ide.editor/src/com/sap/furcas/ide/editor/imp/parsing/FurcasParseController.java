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
package com.sap.furcas.ide.editor.imp.parsing;

import java.util.ArrayList;
import java.util.Iterator;

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

import com.sap.furcas.ide.editor.document.CtsDocument;
import com.sap.furcas.ide.editor.imp.AbstractFurcasEditor;
import com.sap.furcas.ide.editor.imp.AbstractFurcasEditor.ContentProvider;
import com.sap.furcas.ide.editor.imp.AbstractFurcasEditor.ParserCollection;
import com.sap.furcas.ide.editor.imp.services.FurcasSourcePositionLocator;
import com.sap.furcas.ide.parserfactory.AbstractParserFactory;
import com.sap.furcas.metamodel.FURCAS.textblocks.AbstractToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.metamodel.FURCAS.textblocks.Version;
import com.sap.furcas.runtime.parser.ParsingError;
import com.sap.furcas.runtime.parser.impl.ObservableInjectingParser;
import com.sap.furcas.runtime.textblocks.TbNavigationUtil;
import com.sap.furcas.runtime.textblocks.TbUtil;
import com.sap.furcas.runtime.textblocks.model.VersionedTextBlockNavigator;
import com.sap.furcas.runtime.textblocks.modifcation.TbChangeUtil;
import com.sap.furcas.runtime.textblocks.modifcation.TbVersionUtil;
import com.sap.ide.cts.parser.errorhandling.SemanticParserException;
import com.sap.ide.cts.parser.incremental.IncrementalParsingException;

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
    
    /* Implementation note:
     * 
     * This class is called from at least the UI and the parsing thread.
     * This class must assure that no client can have a handle to a piece of
     * the textblocks or domain model while it is altered by the parser. 
     *
     */

    protected EditingDomain editingDomain;
    protected ContentProvider contentProvider;
    protected ParserCollection parserCollection;
    protected final AbstractParserFactory<? extends ObservableInjectingParser, ? extends Lexer> parserFactory;
    
    protected final IAnnotationTypeInfo annotationTypeInfo;
    protected FurcasSourcePositionLocator sourcePositionLocator;
    protected ILanguageSyntaxProperties languageSyntaxProperties;
    
    protected boolean completelyItitialized = false;
    
    protected String EMF_VALDIATION_MARKER_TYPE = "org.eclipse.emf.ecore.diagnostic";
        

    public FurcasParseController(AbstractParserFactory<? extends ObservableInjectingParser, ? extends Lexer>  parserFactory, ILanguageSyntaxProperties languageSyntaxProperties) {
        super(parserFactory.getLanguageId());
        this.parserFactory = parserFactory;
        this.annotationTypeInfo = new SimpleAnnotationTypeInfo();
        this.annotationTypeInfo.addProblemMarkerType(EMF_VALDIATION_MARKER_TYPE);
        this.languageSyntaxProperties = languageSyntaxProperties;
    }
    
    @SuppressWarnings("hiding")
    public void completeInit(EditingDomain editingDomain, ContentProvider contentProvider, ParserCollection parserCollection) {
        this.editingDomain = editingDomain;
        this.contentProvider = contentProvider;
        this.parserCollection = parserCollection;
        
        setParsingResult(contentProvider.getDocument().getRootBlock());
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
            monitor.setCanceled(true);
            return null; // IMP will call us before we are done initializing
        }
        CtsDocument document = contentProvider.getDocument();
        
        // 1) Write all buffered user edits to the underlying 
        //    textblocks model. Synchronize to prevent concurrent
        //    editing from within the UI thread.
        synchronized (document.getLockObject()) {
            document.flushUserEditsToTextBlocskModel();
        }

        // 2) Run the parser. This creates a new TextBlocks model
        //    Parsing runs in the background only.
        TextBlock blockWithUnparsedEdits = TbVersionUtil.getOtherVersion(document.getRootBlock(), Version.PREVIOUS);
        if (blockWithUnparsedEdits == null) {
            return getCurrentAst(); // parser was triggered by IMP, but there are no changes that require reparsing.
        }
        try {
            parse(blockWithUnparsedEdits);
        } catch (SemanticParserException e) {
            handleParseException(e);
            if (getCurrentAst() == null) {
                return null;
            }
        }
        
        // 3) Merge all user edits that happened while step 2 was running.
        //    Afterwards, run the short pretty printer to update all tokens according
        //    to domain model changes. The order is essential here, because otherwise 
        //    the offsets of the user's text edits are already invalid. 
        synchronized (document.getLockObject()) {
            document.setModelContent(getCurrentAst());
            document.flushUserEditsToTextBlocskModel();
            document.expandToEditableVersion();
            document.refreshContentFromTextBlocksModel();
        }
        return getCurrentAst();
    }

    /**
     * Run the parser. Whenever this method returns (normally or with exception)
     * {@link #getCurrentAst()} is guranteed to return a   
     */
    private void parse(TextBlock oldBlock) throws SemanticParserException {

        // reset errors in modelinjector
        parserCollection.parser.getInjector().getErrorList().clear();
        // set the start token to the lexer
        parserCollection.lexer.setSource(oldBlock.getTokens().get(0));

        boolean syntacticallyCorrect = parserCollection.lexer.lex(oldBlock);
        if (!syntacticallyCorrect) {
            throw new SemanticParserException(parserCollection.incrementalParser.getErrorList(), oldBlock, null);
        }
        
        // Lexing phase succeeded. We can use the created textblock as an intermediate result, as
        // it is sufficient for services such as the token colorer.
        TextBlock newlyLexedBlock = TbVersionUtil.getOtherVersion(oldBlock, Version.CURRENT);
        setParsingResult(newlyLexedBlock);

        parserCollection.lexer.setCurrentTokenForParser(newlyLexedBlock.getTokens().get(0));
        parserCollection.textBlocksHandler.setRootBlock(newlyLexedBlock);

        EObject result = null;
        TextBlock newBlock = null;
        try {
            newBlock = parserCollection.incrementalParser.incrementalParse(newlyLexedBlock, /*errorMode*/false);
            if (newBlock.getCorrespondingModelElements().size() > 0) {
                result = newBlock.getCorrespondingModelElements().iterator().next();
            }
        } catch (IncrementalParsingException e) {
            // we check for errors below;
        }
        ArrayList<ParsingError> errorList = new ArrayList<ParsingError>();
        errorList.addAll(parserCollection.incrementalParser.getErrorList());
        if (errorList.size() > 0 || result == null) {
            throw new SemanticParserException(errorList, newBlock, result);
        }

        // Both lexing and parsing were successfull. Make a new REFERENCE version. 
        newBlock = (TextBlock) TbChangeUtil.cleanUp(newBlock);
        setParsingResult(newBlock);
    }

    private void setParsingResult(TextBlock newlyLexedBlock) {
        fCurrentAst = newlyLexedBlock;
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
    
    @Override
    public Iterator<AbstractToken> getTokenIterator(final IRegion region) {
        if (!completelyItitialized) {
            return null; // IMP will call us before we are done initializing
        }
        final VersionedTextBlockNavigator navigator = new VersionedTextBlockNavigator(Version.REFERENCE);
        final int regionEnd = region.getOffset() + region.getLength();
        
        /* We assume that our caller sticks to the protocol and only calls next() after having called hasNext(). 
         * That way the next token only has to be calculated once.
         */
        return new Iterator<AbstractToken>() {
            
            private AbstractToken nextToken;
            
            @Override
            public boolean hasNext() {
                if (nextToken == null) {
                    nextToken = navigator.getFloorToken(getCurrentAst(), region.getOffset());
                } else {
                    nextToken = TbNavigationUtil.nextToken(nextToken);
                }
                return nextToken != null && TbUtil.getAbsoluteOffset(nextToken) + nextToken.getLength() <= regionEnd;
            }
            
            @Override
            public AbstractToken next() {
                if (nextToken == null) {
                    throw new IndexOutOfBoundsException();
                }
                return nextToken;
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
        return (TextBlock) fCurrentAst;
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
