/**
 * <copyright>
 *
 * Copyright (c) 2005, 2010 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   E.D.Willink - Bugs 176110, 191689 
 *   Zeligsoft - Bug 253512
 *   Borland - Bug 242880
 *
 * </copyright>
 *
 * $Id: OCLMessages.java,v 1.13 2010/02/27 13:27:36 ewillink Exp $
 */

package com.sap.emf.ocl.hiddenopposites;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * An accessor class for externalized strings.
 * 
 * @author Christian Vogt (cvogt)
 */
public class OCLMessages {

    static final String BUNDLE_NAME = "com.sap.emf.ocl.hiddenopposites.OCLMessages"; //$NON-NLS-1$

    public static String NonStaticAttribute_ERROR_;
    public static String NonStaticOperation_ERROR_;
    public static String Ambig_AssocEnd_;
    public static String HiddenOppositeOf;
    public static String NullProperty_ERROR_;
    public static String NullNavigationSource_ERROR_;
    public static String NullNavigationType_ERROR_;
    public static String AtPreInPostcondition_ERROR_;

    private static IMessages messagesImpl;

    public static String bind(String message, Object arg) {
	return messagesImpl.bind(message, arg);
    }

    public static String bind(String message, Object arg1, Object arg2) {
	return messagesImpl.bind(message, arg1, arg2);
    }

    public static String bind(String message, Object[] args) {
	return messagesImpl.bind(message, args);
    }

    static {
	try {
	    @SuppressWarnings("unchecked")
	    Class<IMessages> nlsClass = (Class<IMessages>) Class.forName("org.eclipse.ocl.internal.l10n.IMessages$NLS"); //$NON-NLS-1$
	    messagesImpl = nlsClass.newInstance();
	} catch (NoClassDefFoundError e) {
	    // expected in non-Eclipse environment
	} catch (Exception e) {
	    // expected in non-Eclipse environment
	}

	if (messagesImpl == null) {
	    // could not find the NLS class. Try initializing the messages,
	    // ourselves
	    initializeMessages();
	    messagesImpl = new IMessages.Default();
	}
    }

    private static void initializeMessages() {
	ResourceBundle bundle = ResourceBundle.getBundle(BUNDLE_NAME);
	int publicStatic = Modifier.PUBLIC | Modifier.STATIC;

	Class<OCLMessages> clazz = OCLMessages.class;

	if (bundle != null) {
	    Field[] fields = clazz.getDeclaredFields();

	    for (int i = 0; i < fields.length; i++) {
		Field next = fields[i];

		if (((next.getModifiers() & publicStatic) == publicStatic) && (next.getType() == String.class)) {
		    String name = next.getName();

		    try {
			try {
			    next.set(null, bundle.getString(name));
			} catch (MissingResourceException e) {
			    // just use its own name, then
			    next.set(null, "Missing message for key: " + name); //$NON-NLS-1$
			}
		    } catch (Exception e) {
			// oh, well. Can't set a value for this one
		    }
		}
	    }
	}
    }
}
