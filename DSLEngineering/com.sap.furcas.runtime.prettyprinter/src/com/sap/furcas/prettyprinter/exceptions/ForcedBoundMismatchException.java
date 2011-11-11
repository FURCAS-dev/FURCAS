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

import org.eclipse.emf.ecore.EObject;

import com.sap.furcas.metamodel.FURCAS.TCS.ForcedLowerPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.ForcedUpperPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.Property;
import com.sap.furcas.metamodel.FURCAS.TCS.Template;
import com.sap.furcas.runtime.tcs.TcsUtil;


public class ForcedBoundMismatchException extends SyntaxMismatchException {

    private static final long serialVersionUID = 1L;
    private final Object value;
    private final ForcedLowerPArg lowerArg;
    private final Property prop;
    private final String propertyName;
    private final ForcedUpperPArg upperArg;

    public ForcedBoundMismatchException(Object value, Property prop, ForcedLowerPArg lowerArg, ForcedUpperPArg upperArg) {
        this.value = value;
        this.prop = prop;
        this.propertyName = TcsUtil.getPropertyName(prop.getPropertyReference());
        this.lowerArg = lowerArg;
        this.upperArg = upperArg;
    }
    
    @Override
    protected String getMismatchErrorMessage() {
        return "Mismatch in forced property bounds";
    }

    @Override
    protected String getMismatchErrorBody() {
        Object propValue = value;
        if (propValue instanceof EObject) {
            propValue = TcsUtil.getPropertyValue((EObject) value, prop.getPropertyReference());
        }
        Integer propValueSize = 0;
        if (!(propValue == null)) {
            propValueSize = 1;
        }
        if (propValue instanceof Collection<?>) {
            Collection<?> c = (Collection<?>) propValue;
            propValueSize = c.size();
        }

        String error = "Property " + propertyName;
        error += " has " + propValueSize + " elements, but expected are ";

        if (lowerArg != null) {
            error += " forced lower " + lowerArg.getValue();
        }
        if (upperArg != null) {
            error += " forced upper " + upperArg.getValue();
        }
        return error;
    }

    @Override
    protected Template getTemplate() {
        return prop.getParentTemplate();
    }

}
