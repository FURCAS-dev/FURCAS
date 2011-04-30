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
package org.eclipse.imp.editor;

public class ModelTreeNode {
    public static final int DEFAULT_CATEGORY= 0;

    private static final ModelTreeNode[] NO_CHILDREN= new ModelTreeNode[0];

    private ModelTreeNode[] fChildren= NO_CHILDREN;

    private ModelTreeNode fParent;

    private final Object fASTNode;

    private final int fCategory;

    public ModelTreeNode(Object astNode) {
        this(astNode, DEFAULT_CATEGORY);
    }

    public ModelTreeNode(Object astNode, int category) {
        fASTNode= astNode;
        fCategory= category;
    }

    public ModelTreeNode(Object astNode, ModelTreeNode parent) {
        this(astNode, parent, DEFAULT_CATEGORY);
    }

    public ModelTreeNode(Object astNode, ModelTreeNode parent, int category) {
        fASTNode= astNode;
        fParent= parent;
        fCategory= category;
    }

    public void setChildren(ModelTreeNode[] children) {
        fChildren= children;
        for(int i= 0; i < children.length; i++) {
            children[i].fParent= this;
        }
    }

    public void addChild(ModelTreeNode child) {
        ModelTreeNode[] newChildren= new ModelTreeNode[fChildren.length + 1];
        System.arraycopy(fChildren, 0, newChildren, 0, fChildren.length);
        newChildren[fChildren.length]= child;
        fChildren= newChildren;
    }

    public ModelTreeNode[] getChildren() {
        return fChildren;
    }

    public ModelTreeNode getParent() {
        return fParent;
    }

    public Object getASTNode() {
        return fASTNode;
    }

    public int getCategory() {
        return fCategory;
    }

    public String toString() {
        StringBuilder sb= new StringBuilder();

        sb.append(fASTNode.toString());
        if (fChildren.length > 0) {
            sb.append(" [");
            for(int i= 0; i < fChildren.length; i++) {
                sb.append(fChildren[i].toString());
            }
            sb.append(" ]");
        }
        return sb.toString();
    }
}
