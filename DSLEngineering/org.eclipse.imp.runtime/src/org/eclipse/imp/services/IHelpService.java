/*******************************************************************************
* Copyright (c) 2008 IBM Corporation.
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
import org.eclipse.jface.text.IRegion;

public interface IHelpService extends ILanguageService {
    /**
     * Returns the language-specific context appropriate for the given base context,
     * if any. A language-specific
     * implementation should return a context appropriate for the language.
     * Note that the IContext can refer to related topics, including that of
     * the IMP editor, by means of the getRelatedTopics() method.
     * @param part an IMP-related part for which help has been requested
     * @return
     */
    String getContextId(String baseContextId);

    /**
     * Typically called when a structured (non-textual) view has focus.
     * @param target an AST node, ISourceEntity, or other program entity
     * @return the help text for the given entity, possibly HTML formatted
     */
    String getHelp(Object target, IParseController parseController);

    /**
     * Typically called when a textual view has focus.
     * @param target a selected text region for which help was requested
     * @return the help text for the given entity, possibly HTML formatted
     */
    String getHelp(IRegion target, IParseController parseController);
}
