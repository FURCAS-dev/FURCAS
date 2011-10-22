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
import com.sap.furcas.prettyprinter.Formatter.FormatRequest;

/**
 * This interface realizes a strategy to control the pretty printing progress.
 * 
 * @author Stephan Erb
 *
 */
public interface PrintPolicy {

    public PrintPolicy getPolicyFor(EObject modelElement, SequenceElement seqElem, Object value, ContextTemplate template);

    /**
     * Allow to change the order in which templates are tested. Only the first matching template is used
     * to serialize a model element.
     */
    public Collection<ContextTemplate> getPreferredTemplateOrderOf(EObject modelElement, SequenceElement seqElem,
            EObject value, Collection<ContextTemplate> elements);

    /**
     * Allow to alter the order in which elements in a collection property are serialized.
     */
    public Collection<?> getPreferredCollectionOrderOf(EObject modelElement, Property seqElem, Collection<?> elements);

    /**
     * Allow to change the order in which alternatives are tested for a matching choice. Only the
     * first matching choice is used to serialize the alternative.
     */
    public Collection<SequenceInAlternative> getPreferredAlternativeChoiceOrderOf(Collection<SequenceInAlternative> sequences);

    /**
     * Allow to change how a reference to a model element is represented as text.
     * The value should only be changed if the referenceValue is null, which happens whenever a reference is broken. 
     */
    public Object getReferenceValueReplacementFor(Object referenceValue);

    /**
     * Allow to overwrite the formatting between elements.
     */
    public List<FormatRequest> getOverruledFormattingOf(List<FormatRequest> pendingFormattingRequest);

}