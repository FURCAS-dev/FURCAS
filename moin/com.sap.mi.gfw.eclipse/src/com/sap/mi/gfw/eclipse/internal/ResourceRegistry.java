package com.sap.mi.gfw.eclipse.internal;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.graphics.Resource;

public class ResourceRegistry implements IResourceRegistry {
	private Map<Object, Resource> registry = new HashMap<Object, Resource>();

	public Color getSwtColor(int red, int green, int blue) {
		RGB rgb = new RGB(red, green, blue);
		Resource ret = registry.get(rgb);
		if (ret == null) {
			ret = new Color(null, rgb);
			registry.put(rgb, ret);
			ResourceManager.getResourceManager().manageResource(this, ret);
		}

		Color retColor = null;
		if (ret instanceof Color) {
			retColor = (Color) ret;
		}
		return retColor;
	}

	public void dispose() {
		ResourceManager.getResourceManager().cleanUpResources(this);
		registry.clear();
	}
}
