package com.sap.mi.gfw.eclipse.internal;

import org.eclipse.swt.graphics.Resource;

public interface IResourceManager {
	void manageResource(Object obj, Resource resource);

	void cleanUpResources(Object obj);
}
