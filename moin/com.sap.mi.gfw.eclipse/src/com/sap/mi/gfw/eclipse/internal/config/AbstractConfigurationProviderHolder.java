package com.sap.mi.gfw.eclipse.internal.config;

/**
 * A simple implementation of the interface IConfigurationProviderHolder.
 */
public abstract class AbstractConfigurationProviderHolder implements IConfigurationProviderHolder {

	private IConfigurationProvider _configurationProvider;

	/**
	 * Creates a new SimpleConfigurationProviderHolder.
	 * 
	 * @param configurationProvider
	 *            the configuration provider
	 */
	public AbstractConfigurationProviderHolder(IConfigurationProvider configurationProvider) {
		if (configurationProvider == null)
			throw new RuntimeException("Implementation-error: the IConfigurationProvider must not be null."); //$NON-NLS-1$

		_configurationProvider = configurationProvider;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.ide.eclipse.gf.config.provider.IConfigurationProviderHolder#getConfigurationProvider()
	 */
	public IConfigurationProvider getConfigurationProvider() {
		return _configurationProvider;
	}
}