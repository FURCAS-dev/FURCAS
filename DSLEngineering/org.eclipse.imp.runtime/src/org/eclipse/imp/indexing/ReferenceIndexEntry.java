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

package org.eclipse.imp.indexing;

import org.eclipse.core.resources.IFile;

public class ReferenceIndexEntry extends IndexEntry {
    public final static char REFERENCE_TYPE= 'R';

    public ReferenceIndexEntry() { }

    // TODO This isn't right: we need to uniquely identify both the referee and the referent.
    // The 'file' field can't serve both purposes, so we need another, along with another
    // 'name' field.
    // Also, is the 'name' field used to identify the parent entity containing the reference?
    public ReferenceIndexEntry(int type, String name, IFile file, int start, int end) {
        super(type, name, file, start, end);
    }

    public char getEntryKind() {
        return REFERENCE_TYPE;
    }

    protected void readExtraFields(String[] fields) {
        // do nothing
    }

    public Object findASTNode(Object ast) {
        // TODO Auto-generated method stub
        return null;
    }
}
