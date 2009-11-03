package com.sap.tc.moin.repository.spi.runtimehost.context;

import java.util.Properties;

/**
 * MOIN configuration listener.
 * 
 * @author d029324
 */
public interface SpiConfigListener {

	/**
	 * Property update.
	 * 
	 * @param properties
	 */
	public void update(Properties properties);
}
