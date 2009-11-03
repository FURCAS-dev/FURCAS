package com.sap.mi.gfw.dt;

import com.sap.mi.gfw.platform.IGFWExtension;

/**
 * The Interface IDiagramType.
 */
public interface IDiagramType extends IGFWExtension {

	/**
	 * Gets the id.
	 * 
	 * @return the id of the new diagram type
	 */
	String getId();

	/**
	 * Gets the name.
	 * 
	 * @return the name of the new diagram type
	 */
	String getName();

	/**
	 * Gets the description.
	 * 
	 * @return the description of the new diagram type
	 */
	String getDescription();
}
