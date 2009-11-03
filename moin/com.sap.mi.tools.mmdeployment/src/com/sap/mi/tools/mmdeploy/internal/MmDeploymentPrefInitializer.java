package com.sap.mi.tools.mmdeploy.internal;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

/**
 * Initializes preferences for the deployent view
 * 
 * @author d031150
 */
public class MmDeploymentPrefInitializer extends AbstractPreferenceInitializer {

	public MmDeploymentPrefInitializer() {
	}

	@Override
	public void initializeDefaultPreferences() {
		IPreferenceStore preferenceStore = MmDeploymentPlugin.getDefault().getPreferenceStore();
		
		preferenceStore.setDefault(MmDeploymentPlugin.PREF_KEY_SHOW_WORKING_SETS, false);
		preferenceStore.setDefault(MmDeploymentPlugin.PREF_KEY_SHOW_IMPORT_INFO, true);
	}

}
