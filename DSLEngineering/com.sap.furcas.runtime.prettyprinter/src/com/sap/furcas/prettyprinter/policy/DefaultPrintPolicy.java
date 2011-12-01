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

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.metamodel.FURCAS.TCS.ContextTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.Property;
import com.sap.furcas.metamodel.FURCAS.TCS.SequenceElement;
import com.sap.furcas.metamodel.FURCAS.TCS.SequenceInAlternative;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.prettyprinter.Formatter.FormatRequest;
import com.sap.furcas.prettyprinter.incremental.TextBlockBasedPrintPolicy;
import com.sap.furcas.prettyprinter.incremental.TextBlockIndex;

/**
 * A {@link PrintPolicy} which always defaults to the information/order as provided by the used {@link ConcreteSyntax}.
 * 
 * @author Stephan Erb
 *
 */
public class DefaultPrintPolicy implements PrintPolicy {

    private final TextBlockIndex index;

    public DefaultPrintPolicy() {
        this(null);
    }
    
    public DefaultPrintPolicy(TextBlockIndex index) {
        this.index = index;
    }

    @Override
    public PrintPolicy getPolicyFor(EObject modelElement, SequenceElement seqElem, EObject value, ContextTemplate template) {
        if (index == null) {
            return this;
        } else {
            return getPolicyFor(index, value, template);
        }
    }
    
    public static PrintPolicy getPolicyFor(TextBlockIndex index, EObject valueToBePrinted, ContextTemplate template) {
        
        Collection<TextBlock> potentiallyReusableBlocks = index.findTextBlock(template, valueToBePrinted);
        if (potentiallyReusableBlocks.isEmpty()) {
            return new DefaultPrintPolicy(index);
        } else {
            // it is unknown which textblocks to prefer if there are several potential
            // this may happen if a model element is visible in several views
            TextBlock block = potentiallyReusableBlocks.iterator().next();
            return new TextBlockBasedPrintPolicy(block, template, index);
        }
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
        return sequences;
    }

    @Override
    public Object getRecoveredReferenceValueFor(SequenceElement seqElem) {
        return "";
    }

    @Override
    public List<FormatRequest> getOverruledFormattingBetween(List<FormatRequest> pendingFormattingRequest, SequenceElement previousSeqElement, SequenceElement followingSeqElement, String followingTokenValue) {
        return pendingFormattingRequest;
    }

}
