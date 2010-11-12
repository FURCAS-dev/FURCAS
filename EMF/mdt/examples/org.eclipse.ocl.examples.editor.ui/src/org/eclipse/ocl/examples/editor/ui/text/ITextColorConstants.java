/*******************************************************************************
 * Copyright (c) 2007,2010 Eclipse Modeling Project and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.editor.ui.text;

import org.eclipse.swt.graphics.RGB;

@Deprecated // Use UniversalTextEditor
public interface ITextColorConstants {
	RGB DEFAULT =            		new RGB(  0,   0,   0);
	RGB DOUBLE_QUOTED_STRING =      new RGB(  0,   0, 255);
	RGB KEYWORD =                	new RGB(128,   0, 128);
	RGB MULTI_LINE_COMMENT =       	new RGB( 64,  64, 160);
    RGB PROCESSING_INSTRUCTION =    new RGB(191, 191, 191);
	RGB SINGLE_LINE_COMMENT =   	new RGB(  0, 128,  64);
	RGB SINGLE_QUOTED_STRING =      new RGB(  0,   0, 255);
	RGB UNTERMINATED_STRING =       new RGB(224,   0,   0);
}
