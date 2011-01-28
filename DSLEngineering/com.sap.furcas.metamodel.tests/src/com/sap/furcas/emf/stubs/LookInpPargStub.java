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

import org.eclipse.emf.common.util.EList;

import com.sap.furcas.metamodel.FURCAS.TCS.LookInPArg;

public class LookInpPargStub extends PargStub implements LookInPArg {

    public EList<String> propertyName;

    @Override
    	public EList<String> getPropertyName() {
        return propertyName;
    }

}