package com.sap.mi.fwk.ui.internal.help;

import com.sap.mi.fwk.services.local.help.IHelpContext;
import com.sap.mi.fwk.services.local.help.MiHelp;
import com.sap.mi.fwk.ui.internal.MiFwkUIPlugin;

/**
 * Context help ids for <code>com.sap.mi.fwk.ui</code>. Make sure the ids
 * match to what is specified in the docu plugin.
 * 
 * @author d031150
 * 
 * @see MiHelp
 */
public enum MiFwkUiHelpContext implements IHelpContext {

	/**
	 * The "Assign Elements" dialog
	 */
	AssignElementsDialog("assignElementsDialog"); //$NON-NLS-1$

	private final String id;

	private MiFwkUiHelpContext(String id) {
		this.id = MiFwkUIPlugin.PLUGIN_ID + "." + id; //$NON-NLS-1$
	}

	public String getId() {
		return this.id;
	}

}
