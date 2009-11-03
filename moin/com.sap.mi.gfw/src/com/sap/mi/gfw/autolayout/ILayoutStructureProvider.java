package com.sap.mi.gfw.autolayout;

import com.sap.mi.gfw.mm.pictograms.Connection;
import com.sap.mi.gfw.mm.pictograms.ContainerShape;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;

/**
 * The Interface ILayoutStructureProvider. Provides layout information like root object, child PictogramElements (PEs) of a given PE,
 * outgoing Connections of a PE and the target PE of a given Connection.
 */
public interface ILayoutStructureProvider {

	/**
	 * the root object for the layout.
	 * 
	 * @return the root
	 */
	ContainerShape getRoot();

	/**
	 * Gets the children.
	 * 
	 * @param parent
	 *            the parent
	 * 
	 * @return the parent of this container
	 */
	PictogramElement[] getChildren(PictogramElement parent);

	/**
	 * Gets the outgoing connections.
	 * 
	 * @param pe
	 *            the pe
	 * 
	 * @return the nodes this source node has pointers to
	 */
	Connection[] getOutgoingConnections(PictogramElement pe);

	/**
	 * Gets the target PictogramElement of the connection.
	 * 
	 * @param connection
	 *            the connection
	 * 
	 * @return the target PictogramElement
	 */
	PictogramElement getTarget(Connection connection);
}