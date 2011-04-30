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

/**
 * This interface represents a service that translates between program entities
 * and unique, persistable keys.
 * @author rfuhrer
 */
public interface IIdentityMapper extends ILanguageService {
    /**
     * Maps the given program entity to its corresponding key.
     * The key must be unique within the workspace containing the given
     * program entity.<br>
     * The key may be a String, but if not, its toString() implementation
     * must satisfy the following constraint:<br>
     *  <code>key1.equals(key2) iff key1.toString().equals(key2.toString())</code><br>
     * Also, the key must remain valid when persisted/serialized and restored.
     * However, there is no guarantee that it still refers to an existing entity
     * when retrieved from a persistent store (e.g., it is permissible that an
     * index containing a key may fall out of date).
     * @param entity a program entity, e.g. a compilation unit, a type, a
     * method, an expression, etc.
     * @return the key that uniquely represents the given program entity.
     */
    Object getKeyFor(Object entity);

    /**
     * @return the program entity corresponding to the given key
     */
    Object getEntityFor(Object key);
}
