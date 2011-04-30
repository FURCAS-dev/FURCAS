/*******************************************************************************
* Copyright (c) 2007 IBM Corporation.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*    Robert Fuhrer (rfuhrer@watson.ibm.com) - initial API and implementation

*******************************************************************************/

package org.eclipse.imp.services;

import org.eclipse.imp.language.ILanguageService;
import org.eclipse.imp.parser.IParseController;

/**
 * Essentially the same as IFormattingStrategy, but the format() method
 * takes an IParseController as an argument, so that the language-specific
 * formatter has access to an AST to drive formatting decisions.
 * @author Dr. Robert M. Fuhrer
 */
public interface ISourceFormatter extends ILanguageService {
    void formatterStarts(String initialIndentation);

    String format(IParseController parseController, String content, boolean isLineStart, String indentation, int[] positions);

    void formatterStops();
}
