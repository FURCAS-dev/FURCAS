package com.sap.mi.gfw.mapping;

/**
 * The Interface ILinkCreationInfo.
 */
public interface ILinkCreationInfo {

	/**
	 * Gets the business objects.
	 * 
	 * @return list of business objects which will connected with a pictogram element
	 */
	Object[] getBusinessObjects();

	/**
	 * Gets the property.
	 * 
	 * @return a property which will be used as link property
	 */
	String getProperty();
}
