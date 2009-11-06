package com.sap.mi.tools.cockpit.editor;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import com.sap.mi.fwk.internal.tracing.MiLocations;

/**
 * The MOINBrowser class controls the plug-in life cycle
 */
public final class MOINBrowser extends AbstractUIPlugin {

	// The shared instance
	private static MOINBrowser plugin;

	private static final Logger tracer = Logger.getLogger(MiLocations.MI_MODELBROWSER);

	public static final String METAMODEL_IMAGE = "METAMODEL_IMAGE"; //$NON-NLS-1$

	public static final String ROOT_IMAGE = "ROOT_IMAGE"; //$NON-NLS-1$

	public static final String AGGREGATION_IMAGE = "AGGREGATION_IMAGE"; //$NON-NLS-1$

	public static final String ZERO_TO_ONE_COMPOSITION_IMAGE = "ZERO_TO_ONE_COMPOSITION_IMAGE"; //$NON-NLS-1$

	public static final String ZERO_TO_UNBOUND_COMPOSITION_IMAGE = "ZERO_TO_UNBOUND_COMPOSITION_IMAGE"; //$NON-NLS-1$

	public static final String ASSOCIATION_IMAGE = "ASSOCIATION_IMAGE"; //$NON-NLS-1$

	public static final String ZERO_TO_ONE_ASSOCIATION_IMAGE = "ZERO_TO_ONE_ASSOCIATION_IMAGE"; //$NON-NLS-1$

	public static final String ZERO_TO_UNBOUND_ASSOCIATION_IMAGE = "ZERO_TO_UNBOUND_ASSOCIATION_IMAGE"; //$NON-NLS-1$

	public static final String ATTRIBUTE_IMAGE = "ATTRIBUTE_IMAGE"; //$NON-NLS-1$

	public static final String ZERO_TO_UNBOUND_ATTRIBUTE_IMAGE = "ZERO_TO_UNBOUND_ATTRIBUTE_IMAGE"; //$NON-NLS-1$

	public static final String OBJECT_IMAGE = "OBJECT_IMAGE"; //$NON-NLS-1$

	public static final String LITERAL_IMAGE = "LITERAL_IMAGE"; //$NON-NLS-1$

	public static final String REFRESH_IMAGE = "REFRESH_IMAGE"; //$NON-NLS-1$

	public static final String FLAT_CONTAINER_PRESENTATION_IMAGE = "FLAT_CONTAINER_PRESENTATION_IMAGE"; //$NON-NLS-1$

	public static final String HIERARCHICAL_CONTAINER_PRESENTATION_IMAGE = "HIERARCHICAL_CONTAINER_PRESENTATION_IMAGE"; //$NON-NLS-1$

	public static final String CONTAINER_IMAGE = "CONTAINER_IMAGE"; //$NON-NLS-1$

	public static final String CONTAINER_PATH_IMAGE = "CONTAINER_PATH_IMAGE"; //$NON-NLS-1$

	public static final String PACKAGE_IMAGE = "PACKAGE_IMAGE"; //$NON-NLS-1$

	public static final String SHOW_LEGEND_IMAGE = "SHOW_LEGEND_IMAGE"; //$NON-NLS-1$

	public static final String COLLAPSE_ALL_IMAGE = "COLLAPSE_ALL_IMAGE"; //$NON-NLS-1$

	public static final String MOVE_UP_IMAGE = "MOVE_UP_IMAGE"; //$NON-NLS-1$

	public static final String TYPE_IMAGE = "TYPE_IMAGE"; //$NON-NLS-1$

	public static final String ENUMERATION_TYPE_IMAGE = "ENUMERATION_TYPE_IMAGE"; //$NON-NLS-1$

	public static final String STRUCTURE_TYPE_IMAGE = "STRUCTURE_TYPE_IMAGE"; //$NON-NLS-1$

	public static final String ALIAS_TYPE_IMAGE = "ALIAS_TYPE_IMAGE"; //$NON-NLS-1$

	public static final String LOADING_IMAGE = "LOADING_IMAGE"; //$NON-NLS-1$
	
	public static final String OPEN_TYPE_IMAGE = "OPEN_TYPE_IMAGE"; //$NON-NLS-1$
	
	public static final String TYPES_IMAGE = "TYPES_IMAGE"; //$NON-NLS-1$
	
	public static final String UNKNOWN_OBJECT_IMAGE = "UNKNOWN_OBJECT_IMAGE"; //$NON-NLS-1$

	/**
	 * Creates {@link MOINBrowser}.
	 */
	public MOINBrowser() {

		MOINBrowser.plugin = this;
	}

