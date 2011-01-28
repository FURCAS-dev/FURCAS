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

import com.sap.furcas.metamodel.FURCAS.TCS.CreateInPArg;

public class CreateInPArgStub extends PargStub implements CreateInPArg {

    public EList<String> pName;

    @Override
    public EList<String> getPropertyName() {
        return pName;
    }

}