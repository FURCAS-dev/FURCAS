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

import com.sap.furcas.metamodel.FURCAS.TCS.Property;
import com.sap.furcas.metamodel.FURCAS.TCS.PropertyArg;
import com.sap.furcas.metamodel.FURCAS.TCS.stubs.LocatedElementStub;

public class PargStub extends LocatedElementStub implements PropertyArg {
    public Property property;

    @Override
    	public final Property getProperty() {
        return property;
    }

    @Override
    	public final void setProperty(Property property) {
        this.property = property;
    }
}