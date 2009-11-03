package com.sap.mi.tools.diagnostics.internal.model;

import org.eclipse.core.runtime.PlatformObject;

/**
 * <p>Title:       TreeNode</p>
 * <p>Description: </p>
 * <p>Copyright:   Copyright (c) 2006</p>
 * <p>Company:     SAP AG</p>
 * @author        d031150
 * @since         NYC
 */
public abstract class TreeNode extends PlatformObject {

    protected static final Object[] NO_CHILDREN = new Object[0];
    
    private TreeNode mParent;

    public TreeNode(TreeNode parent) {
        mParent = parent;
    }

    public boolean hasChildren() {
        Object[] children = getChildren();
        return children != null ? children.length > 0 : true;
    }

    public Object[] getChildren() {
        return NO_CHILDREN;
    }

    public Object getParent() {
        return mParent;
    }

    public String getText() {
        return toString();
    }
    
}