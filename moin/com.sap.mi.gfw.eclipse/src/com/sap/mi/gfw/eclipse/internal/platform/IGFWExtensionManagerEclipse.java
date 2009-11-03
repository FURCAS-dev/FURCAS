package com.sap.mi.gfw.eclipse.internal.platform;

import com.sap.mi.gfw.eclipse.platform.IImageProvider;
import com.sap.mi.gfw.platform.IGFWExtensionManager;

public interface IGFWExtensionManagerEclipse extends IGFWExtensionManager {

	IImageProvider[] getImageProviders();
}
