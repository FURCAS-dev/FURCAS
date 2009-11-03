package com.sap.tc.moin.nwdi.dctype.mm.internal.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.dialogs.MessageDialogWithToggle;
import org.eclipse.jface.preference.IPreferenceStore;

import com.sap.tc.moin.nwdi.dctype.mm.internal.MoinMetaModelDCTypePlugin;

public class PreferenceInitializer extends AbstractPreferenceInitializer {

	public static final String CREATE_WRAPPER_PLUGIN_WITH_METAMODEL_DC = "com.sap.tc.moin.nwdi.dctype.mm.create.mm.plugin"; //$NON-NLS-X$
	
	public PreferenceInitializer() {
		super();
	}

	@Override
	public void initializeDefaultPreferences() {
		IPreferenceStore store = MoinMetaModelDCTypePlugin.getDefault().getPreferenceStore();
		store.setDefault(CREATE_WRAPPER_PLUGIN_WITH_METAMODEL_DC, MessageDialogWithToggle.PROMPT);
	}
}
