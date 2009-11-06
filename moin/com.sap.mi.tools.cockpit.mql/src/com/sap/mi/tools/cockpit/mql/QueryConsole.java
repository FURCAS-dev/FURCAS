package com.sap.mi.tools.cockpit.mql;

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
 * The MQLConsole class controls the plug-in life cycle.
 * 
 * @author d003456
 * 
 */
public class QueryConsole extends AbstractUIPlugin {

	// The shared instance
	private static QueryConsole plugin;

	public static final String HORIZONTAL_ORIENTATION_IMAGE = "HORIZONTAL_ORIENTATION_IMAGE"; //$NON-NLS-1$

	public static final String VERTICAL_ORIENTATION_IMAGE = "VERTICAL_ORIENTATION_IMAGE"; //$NON-NLS-1$

	public static final String FIND_IMAGE = "FIND_IMAGE"; //$NON-NLS-1$

	public static final String FORM_BG_IMAGE = "FORM_BG_IMAGE"; //$NON-NLS-1$

	public static final String TEMPLATE_QUERY_IMAGE = "TEMPLATE_QUERY_IMAGE"; //$NON-NLS-1$

	public static final String ATTRIBUTE_IMAGE = "ATTRIBUTE_IMAGE"; //$NON-NLS-1$

	public static final String ZERO_TO_UNBOUND_ATTRIBUTE_IMAGE = "ZERO_TO_UNBOUND_ATTRIBUTE_IMAGE"; //$NON-NLS-1$

	public static final String OBJECT_IMAGE = "OBJECT_IMAGE"; //$NON-NLS-1$

	public static final String EXPORT_IMAGE = "EXPORT_IMAGE"; //$NON-NLS-1$

	public static final String EXPORT_IMAGE_DISABLED = "EXPORT_IMAGE_DISABLED"; //$NON-NLS-1$

	public static final String REMOVE_IMAGE = "REMOVE_IMAGE"; //$NON-NLS-1$

	public static final String REMOVE_IMAGE_DISABLED = "REMOVE_IMAGE_DISABLED"; //$NON-NLS-1$

	public static final String REMOVE_ALL_IMAGE = "REMOVE_ALL_IMAGE"; //$NON-NLS-1$

	public static final String REMOVE_ALL_IMAGE_DISABLED = "REMOVE_ALL_IMAGE_DISABLED"; //$NON-NLS-1$

	public static final String NEXT_IMAGE = "NEXT_IMAGE"; //$NON-NLS-1$

	public static final String NEXT_IMAGE_DISABLED = "NEXT_IMAGE_DISABLED"; //$NON-NLS-1$

	public static final String PREVIOUS_IMAGE = "PREVIOUS_IMAGE"; //$NON-NLS-1$

	public static final String PREVIOUS_IMAGE_DISABLED = "PREVIOUS_IMAGE_DISABLED"; //$NON-NLS-1$

	public static final String FILTER_IMAGE = "FILTER_IMAGE"; //$NON-NLS-1$

	public static final String MOIN_BROWSER_IMAGE = "MOIN_BROWSER_IMAGE"; //$NON-NLS-1$

	private static final Logger tracer = Logger.getLogger(MiLocations.MI_MQLVIEW);

	/**
	 * The constructor.
	 */
	public QueryConsole() {

		QueryConsole.plugin = this;
	}

	/**
	 * Returns the plug-in ID.
	 * 
	 * @return return plug-in ID
	 */
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

		QueryConsole.plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static QueryConsole getDefault() {

		return QueryConsole.plugin;
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
			QueryConsole.tracer.log(Level.SEVERE, e.getMessage(), e);
			return;
		}

