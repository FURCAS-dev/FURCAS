package com.sap.mi.tools.cockpit.mql.preferences;

import org.eclipse.jface.preference.IPreferenceStore;

import com.sap.mi.tools.cockpit.mql.QueryConsole;

/**
 * @author d003456
 * 
 */
public class MQLPreferencesHelper {

	private static MQLPreferencesHelper instance;

	private final IPreferenceStore prefStore;

	public static final MQLPreferencesHelper getInstance() {

		if (MQLPreferencesHelper.instance == null) {
			MQLPreferencesHelper.instance = new MQLPreferencesHelper();
		}
		return MQLPreferencesHelper.instance;
	}

	private MQLPreferencesHelper() {

		this.prefStore = QueryConsole.getDefault().getPreferenceStore();
	}

	public final String getTeamServerUrl() {

		return this.prefStore.getString(MQLPreferencePage.PREFERENCE_TEAM_SERVER_URL);
	}

	public final void setTeamServerUrl(String newValue) {

		this.prefStore.setValue(MQLPreferencePage.PREFERENCE_TEAM_SERVER_URL, newValue);
	}
}
