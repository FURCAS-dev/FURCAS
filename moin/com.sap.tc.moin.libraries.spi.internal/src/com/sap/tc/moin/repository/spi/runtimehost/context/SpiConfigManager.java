package com.sap.tc.moin.repository.spi.runtimehost.context;

/**
 * MOIN Configuration Manager interface.
 * 
 * @author d029324
 *
 */
public interface SpiConfigManager {

	
	/**
	 * Register MOIN configuration listener.
	 */
	public void register(SpiConfigListener configListener);
}
