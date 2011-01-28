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
package com.sap.furcas.emf.stubs;

import com.sap.furcas.metamodel.FURCAS.TCS.AsPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.Template;

public class AsPargStub extends PargStub implements AsPArg {
    private String value;
    private Template template;

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public void setValue(String newValue) {
        value = value;
    }

    @Override
    public void setTemplate(Template newValue) {
        template = newValue;
    }

    @Override
    public Template getTemplate() {
        return template;
    }
}