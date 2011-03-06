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

import org.antlr.runtime.Lexer;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.imp.parser.IParseController;
import org.eclipse.imp.services.IContentProposer;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.ICompletionProposal;

import com.sap.furcas.ide.editor.contentassist.CtsContentAssistProcessor;
import com.sap.furcas.ide.parserfactory.AbstractParserFactory;
import com.sap.furcas.runtime.parser.impl.ObservableInjectingParser;

/**
 * {@link IContentProposer} implementation for languages defined in FURCAS.
 * 
 * This class is generic and does not need a language specific implementation.
 *  
 * @author Stephan Erb
 *
 */
public class FurcasContentProposer implements IContentProposer {
    
    private final CtsContentAssistProcessor contentProposer;

    public FurcasContentProposer(AbstractParserFactory<ObservableInjectingParser, Lexer> parserFactory) {
        // FIXME: the content can have side effects! Nees to be fixed in the MASTER branch.
        contentProposer = new CtsContentAssistProcessor(new ResourceSetImpl(), parserFactory, parserFactory.getLanguageId());
    }

    @Override
    public ICompletionProposal[] getContentProposals(IParseController controller, int offset, ITextViewer viewer) {
        return contentProposer.computeCompletionProposals(viewer, offset);
    }

}
