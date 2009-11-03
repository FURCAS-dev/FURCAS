package com.sap.mi.tools.mmdeploy.internal.view;

/**
 * The tree proxy for the pending request to fetch the metamodels
 * 
 * @author d031150
 */
final class MmPendingNode {

	static final MmPendingNode INSTANCE = new MmPendingNode();

	private MmPendingNode() {
	}

	@Override
	public String toString() {
		return "Pending..."; //$NON-NLS-1$
	}

}
