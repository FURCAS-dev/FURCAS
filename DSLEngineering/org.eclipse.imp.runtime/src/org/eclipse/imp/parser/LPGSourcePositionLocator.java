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

package org.eclipse.imp.parser;

import lpg.runtime.IAst;
import lpg.runtime.IToken;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.imp.editor.ModelTreeNode;
import org.eclipse.imp.model.ICompilationUnit;

/**
 * Locator implementation that works for LPG-generated AST's using the base IAst
 * interface.
 * 
 * @author rfuhrer
 */
public class LPGSourcePositionLocator implements ISourcePositionLocator {
    private final IParseController fParseController;

    public LPGSourcePositionLocator(IParseController parseController) {
        fParseController= parseController;
    }

    public Object findNode(Object root, int offset) {
        return findNode(root, offset, offset);
    }

    public Object findNode(Object root, int startOffset, int endOffset) {
        if (!(root instanceof IAst))
            return root;

        IAst astNode= (IAst) root;

        if (astNode.getAllChildren() != null) {
            for(int i= 0; i < astNode.getAllChildren().size(); i++) {
                IAst maybe= (IAst) findNode(astNode.getAllChildren().get(i), startOffset, endOffset);
                if (maybe != null)
                    return maybe;
            }
        }
        if (startOffset >= astNode.getLeftIToken().getStartOffset()
                && endOffset <= astNode.getRightIToken().getEndOffset())
            return astNode;

        return null;
    }

    public int getStartOffset(Object entity) {
        if (entity instanceof IAst) {
            IAst n= (IAst) entity;
            return n.getLeftIToken().getStartOffset();
        } else if (entity instanceof IToken) {
            IToken tok= (IToken) entity;
            return tok.getStartOffset();
        } else if (entity instanceof ModelTreeNode) {
            ModelTreeNode treeNode= (ModelTreeNode) entity;
            return ((IAst) treeNode.getASTNode()).getLeftIToken().getStartOffset();
        }
        return 0;
    }

    public int getEndOffset(Object entity) {
        if (entity instanceof IAst) {
            IAst n= (IAst) entity;
            return n.getRightIToken().getEndOffset();
        } else if (entity instanceof IToken) {
            IToken tok= (IToken) entity;
            return tok.getEndOffset();
        } else if (entity instanceof ModelTreeNode) {
            ModelTreeNode treeNode= (ModelTreeNode) entity;
            return ((IAst) treeNode.getASTNode()).getRightIToken().getEndOffset();
        }
        return 0;
    }

    public int getLength(Object node) {
        return getEndOffset(node) - getStartOffset(node);
    }

    public IPath getPath(Object entity) {
        if (entity instanceof IAst) {
            IAst node= (IAst) entity;
            return fParseController.getProject().getRawProject().getFile(node.getLeftIToken().getILexStream().getFileName()).getFullPath();
        }
        if (entity instanceof ICompilationUnit) {
            ICompilationUnit cu= (ICompilationUnit) entity;
            return cu.getPath();
        }
        return new Path("");
    }
}
