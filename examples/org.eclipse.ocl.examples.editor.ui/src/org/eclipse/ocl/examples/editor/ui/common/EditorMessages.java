/*******************************************************************************
 * Copyright (c) 2000,2010 Eclipse Modeling Project.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.editor.ui.common;

import org.eclipse.osgi.util.NLS;

/**
 * Helper class to get NLSed messages.
 */
public class EditorMessages extends NLS
{
	private static final String BUNDLE_NAME = EditorMessages.class.getName();

	private EditorMessages() {
		// Do not instantiate
	}

	public static String AbstractDecoratedTextEditor_error_saveAs_title;
	public static String AbstractDecoratedTextEditor_error_saveAs_message;
	
	static {
		NLS.initializeMessages(BUNDLE_NAME, EditorMessages.class);
	}
}
