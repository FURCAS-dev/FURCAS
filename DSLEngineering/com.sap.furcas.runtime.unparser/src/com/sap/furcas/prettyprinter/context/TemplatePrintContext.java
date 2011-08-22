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
import com.sap.furcas.prettyprinter.Formatter.FormatRequest;
import com.sap.furcas.runtime.tcs.TcsUtil;

/**
 * @author Stephan Erb
 *
 */
public class TemplatePrintContext implements PrintContext {

    private final PrintContext parentContext;
    private final EObject modelElement;
    private final ContextTemplate template;

    /**
     * @param modelElement
     * @param template
     */
    public TemplatePrintContext(PrintContext context, EObject modelElement, ContextTemplate template) {
        this.parentContext = context;
        this.modelElement = modelElement;
        this.template = template;
    }

    @Override
    public int getNextOffset() {
        return 0;
    }

    @Override
    public int getPriority() {
        return parentContext.getPriority();
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

}
