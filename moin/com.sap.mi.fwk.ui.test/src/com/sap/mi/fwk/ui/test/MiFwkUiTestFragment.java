package com.sap.mi.fwk.ui.test;

import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.osgi.framework.Bundle;

import com.sap.mi.fwk.ui.internal.MiFwkUIPlugin;

/**
 * Utilities for the whole test fragment similar to a plugin class. But is
 * explicitly <b>not a real plugin class</b> since fragments merge with their
 * hosts at runtime.
 * 
 * @author d031150
 */
public final class MiFwkUiTestFragment {

	public static final String PLUGIN_ID = MiFwkUIPlugin.PLUGIN_ID;

	static {
		ImageRegistry registry = MiFwkUIPlugin.getDefault().getImageRegistry();
		String[] names = { "Button", "InputField", "View", "ViewContainerUIElement", "Label", "Table", "Group",
				"TransparentContainer" };
		Bundle host = MiFwkUIPlugin.getDefault().getBundle();

		final IPath basePath = new Path("resources");
		for (String name : names) {
			IPath path = basePath.append(name).addFileExtension("gif");
			URL url = FileLocator.find(host, path, null);
			registry.put(name, ImageDescriptor.createFromURL(url));
		}
	}

	public static ImageRegistry getImageRegistry() {
		return MiFwkUIPlugin.getDefault().getImageRegistry();
	}

	public static Bundle getBundle() {
		return MiFwkUIPlugin.getDefault().getBundle();
	}

}