		try {
			reg.put(QueryConsole.HORIZONTAL_ORIENTATION_IMAGE, ImageDescriptor.createFromURL(new URL(lInstallURL,
					"resources/icons/th_horizontal.gif"))); //$NON-NLS-1$
			reg.put(QueryConsole.VERTICAL_ORIENTATION_IMAGE, ImageDescriptor.createFromURL(new URL(lInstallURL,
					"resources/icons/th_vertical.gif"))); //$NON-NLS-1$
			reg.put(QueryConsole.FIND_IMAGE, ImageDescriptor.createFromURL(new URL(lInstallURL, "resources/icons/find.gif"))); //$NON-NLS-1$
			reg.put(QueryConsole.FORM_BG_IMAGE, ImageDescriptor.createFromURL(new URL(lInstallURL, "resources/icons/form_banner.gif"))); //$NON-NLS-1$
			reg.put(QueryConsole.TEMPLATE_QUERY_IMAGE, ImageDescriptor.createFromURL(new URL(lInstallURL,
					"resources/icons/templatequery.gif"))); //$NON-NLS-1$
			reg.put(QueryConsole.OBJECT_IMAGE, ImageDescriptor.createFromURL(new URL(lInstallURL, "resources/icons/object.gif"))); //$NON-NLS-1$
			reg.put(QueryConsole.ATTRIBUTE_IMAGE, ImageDescriptor.createFromURL(new URL(lInstallURL, "resources/icons/attribute.gif"))); //$NON-NLS-1$
			reg.put(QueryConsole.ZERO_TO_UNBOUND_ATTRIBUTE_IMAGE, ImageDescriptor.createFromURL(new URL(lInstallURL,
					"resources/icons/zerotounboundattribute.gif"))); //$NON-NLS-1$
			reg.put(QueryConsole.EXPORT_IMAGE, ImageDescriptor.createFromURL(new URL(lInstallURL, "resources/icons/export.gif"))); //$NON-NLS-1$
			reg.put(QueryConsole.EXPORT_IMAGE_DISABLED, ImageDescriptor
					.createFromURL(new URL(lInstallURL, "resources/icons/export_dis.gif"))); //$NON-NLS-1$
			reg.put(QueryConsole.REMOVE_IMAGE, ImageDescriptor.createFromURL(new URL(lInstallURL, "resources/icons/search_rem.gif"))); //$NON-NLS-1$
			reg.put(QueryConsole.REMOVE_IMAGE_DISABLED, ImageDescriptor.createFromURL(new URL(lInstallURL,
					"resources/icons/search_rem_dis.gif"))); //$NON-NLS-1$
			reg
					.put(QueryConsole.REMOVE_ALL_IMAGE, ImageDescriptor.createFromURL(new URL(lInstallURL,
							"resources/icons/search_remall.gif"))); //$NON-NLS-1$
			reg.put(QueryConsole.REMOVE_ALL_IMAGE_DISABLED, ImageDescriptor.createFromURL(new URL(lInstallURL,
					"resources/icons/search_remall_dis.gif"))); //$NON-NLS-1$
			reg.put(QueryConsole.NEXT_IMAGE, ImageDescriptor.createFromURL(new URL(lInstallURL, "resources/icons/search_next.gif"))); //$NON-NLS-1$
			reg.put(QueryConsole.NEXT_IMAGE_DISABLED, ImageDescriptor.createFromURL(new URL(lInstallURL,
					"resources/icons/search_next_dis.gif"))); //$NON-NLS-1$
			reg.put(QueryConsole.PREVIOUS_IMAGE, ImageDescriptor.createFromURL(new URL(lInstallURL, "resources/icons/search_prev.gif"))); //$NON-NLS-1$
			reg.put(QueryConsole.PREVIOUS_IMAGE_DISABLED, ImageDescriptor.createFromURL(new URL(lInstallURL,
					"resources/icons/search_prev_dis.gif"))); //$NON-NLS-1$
			reg.put(QueryConsole.FILTER_IMAGE, ImageDescriptor.createFromURL(new URL(lInstallURL, "resources/icons/filter.gif"))); //$NON-NLS-1$
			reg.put(QueryConsole.MOIN_BROWSER_IMAGE, ImageDescriptor
					.createFromURL(new URL(lInstallURL, "resources/icons/moin_browser.gif"))); //$NON-NLS-1$

		}
		catch (final MalformedURLException e) {
			// spec'ed to ignore problems
			QueryConsole.tracer.log(Level.SEVERE, e.getMessage(), e);
		}
	}

	public Image getImage(String key) {

		return getImageRegistry().get(key);
	}

	public ImageDescriptor getImageDescriptor(String key) {

		return getImageRegistry().getDescriptor(key);
	}

}
