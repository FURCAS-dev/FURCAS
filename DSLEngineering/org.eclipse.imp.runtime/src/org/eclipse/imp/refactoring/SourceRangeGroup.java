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

package org.eclipse.imp.refactoring;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;

/**
 * Represents a set of <code>SourceRange</code>s in the file corresponding to an <code>IFile</code>.
 */
public class SourceRangeGroup {
    public IFile fFile;
    public List<SourceRange> fRanges= new ArrayList<SourceRange>();

    public SourceRangeGroup(IFile file) {
        fFile= file;
    }

    public void addReference(SourceRange range) {
        fRanges.add(range);
    }
    
    /**
     * @return Returns the file.
     */
    public IFile getFile() {
        return fFile;
    }

    public List<SourceRange> getRanges() {
        return fRanges;
    }
}
