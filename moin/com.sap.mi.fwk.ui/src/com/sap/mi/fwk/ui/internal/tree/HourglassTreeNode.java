/**
 * Copyright (c) 2008 by SAP AG, Walldorf. http://www.sap.com All rights
 * reserved.
 * 
 * This software is the confidential and proprietary information of SAP AG,
 * Walldorf. You shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement you entered
 * into with SAP.
 * 
 * @author d024127 
 */
package com.sap.mi.fwk.ui.internal.tree;

import com.sap.mi.fwk.ui.tree.nodes.ITreeNode;
import com.sap.mi.fwk.ui.tree.nodes.TreeNode;

/**
 * Internal hourglass class as a place holder until MOIN data is loaded and
 * displayed in the tree
 * 
 * @author d024127
 */
public class HourglassTreeNode extends TreeNode<Object> {

	public HourglassTreeNode() {
		super(null, ""); //$NON-NLS-1$
	}

	@Override
	public Object getAdapter(final Class adapter) {
		return null;
	}

	public Object[] getChildren() {
		return ITreeNode.EMPTY_ARRAY;
	}

	public boolean hasChildren() {
		return false;
	}
}