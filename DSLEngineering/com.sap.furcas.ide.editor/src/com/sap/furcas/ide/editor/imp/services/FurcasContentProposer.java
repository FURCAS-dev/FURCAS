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

import org.eclipse.imp.parser.IParseController;
import org.eclipse.imp.services.IContentProposer;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.ICompletionProposal;

import com.sap.furcas.ide.editor.contentassist.CtsContentAssistProcessor;
import com.sap.furcas.ide.editor.imp.FurcasParseController;

/**
 * {@link IContentProposer} implementation for languages defined in FURCAS.
 * 
 * This class is generic and does not need a language specific implementation.
 *  
 * @author Stephan Erb
 *
 */
public class FurcasContentProposer implements IContentProposer {
    
    private CtsContentAssistProcessor contentProposer;

    @Override
    public ICompletionProposal[] getContentProposals(IParseController controller, int offset, ITextViewer viewer) {
        if (contentProposer == null) {
            contentProposer = new CtsContentAssistProcessor(((FurcasParseController) controller).getParserFacade());
        }
        return contentProposer.computeCompletionProposals(viewer, offset);
    }

}
