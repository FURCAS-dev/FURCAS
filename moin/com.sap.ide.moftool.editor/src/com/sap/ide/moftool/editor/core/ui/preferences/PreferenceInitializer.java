package com.sap.ide.moftool.editor.core.ui.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

import com.sap.ide.moftool.editor.plugin.MOFToolEditorPlugin;

/**
 * Class used to initialize default preference values.
 */
public class PreferenceInitializer extends AbstractPreferenceInitializer {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer#initializeDefaultPreferences()
	 */
	public void initializeDefaultPreferences() {
		IPreferenceStore store = MOFToolEditorPlugin.getDefault().getPreferenceStore();
		store.setDefault(PreferenceConstants.NAME_REFERENCE_CREATION, PreferenceConstants.VALUE_REFERENCE_CREATION_AUTO);
		store.setDefault(PreferenceConstants.NAME_OCL_AUTO_ACTIVATION, PreferenceConstants.VALUE_OCL_AUTO_ACTIVATION_ON);
	}
}
