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
import com.sap.furcas.prettyprinter.Formatter.FormatRequest;

/**
 * A {@link PrintPolicy} which always defaults to the information/order as provided by the used {@link ConcreteSyntax}.
 * 
 * @author Stephan Erb
 *
 */
public class DefaultPrintPolicy implements PrintPolicy {

    @Override
    public PrintPolicy getPolicyFor(EObject modelElement, SequenceElement seqElem, Object value, ContextTemplate template) {
        return this; 
    }

    
    @Override
    public Collection<ContextTemplate> getPreferredTemplateOrderOf(EObject modelElement, SequenceElement seqElem, Collection<ContextTemplate> elements) {
        return elements;
    }
    
    @Override
    public Collection<?> getPreferredCollectionOrderOf(EObject modelElement, Property seqElem, Collection<?> elements) {
        return elements;
    }
    

    @Override
    public Collection<SequenceInAlternative> getPreferredAlternativeChoiceOrderOf(Collection<SequenceInAlternative> sequences) {
        return sequences;
    }

    @Override
    public Object getReferenceValueReplacementFor(Object referenceValue) {
        return referenceValue;
    }

    @Override
    public List<FormatRequest> getOverruledFormattingOf(List<FormatRequest> pendingFormattingRequest) {
        return pendingFormattingRequest;
    }

}