	public static String getId() {

		return getDefault().getBundle().getSymbolicName();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public void start(BundleContext context) throws Exception {

		super.start(context);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(BundleContext context) throws Exception {

		MOINBrowser.plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static MOINBrowser getDefault() {

		return MOINBrowser.plugin;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#initializeImageRegistry(org.eclipse.jface.resource.ImageRegistry) Any problems which
	 * arise are silently ignored.
	 */
	@Override
	protected void initializeImageRegistry(ImageRegistry reg) {

		super.initializeImageRegistry(reg);
		URL lInstallURL = null;

		try {
			lInstallURL = FileLocator.resolve(getDefault().getBundle().getEntry("/")); //$NON-NLS-1$
		}
		catch (final IOException e) {
			// spec'ed to ignore problems
			MOINBrowser.tracer.log(Level.SEVERE, e.getMessage(), e);
			return;
		}

		try {
			reg.put(MOINBrowser.TYPE_IMAGE, ImageDescriptor.createFromURL(new URL(lInstallURL, "resources/icons/type.gif"))); //$NON-NLS-1$
			reg.put(MOINBrowser.METAMODEL_IMAGE, ImageDescriptor.createFromURL(new URL(lInstallURL, "resources/icons/metamodel.gif"))); //$NON-NLS-1$
			reg.put(MOINBrowser.ENUMERATION_TYPE_IMAGE, ImageDescriptor.createFromURL(new URL(lInstallURL,
					"resources/icons/enumeration_type.gif"))); //$NON-NLS-1$
			reg.put(MOINBrowser.STRUCTURE_TYPE_IMAGE, ImageDescriptor.createFromURL(new URL(lInstallURL,
					"resources/icons/structure_type.gif"))); //$NON-NLS-1$
			reg.put(MOINBrowser.ZERO_TO_ONE_COMPOSITION_IMAGE, ImageDescriptor.createFromURL(new URL(lInstallURL,
					"resources/icons/zerotoonecomposition.gif"))); //$NON-NLS-1$
			reg.put(MOINBrowser.ZERO_TO_UNBOUND_COMPOSITION_IMAGE, ImageDescriptor.createFromURL(new URL(lInstallURL,
					"resources/icons/zerotounboundcomposition.gif"))); //$NON-NLS-1$
			reg.put(MOINBrowser.ZERO_TO_ONE_ASSOCIATION_IMAGE, ImageDescriptor.createFromURL(new URL(lInstallURL,
					"resources/icons/zerotooneassociation.gif"))); //$NON-NLS-1$
			reg.put(MOINBrowser.ZERO_TO_UNBOUND_ASSOCIATION_IMAGE, ImageDescriptor.createFromURL(new URL(lInstallURL,
					"resources/icons/zerotounboundassociation.gif"))); //$NON-NLS-1$
			reg.put(MOINBrowser.ATTRIBUTE_IMAGE, ImageDescriptor.createFromURL(new URL(lInstallURL, "resources/icons/attribute.gif"))); //$NON-NLS-1$
			reg.put(MOINBrowser.ZERO_TO_UNBOUND_ATTRIBUTE_IMAGE, ImageDescriptor.createFromURL(new URL(lInstallURL,
					"resources/icons/zerotounboundattribute.gif"))); //$NON-NLS-1$
			reg.put(MOINBrowser.OBJECT_IMAGE, ImageDescriptor.createFromURL(new URL(lInstallURL, "resources/icons/object.gif"))); //$NON-NLS-1$
			reg.put(MOINBrowser.MOVE_UP_IMAGE, ImageDescriptor.createFromURL(new URL(lInstallURL, "resources/icons/moveUp.gif"))); //$NON-NLS-1$
			reg.put(MOINBrowser.LITERAL_IMAGE, ImageDescriptor.createFromURL(new URL(lInstallURL, "resources/icons/literal.gif"))); //$NON-NLS-1$
			reg.put(MOINBrowser.REFRESH_IMAGE, ImageDescriptor.createFromURL(new URL(lInstallURL, "resources/icons/refresh.gif"))); //$NON-NLS-1$
			reg.put(MOINBrowser.FLAT_CONTAINER_PRESENTATION_IMAGE, ImageDescriptor.createFromURL(new URL(lInstallURL,
					"resources/icons/flatcontainerpresentation.gif"))); //$NON-NLS-1$
			reg.put(MOINBrowser.HIERARCHICAL_CONTAINER_PRESENTATION_IMAGE, ImageDescriptor.createFromURL(new URL(lInstallURL,
					"resources/icons/hierarchicalcontainerpresentation.gif"))); //$NON-NLS-1$
			reg.put(MOINBrowser.CONTAINER_IMAGE, ImageDescriptor.createFromURL(new URL(lInstallURL, "resources/icons/container.gif"))); //$NON-NLS-1$
			reg.put(MOINBrowser.CONTAINER_PATH_IMAGE, ImageDescriptor.createFromURL(new URL(lInstallURL,
					"resources/icons/containerpath.gif"))); //$NON-NLS-1$
			reg.put(MOINBrowser.PACKAGE_IMAGE, ImageDescriptor.createFromURL(new URL(lInstallURL, "resources/icons/package.gif"))); //$NON-NLS-1$
			reg.put(MOINBrowser.SHOW_LEGEND_IMAGE, ImageDescriptor.createFromURL(new URL(lInstallURL, "resources/icons/showlegend.gif"))); //$NON-NLS-1$
			reg.put(MOINBrowser.COLLAPSE_ALL_IMAGE, ImageDescriptor.createFromURL(new URL(lInstallURL, "resources/icons/collapseall.gif"))); //$NON-NLS-1$
			reg.put(MOINBrowser.LOADING_IMAGE, ImageDescriptor.createFromURL(new URL(lInstallURL, "resources/icons/loading.gif"))); //$NON-NLS-1$
			reg.put(MOINBrowser.OPEN_TYPE_IMAGE, ImageDescriptor.createFromURL(new URL(lInstallURL, "resources/icons/opentype.gif"))); //$NON-NLS-1$
			reg.put(MOINBrowser.TYPES_IMAGE, ImageDescriptor.createFromURL(new URL(lInstallURL, "resources/icons/types.gif"))); //$NON-NLS-1$
			reg.put(MOINBrowser.UNKNOWN_OBJECT_IMAGE, ImageDescriptor.createFromURL(new URL(lInstallURL, "resources/icons/unknown_obj.gif"))); //$NON-NLS-1$
		}
		catch (final MalformedURLException e) {
			// spec'ed to ignore problems
			MOINBrowser.tracer.log(Level.SEVERE, e.getMessage(), e);
		}
	}

	public Image getImage(String key) {

		return getImageRegistry().get(key);
	}

	public ImageDescriptor getImageDescriptor(String key) {

		return getImageRegistry().getDescriptor(key);
	}

}
