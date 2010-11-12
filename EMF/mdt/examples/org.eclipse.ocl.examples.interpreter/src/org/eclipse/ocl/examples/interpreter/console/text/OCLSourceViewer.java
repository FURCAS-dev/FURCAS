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
 * $Id: OCLSourceViewer.java,v 1.1 2010/03/11 10:13:27 ewillink Exp $
 */

package org.eclipse.ocl.examples.interpreter.console.text;

import org.eclipse.jface.text.contentassist.ContentAssistEvent;
import org.eclipse.jface.text.contentassist.ICompletionListener;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistant;
import org.eclipse.jface.text.contentassist.IContentAssistantExtension2;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.swt.widgets.Composite;


/**
 * Input field implementation for the OCL Console.
 * 
 * @author Christian W. Damus (cdamus)
 */
public class OCLSourceViewer
    extends SourceViewer {

    private long contentAssistLastActive;
    
    /**
     * @param parent
     * @param colorManager
     * @param styles
     */
    public OCLSourceViewer(Composite parent, ColorManager colorManager, int styles) {
        super(parent, null, styles);
        
        configure(new OCLConfiguration(colorManager));
        
        ((IContentAssistantExtension2) fContentAssistant).addCompletionListener(new ICompletionListener() {
            public void assistSessionEnded(ContentAssistEvent event) {
                contentAssistLastActive = System.currentTimeMillis();
            }
            
            public void assistSessionStarted(ContentAssistEvent event) {
                // not interesting
            }
        
            public void selectionChanged(ICompletionProposal proposal,
                    boolean smartToggle) {
                // not interesting
            }});
    }

    /**
     * Queries whether the content-assist popup is currently active.  Actually,
     * this method employs a heuristic, answering <code>true</code> for 500
     * milliseconds after the content-assist is dismissed.
     * 
     * @return whether content-assist is active
     */
    public boolean isContentAssistActive() {
        return System.currentTimeMillis() - contentAssistLastActive < 500L;
    }
    
    public IContentAssistant getContentAssistant() {
        return fContentAssistant;
    }
}
