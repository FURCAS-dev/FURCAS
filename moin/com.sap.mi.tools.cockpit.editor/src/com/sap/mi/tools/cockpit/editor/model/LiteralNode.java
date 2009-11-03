package com.sap.mi.tools.cockpit.editor.model;

import org.eclipse.core.runtime.Assert;

import com.sap.mi.fwk.ui.tree.nodes.TreeNode;

/**
 * @author d003456
 * 
 */
public final class LiteralNode extends TreeNode<String> {

	/**
	 * Creates {@link LiteralNode}.
	 * 
	 * @param parent
	 * @param object
	 */
	public LiteralNode(Object parent, String object) {

		super(parent, object);
		Assert.isNotNull(getParent());
	}

	public String getLabel() {

		return getValue();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.fwk.ui.tree.nodes.ITreeNode#getChildren()
	 */
	public Object[] getChildren() {

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.fwk.ui.tree.nodes.ITreeNode#hasChildren()
	 */
	public boolean hasChildren() {

		return false;
	}

}
