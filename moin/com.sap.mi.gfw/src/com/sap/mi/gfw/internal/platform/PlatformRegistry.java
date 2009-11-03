package com.sap.mi.gfw.internal.platform;

import com.sap.mi.gfw.platform.IGFWExtensionManager;
import com.sap.mi.gfw.platform.IPlatformService;

/**
 * The Class PlatformRegistry.
 */
public class PlatformRegistry implements IPlatformRegistry {

	private static IPlatformRegistry platformRegistry;
	private IPlatformService platformService;
	private IGFWExtensionManager extensionManager;

	private PlatformRegistry() {
	}

	/**
	 * Gets the single instance of PlatformRegistry.
	 * 
	 * @return single instance of PlatformRegistry
	 */
	public static IPlatformRegistry getInstance() {
		if (platformRegistry == null) {
			platformRegistry = new PlatformRegistry();
		}
		return platformRegistry;
	}

	/**
	 * Register platform.
	 * 
	 * @param extensionManager
	 *            the extension manager
	 * @param platformID
	 *            the platform id
	 * @param platformService
	 *            the platform service
	 */
	public void setPlatform(IPlatformService platformService, IGFWExtensionManager extensionManager) {
		this.platformService = platformService;
		this.extensionManager = extensionManager;
	}

	/**
	 * Gets the platform service.
	 * 
	 * @return Returns the platformService.
	 */
	public IPlatformService getPlatformService() {
		return platformService;
	}

	/**
	 * Gets the gfw extension manager.
	 * 
	 * @return the platform-specific extension-manager
	 */
	public IGFWExtensionManager getGFWExtensionManager() {
		return extensionManager;
	}
}