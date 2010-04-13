/*******************************************************************************
 * Copyright (c) 2008 Lucas Bigeardel. All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Messages.java
 * 
 * Contributors: 
 * 		Lucas Bigeardel - initial API and implementation
 * 
 * 
 * $Id: Messages.java,v 1.2 2008/04/28 12:23:25 jlescot Exp $
 ******************************************************************************/

package org.eclipse.emf.ecoretools.codegen.builder.genmodelBuilder.l10n;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * l10n localization 
 * 
 * @author <a href="mailto:lucas.bigeardel@gmail.com">lucas.bigeardel@gmail.com</a>
 *
 */
public class Messages {
	private static final String BUNDLE_NAME = "messages"; //$NON-NLS-1$

	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle
			.getBundle(BUNDLE_NAME);

	private Messages() {
	}

	public static String getString(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
}
