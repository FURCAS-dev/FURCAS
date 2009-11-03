/*
 * Created on 16.11.2005
 */
package com.sap.mi.gfw.features.context.impl;

import com.sap.mi.gfw.features.context.IMoveBendpointContext;
import com.sap.mi.gfw.mm.datatypes.Point;
import com.sap.mi.gfw.mm.pictograms.FreeFormConnection;

/**
 * The Class MoveBendpointContext.
 */
public class MoveBendpointContext extends MoveContext implements IMoveBendpointContext {

	private Point bendpoint;

	private int bendpointIndex;

	private FreeFormConnection connection;

	/**
	 * The Constructor.
	 * 
	 * @param bendpoint
	 *            the bendpoint
	 */
	public MoveBendpointContext(Point bendpoint) {
		super();
		setBendpoint(bendpoint);
	}

	/**
	 * Gets the bendpoint.
	 * 
	 * @return Returns the bendpoint.
	 */
	public Point getBendpoint() {
		return bendpoint;
	}

	/**
	 * @param bendpoint
	 *            The bendpoint to set.
	 */
	private void setBendpoint(Point bendpoint) {
		this.bendpoint = bendpoint;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.context.IBendpointContext#getBendpointIndex()
	 */
	public int getBendpointIndex() {
		return bendpointIndex;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.context.IBendpointContext#getConnection()
	 */
	public FreeFormConnection getConnection() {
		return connection;
	}

	/**
	 * Sets the bendpoint index.
	 * 
	 * @param bendpointIndex
	 *            the new bendpoint index
	 */
	public void setBendpointIndex(int bendpointIndex) {
		this.bendpointIndex = bendpointIndex;
	}

	/**
	 * Sets the connection.
	 * 
	 * @param freeFormConnection
	 *            the new connection
	 */
	public void setConnection(FreeFormConnection freeFormConnection) {
		this.connection = freeFormConnection;
	}

	@Override
	public String toString() {
		String ret = super.toString();
		return ret + " bendpoint: " + getBendpoint() + " bendpointIndex: " + getBendpointIndex() + " connection: " + getConnection(); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}

}
