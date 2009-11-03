package com.sap.mi.tools.diagnostics.internal.model;

import javax.management.ObjectName;

import com.sap.mi.tools.diagnostics.internal.MoinJmxClient;
import com.sap.mi.tools.diagnostics.internal.messages.DiagnosticsMessages;
import com.sap.tc.moin.repository.jmx.MoinMBean;

/**
 * Represents the "Moin" node for the Moin singleton
 * 
 * @author d031150
 */
public class MoinNode extends MBeanNode {

	private final ConnectionsNode mConnectionsNode;
	private String mId;

	public MoinNode(MoinMBean moin, ObjectName name, MoinJmxClient client) {
		super(null, name, moin, client);
		// Store child node to stay stable with the children. See
		// ConnectionsNode
		// for details.
		mConnectionsNode = new ConnectionsNode(this, getClient());
		mId = name.getKeyProperty(MoinJmxClient.OBJECT_NAME_MOIN_ID);
	}

	@Override
	public MoinMBean getDelegate() {
		return (MoinMBean) super.getDelegate();
	}

	@Override
	public Object[] getChildren() {
		return new Object[] { mConnectionsNode };
	}

	@Override
	public String getText() {
		return DiagnosticsMessages.bind(DiagnosticsMessages.MoinNode_moin_label, mId);
	}

}
