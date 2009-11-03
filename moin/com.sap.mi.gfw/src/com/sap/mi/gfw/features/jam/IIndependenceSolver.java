package com.sap.mi.gfw.features.jam;

/**
 * The Interface IIndependenceSolver.
 */
public interface IIndependenceSolver {

	/**
	 * Provides the unique key for the given business object.
	 * 
	 * @param bo
	 *            the given business object
	 * 
	 * @return unique key
	 */
	String getKeyForBusinessObject(Object bo);

	/**
	 * Provides the business object for the given key.
	 * 
	 * @param key
	 *            the unique key
	 * 
	 * @return the business object
	 */
	Object getBusinessObjectForKey(String key);
}
