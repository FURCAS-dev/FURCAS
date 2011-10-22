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
package com.sap.furcas.prettyprinter.exceptions;

import java.util.Collection;

import com.sap.furcas.metamodel.FURCAS.TCS.Alternative;
import com.sap.furcas.metamodel.FURCAS.TCS.Template;


public class AlternativeChoiceMismatch extends SyntaxMismatchException {

    private static final long serialVersionUID = 1L;
    private final Alternative seqElem;
    private final Collection<SyntaxMismatchException> exceptions;

    public AlternativeChoiceMismatch(Alternative seqElem, Collection<SyntaxMismatchException> exceptions) {
        this.seqElem = seqElem;
        this.exceptions = exceptions;
    }

    @Override
    protected String getMismatchErrorMessage() {
        return "No matching choice for alternative";
    }

    @Override
    protected String getMismatchErrorBody() {
        StringBuilder error = new StringBuilder();
        int i = 0;
        for (SyntaxMismatchException e : exceptions) {
            error.append("Choice ").append(i).append(": ").append(e.getMessage());
            i++;
        }
        return error.toString();
    }

    @Override
    protected Template getTemplate() {
        return seqElem.getParentTemplate();
    }

}
