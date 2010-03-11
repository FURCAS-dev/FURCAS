/**
 * <copyright>
 *
 * Copyright (c) 2007 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: OCLConfiguration.java,v 1.1 2010/03/11 10:13:31 ewillink Exp $
 */

package org.eclipse.ocl.examples.interpreter.console.text;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.contentassist.ContentAssistant;
import org.eclipse.jface.text.contentassist.IContentAssistant;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.rules.DefaultDamagerRepairer;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;


/**
 * Source viewer configuration for the OCL Console input area.
 * 
 * @author Christian W. Damus (cdamus)
 */
class OCLConfiguration extends SourceViewerConfiguration {
    private OCLScanner oclScanner;
    private OCLCommentScanner oclCommentScanner;
    private ColorManager colorManager;

    OCLConfiguration(ColorManager colorManager) {
        this.colorManager = colorManager;
    }
    
    @Override
    public String[] getConfiguredContentTypes(ISourceViewer sourceViewer) {
        return new String[] {
            IDocument.DEFAULT_CONTENT_TYPE,
            OCLPartitionScanner.COMMENT};
    }

    protected OCLScanner getOCLScanner() {
        if (oclScanner == null) {
            oclScanner = new OCLScanner(colorManager);
            oclScanner.setDefaultReturnToken(
                new Token(
                    new TextAttribute(colorManager.getColor(ColorManager.DEFAULT))));
        }
        
        return oclScanner;
    }

    protected OCLCommentScanner getOCLCommentScanner() {
        if (oclCommentScanner == null) {
            oclCommentScanner = new OCLCommentScanner(colorManager);
            oclCommentScanner.setDefaultReturnToken(
                new Token(
                    new TextAttribute(colorManager.getColor(ColorManager.COMMENT))));
        }
        
        return oclCommentScanner;
    }

    @Override
    public IPresentationReconciler getPresentationReconciler(ISourceViewer sourceViewer) {
        PresentationReconciler reconciler = new PresentationReconciler();

        DefaultDamagerRepairer dr = new DefaultDamagerRepairer(getOCLScanner());
        reconciler.setDamager(dr, IDocument.DEFAULT_CONTENT_TYPE);
        reconciler.setRepairer(dr, IDocument.DEFAULT_CONTENT_TYPE);

        dr = new DefaultDamagerRepairer(getOCLCommentScanner());
        reconciler.setDamager(dr, OCLPartitionScanner.COMMENT);
        reconciler.setRepairer(dr, OCLPartitionScanner.COMMENT);

        return reconciler;
    }

    @Override
    public IContentAssistant getContentAssistant(ISourceViewer sourceViewer) {
        ContentAssistant result = new ContentAssistant();
        
        result.setContentAssistProcessor(new OCLCompletionProcessor(),
            IDocument.DEFAULT_CONTENT_TYPE);
        result.enableAutoActivation(true);
        //result.enablePrefixCompletion(true);
        
        return result;
    }
}
