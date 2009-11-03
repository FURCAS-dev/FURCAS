package com.sap.mi.gfw.eclipse;

import java.net.URL;

import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.gef.ui.palette.FlyoutPaletteComposite;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import com.sap.mi.gfw.eclipse.internal.editor.DiagramEditor;
import com.sap.mi.gfw.eclipse.internal.platform.GFWExtensionManagerEclipse;
import com.sap.mi.gfw.eclipse.internal.platform.IGFWExtensionManagerEclipse;
import com.sap.mi.gfw.eclipse.internal.platform.PlatformServiceImpl;
import com.sap.mi.gfw.internal.platform.IPlatformRegistry;
import com.sap.mi.gfw.internal.platform.PlatformRegistry;
import com.sap.mi.gfw.platform.IPlatformService;

/**
 * The main-class of the plugin. It is mostly used to acces the 'environment' of this plugin.
 */
public class GraphicsPlugin extends AbstractUIPlugin {

	/**
	 * The Constant DIAGRAM_EDITOR_ID.
	 */
	public static final String DIAGRAM_EDITOR_ID = "com.sap.mi.gfw.eclipse.internal.editor.DiagramEditor"; //$NON-NLS-1$

	private static GraphicsPlugin _plugin;

	/**
	 * Creates the Plugin and caches its default instance.
	 */
	public GraphicsPlugin() {
		_plugin = this;

		IPlatformService platformService = PlatformServiceImpl.getSingleton();
		IGFWExtensionManagerEclipse extensionManager = GFWExtensionManagerEclipse.getSingleton();

		IPlatformRegistry platformRegistry = PlatformRegistry.getInstance();
		platformRegistry.setPlatform(platformService, extensionManager);
	}

	// ============ overwritten methods of AbstractUIPlugin ====================

	/**
	 * This method is called upon plug-in activation.
	 * 
	 * @param context
	 *            the context
	 * @throws Exception
	 *             the exception
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
	}

	/**
	 * This method is called when the plug-in is stopped.
	 * 
	 * @param context
	 *            the context
	 * @throws Exception
	 *             the exception
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		super.stop(context);
	}

	// ======================== static access methods ==========================

	/**
	 * Gets the default-instance of this plugin. Actually the default-instance should always be the only instance -> Singleton.
	 * 
	 * @return the default
	 */
	public static GraphicsPlugin getDefault() {
		return _plugin;
	}

	// =========================== public helper methods ======================

	/**
	 * Returns the current Workspace.
	 * 
	 * @return The current Workspace.
	 */
	public static IWorkspace getWorkspace() {
		return ResourcesPlugin.getWorkspace();
	}

	/**
	 * Returns the URL, which points to where this Plugin is installed.
	 * 
	 * @return The URL, which points to where this Plugin is installed.
	 */
	public static URL getInstallURL() {
		return getDefault().getBundle().getEntry("/"); //$NON-NLS-1$
	}

	/**
	 * Returns the Plugin-ID.
	 * 
	 * @return The Plugin-ID.
	 */
	public static String getID() {
		return getDefault().getBundle().getSymbolicName();
	}

	/**
	 * Returns the currently active WorkbenchPage.
	 * 
	 * @return The currently active WorkbenchPage.
	 */
	public static IWorkbenchPage getActivePage() {
		IWorkbenchWindow workbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		if (workbenchWindow != null)
			return workbenchWindow.getActivePage();
		return null;
	}

	/**
	 * Returns the currently active Shell.
	 * 
	 * @return The currently active Shell.
	 */
	public static Shell getShell() {
		return getDefault().getWorkbench().getActiveWorkbenchWindow().getShell();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#getPreferenceStore()
	 */
	@Override
	public IPreferenceStore getPreferenceStore() {
		IPreferenceStore ps = super.getPreferenceStore();
		ps.setDefault(DiagramEditor.PALETTE_STATE, FlyoutPaletteComposite.STATE_PINNED_OPEN);
		return ps;
	}
}