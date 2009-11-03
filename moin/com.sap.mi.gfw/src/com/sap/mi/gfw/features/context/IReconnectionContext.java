/*
 * Created on 16.11.2005
 */
package com.sap.mi.gfw.features.context;

import com.sap.mi.gfw.features.context.impl.ReconnectionContext;
import com.sap.mi.gfw.mm.pictograms.Anchor;
import com.sap.mi.gfw.mm.pictograms.Connection;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;

/**
 * The Interface IReconnectionContext.
 */
public interface IReconnectionContext extends IContext {

	/**
	 * Gets the connection.
	 * 
	 * @return the connection
	 */
	Connection getConnection();

	/**
	 * Gets the old anchor.
	 * 
	 * @return the old anchor
	 */
	Anchor getOldAnchor();

	/**
	 * Gets the new anchor.
	 * 
	 * @return the new anchor
	 */
	Anchor getNewAnchor();

	/**
	 * Gets the target pictogram element.
	 * 
	 * @return the target pictogram element
	 */
	PictogramElement getTargetPictogramElement();

	/**
	 * Sets the target pictogram element.
	 * 
	 * @param targetPictogramElement
	 *            the new target pictogram element
	 */
	void setTargetPictogramElement(PictogramElement targetPictogramElement);

	/**
	 * Indicate whether the end of an existing connection is being reconnected to a new source node or a new target node.
	 * 
	 * @return {@link ReconnectionContext#RECONNECT_TARGET} or {@link ReconnectionContext#RECONNECT_SOURCE}
	 */
	String getReconnectType();
}