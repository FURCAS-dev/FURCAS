package com.sap.mi.gfw.features.context.impl;

import com.sap.mi.gfw.features.context.IRemoveBendpointContext;
import com.sap.mi.gfw.features.context.impl.base.DefaultContext;
import com.sap.mi.gfw.mm.datatypes.Point;
import com.sap.mi.gfw.mm.pictograms.FreeFormConnection;

/**
 * The Class RemoveBendpointContext.
 */
public class RemoveBendpointContext extends DefaultContext implements IRemoveBendpointContext {

	private FreeFormConnection freeFormConnection;

	private Point bendpoint;

	private int bendpointIndex;

	/**
	 * Instantiates a new removes the bendpoint context.
	 * 
	 * @param freeFormConnection
	 *            the free form connection
	 * @param bendpoint
	 *            the bendpoint
	 */
	public RemoveBendpointContext(FreeFormConnection freeFormConnection, Point bendpoint) {
		super();
		setConnection(freeFormConnection);
		setBendpoint(bendpoint);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.context.IBendpointContext#getBendpoint()
	 */
	public Point getBendpoint() {
		return bendpoint;
	}

	/**
	 * Sets the bendpoint.
	 * 
	 * @param bendpoint
	 *            the new bendpoint
	 */
	public void setBendpoint(Point bendpoint) {
		this.bendpoint = bendpoint;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.context.IBendpointContext#getConnection()
	 */
	public FreeFormConnection getConnection() {
		return freeFormConnection;
	}

	/**
	 * Sets the bendpoint index.
	 * 
	 * @param index
	 *            the new bendpoint index
	 */
	public void setBendpointIndex(int index) {
		bendpointIndex = index;
	}

	@Override
	public String toString() {
		String ret = super.toString();
		return ret + " bendpoint: " + getBendpoint() + " bendpointIndex: " + getBendpointIndex() + " freeFormConnection: " //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				+ getConnection();
	}

}
