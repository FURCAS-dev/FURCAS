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


public class AmbigousTemplateException extends SyntaxMismatchException {

    private static final long serialVersionUID = 1L;
    private final EClassifier type;
    private final int numberOfTemplatesFound;

    public AmbigousTemplateException(EClassifier type, int numberOfTemplatesFound) {
        this.type = type;
        this.numberOfTemplatesFound = numberOfTemplatesFound;
    }
    
    @Override
    protected String getMismatchErrorMessage() {
        return "Ambigous template definition";
    }

    @Override
    protected String getMismatchErrorBody() {
        return "Found  " + numberOfTemplatesFound + " templates for type "
                + TcsUtil.joinNameList(EcoreHelper.getQualifiedName(type));
    }

    @Override
    protected Template getTemplate() {
        return null;
    }

}
