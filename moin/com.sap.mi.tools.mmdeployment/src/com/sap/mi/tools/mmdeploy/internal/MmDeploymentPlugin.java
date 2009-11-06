package com.sap.mi.tools.mmdeploy.internal;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class for the deployment plugin
 * 
 * @author d031150
 */
public class MmDeploymentPlugin extends AbstractUIPlugin {

	public static final String ID_PLUGIN = "com.sap.mi.tools.mmdeployment"; //$NON-NLS-1$

	private static final String ID_UI_PLUGIN = "com.sap.mi.fwk.ui"; //$NON-NLS-1$

	static final String PREF_KEY_SHOW_WORKING_SETS = "showWorkingSets"; //$NON-NLS-1$
	static final String PREF_KEY_SHOW_IMPORT_INFO = "showImportInfo"; //$NON-NLS-1$

	private static final String PATH_ICONS_UI_PLUGIN = "resources/"; //$NON-NLS-1$

	/*public static final IImageKey IMAGE_NAME_WORKING_SET = SapUI.getImageServices().registerImage(ID_UI_PLUGIN,
			PATH_ICONS_UI_PLUGIN + "metamodelWorkingSet.gif", //$NON-NLS-1$
			AccessibilityUtil.createAccessibleInfo(MmDeploymentMessages.plugin_imageAcc_workingSet));
*/
	private static MmDeploymentPlugin sPlugin;

	public MmDeploymentPlugin() {
		sPlugin = this;
	}

	public void stop(BundleContext context) throws Exception {
		super.stop(context);
		sPlugin = null;
	}

	/**
	 * Returns the shared instance.
	 */
	public static MmDeploymentPlugin getDefault() {
		return sPlugin;
	}

	public static void setPrefShowWorkingSets(boolean show) {
		getDefault().getPreferenceStore().setValue(PREF_KEY_SHOW_WORKING_SETS, show);
	}

	public static boolean getPrefShowWorkingSets() {
		boolean show = getDefault().getPreferenceStore().getBoolean(PREF_KEY_SHOW_WORKING_SETS);
		return show;
	}

//	public static Image getSharedImage(ISapImage key, Control parent) {
//		IImageKey imgKey = SapImageConverter.convert(key);
//		IImagePool pool = SapUI.getImageServices().getLocalImagePool(parent);
//		return pool.getImage(imgKey);
//	}
//
//	public static Image getSharedImage(IImageKey imgKey) {
//		IImagePool pool = SapUI.getImageServices().getGlobalImagePool();
//		return pool.getImage(imgKey);
//	}

}
