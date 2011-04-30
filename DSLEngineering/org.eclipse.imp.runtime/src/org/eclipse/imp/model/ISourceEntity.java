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

/*
 * Created on Mar 30, 2007
 */
package org.eclipse.imp.model;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;

public interface ISourceEntity {
    String getName();

    ISourceEntity getParent();

    ISourceEntity getAncestor(Class ofType);

    IResource getResource();

    /**
     * Commit any pending changes to the given entity to disk.
     * @param monitor
     */
    void commit(IProgressMonitor monitor);
}
