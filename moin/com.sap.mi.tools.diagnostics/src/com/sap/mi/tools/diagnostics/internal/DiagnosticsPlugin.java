package com.sap.mi.tools.diagnostics.internal;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The plugin class
 * 
 * @author d031150
 */
public class DiagnosticsPlugin extends AbstractUIPlugin {

    public static final String ID_PLUGIN = "com.sap.mi.tools.diagnostics"; //$NON-NLS-1$
    public static final String ID_VIEW = "com.sap.mi.tools.diagnostics.viewer"; //$NON-NLS-1$
    private static final String PATH_ICONS = "resources/icons/"; //$NON-NLS-1$
    public static final String IMAGE_NAME_REFRESH = "refresh.gif"; //$NON-NLS-1$

    private static DiagnosticsPlugin sInstance;

    public DiagnosticsPlugin() {
        sInstance = this;
    }
    
    @Override
    public void stop(BundleContext context) throws Exception {
        sInstance = null;
        super.stop(context);
    }
    
    public static DiagnosticsPlugin getDefault() {
        return sInstance;
    }

    public static ImageDescriptor getImageDescriptorFromPlugin(String name) {
        return imageDescriptorFromPlugin(ID_PLUGIN, PATH_ICONS + name);
    }

}
