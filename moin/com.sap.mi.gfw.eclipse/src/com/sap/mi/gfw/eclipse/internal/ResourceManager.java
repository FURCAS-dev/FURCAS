package com.sap.mi.gfw.eclipse.internal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.swt.graphics.Resource;

public class ResourceManager implements IResourceManager {
	private static IResourceManager singleton;

	private HashMap<Object, List<Resource>> map = new HashMap<Object, List<Resource>>();

	public static IResourceManager getResourceManager() {
		if (singleton == null) {
			singleton = new ResourceManager();
		}

		return singleton;
	}

	public void cleanUpResources(Object obj) {

		if (obj == null) {
			return;
		}
		List<Resource> list = map.get(obj);
		if (list != null) {
			for (Resource resource : list) {
				if (resource != null && !resource.isDisposed()) {
					resource.dispose();
				}
			}
			list.clear();
		}
		map.remove(obj);
	}

	public void manageResource(Object obj, Resource resource) {
		if (obj == null || resource == null) {
			return;
		}
		List<Resource> list = map.get(obj);
		if (list == null) {
			list = new ArrayList<Resource>();
			map.put(obj, list);
		}
		list.add(resource);
	}
}
