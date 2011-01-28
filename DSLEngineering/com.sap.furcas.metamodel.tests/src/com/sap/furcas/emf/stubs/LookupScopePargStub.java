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

import com.sap.furcas.metamodel.FURCAS.TCS.LookupScopePArg;

public class LookupScopePargStub extends PargStub implements LookupScopePArg {

    public String query;
    
    @Override
    public String getQuery() {
        return query;
    }

    @Override
    public void setQuery(String value) {
        query = value;
    }
}