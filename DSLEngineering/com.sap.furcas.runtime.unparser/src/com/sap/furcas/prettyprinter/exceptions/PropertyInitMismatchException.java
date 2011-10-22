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

import com.sap.furcas.metamodel.FURCAS.TCS.LookupPropertyInit;
import com.sap.furcas.metamodel.FURCAS.TCS.PrimitivePropertyInit;
import com.sap.furcas.metamodel.FURCAS.TCS.PropertyInit;
import com.sap.furcas.metamodel.FURCAS.TCS.Template;
import com.sap.furcas.runtime.tcs.TcsUtil;


public class PropertyInitMismatchException extends SyntaxMismatchException {

    private static final long serialVersionUID = 1L;
    private final PropertyInit propertyInit;
    private final String propertyName;

    /**
     * @param actualValueInModel  
     * @param expectedValueByPropInit 
     */
    public PropertyInitMismatchException(Object actualValueInModel, Object expectedValueByPropInit, PropertyInit propertyInit) {
        this.propertyInit = propertyInit;
        this.propertyName = TcsUtil.getPropertyName(propertyInit.getPropertyReference());
    }
    
    @Override
    protected Template getTemplate() {
        return propertyInit.getInjectorActionsBlock().getParentTemplate();
    }

    @Override
    protected String getMismatchErrorMessage() {
        return "Mismatch in PropertyInit";
    }

    @Override
    protected String getMismatchErrorBody() {
        if (propertyInit instanceof PrimitivePropertyInit) {
            return "Proprty " + propertyName + " does not match the expected primitive " +
                    ((PrimitivePropertyInit) propertyInit).getValue();
        }
        if (propertyInit instanceof LookupPropertyInit) {
            return "Property " + propertyName + " does not match OCL query " +
                    ((LookupPropertyInit) propertyInit).getValue();
        }
        return "Unknown property init type.";
    }
}
