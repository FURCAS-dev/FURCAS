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

import com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.Template;
import com.sap.furcas.runtime.common.util.EcoreHelper;
import com.sap.furcas.runtime.tcs.TcsUtil;


public abstract class SyntaxMismatchException extends Exception {

    private static final long serialVersionUID = 1L;

    @Override
    public synchronized Throwable fillInStackTrace() {
        // Do not create a stack trace as we don't need it.
        // It is very costly when all we want is a deep return.
        return this;
    }

    protected String getTemplateName(Template template) {
        String name = TcsUtil.joinNameList(EcoreHelper.getQualifiedName(template.getMetaReference()));
        if (template instanceof ClassTemplate && ((ClassTemplate) template).getMode() != null) {
            name += " #" + ((ClassTemplate) template).getMode();
        }
        return name;
    }

    @Override
    public String getMessage() {
        StringBuilder builder = new StringBuilder();
        builder.append(getMismatchErrorMessage());
        if (getTemplate() != null) {
            builder.append(" in/of Template ").append(getTemplateName(getTemplate()));
        }
        builder.append(": ").append(getMismatchErrorBody());
        return builder.toString();
    }
    
    protected abstract String getMismatchErrorMessage();
    protected abstract String getMismatchErrorBody();
    protected abstract  Template getTemplate();

}
