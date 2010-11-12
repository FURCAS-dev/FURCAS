/**
 * <copyright>
 *
 * Copyright (c) 2010 Eclipse Modeling Project and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: OCLEditorMessages.java,v 1.1 2010/03/11 14:51:24 ewillink Exp $
 */

package org.eclipse.ocl.examples.editor.ui.messages;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * An accessor class for externalized strings.
 */
public class OCLEditorMessages {

	static final String BUNDLE_NAME = "org.eclipse.ocl.examples.editor.ui.messages.OCLEditorMessages"; //$NON-NLS-1$

	public static String no_message;
    public static String Input_ERROR_;
    
    public static String _UI_FileConflict_label;
    public static String _WARN_FileConflict;
	
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
			Class<IMessages> nlsClass = (Class<IMessages>) Class
				.forName("org.eclipse.ocl.internal.l10n.IMessages$NLS"); //$NON-NLS-1$
			messagesImpl = nlsClass.newInstance();
		} catch (NoClassDefFoundError e) {
			// expected in non-Eclipse environment
		} catch (Exception e) {
			// expected in non-Eclipse environment
		}
		
		if (messagesImpl == null) {
			// could not find the NLS class.  Try initializing the messages,
			//    ourselves
			initializeMessages();
			messagesImpl = new IMessages.Default();
		}
	}
	
	private static void initializeMessages() {
		ResourceBundle bundle = ResourceBundle.getBundle(BUNDLE_NAME);
		int publicStatic = Modifier.PUBLIC | Modifier.STATIC;
		
		Class<OCLEditorMessages> clazz = OCLEditorMessages.class;
		
		if (bundle != null) {
			Field[] fields = clazz.getDeclaredFields();
			
			for (int i = 0; i < fields.length; i++) {
				Field next = fields[i];
				
				if (((next.getModifiers() & publicStatic) == publicStatic)
						&& (next.getType() == String.class)) {
					String name = next.getName();
					
					try {
						try {
							next.set(null, bundle.getString(name));
						} catch (MissingResourceException e) {
							// just use its own name, then
							next.set(null, "Missing message for key: " + name); //$NON-NLS-1$
						}
					} catch (Exception e) {
						// oh, well.  Can't set a value for this one
					}
				}
			}
		}
	}
}
