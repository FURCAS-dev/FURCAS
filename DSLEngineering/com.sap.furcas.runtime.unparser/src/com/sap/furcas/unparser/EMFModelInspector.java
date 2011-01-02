/*******************************************************************************
 * Copyright (c) 2008-2010 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package com.sap.furcas.unparser;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import com.sap.furcas.runtime.common.util.EcoreHelper;
import com.sap.furcas.runtime.tcs.TcsUtil;

public class EMFModelInspector {

    public static Object get(EObject me, String propName) {
	if (me == null || propName == null) {
	    return null;
	}
	return me.eGet(me.eClass().getEStructuralFeature(propName));
    }

    public static String getString(EObject me, String propName) {
	try {
	    return (String) get(me, propName);
	} catch (Exception e) {
	    e.printStackTrace();
	    return null;
	}
    }
    
    public static Boolean getBool(EObject me, String propName) {
        return (Boolean) get(me, propName);
    }
    
    public static Integer getInteger(EObject me, String propName) {
        return (Integer) get(me, propName);
    }

    public static String getTypeName(EObject me) {
	if (me != null) {
	    EObject r = me;
	    if (r.eClass() instanceof EClass) {
		EClass c = r.eClass();
		return TcsUtil.joinNameList(EcoreHelper.getQualifiedName(c));
	    }
	}
	return null;
    }

    public static boolean isPrimitive(Object value) {
	return ((value instanceof String) || (value instanceof Boolean) || (value instanceof Double) || (value instanceof Integer));
    }

}
