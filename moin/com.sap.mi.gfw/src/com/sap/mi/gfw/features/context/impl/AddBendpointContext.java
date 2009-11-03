package com.sap.mi.gfw.features.context.impl;

import com.sap.mi.gfw.features.context.IAddBendpointContext;
import com.sap.mi.gfw.mm.datatypes.Point;
import com.sap.mi.gfw.mm.pictograms.FreeFormConnection;

/**
 * The Class AddBendpointContext.
 */
public class AddBendpointContext extends LocationContext implements IAddBendpointContext {

	private FreeFormConnection freeFormConnection;

	private int bendpointIndex;

	/**
	 * Instantiates a new adds the bendpoint context.
	 * 
	 * @param connection
	 *            the connection
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 * @param index
	 *            the index
	 */
	public AddBendpointContext(FreeFormConnection connection, int x, int y, int index) {
		super(x, y);
		setConnection(connection);
		setBendpointIndex(index);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.context.IBendpointContext#getConnection()
	 */
	public FreeFormConnection getConnection() {
		return freeFormConnection;
	}

	/**
	 * Sets the connection.
	 * 
	 * @param freeFormConnection
	 *            the new connection
	 */
	public void setConnection(FreeFormConnection freeFormConnection) {
		this.freeFormConnection = freeFormConnection;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.context.IBendpointContext#getBendpointIndex()
	 */
	public int getBendpointIndex() {
		return bendpointIndex;
	}

	/**
	 * Sets the bendpoint index.
	 * 
	 * @param index
	 *            the new bendpoint index
	 */
	public void setBendpointIndex(int index) {
		this.bendpointIndex = index;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.context.IBendpointContext#getBendpoint()
	 */
	public Point getBendpoint() {
		return null;
	}

	@Override
	public String toString() {
		String ret = super.toString();
		return ret + " freeFormConnection: " + getConnection() + " bendpointIndex: " + getBendpointIndex(); //$NON-NLS-1$ //$NON-NLS-2$
	}

}
