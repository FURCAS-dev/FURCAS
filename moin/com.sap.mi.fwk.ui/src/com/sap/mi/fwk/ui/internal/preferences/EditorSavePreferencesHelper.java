package com.sap.mi.fwk.ui.internal.preferences;

import org.eclipse.jface.preference.IPreferenceStore;

import com.sap.mi.fwk.ui.internal.MiFwkUIPlugin;

public class EditorSavePreferencesHelper {

	private static EditorSavePreferencesHelper instance;
	private IPreferenceStore prefStore;

	public static final EditorSavePreferencesHelper getInstance() {
		if (instance == null) {
			instance = new EditorSavePreferencesHelper();
		}
		return instance;
	}

	private EditorSavePreferencesHelper() {
		prefStore = MiFwkUIPlugin.getDefault().getPreferenceStore();
	}

	public final boolean getEditorSaveState() {
		return prefStore
				.getBoolean(EditorSaveConstants.SHOW_EDITOR_SAVE_DIALOG);
	}

	public final void setEditorSaveState(boolean newValue) {
		prefStore.setValue(EditorSaveConstants.SHOW_EDITOR_SAVE_DIALOG,
				newValue);
	}

}
