package com.sap.mi.gfw.eclipse.internal.config;

/**
 * A simple interface, which can be implemented by all classes/interfaces which provide access to an IConfigurationProvider.
 */
public interface IConfigurationProviderHolder {

	/**
	 * Returns the IConfigurationProvider. Must not return null.
	 * 
	 * @return The IConfigurationProvider. Must not return null.
	 * 
	 * @throws IllegalStateException
	 *             If no IConfigurationProvider is available (if it is null).
	 */
	IConfigurationProvider getConfigurationProvider() throws IllegalStateException;
}