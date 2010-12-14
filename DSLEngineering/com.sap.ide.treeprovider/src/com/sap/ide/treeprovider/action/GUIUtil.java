package com.sap.ide.treeprovider.action;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import com.sap.ide.treeprovider.RootNodeProvider;

public class GUIUtil {

    /**
     * Prompts the user (popup) for input (one text box).
     * 
     * @param title
     *            Dialog title
     * @param message
     *            Dialog message
     * @param text
     *            Default value
     * @return The value entered by the user
     */
    public static String enterText(String title, String message, String text) {
	Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
	InputDialog inputDialog = new InputDialog(shell, title, message, text, null);
	int retDialog = inputDialog.open();
	if (retDialog == Window.OK) {
	    return inputDialog.getValue();
	}
	return null;
    }

    /**
     * Creates an {@link IPath} that identifies a newly, unique partition name.
     * FIXME: This is an evil hack until MOIN RIFactories expose the construction guideline for PRIs
     * @param name
     * @param project
     * @return
     */
    public static IPath createPartitionPath(final String name, ResourceSet connection, EClass parentOfCompositionClazz) {
	String ts = Long.toHexString(System.currentTimeMillis());
	String folder = "src";
	String extension = "types";

	IExtensionPoint eventListenerPoint = Platform.getExtensionRegistry().getExtensionPoint(
		"com.sap.ide.treeprovider.rootNodeDefinition");
	for (IConfigurationElement e : eventListenerPoint.getConfigurationElements()) {
	    if (e.getName().equals("rootNodeProvider")) {
		RootNodeProvider provider;
		try {
		    provider = (RootNodeProvider) e.createExecutableExtension("classname");
		    if (provider.getTopLevelModelElementTypes(connection).contains(parentOfCompositionClazz)) {
			folder = provider.getPartionFolderName();
			extension = provider.getPartitionExtension();
			break;
		    }
		} catch (CoreException ex) {
		    throw new RuntimeException(ex);
		}
	    }
	}
	return Path.fromPortableString(folder).addTrailingSeparator().append(name + ts).addFileExtension(extension);
    }
}
