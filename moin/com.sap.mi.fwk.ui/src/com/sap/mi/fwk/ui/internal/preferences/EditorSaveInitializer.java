package com.sap.mi.fwk.ui.internal.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

import com.sap.mi.fwk.ui.internal.MiFwkUIPlugin;

public class EditorSaveInitializer extends AbstractPreferenceInitializer {

	@Override
	public void initializeDefaultPreferences() {
		IPreferenceStore store = MiFwkUIPlugin.getDefault()
				.getPreferenceStore();
		store.setDefault(EditorSaveConstants.SHOW_EDITOR_SAVE_DIALOG, true);
	}

}
