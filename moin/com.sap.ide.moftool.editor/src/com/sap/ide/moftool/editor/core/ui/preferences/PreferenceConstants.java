package com.sap.ide.moftool.editor.core.ui.preferences;

import org.eclipse.jface.preference.IPreferenceStore;

import com.sap.ide.moftool.editor.plugin.MOFToolEditorPlugin;

/**
 * Constant definitions for plug-in preferences
 */
public class PreferenceConstants {

	public static final String NAME_REFERENCE_CREATION = "referenceCreation"; //$NON-NLS-1$
	public static final String VALUE_REFERENCE_CREATION_AUTO = "auto"; //$NON-NLS-1$
	public static final String VALUE_REFERENCE_CREATION_ASK = "ask"; //$NON-NLS-1$
	public static final String VALUE_REFERENCE_CREATION_NEVER = "never"; //$NON-NLS-1$
	
	public static final String NAME_OCL_AUTO_ACTIVATION = "oclAutoActivation"; //$NON-NLS-1$
	public static final boolean VALUE_OCL_AUTO_ACTIVATION_ON = true;
	public static final boolean VALUE_OCL_AUTO_ACTIVATION_OFF = false;
	
	public static final String getReferenceCreationSetting() {
		IPreferenceStore store = MOFToolEditorPlugin.getDefault().getPreferenceStore();
		return store.getString(NAME_REFERENCE_CREATION);
	}

	public static final boolean getOclAutoActivationSetting() {
		IPreferenceStore store = MOFToolEditorPlugin.getDefault().getPreferenceStore();
		return store.getBoolean(NAME_OCL_AUTO_ACTIVATION);
	}
}
