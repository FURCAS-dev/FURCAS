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

/**
 * 
 */
package org.eclipse.imp.parser;

import org.eclipse.core.runtime.IPath;

public interface ISourcePositionLocator
{
    /**
     * @param ast the root of the AST
     * @param offset the textual offset, in characters
     * @return the innermost AST node whose textual extent contains the given text offset
     */
    Object findNode(Object astRoot, int offset);

    /**
     * @param ast the root of the AST
     * @param startOffset the beginning of the textual extent, in characters
     * @param endOffset the end of the textual extent, in characters
     * @return the innermost AST node whose textual extent completely contains the given text extent
     */
    Object findNode(Object astRoot, int startOffset, int endOffset);

    /**
     * @param entity the program entity, e.g. AST node, token, or some
     * kind of type system object
     * @return the offset, in characters, of the beginning of the textual extent
     * spanned by the given entity
     */
    int getStartOffset(Object entity);

    /**
     * @param entity the program entity, e.g. AST node, token, or some
     * kind of type system object
     * @return the offset, in characters, of the end of the textual extent spanned by the given entity 
     * It should be the character offset of the last character of the token,
     * equivalent to <code>getStartOffset() + getLength() - 1</code>
     * 
     * 
     */
    int getEndOffset(Object entity);

    /**
     * @param entity the program entity, e.g. AST node, token, or some
     * kind of type system object
     * @return the length, in characters, of the textual extent spanned by the given AST node
     */
    int getLength(Object entity);

    /**
     * @return the workspace-relative or file-system absolute path to the compilation unit
     * (source or compiled, if no source) that contains the given AST node or ISourceEntity.
     * The path is in "portable" format, using the Eclipse convention '/' for the path
     * component separator.
     * @see org.eclipse.core.runtime.IPath#toPortableString()
     */
    IPath getPath(Object node);
}
