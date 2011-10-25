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
package com.sap.furcas.prettyprinter.policy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.emf.ecore.EObject;

import com.sap.furcas.metamodel.FURCAS.TCS.ContextTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.Property;
import com.sap.furcas.metamodel.FURCAS.TCS.SequenceElement;
import com.sap.furcas.metamodel.FURCAS.TCS.SequenceInAlternative;
import com.sap.furcas.metamodel.FURCAS.textblocks.AbstractToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.Bostoken;
import com.sap.furcas.metamodel.FURCAS.textblocks.DocumentNode;
import com.sap.furcas.metamodel.FURCAS.textblocks.Eostoken;
import com.sap.furcas.metamodel.FURCAS.textblocks.LexedToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.OmittedToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.prettyprinter.Formatter.FormatRequest;
import com.sap.furcas.runtime.tcs.TcsUtil;
import com.sap.furcas.unparser.textblocks.TextBlockIndex;

/**
 * A {@link PrintPolicy} which allows to re-use information from old/preexisting {@link TextBlock}s.
 * 
 * Stated goal is re-use as much as possible, including formatting, comments, serialization order
 * of unordered collections, chosen alternatives, names for for currently un-resolvable elements, ...
 * 
 * A {@link TextBlock} represent a single policy. Its sub-blocks are realized as sub-policies
 * (see {@link #getPolicyFor}). 
 * 
 * @author Stephan Erb
 *
 */
public class TextBlockBasedPrintPolicy implements PrintPolicy {

    private final TextBlock textBlock;
    private final HashMap<SequenceElement, AbstractToken> firstPreceedingWhiteSpacePerTokenSequenceElement = new HashMap<SequenceElement, AbstractToken>();
    private final TextBlockIndex index;
    
    public TextBlockBasedPrintPolicy(TextBlock oldBlock, TextBlockIndex index) {
        this.textBlock = oldBlock;
        this.index = index;
        
        initializeSequenceElementStore(textBlock.getTokens());
    }
    
    private void initializeSequenceElementStore(List<AbstractToken> tokensOfBlock) {
        AbstractToken currentleftMostWhiteSpace = null;
        
        for (AbstractToken token : tokensOfBlock) {
            if (token instanceof LexedToken) {
                SequenceElement se = ((LexedToken) token).getSequenceElement();
                if (currentleftMostWhiteSpace == null) {
                    firstPreceedingWhiteSpacePerTokenSequenceElement.put(se, token);
                } else {
                    firstPreceedingWhiteSpacePerTokenSequenceElement.put(se, currentleftMostWhiteSpace);
                    currentleftMostWhiteSpace = null;
                }
            } else if (isWhiteSpace(token) && !isPseudoToken(token)) {
                if (currentleftMostWhiteSpace == null) {
                    currentleftMostWhiteSpace = token;
                }
            } else {
                currentleftMostWhiteSpace = null;
            }
        }
    }
    
    private static boolean isPseudoToken(DocumentNode node) {
        return node instanceof Bostoken || node instanceof Eostoken;
    }
    
    private static boolean isWhiteSpace(DocumentNode node) {
        return node instanceof OmittedToken;
    }
    

    @Override
    public PrintPolicy getPolicyFor(EObject modelElement, SequenceElement seqElem, EObject valueToBePrinted, ContextTemplate template) {
        return DefaultPrintPolicy.getPolicyFor(index, valueToBePrinted, template);
    }
    
    @Override
    public Collection<?> getPreferredCollectionOrderOf(EObject modelElement, Property seqElem, Collection<?> elements) {
        return elements;
    }
    
    @Override
    public Collection<ContextTemplate> getPreferredTemplateOrderOf(EObject modelElement, SequenceElement seqElem, EObject value,
            Collection<ContextTemplate> elements) {
        return elements;
    }

    @Override
    public Collection<SequenceInAlternative> getPreferredAlternativeChoiceOrderOf(Collection<SequenceInAlternative> sequences) {
        // This is slow, but seems fast enough for now...
        // Find the chosen alternative in the old textblock
        SequenceInAlternative executedAlternative = null;
        for (SequenceInAlternative seq : sequences) {
            if (seq.getElements().isEmpty()) {
                executedAlternative = seq;
                continue; // only use if we there wasn't another one being executed.
            }
            if (textBlock.getType() instanceof ContextTemplate && TcsUtil.wasExecuted(
                    (ContextTemplate) textBlock.getType(), textBlock.getParentAltChoices(), seq.getElements().iterator().next())) {
                executedAlternative = seq;
                break; // there can only be one
            }
        }
        if (executedAlternative == null) {
            return sequences;
        } else {
            // put it to front: It should be tested first
            List<SequenceInAlternative> reordered = new ArrayList<SequenceInAlternative>(sequences);
            reordered.remove(executedAlternative);
            reordered.add(0, executedAlternative);
            return reordered;
        }
    }

    @Override
    public Object getRecoveredReferenceValueFor(SequenceElement seqElem) {
        // The reference is broken. We now have to recover the text used to reference the deleted object, so that 
        // the reference can be re-established at a later point in time.
        for (DocumentNode node : textBlock.getSubNodes()) {
            // FIXME: this might fail if we have a multi-value reference and more than two references
            // break at the same time. We don't know which value shall be re-used here
            if (node instanceof LexedToken && seqElem.equals(node.getSequenceElement())) {
                return ((LexedToken) node).getValue();
            }
        }
        return "";
    }

    @Override
    public List<FormatRequest> getOverruledFormattingBetween(List<FormatRequest> pendingFormattingRequest,
            SequenceElement previousSeqElement, SequenceElement newSeqElement) {
        ListIterator<DocumentNode> iter = textBlock.getSubNodes().listIterator();
        
        if (consumeUntilSequenceElement(iter, newSeqElement)) {
            return getFormattingRequestsForNextWhiteSpaces(iter);
        } else {
            return pendingFormattingRequest;
        }
    }
    
    /**
     * Fast forward to the leftmost whitespace in [..., TB, WS, WS, MyLexedTokenWithTargetSeqElem, TB]
     */
    private boolean consumeUntilSequenceElement(ListIterator<DocumentNode> iter, SequenceElement targetSeqElem) {
        AbstractToken targetToken = firstPreceedingWhiteSpacePerTokenSequenceElement.get(targetSeqElem);
        if (targetToken == null) {
            return false;
        }
        while (iter.hasNext()) {
            DocumentNode node = iter.next();
            if (node == targetToken) {
                iter.previous(); // gone one to far
                return true;
            }
        }
        return false; // happens at end of list
    }
    
    private  List<FormatRequest> getFormattingRequestsForNextWhiteSpaces(Iterator<DocumentNode> iter) {
        List<FormatRequest> requests = new ArrayList<FormatRequest>();
        
        while (iter.hasNext()) {
            DocumentNode node = iter.next();
            if (isPseudoToken(node)) {
                continue;
            }
            if (isWhiteSpace(node)) {
                requests.add(FormatRequest.createCustom(((AbstractToken) node).getValue()));
            } else {
                break;
            }
        }
        return requests;
    }

}
