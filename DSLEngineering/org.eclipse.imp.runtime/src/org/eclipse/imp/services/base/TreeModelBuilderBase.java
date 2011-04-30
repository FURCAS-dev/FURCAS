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

package org.eclipse.imp.services.base;

import java.util.Stack;

import org.eclipse.imp.core.ErrorHandler;
import org.eclipse.imp.editor.ModelTreeNode;
import org.eclipse.imp.language.ILanguageService;

public abstract class TreeModelBuilderBase implements ILanguageService {
    protected ModelTreeNode fModelRoot;

    private Stack<ModelTreeNode> fItemStack= new Stack<ModelTreeNode>();

    public final ModelTreeNode buildTree(Object rootASTNode) {
        fItemStack.push(fModelRoot= createTopItem(new ModelTreeNode(rootASTNode)));
        try {
            visitTree(rootASTNode);
        } catch (Exception e) {
            ErrorHandler.reportError("Exception caught from invocation of language-specific tree model builder implementation", e);
        }
        fItemStack.pop();
        return fModelRoot;
    }

    protected abstract void visitTree(Object root);

    protected ModelTreeNode createTopItem(Object n) {
        return createTopItem(n, ModelTreeNode.DEFAULT_CATEGORY);
    }

    protected ModelTreeNode createTopItem(Object n, int category) {
        ModelTreeNode treeNode= new ModelTreeNode(n, category);
        return treeNode;
    }

    protected ModelTreeNode createSubItem(Object n) {
        return createSubItem(n, ModelTreeNode.DEFAULT_CATEGORY);
    }

    protected ModelTreeNode createSubItem(Object n, int category) {
        final ModelTreeNode parent= fItemStack.peek();
        ModelTreeNode treeNode= new ModelTreeNode(n, parent, category);

        parent.addChild(treeNode);
        return treeNode;
    }

    protected ModelTreeNode pushSubItem(Object n) {
        return pushSubItem(n, ModelTreeNode.DEFAULT_CATEGORY);
    }

    protected ModelTreeNode pushSubItem(Object n, int category) {
        return fItemStack.push(createSubItem(n, category));
    }

    protected void popSubItem() {
        fItemStack.pop();
    }
}
