package com.sap.furcas.ide.editor;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import com.sap.furcas.utils.exceptions.StatusLogger;

/**
 * The activator class controls the plug-in life cycle
 */
public class CtsActivator extends AbstractUIPlugin {

    public static final String PLUGIN_ID = "com.sap.furcas.ide.editor";
    private static CtsActivator plugin;
    public static StatusLogger logger;

    /**
     * The constructor.
     */
    public CtsActivator() {
    }

    /*
     * (non-Javadoc)
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
     */
    @Override
    public void start(BundleContext context) throws Exception {
        super.start(context);
        plugin = this;
        logger = new StatusLogger(this, PLUGIN_ID);
    }

    /*
     * (non-Javadoc)
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
     */
    @Override
    public void stop(BundleContext context) throws Exception {
        plugin = null;
        super.stop(context);

    }

    /**
     * Returns the shared instance.
     *
     * @return the shared instance
     */
    public static CtsActivator getDefault() {
        return plugin;
    }

    /**
     * Returns an image descriptor for the image file at the given
     * plug-in relative path.
     *
     * @param path the path
     *
     * @return the image descriptor
     */
    public static ImageDescriptor getImageDescriptor(String path) {
        return imageDescriptorFromPlugin(PLUGIN_ID, path);
    }

}
