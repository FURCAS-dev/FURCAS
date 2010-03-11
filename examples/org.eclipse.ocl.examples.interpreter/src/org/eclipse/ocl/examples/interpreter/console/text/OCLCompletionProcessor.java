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
 * $Id: OCLCompletionProcessor.java,v 1.1 2010/03/11 10:13:27 ewillink Exp $
 */

package org.eclipse.ocl.examples.interpreter.console.text;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.CompletionProposal;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;
import org.eclipse.ocl.helper.Choice;
import org.eclipse.ocl.helper.OCLHelper;


/**
 * Completion processor for the OCL Console, demonstrating the syntax-completion
 * support of the {@link OCLHelper}.
 * 
 * @author Christian W. Damus (cdamus)
 */
class OCLCompletionProcessor
    implements IContentAssistProcessor {

    private static char[] NO_CHARS = {};
    private static IContextInformation[] NO_CONTEXTS = {};
    private static ICompletionProposal[] NO_COMPLETIONS = {};
    
    private static char[] ACTIVATION = {
        '.',
        ':' /* :: */,
        '>' /* -> */,
        '^'};
    
    public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer,
            int offset) {
        
        OCLDocument doc = (OCLDocument) viewer.getDocument();
        
        int replacementOffset = offset;
        
        try {
            if (offset > 0 && doc.getChar(offset - 1) == '>') {
                // check that this is an arrow
                if (offset < 2 || doc.getChar(offset - 2) != '-') {
                    return NO_COMPLETIONS;
                }
            }
            
            if (offset > 0 && doc.getChar(offset - 1) == ':') {
                // check that this is a double-colon
                if (offset < 2 || doc.getChar(offset - 2) != ':') {
                    return NO_COMPLETIONS;
                }
            }
            
            loop: while (replacementOffset > 0) {
                char trigger = doc.getChar(--replacementOffset);
                switch (trigger) {
                    case '.':
                    case '>':
                    case ':':
                    case '^':
                    case ' ':
                    case '\t':
                    case '\n':
                    case '\r':
                    case '(':
                    case '[':
                    case '{':
                        replacementOffset++;
                        break loop;
                }
            }
        } catch (BadLocationException e) {
            // just don't return any proposal
            return NO_COMPLETIONS;
        }
        
        List<Choice> choices = doc.getOCLChoices(offset);
        
        return createCompletions(choices, replacementOffset, offset - replacementOffset);
    }

    public char[] getCompletionProposalAutoActivationCharacters() {
        return ACTIVATION;
    }

    public IContextInformation[] computeContextInformation(ITextViewer viewer,
            int offset) {
        return NO_CONTEXTS;
    }

    public char[] getContextInformationAutoActivationCharacters() {
        return NO_CHARS;
    }

    public IContextInformationValidator getContextInformationValidator() {
        return null;
    }

    public String getErrorMessage() {
        return null;
    }
    
    private ICompletionProposal[] createCompletions(List<Choice> choices,
            int replacementOffset, int replacementLength) {
        
        List<ICompletionProposal> result = new java.util.ArrayList<ICompletionProposal>();
        
        sortChoices(choices);
        
        for (Choice choice : choices) {
            String text = choice.getName();
            String display;
            int cursor;
            
            switch (choice.getKind()) {
                case OPERATION:
                case SIGNAL:
                    // the description is already complete
                    text = text + "()"; //$NON-NLS-1$
                    display = choice.getDescription();
                    cursor = text.length() - 1;  // between the ()
                    break;
                case PROPERTY:
                case ENUMERATION_LITERAL:
                case VARIABLE:
                case ASSOCIATION_CLASS:
                    display = text + " : " + choice.getDescription(); //$NON-NLS-1$
                    cursor = text.length();
                    break;
                default:
                    display = text;
                    cursor = text.length();
                    break;
            }
            
            result.add(new CompletionProposal(
                text,
                replacementOffset,
                replacementLength,
                cursor,
                null,
                display,
                null,
                null));
        }
        
        return result.toArray(new ICompletionProposal[result.size()]);
    }
    
    private void sortChoices(List<Choice> choices) {
        Collections.sort(choices, new Comparator<Choice>() {
            public int compare(Choice o1, Choice o2) {
                int result = rank(o1) - rank(o2);
                
                if (result == 0) {
                    result = o1.getName().compareTo(o2.getName());
                }
                
                return result;
            }
            
            private int rank(Choice choice) {
                switch (choice.getKind()) {
                    case VARIABLE:
                        return 0;
                    case PACKAGE:
                        return 1;
                    case TYPE:
                        return 2;
                    case ENUMERATION_LITERAL:
                        return 3;
                    case STATE:
                        return 4;
                    case PROPERTY:
                        return 5;
                    case ASSOCIATION_CLASS:
                        return 6;
                    case OPERATION:
                        return 7;
                    case SIGNAL:
                        return 8;
                    default:
                        return Integer.MAX_VALUE;
                }
            }
        });
    }
}
