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

/**
 * Represents a textual range within some text, expressed as a character offset and a length.
 */
public class SourceRange {
    private final int fOffset;
    private final int fLength;

    public SourceRange(int off, int len) {
        fOffset= off;
        fLength= len;
    }

    public int getLength() {
        return fLength;
    }

    public int getOffset() {
        return fOffset;
    }

    public boolean equals(Object o) {
        if (!(o instanceof SourceRange))
            return false;
        SourceRange other= (SourceRange) o;
        return (fOffset == other.fOffset) && (fLength == other.fLength);
    }

    public int hashCode() {
        return 631 + 3191 * fOffset + 4259 * fLength;
    }

    public String toString() {
        return "[" + fOffset + ":" + fLength + "]";
    }
}
