package com.sap.mi.fwk.ui.internal;

import org.eclipse.core.runtime.Platform;

/**
 * Internal Textpool class featuring UI relevant Text constants. The texts
 * itselves are retrieved from the Eclipse plugin.properties fields.
 * 
 * @author d024127
 */
public class TextPool {

	/**
	 * Features an enum entry for each entry in plugin.properties
	 * 
	 * @author d024127
	 * 
	 */
	public enum UIText {

		_editor_save_preference_page_name, 
		_menu_name_modeling {
			@Override
			String getKey() {
				return "menu.name.modeling"; //$NON-NLS-1$
			}
		};
		
		String getKey() {
			return toString();
		}
	}

	/**
	 * "Type-safe" access the resource strings. Returns the text for a key,
	 * which can be found in the <i>plugin.properties</i> file.
	 * 
	 * @param text
	 *            The key, which to find in the resources.
	 * 
	 * @return The text for the key from the <i>plugin.properties</i> file.
	 */
	public static String getString(UIText text) {
		return Platform.getResourceString(MiFwkUIPlugin.getDefault().getBundle(), "%" + text.getKey()); //$NON-NLS-1$
	}

}
