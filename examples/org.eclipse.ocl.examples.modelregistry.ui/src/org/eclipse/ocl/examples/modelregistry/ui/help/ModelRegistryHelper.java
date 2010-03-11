package org.eclipse.ocl.examples.modelregistry.ui.help;

import org.eclipse.ocl.examples.modelregistry.ui.ModelRegistryUIPlugin;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.PlatformUI;

public class ModelRegistryHelper
{
	public static void setHelp(Control control, Enum<?> contextId) {
		String helpId = ModelRegistryUIPlugin.PLUGIN_ID + '.' + contextId.getDeclaringClass().getSimpleName() + '_'  + contextId.name();
		PlatformUI.getWorkbench().getHelpSystem().setHelp(control, helpId);
	}
}
