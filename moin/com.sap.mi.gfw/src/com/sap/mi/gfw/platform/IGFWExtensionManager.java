/**
 * 
 */
package com.sap.mi.gfw.platform;

import com.sap.mi.gfw.dt.IDiagramType;
import com.sap.mi.gfw.dt.IDiagramTypeProvider;

/**
 * The Interface IGFWExtensionManager.
 */
public interface IGFWExtensionManager {

	/**
	 * Gets the diagram type provider extension ids.
	 * 
	 * @param diagramTypeId
	 *            the diagram type id
	 * 
	 * @return extension id's of all the diagram type providers which can handle the given diagram type id.
	 */
	String[] getDiagramTypeProviderExtensionIds(String diagramTypeId);

	/**
	 * Creates the diagram type provider.
	 * 
	 * @param providerId
	 *            the provider id
	 * 
	 * @return the i diagram type provider
	 */
	IDiagramTypeProvider createDiagramTypeProvider(String providerId);

	/**
	 * Gets the diagram types.
	 * 
	 * @return the diagram types
	 */
	IDiagramType[] getDiagramTypes();
}
