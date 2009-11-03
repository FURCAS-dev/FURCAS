package com.sap.mi.fwk.services.local.help;

import org.eclipse.core.runtime.Platform;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.PlatformUI;
import org.osgi.framework.Bundle;

/**
 * Accessor for workbench help funtionality. Not intended to be used outside the
 * MiE project.
 * 
 * @author d031150
 */
public final class MiHelp {

	private static final String PLUGIN_ID_DOCU = "com.sap.netweaver.developerstudio.mie.doc.internal"; //$NON-NLS-1$

	/**
	 * Installs the given help context if the documentation plugin is installed
	 * (which currently is not the case in external installations). Must be
	 * called from the UI thread.
	 * 
	 * @param control
	 *            the control to set the help for
	 * @param helpContext
	 *            the help context to install
	 */
	public static void setHelp(Control control, IHelpContext helpContext) {
		Bundle docu = Platform.getBundle(PLUGIN_ID_DOCU);
		if (docu == null)
			return;

		PlatformUI.getWorkbench().getHelpSystem().setHelp(control, helpContext.getId());
	}

}
