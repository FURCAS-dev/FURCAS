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
 * Created on Mar 13, 2007
 */
package org.eclipse.imp.model.internal;

import org.eclipse.core.runtime.IPath;
import org.eclipse.imp.model.IPathEntry;

public class PathEntry implements IPathEntry {
    private final IPath fPath;
    private final PathEntryType fType;

    public PathEntry(PathEntryType type, IPath path) {
        fType= type;
        fPath= path;
    }

    public PathEntryType getEntryType() {
        return fType;
    }

    public IPath getPath() {
        return fPath;
    }

    public String toString() {
	return "<" + fType + ": " + fPath.toPortableString() + ">";
    }
}
