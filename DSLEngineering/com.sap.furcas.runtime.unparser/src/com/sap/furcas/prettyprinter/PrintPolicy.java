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
package com.sap.furcas.prettyprinter;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import com.sap.furcas.metamodel.FURCAS.TCS.ContextTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.Property;
import com.sap.furcas.metamodel.FURCAS.TCS.SequenceElement;
import com.sap.furcas.metamodel.FURCAS.TCS.SequenceInAlternative;
import com.sap.furcas.prettyprinter.Formatter.FormatRequest;

/**
 * @author Stephan Erb
 *
 */
public class PrintPolicy {

    public PrintPolicy getPolicyFor(EObject modelElement, SequenceElement seqElem, Object value, ContextTemplate template) {
        // TODO for now: just the same policy
        return this; 
    }

    
    public Collection<ContextTemplate> getPreferredTemplateOrderOf(EObject modelElement, SequenceElement seqElem, Collection<ContextTemplate> elements) {
        // TODO for now: just the same order
        return elements;
    }
    
    public Collection<?> getPreferredCollectionOrderOf(EObject modelElement, Property seqElem, Collection<?> elements) {
        // TODO for now: just the same order
        return elements;
    }
    

    public Collection<SequenceInAlternative> getPreferredAlternativeChoiceOrderOf(Collection<SequenceInAlternative> sequences) {
        // TODO for now: just the same order
        return sequences;
    }

    public Object getReferenceValueReplacementFor(Object referenceValue) {
        // TODO for now: now overwriting, use even if null
        return referenceValue;
    }

    public List<FormatRequest> getOverruledFormattingOf(List<FormatRequest> pendingFormattingRequest) {
        // TODO for now: now overwriting, use even if null
        return pendingFormattingRequest;
    }



}
