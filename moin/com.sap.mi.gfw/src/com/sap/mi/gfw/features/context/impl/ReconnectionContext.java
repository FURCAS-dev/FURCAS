/*
 * Created on 20.06.2005
 */
package com.sap.mi.gfw.features.context.impl;

import com.sap.mi.gfw.features.context.IReconnectionContext;
import com.sap.mi.gfw.features.context.impl.base.DefaultContext;
import com.sap.mi.gfw.mm.pictograms.Anchor;
import com.sap.mi.gfw.mm.pictograms.Connection;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;

/**
 * The Class ReconnectionContext.
 */
public class ReconnectionContext extends DefaultContext implements IReconnectionContext {

	/**
	 * Constant used to indicate that the <i>source</i> end of an existing connection is being reconnected to a new source node.
	 */
	public static String RECONNECT_SOURCE = "Reconnection source";//$NON-NLS-1$

	/**
	 * Constant used to indicate that the <i>target</i> end of an existing connection is being reconnected to a new target node.
	 */
	public static String RECONNECT_TARGET = "Reconnection target";//$NON-NLS-1$

	private Connection connection;

	private Anchor oldAnchor;

	private Anchor newAnchor;

	private PictogramElement targetPictogramElement;

	private String reconnectType = ""; //$NON-NLS-1$

	/**
	 * The Constructor.
	 * 
	 * @param connection
	 *            the connection
	 * @param oldAnchor
	 *            the old anchor
	 * @param newAnchor
	 *            the new anchor
	 */
	public ReconnectionContext(Connection connection, Anchor oldAnchor, Anchor newAnchor) {
		super();
		setConnection(connection);
		setOldAnchor(oldAnchor);
		setNewAnchor(newAnchor);
	}

	/**
	 * Gets the connection.
	 * 
	 * @return Returns the connection.
	 */
	public Connection getConnection() {
		return connection;
	}

	/**
	 * Sets the connection.
	 * 
	 * @param connection
	 *            The connection to set.
	 */
	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	/**
	 * Gets the new anchor.
	 * 
	 * @return Returns the newAnchor.
	 */
	public Anchor getNewAnchor() {
		return newAnchor;
	}

	/**
	 * Sets the new anchor.
	 * 
	 * @param newAnchor
	 *            The newAnchor to set.
	 */
	public void setNewAnchor(Anchor newAnchor) {
		this.newAnchor = newAnchor;
	}

	/**
	 * Gets the old anchor.
	 * 
	 * @return Returns the oldAnchor.
	 */
	public Anchor getOldAnchor() {
		return oldAnchor;
	}

	/**
	 * Sets the old anchor.
	 * 
	 * @param oldAnchor
	 *            The oldAnchor to set.
	 */
	public void setOldAnchor(Anchor oldAnchor) {
		this.oldAnchor = oldAnchor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.context.IReconnectionContext#getTargetPictogramElement()
	 */
	public PictogramElement getTargetPictogramElement() {
		return targetPictogramElement;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.context.IReconnectionContext#setTargetPictogramElement(com.sap.mi.gfw.mm.pictograms.PictogramElement)
	 */
	public void setTargetPictogramElement(PictogramElement targetPictogramElement) {
		this.targetPictogramElement = targetPictogramElement;
	}

	@Override
	public String toString() {
		String ret = super.toString();
		return ret + " connection: " + getConnection() + " newAnchor: " + getNewAnchor() + " oldAnchor: " + getOldAnchor() //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				+ " targetPctogramElement: " + getTargetPictogramElement(); //$NON-NLS-1$
	}

	/**
	 * Indicate whether the end of an existing connection is being reconnected to a new source node or a new target node.
	 * 
	 * @return {@link ReconnectionContext#RECONNECT_TARGET} or {@link ReconnectionContext#RECONNECT_SOURCE}
	 */
	public String getReconnectType() {
		return reconnectType;
	}

	/**
	 * Sets the reconnection type. {@link ReconnectionContext#RECONNECT_TARGET} or {@link ReconnectionContext#RECONNECT_SOURCE}
	 * 
	 * @param reconnectType
	 */
	public void setReconnectType(String reconnectType) {
		this.reconnectType = reconnectType;
	}

}