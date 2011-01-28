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

import com.sap.furcas.metamodel.FURCAS.TCS.ModePArg;

public class ModePargStub extends PargStub implements ModePArg {
    public String mode;

    /*
     * (non-Javadoc)
     * 
     * @see TCS.AsPArg#getValue()
     */
    @Override
    	public String getMode() {
        return mode;
    }

    /*
     * (non-Javadoc)
     * 
     * @see TCS.AsPArg#setValue(java.lang.String)
     */
    @Override
    	public void setMode(String value) {

    }

}