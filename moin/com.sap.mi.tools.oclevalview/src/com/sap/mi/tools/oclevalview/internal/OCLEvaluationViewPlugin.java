package com.sap.mi.tools.oclevalview.internal;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class
 * 
 * @author d024127
 */
public class OCLEvaluationViewPlugin extends AbstractUIPlugin {

	private static final IPath PATH_ICONS = new Path("resources/icons"); //$NON-NLS-1$

	private static OCLEvaluationViewPlugin sInstance;

	/**
	 * Create {@link OCLEvaluationViewPlugin}.
	 */
	public OCLEvaluationViewPlugin() {

		OCLEvaluationViewPlugin.sInstance = this;
	}

	@Override
	public void stop(BundleContext context) throws Exception {

		OCLEvaluationViewPlugin.sInstance = null;
		super.stop(context);
	}

	public static OCLEvaluationViewPlugin getDefault() {

		return OCLEvaluationViewPlugin.sInstance;
	}

	public static ImageDescriptor getImageDescriptorFromPlugin(String name) {

		return imageDescriptorFromPlugin(getId(), OCLEvaluationViewPlugin.PATH_ICONS.append(name).toString());
	}

	/**
	 * Returns the plug-in ID.
	 * 
	 * @return return plug-in ID
	 */
	public static String getId() {

		return getDefault().getBundle().getSymbolicName();
	}

}
