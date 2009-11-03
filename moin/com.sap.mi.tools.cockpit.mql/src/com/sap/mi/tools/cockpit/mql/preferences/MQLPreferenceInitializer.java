package com.sap.mi.tools.cockpit.mql.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

import com.sap.mi.tools.cockpit.mql.QueryConsole;

/**
 * @author d003456
 * 
 */
public class MQLPreferenceInitializer extends AbstractPreferenceInitializer {

	private final static String TEAM_SERVER_URL_DEFAULT = "http://vemoin03.dhcp.wdf.sap.corp:50000/QueryService/QueryImplBean?wsdl"; //$NON-NLS-1$

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer#initializeDefaultPreferences()
	 */
	@Override
	public void initializeDefaultPreferences() {

		final IPreferenceStore store = QueryConsole.getDefault().getPreferenceStore();
		store.setDefault(MQLPreferencePage.PREFERENCE_TEAM_SERVER_URL, MQLPreferenceInitializer.TEAM_SERVER_URL_DEFAULT);
	}
}
