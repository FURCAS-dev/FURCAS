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

import com.sap.furcas.metamodel.FURCAS.TCS.ContextTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.Property;
import com.sap.furcas.metamodel.FURCAS.TCS.SequenceElement;
import com.sap.furcas.metamodel.FURCAS.TCS.SequenceInAlternative;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.prettyprinter.Formatter.FormatRequest;

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

    public TextBlockBasedPrintPolicy(TextBlock oldBlock) {
        // TODO Auto-generated method stub
    }

    @Override
    public PrintPolicy getPolicyFor(EObject modelElement, SequenceElement seqElem, Object value, ContextTemplate template) {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public Collection<ContextTemplate> getPreferredTemplateOrderOf(EObject modelElement, SequenceElement seqElem, EObject value,
            Collection<ContextTemplate> elements) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Collection<?> getPreferredCollectionOrderOf(EObject modelElement, Property seqElem, Collection<?> elements) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Collection<SequenceInAlternative> getPreferredAlternativeChoiceOrderOf(Collection<SequenceInAlternative> sequences) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object getReferenceValueReplacementFor(Object referenceValue) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<FormatRequest> getOverruledFormattingOf(List<FormatRequest> pendingFormattingRequest) {
        // TODO Auto-generated method stub
        return null;
    }



}
