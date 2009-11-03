package com.sap.tc.moin.versioning.di.impl.preferences;

import org.eclipse.jface.preference.IPreferenceStore;

import com.sap.tc.moin.versioning.di.impl.Activator;

public class PreferenceHelper {
	private IPreferenceStore mPreferenceStore;
	private static PreferenceHelper sInstance = null;

	public static PreferenceHelper getInstance() {
		if (sInstance == null)
			sInstance = new PreferenceHelper();
		return sInstance;
	}

	private PreferenceHelper() {
		mPreferenceStore = Activator.getDefault().getPreferenceStore();
	}

	public boolean getShowPrepareDialog() {
		boolean result = mPreferenceStore.getBoolean(PreferenceConstants.SHOW_PREPARE_DIALOG);
		return result;
	}

	public void setShowPrepareDialog(boolean newValue) {
		mPreferenceStore.setValue(PreferenceConstants.SHOW_PREPARE_DIALOG, newValue);
	}
}
