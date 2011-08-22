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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import com.sap.furcas.prettyprinter.Formatter.FormatRequest;
import com.sap.furcas.prettyprinter.Formatter.Type;

/**
 * @author Stephan Erb
 *
 */
public class InitialPrintContext implements PrintContext {
    
    private final FormatRequest formatRequest = FormatRequest.create(Type.SKIP_SPACE);

    @Override
    public int getNextOffset() {
        return 0;
    }

    @Override
    public int getPriority() {
        return Integer.MAX_VALUE; // lowest priority
    }

    @Override
    public EObject getContextElementMatchingTag(String tag) {
        return null;
    }

    @Override
    public int getIndenationLevel() {
        return 0;
    }

    @Override
    public List<FormatRequest> getPendingFormattingRequest() {
        ArrayList<FormatRequest> requests = new ArrayList<FormatRequest>();
        requests.add(formatRequest);
        return requests;
    }
    @Override
    public int getAlternativeNestingLevel() {
        return 0;
    }

    @Override
    public Collection<FormatRequest> getBlockFormattingBetweenElements() {
        return Collections.emptyList();
    }

}
