package com.sap.mi.tools.diagnostics.internal.model;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.management.ObjectName;
import javax.management.openmbean.CompositeData;

import com.sap.mi.fwk.internal.tracing.MiLocations;
import com.sap.mi.tools.diagnostics.internal.MoinJmxClient;
import com.sap.mi.tools.diagnostics.internal.messages.DiagnosticsMessages;
import com.sap.tc.moin.repository.jmx.ConnectionMBean;
import com.tssap.util.trace.TracerI;
import com.tssap.util.trace.TracingManager;

/**
 * Represents one connection
 * 
 * @author d031150
 */
public class ConnectionNode extends MBeanNode {

	private static final TracerI sTracer = TracingManager.getTracer(MiLocations.MI_DIAGNOSTICS);

	private final transient String mId;
	private final transient String mLabel;

	/**
	 * Creates a connection node
	 * 
	 * @param node
	 *            the parent node
	 * @param name
	 *            the object name
	 * @param connection
	 *            the connection delegate or <code>null</code> if the
	 *            connection is closed
	 * @param client
	 *            the JMX client
	 * @throws IOException
	 *             in case of failures
	 */
	public ConnectionNode(ConnectionsNode node, ObjectName name, ConnectionMBean connection, MoinJmxClient client)
			throws IOException {
		super(node, name, connection, client);
		if (connection == null) { // is null in case of closed connections
			mId = name.getKeyProperty(MoinJmxClient.OBJECT_NAME_SESSION)
					+ "-" + name.getKeyProperty(MoinJmxClient.OBJECT_NAME_CONNECTION_ID); //$NON-NLS-1$
			mLabel = null;
		} else {
			mId = connection.getId();
			mLabel = connection.getLabel();
		}
	}

	@Override
	protected ConnectionMBean getDelegate() {
		return (ConnectionMBean) super.getDelegate();
	}

	@Override
	public Object[] getChildren() {
		try {
			List<PartitionNode> result = new ArrayList<PartitionNode>(getRealPartitionNodes());
			// add null partition
			PartitionNode nullPartitionNode = getNullPartitionNode();
			if (nullPartitionNode != null)
				result.add(nullPartitionNode);
			return result.toArray(new Object[result.size()]);
		} catch (IOException e) {
			sTracer.error(e.getMessage(), e);
		}
		return NO_CHILDREN;
	}

	public String getId() {
		return mId;
	}

	public String getLabel() {
		return mLabel;
	}

	public boolean isAlive() {
		try {
			boolean alive = getDelegate().isAlive();
			return alive;
		} catch (Exception e) { // $JL-EXC$
			// may happen if connection just has become invalid
			return false;
		}
	}

	@Override
	public String getText() {
		try {
			if (!isAlive())
				return DiagnosticsMessages.ConnectionNode_closed_label;

			StringBuilder result = new StringBuilder();

			if (isDirty())
				result.append("* "); //$NON-NLS-1$

			result.append(mId);
			if (mLabel != null)
				result.append(" - ").append(mLabel); //$NON-NLS-1$

			return result.toString();
		} catch (IOException e) {
			sTracer.error(e.getMessage(), e);
			return "Error: " + e.getMessage(); //$NON-NLS-1$
		}
	}

	public int getNumberOfElementsInNullPartition() throws IOException {
		if (!isAlive())
			return 0;
		int nullPartitionSize = getDelegate().getNumberOfElementsInNullPartition();
		return nullPartitionSize;
	}

	public void deleteAllElementsInNullPartition() throws IOException {
		getDelegate().deleteAllElementsInNullPartition();
	}

	public String showAllocationStackTrace() throws IOException {
		StackTraceElement[] stackTrace = getDelegate().getAllocationStackTrace();
		Exception e = new Exception("Allocation stack of connection " + getText()); //$NON-NLS-1$
		e.setStackTrace(stackTrace);
		Writer writer = new StringWriter();
		e.printStackTrace(new PrintWriter(writer));
		writer.close();
		return writer.toString();
	}

	public String showContentOfModelPartition(String priString) throws IOException {
		return getDelegate().showContentOfPartition(priString);
	}

	public String[] getRootElementsInPartition(String priString) throws IOException {
		String[] elements = getDelegate().getRootElementsInPartition(priString);
		return elements;
	}

	public CompositeData getModelElement(String mriString) throws IOException {
		CompositeData modelElement = getDelegate().getElementByMRI(mriString);
		return modelElement;
	}

	public void revert() throws IOException {
		getDelegate().revert();
	}

	public void save() throws IOException {
		getDelegate().save();
	}

	public void close() throws IOException {
		getDelegate().close();
	}

	private List<PartitionNode> getRealPartitionNodes() throws IOException {
		ConnectionMBean delegate = getDelegate();
		if (!isAlive())
			return Collections.emptyList();
		try {
			String[] partitions = delegate.getDirtyPartitions();
			List<PartitionNode> result = new ArrayList<PartitionNode>(partitions.length);
			for (String partition : partitions)
				result.add(new PartitionNode(this, partition, false));
			return result;
		} catch (RuntimeException e) { // $JL-EXC$
			// bad response from Moin -> fall through
		}
		return Collections.emptyList();
	}

	private PartitionNode getNullPartitionNode() throws IOException {
		if (!isAlive())
			return null;
		try {
			int nullPartitionSize = getDelegate().getNumberOfElementsInNullPartition();
			if (nullPartitionSize > 0) {
				String nullPartitionPri = getDelegate().getNullPartition();
				return new PartitionNode(this, nullPartitionPri, true);
			}
		} catch (RuntimeException e) { // $JL-EXC$
			// bad response from Moin -> fall through
		}
		return null;
	}

	public boolean isDirty() throws IOException {
		if (getRealPartitionNodes().size() > 0)
			return true;
		return false;
	}

}
