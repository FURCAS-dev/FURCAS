package com.sap.mi.fwk.ui.internal.tree;

import com.sap.mi.fwk.ui.tree.TreeNodeDecorator;

public final class TreeNodeMarkerSupport {

	/**
	 * severity of a node
	 */
	private int maxSeverity = SEVERITY_UNKNOWN;

	/**
	 * INITIAL means that a marker has not been calculated at that point in time
	 */
	public static final int SEVERITY_UNKNOWN = -2;

	/**
	 * Returns the maximum severity of the corresponding node - used as an optimization by {@link TreeNodeDecorator}
	 * 
	 * @return the maximum severity of this node
	 */
	public int getMaxSeverity() {
		return maxSeverity;
	}

	/**
	 * Sets the computed maximum severity of the corresponding node
	 * 
	 * @param severity the new maximum severity of the node 
	 */
	public void setMaxSeverity(int severity) {
		maxSeverity = severity;
	}
}
