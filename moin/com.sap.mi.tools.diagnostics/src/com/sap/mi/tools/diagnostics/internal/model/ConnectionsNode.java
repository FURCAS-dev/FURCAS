package com.sap.mi.tools.diagnostics.internal.model;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.management.ObjectName;

import com.sap.mi.fwk.internal.tracing.MiLocations;
import com.sap.mi.tools.diagnostics.internal.MoinJmxClient;
import com.sap.mi.tools.diagnostics.internal.messages.DiagnosticsMessages;
import com.sap.tc.moin.repository.jmx.ConnectionMBean;
import com.tssap.util.trace.TracerI;
import com.tssap.util.trace.TracingManager;

/**
 * Represents the structural "Connections" node
 * 
 * @author d031150
 */
public class ConnectionsNode extends StructureNode {

	private static final TracerI sTracer = TracingManager.getTracer(MiLocations.MI_DIAGNOSTICS);

	private final MoinJmxClient mClient;

	private final Map<ObjectName, ConnectionNode> mConnectionNodes = new LinkedHashMap<ObjectName, ConnectionNode>();

	public ConnectionsNode(MoinNode parent, MoinJmxClient client) {

		super(parent);
		mClient = client;
	}

	@Override
	public Object[] getChildren() {

		Map<ObjectName, ConnectionMBean> connections = mClient.getConnections();

		if (connections != null) {//d003456: connections can be null
			try {
				// Check all existing connections whether they are still returned.
				// If not,
				// this most likely indicates the connection not being alive
				// anymore. In this
				// case we relace the respective nodes by placeholders that only
				// know their name,
				// do not accept any operation calls, and that are specially
				// decorated.
				Map<ObjectName, DeadConnectionNode> toBeReplaced = new LinkedHashMap<ObjectName, DeadConnectionNode>();
				for (Entry<ObjectName, ConnectionNode> entry : mConnectionNodes.entrySet()) {
					ObjectName key = entry.getKey();
					if (!connections.containsKey(key)) {
						DeadConnectionNode deadNode = new DeadConnectionNode(this, key);
						toBeReplaced.put(key, deadNode);
					}
				}

				mConnectionNodes.putAll(toBeReplaced);

				// add the rest of the new connections
				for (Entry<ObjectName, ConnectionMBean> entry : connections.entrySet()) {
					ObjectName key = entry.getKey();
					ConnectionNode node;
					node = new ConnectionNode(this, key, entry.getValue(), mClient);
					mConnectionNodes.put(key, node);
				}
			}
			catch (IOException e) {
				sTracer.error(e.getMessage(), e);
			}
		}
		return mConnectionNodes.values().toArray(new Object[mConnectionNodes.size()]);
	}

	@Override
	public String getText() {

		Map<ObjectName, ConnectionMBean> connections = mClient.getConnections();
		if (connections != null) {
			return DiagnosticsMessages.bind(DiagnosticsMessages.ConnectionsNode_connections_label, connections.size());
		}
		return DiagnosticsMessages.ConnectionsNode_emptyConnections_label;
	}

}
