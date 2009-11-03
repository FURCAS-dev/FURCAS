/**
 * 
 */
package com.sap.mi.gfw.internal.platform;

import com.sap.mi.gfw.platform.IGFWExtensionManager;
import com.sap.mi.gfw.platform.IPlatformService;

/**
 * The Interface IPlatformRegistry.
 */
public interface IPlatformRegistry {

	/**
	 * Set the platform.
	 * 
	 * @param extensionManager
	 *            the extension manager
	 * @param platformService
	 *            the platform service
	 */
	void setPlatform(IPlatformService platformService, IGFWExtensionManager extensionManager);

	/**
	 * Gets the platform service.
	 * 
	 * @return Returns the platformService.
	 */
	IPlatformService getPlatformService();

	/**
	 * Gets the gfw extension manager.
	 * 
	 * @return the platform-specific extension-manager
	 */
	IGFWExtensionManager getGFWExtensionManager();
}
