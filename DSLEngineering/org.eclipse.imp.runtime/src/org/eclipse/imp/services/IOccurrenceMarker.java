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

import java.util.List;

import org.eclipse.imp.language.ILanguageService;
import org.eclipse.imp.parser.IParseController;

public interface IOccurrenceMarker extends ILanguageService {
    /**
     * @return the user-readable name of the kind of occurrence.
     */
    public String getKindName();

    /**
     * @param entity the AST node representing the given entity
     * @return the list of AST nodes representing occurrences of the given entity
     * in the same file as the entity.
     */
    public List<Object> getOccurrencesOf(IParseController parseCtrlr, Object entity);
}
