package com.sap.mi.tools.mmdeploy.internal;

import com.sap.mi.fwk.services.local.help.IHelpContext;
import com.sap.mi.fwk.services.local.help.MiHelp;

/**
 * Context help ids for <code>com.sap.mi.fwk.ui</code>. Make sure the ids
 * match to what is specified in the docu plugin.
 * 
 * @author d031150
 * 
 * @see MiHelp
 */
public enum MmDeploymentHelpContext implements IHelpContext {

	/**
	 * The "Assign Elements" dialog
	 */
	DeploymentView("deploymentView"); //$NON-NLS-1$

	private final String id;

	private MmDeploymentHelpContext(String id) {
		this.id = MmDeploymentPlugin.ID_PLUGIN + "." + id; //$NON-NLS-1$
	}

	public String getId() {
		return this.id;
	}

}
