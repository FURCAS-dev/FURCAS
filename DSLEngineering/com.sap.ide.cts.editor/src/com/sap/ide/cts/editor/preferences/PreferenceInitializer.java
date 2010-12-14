package com.sap.ide.cts.editor.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.swt.graphics.RGB;

import com.sap.furcas.ide.editor.CtsActivator;


public class PreferenceInitializer extends AbstractPreferenceInitializer {

	public static final String EDITOR_MATCHING_BRACKETS = "matchingBrackets";
	public static final String EDITOR_MATCHING_BRACKETS_COLOR = "matchingBracketsColor"; 


	public PreferenceInitializer() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initializeDefaultPreferences() {
			
		IPreferenceStore store = CtsActivator.getDefault().getPreferenceStore();
		store.setDefault(EDITOR_MATCHING_BRACKETS, true);
		PreferenceConverter.setDefault(store, EDITOR_MATCHING_BRACKETS_COLOR,new RGB(190, 140, 190)); 
		
	
	}

}
