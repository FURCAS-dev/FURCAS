package com.sap.tc.moin.repository.runtimehost.ide;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

/**
 * The MOIN IDE preference page initializer which is used to initialize default
 * preference values.
 * 
 * @author d029324
 */
public class MoinPreferenceInitializer extends AbstractPreferenceInitializer {

    /**
     * This method is called by the preference initializer to initialize default
     * preference values. Clients should get the correct node for their bundle
     * and then set the default values on it. For example:
     */
    public void initializeDefaultPreferences( ) {

        IPreferenceStore result = IdeRuntimeHostImpl.getDefault( ).getPreferenceStore( );

        //result.setDefault( MoinPreferencePage.PREFERENCE_DATABASE_TYPE, MoinPreferencePage.DEFAULT_DATABASE_TYPE );

        //result.setDefault( MoinPreferencePage.PREFERENCE_DATABASE_SERVER, MoinPreferencePage.DEFAULT_DATABASE_SERVER );
        //result.setDefault( MoinPreferencePage.PREFERENCE_DATABASE_PORT, MoinPreferencePage.DEFAULT_DATABASE_PORT );
        //result.setDefault( MoinPreferencePage.PREFERENCE_DATABASE_NAME, MoinPreferencePage.DEFAULT_DATABASE_NAME );

        //result.setDefault( MoinPreferencePage.PREFERENCE_DATABASE_USER, MoinPreferencePage.DEFAULT_DATABASE_USER );
        //result.setDefault( MoinPreferencePage.PREFERENCE_DATABASE_PASSWORD, MoinPreferencePage.DEFAULT_DATABASE_PASSWORD );
    }

}
