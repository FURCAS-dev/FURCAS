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

import java.io.FileWriter;
import java.io.IOException;

import org.eclipse.core.resources.IFile;

public abstract class IndexEntry {
    // TODO would be nice to make these 'final'...
    protected int fType;
    protected String fName;
    protected int fStart;
    protected int fEnd;
    protected String fPath;

    public IndexEntry() { }

    public IndexEntry(int type, String name, IFile file, int start, int end) {
        fType= type;
        fName= name;
        fPath= file.getFullPath().toString();
        fStart= start;
        fEnd= end;
    }

    public abstract char getEntryKind();

    public void saveToStream(FileWriter writer) throws IOException {
        writer.write(getEntryKind());
        writer.write(':');
        writer.write(fType);
        writer.write(':');
        writer.write(fPath);
        writer.write(':');
        writer.write(fName);
        writer.write(':');
        writer.write(fStart);
        writer.write(':');
        writer.write(fEnd);
    }

    public final void parseFromString(String s) {
        String[] fields= s.split(":");

        fType= Integer.parseInt(fields[1]);
        fPath= fields[2];
        fName= fields[3];
        fStart= Integer.parseInt(fields[4]);
        fEnd= Integer.parseInt(fields[5]);
        readExtraFields(fields);
    }

    protected abstract void readExtraFields(String[] fields);

    public abstract Object findASTNode(Object ast);
}
