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
package com.sap.furcas.ide.editor.imp;

import java.util.Collections;
import java.util.Iterator;

import org.antlr.runtime.Lexer;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.imp.parser.IParseController;
import org.eclipse.imp.parser.ISourcePositionLocator;
import org.eclipse.imp.parser.ParseControllerBase;
import org.eclipse.imp.parser.SimpleAnnotationTypeInfo;
import org.eclipse.imp.services.IAnnotationTypeInfo;
import org.eclipse.imp.services.ILanguageSyntaxProperties;
import org.eclipse.jface.text.IRegion;

import com.sap.furcas.ide.editor.commands.ParseCommand;
import com.sap.furcas.ide.editor.imp.AbstractFurcasEditor.ContentProvider;
import com.sap.furcas.ide.editor.imp.services.FurcasSourcePositionLocator;
import com.sap.furcas.ide.parserfactory.AbstractParserFactory;
import com.sap.furcas.metamodel.FURCAS.textblocks.AbstractToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.metamodel.FURCAS.textblocks.Version;
import com.sap.furcas.runtime.parser.impl.ObservableInjectingParser;
import com.sap.furcas.runtime.textblocks.TbNavigationUtil;
import com.sap.furcas.runtime.textblocks.TbUtil;
import com.sap.furcas.runtime.textblocks.model.VersionedTextBlockNavigator;
import com.sap.ide.cts.parser.incremental.IncrementalParserFacade;

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
    
    protected TransactionalEditingDomain editingDomain;
    protected ContentProvider contentProvider;
    protected IncrementalParserFacade parserFacade;
    protected final AbstractParserFactory<? extends ObservableInjectingParser, ? extends Lexer> parserFactory;
    
    protected final IAnnotationTypeInfo annotationTypeInfo;
    protected final FurcasSourcePositionLocator sourcePositionLocator;
    protected final ILanguageSyntaxProperties languageSyntaxProperties;
    
    protected boolean completelyItitialized = false;

    public FurcasParseController(AbstractParserFactory<? extends ObservableInjectingParser, ? extends Lexer>  parserFactory, ILanguageSyntaxProperties languageSyntaxProperties) {
        super(parserFactory.getLanguageId());
        this.parserFactory = parserFactory;
        this.sourcePositionLocator = new FurcasSourcePositionLocator();
        this.annotationTypeInfo = new SimpleAnnotationTypeInfo();
        this.languageSyntaxProperties = languageSyntaxProperties;
    }
    
    @SuppressWarnings("hiding")
    public void completeInit(TransactionalEditingDomain editingDomain, ContentProvider contentProvider, IncrementalParserFacade parserFacade) {
        this.editingDomain = editingDomain;
        this.contentProvider = contentProvider;
        this.parserFacade = parserFacade;
        
        setCurrentAst(contentProvider.getDocument().getRootBlock());
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
        
        boolean saveNeeded = ((BasicCommandStack) editingDomain.getCommandStack()).isSaveNeeded();
        
        ParseCommand command = new ParseCommand(editingDomain, contentProvider.getDocument(), parserFacade, handler);
        editingDomain.getCommandStack().execute(command);
        
        if (!saveNeeded && !command.wasEffective()) {
            // the command changed nothing. Reset dirty state.
            ((BasicCommandStack) editingDomain.getCommandStack()).saveIsDone();
        }
        
        setCurrentAst(command.getParsingResult());
        return getCurrentAst();
    }

    @Override
    public Iterator<AbstractToken> getTokenIterator(final IRegion region) {
        if (!completelyItitialized || getCurrentAst() == null) {
            return Collections.<AbstractToken>emptyList().iterator();
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
                throw new UnsupportedOperationException();

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
    
    private void setCurrentAst(TextBlock rootBlock) {
        fCurrentAst = rootBlock;
    }
    
    public EObject getCurrentRootObject() {
        return IncrementalParserFacade.getParsingResult(getCurrentAst());
    }

    @Override
    public ISourcePositionLocator getSourcePositionLocator() {
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

    public IncrementalParserFacade getParserFacade() {
        return parserFacade;
    }


    
}
