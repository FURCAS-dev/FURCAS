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
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import com.sap.furcas.metamodel.FURCAS.TCS.Alternative;
import com.sap.furcas.metamodel.FURCAS.TCS.Block;
import com.sap.furcas.metamodel.FURCAS.TCS.ConditionalElement;
import com.sap.furcas.metamodel.FURCAS.TCS.SequenceElement;
import com.sap.furcas.metamodel.FURCAS.TCS.Template;
import com.sap.furcas.prettyprinter.Formatter.FormatRequest;
import com.sap.furcas.prettyprinter.TemplateHandler;
import com.sap.furcas.runtime.common.util.ContextAndForeachHelper;


/**
 * Instances of this class encapsulate the relevent information about everything that
 * has been pretty printed up to the creation of the respective context instance. 
 * 
 * @author Stephan Erb
 *
 */
public interface PrintContext {

    /**
     * The offset where the next serialized element will have to start. Offset starts at 0
     * for the first element and increases depth-first, from left to right.
     */
    public int getNextOffset();
    
    /**
     * Current operator priority as required for the adding correct parenthesis around
     * a given expression tree. 0 represents the highest priority.
     */
    public int getPriority();
    
    /**
     * Find the most recent corresponding context element within the stack of
     * {@link TemplateHandler} invocations leading to the currently serialized element.
     *   
     * @see ContextAndForeachHelper
     */
    public EObject getContextElementMatchingTag(String tag);

    /**
     * The current level of logical indentation as given by the nesting of
     * {@link Block}s. The root element starts at indentation levlel 0.
     */
    public int getIndenationLevel();
    
    /**
     * The current number of nested  {@link Alternative}s and {@link ConditionalElement}s
     * within the currently printed {@link Template}. 
     */
    public int getAlternativeNestingLevel();

    /**
     * The list of issued {@link FormatRequest formatting requests} that have to be realized
     * before the next element with syntactic contribution can be printed. 
     */
    public List<FormatRequest> getPendingFormattingRequest();
    
    /**
     * The {@link SequenceElement} of the last printed element.
     */
    public SequenceElement getLastSequenceElement();

    /**
     * The formatting as required by the configuration of the inner-most {@link Block}.
     */
    public Collection<FormatRequest> getBlockFormattingBetweenElements();


}
