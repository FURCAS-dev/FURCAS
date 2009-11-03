/**
 * 
 */
package com.sap.mi.gfw.platform;

/**
 * The Class AbstractGFWExtension.
 */
public abstract class AbstractGFWExtension implements IGFWExtension {

	private String providerId;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.platform.IGFWExtension#getProviderId()
	 */
	final public String getProviderId() {
		return providerId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.platform.IGFWExtension#setProviderId(java.lang.String)
	 */
	final public void setProviderId(String providerId) {
		this.providerId = providerId;
	}

}
