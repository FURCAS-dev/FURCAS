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

import org.eclipse.emf.ecore.EClass;

import com.sap.furcas.metamodel.FURCAS.TCS.PrefixPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage;

public class PrefixPArgStub extends PargStub implements PrefixPArg {

    public String prefix;
    
    @Override
    public String getPrefix() {
        return prefix;
    }

    @Override
    public void setPrefix(String value) {
        prefix = value;
    }
    
    @Override
    public EClass eClass() {
        return TCSPackage.eINSTANCE.getPrefixPArg();
    }

}