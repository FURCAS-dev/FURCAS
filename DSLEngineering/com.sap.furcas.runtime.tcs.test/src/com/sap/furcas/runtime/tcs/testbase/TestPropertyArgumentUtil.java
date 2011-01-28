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
package com.sap.furcas.runtime.tcs.testbase;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sap.furcas.emf.stubs.PostfixPArgStub;
import com.sap.furcas.emf.stubs.PrefixPArgStub;
import com.sap.furcas.runtime.tcs.PropertyArgumentUtil;


public class TestPropertyArgumentUtil {

    @Test
    public void testStripPrefixPostfix() {
        PrefixPArgStub prefix = new PrefixPArgStub();
        prefix.prefix = "aa";
        
        PostfixPArgStub postfix = new PostfixPArgStub();
        postfix.postfix = "zz";
        
        String testString = "aa123zz";
        
        assertEquals("Prefix and postfix must be gone", "123", PropertyArgumentUtil.stripPrefixPostfix(testString, prefix, postfix));
        assertEquals("Should not be altered at all ", "aa123zz", PropertyArgumentUtil.stripPrefixPostfix(testString, null, null));
        assertEquals("Only prefix should be gone", "123zz", PropertyArgumentUtil.stripPrefixPostfix(testString, prefix, null));
        assertEquals("Only postfix should be gone", "aa123", PropertyArgumentUtil.stripPrefixPostfix(testString, null, postfix));
    }
    
}
