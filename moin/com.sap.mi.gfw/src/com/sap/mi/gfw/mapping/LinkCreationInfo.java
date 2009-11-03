package com.sap.mi.gfw.mapping;

/**
 * The Class LinkCreationInfo.
 */
public class LinkCreationInfo implements ILinkCreationInfo {

	private Object[] businessObjects;

	private String property;

	/**
	 * Instantiates a new link creation info.
	 * 
	 * @param businessObject
	 *            the business object
	 */
	public LinkCreationInfo(Object businessObject) {
		this(new Object[] { businessObject });
	}

	/**
	 * Instantiates a new link creation info.
	 * 
	 * @param businessObjects
	 *            the business objects
	 */
	public LinkCreationInfo(Object[] businessObjects) {
		this(businessObjects, null);
	}

	/**
	 * Instantiates a new link creation info.
	 * 
	 * @param businessObjects
	 *            the business objects
	 * @param property
	 *            the property
	 */
	public LinkCreationInfo(Object[] businessObjects, String property) {
		super();
		this.businessObjects = businessObjects;
		this.property = property;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.mapping.ILinkCreationInfo#getBusinessObjects()
	 */
	public Object[] getBusinessObjects() {
		return businessObjects;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.mapping.ILinkCreationInfo#getProperty()
	 */
	public String getProperty() {
		return property;
	}

}
