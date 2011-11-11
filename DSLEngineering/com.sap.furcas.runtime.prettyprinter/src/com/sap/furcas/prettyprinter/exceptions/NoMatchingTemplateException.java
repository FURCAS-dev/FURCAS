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

import org.eclipse.emf.ecore.EClassifier;

import com.sap.furcas.metamodel.FURCAS.TCS.Template;
import com.sap.furcas.runtime.common.util.EcoreHelper;
import com.sap.furcas.runtime.tcs.TcsUtil;


public class NoMatchingTemplateException extends SyntaxMismatchException {
    
    private static final long serialVersionUID = 1L;
    private final EClassifier type;
    private final String mode;

    public NoMatchingTemplateException(EClassifier type) {
        this(type, null);
    }
    
    public NoMatchingTemplateException(EClassifier type, String mode) {
        this.type = type;
        this.mode = mode;
    }
    
    @Override
    protected String getMismatchErrorMessage() {
        return "No matching template found";
    }

    @Override
    protected String getMismatchErrorBody() {
        String error = "There is no template for type " + TcsUtil.joinNameList(EcoreHelper.getQualifiedName(type));
        if (mode != null) {
            error += " with mode " + mode;
        }
        return error;       
    }

    @Override
    protected Template getTemplate() {
        return null;
    }
}
