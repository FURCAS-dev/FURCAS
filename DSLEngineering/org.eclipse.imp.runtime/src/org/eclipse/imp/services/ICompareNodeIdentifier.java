/*******************************************************************************
 * Copyright (c) 2009 IBM Corporation.
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

/**
 * This interface enables the structured comparison view to determine which source
 * entities should be considered the same, so that their content/bodies/source text
 * should be compared.<br>
 * For example, in Java, two methods with the same name and the same signature
 * would be considered the same. In C, two functions with the same name would be
 * considered the same (since their argument types don't contribute to the unique
 * identification).<br>
 * For the purposes of this interface, two entities are "the same" iff their
 * "type codes" and "IDs" are identical.<br>
 * It's generally expected that any implementations of this interface are
 * language-specific. Implementations are free to use any values they wish for
 * the type codes and the ID strings.
 */
public interface ICompareNodeIdentifier extends ILanguageService {
    /**
     * Returns a "type code" for the given entity, which generally indicates the
     * kind of entity it is, and thus serves to distinguish it from other entities
     * that might have the same ID. The implementation of this interface is free
     * to use any set of "type codes" that it wishes.
     */
    public int getTypeCode(Object o);

    /**
     * Returns an ID for the given entity which is unique within the given file,
     * and which can thus be used to identify entities across two versions of the
     * same source file. The implementation of this interface is free to use any
     * set/format for IDs that it wishes.
     */
    public String getID(Object o);
}