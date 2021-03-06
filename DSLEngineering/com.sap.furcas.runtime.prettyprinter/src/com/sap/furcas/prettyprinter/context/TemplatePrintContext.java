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
package com.sap.furcas.prettyprinter.context;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import com.sap.furcas.metamodel.FURCAS.TCS.ContextTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.OperatorTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.SequenceElement;
import com.sap.furcas.prettyprinter.Formatter.FormatRequest;
import com.sap.furcas.prettyprinter.PrettyPrinter;
import com.sap.furcas.runtime.tcs.TcsUtil;

/**
 * A {@link PrintContext} which is used when the {@link PrettyPrinter} descends into
 * serializing a {@link ContextTemplate}.
 * 
 * @author Stephan Erb
 *
 */
public class TemplatePrintContext implements PrintContext {

    private final PrintContext parentContext;
    private final EObject modelElement;
    private final ContextTemplate template;
    private int priority;

    public TemplatePrintContext(PrintContext context, EObject modelElement, ContextTemplate template) {
        this.parentContext = context;
        this.modelElement = modelElement;
        this.template = template;
        this.priority = parentContext.getPriority();
    }

    public TemplatePrintContext(PrintContext context, EObject modelElement, OperatorTemplate template, int priority) {
        this(context, modelElement, template);
        this.priority = priority;
    }

    @Override
    public int getNextOffset() {
        return 0;
    }

    @Override
    public int getPriority() {
        return priority;
    }

    @Override
    public EObject getContextElementMatchingTag(String tag) {
       if (TcsUtil.matchesContext(template, tag)) {
           return modelElement;
       } else {
           return parentContext.getContextElementMatchingTag(tag);
       }
    }

    @Override
    public int getIndenationLevel() {
        return parentContext.getIndenationLevel();
    }

    @Override
    public int getAlternativeNestingLevel() {
        return parentContext.getAlternativeNestingLevel();
    }

    @Override
    public List<FormatRequest> getPendingFormattingRequest() {
        return parentContext.getPendingFormattingRequest();
    }

    @Override
    public Collection<FormatRequest> getBlockFormattingBetweenElements() {
        return Collections.emptyList();
    }

    @Override
    public SequenceElement getLastSequenceElement() {
       return parentContext.getLastSequenceElement();
    }

}
